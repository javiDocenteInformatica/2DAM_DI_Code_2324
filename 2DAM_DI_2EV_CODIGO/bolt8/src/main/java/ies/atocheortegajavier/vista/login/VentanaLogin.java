package ies.atocheortegajavier.vista.login;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ies.atocheortegajavier.controlador.VentanaLoginControlador;
import ies.atocheortegajavier.utiles.Imagenes;
import ies.atocheortegajavier.utiles.Tamanyos;
import ies.atocheortegajavier.utiles.Textos;
import ies.atocheortegajavier.vista.inicio.VentanaInicio;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private VentanaLoginControlador ventanaLoginControlador;
	private VentanaInicio ventanaInicio;
	private PanelLogin panelLogin;

	/**
	 * Create the frame.
	 */
	public VentanaLogin(VentanaInicio ventanaInicio) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// cambia tamanyo de la ventana
		setSize(Tamanyos.W_500, Tamanyos.H_300);

		// evita que cambie el tamanyo de la ventana
		setResizable(false);

		// centra la ventana en mitad de la pantalla
		setLocationRelativeTo(null);

		// titulo de la ventana
		setTitle(Textos.TITULO_VENTANA_LOGIN);

		// icono de la ventana
		ImageIcon logo = Imagenes.createImageIcon(this, Imagenes.PATH_LOGO);
		setIconImage(logo.getImage());

		// ventana inicio
		this.ventanaInicio = ventanaInicio;

		// panel
		panelLogin = new PanelLogin();
		setContentPane(panelLogin);

		// EVENTOS
		ventanaLoginControlador = new VentanaLoginControlador(this);
		ventanaLoginControlador.eventoBotonIniciarSesion();
		ventanaLoginControlador.eventoBotonCancelar();
	}

	public VentanaInicio getVentanaInicio() {
		return ventanaInicio;
	}

	public void setVentanaInicio(VentanaInicio ventanaInicio) {
		this.ventanaInicio = ventanaInicio;
	}

	public PanelLogin getPanelLogin() {
		return panelLogin;
	}

	public void setPanelLogin(PanelLogin panelLogin) {
		this.panelLogin = panelLogin;
	}

}
