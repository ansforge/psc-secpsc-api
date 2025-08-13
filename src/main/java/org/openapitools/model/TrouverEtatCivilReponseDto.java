package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.ReponsePSDto;
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
 * TrouverEtatCivilReponseDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class TrouverEtatCivilReponseDto {

  private @Nullable String code;

  private @Nullable String libelle;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime ts;

  @Valid
  private List<@Valid ReponsePSDto> reponsePS = new ArrayList<>();

  public TrouverEtatCivilReponseDto code(@Nullable String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   */
  
  @Schema(name = "code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public @Nullable String getCode() {
    return code;
  }

  public void setCode(@Nullable String code) {
    this.code = code;
  }

  public TrouverEtatCivilReponseDto libelle(@Nullable String libelle) {
    this.libelle = libelle;
    return this;
  }

  /**
   * Get libelle
   * @return libelle
   */
  
  @Schema(name = "libelle", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("libelle")
  public @Nullable String getLibelle() {
    return libelle;
  }

  public void setLibelle(@Nullable String libelle) {
    this.libelle = libelle;
  }

  public TrouverEtatCivilReponseDto ts(@Nullable OffsetDateTime ts) {
    this.ts = ts;
    return this;
  }

  /**
   * Get ts
   * @return ts
   */
  @Valid 
  @Schema(name = "ts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ts")
  public @Nullable OffsetDateTime getTs() {
    return ts;
  }

  public void setTs(@Nullable OffsetDateTime ts) {
    this.ts = ts;
  }

  public TrouverEtatCivilReponseDto reponsePS(List<@Valid ReponsePSDto> reponsePS) {
    this.reponsePS = reponsePS;
    return this;
  }

  public TrouverEtatCivilReponseDto addReponsePSItem(ReponsePSDto reponsePSItem) {
    if (this.reponsePS == null) {
      this.reponsePS = new ArrayList<>();
    }
    this.reponsePS.add(reponsePSItem);
    return this;
  }

  /**
   * Get reponsePS
   * @return reponsePS
   */
  @Valid 
  @Schema(name = "reponsePS", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reponsePS")
  public List<@Valid ReponsePSDto> getReponsePS() {
    return reponsePS;
  }

  public void setReponsePS(List<@Valid ReponsePSDto> reponsePS) {
    this.reponsePS = reponsePS;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrouverEtatCivilReponseDto trouverEtatCivilReponseDto = (TrouverEtatCivilReponseDto) o;
    return Objects.equals(this.code, trouverEtatCivilReponseDto.code) &&
        Objects.equals(this.libelle, trouverEtatCivilReponseDto.libelle) &&
        Objects.equals(this.ts, trouverEtatCivilReponseDto.ts) &&
        Objects.equals(this.reponsePS, trouverEtatCivilReponseDto.reponsePS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, libelle, ts, reponsePS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrouverEtatCivilReponseDto {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    libelle: ").append(toIndentedString(libelle)).append("\n");
    sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
    sb.append("    reponsePS: ").append(toIndentedString(reponsePS)).append("\n");
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

