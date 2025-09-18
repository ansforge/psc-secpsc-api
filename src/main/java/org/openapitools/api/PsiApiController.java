package org.openapitools.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openapitools.model.CivilStatusDto;
import org.openapitools.model.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import fr.ans.psc.amar.v2.model.CivilStatus;
import fr.ans.psc.amar.v2.model.User;
import fr.ans.psc.model.Ps;
import fr.ans.psc.model.ps.PsiPsAdapter;
import fr.ans.psc.model.user.PsiUserAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("${openapi.pscPsi.base-path:/api}")
public class PsiApiController implements PsiApi {

	@Value("${openapi.pscAmar.base-path:/api}")
	private String amarPath;

	@Value("${openapi.pscApiMajV2.base-path:/api}")
	private String psPath;

	/**
	 * Convertit une chaîne de prénoms avec espaces vers une liste de prénoms
	 * 
	 * @param firstNamesString Prénoms séparés par des espaces (ex: "Jean Pierre")
	 * @return Liste de prénoms (ex: ["Jean", "Pierre"])
	 */
	private List<String> convertFirstNamesStringToList(String firstNamesString) {
		if (firstNamesString == null || firstNamesString.trim().isEmpty()) {
			return new ArrayList<>();
		}
		List<String> result = new ArrayList<>();
		String[] names = firstNamesString.split(" ");
		for (String name : names) {
			name = name.trim();
			if (!name.isEmpty()) {
				result.add(name);
			}
		}
		return result;
	}

	/**
	 * Convertit une liste de prénoms vers une chaîne avec espaces
	 * 
	 * @param firstNamesList Liste de prénoms (ex: ["Jean", "Pierre"])
	 * @return Prénoms séparés par des espaces (ex: "Jean Pierre")
	 */
	private String convertFirstNamesListToString(List<String> firstNamesList) {
		if (firstNamesList == null || firstNamesList.isEmpty()) {
			return "";
		}
		return String.join(" ", firstNamesList);
	}

	/**
	 * Convertit un UserDto (nouveau format PSI) vers un User (format AMAR)
	 * 
	 * @param userDto Le UserDto reçu depuis l'API PSI
	 * @return Un User compatible avec le format AMAR
	 */
	private User convertUserDtoToUser(UserDto userDto) {
		User user = new User();

		// Mapping de base
		user.setNationalId(userDto.getNationalId());

		// Mapping CivilStatus
		if (userDto.getCivilStatus() != null) {
			CivilStatus civilStatus = new CivilStatus();
			CivilStatusDto dto = userDto.getCivilStatus();

			civilStatus.setLastName(dto.getLastName());
			civilStatus.setGenderCode(dto.getGenderCode());
			civilStatus.setBirthplace(dto.getBirthplace());
			civilStatus.setBirthTownCode(dto.getBirthTownCode());
			civilStatus.setBirthCountryCode(dto.getBirthCountryCode());
			civilStatus.setPersonalCivilityTitle(dto.getPersonalCivilityTitle());

			// Conversion de la date : ISO (yyyy-MM-dd) vers format français (dd/MM/yyyy)
			if (dto.getBirthdate() != null) {
				DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String frenchDateFormat = dto.getBirthdate().format(outputFormatter);
				civilStatus.setBirthdate(frenchDateFormat);
			}

			// Conversion des prénoms : String -> List<String>
			if (dto.getFirstNames() != null && !dto.getFirstNames().trim().isEmpty()) {
				civilStatus.setFirstNames(convertFirstNamesStringToList(dto.getFirstNames()));
			}

			user.setCivilStatus(civilStatus);
		}

		// Mapping ContactInfo vers CivilStatus
		if (userDto.getContactInfo() != null && user.getCivilStatus() != null) {
			user.getCivilStatus().setEmail(userDto.getContactInfo().getEmail());
			user.getCivilStatus().setPhone(userDto.getContactInfo().getPhone());
		}

		// Mapping AlternativeIdentifiers
		if (userDto.getAlternativeIdentifiers() != null) {
			List<fr.ans.psc.amar.v2.model.AlternativeIdentifier> alternativeIds = new ArrayList<>();
			userDto.getAlternativeIdentifiers().forEach(dto -> {
				fr.ans.psc.amar.v2.model.AlternativeIdentifier altId = new fr.ans.psc.amar.v2.model.AlternativeIdentifier();
				altId.setIdentifier(dto.getIdentifier());
				altId.setOrigine(dto.getOrigine());
				altId.setQuality(dto.getQuality() != null ? dto.getQuality() : 1); // Utilise quality du DTO ou 1 par
																					// défaut
				alternativeIds.add(altId);
			});
			user.setAlternativeIdentifiers(alternativeIds);
		}

		// Mapping Practices
		if (userDto.getPractices() != null) {
			List<fr.ans.psc.amar.v2.model.Practice> practices = new ArrayList<>();
			userDto.getPractices().forEach(practiceDto -> {
				fr.ans.psc.amar.v2.model.Practice practice = new fr.ans.psc.amar.v2.model.Practice();
				
				practice.setProfessionCode(practiceDto.getProfessionCode());
				practice.setProfessionalCategoryCode(practiceDto.getProfessionalCategoryCode());
				practice.setExpertiseTypeCode(practiceDto.getExpertiseTypeCode());
				practice.setExpertiseCode(practiceDto.getExpertiseCode());
				practice.setProfessionalCivilityTitle(practiceDto.getProfessionalCivilityTitle());
				practice.setProfessionalLastName(practiceDto.getProfessionalLastName());
				practice.setProfessionalFirstName(practiceDto.getProfessionalFirstName());
				
				// Mapping Activities si elles existent
				if (practiceDto.getActivities() != null) {
					List<fr.ans.psc.amar.v2.model.Activity> activities = new ArrayList<>();
					practiceDto.getActivities().forEach(activityDto -> {
						fr.ans.psc.amar.v2.model.Activity activity = new fr.ans.psc.amar.v2.model.Activity();
						
						activity.setProfessionalModeCode(activityDto.getProfessionalModeCode());
						activity.setActivitySectorCode(activityDto.getActivitySectorCode());
						activity.setRoleCode(activityDto.getRoleCode());
						activity.setActivityTypeCode(activityDto.getActivityTypeCode());
						activity.setSiretSiteNumber(activityDto.getSiretSiteNumber());
						activity.setSirenSiteNumber(activityDto.getSirenSiteNumber());
						activity.setFinessSiteNumber(activityDto.getFinessSiteNumber());
						activity.setCompanyName(activityDto.getCompanyName());
						activity.setCompanyWayNumber(activityDto.getCompanyWayNumber());
						activity.setCompanyWayType(activityDto.getCompanyWayType());
						activity.setCompanyWayLabel(activityDto.getCompanyWayLabel());
						activity.setCompanyPostalCode(activityDto.getCompanyPostalCode());
						activity.setCompanyTownCode(activityDto.getCompanyTownCode());
						activity.setCompanyCountryCode(activityDto.getCompanyCountryCode());
						activity.setCompanyPhone1(activityDto.getCompanyPhone1());
						activity.setCompanyEmail(activityDto.getCompanyEmail());
						
						activities.add(activity);
					});
					practice.setActivities(activities);
				}
				
				practices.add(practice);
			});
			user.setPractices(practices);
		}

		// TODO: Ajouter mapping pour eims si nécessaire

		return user;
	}

	@Override
	public ResponseEntity<User> rechercherParIdNational(String nationalId)
			throws URISyntaxException, IOException, InterruptedException {

		log.info("Start - rechercherParIdNational");

		if (nationalId != null) {
			HttpClient client = HttpClient.newHttpClient();
			String uriPscPs = psPath + "/v2/ps/" + nationalId;
			HttpRequest requestPscPs = HttpRequest.newBuilder().uri(new URI(uriPscPs))
					.headers("Content-Type", "application/json").GET().build();

			log.info(String.format("Send request to [%s] with in headers: nationalId=%s", uriPscPs, nationalId));

			HttpResponse<String> responsePscPs = client.send(requestPscPs, HttpResponse.BodyHandlers.ofString());

			if (responsePscPs != null) {

				log.info(String.format("Response of [%s] : %s", uriPscPs, responsePscPs));

				Ps psResponse = new Ps();
				if (responsePscPs.statusCode() == 200) {
					String jsonResponse = responsePscPs.body();
					ObjectMapper mapper = new ObjectMapper();
					mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
					psResponse = mapper.readValue(jsonResponse, Ps.class);
					// return new ResponseEntity<>(userResponse, HttpStatus.OK);
				} else {
					HttpHeaders headers = new HttpHeaders();
					if (responsePscPs.statusCode() == 400) {
						headers.add("X-Error-Message", "Bad Request");
					} else if (responsePscPs.statusCode() == 410) {
						headers.add("X-Error-Message", "Not Found");
					} else if (responsePscPs.statusCode() == 500) {
						headers.add("X-Error-Message", "Erreur interne serveur");
					}

					return new ResponseEntity<>(headers, HttpStatus.valueOf(responsePscPs.statusCode()));
				}

				User user = new PsiUserAdapter(psResponse);

				// TODO : A ENLEVER QUAND ON AURA LE AMAR
				return new ResponseEntity<>(user, HttpStatus.OK);

				// Récupérer le MIE de Amar

//				String uriPscAmar = UriComponentsBuilder.fromHttpUrl(amarPath + "/users/eims").queryParam("nationalId", nationalId)
//						.build().encode().toUriString();
//
//				HttpRequest requestPscAmar = HttpRequest.newBuilder().uri(new URI(uriPscAmar))
//						.headers("Content-Type", "application/json", "nationalId", nationalId).GET().build();
//				
//				log.info(String.format("Send request to [%s] with in headers: nationalId=%s", uriPscAmar, nationalId));
//
//				HttpResponse<String> responsePscAmar = client.send(requestPscAmar, HttpResponse.BodyHandlers.ofString());
//
//				if (responsePscAmar.statusCode() == 200) {
//					String jsonResponse = responsePscAmar.body();
//					ObjectMapper mapper = new ObjectMapper();
//					HashMap<?,?> mieResponse = mapper.readValue(jsonResponse, HashMap.class);
//					//List<MIE> eims = mieResponse.get("data"); // MAPPING
//					user.etEims(eims);
//					
//					return new ResponseEntity<>(user, HttpStatus.OK);
//				} else {
//					HttpHeaders headers = new HttpHeaders();
//					if (responsePscAmar.statusCode() == 400) {
//						headers.add("X-Error-Message", "Données invalides ou absentes");
//					} else if (responsePscAmar.statusCode() == 404) {
//						headers.add("X-Error-Message", "Utilisateur non trouvé");
//					} else if (responsePscAmar.statusCode() == 500) {
//						headers.add("X-Error-Message", "Erreur interne serveur");
//					}
//					return new ResponseEntity<>(headers, HttpStatus.valueOf(responsePscAmar.statusCode()));
//				}
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<List<String>> rechercherNationalIdParTraitsIdentite(String lastName, String firstNames,
			String genderCode, LocalDate birthdate, String birthTownCode, String birthCountryCode, String birthplace)
			throws URISyntaxException, IOException, InterruptedException {

		log.info("Start - rechercherNationalIdParTraitsIdentite");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		HttpClient client = HttpClient.newHttpClient();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(psPath + "/v2/ps/search")
				.queryParam("lastName", lastName).queryParam("firstNames", firstNames)
				.queryParam("genderCode", genderCode).queryParam("birthdate", birthdate.toString());

		if (birthTownCode != null && !birthTownCode.isEmpty()) {
			builder.queryParam("birthTownCode", birthTownCode);
		}

		if (birthCountryCode != null && !birthCountryCode.isEmpty()) {
			builder.queryParam("birthCountryCode", birthCountryCode);
		}

		if (birthplace != null && !birthplace.isEmpty()) {
			builder.queryParam("birthplace", birthplace);
		}

		String uri = builder.build().encode().toUriString();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).headers("Content-Type", "application/json")
				.GET().build();

		log.info(String.format(
				"Send request to [%s] with parameters: lastName=%s, firstNames=%s, genderCode=%s, birthTownCode=%s, birthCountryCode=%s, birthplace=%s",
				uri, lastName, firstNames, genderCode, birthTownCode, birthCountryCode, birthplace));

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if (response != null) {

			log.info(String.format("Response of [%s] : %s", uri, response));

			if (response.statusCode() == 200) {
				String jsonResponse = response.body();
				ObjectMapper mapper = new ObjectMapper();
				List<String> list = mapper.readValue(jsonResponse, new TypeReference<List<String>>() {
				});

				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				HttpHeaders headers = new HttpHeaders();
				if (response.statusCode() == 400) {
					headers.add("X-Error-Message", "Données invalides ou absentes");
				} else if (response.statusCode() == 401) {
					headers.add("X-Error-Message", "Utilisateur non autorisé");
				} else if (response.statusCode() == 404) {
					headers.add("X-Error-Message", "Utilisateur non trouvé");
				} else if (response.statusCode() == 409) {
					headers.add("X-Error-Message", "Conflits");
				} else if (response.statusCode() == 500) {
					headers.add("X-Error-Message", "Erreur interne serveur");
				}
				return new ResponseEntity<>(headers, HttpStatus.valueOf(response.statusCode()));
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Void> creerUser(UserDto userDto)
			throws IOException, InterruptedException, URISyntaxException {

		log.info("Start - creerUser");

		ObjectMapper mapper = new ObjectMapper();

		// Conversion UserDto -> User (format AMAR)
		User user = convertUserDtoToUser(userDto);

		// Mapping
		Ps ps = new PsiPsAdapter(user);
		String psJson = mapper.writeValueAsString(ps);

		HttpClient client = HttpClient.newHttpClient();
		String uri = psPath + "/v2/ps";
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(psJson)).build();

		log.info(String.format("Send request to [%s] with in body: %s", uri, psJson));

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if (response != null) {

			log.info(String.format("Response of [%s] : %s", uri, response));

			if (response.statusCode() == 200) {
				String jsonResponse = response.body();
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				HttpHeaders headers = new HttpHeaders();
				if (response.statusCode() == 400) {
					headers.add("X-Error-Message", "Données invalides ou absentes");
				} else if (response.statusCode() == 401) {
					headers.add("X-Error-Message", "Utilisateur non autorisé");
				} else if (response.statusCode() == 404) {
					headers.add("X-Error-Message", "Utilisateur non trouvé");
				} else if (response.statusCode() == 409) {
					headers.add("X-Error-Message", "Conflits");
				} else if (response.statusCode() == 500) {
					headers.add("X-Error-Message", "Erreur interne serveur");
				}
				return new ResponseEntity<>(headers, HttpStatus.valueOf(response.statusCode()));
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Void> updateUser(String nationalId, UserDto userDto)
			throws IOException, InterruptedException, URISyntaxException {

		log.info("Start - updateUser");

		ObjectMapper mapper = new ObjectMapper();

		// Conversion UserDto -> User (format AMAR)
		User user = convertUserDtoToUser(userDto);

		// Mapping
		Ps ps = new PsiPsAdapter(user);
		String psJson = mapper.writeValueAsString(ps);

		HttpClient client = HttpClient.newHttpClient();

		String uri = UriComponentsBuilder.fromHttpUrl(psPath + "/v2/ps").queryParam("extraId", nationalId).build()
				.encode().toUriString();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).headers("Content-Type", "application/json")
				.PUT(HttpRequest.BodyPublishers.ofString(psJson)).build();

		log.info(String.format("Send request to [%s] with in parameters : extraId=%s and in body: %s", uri, nationalId,
				psJson));

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if (response != null) {

			log.info(String.format("Response of [%s] : %s", uri, response));

			if (response.statusCode() == 200) {
				String jsonResponse = response.body();
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				HttpHeaders headers = new HttpHeaders();
				if (response.statusCode() == 400) {
					headers.add("X-Error-Message", "Données invalides ou absentes");
				} else if (response.statusCode() == 401) {
					headers.add("X-Error-Message", "Utilisateur non autorisé");
				} else if (response.statusCode() == 404) {
					headers.add("X-Error-Message", "Utilisateur non trouvé");
				} else if (response.statusCode() == 409) {
					headers.add("X-Error-Message", "L'utilisateur avec cet identifiant national existe déjà");
				} else if (response.statusCode() == 500) {
					headers.add("X-Error-Message", "Erreur interne serveur");
				}
				return new ResponseEntity<>(headers, HttpStatus.valueOf(response.statusCode()));
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}