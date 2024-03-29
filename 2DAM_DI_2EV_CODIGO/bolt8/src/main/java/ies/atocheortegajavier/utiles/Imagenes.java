package ies.atocheortegajavier.utiles;

import java.net.URL;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

public class Imagenes {

	// Obtener el logger para la clase actual
	public static final Logger logger = Logger.getLogger(Imagenes.class.getName());

	public static final String PATH_LOGO = Rutas.BASEDIR_RESOURCES + "logo_EduTrack.png";

	/**
	 * Crea y devuelve un objeto ImageIcon a partir de una ruta de archivo.
	 *
	 * @param path La ruta del archivo de la imagen.
	 * @return Un objeto ImageIcon creado a partir de la ruta especificada.
	 */
	public static ImageIcon createImageIcon(Object o, String path) {

		ImageIcon icon = null;

		try {
			// Obtiene la URL del recurso utilizando la clase del menú emergente.
			URL imgURL = o.getClass().getResource(path);

			// Verifica si la URL del recurso es válida.
			if (imgURL != null) {
				// Si la URL es válida, crea y devuelve un nuevo ImageIcon.
				icon = new ImageIcon(imgURL);
			} else {
				// Si la URL no es válida, imprime un mensaje de error y devuelve null.
				logger.severe("No se puede encontrar el fichero: " + path);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return icon;

	}
}
