package co.samtel.topdawn.service.rest;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculadoraServiceImpl {



    public double sumaDosNumeros(Double uno, Double dos) {
        double sumaDosNumeros = uno + dos;
        return sumaDosNumeros;
    }
}
