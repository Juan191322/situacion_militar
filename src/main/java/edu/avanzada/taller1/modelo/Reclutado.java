/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.modelo;

/**
 *
 * @author user
 */
public class Reclutado extends Persona {
    private String codigoReclutamiento;
    
    public Reclutado(String nombre, String apellido, String cedula, String codigoReclutamiento){
        super(nombre, apellido, cedula);
        this.codigoReclutamiento = codigoReclutamiento;
    }
    
    public String getCodigoReclutamiento(){
        return codigoReclutamiento;
    }
    
    public void setCodigoReclutamiento(String codigoReclutamiento){
        this.codigoReclutamiento = codigoReclutamiento;
    }
}
