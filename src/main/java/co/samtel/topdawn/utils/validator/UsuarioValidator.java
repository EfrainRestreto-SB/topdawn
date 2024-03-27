package co.samtel.topdawn.utils.validator;

import co.samtel.topdawn.constant.Constans;
import co.samtel.topdawn.gen.type.UsuarioTypeInput;
import co.samtel.topdawn.utils.exception.ApplicationException;
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
