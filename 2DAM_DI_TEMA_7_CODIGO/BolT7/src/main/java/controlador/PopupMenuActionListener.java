package controlador;

import utiles.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import utiles.Utiles;

public class PopupMenuActionListener implements ActionListener {

	private JTextArea output;
	
	public PopupMenuActionListener(JTextArea output) {
		this.output = output;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Action event detected."
                   + Utiles.NEW_LINE
                   + "    Event source: " + source.getText()
                   + " (an instance of " + Utiles.getClassName(source) + ")";
        output.append(s + Utiles.NEW_LINE);
        output.setCaretPosition(output.getDocument().getLength());
    }

	
	
}
