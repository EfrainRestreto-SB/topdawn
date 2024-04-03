package io.quarkus.topdawn.service.graphql.contract;

import io.quarkus.topdawn.entity.UsuarioEntity;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import org.eclipse.microprofile.graphql.Name;

import java.util.List;

public interface IUsuarioService {
    public List<UsuarioEntity> listarTodo();
    public UsuarioTypeInput crearUsuario(@Name("account") UsuarioTypeInput usuarioTypeInput);
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput);
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser);
}
