/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.control;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Persona.EstadoPersona;

/**
 *
 * @author anaro
 */
public class ControladorCambioEstado {
    
    public boolean cambiarEstado(Persona persona, String nuevoEstado) {
        try {
            // Convertir el String nuevoEstado a EstadoPersona usando valueOf
            EstadoPersona estadoConvertido = EstadoPersona.valueOf(nuevoEstado);
            
            if (validarTransicion(persona.getEstado(), estadoConvertido)) {
                persona.setEstado(estadoConvertido);
                // Lógica para cambiar estado
                return true;
            } else {
                System.out.println("Transición de estado no permitida: " 
                    + persona.getEstado().name() + " -> " + nuevoEstado);
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Estado no válido: " + nuevoEstado);
            return false;
        }
    }

    private boolean validarTransicion(EstadoPersona estadoActual, EstadoPersona nuevoEstado) {
        // Reglas de transición:
        switch (estadoActual) {
            case Aplazado:
                return nuevoEstado == EstadoPersona.Reclutado;
            case Reclutado:
                return nuevoEstado == EstadoPersona.Reservista || nuevoEstado == EstadoPersona.Remiso;
            case Remiso:
                return nuevoEstado == EstadoPersona.Reclutado;
            case Reservista:
                return false; // No puede cambiar de Reservista a otro estado
            default:
                return false;
        }
    }
}
