package io.quarkus.topdawn.service.mock.impl;

import io.quarkus.topdawn.constant.Constans;
import io.quarkus.topdawn.dao.Mock.UsuarioArrayDao;
import io.quarkus.topdawn.entity.UsuarioEntity;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import io.quarkus.topdawn.service.mock.contract.IUsuarioMockService;
import io.quarkus.topdawn.utils.exception.ApplicationException;
import io.quarkus.topdawn.utils.mapper.UsuarioMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@ApplicationScoped
public class UsuarioMockService implements IUsuarioMockService {
    private static final Logger LOG = LoggerFactory.getLogger(UsuarioMockService.class);

    @Inject
    UsuarioArrayDao usuarioArrayDao;

    @Inject
    UsuarioMapper usuarioMapper;

    @Override
    public UsuarioEntity crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Se inicia crearUsuario Impl");
        try {
            UsuarioEntity usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioArrayDao.crearUsuario(usuario);
            return usuario;
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " buscarUsuarioPorIdImpl");
            UsuarioEntity usuarioResponse = null;
            return null;
        }
    }

    @Override
    public UsuarioEntity buscarUsuarioPorId(Integer idtblUser) {
        return null;
    }

    @Override
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser) {
        return null;
    }

    @Override
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        return null;
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return  usuarioArrayDao.listAll();
    }
}
