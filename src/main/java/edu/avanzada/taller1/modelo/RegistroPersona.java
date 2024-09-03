/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona el registro de personas.
 * @author user
 */
public class RegistroPersona {
    private List<Persona> personasRegistradas;
    
    /**
     * Constructor de la clase RegustroPersona
     * inicializa la lista de personas registrabas
     */

    public RegistroPersona(){
        this.personasRegistradas = new ArrayList<>();
    }

    public List<Persona> getPersonasRegistradas(){
        return personasRegistradas;
    }
    
    // Verificar si una cédula existe en el registro
    public boolean existePersona(String cedula){
        for (Persona persona : personasRegistradas){
            if(persona.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }
    
    // Registrar a una nueva perosna 
    public boolean registrarPersona(Persona nuevaPersona){
        if(!existePersona(nuevaPersona.getCedula())){
            personasRegistradas.add(nuevaPersona);
            return true;
        }else{
            return false;
        }
    }
}