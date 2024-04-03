package io.quarkus.topdawn.controller.graphql;

import io.quarkus.topdawn.constant.Constans;
import io.quarkus.topdawn.dao.UsuarioDao;
import io.quarkus.topdawn.entity.UsuarioEntity;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import io.quarkus.topdawn.service.graphql.contract.IUsuarioService;
import io.quarkus.topdawn.service.rest.impl.UsuarioServiceImpl;
import io.quarkus.topdawn.utils.exception.ApplicationException;
import io.quarkus.topdawn.utils.mapper.UsuarioMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@GraphQLApi
public class UsuarioGraphqlController {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioGraphqlController.class);

    @Inject
    UsuarioServiceImpl usuarioServiceImpl;

    @Inject
    IUsuarioService iUsuarioService;

    @Inject
    UsuarioDao usuarioDao;

    @Inject
    UsuarioMapper usuarioMapper;

    @Query("allUser")
    public List<UsuarioEntity> listarTodo() {
        LOG.info("Se inicia Listar todos los usuario GrapqlController");
        try {
            List<UsuarioEntity> all = iUsuarioService.listarTodo();
            LOG.info("Se finaliza Listar todos los usuario GrapqlController");
            return all;
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " listarTodo");
            Object UsuarioEntity = null;
            return (List<io.quarkus.topdawn.entity.UsuarioEntity>) Response.status(Response.Status.BAD_REQUEST).entity(UsuarioEntity).build();
        }
    }

    @Mutation("crearUsuario")
    @Transactional
    public UsuarioTypeInput crearUsuario(@Name("account") UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Se inicia crearUsuario GrapqlController");
        UsuarioTypeInput usuarioType = null;
        try {
            usuarioType = iUsuarioService.crearUsuario(usuarioTypeInput);
            LOG.info("Se finaliza crearUsuario GrapqlController");
            return usuarioType;
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " crearUsuarioController");
            return usuarioType;
        }
    }

    @Mutation("actualizarUsuario")
    @Transactional
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Se inicia actualizarUsuarioPorId GrapqlController");
        UsuarioEntity entity = null;
        try {
            entity = iUsuarioService.actualizarUsuarioPorId(usuarioTypeInput);
            LOG.info("Se finaliza actualizarUsuarioPorId GrapqlController");
            return entity;
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " actualizarUsuarioPorId");
            return entity;
        }
    }


    @Mutation("borrarUsuario")
    @Transactional
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser) {
        LOG.info("Se inicia actualizarUsuarioPorId GrapqlController");
        UsuarioEntity usuario = null;
        try {
            usuario = iUsuarioService.borrarUsuarioPorId(idtblUser);
            LOG.info("Se finaliza actualizarUsuarioPorId GrapqlController");
            return usuario;
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " actualizarUsuarioPorId");
            return usuario;
        }
    }
}
