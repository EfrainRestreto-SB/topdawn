package io.quarkus.topdawn.service.mock.contract;

import io.quarkus.topdawn.entity.UsuarioEntity;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;

import java.util.List;

public interface IUsuarioMockService {
    public UsuarioEntity crearUsuario(UsuarioTypeInput usuarioTypeInput);
    public UsuarioEntity buscarUsuarioPorId(Integer idtblUser);
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser);
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput);
    public List<UsuarioEntity> listarUsuarios();
}
