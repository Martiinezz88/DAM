# Tema 3 y Anexo I explicados para principiantes absolutos

Antes de meternos en Java, piensa en un programa como una receta: tiene ingredientes (datos) y pasos (instrucciones). El ordenador no adivina nada: hay que decirle todo con precisión. Vamos a ir paso a paso y con ejemplos sencillos para que tu hermano pueda seguirlo aunque nunca haya visto Java.

---

## Objetivos del tema

- Entender qué es el “léxico”, “sintaxis” y “semántica” en un lenguaje.
- Reconocer las partes de un programa (palabras reservadas, tokens, expresiones).
- Aprender a construir y evaluar expresiones (como operaciones matemáticas y comparaciones).
- Usar métodos (funciones ya hechas) en expresiones.
- Controlar el flujo del programa: elegir caminos (if/switch) y repetir acciones (while/do while/for).
- Saber qué es declarar variables y cómo se agrupan sentencias en bloques.
- Comprender cómo y por qué revisar y “trazar” programas (ver paso a paso qué hace).
- Compilar y ejecutar tu primer programa Java desde cero.

---

## 1. Introducción: cómo se “lee” un programa

Cuando el compilador (el “lector” del programa) ve tu código, lo primero que hace es dividir el texto en “palabras” con significado para Java. Estas palabras especiales se llaman “tokens”. Para separar tokens se usan:

- Espacio en blanco, salto de línea (return/enter), tabulador.
- Comentarios:
    - // comentario de una línea
    - /* comentario de varias líneas */
    - /** comentario para documentación (Javadoc) */

Estas cosas no afectan a lo que hace tu programa, pero ayudan al compilador a entender dónde empieza y termina cada palabra.

---

## 2. Palabras reservadas

Son palabras que Java ya usa para cosas concretas. No puedes inventarte variables con esos nombres. Ejemplos: int, class, if, while, switch, return, public, private, enum, module, yield, var, record, sealed, etc.

Si ves una de estas palabras, significa algo para el lenguaje (por ejemplo, “int” significa “voy a declarar un número entero”).

---

## 3. Expresiones: piezas que producen un valor

Una expresión es cualquier cosa que “se resuelve” a un valor:

- Un literal: 5, 3.14, 'A', true.
- Un identificador (el nombre de una variable): edad, precio.
- Operaciones con operadores: 5 + 2, edad > 18, a && b.

### 3.1 Definición simple

- Literal: “3” es una expresión de tipo entero.
- Identificador: “edad” (si está declarada) es una expresión del tipo que tenga.
- Operación: “a + b” es una expresión cuyo tipo depende de a y b.

### 3.2 Expresiones aritméticas (matemáticas)

Usan +, -, *, /, %.

- Si aparece un número con decimales (real), la operación será con decimales:
   ```java
    double a = 3 / 2.0; // 1.5
    ```
- A veces Java convierte tipos automáticamente para poder operar (promoción implícita).
- Otras veces hay que “forzar” la conversión (casting explícito) si quieres guardar un resultado en un tipo más pequeño:
   ```java
    byte var = 100;
    var = (byte) (var + var); // fuerzas que el resultado (int) quepa en byte
    ```


Ideas clave:

- Usar un tipo “más grande” para guardar el resultado es seguro (por ejemplo, pasar de int a double).
- Pasar de un tipo más grande a uno más pequeño puede perder información (por ejemplo, de float a int se pierden decimales).

### 3.3 Expresiones lógicas o booleanas

Devuelven true o false. Se usan operadores de comparación y lógicos.

- Comparaciones: ==, !=, <, >, <=, >=
- Lógicos: && (y), || (o), ! (no)

Ejemplo:

```java
boolean menorQueCero = (i < 0); // true si i es menor que 0
```

Evaluación en “cortocircuito”:

- a && b: si a es false, no evalúa b (porque ya será false).
- a || b: si a es true, no evalúa b (porque ya será true).

---

## 4. Funciones (métodos) que te ayudan

Java trae funciones listas para usar, por ejemplo en la clase Math:

```java
int a = Math.abs(-3);     // 3 (valor absoluto)
double r = Math.sqrt(16); // 4.0 (raíz cuadrada)
```

Más adelante verás que tú también podrás escribir tus propias funciones.

---

## 5. Instrucciones o sentencias

Una sentencia es una “acción completa” que el programa ejecuta. Tipos:

- Sentencias de expresión:
    
    - Asignación: a = 3; a += 3;
    - Incremento/decremento: a++; a--;
    - Llamadas a métodos: listarPorNombre("Juan");
    - Creación de objetos: Trabajador t1 = new Trabajador("Juan");
- Sentencias de declaración:
    
    ```java
    int edad;
    String nombre = "Juan";
    ```
    
    Puedes declarar varias del mismo tipo:
    
    ```java
    int v1, v2 = 2, v3; // v2 inicializada; v1 y v3 no
    ```
    
- Sentencias de flujo de control: controlan el orden de ejecución (if, switch, while, do while, for).
    

Regla: en Java, las sentencias terminan con “;”.

---

## 6. Estructura general de un programa

Tu primer programa mínimo:

```java
public class Ejemplo {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
    }
}
```

- public class Ejemplo: defines una clase llamada Ejemplo (el archivo debe llamarse Ejemplo.java).
- main: punto de entrada; el programa empieza a ejecutarse ahí.
- System.out.println(...): imprime texto en la pantalla.

---

## 7. Sentencias y bloques

Un bloque agrupa varias sentencias entre llaves { }:

```java
{
  int x = 5;
  System.out.println(x);
}
```

¿Por qué es útil? Porque donde el lenguaje permite una sentencia, también suele permitir un bloque (y así puedes ejecutar varias).

Ejemplo práctico (leer dos números y mostrar suma y producto):

```java
import java.util.Scanner;

public class SumaProductoNumeros {
    public static void main(String[] arg) {
        Scanner teclado = new Scanner(System.in);
        int num1, num2, suma, producto;

        System.out.print("Ingrese primer valor: ");
        num1 = teclado.nextInt();
        System.out.print("Ingrese segundo valor: ");
        num2 = teclado.nextInt();

        suma = num1 + num2;
        producto = num1 * num2;

        System.out.print("La suma de los dos valores es: ");
        System.out.println(suma);

        System.out.print("El producto de los dos valores es: ");
        System.out.println(producto);
    }
}
```

---

## 8. Estructuras de selección (elegir caminos)

### 8.1 If (si… entonces… si no…)

```java
if (condicion) {
    // si la condición es true
} else {
    // si la condición es false
}
```

Ejemplo:

```java
if ((diasemana >= 1) && (diasemana <= 5)) {
    trabajar = true;
} else {
    trabajar = false;
}
```

If anidados (varios casos):

```java
if (diasemana == 1) dia = "Lunes";
else if (diasemana == 2) dia = "Martes";
...
else dia = "?";
```

Consejo: si solo hay una sentencia dentro del if, puedes escribirla sin llaves, pero para principiantes es más claro usar llaves siempre.

### 8.2 Switch (varios casos)

Evalúa una expresión y elige entre varios casos.

```java
switch (diasemana) {
  case 1: dia = "Lunes";     break;
  case 2: dia = "Martes";    break;
  case 3: dia = "Miércoles"; break;
  case 4: dia = "Jueves";    break;
  case 5: dia = "Viernes";   break;
  case 6: dia = "Sábado";    break;
  case 7: dia = "Domingo";   break;
  default: dia = "?";
}
```

Puntos importantes:

- La expresión del switch suele ser `byte`, `short`, `int`, `char`, `String` o sus clases envolventes.
- Cada `case` debe tener un valor único.
- “Ejecución por caída”: si no pones `break`, seguirá ejecutando los siguientes `case`.

Atajo desde Java 12 (estable desde Java 14):

```java
laborable = switch (diasemana) {
  case 1, 2, 3, 4, 5 -> true;
  case 6, 7 -> false;
};
```

---

## 9. Estructuras de repetición (bucles)

Un bucle repite instrucciones mientras se cumpla una condición.

### 9.1 While (mira la condición antes)

```java
while (condicion) {
    // se repite mientras condicion sea true
}
```

Ejemplo: factorial de 4 (4_3_2*1):

```java
int n = 4, factorial = 1, temporal = n;
while (temporal > 0) {
    factorial *= temporal;
    temporal -= 1;
}
```

Fases de un bucle:

- Entrada al bucle.
- Iteración (cada pasada por el cuerpo).
- Comprobación de la condición antes de cada iteración.
- Salida cuando la condición es falsa.
- “Controlado por contador” (sabes cuántas veces) vs “controlado por condición” (paras cuando ocurre algo).

### 9.3 Do while (se ejecuta al menos una vez)

Primero hace, luego comprueba la condición:

```java
do {
    // instrucciones
} while (condicion);
```

### 9.4 For (ideal para contadores y arrays)

Tiene tres partes: inicialización; condición; actualización:

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

Variantes:

```java
for (x = 0; x + y < 10 && z != 0; x++) { ... }
for (x = 0; x <= 10; x++, y++) { ... }
for (x = 0, y = 0; x <= 10; x++) { ... }
```

---

## 10. Salidas del bucle: romper o saltar

### 10.1 break

Sale del bucle inmediatamente (o del switch).

Estructurado (preferible) vs no estructurado:

- En lugar de usar `break` dentro de un `for` sin condición (que sería infinito), es mejor poner la condición en el `for` para que el bucle “se rompa” de forma natural.

### 10.2 continue

Salta a la siguiente iteración del bucle (no ejecuta lo que queda del cuerpo en esa pasada).

También existe la posibilidad de “etiquetas” para decidir a qué bucle externo volver, pero para principiantes es mejor evitarlo porque complica el flujo y la lectura.

---

## 11. Sentencia return (terminar un método y devolver valores)

- `return` termina el método y opcionalmente devuelve un valor.
- Si el método devuelve algo (no es `void`), todas las rutas deben terminar con `return` que devuelva el tipo correcto.

Con valor:

```java
public int sumar(int a, int b) {
    return a + b;
}
```

Solo terminar (método void):

```java
public void mostrar(String texto) {
    if (texto == null) {
        return; // termina sin hacer nada
    }
    System.out.println(texto);
}
```

---

# Anexo I: compilar y ejecutar tu primer programa

## ¿Qué necesitas?

- Un editor de texto (Bloc de notas, Notepad++, Sublime Text…).
- El **JDK** (Java Development Kit), que incluye:
    - El compilador (javac)
    - La JVM (para ejecutar)
    - Herramientas necesarias

Descarga el JDK desde la web de Oracle. Instálalo y (si hace falta) añade su ruta al PATH del sistema para poder usar `java` y `javac` desde la terminal.

Comprueba la instalación:

```bash
java -version
```

Si aparece la versión, está correcto. Si no, añade la ruta al bin del JDK en el PATH (Windows, Linux o macOS según tu sistema).

## Tu primer programa

Escribe esto y guárdalo como “MiPrimerPrograma.java” (el nombre de la clase debe coincidir con el archivo):

```java
public class MiPrimerPrograma {
    public static void main(String[] args) {
        System.out.println("Mi primer programa Java");
    }
}
```

Compila (traduce a bytecode):

```bash
javac MiPrimerPrograma.java
```

Se crea “MiPrimerPrograma.class”.

Ejecuta:

```bash
java MiPrimerPrograma
```

Verás en la consola:

```
Mi primer programa Java
```

Has compilado y ejecutado tu primer programa.

