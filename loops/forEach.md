El bucle **for-each** en Java se utiliza para iterar sobre los elementos de un array o una colección de forma simplificada, sin necesidad de usar un índice. Para usarlo, se especifica la variable que contendrá cada elemento en cada iteración, dos puntos (:) y el array o colección sobre la que se itera.
#### Ejemplo con un array de Strings
```java
String[] nombres = {"Sophie", "Tim", "Anna", "John", "Melissa"};
for (String nombre : nombres) {
    System.out.println(nombre);
}
```
#### Salida:
```java
Sophie
Tim
Anna
John
Melissa
```
___
#### Ejemplo para sumar elementos de un array de enteros
```java
int[] numeros = {10, 34, 7, 19, -28};
int suma = 0;
for (int numero : numeros) {
    suma += numero;
}
System.out.println("Resultado = " + suma);
```
#### Salida:
```java
Resultado = 42
```
___
#### Ejemplo con java.util.List
```java
import java.util.ArrayList;
import java.util.List;

List<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Banana");
frutas.add("Cereza");

for (String fruta : frutas) {
    System.out.println(fruta);
}
```
#### Salida:
```java
Manzana
Banana
Cereza
```
