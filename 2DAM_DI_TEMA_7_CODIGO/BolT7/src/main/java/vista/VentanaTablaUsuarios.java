package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utiles.Utiles;

public class VentanaTablaUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public VentanaTablaUsuarios() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		contentPane = new PanelTablaUsuarios();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setTitle(Utiles.TITULO_VENTANA_USUARIOS);
		this.setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		
	}

}
