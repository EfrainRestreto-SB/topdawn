package co.samtel.topdawn.controller;




import co.samtel.topdawn.service.rest.CalculadoraServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class CalculadoraControllerTest {



    @Test
    void sumaDosNumeros() {
        //esperado
        double esperado = 21;
        var calculadora = new CalculadoraServiceImpl();

        //ejecutar y obtener
        var obtenido = calculadora.sumaDosNumeros( 10.0, 12.0);

        //comparar esperado vs obtenido
        Assertions.assertEquals(esperado, obtenido);
    }

    @Test
    public void testGetRequest() {
        given()
                .when()
                .get("http://localhost:8080/v1/es/sumaDosNumers/15/22")
                .then()
                .statusCode(200);
    }

}
