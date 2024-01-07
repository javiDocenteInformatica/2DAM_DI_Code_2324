package ies.atocheortegajavier.vista.inicio;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import ies.atocheortegajavier.controlador.VentanaInicioControlador;
import ies.atocheortegajavier.utiles.Imagenes;
import ies.atocheortegajavier.utiles.Tamanyos;
import ies.atocheortegajavier.utiles.Textos;

public class VentanaInicio extends JFrame implements IVentanaInicio {

	private static final long serialVersionUID = 1L;
	private VentanaInicioControlador ventanaInicioControlador;
	private PanelInicio panelInicio;
	private ImageIcon logo;

	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// cambia tamanyo de la ventana
		setSize(Tamanyos.W_650, Tamanyos.H_500);

		// evita que cambie el tamanyo de la ventana
		setResizable(false);

		// centra la ventana en mitad de la pantalla
		setLocationRelativeTo(null);

		// titulo de la ventana
		setTitle(Textos.TITULO_VENTANA_INICIO);

		// icono de la ventana
		ImageIcon logo = Imagenes.createImageIcon(this, Imagenes.PATH_LOGO);
		setIconImage(logo.getImage());
		
		// panel
		panelInicio = new PanelInicio();
		setContentPane(panelInicio);
		
		// EVENTOS
		ventanaInicioControlador = new VentanaInicioControlador(this);
		ventanaInicioControlador.eventoBotonIniciarSesion();
		
	}

	
	// GETTER Y SETTER
	public PanelInicio getPanelInicio() {
		return panelInicio;
	}

	public void setPanelInicio(PanelInicio panelInicio) {
		this.panelInicio = panelInicio;
	}

	


}
