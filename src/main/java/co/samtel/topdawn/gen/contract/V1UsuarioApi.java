package co.samtel.topdawn.gen.contract;

import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.gen.type.UsuarioTypeResponse;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-19T17:32:00.251970400-05:00[America/Bogota]")
public interface V1UsuarioApi {

    @PUT
    @Path("/actualizarUsuarioPorId")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response actualizarUsuarioPorId(@Valid UsuarioTypeInput usuarioTypeInput);

    @GET
    @Path("/borrarUsuarioPorId/{idtbl_user}")
    @Produces({ "application/json" })
    Response borrarUsuarioPorId(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @GET
    @Path("/buscarUsuarioPorId/{idtbl_user}")
    @Produces({ "application/json" })
    Response buscarUsuarioPorId(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @POST
    @Path("/usuario")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearUsuario(@Valid UsuarioTypeInput usuarioTypeInput);
}
