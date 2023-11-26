**Código**:

```java
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
```

Este método, `getClassName`, se utiliza para obtener el nombre de la clase de un objeto en Java. 

Toma un objeto (`o`) como parámetro y devuelve una cadena que representa el nombre de la clase a la que pertenece ese objeto.



1. `String classString = o.getClass().getName();`: Obtiene el nombre completo de la clase del objeto `o`. `o.getClass()` devuelve el objeto de la clase `Class` que representa la clase del objeto, y luego `getName()` devuelve el nombre completo de la clase como una cadena.

2. `int dotIndex = classString.lastIndexOf(".");`: Encuentra la posición del último punto (`.`) en la cadena del nombre de la clase. Esto es útil para separar el nombre de la clase del paquete que la contiene.

3. `return classString.substring(dotIndex + 1);`: Obtiene una subcadena del nombre de la clase, comenzando después del último punto. Esto da como resultado el nombre simple de la clase, sin el paquete.

*En resumen, el método toma un objeto como parámetro, obtiene el nombre completo de su clase, y luego extrae y devuelve el nombre simple de la clase. 

Por ejemplo, si el nombre completo de la clase es "com.example.Ejemplo", este método devolverá "Ejemplo".*


