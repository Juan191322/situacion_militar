/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.modelo;

/**
 * Clase para representar a una persona reservista.
 * @author user
 */
public class Reservista extends Persona {
    private String numeroLibretaMilitar;

    public Reservista(String nombre, String apellido, String cedula, String numeroLibretaMilitar){
        super(nombre, apellido, cedula);
        this.numeroLibretaMilitar = numeroLibretaMilitar;
    }
    
    // Getter y Setter de numeroLibretaMilitar

    public String getNumeroLibretaMilitar(){
        return numeroLibretaMilitar;
    }

    public void setNumeroLibretaMilitar(String numeroLibretaMilitar){
        this.numeroLibretaMilitar = numeroLibretaMilitar;
    }
}