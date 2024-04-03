package io.quarkus.topdawn.service.rest.impl;

import io.quarkus.topdawn.constant.Constans;

import io.quarkus.topdawn.dao.UsuarioDao;
import io.quarkus.topdawn.entity.UsuarioEntity;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import io.quarkus.topdawn.utils.exception.ApplicationException;
import io.quarkus.topdawn.utils.mapper.UsuarioMapper;


import io.quarkus.topdawn.service.rest.contract.IUsuarioService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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


    @Transactional
    public UsuarioEntity crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Se inicia crearUsuario Impl");
        try {
            UsuarioEntity usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioDao.persist(usuario);
            return usuario;
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " buscarUsuarioPorIdImpl");
            UsuarioEntity usuarioResponse = null;
            return null;
        }
    }

    public UsuarioEntity buscarUsuarioPorId(Integer idtblUser) {
        LOG.info("Se inicia buscar usuario por id Impl");
        try {
            LOG.info("Se finaliza buscar usuario por id Impl");
            return usuarioDao.findById(Long.valueOf(idtblUser));
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " buscarUsuarioPorIdImpl");
            return null;
        }
    }

    @Transactional
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser) {
        LOG.info("Se inicia borrar usuario por id Impl");
        try {
            UsuarioEntity usuarioEntity = buscarUsuarioPorId(idtblUser);
            usuarioDao.delete(usuarioEntity);
            LOG.info("Se finaliza borrar usuario por id Impl");
            return usuarioEntity;
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " borrarUsuarioPorIdImpl");
            return null;
        }
    }

    @Transactional
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Se inicia borrar usuario por id Impl");
        UsuarioEntity entity = null;
        try {
            entity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            Long id = entity.getId();
            String nombre = entity.getName();
            UsuarioEntity usuario = usuarioDao.findById(id);
            usuario.setName(nombre);
            usuarioDao.persist(usuario);
            return usuario;
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " actualizarUsuarioPorIdImpl");
            return entity;
        }
    }

    public List<UsuarioEntity>  listarUsuarios() {
        List<UsuarioEntity> all = usuarioDao.listAll();
        return all;
    }
}
