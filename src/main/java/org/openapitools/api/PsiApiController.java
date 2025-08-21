package org.openapitools.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.ans.psc.amar.model.User;
import fr.ans.psc.model.Ps;
import fr.ans.psc.model.ps.PsiPsAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("${openapi.pscPsi.base-path:/api}")
public class PsiApiController implements PsiApi {

	@Value("${openapi.pscAmar.base-path:/api}")
	private String amarPath;

	@Value("${openapi.pscApiMajV2.base-path:/api}")
	private String psPath;

	@Override
	public ResponseEntity<User> rechercherParIdNational(String nationalId)
			throws URISyntaxException, IOException, InterruptedException {
		
		log.info("Debut - rechercherParIdNational");

		HttpClient client = HttpClient.newHttpClient();
		String uri = amarPath + "/users";
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri))
				.headers("Content-Type", "application/json", "nationalId", nationalId).GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		HttpHeaders headers = new HttpHeaders();

		if (response != null) {
			
			log.info("response" + response);
			
			if (response.statusCode() == 200) {
				String jsonResponse = response.body();
				ObjectMapper mapper = new ObjectMapper();
				User userResponse = mapper.readValue(jsonResponse, User.class);
				return new ResponseEntity<>(userResponse, HttpStatus.OK);
			} else {
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
		// return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<List<String>> rechercherNationalIdParTraitsIdentite(String lastName, String firstNames,
			String genderCode, LocalDate birthdate, String birthTownCode, String birthCountryCode, String birthPlace)
			throws URISyntaxException, IOException, InterruptedException {
		
		log.info("Debut - rechercherNationalIdParTraitsIdentite");

		HttpClient client = HttpClient.newHttpClient();
		String uri = psPath + "/user/identitytraits";
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri))
				.headers("Content-Type", "application/json", "lastName", lastName, "firstNames", firstNames,
						"genderCode", genderCode, "birthdate", birthdate.toString(), "birthTownCode", birthTownCode,
						"birthCountryCode", birthCountryCode, "birthPlace", birthPlace)
				.GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		HttpHeaders headers = new HttpHeaders();

		if (response != null) {
			
			log.info("response" + response);
			
			if (response.statusCode() == 200) {
				String jsonResponse = response.body();
				ObjectMapper mapper = new ObjectMapper();
				List<String> list = mapper.readValue(jsonResponse, new TypeReference<List<String>>() {
				});

				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
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
	public ResponseEntity<Void> creerUser(User user) throws IOException, InterruptedException, URISyntaxException {
		
		log.info("Debut - creerUser");

		ObjectMapper mapper = new ObjectMapper();

		// Mapping
		Ps ps = new PsiPsAdapter(user);
		String psJson = mapper.writeValueAsString(ps);

		HttpClient client = HttpClient.newHttpClient();
		String uri = psPath + "/v2/ps";
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(psJson)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		HttpHeaders headers = new HttpHeaders();

		if (response != null) {
			
			log.info("response" + response);
			
			if (response.statusCode() == 200) {
				String jsonResponse = response.body();
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
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
	public ResponseEntity<Void> updateUser(String nationalId, User user)
			throws IOException, InterruptedException, URISyntaxException {
		
		log.info("Debut - updateUser");

		ObjectMapper mapper = new ObjectMapper();

		// Mapping
		Ps ps = new PsiPsAdapter(user);
		String psJson = mapper.writeValueAsString(ps);

		HttpClient client = HttpClient.newHttpClient();
		String uri = psPath + "/v2/ps";
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(psJson)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		HttpHeaders headers = new HttpHeaders();

		if (response != null) {
			
			log.info("response" + response);
			
			if (response.statusCode() == 200) {
				String jsonResponse = response.body();
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
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