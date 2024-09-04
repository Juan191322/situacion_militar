/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.avanzada.taller1.control;

import edu.avanzada.taller1.modelo.Persona.EstadoPersona;
import edu.avanzada.taller1.modelo.RegistroPersona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorPersonaTest {
    
    private ControladorPersona controlador;
    private RegistroPersona registro;

    @BeforeAll
    public static void setUpClass() {
        // Configuración global que se ejecuta antes de todas las pruebas (si es necesario)
    }
    
    @AfterAll
    public static void tearDownClass() {
        // Limpieza global después de que todas las pruebas se hayan ejecutado (si es necesario)
    }
    
    @BeforeEach
    public void setUp() {
        // Configuración antes de cada prueba
        controlador = new ControladorPersona();
        registro = new RegistroPersona();
    }
    
    @AfterEach
    public void tearDown() {
        // Limpieza después de cada prueba (si es necesario)
    }

    @Test
    public void testInsertarPersonaRemiso() {
        System.out.println("insertarPersona - Remiso");
        boolean resultado = controlador.insertarPersona("Pablo", "Garson", "52456974", "remiso", "");
        assertTrue(resultado, "La persona remiso debería ser insertada correctamente.");
    }

    @Test
    public void testInsertarPersonaAplazado() {
        System.out.println("insertarPersona - Aplazado");
        boolean resultado = controlador.insertarPersona("Steven", "Maldonado", "156735906", "aplazado", "2022-07-12");
        assertTrue(resultado, "La persona aplazada debería ser insertada correctamente.");
    }

    @Test
    public void testValidarCedula() {
        System.out.println("validarCedula");
        controlador.insertarPersona("Carlos", "López", "47843465", "remiso", "");
        boolean resultado = controlador.validarCedula("47843465"); // Cambiado a una cédula existente
        assertTrue(resultado, "La cédula 47843465 debería existir en el sistema.");
    }
}
