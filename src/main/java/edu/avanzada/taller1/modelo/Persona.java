/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.modelo;


 /**
 *Representa una persona con atributos básicos como nombre, apellido y cédula.
 * Esta clase sirve como base para otras clases que requieren estos atributos.
 *  Atributos que definen a una persona.
 * 
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int cedula;
    /**
     * Constructor para crear una instancia de Persona.
     * @param nombre El nombre de la persona.
     * @param apellido El apellido de la persona.
     * @param cedula  La cédula de la persona.
     */
    public Persona(String nombre, String apellido,int cedula){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }
    /**
     * Obtiene el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * establce el nombre de la persona
     * @param nombre el nuevo nombre de la persona 
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * obtiene el apellido de la persona
     * @return el apellido de la persona
     */
    public String getApellido(){
        return apellido;
    }
    /**
     * Establece el apellido de la persona.
     * @param apellido El nuevo apellido de la persona.
     */
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    /**
     * Obtiene la cédula de la persona.
     * @return La cédula de la persona.
     */
    public int getCedula(){
        return cedula;
    }
    /**
     * Establece la cédula de la persona.
     * @param cedula La nueva cédula de la persona.
     */
    public void setCedula(int  cedula){

        this.cedula = cedula;
    }
}
