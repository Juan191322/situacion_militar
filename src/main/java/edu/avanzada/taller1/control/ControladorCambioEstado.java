/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.control;
import edu.avanzada.taller1.modelo.*;
import edu.avanzada.taller1.modelo.Persona.EstadoPersona;
import static edu.avanzada.taller1.modelo.Persona.EstadoPersona.Aplazado;
import static edu.avanzada.taller1.modelo.Persona.EstadoPersona.Reclutado;
import static edu.avanzada.taller1.modelo.Persona.EstadoPersona.Remiso;
import static edu.avanzada.taller1.modelo.Persona.EstadoPersona.Reservista;
import edu.avanzada.taller1.vista.VistaPrincipal;

/**
 * 
 * @author Erika
 */


public class ControladorCambioEstado {

    private RegistroPersona registro;

    public ControladorCambioEstado(RegistroPersona registro) {
        this.registro = registro;
    }

   public boolean cambiarEstado(Persona persona, String nuevoEstado) {
    try {
        EstadoPersona estadoConvertido = EstadoPersona.valueOf(nuevoEstado);

        if (validarTransicion(persona.getEstado(), estadoConvertido)) {
            String datoAdicional = "";

            if (esDatoAdicionalNecesario(estadoConvertido)) {
                datoAdicional = obtenerDatoAdicional(estadoConvertido);
                if (datoAdicional == null || datoAdicional.isEmpty()) {
                    System.out.println("El dato adicional es necesario para cambiar al estado: " + nuevoEstado);
                    return false;
                }
            }

            // Crear una nueva instancia de la clase correcta según el nuevo estado
            Persona nuevaPersona;
            if (estadoConvertido == EstadoPersona.Aplazado) {
                nuevaPersona = new Aplazado(persona.getNombre(), persona.getApellido(), persona.getCedula(), datoAdicional);
            } else if (estadoConvertido == EstadoPersona.Reclutado) {
                nuevaPersona = new Reclutado(persona.getNombre(), persona.getApellido(), persona.getCedula(), datoAdicional);
            } else if (estadoConvertido == EstadoPersona.Reservista) {
                nuevaPersona = new Reservista(persona.getNombre(), persona.getApellido(), persona.getCedula(), datoAdicional);
            } else if (estadoConvertido == EstadoPersona.Remiso) {
                nuevaPersona = new Remiso(persona.getNombre(), persona.getApellido(), persona.getCedula());
            } else {
                return false;
            }

            // Actualizar el estado en el registro de personas
            registro.removerPersona(persona.getCedula());
            registro.registrarPersona(nuevaPersona);

            return true;
        } else {
            System.out.println("Transición de estado no permitida: " + persona.getEstado().name() + " -> " + nuevoEstado);
            return false;
        }
    } catch (IllegalArgumentException e) {
        System.out.println("Estado no válido: " + nuevoEstado);
        return false;
    }
}

     private String obtenerDatoAdicional(EstadoPersona estadoConvertido) {
        String mensaje = "";

        switch (estadoConvertido) {
            case Aplazado:
                mensaje = "Ingrese la fecha de aplazamiento (dd/MM/yyyy):";
                break;
            case Reclutado:
                mensaje = "Ingrese el código de reclutamiento:";
                break;
            case Reservista:
                mensaje = "Ingrese el número de la libreta militar:";
                break;
            default:
                return "";
        }

        return VistaPrincipal.solicitarDatoAdicional(mensaje);
    }

    private boolean validarTransicion(EstadoPersona estadoActual, EstadoPersona nuevoEstado) {
        return switch (estadoActual) {
            case Aplazado -> nuevoEstado == EstadoPersona.Remiso || nuevoEstado == EstadoPersona.Reclutado;
            case Reclutado -> nuevoEstado == EstadoPersona.Reservista; 
            case Remiso -> nuevoEstado == EstadoPersona.Reclutado || nuevoEstado == EstadoPersona.Aplazado;
            case Reservista -> false;
            default -> false;
        };
    }

    public boolean esDatoAdicionalNecesario(EstadoPersona nuevoEstado) {
        return nuevoEstado == EstadoPersona.Aplazado || 
               nuevoEstado == EstadoPersona.Reclutado || 
               nuevoEstado == EstadoPersona.Reservista;
    }
}
