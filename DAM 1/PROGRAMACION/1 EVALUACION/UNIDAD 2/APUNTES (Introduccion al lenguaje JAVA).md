# 📘 Apuntes completos – Tema 2: Introducción al lenguaje Java

## 🎯 Objetivos

- Reconocer la importancia de Java.
- Usar identificadores significativos.
- Distinguir entre tipos predefinidos y definidos por el usuario.
- Diferenciar carácter y cadena.
- Diferenciar constante y variable.
- Describir un objeto de forma abstracta.
- Comprender los distintos tipos de datos numéricos y sus rangos.
- Entender la diferencia entre enteros, reales y punto flotante.
- Ver cómo la precedencia afecta a las expresiones.
- Comprender la conversión de tipos (implícita y explícita).

---

## 1. Introducción a Java

- Creado por **Sun Microsystems**, basado en C++ pero más sencillo.
- Desde 2006 es **software libre**.
- Popularidad: muy usado en empresas y ofertas de empleo.
- Ventajas: portabilidad, comunidad amplia, facilidad de aprendizaje.

### Java es fácil de aprender

- No tiene punteros.
- La memoria se gestiona automáticamente.
- **WORA (Write Once, Run Anywhere)**: escribir una vez, ejecutar en cualquier plataforma.
- El código fuente se compila a **Bytecode**, que se ejecuta en cualquier máquina con la **JVM**.

### Software necesario

- **Eclipse**: IDE libre.
- **JDK**: compiladores y depuradores.
- **JRE**: librerías y la JVM.

---

## 2. Concepto de Dato

- Un **dato** es cualquier información que el ordenador maneja: número, letra, imagen, canción, etc.
- Los datos deben estar organizados y estructurados.

---

## 3. Tipos de datos

### 3.1 Variables y constantes

- **Variable**: zona de memoria cuyo valor puede cambiar.

```java
int dias;
```

- **Constante**: valor fijo, declarada con `final`.

```java
final float IVA = 0.21f;
```

#### Normas de estilo

- Variables → minúscula inicial: `numAlumnos`.
- Constantes → mayúsculas con guiones bajos: `TAM_MAX`.
- Clases → mayúscula inicial: `Alumno`.
- Métodos → minúscula inicial: `calcularNota()`.

---

### 3.2 Preguntas que definen un tipo de dato

1. ¿Qué valores son válidos?
2. ¿Qué operaciones puedo hacer con ellos?

---

### 3.3 Datos primitivos

Son los básicos que Java ofrece directamente:

|Tipo|Descripción|
|---|---|
|boolean|`true` o `false`.|
|char|Carácter Unicode (16 bits).|
|byte|Entero de 8 bits (-128 a 127).|
|short|Entero de 16 bits.|
|int|Entero de 32 bits.|
|long|Entero de 64 bits.|
|float|Real de 32 bits.|
|double|Real de 64 bits.|

#### Enteros

- `byte`, `short`, `int`, `long`.
- Diferencia: rango de valores y memoria usada.

#### Reales

- `float` y `double`.
- `double` es más preciso y se recomienda usarlo por defecto.

#### Booleanos

- Valores lógicos: `true` o `false`.
- Operadores: `&&` (AND), `||` (OR), `!` (NOT).

#### Carácter

- Tipo `char`.
- Usa Unicode (16 bits).
- Se puede operar con caracteres como si fueran números (su código Unicode).

---

### 3.4 Literales

- **Booleanos**: `true`, `false`.
- **Enteros**: decimal (`20`), octal (`024`), hexadecimal (`0x14`).
- **Reales**: `13.2`, `1.32e1`, `6.022e+23f`.
- **Carácter**: `'A'`, `'\u0041'`.
- **Cadenas (String)**: `"Hola mundo"`.

---

### 3.5 Tipos referenciados

- Construidos a partir de los primitivos.
- Ejemplos: `String`, arrays, objetos.

```java
String mensaje = "Mi primer programa";
int[] numeros = new int[5];
```

---

## 4. Datos estructurados

- **String**: cadenas de caracteres (objetos).
- **Arrays**: vectores y matrices.
- **Registros**: agrupación de datos relacionados.
- **Archivos**: datos almacenados en disco.
- **Listas y árboles**: estructuras dinámicas para organizar datos.

---

## 5. Datos definidos por el usuario

- **Enumerados**: conjunto de valores predefinidos.

```java
enum Dia {LUNES, MARTES, MIERCOLES}
```

- **Objetos**: creados a partir de clases.
- Se definen por **atributos** (datos) y **métodos** (acciones).

---

## 6. Operadores y expresiones

### 🔹 6.1 Operadores aritméticos

Se usan para operaciones matemáticas básicas.

- `+` → suma
- `-` → resta
- `*` → multiplicación
- `/` → división
- `%` → resto (módulo)

```java
int a = 10, b = 3;
System.out.println(a + b); // 13
System.out.println(a % b); // 1
```

---

### 🔹 6.2 Operadores de asignación

Asignan valores a variables.

- = → asignación simple
- `+=` → suma y asigna
- `-=` → resta y asigna
- `*=` → multiplica y asigna
- `/=` → divide y asigna

```java
int x = 5;
x += 3; // x = 8
```

---

### 🔹 6.3 Operador condicional (ternario)

Permite decidir entre dos valores en una sola línea.

```java
int edad = 20;
String resultado = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
System.out.println(resultado);
```

---

### 🔹 6.4 Operadores de relación

Comparan valores y devuelven `true` o `false`.

- == → igual
- `!=` → distinto
- `<` → menor
- `>` → mayor
- `<=` → menor o igual
- `>=` → mayor o igual

```java
int a = 5, b = 10;
System.out.println(a < b); // true
```

---

### 🔹 6.5 Operadores lógicos

Trabajan con valores booleanos.

- `&&` → AND (conjunción)
- `||` → OR (disyunción)
- `!` → NOT (negación)

```java
boolean esAdulto = true;
boolean tieneCarnet = false;

System.out.println(esAdulto && tieneCarnet); // false
System.out.println(esAdulto || tieneCarnet); // true
System.out.println(!esAdulto); // false
```

---

### 🔹 6.6 Operadores de bits

Operan directamente sobre los bits de los números enteros.

- `&` → AND bit a bit
- `|` → OR bit a bit
- `^` → XOR bit a bit
- `~` → NOT bit a bit
- `<<` → desplazamiento a la izquierda
- `>>` → desplazamiento a la derecha

```java
int a = 5;  // 0101 en binario
int b = 3;  // 0011 en binario

System.out.println(a & b); // 1 (0001)
System.out.println(a | b); // 7 (0111)
```

---

### 🔹 6.7 Precedencia de operadores

Define el orden en que se evalúan las operaciones.

1. Paréntesis `()`
2. Multiplicación, división, módulo `* / %`
3. Suma y resta `+ -`
4. Comparaciones `< > <= >=`
5. Igualdad == ,  !=
6. Lógicos `&& ||`
7. Asignación = , += , -= , `*=` ,  /=

👉 Ejemplo:

```java
int resultado = 5 + 3 * 2; // resultado = 11 (no 16)
```


## 7. Conversión de tipos

- **Implícita (promoción)**: el lenguaje convierte automáticamente a un tipo mayor.

```java
int x = 5;
double y = x; // conversión implícita
```

- **Explícita (casting)**: el programador fuerza la conversión.

```java
double d = 9.7;
int i = (int) d; // i = 9
```

### Reglas de promoción

- Enteros pequeños (`byte`, `short`) se convierten a `int`.
- Operaciones con `double` → resultado en `double`.

### Conversiones específicas

- **Reales a enteros**: se pierde la parte decimal.
- **Char ↔ int**: se usa el código Unicode.
- **String ↔ otros tipos**: mediante métodos (`Integer.parseInt("123")`).

---

## 8. Comentarios

- **Una línea**: `// comentario`.
- **Varias líneas**: `/* comentario */`.
- **Documentación**: `/** comentario */`.

---

## 9. Entrada y salida

- **Entrada (teclado)**: `Scanner`.

```java
Scanner sc = new Scanner(System.in);
int edad = sc.nextInt();
```

- **Salida (pantalla)**:

```java
System.out.println("Texto");
```

---

