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
<dependency>    
  <groupId>org.springframework.boot</groupId>    
  <artifactId>spring-boot-starter-data-jpa</artifactId>    
  </dependency> 
  <dependency>
   <groupId>com.mysql</groupId>
   <artifactId>mysql-connector-j</artifactId>
   <scope>runtime</scope>
  </dependency>
  <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-test</artifactId>
   <scope>test</scope>
  </dependency>

  <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-webflux</artifactId>
  </dependency>
  <dependency>
   <groupId>org.projectlombok</groupId>
   <artifactId>lombok</artifactId>
   <optional>true</optional>
  </dependency>
  <dependency>
   <groupId>io.projectreactor</groupId>
   <artifactId>reactor-test</artifactId>
   <scope>test</scope>
  </dependency>

  <!-- Springboot data -->
  <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-r2dbc</artifactId>
  </dependency>

  <!-- Enable connection pooling -->
  <dependency>
   <groupId>io.r2dbc</groupId>
   <artifactId>r2dbc-pool</artifactId>
  </dependency>
  <dependency>
   <groupId>org.springframework</groupId>
   <artifactId>spring-jdbc</artifactId>
  </dependency>

  <!-- Reactive Mysql -->
  <dependency>
   <groupId>dev.miku</groupId>
   <artifactId>r2dbc-mysql</artifactId>
   <version>0.8.2.RELEASE</version>
  </dependency>
  <dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
   <version>8.0.33</version>
  </dependency>
```
___
Veamos un ejemplo sencillo:
```java
package com.reactiveprogramming.demo.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Employee {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int idemployee;
 private String employeename;
 private String employeelocation;

 public int getIdemployee() {
  return idemployee;
 }

 public void setIdemployee(int idemployee) {
  this.idemployee = idemployee;
 }

 public String getEmployeename() {
  return employeename;
 }

 public void setEmployeename(String employeename) {
  this.employeename = employeename;
 }

 public String getEmployeelocation() {
  return employeelocation;
 }

 public void setEmployeelocation(String employeelocation) {
  this.employeelocation = employeelocation;
 }

}
```
___
```java
package com.reactiveprogramming.demo.model;

import org.springframework.stereotype.Component;

@Component
public class EmployeeTaskSaved {

 private String saveStatus;

 public EmployeeTaskSaved() {
  // Constructor
 }

 public String getSaveStatus() {
  return saveStatus;
 }

 public void setSaveStatus(String saveStatus) {
  this.saveStatus = saveStatus;
 }

}
```

### Caso de uso:
Los flujos reactivos le permiten trabajar con datos asincrónicos de manera no bloqueante, lo que posibilita actualizaciones y capacidad de respuesta en tiempo real. 

2.- Manejo reactivo de solicitudes web:

Imagine crear una aplicación de char donde los mensajes llegan a intervalos impredecibles. 
Spring WebFlux, parte de Spring Boot, proporciona las herramientas para gestionar estos escenarios sin problemas:
```java
package com.reactiveprogramming.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactiveprogramming.demo.exception.ResourceNotFoundException;
import com.reactiveprogramming.demo.model.Employee;
import com.reactiveprogramming.demo.model.EmployeeTaskSaved;
import com.reactiveprogramming.demo.repository.ReactiveProgrammingRepository;

import reactor.core.publisher.Flux;

@RestController
public class ReactiveProgrammingController {
 @Autowired
 ReactiveProgrammingRepository reactiveProgrammingRepository;

 @Autowired
 EmployeeTaskSaved taskSaved;

 public String SAVED = "Successfully Persisted";
 public String DELETED = "Successfully Deleted";

 /**
  * Method to get all Employee Tasks
  */
 @GetMapping("/getEmployee")
 public @ResponseBody Flux<Employee> getEmployee() {
  return reactiveProgrammingRepository.findAll();
 }

 /**
  * 
  * @param employee {@ Employee}
  * @return employee {@EmployeeTaskSaved} 
  */
 @PostMapping("/saveEmployee")
 public EmployeeTaskSaved saveEmployeeTaskManagement(@RequestBody Employee employee) {
  reactiveProgrammingRepository.save(employee);
  taskSaved.setSaveStatus(SAVED);
  return taskSaved;
 }

 /**
  * @param id unique identifier
  * @param employee {@ Employee}
  * @return employee {@EmployeeTaskSaved}
  */
 @PutMapping("/updateEmployee/{id}")
 public EmployeeTaskSaved updateEmployeeTaskManagement(@PathVariable int id, @RequestBody Employee employee) {

  Employee employeeUpdate = reactiveProgrammingRepository.findById(id).block();
  // .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id
  // :" + id));
  if (employeeUpdate != null) {
   employeeUpdate.setEmployeename(employee.getEmployeename());
   employeeUpdate.setEmployeelocation(employee.getEmployeelocation());
   reactiveProgrammingRepository.save(employeeUpdate);
   taskSaved.setSaveStatus(SAVED);
   return taskSaved;

  } else {
   throw new ResourceNotFoundException("Employee not exist with id :" + id);
  }

 }

 /**
  * @param id unique identifier
  * @return employee {@EmployeeTaskSaved}
  */
 @DeleteMapping("/deleteEmployee/{id}")
 public EmployeeTaskSaved deleteEmployee(@PathVariable int id) {
  Employee employee = reactiveProgrammingRepository.findById(id).block();
  if(employee!=null) {
   reactiveProgrammingRepository.delete(employee);
   taskSaved.setSaveStatus(DELETED);
   return taskSaved;
  }else {
   throw new ResourceNotFoundException("Employee not exist with id :" + id);
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
package com.reactiveprogramming.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactiveprogramming.demo.model.Employee;

@Repository
public interface ReactiveProgrammingRepository extends ReactiveCrudRepository<Employee, Integer>{

}

```

### Caso de uso:
El acceso reactivo a los datos garantiza que su aplicación siga respondiendo, incluso durante operaciones intensivas en bases de datos. 

```java
#FOR MYSQL
spring.r2dbc.url=r2dbc:pool:mysql://localhost/tutorial
spring.r2dbc.username=root
spring.r2dbc.password=root

#We are using mysql pooling to avoid many connections
spring.r2dbc.pool.initial-size=100
spring.r2dbc.pool.max-size=500
spring.r2dbc.pool.max-idle-time=30m
spring.r2dbc.pool.validation-query=SELECT 1
```

