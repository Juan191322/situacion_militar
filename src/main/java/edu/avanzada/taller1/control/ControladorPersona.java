/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.control;

import edu.avanzada.taller1.modelo.Aplazado;
import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Reclutado;
import edu.avanzada.taller1.modelo.RegistroPersona;
import edu.avanzada.taller1.modelo.Remiso;
import edu.avanzada.taller1.modelo.Reservista;
import java.util.List;

public class ControladorPersona {
    private RegistroPersona registro;
    
    public ControladorPersona(RegistroPersona registro) {
        this.registro = registro;
    }

    public boolean registrarPersona(String nombre, String apellido, String cedula, String tipoPersona, String datoAdicional) {
        Persona nuevaPersona;

        switch (tipoPersona.toLowerCase()) {
            case "remiso" -> nuevaPersona = new Remiso(nombre, apellido, cedula);
            case "aplazado" -> nuevaPersona = new Aplazado(nombre, apellido, cedula, datoAdicional);
            case "reclutado" -> nuevaPersona = new Reclutado(nombre, apellido, cedula, datoAdicional);
            case "reservista" -> nuevaPersona = new Reservista(nombre, apellido, cedula, datoAdicional);
            default -> {
                return false;
            }
        }

        return registro.registrarPersona(nuevaPersona);
    }

    public Persona consultarPersona(String cedula) {
        return registro.buscarPersona(cedula); // Devuelve la persona si existe
    }

   
    public boolean validarCedula(String cedula) {
        return registro.existePersona(cedula);
    }
    // imprimir personas por estado
    public void imprimirPersonasPorEstado(Persona.EstadoPersona estado) {
        List<Persona> personas = registro.obtenerPersonasPorEstado(estado);
        System.out.println("Personas con estado " + estado + ":");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " " + persona.getApellido() + " - " + persona.getCedula());
        }
    }
}
