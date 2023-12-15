package controlador;

import utiles.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import utiles.Utiles;

public class PopupMenuEventsManager extends WindowAdapter implements ActionListener {

	private JTextArea output;
	private JFrame frame;

	public PopupMenuEventsManager(JTextArea output) {
		this.output = output;

	}

	public PopupMenuEventsManager(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem) (e.getSource());
		
		Utiles.mensajeAreaTexto(e, menuItem, output);
//		String s = "Action event detected." + Utiles.NEW_LINE + "    Event source: " + menuItem.getText()
//				+ " (an instance of " + Utiles.getClassName(menuItem) + ")";
//		output.append(s + Utiles.NEW_LINE);
//		output.setCaretPosition(output.getDocument().getLength());
	}

	/**
	 * Clase que extiende WindowAdapter para proporcionar una implementación
	 * específica del evento de cierre de la ventana.
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		
		 // Configurar el texto y los botones en español
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");
		
		// Mostrar un JOptionPane para confirmar el cierre de la ventana
		int result = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que quieres cerrar la ventana?",
				"Confirmar cierre", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.YES_OPTION) {
			// Si el usuario elige "Sí", cerrar la ventana
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}else {
			// Si el usuario elige "No", simplemente ignora el evento de cierre de la ventana
	        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}

}
