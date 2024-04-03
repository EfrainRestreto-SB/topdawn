package io.quarkus.topdawn.service.graphql.impl;

import io.quarkus.topdawn.constant.Constans;
import io.quarkus.topdawn.dao.UsuarioDao;
import io.quarkus.topdawn.entity.UsuarioEntity;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import io.quarkus.topdawn.service.graphql.contract.IUsuarioService;
import io.quarkus.topdawn.utils.exception.ApplicationException;
import io.quarkus.topdawn.utils.mapper.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class UsuarioServiceImpl implements IUsuarioService {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    @Inject
    UsuarioDao usuarioDao;

    @Inject
    UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioEntity> listarTodo() {
        LOG.info("Se inicia Listar todos los usuario GrapqlController");
        try{
            List<UsuarioEntity> all = usuarioDao.listAll();
            return  all;
        }catch (ApplicationException e){
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " crearUsuarioController");
            Object UsuarioEntity = null;
            return (List<io.quarkus.topdawn.entity.UsuarioEntity>) Response.status(Response.Status.BAD_REQUEST).entity(UsuarioEntity).build();
        }
    }

    @Override
    public UsuarioTypeInput crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity entity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        usuarioDao.persist(entity);
        UsuarioTypeInput UsuarioType = usuarioMapper.usuarioEntityToType(entity);
        return UsuarioType;
    }

    @Override
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity entity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        Long id = entity.getId();
        String nombre = entity.getName();
        UsuarioEntity usuario = usuarioDao.findById(id);
        usuario.setName(nombre);
        usuarioDao.persist(usuario);
        return usuario;
    }

    @Override
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser) {
        UsuarioEntity usuario;
        usuario = usuarioDao.findById(Long.valueOf(idtblUser));
        usuarioDao.delete(usuario);
        return usuario;
    }
}
