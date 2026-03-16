package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * EimDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class EimDto {

  private @Nullable String idNat;

  private @Nullable String mieType;

  private @Nullable String serialNumber;

  private @Nullable String email;

  private @Nullable String deviceName;

  private @Nullable String model;

  private @Nullable String operatingSystem;

  private @Nullable String appVersion;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate creationDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate endOfValidityDate;

  private @Nullable String activationMode;

  private @Nullable String eidasLevel;

  private @Nullable String fitier;

  public EimDto idNat(@Nullable String idNat) {
    this.idNat = idNat;
    return this;
  }

  /**
   * Get idNat
   * @return idNat
   */
  
  @Schema(name = "idNat", required = false, description = "")
  @JsonProperty("idNat")
  public @Nullable String getIdNat() {
    return idNat;
  }

  public void setIdNat(@Nullable String idNat) {
    this.idNat = idNat;
  }

  public EimDto mieType(@Nullable String mieType) {
    this.mieType = mieType;
    return this;
  }

  /**
   * Get mieType
   * @return mieType
   */
  
  @Schema(name = "mieType", required = false, description = "")
  @JsonProperty("mieType")
  public @Nullable String getMieType() {
    return mieType;
  }

  public void setMieType(@Nullable String mieType) {
    this.mieType = mieType;
  }

  public EimDto serialNumber(@Nullable String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  /**
   * Get serialNumber
   * @return serialNumber
   */
  
  @Schema(name = "serialNumber", required = false, description = "")
  @JsonProperty("serialNumber")
  public @Nullable String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(@Nullable String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public EimDto email(@Nullable String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  
  @Schema(name = "email", required = false, description = "")
  @JsonProperty("email")
  public @Nullable String getEmail() {
    return email;
  }

  public void setEmail(@Nullable String email) {
    this.email = email;
  }

  public EimDto deviceName(@Nullable String deviceName) {
    this.deviceName = deviceName;
    return this;
  }

  /**
   * Get deviceName
   * @return deviceName
   */
  
  @Schema(name = "deviceName", required = false, description = "")
  @JsonProperty("deviceName")
  public @Nullable String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(@Nullable String deviceName) {
    this.deviceName = deviceName;
  }

  public EimDto model(@Nullable String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
   */
  
  @Schema(name = "model", required = false, description = "")
  @JsonProperty("model")
  public @Nullable String getModel() {
    return model;
  }

  public void setModel(@Nullable String model) {
    this.model = model;
  }

  public EimDto operatingSystem(@Nullable String operatingSystem) {
    this.operatingSystem = operatingSystem;
    return this;
  }

  /**
   * Get operatingSystem
   * @return operatingSystem
   */
  
  @Schema(name = "operatingSystem", required = false, description = "")
  @JsonProperty("operatingSystem")
  public @Nullable String getOperatingSystem() {
    return operatingSystem;
  }

  public void setOperatingSystem(@Nullable String operatingSystem) {
    this.operatingSystem = operatingSystem;
  }

  public EimDto appVersion(@Nullable String appVersion) {
    this.appVersion = appVersion;
    return this;
  }

  /**
   * Get appVersion
   * @return appVersion
   */
  
  @Schema(name = "appVersion", required = false, description = "")
  @JsonProperty("appVersion")
  public @Nullable String getAppVersion() {
    return appVersion;
  }

  public void setAppVersion(@Nullable String appVersion) {
    this.appVersion = appVersion;
  }

  public EimDto creationDate(@Nullable LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Get creationDate
   * @return creationDate
   */
  @Valid 
  @Schema(name = "creationDate", required = false, description = "")
  @JsonProperty("creationDate")
  public @Nullable LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(@Nullable LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public EimDto endOfValidityDate(@Nullable LocalDate endOfValidityDate) {
    this.endOfValidityDate = endOfValidityDate;
    return this;
  }

  /**
   * Get endOfValidityDate
   * @return endOfValidityDate
   */
  @Valid 
  @Schema(name = "endOfValidityDate", required = false, description = "")
  @JsonProperty("endOfValidityDate")
  public @Nullable LocalDate getEndOfValidityDate() {
    return endOfValidityDate;
  }

  public void setEndOfValidityDate(@Nullable LocalDate endOfValidityDate) {
    this.endOfValidityDate = endOfValidityDate;
  }

  public EimDto activationMode(@Nullable String activationMode) {
    this.activationMode = activationMode;
    return this;
  }

  /**
   * Get activationMode
   * @return activationMode
   */
  
  @Schema(name = "activationMode", required = false, description = "")
  @JsonProperty("activationMode")
  public @Nullable String getActivationMode() {
    return activationMode;
  }

  public void setActivationMode(@Nullable String activationMode) {
    this.activationMode = activationMode;
  }

  public EimDto eidasLevel(@Nullable String eidasLevel) {
    this.eidasLevel = eidasLevel;
    return this;
  }

  /**
   * Get eidasLevel
   * @return eidasLevel
   */
  
  @Schema(name = "eidasLevel", required = false, description = "")
  @JsonProperty("eidasLevel")
  public @Nullable String getEidasLevel() {
    return eidasLevel;
  }

  public void setEidasLevel(@Nullable String eidasLevel) {
    this.eidasLevel = eidasLevel;
  }

  public EimDto fitier(@Nullable String fitier) {
    this.fitier = fitier;
    return this;
  }

  /**
   * Get fitier
   * @return fitier
   */
  
  @Schema(name = "fitier", required = false, description = "")
  @JsonProperty("fitier")
  public @Nullable String getFitier() {
    return fitier;
  }

  public void setFitier(@Nullable String fitier) {
    this.fitier = fitier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EimDto eimDto = (EimDto) o;
    return Objects.equals(this.idNat, eimDto.idNat) &&
        Objects.equals(this.mieType, eimDto.mieType) &&
        Objects.equals(this.serialNumber, eimDto.serialNumber) &&
        Objects.equals(this.email, eimDto.email) &&
        Objects.equals(this.deviceName, eimDto.deviceName) &&
        Objects.equals(this.model, eimDto.model) &&
        Objects.equals(this.operatingSystem, eimDto.operatingSystem) &&
        Objects.equals(this.appVersion, eimDto.appVersion) &&
        Objects.equals(this.creationDate, eimDto.creationDate) &&
        Objects.equals(this.endOfValidityDate, eimDto.endOfValidityDate) &&
        Objects.equals(this.activationMode, eimDto.activationMode) &&
        Objects.equals(this.eidasLevel, eimDto.eidasLevel) &&
        Objects.equals(this.fitier, eimDto.fitier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idNat, mieType, serialNumber, email, deviceName, model, operatingSystem, appVersion, creationDate, endOfValidityDate, activationMode, eidasLevel, fitier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EimDto {\n");
    sb.append("    idNat: ").append(toIndentedString(idNat)).append("\n");
    sb.append("    mieType: ").append(toIndentedString(mieType)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    deviceName: ").append(toIndentedString(deviceName)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    operatingSystem: ").append(toIndentedString(operatingSystem)).append("\n");
    sb.append("    appVersion: ").append(toIndentedString(appVersion)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    endOfValidityDate: ").append(toIndentedString(endOfValidityDate)).append("\n");
    sb.append("    activationMode: ").append(toIndentedString(activationMode)).append("\n");
    sb.append("    eidasLevel: ").append(toIndentedString(eidasLevel)).append("\n");
    sb.append("    fitier: ").append(toIndentedString(fitier)).append("\n");
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

