```java
/**
 * Carga una fuente personalizada desde un archivo TrueType (TTF).
 * @param nombreFuente Nombre del archivo de la fuente en la carpeta de activos.
 * @return Una instancia de Font cargada desde el archivo TTF.
 */
public static Font cargaFuentes(String nombreFuente) {
    // Inicializar la variable de la fuente a null
    Font fuente = null;

    try {
        // Obtener la URL del archivo de fuente en la carpeta de activos
        URL fontUrl = Utiles.class.getResource("../assets/" + nombreFuente);
        
        // Crear un objeto Font personalizado desde la URL del archivo de fuente
        // y derivar una nueva fuente con estilo plano (Font.PLAIN) y tamaño de 14 puntos
        fuente = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream()).deriveFont(Font.PLAIN, 14);
    } catch (FontFormatException | IOException e) {
        // Imprimir la traza de la excepción en caso de error
        e.printStackTrace();
        // En caso de error, usar una fuente predeterminada (Arial, plano, 14 puntos)
        return new Font("Arial", Font.PLAIN, 14);
    }

    // Devolver la fuente cargada o la fuente predeterminada en caso de error
    return fuente;
}
```

- **`Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream())`**: Este fragmento carga una fuente TrueType desde un flujo de entrada (`InputStream`) obtenido de la URL del archivo de fuente. Aquí, `Font.TRUETYPE_FONT` indica que estamos trabajando con una fuente TrueType. `Font.createFont` es un método estático que toma el tipo de fuente y un flujo de entrada y devuelve un objeto `Font` que representa la fuente cargada.

- **`fontUrl.openStream()`**: Este método obtiene un flujo de entrada desde la URL de la fuente. `openStream` es un método de `URL` que devuelve un `InputStream` que puede utilizarse para leer el contenido de la fuente. En este caso, se utiliza para proporcionar el contenido del archivo de fuente a `createFont`.