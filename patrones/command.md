El patrón de diseño **Command** encapsula una solicitud como un objeto, permitiendo así desacoplar el emisor de la solicitud de su receptor. Un ejemplo sencillo sería un objeto Command que se pasa a una clase Invoker para que la ejecute cuando se necesite, lo cual permite la ejecución diferida de acciones, el almacenamiento de historiales y la gestión de transacciones.  
___
#### Estructura del patrón Command.  
- Command (Interfaz): Define la interfaz para ejecutar una operación. Generalmente tiene un método execute().   
- ConcreteCommand (Clase Concreta): Implementa la interfaz Command y asocia una acción a un Receiver (receptor).  
- Receiver (Receptor): Es el objeto que sabe cómo realizar la acción real que se requiere.  
- Invoker (Invocador): Solicita la ejecución de un comando. Mantiene una referencia a un objeto Command y delega la ejecución.  
- Client (Cliente): Crea un objeto ConcreteCommand y establece su Receiver.  
___
```java
// 1. Interfaz Command
interface Command {
    void execute();
}

// 2. Receiver (Receptor)
class Light {
    public void turnOn() {
        System.out.println("La luz está encendida.");
    }
    public void turnOff() {
        System.out.println("La luz está apagada.");
    }
}

// 3. ConcreteCommand (Comando Concreto)
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// 4. Invoker (Invocador)
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        this.command.execute();
    }
}

// 5. Client (Cliente)
public class Client {
    public static void main(String[] args) {
        // Crear el receptor
        Light myLight = new Light();

        // Crear comandos concretos
        Command lightOn = new LightOnCommand(myLight);
        Command lightOff = new LightOffCommand(myLight);

        // Crear el invocador
        RemoteControl remote = new RemoteControl();

        // Establecer un comando y ejecutarlo
        remote.setCommand(lightOn);
        remote.pressButton(); // Imprime: La luz está encendida.

        // Cambiar el comando y volver a ejecutarlo
        remote.setCommand(lightOff);
        remote.pressButton(); // Imprime: La luz está apagada.
    }
}
```
___
