package vista;

import java.awt.Color;

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
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public PanelTablaUsuarios() {

		cuadricula = new AbstractTableModel() {

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return Integer.valueOf(rowIndex * columnIndex);
			}

			@Override
			public int getRowCount() {
				return 10;
			}

			@Override
			public int getColumnCount() {
				return 4;
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

		add(tablaUsuarios);

		scrollPane = new JScrollPane();

		add(scrollPane);

	}

}
