El patrón **Builder** es un patrón de diseño creacional que se utiliza para construir objetos complejos de forma paso a paso, separando la construcción del objeto de su representación. Un ejemplo sencillo en Java es construir un objeto Persona con múltiples campos (nombre, edad, dirección), creando primero un objeto Builder que permite añadir los detalles uno por uno de forma encadenada, y finalmente llamando a un método build() para obtener el objeto completo.
___
- Clase de producto (Persona):
    - Tiene un constructor privado que toma un Builder como argumento.
    - Tiene métodos getters para acceder a sus atributos.
    - Tener la anotación @Builder (con Lombok) es la forma más fácil de implementarlo.  
```java
// Usando Lombok para simplificar
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Persona {
    private String nombre;
    private int edad;
    private String direccion;
}
```
___
- Uso del Builder:
    - Se crea una instancia del Builder a través de la clase Persona.  
    - Se llaman métodos del Builder (como nombre(), edad(), direccion()) para establecer los atributos.  
    - Se llama al método build() para obtener la instancia final de Persona.  
```java
// Uso del builder
Persona persona = Persona.builder()
    .nombre("Juan Pérez")
    .edad(30)
    .direccion("Calle Falsa 123")
    .build();

System.out.println(persona.getNombre()); // Juan Pérez
```
___
#### Ventajas clave del patrón Builder.  
- Claridad: Hace el código más legible al proporcionar un constructor con nombres para cada paso.   
- Flexibilidad: Permite construir objetos de diferentes maneras sin modificar la clase principal, según la variación de los pasos.   
- Facilidad de uso: Facilita la creación de objetos con muchas opciones, evitando un constructor sobrecargado con múltiples parámetros.       

