package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * AlternativeIdentifierDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class AlternativeIdentifierDto {

  private String identifier;

  private String origine;

  private Integer quality;

  public AlternativeIdentifierDto identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * Get identifier
   * @return identifier
  */
  
  @Schema(name = "identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("identifier")
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public AlternativeIdentifierDto origine(String origine) {
    this.origine = origine;
    return this;
  }

  /**
   * Get origine
   * @return origine
  */
  
  @Schema(name = "origine", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("origine")
  public String getOrigine() {
    return origine;
  }

  public void setOrigine(String origine) {
    this.origine = origine;
  }

  public AlternativeIdentifierDto quality(Integer quality) {
    this.quality = quality;
    return this;
  }

  /**
   * Get quality
   * @return quality
  */
  
  @Schema(name = "quality", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quality")
  public Integer getQuality() {
    return quality;
  }

  public void setQuality(Integer quality) {
    this.quality = quality;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlternativeIdentifierDto alternativeIdentifierDto = (AlternativeIdentifierDto) o;
    return Objects.equals(this.identifier, alternativeIdentifierDto.identifier) &&
        Objects.equals(this.origine, alternativeIdentifierDto.origine) &&
        Objects.equals(this.quality, alternativeIdentifierDto.quality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, origine, quality);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlternativeIdentifierDto {\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    origine: ").append(toIndentedString(origine)).append("\n");
    sb.append("    quality: ").append(toIndentedString(quality)).append("\n");
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

