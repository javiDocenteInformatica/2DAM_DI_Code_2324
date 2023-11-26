package controlador;

import utiles.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Clase que actúa como adaptador para eventos del mouse y muestra un menú
 * emergente asociado.
 */
public class PopupMenuContextEventsManager extends MouseAdapter {
	/** Menú emergente que se mostrará en respuesta a eventos del mouse. */
	JPopupMenu popup;

	/**
	 * Constructor de la clase que asigna un objeto JPopupMenu al miembro popup.
	 *
	 * @param popupMenu El menú emergente que se asociará con este adaptador.
	 */
	public PopupMenuContextEventsManager(JPopupMenu popupMenu) {
		popup = popupMenu;

		/**
		 * FUENTES
		 */
		popup.setFont(Utiles.cargaFuentes(Utiles.RALEWAY_MEDIUM, 15));

	}

	/**
	 * Se llama cuando se presiona un botón del mouse.
	 *
	 * @param e El evento del mouse asociado.
	 */
	public void mousePressed(MouseEvent e) {
		maybeShowPopup(e);

	}

	/**
	 * Se llama cuando se libera un botón del mouse.
	 *
	 * @param e El evento del mouse asociado.
	 */
	public void mouseReleased(MouseEvent e) {
		maybeShowPopup(e);

	}

	/**
	 * Método privado que determina si se debe mostrar el menú emergente o no.
	 *
	 * @param e El evento del mouse asociado.
	 */
	private void maybeShowPopup(MouseEvent e) {
		/*
		 * El método isPopupTrigger() es un método de la clase MouseEvent en Java que se
		 * utiliza para determinar si el evento del mouse es un desencadenador de menú
		 * emergente.
		 * 
		 * En el contexto de un MouseAdapter o un MouseListener, este método se usa
		 * comúnmente para verificar si se ha hecho clic con el botón del mouse que
		 * generalmente desencadena los menús emergentes (por lo general, el botón
		 * derecho del mouse en entornos basados en ventanas).
		 * 
		 * Devuelve true si el evento del mouse tiene que desencadenar la aparición de
		 * un menú emergente, y false en caso contrario.
		 * 
		 */
		if (e.isPopupTrigger()) {
			// Muestra el menú emergente en la posición del evento del mouse.
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}

}
