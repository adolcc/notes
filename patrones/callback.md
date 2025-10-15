El patrón **callback** es una técnica de programación donde un método (la función de callback) se pasa como argumento a otro método y se ejecuta después de que una acción se completa. Este patrón se utiliza para manejar operaciones, especialmente las asíncronas, permitiendo que el código continúe ejecutándose sin esperar a que una tarea finalice. En Java, se puede implementar usando interfaces anónimas, expresiones lambda o escuchadores de eventos. 
___
1. Crear una interfaz
Primero, define una interfaz que declare el método que se ejecutará como callback.
```java
public interface MiCallback {
    void onComplete(String resultado);
}
```
___
2. Clase que utiliza el callback
Luego, crea una clase que tenga un método que acepte un objeto de esta interfaz.
```java
public class OperacionAsincrona {
    public void ejecutar(String tarea, MiCallback callback) {
        // Simula una operación que toma tiempo
        new Thread(() -> {
            String resultado = "La tarea '" + tarea + "' se completó.";
            // Llama al método del callback una vez que la tarea termina
            callback.onComplete(resultado);
        }).start();
    }
}
```
___
3. Implementación y ejecución
Finalmente, puedes crear una instancia de la clase y pasarle un objeto que implemente la interfaz.
```java
public class Main {
    public static void main(String[] args) {
        MiCallback miCallback = new MiCallback() {
            @Override
            public void onComplete(String resultado) {
                System.out.println(resultado);
            }
        };

        OperacionAsincrona operacion = new OperacionAsincrona();
        operacion.ejecutar("Procesar datos", miCallback);

        System.out.println("La operación fue iniciada (pero puede no haber terminado aún).");
    }
}
```
Este ejemplo demuestra cómo el método main inicia la operación asíncrona y luego imprime un mensaje inmediatamente, sin esperar a que la tarea termine y la función de callback se ejecute. La salida de la consola podría ser: 
```java 
La operación fue iniciada (pero puede no haber terminado aún).
La tarea 'Procesar datos' se completó.
```
___
#### Ejemplo con Expresión Lambda (Java 8+).  
El mismo ejemplo se puede simplificar drásticamente usando expresiones lambda.
```java
public class OperacionAsincronaLambda {
    public void ejecutar(String tarea, MiCallback callback) {
        new Thread(() -> {
            String resultado = "La tarea '" + tarea + "' se completó.";
            callback.onComplete(resultado);
        }).start();
    }
}

public class MainLambda {
    public static void main(String[] args) {
        OperacionAsincronaLambda operacion = new OperacionAsincronaLambda();

        // Usando una expresión lambda directamente
        operacion.ejecutar("Procesar datos", resultado ->
            System.out.println(resultado)
        );

        System.out.println("La operación fue iniciada (pero puede no haber terminado aún).");
    }
}
```
Este es un ejemplo de cómo el patrón callback permite desacoplar la ejecución de una tarea del código que necesita ser ejecutado después de que la tarea se complete. 

