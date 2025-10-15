### El patrón Singleton   

Es un patrón de diseño creacional que garantiza que una clase solo tenga una única instancia y proporciona un punto de acceso global a ella. Se usa comúnmente para gestionar recursos como conexiones a bases de datos, cachés o configuraciones. Un ejemplo sencillo en Java consiste en hacer el constructor privado, crear una instancia estática de la clase y un método estático público para obtenerla.

```java
public class Configuracion {
    // 1. Instancia estática única de la clase
    private static Configuracion instancia;
    
    // 2. Constructor privado para evitar instanciación externa
    private Configuracion() {
        // Inicializaciones
    }

    // 3. Método público para obtener la instancia única
    public static Configuracion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    // Otros métodos de la clase...
    public void hacerAlgo() {
        System.out.println("La instancia única está funcionando.");
    }
}
```
### ¿Cómo funciona?  
Constructor privado: Al ser private, nadie puede crear una instancia de la clase usando new Configuracion() fuera de la propia clase.  
Instancia estática: Se crea una única instancia de la clase dentro de la clase misma y se almacena en una variable estática (instancia).  
Método obtenerInstancia(): Este método estático público es el único punto de acceso. Comprueba si instancia ya existe. Si es nula, crea la instancia y la guarda. Si ya existe, simplemente la devuelve, asegurando que solo haya una instancia en memoria.  

```java
public class Main {
    public static void main(String[] args) {
        // Obtenemos la única instancia
        Configuracion config1 = Configuracion.obtenerInstancia();
        Configuracion config2 = Configuracion.obtenerInstancia();

        // Verificamos que ambas variables apuntan al mismo objeto
        if (config1 == config2) {
            System.out.println("Ambas variables apuntan a la misma instancia.");
        } else {
            System.out.println("¡Error! Se han creado dos instancias.");
        }

        // Usamos la instancia
        config1.hacerAlgo();
    }
}
````
