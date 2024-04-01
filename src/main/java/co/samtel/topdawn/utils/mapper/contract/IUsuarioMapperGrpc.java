package co.samtel.topdawn.utils.mapper.contract;


import co.samtel.topdawn.dto.UsuarioRequest;
import com.samtel.grpc.proto.service.Usuario;

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