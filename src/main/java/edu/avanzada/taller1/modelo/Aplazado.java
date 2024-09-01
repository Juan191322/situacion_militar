/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.modelo;

/**
 *
 * @author user
 */
import java.util.Date;
public class Aplazado extends Persona{
    private Date fechaAplazamiento;
    
    public Aplazado(String nombre, String apellido, String cedula, Date fechaAplazamiento){
        super(nombre, apellido, cedula);
        this.fechaAplazamiento = fechaAplazamiento;
    }
    
    public Date getFechaAplazamiento(){
        return fechaAplazamiento;
    }
    
    public void setFechaAplazamiento(Date fechaAplazamiento){
        this.fechaAplazamiento = fechaAplazamiento;
    }
}
