package vista;

import utiles.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//La anotación @TestInstance se utiliza para especificar el ciclo de vida de las instancias de prueba.
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//@Disabled ("CLASE PopupMenuDemoTest deshabilitado por el momento")
//@ExtendWith(MockitoExtension.class)
public class PopupMenuDemoTest {

//        @Mockito
    private PopupMenuDemo popupMenuDemo = new PopupMenuDemo();

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
//	@Test
//	public void testCreateContentPane() {
//		assertNotNull(popupMenuDemo.createContentPane());
//
//	}
    // Prueba para verificar la creación del menú emergente.
    @Test
    public void testCreatePopupMenu() {
        assertNotNull(popupMenuDemo.createPopupMenu());

    }

    /**
     * En este test se pretende probar que se selecciona correctamente un menú
     * (JMenu). Esta selección es un sombreado del menú (componente). Es
     * diferente seleccionar que hacer click.
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
            MenuElement[] path = {jMenuBar, menu};
            MenuSelectionManager.defaultManager().setSelectedPath(path);

            // Realiza las verificaciones necesarias después del clic en el menú
            assertTrue(menu.isSelected());
        }
    }

    /**
     * En este test se pretende probar que se hace click correctamente en un
     * menú (JMenu). Al hacer click en el menú, este debe abrirse. Se debe
     * comprobar que efectivamente se abre el menú..
     */
    @Test
    public void testClickMenuItem() {
        // TODO

        /*
		 * -> Creamos una variable para almacenar si se ha activado el evento.
		 * 
		 * -> Se crea un array debido a que no es posible acceder una variable en el
		 * contexto del "actionPeformed", pero con un array si es posible ya que un
		 * array se pasa como referencia a memoria, por tanto nos permite modificar su
		 * valor, aunque sea "final".
		 * 
		 * -> "final" lo utilizamos para optimizar la memoria que se utiliza, ya que a
		 * pesar de ser "final" al ser un valor referenciado en memoria, podemos
		 * modificarlo.
         */
        final boolean itemSelected[] = {false};

        // Creamos un JMenuBar utilizando el método createMenuBar de popupMenuDemo.
        JMenuBar jMenuBar = popupMenuDemo.createMenuBar();

        // Obtenemos el primer menú de "jMenuBar", y si es nulo, creamos un nuevo JMenu
        JMenu jMenu1 = jMenuBar.getMenu(0);
        jMenu1 = (jMenu1 != null) ? jMenu1 : new JMenu("No hay menú");

        // Obtenemos el primer JMenuItem de "jMenu1", y si es nulo, creamos un nuevo
        // JMenuItem
        JMenuItem jMenuItem1 = jMenu1.getItem(0);
        jMenuItem1 = (jMenuItem1 != null) ? jMenuItem1 : new JMenuItem("No hay item");

        // Agregamos un ItemListener al JMenuItem para "escuchar" el cambio de estado
        jMenuItem1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {

                // Obtenemos el JMenuItem que ha lanzado el evento al ser seleccionado
                JMenuItem jMenuItem = (JMenuItem) evt.getSource();
                // Mostramos el texto del "jMenuItem" con colores por consola
                System.out.println(Utiles.ANSI_GREEN + "Cuando se lanza 'itemStateChanged' el JMenuItem lanzado tiene el texto: "
                        + Utiles.ANSI_RED + jMenuItem.getText());
                System.out.println();

                // Verificamos si el estado del item es "SELECTED"
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    // Cuando se activa el evento, establecemos la variable en "true"
                    itemSelected[0] = true;
                }
            }
        });

        // Mostramos la variable "itemSelected[0]" ANTES de que sea seleccionada
        String mensajeConsola = "ANTES de ejecutar automáticamente la selección de un JMenuItem";
        System.out.println(String.format("%s: %b", mensajeConsola, itemSelected[0]));

        // Simulamos el evento ItemEvent con estado "SELECTED"
        ItemEvent itemEvent = new ItemEvent(jMenuItem1, ItemEvent.ITEM_STATE_CHANGED, jMenuItem1, ItemEvent.SELECTED);
        ItemListener itemListener = jMenuItem1.getItemListeners()[0];
        itemListener.itemStateChanged(itemEvent);

        // Mostramos la variable "itemSelected[0]" DESPUÉS de que sea seleccionada
        mensajeConsola = "DESPUÉS de ejecutar automáticamente la selección de un JMenuItem";
        System.out.println(String.format("%s: %b", mensajeConsola, itemSelected[0]));

        // Verificamos que la variable de "itemSelected" ahora sea true
        assertEquals(true, itemSelected[0]);

    }

    /**
     * Este test pretende probar, cuando el cursor está por encima de un submenú
     * (un JMenu dentro de otro JMenu), el submenú se abre correctamente. Se
     * debe simular que colocas el cursor encima del componente. Se debe
     * comprobar que el menú está desplegado.
     */
    @Test
    public void testHoverSubmenu() {
        // TODO

    }

}
