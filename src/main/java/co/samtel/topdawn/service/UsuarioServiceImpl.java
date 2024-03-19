package co.samtel.topdawn.service;

import co.samtel.topdawn.dao.UsuarioDao;
import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.utils.mapper.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImpl {

    @Inject
    UsuarioDao usuarioDao;

    @Inject
    UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioTypeInput crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity entity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        usuarioDao.persist(entity);
        UsuarioTypeInput UsuarioType = usuarioMapper.usuarioEntityToType(entity);
        //return Response.status(Response.Status.CREATED).entity(UsuarioType).build();
        return UsuarioType;
    }

    /*public UsuarioEntity buscarUsuarioPorId(Integer idtblUser) {

        UsuarioEntity usuarioResponse = usuarioDao.findById(Long.valueOf(idtblUser));

        return usuarioResponse;
    }*/

    /*@Transactional
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser) {
        UsuarioEntity usuarioEntity = buscarUsuarioPorId(idtblUser);
        usuarioDao.delete(usuarioEntity);
        return usuarioEntity;
    }*/

    /*@Transactional
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity entity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        Long id = entity.getId();
        String nombre = entity.getName();
        UsuarioEntity usuario = usuarioDao.findById(id);
        usuario.setName(nombre);
        usuarioDao.persist(usuario);
        return usuario;
    }*/
}
