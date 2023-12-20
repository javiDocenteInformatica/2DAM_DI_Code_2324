/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import utiles.Utiles;
import vista.PopupMenuDemo;
import vista.VentanaAccionesUsuario;

/**
 *
 * @author profesor
 */
public class PopupMenuDemoControlador {

    private PopupMenuDemo popupMenuDemo;

    public PopupMenuDemoControlador(PopupMenuDemo popupMenuDemo) {
        this.popupMenuDemo = popupMenuDemo;
        
         // AÑADE TODOS LOS EVENTS LISTENERS A LOS COMPONENTES DE LA CLASE
        this.anyadeEventsListeners();
    }

    public void muestraMensajeAreaTexto(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) (e.getSource());

        Utiles.mensajeAreaTexto(e, menuItem, popupMenuDemo.getOutput());
//		String s = "Action event detected." + Utiles.NEW_LINE + "    Event source: " + menuItem.getText()
//				+ " (an instance of " + Utiles.getClassName(menuItem) + ")";
//		output.append(s + Utiles.NEW_LINE);
//		output.setCaretPosition(output.getDocument().getLength());
    }

    public void muestraMensajeAreaTexto(ItemEvent e) {
        JMenuItem menuItem = (JMenuItem) (e.getSource());

        Utiles.mensajeAreaTexto(e, menuItem, popupMenuDemo.getOutput());
//		String s = "Action event detected." + Utiles.NEW_LINE + "    Event source: " + menuItem.getText()
//				+ " (an instance of " + Utiles.getClassName(menuItem) + ")";
//		output.append(s + Utiles.NEW_LINE);
//		output.setCaretPosition(output.getDocument().getLength());
    }

    public void gestionaCierreVentana(WindowEvent e) {
        // Configurar el texto y los botones en español
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");

        // Mostrar un JOptionPane para confirmar el cierre de la ventana
        int result = JOptionPane.showConfirmDialog(popupMenuDemo.getFrame(), "¿Estás seguro de que quieres cerrar la ventana?",
                "Confirmar cierre", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            // Si el usuario elige "Sí", cerrar la ventana
            popupMenuDemo.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            // Si el usuario elige "No", simplemente ignora el evento de cierre de la ventana
            popupMenuDemo.getFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    public void muestraVentanaAccionesUsuario(ActionEvent e) {
        VentanaAccionesUsuario ventanaAccionesUsuarios = new VentanaAccionesUsuario();
        ventanaAccionesUsuarios.setVisible(true);
    }

    /**
     * Método privado que determina si se debe mostrar el menú emergente o no.
     *
     * @param e El evento del mouse asociado.
     */
    public void maybeShowPopup(MouseEvent e) {
        /*
		 * El método isPopupTrigger() es un método de la clase MouseEvent en Java que se
		 * utiliza para determinar si el evento del mouse es un desencadenador de menú
		 * emergente.
		 * 
		 * En el contexto de un MouseAdapter o un MouseListener, este método se usa
		 * comúnmente para verificar si se ha hecho clic con el botón del mouse que
		 * generalmente desencadena los menús emergentes (por lo general, el botón
		 * derecho del mouse en entornos basados en ventanas).
		 * 
		 * Devuelve true si el evento del mouse tiene que desencadenar la aparición de
		 * un menú emergente, y false en caso contrario.
		 * 
         */
        if (e.isPopupTrigger()) {
            // Muestra el menú emergente en la posición del evento del mouse.
            popupMenuDemo.getPopup().show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
    
    // Método para añadir todos los Events Listeners a los componentes de esta clase
    public void anyadeEventsListeners() {

        popupMenuDemo.getFrame().addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                gestionaCierreVentana(e);
            }
        });

        popupMenuDemo.getMenuItem1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraMensajeAreaTexto(e);
            }
        });

        popupMenuDemo.getMenuItem2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraMensajeAreaTexto(e);
            }
        });

        popupMenuDemo.getMenuItem3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraMensajeAreaTexto(e);
            }
        });

        popupMenuDemo.getRbMenuItem1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraMensajeAreaTexto(e);
            }
        });

        popupMenuDemo.getRbMenuItem2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraMensajeAreaTexto(e);
            }
        });

        popupMenuDemo.getCbMenuItem1().addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                muestraMensajeAreaTexto(e);
            }

        });
        popupMenuDemo.getCbMenuItem2().addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                muestraMensajeAreaTexto(e);
            }

        });

        popupMenuDemo.getMenuItem4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraMensajeAreaTexto(e);
            }
        });

        popupMenuDemo.getMenuItem5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraMensajeAreaTexto(e);
            }
        });

        popupMenuDemo.getMenuItem1Contextual().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraMensajeAreaTexto(e);
            }
        });

        popupMenuDemo.getMenuItem2Contextual().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraMensajeAreaTexto(e);
            }
        });

        popupMenuDemo.getMenu2Item1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraVentanaAccionesUsuario(e);
            }
        });

        popupMenuDemo.getOutput().addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }

        });

    }

}
