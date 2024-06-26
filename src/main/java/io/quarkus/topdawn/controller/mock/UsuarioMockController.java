package io.quarkus.topdawn.controller.mock;

import io.quarkus.topdawn.constant.Constans;
import io.quarkus.topdawn.entity.UsuarioEntity;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import io.quarkus.topdawn.service.mock.contract.IUsuarioMockService;

import io.quarkus.topdawn.utils.exception.ApplicationException;

import io.quarkus.topdawn.utils.validator.UsuarioValidator;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/v1")
public class UsuarioMockController {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioMockController.class);

    @Inject
    UsuarioValidator usuarioValidator;

    @Inject
    IUsuarioMockService iUsuarioService;
    @POST
    @Path("/usuarioMock")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Se inicia crear usuario Controller");
        usuarioValidator.verificarUsuarioTypeInput(usuarioTypeInput);
        UsuarioEntity usuarioResponse = null;
        try {
            usuarioResponse = iUsuarioService.crearUsuario(usuarioTypeInput);
            LOG.info("Finaliza crear usuario Controller");
            return Response.status(Response.Status.CREATED).entity(usuarioResponse).build();
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " crearUsuarioController");
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarioResponse).build();
        }
    }

    @GET
    @Path("/listar")
    @Produces({ "application/json" })
    public Response listarUsuarios() {
        LOG.info("Se inicia listar usuario Controller");
        List<UsuarioEntity> usuarios = null;
        try {
            usuarios = iUsuarioService.listarUsuarios();
            return Response.status(200).entity(usuarios).build();
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " listarUsuariosController");
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarios).build();
        }
    }
}
