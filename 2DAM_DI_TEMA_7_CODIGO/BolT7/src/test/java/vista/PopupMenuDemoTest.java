package vista;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//La anotación @TestInstance se utiliza para especificar el ciclo de vida de las instancias de prueba.
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class PopupMenuDemoTest {

	private PopupMenuDemo popupMenuDemo;

	// Este método se ejecuta antes de cada método de prueba.
	@BeforeEach
	public void setUp() {
		popupMenuDemo = new PopupMenuDemo();

	}

	// Este método se ejecuta después de cada método de prueba.
	@AfterEach
	public void tearDown() {
		popupMenuDemo = null;
	}

	// Prueba para verificar la creación del menú bar.
	@Test
	public void testCreateMenuBar() {
		assertNotNull(popupMenuDemo.createMenuBar());

	}

	// Prueba para verificar la creación del contenido del panel.
	@Test
	public void testCreateContentPane() {
		assertNotNull(popupMenuDemo.createContentPane());

	}

	// Prueba para verificar la creación del menú emergente.
	@Test
	public void testCreatePopupMenu() {
		assertNotNull(popupMenuDemo.createPopupMenu());

	}

	/**
	 * En este test se pretende probar que se selecciona correctamente un menú (JMenu). 
	 * Esta  selección es un sombreado del menú (componente). Es diferente seleccionar que
	 * hacer click.
	 */
	@Test
	public void testSelectMenu() {
		JMenuBar jMenuBar = popupMenuDemo.createMenuBar();

		Component[] componentes = jMenuBar.getComponents();
		JMenu menu = null;
		for (int i = 0; i < componentes.length; i++) {
			menu = (JMenu) componentes[i];
//			System.out.println(menu.getText());
			// Crea un nuevo evento de selección para el menú
			MenuElement[] path = { jMenuBar, menu };
			MenuSelectionManager.defaultManager().setSelectedPath(path);

			// Realiza las verificaciones necesarias después del clic en el menú
			assertTrue(menu.isSelected());
		}
	}

	/**
	 * En este test se pretende probar que se hace click correctamente en un menú (JMenu). 
	 * Al hacer click en el menú, este debe abrirse.
	 * Se debe comprobar que efectivamente se abre el menú..
	 */
	@Test
	public void testClickMenuItem() {
		// TODO
		
		
		
		
	}

	
	/**
	 * Este test pretende probar, cuando el cursor está por encima de un submenú (un JMenu dentro de otro JMenu), el submenú se abre correctamente.
	 * Se debe simular que colocas el cursor encima del componente.
	 * Se debe comprobar que el menú está desplegado.
	 */
	@Test
	public void testHoverSubmenu() {
		// TODO
		
	}

}
