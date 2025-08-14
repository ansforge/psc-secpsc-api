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
 * AlternativeIdentifierDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class AlternativeIdentifierDto {

  private @Nullable String identifier;

  private @Nullable String origine;

  private @Nullable Integer quality;

  private @Nullable Boolean showInToken;

  public AlternativeIdentifierDto identifier(@Nullable String identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * Get identifier
   * @return identifier
   */
  
  @Schema(name = "identifier", required = false, description = "")
  @JsonProperty("identifier")
  public @Nullable String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(@Nullable String identifier) {
    this.identifier = identifier;
  }

  public AlternativeIdentifierDto origine(@Nullable String origine) {
    this.origine = origine;
    return this;
  }

  /**
   * Get origine
   * @return origine
   */
  
  @Schema(name = "origine", required = false, description = "")
  @JsonProperty("origine")
  public @Nullable String getOrigine() {
    return origine;
  }

  public void setOrigine(@Nullable String origine) {
    this.origine = origine;
  }

  public AlternativeIdentifierDto quality(@Nullable Integer quality) {
    this.quality = quality;
    return this;
  }

  /**
   * Get quality
   * @return quality
   */
  
  @Schema(name = "quality", required = false, description = "")
  @JsonProperty("quality")
  public @Nullable Integer getQuality() {
    return quality;
  }

  public void setQuality(@Nullable Integer quality) {
    this.quality = quality;
  }

  public AlternativeIdentifierDto showInToken(@Nullable Boolean showInToken) {
    this.showInToken = showInToken;
    return this;
  }

  /**
   * Get showInToken
   * @return showInToken
   */
  
  @Schema(name = "showInToken", required = false, description = "")
  @JsonProperty("showInToken")
  public @Nullable Boolean getShowInToken() {
    return showInToken;
  }

  public void setShowInToken(@Nullable Boolean showInToken) {
    this.showInToken = showInToken;
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
        Objects.equals(this.quality, alternativeIdentifierDto.quality) &&
        Objects.equals(this.showInToken, alternativeIdentifierDto.showInToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, origine, quality, showInToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlternativeIdentifierDto {\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    origine: ").append(toIndentedString(origine)).append("\n");
    sb.append("    quality: ").append(toIndentedString(quality)).append("\n");
    sb.append("    showInToken: ").append(toIndentedString(showInToken)).append("\n");
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

