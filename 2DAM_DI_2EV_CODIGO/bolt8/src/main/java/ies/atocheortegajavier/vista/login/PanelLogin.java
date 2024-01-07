package ies.atocheortegajavier.vista.login;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;

public class PanelLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblUsuario;
	private JTextField txtFdUsuario;
	private JLabel lblContrasenya;
	private JPasswordField txtFdContrasenya;
	private JButton btnIniciarSesion;
	private JButton btnCancelar;
	private JTextPane textPane;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		
		// panel
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// LAYOUT
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 50, 50, 50, 0, 50, 50, 50,0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,Double.MIN_VALUE ,Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setToolTipText("Nombre de Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridwidth = 3;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 2;
		
		
		txtFdUsuario = new JTextField();
		lblUsuario.setLabelFor(txtFdUsuario);
		txtFdUsuario.setToolTipText("Introduce el nombre de usuario");
		GridBagConstraints gbc_txtFdUsuario = new GridBagConstraints();
		gbc_txtFdUsuario.gridwidth = 5;
		gbc_txtFdUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtFdUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFdUsuario.gridx = 4;
		gbc_txtFdUsuario.gridy = 2;
		txtFdUsuario.setColumns(10);
		
		lblContrasenya = new JLabel("Contraseña:");
		lblContrasenya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenya.setToolTipText("Contraseña");
		GridBagConstraints gbc_lblContrasenya = new GridBagConstraints();
		gbc_lblContrasenya.anchor = GridBagConstraints.EAST;
		gbc_lblContrasenya.gridwidth = 3;
		gbc_lblContrasenya.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasenya.gridx = 1;
		gbc_lblContrasenya.gridy = 4;
		
		
		txtFdContrasenya = new JPasswordField();
		lblContrasenya.setLabelFor(txtFdContrasenya);
		txtFdContrasenya.setToolTipText("Introduce la contraseña");
		GridBagConstraints gbc_txtFdContrasenya = new GridBagConstraints();
		gbc_txtFdContrasenya.gridwidth = 5;
		gbc_txtFdContrasenya.insets = new Insets(0, 0, 5, 5);
		gbc_txtFdContrasenya.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFdContrasenya.gridx = 4;
		gbc_txtFdContrasenya.gridy = 4;
		
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setToolTipText("Clic para iniciar sesión");
		GridBagConstraints gbc_btnIniciarSesion = new GridBagConstraints();
		gbc_btnIniciarSesion.gridwidth = 2;
		gbc_btnIniciarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciarSesion.gridx = 4;
		gbc_btnIniciarSesion.gridy = 6;
		
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setToolTipText("Clic para cancelar y volver a inicio");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 6;
		
		
		
		textPane = new JTextPane();
		textPane.setToolTipText("Información el resultado del inicio de sesión");
		textPane.setEnabled(false);
		textPane.setBackground(new Color(255, 255, 255));
		textPane.setEditable(false);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 2;
		gbc_textPane.gridwidth = 5;
		gbc_textPane.insets = new Insets(0, 0, 0, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 4;
		gbc_textPane.gridy = 8;
		textPane.setVisible(false);
		
		
		// Anyadir componentes
		add(lblUsuario, gbc_lblUsuario);
		add(txtFdUsuario, gbc_txtFdUsuario);
		add(lblContrasenya, gbc_lblContrasenya);
		add(txtFdContrasenya, gbc_txtFdContrasenya);
		add(btnIniciarSesion, gbc_btnIniciarSesion);
		add(btnCancelar, gbc_btnCancelar);
		add(textPane, gbc_textPane);
		
		
		
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public JTextField getTxtFdUsuario() {
		return txtFdUsuario;
	}

	public void setTxtFdUsuario(JTextField txtFdUsuario) {
		this.txtFdUsuario = txtFdUsuario;
	}

	public JLabel getLblContrasenya() {
		return lblContrasenya;
	}

	public void setLblContrasenya(JLabel lblContrasenya) {
		this.lblContrasenya = lblContrasenya;
	}

	public JPasswordField getTxtFdContrasenya() {
		return txtFdContrasenya;
	}

	public void setTxtFdContrasenya(JPasswordField txtFdContrasenya) {
		this.txtFdContrasenya = txtFdContrasenya;
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}

}
