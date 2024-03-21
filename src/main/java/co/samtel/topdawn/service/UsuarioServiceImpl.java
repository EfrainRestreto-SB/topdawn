package co.samtel.topdawn.service;

import co.samtel.topdawn.dao.UsuarioDao;
import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.utils.mapper.UsuarioMapper;



import io.smallrye.mutiny.Uni;
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
    public Uni<UsuarioEntity> crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        usuarioDao.persist(usuario);
       return null;
    }

    public UsuarioEntity buscarUsuarioPorId(Integer idtblUser) {
        return null;
    }

    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser) {
        return null;
    }

    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        return null;
    }

/*
    @Transactional
    public UsuarioTypeInput crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity entity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        usuarioDao.persist(entity);
        UsuarioTypeInput UsuarioType = usuarioMapper.usuarioEntityToType(entity);
        return UsuarioType;
    }

    public UsuarioEntity buscarUsuarioPorId(Integer idtblUser) {

        UsuarioEntity usuarioResponse = (UsuarioEntity) usuarioDao.findById(Long.valueOf(idtblUser));

        return usuarioResponse;
    }

    @Transactional
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser) {
        UsuarioEntity usuarioEntity = buscarUsuarioPorId(idtblUser);
        usuarioDao.delete(usuarioEntity);
        return usuarioEntity;
    }

    @Transactional
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity entity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        Long id = entity.getId();
        String nombre = entity.getName();
        UsuarioEntity usuario = (UsuarioEntity) usuarioDao.findById(id);
        usuario.setName(nombre);
        usuarioDao.persist(usuario);
        return usuario;
    }*/
}
