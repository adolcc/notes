## El patrón Strategy  
Es un patrón de diseño de comportamiento que permite seleccionar un algoritmo o estrategia de ejecución en tiempo de ejecución. Encapsula diferentes algoritmos en clases separadas, todas implementando una misma interfaz, lo que las hace intercambiables. Esto permite cambiar la lógica de una clase sin modificarla directamente, aplicando la estrategia deseada según sea necesario, como en el ejemplo de un sistema de navegación que puede usar rutas rápidas, cortas o económicas. 

## Componentes principales  
- Interfaz Strategy: Define una interfaz común para todas las estrategias (algoritmos).
- Clases concretas de Strategy: Implementan la interfaz Strategy y contienen la lógica específica para cada algoritmo.
- Contexto (Context): Mantiene una referencia a un objeto Strategy y delega la ejecución del comportamiento a este objeto. El contexto puede cambiar la estrategia en tiempo de ejecución. 
___
## Ejemplo: Sistema de navegación
- Interfaz NavegacionStrategy: Define el método calcularRuta().
- Clases concretas:
    - RutaRapida implementa calcularRuta() para encontrar la ruta más rápida.
    - RutaCorta implementa calcularRuta() para encontrar la ruta más corta.
    - RutaEconomica implementa calcularRuta() para encontrar la ruta más económica.
- Contexto NavegadorGPS:
    - Contiene una instancia de NavegacionStrategy.
    - Un método setEstrategia() permite cambiar la estrategia (ej: setEstrategia(new RutaRapida())).
    - Un método obtenerRuta() llama al método calcularRuta() del objeto Strategy actual para obtener el resultado. 

Este patrón permite que la clase NavegadorGPS use cualquiera de las estrategias de navegación sin tener que saber cómo se implementan internamente, ofreciendo una gran flexibilidad. 