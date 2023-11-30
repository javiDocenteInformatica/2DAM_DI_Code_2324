/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import controlador.PopupMenuContextEventsManager;
import controlador.PopupMenuEventsManager;
import controlador.PopupMenuItemEventsManager;
import utiles.Utiles;

/* PopupMenuDemo.java requires images/middle.gif. */

/*
 * Like MenuDemo, but with popup menus added.
 */
public class PopupMenuDemo {

	private JFrame frame;
	private JPanel contentPane;

	private JMenuBar menuBar;
	private JMenu menu1, menu2, submenu;
	private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5;
	private JRadioButtonMenuItem rbMenuItem1, rbMenuItem2;
	private JCheckBoxMenuItem cbMenuItem1, cbMenuItem2;

	private JMenuItem menuItem1Contextual, menuItem2Contextual;

	private JPopupMenu popup;

	private JTextArea output;
	private JScrollPane scrollPane;

	public PopupMenuDemo() {

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	public void createAndShowGUI() {
		// Create and set up the window.
		frame = new JFrame("PopupMenuDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Centrar el Frame en pantalla
		Utiles.centrarEnPantalla(frame);

		// Create/set menu bar and content pane.
		frame.setContentPane(this.createContentPane());
		frame.setJMenuBar(this.createMenuBar());

		// Create and set up the popup menu.
		this.createPopupMenu();

		// Display the window.
		frame.setSize(600, 300);
		frame.setVisible(true);

		// Añade un WindowListener personalizado (PopupMenuEventsManager) al JFrame
		// (frame).
		frame.addWindowListener(new PopupMenuEventsManager(frame));

		// TOOLTIPS
//		 menuBar, menu1, menu2, submenu, menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, rbMenuItem1, rbMenuItem2, cbMenuItem1, cbMenuItem2, menuItem1Contextual, menuItem2Contextual, popup, output, scrollPane;

		// Establece un tooltip para la barra de menú, proporcionando información general sobre sus opciones.
		Utiles.toolTip(menuBar, "Esta es la barra de menú, en ella encontraremos múltiples opciones, entre ellas: '"
						+ menu1.getText() + "', '" + menu2.getText() + "'");

		// Establece un tooltip para el primer menú, describiendo las acciones y los elementos que se pueden encontrar.
		Utiles.toolTip(menu1,
						"En este menú encontraremos diferentes acciones. Estás acciones son de prueba, y podemos encontrar elementos como: 'JMenuItem', 'JRadioButtonMenuItem', 'JCheckBoxMenuItem', 'JPopupMenu', 'JTextArea' y 'JScrollPane' ");

		
		/**
		 * El resto de elementos los haré de muestra, se debería añadir un mensaje con información más útil, esto solo es un ejemplo:
		 */
		// Tooltips para los elementos restantes
		Utiles.toolTip(menu2, "Otro menú de ejemplo con opciones adicionales.");

		Utiles.toolTip(submenu, "Un submenú que contiene más opciones.");

		Utiles.toolTip(menuItem1, "Un elemento de menú de prueba con acción asociada.");

		Utiles.toolTip(menuItem2, "Otro elemento de menú con acción asociada y un ícono.");

		Utiles.toolTip(menuItem3, "Un tercer elemento de menú con solo un ícono.");

		Utiles.toolTip(rbMenuItem1, "Un elemento de menú de radio button (seleccionable).");

		Utiles.toolTip(rbMenuItem2, "Otro elemento de radio button en un grupo.");

		Utiles.toolTip(cbMenuItem1, "Un elemento de menú de casilla de verificación (check box).");

		Utiles.toolTip(cbMenuItem2, "Otro elemento de casilla de verificación.");

		Utiles.toolTip(popup, "Un menú emergente con opciones adicionales.");

		Utiles.toolTip(output, "Área de texto para mostrar resultados y mensajes.");

		Utiles.toolTip(scrollPane, "Un área de desplazamiento para el texto largo.");

		Utiles.toolTip(menuItem1Contextual, "Elemento de menú contextual 1.");

		Utiles.toolTip(menuItem2Contextual, "Elemento de menú contextual 2.");


	}

	public JMenuBar createMenuBar() {

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		menu1 = new JMenu("A Menu");
		menu1.setMnemonic(KeyEvent.VK_A);
		menu1.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu1);

		// a group of JMenuItems
		menuItem1 = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
		// menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem1.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menuItem1.addActionListener(new PopupMenuEventsManager(output));
		menu1.add(menuItem1);

		ImageIcon icon = Utiles.createImageIcon("../assets/middle.gif");
		menuItem2 = new JMenuItem("Both text and icon", icon);
		menuItem2.setMnemonic(KeyEvent.VK_B);
		menuItem2.addActionListener(new PopupMenuEventsManager(output));
		menu1.add(menuItem2);

		menuItem3 = new JMenuItem(icon);
		menuItem3.setMnemonic(KeyEvent.VK_D);
		menuItem3.addActionListener(new PopupMenuEventsManager(output));
		menu1.add(menuItem3);

		// a group of radio button menu items
		menu1.addSeparator();
		ButtonGroup group = new ButtonGroup();

		rbMenuItem1 = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem1.setSelected(true);
		rbMenuItem1.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem1);
		rbMenuItem1.addActionListener(new PopupMenuEventsManager(output));
		menu1.add(rbMenuItem1);

		rbMenuItem2 = new JRadioButtonMenuItem("Another one");
		rbMenuItem2.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem2);
		rbMenuItem2.addActionListener(new PopupMenuEventsManager(output));
		menu1.add(rbMenuItem2);

		// a group of check box menu items
		menu1.addSeparator();
		cbMenuItem1 = new JCheckBoxMenuItem("A check box menu item");
		cbMenuItem1.setMnemonic(KeyEvent.VK_C);
		cbMenuItem1.addItemListener(new PopupMenuItemEventsManager(output));
		menu1.add(cbMenuItem1);

		cbMenuItem2 = new JCheckBoxMenuItem("Another one");
		cbMenuItem2.setMnemonic(KeyEvent.VK_H);
		cbMenuItem2.addItemListener(new PopupMenuItemEventsManager(output));
		menu1.add(cbMenuItem2);

		// a submenu
		menu1.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem4 = new JMenuItem("An item in the submenu");
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem4.addActionListener(new PopupMenuEventsManager(output));
		submenu.add(menuItem4);

		menuItem5 = new JMenuItem("Another item");
		menuItem5.addActionListener(new PopupMenuEventsManager(output));
		submenu.add(menuItem5);
		menu1.add(submenu);

		// Build second menu in the menu bar.
		menu2 = new JMenu("Another Menu");
		menu2.setMnemonic(KeyEvent.VK_N);
		menu2.getAccessibleContext().setAccessibleDescription("This menu does nothing");
		menuBar.add(menu2);

		/**
		 * FUENTES
		 */

		menu1.setFont(Utiles.cargaFuentes(Utiles.POPPINS_BOLD, 16));
		menu2.setFont(Utiles.cargaFuentes(Utiles.POPPINS_BOLD_ITALIC, 16));
		submenu.setFont(Utiles.cargaFuentes(Utiles.POPPINS_REGULAR, 14));

		menuItem1.setFont(Utiles.cargaFuentes(Utiles.ROBOTO_BLACK, 12));
		menuItem2.setFont(Utiles.cargaFuentes(Utiles.ROBOTO_BLACK_ITALIC, 12));
		menuItem3.setFont(Utiles.cargaFuentes(Utiles.ROBOTO_BOLD, 12));
		menuItem4.setFont(Utiles.cargaFuentes(Utiles.RALEWAY_BOLD, 12));
		menuItem5.setFont(Utiles.cargaFuentes(Utiles.RALEWAY_BOLD_ITALIC, 12));

		rbMenuItem1.setFont(Utiles.cargaFuentes(Utiles.RALEWAY_MEDIUM, 10));
		rbMenuItem2.setFont(Utiles.cargaFuentes(Utiles.ROBOTO_BLACK_ITALIC, 10));

		cbMenuItem1.setFont(Utiles.cargaFuentes(Utiles.POPPINS_BOLD_ITALIC, 10));
		cbMenuItem2.setFont(Utiles.cargaFuentes(Utiles.RALEWAY_BOLD_ITALIC, 10));
//        cbMenuItem3.setFont(Utiles.cargaFuentes(Utiles.ROBOTO_BLACK, 10));
//        cbMenuItem4.setFont(Utiles.cargaFuentes(Utiles.POPPINS_REGULAR, 10));

		output.setFont(Utiles.cargaFuentes(Utiles.POPPINS_BOLD_ITALIC, 15));

		/**
		 * COLORES
		 */

		// Establece la propiedad opaca como verdadera para que el color de fondo sea
		// visible
		menu1.setOpaque(true);
		menu2.setOpaque(true);
		submenu.setOpaque(true);

		// Establece el color de fondo y el color de primer plano del primer menú
		menu1.setBackground(Utiles.convierteRGBdeHEX(Utiles.COLOR_ROJO1)); // Color de fondo rojo oscuro
		menu1.setForeground(Color.WHITE); // Color de primer plano blanco

		// Establece el color de fondo y el color de primer plano del segundo menú
		menu2.setBackground(Utiles.convierteRGBdeHEX(Utiles.COLOR_MARRON1)); // Color de fondo marrón oscuro
		menu2.setForeground(Color.WHITE); // Color de primer plano blanco

		// Establece el color de fondo y el color de primer plano del submenú
		submenu.setBackground(Utiles.convierteRGBdeHEX(Utiles.COLOR_AZUL1)); // Color de fondo azul oscuro
		submenu.setForeground(Color.WHITE); // Color de primer plano blanco

		// Establece el color de fondo y el color de primer plano del área de salida
		// (JTextArea)
		output.setBackground(Utiles.convierteRGBdeHEX(Utiles.COLOR_MARRON2)); // Color de fondo beige claro
		output.setForeground(Color.WHITE); // Color de primer plano blanco

		return menuBar;
	}

	public Container createContentPane() {
		// Create the content-pane-to-be.
		contentPane = new JPanel(new BorderLayout());
		contentPane.setOpaque(true);

		// Create a scrolled text area.
		output = new JTextArea(5, 30);
		output.setEditable(false);
		scrollPane = new JScrollPane(output);

		// Add the text area to the content pane.
		contentPane.add(scrollPane, BorderLayout.CENTER);

		return contentPane;
	}

	public JPopupMenu createPopupMenu() {

		// Create the popup menu.
		popup = new JPopupMenu();
		menuItem1Contextual = new JMenuItem("A popup menu item");
		menuItem1Contextual.addActionListener(new PopupMenuEventsManager(output));
		popup.add(menuItem1Contextual);
		menuItem2Contextual = new JMenuItem("Another popup menu item");
		menuItem2Contextual.addActionListener(new PopupMenuEventsManager(output));
		popup.add(menuItem2Contextual);

		// Add listener to the text area so the popup menu can come up.
		MouseListener popupListener = new PopupMenuContextEventsManager(popup);
		output.addMouseListener(popupListener);

		/**
		 * FUENTES
		 */
		// Configurar la fuente para menuItem1 utilizando la fuente RALEWAY_MEDIUM con
		// tamaño 14
		menuItem1Contextual.setFont(Utiles.cargaFuentes(Utiles.RALEWAY_MEDIUM, 14));

		// Configurar la fuente para menuItem2 utilizando la fuente POPPINS_BOLD_ITALIC
		// con tamaño 15
		menuItem2Contextual.setFont(Utiles.cargaFuentes(Utiles.POPPINS_BOLD_ITALIC, 15));

		/**
		 * COLORES
		 * 
		 * Cambiar el color de fondo y letra de los JMenuItems del POPUP no funciona
		 * 
		 */
		// Establecer la opacidad del componente popup en true
		popup.setOpaque(true);

		// Establecer el color de fondo del componente popup utilizando el método
		// convierteRGBdeHEX con el color "C25E5E"
		popup.setBackground(Utiles.convierteRGBdeHEX(Utiles.COLOR_ROJO1));

		// Establecer el color de primer plano (foreground) del componente popup
		// utilizando el método convierteRGBdeHEX con el color "FFE4E1"
		popup.setForeground(Utiles.convierteRGBdeHEX(Utiles.COLOR_ROJO2));

		
		return popup;
	}

}
