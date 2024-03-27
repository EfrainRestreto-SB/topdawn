package co.samtel.topdawn.graphql;

import co.samtel.topdawn.constant.Constans;
import co.samtel.topdawn.dao.UsuarioDao;
import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.service.UsuarioServiceImpl;
import co.samtel.topdawn.utils.exception.ApplicationException;
import co.samtel.topdawn.utils.mapper.UsuarioMapper;
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
    UsuarioDao usuarioDao;

    @Inject
    UsuarioMapper usuarioMapper;
    @Query("allUser")
    public List<UsuarioEntity> listarTodo(){
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

    @Mutation("createUser")
    @Transactional
    public UsuarioTypeInput crearUsuario(@Name("account") UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity entity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        usuarioDao.persist(entity);
        UsuarioTypeInput UsuarioType = usuarioMapper.usuarioEntityToType(entity);
        return UsuarioType;
    }

    @Mutation("actualizarUser")
    @Transactional
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity entity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        Long id = entity.getId();
        String nombre = entity.getName();
        UsuarioEntity usuario = usuarioDao.findById(id);
        usuario.setName(nombre);
        usuarioDao.persist(usuario);
        return usuario;
    }
}
