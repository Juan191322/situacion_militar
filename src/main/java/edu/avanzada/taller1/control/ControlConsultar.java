/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.control;

import edu.avanzada.taller1.modelo.Aplazado;
import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Reclutado;
import edu.avanzada.taller1.modelo.Remiso;
import edu.avanzada.taller1.modelo.Reservista;
import edu.avanzada.taller1.vista.MenuConsultar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @param clase que nos permite consultar la informacion de las personas ingresadas
 */
public class ControlConsultar implements ActionListener {

    /**
     * @param ControlPrincipal parametro que nos redirige al menu prinicpal
     * @param MenuConsultar parametro que nos redirige al menu de consultar 
     */
    private ControlPrincipal controlPrin;
    private MenuConsultar vistaCon;
   
    /**
     * 
     * @param controlPrin constructor que nos permite instanciar el control principal
     */
    public ControlConsultar(ControlPrincipal controlPrin) {
        this.controlPrin = controlPrin;
        
    }
    
    /**
     * @param metodo que nos permite acceder a la vista de consultar
     */
    public void consultarPersonas() {
        vistaCon = new MenuConsultar();
        vistaCon.consultarInfo.addActionListener(this);
        vistaCon.volver6.addActionListener(this);

    }
    
    /**
     * @param metodo que nos permite mostrar la informacion de la clase persona que hayamos guardado
     */
    public void mostrarInfo(){
        int cedula = Integer.parseInt(vistaCon.cedulaEnter.getText());
        vistaCon.pink.setText("no se encontro :)");
        for (Persona persona : controlPrin.militares){
           if (persona.getCedula() == cedula){
               String tipo = persona.getClass().getName();
               
               switch(tipo){
                    case "edu.avanzada.taller1.modelo.Reclutado":
                       Reclutado reclutado = (Reclutado)persona;
                       vistaCon.pink.setText("<html>" + reclutado.verDatos() + "<html>");
                       break;
                    case "edu.avanzada.taller1.modelo.Aplazado":
                       Aplazado aplazado = (Aplazado)persona;
                       vistaCon.pink.setText("<html>" + aplazado.verDatos() + "<html>");
                       break;
                    case "edu.avanzada.taller1.modelo.Remiso":
                       Remiso remiso = (Remiso)persona;
                       vistaCon.pink.setText("<html>" + remiso.verDatos() + "<html>");
                       break;
                    case "edu.avanzada.taller1.modelo.Reservista":
                       Reservista reservista = (Reservista)persona;
                       vistaCon.pink.setText("<html>" + reservista.verDatos() + "<html>");
                       break;
               }
               
           } 
              
           
        }
            
    }
    
    /**
     * @param metodo de un evento en el cual le agregamos el valor a los botones,abriendo las ventanas o redirigiendola a otra.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Volver".equals(e.getActionCommand())) {
            vistaCon.dispose();
            controlPrin.vistaMenuPrincipal();

        }
        if ("Consultar".equals(e.getActionCommand())) {
            mostrarInfo();

        }

    }

}
