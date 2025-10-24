Un bucle **while** en Java repite un bloque de código siempre que una condición sea verdadera. Los ejemplos incluyen un bucle que imprime números hasta que un contador alcanza un valor específico (ejemplo 1), un bucle que lee la entrada del usuario hasta que escribe "exit" (ejemplo 2), y un ejemplo de bucle infinito que no tiene una condición de salida.  
#### Ejemplo 1: Bucle while básico
Este ejemplo imprime los números del 0 al 4. El bucle se ejecuta mientras la variable i sea menor que 5. 
```java
public class WhileExample {
    public static void main(String[] args) {
        int i = 0;
        while (i < 5) {
            System.out.println("i es: " + i);
            i++; // Se incrementa i en cada iteración
        }
    }
}
```
___
#### Ejemplo 2: Leer entrada hasta una condición
Este ejemplo utiliza un bucle while para leer texto del usuario hasta que este escriba la palabra "exit". 
```java
import java.util.Scanner;

public class WhileInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("exit")) {
            System.out.println("Introduce texto (escribe 'exit' para salir): ");
            input = scanner.nextLine();
        }
        scanner.close();
    }
}
```
___
#### Ejemplo 3: Bucle infinito
Un bucle while (true) nunca termina porque la condición siempre es verdadera. 
```java
public class InfiniteWhileLoop {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Esto se imprimirá para siempre");
        }
    }
}
```
