package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class GenericInternalServerErrorDto {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private Integer status;

  private String error;

  private String path;

  public GenericInternalServerErrorDto timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Instant auquel s'est produit l'erreur
   * @return timestamp
  */
  @Valid 
  @Schema(name = "timestamp", example = "2024-02-27T14:45:00.593+00:00", required = false, description = "Instant auquel s'est produit l'erreur")
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public GenericInternalServerErrorDto status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Code statut HTTP
   * @return status
  */
  
  @Schema(name = "status", example = "500", required = false, description = "Code statut HTTP")
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public GenericInternalServerErrorDto error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Brève description de l'erreur
   * @return error
  */
  
  @Schema(name = "error", example = "Erreur interne serveur", required = false, description = "Brève description de l'erreur")
  @JsonProperty("error")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public GenericInternalServerErrorDto path(String path) {
    this.path = path;
    return this;
  }

  /**
   * URL de base de la ressource à l'origine de l'erreur
   * @return path
  */
  
  @Schema(name = "path", example = "/rpps-identifications", required = false, description = "URL de base de la ressource à l'origine de l'erreur")
  @JsonProperty("path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
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

