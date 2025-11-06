### Log4j 2
```java
Configuration:
  Appenders:
    Console:
      name: Console
      target: SYSTEM_OUT
      PatternLayout:
        pattern: "%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n"

    File:
      name: FileLogger
      fileName: logs/app.log
      PatternLayout:
        pattern: "%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger{36} - %msg%n"

  Loggers:
    Logger:
      - name: com.myapp
        level: debug
        additivity: false
        AppenderRef:
          - ref: Console
          - ref: FileLogger

    Root:
      level: info
      AppenderRef:
        - ref: Console
```
___
### Appenders  
Es un componente que define a dónde van los logs que la aplicación genera.

#### Ejemplo:
puedes enviar logs:

- 🖥️ A la consola (`Console`)
- 🗃️ A un archivo (`File`)
- 📧 A un correo (raro, pero posible)
- 📦 A un sistema externo como Kafka, syslog, etc.
___
### PatternLayout
Define el formato de los mensajes.
```java
      PatternLayout:
        pattern: "%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n"
```
### 🧩 ¿Qué significa cada parte?
| Parte | Significado |
| --- | --- |
| `%d{yyyy-MM-dd HH:mm:ss}` | La **fecha y hora** del log, con ese formato: `2025-07-29 15:30:45` |
| `[%t]` | El **nombre del thread** (hilo de ejecución) |
| `%-5level` | El **nivel del log** (INFO, DEBUG, ERROR...) alineado a la izquierda (5 letras) |
| `%logger{36}` | El **nombre del logger**, acortado a 36 caracteres si es muy largo |
| `-` | Separador visual |
| `%msg` | El **mensaje real del log** que tú escribiste (por ejemplo `logger.info(...)`) |
| `%n` | Salto de línea al final |

### 🛠 Puedes personalizarlo
Por ejemplo:

- Mostrar el nombre del archivo: `%F`
- Mostrar el número de línea: `%L`
- Agregar ID del hilo: `%threadId`
- Agregar color (si usas consola y alguna librería adicional)
___
### Loggers
Definen cómo se usan los appenders.
```java
Loggers:
  Logger:
    - name: com.myapp
      level: debug
      additivity: false
      AppenderRef:
        - ref: Console
        - ref: FileLogger
```
Aquí los logs de la clase `com.myapp` deben ir tanto a la consola como al archivo. deben ir tanto a la consola como al archivo.
___
### Level
Define el nivel mínimo de log que se aceptará para este logger.
### Niveles posibles (de más a menos detallado):

- `trace` → lo más detallado (para debugging profundo)
- `debug` → para seguimiento técnico, como valores de variables, flujo interno
- `info` → para mensajes normales de operación
- `warn` → para advertencias (algo raro, pero no error)
- `error` → para errores que afectan el funcionamiento
- `fatal` → errores muy graves que probablemente apaguen tu app
- `off` → desactiva el logging
  
[logging.apache.org/log4j/2](https://logging.apache.org/log4j/2.x/javadoc/log4j-api/org/apache/logging/log4j/Level.html)

Entonces, `level: debug` significa:

> “Este logger va a mostrar mensajes de nivel debug, info, warn, error, y fatal. Todo lo más bajo que eso (como trace) no se mostrará.”
>

### additivity
Controla si el logger hereda los appenders del logger padre o no (true | false).

Cuando ves que tus logs están duplicados y no sabes por qué → probablemente es additivity: true.
___
### Root
- Es el **logger raíz** de toda la aplicación.
- Si un logger **no tiene una configuración explícita**, hereda del `Root`.
- Es como el **default logger**, el que captura todo lo que no se ha definido con nombre propio.
- Es obligatorio tener uno.
- Todos los logs en cualquier parte de tu app pasarán por aquí, a menos que tengan su propio `Logger`.

### Ejemplo:
```java
Root:
  level: info
  AppenderRef:
    - ref: Console
```
Si escribes este código sin tener un logger explícito configurado:
```java
Logger logger = LogManager.getLogger("anything.unconfigured");
logger.warn("This is a warning!");
logger.trace("This is a trace!");
```
El mensaje "This is a warning!" se manejará por el `Root` logger y se mostrará en **consola** porque:

- El nivel `warn` es mayor que `info` ✅
- Hay un appender `Console` ✅



