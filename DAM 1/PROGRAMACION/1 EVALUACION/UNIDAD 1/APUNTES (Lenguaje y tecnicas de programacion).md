# 📘 Apuntes – Tema 1: Lenguajes y técnicas de programación (versión para principiantes)

## 1. ¿Qué es un ordenador?

- Un **ordenador** es una máquina que puede almacenar información y seguir instrucciones para resolver problemas.
- Piensa en él como una **calculadora gigante**: puede hacer operaciones muy rápidas, pero necesita que alguien le diga exactamente qué hacer.

---

## 2. ¿Qué es programar?

- **Programar** es darle al ordenador una lista de pasos muy claros para que haga una tarea.

- Ejemplo cotidiano: **hacer un bocadillo**.
    - Paso 1: coger pan.
    - Paso 2: abrirlo.
    - Paso 3: meter jamón.
    - Paso 4: cerrar el pan.
- Eso es un **algoritmo**: una lista de pasos que llevan a un resultado.

👉 En programación, esos pasos se escriben en un **lenguaje que el ordenador entiende**.

---

## 3. Ciclo de vida de un programa

Cuando hacemos un programa, seguimos tres fases:

1. **Resolución del problema**
    
    - Entender qué queremos hacer.
    - Pensar los pasos (algoritmo).
    - Comprobar que funcionan.
2. **Implementación**
    
    - Escribir esos pasos en un lenguaje de programación.
    - Probarlo en el ordenador.
3. **Mantenimiento**
    
    - Usar el programa.
    - Corregir errores o adaptarlo si cambian las necesidades.

👉 Ejemplo: un programa que calcule notas de alumnos.

- Problema: saber si aprueban o suspenden.
- Algoritmo: sumar notas, calcular media, comparar con 5.
- Implementación: escribirlo en Java.
- Mantenimiento: cambiarlo si el sistema de notas cambia.

---

## 4. Lenguajes de programación

- El ordenador solo entiende **ceros y unos** (lenguaje máquina).
- Para los humanos es imposible trabajar así, por eso se inventaron:
    - **Lenguaje ensamblador**: usa palabras cortas como `ADD` (sumar).
    - **Lenguajes de alto nivel**: más parecidos al lenguaje humano. Ejemplo: Java.

👉 En Java escribimos cosas como:

```java
System.out.println("Hola mundo");
```

El ordenador no entiende esto directamente. Primero se traduce a un lenguaje que sí entiende.

---

## 5. Compilación e interpretación

- **Compilar**: traducir todo el programa de golpe a lenguaje máquina.
- **Interpretar**: traducirlo paso a paso mientras se ejecuta.
- **Java**: mezcla los dos.
    - Se compila a **Bytecode**.
    - La **Máquina Virtual de Java (JVM)** interpreta ese Bytecode en cualquier ordenador.  
        👉 Resultado: un programa Java funciona en cualquier ordenador que tenga JVM.

---

## 6. Paradigmas de programación

Son diferentes formas de pensar cómo resolver problemas con programas:

- **Imperativa**: dar órdenes paso a paso.
- **Funcional**: usar funciones matemáticas.
- **Lógica**: usar reglas y hechos (muy usado en inteligencia artificial).
- **Concurrente**: hacer varias tareas a la vez.
- **Orientada a objetos (POO)**: pensar en términos de objetos (ejemplo: coche, persona, animal).

👉 Ejemplo POO en Java:

```java
class Coche {
    int velocidad = 0;

    void acelerar() {
        velocidad += 10;
    }
}
```

Aquí el **coche** es un objeto con un dato (`velocidad`) y una acción (`acelerar`).

---

## 7. Tipos de instrucciones en un programa

Todo programa se construye con cuatro tipos de instrucciones:

1. **Secuencia** → pasos uno detrás de otro.

```java
int a = 5;
int b = 10;
System.out.println(a + b);
```

2. **Condición (selección)** → tomar decisiones.

```java
if (edad >= 18) {
    System.out.println("Mayor de edad");
} else {
    System.out.println("Menor de edad");
}
```

3. **Repetición (bucles)** → repetir mientras se cumpla algo.

```java
for(int i=0; i<3; i++) {
    System.out.println("Iteración " + i);
}
```

4. **Subprogramas (métodos en Java)** → agrupar pasos en bloques reutilizables.

```java
int sumar(int x, int y) {
    return x + y;
}
```

---

## 8. Técnicas para resolver problemas

Cuando no sabemos cómo empezar, podemos usar estas estrategias:

- **Hacer preguntas**: ¿qué quiero conseguir?
- **Buscar cosas familiares**: ¿se parece a algo que ya resolví?
- **Analogía**: aplicar una solución parecida.
- **Medios-fines**: dividir el problema en objetivos pequeños.
- **Divide y vencerás**: partir el problema en trozos.
- **Construcción por bloques**: juntar soluciones pequeñas.
- **Superar bloqueo mental**: empezar aunque sea con algo sencillo.

---

