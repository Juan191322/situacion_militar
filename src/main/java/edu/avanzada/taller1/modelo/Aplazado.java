/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.modelo;

import edu.avanzada.taller1.modelo.Persona;



/**
 *Representa a un militar aplazado, que es una subclase de Persona.
 * Esta clase incluye información adicional específica para un militar aplazado,
 * como la fecha de aplazamiento.
 * @param fechaAplazamiento fecha en que se aplazo el militar 
 * 
 */
import java.util.Date;
public class Aplazado extends Persona{
    
    private String fechaAplazamiento;
    
    /**
     * Constructor para crear una instancia de Aplazado.
     * @param nombre El nombre del militar aplazado.
     * @param apellido El apellido del militar aplazado.
     * @param cedula La cédula del militar aplazado.
     * @param fechaAplazamiento La fecha en que se aplazó al militar.
     * Llama al constructor de la clase base Persona.
     * 
     */
    public Aplazado(String nombre, String apellido,int cedula, String fechaAplazamiento){
        super(nombre, apellido, cedula);
        this.fechaAplazamiento = fechaAplazamiento;
    }
    /**
     * Obtiene la fecha de aplazamiento del militar.
     * @return La fecha de aplazamiento.
     */
    public String getFechaAplazamiento(){
        return fechaAplazamiento;
    }
    /**
     * Establece la fecha de aplazamiento del militar.
     * @param fechaAplazamiento fechaAplazamiento La nueva fecha de aplazamiento.
     */
    public void setFechaAplazamiento(String fechaAplazamiento){
        this.fechaAplazamiento = fechaAplazamiento;

    }
    /**
     * Devuelve una representación en cadena de los datos del militar aplazado.
     * @return Una cadena con la información del militar aplazado, incluyendo
     *         nombre, apellido, cédula y fecha de aplazamiento.
     */
    public String verDatos(){
        return "Estado militar:Aplazado &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                + "<p>Nombre: " + super.getNombre() + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                + "Apellido: " + super.getApellido() + "<p> "
                + "Cedula: " + super.getCedula() + "<p> "
                + "<p>Fecha: " + fechaAplazamiento + "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"
                 + "<p>";
    }
}
