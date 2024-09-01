/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.situacion_militar;

/**
 *
 * @author user
 */
public class ControladorPersona {
    private RegistroPersona registro;
    
    public ControladorPersona(){
        this.registro = new RegistroPersona();
    }
    
    public boolean insertarPersona(String nombre, String apellido, String cedula,  String tipoPersona, String datoAdicional){
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
}
