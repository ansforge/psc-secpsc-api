package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.ImagePSDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ImagesPSDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-11T14:56:49.312778+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class ImagesPSDto {

  private String idPP;

  private String code;

  private String libelle;

  private ImagePSDto imagePS;

  public ImagesPSDto idPP(String idPP) {
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

  public ImagesPSDto code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  
  @Schema(name = "code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ImagesPSDto libelle(String libelle) {
    this.libelle = libelle;
    return this;
  }

  /**
   * Get libelle
   * @return libelle
  */
  
  @Schema(name = "libelle", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("libelle")
  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public ImagesPSDto imagePS(ImagePSDto imagePS) {
    this.imagePS = imagePS;
    return this;
  }

  /**
   * Get imagePS
   * @return imagePS
  */
  @Valid 
  @Schema(name = "imagePS", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imagePS")
  public ImagePSDto getImagePS() {
    return imagePS;
  }

  public void setImagePS(ImagePSDto imagePS) {
    this.imagePS = imagePS;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImagesPSDto imagesPSDto = (ImagesPSDto) o;
    return Objects.equals(this.idPP, imagesPSDto.idPP) &&
        Objects.equals(this.code, imagesPSDto.code) &&
        Objects.equals(this.libelle, imagesPSDto.libelle) &&
        Objects.equals(this.imagePS, imagesPSDto.imagePS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPP, code, libelle, imagePS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImagesPSDto {\n");
    sb.append("    idPP: ").append(toIndentedString(idPP)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    libelle: ").append(toIndentedString(libelle)).append("\n");
    sb.append("    imagePS: ").append(toIndentedString(imagePS)).append("\n");
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

