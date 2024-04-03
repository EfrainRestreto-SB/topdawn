package io.quarkus.topdawn.service.rest.contract;

import io.quarkus.topdawn.entity.UsuarioEntity;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface IUsuarioService {
    public UsuarioEntity crearUsuario(UsuarioTypeInput usuarioTypeInput);
    public UsuarioEntity buscarUsuarioPorId(Integer idtblUser);
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser);
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput);
    public List<UsuarioEntity> listarUsuarios();
}
