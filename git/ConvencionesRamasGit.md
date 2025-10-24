#### Git 
Es un sistema de control de versiones distribuido que permite a los desarrolladores de software realizar un seguimiento de los cambios realizados en su código a lo largo del tiempo. Un aspecto crucial para usar Git eficazmente es el uso y la nomenclatura adecuados de las ramas. Una rama en Git es esencialmente un conjunto único de cambios de código con un nombre único.
___
#### Reglas básicas
- Minúsculas y separado por guiones : Use minúsculas para los nombres de las sucursales y guiones para separar las palabras. Por ejemplo, feature/new-logino bugfix/header-styling.
- Caracteres alfanuméricos: Utilice únicamente caracteres alfanuméricos (az, AZ, 0–9) y guiones. Evite la puntuación, los espacios, los guiones bajos y cualquier carácter no alfanumérico.
Sin guiones continuos: no utilice guiones continuos. feature--new-loginPuede resultar confuso y difícil de leer.
- Sin guiones finales: No termine el nombre de su sucursal con un guion. Por ejemplo, feature-new-login-no es recomendable.
- Descriptivo: El nombre debe ser descriptivo y conciso, reflejando idealmente el trabajo realizado en la sucursal.
___
#### Prefijos de rama
El uso de prefijos en los nombres de las ramas ayuda a identificar rápidamente su propósito. A continuación, se muestran algunos tipos comunes de ramas con sus prefijos correspondientes:

- Ramas de características: Estas ramas se utilizan para desarrollar nuevas características. Use el prefijo feature/. Por ejemplo, feature/login-system.
- Ramas de corrección de errores: Estas ramas se utilizan para corregir errores en el código. Use el prefijo bugfix/. Por ejemplo, bugfix/header-styling.
- Ramas de revisión: Estas ramas se crean directamente desde la rama de producción para corregir errores críticos en el entorno de producción. Use el prefijo hotfix/. Por ejemplo, hotfix/critical-security-issue.
- Ramas de lanzamiento: Estas ramas se utilizan para preparar una nueva versión de producción. Permiten realizar ajustes de última hora. Use el prefijo release/. Por ejemplo, release/v1.0.1.
Ramas de documentación: Estas ramas se utilizan para escribir, actualizar o corregir la documentación, por ejemplo, el archivo README.md. Use el prefijo docs/. Por ejemplo, docs/api-endpoints.  
___
#### Incluir números de tickets de Jira (u otra herramienta de gestión de proyectos).  
En algunos flujos de trabajo, especialmente en equipos grandes, es habitual incluir el número de ticket de una herramienta de gestión de proyectos como Jira en el nombre de la rama. Esto facilita el seguimiento del trabajo realizado en un ticket específico. Por ejemplo, si está trabajando en un ticket con el número "T-123" para añadir un nuevo sistema de inicio de sesión, el nombre de la rama podría ser feature/T-123-new-login-system.
___
#### Ejemplos de nombres de sucursales.  
A continuación se muestran algunos ejemplos de buenos nombres de ramas que siguen las convenciones anteriores:

- feature/T-456-user-authentication
- bugfix/T-789-fix-header-styling
- hotfix/T-321-security-patch
- release/v2.0.1
- docs/T-654-update-readme. 
___
#### Conclusión
Las convenciones de nomenclatura de ramas en Git, aunque no las impone el propio sistema, son cruciales para mantener un código limpio y comprensible, especialmente al trabajar en equipo. Al seguir estas convenciones, puede asegurarse de que sus ramas sean fácilmente identificables.
