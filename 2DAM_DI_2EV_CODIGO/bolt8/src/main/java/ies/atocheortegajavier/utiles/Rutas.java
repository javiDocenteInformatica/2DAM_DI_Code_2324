package ies.atocheortegajavier.utiles;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Rutas {

	

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
