/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.control;

import edu.avanzada.taller1.vista.VistaPrincipal;
import edu.avanzada.taller1.modelo.RegistroPersona;

public class Launcher {
    public static void main(String[] args) {
        RegistroPersona registro = new RegistroPersona();
        ControladorPersona controladorPersona = new ControladorPersona(registro);
        ControladorCambioEstado controladorCambioEstado = new ControladorCambioEstado (registro);


        VistaPrincipal vista = new VistaPrincipal(controladorPersona, controladorCambioEstado);
        vista.setVisible(true);
    }
}
