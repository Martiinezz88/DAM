# 📘 Tema 4 – Formato de salida de impresión numérica

## 1. Métodos básicos: `print` y `println`

- **`print`** → escribe en pantalla sin salto de línea.
- **`println`** → escribe y añade salto de línea.

Ejemplo:

```java
System.out.print("Hola");
System.out.println(" mundo");
```

Salida:

```
Hola mundo
```

---

## 2. Métodos avanzados: `printf` y `format`

- Son equivalentes y permiten **dar formato** a la salida.
- Sintaxis:

```java
System.out.printf("texto %d %f %s%n", entero, decimal, cadena);
```

### Especificadores de formato

- `%d` → número entero decimal.
- `%f` → número real (float/double).
- `%s` → cadena (String).
- `%n` → salto de línea independiente de la plataforma.

Ejemplo:

```java
int i = 461012;
System.out.format("El valor de i es: %d%n", i);
```

Salida:

```
El valor de i es: 461012
```

---

## 3. Ejemplos prácticos

```java
long n = 461012;
System.out.format("%d%n", n);       // 461012
System.out.format("%08d%n", n);     // 00461012 (rellena con ceros)
System.out.format("%+8d%n", n);     //  +461012 (con signo)
System.out.format("%,8d%n", n);     // 461,012 (con separador de miles)

double pi = Math.PI;
System.out.format("%f%n", pi);      // 3.141593
System.out.format("%.3f%n", pi);    // 3.142 (3 decimales)
System.out.format("%10.3f%n", pi);  //      3.142 (alineado a la derecha)
System.out.format("%-10.3f%n", pi); // 3.142      (alineado a la izquierda)
System.out.format(Locale.FRANCE, "%-10.4f%n", pi); // 3,1416 (coma en vez de punto)
```

---

## 4. Crear cadenas formateadas con `String.format`

- Devuelve un String en lugar de imprimir directamente.
- Útil para reutilizar el texto.

Ejemplo:

```java
String fs = String.format("Edad: %d, Nota: %.1f, Nombre: %s", 20, 7.5, "Ana");
System.out.println(fs);
```

Salida:

```
Edad: 20, Nota: 7.5, Nombre: Ana
```

---

# 📘 Tema 4 – La clase String y sus métodos

## 1. Introducción

- Los tipos primitivos (`int`, `double`, etc.) tienen tamaño fijo.
- Los textos en Java son objetos de la clase **String**.
- Los String son **inmutables**: no se modifican, se crean nuevos cuando cambian.
- Se crean de dos formas:

```java
String texto1 = "Hola";                 // literal
String texto2 = new String("Hola");     // constructor
```

---

## 2. Comparación de Strings

- **equals:** compara contenido exacto

  ```

```java
"Hola".equals("Hola");  // true
"Hola".equals("hola");  // false
```

- **equalsIgnoreCase:** ignora mayúsculas/minúsculas.

```java
"Hola".equalsIgnoreCase("hola"); // true
```

- **compareTo:** orden alfabético Unicode.

```java
"casa".compareTo("cabo"); // > 0
"hola".compareTo("hola"); // 0
"a".compareTo("b");       // < 0
```

- **compareToIgnoreCase:** igual que compareTo, pero ignora mayúsculas/minúsculas.

---

## 3. String.valueOf

Convierte cualquier valor a texto.

```java
String numero = String.valueOf(1234); // "1234"
String letra = String.valueOf('Z');   // "Z"
String b = String.valueOf(true);      // "true"
```

---

## 4. Métodos principales de String

### 4.1 length

Devuelve la longitud de la cadena.

```java
String texto = "Prueba";
System.out.println(texto.length()); // 6
```

### 4.2 Concatenar

```java
String saludo = "Buenos " + "días";
String saludo2 = "Buenos ".concat("días");
```

### 4.3 charAt

Devuelve el carácter en una posición.

```java
String palabra = "Prueba";
char letra = palabra.charAt(2); // 'u'
```

### 4.4 substring

Devuelve una parte de la cadena.

```java
String frase = "Buenos días";
String trozo = frase.substring(7, 10); // "día"
```

### 4.5 indexOf

Devuelve la primera posición de un texto.

```java
String frase = "Quiero que vengas";
System.out.println(frase.indexOf("que")); // 7
```

### 4.6 lastIndexOf

Busca desde el final.

```java
System.out.println(frase.lastIndexOf("que")); // última posición
```

### 4.7 endsWith / startsWith

```java
frase.endsWith("venas");    // true
frase.startsWith("Quiero"); // true
```

### 4.8 replace

Reemplaza caracteres.

```java
String palabra = "Mariposa";
System.out.println(palabra.replace('a', 'e')); // "Meripose"
```

### 4.9 replaceAll

Reemplaza texto (puede usar expresiones regulares).

```java
String s = "Cazar armadillos";
System.out.println(s.replace("ar", "er")); // "Cazer ermadillos"
```

### 4.10 toUpperCase / toLowerCase

```java
String texto = "Hola";
System.out.println(texto.toUpperCase()); // "HOLA"
System.out.println(texto.toLowerCase()); // "hola"
```

### 4.11 toCharArray

Convierte a array de caracteres.

```java
char[] letras = "Hola".toCharArray();
```

### 4.12 trim

Elimina espacios al principio y al final.

```java
String texto = "  Hola  ";
System.out.println(texto.trim()); // "Hola"
```

---

## 5. Ejemplo práctico completo

```java
public class EjemploString {
    public static void main(String[] args) {
        String texto = "Buenos días";
        
        // Longitud
        System.out.println("Longitud: " + texto.length());
        
        // Substring
        System.out.println("Trozo: " + texto.substring(7, 10));
        
        // Reemplazo
        System.out.println("Reemplazo: " + texto.replace("días", "noches"));
        
        // Mayúsculas
        System.out.println("Mayúsculas: " + texto.toUpperCase());
        
        // Comparación
        System.out.println("¿Igual a 'Buenos días'? " + texto.equals("Buenos días"));
        
        // valueOf
        int numero = 123;
        String numeroTexto = String.valueOf(numero);
        System.out.println("Número como texto: " + numeroTexto);
    }
}
```

---

# ✅ Conclusión 

- **Formato de salida:** `printf` y `format` permiten mostrar números y textos con estilo (decimales, alineación, separadores).
- **Clase String:** es la herramienta para trabajar con textos en Java.
- Métodos como `length`, `substring`, `indexOf`, `replace`, `toUpperCase` son básicos para manipular cadenas.
- **Inmutabilidad:** cada vez que “cambias” un String, en realidad se crea uno nuevo.
- **Comparación:** siempre con `equals` o `compareTo`, nunca con `==.
- **valueOf:** convierte cualquier cosa en texto.