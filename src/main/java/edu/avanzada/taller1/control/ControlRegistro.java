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
import edu.avanzada.taller1.vista.MenuAplazado;
import edu.avanzada.taller1.vista.MenuReclutado;
import edu.avanzada.taller1.vista.MenuRemiso;
import edu.avanzada.taller1.vista.MenuReservista;
import edu.avanzada.taller1.vista.VistaRegistrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *ControlRegistro es el controlador encargado de manejar las interacciones
 * con las vistas relacionadas con el registro de personas y la gestión de su información.
 * Maneja la navegación entre vistas para registrar diferentes tipos de militares.
 * @param ControlPrincipal Controlador principal que maneja la vista principal y la lista de militares.
 * @param VistaRegistrar Vista para seleccionar el tipo de registro de persona.
 * @param MenuAplazado Vista para registrar personas aplazadas.
 * @param MenuReclutado Vista para registrar personas reclutadas.
 * @param MenuRemiso Vista para registrar personas remisas.
 * @param MenuReservista Vista para registrar personas reservistas.
 * @param cuenta Identificador para controlar la vista activa y navegación.
 */
 
public class ControlRegistro implements ActionListener {

    private ControlPrincipal controlP;
    private VistaRegistrar vistaR;
    private MenuAplazado menuAplazado;
    private MenuReclutado menuReclutado;
    private MenuRemiso menuRemiso;
    private MenuReservista menuReservista;
    private int cuenta;
    
    /**
     * Constructor de ControlRegistro que inicializa el controlador con el controlador principal.
     * 
     * @param controlP El controlador principal que maneja la vista principal.
     */
    public ControlRegistro(ControlPrincipal controlP) {
        this.controlP = controlP;
    }
    
    /**
     * Verifica si la cédula proporcionada ya está registrada en la lista de militares.
     * 
     * @param cedula
     * @return true si la cédula no está registrada, false si ya existe.
     */
    public boolean confirmarCedula(int cedula) {
        boolean com = true;
        for (Persona persona : controlP.militares) {
            if (cedula == persona.getCedula()) {
                com = false;
            }
        }
        return com;
    }
    
    /**
     * Inicializa la vista de registro y configura los ActionListeners para los botones.
     * 
     * new VistaRegistrar()  Crea una instancia de la vista de registro.
     * añade con el Action listener los botones de vistaregistrar
     */
    public void vistaRegistrar() {
        vistaR = new VistaRegistrar();
        vistaR.aplazado.addActionListener(this);
        vistaR.reclutado.addActionListener(this);
        vistaR.remiso.addActionListener(this);
        vistaR.reservista.addActionListener(this);
        vistaR.volver.addActionListener(this);
        cuenta = 1;

    }
    
    /**
     * Inicializa la vista para registrar personas aplazadas y configura los ActionListeners.
     * new MenuAplazado()  Crea una instancia de la vista de aplazado.
     * añade el actionListener para los botones registrar aplazado y volver2.
     * cuenta = 2  Establece la cuenta en 2, indicando que la vista de aplazado está activa.
     */
    public void datosAplazado() {
        menuAplazado = new MenuAplazado();
        menuAplazado.registrarAplazado.addActionListener(this);
        menuAplazado.volver2.addActionListener(this);
        cuenta = 2;
    }
    
    /**
     * Crea un nuevo objeto Aplazado y lo agrega a la lista de militares si la cédula es válida.
     * 
     */
    public void crearAplazado() {
        if (confirmarCedula(Integer.parseInt(menuAplazado.cedula.getText()))) {
            Aplazado aplazado = new Aplazado(menuAplazado.nombre.getText(), menuAplazado.apellido.getText(), Integer.parseInt(menuAplazado.cedula.getText()), menuAplazado.fechaAplazado.getText());
            menuAplazado.limpiar();
            menuAplazado.viva.setText("se creo exitosamente");
            controlP.militares.add(aplazado);
        } else {
            menuAplazado.error1.setText("Ya ingresada");
        }

    }
    /**
     * Inicializa la vista para registrar personas reclutadas y configura los ActionListeners.
     *  new MenuReclutado Crea una instancia de la vista de reclutado.
     * añade el action listener para los botones registrar reclutado y volver
     * Cuenta= 3 Establece la cuenta en 3, indicando que la vista de reclutado está activa.
     */
    public void datosReclutado() {
        menuReclutado = new MenuReclutado();
        menuReclutado.registrarReclutado.addActionListener(this);
        menuReclutado.volver3.addActionListener(this);
        cuenta = 3;

    }
    /**
     * Crea un nuevo objeto Reclutado y lo agrega a la lista de militares si la cédula es válida.
     * @param menuReclutado.limpiar limpia los campos de la vista
     * 
     */
    public void crearReclutado() {
        if (confirmarCedula(Integer.parseInt(menuReclutado.cedula1.getText()))) {
            Reclutado reclutado = new Reclutado(menuReclutado.nombre1.getText(), menuReclutado.apellido1.getText(), Integer.parseInt(menuReclutado.cedula1.getText()), Integer.parseInt(menuReclutado.codigoReclutamiento.getText()));
            menuReclutado.limpiar();
            controlP.militares.add(reclutado);
            menuReclutado.loca.setText("se creo exitosamente");
        } else {
            menuReclutado.error1.setText("Ya ingresada");
        }
    }
    /**
     * Inicializa la vista para registrar personas remisas y configura los ActionListeners.
     * new MenuRemiso() Crea una instancia de la vista de remiso.
     * añade los ActiobListener para los botones registrarremiso y volver4
     */
    public void datosRemiso() {
        menuRemiso = new MenuRemiso();
        menuRemiso.registrarRemiso.addActionListener(this);
        menuRemiso.volver4.addActionListener(this);
        cuenta = 4;
    }
    /**
     * Crea un nuevo objeto Remiso y lo agrega a la lista de militares si la cédula es válida.
     */
     
    public void crearRemiso() {
        if (confirmarCedula(Integer.parseInt(menuRemiso.cedula2.getText()))) {
            Remiso remiso = new Remiso(menuRemiso.nombre2.getText(), menuRemiso.apellido2.getText(), Integer.parseInt(menuRemiso.cedula2.getText()));
            menuRemiso.limpiar();
            controlP.militares.add(remiso);
            menuRemiso.lulu.setText("se creo exitosamente");
        } else {
            menuReclutado.error1.setText("Ya ingresada");
        }
    }
    /**
     * Inicializa la vista para registrar personas reservistas y configura los ActionListeners.
     * new MenuReservista() Crea una instancia de la vista de reservista.
     * añade los ActionListener para los botones registrarreservista y volver5
     */
    public void datosReservista() {
        menuReservista = new MenuReservista();
        menuReservista.registrarReservista.addActionListener(this);
        menuReservista.volver5.addActionListener(this);
        cuenta = 5;
    }
    /**
     * Crea un nuevo objeto Reservista y lo agrega a la lista de militares si la cédula es válida.
     */
    public void crearReservista() {
        if (confirmarCedula(Integer.parseInt(menuReservista.cedula3.getText()))) {
            Reservista reservista = new Reservista(menuReservista.nombre3.getText(), menuReservista.apellido3.getText(), Integer.parseInt(menuReservista.cedula3.getText()), Integer.parseInt(menuReservista.libretaMilitar.getText()));
            menuReservista.limpiar();
            controlP.militares.add(reservista);
            menuReservista.bebe.setText("se creo exitosamente");
        } else {
            menuReservista.error1.setText("Ya ingresada");
        }

    }
    
    /**
     * Maneja los eventos de acción generados por los botones en las vistas de registro.
     * Dependiendo del comando de acción, redirige a la vista adecuada o realiza la acción correspondiente.
     * 
     * @param e El evento de acción que contiene información sobre la acción del usuario.
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Maneja la acción para mostrar la vista de registro de personas aplazadas.
         */
        if ("Aplazado".equals(e.getActionCommand())) {
            vistaR.dispose();
            datosAplazado();
        }
        /**
         * Maneja la acción para registrar una persona aplazada.
         * crearAplazado() Crea un nuevo aplazado y lo agrega a la lista de militares.
         */
        if ("Registrar Aplazado".equals(e.getActionCommand())) {

            crearAplazado();
        }
        /**
         *  Maneja la acción para mostrar la vista de registro de personas reclutadas.
         * 
         */
        if ("Reclutado".equals(e.getActionCommand())) {
            vistaR.dispose();
            datosReclutado();
        }
        /**
         * Maneja la acción para registrar una persona reclutada.
         */
        if ("Registrar Reclutado".equals(e.getActionCommand())) {
            crearReclutado();
        }
        /**
         * Maneja la acción para mostrar la vista de registro de personas remisas.
         * 
         */
        if ("Remiso".equals(e.getActionCommand())) {
            vistaR.dispose();
            datosRemiso();
        }
        /**
         * Maneja la acción para registrar una persona remisa.
         */
        if ("Registrar Remiso".equals(e.getActionCommand())) {
            crearRemiso();
        }
        /**
         *  Maneja la acción para mostrar la vista de registro de personas reservistas.
         * 
         */
        if ("Reservista".equals(e.getActionCommand())) {
            vistaR.dispose();
            datosReservista();
        }
        /**
         * Maneja la acción para registrar una persona reservista.
         */
        if ("Registrar Reservista".equals(e.getActionCommand())) {
            crearReservista();
        }
        
        /**
         *  Maneja la acción de volver a la vista anterior según el estado de la variable cuenta.
         */
        if ("Volver".equals(e.getActionCommand())) {
            
            switch (cuenta) {
                /**
             * Si la vista activa es la vista de registro principal.
             */
                case 1:
                    vistaR.dispose();
                    controlP.vistaMenuPrincipal();

                    break;
                /**
                 * Si la vista activa es la vista de aplazado.
                 */
                case 2:
                    menuAplazado.dispose();
                    vistaRegistrar();
                    break;
                /**
                 * Si la vista activa es la vista de reclutado.
                 */
                case 3:
                    menuReclutado.dispose();
                    vistaRegistrar();
                    break;
                /**
                 * Si la vista activa es la vista de remiso.
                 */
                case 4:
                    menuRemiso.dispose();
                    vistaRegistrar();
                    break;
                /**
                 * Si la vista activa es la vista de reservista.
                 */
                case 5:
                    menuReservista.dispose();
                    vistaRegistrar();
                    break;
                /**
                 * lanza un error si la cuenta no es reconocida
                 */
                default:
                    throw new AssertionError();
            }
        }
    }
}
