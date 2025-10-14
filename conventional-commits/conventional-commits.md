### Conventional Commits.  
 Es una especificación que establece un formato estandarizado para los mensajes de commit en Git, haciendo que el historial de cambios sea más fácil de leer, tanto para humanos como para máquinas.   Permite automatizar procesos como el versionado semántico, la generación de changelogs y la integración continua. La estructura básica es tipo(alcance opcional): descripción en imperativo, seguido de un cuerpo opcional y un pie de página opcional.

 ### Estructura y tipos de commit.  
 ##### Tipo: Sustantivo que describe la naturaleza del cambio.   
- feat: Introduce una nueva funcionalidad.   
- fix: Corrige un error o bug.   
- docs: Cambios en la documentación.   
- style: Cambios en el estilo del código (espacios, formato) que no afectan al significado.   
- refactor: Cambios en la estructura del código que no corrigen un error ni añaden una funcionalidad.   
- perf: Mejora el rendimiento del código.   
- test: Añade o corrige tests.   
- build: Cambios relacionados con el proceso de construcción del proyecto.   
- ci: Cambios en los archivos o scripts de integración continua.   
- chore: Tareas de mantenimiento que no modifican el código fuente principal.    

##### Ambito (opcional): Indica la parte del código que se ve afectada,   
por ejemplo: *feat(auth):*   

##### Descripción: Breve descripción del cambio en infinitivo, seguida de un punto.   
Por ejemplo: *feat(user): añadir nuevo campo de correo.*  

#### Cuerpo (opcional): Descripción más detallada que explica el porqué del cambio.  

#### Pie de página (opcional): Para referencias a issues, como BREAKING CHANGE: para cambios que rompen la compatibilidad, ticket JIRA.   

#### Estructura Sencilla:

*Tipo (ambito/optcional): <Descripción>.*  

- Ejemplo: 
git commit -m "feat(partitura-api): agregar listado de PDFs de partituras"

#### Estructura completa:
HEADER       
LINEA BLANCA        
Cuerpo Opcional (Body).     
LINEA BLANCA     
Pie(s) de Pagina Opcional(es) (Footer)     

- Ejemplo:

fix(usuario): corregir error de validación de contraseña.  

Se ajusta la expresión regular del validador para permitir caracteres especiales
que previamente causaban un fallo en el proceso de creación de usuario.  

Fixes: #99  
Reviewed-by: Juan Perez.  
