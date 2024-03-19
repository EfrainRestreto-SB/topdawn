package co.samtel.topdawn.utils.mapper;

import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.gen.type.UsuarioTypeResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioMapper {
    public UsuarioEntity usuarioTypeToEntity(UsuarioTypeInput usuarioType) {

        return new ModelMapper().map(usuarioType, UsuarioEntity.class);
    }

    public UsuarioTypeInput usuarioEntityToType(UsuarioEntity usuario) {
        return new ModelMapper().map(usuario, UsuarioTypeInput.class);
    }

    public UsuarioTypeResponse usuarioEntityToTypeResponse(UsuarioEntity usuario) {
        return new ModelMapper().map(usuario, UsuarioTypeResponse.class);
    }


    public List<UsuarioEntity> usuarioTypeListToEntity(
            List<UsuarioTypeInput> usuarioTypeList) {
        return usuarioTypeList.stream().map(usuario -> usuarioTypeToEntity(usuario))
                .collect(Collectors.toList());
    }


    public UsuarioEntity clienteTypeToEntity(UsuarioTypeInput usuarioTypeInput) {
        return new ModelMapper().map(usuarioTypeInput, UsuarioEntity.class);
    }

    public UsuarioTypeResponse usuarioTypeToTypeResponse(UsuarioTypeInput usuarioTypeInput) {
        return new ModelMapper().map(usuarioTypeInput, UsuarioTypeResponse.class);
    }


}
