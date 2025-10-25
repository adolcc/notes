Las **anotaciones** en Java son metadatos que se añaden a elementos de código como clases, métodos o campos, y que proporcionan información adicional que puede ser procesada por herramientas y el compilador. Se identifican por el prefijo @ y sirven para automatizar tareas, verificar la sintaxis, o añadir configuraciones específicas a través de los parámetros que contienen. Ejemplos comunes son @Override, @SuppressWarnings y @Deprecated, pero también se pueden crear anotaciones personalizadas. 
___
#### Explicación
¿Qué son? Son una forma de insertar metadatos (datos sobre los datos) en el código.


¿Cómo se ven? Se escriben precedidas por el símbolo @, por ejemplo, @Override.


##### ¿Para qué sirven?
Para el compilador: Verificar que el código sea correcto. Por ejemplo, @Override garantiza que un método esté sobreescribiendo correctamente un método de una clase padre.


Para herramientas de desarrollo: Como Project Lombok, que usa @Data para generar automáticamente métodos repetitivos como getters y setters.


Para el código en tiempo de ejecución: Añadir lógica o configuración. Por ejemplo, usar @NotNull en un parámetro de método para que se lance una excepción si el valor es nulo. 

#### Ejemplos:
##### Anotaciones predefinidas
- @Override: Indica que un método de una subclase sobreescribe un método de una superclase.
```java
class Animal {
  void makeSound() {
    System.out.println("Some sound");
  }
}

class Dog extends Animal {
  @Override
  void makeSound() {
    System.out.println("Woof");
  }
}
```
- @SuppressWarnings: Le dice al compilador que ignore ciertas advertencias.
```java 
@SuppressWarnings("deprecation")
void myOldMethod() {
  // ... código que usa un método obsoleto
}
```
- @Deprecated: Indica que un elemento (clase, método, etc.) está obsoleto y no debe ser usado más.
```java
@Deprecated
void someMethod() {
  // ...
}
```
___
#### Anotaciones personalizadas
- Definición: Se crea una anotación personalizada con la sintaxis @interface.
```java
public @interface MiAnotacion {
  String valor() default "";
  int cantidad() default 1;
}
```
- Uso: Se aplica la anotación a un elemento de código, especificando los valores de sus parámetros si es necesario.
```java
@MiAnotacion(valor = "Ejemplo", cantidad = 5)
public class MiClase {
  // ...
}

