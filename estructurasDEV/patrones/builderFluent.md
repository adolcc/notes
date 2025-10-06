El patrón Builder Fluent es una variación del patrón de diseño creacional Builder que permite la construcción de objetos complejos de manera más legible y expresiva, encadenando métodos y retornando el objeto builder en cada paso para una sintaxis fluida, o "fluent".   
En lugar de una llamada de constructor repetitiva o de una serie de llamadas a métodos en un objeto director, la sintaxis "fluent" crea una línea de código clara y directa, haciendo el código más comprensible y menos propenso a errores, como se ve en el ejemplo de construcción de una cuenta de login.  
### Explicación del Patrón Builder Fluent.  
El objetivo principal del patrón Builder es separar la lógica de construcción de un objeto complejo de su representación. Con la variante "fluent":  
* Encadenamiento de Métodos: Cada método del builder realiza una parte de la configuración del objeto y devuelve el mismo builder (o un objeto de la misma clase) para permitir que el siguiente método de configuración se pueda llamar inmediatamente después.  
* Legibilidad: Esto crea una sintaxis similar a un lenguaje natural, donde se puede "leer" cómo se está construyendo el objeto.  
* Control del Proceso: Permite aplazar la ejecución de ciertos pasos, definir el orden de los mismos y construir objetos de manera flexible, lo que es ideal para objetos con muchas propiedades opcionales.  

```java
// Ejemplo de cómo podría verse el patrón builder fluent en Java
// (Este es un ejemplo simplificado para ilustrar la sintaxis)

public class Computer {
    private String cpu;
    private int ram;
    private int storage;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    // Métodos getters (omiten por brevedad)

    public static class ComputerBuilder {
        private String cpu;
        private int ram;
        private int storage;

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this; // Devuelve el propio builder para el encadenamiento
        }

        public ComputerBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de construcción fluent
        Computer gamingComputer = new Computer.ComputerBuilder()
            .setCpu("Intel i9")
            .setRam(32)
            .setStorage(1024)
            .build();
            
        System.out.println("CPU: " + gamingComputer.cpu);
        System.out.println("RAM: " + gamingComputer.ram + "GB");
        System.out.println("Almacenamiento: " + gamingComputer.storage + "GB");
    }
}
```

### Ejemplo de uso en el mundo real.  
Se utiliza comúnmente para construir objetos de configuración, como un objeto de solicitud HTTP con diferentes cabeceras, parámetros y cuerpos, o para construir un objeto de usuario con campos como nombre, edad, dirección, etc., donde muchas de las propiedades son opcionales.  
### Ventajas:  
* Mejora la legibilidad del código, especialmente en objetos con muchos atributos configurables.  
* Simplifica la creación de objetos complejos, al separar la lógica de construcción del objeto final.    
* Permite un control más granular: sobre el proceso de construcción.  
### Desventajas:
* Puede ser excesivo para objetos sencillos, donde el patrón Builder o simplemente el constructor pueden ser suficientes.  
* Aumenta la cantidad de código: necesario para la clase del builder.    



