Un **for loop** en Java se utiliza para ejecutar repetidamente un bloque de código un número determinado de veces. Su sintaxis básica es for (inicialización; condición; incremento). Es útil para iterar sobre arrays y colecciones o realizar una tarea un número fijo de veces.  
___
#### Sintaxis básica.  
```java
for (int i = 0; i < 5; i++) {
  // código a ejecutar
}
```
- int i = 0: Se realiza una sola vez al inicio del bucle. Inicializa la variable de control.
- i < 5: Es la condición que se evalúa antes de cada iteración. Si es verdadera, el bucle continúa; si es falsa, el bucle termina. 
- i++: Se ejecuta al final de cada iteración. Usualmente, se incrementa o decrementa la variable de control. 
___
#### Ejemplos:
##### Imprimir números del 1 al 10
```java
for (int i = 1; i <= 10; i++) {
  System.out.println(i);
}
```
##### Sumar números del 1 al 100
```java
int sum = 0;
for (int i = 1; i <= 100; i++) {
  sum += i;
}
System.out.println("La suma es: " + sum);
```
##### Imprimir solo números pares del 2 al 20
En este caso, el bucle incrementa la variable de control en 2 en cada paso (i += 2), mostrando solo números pares.  
```java
for (int i = 2; i <= 20; i += 2) {
  System.out.println(i);
}
```

