package controlador;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonModel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicMenuItemUI;

import utiles.Utiles;

public class PopupMenuItemEventsManager extends MouseAdapter implements ItemListener {
	private JTextArea output;

	public PopupMenuItemEventsManager(JTextArea output) {
		this.output = output;

	}

	public PopupMenuItemEventsManager() {

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JMenuItem menuItem = (JMenuItem) (e.getSource());
		String s = "Item event detected." + Utiles.NEW_LINE + "    Event source: " + menuItem.getText()
				+ " (an instance of " + Utiles.getClassName(menuItem) + ")" + Utiles.NEW_LINE + "    New state: "
				+ ((e.getStateChange() == ItemEvent.SELECTED) ? "selected" : "unselected");
		output.append(s + Utiles.NEW_LINE);
		output.setCaretPosition(output.getDocument().getLength());
	}

}
