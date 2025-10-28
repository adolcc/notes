## Programación Reactiva. 

Programación reactiva: potenciando la capacidad de respuesta.   

Un paradigma que esta revolucionando la gestión de flujos de datos asíncronos.   
___
1.- Cimientos reactivos con Spring Boot:

Imagina crear un panel de análisis en tiempo real que procesa miles de eventos por segundo.  

La programación reactiva con Spring boot te permite gestionar escenarios de forma eficiente.  

CRUD significa << crear, leer, actualizar y eliminar>>, que son las cuatro funciones básica del almacenamiento persistente.  

## Spring WebFlux 
Es un framework web reactivo y sin bloqueos para crear aplicaciónes web relativas y escaladles.  

Juntos, Spring WebFlux y CRUD se pueden usar para desarrollar rápidamente una API RESTful reactiva que pueda crear, leer, actualizar y eliminar datos en una base de datos.  


Spring WebFlux es un framework web reactivo y no bloqueante para crear aplicaciónnes web reactivas y escalables, y es ideal para su uso en entornos de alta concurrencia.  
___
## Mono y Flux 

Spring WebFlux utiliza principalmente  dos editores: Mono y Flux. 

### Mono: 
Devuelve 0 o 1 elemento. 
La API Mono permite generar solo un valor. 
### Flux: 
Devuelve 0…N elementos. 
Flux puede ser infinito y generar múltiples valores. 

```java
Flux<Integer> numbers = Flux.just( 1 , 2 , 3 , 4 , 5 ) 
        .delayElements(Duration.ofSeconds( 1 )) 
        .map(n -> n * 2 ); 

numbers.subscribe(System.out::println); 

// Salida: 2 4 6 8 10 (con un retraso de 1 segundo entre cada uno)
```
___
## Mono vs Flux:

Mono y Flux son implementaciones de la interfaz Publisher. En resumen, cuando realizamos un cálculo o una solicitud a una base de datos o un servicio externo, y esperamos un máximo de un resultado, deberíamos usar Mono. 

Agregue las siguientes dependencias. 

```java
< dependencia >     
  < groupId > org.springframework.boot </ groupId >     
  < artifactId > spring-boot-starter-data-jpa </ artifactId >     
  </ dependencia >  
  < dependencia > 
   < groupId > com.mysql </ groupId > 
   < artifactId > mysql-connector-j </ artifactId > 
   < ámbito > tiempo de ejecución </ ámbito > 
  </ dependencia > 
  < dependencia > 
   < groupId > org.springframework.boot </ groupId > 
   < artifactId > spring-boot-starter-test </ artifactId > 
   < ámbito > prueba </ ámbito > 
  </ dependencia > 

  < dependencia > 
   < groupId > org.springframework.boot </ groupId > 
   < artifactId > spring-boot-starter-web </ artifactId > 
  </ dependencia > 
  < dependencia > 
   < groupId > org.springframework.boot </ groupId > 
   < artifactId > spring-boot-starter-webflux </ artifactId > 
  </ dependencia > 
  < dependencia > 
   < groupId > org.projectlombok </ groupId > 
   < artifactId > lombok </ artifactId > 
   < opcional > verdadero </ opcional > 
  </ dependencia > 
  < dependencia > 
   < groupId > io.reactor de proyecto </ groupId > 
   < artifactId > reactor-test </ artifactId > 
   < scope > prueba </ scope > 
  </Dependencia > 

  <!-- Datos de Springboot --> 
  < dependencia > 
   < groupId > org.springframework.boot </ groupId > 
   < artifactId > spring-boot-starter-data-r2dbc </ artifactId > 
  </ dependencia > 

  <!-- Habilitar agrupación de conexiones --> 
  < dependencia > 
   < groupId > io.r2dbc </ groupId > 
   < artifactId > r2dbc-pool </ artifactId > 
  </ dependencia > 
  < dependencia > 
   < groupId > org.springframework </ groupId > 
   < artifactId > spring-jdbc </ artifactId > 
  </ dependencia > 

  <!-- Mysql reactivo --> 
  < dependencia > 
   < groupId > dev.miku </ groupId > 
   < artifactId > r2dbc-mysql </ artifactId > 
   < versión > 0.8.2.RELEASE </ versión > 
  </ dependencia > 
  < dependencia > 
   < groupId > mysql </ groupId > 
   < artifactId > mysql-connector-java </ artifactId > 
   < versión > 8.0.33 </ versión > 
  </ dependencia >
```
___
Veamos un ejemplo sencillo:
```java
paquete com.reactiveprogramming.demo.model; 

importar org.springframework.data.annotation.Id; 

importar jakarta.persistence.GeneratedValue; 
importar jakarta.persistence.GenerationType; clase 

pública  Empleado { @Id @GeneratedValue(strategy = GenerationType.AUTO) int privado idemployee; cadena privada nombredeempleado; cadena privada ubicacióndeempleado; int público getIdemployee () { devolver idemployee; } vacío público setIdemployee ( int idemployee) { este.idemployee = idemployee; } cadena pública getEmployeename () { devolver nombredeempleado; } vacío público setEmployeename (cadena nombredeempleado) { este.employeename = nombredeempleado; } cadena pública getEmployeelocation () { devolver ubicacióndeempleado; } public void setEmployeelocation (String ubicación_empleado) { este .ubicación_empleado = ubicación_empleado; } } 
```
___
```java
paquete com.reactiveprogramming.demo.model; 

importar org.springframework.stereotype.Component; 

@Component clase 
pública  EmployeeTaskSaved { cadena privada saveStatus; pública EmployeeTaskSaved () { // Constructor } cadena pública getSaveStatus () { devolver saveStatus; } vacío público setSaveStatus (cadena saveStatus) { este .saveStatus = saveStatus; } }
```

### Caso de uso:
Los flujos reactivos le permiten trabajar con datos asincrónicos de manera no bloqueante, lo que posibilita actualizaciones y capacidad de respuesta en tiempo real. 

2.- Manejo reactivo de solicitudes web:

Imagine crear una aplicación de char donde los mensajes llegan a intervalos impredecibles. 
Spring WebFlux, parte de Spring Boot, proporciona las herramientas para gestionar estos escenarios sin problemas:
```java
paquete com.reactiveprogramming.demo.controller; 

importar org.springframework.beans.factory.annotation.Autowired; 
importar org.springframework.web.bind.annotation.DeleteMapping; 
importar org.springframework.web.bind.annotation.GetMapping; 
importar org.springframework.web.bind.annotation.PathVariable; 
importar org.springframework.web.bind.annotation.PostMapping; 
importar org.springframework.web.bind.annotation.PutMapping; 
importar org.springframework.web.bind.annotation.RequestBody; 
importar org.springframework.web.bind.annotation.ResponseBody; 
importar org.springframework.web.bind.annotation.RestController; 

importar com.reactiveprogramming.demo.exception.ResourceNotFoundException; 
importar com.reactiveprogramming.demo.model.Employee; 
importar com.reactiveprogramming.demo.model.EmployeeTaskSaved; 
importar com.reactiveprogramming.demo.repository.ReactiveProgrammingRepository; 

importar reactor.core.publisher.Flux; 

@RestController 
public  class  ReactiveProgrammingController { 
 @Autowired
 ReactiveProgrammingRepository reactiveProgrammingRepository; 

 @Autowired
 EmployeeTaskSaved taskSaved; 

 public  String  GUARDADO  =  "Persistente correctamente" ; 
 public  String  ELIMINADO  =  "Eliminado correctamente" ; 

 /** 
  * Método para obtener todas las tareas de los empleados 
  */ 
 @GetMapping("/getEmployee") 
 public  @ResponseBody Flux<Employee> getEmployee () { 
  return reactiveProgrammingRepository.findAll(); 
} 

 /** 
  * 
  * @param empleado {@ Empleado} 
  * @return empleado { @EmployeeTaskSaved } 
  */ 
 @PostMapping("/saveEmployee") 
 public EmployeeTaskSaved saveEmployeeTaskManagement ( @RequestBody Empleado empleado) { 
  reactiveProgrammingRepository.save(empleado); 
  taskSaved.setSaveStatus(GUARDADO); 
  return taskSaved; 
} 

 /** 
  * @param id identificador único 
  * @param empleado {@ Empleado} 
  * @return empleado { @EmployeeTaskSaved} 
  */ 
 @PutMapping("/updateEmployee/{id}") 
 public EmployeeTaskSaved updateEmployeeTaskManagement ( @PathVariable  int id, @RequestBody Empleado empleado) { 

  Empleado  ActualizaciónEmpleado  = reactiveProgrammingRepository.findById(id).block(); 
  // .orElseThrow(() -> new ResourceNotFoundException("El empleado no existe con el id 
  // :" + id)); 
  if (ActualizaciónEmpleado != null ) { 
   ActualizaciónEmpleado.setEmployeename(empleado.getEmployeename()); 
   ActualizaciónEmpleado.setEmployeelocation(empleado.getEmployeelocation()); 
   reactiveProgrammingRepository.save(ActualizaciónEmpleado); 
   tareaSaved.setSaveStatus(GUARDADO); 
   return tareaSaved; 

  } else { 
   throw  new  ResourceNotFoundException ( "El empleado no existe con id:" + id); 
  } 

} 

 /** 
  * @param id identificador único 
  * @return empleado { @EmployeeTaskSaved } 
  */ 
 @DeleteMapping("/deleteEmployee/{id}") 
 public EmployeeTaskSaved deleteEmployee ( @PathVariable  int id) { 
  Empleado empleado  =  reactiveProgrammingRepository.findById (id).block(); 
  if (empleado!= null ) { 
   reactiveProgrammingRepository.delete(empleado); 
   taskSaved.setSaveStatus(DELETED); 
   return taskSaved; 
  } else { 
   throw  new  ResourceNotFoundException ( "El empleado no existe con id:" + id); 
  } 
} 
}
```
___
### WebFlux 
Permite gestionar datos impredecibles y asincrónicos, lo que lo hace ideal para aplicaciones de chat, datos de IoT y mas. 

3.- Acceso reactivo a datos:

En una plataforma de comercio electrónico con mucho tráfico, se necesita una recuperación de datos ágil. 
Spring Data R2DBC, con sus capacidades reactivas, garantiza que las interacciones con la base de datos no bloqueen la aplicación. 
```java
paquete com.reactiveprogramming.demo.repository; 

importar org.springframework.data.repository.reactive.ReactiveCrudRepository; 
importar org.springframework.stereotype.Repository; 

importar com.reactiveprogramming.demo.model.Employee; 

@Repository interfaz 
pública  ReactiveProgrammingRepository extiende ReactiveCrudRepository <Employee, Integer>{ }
```

### Caso de uso:
El acceso reactivo a los datos garantiza que su aplicación siga respondiendo, incluso durante operaciones intensivas en bases de datos. 

```java
#PARA MYSQL 
spring.r2dbc.url =r2dbc:pool:mysql://localhost/tutorial 
spring.r2dbc.username =root 
spring.r2dbc.password =root 

#Estamos usando el agrupamiento de MySQL para evitar muchas conexiones 
spring.r2dbc.pool.initial-size = 100 
spring.r2dbc.pool.max-size = 500 
spring.r2dbc.pool.max-idle-time = 30 m 
spring.r2dbc.pool.validation-query =SELECT 1
```

