package ies.atocheortegajavier.vista.inicio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import ies.atocheortegajavier.utiles.Imagenes;
import ies.atocheortegajavier.utiles.Textos;

public class PanelInicio extends JPanel {

	// PROPIEDADES

	private static final long serialVersionUID = 1L;

	// panel
	private JPanel jpanelBotones;

	// jlabel descripcion
	private JTextArea jtextareaDescripcion;

	// jlabel logo
	private JLabel jlabelLogo;

	// botones
	private JButton jbuttonIniciarSesion;
	private JButton jbuttonRegistrarse;

	// CONSTRUCTORES

	public PanelInicio() {

		// panel
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout());

		// JLabel TEXTO
		this.jtextareaDescripcion = new JTextArea();
		this.jtextareaDescripcion.setText(Textos.DESCRIPCION);
		this.jtextareaDescripcion.setEditable(false);
		this.jtextareaDescripcion.setSize(500, 400);
		this.jtextareaDescripcion.setLineWrap(true);// https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/JTextArea.html#setLineWrap(boolean)
		this.jtextareaDescripcion.setWrapStyleWord(true);// https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/javax/swing/JTextArea.html#setWrapStyleWord(boolean)

		// JLabel LOGO
		this.jlabelLogo = new JLabel();

		ImageIcon logo = Imagenes.createImageIcon(this, Imagenes.PATH_LOGO);
		this.jlabelLogo.setIcon(logo);

		// BOTONES
		this.jpanelBotones = new JPanel(new FlowLayout());
		this.jbuttonIniciarSesion = new JButton(Textos.BOTON_INICIAR_SESION);
		this.jbuttonRegistrarse = new JButton(Textos.BOTON_REGISTRARSE);

		// ANYADIR COMPONENTES AL PANEL
		// norte
		this.add(jlabelLogo, BorderLayout.NORTH);

		// centro
		this.add(jtextareaDescripcion, BorderLayout.CENTER);

		// sur
		this.jpanelBotones.add(jbuttonIniciarSesion);
		this.jpanelBotones.add(jbuttonRegistrarse);
		this.add(jpanelBotones, BorderLayout.SOUTH);


	}

	// GETTERS Y SETTERS
	public JPanel getJpanelBotones() {
		return jpanelBotones;
	}

	public void setJpanelBotones(JPanel jpanelBotones) {
		this.jpanelBotones = jpanelBotones;
	}

	public JTextArea getJtextareaDescripcion() {
		return jtextareaDescripcion;
	}

	public void setJtextareaDescripcion(JTextArea jtextareaDescripcion) {
		this.jtextareaDescripcion = jtextareaDescripcion;
	}

	public JLabel getJlabelLogo() {
		return jlabelLogo;
	}

	public void setJlabelLogo(JLabel jlabelLogo) {
		this.jlabelLogo = jlabelLogo;
	}

	public JButton getJbuttonIniciarSesion() {
		return jbuttonIniciarSesion;
	}

	public void setJbuttonIniciarSesion(JButton jbuttonIniciarSesion) {
		this.jbuttonIniciarSesion = jbuttonIniciarSesion;
	}

	public JButton getJbuttonRegistrarse() {
		return jbuttonRegistrarse;
	}

	public void setJbuttonRegistrarse(JButton jbuttonRegistrarse) {
		this.jbuttonRegistrarse = jbuttonRegistrarse;
	}

}
