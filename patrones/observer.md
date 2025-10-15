El patrón **Observer** define una dependencia de uno a muchos entre objetos, de modo que cuando el objeto principal (sujeto) cambia de estado, todos sus dependientes (observadores) son notificados automáticamente. Un ejemplo sencillo en Java sería una aplicación de pronóstico del tiempo donde la estación meteorológica (sujeto) notifica a varias pantallas (observadores) cuando la temperatura cambia.  
___
#### Estructura y componentes.  
- Sujeto (Subject): Es el objeto que mantiene una lista de observadores y notifica a todos los observadores cuando su estado cambia. Debe tener métodos para agregar y eliminar observadores.
- Observador (Observer): Es una interfaz o clase abstracta que define el método de actualización que debe implementar cada observador.
- ConcreteObserver: Implementa la interfaz Observer y realiza una acción cuando es notificado por el sujeto.  
```java
// 1. Interfaz del Sujeto
interface Sujeto {
    void agregarObservador(Observador o);
    void eliminarObservador(Observador o);
    void notificarObservadores();
}

// 2. Interfaz del Observador
interface Observador {
    void actualizar(float temperatura);
}

// 3. Implementación concreta del Sujeto
class EstacionMeteorologica implements Sujeto {
    private List<Observador> observadores = new ArrayList<>();
    private float temperatura;

    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(this.temperatura);
        }
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }
}

// 4. Implementación concreta del Observador
class PantallaTemperatura implements Observador {
    private float temperatura;

    @Override
    public void actualizar(float temperatura) {
        this.temperatura = temperatura;
        System.out.println("Pantalla: La temperatura es ahora: " + this.temperatura);
    }
}

// 5. Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        EstacionMeteorologica estacion = new EstacionMeteorologica();
        PantallaTemperatura pantalla1 = new PantallaTemperatura();
        PantallaTemperatura pantalla2 = new PantallaTemperatura();

        estacion.agregarObservador(pantalla1);
        estacion.agregarObservador(pantalla2);

        estacion.setTemperatura(25.5f); // Notifica a ambas pantallas
        estacion.setTemperatura(27.0f); // Notifica de nuevo
    }
}
```
