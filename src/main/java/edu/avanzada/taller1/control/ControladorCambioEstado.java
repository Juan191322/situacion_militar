/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.control;

import edu.avanzada.taller1.modelo.Persona;

/**
 *
 * @author anaro
 */
public class ControladorCambioEstado {
    public boolean cambiarEstado(Persona persona, String nuevoEstado) {
        if (validarTransicion(persona.getEstado(), nuevoEstado)) {
            persona.setEstado(nuevoEstado);
            //  logica para cambiar estado
            return true;
        } else {
            System.out.println("Transición de estado no permitida: " + persona.getEstado() + " -> " + nuevoEstado);
            return false;
        }
    }

    private boolean validarTransicion(String estadoActual, String nuevoEstado) {
        // Reglas de transición:
        switch (estadoActual) {
            case "Aplazado":
                return nuevoEstado.equals("Reclutado");
            case "Reclutado":
                return nuevoEstado.equals("Reservista") || nuevoEstado.equals("Remiso");
            case "Remiso":
                return nuevoEstado.equals("Reclutado");
            case "Reservista":
                return false; // No puede cambiar de Reservista a otro estado
            default:
                return false;
        }
    }
}