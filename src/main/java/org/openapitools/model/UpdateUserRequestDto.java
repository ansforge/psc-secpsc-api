package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.CivilStatusDto;
import org.openapitools.model.ContactInfoDto;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UpdateUserRequestDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class UpdateUserRequestDto {

  private @Nullable String nationalId;

  private @Nullable CivilStatusDto civilStatus;

  private @Nullable ContactInfoDto contactInfo;

  public UpdateUserRequestDto nationalId(@Nullable String nationalId) {
    this.nationalId = nationalId;
    return this;
  }

  /**
   * id PSI, qui sera le nouvel nationalId de l'utilisateur, et ajouté dans les identifiants alternatifs.
   * @return nationalId
   */
  
  @Schema(name = "nationalId", description = "id PSI, qui sera le nouvel nationalId de l'utilisateur, et ajouté dans les identifiants alternatifs.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nationalId")
  public @Nullable String getNationalId() {
    return nationalId;
  }

  public void setNationalId(@Nullable String nationalId) {
    this.nationalId = nationalId;
  }

  public UpdateUserRequestDto civilStatus(@Nullable CivilStatusDto civilStatus) {
    this.civilStatus = civilStatus;
    return this;
  }

  /**
   * Get civilStatus
   * @return civilStatus
   */
  @Valid 
  @Schema(name = "civilStatus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("civilStatus")
  public @Nullable CivilStatusDto getCivilStatus() {
    return civilStatus;
  }

  public void setCivilStatus(@Nullable CivilStatusDto civilStatus) {
    this.civilStatus = civilStatus;
  }

  public UpdateUserRequestDto contactInfo(@Nullable ContactInfoDto contactInfo) {
    this.contactInfo = contactInfo;
    return this;
  }

  /**
   * Get contactInfo
   * @return contactInfo
   */
  @Valid 
  @Schema(name = "contactInfo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contactInfo")
  public @Nullable ContactInfoDto getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(@Nullable ContactInfoDto contactInfo) {
    this.contactInfo = contactInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUserRequestDto updateUserRequestDto = (UpdateUserRequestDto) o;
    return Objects.equals(this.nationalId, updateUserRequestDto.nationalId) &&
        Objects.equals(this.civilStatus, updateUserRequestDto.civilStatus) &&
        Objects.equals(this.contactInfo, updateUserRequestDto.contactInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nationalId, civilStatus, contactInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUserRequestDto {\n");
    sb.append("    nationalId: ").append(toIndentedString(nationalId)).append("\n");
    sb.append("    civilStatus: ").append(toIndentedString(civilStatus)).append("\n");
    sb.append("    contactInfo: ").append(toIndentedString(contactInfo)).append("\n");
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

