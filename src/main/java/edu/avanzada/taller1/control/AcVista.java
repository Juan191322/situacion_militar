package edu.avanzada.taller1.control;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @param  nos permite manipular las tablas de la vistaGenerarReportes  de una mejor manera en el control
 * 
 */

public class AcVista extends DefaultTableCellRenderer {

    /**
     * @param metodo en el cual se inicializa o se instancia sus componentes para formar la tabla
     * @param jtable
     * @param o
     * @param bln
     * @param bln1
     * @param i
     * @param i1
     * @return  el get de la tabla con sus componentes, en el cual definen sus caracteristicas
     */
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        if (o instanceof JButton) {
            JButton boton = (JButton) o;
            return boton;
        }
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
    }

}
