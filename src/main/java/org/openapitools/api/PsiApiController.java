package org.openapitools.api;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.openapitools.model.RechercherMiesResponseDto;
import org.openapitools.model.TrouverUserResponseDto;
import org.openapitools.model.UpdateEimsRequestDto;
import org.openapitools.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-04T14:42:58.339608400+02:00[Europe/Paris]")
@Controller
@RequestMapping("${openapi.pscApiMajV2.base-path:/api}")
public class PsiApiController implements PsiApi {

	@Override
	public ResponseEntity<Void> creerUser(@Valid UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<RechercherMiesResponseDto> rechercherEims(@NotNull @Valid String nationalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<TrouverUserResponseDto> rechercherParIdNational(@NotNull @Valid String nationalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<TrouverUserResponseDto> rechercherParTraitsIdentite1(@NotNull @Valid String lastName,
			@NotNull @Valid String firstNames, @NotNull @Valid String genderCode, @NotNull @Valid LocalDate birthdate,
			@NotNull @Valid String birthTownCode, @NotNull @Valid String birthCountryCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> updateEims(@NotNull @Valid String nationalId,
			@Valid UpdateEimsRequestDto updateEimsRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
