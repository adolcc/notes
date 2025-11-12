### Mono y Flux  
Son tipos de datos asíncronos en la programación reactiva de Java que provienen de la biblioteca Project Reactor. Mono representa un único resultado (cero o un valor), mientras que Flux representa una secuencia de cero a múltiples valores. Se utilizan para construir aplicaciones no bloqueantes, especialmente en frameworks como Spring WebFlux. 

### Mono  
- Qué es: Representa un flujo de datos que emitirá, como máximo, un solo elemento.
- Cuándo usarlo: Para operaciones que devuelven un único valor, como obtener un dato de una base de datos por su ID, una validación o la llamada a una API que devuelve un solo objeto.
- Ejemplo de código:
```java
Mono<String> mono = Mono.just("Hola");
mono.subscribe(System.out::println); // Imprime: Hola
```
___
### Flux  
- Qué es: Representa un flujo de datos que puede emitir cero, uno o muchos elementos en el tiempo.
- Cuándo usarlo: Para operaciones que devuelven una lista de elementos, como la recuperación de múltiples registros de una base de datos o la emisión de una secuencia de eventos.
- Ejemplo de código:
```java
Flux<String> flux = Flux.just("a", "b", "c");
flux.subscribe(System.out::println); // Imprime: a, b, c (cada uno en una línea nueva)
```

