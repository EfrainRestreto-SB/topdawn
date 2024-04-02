package co.samtel.topdawn.service.graphql.impl;

import co.samtel.topdawn.constant.Constans;
import co.samtel.topdawn.controller.graphql.UsuarioGraphqlController;
import co.samtel.topdawn.dao.UsuarioDao;
import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.service.graphql.contract.IUsuarioService;
import co.samtel.topdawn.utils.exception.ApplicationException;
import co.samtel.topdawn.utils.mapper.UsuarioMapper;
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
            return (List<co.samtel.topdawn.entity.UsuarioEntity>) Response.status(Response.Status.BAD_REQUEST).entity(UsuarioEntity).build();
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
