package utiles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import vista.PopupMenuDemo;

public class Utiles extends JComponent {

    public static final String NEW_LINE = "\n";

    // FUENTES
    public static final String ROBOTO_BLACK = "Roboto/Roboto-Black.ttf";
    public static final String ROBOTO_BLACK_ITALIC = "Roboto/Roboto-BlackItalic.ttf";
    public static final String ROBOTO_BOLD = "Roboto/Roboto-Bold.ttf";
    public static final String POPPINS_BOLD = "Poppins/Poppins-Bold.ttf";
    public static final String POPPINS_BOLD_ITALIC = "Poppins/Poppins-BoldItalic.ttf";
    public static final String POPPINS_REGULAR = "Poppins/Poppins-Regular.ttf";
    public static final String RALEWAY_BOLD = "Raleway/Raleway-Bold.ttf";
    public static final String RALEWAY_BOLD_ITALIC = "Raleway/Raleway-BoldItalic.ttf";
    public static final String RALEWAY_MEDIUM = "Raleway/Raleway-Medium.ttf";

    // COLORES
    public static final String COLOR_ROJO1 = "C25E5E";
    public static final String COLOR_ROJO2 = "FFE4E1";
    public static final String COLOR_MARRON1 = "574240";
    public static final String COLOR_MARRON2 = "BFA5A4";
    public static final String COLOR_AZUL1 = "005983";

    // COLORES CONSOLA
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    // TEXTOS JMenuItem
    public static final String TEXT_MENU2_ITEM1 = "Ver Tabla";

    // TEXTOS JFrame
    public static final String TITULO_VENTANA_USUARIOS = "Usuarios de la BBDD";

    // TEXTOS JPanel
    /**
     * Obtiene el nombre de la clase de un objeto.
     *
     * @param o El objeto del cual se quiere obtener el nombre de la clase.
     * @return El nombre de la clase del objeto.
     */
    public static String getClassName(Object o) {
        // Obtiene el nombre completo de la clase del objeto.
        String classString = o.getClass().getName();

        // Encuentra el índice del último punto (.) en el nombre de la clase.
        int dotIndex = classString.lastIndexOf(".");

        // Obtiene la subcadena después del último punto, que es el nombre de la clase.
        return classString.substring(dotIndex + 1);
    }

    /**
     * Crea y devuelve un objeto ImageIcon a partir de una ruta de archivo.
     *
     * @param path La ruta del archivo de la imagen.
     * @return Un objeto ImageIcon creado a partir de la ruta especificada.
     */
    public static ImageIcon createImageIcon(Object o, String path) {
        // Obtiene la URL del recurso utilizando la clase del menú emergente.
        java.net.URL imgURL = PopupMenuDemo.class.getResource(path);
//        URL imgURL = o.getClass().getResource(path);

        // Verifica si la URL del recurso es válida.
        if (imgURL != null) {
            // Si la URL es válida, crea y devuelve un nuevo ImageIcon.
            return new ImageIcon(imgURL);
        } else {
            // Si la URL no es válida, imprime un mensaje de error y devuelve null.
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Método para cargar fuentes personalizadas.
     *
     * @param nombreFuente Nombre del archivo de la fuente (ubicado en
     * ../assets/).
     * @param tamanyo Tamaño de la fuente.
     * @return Objeto de tipo Font cargado desde el archivo especificado.
     */
    public static Font cargaFuentes(String nombreFuente, int tamanyo) {
        // Inicializar la fuente como nula
        Font fuente = null;

        try {
            // Ruta al archivo de la fuente descargada

            String path = "/assets/" + nombreFuente;

//            URL fontUrl = Utiles.class.getClassLoader().getResource(path);
            URL fontUrl = Utiles.class.getResource(path);

            // Crear un objeto de fuente personalizada desde la URL
            // Derivar la fuente con tamaño especificado
            fuente = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream()).deriveFont(Font.PLAIN, tamanyo);
        } catch (Exception e) {
            // Imprimir detalles del error en caso de FontFormatException o IOException
//            e.printStackTrace();
            System.out.println("utiles.Utiles.cargaFuentes(): " + e.getMessage());
            // En caso de error, usar una fuente predeterminada
            return new Font("Arial", Font.PLAIN, tamanyo);
        }

        // Devolver la fuente cargada
        return fuente;
    }

    /**
     * Convierte un color en formato hexadecimal a un objeto Color de Java.
     *
     * @param hexColor Representación hexadecimal del color (por ejemplo,
     * "RRGGBB").
     * @return Objeto Color correspondiente al color hexadecimal especificado.
     */
    public static Color convierteRGBdeHEX(String hexColor) {
        // Extraer los componentes RGB del color hexadecimal

        // Obtener los primeros dos caracteres del color hexadecimal (componente rojo)
        int resultRed = Integer.valueOf(hexColor.substring(0, 2), 16);

        // Obtener los siguientes dos caracteres del color hexadecimal (componente
        // verde)
        int resultGreen = Integer.valueOf(hexColor.substring(2, 4), 16);

        // Obtener los últimos dos caracteres del color hexadecimal (componente azul)
        int resultBlue = Integer.valueOf(hexColor.substring(4, 6), 16);

        // Crear y devolver un nuevo objeto Color con los componentes RGB obtenidos
        Color colorRGB = new Color(resultRed, resultGreen, resultBlue);

        return colorRGB;
    }

    /**
     * Método para imprimir las claves y valores configurados en UIManager.
     */
    public static void printUIManagerKeys() {
        // Obtener las configuraciones predeterminadas de UIManager.
        UIDefaults defaults = UIManager.getDefaults();

        // Obtener una enumeración de las claves.
        Enumeration keysEnumeration = defaults.keys();

        // Convertir la enumeración a una lista.
        ArrayList keysList = Collections.list(keysEnumeration);

        // Iterar a través de las claves y mostrar aquellas con valores no nulos.
        for (Object key : keysList) {
            if (defaults.getString(key) != null) {
                System.out.println(key + " - " + defaults.getString(key));
            }
        }

        // Imprimir la cantidad total de claves.
        System.out.println(keysList.size());
    }

    /**
     * Muestra un mensaje en un área de texto cuando se detecta un evento de
     * ítem.
     *
     * @param ev Evento de ítem.
     * @param menuItem Elemento de menú asociado al evento.
     * @param textArea Área de texto en la que se mostrará el mensaje.
     */
    public static void mensajeAreaTexto(ItemEvent ev, JMenuItem menuItem, JTextArea textArea) {
        // Construir el mensaje para el evento de ítem
        String mensaje = "Evento de ítem detectado." + Utiles.NEW_LINE + "    Fuente del evento: " + menuItem.getText()
                + " (una instancia de " + Utiles.getClassName(menuItem) + ")" + Utiles.NEW_LINE + "    Nuevo estado: "
                + ((ev.getStateChange() == ItemEvent.SELECTED) ? "seleccionado" : "no seleccionado");

        // Agregar el mensaje al área de texto
        textArea.append(mensaje + Utiles.NEW_LINE);
        // Ajustar la posición del cursor al final del área de texto
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    /**
     * Muestra un mensaje en un área de texto cuando se detecta un evento de
     * acción.
     *
     * @param ev Evento de acción.
     * @param menuItem Elemento de menú asociado al evento.
     * @param textArea Área de texto en la que se mostrará el mensaje.
     */
    public static void mensajeAreaTexto(ActionEvent ev, JMenuItem menuItem, JTextArea textArea) {
        // Construir el mensaje para el evento de acción
        String mensaje = "Evento de acción detectado." + Utiles.NEW_LINE + "    Fuente del evento: "
                + menuItem.getText() + " (una instancia de " + Utiles.getClassName(menuItem) + ")";

        // Agregar el mensaje al área de texto
        textArea.append(mensaje + Utiles.NEW_LINE);
        // Ajustar la posición del cursor al final del área de texto
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    // Método para centrar un JFrame en la mitad de la pantalla (CUANDO TIENES
    // CONECTADOS 2 MONITORES)
    public static void centrarEnPantalla(JFrame frame) {
        // Obtiene la dimensión de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcula la posición para centrar el JFrame
        int x = (screenSize.width - frame.getWidth()) / 3;
        int y = (screenSize.height - frame.getHeight()) / 3;

        // Establece la posición del JFrame
        frame.setLocation(x, y);
    }

    /**
     * Establece un mensaje de tooltip para un componente Swing.
     *
     * @param componente: El componente Swing al que se le establecerá el
     * tooltip.
     * @param mensaje: El mensaje que se mostrará como tooltip en el componente.
     *
     */
    public static void toolTip(JComponent componente, String mensaje) {

        // Establece el tooltip del componente con el mensaje proporcionado.
        componente.setToolTipText("<html><p width=\"250px\">" + mensaje + "</p></html>");

    }

    /**
     * Este método te permite seleccionar un Menú. El menú se verá seleccionado
     * con un sombreado.
     */
    public static void pruebaSelectMenu(PopupMenuDemo popupMenu) {

        JMenuBar jMenuBar = popupMenu.getMenuBar();

//				JMenu menu  = (JMenu) jMenuBar.getComponent(0); //prueba selección Menu1
        JMenu menu = (JMenu) jMenuBar.getComponent(1); // prueba selección Menu2
        System.out.println(String.format("%s%s%s", "pruebaClickMenu: ", "menu: ", menu.getText()));

        // Crea un nuevo evento de selección para el menú
        MenuElement[] path = {jMenuBar, menu};
        for (int i = 0; i < path.length; i++) {
            Component componente = (Component) path[i];
            System.out.println(String.format("%s%s%s", "pruebaClickMenu: ", "path: ", componente.getClass()));
        }

        MenuSelectionManager defaultMenuSelection = MenuSelectionManager.defaultManager();
        defaultMenuSelection.setSelectedPath(path);
//			    System.out.println(String.format("%s%s%s", "pruebaClickMenu: ", "path: " , defaultMenuSelection.isComponentPartOfCurrentMenu(menu)));
    }

}
