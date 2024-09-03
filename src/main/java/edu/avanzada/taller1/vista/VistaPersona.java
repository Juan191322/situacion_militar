/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.vista;

import edu.avanzada.taller1.modelo.Aplazado;
import edu.avanzada.taller1.modelo.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author anaro
 */
public class VistaPersona extends JFrame{
    
    
    public void mostrarInfo(Persona persona) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Información de la Persona");
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setText(obtenerInfo(persona));
            JScrollPane scrollPane = new JScrollPane(textArea);
            frame.add(scrollPane);
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    // Método para mostrar mensajes simples
    public void mostrarFalsos(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Método auxiliar para generar la información de la persona como texto
    private String obtenerInfo(Persona persona) {
        StringBuilder info = new StringBuilder();
        info.append("Información de la persona encontrada:\n");
        info.append("Nombre: ").append(persona.getNombre()).append("\n");
        info.append("Apellido: ").append(persona.getApellido()).append("\n");
        info.append("Cédula: ").append(persona.getCedula()).append("\n");
        if (persona instanceof Aplazado) {
            info.append("Dato adicional: ").append(((Aplazado) persona).getDatoAdicional()).append("\n");
        } else if (persona instanceof Reclutado) {
            info.append("Dato adicional: ").append(((Reclutado) persona).getDatoAdicional()).append("\n");
        } else if (persona instanceof Reservista) {
            info.append("Dato adicional: ").append(((Reservista) persona).getDatoAdicional()).append("\n");
        }
        return info.toString();
    }
    
}
