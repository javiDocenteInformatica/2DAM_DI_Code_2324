package vista;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Component;

import javax.swing.JMenuBar;

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

	@Test
	public void testClickMenu() {
		JMenuBar jMenuBar = popupMenuDemo.createMenuBar();
		
		Component[] componentes = jMenuBar.getComponents();
		for (int i=0; i< componentes.length; i++) {
			System.out.println(componentes[i].toString());
		}
	}

	@Test
	public void testClickMenuItem() {

	}

	@Test
	public void testHoverSubmenu() {

	}

}
