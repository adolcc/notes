Los mentores desaconsejan usar instanceof porque a menudo es un signo de un antipatrón de diseño que indica la necesidad de refactorizar la estructura del código, violando el principio de sustitución de Liskov y violando el principio abierto/cerrado. En lugar de usar instanceof, se debe favorecer el polimorfismo a través de la herencia y la sustitución de métodos para escribir código más mantenible y flexible. 
___
#### Ejemplo de código con instanceof
```java
// Método con instanceof
public void procesarForma(Forma forma) {
    if (forma instanceof Circulo) {
        Circulo circulo = (Circulo) forma;
        circulo.dibujarCirculo();
    } else if (forma instanceof Cuadrado) {
        Cuadrado cuadrado = (Cuadrado) forma;
        cuadrado.dibujarCuadrado();
    }
}
```
En este ejemplo, el método necesita if/else if para comprobar el tipo de objeto y llamar al método apropiado. Esto viola el principio abierto/cerrado, ya que cada vez que se agregue una nueva forma, se necesitará modificar este método. 
___
#### Ejemplo usando polimorfismo (mejor práctica)
```java
// Clase base
abstract class Forma {
    abstract void dibujar();
}

// Clases derivadas
class Circulo extends Forma {
    @Override
    void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}

class Cuadrado extends Forma {
    @Override
    void dibujar() {
        System.out.println("Dibujando un cuadrado");
    }
}

// Método mejorado
public void procesarForma(Forma forma) {
    forma.dibujar(); // Se llama al método adecuado en función del tipo real del objeto
}
```
En el segundo ejemplo, la clase Forma tiene un método abstracto dibujar(). Las clases Circulo y Cuadrado implementan este método de manera específica. El método procesarForma simplemente llama a forma.dibujar() y el polimorfismo se encarga de ejecutar la versión correcta del método en tiempo de ejecución. Esto hace que el código sea más abierto a la extensión (para agregar nuevas formas) y cerrado a la modificación (no es necesario cambiar el método procesarForma). 
