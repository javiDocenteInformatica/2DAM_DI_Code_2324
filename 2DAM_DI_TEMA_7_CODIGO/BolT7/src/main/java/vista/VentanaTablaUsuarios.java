package vista;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import utiles.Utiles;

public class VentanaTablaUsuarios extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel panelTablaUsuarios;
    private JScrollPane scrollPane;

    /**
     * Create the frame.
     */
    public VentanaTablaUsuarios() {
        this.setModal(true);
        this.setTitle(Utiles.TITULO_VENTANA_USUARIOS);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 450, 300);

        panelTablaUsuarios = new PanelTablaUsuarios();
        panelTablaUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));

        JTable tablaUsuarios = panelTablaUsuarios.getTablaUsuarios();
        
        scrollPane = new JScrollPane(tablaUsuarios);
//        scrollPane.add();

        this.add(scrollPane);
        
        this.setContentPane(panelTablaUsuarios);

        this.setLocationRelativeTo(null);

    }

}
