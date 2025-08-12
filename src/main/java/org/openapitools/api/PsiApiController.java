package org.openapitools.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.openapitools.model.RechercherMiesResponseDto;
import org.openapitools.model.TrouverUserResponseDto;
import org.openapitools.model.UpdateEimsRequestDto;
import org.openapitools.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-04T14:42:58.339608400+02:00[Europe/Paris]")
@Controller
@RequestMapping("${openapi.pscApiMajV2.base-path:/api}")
public class PsiApiController implements PsiApi {

	@Override
	public ResponseEntity<Void> creerUser(@Valid UserDto userDto) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<RechercherMiesResponseDto> rechercherEims(@NotNull @Valid String nationalId) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<TrouverUserResponseDto> rechercherParIdNational(@NotNull @Valid String nationalId)
			throws URISyntaxException, IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();

		String uri = "http://localhost:8080/psc-api-maj/api/v2/ps?psId=" + nationalId;

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).header(nationalId, nationalId).GET().build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if (response != null) {
			if (response.statusCode() == 200) {
				String jsonResponse = response.body();

				ObjectMapper mapper = new ObjectMapper();
				TrouverUserResponseDto userResponse = mapper.readValue(jsonResponse, TrouverUserResponseDto.class);

				return new ResponseEntity<>(userResponse, HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.valueOf(response.statusCode()));
			}
		}

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<TrouverUserResponseDto> rechercherParTraitsIdentite1(@NotNull @Valid String lastName,
			@NotNull @Valid String firstNames, @NotNull @Valid String genderCode, @NotNull @Valid LocalDate birthdate,
			@NotNull @Valid String birthTownCode, @NotNull @Valid String birthCountryCode) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Void> updateEims(@NotNull @Valid String nationalId,
			@Valid UpdateEimsRequestDto updateEimsRequestDto) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}