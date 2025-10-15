El **patrón Abstract Factory** es un patrón creacional de diseño que permite crear familias de objetos relacionados sin especificar sus clases concretas. Se usa para crear un conjunto de productos (como una computadora y un monitor) de forma que solo se cree una versión compatible de los mismos (por ejemplo, de escritorio o portátil), lo que mejora la modularidad y la flexibilidad del código. En Java, esto se implementa creando una interfaz de "fábrica abstracta" y clases "fábricas concretas" para cada tipo de familia de productos.  

```java
// 1. Interfaz del producto A (Motor)
interface Motor {
    void encender();
}

// 2. Interfaz del producto B (Vehículo)
interface Vehiculo {
    void acelerar();
}

// 3. Clases concretas de productos A (Motores)
class MotorElectrico implements Motor {
    public void encender() {
        System.out.println("Motor eléctrico encendido.");
    }
}

class MotorGasolina implements Motor {
    public void encender() {
        System.out.println("Motor de gasolina encendido.");
    }
}

// 4. Clases concretas de productos B (Vehículos)
class CocheElectrico implements Vehiculo {
    private Motor motor;

    public CocheElectrico(Motor motor) {
        this.motor = motor;
        this.motor.encender(); // La creación del motor va en el constructor
    }

    @Override
    public void acelerar() {
        System.out.println("Coche eléctrico acelerando.");
    }
}

class MotoElectrica implements Vehiculo {
    private Motor motor;

    public MotoElectrica(Motor motor) {
        this.motor = motor;
        this.motor.encender();
    }

    @Override
    public void acelerar() {
        System.out.println("Moto eléctrica acelerando.");
    }
}

// 5. Interfaz de la fábrica abstracta
interface FabricaVehiculos {
    Motor crearMotor();
    Vehiculo crearVehiculo();
}

// 6. Fábricas concretas
class FabricaVehiculoElectrico implements FabricaVehiculos {
    @Override
    public Motor crearMotor() {
        return new MotorElectrico();
    }

    @Override
    public Vehiculo crearVehiculo() {
        return new CocheElectrico(crearMotor());
    }
}

class FabricaVehiculoGasolina implements FabricaVehiculos {
    @Override
    public Motor crearMotor() {
        return new MotorGasolina();
    }

    @Override
    public Vehiculo crearVehiculo() {
        // Aquí no tenemos coches de gasolina, solo un ejemplo
        return new MotoElectrica(crearMotor());
    }
}

// 7. Cliente que usa la fábrica
public class Main {
    public static void main(String[] args) {
        // Crear una fábrica para vehículos eléctricos
        FabricaVehiculos fabricaElectrica = new FabricaVehiculoElectrico();
        Vehiculo cocheElectrico = fabricaElectrica.crearVehiculo();
        cocheElectrico.acelerar(); // Salida: Coche eléctrico acelerando.

        System.out.println("---");

        // Crear una fábrica para vehículos de gasolina
        FabricaVehiculos fabricaGasolina = new FabricaVehiculoGasolina();
        Vehiculo motoGasolina = fabricaGasolina.crearVehiculo();
        motoGasolina.acelerar(); // Salida: Moto eléctrica acelerando.
    }
}
```
#### Cómo funciona
Interfaces de Producto: Se definen interfaces para cada tipo de producto (por ejemplo, Motor y Vehiculo).  
Fábrica Abstracta: Se crea una interfaz para la fábrica (FabricaVehiculos), que declara métodos para crear cada producto de la familia ( crearMotor() y crearVehiculo()). 

