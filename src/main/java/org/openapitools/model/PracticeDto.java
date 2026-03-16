package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.ActivityDto;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PracticeDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class PracticeDto {

  private @Nullable String professionCode;

  private @Nullable String professionalCategoryCode;

  private @Nullable String expertiseTypeCode;

  private @Nullable String expertiseCode;

  private @Nullable String professionalCivilityTitle;

  private @Nullable String professionalLastName;

  private @Nullable String professionalFirstName;

  @Valid
  private List<@Valid ActivityDto> activities = new ArrayList<>();

  public PracticeDto professionCode(@Nullable String professionCode) {
    this.professionCode = professionCode;
    return this;
  }

  /**
   * Get professionCode
   * @return professionCode
   */
  
  @Schema(name = "professionCode", required = false, description = "")
  @JsonProperty("professionCode")
  public @Nullable String getProfessionCode() {
    return professionCode;
  }

  public void setProfessionCode(@Nullable String professionCode) {
    this.professionCode = professionCode;
  }

  public PracticeDto professionalCategoryCode(@Nullable String professionalCategoryCode) {
    this.professionalCategoryCode = professionalCategoryCode;
    return this;
  }

  /**
   * Get professionalCategoryCode
   * @return professionalCategoryCode
   */
  
  @Schema(name = "professionalCategoryCode", required = false, description = "")
  @JsonProperty("professionalCategoryCode")
  public @Nullable String getProfessionalCategoryCode() {
    return professionalCategoryCode;
  }

  public void setProfessionalCategoryCode(@Nullable String professionalCategoryCode) {
    this.professionalCategoryCode = professionalCategoryCode;
  }

  public PracticeDto expertiseTypeCode(@Nullable String expertiseTypeCode) {
    this.expertiseTypeCode = expertiseTypeCode;
    return this;
  }

  /**
   * Get expertiseTypeCode
   * @return expertiseTypeCode
   */
  
  @Schema(name = "expertiseTypeCode", required = false, description = "")
  @JsonProperty("expertiseTypeCode")
  public @Nullable String getExpertiseTypeCode() {
    return expertiseTypeCode;
  }

  public void setExpertiseTypeCode(@Nullable String expertiseTypeCode) {
    this.expertiseTypeCode = expertiseTypeCode;
  }

  public PracticeDto expertiseCode(@Nullable String expertiseCode) {
    this.expertiseCode = expertiseCode;
    return this;
  }

  /**
   * Get expertiseCode
   * @return expertiseCode
   */
  
  @Schema(name = "expertiseCode", required = false, description = "")
  @JsonProperty("expertiseCode")
  public @Nullable String getExpertiseCode() {
    return expertiseCode;
  }

  public void setExpertiseCode(@Nullable String expertiseCode) {
    this.expertiseCode = expertiseCode;
  }

  public PracticeDto professionalCivilityTitle(@Nullable String professionalCivilityTitle) {
    this.professionalCivilityTitle = professionalCivilityTitle;
    return this;
  }

  /**
   * Get professionalCivilityTitle
   * @return professionalCivilityTitle
   */
  
  @Schema(name = "professionalCivilityTitle", required = false, description = "")
  @JsonProperty("professionalCivilityTitle")
  public @Nullable String getProfessionalCivilityTitle() {
    return professionalCivilityTitle;
  }

  public void setProfessionalCivilityTitle(@Nullable String professionalCivilityTitle) {
    this.professionalCivilityTitle = professionalCivilityTitle;
  }

  public PracticeDto professionalLastName(@Nullable String professionalLastName) {
    this.professionalLastName = professionalLastName;
    return this;
  }

  /**
   * Get professionalLastName
   * @return professionalLastName
   */
  
  @Schema(name = "professionalLastName", required = false, description = "")
  @JsonProperty("professionalLastName")
  public @Nullable String getProfessionalLastName() {
    return professionalLastName;
  }

  public void setProfessionalLastName(@Nullable String professionalLastName) {
    this.professionalLastName = professionalLastName;
  }

  public PracticeDto professionalFirstName(@Nullable String professionalFirstName) {
    this.professionalFirstName = professionalFirstName;
    return this;
  }

  /**
   * Get professionalFirstName
   * @return professionalFirstName
   */
  
  @Schema(name = "professionalFirstName", required = false, description = "")
  @JsonProperty("professionalFirstName")
  public @Nullable String getProfessionalFirstName() {
    return professionalFirstName;
  }

  public void setProfessionalFirstName(@Nullable String professionalFirstName) {
    this.professionalFirstName = professionalFirstName;
  }

  public PracticeDto activities(List<@Valid ActivityDto> activities) {
    this.activities = activities;
    return this;
  }

  public PracticeDto addActivitiesItem(ActivityDto activitiesItem) {
    if (this.activities == null) {
      this.activities = new ArrayList<>();
    }
    this.activities.add(activitiesItem);
    return this;
  }

  /**
   * Get activities
   * @return activities
   */
  @Valid 
  @Schema(name = "activities", required = false, description = "")
  @JsonProperty("activities")
  public List<@Valid ActivityDto> getActivities() {
    return activities;
  }

  public void setActivities(List<@Valid ActivityDto> activities) {
    this.activities = activities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PracticeDto practiceDto = (PracticeDto) o;
    return Objects.equals(this.professionCode, practiceDto.professionCode) &&
        Objects.equals(this.professionalCategoryCode, practiceDto.professionalCategoryCode) &&
        Objects.equals(this.expertiseTypeCode, practiceDto.expertiseTypeCode) &&
        Objects.equals(this.expertiseCode, practiceDto.expertiseCode) &&
        Objects.equals(this.professionalCivilityTitle, practiceDto.professionalCivilityTitle) &&
        Objects.equals(this.professionalLastName, practiceDto.professionalLastName) &&
        Objects.equals(this.professionalFirstName, practiceDto.professionalFirstName) &&
        Objects.equals(this.activities, practiceDto.activities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(professionCode, professionalCategoryCode, expertiseTypeCode, expertiseCode, professionalCivilityTitle, professionalLastName, professionalFirstName, activities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PracticeDto {\n");
    sb.append("    professionCode: ").append(toIndentedString(professionCode)).append("\n");
    sb.append("    professionalCategoryCode: ").append(toIndentedString(professionalCategoryCode)).append("\n");
    sb.append("    expertiseTypeCode: ").append(toIndentedString(expertiseTypeCode)).append("\n");
    sb.append("    expertiseCode: ").append(toIndentedString(expertiseCode)).append("\n");
    sb.append("    professionalCivilityTitle: ").append(toIndentedString(professionalCivilityTitle)).append("\n");
    sb.append("    professionalLastName: ").append(toIndentedString(professionalLastName)).append("\n");
    sb.append("    professionalFirstName: ").append(toIndentedString(professionalFirstName)).append("\n");
    sb.append("    activities: ").append(toIndentedString(activities)).append("\n");
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

