/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.avanzada.taller1.control;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Persona.EstadoPersona;
import edu.avanzada.taller1.modelo.RegistroPersona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorCambioEstadoTest {
    
    private ControladorCambioEstado controlador;
    private RegistroPersona registro;
    private Persona persona; // Añadido para la prueba

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
        controlador = new ControladorCambioEstado();
        registro = new RegistroPersona();
        persona = new Persona("Carlos", "López", "47843465"); // Inicialización de persona para pruebas
        persona.setEstado(EstadoPersona.Remiso);
        registro.registrarPersona(persona); // Registrar la persona para pruebas
    }
    
    @AfterEach
    public void tearDown() {
        // Limpieza después de cada prueba (si es necesario)
    }

    @Test
    public void testCambiarEstadoRemisoAReclutado() {
        System.out.println("cambiarEstado - Remiso a Reclutado");
        boolean resultado = controlador.cambiarEstado(persona, "Reclutado");
        assertTrue(resultado, "La transición de estado Remiso a Reclutado debería ser exitosa.");
        assertEquals(EstadoPersona.Reclutado, persona.getEstado(), "El estado de la persona debería ser Reclutado.");
    }

    @Test
    public void testCambiarEstadoReclutadoAReservista() {
        System.out.println("cambiarEstado - Reclutado a Reservista");
        persona.setEstado(EstadoPersona.Reclutado); // Cambia el estado de la persona a Reclutado
        boolean resultado = controlador.cambiarEstado(persona, "Reservista");
        assertTrue(resultado, "La transición de estado Reclutado a Reservista debería ser exitosa.");
        assertEquals(EstadoPersona.Reservista, persona.getEstado(), "El estado de la persona debería ser Reservista.");
    }

    @Test
    public void testCambiarEstadoReservista() {
        System.out.println("cambiarEstado - Estado Reservista");
        persona.setEstado(EstadoPersona.Reservista); // Cambia el estado de la persona a Reservista
        boolean resultado = controlador.cambiarEstado(persona, "Remiso");
        assertFalse(resultado, "La transición de estado desde Reservista debería ser rechazada.");
    }

    @Test
    public void testCambiarEstadoConEstadoInvalido() {
        System.out.println("cambiarEstado - Estado Inválido");
        boolean resultado = controlador.cambiarEstado(persona, "EstadoInvalido");
        assertFalse(resultado, "La transición a un estado no válido debería ser rechazada.");
    }
}
