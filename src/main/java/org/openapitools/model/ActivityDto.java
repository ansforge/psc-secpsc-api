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
 * ActivityDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class ActivityDto {

  private @Nullable String professionalModeCode;

  private @Nullable String activitySectorCode;

  private @Nullable String pharmacistTableSectionCode;

  private @Nullable String roleCode;

  private @Nullable String activityTypeCode;

  private @Nullable String siretSiteNumber;

  private @Nullable String sirenSiteNumber;

  private @Nullable String finessSiteNumber;

  private @Nullable String finessLegalCompanyNumber;

  private @Nullable String companyTechnicalIdentifier;

  private @Nullable String companyName;

  private @Nullable String companyCommercialSign;

  private @Nullable String companyAdditionalAddress;

  private @Nullable String companyGeographicalPointComplement;

  private @Nullable String companyWayNumber;

  private @Nullable String companyRepeatIndex;

  private @Nullable String companyWayType;

  private @Nullable String companyWayLabel;

  private @Nullable String companyDistributionMention;

  private @Nullable String companyCedexOffice;

  private @Nullable String companyPostalCode;

  private @Nullable String companyTownCode;

  private @Nullable String companyCountryCode;

  private @Nullable String companyPhone1;

  private @Nullable String companyPhone2;

  private @Nullable String companyFax;

  private @Nullable String companyEmail;

  private @Nullable String companyCountyCode;

  private @Nullable String companyOldIdentifier;

  private @Nullable String companyRegistrationAuthority;

  public ActivityDto professionalModeCode(@Nullable String professionalModeCode) {
    this.professionalModeCode = professionalModeCode;
    return this;
  }

  /**
   * Get professionalModeCode
   * @return professionalModeCode
   */
  
  @Schema(name = "professionalModeCode", required = false, description = "")
  @JsonProperty("professionalModeCode")
  public @Nullable String getProfessionalModeCode() {
    return professionalModeCode;
  }

  public void setProfessionalModeCode(@Nullable String professionalModeCode) {
    this.professionalModeCode = professionalModeCode;
  }

  public ActivityDto activitySectorCode(@Nullable String activitySectorCode) {
    this.activitySectorCode = activitySectorCode;
    return this;
  }

  /**
   * Get activitySectorCode
   * @return activitySectorCode
   */
  
  @Schema(name = "activitySectorCode", required = false, description = "")
  @JsonProperty("activitySectorCode")
  public @Nullable String getActivitySectorCode() {
    return activitySectorCode;
  }

  public void setActivitySectorCode(@Nullable String activitySectorCode) {
    this.activitySectorCode = activitySectorCode;
  }

  public ActivityDto pharmacistTableSectionCode(@Nullable String pharmacistTableSectionCode) {
    this.pharmacistTableSectionCode = pharmacistTableSectionCode;
    return this;
  }

  /**
   * Get pharmacistTableSectionCode
   * @return pharmacistTableSectionCode
   */
  
  @Schema(name = "pharmacistTableSectionCode", required = false, description = "")
  @JsonProperty("pharmacistTableSectionCode")
  public @Nullable String getPharmacistTableSectionCode() {
    return pharmacistTableSectionCode;
  }

  public void setPharmacistTableSectionCode(@Nullable String pharmacistTableSectionCode) {
    this.pharmacistTableSectionCode = pharmacistTableSectionCode;
  }

  public ActivityDto roleCode(@Nullable String roleCode) {
    this.roleCode = roleCode;
    return this;
  }

  /**
   * Get roleCode
   * @return roleCode
   */
  
  @Schema(name = "roleCode", required = false, description = "")
  @JsonProperty("roleCode")
  public @Nullable String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(@Nullable String roleCode) {
    this.roleCode = roleCode;
  }

  public ActivityDto activityTypeCode(@Nullable String activityTypeCode) {
    this.activityTypeCode = activityTypeCode;
    return this;
  }

  /**
   * Get activityTypeCode
   * @return activityTypeCode
   */
  
  @Schema(name = "activityTypeCode", required = false, description = "")
  @JsonProperty("activityTypeCode")
  public @Nullable String getActivityTypeCode() {
    return activityTypeCode;
  }

  public void setActivityTypeCode(@Nullable String activityTypeCode) {
    this.activityTypeCode = activityTypeCode;
  }

  public ActivityDto siretSiteNumber(@Nullable String siretSiteNumber) {
    this.siretSiteNumber = siretSiteNumber;
    return this;
  }

  /**
   * Get siretSiteNumber
   * @return siretSiteNumber
   */
  
  @Schema(name = "siretSiteNumber", required = false, description = "")
  @JsonProperty("siretSiteNumber")
  public @Nullable String getSiretSiteNumber() {
    return siretSiteNumber;
  }

  public void setSiretSiteNumber(@Nullable String siretSiteNumber) {
    this.siretSiteNumber = siretSiteNumber;
  }

  public ActivityDto sirenSiteNumber(@Nullable String sirenSiteNumber) {
    this.sirenSiteNumber = sirenSiteNumber;
    return this;
  }

  /**
   * Get sirenSiteNumber
   * @return sirenSiteNumber
   */
  
  @Schema(name = "sirenSiteNumber", required = false, description = "")
  @JsonProperty("sirenSiteNumber")
  public @Nullable String getSirenSiteNumber() {
    return sirenSiteNumber;
  }

  public void setSirenSiteNumber(@Nullable String sirenSiteNumber) {
    this.sirenSiteNumber = sirenSiteNumber;
  }

  public ActivityDto finessSiteNumber(@Nullable String finessSiteNumber) {
    this.finessSiteNumber = finessSiteNumber;
    return this;
  }

  /**
   * Get finessSiteNumber
   * @return finessSiteNumber
   */
  
  @Schema(name = "finessSiteNumber", required = false, description = "")
  @JsonProperty("finessSiteNumber")
  public @Nullable String getFinessSiteNumber() {
    return finessSiteNumber;
  }

  public void setFinessSiteNumber(@Nullable String finessSiteNumber) {
    this.finessSiteNumber = finessSiteNumber;
  }

  public ActivityDto finessLegalCompanyNumber(@Nullable String finessLegalCompanyNumber) {
    this.finessLegalCompanyNumber = finessLegalCompanyNumber;
    return this;
  }

  /**
   * Get finessLegalCompanyNumber
   * @return finessLegalCompanyNumber
   */
  
  @Schema(name = "finessLegalCompanyNumber", required = false, description = "")
  @JsonProperty("finessLegalCompanyNumber")
  public @Nullable String getFinessLegalCompanyNumber() {
    return finessLegalCompanyNumber;
  }

  public void setFinessLegalCompanyNumber(@Nullable String finessLegalCompanyNumber) {
    this.finessLegalCompanyNumber = finessLegalCompanyNumber;
  }

  public ActivityDto companyTechnicalIdentifier(@Nullable String companyTechnicalIdentifier) {
    this.companyTechnicalIdentifier = companyTechnicalIdentifier;
    return this;
  }

  /**
   * Get companyTechnicalIdentifier
   * @return companyTechnicalIdentifier
   */
  
  @Schema(name = "companyTechnicalIdentifier", required = false, description = "")
  @JsonProperty("companyTechnicalIdentifier")
  public @Nullable String getCompanyTechnicalIdentifier() {
    return companyTechnicalIdentifier;
  }

  public void setCompanyTechnicalIdentifier(@Nullable String companyTechnicalIdentifier) {
    this.companyTechnicalIdentifier = companyTechnicalIdentifier;
  }

  public ActivityDto companyName(@Nullable String companyName) {
    this.companyName = companyName;
    return this;
  }

  /**
   * Get companyName
   * @return companyName
   */
  
  @Schema(name = "companyName", required = false, description = "")
  @JsonProperty("companyName")
  public @Nullable String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(@Nullable String companyName) {
    this.companyName = companyName;
  }

  public ActivityDto companyCommercialSign(@Nullable String companyCommercialSign) {
    this.companyCommercialSign = companyCommercialSign;
    return this;
  }

  /**
   * Get companyCommercialSign
   * @return companyCommercialSign
   */
  
  @Schema(name = "companyCommercialSign", required = false, description = "")
  @JsonProperty("companyCommercialSign")
  public @Nullable String getCompanyCommercialSign() {
    return companyCommercialSign;
  }

  public void setCompanyCommercialSign(@Nullable String companyCommercialSign) {
    this.companyCommercialSign = companyCommercialSign;
  }

  public ActivityDto companyAdditionalAddress(@Nullable String companyAdditionalAddress) {
    this.companyAdditionalAddress = companyAdditionalAddress;
    return this;
  }

  /**
   * Get companyAdditionalAddress
   * @return companyAdditionalAddress
   */
  
  @Schema(name = "companyAdditionalAddress", required = false, description = "")
  @JsonProperty("companyAdditionalAddress")
  public @Nullable String getCompanyAdditionalAddress() {
    return companyAdditionalAddress;
  }

  public void setCompanyAdditionalAddress(@Nullable String companyAdditionalAddress) {
    this.companyAdditionalAddress = companyAdditionalAddress;
  }

  public ActivityDto companyGeographicalPointComplement(@Nullable String companyGeographicalPointComplement) {
    this.companyGeographicalPointComplement = companyGeographicalPointComplement;
    return this;
  }

  /**
   * Get companyGeographicalPointComplement
   * @return companyGeographicalPointComplement
   */
  
  @Schema(name = "companyGeographicalPointComplement", required = false, description = "")
  @JsonProperty("companyGeographicalPointComplement")
  public @Nullable String getCompanyGeographicalPointComplement() {
    return companyGeographicalPointComplement;
  }

  public void setCompanyGeographicalPointComplement(@Nullable String companyGeographicalPointComplement) {
    this.companyGeographicalPointComplement = companyGeographicalPointComplement;
  }

  public ActivityDto companyWayNumber(@Nullable String companyWayNumber) {
    this.companyWayNumber = companyWayNumber;
    return this;
  }

  /**
   * Get companyWayNumber
   * @return companyWayNumber
   */
  
  @Schema(name = "companyWayNumber", required = false, description = "")
  @JsonProperty("companyWayNumber")
  public @Nullable String getCompanyWayNumber() {
    return companyWayNumber;
  }

  public void setCompanyWayNumber(@Nullable String companyWayNumber) {
    this.companyWayNumber = companyWayNumber;
  }

  public ActivityDto companyRepeatIndex(@Nullable String companyRepeatIndex) {
    this.companyRepeatIndex = companyRepeatIndex;
    return this;
  }

  /**
   * Get companyRepeatIndex
   * @return companyRepeatIndex
   */
  
  @Schema(name = "companyRepeatIndex", required = false, description = "")
  @JsonProperty("companyRepeatIndex")
  public @Nullable String getCompanyRepeatIndex() {
    return companyRepeatIndex;
  }

  public void setCompanyRepeatIndex(@Nullable String companyRepeatIndex) {
    this.companyRepeatIndex = companyRepeatIndex;
  }

  public ActivityDto companyWayType(@Nullable String companyWayType) {
    this.companyWayType = companyWayType;
    return this;
  }

  /**
   * Get companyWayType
   * @return companyWayType
   */
  
  @Schema(name = "companyWayType", required = false, description = "")
  @JsonProperty("companyWayType")
  public @Nullable String getCompanyWayType() {
    return companyWayType;
  }

  public void setCompanyWayType(@Nullable String companyWayType) {
    this.companyWayType = companyWayType;
  }

  public ActivityDto companyWayLabel(@Nullable String companyWayLabel) {
    this.companyWayLabel = companyWayLabel;
    return this;
  }

  /**
   * Get companyWayLabel
   * @return companyWayLabel
   */
  
  @Schema(name = "companyWayLabel", required = false, description = "")
  @JsonProperty("companyWayLabel")
  public @Nullable String getCompanyWayLabel() {
    return companyWayLabel;
  }

  public void setCompanyWayLabel(@Nullable String companyWayLabel) {
    this.companyWayLabel = companyWayLabel;
  }

  public ActivityDto companyDistributionMention(@Nullable String companyDistributionMention) {
    this.companyDistributionMention = companyDistributionMention;
    return this;
  }

  /**
   * Get companyDistributionMention
   * @return companyDistributionMention
   */
  
  @Schema(name = "companyDistributionMention", required = false, description = "")
  @JsonProperty("companyDistributionMention")
  public @Nullable String getCompanyDistributionMention() {
    return companyDistributionMention;
  }

  public void setCompanyDistributionMention(@Nullable String companyDistributionMention) {
    this.companyDistributionMention = companyDistributionMention;
  }

  public ActivityDto companyCedexOffice(@Nullable String companyCedexOffice) {
    this.companyCedexOffice = companyCedexOffice;
    return this;
  }

  /**
   * Get companyCedexOffice
   * @return companyCedexOffice
   */
  
  @Schema(name = "companyCedexOffice", required = false, description = "")
  @JsonProperty("companyCedexOffice")
  public @Nullable String getCompanyCedexOffice() {
    return companyCedexOffice;
  }

  public void setCompanyCedexOffice(@Nullable String companyCedexOffice) {
    this.companyCedexOffice = companyCedexOffice;
  }

  public ActivityDto companyPostalCode(@Nullable String companyPostalCode) {
    this.companyPostalCode = companyPostalCode;
    return this;
  }

  /**
   * Get companyPostalCode
   * @return companyPostalCode
   */
  
  @Schema(name = "companyPostalCode", required = false, description = "")
  @JsonProperty("companyPostalCode")
  public @Nullable String getCompanyPostalCode() {
    return companyPostalCode;
  }

  public void setCompanyPostalCode(@Nullable String companyPostalCode) {
    this.companyPostalCode = companyPostalCode;
  }

  public ActivityDto companyTownCode(@Nullable String companyTownCode) {
    this.companyTownCode = companyTownCode;
    return this;
  }

  /**
   * Get companyTownCode
   * @return companyTownCode
   */
  
  @Schema(name = "companyTownCode", required = false, description = "")
  @JsonProperty("companyTownCode")
  public @Nullable String getCompanyTownCode() {
    return companyTownCode;
  }

  public void setCompanyTownCode(@Nullable String companyTownCode) {
    this.companyTownCode = companyTownCode;
  }

  public ActivityDto companyCountryCode(@Nullable String companyCountryCode) {
    this.companyCountryCode = companyCountryCode;
    return this;
  }

  /**
   * Get companyCountryCode
   * @return companyCountryCode
   */
  
  @Schema(name = "companyCountryCode", required = false, description = "")
  @JsonProperty("companyCountryCode")
  public @Nullable String getCompanyCountryCode() {
    return companyCountryCode;
  }

  public void setCompanyCountryCode(@Nullable String companyCountryCode) {
    this.companyCountryCode = companyCountryCode;
  }

  public ActivityDto companyPhone1(@Nullable String companyPhone1) {
    this.companyPhone1 = companyPhone1;
    return this;
  }

  /**
   * Get companyPhone1
   * @return companyPhone1
   */
  
  @Schema(name = "companyPhone1", required = false, description = "")
  @JsonProperty("companyPhone1")
  public @Nullable String getCompanyPhone1() {
    return companyPhone1;
  }

  public void setCompanyPhone1(@Nullable String companyPhone1) {
    this.companyPhone1 = companyPhone1;
  }

  public ActivityDto companyPhone2(@Nullable String companyPhone2) {
    this.companyPhone2 = companyPhone2;
    return this;
  }

  /**
   * Get companyPhone2
   * @return companyPhone2
   */
  
  @Schema(name = "companyPhone2", required = false, description = "")
  @JsonProperty("companyPhone2")
  public @Nullable String getCompanyPhone2() {
    return companyPhone2;
  }

  public void setCompanyPhone2(@Nullable String companyPhone2) {
    this.companyPhone2 = companyPhone2;
  }

  public ActivityDto companyFax(@Nullable String companyFax) {
    this.companyFax = companyFax;
    return this;
  }

  /**
   * Get companyFax
   * @return companyFax
   */
  
  @Schema(name = "companyFax", required = false, description = "")
  @JsonProperty("companyFax")
  public @Nullable String getCompanyFax() {
    return companyFax;
  }

  public void setCompanyFax(@Nullable String companyFax) {
    this.companyFax = companyFax;
  }

  public ActivityDto companyEmail(@Nullable String companyEmail) {
    this.companyEmail = companyEmail;
    return this;
  }

  /**
   * Get companyEmail
   * @return companyEmail
   */
  
  @Schema(name = "companyEmail", required = false, description = "")
  @JsonProperty("companyEmail")
  public @Nullable String getCompanyEmail() {
    return companyEmail;
  }

  public void setCompanyEmail(@Nullable String companyEmail) {
    this.companyEmail = companyEmail;
  }

  public ActivityDto companyCountyCode(@Nullable String companyCountyCode) {
    this.companyCountyCode = companyCountyCode;
    return this;
  }

  /**
   * Get companyCountyCode
   * @return companyCountyCode
   */
  
  @Schema(name = "companyCountyCode", required = false, description = "")
  @JsonProperty("companyCountyCode")
  public @Nullable String getCompanyCountyCode() {
    return companyCountyCode;
  }

  public void setCompanyCountyCode(@Nullable String companyCountyCode) {
    this.companyCountyCode = companyCountyCode;
  }

  public ActivityDto companyOldIdentifier(@Nullable String companyOldIdentifier) {
    this.companyOldIdentifier = companyOldIdentifier;
    return this;
  }

  /**
   * Get companyOldIdentifier
   * @return companyOldIdentifier
   */
  
  @Schema(name = "companyOldIdentifier", required = false, description = "")
  @JsonProperty("companyOldIdentifier")
  public @Nullable String getCompanyOldIdentifier() {
    return companyOldIdentifier;
  }

  public void setCompanyOldIdentifier(@Nullable String companyOldIdentifier) {
    this.companyOldIdentifier = companyOldIdentifier;
  }

  public ActivityDto companyRegistrationAuthority(@Nullable String companyRegistrationAuthority) {
    this.companyRegistrationAuthority = companyRegistrationAuthority;
    return this;
  }

  /**
   * Get companyRegistrationAuthority
   * @return companyRegistrationAuthority
   */
  
  @Schema(name = "companyRegistrationAuthority", required = false, description = "")
  @JsonProperty("companyRegistrationAuthority")
  public @Nullable String getCompanyRegistrationAuthority() {
    return companyRegistrationAuthority;
  }

  public void setCompanyRegistrationAuthority(@Nullable String companyRegistrationAuthority) {
    this.companyRegistrationAuthority = companyRegistrationAuthority;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityDto activityDto = (ActivityDto) o;
    return Objects.equals(this.professionalModeCode, activityDto.professionalModeCode) &&
        Objects.equals(this.activitySectorCode, activityDto.activitySectorCode) &&
        Objects.equals(this.pharmacistTableSectionCode, activityDto.pharmacistTableSectionCode) &&
        Objects.equals(this.roleCode, activityDto.roleCode) &&
        Objects.equals(this.activityTypeCode, activityDto.activityTypeCode) &&
        Objects.equals(this.siretSiteNumber, activityDto.siretSiteNumber) &&
        Objects.equals(this.sirenSiteNumber, activityDto.sirenSiteNumber) &&
        Objects.equals(this.finessSiteNumber, activityDto.finessSiteNumber) &&
        Objects.equals(this.finessLegalCompanyNumber, activityDto.finessLegalCompanyNumber) &&
        Objects.equals(this.companyTechnicalIdentifier, activityDto.companyTechnicalIdentifier) &&
        Objects.equals(this.companyName, activityDto.companyName) &&
        Objects.equals(this.companyCommercialSign, activityDto.companyCommercialSign) &&
        Objects.equals(this.companyAdditionalAddress, activityDto.companyAdditionalAddress) &&
        Objects.equals(this.companyGeographicalPointComplement, activityDto.companyGeographicalPointComplement) &&
        Objects.equals(this.companyWayNumber, activityDto.companyWayNumber) &&
        Objects.equals(this.companyRepeatIndex, activityDto.companyRepeatIndex) &&
        Objects.equals(this.companyWayType, activityDto.companyWayType) &&
        Objects.equals(this.companyWayLabel, activityDto.companyWayLabel) &&
        Objects.equals(this.companyDistributionMention, activityDto.companyDistributionMention) &&
        Objects.equals(this.companyCedexOffice, activityDto.companyCedexOffice) &&
        Objects.equals(this.companyPostalCode, activityDto.companyPostalCode) &&
        Objects.equals(this.companyTownCode, activityDto.companyTownCode) &&
        Objects.equals(this.companyCountryCode, activityDto.companyCountryCode) &&
        Objects.equals(this.companyPhone1, activityDto.companyPhone1) &&
        Objects.equals(this.companyPhone2, activityDto.companyPhone2) &&
        Objects.equals(this.companyFax, activityDto.companyFax) &&
        Objects.equals(this.companyEmail, activityDto.companyEmail) &&
        Objects.equals(this.companyCountyCode, activityDto.companyCountyCode) &&
        Objects.equals(this.companyOldIdentifier, activityDto.companyOldIdentifier) &&
        Objects.equals(this.companyRegistrationAuthority, activityDto.companyRegistrationAuthority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(professionalModeCode, activitySectorCode, pharmacistTableSectionCode, roleCode, activityTypeCode, siretSiteNumber, sirenSiteNumber, finessSiteNumber, finessLegalCompanyNumber, companyTechnicalIdentifier, companyName, companyCommercialSign, companyAdditionalAddress, companyGeographicalPointComplement, companyWayNumber, companyRepeatIndex, companyWayType, companyWayLabel, companyDistributionMention, companyCedexOffice, companyPostalCode, companyTownCode, companyCountryCode, companyPhone1, companyPhone2, companyFax, companyEmail, companyCountyCode, companyOldIdentifier, companyRegistrationAuthority);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityDto {\n");
    sb.append("    professionalModeCode: ").append(toIndentedString(professionalModeCode)).append("\n");
    sb.append("    activitySectorCode: ").append(toIndentedString(activitySectorCode)).append("\n");
    sb.append("    pharmacistTableSectionCode: ").append(toIndentedString(pharmacistTableSectionCode)).append("\n");
    sb.append("    roleCode: ").append(toIndentedString(roleCode)).append("\n");
    sb.append("    activityTypeCode: ").append(toIndentedString(activityTypeCode)).append("\n");
    sb.append("    siretSiteNumber: ").append(toIndentedString(siretSiteNumber)).append("\n");
    sb.append("    sirenSiteNumber: ").append(toIndentedString(sirenSiteNumber)).append("\n");
    sb.append("    finessSiteNumber: ").append(toIndentedString(finessSiteNumber)).append("\n");
    sb.append("    finessLegalCompanyNumber: ").append(toIndentedString(finessLegalCompanyNumber)).append("\n");
    sb.append("    companyTechnicalIdentifier: ").append(toIndentedString(companyTechnicalIdentifier)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    companyCommercialSign: ").append(toIndentedString(companyCommercialSign)).append("\n");
    sb.append("    companyAdditionalAddress: ").append(toIndentedString(companyAdditionalAddress)).append("\n");
    sb.append("    companyGeographicalPointComplement: ").append(toIndentedString(companyGeographicalPointComplement)).append("\n");
    sb.append("    companyWayNumber: ").append(toIndentedString(companyWayNumber)).append("\n");
    sb.append("    companyRepeatIndex: ").append(toIndentedString(companyRepeatIndex)).append("\n");
    sb.append("    companyWayType: ").append(toIndentedString(companyWayType)).append("\n");
    sb.append("    companyWayLabel: ").append(toIndentedString(companyWayLabel)).append("\n");
    sb.append("    companyDistributionMention: ").append(toIndentedString(companyDistributionMention)).append("\n");
    sb.append("    companyCedexOffice: ").append(toIndentedString(companyCedexOffice)).append("\n");
    sb.append("    companyPostalCode: ").append(toIndentedString(companyPostalCode)).append("\n");
    sb.append("    companyTownCode: ").append(toIndentedString(companyTownCode)).append("\n");
    sb.append("    companyCountryCode: ").append(toIndentedString(companyCountryCode)).append("\n");
    sb.append("    companyPhone1: ").append(toIndentedString(companyPhone1)).append("\n");
    sb.append("    companyPhone2: ").append(toIndentedString(companyPhone2)).append("\n");
    sb.append("    companyFax: ").append(toIndentedString(companyFax)).append("\n");
    sb.append("    companyEmail: ").append(toIndentedString(companyEmail)).append("\n");
    sb.append("    companyCountyCode: ").append(toIndentedString(companyCountyCode)).append("\n");
    sb.append("    companyOldIdentifier: ").append(toIndentedString(companyOldIdentifier)).append("\n");
    sb.append("    companyRegistrationAuthority: ").append(toIndentedString(companyRegistrationAuthority)).append("\n");
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

