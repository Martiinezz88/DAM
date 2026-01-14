# **1. Concepto y objetivo de las pruebas**

## **1.1 Necesidad de las pruebas en el desarrollo de software**

Durante el ciclo de vida del software —desde el análisis hasta la implantación— es habitual que aparezcan errores debido a:

- Definición incorrecta de los objetivos o requisitos.
- Fallos en el diseño.
- Errores cometidos durante la programación.

Por ello, las pruebas son esenciales para comprobar que el producto desarrollado:

- Es correcto.
- Cumple con las especificaciones del usuario.
- Funciona según lo esperado.

### **1.2 Qué son las pruebas de software**

Las pruebas son actividades destinadas a:

1. **Verificar** que el programa cumple los requisitos establecidos.
2. **Validar** que funciona correctamente y se ha construido de forma adecuada.

### **1.3 Objetivos principales**

- Detectar errores antes de la puesta en producción.
- Garantizar la calidad y fiabilidad del software.
- Validar que el sistema cumple las especificaciones del cliente.

---

# **2. Planificación de las pruebas**

## **2.1 Estrategias de pruebas**

Para realizar pruebas de forma adecuada se definen estrategias basadas en modelos de desarrollo.  
En este tema se sigue el **modelo en V**, donde cada fase del desarrollo tiene asociada una fase de pruebas.

## **2.2 Secuencia de pruebas según el modelo en V**

1. **Pruebas unitarias**
    
    - Se prueban unidades pequeñas de código (funciones, métodos, clases).
    - Objetivo: comprobar que cada pieza funciona de forma aislada.
2. **Pruebas de integración**
    
    - Se combinan las unidades probadas individualmente.
    - Se verifica que interactúan correctamente y que el ensamblado respeta el diseño.
3. **Pruebas de validación**
    
    - Se comprueba que el sistema cumple los requisitos definidos en el análisis.
    - Se evalúa desde la perspectiva del usuario.
4. **Pruebas de sistema**
    
    - Se verifica el funcionamiento global del software y su interacción con otros elementos del sistema.

## **2.3 Consideraciones importantes**

- El objetivo de las pruebas es **detectar errores**, no demostrar que el software está perfecto.
- Encontrar defectos se considera un **éxito**, porque permite corregirlos antes de la entrega.
- **El programador no debe probar su propio código**, ya que tenderá a repetir los mismos sesgos que tuvo al programarlo.

---


# **3. Tipos de pruebas**

## **3.1 Pruebas de caja negra (funcionales)**

### **Concepto**

Las pruebas de caja negra (Black Box Testing) evalúan la **funcionalidad del software sin conocer su estructura interna**.  
El probador no ve el código, solo trabaja con:

- Entradas del sistema
- Salidas esperadas
- Requisitos funcionales
- Casos de uso

El objetivo es comprobar que el sistema **hace lo que debe hacer**, según lo especificado.

### **Características principales**

- No se analiza el código fuente.
- Se basa en requisitos y especificaciones funcionales.
- Se centra en el comportamiento observable del sistema.
- Es útil para validar la funcionalidad desde la perspectiva del usuario.

---

### **Ejemplo: Clasificación por edad**

Una aplicación recibe una edad entre 0 y 120 y clasifica a la persona en:

- 0–12 → Niño
- 13–17 → Adolescente
- 18–64 → Adulto
- 65+ → Jubilado
- Fuera de rango → “Edad no válida”

El objetivo es diseñar pruebas que verifiquen la clasificación **sin mirar el código**.

---

### **Técnicas de pruebas de caja negra**

#### **1) Partición de equivalencia**

Consiste en dividir los datos de entrada en **clases de equivalencia**, donde todos los valores de una misma clase producen el mismo comportamiento.

Tipos de particiones:

- **Válidas** → dentro del rango permitido
- **No válidas** → fuera del rango permitido

Ventajas:

- Reduce el número de pruebas.
- Evita redundancias.
- Permite cubrir grandes rangos con pocos casos.

Ejemplo aplicado a la edad:

- Niño: 0–12
- Adolescente: 13–17
- Adulto: 18–64
- Jubilado: 65+
- No válido: <0 o >120

Cada partición debe probarse al menos una vez.

---

#### **2) Valores límite (Boundary Value Analysis)**

Los errores suelen aparecer en los bordes de los rangos válidos.  
Por eso se prueban:

- El mínimo
- El máximo
- Los valores inmediatamente anteriores y posteriores

Ejemplo para el rango 0–120:

- -1, 0, 1
- 119, 120, 121

---

### **Aplicación al ejemplo**

Para cubrir completamente el caso de la edad se seleccionan:

- Un valor representativo de cada partición
- Todos los valores límite y adyacentes

Total: **14 pruebas**.

---

### **Ejemplo adicional de caja negra**

El sistema debe enviar un correo cuando se registren ciertas transacciones:

- Pedido de venta → correo al cliente
- Despacho de mercancía → correo al cliente
- Factura emitida → correo al cliente y facturación
- Cobro registrado → correo a cuentas por cobrar y al comercial

Cada caso se prueba introduciendo la transacción y verificando la salida esperada.

---

### **Resumen de caja negra**

- Evalúa la funcionalidad sin mirar el código.
- Se basa en requisitos y casos de uso.
- Técnicas principales:
    - Partición de equivalencia
    - Valores límite
- Es esencial para validar el comportamiento del sistema desde la perspectiva del usuario.

---

## **3.2 Pruebas de caja blanca (pruebas estructurales)**

### **Concepto**

Las pruebas de caja blanca analizan la **estructura interna del código**.  
El probador conoce:

- La lógica interna
- Las condiciones
- Los bucles
- El flujo de ejecución

El objetivo es comprobar que **todas las rutas posibles del código** funcionan correctamente.

---

### **a) Creación del grafo de flujo**

Se representa el código como un **grafo dirigido**, donde:

- Cada **nodo** es un bloque de instrucciones
- Cada **arista** es un cambio de flujo

Permite visualizar:

- Ramas
- Bucles
- Decisiones
- Caminos posibles

---

### **b) Complejidad ciclomática (McCabe)**

Es una métrica que indica cuántos **caminos independientes** existen en un programa.

Fórmula:

[ V(G) = E - N + 2 ]

Donde:

- (E) = aristas
- (N) = nodos
- (V(G)) = complejidad ciclomática

Interpretación:

- Indica el **mínimo número de casos de prueba** necesarios.
- Valores altos → código complejo y difícil de mantener.

---

### **c) Caminos de prueba**

Un camino independiente es una ruta única que recorre una secuencia de nodos no cubierta por otros caminos.

Cada camino representa un flujo distinto del programa.

---

### **d) Casos de uso por cada camino**

Para cada camino identificado se diseña un caso de prueba que:

- Active ese flujo
- Ejecute las decisiones correspondientes
- Permita verificar el comportamiento interno

---

### **e) Ejecución del programa**

Se ejecutan los casos de prueba y se comparan:

- **Resultados obtenidos**
- **Resultados esperados**

Objetivo:

- Verificar que la lógica interna funciona correctamente.
- Detectar errores en condiciones, bucles o decisiones.
- Asegurar que todas las rutas están cubiertas.

---

### **Ventajas**

- Cobertura profunda del código.
- Detecta errores internos no visibles desde fuera.
- Identifica caminos muertos o inalcanzables.
- Mejora la calidad del diseño.

### **Inconvenientes**

- Requiere conocer el código fuente.
- Es más costosa en tiempo.
- No valida requisitos funcionales.
- Difícil de aplicar en sistemas grandes.

---

## **3.3 Pruebas de regresión**

### **Concepto**

Las pruebas de regresión verifican que, tras realizar cambios en el software, **las funcionalidades que antes funcionaban siguen funcionando**.

Se aplican cuando se modifica el código por:

- Corrección de errores
- Nuevas funcionalidades
- Refactorización
- Cambios en dependencias
- Ajustes en el entorno

---

### **Objetivo principal**

Asegurar que:

- No aparecen fallos nuevos
- El comportamiento previo se mantiene
- El sistema sigue siendo estable

---

### **Características**

- Se basan en **repetir pruebas ya realizadas**.
- Suelen estar **automatizadas**.
- No prueban nuevas funcionalidades, sino las existentes.
- Son esenciales en integración continua y metodologías ágiles.

---

### **Ejemplo**

Si se corrige un error en _Dinero.java_, se deben repetir:

- Pruebas relacionadas con ese cálculo
- Pruebas dependientes
- Pruebas que antes funcionaban

Si alguna falla → **fallo de regresión**.

---

### **Ventajas**

- Aumentan la confianza tras cada cambio
- Detectan errores introducidos accidentalmente
- Mantienen la estabilidad del sistema
- Ideales para automatización

### **Inconvenientes**

- Manualmente consumen mucho tiempo
- Requieren mantener pruebas actualizadas
- Crecen con el tiempo

---
Perfecto, José. Continuamos con el **Tema 3**, manteniendo tu formato exacto para Obsidian:

- **##** para apartados principales
- **###** para subapartados (3.1, 3.2, 3.3)

El **punto 3 ya está completo**, así que ahora te entrego **TODO el bloque 4**, siguiendo el mismo estilo, exhaustivo y fiel al contenido del documento.

---

# **4. Pruebas unitarias**

## **Concepto**

Las **pruebas unitarias** son pruebas que se realizan sobre la unidad más pequeña del software que puede ejecutarse de manera independiente.  
Normalmente, una unidad es:

- Una función
- Un método
- Una clase
- Un módulo pequeño

El objetivo es comprobar que **cada unidad funciona correctamente por sí sola**, antes de integrarla con otras partes del sistema.

---

## **Objetivos de las pruebas unitarias**

- Verificar que cada unidad cumple su propósito.
- Detectar errores en etapas tempranas del desarrollo.
- Facilitar la localización de fallos (si una prueba falla, el error está en esa unidad concreta).
- Asegurar que los cambios futuros no rompen el comportamiento de la unidad.
- Servir como documentación viva del código.

---

## **Características**

- Son las primeras pruebas que se realizan en el modelo en V.
- Se centran en **pequeñas porciones de código**, no en el sistema completo.
- Suelen estar **altamente automatizadas**.
- Se ejecutan con mucha frecuencia durante el desarrollo.
- Permiten probar casos extremos, valores límite y situaciones excepcionales.

---

## **Qué se prueba en una prueba unitaria**

- Entradas válidas
- Entradas no válidas
- Valores límite
- Excepciones
- Comportamiento esperado
- Efectos secundarios (si los hay)

---

## **Ventajas**

- Detectan errores muy pronto.
- Reducen el coste de corrección.
- Facilitan el mantenimiento del software.
- Mejoran la calidad del código.
- Permiten refactorizar con seguridad.
- Son rápidas de ejecutar.

---

## **Inconvenientes**

- Requieren tiempo para escribirlas.
- No detectan errores de integración entre módulos.
- Si no se mantienen, pueden quedar obsoletas.
- No sustituyen a pruebas funcionales o de sistema.

---

## **Ejemplo conceptual**

Si tienes un método:

```
int sumar(int a, int b)
```

Una prueba unitaria debe comprobar:

- sumar(2, 3) → 5
- sumar(0, 0) → 0
- sumar(-2, 5) → 3
- sumar(1000, -1000) → 0

Y también casos límite como:

- sumar(Integer.MAX_VALUE, 1) → ¿desbordamiento?

---

Perfecto, José. Aquí tienes el **punto 5 completo**, totalmente fiel al contenido del tema, ampliado donde corresponde y con **tu formato exacto para Obsidian**:

- **##** para apartados principales
- **###** para subapartados

Listo para copiar y pegar.

---

# **5. Herramientas para Java (JUnit)**

## **Concepto**

JUnit es un **framework de pruebas unitarias para Java** que permite automatizar la ejecución de pruebas, verificar resultados y detectar errores de forma rápida y repetitiva.  
Es la herramienta estándar en el ecosistema Java para implementar pruebas unitarias siguiendo buenas prácticas.

JUnit facilita:

- Crear pruebas de forma sencilla.
- Ejecutarlas automáticamente.
- Comparar resultados esperados vs. resultados obtenidos.
- Integrar las pruebas en procesos de integración continua.

---

## **Características principales**

- Es un framework **open source**.
- Permite definir pruebas mediante **anotaciones**.
- Automatiza la ejecución de múltiples pruebas.
- Proporciona **asserts** para validar resultados.
- Genera informes de ejecución.
- Se integra con herramientas como Maven, Gradle, IntelliJ, Eclipse, Jenkins, GitHub Actions…

---

## **Estructura básica de una prueba en JUnit**

Una prueba típica contiene:

1. **Preparación**
    
    - Crear objetos necesarios
    - Definir datos de entrada
2. **Ejecución**
    
    - Llamar al método que se quiere probar
3. **Verificación**
    
    - Comprobar que el resultado es el esperado mediante asserts
4. **Limpieza (opcional)**
    
    - Restaurar estados o liberar recursos

---

## **Anotaciones más importantes**

- `@Test`  
    Indica que un método es una prueba unitaria.
    
- `@BeforeEach`  
    Se ejecuta **antes de cada prueba**.  
    Útil para inicializar objetos.
    
- `@AfterEach`  
    Se ejecuta **después de cada prueba**.  
    Útil para limpiar recursos.
    
- `@BeforeAll`  
    Se ejecuta **una vez antes de todas las pruebas**.
    
- `@AfterAll`  
    Se ejecuta **una vez después de todas las pruebas**.
    
- `@Disabled`  
    Permite desactivar temporalmente una prueba.
    

---

## **Asserts más utilizados**

Los asserts permiten comprobar si el resultado obtenido coincide con el esperado.

- `assertEquals(expected, actual)`
- `assertTrue(condition)`
- `assertFalse(condition)`
- `assertNotNull(object)`
- `assertThrows(Exception.class, () -> { ... })`

Si un assert falla, la prueba se marca como **fallida**.

---

## **Ejemplo básico de prueba con JUnit**

Supongamos un método:

```
public int sumar(int a, int b) {
    return a + b;
}
```

Una prueba en JUnit sería:

```
@Test
void testSumar() {
    assertEquals(5, sumar(2, 3));
}
```

JUnit ejecuta la prueba y verifica que el resultado es correcto.

---
## **Ventajas de usar JUnit**

- Automatiza las pruebas unitarias.
- Permite ejecutar cientos de pruebas en segundos.
- Facilita la detección temprana de errores.
- Se integra con herramientas de desarrollo y CI/CD.
- Mejora la calidad del software.
- Permite refactorizar con seguridad.

---

## **Relación con las pruebas unitarias**

JUnit es la herramienta ideal para implementar las pruebas unitarias descritas en el punto 4:

- Permite probar funciones de forma aislada.
- Facilita probar valores límite, entradas válidas y no válidas.
- Automatiza la repetición de pruebas (útil para regresión).
- Ayuda a mantener un conjunto de pruebas actualizado.

---

