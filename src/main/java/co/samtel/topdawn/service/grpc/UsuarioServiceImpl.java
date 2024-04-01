package co.samtel.topdawn.service.grpc;

import co.samtel.topdawn.dao.Mock.UsuarioArrayDao;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import com.samtel.grpc.proto.service.Usuario;
import com.samtel.grpc.proto.service.UsuarioList;
import com.samtel.grpc.proto.service.UsuarioService;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;


public class UsuarioServiceImpl implements  UsuarioService{



    @Inject
    UsuarioArrayDao usuarioArrayDao;
    @Override
    public Uni<Usuario> create(Usuario request) {
        /*log.info("Creating a new user.");
        UsuarioEntity entity = mapper.userToEntity(request);
        entity.setId(null);
        return usuarioArrayDao.crearUsuario(entity);*/
        return  null;
    }

    @Override
    public Uni<Usuario> update(Usuario request) {
        return null;
    }

    @Override
    public Uni<Usuario> findById(Int64Value request) {
        return null;
    }

    @Override
    public Uni<UsuarioList> list(Empty request) {
        return null;
    }

    @Override
    public Uni<BoolValue> delete(Int64Value request) {
        return null;
    }
/*
    @Inject
    IUsuarioMapperGrpc mapper;

    @Inject
    UsuarioArrayDao usuarioArrayDao;


    @Override
    public Uni<Usuario> create(Usuario request) {
        log.info("Creating a new user.");
        UsuarioEntity entity = mapper.userToEntity(request);
        entity.setId(null);
        return usuarioArrayDao.crearUsuario(entity);
       // return repository.persistAndFlush(entity).map(mapper::entityToUser);
    }

    @Override
    public Uni<Usuario> update(Usuario request) {
        return null;
    }

    @Override
    public Uni<Usuario> findById(Int64Value request) {
        return null;
    }

    @Override
    public Uni<UsuarioList> list(Empty request) {
        return null;
    }

    @Override
    public Uni<BoolValue> delete(Int64Value request) {
        return null;
    }*/
}
