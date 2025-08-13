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
 * ContactInfoDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-13T15:21:27.382698+02:00[Europe/Paris]", comments = "Generator version: 7.14.0")
public class ContactInfoDto {

  private @Nullable String email;

  private @Nullable String phone;

  public ContactInfoDto email(@Nullable String email) {
    this.email = email;
    return this;
  }

  /**
   * L'utilisateur a déjà vérifié son adresse e-mail avec PSI.
   * @return email
   */
  
  @Schema(name = "email", description = "L'utilisateur a déjà vérifié son adresse e-mail avec PSI.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public @Nullable String getEmail() {
    return email;
  }

  public void setEmail(@Nullable String email) {
    this.email = email;
  }

  public ContactInfoDto phone(@Nullable String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * L'utilisateur a déjà vérifié son numéro de téléphone avec PSI.
   * @return phone
   */
  
  @Schema(name = "phone", description = "L'utilisateur a déjà vérifié son numéro de téléphone avec PSI.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phone")
  public @Nullable String getPhone() {
    return phone;
  }

  public void setPhone(@Nullable String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfoDto contactInfoDto = (ContactInfoDto) o;
    return Objects.equals(this.email, contactInfoDto.email) &&
        Objects.equals(this.phone, contactInfoDto.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactInfoDto {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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

