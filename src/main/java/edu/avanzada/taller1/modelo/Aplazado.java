/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.modelo;

import java.util.Date;

/**
 * Clase que reprsenta a una persona aplazada.
 * @author user
 */
public class Aplazado extends Persona{
    private Date fechaAplazamiento;

    public Aplazado(String nombre, String apellido, String cedula, Date fechaAplazamiento){
        super(nombre, apellido, cedula);
        this.fechaAplazamiento = fechaAplazamiento;
    }
    
    // Getter y setter de fechaAplazamiento

    public Date getFechaAplazamiento(){
        return fechaAplazamiento;
    }

    public void setFechaAplazamiento(Date fechaAplazamiento){
        this.fechaAplazamiento = fechaAplazamiento;
    }
}