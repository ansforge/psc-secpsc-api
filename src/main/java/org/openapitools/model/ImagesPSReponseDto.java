package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.ImagesPSDto;
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
 * ImagesPSReponseDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class ImagesPSReponseDto {

  private @Nullable String code;

  private @Nullable String libelle;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime ts;

  @Valid
  private List<@Valid ImagesPSDto> reponseImagesPS = new ArrayList<>();

  public ImagesPSReponseDto code(@Nullable String code) {
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

  public ImagesPSReponseDto libelle(@Nullable String libelle) {
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

  public ImagesPSReponseDto ts(@Nullable OffsetDateTime ts) {
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

  public ImagesPSReponseDto reponseImagesPS(List<@Valid ImagesPSDto> reponseImagesPS) {
    this.reponseImagesPS = reponseImagesPS;
    return this;
  }

  public ImagesPSReponseDto addReponseImagesPSItem(ImagesPSDto reponseImagesPSItem) {
    if (this.reponseImagesPS == null) {
      this.reponseImagesPS = new ArrayList<>();
    }
    this.reponseImagesPS.add(reponseImagesPSItem);
    return this;
  }

  /**
   * Get reponseImagesPS
   * @return reponseImagesPS
   */
  @Valid 
  @Schema(name = "reponseImagesPS", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reponseImagesPS")
  public List<@Valid ImagesPSDto> getReponseImagesPS() {
    return reponseImagesPS;
  }

  public void setReponseImagesPS(List<@Valid ImagesPSDto> reponseImagesPS) {
    this.reponseImagesPS = reponseImagesPS;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImagesPSReponseDto imagesPSReponseDto = (ImagesPSReponseDto) o;
    return Objects.equals(this.code, imagesPSReponseDto.code) &&
        Objects.equals(this.libelle, imagesPSReponseDto.libelle) &&
        Objects.equals(this.ts, imagesPSReponseDto.ts) &&
        Objects.equals(this.reponseImagesPS, imagesPSReponseDto.reponseImagesPS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, libelle, ts, reponseImagesPS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImagesPSReponseDto {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    libelle: ").append(toIndentedString(libelle)).append("\n");
    sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
    sb.append("    reponseImagesPS: ").append(toIndentedString(reponseImagesPS)).append("\n");
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

