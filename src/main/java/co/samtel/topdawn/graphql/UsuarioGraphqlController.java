package co.samtel.topdawn.graphql;

import co.samtel.topdawn.dao.UsuarioDao;
import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.service.UsuarioServiceImpl;
import co.samtel.topdawn.utils.mapper.UsuarioMapper;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
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
        List<UsuarioEntity> all = usuarioDao.listAll();
        return  all;
    }
}
