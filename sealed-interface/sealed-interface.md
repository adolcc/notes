Una public interface **sealed** en Java permite definir una interfaz que solo puede ser implementada por un conjunto predefinido de clases, proporcionando un control de herencia más estricto. La palabra clave public asegura que la interfaz sea accesible desde cualquier lugar, mientras que sealed limita las clases que pueden implementar dicha interfaz. 

Explicación de public interface sealed
public: Indica que la interfaz es accesible desde cualquier otra clase en cualquier otro paquete.
interface: Define la interfaz.
sealed: Restringe el conjunto de clases que pueden heredar de esta interfaz. Se usa junto con la palabra clave permits para listar explícitamente las clases permitidas en el momento de la declaración de la interfaz.
Control de herencia: Permite que el compilador conozca todas las subclases directas en tiempo de compilación, lo que ayuda a optimizar el código y puede ser utilizado para lógica más robusta en el diseño de la jerarquía de clases, explica Arquitectura Java. 
___

### Ejemplo:
Supongamos que queremos modelar diferentes tipos de figuras geométricas y solo queremos permitir que se deriven de Triangulo, Cuadrado y Circulo.

```java
// Declaramos la interfaz sellada
public abstract sealed interface FiguraGeometrica permits Triangulo, Cuadrado, Circulo {
    double calcularArea();
}

// Clases que implementan la interfaz sellada
public final class Triangulo implements FiguraGeometrica {
    private final double base;
    private final double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
}

public final class Cuadrado implements FiguraGeometrica {
    private final double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}

public final class Circulo implements FiguraGeometrica {
    private final double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        FiguraGeometrica miTriangulo = new Triangulo(10, 5);
        FiguraGeometrica miCuadrado = new Cuadrado(5);
        FiguraGeometrica miCirculo = new Circulo(5);

        System.out.println("Área del triángulo: " + miTriangulo.calcularArea());
        System.out.println("Área del cuadrado: " + miCuadrado.calcularArea());
        System.out.println("Área del círculo: " + miCirculo.calcularArea());
    }
}
```
### En este ejemplo:
- FiguraGeometrica es una public interface sealed que solo puede ser implementada por Triangulo, Cuadrado y Circulo, como se especifica después de la palabra clave permits.
- Cualquier intento de crear una nueva clase, como Pentagono, que intente implementar FiguraGeometrica fallará en tiempo de compilación.
- Las clases Triangulo, Cuadrado y Circulo son marcadas como final porque no se permite que nadie más herede de ellas. 
