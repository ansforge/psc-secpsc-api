package org.openapitools.api;

import java.net.URISyntaxException;

import org.openapitools.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PsiExceptionHandler {
	
//	@ExceptionHandler(URISyntaxException.class)
//	public ResponseEntity<ApiError> handleUriSyntax (URISyntaxException ex) {
//		ApiError error = new ApiError("URI invalide : " + ex.getMessage());
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//	}
}