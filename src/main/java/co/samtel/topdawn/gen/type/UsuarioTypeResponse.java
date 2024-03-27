package co.samtel.topdawn.gen.type;

import java.time.LocalDate;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("UsuarioTypeResponse")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-26T15:06:33.657130500-05:00[America/Bogota]")
public class UsuarioTypeResponse   {
  private @Valid String tipoTelefonoPrincipal;
  private @Valid String lastname;
  private @Valid LocalDate createat;

  /**
   **/
  public UsuarioTypeResponse tipoTelefonoPrincipal(String tipoTelefonoPrincipal) {
    this.tipoTelefonoPrincipal = tipoTelefonoPrincipal;
    return this;
  }

  
  @JsonProperty("tipoTelefonoPrincipal")
  public String getTipoTelefonoPrincipal() {
    return tipoTelefonoPrincipal;
  }

  @JsonProperty("tipoTelefonoPrincipal")
  public void setTipoTelefonoPrincipal(String tipoTelefonoPrincipal) {
    this.tipoTelefonoPrincipal = tipoTelefonoPrincipal;
  }

  /**
   **/
  public UsuarioTypeResponse lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  
  @JsonProperty("lastname")
  public String getLastname() {
    return lastname;
  }

  @JsonProperty("lastname")
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   **/
  public UsuarioTypeResponse createat(LocalDate createat) {
    this.createat = createat;
    return this;
  }

  
  @JsonProperty("createat")
  public LocalDate getCreateat() {
    return createat;
  }

  @JsonProperty("createat")
  public void setCreateat(LocalDate createat) {
    this.createat = createat;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsuarioTypeResponse usuarioTypeResponse = (UsuarioTypeResponse) o;
    return Objects.equals(this.tipoTelefonoPrincipal, usuarioTypeResponse.tipoTelefonoPrincipal) &&
        Objects.equals(this.lastname, usuarioTypeResponse.lastname) &&
        Objects.equals(this.createat, usuarioTypeResponse.createat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipoTelefonoPrincipal, lastname, createat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsuarioTypeResponse {\n");
    
    sb.append("    tipoTelefonoPrincipal: ").append(toIndentedString(tipoTelefonoPrincipal)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    createat: ").append(toIndentedString(createat)).append("\n");
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

