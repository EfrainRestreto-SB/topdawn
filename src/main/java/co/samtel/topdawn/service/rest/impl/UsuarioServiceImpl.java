package co.samtel.topdawn.service.rest.impl;

import co.samtel.topdawn.constant.Constans;
import co.samtel.topdawn.dao.Mock.UsuarioArrayDao;
import co.samtel.topdawn.dao.UsuarioDao;
import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.utils.exception.ApplicationException;
import co.samtel.topdawn.utils.mapper.UsuarioMapper;



import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import co.samtel.topdawn.service.rest.contract.IUsuarioService;

@ApplicationScoped
public class UsuarioServiceImpl implements IUsuarioService{

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    @Inject
    UsuarioDao usuarioDao;

    @Inject
    UsuarioArrayDao usuarioArrayDao;

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
