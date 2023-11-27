# RA4. Diseña interfaces gráficos identificando y aplicando criterios de usabilidad.
# 4.h) Se han realizado pruebas para evaluar la usabilidad de la aplicación.

**A tener en cuenta, las diapositivas:**
> 35, 36, 37 (uso de mnemonicos, miga de pan), 38, 39, 48, 49, 50, 51, 52, 63, 64, 65, 66, 67

---------------------------------

Para realizar pruebas de usabilidad de la aplicación, seguiremos los pasos básicos que generalmente se realizan en el desarrollo de software. 

En un entorno de desarrollo real se realizarían pruebas más exhaustivas.

### Pruebas de Usabilidad:

1. **Compilar y Ejecutar la Aplicación:**
   
   - Compila y ejecuta la clase `App` que contiene el método `main`.
   
   - Observa la consola de Eclipse para asegurarte de que se imprima el mensaje "Hello World on [Nombre del Hilo]".

2. **Interacción Básica con la Aplicación:**
   
   - Verifica que la aplicación se inicie sin errores y que la interfaz gráfica aparezca.
   
   - Confirma que se pueda interactuar con los menús y submenús utilizando el mouse.

3. **Pruebas de Funcionalidad de Menús:**
   
   - Abre y cierra los menús y submenús para asegurarte de que se desplieguen y oculten correctamente.
   
   - Selecciona diferentes opciones de menú para verificar que las acciones asociadas se ejecuten correctamente.

4. **Eventos del Mouse:**
   
   - Haz clic derecho en diferentes partes de la aplicación para verificar que se muestren los menús contextuales (popup menus) y que contengan las opciones correctas.

5. **Cierre de la Ventana Principal:**
   
   - Intenta cerrar la ventana principal y verifica que aparezca un cuadro de diálogo de confirmación.
   
   - Confirma que la ventana se cierre si seleccionas "Sí" en el cuadro de diálogo y que no se cierre si seleccionas "No".

6. **Eventos de Items de Menú:**
   
   - Selecciona elementos de menú que tienen eventos asociados (por ejemplo, los que imprimen mensajes en la consola) y verifica que se realicen las acciones esperadas.

7. **Pruebas de Usabilidad:**
   
   - Evalúa la apariencia y la disposición de la interfaz gráfica. Verifica si la fuente, el color y el diseño son coherentes y agradables.
   
   - Observa si los menús y las opciones están etiquetados de manera clara y comprensible.
   
   - Evalúa la capacidad de respuesta de la aplicación y si las acciones se ejecutan de manera rápida y sin demora perceptible.

8. **Pruebas de Fuentes Personalizadas:**
   
   - Verifica que las fuentes personalizadas se apliquen correctamente a los diferentes elementos de la interfaz gráfica.

9. **Pruebas de Internacionalización (I18n):**
   
   - Cambia el idioma de tu sistema y verifica cómo afecta a la aplicación (por ejemplo, el cuadro de diálogo de cierre de la ventana debería mostrar botones en español).

10. **Desarrollo Futuro:**
   - Considera cualquier funcionalidad adicional que desees agregar a la aplicación y evalúa la facilidad de integración.

### Observaciones:

- **Excepciones y Errores:**
  
  - Asegúrate de manejar adecuadamente las excepciones y errores que puedan ocurrir durante la ejecución de la aplicación.

- **Logs y Depuración:**
  
  - Utiliza mensajes de registro y depuración para obtener información sobre el flujo de la aplicación y para identificar posibles problemas.

Estos son pasos básicos para realizar pruebas de usabilidad. 

Puedes ajustarlos según tus necesidades específicas y considerar la posibilidad de utilizar frameworks de pruebas automatizadas para pruebas más extensas y repetitivas.

---------------------------------

Para realizar pruebas de unidad y automatizar algunos aspectos de las pruebas de usabilidad, puedes utilizar frameworks de pruebas en Java como JUnit o TestNG. 

A continuación, muestro ejemplos de cómo realizar algunas pruebas utilizando JUnit:

1. **Pruebas Básicas de Interfaz:**

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testAppInitialization() {
        // Verificar que la aplicación se inicialice correctamente
        // Puedes asumir que si no hay excepciones al crear la GUI, la inicialización es exitosa.
        assertDoesNotThrow(() -> {
            App.main(null);
        });
    }

    @Test
    public void testPopupMenuCreation() {
        // Verificar que se pueda crear un objeto PopupMenuDemo sin excepciones
        assertDoesNotThrow(() -> {
            PopupMenuDemo demo = new PopupMenuDemo();
        });
    }

    // Agrega más pruebas según sea necesario para otras partes de tu aplicación
}
```

2. **Pruebas de Funcionalidad de Menús y Eventos:**

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PopupMenuEventsManagerTest {

    @Test
    public void testPopupMenuEvents() {
        // Simular un clic en un elemento de menú y verificar si se activa el evento correctamente
        PopupMenuEventsManager eventsManager = new PopupMenuEventsManager(new JTextArea());
        ActionEvent mockEvent = new ActionEvent(new JMenuItem("MockMenuItem"), ActionEvent.ACTION_PERFORMED, "command");
        assertDoesNotThrow(() -> {
            eventsManager.actionPerformed(mockEvent);
        });
    }

    // Agrega más pruebas según sea necesario para otros eventos y clases relacionadas
}
```

3. **Pruebas de Fuentes y Estilos:**

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilesTest {

    @Test
    public void testCargaFuentes() {
        // Verificar que se pueda cargar una fuente sin excepciones
        Font font = Utiles.cargaFuentes(Utiles.ROBOTO_BLACK, 12);
        assertNotNull(font);
    }

    // Agrega más pruebas según sea necesario para otros métodos en la clase Utiles
}
```

Estos son solo ejemplos básicos y puedes ampliarlos según tus necesidades específicas. Para ejecutar estas pruebas, configura un entorno de prueba en tu IDE o utiliza la línea de comandos con herramientas como Maven o Gradle. Las pruebas automatizadas te ayudarán a identificar rápidamente problemas y a garantizar la integridad de tu código a medida que realizas cambios y mejoras en tu aplicación.
