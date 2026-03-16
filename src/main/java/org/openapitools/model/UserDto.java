package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.AlternativeIdentifierDto;
import org.openapitools.model.CivilStatusDto;
import org.openapitools.model.ContactInfoDto;
import org.openapitools.model.EimDto;
import org.openapitools.model.PracticeDto;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UserDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class UserDto {

  private @Nullable String nationalId;

  private @Nullable CivilStatusDto civilStatus;

  private @Nullable ContactInfoDto contactInfo;

  @Valid
  private List<@Valid PracticeDto> practices = new ArrayList<>();

  @Valid
  private List<@Valid AlternativeIdentifierDto> alternativeIdentifiers = new ArrayList<>();

  @Valid
  private List<@Valid EimDto> eims = new ArrayList<>();

  public UserDto nationalId(@Nullable String nationalId) {
    this.nationalId = nationalId;
    return this;
  }

  /**
   * Get nationalId
   * @return nationalId
   */
  
  @Schema(name = "nationalId", required = false, description = "")
  @JsonProperty("nationalId")
  public @Nullable String getNationalId() {
    return nationalId;
  }

  public void setNationalId(@Nullable String nationalId) {
    this.nationalId = nationalId;
  }

  public UserDto civilStatus(@Nullable CivilStatusDto civilStatus) {
    this.civilStatus = civilStatus;
    return this;
  }

  /**
   * Get civilStatus
   * @return civilStatus
   */
  @Valid 
  @Schema(name = "civilStatus", required = false, description = "")
  @JsonProperty("civilStatus")
  public @Nullable CivilStatusDto getCivilStatus() {
    return civilStatus;
  }

  public void setCivilStatus(@Nullable CivilStatusDto civilStatus) {
    this.civilStatus = civilStatus;
  }

  public UserDto contactInfo(@Nullable ContactInfoDto contactInfo) {
    this.contactInfo = contactInfo;
    return this;
  }

  /**
   * Get contactInfo
   * @return contactInfo
   */
  @Valid 
  @Schema(name = "contactInfo", required = false, description = "")
  @JsonProperty("contactInfo")
  public @Nullable ContactInfoDto getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(@Nullable ContactInfoDto contactInfo) {
    this.contactInfo = contactInfo;
  }

  public UserDto practices(List<@Valid PracticeDto> practices) {
    this.practices = practices;
    return this;
  }

  public UserDto addPracticesItem(PracticeDto practicesItem) {
    if (this.practices == null) {
      this.practices = new ArrayList<>();
    }
    this.practices.add(practicesItem);
    return this;
  }

  /**
   * Get practices
   * @return practices
   */
  @Valid 
  @Schema(name = "practices", required = false, description = "")
  @JsonProperty("practices")
  public List<@Valid PracticeDto> getPractices() {
    return practices;
  }

  public void setPractices(List<@Valid PracticeDto> practices) {
    this.practices = practices;
  }

  public UserDto alternativeIdentifiers(List<@Valid AlternativeIdentifierDto> alternativeIdentifiers) {
    this.alternativeIdentifiers = alternativeIdentifiers;
    return this;
  }

  public UserDto addAlternativeIdentifiersItem(AlternativeIdentifierDto alternativeIdentifiersItem) {
    if (this.alternativeIdentifiers == null) {
      this.alternativeIdentifiers = new ArrayList<>();
    }
    this.alternativeIdentifiers.add(alternativeIdentifiersItem);
    return this;
  }

  /**
   * Get alternativeIdentifiers
   * @return alternativeIdentifiers
   */
  @Valid 
  @Schema(name = "alternativeIdentifiers", required = false, description = "")
  @JsonProperty("alternativeIdentifiers")
  public List<@Valid AlternativeIdentifierDto> getAlternativeIdentifiers() {
    return alternativeIdentifiers;
  }

  public void setAlternativeIdentifiers(List<@Valid AlternativeIdentifierDto> alternativeIdentifiers) {
    this.alternativeIdentifiers = alternativeIdentifiers;
  }

  public UserDto eims(List<@Valid EimDto> eims) {
    this.eims = eims;
    return this;
  }

  public UserDto addEimsItem(EimDto eimsItem) {
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
    UserDto userDto = (UserDto) o;
    return Objects.equals(this.nationalId, userDto.nationalId) &&
        Objects.equals(this.civilStatus, userDto.civilStatus) &&
        Objects.equals(this.contactInfo, userDto.contactInfo) &&
        Objects.equals(this.practices, userDto.practices) &&
        Objects.equals(this.alternativeIdentifiers, userDto.alternativeIdentifiers) &&
        Objects.equals(this.eims, userDto.eims);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nationalId, civilStatus, contactInfo, practices, alternativeIdentifiers, eims);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDto {\n");
    sb.append("    nationalId: ").append(toIndentedString(nationalId)).append("\n");
    sb.append("    civilStatus: ").append(toIndentedString(civilStatus)).append("\n");
    sb.append("    contactInfo: ").append(toIndentedString(contactInfo)).append("\n");
    sb.append("    practices: ").append(toIndentedString(practices)).append("\n");
    sb.append("    alternativeIdentifiers: ").append(toIndentedString(alternativeIdentifiers)).append("\n");
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

