package io.quarkus.topdawn.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("UsuarioTypeInput")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-04-03T08:25:53.849149100-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public class UsuarioTypeInput   {
  private @Valid Integer id;
  private @Valid String name;
  private @Valid String lastname;

  /**
   **/
  public UsuarioTypeInput id(Integer id) {
    this.id = id;
    return this;
  }

  
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  public UsuarioTypeInput name(String name) {
    this.name = name;
    return this;
  }

  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public UsuarioTypeInput lastname(String lastname) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsuarioTypeInput usuarioTypeInput = (UsuarioTypeInput) o;
    return Objects.equals(this.id, usuarioTypeInput.id) &&
        Objects.equals(this.name, usuarioTypeInput.name) &&
        Objects.equals(this.lastname, usuarioTypeInput.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsuarioTypeInput {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
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

