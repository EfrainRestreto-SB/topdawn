package io.quarkus.topdawn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioResponse {
    private Long id;
    private String name;
    private String lastname;
}
