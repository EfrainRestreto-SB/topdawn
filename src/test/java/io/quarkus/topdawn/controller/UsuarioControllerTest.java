package io.quarkus.topdawn.controller;

import io.quarkus.topdawn.gen.type.UsuarioTypeInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

@QuarkusTest
class UsuarioControllerTest {

    @Inject
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actualizarUsuarioPorId() {
    }

    @Test
    void borrarUsuarioPorId() {
    }

    @Test
    void buscarUsuarioPorId() {
    }

    @Test
    void crearUsuario() throws IOException {

        // Preparación de datos
        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/prueba-usuario.json")), StandardCharsets.UTF_8);
        UsuarioTypeInput usuarioType = objectMapper.readValue(jsonString, UsuarioTypeInput.class);

        // Envío de solicitud
        given()
                .contentType(ContentType.JSON)
                .body(usuarioType)
                .when()
                .post("/v1/es/usuario")
                .then()
                .statusCode(201);
    }

    @Test
    void listarUsuarios() {
    }
}