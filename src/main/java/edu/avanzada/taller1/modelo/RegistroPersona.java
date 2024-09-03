/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.modelo;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.List;

public class RegistroPersona {
    private List<Persona> personasRegistradas;

    public RegistroPersona(){
        this.personasRegistradas = new ArrayList<>();
    }

    public List<Persona> getPersonasRegistradas(){
        return personasRegistradas;
    }

    public boolean existePersona(int cedula){
        for (Persona persona : personasRegistradas){
            if(persona.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }

    public boolean registrarPersona(Persona nuevaPersona){
        if(!existePersona(nuevaPersona.getCedula())){
            personasRegistradas.add(nuevaPersona);
            return true;
        }else{
            return false;
        }
    }
}