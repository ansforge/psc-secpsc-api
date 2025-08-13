package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
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
 * GenericInternalServerErrorDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class GenericInternalServerErrorDto {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime timestamp;

  private @Nullable Integer status;

  private @Nullable String error;

  private @Nullable String path;

  public GenericInternalServerErrorDto timestamp(@Nullable OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Instant auquel s'est produit l'erreur
   * @return timestamp
   */
  @Valid 
  @Schema(name = "timestamp", example = "2024-02-27T14:45:00.593+00:00", description = "Instant auquel s'est produit l'erreur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
  public @Nullable OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@Nullable OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public GenericInternalServerErrorDto status(@Nullable Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Code statut HTTP
   * @return status
   */
  
  @Schema(name = "status", example = "500", description = "Code statut HTTP", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public @Nullable Integer getStatus() {
    return status;
  }

  public void setStatus(@Nullable Integer status) {
    this.status = status;
  }

  public GenericInternalServerErrorDto error(@Nullable String error) {
    this.error = error;
    return this;
  }

  /**
   * Brève description de l'erreur
   * @return error
   */
  
  @Schema(name = "error", example = "Erreur interne serveur", description = "Brève description de l'erreur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("error")
  public @Nullable String getError() {
    return error;
  }

  public void setError(@Nullable String error) {
    this.error = error;
  }

  public GenericInternalServerErrorDto path(@Nullable String path) {
    this.path = path;
    return this;
  }

  /**
   * URL de base de la ressource à l'origine de l'erreur
   * @return path
   */
  
  @Schema(name = "path", example = "/rpps-identifications", description = "URL de base de la ressource à l'origine de l'erreur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    GenericInternalServerErrorDto genericInternalServerErrorDto = (GenericInternalServerErrorDto) o;
    return Objects.equals(this.timestamp, genericInternalServerErrorDto.timestamp) &&
        Objects.equals(this.status, genericInternalServerErrorDto.status) &&
        Objects.equals(this.error, genericInternalServerErrorDto.error) &&
        Objects.equals(this.path, genericInternalServerErrorDto.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, status, error, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenericInternalServerErrorDto {\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

