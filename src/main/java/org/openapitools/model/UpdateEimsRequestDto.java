package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.EimDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UpdateEimsRequestDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class UpdateEimsRequestDto {

  private String nationalId;

  @Valid
  private List<@Valid EimDto> eims = new ArrayList<>();

  public UpdateEimsRequestDto nationalId(String nationalId) {
    this.nationalId = nationalId;
    return this;
  }

  /**
   * Get nationalId
   * @return nationalId
  */
  
  @Schema(name = "nationalId", required = false, description = "")
  @JsonProperty("nationalId")
  public String getNationalId() {
    return nationalId;
  }

  public void setNationalId(String nationalId) {
    this.nationalId = nationalId;
  }

  public UpdateEimsRequestDto eims(List<@Valid EimDto> eims) {
    this.eims = eims;
    return this;
  }

  public UpdateEimsRequestDto addEimsItem(EimDto eimsItem) {
    if (this.eims == null) {
      this.eims = new ArrayList<>();
    }
    this.eims.add(eimsItem);
    return this;
  }

  /**
   * Get eims
   * @return eims
  */
  @Valid 
  @Schema(name = "eims", required = false, description = "")
  @JsonProperty("eims")
  public List<@Valid EimDto> getEims() {
    return eims;
  }

  public void setEims(List<@Valid EimDto> eims) {
    this.eims = eims;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateEimsRequestDto updateEimsRequestDto = (UpdateEimsRequestDto) o;
    return Objects.equals(this.nationalId, updateEimsRequestDto.nationalId) &&
        Objects.equals(this.eims, updateEimsRequestDto.eims);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nationalId, eims);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateEimsRequestDto {\n");
    sb.append("    nationalId: ").append(toIndentedString(nationalId)).append("\n");
    sb.append("    eims: ").append(toIndentedString(eims)).append("\n");
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

