/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.situacion_militar;

/**
 *
 * @author user
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    
    public Persona(String nombre, String apellido,String cedula){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public String getCedula(){
        return cedula;
    }
    
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
}
