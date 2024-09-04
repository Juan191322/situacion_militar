/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.vista;

import edu.avanzada.taller1.control.ControladorCambioEstado;
import edu.avanzada.taller1.control.ControladorPersona;
import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Aplazado;
import edu.avanzada.taller1.modelo.Reclutado;
import edu.avanzada.taller1.modelo.Reservista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaPrincipal extends JFrame {
    private ControladorPersona controladorPersona;
    private ControladorCambioEstado controladorCambioEstado;

    public VistaPrincipal(ControladorPersona controladorPersona, ControladorCambioEstado controladorCambioEstado) {
        this.controladorPersona = controladorPersona;
        this.controladorCambioEstado = controladorCambioEstado;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Gestión de Situación Militar");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        // Panel superior para consultas
        JPanel panelConsulta = new JPanel(new FlowLayout());
        JLabel lblIdPersona = new JLabel("Cédula de Persona:");
        JTextField txtIdPersona = new JTextField(10);
        JButton btnConsultar = new JButton("Consultar");

        panelConsulta.add(lblIdPersona);
        panelConsulta.add(txtIdPersona);
        panelConsulta.add(btnConsultar);

        JTextArea areaResultado = new JTextArea(10, 50);
        areaResultado.setEditable(false);
        panelConsulta.add(new JScrollPane(areaResultado));

        // Botones para mostrar los paneles de registro y cambio de estado
        JButton btnMostrarRegistro = new JButton("Registrar Persona");
        JButton btnMostrarCambioEstado = new JButton("Modificar Estado");

        // Panel medio para registro de persona
        JPanel panelRegistro = new JPanel(new GridLayout(6, 2));
        panelRegistro.setVisible(false);  // Se oculta hasta que se presione el botón correspondiente
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblApellido = new JLabel("Apellido:");
        JTextField txtApellido = new JTextField();
        JLabel lblCedula = new JLabel("Cédula:");
        JTextField txtCedula = new JTextField();
        JLabel lblTipoPersona = new JLabel("Tipo de Persona:");
        String[] tipos = {"Remiso", "Aplazado", "Reclutado", "Reservista"};
        JComboBox<String> comboTipoPersona = new JComboBox<>(tipos);
        JLabel lblDatoAdicional = new JLabel("Dato Adicional:");
        JTextField txtDatoAdicional = new JTextField();
        JButton btnRegistrar = new JButton("Registrar");

        panelRegistro.add(lblNombre);
        panelRegistro.add(txtNombre);
        panelRegistro.add(lblApellido);
        panelRegistro.add(txtApellido);
        panelRegistro.add(lblCedula);
        panelRegistro.add(txtCedula);
        panelRegistro.add(lblTipoPersona);
        panelRegistro.add(comboTipoPersona);
        panelRegistro.add(lblDatoAdicional);
        panelRegistro.add(txtDatoAdicional);
        panelRegistro.add(btnRegistrar);

        // Panel inferior para cambio de estado
        JPanel panelCambioEstado = new JPanel(new FlowLayout());
        panelCambioEstado.setVisible(false);  // Se oculta hasta que se presione el botón correspondiente
        JLabel lblNuevoEstado = new JLabel("Cambiar Estado A:");
        JComboBox<String> comboEstados = new JComboBox<>(tipos);
        JButton btnCambiarEstado = new JButton("Cambiar Estado");

        panelCambioEstado.add(lblNuevoEstado);
        panelCambioEstado.add(comboEstados);
        panelCambioEstado.add(btnCambiarEstado);

        // Acciones de los botones
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtIdPersona.getText();
                Persona persona = controladorPersona.consultarPersona(id);
                if (persona != null) {
                    StringBuilder resultado = new StringBuilder();
                    resultado.append("Cédula: ").append(persona.getCedula())
                             .append("\nNombre: ").append(persona.getNombre())
                             .append(" ").append(persona.getApellido())
                             .append("\nEstado: ").append(persona.getEstado().name());

                    // Mostrar dato adicional basado en el tipo de persona
                    if (persona instanceof Aplazado) {
                        Aplazado aplazado = (Aplazado) persona;
                        resultado.append("\nFecha Aplazamiento: ").append(aplazado.getFechaAplazamiento());
                    } else if (persona instanceof Reclutado) {
                        Reclutado reclutado = (Reclutado) persona;
                        resultado.append("\nCódigo de Reclutamiento: ").append(reclutado.getCodigoReclutamiento());
                    } else if (persona instanceof Reservista) {
                        Reservista reservista = (Reservista) persona;
                        resultado.append("\nLibreta Militar: ").append(reservista.getNumeroLibretaMilitar());
                    }

                    areaResultado.setText(resultado.toString());
                } else {
                    areaResultado.setText("Persona no encontrada.");
                }
            }
        });

        btnMostrarRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelRegistro.setVisible(true);
                panelCambioEstado.setVisible(false);
            }
        });

        btnMostrarCambioEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelRegistro.setVisible(false);
                panelCambioEstado.setVisible(true);
            }
        });
        
        comboTipoPersona.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String tipoSeleccionado = (String) comboTipoPersona.getSelectedItem();
        if ("Remiso".equals(tipoSeleccionado)) {
            lblDatoAdicional.setVisible(false);
            txtDatoAdicional.setVisible(false);
        } else {
            lblDatoAdicional.setVisible(true);
            txtDatoAdicional.setVisible(true);
        }
    }
});


        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String cedula = txtCedula.getText();
                String tipoPersona = comboTipoPersona.getSelectedItem().toString();
                String datoAdicional = txtDatoAdicional.getText();

                boolean exito = controladorPersona.registrarPersona(nombre, apellido, cedula, tipoPersona, datoAdicional);
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Persona registrada exitosamente.");
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtCedula.setText("");
                    txtDatoAdicional.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar la persona.");
                }
            }
        });

        btnCambiarEstado.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String id = txtIdPersona.getText();
        Persona persona = controladorPersona.consultarPersona(id);
        if (persona != null) {
            String nuevoEstado = comboEstados.getSelectedItem().toString();
            boolean exito = controladorCambioEstado.cambiarEstado(persona, nuevoEstado);
            if (exito) {
                JOptionPane.showMessageDialog(null, "Estado cambiado exitosamente.");
                // Actualizar el área de resultado con la información actualizada
                btnConsultar.doClick();
            } else {
                JOptionPane.showMessageDialog(null, "Error al cambiar el estado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada.");
        }
    }
});


        // Añadir los paneles al marco
        panelPrincipal.add(panelConsulta, BorderLayout.NORTH);
        panelPrincipal.add(panelRegistro, BorderLayout.CENTER);
        panelPrincipal.add(panelCambioEstado, BorderLayout.SOUTH);
        panelPrincipal.add(btnMostrarRegistro, BorderLayout.WEST);
        panelPrincipal.add(btnMostrarCambioEstado, BorderLayout.EAST);

        add(panelPrincipal);
    }

    // Método para solicitar dato adicional (usado en el controlador)
    public static String solicitarDatoAdicional(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }
}