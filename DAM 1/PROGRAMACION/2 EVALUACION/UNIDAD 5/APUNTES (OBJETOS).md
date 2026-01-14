# 12/12/25

## 1. Clase..

- **Explicación:**  
    Una clase es como un plano o receta. No es el objeto en sí, sino la definición de cómo será. Dentro de una clase se definen:
    
    - **Atributos (variables):** características del objeto.
    - **Métodos (funciones):** acciones que el objeto puede realizar.
- **Ejemplo cotidiano:** La receta de una pizza. Dice qué ingredientes lleva y cómo se prepara, pero no es una pizza todavía.
    
- **Ejemplo en Java:**
    

```java
// Definimos una clase llamada Pizza
class Pizza {
    // Atributos: características de la pizza
    String ingredientes;
    int tamaño;

    // Método: acción que puede realizar la pizza
    void hornear() {
        System.out.println("La pizza está en el horno...");
    }
}
```

-> Aquí **Pizza** es solo el molde. No existe ninguna pizza real todavía.



---

## 2. Objeto

- **Explicación:**  
    Un objeto es la **instancia real** creada a partir de una clase. Es como cocinar la pizza siguiendo la receta: ahora sí tienes algo tangible.
    
- **Ejemplo cotidiano:** La pizza cocinada que puedes comer.
    
- **Ejemplo en Java:**
    

```java
// Creamos un objeto a partir de la clase Pizza
Pizza miPizza = new Pizza(); // Objeto real

// Le damos valores a sus atributos
miPizza.ingredientes = "Tomate y queso";
miPizza.tamaño = 30;

// Usamos sus métodos
miPizza.hornear();
```

-> Aquí **miPizza** es un objeto real. Tiene ingredientes y tamaño propios.

---

## 3. Instanciación

- **Explicación:**  
    Es el proceso de crear un objeto a partir de una clase. En Java se hace con la palabra clave `new`.
    
- **Ejemplo cotidiano:** El acto de cocinar la pizza siguiendo la receta.
    
- **Ejemplo en Java:**
    

```java
Pizza otraPizza = new Pizza(); // Instanciación
```

---

## 4. Modularización

- **Explicación:**  
    Dividir el programa en partes más pequeñas y fáciles de entender. Cada módulo hace una tarea específica.
    
- **Ejemplo cotidiano:** Para hacer una pizza, primero preparas la masa, luego añades ingredientes y finalmente la horneas.
    
- **Ejemplo en Java
    

```java
class Pizza {
    void prepararMasa() {
        System.out.println("Masa preparada.");
    }
    void agregarIngredientes() {
        System.out.println("Ingredientes añadidos.");
    }
    void hornear() {
        System.out.println("Pizza horneada.");
    }
}
```

-> Cada método es un módulo independiente que hace una parte del proceso.

---

## 5. Ocultación

- **Explicación:**  
    Esconde los detalles internos para que el usuario no tenga que preocuparse por ellos.  
    Ejemplo: cuando conduces un coche, no ves cómo funciona el motor, solo usas el volante y pedales.
    
- **Ejemplo en Java:**
    

```java
class Coche {
    private String motor = "V8"; // Oculto al usuario

    public void conducir() {
        System.out.println("El coche avanza sin mostrar el motor.");
    }
}
```

-> El atributo `motor` está oculto (`private`). Solo se puede interactuar con el coche mediante el método `conducir`.

---

## 6. Encapsulación

- **Explicación:**  
    Es proteger los datos y controlar cómo se accede a ellos. Se usan **getters** y **setters** para acceder y modificar los atributos.
    
- **Ejemplo cotidiano:** Una caja fuerte con llave. No puedes abrirla directamente, necesitas la clave.
    
- **Ejemplo en Java:**
    

```java
class CuentaBancaria {
    private double saldo = 1000; // Dato protegido

    // Observador (getter): muestra el saldo
    public double getSaldo() {
        return saldo;
    }

    // Transformador (setter): modifica el saldo
    public void depositar(double cantidad) {
        saldo += cantidad;
    }
}
```

-> El saldo está protegido. Solo se puede consultar con `getSaldo()` y modificar con `depositar()`.

---

## 7. Tipos de datos

- **Primitivos:** básicos como `int`, `char`, `boolean`.

```java
int edad = 25;
char inicial = 'J';
boolean casado = false;
```

- **Compuestos:** más complejos como arrays u objetos.

```java
String[] nombres = {"Ana", "Luis", "José"};
```

---

## 8. Tipos Abstractos de Datos (TAD)

- **Explicación:**  
    Son ideas abstractas de cómo organizar datos y qué operaciones se pueden hacer con ellos.  
    Ejemplo: una pila de platos (apilar y desapilar).
    
- **Ejemplo en Java:**
    

```java
import java.util.Stack;

Stack<String> platos = new Stack<>();
platos.push("Plato1"); // Apilar
platos.push("Plato2");
System.out.println(platos.pop()); // Desapilar (quita el último)
```

---

## 9. Estructura de datos

- **Explicación:**  
    Es la implementación concreta de cómo organizar los datos.  
    Ejemplo: una cola en el supermercado (el primero en entrar es el primero en salir).
    
- **Ejemplo en Java:**
    

```java
import java.util.LinkedList;
import java.util.Queue;

Queue<String> cola = new LinkedList<>();
cola.add("Persona1"); // Entra al final
cola.add("Persona2");
System.out.println(cola.remove()); // Sale el primero
```

---

## 10. Diferencia clave

- Clase → el plano, la receta 🍕
- Objeto → la pizza cocinada
- Instanciación → el acto de cocinar

---

## 11. Métodos especiales

- **Constructor:** inicializa el objeto.

```java
class Movil {
    String idioma;
    Movil(String idioma) { // Constructor
        this.idioma = idioma;
    }
}
Movil miMovil = new Movil("Español");
```

- **Transformador:** cambia datos internos.

```java
miMovil.idioma = "Inglés"; // Cambia idioma
```

- **Observador:** muestra datos sin cambiarlos.

```java
System.out.println(miMovil.idioma); // Muestra idioma
```

- **Copy Constructor (simulado en Java):**

```java
class Documento {
    String texto;
    Documento(Documento otro) { // Copia otro objeto
        this.texto = otro.texto;
    }
}
```

- **Iterator:**

```java
import java.util.ArrayList;

ArrayList<String> lista = new ArrayList<>();
lista.add("Ana");
lista.add("Luis");

for(String nombre : lista) {
    System.out.println(nombre); // Recorre la lista
}
```

- **Helper (método auxiliar):**

```java
class Cocina {
    void cortarVerduras() {
        System.out.println("Verduras cortadas.");
    }
    void cocinar() {
        cortarVerduras(); // Usa el helper
        System.out.println("Cocinando...");
    }
}
```

- **Destructor:** en Java lo hace automáticamente el Garbage Collector.

---
# TEMA  1 : Paradigma de programación orientada a objetos

## Idea general

Cuando pensamos en programar, solemos pensar en “escribir código”. Pero en proyectos reales (grandes) el código es solo una parte. También hay:

- **Análisis del problema**
- **Especificación de requisitos**
- **Diseño**
- **Implementación (codificar)**
- **Pruebas y verificación**
- **Entrega**
- **Operación y mantenimiento**

La **programación orientada a objetos (POO)** se introduce como una forma de mejorar la **calidad del software**, tanto por fuera (lo que ve el usuario) como por dentro (cómo está hecho el código).

---

## 1.1 Calidad del software: factores externos

Son las características que **ve el usuario**. Si un programa es “bueno” para el usuario, es porque cumple bien estos factores.

### 1.1.1 Corrección

**Definición corta para tus apuntes:**

- **Corrección:** El programa hace exactamente lo que dicen las especificaciones, ni más ni menos.

**Ejemplo:**

Un programa de nóminas:

- Si la especificación dice que debe calcular el IRPF según unas tablas concretas, un programa **correcto** lo hará siempre bien para todos los casos contemplados.
- Si da un resultado equivocado en ciertas situaciones, deja de ser correcto, aunque “no se cuelgue” ni dé errores visuales.

---

### 1.1.2 Robustez

**Definición corta:**

- **Robustez:** Capacidad del programa para reaccionar bien ante situaciones no previstas o entradas incorrectas.

**Ejemplo:**

En un programa que pide la edad por teclado:

- El usuario escribe `23` → todo bien.
- El usuario escribe `hola`:
    - Un programa **robusto** muestra un mensaje de error claro y no se rompe.
    - Un programa **no robusto** puede colgarse, lanzar una excepción sin controlar, o mostrar un comportamiento raro.

En Java, un ejemplo robusto al leer un número podría ser:

```java
Scanner sc = new Scanner(System.in);
System.out.print("Introduce tu edad: ");

if (sc.hasNextInt()) {
    int edad = sc.nextInt();
    System.out.println("Tienes " + edad + " años.");
} else {
    System.out.println("Error: debes introducir un número entero.");
}
```

---

### 1.1.3 Extensibilidad

**Definición corta:**

- **Extensibilidad:** Facilidad con la que se puede modificar o ampliar el programa cuando cambian las especificaciones.

**Ejemplo:**

Sistema de nóminas:

- Hoy la ley cambia el tipo de retención.
- Mañana se añade un plus nuevo.
- Pasado se cambia la forma de calcular las horas extra.

Un sistema **extensible**:

- Tiene el cálculo separado en módulos/clases claros.
- Te permite cambiar solo una parte sin romper todo lo demás.

Un sistema **no extensible**:

- Tiene cálculos mezclados por todo el programa.
- Cambiar algo implica tocar muchos sitios → más probabilidad de errores y costoso de mantener.

---

### 1.1.4 Reutilización

**Definición corta:**

- **Reutilización:** Capacidad de aprovechar elementos de software ya existentes (clases, funciones, módulos) en distintos programas o proyectos.

**Ejemplo:**

Imagínate que has creado una clase `Fecha`:

```java
public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public boolean esBisiesto() {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }
}

```

Si la diseñas bien, puedes usarla:

==**private** sirve para proteger los métodos y atributos para que únicamente solo puedan utilizarse dentro de la propia clase sin que interfiera con otra y así evitar que rompan los objetos==

- En un programa de nóminas.
- En un calendario.
- En un gestor de tareas.

La POO ayuda mucho a la reutilización porque:

- Las **clases** bien diseñadas se pueden **heredar** o **componer** en otros proyectos.

---

### 1.1.5 Compatibilidad

**Definición corta:**

- **Compatibilidad:** Capacidad del software para combinarse y trabajar correctamente con otros programas o sistemas.

**Ejemplo:**

- Un programa genera un archivo `.csv` y otro programa lo abre.
- Son compatibles si:
    - Usan el mismo formato (comas, punto y coma, codificación, etc.).
    - Siguen convenciones comunes.

En la práctica:

- Diseñar APIs claras.
- Usar formatos estándar (JSON, XML, etc.).
- No inventar cosas raras sin documentar.

---

### 1.1.6 Eficiencia

**Definición corta:**

- **Eficiencia:** El programa consume la menor cantidad posible de recursos (tiempo, memoria, CPU, disco, red) para hacer su trabajo.

**Ejemplo:**

- Dos programas hacen lo mismo:
    - Programa A tarda 1 segundo y usa poca memoria.
    - Programa B tarda 30 segundos y consume 4 GB de RAM.
- Ambos pueden ser correctos y robustos, pero A es **más eficiente**.

En Java, ejemplos típicos:

- Elegir bien las estructuras de datos (`ArrayList` vs `LinkedList`, `HashMap`, etc.).
- Evitar bucles innecesarios.
- No repetir cálculos que se pueden guardar.

---

### 1.1.7 Portabilidad

**Definición corta:**

- **Portabilidad:** Capacidad de un programa para funcionar en diferentes entornos (distintos sistemas operativos, arquitecturas, etc.) con pocos o ningún cambio.

**Ejemplo:**

- Un programa en Java suele ser más portable que uno que depende fuertemente de detalles específicos de Windows.
- Si tu programa no usa rutas “hardcodeadas” tipo `C:\algo\...` y usa en su lugar cosas como `System.getProperty("user.home")`, será más fácil moverlo entre Windows, Linux, macOS.

Java de por sí está muy orientado a la portabilidad gracias a la JVM, pero puedes arruinarlo si dependes de cosas muy específicas del sistema.

---

### 1.1.8 Facilidad de uso

**Definición corta:**

- **Facilidad de uso (usabilidad):** Lo fácil que resulta aprender y utilizar el programa para usuarios con distintas formaciones.

**Ejemplo:**

- Un programa “fácil de usar”:
    - Tiene menús claros.
    - Mensajes de error comprensibles.
    - No obliga al usuario a leerse un manual de 200 páginas.

Pensando ya en POO:

- Una **buena interfaz de usuario** puede estar separada del núcleo de lógica (patrón MVC), lo que facilita cambiar la interfaz sin reescribir el programa entero.

---

### 1.1.9 Economía

**Definición corta:**

- **Economía:** Relación entre coste del software (desarrollarlo, mantenerlo, licencias) y lo que ofrece.

**Idea clave:**

- Que algo sea caro no implica que sea de calidad.
- Pero un software de calidad suele reducir costes a largo plazo (menos bugs, menos mantenimiento caótico, más reutilización, etc.).

---

## 1.2 Calidad del software: factores internos

Ahora pasamos a lo que **no ve el usuario**, pero que es clave para poder conseguir buenos factores externos.

### 1.2.1 Modularidad

**Definición corta:**

- **Modularidad:** Capacidad de dividir el programa en partes (módulos/clases) relativamente independientes, cada una con un propósito claro.

**Relación con factores externos:**

- Facilita:
    - **Extensibilidad:** si algo cambia, tocas solo ciertos módulos.
    - **Reutilización:** puedes llevarte un módulo a otro proyecto.

**Ejemplo:**

Sistema de tienda online:

- Módulo `Carrito`.
- Módulo `Pago`.
- Módulo `Productos`.
- Módulo `Usuarios`.

Si cada módulo está bien definido, ampliar el sistema (por ejemplo, añadir PayPal como método de pago) es mucho más sencillo.

En Java, modularidad se traduce en:

- Paquetes.
- Clases bien separadas por responsabilidad.

---

### 1.2.2 Legibilidad

**Definición corta:**

- **Legibilidad:** Que el código sea fácil de entender por otra persona (o por ti dentro de 6 meses).

**Elementos clave:**

- **Buenos nombres** de variables, métodos y clases.
- **Indentación correcta.**
- **Comentarios útiles** (no obviedades).
- Código organizado en métodos que hagan una única cosa.

**Ejemplo en Java malo:**

```java
int a, b, c;
a = sc.nextInt();
b = sc.nextInt();
c = a * b;
System.out.println(c);
```

**Ejemplo más legible:**

```java
int base = sc.nextInt();
int altura = sc.nextInt();
int area = base * altura;
System.out.println(area);
```

Aunque hagan lo mismo, el segundo es mucho más entendible.

# TEMA 2: La programación orientada a objetos

## 2.0. Qué es un paradigma de programación

Antes de entrar en la programación orientada a objetos, es necesario entender qué significa la palabra “paradigma” en programación.

Un paradigma es una forma de pensar y organizar un programa.  
Es una filosofía que indica cómo se deben estructurar las soluciones, cómo se deben dividir los problemas y cómo se debe escribir el código.

En programación existen muchos paradigmas, pero en este tema nos interesan dos:

1. El paradigma imperativo, que da lugar a la programación estructurada.
2. El paradigma orientado a objetos, que da lugar a la programación orientada a objetos (POO).

Cada uno de estos paradigmas propone una forma distinta de organizar el código y de resolver problemas.

---

## 2.1. Programación estructurada: cómo funciona y por qué empieza a fallar

La programación estructurada fue durante muchos años la forma principal de programar.  
Se basa en dividir el programa en funciones o procedimientos, cada uno encargado de realizar una tarea concreta.

### 2.1.1. Cómo piensa la programación estructurada

La programación estructurada se centra en las acciones.  
El programador piensa en términos de pasos:

- Primero haz esto.
- Luego haz esto otro.
- Si ocurre esta condición, ejecuta esta acción.
- Repite esta operación hasta que se cumpla algo.

Es un enfoque muy parecido a escribir una receta de cocina o un manual de instrucciones.

### 2.1.2. Cómo se organiza el código en estructurada

El código se divide en funciones.  
Cada función realiza una tarea concreta.  
Los datos están fuera de las funciones y estas los utilizan cuando los necesitan.

Ejemplo sencillo:

```java
int sumar(int a, int b) {
    return a + b;
}

int resultado = sumar(3, 5);
```

Aquí:

- La función `sumar` es una acción.
- Los números son datos.
- La función no pertenece a ningún objeto, simplemente existe.

Este enfoque funciona bien en programas pequeños, pero cuando el programa crece empiezan los problemas.

---

### 2.1.3. Problemas de la programación estructurada

A continuación se explican los problemas principales que aparecen cuando se usa programación estructurada en proyectos grandes.

#### Problema 1: Separación entre datos y procesos

En la programación estructurada, los datos están por un lado y las funciones por otro.  
Las funciones manipulan los datos, pero no están unidas a ellos.

Ejemplo:

```java
String nombre;
int edad;

void mostrar() {
    System.out.println(nombre + " tiene " + edad + " años.");
}
```

Aquí no existe una entidad “Persona”.  
Solo hay variables sueltas y funciones que las usan.

Esto provoca:

- Código desorganizado.
- Dificultad para saber qué función modifica qué datos.
- Mayor probabilidad de errores.

#### Problema 2: Alta dependencia entre datos y funciones

Como los datos y las funciones están separados, cualquier cambio en los datos obliga a revisar todas las funciones que los usan.

Ejemplo:

```java
// Antes
String apellidos;

// Después
String primerApellido;
String segundoApellido;
```

Todas las funciones que usaban `apellidos` dejan de funcionar.  
Esto hace que el programa sea difícil de mantener y muy frágil ante cambios.

#### Problema 3: No representa el mundo real

En la vida real, las cosas tienen características y comportamientos.  
Una persona tiene nombre, edad, altura, y además puede comer, dormir, caminar.

En la programación estructurada, esto no existe.  
Solo hay variables y funciones sueltas.

Ejemplo:

```java
String nombre;
int edad;

void comer() { ... }
void dormir() { ... }
```

No existe una entidad “Persona”.  
Esto hace que el código sea menos intuitivo y más difícil de entender.

#### Problema 4: Poca reutilización

Como no existen objetos completos, sino funciones dispersas, es difícil reutilizar código en otros proyectos.

Cuando empiezas un proyecto nuevo, no puedes llevarte una clase “Persona” o “Coche”.  
Solo puedes llevarte funciones sueltas, y muchas veces acabas reescribiendo código que ya habías hecho.

Esto implica:

- Más tiempo.
- Más errores.
- Más coste.

---

## 2.2. Por qué programar con objetos

La programación orientada a objetos surge para solucionar los problemas anteriores.

La idea principal es muy sencilla:

Si el mundo real está formado por objetos, los programas también deberían estar formados por objetos.

### 2.2.1. Qué es un objeto

Un objeto es una unidad que combina:

- Atributos: características del objeto.
- Métodos: acciones que el objeto puede realizar.

Ejemplos:

Pelota  
Atributos: peso, color, material  
Métodos: botar, rodar, inflar

Coche  
Atributos: marca, color, combustible  
Métodos: acelerar, frenar, girar

Persona  
Atributos: nombre, edad, altura  
Métodos: comer, dormir, caminar

### 2.2.2. Qué es una clase

Una clase es el plano o molde a partir del cual se crean objetos.

Ejemplo en Java:

```java
class Coche {
    String marca;
    int velocidad;

    void acelerar() {
        velocidad += 10;
    }
}
```

Y para crear un objeto:

```java
Coche miCoche = new Coche();
miCoche.marca = "Toyota";
miCoche.acelerar();
```

### 2.2.3. Ventajas de programar con objetos

1. Los datos y las acciones están unidos dentro del objeto.
2. El código se parece más al mundo real, lo que facilita pensar en soluciones.
3. Las clases bien diseñadas se pueden reutilizar en otros proyectos.
4. Es más fácil modificar o ampliar el programa sin romperlo.
5. El mantenimiento es más sencillo porque el código está organizado en unidades lógicas.

---

## 2.3. La reutilización como factor de calidad

Una de las mayores ventajas de la programación orientada a objetos es la reutilización.

Las clases funcionan como piezas estándar que se pueden usar en muchos programas distintos.

Ejemplo:

```java
class Fecha {
    int dia;
    int mes;
    int año;
}
```

Esta clase puede usarse en:

- un calendario
- un sistema de facturación
- un sistema de reservas
- un videojuego

Además, la POO permite heredar clases, lo que facilita aún más la reutilización.

### Por qué no se empieza el curso directamente con POO

Para poder crear objetos necesitas saber:

- variables
- tipos
- condicionales
- bucles
- funciones

La POO se construye sobre la programación estructurada, por eso primero se enseñan las bases.

---

# TEMA 3: Diseño de programas

Cuando te dan un problema para programar (por ejemplo, “haz una agenda”, “haz un juego”, “haz un sistema de reservas”), no puedes ponerte a escribir código a lo loco.  
Primero hay que pensar cómo vas a organizar la solución.

El “diseño de programas” es esa fase intermedia entre:

- saber qué tiene que hacer el programa (especificación), y
- escribir el código (implementación).

En este tema se presentan varias ideas importantes para diseñar bien:

- Abstracción
- Refinamiento sucesivo (top-down)
- Tarjetas CRC (para diseño orientado a objetos)
- Ejemplo práctico (agenda de direcciones)

---

## 3.1. Abstracción

### 3.1.1. Qué es la abstracción (idea general)

Abstraer significa quedarse solo con lo importante y dejar fuera los detalles que no son necesarios en ese momento.

En programación, una abstracción es una representación simplificada de algo más complejo.  
No intentas copiar la realidad al 100%, sino crear un modelo que tenga:

- solo las propiedades necesarias, y
- el comportamiento relevante para el problema que quieres resolver.

Es una forma de reducir la complejidad.

### 3.1.2. Ejemplo cotidiano

Piensa en un mapa del metro de una ciudad.

- No te muestra edificios, árboles, semáforos, ni todas las calles.
- Solo te muestra las estaciones y las líneas que las conectan.

Ese mapa es una abstracción de la ciudad.  
Oculta detalles que no son importantes para viajar en metro.

Otro ejemplo: un globo terráqueo.

- La Tierra es un esferoide achatado por los polos.
- El globo que tienes en casa es una esfera perfecta.
- Para estudiar países y océanos, esa simplificación es suficiente.  
    No necesitas modelar exactamente la forma física de la Tierra.

### 3.1.3. Abstracción en programación orientada a objetos

Cuando diseñas un sistema orientado a objetos, todo el rato estás haciendo abstracciones.

Por ejemplo, si quieres representar un coche en tu programa:

En la realidad, un coche tiene:

- Motor
- Sistema eléctrico
- Sistema de frenos
- Sistema de refrigeración
- Calculadora del consumo
- Unidad de control electrónico
- Etc.

Si intentaras meter todo eso en tu clase Coche, acabarías con algo inmanejable.

En tu programa, quizá solo necesitas:

- Atributos como marca, velocidad, combustible.
- Métodos como acelerar(), frenar(), girar().

Lo que haces es crear una abstracción de un coche.  
No modelas todas las piezas reales, sino solo lo que es útil para tu problema.

Ejemplo en Java:

```java
class Coche {
    String marca;
    int velocidad;
    int combustible;

    void acelerar() {
        if (combustible > 0) {
            velocidad += 10;
            combustible -= 1;
        }
    }

    void frenar() {
        if (velocidad >= 10) {
            velocidad -= 10;
        } else {
            velocidad = 0;
        }
    }
}
```

Este `Coche` no es un coche real.  
Es una abstracción: un modelo simple que solo incluye lo esencial para el programa.

### 3.1.4. Diferentes abstracciones para la misma cosa

Según quién mire un sistema, la abstracción será distinta.

Ejemplo: un coche

- Para un conductor:
    - el coche es un medio de transporte
    - le importa el volante, los pedales, los botones
- Para un mecánico:
    - el coche es un conjunto de piezas
    - le importan el motor, el sistema eléctrico, los frenos
- Para un diseñador de aerodinámica:
    - le importa la forma de la carrocería, el coeficiente de rozamiento

En programación pasa igual:  
Según el problema que estés resolviendo, tu abstracción de un objeto será diferente.

---

## 3.2. Refinamiento sucesivo (diseño top-down)

### 3.2.1. Idea general

El refinamiento sucesivo (también llamado diseño descendente o top-down) es una técnica de diseño donde empiezas por una visión global del problema y poco a poco lo vas descomponiendo en partes más pequeñas y detalladas.

Vas del “qué” al “cómo” en varios niveles:

1. Primero describes el problema de forma muy general.
2. Lo divides en grandes bloques o tareas.
3. Esas tareas las vuelves a dividir en subtareas más concretas.
4. Sigues refinando hasta que cada parte sea lo suficientemente simple como para programarla.

### 3.2.2. Ejemplo cotidiano

Imagina que quieres escribir un libro.

- Al principio, piensas en el libro como un todo.
- Luego decides los capítulos.
- Dentro de cada capítulo, decides las secciones.
- Dentro de cada sección, las ideas principales.
- Al final, escribes los párrafos y las frases.

No empiezas escribiendo la primera frase sin tener ni idea de cómo será el resto del libro.  
Primero diseñas la estructura general.

### 3.2.3. Ejemplo aplicado a programación

Supongamos que quieres diseñar un programa para gestionar una agenda de contactos.

Nivel 1 (muy general):

- gestionarAgenda()

Nivel 2 (un poco más detallado):

- mostrarMenú()
- añadirContacto()
- buscarContacto()
- eliminarContacto()
- salir()

Nivel 3 (más detallado en una parte, por ejemplo, añadirContacto):

- pedirDatosContacto()
- validarDatos()
- guardarContacto()

En pseudocódigo:

```text
gestionarAgenda()
    repetir
        mostrarMenú()
        leerOpción()
        según opción
            caso 1: añadirContacto()
            caso 2: buscarContacto()
            caso 3: eliminarContacto()
            caso 4: salir()
    hasta que opción == 4
```

Cada una de esas funciones (añadirContacto, buscarContacto, etc.) se puede seguir refinando hasta llegar a nivel de código concreto.

### 3.2.4. Diseño descendente vs diseño ascendente

El refinamiento sucesivo es diseño descendente (top-down):

- Empiezas desde arriba, desde una visión general del sistema.
- Vas bajando hasta llegar a detalles concretos.

El diseño ascendente (bottom-up) es lo contrario:

- Empiezas creando componentes pequeños y detallados (por ejemplo, una clase Fecha, una clase Persona, una clase Dirección).
- Luego vas combinando esos componentes para formar partes más grandes del sistema.
- Finalmente, obtienes el sistema completo.

Ejemplo de diseño ascendente:

- Primero implementas una clase `Fecha`
- Luego una clase `Persona`
- Luego una clase `Contacto` que usa `Persona` y `Fecha`
- Luego una clase `Agenda` que contiene varios `Contacto`

En la práctica, muchas veces se combinan las dos:  
A veces partes de arriba a abajo, otras veces diseñas primero componentes que sabes que vas a necesitar.

---

## 3.3. Tarjetas CRC (Class, Responsibility, Collaboration)

### 3.3.1. Qué son las tarjetas CRC

Las tarjetas CRC son una herramienta de diseño para programación orientada a objetos.

CRC significa:

- Class (Clase)
- Responsibility (Responsabilidad)
- Collaboration (Colaboración)

La idea es usar tarjetas (físicas o virtuales) para pensar y decidir:

- qué clases necesitas
- qué responsabilidades tendrá cada clase
- con qué otras clases colaborará para cumplir esas responsabilidades

Es una forma muy visual y práctica de diseñar sistemas orientados a objetos sin escribir código todavía.

### 3.3.2. Qué se escribe en una tarjeta CRC

Cada tarjeta representa una clase.

Normalmente se escriben:

- Nombre de la clase
- Responsabilidad principal (qué hace esa clase, su “motivo de existir”)
- Otras responsabilidades concretas
- Colaboraciones (otras clases con las que interactúa)

La estructura típica de una tarjeta CRC podría ser así:

- Nombre de la clase: `Agenda`
- Responsabilidad principal:
    - gestionar la colección de contactos
- Otras responsabilidades:
    - añadir contacto
    - buscar contacto
    - eliminar contacto
- Colaboraciones:
    - `Contacto` (porque la agenda contiene contactos)

En el diseño real, a veces también se incluye:

- Superclase (de qué clase hereda, si hay herencia)
- Comentarios o notas adicionales

### 3.3.3. Por qué son útiles

Las tarjetas CRC ayudan a:

- Pensar en términos de clases y objetos, no solo en funciones.
- Repartir responsabilidades de forma clara:
    - Cada clase debe tener un propósito bien definido.
- Evitar clases “Dios” que lo hacen todo.
- Diseñar en equipo: cada persona puede sostener una tarjeta y representar su clase en una discusión.

Son especialmente útiles al principio del diseño orientado a objetos, cuando aún no quieres entrar en detalles de código.

---

## 3.4. Ejemplo de diseño: una agenda de direcciones

Vamos a ver cómo aplicar todos estos conceptos (abstracción, refinamiento, CRC) a un ejemplo concreto: una agenda.

### 3.4.1. Descripción del problema

Te piden crear una agenda de direcciones.  
El usuario debe poder:

- introducir información en la agenda
- consultar información de la agenda

Como modelo te dan una agenda física de papel.

### 3.4.2. Identificación inicial de posibles objetos

Si miras una agenda de papel, puedes ver muchas cosas que podrían ser objetos:

- portada
- páginas
- nombre
- teléfono particular
- teléfono del trabajo
- correo electrónico
- dirección
- dirección del trabajo
- cumpleaños
- compañía
- usuario
- etc.

Al principio, la lista de posibles objetos suele ser más larga de lo que necesitas.

### 3.4.3. Fase de filtrado (quedarse con lo relevante)

No todo lo que ves en la agenda física es necesario para el diseño del programa.

Por ejemplo:

- La portada y las páginas físicas no son necesarias como objetos en el programa.
- Sí necesitas algo que represente la “entrada” de la agenda: un conjunto de datos de una persona (nombre, teléfono, dirección, etc.).
- Varios tipos de teléfono (casa, trabajo, móvil) pueden ser representados por una misma clase `Telefono` con un tipo.
- Algunos datos tal vez no hacen falta porque el cliente dice que no los quiere (por ejemplo, zona horaria, número de emergencias, etc.).

Tras hablar con el cliente y analizar un poco, podrías quedarte con clases como:

- Entrada (o Contacto)
- Nombre
- Dirección
- NúmeroDeTelefono
- CorreoElectronico
- Cumpleaños
- InterfazDeUsuario

Más adelante, te das cuenta de que falta una clase que agrupe todas las entradas: `Agenda`.

### 3.4.4. Crear tarjetas CRC para cada clase

Para cada clase identificada, creas una tarjeta CRC.  
Por ejemplo:

Tarjeta de `Nombre`:

- Clase: Nombre
- Responsabilidad principal: gestionar un nombre compuesto por nombre y apellidos
- Responsabilidades:
    - almacenar nombre
    - almacenar apellidos
    - devolver el nombre completo
- Colaboraciones:
    - podría ser usada por `Entrada`

Tarjeta de `Entrada`:

- Clase: Entrada
- Responsabilidad principal: representar todos los datos de un contacto
- Responsabilidades:
    - almacenar nombre
    - almacenar dirección
    - almacenar teléfonos
    - almacenar correo electrónico
- Colaboraciones:
    - Nombre
    - Dirección
    - NúmeroDeTelefono
    - CorreoElectronico

Tarjeta de `Agenda`:

- Clase: Agenda
- Responsabilidad principal: gestionar un conjunto de entradas
- Responsabilidades:
    - añadir entrada
    - buscar entrada
    - eliminar entrada
- Colaboraciones:
    - Entrada
    - InterfazDeUsuario (según el diseño)

Tarjeta de `InterfazDeUsuario`:

- Clase: InterfazDeUsuario
- Responsabilidad principal: comunicarse con el usuario
- Responsabilidades:
    - mostrar menús
    - pedir datos
    - mostrar resultados
- Colaboraciones:
    - Agenda

### 3.4.5. Simulación de escenarios

Una vez tienes las tarjetas, se recomienda “simular” situaciones reales para comprobar si el diseño funciona.

Por ejemplo, escenario: “el usuario quiere buscar una dirección por nombre”.

Podrías seguir estos pasos:

1. `InterfazDeUsuario` pide al usuario el nombre de la persona.
2. `InterfazDeUsuario` envía ese nombre a `Agenda` para buscar.
3. `Agenda` recorre su lista de `Entrada` y compara los nombres.
4. Para comparar, necesita pedir a `Entrada` su nombre como texto.
5. `Entrada` colabora con `Nombre` para construir el nombre completo.
6. Cuando `Agenda` encuentra la entrada correcta, se la devuelve a `InterfazDeUsuario`.
7. `InterfazDeUsuario` muestra la información al usuario.

Durante esta simulación te puedes dar cuenta de:

- Si falta alguna responsabilidad en una clase.
- Si necesitas una nueva colaboración entre clases.
- Si una clase está haciendo demasiado y deberías dividirla.

Se repite este proceso con otros escenarios:

- ¿Qué pasa si el usuario quiere añadir un nuevo contacto?
- ¿Qué pasa si quiere eliminar uno?
- ¿Qué pasa si el nombre no está en la agenda?

El diseño se considera “suficientemente completo” cuando ya no aparecen responsabilidades nuevas al estudiar nuevos escenarios.

---

Con esto tienes el punto 3 del tema (Diseño de programas) explicado con calma, desde cero y con ejemplos, listo para Obsidian.

Si quieres, el siguiente paso natural sería que hagamos el **punto 4: Concepto de clase** con este mismo estilo (es muy largo e importante: modularización, ocultación de información, tipos compuestos, TAD, estructuras de datos, instanciación, métodos).

--- 

# TEMA 4: Concepto de clase

## 4. Concepto de clase

Cuando describimos un programa, de forma natural usamos:

- verbos para hablar de lo que **hace** el programa (acciones),
- sustantivos para hablar de la **información** con la que trabaja (datos).

Ejemplos:

- “El programa **calcula** las nóminas” → acción.
- “El programa usa la **edad**, el **salario**, la **retención**” → datos.

En programación:

- Las acciones se representan con **métodos** (o funciones).
- Los datos se representan con **tipos de datos** y **variables**.

En el tema 2 ya viste que los datos son la forma que tenemos de **representar información** en la memoria del ordenador.  
Esa información pertenece al **dominio del problema** (nóminas, alumnos, productos, cuentas bancarias, etc.) y se codifica con los **tipos de datos** del lenguaje.

La **clase**, en la programación orientada a objetos, es el mecanismo que permite:

- crear **nuevos tipos de datos** adaptados al problema (por ejemplo, `Cuenta`, `Persona`, `Fecha`),
- agrupar en ellos tanto datos (atributos) como acciones (métodos).

Pero para llegar a la idea de clase, el tema introduce antes varios conceptos clave: **modularización**, **ocultación de información**, **tipos compuestos** y **abstracción de datos**.

Vamos uno por uno.

---

## 4.1. Modularización

### 4.1.1. Problema: programas “monolíticos”

Cuando empiezas a programar en Java, sueles hacer cosas como:

```java
public class Hola {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
    }
}
```

O incluso algo un poco más largo, pero siempre con:

- una única clase,
- un único método interesante (`main`),
- todo el código dentro.

Esto está bien para ejercicios pequeños.  
Pero si un programa crece mucho y lo haces todo en una única clase y con muchos métodos juntos, llega un punto en que:

- es difícil de leer,
- es difícil de localizar errores,
- es difícil de modificar sin romper algo,
- es difícil de reutilizar partes en otros programas.

El PDF lo resume así:  
si la complejidad del programa crece, el número de declaraciones e instrucciones crece, y el programa se vuelve casi imposible de mantener.

La solución es **dividir el programa**.

### 4.1.2. Qué es modularización

La **modularización** es el proceso de:

> dividir el programa en partes lo suficientemente pequeñas para que sean fáciles de comprender y comprobar de forma independiente.

Esas partes se llaman **módulos**.

Un **módulo** es:

- una unidad de programa
- donde se implementa una colección de recursos (funciones, tipos, datos)
- que pueden ser utilizados por uno o varios programas.

Características importantes de un módulo (según el PDF):

1. Se compila por separado (a menudo en forma de biblioteca).
2. No es un programa completo (no suele ejecutarse por sí solo).
3. Se caracteriza por:
    - su **interfaz**: qué ofrece al exterior,
    - su **implementación**: cómo está hecho por dentro.

Un módulo no suele tener método `main`:  
es algo que otro programa **usa**.

### 4.1.3. Ejemplo conceptual de módulo

Piensa en una biblioteca de matemáticas:

- funciones trigonométricas: `sin`, `cos`, `tan`.
- funciones estadísticas: media, desviación, etc.

En muchos lenguajes, eso se implementa como un módulo o biblioteca `Math`:

- Otros programas pueden “importar” esa biblioteca.
- Sólo conocen sus funciones públicas.
- No saben (ni necesitan saber) cómo se implementan por dentro.

En Java, por ejemplo, tienes:

```java
double x = Math.sqrt(25);
```

Tú usas `Math.sqrt()` sin preocuparte de cómo está implementado.

### 4.1.4. Ejemplo en Java: sin modularización

```java
public class SistemaTienda {
    public static void main(String[] args) {
        // Registrar cliente
        System.out.println("Registrando cliente...");

        // Añadir productos
        System.out.println("Añadiendo productos al carrito...");

        // Cobrar
        System.out.println("Cobrando al cliente...");

        // Imprimir ticket
        System.out.println("Imprimiendo ticket...");
    }
}
```

Todo está junto.  
Si el programa crece (manejar múltiples clientes, stocks, informes, etc.), se convierte en un caos.

### 4.1.5. Ejemplo en Java: con modularización

```java
class Cliente {
    void registrar() {
        System.out.println("Registrando cliente...");
    }
}

class Carrito {
    void agregarProductos() {
        System.out.println("Añadiendo productos al carrito...");
    }
}

class Caja {
    void cobrar() {
        System.out.println("Cobrando al cliente...");
    }
}

class Ticket {
    void imprimir() {
        System.out.println("Imprimiendo ticket...");
    }
}

public class SistemaTienda {
    public static void main(String[] args) {
        Cliente c = new Cliente();
        Carrito carrito = new Carrito();
        Caja caja = new Caja();
        Ticket ticket = new Ticket();

        c.registrar();
        carrito.agregarProductos();
        caja.cobrar();
        ticket.imprimir();
    }
}
```

Aquí:

- cada clase es un módulo lógico con una responsabilidad clara,
- el programa principal se limita a coordinar.

En POO, las **clases** se usan precisamente como módulo:  
unidades que encapsulan datos y operaciones relacionadas.

---

## 4.2. Ocultación de información

### 4.2.1. Módulos como herramienta de abstracción

El PDF dice que:

> Los módulos actúan como herramienta de abstracción en la que la complejidad de su estructura interna se puede ocultar del resto del sistema.

Esto significa:

- Los módulos sirven para simplificar la visión del sistema.
- Cada módulo puede tener una estructura interna compleja.
- Pero esa complejidad se oculta a los demás módulos.

El objetivo es que:

- los detalles internos de un módulo **no sean visibles** ni **relevantes** para los otros.
- solo importe lo que el módulo ofrece (sus servicios).

### 4.2.2. Por qué ocultar información

El PDF plantea:

> ¿Por qué es deseable la ocultación de los detalles? ¿No debería el programador conocerlo todo?

Razones para ocultar información:

1. **Gestión de la complejidad**  
    Si intentas conocer y controlar todos los detalles de todos los módulos, el sistema se vuelve inmanejable.
    
2. **Independencia entre módulos**  
    Si la implementación de un módulo cambia, el resto del sistema no debería romperse mientras la interfaz se mantenga.
    
3. **Control del acceso**  
    Ocultar los detalles permite controlar mejor quién puede hacer qué con los datos.  
    Es una especie de “seguridad interna” del programa.
    

En resumen:  
el programador no debe “saberlo todo” del sistema a la vez, solo lo que necesita sobre cada módulo en cada momento.

### 4.2.3. Interfaz como contrato

Los módulos, según el PDF:

- están interrelacionados (colaboran).
- se proporcionan servicios unos a otros.

La única forma correcta de usar un módulo es a través de su **interfaz**:

- Conjunto de operaciones que el módulo pone a disposición de otros.
- Es una especie de “contrato”:
    - qué puedes pedirle,
    - qué hace,
    - qué te devuelve.

Los programadores de un módulo:

- no necesitan conocer detalles internos de otros módulos,
- pero sí necesitan conocer sus interfaces para poder usarlos correctamente.

### 4.2.4. Analogía del coche (muy importante en el PDF)

El PDF usa esta analogía fundamental:

Para conducir un coche:

- No necesitas saber qué pasa dentro del motor al pisar el freno.
- Necesitas saber:
    - dónde está el freno,
    - cómo se pisa,
    - qué efecto tiene (disminuir la velocidad).

Lo mismo con el volante:

- No te interesa cómo se transmite el movimiento a las ruedas.
- Te interesa que al girar a la derecha, el coche gire a la derecha.

Es decir:

- Lo que necesitas conocer es la **interfaz del coche**:
    - pedales,
    - volante,
    - palancas,
    - botones,
    - qué hace cada elemento.

Lo que no te interesa (para conducir) es la **implementación**:

- válvulas,
- tornillos,
- bujías,
- cables,
- dispositivos electrónicos internos…

En programación orientada a objetos buscamos lo mismo con las **clases**:

- La **interfaz** de la clase (métodos públicos) es el “cuadro de mandos”.
- La **implementación interna** (atributos privados, lógica interna) son los “tornillos, válvulas y cables” que no queremos exponer.

### 4.2.5. Ejemplo en Java: interfaz vs implementación

```java
class Coche {
    // Implementación interna (oculta con private)
    private int velocidad;
    private int combustible;

    // Interfaz pública: lo que otros pueden usar
    public void acelerar() {
        if (combustible > 0) {
            velocidad += 10;
            combustible--;
        }
    }

    public void frenar() {
        if (velocidad >= 10) velocidad -= 10;
        else velocidad = 0;
    }

    public void repostar(int cantidad) {
        if (cantidad > 0) combustible += cantidad;
    }

    public int getVelocidad() {
        return velocidad;
    }
}
```

Desde fuera:

```java
Coche c = new Coche();
c.repostar(20);
c.acelerar();
System.out.println(c.getVelocidad());
```

- Usas la interfaz (métodos públicos).
- No te importa cómo se actualiza internamente `velocidad` o `combustible`.

Eso es **ocultación de información** aplicada a clases.

---

## 4.3. Tipos compuestos

Este apartado es muy conceptual en el PDF. Vamos con calma.

### 4.3.1. Qué es un tipo de datos (formalmente)

Según el PDF:

> Un tipo de datos se puede utilizar para caracterizar y manipular una cierta variedad de datos.  
> Lo describimos formalmente definiendo:
> 
> 1. El conjunto de elementos que puede representar.
> 2. Las operaciones que pueden ser realizadas sobre esos elementos.

Esto significa:

- Cada tipo de datos tiene un **dominio** (conjunto de valores posibles).
- Y un conjunto de **operaciones** permitidas sobre esos valores.

Ejemplo: tipo `int` en Java.

- Conjunto de elementos: todos los enteros dentro de un cierto rango (por ejemplo, -2³¹ a 2³¹ − 1).
- Operaciones: suma, resta, multiplicación, división, módulo, comparaciones, etc.

Ejemplo: tipo `boolean`.

- Conjunto de elementos: {`true`, `false`}.
- Operaciones: `&&`, `||`, `!`, comparaciones.

### 4.3.2. Tipos simples o primitivos

El PDF dice que:

> La mayoría de los lenguajes proporcionan tipos de datos simples para la representación de información básica.

Ejemplos:

- Enteros → edad de una persona.
- Reales → cantidad de dinero en una cuenta.
- Caracteres → letras individuales.

Se llaman también:

- tipos **primitivos**,
- tipos **atómicos**,  
    porque no pueden descomponerse en partes más pequeñas dentro del lenguaje.

Ejemplos en Java:

```java
int edad = 32;
double saldo = 1500.75;
char inicial = 'J';
boolean activo = true;
```

### 4.3.3. De tipos simples a tipos compuestos

El PDF dice:

> Los lenguajes suelen proporcionar maneras de combinar tipos primitivos en otras estructuras más complejas con las que representar relaciones entre datos individuales.

Ejemplo:

- Dos enteros (`x`, `y`) para representar coordenadas en un plano cartesiano.

Sin tipo compuesto:

```java
int x = 10;
int y = 20;
```

Con tipo compuesto:

```java
class Punto {
    int x;
    int y;
}
```

Ahora `Punto` es un tipo de datos que agrupa varios valores.

Definición clave del PDF:

> A un tipo de datos que se compone de múltiples elementos se lo denomina tipo compuesto.

### 4.3.4. Tipos compuestos estructurados y no estructurados

El PDF distingue:

- Tipos compuestos **no estructurados**:
    
    - Colección de datos sin organización interna clara.
    - Ejemplo típico: un array.
    
    ```java
    int[] numeros = {3, 5, 7};
    ```
    
    Tienes varios valores, pero la única estructura es la posición.
    
- Tipos compuestos **estructurados**:
    
    - Colección de componentes organizados, donde la organización determina cómo se accede a componentes individuales o subconjuntos.
    - Ejemplo típico: una clase.
    
    ```java
    class Persona {
        String nombre;
        int edad;
        String dni;
    }
    ```
    
    Aquí, cada campo tiene un nombre y un papel claro.
    

### 4.3.5. Mecanismos de Java para tipos compuestos

El PDF lista:

> Los mecanismos que Java proporciona para la construcción de tipos compuestos son:
> 
> - las clases,
> - los vectores (arrays),
> - las interfaces.

En este tema, se centrará sobre todo en **las clases**.

### 4.3.6. Visión de bits vs visión humana

El PDF remata este apartado con una idea importante:

> En esencia, cualquier dato que es procesado por el ordenador, sea primitivo o compuesto, es solo un conjunto de bits.

Para la máquina:

- Todo es una secuencia de zeros y unos.
- No sabe que algo es “edad” o “precio”.

Para nosotros, los humanos:

- Pensamos en conceptos: números, cadenas, fechas, personas.
- Queremos que los programas se escriban en esos términos, no en bits.

Para **separar** la visión de la máquina (bits) de la visión humana (conceptos), usamos la **abstracción de datos**, que se explica en el siguiente apartado.

---

## 4.4. Abstracción de datos

### 4.4.1. Idea general

El PDF dice:

> La mayor parte de la gente se siente más a gusto con las cosas que percibe como reales que con aquellas con las que piensa en abstracto.

Sin embargo, incluso un número entero es ya una abstracción.

El mismo número entero puede representarse de formas distintas en distintas máquinas:

- BCD (Binary Coded Decimal).
- Binario con signo y magnitud.
- Complemento a dos.

Aunque esos nombres quizá no te suenen todavía, lo importante es:

- Son distintos mecanismos físicos de representar números en binario.
- Todos representan el mismo concepto: entero.

Como programador en Java:

- No necesitas saber cómo representa el entero la máquina.
- Solo necesitas saber:
    - cómo declarar un `int`,
    - qué operaciones tienes (`+`, `-`, `*`, `/`, `%`, comparaciones),
    - qué rango aproximado maneja.

El lenguaje (Java) **oculta** los detalles de implementación y te da una vista lógica del tipo.

Eso es lo que llamamos **abstracción de datos**.

Definición que da el PDF:

> Si tenemos en cuenta que una abstracción es la simplificación de algo en la que solo se consideran los aspectos más relevantes,  
> la abstracción de datos es la separación de las propiedades lógicas del tipo de datos de su implementación.

En otras palabras:

- “Propiedades lógicas”:
    - Qué valores puede tomar el tipo.
    - Qué operaciones puedes hacer con él.
- “Implementación”:
    - Cómo se codifica internamente (en bits).
    - Qué estructuras usa por debajo.

Tú trabajas con lo primero.  
El lenguaje se encarga de lo segundo.

---

### 4.4.1. Encapsulación de datos

Aunque en el PDF esta sub-sección sigue a continuación (no está completa en lo que has pegado, pero sabemos la idea), la encapsulación se entiende así:

- El lenguaje (Java) “encapsula” los datos, igual que una cápsula de medicación “envuelve” un medicamento.

La analogía del PDF:

> Podemos imaginar las cápsulas en las que vienen los medicamentos:  
> no conocemos su composición química y no necesitamos conocerla.

Aplicado a datos:

- No conocemos los detalles exactos de cómo se representa un `int`, un `double` o un objeto en memoria.
- No necesitamos conocerlos para usarlos.

Al nivel de clases:

- Encapsular datos significa hacer que los atributos internos no sean accesibles directamente desde fuera (usar `private`)
- y proporcionar métodos públicos para trabajar con ellos.

Ejemplo:

```java
class Termometro {
    private double temperatura; // detalle interno

    public void setTemperatura(double t) {
        if (t >= -273.15) {    // control lógico
            temperatura = t;
        }
    }

    public double getTemperatura() {
        return temperatura;
    }
}
```

Aquí:

- La representación interna (un `double`) está oculta.
- El usuario de `Termometro` tiene una interfaz limpia: `setTemperatura`, `getTemperatura`.
- El objeto se asegura de no tomar valores imposibles (por debajo del cero absoluto).

Esta encapsulación es la forma práctica de implementar la abstracción de datos en objetos.


---

### 4.4.2. Tipo Abstracto de Datos (TAD)

**Explicación completa, profunda y derivada del PDF**

En el apartado anterior vimos que la **abstracción de datos** consiste en separar:

- la **visión lógica** de un tipo de datos (qué es, qué operaciones tiene),
- de su **implementación interna** (cómo se representa en memoria).

Un **Tipo Abstracto de Datos (TAD)** lleva esta idea al máximo nivel.

#### Qué es un TAD

Un TAD es una descripción **matemática y lógica** de un tipo de datos.  
Define:

1. **El dominio**  
    El conjunto de valores que puede tomar.  
    Ejemplo:
    
    - Para un TAD “Pila”, el dominio son todas las secuencias posibles de elementos.
    - Para un TAD “Fecha”, el dominio son todas las fechas válidas.
2. **Las operaciones**  
    Qué se puede hacer con esos valores.  
    Ejemplo:
    
    - En una pila: `push`, `pop`, `peek`, `estaVacia`.
    - En una fecha: `sumarDias`, `esBisiesto`, `comparar`.
3. **Las propiedades lógicas**  
    Reglas que deben cumplirse.  
    Ejemplo:
    
    - En una pila, `pop` siempre devuelve el último elemento insertado.
    - En una fecha, `1/1/2025` es anterior a `2/1/2025`.

Lo importante es que un TAD **no dice nada** sobre cómo se implementa:

- No dice si se usa un array, una lista, un árbol o una tabla hash.
- No dice cómo se guardan los datos en memoria.
- No dice si las operaciones son rápidas o lentas.

Un TAD es **puro comportamiento**, sin implementación.

#### Ejemplo: TAD Pila (Stack)

Dominio:  
Todas las secuencias de elementos, incluyendo la secuencia vacía.

Operaciones:

- `push(e)` → añade un elemento al final.
- `pop()` → elimina y devuelve el último elemento.
- `peek()` → devuelve el último elemento sin eliminarlo.
- `estaVacia()` → indica si la pila está vacía.

Propiedades:

- Después de `push(e)`, `peek()` debe devolver `e`.
- Si la pila está vacía, `pop()` no debería estar permitido.

#### Implementación en Java (una posible)

```java
class Pila {
    private int[] datos = new int[100];
    private int tope = -1;

    public void push(int valor) {
        datos[++tope] = valor;
    }

    public int pop() {
        return datos[tope--];
    }

    public int peek() {
        return datos[tope];
    }

    public boolean estaVacia() {
        return tope == -1;
    }
}
```

Esto es **una implementación concreta** del TAD Pila.  
Pero podrías implementarlo con:

- una `LinkedList`,
- un `ArrayList`,
- un árbol,
- una estructura circular…

Y seguiría siendo el mismo TAD.

#### Por qué es importante el concepto de TAD

Porque permite:

- diseñar tipos de datos sin pensar en la implementación,
- cambiar la implementación sin cambiar el código que usa el tipo,
- razonar sobre el comportamiento de forma abstracta,
- crear programas más robustos y mantenibles.

En POO, las **clases** son la herramienta para implementar TADs.

---

## 4.5. Estructuras de datos

**Explicación completa y ampliada**

El PDF define estructura de datos como:

> Una colección de datos cuya organización refleja la relación que existe entre los mismos;  
> se caracteriza por las operaciones que se utilizan para almacenar y acceder a la información.

Vamos a desglosarlo.

### 4.5.1. Qué es una estructura de datos

Una estructura de datos es:

- una forma concreta de organizar datos en memoria,
- que permite realizar ciertas operaciones de manera eficiente.

Ejemplos:

- Array
- Lista enlazada
- Pila
- Cola
- Árbol
- Tabla hash
- Grafo

Cada estructura tiene:

- una **organización interna**,
- un conjunto de **operaciones típicas**,
- ventajas e inconvenientes.

### 4.5.2. Ejemplo: representar un punto en el plano

El PDF menciona que un punto puede representarse de varias formas:

### Coordenadas cartesianas

```java
class Punto {
    double x;
    double y;
}
```

### Coordenadas polares

```java
class PuntoPolar {
    double radio;
    double angulo;
}
```

Ambas representan el mismo concepto (un punto),  
pero la estructura interna es distinta.

Según lo que quieras hacer:

- Si vas a sumar vectores, las cartesianas son más cómodas.
- Si vas a rotar puntos, las polares son más naturales.

### 4.5.3. Estructuras de datos y abstracción

El PDF insiste en que:

- La estructura de datos es la **implementación concreta**.
- El TAD es la **descripción lógica**.

Ejemplo:

- TAD “Lista”: secuencia de elementos con operaciones `insertar`, `borrar`, `buscar`.
- Estructura de datos:
    - lista enlazada,
    - array dinámico,
    - árbol equilibrado.

El usuario del TAD no necesita saber qué estructura se usa.

### 4.5.4. Java y las estructuras de datos

Java proporciona muchas estructuras listas para usar:

- `ArrayList`
- `LinkedList`
- `HashMap`
- `HashSet`
- `TreeMap`
- `Stack`
- `Queue`

Ejemplo:

```java
ArrayList<String> nombres = new ArrayList<>();
nombres.add("Ana");
nombres.add("Luis");
nombres.add("José");
```

Pero también puedes crear tus propias estructuras usando clases.

---

## 4.6. Instanciación

**Explicación completa y ampliada**

Este apartado es muy importante en el PDF.

### 4.6.1. De las clases a los objetos

En el diseño orientado a objetos:

- Una **clase** es un concepto, un plano, un molde.
- Un **objeto** es una instancia concreta de esa clase.

El PDF dice:

> Una clase es una plantilla que define la forma de un tipo de objetos: especifica atributos y comportamiento.

Ejemplo:

```java
class Pelota {
    String color;
    double peso;

    void botar() {
        System.out.println("La pelota está botando.");
    }
}
```

La clase `Pelota` define:

- qué datos tiene una pelota,
- qué puede hacer una pelota.

Pero no es una pelota real.

### 4.6.2. Qué es instanciar

Instanciar es **crear un objeto real** a partir de la clase.

```java
Pelota p1 = new Pelota();
Pelota p2 = new Pelota();
```

- `p1` y `p2` son objetos distintos.
- Cada uno tiene su propio estado.

```java
p1.color = "rojo";
p2.color = "azul";
```

### 4.6.3. Parte estática vs parte dinámica

El PDF explica una distinción fundamental:

#### Parte estática

- Las clases.
- Existen antes de ejecutar el programa.
- Definen la estructura y el comportamiento.
- Son fijas mientras no cambies el código.

#### Parte dinámica

- Los objetos.
- Se crean y destruyen durante la ejecución.
- Interactúan entre sí.
- Representan el estado real del programa en cada momento.

Ejemplo:

- Clase `Coche` → parte estática.
- Objetos `miCoche`, `tuCoche`, `cocheDeEmpresa` → parte dinámica.

### 4.6.4. Cuántos objetos puede haber

El PDF dice:

> Para cada clase en el programa, en un instante dado puede haber cero o más objetos de esa clase.

Ejemplos:

- Clase `Persona`: puede haber 0, 1, 100 o 1 millón de personas.
- Clase `Banco`: puede haber solo 1 banco en el programa.
- Clase `Ventana`: puede haber varias ventanas abiertas.

### 4.6.5. Cómo se crean y destruyen objetos en Java

#### Creación

Siempre con `new`:

```java
Persona p = new Persona();
```

#### Destrucción

Java tiene **recolector de basura** (garbage collector):

- Libera automáticamente los objetos que ya no son accesibles.
- No tienes que liberar memoria manualmente.
- No existe destructor como en C++.

El PDF menciona `finalize()`, pero hoy en día está obsoleto.

---

## 4.7. Métodos

**Explicación completa y ampliada**

El PDF clasifica los métodos según su función.

### 4.7.1. Constructor

Es un método especial que:

- tiene el mismo nombre que la clase,
- no tiene tipo de retorno,
- se ejecuta al crear un objeto.

Ejemplo:

```java
class Punto {
    int x, y;

    public Punto(int xInicial, int yInicial) {
        x = xInicial;
        y = yInicial;
    }
}
```

Uso:

```java
Punto a = new Punto(3, 5);

Punto b = new Punto (2,3);


```

Si no defines ningún constructor, Java crea uno por defecto.

### 4.7.2. Métodos transformadores (Transformer, mutator o setter )

Cambian el estado del objeto.

Ejemplo:

```java
class Cuenta {
    private double saldo;

    public void ingresar(double cantidad) {
        saldo += cantidad;
    }
}
```

### 4.7.3. Métodos observadores (observer, accessor, selector o getter )

Permiten consultar el estado sin modificarlo.

Ejemplo:

```java
public double getSaldo() {
    return saldo;
}
```

### 4.7.4. Métodos auxiliares

Son métodos internos que ayudan a implementar otros métodos.  
Suelen ser `private`.

Ejemplo:

```java
private boolean esValido(double cantidad) {
    return cantidad > 0;
}
```

### 4.7.5. Alias y paso de parámetros

El PDF explica algo muy importante:

- En Java, los parámetros se pasan **por valor**.
- Pero cuando pasas un objeto, lo que se copia es la **referencia**.

Ejemplo:

```java
void modificar(Cuenta c) {
    c.ingresar(100); // modifica el objeto real
}
```

Si haces:

```java
Cuenta c1 = new Cuenta();
Cuenta c2 = c1; // alias
```

Ambas variables apuntan al mismo objeto.

### 4.7.6. Recolector de basura

El PDF explica que:

- Java gestiona la memoria automáticamente.
- Cuando un objeto ya no es accesible, el GC lo elimina.
- No hay destructores manuales.
- `finalize()` existía pero no se garantiza su ejecución.

---

# TEMA 5. Construcción de clases en Java

Hasta ahora, en los ejercicios que has realizado durante el curso, todos tus programas consistían en **una única clase**, normalmente con un método `main`.  
Desde el punto de vista del lenguaje Java, eso es correcto: un archivo `.java` contiene una clase.  
Pero desde el punto de vista de la **programación orientada a objetos**, esas clases no eran “clases completas”, porque no tenían atributos, ni métodos propios, ni representaban entidades del mundo real.

También has utilizado muchas clases ya definidas por Java (`String`, `Scanner`, `Math`, etc.).  
Ahora que ya entiendes qué es realmente una clase y qué es un objeto, ha llegado el momento de **definir tus propias clases**, con atributos, métodos y constructores.

Para definir una clase en Java debes tener en cuenta varios aspectos fundamentales:

- La definición e implementación de una clase se realiza en el **mismo archivo**.
- Un archivo puede contener **más de una clase**, pero solo una puede ser la principal.
- El archivo debe llamarse igual que la clase principal (con extensión `.java`).
- La palabra clave `class` es la que permite definir una clase.
- Dentro de la clase deben aparecer sus **atributos** y sus **métodos**.

A continuación veremos cómo se construye una clase en Java desde cero.

---

## 5.1. El cuerpo de la clase

El cuerpo de una clase contiene:

- los **atributos** (estado),
- los **métodos** (comportamiento),
- los **constructores** (inicialización).

### 5.1.1. Declaración de atributos

Declarar un atributo es igual que declarar una variable normal, pero dentro de la clase.

Formato general:

```
modificador tipo nombreAtributo;
```

Ejemplos:

```java
private int edad;
public String nombre;
```

Si varios atributos tienen el mismo tipo y los mismos modificadores, pueden declararse juntos:

```java
private int x, y;
```

Aunque por claridad suele preferirse:

```java
private int x;
private int y;
```

### 5.1.2. Modificadores de atributos

Los atributos pueden llevar modificadores que indican características importantes:

- `private` → solo accesible dentro de la clase.
- `public` → accesible desde fuera.
- `protected` → accesible desde subclases.
- `static` → atributo compartido por todas las instancias.
- `final` → atributo constante.

Ejemplo:

```java
private static int contadorObjetos;
```

---

## 5.2. Métodos de una clase

Los métodos se ubican dentro del cuerpo de la clase.  
Cada método tiene dos partes:

1. **Encabezado del método** → declara el método.
2. **Cuerpo del método** → implementa lo que hace.

---

## 5.2.1. Encabezado de método

El encabezado del método está formado por:

1. **Modificadores del método**  
    Ejemplos: `public`, `private`, `static`.
    
2. **Tipo de dato devuelto**
    
    - Si no devuelve nada, se usa `void`.
    - Omitirlo es un error de sintaxis.
3. **Nombre del método**
    
    - Debe empezar por minúscula (convención Java).
    - Debe ser descriptivo.
4. **Parámetros del método**
    
    - Entre paréntesis.
    - Cada parámetro tiene tipo y nombre.
    - No se pueden agrupar parámetros del mismo tipo como en variables.

Ejemplo correcto:

```java
public void mover(int dx, int dy)
```

Ejemplo incorrecto:

```java
public void mover(int dx, dy) // error
```

### 5.2.1.1. Reglas de ámbito (scope)

El PDF explica algo fundamental:

- Una variable es visible desde el punto donde se declara hasta el final del bloque `{ }` donde está.
- Si dentro de un bloque interno declaras otra variable con el mismo nombre, **oculta** a la externa.

Ejemplo:

```java
int x = 5;

{
    int x = 10; // oculta a la x externa
    System.out.println(x); // imprime 10
}

System.out.println(x); // imprime 5
```

Los **parámetros de un método** se consideran variables declaradas dentro del bloque del método, por lo que:

- si un atributo tiene el mismo nombre que un parámetro, el parámetro lo oculta,
- para acceder al atributo se usa `this`.

Ejemplo:

```java
class Persona {
    private String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre; // this.nombre = atributo, nombre = parámetro
    }
}
```

---

## 5.2.2. Parámetros y argumentos

El PDF distingue:

- **parámetro formal** → el nombre que aparece en la declaración del método,
- **parámetro actual o argumento** → el valor que se pasa cuando se llama al método.

Ejemplo:

```java
void saludar(String mensaje) { // mensaje = parámetro formal
    System.out.println(mensaje);
}

saludar("Hola"); // "Hola" = argumento
```

Reglas importantes:

- El número de argumentos debe coincidir con el número de parámetros.
- El tipo de cada argumento debe ser compatible con el tipo del parámetro.
- El orden debe coincidir.

Si no, es error de sintaxis.

---

### 5.2.2.1. Tipos lógicos de parámetros

Aunque Java no distingue formalmente entre tipos de parámetros, el PDF explica que conceptualmente existen:

- **parámetros de entrada** → solo proporcionan datos al método,
- **parámetros de salida** → el método devuelve datos a través de ellos (no existen en Java),
- **parámetros de entrada-salida** → sirven para ambas cosas (tampoco existen en Java).

Esto es útil para entender cómo se usan los parámetros, aunque Java no lo implemente directamente.

---

### 5.2.2.2. Paso por valor y paso por referencia

El PDF explica la diferencia general entre lenguajes:

- **Paso por valor:** se copia el valor del argumento.
- **Paso por referencia:** se pasa un alias del argumento.

#### En Java:

**Java SIEMPRE pasa los parámetros por valor.**

Pero hay un matiz crucial:

- Si pasas un **primitivo**, se copia su valor.
- Si pasas un **objeto**, se copia la referencia, y por tanto el método puede modificar el objeto original.

Ejemplo con primitivo:

```java
void cambiar(int x) {
    x = 10;
}

int a = 5;
cambiar(a);
// a sigue valiendo 5
```

Ejemplo con objeto:

```java
void ingresar(Cuenta c) {
    c.ingresar(100);
}

Cuenta miCuenta = new Cuenta(0);
ingresar(miCuenta);
// miCuenta ahora tiene saldo 100
```

Aquí:

- La referencia al objeto se copia,
- pero ambas referencias apuntan al mismo objeto,
- por eso el método puede modificarlo.

---

## 5.2.3. Cuerpo del método

El cuerpo del método es un bloque `{ }` que contiene las instrucciones que implementan la acción del método.

Ejemplo:

```java
public void mover(int dx, int dy) {
    x = x + dx;
    y = y + dy;
}
```

Dentro del cuerpo puedes:

- declarar variables locales,
- usar estructuras de control (`if`, `while`, `for`),
- llamar a otros métodos,
- modificar atributos,
- devolver valores (si el método no es `void`).

---

## 5.3. Sobrecarga

La **sobrecarga** consiste en definir varios métodos con el mismo nombre pero distinta lista de parámetros.

Ejemplo:

```java
public void mover(int dx, int dy)
public void mover(float angulo, float distancia)
```

Ambos métodos se llaman `mover`, pero Java los distingue por:

- número de parámetros,
- tipo de parámetros,
- orden de parámetros.

La sobrecarga también se aplica a los constructores.

---

## 5.4. Métodos que devuelven un valor

Un método puede devolver un valor usando `return`.

Formato general:

```java
tipo nombreMetodo(parámetros) {
    return valor;
}
```

Ejemplo:

```java
public int sumar(int a, int b) {
    return a + b;
}
```

Reglas importantes:

- El tipo del valor devuelto debe coincidir con el tipo declarado.
- Un método que no devuelve nada debe declararse `void`.
- Un método no `void` debe tener al menos un `return`.

---

## 5.5. Control de acceso en Java

Java proporciona varios niveles de acceso para controlar la visibilidad de clases, atributos y métodos.

### 5.5.1. Modificadores de acceso

- `public` → accesible desde cualquier clase.
- `private` → accesible solo dentro de la clase.
- `protected` → accesible en la clase, subclases y paquete.
- (sin modificador) → accesible solo dentro del paquete.

Ejemplo:

```java
public class Persona {
    private String nombre;   // solo accesible dentro de Persona
    public int edad;         // accesible desde fuera
}
```

### 5.5.2. Encapsulación

La encapsulación consiste en:

- hacer los atributos privados,
- proporcionar métodos públicos para acceder a ellos.

Ejemplo:

```java
class Cuenta {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) saldo += cantidad;
    }
}
```

Esto protege el estado interno del objeto.

---
# TEMA 6. Objetos o instancias de una clase


Hasta ahora has aprendido a **definir una clase**:  
qué son los atributos, qué son los métodos, cómo se declaran, cómo se organizan dentro del archivo `.java`.

Pero una clase, por sí sola, **no es un objeto**.  
Una clase es solo un **molde**, un **plano**, una **plantilla**.

Para que exista algo real en memoria, necesitamos **instanciar** la clase, es decir, **crear un objeto**.

---

## 6.0. ¿Qué significa instanciar un objeto?

_(Explicación completa del PDF)_

El PDF dice:

> “Instanciar un objeto es reservar espacio en memoria para los miembros del objeto, es decir, para sus atributos y su comportamiento.”

Vamos a explicarlo desde cero.

### 6.0.1. Declarar una referencia NO crea un objeto

Cuando escribes:

```java
Trabajador unTrabajador;
```

No estás creando un objeto.  
Solo estás creando una **variable que puede apuntar a un objeto**.

Es como tener un mando a distancia sin televisor.  
El mando existe, pero no controla nada todavía.

### 6.0.2. Crear el objeto: usar `new`

Para crear un objeto real, el PDF dice que se usa:

```java
unTrabajador = new Trabajador();
```

Esto hace tres cosas:

1. **Reserva memoria** para un objeto de tipo `Trabajador`.
2. **Ejecuta el constructor** `Trabajador()`.
3. **Devuelve una referencia** al objeto recién creado.

Esa referencia se guarda en `unTrabajador`.

### 6.0.3. Forma abreviada

El PDF dice que puedes hacerlo en una sola línea:

```java
Trabajador unTrabajador = new Trabajador();
```

Esta es la forma más habitual.

---

### 6.0.4. Identidad de los objetos

_(Explicación completa del PDF)_

El PDF explica algo fundamental:

> “Una vez creado un objeto, éste tiene identidad propia que lo distingue de los demás.”

Esto significa:

- Aunque dos objetos tengan **los mismos atributos**,
- y los mismos valores en esos atributos,
- **siguen siendo objetos distintos**.

Ejemplo:

```java
Trabajador t1 = new Trabajador();
Trabajador t2 = new Trabajador();
```

Aunque ambos tengan:

- nombre = “Ana”
- sueldo = 1200
- antigüedad = 5

**NO son el mismo objeto**.

### 6.0.5. ¿Por qué no son el mismo objeto?

Porque cada objeto tiene un **identificador interno único**, llamado **OID** (Object ID).

El PDF lo explica así:

- Dos objetos con distinto OID pueden tener los mismos valores.
- Los valores pueden cambiar, pero el OID nunca cambia.

### 6.0.6. Ejemplo del PDF: los coches idénticos

El PDF dice:

> “Imagina dos coches exactamente iguales… siguen siendo dos coches distintos.”

Aunque tengan:

- misma marca,
- mismo modelo,
- mismo color,
- mismos accesorios…

**siguen siendo dos entidades distintas**.

---

## 6.1. Miembros de objeto y miembros de clase

_(Explicación completa del PDF)_

El PDF empieza recordando:

> “Instanciar un objeto es reservar espacio en memoria para sus atributos y su comportamiento.”

Vamos a explicarlo.

Cuando creas un objeto:

```java
Trabajador t = new Trabajador();
```

Java crea en memoria:

- una copia de **cada atributo** de la clase,
- que pertenece **solo a ese objeto**.

---

### 6.1.1. Variables de instancia

_(Explicación literal del PDF, pero entendible)_

El PDF dice:

> “A este tipo de atributos… se les conoce como variables de instancia.”

Una **variable de instancia** es:

- un atributo que pertenece **a cada objeto**,
- cada objeto tiene su propia copia,
- si cambias la copia de un objeto, no afecta a los demás.

Ejemplo:

```java
class Trabajador {
    String nombre;   // variable de instancia
    double sueldo;   // variable de instancia
}
```

Si haces:

```java
Trabajador t1 = new Trabajador();
Trabajador t2 = new Trabajador();

t1.nombre = "Ana";
t2.nombre = "Luis";
```

- `t1.nombre` es independiente de `t2.nombre`.

---

### 6.1.2. Métodos de instancia

_(Explicación completa del PDF)_

El PDF dice:

> “Los métodos que hacen uso de estas variables… reciben el nombre de métodos de instancia.”

Un **método de instancia**:

- necesita un objeto para ejecutarse,
- trabaja con las variables de instancia del objeto.

Ejemplo:

```java
void subirSueldo(double cantidad) {
    sueldo += cantidad; // sueldo es la variable de instancia del objeto actual
}
```

---

### 6.1.3. ¿Por qué necesitamos miembros de clase?

_(Ejemplo del PDF: los marcianos)_

El PDF introduce un ejemplo:

> “Si hay más de cinco marcianos en pantalla, cada marciano se vuelve valiente…”

Esto plantea un problema:

- Cada marciano necesita saber **cuántos marcianos hay en total**.
- Si usamos una **variable de instancia**, cada marciano tendría su propia copia.
- Eso es incorrecto: queremos **una sola variable compartida**.

Aquí aparece el concepto clave:

---

### 6.1.4. Variables de clase (static)

_(Explicación completa del PDF)_

El PDF dice:

> “Para crear una variable de clase haremos uso del modificador static.”

Una **variable de clase**:

- pertenece a la **clase**, no a los objetos,
- hay **una sola copia** para todos los objetos,
- todos los objetos comparten el mismo valor.

Ejemplo:

```java
class Marciano {
    static int cuentaMarcianos = 0; // variable de clase
}
```

Cada vez que creas un marciano:

```java
new Marciano();
Marciano.cuentaMarcianos++;
```

Todos los marcianos ven el mismo valor.

#### 6.1.4.1. Ventajas según el PDF

- Ahorra memoria.
- Evita inconsistencias.
- Representa información global de la clase.

---

### 6.1.5. Métodos de clase (static)

_(Explicación completa del PDF)_

El PDF dice:

> “Para definir un método de clase, también se usa static.”

Un **método de clase**:

- no necesita un objeto para ejecutarse,
- se llama usando el nombre de la clase,
- solo puede acceder a variables de clase.

Ejemplo:

```java
static void addCategoria(String nombre, double sueldo) {
    // código
}
```

---

### 6.1.6. Cómo acceder a miembros de clase

_(Explicación completa del PDF)_

El PDF muestra dos formas:

#### Forma 1: usando un objeto

```java
unTrabajador.numTrabajadores
unTrabajador.addCategoria("gerente", 200)
```

#### Forma 2 (recomendada por el PDF): usando el nombre de la clase

```java
Trabajador.numTrabajadores
Trabajador.addCategoria("gerente", 200)
```

El PDF dice que esta forma es mejor porque:

- deja claro que es un miembro de clase,
- evita confusiones,
- es más legible.

---

### 6.1.7. Reglas importantes del PDF

- Los miembros de clase pueden ser `public` o `private`.
- Los métodos de clase **no pueden acceder a variables de instancia**.
- Los métodos de instancia sí pueden acceder a todo.
- Los miembros de clase se cargan en memoria **cuando la clase se carga**, no cuando se crean objetos.

---

## 6.2. El método this()

_(Explicación completa del PDF)_

El PDF dice:

> “Cuando en una misma clase tenemos diferentes constructores…”

Esto se refiere a la **sobrecarga de constructores**.

Ejemplo:

```java
class Persona {
    Persona() { }
    Persona(String nombre) { }
}
```

A veces quieres que un constructor llame a otro para no repetir código.

Para eso sirve **this()**.

---

### 6.2.1. ¿Qué es this()?

`this()` es una llamada a **otro constructor de la misma clase**.

Ejemplo:

```java
class Persona {
    String nombre;
    int edad;

    Persona() {
        this("Sin nombre", 0); // llama al otro constructor
    }

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
```

---

### 6.2.2. Reglas del PDF sobre this()

- `this()` debe ser la **primera instrucción** del constructor.
- Solo se puede llamar a **un** constructor.
- Evita duplicar código.
- Permite centralizar la inicialización.

---


# TEMA 7. Paquetes

En los temas anteriores has aprendido a:

- definir clases,
- crear objetos,
- usar métodos,
- organizar el código dentro de una clase.

Pero a medida que un programa crece, no basta con tener muchas clases sueltas.  
Necesitamos una forma de **organizar** esas clases en grupos lógicos.

Ahí es donde entran los **paquetes**.

---

## 7.1. ¿Qué es un paquete?

Un **paquete** es un mecanismo de Java que permite **agrupar clases relacionadas** dentro de un mismo “contenedor lógico”.

Puedes imaginar un paquete como:

- una carpeta donde guardas archivos relacionados,
- un cajón donde guardas cosas de un mismo tipo,
- un módulo que agrupa clases con un propósito común.

### ¿Por qué existen los paquetes?

Porque en un programa grande:

- puedes tener cientos o miles de clases,
- necesitas evitar que dos clases tengan el mismo nombre,
- necesitas organizar el código por temas,
- necesitas controlar qué clases se pueden usar desde fuera.

Los paquetes resuelven todo esto.

---

### 7.1.1. Sintaxis básica de un paquete

El PDF dice:

> “La sintaxis de un paquete se indica al principio del archivo.”

En Java, un archivo `.java` que pertenece a un paquete debe empezar así:

```java
package nombreDelPaquete;
```

Ejemplo:

```java
package empresa.rrhh;
```

Esto significa:

- La clase pertenece al paquete `empresa.rrhh`.
- Su “dirección completa” será `empresa.rrhh.NombreDeLaClase`.

### Regla importante del PDF:

**La sentencia `package` debe ser la primera línea del archivo**, antes de cualquier `import` o definición de clase.

---

### 7.1.2. ¿Cómo se organizan los archivos en el disco?

Aunque el PDF no lo explica en detalle, lo que quiere decir es:

- Si una clase está en el paquete `empresa.rrhh`,
- entonces el archivo debe estar en una carpeta `empresa/rrhh`.

Ejemplo:

```
src/
 └── empresa/
      └── rrhh/
           └── Trabajador.java
```

Esto es obligatorio para que Java encuentre las clases.

---

### 7.1.3. ¿Cómo se usa una clase que está en un paquete?

Si quieres usar una clase que está en otro paquete, debes **importarla**:

```java
import empresa.rrhh.Trabajador;
```

O importar todo el paquete:

```java
import empresa.rrhh.*;
```

---

## 7.2. Paquetes con múltiples unidades de compilación

_(Explicación completa del PDF)_

El PDF dice:

> “Un paquete puede contener múltiples unidades de compilación.”

Esto significa:

- Un paquete puede contener **muchos archivos `.java`**,
- cada archivo puede contener **una o varias clases**,
- todas esas clases pertenecen al mismo paquete.

Ejemplo:

Paquete `empresa.rrhh` puede contener:

- `Trabajador.java`
- `Nomina.java`
- `Departamento.java`
- `Contrato.java`

Todos empiezan con:

```java
package empresa.rrhh;
```

### ¿Por qué es útil?

Porque puedes agrupar:

- todas las clases de recursos humanos,
- todas las clases de ventas,
- todas las clases de facturación,
- etc.

Esto hace que el proyecto sea más fácil de entender y mantener.

---

## 7.3. Jerarquía de paquetes

_(Explicación completa del PDF)_

El PDF dice:

> “Los paquetes pueden organizarse en jerarquías.”

Esto significa que los paquetes pueden tener **subpaquetes**, igual que las carpetas pueden tener subcarpetas.

Ejemplo:

```
empresa
empresa.rrhh
empresa.rrhh.informes
empresa.ventas
empresa.ventas.online
empresa.ventas.presencial
```

### Regla importante:

**Cada punto en el nombre del paquete representa un nivel en la jerarquía.**

Ejemplo:

```java
package empresa.ventas.online;
```

Significa:

- carpeta `empresa/`
- dentro `ventas/`
- dentro `online/`
- dentro el archivo `.java`

### ¿Por qué usar jerarquías?

Porque permiten organizar el código de forma muy clara:

- `empresa.rrhh` → recursos humanos
- `empresa.ventas` → ventas
- `empresa.ventas.online` → ventas por internet
- `empresa.ventas.presencial` → ventas en tienda física

Cada subpaquete agrupa clases más específicas.

---

## 7.4. ¿Qué ventajas aportan los paquetes?

_(El PDF no lo explica explícitamente, pero es necesario para entenderlo)_

Los paquetes permiten:

### 1. Organización lógica del código

Puedes agrupar clases relacionadas.

### 2. Evitar conflictos de nombres

Puedes tener:

- `empresa.rrhh.Trabajador`
- `empresa.construccion.Trabajador`

y no hay conflicto.

### 3. Control de acceso

Java tiene un nivel de acceso llamado **package-private** (sin modificador), que permite:

- que las clases del mismo paquete se vean entre sí,
- pero que no sean accesibles desde fuera.

### 4. Facilitar el mantenimiento

Si un proyecto crece, los paquetes permiten dividirlo en módulos manejables.

---
