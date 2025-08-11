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
 * TrouverEtatCivilNotFoundErrorDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class TrouverEtatCivilNotFoundErrorDto {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private Integer status;

  private String error;

  private String path;

  public TrouverEtatCivilNotFoundErrorDto timestamp(OffsetDateTime timestamp) {
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
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public TrouverEtatCivilNotFoundErrorDto status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Brève description de l'erreur
   * @return status
  */
  
  @Schema(name = "status", example = "404", description = "Brève description de l'erreur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public TrouverEtatCivilNotFoundErrorDto error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Brève description de l'erreur
   * @return error
  */
  
  @Schema(name = "error", example = "Ressource non trouvée", description = "Brève description de l'erreur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("error")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public TrouverEtatCivilNotFoundErrorDto path(String path) {
    this.path = path;
    return this;
  }

  /**
   * URL de base de la ressource à l'origine de l'erreur
   * @return path
  */
  
  @Schema(name = "path", example = "ps/trouverEtatCivil", description = "URL de base de la ressource à l'origine de l'erreur", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    TrouverEtatCivilNotFoundErrorDto trouverEtatCivilNotFoundErrorDto = (TrouverEtatCivilNotFoundErrorDto) o;
    return Objects.equals(this.timestamp, trouverEtatCivilNotFoundErrorDto.timestamp) &&
        Objects.equals(this.status, trouverEtatCivilNotFoundErrorDto.status) &&
        Objects.equals(this.error, trouverEtatCivilNotFoundErrorDto.error) &&
        Objects.equals(this.path, trouverEtatCivilNotFoundErrorDto.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, status, error, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrouverEtatCivilNotFoundErrorDto {\n");
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

