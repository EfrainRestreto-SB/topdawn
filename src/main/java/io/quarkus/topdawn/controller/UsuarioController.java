package io.quarkus.topdawn.controller;

import io.quarkus.topdawn.constant.Constans;
import io.quarkus.topdawn.entity.UsuarioEntity;
import io.quarkus.topdawn.gen.contract.V1UsuarioApi;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import io.quarkus.topdawn.service.rest.contract.IUsuarioService;
import io.quarkus.topdawn.utils.exception.ApplicationException;
import io.quarkus.topdawn.utils.validator.UsuarioValidator;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UsuarioController implements V1UsuarioApi {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioValidator usuarioValidator;

    @Inject
    IUsuarioService iUsuarioService;

    @Override
    public Response actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Se inicia actualizar usuario  en Controller");
        UsuarioEntity usuarioActualizado = null;
        try {
            usuarioActualizado = iUsuarioService.actualizarUsuarioPorId(usuarioTypeInput);
            LOG.info("Se finaliza actualizar usuario  en Controller");
            return Response.status(Response.Status.OK).entity(usuarioActualizado).build();
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " actualizarUsuarioPorIdController");
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarioActualizado).build();
        }
    }

    @Override
    public Response borrarUsuarioPorId(Integer idtblUser) {
        LOG.info("Se inicia buscar usuario por id en Controller");
        UsuarioEntity usuarioBorrado = null;
        try {
            usuarioBorrado = iUsuarioService.borrarUsuarioPorId(idtblUser);
            LOG.info("Se inicia buscar usuario por id en Controller");
            return Response.status(Response.Status.OK).entity(usuarioBorrado).build();
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " borrarUsuarioPorIdController");
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarioBorrado).build();
        }
    }

    @Override
    public Response buscarUsuarioPorId(Integer idtblUser) {
        LOG.info("Se inicia buscar usuario por id Controller");
        UsuarioEntity usuarioType = null;
        try {
            usuarioType = iUsuarioService.buscarUsuarioPorId(idtblUser);
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " buscarUsuarioPorIdController");
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarioType).build();
        }
        LOG.info("Se inicia buscar usuario por id Controller");
        return Response.status(Response.Status.OK).entity(usuarioType).build();
    }

    @Override
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

    @Override
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