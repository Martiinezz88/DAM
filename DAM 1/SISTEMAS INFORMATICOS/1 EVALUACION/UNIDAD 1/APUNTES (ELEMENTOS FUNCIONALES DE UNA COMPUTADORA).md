# 📚 Elementos Funcionales de una Computadora

## 1. Evolución Histórica

### 1.1 Computadoras no-digitales

* **Ábaco (hacia 500 a.C.):** Una de las primeras herramientas para realizar cálculos aritméticos.
* **Pascalina (Siglo XVII, Blaise Pascal):** Calculadora mecánica capaz de sumar y restar automáticamente.
* **Máquina Analítica (Siglo XIX, Charles Babbage):** Considerada el primer concepto de ordenador programable.
* **Fundamentos esenciales:** Se establecieron el sistema binario (Leibniz, S. XVII), el álgebra de Boole (George Boole, S. XIX) y la máquina de Turing (Alan Turing, 1936).

### 1.2 Computadoras digitales

* El uso de la electricidad permitió construir ordenadores más rápidos, potentes y fiables.
* **Z1 (1938, Konrad Zuse)** y **ABC (1939, Atanasoff y Berry):** Pioneros en usar interruptores eléctricos para representar información (0 y 1).
* **Colossus (1943)** y **ENIAC (1946):** Usaron válvulas de vacío; eran programables, pero requerían modificar físicamente su hardware para la reprogramación.

#### 1.2.1 Computadoras de propósito general

* **EDSAC (1946):** Primer ordenador capaz de ejecutar instrucciones almacenadas internamente, permitiendo reprogramarlo con facilidad.
* **EDVAC (1949):** Primer ordenador con programas almacenados en memoria (modelo de von Neumann), marcando el nacimiento del concepto de **software** (instrucciones independientes del hardware).

#### 1.2.2 Transistores y circuitos integrados

* **Transistor (1947):** Componente electrónico más pequeño, eficiente y fiable que los tubos de vacío, supuso una revolución.
* **Circuitos Integrados (IC) (1959):** Permiten agrupar varios transistores en un único chip, clave para la creación de ordenadores más pequeños y potentes.

#### 1.2.3 Era del ordenador personal (años 70-80)

* Aparición de modelos como MITS Altair, Apple II, IBM 5100 y Mark-8.
* **IBM PC (1981):** Su diseño abierto y estándar consolidó la informática como algo accesible para el gran público.

#### 1.2.4 Internet y la conectividad (años 90-2000)

* Expansión rápida de la conexión de ordenadores personales a Internet en los 90, popularizándose universalmente en los 2000.

#### 1.2.5 Actualidad - Informática omnipresente

* La informática se integra en casi todos los aspectos de la vida diaria a través de dispositivos como teléfonos móviles, tabletas, relojes inteligentes y electrodomésticos conectados.

## 2. Definición de un sistema informático

Un sistema informático es una máquina que sirve para resolver diferentes problemas.

* **Hardware:** Componentes físicos (teclado, pantalla, procesador, disco duro).
* **Software:** Instrucciones o programas que le dicen al hardware qué hacer (juego, procesador de texto, navegador).
* **Usuario:** La persona que utiliza el sistema.
* **Datos:** La información que el sistema procesa (documentos, fotos, vídeos).

## 3. Arquitecturas de computadores

### 3.1 Arquitectura Von Neumann

Modelo teórico propuesto en 1946, base de la mayoría de ordenadores.

Elementos: 

![[licensed-image.jpg]]


1.  **CPU (Unidad Central de Proceso):** Interpreta y ejecuta instrucciones.
2.  **Memoria principal:** Almacena **datos e instrucciones** en el mismo lugar.
3.  **Buses:** Transportan información (datos, direcciones, instrucciones).
4.  **Dispositivos de entrada/salida ($E/S$):** Permiten la comunicación con el exterior (teclado, pantalla, etc.).

**Funcionamiento clave:** Tanto los datos como las instrucciones están en la misma memoria y comparten el mismo bus. Esto permite ejecutar distintos programas cambiando solo el contenido de la memoria.

### 3.2 Arquitectura Harvard

Modelo empleado en sistemas embebidos o microcontroladores.

Diferencias principales con la arquitectura de Von Neumann: 
* **Memorias separadas:** Datos e instrucciones en memorias diferentes, permitiendo leer una instrucción y un dato al mismo tiempo.
* **Buses separados:** Cada tipo (datos/instrucciones) tiene su propio bus, mejorando la velocidad y evitando conflictos.
* **Espacio de direcciones distinto:** Cada uno tiene su propio espacio de memoria independiente.

> **Atención:** La mayoría de ordenadores modernos utiliza modelos **híbridos** que combinan ventajas de ambas.

## 4. Functional elements of a computer (Elementos funcionales de una computadora)

### 4.1 CPU (Unidad Central de Proceso)

Es el núcleo del ordenador; su función es leer y ejecutar las instrucciones.

Compuesta por: 
* **Registros:** Pequeñas memorias muy rápidas que almacenan datos temporalmente.
    * Contador de programa (PC): Guarda la dirección de la siguiente instrucción.
    * Registro de dirección de memoria (MAR).
    * Registro de datos de memoria (MDR).
    * Registro de instrucción (IR).
    * Registros de propósito general.
    * Flags (banderas): Indicadores del estado de las operaciones.
* **Bus interno:** Conecta los registros, la UC y la ULA.
* **Unidad de Control (UC):** Dirige el funcionamiento, interpreta las instrucciones y genera las señales. Componentes clave: Decodificador y Reloj (clock).
* **Unidad Aritmético-Lógica (ULA):** Realiza las operaciones matemáticas y lógicas.

### 4.2 Unidad de memoria

Almacenamiento interno de instrucciones y datos.

* Formada por celdas (1 bit), organizadas en **palabras** (ej. 32 o 64 bits), cada una con una dirección única.
* Generalmente **RAM (Memoria de Acceso Aleatorio)**: es **volátil** (los datos se pierden sin energía).

**Memorias volátiles relacionadas con la CPU:**
* Registros (dentro de la CPU).
* Memoria caché (L1, L2 y L3): Memorias rápidas para datos usados frecuentemente.
* RAM: Memoria volátil de mayor tamaño y menor velocidad.

### 4.3 Otros tipos de memorias

* **ROM (Memoria de Solo Lectura):** No se borra (ej. BIOS antiguas).
* **EPROM:** Borrable mediante luz ultravioleta y reescribible.
* **EEPROM:** Borrable y reprogramable eléctricamente (ej. BIOS con actualizaciones ocasionales).
* **Memoria Flash:** Evolución de EEPROM, permite lectura/escritura simultánea (ej. USB, tecnología común para BIOS modernos/UEFI).
* **Memoria de firmware (BIOS vs UEFI):** El firmware UEFI actual usa Memoria Flash NOR (4-32 MB), soporta ejecución de código directamente desde la memoria (XIP) y funciones avanzadas.

### 4.4 $E/S$ (Entrada/Salida - Dispositivos externos)

Permiten al ordenador comunicarse con el exterior.

* **Dispositivos de entrada:** Ratón, teclado, micrófono.
* **Dispositivos de salida:** Pantalla, impresora, altavoces.
* **Combinados (Entrada y Salida):** Disco duro, pantalla táctil, tarjeta gráfica, etc.
* Todo dispositivo externo o accesorio se considera un **periférico**.

### 4.5 Buses

Conjunto de cables que conectan componentes para transferir datos, direcciones y señales de control.

* **Ancho del bus:** Bits que puede transmitir en una sola operación (ej. 32, 64).
* **Velocidad del bus:** Medida en Hercios (Hz).

**Tipos de buses según su forma física:**
* **Bus serial:** Transfiere bit a bit, a través de un único cable (ej. USB, SATA).
* **Bus paralelo:** Transfiere varios bits a la vez, usando varios cables (ej. puerto paralelo/COM).

**Tipos de buses según su ubicación:**
* **Buses internos:** Conectan componentes dentro de un mismo dispositivo (ej. dentro de la CPU).
* **Buses externos:** Conectan dispositivos diferentes (ej. CPU con memoria principal o con $E/S$).

**Buses externos en la arquitectura de Von Neumann:**
Los buses externos son los encargados de la comunicación entre la CPU, la Memoria Principal y los dispositivos de Entrada/Salida. Son fundamentales para el funcionamiento del ciclo de instrucción.

* **Bus de Control:**
    * **Función:** Transporta señales de sincronización, comandos y respuestas de estado entre los componentes.
    * **Ejemplos de señales:** Señales de lectura (READ), escritura (WRITE), interrupción, petición de acceso al bus, etc.
    * **Dirección:** Bidireccional (señales que van y vienen).
* **Bus de Direcciones:**
    * **Función:** La CPU lo utiliza para indicar la posición de memoria (o el puerto de $E/S$) con la que quiere interactuar.
    * **Dirección:** Unidireccional, siempre va de la CPU hacia la Memoria o los dispositivos $E/S$.
    * **Importancia:** Su ancho (número de líneas) determina la capacidad máxima de memoria que el sistema puede direccionar ($2^N$, donde N es el ancho).
* **Bus de Datos:**
    * **Función:** Transporta la información real que se está transfiriendo (el dato que se lee de la memoria o el dato que se escribe en ella). También transporta las instrucciones de programa.
    * **Dirección:** Bidireccional (los datos pueden ir desde la CPU a la memoria o desde la memoria a la CPU).
    * **Importancia:** Su ancho (ej. 64 bits) determina la cantidad de información que se puede transferir en un ciclo.

### 4.6 Conjunto de instrucciones

Comandos codificados que la CPU puede ejecutar para realizar distintas tareas.

Se clasifican en tres grandes grupos:
* **Operaciones aritmético-lógicas:** Cálculos matemáticos (suma, resta) y operaciones lógicas (AND, OR) sobre datos en registros o memoria.
* **Operaciones de manejo de datos y memoria:** Transferir datos entre CPU y memoria/dispositivos (instrucciones para leer/cargar y almacenar/guardar).
* **Operaciones de control de flujo:** Modifican el orden secuencial de ejecución cambiando el valor del **Contador de Programa (PC)** (saltos condicionales o incondicionales, llamadas a funciones, bucles).

## 5. Ciclo de instrucción en una CPU

Proceso básico por el que la CPU obtiene, interpreta y ejecuta cada instrucción del programa. 

Una instrucción consta de:
* **Código de operación (Opcode):** Indica a la CPU qué operación debe realizar.
* **Operandos:** Datos o direcciones sobre los cuales se realiza la operación.

**Fases detalladas del ciclo de instrucción (Fetch-Decode-Execute-Store):**
1.  **Búsqueda (Fetch):** La CPU usa el PC para acceder a la instrucción en memoria, la carga en el IR, y el PC se incrementa.
2.  **Decodificación (Decode):** La UC interpreta el *Opcode* y determina qué componentes de la CPU estarán involucrados.
3.  **Ejecución (Execute):** La CPU realiza la operación solicitada (ej. con la ALU).
4.  **Almacenamiento (Store):** El resultado se escribe en el destino (registro, memoria o dispositivo); el PC se actualiza si hay un salto.

**Importancia del Ciclo de Instrucción:**

* **Base del funcionamiento:** Es la unidad de trabajo fundamental y repetitiva de la CPU, la razón de ser del ordenador.
* **Sincronización:** Está gobernado por la señal del reloj (clock), lo que sincroniza todas las operaciones internas.
* **Rendimiento:** La velocidad a la que la CPU puede ejecutar estos ciclos (frecuencia) es lo que define su rendimiento. Un ciclo de reloj es el tiempo necesario para realizar una de las microoperaciones dentro de una fase (ej. transferir un dato de un registro a otro).

## 6. Ejemplo didáctico de un conjunto de instrucciones

**Características del ordenador ficticio:**
* Cada instrucción: 8 bits (2 bits para operación, 6 bits para direcciones de memoria).
* Memoria: $2^6=64$ direcciones.
* CPU: 3 registros temporales (R1, R2, R3).

**Conjunto de instrucciones (Ejemplo):**
| Código binario | Operación |
| :--- | :--- |
| **00** | Sumar el contenido de R1 y R2, almacenar el resultado en R3. |
| **01** | Cargar en R1 el contenido de la dirección de memoria indicada. |
| **10** | Cargar en R2 el contenido de la dirección de memoria indicada. |
| **11** | Mostrar en pantalla el contenido del registro R3. |

## 7. Diseño de CPU: RISC y CISC

### 7.1 Arquitectura RISC (Reduced Instruction Set Computer)

* **Filosofía:** Reduce la cantidad y complejidad de las instrucciones.
* **Características:**
    * Conjunto **reducido** de instrucciones simples.
    * Instrucciones de **tamaño fijo**.
    * **Separación clara** entre acceso a memoria (`load`/`store`) y procesamiento (operaciones aritméticas solo con registros internos).
* **Ventajas:** Mayor velocidad (ejecución en un solo ciclo de reloj), facilidad para implementar *pipelining* y ejecución fuera de orden.

### 7.2 Arquitectura CISC (Complex Instruction Set Computer)

* **Filosofía:** Permite ejecutar operaciones complejas con una sola instrucción.
* **Características:**
    * Conjunto **muy amplio** de instrucciones.
    * Instrucciones de **tamaño variable**.
    * **Mayor complejidad** del hardware de la CPU.
* **Ventajas:** Programas más compactos, facilita la generación de código para programadores y compiladores.

### 7.3 Comparación y evolución: RISC vs CISC

| Aspecto | RISC | CISC |
| :--- | :--- | :--- |
| **Rendimiento** | Más rápido (instrucciones en un ciclo, mayor paralelismo) | Puede generar programas más compactos |
| **Complejidad HW** | Más simple y eficiente | Más complejo internamente |

**CPUs Modernas (x86 Híbridas):**
Los procesadores modernos de escritorio (principalmente Intel y AMD) utilizan un enfoque híbrido:
1.  **CISC hacia afuera:** Mantienen el conjunto de instrucciones CISC para ser compatibles con el enorme ecosistema de **software legado** (compatibilidad binaria).
2.  **RISC interno:** Internamente, la CPU traduce las instrucciones CISC complejas en secuencias de **microinstrucciones RISC** simples (sin que el software lo note) para un procesamiento más rápido y eficiente.

> **Justificación de la compatibilidad:** Cambiar el conjunto de instrucciones de x86 a RISC directamente rompería la compatibilidad binaria, haciendo que los millones de programas existentes dejaran de funcionar. Por eso, el enfoque híbrido es la solución comercialmente viable.
