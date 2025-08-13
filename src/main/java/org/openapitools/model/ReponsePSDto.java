package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.EtatCivilDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ReponsePSDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class ReponsePSDto {

  private String code;

  private String libelle;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime ts;

  @Valid
  private List<@Valid EtatCivilDto> reponseEtatCivil = new ArrayList<>();

  public ReponsePSDto code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  
  @Schema(name = "code", required = false, description = "")
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ReponsePSDto libelle(String libelle) {
    this.libelle = libelle;
    return this;
  }

  /**
   * Get libelle
   * @return libelle
  */
  
  @Schema(name = "libelle", required = false, description = "")
  @JsonProperty("libelle")
  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public ReponsePSDto ts(OffsetDateTime ts) {
    this.ts = ts;
    return this;
  }

  /**
   * Get ts
   * @return ts
  */
  @Valid 
  @Schema(name = "ts", required = false, description = "")
  @JsonProperty("ts")
  public OffsetDateTime getTs() {
    return ts;
  }

  public void setTs(OffsetDateTime ts) {
    this.ts = ts;
  }

  public ReponsePSDto reponseEtatCivil(List<@Valid EtatCivilDto> reponseEtatCivil) {
    this.reponseEtatCivil = reponseEtatCivil;
    return this;
  }

  public ReponsePSDto addReponseEtatCivilItem(EtatCivilDto reponseEtatCivilItem) {
    if (this.reponseEtatCivil == null) {
      this.reponseEtatCivil = new ArrayList<>();
    }
    this.reponseEtatCivil.add(reponseEtatCivilItem);
    return this;
  }

  /**
   * Get reponseEtatCivil
   * @return reponseEtatCivil
  */
  @Valid 
  @Schema(name = "reponseEtatCivil", required = false, description = "")
  @JsonProperty("reponseEtatCivil")
  public List<@Valid EtatCivilDto> getReponseEtatCivil() {
    return reponseEtatCivil;
  }

  public void setReponseEtatCivil(List<@Valid EtatCivilDto> reponseEtatCivil) {
    this.reponseEtatCivil = reponseEtatCivil;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReponsePSDto reponsePSDto = (ReponsePSDto) o;
    return Objects.equals(this.code, reponsePSDto.code) &&
        Objects.equals(this.libelle, reponsePSDto.libelle) &&
        Objects.equals(this.ts, reponsePSDto.ts) &&
        Objects.equals(this.reponseEtatCivil, reponsePSDto.reponseEtatCivil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, libelle, ts, reponseEtatCivil);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReponsePSDto {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    libelle: ").append(toIndentedString(libelle)).append("\n");
    sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
    sb.append("    reponseEtatCivil: ").append(toIndentedString(reponseEtatCivil)).append("\n");
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

