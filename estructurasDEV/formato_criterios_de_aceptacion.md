# Criterios de Aceptación (Acceptance Criteria)

Los criterios de aceptación son condiciones que debe cumplir una funcionalidad para considerarse **completada**.  
Son fundamentales para guiar el desarrollo y servir como base para las pruebas.

### Recomendaciones de Uso

* **Sé específico:** Define claramente qué significa "completado".
* **Usa el formato DADO-CUANDO-ENTONCES (Gherkin):** Facilita la comprensión y la conversión a pruebas automatizadas.
* **Incluye escenarios de error:** No solo el "camino feliz".
* **Evita ambigüedades:** Usa términos medibles y objetivos.

---

## Criterios de Ejemplo: Subida de Archivos PDF. 

Utiliza este formato para definir escenarios claros para la Historia de Usuario:

#### Escenario 1: Subida exitosa. 

DADO que soy un usuario autenticado en la aplicación. 
CUANDO selecciono la opción "Subir PDF". 
ENTONCES se me permite seleccionar un archivo PDF desde mi dispositivo.    

DADO que he seleccionado un archivo PDF válido. 
CUANDO confirmo la subida. 
ENTONCES el sistema muestra una barra de progreso durante la carga. 
Y recibo una notificación de éxito cuando termina. 
Y puedo ver el PDF en mi biblioteca. 

#### Escenarios de Error (Casos Negativos). 

DADO que intento subir un archivo que no es PDF. 
CUANDO confirmo la subida. 
ENTONCES el sistema muestra un mensaje de error indicando que solo se permiten archivos PDF. 

#### Exceder el límite de tamaño. 

DADO que intento subir un archivo PDF mayor a 10MB
CUANDO confirmo la subida
ENTONCES el sistema muestra un error indicando el límite de tamaño permitido