package io.quarkus.topdawn.utils.validator;

import io.quarkus.topdawn.constant.Constans;
import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import io.quarkus.topdawn.utils.exception.ApplicationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class UsuarioValidator {

    public Response verificarUsuarioTypeInput(UsuarioTypeInput usuarioTypeInput)
            throws ApplicationException {
        if (usuarioTypeInput.getLastname() == null || usuarioTypeInput.getLastname() == "") {
            throw new ApplicationException(
                    Constans.ERROR_VALIDACION + "lastname no puede estar vacío o ser null");
        }
        return Response.ok().build();
    }
}
