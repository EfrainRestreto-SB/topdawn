package co.samtel.topdawn.dao.Mock;

import co.samtel.topdawn.entity.UsuarioEntity;
import com.samtel.grpc.proto.service.Usuario;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuarioArrayDao {
    List<UsuarioEntity> lista = new ArrayList<UsuarioEntity>();

    public Uni<Usuario> crearUsuario(UsuarioEntity usuarioEntity) {
        lista.add(usuarioEntity);
        return null;
    }

    public List<UsuarioEntity> listAll() {
        return lista;
    }


}
