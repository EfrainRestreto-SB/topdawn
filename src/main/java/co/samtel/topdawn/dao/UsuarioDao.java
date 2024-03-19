package co.samtel.topdawn.dao;

import co.samtel.topdawn.entity.UsuarioEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDao implements PanacheRepository<UsuarioEntity> {
}
