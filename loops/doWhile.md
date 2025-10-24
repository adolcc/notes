Un bucle **do-while** en Java repite un bloque de código al menos una vez, y luego continúa repitiéndolo mientras una condición especificada sea verdadera. La sintaxis es do { // código a ejecutar } while (condición);, y es crucial no olvidar el punto y coma al final.
```java
// Ejemplo 1: Imprimir números hasta llegar a un límite
int contador = 1;
do {
    System.out.println("Contador: " + contador);
    contador++;
} while (contador <= 5);
```
___
#### ¿Cuándo usar un bucle do-while?
- Se utiliza cuando necesitas que el bloque de código se ejecute al menos una vez, independientemente de la condición inicial. 
- Es útil para validar entradas de usuario, como en el siguiente ejemplo, donde el programa pide un número hasta que se introduce un valor específico.  
```java
// Ejemplo 2: Pedir un número al usuario hasta que sea el valor de corte
Scanner entrada = new Scanner(System.in);
int numero;
int valorCorte = 0; // El valor que detiene el bucle

do {
    System.out.print("Introduce un número (introduce 0 para salir): ");
    numero = entrada.nextInt();
    System.out.println("Has introducido: " + numero);
} while (numero != valorCorte);

System.out.println("Bucle terminado.");
entrada.close();
```
___
#### Diferencia clave con el bucle while
- En un bucle while, la condición se evalúa antes de ejecutar el código. Si la condición es falsa desde el principio, el código nunca se ejecutará. 
- En un bucle do-while, el código se ejecuta primero y la condición se evalúa después. Esto garantiza que el bloque de código se ejecute al menos una vez.  
```java
// Ejemplo 3: Demostrar la ejecución al menos una vez
int i = 10;
do {
    System.out.println("Esto se ejecuta al menos una vez.");
} while (i < 5); // La condición es falsa, pero el código se ejecutó una vez
```
