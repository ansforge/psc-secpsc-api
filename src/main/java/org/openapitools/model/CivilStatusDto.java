package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.Generated;

/**
 * CivilStatusDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class CivilStatusDto {

  private @Nullable String lastName;

  private @Nullable String firstNames;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate birthdate;

  private @Nullable String birthTownCode;

  private @Nullable String birthCountryCode;

  private @Nullable String birthplace;

  private @Nullable String genderCode;

  private @Nullable String personalCivilityTitle;

  public CivilStatusDto lastName(@Nullable String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   */
  
  @Schema(name = "lastName", required = false, description = "")
  @JsonProperty("lastName")
  public @Nullable String getLastName() {
    return lastName;
  }

  public void setLastName(@Nullable String lastName) {
    this.lastName = lastName;
  }

  public CivilStatusDto firstNames(String firstNames) {
    this.firstNames = firstNames;
    return this;
  }

  /**
   * Get firstNames
   * @return firstNames
   */
  
  @Schema(name = "firstNames", required = false, description = "Prénoms séparés par des espaces")
  @JsonProperty("firstNames")
  public @Nullable String getFirstNames() {
    return firstNames;
  }

  public void setFirstNames(@Nullable String firstNames) {
    this.firstNames = firstNames;
  }

  public CivilStatusDto birthdate(@Nullable LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Get birthdate
   * @return birthdate
   */
  @Valid 
  @Schema(name = "birthdate", required = false, description = "")
  @JsonProperty("birthdate")
  public @Nullable LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(@Nullable LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public CivilStatusDto birthTownCode(@Nullable String birthTownCode) {
    this.birthTownCode = birthTownCode;
    return this;
  }

  /**
   * Get birthTownCode
   * @return birthTownCode
   */
  
  @Schema(name = "birthTownCode", required = false, description = "")
  @JsonProperty("birthTownCode")
  public @Nullable String getBirthTownCode() {
    return birthTownCode;
  }

  public void setBirthTownCode(@Nullable String birthTownCode) {
    this.birthTownCode = birthTownCode;
  }

  public CivilStatusDto birthCountryCode(@Nullable String birthCountryCode) {
    this.birthCountryCode = birthCountryCode;
    return this;
  }

  /**
   * Get birthCountryCode
   * @return birthCountryCode
   */
  
  @Schema(name = "birthCountryCode", required = false, description = "")
  @JsonProperty("birthCountryCode")
  public @Nullable String getBirthCountryCode() {
    return birthCountryCode;
  }

  public void setBirthCountryCode(@Nullable String birthCountryCode) {
    this.birthCountryCode = birthCountryCode;
  }

  public CivilStatusDto birthplace(@Nullable String birthplace) {
    this.birthplace = birthplace;
    return this;
  }

  /**
   * Get birthplace
   * @return birthplace
   */
  
  @Schema(name = "birthplace", required = false, description = "")
  @JsonProperty("birthplace")
  public @Nullable String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(@Nullable String birthplace) {
    this.birthplace = birthplace;
  }

  public CivilStatusDto genderCode(@Nullable String genderCode) {
    this.genderCode = genderCode;
    return this;
  }

  /**
   * Get genderCode
   * @return genderCode
   */
  
  @Schema(name = "genderCode", required = false, description = "")
  @JsonProperty("genderCode")
  public @Nullable String getGenderCode() {
    return genderCode;
  }

  public void setGenderCode(@Nullable String genderCode) {
    this.genderCode = genderCode;
  }

  public CivilStatusDto personalCivilityTitle(@Nullable String personalCivilityTitle) {
    this.personalCivilityTitle = personalCivilityTitle;
    return this;
  }

  /**
   * Get personalCivilityTitle
   * @return personalCivilityTitle
   */
  
  @Schema(name = "personalCivilityTitle", required = false, description = "")
  @JsonProperty("personalCivilityTitle")
  public @Nullable String getPersonalCivilityTitle() {
    return personalCivilityTitle;
  }

  public void setPersonalCivilityTitle(@Nullable String personalCivilityTitle) {
    this.personalCivilityTitle = personalCivilityTitle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CivilStatusDto civilStatusDto = (CivilStatusDto) o;
    return Objects.equals(this.lastName, civilStatusDto.lastName) &&
        Objects.equals(this.firstNames, civilStatusDto.firstNames) &&
        Objects.equals(this.birthdate, civilStatusDto.birthdate) &&
        Objects.equals(this.birthTownCode, civilStatusDto.birthTownCode) &&
        Objects.equals(this.birthCountryCode, civilStatusDto.birthCountryCode) &&
        Objects.equals(this.birthplace, civilStatusDto.birthplace) &&
        Objects.equals(this.genderCode, civilStatusDto.genderCode) &&
        Objects.equals(this.personalCivilityTitle, civilStatusDto.personalCivilityTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, firstNames, birthdate, birthTownCode, birthCountryCode, birthplace, genderCode, personalCivilityTitle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CivilStatusDto {\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstNames: ").append(toIndentedString(firstNames)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    birthTownCode: ").append(toIndentedString(birthTownCode)).append("\n");
    sb.append("    birthCountryCode: ").append(toIndentedString(birthCountryCode)).append("\n");
    sb.append("    birthplace: ").append(toIndentedString(birthplace)).append("\n");
    sb.append("    genderCode: ").append(toIndentedString(genderCode)).append("\n");
    sb.append("    personalCivilityTitle: ").append(toIndentedString(personalCivilityTitle)).append("\n");
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

