Los condicionales if en Java se usan para ejecutar bloques de código basados en una condición que se evalúa como verdadera o falsa. Los ejemplos incluyen un if simple, un if-else para ejecutar un código alternativo y un if-else if-else para manejar múltiples condiciones. La sintaxis básica es if (condicion) { ... }, y se pueden añadir otras estructuras para controlar el flujo del programa. 
___
#### Ejemplo 1: Condicional if simple
```java
public class IfExample {
    public static void main(String[] args) {
        int number = 10;
        if (number > 5) {
            System.out.println("El número es mayor que 5.");
        }
    }
}
```
- Resultado: Se imprimirá "El número es mayor que 5." porque 10 > 5 es verdadero. 
___
#### Ejemplo 2: Condicional if-else
Este ejemplo ejecuta un bloque de código si la condición es verdadera (if) y otro bloque si es falsa (else). 
```java
public class IfElseExample {
    public static void main(String[] args) {
        int number = 3;
        if (number > 5) {
            System.out.println("El número es mayor que 5.");
        } else {
            System.out.println("El número no es mayor que 5.");
        }
    }
}
```
- Resultado: Se imprimirá "El número no es mayor que 5." porque 3 > 5 es falso, y se ejecuta el bloque else. 
#### Ejemplo 3: Condicional if-else if-else
Permite evaluar múltiples condiciones en secuencia. El primer if que sea verdadero ejecuta su bloque de código y salta el resto. 
```java
public class IfElseIfElseExample {
    public static void main(String[] args) {
        int number = 7;
        if (number > 10) {
            System.out.println("El número es mayor que 10.");
        } else if (number > 5) {
            System.out.println("El número es mayor que 5 pero menor o igual a 10.");
        } else {
            System.out.println("El número es 5 o menos.");
        }
    }
}
```
- Resultado: Se imprimirá "El número es mayor que 5 pero menor o igual a 10." porque 7 > 10 es falso, pero 7 > 5 es verdadero. 