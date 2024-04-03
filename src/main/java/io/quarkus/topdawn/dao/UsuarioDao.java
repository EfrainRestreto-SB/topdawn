package io.quarkus.topdawn.dao;

import io.quarkus.topdawn.entity.UsuarioEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDao implements PanacheRepository<UsuarioEntity> {
}
