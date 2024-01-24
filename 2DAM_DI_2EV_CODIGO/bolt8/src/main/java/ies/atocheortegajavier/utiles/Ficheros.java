package ies.atocheortegajavier.utiles;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Ficheros {

	// Obtener el logger para la clase actual
	public static final Logger logger = Logger.getLogger(Ficheros.class.getName());
	
	
	public static final String NOMBRE_FICHERO_DB = "database.db";

	/**
	 * Método para comprobar si un archivo existe y crearlo en caso de que no
	 * exista.
	 *
	 * @param nombreFichero El nombre del archivo a comprobar o crear.
	 * @return Una instancia de File que representa el archivo.
	 */
	public static File compruebaYCreaFichero(String nombreFichero) {

		// Crear una instancia de File para representar el archivo

		File fichero = null;

		try {

			// Crear una instancia de File para representar el archivo
			fichero = new File(nombreFichero);

			// Verificar si el archivo ya existe
			if (!fichero.exists()) {
				// Crear un nuevo archivo
				boolean esCreado = fichero.createNewFile();

				// Comprobamos si el archivo ha sido creado
				// Si no es creado
				if (!esCreado) {

					logger.severe("No se pudo crear el fichero: " + nombreFichero);
					throw new IOException("No se pudo crear el fichero: " + nombreFichero);

					// Si es creado
				} else {
					logger.info("Archivo creado: " + fichero.getAbsolutePath());
				}

			} else {
				logger.info("El archivo '" + nombreFichero + "' ya existe.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return fichero;
	}

}
