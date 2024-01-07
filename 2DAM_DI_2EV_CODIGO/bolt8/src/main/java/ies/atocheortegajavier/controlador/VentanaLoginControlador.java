package ies.atocheortegajavier.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import ies.atocheortegajavier.vista.login.PanelLogin;
import ies.atocheortegajavier.vista.login.VentanaLogin;

public class VentanaLoginControlador {
	private VentanaLogin ventanaLogin;

	public VentanaLoginControlador(VentanaLogin ventanaLogin) {
		this.ventanaLogin = ventanaLogin;
	}

	public void eventoBotonIniciarSesion() {

		PanelLogin panelLogin = ventanaLogin.getPanelLogin();

		JButton btnIniciarSesion = panelLogin.getBtnIniciarSesion();

		btnIniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// COMPROBACION EN LA BBDD
			}
		});

	}

	public void eventoBotonCancelar() {

		PanelLogin panelLogin = ventanaLogin.getPanelLogin();

		JButton btnCancelar = panelLogin.getBtnCancelar();

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Configurar el texto y los botones en español
				UIManager.put("OptionPane.yesButtonText", "Sí");
				UIManager.put("OptionPane.noButtonText", "No");

				// Mostrar un JOptionPane para confirmar el cierre de la ventana
				int result = JOptionPane.showConfirmDialog(ventanaLogin,
						"¿Estás seguro de que quieres cerrar la ventana?", "Confirmar cierre",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					// Si el usuario elige "Sí", cerrar la ventana
					ventanaLogin.dispose();
					ventanaLogin.getVentanaInicio().setVisible(true);
					
				} 

			}
		});

	}

}
