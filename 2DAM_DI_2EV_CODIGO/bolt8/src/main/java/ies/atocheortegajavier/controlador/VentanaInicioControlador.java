package ies.atocheortegajavier.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ies.atocheortegajavier.vista.inicio.PanelInicio;
import ies.atocheortegajavier.vista.inicio.VentanaInicio;
import ies.atocheortegajavier.vista.login.VentanaLogin;

public class VentanaInicioControlador {

	private VentanaInicio ventanaInicio;

	public VentanaInicioControlador(VentanaInicio ventanaInicio) {
		this.ventanaInicio = ventanaInicio;
	}

	public void eventoBotonIniciarSesion() {

		PanelInicio panel = ventanaInicio.getPanelInicio();
		JButton botonInicioSesion = panel.getJbuttonIniciarSesion();

		botonInicioSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ventanaInicio.setVisible(false);
				VentanaLogin ventanaLogin = new VentanaLogin(ventanaInicio);
				ventanaLogin.setVisible(true);

			}

		});

	}

}
