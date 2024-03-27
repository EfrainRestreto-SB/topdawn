package co.samtel.topdawn.controller;

import co.samtel.topdawn.constant.Constans;
import co.samtel.topdawn.service.rest.CalculadoraServiceImpl;
import co.samtel.topdawn.utils.exception.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/v1/es")
public class CalculadoraController {
    private static final Logger LOG = LoggerFactory.getLogger(CalculadoraController.class);
    @Inject
    CalculadoraServiceImpl cS;


    @GET
    @Path("/sumaDosNumeros/{uno}/{dos}")
    @Produces({"application/json"})
    public double sumaDosNumeros(@PathParam("uno") Double uno, @PathParam("dos") Double dos) {
        LOG.info("Se inicia calculo de la suma en Controller");
        double sumadosResponse = 0;
        try {
            sumadosResponse = cS.sumaDosNumeros(uno, dos);
            LOG.info("Se finaliza calculo de la suma  en Controller");
            return sumadosResponse;
        } catch (ApplicationException e) {
            LOG.error(Constans.ERROR_SERVICIO + e.getMessage() + " actualizarUsuarioPorIdController");
            return sumadosResponse;
        }
    }
}
