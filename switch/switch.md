La sentencia **switch** en Java es una estructura de control de flujo que permite ejecutar diferentes bloques de código basándose en el valor de una variable. Es útil para simplificar la lógica cuando se deben manejar múltiples opciones exactas, de forma similar a un menú. La estructura compara la variable de control con cada uno de los valores definidos en los case y ejecuta el código correspondiente. Es crucial usar break al final de cada case para evitar que el programa continúe ejecutando los case siguientes. La opción default se ejecuta si ningún case coincide. 
___
#### Explicación de la sintaxis
- switch(variable): La palabra clave switch seguida de la variable o expresión que se va a evaluar entre paréntesis.
- case valor:: Define una opción específica. El programa compara el valor de la variable con valor. Solo se puede usar con tipos de datos primitivos (como int, char, byte, short, long, boolean) y sus clases envolventes correspondientes (como Integer, Character), además de String.
- código: El bloque de instrucciones a ejecutar si el case coincide con la variable.
break;: Detiene la ejecución del bloque switch. Sin break, el programa continuará ejecutando el siguiente case.
- default:: Código que se ejecuta si ningún case coincide con el valor de la variable. 
#### Ejemplo básico
```java
public class SwitchEjemplo {
    public static void main(String[] args) {
        int diaDeLaSemana = 3;
        String nombreDia;

        switch (diaDeLaSemana) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miércoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "Sábado";
                break;
            case 7:
                nombreDia = "Domingo";
                break;
            default:
                nombreDia = "Día no válido";
        }

        System.out.println("El día es: " + nombreDia);
    }
}
```
#### Ejemplo con break (comportamiento incorrecto)
Si se olvida el break, la ejecución no se detiene y se ejecutará todo lo que siga:
```java
public class SwitchSinBreak {
    public static void main(String[] args) {
        int dia = 2;

        switch (dia) {
            case 1:
                System.out.println("Lunes");
            case 2:
                System.out.println("Martes"); // Se ejecuta por estar 'dia' = 2
            case 3:
                System.out.println("Miércoles"); // Se ejecuta porque no hubo 'break' en el caso anterior
            default:
                System.out.println("Día no válido"); // Se ejecuta porque no hubo 'break'
        }
    }
}
```
Este código imprimiría:
```java
Martes
Miércoles
Día no válido
```
La importancia de break es evitar este comportamiento no deseado al detener la ejecución del switch una vez que se encuentra una coincidencia. 