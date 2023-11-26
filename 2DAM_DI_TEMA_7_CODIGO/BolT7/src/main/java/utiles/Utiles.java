package utiles;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import vista.PopupMenuDemo;

public class Utiles {

	public static final String NEW_LINE = "\n";

	public static final String ROBOTO_BLACK = "Roboto/Roboto-Black.ttf";
	public static final String ROBOTO_BLACK_ITALIC = "Roboto/Roboto-BlackItalic.ttf";
	public static final String ROBOTO_BOLD = "Roboto/Roboto-Bold.ttf";
	public static final String POPPINS_BOLD = "Poppins/Poppins-Bold.ttf";
	public static final String POPPINS_BOLD_ITALIC = "Poppins/Poppins-BoldItalic.ttf";
	public static final String POPPINS_REGULAR = "Poppins/Poppins-Regular.ttf";
	public static final String RALEWAY_BOLD = "Raleway/Raleway-Bold.ttf";
	public static final String RALEWAY_BOLD_ITALIC = "Raleway/Raleway-BoldItalic.ttf";
	public static final String RALEWAY_MEDIUM = "Raleway/Raleway-Medium.ttf";

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
	public static ImageIcon createImageIcon(String path) {
		// Obtiene la URL del recurso utilizando la clase del menú emergente.
		java.net.URL imgURL = PopupMenuDemo.class.getResource(path);

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
	 * @param nombreFuente Nombre del archivo de la fuente (ubicado en ../assets/).
	 * @param tamanyo      Tamaño de la fuente.
	 * @return Objeto de tipo Font cargado desde el archivo especificado.
	 */
	public static Font cargaFuentes(String nombreFuente, int tamanyo) {
		// Inicializar la fuente como nula
		Font fuente = null;

		try {
			// Ruta al archivo de la fuente descargada
			URL fontUrl = Utiles.class.getResource("../assets/" + nombreFuente);
			// Crear un objeto de fuente personalizada desde la URL
			// Derivar la fuente con tamaño especificado
			fuente = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream()).deriveFont(Font.PLAIN, tamanyo);
		} catch (FontFormatException | IOException e) {
			// Imprimir detalles del error en caso de FontFormatException o IOException
			e.printStackTrace();
			// En caso de error, usar una fuente predeterminada
			return new Font("Arial", Font.PLAIN, tamanyo);
		}

		// Devolver la fuente cargada
		return fuente;
	}

	/**
	 * Convierte un color en formato hexadecimal a un objeto Color de Java.
	 *
	 * @param hexColor Representación hexadecimal del color (por ejemplo, "RRGGBB").
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


}
