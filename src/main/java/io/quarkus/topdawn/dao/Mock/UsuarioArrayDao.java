package io.quarkus.topdawn.dao.Mock;

import io.quarkus.topdawn.entity.UsuarioEntity;
import jakarta.enterprise.context.ApplicationScoped;


import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuarioArrayDao {
    List<UsuarioEntity> lista = new ArrayList<UsuarioEntity>();

    public UsuarioEntity crearUsuario(UsuarioEntity usuarioEntity) {
        lista.add(usuarioEntity);
        return null;
    }

    public List<UsuarioEntity> listAll() {
        return lista;
    }


}
