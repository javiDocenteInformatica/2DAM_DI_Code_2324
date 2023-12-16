/**
 * 
 */
package utiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class UtilesTest {

	private JButton boton;
	private JTextArea areaTexto;
	private JMenuItem menuItem;

	/**
	 * CONFIGURACIONES GLOBALES
	 */

	/**
	 * Se ejecuta una vez antes de que comiencen todas las pruebas.
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception{
		// Puedes realizar configuraciones globales aquí antes de que comiencen todas las pruebas.
		
		
		//boton = new JButton();
		
	}

	/**
	 * Se ejecuta una vez después de que se completan todas las pruebas.
	 *
	 * @throws java.lang.Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		// Puedes realizar limpiezas globales aquí después de que se completan todas las
		// pruebas.
		
//		boton = null;
	}

	/**
	 * Se ejecuta antes de cada prueba individual.
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		// Puedes realizar configuraciones específicas de la prueba aquí antes de cada
		// prueba.
		boton = new JButton();
		areaTexto = new JTextArea();
		menuItem = new JMenuItem();
	}

	/**
	 * Se ejecuta después de cada prueba individual.
	 *
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
		// Puedes realizar limpiezas específicas de la prueba aquí después de cada
		// prueba.
		
		boton = null;
		areaTexto = null;
		menuItem = null;
	}

	/**
	 * TESTS
	 */

	@DisplayName("comprobar que el método 'getClassName' obitiene el nombre de la clase proporcionada")
	@Test
	public void pruebaObtenerNombreDeClase() {
		// Configuración
//		JButton boton = new JButton();

		// Acción
		String nombreClase = Utiles.getClassName(boton);

		// Verificación
		assertEquals("JButton", nombreClase);
	}

	@Test
	public void pruebaCrearImageIcon() {

		// Obtenemos el directorio de trabajo actual
		String directorioActual = System.getProperty("user.dir");

		// Imprime el directorio de trabajo actual
		System.out.println("Directorio de trabajo actual: " + directorioActual);

		// Obtenemos el separador de rutas del sistema
		String separadorRuta = System.getProperty("file.separator");
		System.out.println(String.format("Separador path de java: %s", separadorRuta));

		// Configuración
//	        src\\main\\java\\assets\\middle.gif
//	        src\\test\\java\\utiles\\UtilesTest.java
//	    	String rutaImagen = String.format("%s%s%s%s%s%s%s%s%s%s%s",directorioActual,separadorRuta,"src",separadorRuta,"main",separadorRuta,"java",separadorRuta,"assets",separadorRuta,"middle.gif");

		String rutaImagen = String.format("%s%s%s%s%s", "..", separadorRuta, "assets", separadorRuta, "middle.gif");

		// Acción
		ImageIcon icono = Utiles.createImageIcon(Utiles.class,rutaImagen);

		// Verificación
		assertNotNull(icono);
	}

	@Test
	public void pruebaCargarFuentes() {
		// Configuración
		String nombreFuente = Utiles.ROBOTO_BOLD;
		int tamanoFuente = 14;

		// Acción
		Font fuente = Utiles.cargaFuentes(nombreFuente, tamanoFuente);

		// Verificación
		assertNotNull(fuente);
		assertEquals(nombreFuente, fuente.getFontName());
		assertEquals(Font.PLAIN, fuente.getStyle());
		assertEquals(tamanoFuente, fuente.getSize());
	}

	@Test
	public void pruebaConvierteRGBdeHEX() {
		// Configuración
		String colorHex = "FF5733"; // Hexadecimal para un color naranja

		// Acción
		Color color = Utiles.convierteRGBdeHEX(colorHex);

		// Verificación
		assertNotNull(color);
		assertEquals(255, color.getRed());
		assertEquals(87, color.getGreen());
		assertEquals(51, color.getBlue());
	}

	@Test
	public void pruebaImprimirClavesUIManager() {
		// Acción
		Utiles.printUIManagerKeys();

		// No hay assertions porque este método imprime en la consola.
	}

	@Test
	public void pruebaMensajeAreaTexto_ItemEvent() {
		// Configuración
//		JTextArea areaTexto = new JTextArea();
//		JMenuItem menuItem = new JMenuItem("ItemDePrueba");
		menuItem.setText("ItemDePrueba");
		ItemEvent eventoItem = new ItemEvent(menuItem, ItemEvent.ITEM_STATE_CHANGED, menuItem, ItemEvent.SELECTED);

		// Acción
		Utiles.mensajeAreaTexto(eventoItem, menuItem, areaTexto);

		// Verificación
		String mensajeEsperado = "Evento de ítem detectado." + Utiles.NEW_LINE
				+ "    Fuente del evento: ItemDePrueba (una instancia de JMenuItem)" + Utiles.NEW_LINE
				+ "    Nuevo estado: seleccionado" + Utiles.NEW_LINE;
		assertEquals(mensajeEsperado, areaTexto.getText());
	}

	@Test
	public void pruebaMensajeAreaTexto_ActionEvent() {
		// Configuración
		JTextArea areaTexto = new JTextArea();
		JMenuItem menuItem = new JMenuItem("ItemDePrueba");
		ActionEvent eventoAccion = new ActionEvent(menuItem, ActionEvent.ACTION_PERFORMED, "comando");

		// Acción
		Utiles.mensajeAreaTexto(eventoAccion, menuItem, areaTexto);

		// Verificación
		String mensajeEsperado = "Evento de acción detectado." + Utiles.NEW_LINE
				+ "    Fuente del evento: ItemDePrueba (una instancia de JMenuItem)" + Utiles.NEW_LINE;
		assertEquals(mensajeEsperado, areaTexto.getText());
	}

	@Test
	public void pruebaCentrarEnPantalla() {
		// Configuración
		JFrame frame = new JFrame();

		// Acción
		Utiles.centrarEnPantalla(frame);

		// Verificación
		assertEquals(new Point(frame.getWidth() / 3, frame.getHeight() / 3), frame.getLocation());
	}

	@Test
	public void pruebaToolTip() {
		// Configuración
		boton = new JButton("BotonDePrueba");

		// Acción
		Utiles.toolTip(boton, "Este es un tooltip de prueba");

		// Verificación
		assertEquals("Este es un tooltip de prueba", boton.getToolTipText());
	}

}
