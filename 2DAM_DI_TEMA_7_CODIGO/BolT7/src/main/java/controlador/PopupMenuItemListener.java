package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import utiles.Utiles;

public class PopupMenuItemListener implements ItemListener{
	private JTextArea output;
	
	public PopupMenuItemListener(JTextArea output) {
		this.output = output;

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Item event detected."
                   + Utiles.NEW_LINE
                   + "    Event source: " + source.getText()
                   + " (an instance of " + Utiles.getClassName(source) + ")"
                   + Utiles.NEW_LINE
                   + "    New state: "
                   + ((e.getStateChange() == ItemEvent.SELECTED) ?
                     "selected":"unselected");
        output.append(s + Utiles.NEW_LINE);
        output.setCaretPosition(output.getDocument().getLength());
    }

}
