package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.CoordonneeDto;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class ProfessionnelDto {

  private String idPP;

  private String prenomUsage;

  private String nomUsage;

  private String civilite;

  private String dateAcquisitionNatFR;

  private String paysNationalite;

  private String prenom1;

  private String prenom2;

  private String prenom3;

  private String dateNaissance;

  private String communeNaissance;

  private String lieuNaissance;

  private String paysNaissance;

  private String sexe;

  private String dateDeces;

  private String statutEtatCivil;

  private String dateStatutEtatCivil;

  private CoordonneeDto coordonneesCorrespondance;

  public ProfessionnelDto idPP(String idPP) {
    this.idPP = idPP;
    return this;
  }

  /**
   * Get idPP
   * @return idPP
  */
  
  @Schema(name = "idPP", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idPP")
  public String getIdPP() {
    return idPP;
  }

  public void setIdPP(String idPP) {
    this.idPP = idPP;
  }

  public ProfessionnelDto prenomUsage(String prenomUsage) {
    this.prenomUsage = prenomUsage;
    return this;
  }

  /**
   * Get prenomUsage
   * @return prenomUsage
  */
  
  @Schema(name = "prenomUsage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prenomUsage")
  public String getPrenomUsage() {
    return prenomUsage;
  }

  public void setPrenomUsage(String prenomUsage) {
    this.prenomUsage = prenomUsage;
  }

  public ProfessionnelDto nomUsage(String nomUsage) {
    this.nomUsage = nomUsage;
    return this;
  }

  /**
   * Get nomUsage
   * @return nomUsage
  */
  
  @Schema(name = "nomUsage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nomUsage")
  public String getNomUsage() {
    return nomUsage;
  }

  public void setNomUsage(String nomUsage) {
    this.nomUsage = nomUsage;
  }

  public ProfessionnelDto civilite(String civilite) {
    this.civilite = civilite;
    return this;
  }

  /**
   * Get civilite
   * @return civilite
  */
  
  @Schema(name = "civilite", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("civilite")
  public String getCivilite() {
    return civilite;
  }

  public void setCivilite(String civilite) {
    this.civilite = civilite;
  }

  public ProfessionnelDto dateAcquisitionNatFR(String dateAcquisitionNatFR) {
    this.dateAcquisitionNatFR = dateAcquisitionNatFR;
    return this;
  }

  /**
   * Get dateAcquisitionNatFR
   * @return dateAcquisitionNatFR
  */
  
  @Schema(name = "dateAcquisitionNatFR", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateAcquisitionNatFR")
  public String getDateAcquisitionNatFR() {
    return dateAcquisitionNatFR;
  }

  public void setDateAcquisitionNatFR(String dateAcquisitionNatFR) {
    this.dateAcquisitionNatFR = dateAcquisitionNatFR;
  }

  public ProfessionnelDto paysNationalite(String paysNationalite) {
    this.paysNationalite = paysNationalite;
    return this;
  }

  /**
   * Get paysNationalite
   * @return paysNationalite
  */
  
  @Schema(name = "paysNationalite", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("paysNationalite")
  public String getPaysNationalite() {
    return paysNationalite;
  }

  public void setPaysNationalite(String paysNationalite) {
    this.paysNationalite = paysNationalite;
  }

  public ProfessionnelDto prenom1(String prenom1) {
    this.prenom1 = prenom1;
    return this;
  }

  /**
   * Get prenom1
   * @return prenom1
  */
  
  @Schema(name = "prenom1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prenom1")
  public String getPrenom1() {
    return prenom1;
  }

  public void setPrenom1(String prenom1) {
    this.prenom1 = prenom1;
  }

  public ProfessionnelDto prenom2(String prenom2) {
    this.prenom2 = prenom2;
    return this;
  }

  /**
   * Get prenom2
   * @return prenom2
  */
  
  @Schema(name = "prenom2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prenom2")
  public String getPrenom2() {
    return prenom2;
  }

  public void setPrenom2(String prenom2) {
    this.prenom2 = prenom2;
  }

  public ProfessionnelDto prenom3(String prenom3) {
    this.prenom3 = prenom3;
    return this;
  }

  /**
   * Get prenom3
   * @return prenom3
  */
  
  @Schema(name = "prenom3", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prenom3")
  public String getPrenom3() {
    return prenom3;
  }

  public void setPrenom3(String prenom3) {
    this.prenom3 = prenom3;
  }

  public ProfessionnelDto dateNaissance(String dateNaissance) {
    this.dateNaissance = dateNaissance;
    return this;
  }

  /**
   * Get dateNaissance
   * @return dateNaissance
  */
  
  @Schema(name = "dateNaissance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateNaissance")
  public String getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(String dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public ProfessionnelDto communeNaissance(String communeNaissance) {
    this.communeNaissance = communeNaissance;
    return this;
  }

  /**
   * Get communeNaissance
   * @return communeNaissance
  */
  
  @Schema(name = "communeNaissance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("communeNaissance")
  public String getCommuneNaissance() {
    return communeNaissance;
  }

  public void setCommuneNaissance(String communeNaissance) {
    this.communeNaissance = communeNaissance;
  }

  public ProfessionnelDto lieuNaissance(String lieuNaissance) {
    this.lieuNaissance = lieuNaissance;
    return this;
  }

  /**
   * Get lieuNaissance
   * @return lieuNaissance
  */
  
  @Schema(name = "lieuNaissance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lieuNaissance")
  public String getLieuNaissance() {
    return lieuNaissance;
  }

  public void setLieuNaissance(String lieuNaissance) {
    this.lieuNaissance = lieuNaissance;
  }

  public ProfessionnelDto paysNaissance(String paysNaissance) {
    this.paysNaissance = paysNaissance;
    return this;
  }

  /**
   * Get paysNaissance
   * @return paysNaissance
  */
  
  @Schema(name = "paysNaissance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("paysNaissance")
  public String getPaysNaissance() {
    return paysNaissance;
  }

  public void setPaysNaissance(String paysNaissance) {
    this.paysNaissance = paysNaissance;
  }

  public ProfessionnelDto sexe(String sexe) {
    this.sexe = sexe;
    return this;
  }

  /**
   * Get sexe
   * @return sexe
  */
  
  @Schema(name = "sexe", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sexe")
  public String getSexe() {
    return sexe;
  }

  public void setSexe(String sexe) {
    this.sexe = sexe;
  }

  public ProfessionnelDto dateDeces(String dateDeces) {
    this.dateDeces = dateDeces;
    return this;
  }

  /**
   * Get dateDeces
   * @return dateDeces
  */
  
  @Schema(name = "dateDeces", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateDeces")
  public String getDateDeces() {
    return dateDeces;
  }

  public void setDateDeces(String dateDeces) {
    this.dateDeces = dateDeces;
  }

  public ProfessionnelDto statutEtatCivil(String statutEtatCivil) {
    this.statutEtatCivil = statutEtatCivil;
    return this;
  }

  /**
   * Get statutEtatCivil
   * @return statutEtatCivil
  */
  
  @Schema(name = "statutEtatCivil", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statutEtatCivil")
  public String getStatutEtatCivil() {
    return statutEtatCivil;
  }

  public void setStatutEtatCivil(String statutEtatCivil) {
    this.statutEtatCivil = statutEtatCivil;
  }

  public ProfessionnelDto dateStatutEtatCivil(String dateStatutEtatCivil) {
    this.dateStatutEtatCivil = dateStatutEtatCivil;
    return this;
  }

  /**
   * Get dateStatutEtatCivil
   * @return dateStatutEtatCivil
  */
  
  @Schema(name = "dateStatutEtatCivil", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dateStatutEtatCivil")
  public String getDateStatutEtatCivil() {
    return dateStatutEtatCivil;
  }

  public void setDateStatutEtatCivil(String dateStatutEtatCivil) {
    this.dateStatutEtatCivil = dateStatutEtatCivil;
  }

  public ProfessionnelDto coordonneesCorrespondance(CoordonneeDto coordonneesCorrespondance) {
    this.coordonneesCorrespondance = coordonneesCorrespondance;
    return this;
  }

  /**
   * Get coordonneesCorrespondance
   * @return coordonneesCorrespondance
  */
  @Valid 
  @Schema(name = "coordonneesCorrespondance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("coordonneesCorrespondance")
  public CoordonneeDto getCoordonneesCorrespondance() {
    return coordonneesCorrespondance;
  }

  public void setCoordonneesCorrespondance(CoordonneeDto coordonneesCorrespondance) {
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

