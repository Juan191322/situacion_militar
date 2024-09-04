/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.control;

import edu.avanzada.taller1.modelo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Clase que controla la logica del programa.
 * @author user
 */
public class ControladorPersona {
    private RegistroPersona registro;

    public ControladorPersona(){
        this.registro = new RegistroPersona();
    }

    public boolean insertarPersona(String nombre, String apellido,String cedula,  String tipoPersona, String datoAdicional){
        Persona nuevaPersona;

        switch (tipoPersona.toLowerCase()){
            case "remiso":
                nuevaPersona = new Remiso(nombre, apellido, cedula);
                break;
            case "aplazado":
                nuevaPersona = new Aplazado(nombre, apellido, cedula, parseFecha(datoAdicional));
                break;
            case "reclutado":
                nuevaPersona = new Reclutado(nombre, apellido, cedula, datoAdicional);
                break;
            case "reservista":
                nuevaPersona = new Reservista(nombre, apellido, cedula, datoAdicional);
                break;
            default:
                return false;
        }

        return registro.registrarPersona(nuevaPersona);
    }
    
    // Convierte una cadena de texto en una fecha
    private Date parseFecha(String fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            return formato.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Valida si una cedula ya esta en el sistema
    public boolean validarCedula(String cedula) {
        if (registro.existePersona(cedula)) {
            return true;
        } else {
            return false;
        }
    }
}
