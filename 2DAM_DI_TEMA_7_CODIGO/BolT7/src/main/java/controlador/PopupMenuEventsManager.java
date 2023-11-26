package controlador;

import utiles.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import utiles.Utiles;

public class PopupMenuEventsManager implements ActionListener {

	private JTextArea output;
	
	public PopupMenuEventsManager(JTextArea output) {
		this.output = output;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem)(e.getSource());
        String s = "Action event detected."
                   + Utiles.NEW_LINE
                   + "    Event source: " + menuItem.getText()
                   + " (an instance of " + Utiles.getClassName(menuItem) + ")";
        output.append(s + Utiles.NEW_LINE);
        output.setCaretPosition(output.getDocument().getLength());
    }

	
	
}
