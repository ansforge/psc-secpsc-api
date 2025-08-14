package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CoordonneeDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class CoordonneeDto {

  private @Nullable String numeroTelephonePort;

  private @Nullable String courriel;

  public CoordonneeDto numeroTelephonePort(@Nullable String numeroTelephonePort) {
    this.numeroTelephonePort = numeroTelephonePort;
    return this;
  }

  /**
   * Get numeroTelephonePort
   * @return numeroTelephonePort
   */
  
  @Schema(name = "numeroTelephonePort", required = false, description = "")
  @JsonProperty("numeroTelephonePort")
  public @Nullable String getNumeroTelephonePort() {
    return numeroTelephonePort;
  }

  public void setNumeroTelephonePort(@Nullable String numeroTelephonePort) {
    this.numeroTelephonePort = numeroTelephonePort;
  }

  public CoordonneeDto courriel(@Nullable String courriel) {
    this.courriel = courriel;
    return this;
  }

  /**
   * Get courriel
   * @return courriel
   */
  
  @Schema(name = "courriel", required = false, description = "")
  @JsonProperty("courriel")
  public @Nullable String getCourriel() {
    return courriel;
  }

  public void setCourriel(@Nullable String courriel) {
    this.courriel = courriel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoordonneeDto coordonneeDto = (CoordonneeDto) o;
    return Objects.equals(this.numeroTelephonePort, coordonneeDto.numeroTelephonePort) &&
        Objects.equals(this.courriel, coordonneeDto.courriel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroTelephonePort, courriel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoordonneeDto {\n");
    sb.append("    numeroTelephonePort: ").append(toIndentedString(numeroTelephonePort)).append("\n");
    sb.append("    courriel: ").append(toIndentedString(courriel)).append("\n");
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

