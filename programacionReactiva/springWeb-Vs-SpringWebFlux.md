## Spring Web y Spring WebFlux
Son marcos del ecosistema Spring que se utilizan para crear aplicaciones web, pero tienen algunas diferencias clave.  

Spring Web es un framework web tradicional basado en la API de Servlets.  
Está diseñado para gestionar el bloqueo de I/O, donde un hilo se bloquea hasta que se recibe uuna respuesta de una base de datos u otro servicio.  

Spring Web es ideal para aplicaciones web tradicionales que requieren comunicación síncronica. 

Srping WebFlux, por otro lado, es un freamework web reactivo basado en Reactive Streams. Está diseñado para gestionar I/O no bloqueantes, donde un hilo no se bloequea mientras espera una respuesta de una base de datos u otro servicio. En cambio, la aplicación puede continuar procesando otras solicitudes mientras espera la respuesta. Spring WebFlux es ideal para aplicaciones que requieren alta concurrencia, como aplicaciones de transmisión o procesamiento de datos en tiempo real.\  

En resumen, si está desarrollando una aplocación web tradicional con comunicación síncronica, Spring Web puede ser una buena opción. Si está desarrolando una aplicacion altamente concurrente con I/O sin bloqueo, Spring WebFlux puede ser una mejor opción.  

Consideremos un ejemplo de creación de una aplicación web que recupera datos meteorológicos de una API de terceros y los muestra a los usuarios.  

En una aplicación web Spring tradicional, el controlador usaría I/O de bloqueo para recuperar los datos meteorológicos de la API, y el usuario tendría que esperar a que se recuperaran para ver la información metereológica. Esto es ideal para aplicaciones de pequeña escala con baja concurrencia.  

Por otro lado, en una aplicación Spring WebFlux, el controlador usaría I/O no bloqueante para recuperar los datos metereológicos de la API, y el usuario podría ver la carga de la página mientras se recuperan los datos en un segundo plano. Esto es ideal para aplicaciones de gran escala con alta concurrencia.  

Así es como podría verse el código para ambos ejemplos:

## Ejemplo de Spring Web:
```java
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather() {
        WeatherData weatherData = weatherService.getWeatherData();
        return "The temperature in " + weatherData.getCity() + " is " + weatherData.getTemperature() + " degrees Celsius.";
    }
}

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    public WeatherData getWeatherData() {
        ResponseEntity<WeatherData> response = restTemplate.getForEntity("https://api.weather.com/weatherdata", WeatherData.class);
        return response.getBody();
    }
}
```
___
## Ejemplo de Spring WebFlux:
```java
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public Mono<String> getWeather() {
        return weatherService.getWeatherData().map(weatherData -> "The temperature in " + weatherData.getCity() + " is " + weatherData.getTemperature() + " degrees Celsius.");
    }
}

@Service
public class WeatherService {

    @Autowired
    private WebClient webClient;

    public Mono<WeatherData> getWeatherData() {
        return webClient.get().uri("https://api.weather.com/weatherdata").retrieve().bodyToMono(WeatherData.class);
    }
}
```
___
Como puedes ver, el ejemplo de Spring WebFlux utiliza conceptios de programación reactiva, como Mono y WebClient, para gestionar la I/O no bloquenate y la concurrencia. Mientras que el ejemplo de Sping Web utiliza conceptos tradicionales de I/O bloqueante, como RestTemplate y ResponseEntity.  

Si tanto Spring Web como Spring WebFlux se ejecutan en los mismos recursos del sistema y se realizan 300 solicitudes entrantes al mismo tiempo, Spring Webflux funcionará mejor debido a su enfoque de I/O sin bloqueo.  








