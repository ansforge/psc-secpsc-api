package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.CoordonneeDto;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ProfessionnelDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class ProfessionnelDto {

  private @Nullable String idPP;

  private @Nullable String prenomUsage;

  private @Nullable String nomUsage;

  private @Nullable String civilite;

  private @Nullable String dateAcquisitionNatFR;

  private @Nullable String paysNationalite;

  private @Nullable String prenom1;

  private @Nullable String prenom2;

  private @Nullable String prenom3;

  private @Nullable String dateNaissance;

  private @Nullable String communeNaissance;

  private @Nullable String lieuNaissance;

  private @Nullable String paysNaissance;

  private @Nullable String sexe;

  private @Nullable String dateDeces;

  private @Nullable String statutEtatCivil;

  private @Nullable String dateStatutEtatCivil;

  private @Nullable CoordonneeDto coordonneesCorrespondance;

  public ProfessionnelDto idPP(@Nullable String idPP) {
    this.idPP = idPP;
    return this;
  }

  /**
   * Get idPP
   * @return idPP
   */
  
  @Schema(name = "idPP", required = false, description = "")
  @JsonProperty("idPP")
  public @Nullable String getIdPP() {
    return idPP;
  }

  public void setIdPP(@Nullable String idPP) {
    this.idPP = idPP;
  }

  public ProfessionnelDto prenomUsage(@Nullable String prenomUsage) {
    this.prenomUsage = prenomUsage;
    return this;
  }

  /**
   * Get prenomUsage
   * @return prenomUsage
   */
  
  @Schema(name = "prenomUsage", required = false, description = "")
  @JsonProperty("prenomUsage")
  public @Nullable String getPrenomUsage() {
    return prenomUsage;
  }

  public void setPrenomUsage(@Nullable String prenomUsage) {
    this.prenomUsage = prenomUsage;
  }

  public ProfessionnelDto nomUsage(@Nullable String nomUsage) {
    this.nomUsage = nomUsage;
    return this;
  }

  /**
   * Get nomUsage
   * @return nomUsage
   */
  
  @Schema(name = "nomUsage", required = false, description = "")
  @JsonProperty("nomUsage")
  public @Nullable String getNomUsage() {
    return nomUsage;
  }

  public void setNomUsage(@Nullable String nomUsage) {
    this.nomUsage = nomUsage;
  }

  public ProfessionnelDto civilite(@Nullable String civilite) {
    this.civilite = civilite;
    return this;
  }

  /**
   * Get civilite
   * @return civilite
   */
  
  @Schema(name = "civilite", required = false, description = "")
  @JsonProperty("civilite")
  public @Nullable String getCivilite() {
    return civilite;
  }

  public void setCivilite(@Nullable String civilite) {
    this.civilite = civilite;
  }

  public ProfessionnelDto dateAcquisitionNatFR(@Nullable String dateAcquisitionNatFR) {
    this.dateAcquisitionNatFR = dateAcquisitionNatFR;
    return this;
  }

  /**
   * Get dateAcquisitionNatFR
   * @return dateAcquisitionNatFR
   */
  
  @Schema(name = "dateAcquisitionNatFR", required = false, description = "")
  @JsonProperty("dateAcquisitionNatFR")
  public @Nullable String getDateAcquisitionNatFR() {
    return dateAcquisitionNatFR;
  }

  public void setDateAcquisitionNatFR(@Nullable String dateAcquisitionNatFR) {
    this.dateAcquisitionNatFR = dateAcquisitionNatFR;
  }

  public ProfessionnelDto paysNationalite(@Nullable String paysNationalite) {
    this.paysNationalite = paysNationalite;
    return this;
  }

  /**
   * Get paysNationalite
   * @return paysNationalite
   */
  
  @Schema(name = "paysNationalite", required = false, description = "")
  @JsonProperty("paysNationalite")
  public @Nullable String getPaysNationalite() {
    return paysNationalite;
  }

  public void setPaysNationalite(@Nullable String paysNationalite) {
    this.paysNationalite = paysNationalite;
  }

  public ProfessionnelDto prenom1(@Nullable String prenom1) {
    this.prenom1 = prenom1;
    return this;
  }

  /**
   * Get prenom1
   * @return prenom1
   */
  
  @Schema(name = "prenom1", required = false, description = "")
  @JsonProperty("prenom1")
  public @Nullable String getPrenom1() {
    return prenom1;
  }

  public void setPrenom1(@Nullable String prenom1) {
    this.prenom1 = prenom1;
  }

  public ProfessionnelDto prenom2(@Nullable String prenom2) {
    this.prenom2 = prenom2;
    return this;
  }

  /**
   * Get prenom2
   * @return prenom2
   */
  
  @Schema(name = "prenom2", required = false, description = "")
  @JsonProperty("prenom2")
  public @Nullable String getPrenom2() {
    return prenom2;
  }

  public void setPrenom2(@Nullable String prenom2) {
    this.prenom2 = prenom2;
  }

  public ProfessionnelDto prenom3(@Nullable String prenom3) {
    this.prenom3 = prenom3;
    return this;
  }

  /**
   * Get prenom3
   * @return prenom3
   */
  
  @Schema(name = "prenom3", required = false, description = "")
  @JsonProperty("prenom3")
  public @Nullable String getPrenom3() {
    return prenom3;
  }

  public void setPrenom3(@Nullable String prenom3) {
    this.prenom3 = prenom3;
  }

  public ProfessionnelDto dateNaissance(@Nullable String dateNaissance) {
    this.dateNaissance = dateNaissance;
    return this;
  }

  /**
   * Get dateNaissance
   * @return dateNaissance
   */
  
  @Schema(name = "dateNaissance", required = false, description = "")
  @JsonProperty("dateNaissance")
  public @Nullable String getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(@Nullable String dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public ProfessionnelDto communeNaissance(@Nullable String communeNaissance) {
    this.communeNaissance = communeNaissance;
    return this;
  }

  /**
   * Get communeNaissance
   * @return communeNaissance
   */
  
  @Schema(name = "communeNaissance", required = false, description = "")
  @JsonProperty("communeNaissance")
  public @Nullable String getCommuneNaissance() {
    return communeNaissance;
  }

  public void setCommuneNaissance(@Nullable String communeNaissance) {
    this.communeNaissance = communeNaissance;
  }

  public ProfessionnelDto lieuNaissance(@Nullable String lieuNaissance) {
    this.lieuNaissance = lieuNaissance;
    return this;
  }

  /**
   * Get lieuNaissance
   * @return lieuNaissance
   */
  
  @Schema(name = "lieuNaissance", required = false, description = "")
  @JsonProperty("lieuNaissance")
  public @Nullable String getLieuNaissance() {
    return lieuNaissance;
  }

  public void setLieuNaissance(@Nullable String lieuNaissance) {
    this.lieuNaissance = lieuNaissance;
  }

  public ProfessionnelDto paysNaissance(@Nullable String paysNaissance) {
    this.paysNaissance = paysNaissance;
    return this;
  }

  /**
   * Get paysNaissance
   * @return paysNaissance
   */
  
  @Schema(name = "paysNaissance", required = false, description = "")
  @JsonProperty("paysNaissance")
  public @Nullable String getPaysNaissance() {
    return paysNaissance;
  }

  public void setPaysNaissance(@Nullable String paysNaissance) {
    this.paysNaissance = paysNaissance;
  }

  public ProfessionnelDto sexe(@Nullable String sexe) {
    this.sexe = sexe;
    return this;
  }

  /**
   * Get sexe
   * @return sexe
   */
  
  @Schema(name = "sexe", required = false, description = "")
  @JsonProperty("sexe")
  public @Nullable String getSexe() {
    return sexe;
  }

  public void setSexe(@Nullable String sexe) {
    this.sexe = sexe;
  }

  public ProfessionnelDto dateDeces(@Nullable String dateDeces) {
    this.dateDeces = dateDeces;
    return this;
  }

  /**
   * Get dateDeces
   * @return dateDeces
   */
  
  @Schema(name = "dateDeces", required = false, description = "")
  @JsonProperty("dateDeces")
  public @Nullable String getDateDeces() {
    return dateDeces;
  }

  public void setDateDeces(@Nullable String dateDeces) {
    this.dateDeces = dateDeces;
  }

  public ProfessionnelDto statutEtatCivil(@Nullable String statutEtatCivil) {
    this.statutEtatCivil = statutEtatCivil;
    return this;
  }

  /**
   * Get statutEtatCivil
   * @return statutEtatCivil
   */
  
  @Schema(name = "statutEtatCivil", required = false, description = "")
  @JsonProperty("statutEtatCivil")
  public @Nullable String getStatutEtatCivil() {
    return statutEtatCivil;
  }

  public void setStatutEtatCivil(@Nullable String statutEtatCivil) {
    this.statutEtatCivil = statutEtatCivil;
  }

  public ProfessionnelDto dateStatutEtatCivil(@Nullable String dateStatutEtatCivil) {
    this.dateStatutEtatCivil = dateStatutEtatCivil;
    return this;
  }

  /**
   * Get dateStatutEtatCivil
   * @return dateStatutEtatCivil
   */
  
  @Schema(name = "dateStatutEtatCivil", required = false, description = "")
  @JsonProperty("dateStatutEtatCivil")
  public @Nullable String getDateStatutEtatCivil() {
    return dateStatutEtatCivil;
  }

  public void setDateStatutEtatCivil(@Nullable String dateStatutEtatCivil) {
    this.dateStatutEtatCivil = dateStatutEtatCivil;
  }

  public ProfessionnelDto coordonneesCorrespondance(@Nullable CoordonneeDto coordonneesCorrespondance) {
    this.coordonneesCorrespondance = coordonneesCorrespondance;
    return this;
  }

  /**
   * Get coordonneesCorrespondance
   * @return coordonneesCorrespondance
   */
  @Valid 
  @Schema(name = "coordonneesCorrespondance", required = false, description = "")
  @JsonProperty("coordonneesCorrespondance")
  public @Nullable CoordonneeDto getCoordonneesCorrespondance() {
    return coordonneesCorrespondance;
  }

  public void setCoordonneesCorrespondance(@Nullable CoordonneeDto coordonneesCorrespondance) {
    this.coordonneesCorrespondance = coordonneesCorrespondance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfessionnelDto professionnelDto = (ProfessionnelDto) o;
    return Objects.equals(this.idPP, professionnelDto.idPP) &&
        Objects.equals(this.prenomUsage, professionnelDto.prenomUsage) &&
        Objects.equals(this.nomUsage, professionnelDto.nomUsage) &&
        Objects.equals(this.civilite, professionnelDto.civilite) &&
        Objects.equals(this.dateAcquisitionNatFR, professionnelDto.dateAcquisitionNatFR) &&
        Objects.equals(this.paysNationalite, professionnelDto.paysNationalite) &&
        Objects.equals(this.prenom1, professionnelDto.prenom1) &&
        Objects.equals(this.prenom2, professionnelDto.prenom2) &&
        Objects.equals(this.prenom3, professionnelDto.prenom3) &&
        Objects.equals(this.dateNaissance, professionnelDto.dateNaissance) &&
        Objects.equals(this.communeNaissance, professionnelDto.communeNaissance) &&
        Objects.equals(this.lieuNaissance, professionnelDto.lieuNaissance) &&
        Objects.equals(this.paysNaissance, professionnelDto.paysNaissance) &&
        Objects.equals(this.sexe, professionnelDto.sexe) &&
        Objects.equals(this.dateDeces, professionnelDto.dateDeces) &&
        Objects.equals(this.statutEtatCivil, professionnelDto.statutEtatCivil) &&
        Objects.equals(this.dateStatutEtatCivil, professionnelDto.dateStatutEtatCivil) &&
        Objects.equals(this.coordonneesCorrespondance, professionnelDto.coordonneesCorrespondance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPP, prenomUsage, nomUsage, civilite, dateAcquisitionNatFR, paysNationalite, prenom1, prenom2, prenom3, dateNaissance, communeNaissance, lieuNaissance, paysNaissance, sexe, dateDeces, statutEtatCivil, dateStatutEtatCivil, coordonneesCorrespondance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfessionnelDto {\n");
    sb.append("    idPP: ").append(toIndentedString(idPP)).append("\n");
    sb.append("    prenomUsage: ").append(toIndentedString(prenomUsage)).append("\n");
    sb.append("    nomUsage: ").append(toIndentedString(nomUsage)).append("\n");
    sb.append("    civilite: ").append(toIndentedString(civilite)).append("\n");
    sb.append("    dateAcquisitionNatFR: ").append(toIndentedString(dateAcquisitionNatFR)).append("\n");
    sb.append("    paysNationalite: ").append(toIndentedString(paysNationalite)).append("\n");
    sb.append("    prenom1: ").append(toIndentedString(prenom1)).append("\n");
    sb.append("    prenom2: ").append(toIndentedString(prenom2)).append("\n");
    sb.append("    prenom3: ").append(toIndentedString(prenom3)).append("\n");
    sb.append("    dateNaissance: ").append(toIndentedString(dateNaissance)).append("\n");
    sb.append("    communeNaissance: ").append(toIndentedString(communeNaissance)).append("\n");
    sb.append("    lieuNaissance: ").append(toIndentedString(lieuNaissance)).append("\n");
    sb.append("    paysNaissance: ").append(toIndentedString(paysNaissance)).append("\n");
    sb.append("    sexe: ").append(toIndentedString(sexe)).append("\n");
    sb.append("    dateDeces: ").append(toIndentedString(dateDeces)).append("\n");
    sb.append("    statutEtatCivil: ").append(toIndentedString(statutEtatCivil)).append("\n");
    sb.append("    dateStatutEtatCivil: ").append(toIndentedString(dateStatutEtatCivil)).append("\n");
    sb.append("    coordonneesCorrespondance: ").append(toIndentedString(coordonneesCorrespondance)).append("\n");
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

