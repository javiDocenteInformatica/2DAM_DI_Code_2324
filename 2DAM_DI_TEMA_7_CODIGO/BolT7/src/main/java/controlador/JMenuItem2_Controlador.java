package controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import vista.JMenuItem2;

public class JMenuItem2_Controlador implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		JMenuItem2 item = (JMenuItem2) e.getSource();
		
		switch(item.getId()) {
		case 21: 
			break;
		default:
			JOptionPane.showMessageDialog(item, "No se ha seleccionado ningún JMenuItem válido:  ID --> "+item.getId(), null, JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		
	}

}
