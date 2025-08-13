package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.ProfessionnelDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ImagePSDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class ImagePSDto {

  private ProfessionnelDto professionnel;

  public ImagePSDto professionnel(ProfessionnelDto professionnel) {
    this.professionnel = professionnel;
    return this;
  }

  /**
   * Get professionnel
   * @return professionnel
  */
  @Valid 
  @Schema(name = "professionnel", required = false, description = "")
  @JsonProperty("professionnel")
  public ProfessionnelDto getProfessionnel() {
    return professionnel;
  }

  public void setProfessionnel(ProfessionnelDto professionnel) {
    this.professionnel = professionnel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImagePSDto imagePSDto = (ImagePSDto) o;
    return Objects.equals(this.professionnel, imagePSDto.professionnel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(professionnel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImagePSDto {\n");
    sb.append("    professionnel: ").append(toIndentedString(professionnel)).append("\n");
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

