Un **pseudocódigo** es una descripción de alto nivel de los pasos lógicos de un algoritmo o programa, escrita utilizando una mezcla de lenguaje natural y elementos de programación, que no es ejecutable por una computadora.
___
#### Características principales
- Lenguaje informal pero estructurado: Utiliza palabras y estructuras similares a los lenguajes de programación (como asignaciones, bucles y condicionales), pero se adapta a un estilo más cercano al lenguaje humano para facilitar la comprensión. 
- No ejecutable: No está sujeto a la sintaxis estricta de ningún lenguaje de programación, por lo que no puede ser ejecutado por un ordenador. Su propósito es la planificación y la comprensión. 
- Independiente del lenguaje: Al no depender de un lenguaje de programación específico, permite que un algoritmo diseñado en pseudocódigo se pueda implementar fácilmente en diferentes lenguajes de programación. 
- Herramienta de diseño: Se utiliza para esbozar y refinar la lógica de un programa antes de comenzar la codificación detallada, lo que ayuda a reducir errores y a acelerar el proceso de desarrollo.  
___
- Variables: Declarar variable, Inicializar variable
- Entrada/Salida: LEER, ESCRIBIR, MOSTRAR
- Asignación: <- o = (por ejemplo, total <- 0)
- Condiciones: SI... ENTONCES... SINO... FIN_SI
- Bucles: PARA... HACER... FIN_PARA, MIENTRAS... HACER... FIN_MIENTRAS
- Funciones/Procedimientos: FUNCIÓN, PROCEDIMIENTO, RETORNAR
___
#### Ejemplo:
// Inicio del programa  
PROCEDIMIENTO sumarNumeros


// Declarar variables  
NUMERO numero1
NUMERO numero2
NUMERO suma  


// Pedir los números al usuario  
ESCRIBIR "Por favor, introduce el primer número:"
LEER numero1  


ESCRIBIR "Por favor, introduce el segundo número:"
LEER numero2  


// Realizar la suma  
suma <- numero1 + numero2  


// Mostrar el resultado  
ESCRIBIR "La suma de los números es: ", suma


FIN_PROCEDIMIENTO  
___
// Definición de la función  
FUNCION contarVocales(cadena_texto) RETORNA ENTERO:


// 1. Declarar e inicializar el contador  
ENTERO contador_de_vocales <- 0


// 2. Convertir la cadena a minúsculas para simplificar la validación  
cadena_texto <- CONVERTIR_A_MINUSCULAS(cadena_texto)


// 3. Iterar sobre cada carácter de la cadena  
PARA CADA caracter EN cadena_texto HACER  

    // 4. Verificar si el carácter es una vocal
    SI (caracter ES IGUAL A 'a' O 'e' O 'i' O 'o' O 'u') ENTONCES
        // 5. Incrementar el contador si se encuentra una vocal
        contador_de_vocales <- contador_de_vocales + 1
    FIN_SI

FIN_PARA  

// 6. Retornar el resultado final  
RETORNAR contador_de_vocales


FIN_FUNCION
