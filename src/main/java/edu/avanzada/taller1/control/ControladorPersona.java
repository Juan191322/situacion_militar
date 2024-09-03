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
import edu.avanzada.taller1.vista.VistaPersona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ControladorPersona {
    private RegistroPersona registro;
    private VistaPersona view ;

    public ControladorPersona(){
        this.registro = new RegistroPersona();
    }

    public boolean insertarPersona(String nombre, String apellido,int cedula,  String tipoPersona, String datoAdicional){
        Persona nuevaPersona;

        switch (tipoPersona.toLowerCase()){
            case "remiso":
                nuevaPersona = new Remiso(nombre, apellido, cedula);
                break;
            case "aplazado":
                nuevaPersona = new Aplazado(nombre, apellido, cedula, datoAdicional);
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




    public boolean validarCedula(RegistroPersona registro, int cedula) {
        List<Persona> c = registro.getPersonasRegistradas();
        for (Persona persona : c) {
            if (cedula == persona.getCedula()) {
                view.mostrarInfo();
                return true; // Si la cedula ya está registrada, devuelve...
            }
        }
        view.mostrarFalsos();

    });

}