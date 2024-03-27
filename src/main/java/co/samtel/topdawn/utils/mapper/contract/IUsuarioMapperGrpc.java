package co.samtel.topdawn.utils.mapper.contract;

import co.samtel.topdawn.entity.UsuarioEntity;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.gen.type.UsuarioTypeResponse;

import com.samtel.grpc.proto.service.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface IUsuarioMapperGrpc {

  /*  UsuarioEntity userToEntity(Usuario user);
    Usuario entityToUser(UsuarioEntity entity);
    List<Usuario> entityListToUserList(List<UsuarioEntity> entityList);

    Usuario userRequestToUser(UsuarioTypeInput userRequest);
    UsuarioTypeResponse userToUserResponse(Usuario user);
    List<UsuarioTypeResponse> userListToUserResponseList(List<Usuario> userList);*/
}
