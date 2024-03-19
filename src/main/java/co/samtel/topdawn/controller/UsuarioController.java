package co.samtel.topdawn.controller;

import co.samtel.topdawn.gen.contract.V1UsuarioApi;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import jakarta.ws.rs.core.Response;

public class UsuarioController implements V1UsuarioApi {
    @Override
    public Response actualizarUsuarioPorId(UsuarioTypeInput usuarioTypeInput) {
        return null;
    }

    @Override
    public Response borrarUsuarioPorId(Integer idtblUser) {
        return null;
    }

    @Override
    public Response buscarUsuarioPorId(Integer idtblUser) {
        return null;
    }

    @Override
    public Response crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        return null;
    }
}
