package co.samtel.topdawn.service.mock.contract;

import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;

import java.util.List;

public interface IUsuarioMockService {
    public UsuarioEntity crearUsuario(UsuarioTypeInput usuarioTypeInput);
    public UsuarioEntity buscarUsuarioPorId(Integer idtblUser);
    public UsuarioEntity borrarUsuarioPorId(Integer idtblUser);
    public UsuarioEntity actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput);
    public List<UsuarioEntity> listarUsuarios();
}
