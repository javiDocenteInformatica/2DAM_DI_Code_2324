package ies.atocheortegajavier.utiles;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Rutas {

	public static final String BASEDIR_RESOURCES = "src\\main\\java\\ies\\atocheortegajavier\\resources\\";
	public static final String BASEDIR_DB = "src\\main\\java\\ies\\atocheortegajavier\\modelo\\";

	public static String obtenerRutaAbsoluta(URL url) {
		String rutaAbsoluta = "";

		File file;
		try {
			file = Paths.get(url.toURI()).toFile();
			rutaAbsoluta = file.getAbsolutePath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			rutaAbsoluta = "No ha sido posible obtener la ruta absoluta";
		}
		
		System.out.println(rutaAbsoluta);

		return rutaAbsoluta;
	}
}
