package co.samtel.topdawn.controller.grpc;


import co.samtel.topdawn.dto.UsuarioRequest;
import co.samtel.topdawn.utils.mapper.contract.IUsuarioMapperGrpc;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import com.samtel.grpc.proto.service.Usuario;
import com.samtel.grpc.proto.service.UsuarioList;

import com.samtel.grpc.proto.service.UsuarioService;


import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

import jakarta.ws.rs.POST;

import jakarta.ws.rs.core.Response;


import java.net.URI;


@GrpcService
public class UsuarioGrpcController implements UsuarioService  {


    UsuarioService userService;


    IUsuarioMapperGrpc mapper;

    @POST
    public Uni<Response> create(UsuarioRequest request) {

        return userService.create(mapper.userRequestToUser(request)).onItem().transform(inserted -> Response.created(URI.create("/users/" + inserted.getId())).build());


    }


    @Override
    public Uni<Usuario> create(Usuario request) {
        //return userService.create(request).onItem().transform(inserted -> Usuario.created()
                //Response.created(URI.create("/users/" + inserted.getId())).build());
        return null;
    }

    public Uni<Usuario> update(Usuario request) {
        return null;
    }


    public Uni<Usuario> findById(Int64Value request) {
        return null;
    }


    public Uni<UsuarioList> list(Empty request) {
        return null;
    }


    public Uni<BoolValue> delete(Int64Value request) {
        return null;
    }
}
