package edu.avanzada.taller1.control;

import edu.avanzada.taller1.modelo.Aplazado;
import edu.avanzada.taller1.modelo.Persona;
import edu.avanzada.taller1.modelo.Reclutado;
import edu.avanzada.taller1.modelo.Remiso;
import edu.avanzada.taller1.modelo.Reservista;
import edu.avanzada.taller1.vista.VistaGenenarReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Controlador para la generación y visualización de reportes de diferentes tipos de personas militares.
 * Maneja las acciones de los botones para mostrar tablas con datos de personas aplazadas, reclutadas, remisas y reservistas.
 * 
 */
public class ControlReportes implements ActionListener {

    private ControlPrincipal controlP;
    private VistaGenenarReportes vistaGeneral;
    
    /**
     * Constructor de ControlReportes.
     * @param controlP El controlador principal que maneja la navegación entre vistas.
     */
    public ControlReportes(ControlPrincipal controlP) {
        this.controlP = controlP;
    }
    /**
     * Inicializa la vista de reportes generales y agrega los oyentes de acción para los botones.
     */
    public void VistaTabla() {
        vistaGeneral = new VistaGenenarReportes();
        vistaGeneral.aplazado.addActionListener(this);
        vistaGeneral.reclutado.addActionListener(this);
        vistaGeneral.remiso.addActionListener(this);
        vistaGeneral.reservista.addActionListener(this);
        vistaGeneral.volver.addActionListener(this);
    }
    /**
     * Inicializa la vista de reportes con una tabla de remisos y llena la tabla con datos de remisos.
     * istaGeneral.MostrarTablaRemisos()Muestra la tabla de remisos en la vista.
     */
    public void VistaTablaRemiso() {
        vistaGeneral = new VistaGenenarReportes(this);
        vistaGeneral.aplazado.addActionListener(this);
        vistaGeneral.reclutado.addActionListener(this);
        vistaGeneral.remiso.addActionListener(this);
        vistaGeneral.reservista.addActionListener(this);
        vistaGeneral.volver.addActionListener(this);
        vistaGeneral.MostrarTablaRemisos();
        /**
         * llena la tabla de remisos con datos de la lista de militares
         */
        for (Persona persona : controlP.militares) {
            if ("edu.avanzada.taller1.modelo.Remiso".equals(persona.getClass().getName())) {
                Remiso remiso = (Remiso) persona;
                vistaGeneral.TablaDinamicoRemisos(remiso.getNombre(), remiso.getApellido(), remiso.getCedula());
            }

        }
    }
/**
 * Inicializa la vista de reportes con una tabla de reservistas y llena la tabla con datos de reservistas.
 * vistaGeneral.MostrarTablaReservista()Muestra la tabla de reservistas en la vista.
 * Llena la tabla de reservistas con datos de la lista de militares.

 */
    public void VistaTablaReservista() {
        vistaGeneral = new VistaGenenarReportes(this);
        vistaGeneral.aplazado.addActionListener(this);
        vistaGeneral.reclutado.addActionListener(this);
        vistaGeneral.remiso.addActionListener(this);
        vistaGeneral.reservista.addActionListener(this);
        vistaGeneral.volver.addActionListener(this);
        vistaGeneral.MostrarTablaReservista();
        for (Persona persona : controlP.militares) {
            if ("edu.avanzada.taller1.modelo.Reservista".equals(persona.getClass().getName())) {
                Reservista reservista = (Reservista) persona;
                vistaGeneral.TablaDinamicoReservista(reservista.getNombre(), reservista.getApellido(), reservista.getCedula(), reservista.getNumeroLibretaMilitar());
            }

        }
    }
    /**
     * Inicializa la vista de reportes con una tabla de aplazados y llena la tabla con datos de aplazados.
     * vistaGeneral.MostrarTablaAplazado() Muestra la tabla de aplazados en la vista.
     *  Llena la tabla de aplazados con datos de la lista de militares.
     */
    public void VistaTablaAplazado() {
        vistaGeneral = new VistaGenenarReportes(this);
        vistaGeneral.aplazado.addActionListener(this);
        vistaGeneral.reclutado.addActionListener(this);
        vistaGeneral.remiso.addActionListener(this);
        vistaGeneral.reservista.addActionListener(this);
        vistaGeneral.volver.addActionListener(this);
        vistaGeneral.MostrarTablaAplazado();
        for (Persona persona : controlP.militares) {
            if ("edu.avanzada.taller1.modelo.Aplazado".equals(persona.getClass().getName())) {
                Aplazado aplazado = (Aplazado) persona;
                vistaGeneral.TablaDinamicoAplazado(aplazado.getNombre(), aplazado.getApellido(), aplazado.getCedula(), aplazado.getFechaAplazamiento());
            }

        }
    }
    /**
     * Inicializa la vista de reportes con una tabla de reclutados y llena la tabla con datos de reclutados.
     * // Muestra la tabla de reclutados en la vista.
     */
    public void VistaTablaReclutado() {
        vistaGeneral = new VistaGenenarReportes(this);
        vistaGeneral.aplazado.addActionListener(this);
        vistaGeneral.reclutado.addActionListener(this);
        vistaGeneral.remiso.addActionListener(this);
        vistaGeneral.reservista.addActionListener(this);
        vistaGeneral.volver.addActionListener(this);
        vistaGeneral.MostrarTablaReclutado();
        for (Persona persona : controlP.militares) {
            if ("edu.avanzada.taller1.modelo.Reclutado".equals(persona.getClass().getName())) {
                Reclutado reclutado = (Reclutado) persona;
                vistaGeneral.TablaDinamicoReclutado(reclutado.getNombre(), reclutado.getApellido(), reclutado.getCedula(), reclutado.getCodigoReclutamiento());
            }

        }
    }
    /**
     * Maneja los eventos de acción generados por los botones en la vista de generación de reportes.
     * El evento de acción que contiene información sobre la acción del usuario.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Maneja la acción para mostrar la tabla de reservistas.
         * 
         */
        if ("Reservista".equals(e.getActionCommand())) {
            vistaGeneral.dispose();
            VistaTablaReservista();
        }
        /**
         * Maneja la acción para mostrar la tabla de reclutados.
         */
        if ("Reclutado".equals(e.getActionCommand())) {
            vistaGeneral.dispose();
            VistaTablaReclutado();
        }
        /**
         * Maneja la acción para mostrar la tabla de remisos.
         */
        if ("Remiso".equals(e.getActionCommand())) {
            vistaGeneral.dispose();
            VistaTablaRemiso();
        }
        /**
         * Maneja la acción para mostrar la tabla de aplazados.
         */
        if ("Aplazado".equals(e.getActionCommand())) {
            vistaGeneral.dispose();
            VistaTablaAplazado();
        }
        /**
         *  Maneja la acción de volver al menú principal.
         */
        if ("Volver".equals(e.getActionCommand())) {
            vistaGeneral.dispose();
            controlP.vistaMenuPrincipal();
        }

    }

}
