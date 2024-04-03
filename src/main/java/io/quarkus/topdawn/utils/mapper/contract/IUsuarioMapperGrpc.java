package io.quarkus.topdawn.utils.mapper.contract;


import io.quarkus.topdawn.dto.UsuarioRequest;
import io.quarkus.grpc.proto.service.Usuario;

import org.mapstruct.Mapper;


@Mapper(componentModel = "cdi")
public interface IUsuarioMapperGrpc {

    Usuario userRequestToUser(UsuarioRequest userRequest);

   // UsuarioEntity userToEntity(Usuario request);

  /*  UsuarioEntity userToEntity(Usuario user);
    Usuario entityToUser(UsuarioEntity entity);
    List<Usuario> entityListToUserList(List<UsuarioEntity> entityList);

    Usuario userRequestToUser(UsuarioTypeInput userRequest);
    UsuarioTypeResponse userToUserResponse(Usuario user);
    List<UsuarioTypeResponse> userListToUserResponseList(List<Usuario> userList);*/
}