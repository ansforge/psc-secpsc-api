package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * EtatCivilDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class EtatCivilDto {

  private String idPP;

  private String nomFamille;

  private String prenom1;

  private String prenom2;

  private String prenom3;

  private String sexe;

  private String dateNaissance;

  private String paysNaissance;

  private String communeNaissance;

  private String departementNaissance;

  @Valid
  private List<String> adeli = new ArrayList<>();

  public EtatCivilDto idPP(String idPP) {
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

  public EtatCivilDto nomFamille(String nomFamille) {
    this.nomFamille = nomFamille;
    return this;
  }

  /**
   * Get nomFamille
   * @return nomFamille
  */
  
  @Schema(name = "nomFamille", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nomFamille")
  public String getNomFamille() {
    return nomFamille;
  }

  public void setNomFamille(String nomFamille) {
    this.nomFamille = nomFamille;
  }

  public EtatCivilDto prenom1(String prenom1) {
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

  public EtatCivilDto prenom2(String prenom2) {
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

  public EtatCivilDto prenom3(String prenom3) {
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

  public EtatCivilDto sexe(String sexe) {
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

  public EtatCivilDto dateNaissance(String dateNaissance) {
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

  public EtatCivilDto paysNaissance(String paysNaissance) {
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

  public EtatCivilDto communeNaissance(String communeNaissance) {
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

  public EtatCivilDto departementNaissance(String departementNaissance) {
    this.departementNaissance = departementNaissance;
    return this;
  }

  /**
   * Get departementNaissance
   * @return departementNaissance
  */
  
  @Schema(name = "departementNaissance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("departementNaissance")
  public String getDepartementNaissance() {
    return departementNaissance;
  }

  public void setDepartementNaissance(String departementNaissance) {
    this.departementNaissance = departementNaissance;
  }

  public EtatCivilDto adeli(List<String> adeli) {
    this.adeli = adeli;
    return this;
  }

  public EtatCivilDto addAdeliItem(String adeliItem) {
    if (this.adeli == null) {
      this.adeli = new ArrayList<>();
    }
    this.adeli.add(adeliItem);
    return this;
  }

  /**
   * Get adeli
   * @return adeli
  */
  
  @Schema(name = "adeli", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("adeli")
  public List<String> getAdeli() {
    return adeli;
  }

  public void setAdeli(List<String> adeli) {
    this.adeli = adeli;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EtatCivilDto etatCivilDto = (EtatCivilDto) o;
    return Objects.equals(this.idPP, etatCivilDto.idPP) &&
        Objects.equals(this.nomFamille, etatCivilDto.nomFamille) &&
        Objects.equals(this.prenom1, etatCivilDto.prenom1) &&
        Objects.equals(this.prenom2, etatCivilDto.prenom2) &&
        Objects.equals(this.prenom3, etatCivilDto.prenom3) &&
        Objects.equals(this.sexe, etatCivilDto.sexe) &&
        Objects.equals(this.dateNaissance, etatCivilDto.dateNaissance) &&
        Objects.equals(this.paysNaissance, etatCivilDto.paysNaissance) &&
        Objects.equals(this.communeNaissance, etatCivilDto.communeNaissance) &&
        Objects.equals(this.departementNaissance, etatCivilDto.departementNaissance) &&
        Objects.equals(this.adeli, etatCivilDto.adeli);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPP, nomFamille, prenom1, prenom2, prenom3, sexe, dateNaissance, paysNaissance, communeNaissance, departementNaissance, adeli);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EtatCivilDto {\n");
    sb.append("    idPP: ").append(toIndentedString(idPP)).append("\n");
    sb.append("    nomFamille: ").append(toIndentedString(nomFamille)).append("\n");
    sb.append("    prenom1: ").append(toIndentedString(prenom1)).append("\n");
    sb.append("    prenom2: ").append(toIndentedString(prenom2)).append("\n");
    sb.append("    prenom3: ").append(toIndentedString(prenom3)).append("\n");
    sb.append("    sexe: ").append(toIndentedString(sexe)).append("\n");
    sb.append("    dateNaissance: ").append(toIndentedString(dateNaissance)).append("\n");
    sb.append("    paysNaissance: ").append(toIndentedString(paysNaissance)).append("\n");
    sb.append("    communeNaissance: ").append(toIndentedString(communeNaissance)).append("\n");
    sb.append("    departementNaissance: ").append(toIndentedString(departementNaissance)).append("\n");
    sb.append("    adeli: ").append(toIndentedString(adeli)).append("\n");
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

