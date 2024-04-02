package co.samtel.topdawn.service.mock.impl;

import co.samtel.topdawn.constant.Constans;
import co.samtel.topdawn.dao.Mock.UsuarioArrayDao;
import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.service.mock.contract.IUsuarioMockService;
import co.samtel.topdawn.service.rest.impl.UsuarioServiceImpl;
import co.samtel.topdawn.utils.exception.ApplicationException;
import co.samtel.topdawn.utils.mapper.UsuarioMapper;
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
