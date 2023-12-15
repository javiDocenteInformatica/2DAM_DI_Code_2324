package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.JMenuItem2;
import vista.VentanaTablaUsuarios;

public class JMenuItem2Controlador implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JMenuItem2 item = (JMenuItem2) e.getSource();

		switch (item.getId()) {
		case 21:
			VentanaTablaUsuarios ventanaTablaUsuarios = new VentanaTablaUsuarios();
			ventanaTablaUsuarios.setVisible(true);
			break;
		default:
			JOptionPane.showMessageDialog(item,
					"No se ha seleccionado ningún JMenuItem válido:  ID --> " + item.getId(), null,
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}

	}

}
