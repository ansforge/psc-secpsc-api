package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ApiError
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class ApiError {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime timestamp;

  @Valid
  private List<String> faultyFields = new ArrayList<>();

  @Valid
  private List<Object> faultyValues = new ArrayList<>();

  private @Nullable String errorMessage;

  private @Nullable String path;

  public ApiError timestamp(@Nullable OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Instant auquel s'est produit l'erreur
   * @return timestamp
   */
  @Valid 
  @Schema(name = "timestamp", example = "2024-02-27T14:45:00.593+00:00", description = "Instant auquel s'est produit l'erreur")
  @JsonProperty("timestamp")
  public @Nullable OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@Nullable OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public ApiError faultyFields(List<String> faultyFields) {
    this.faultyFields = faultyFields;
    return this;
  }

  public ApiError addFaultyFieldsItem(String faultyFieldsItem) {
    if (this.faultyFields == null) {
      this.faultyFields = new ArrayList<>();
    }
    this.faultyFields.add(faultyFieldsItem);
    return this;
  }

  /**
   * Liste des champs invalides
   * @return faultyFields
   */
  
  @Schema(name = "faultyFields", example = "[nationalId, email]", required = false, description = "Liste des champs invalides")
  @JsonProperty("faultyFields")
  public List<String> getFaultyFields() {
    return faultyFields;
  }

  public void setFaultyFields(List<String> faultyFields) {
    this.faultyFields = faultyFields;
  }

  public ApiError faultyValues(List<Object> faultyValues) {
    this.faultyValues = faultyValues;
    return this;
  }

  public ApiError addFaultyValuesItem(Object faultyValuesItem) {
    if (this.faultyValues == null) {
      this.faultyValues = new ArrayList<>();
    }
    this.faultyValues.add(faultyValuesItem);
    return this;
  }

  /**
   * Liste des valeurs invalides pour les champs mentionnés
   * @return faultyValues
   */
  
  @Schema(name = "faultyValues", example = "[123456789, 987654321]", required = false, description = "Liste des valeurs invalides pour les champs mentionnés")
  @JsonProperty("faultyValues")
  public List<Object> getFaultyValues() {
    return faultyValues;
  }

  public void setFaultyValues(List<Object> faultyValues) {
    this.faultyValues = faultyValues;
  }

  public ApiError errorMessage(@Nullable String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Brève description de l'erreur
   * @return errorMessage
   */
  
  @Schema(name = "errorMessage", example = "Ressource non trouvée", required = false, description = "Brève description de l'erreur")
  @JsonProperty("errorMessage")
  public @Nullable String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(@Nullable String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ApiError path(@Nullable String path) {
    this.path = path;
    return this;
  }

  /**
   * path
   * @return path
   */
  
  @Schema(name = "path", example = "/user/123456789", required = false, description = "path")
  @JsonProperty("path")
  public @Nullable String getPath() {
    return path;
  }

  public void setPath(@Nullable String path) {
    this.path = path;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiError apiError = (ApiError) o;
    return Objects.equals(this.timestamp, apiError.timestamp) &&
        Objects.equals(this.faultyFields, apiError.faultyFields) &&
        Objects.equals(this.faultyValues, apiError.faultyValues) &&
        Objects.equals(this.errorMessage, apiError.errorMessage) &&
        Objects.equals(this.path, apiError.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, faultyFields, faultyValues, errorMessage, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiError {\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    faultyFields: ").append(toIndentedString(faultyFields)).append("\n");
    sb.append("    faultyValues: ").append(toIndentedString(faultyValues)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

