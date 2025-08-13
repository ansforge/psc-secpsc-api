package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ErrorDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class ErrorDto {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private String code;

  private String message;

  @Valid
  private Map<String, Object> metadata = new HashMap<>();

  public ErrorDto timestamp(OffsetDateTime timestamp) {
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

  public ErrorDto code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Brève description de l'erreur
   * @return code
  */
  
  @Schema(name = "code", example = "404", required = false, description = "Brève description de l'erreur")
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorDto message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Brève description de l'erreur
   * @return message
  */
  
  @Schema(name = "message", example = "Ressource non trouvée", required = false, description = "Brève description de l'erreur")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorDto metadata(Map<String, Object> metadata) {
    this.metadata = metadata;
    return this;
  }

  public ErrorDto putMetadataItem(String key, Object metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

  /**
   * Données additionnelles sur l'erreur (clé/valeur)
   * @return metadata
  */
  
  @Schema(name = "metadata", example = "{additionalProp1={}, additionalProp2={}, additionalProp3={}}", required = false, description = "Données additionnelles sur l'erreur (clé/valeur)")
  @JsonProperty("metadata")
  public Map<String, Object> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, Object> metadata) {
    this.metadata = metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDto errorDto = (ErrorDto) o;
    return Objects.equals(this.timestamp, errorDto.timestamp) &&
        Objects.equals(this.code, errorDto.code) &&
        Objects.equals(this.message, errorDto.message) &&
        Objects.equals(this.metadata, errorDto.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, code, message, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDto {\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

