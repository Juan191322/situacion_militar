/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avanzada.taller1.control;

import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @param clase que se puede interpretar como fachada en la cual delega las tareas hacia las otras clases controles 
 */
public class ControlPrincipal implements ActionListener {
    /**
     *   La vista principal que muestra el menú principal.
     * Controlador para la vista de registro de personas.
     *  Controlador para la vista de consulta de personas.
     *  Controlador para la vista de cambio de estado.
     *  Controlador para la vista de generación de reportes.
     *  Lista de personas que representan a los militares.
     */
    private VistaPrincipal vistaView;
    private ControlRegistro controlR;
    private ControlConsultar controlC;
    private ControlCambio controlCambio;
    private ControlReportes controlRP;
    protected ArrayList<Persona> militares ;
    
    /**
     * Constructor de ControlPrincipal que inicializa los controladores y la vista principal.
     */
    public ControlPrincipal() {
        vistaMenuPrincipal();
        controlCambio = new ControlCambio(this);
        controlR = new  ControlRegistro(this);
        controlC = new ControlConsultar(this);
        controlRP=new ControlReportes(this);
        militares = new ArrayList<>();
    }
    
    /**
     * Inicializa la vista principal y establece los ActionListeners para sus componentes.
     */
    public void vistaMenuPrincipal(){
        vistaView = new VistaPrincipal(this);
        vistaView.registrar.addActionListener(this);
        vistaView.consultar.addActionListener(this);
        vistaView.cambiarEstado.addActionListener(this);
        vistaView.generarReportes.addActionListener(this);
        vistaView.salir.addActionListener(this);
        
    }
    /**
     * Maneja los eventos de acción generados por los botones en la vista principal.
     *  Dependiendo del comando de acción, redirige a la vista adecuada.
     * @param e El evento de acción que contiene información sobre la acción del usuario.
     *
     */
     
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Maneja la acción de registrar, cierra la vista actual y abre la vista de registro.
         * @param vistaView cierra la vista principal
         * @param controlR llama al controlador de registro para mostrar la vista de registro
         */
        if ("Registrar".equals(e.getActionCommand())) {
            vistaView.dispose();
            controlR.vistaRegistrar();
        }
        /**
         * Maneja la acción de consultar, cierra la vista actual y abre la vista de consulta.
         * @param vistaView cierra la vista principal
         * @param controlCLlama al controlador de consulta para mostrar la vista de consulta.
         */
        if ("Consultar".equals(e.getActionCommand())) {
            vistaView.dispose();
            controlC.consultarPersonas();
        }
        /**
         * Maneja la acción de cambiar estado, cierra la vista actual y abre la vista de cambio de estado.
         * @param controlRP Llama al controlador de reportes para mostrar la vista de reportes. 
         */
        if ("Cambiar estado".equals(e.getActionCommand())) {
            vistaView.dispose();
            controlCambio.cambioEstado();
        }
        /**
         *  Maneja la acción de generar reportes, cierra la vista actual y abre la vista de generación de reportes.
         * @param controlRP Llama al controlador de reportes para mostrar la vista de reportes.
         */
        if ("Generar reportes".equals(e.getActionCommand())) {
            vistaView.dispose();
            controlRP.VistaTabla();
        }
        /**
         * termina la aplicacion
         * @param System.exit(0) el que cierra la aplicacion
         */
        if ("Salir".equals(e.getActionCommand())) {
            System.exit(0);
        }
    }
    
}
