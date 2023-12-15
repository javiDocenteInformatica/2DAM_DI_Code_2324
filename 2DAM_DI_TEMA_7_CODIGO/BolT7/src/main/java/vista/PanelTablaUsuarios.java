package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import utiles.Utiles;

public class PanelTablaUsuarios extends JPanel {

    private static final long serialVersionUID = 1L;

   
    private JTable tablaUsuarios;
    private TableModel cuadricula;
    private final int numColumns = 4;
    private String[] nombreColumnas;
    private Object[][] datosFila;

    /**
     * Create the panel.
     */
    public PanelTablaUsuarios() {

        this.setLayout(new BorderLayout());

        nombreColumnas = new String[]{"Apellido1", "Apellido2", "Nombre", "Fecha de Nacimiento"};

        datosFila = new Object[][]{
            {"Carrillo", "Salcedo", "Antonio", LocalDate.of(1995, Month.NOVEMBER, 12)},
            {"López", "Arena", "Daniel", LocalDate.of(2002, Month.MARCH, 1)},
            {"Martínez", "Ropero", "Agueda", LocalDate.of(2010, Month.FEBRUARY, 28)},};

        cuadricula = new AbstractTableModel() {

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return getDatosFila()[rowIndex][columnIndex];
            }

            @Override
            public int getRowCount() {
                return getDatosFila().length;
            }

            @Override
            public int getColumnCount() {
                return getNombreColumnas().length;
            }
        };

        tablaUsuarios = new JTable(cuadricula);

        // Se le da un color por defecto, pero se cambiará
        // Esto se hace por si falla la decodificación del color en HEX
        Color colorLineaBordeTabla = new Color(0, 0, 0);
        Color colorBackgroundTabla = new Color(255, 255, 255);

        // Se intenta decodificar el color en HEX
        try {
            colorLineaBordeTabla = Color.decode("#" + Utiles.COLOR_MARRON2);
            colorBackgroundTabla = Color.decode("#" + Utiles.COLOR_ROJO2);
        } catch (NumberFormatException ex) {
            System.out.println("Error al intentar decodificar un color en HEX");
            ex.printStackTrace();

        }

        tablaUsuarios.setBorder(new LineBorder(colorLineaBordeTabla));
        tablaUsuarios.setBackground(colorBackgroundTabla);

        this.add(tablaUsuarios, BorderLayout.CENTER);

    }

     public JTable getTablaUsuarios() {
        return tablaUsuarios;
    }

    public void setTablaUsuarios(JTable tablaUsuarios) {
        this.tablaUsuarios = tablaUsuarios;
    }

    public TableModel getCuadricula() {
        return cuadricula;
    }

    public void setCuadricula(TableModel cuadricula) {
        this.cuadricula = cuadricula;
    }

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public void setNombreColumnas(String[] nombreColumnas) {
        this.nombreColumnas = nombreColumnas;
    }

    public Object[][] getDatosFila() {
        return datosFila;
    }

    public void setDatosFila(Object[][] datosFila) {
        this.datosFila = datosFila;
    }

}
