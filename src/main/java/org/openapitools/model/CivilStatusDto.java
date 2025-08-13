package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CivilStatusDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class CivilStatusDto {

  private String lastName;

  @Valid
  private List<String> firstNames = new ArrayList<>();

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthDate;

  private String birthTownCode;

  private String birthCountryCode;

  private String birthPlace;

  private String genderCode;

  private String personalCivilityTitle;

  public CivilStatusDto lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  
  @Schema(name = "lastName", required = false, description = "")
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CivilStatusDto firstNames(List<String> firstNames) {
    this.firstNames = firstNames;
    return this;
  }

  public CivilStatusDto addFirstNamesItem(String firstNamesItem) {
    if (this.firstNames == null) {
      this.firstNames = new ArrayList<>();
    }
    this.firstNames.add(firstNamesItem);
    return this;
  }

  /**
   * Get firstNames
   * @return firstNames
  */
  
  @Schema(name = "firstNames", required = false, description = "")
  @JsonProperty("firstNames")
  public List<String> getFirstNames() {
    return firstNames;
  }

  public void setFirstNames(List<String> firstNames) {
    this.firstNames = firstNames;
  }

  public CivilStatusDto birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
  */
  @Valid 
  @Schema(name = "birthDate", required = false, description = "")
  @JsonProperty("birthDate")
  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public CivilStatusDto birthTownCode(String birthTownCode) {
    this.birthTownCode = birthTownCode;
    return this;
  }

  /**
   * Get birthTownCode
   * @return birthTownCode
  */
  
  @Schema(name = "birthTownCode", required = false, description = "")
  @JsonProperty("birthTownCode")
  public String getBirthTownCode() {
    return birthTownCode;
  }

  public void setBirthTownCode(String birthTownCode) {
    this.birthTownCode = birthTownCode;
  }

  public CivilStatusDto birthCountryCode(String birthCountryCode) {
    this.birthCountryCode = birthCountryCode;
    return this;
  }

  /**
   * Get birthCountryCode
   * @return birthCountryCode
  */
  
  @Schema(name = "birthCountryCode", required = false, description = "")
  @JsonProperty("birthCountryCode")
  public String getBirthCountryCode() {
    return birthCountryCode;
  }

  public void setBirthCountryCode(String birthCountryCode) {
    this.birthCountryCode = birthCountryCode;
  }

  public CivilStatusDto birthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
    return this;
  }

  /**
   * Get birthPlace
   * @return birthPlace
  */
  
  @Schema(name = "birthPlace", required = false, description = "")
  @JsonProperty("birthPlace")
  public String getBirthPlace() {
    return birthPlace;
  }

  public void setBirthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
  }

  public CivilStatusDto genderCode(String genderCode) {
    this.genderCode = genderCode;
    return this;
  }

  /**
   * Get genderCode
   * @return genderCode
  */
  
  @Schema(name = "genderCode", required = false, description = "")
  @JsonProperty("genderCode")
  public String getGenderCode() {
    return genderCode;
  }

  public void setGenderCode(String genderCode) {
    this.genderCode = genderCode;
  }

  public CivilStatusDto personalCivilityTitle(String personalCivilityTitle) {
    this.personalCivilityTitle = personalCivilityTitle;
    return this;
  }

  /**
   * Get personalCivilityTitle
   * @return personalCivilityTitle
  */
  
  @Schema(name = "personalCivilityTitle", required = false, description = "")
  @JsonProperty("personalCivilityTitle")
  public String getPersonalCivilityTitle() {
    return personalCivilityTitle;
  }

  public void setPersonalCivilityTitle(String personalCivilityTitle) {
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
        Objects.equals(this.birthDate, civilStatusDto.birthDate) &&
        Objects.equals(this.birthTownCode, civilStatusDto.birthTownCode) &&
        Objects.equals(this.birthCountryCode, civilStatusDto.birthCountryCode) &&
        Objects.equals(this.birthPlace, civilStatusDto.birthPlace) &&
        Objects.equals(this.genderCode, civilStatusDto.genderCode) &&
        Objects.equals(this.personalCivilityTitle, civilStatusDto.personalCivilityTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, firstNames, birthDate, birthTownCode, birthCountryCode, birthPlace, genderCode, personalCivilityTitle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CivilStatusDto {\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstNames: ").append(toIndentedString(firstNames)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    birthTownCode: ").append(toIndentedString(birthTownCode)).append("\n");
    sb.append("    birthCountryCode: ").append(toIndentedString(birthCountryCode)).append("\n");
    sb.append("    birthPlace: ").append(toIndentedString(birthPlace)).append("\n");
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

