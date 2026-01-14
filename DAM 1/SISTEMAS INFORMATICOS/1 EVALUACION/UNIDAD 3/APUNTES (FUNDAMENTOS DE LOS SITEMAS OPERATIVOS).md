## 📚 UNIDAD 03. FUNDAMENTOS DE SISTEMAS OPERATIVOS

### 1. INTRODUCCIÓN

Un sistema operativo (SO) es el software básico que gestiona un ordenador.

- Se encarga de controlar todos los recursos de _hardware_ (CPU, memoria, dispositivos, etc.).
    
- Oculta la complejidad del _hardware_ al usuario final, quien interactúa a través de una interfaz.
    
- Es responsable de ejecutar las aplicaciones de usuario.
    
- Actúa como un intermediario entre el _hardware_ y las aplicaciones.
    

**Diagrama de Capas del Sistema Informático**

El sistema se estructura en capas de la siguiente forma:

1. **Capa de Hardware** (interna): Compuesta por la CPU, discos, ratón, impresora, etc.
    
2. **Capa de System Software** (intermedia): Incluye el _Operating System_ (Sistema Operativo) y las _Utilities_ (Utilidades).
    
3. **Capa de Application Software** (externa): Incluye programas como _Spreadsheets_ (Hojas de cálculo), _Word processors_ (Procesadores de texto), _Databases_ (Bases de datos), _Computer Games_ (Juegos) e _Internet Browsers_ (Navegadores).
    

### 2. HISTORIA

La evolución de los sistemas operativos (SO) se resume en las siguientes fases:

- **Primeras computadoras (décadas de 1940-50):** No existían sistemas operativos. Los programadores interactuaban directamente con la máquina, modificando el _hardware_ o introduciendo instrucciones de forma manual.
    
- **Años 50:** Surge el concepto inicial de sistema operativo, con funciones muy básicas (cargar un programa, ejecutarlo y preparar el siguiente).
    
- **Años 60:** Se desarrollan los principales conceptos de los sistemas operativos modernos: multiusuario, multitarea, multiprocesador y sistemas en tiempo real. Hacia finales de esta década, aparece **Unix**.
    
- **Años 70:** Los ordenadores comienzan a popularizarse. El lenguaje C es clave, y Unix se reescribe en este lenguaje, facilitando su portabilidad y difusión.
    
- **Años 80:** Gran impulso a la usabilidad. Aparecen las primeras **interfaces gráficas** para hacer los sistemas más accesibles al usuario común.
    
- **Años 90:** Se consolidan sistemas como **Windows** y **Linux**, que dominan gran parte del mercado hasta la actualidad.
    
- **Años 2000 en adelante:** Surgen sistemas operativos adaptados a dispositivos móviles, como **Android** e **iOS**, que hoy son los más utilizados en _smartphones_ y tabletas.
    

### 3. CLASIFICACIÓN DE LOS SISTEMAS OPERATIVOS

Los sistemas operativos se clasifican en función de distintos parámetros. Un mismo sistema puede pertenecer a varias categorías a la vez.

#### 1. Según el número de usuarios simultáneos

- **Monousuario:** Solo una persona puede interactuar con el sistema en un momento dado. _Ejemplo: MS-DOS_.
    
- **Multiusuario:** Varios usuarios pueden trabajar de forma concurrente sobre el mismo sistema, compartiendo recursos mediante mecanismos de control de acceso y seguridad. _Ejemplo: Unix, Linux, Windows Server_.
    

#### 2. Según el número de procesadores soportados

- **Monoprocesador:** Diseñado para funcionar con un solo procesador. _Ejemplo: MS-DOS_.
    
- **Multiprocesador:** Puede aprovechar más de un procesador físico o núcleo.
    
    - **SMP (Multiprocesamiento Simétrico):** Todos los procesadores comparten las mismas funciones y los procesos se distribuyen equitativamente. _Ejemplo: Linux o Windows 10/11_.
        
    - **AMP (Multiprocesamiento Asimétrico):** Algunos procesadores se dedican a tareas específicas (ej. gestión del sistema).
        

#### 3. Según el número de tareas simultáneas

- **Monotarea:** Solo permite ejecutar un programa a la vez. _Ejemplo: MS-DOS_.
    
- **Multitarea:** Gestiona varias aplicaciones a la vez.
    
    - **Multitarea cooperativa:** Cada programa decide cuándo cede el control al sistema, haciéndolo menos fiable. _Ejemplo: Windows 3.x_.
        
    - **Multitarea preventiva:** El sistema operativo decide cuándo interrumpir un proceso, garantizando mejor estabilidad y seguridad. _Ejemplo: Linux, Windows NT/2000/XP en adelante, macOS_.
        
    - _Interesante:_ Un sistema monoprocesador también puede ser multitarea gracias al cambio de contexto, que hace que el usuario perciba concurrencia.
        

**Clasificación de los sistemas operativos (Tabla resumen)**

|**Sistema operativo**|**Número de usuarios**|**Número de tareas simultáneas**|**Número de procesadores soportados**|
|---|---|---|---|
|MS-DOS|Mono|Mono|Mono|
|Windows 9x, Me|Mono|Multi|Mono|
|Windows XP/Vista/7/8/10/11|Mono/Multi|Multi|Multi|
|UNIX, Linux, Windows NT, Windows Server|Multi|Multi|Multi|

### 4. SISTEMAS OPERATIVOS MÁS POPULARES

Los sistemas operativos se clasifican en:

- **Software libre:** El código fuente está disponible para ser estudiado, modificado y redistribuido.
    
- **Software privativo:** El código fuente no está disponible y su uso requiere el pago de licencias.
    

**Principales sistemas operativos:**

- **Linux:** Software libre, muy usado en servidores y supercomputadoras. Destaca por su seguridad, estabilidad y flexibilidad.
    
- **Microsoft Windows:** Software privativo, el más extendido en equipos de escritorio y portátiles.
    
- **macOS (Apple):** Software privativo, basado en BSD (familia de Unix), diseñado para computadoras Apple.
    
- **Android (Google):** Sistema operativo libre basado en Linux, orientado a dispositivos móviles. Es el sistema móvil más utilizado.
    
- **iOS (Apple):** Sistema operativo privativo para dispositivos móviles de Apple. Destaca por su estabilidad, seguridad y optimización para el _hardware_ de la compañía.
    

### 5. FUNCIONES DEL SISTEMA OPERATIVO

El sistema operativo cumple las siguientes funciones esenciales:

- **Gestión de procesos:** Decide qué procesos usan la CPU y en qué momento.
    
- **Gestión de memoria:** Organiza y controla el uso de la memoria principal, asignando espacio y evitando interferencias entre procesos.
    
- **Gestión de dispositivos de entrada/salida (E/S):** Coordina la comunicación entre el _hardware_ (teclado, disco, etc.) y las aplicaciones.
    
- **Gestión del sistema de archivos:** Organiza la información en discos y memorias mediante estructuras lógicas (archivos, directorios).
    

### 6. GESTIÓN DE PROCESOS

La gestión de procesos es un pilar fundamental del sistema operativo, especialmente en los sistemas multitarea.

#### 6.1. ¿QUÉ ES UN PROCESO?

Un proceso es un **programa en ejecución**. Para estar activo, un proceso debe:

- Cargarse en la memoria principal.
    
- Utilizar tiempo de CPU para ejecutar sus instrucciones.
    
- Requerir otros recursos, como acceso a disco o dispositivos de entrada/salida (E/S).
    

**Diferencia entre Programa y Proceso (Tabla)**

|**Concepto**|**Característica**|**Analogía**|
|---|---|---|
|**Programa**|Conjunto **estático** de instrucciones, datos y recursos almacenados en un archivo ejecutable.|La receta escrita en un libro.|
|**Proceso**|La instancia **activa** de un programa en ejecución. Consume recursos y tiempo de CPU.|El acto de cocinar siguiendo esa receta.|

#### 6.2. PROCESOS E HILOS (_THREADS_)

Dentro de un proceso puede haber uno o varios **hilos de ejecución** (_threads_).

- **Hilo:** Es la unidad básica de ejecución dentro de un proceso.
    
- Cada hilo comparte el mismo espacio de memoria y recursos del proceso.
    
- Sin embargo, cada hilo tiene su propio contador de programa y pila de ejecución.
    

**Ventajas de los hilos**

- Permiten dividir el trabajo de un proceso en subtareas que se ejecutan en paralelo o concurrente.
    
- Mejoran el rendimiento en sistemas multiprocesador.
    
- Reducen el coste de creación y de cambio de contexto respecto a los procesos.
    

_¡Atención!_ Al compartir memoria, pueden aparecer problemas como condiciones de carrera o bloqueos mutuos (_deadlocks_).

#### 6.3. ESTADOS DE LOS PROCESOS

Un proceso pasa por diferentes estados a lo largo de su ciclo de vida.

**Principales estados y transiciones:**

- **Nuevo (_New_):** El sistema operativo está creando el proceso.
    
    - El **planificador a largo plazo** decide si es **admitido** al estado Listo.
        
- **Listo (_Ready_):** El proceso tiene todos los recursos necesarios **excepto la CPU**. Espera ser seleccionado por el **planificador a corto plazo**.
    
    - **Transición (Waiting $\rightarrow$ Ready):** Cuando la operación de E/S que esperaba ha concluido.
        
- **En ejecución (_Running_):** El proceso está utilizando la CPU.
    
    - **Transición (Ready $\rightarrow$ Running):** El planificador a corto plazo escoge al proceso (_scheduler dispatch_).
        
    - **Transición (Running $\rightarrow$ Waiting):** Si el proceso necesita realizar una operación de E/S o esperar un evento.
        
    - **Transición (Running $\rightarrow$ Ready):** Si el planificador lo interrumpe (_interrupt_) para dar paso a otro proceso (multitarea preventiva).
        
    - **Transición (Running $\rightarrow$ Terminated):** Cuando el proceso finaliza todas sus operaciones (_exit_).
        
- **Esperando (_Waiting_):** El proceso está esperando el resultado de una operación de E/S o un recurso externo.
    
- **Terminado (_Terminated_):** El proceso ha concluido su ejecución y sus recursos son liberados.
    

#### 6.4. PLANIFICADOR A CORTO PLAZO

Es el componente encargado de decidir qué proceso, de la cola de Listos, obtiene la CPU en un momento dado.

**Algoritmos de planificación comunes:**

- **FIFO/FCFS** (_First Come, First Served_).
    
- **Round Robin (RR)**.
    
- **SJF** (_Shortest Job First_).
    
- **Prioridades** (fijas o dinámicas).
    

#### 6.5. ALGORITMOS DE PLANIFICACIÓN DE CPU

##### 1. FIFO (First In, First Out) o FCFS

- **Idea básica:** El primero que llega es el primero en ser atendido.
    
- **Problema:** Puede provocar tiempos de espera largos para procesos cortos (_convoy effect_).
    
![[Pasted image 20251216102457.png]]
##### 2. Shortest Remaining Time First (SRTF)

- **Idea básica:** El proceso con menor tiempo de CPU **pendiente** es el que obtiene la CPU.
    
- **Características:** Es un algoritmo **apropiativo** (_preemptive_).
    
- **Problemas:** No se puede conocer con exactitud la duración de un proceso y puede producir **inanición** (_starvation_) en procesos largos.
    
![[Pasted image 20251216102508.png]]
##### 3. Round Robin (RR)

- **Idea básica:** Cada proceso recibe la CPU por un intervalo de tiempo fijo, llamado **quantum**.
    
- **Características:** Es justo y equitativo. Es el algoritmo más usado en sistemas multitarea e interactivos.
    
![[Pasted image 20251216102516.png]]
#### 6.6. ¿CÓMO RESOLVER EJERCICIOS DE “ALGORITMOS DE PLANIFICACIÓN”?

Se recomienda:

1. **Comprender bien el algoritmo** y sus reglas.
    
2. **Construir una tabla o línea de tiempo (diagrama de Gantt)**.
    
3. **Aplicar el algoritmo paso a paso**.
    
4. **Calcular métricas de rendimiento:** Tiempo de espera, tiempo de retorno o finalización, y tiempo de respuesta.
    
5. **Prestar especial atención al algoritmo Round Robin**.
    

### 7. GESTIÓN DE MEMORIA

La gestión de memoria es fundamental en sistemas multitarea para organizar, asignar y proteger la memoria.

**Paginación y páginas de memoria:** La memoria RAM se divide en **páginas** (ej. 4 KB). Los procesos usan un **espacio de direcciones virtual** que el SO traduce a direcciones físicas.

#### 7.1. PRINCIPALES PROBLEMAS DE LA GESTIÓN DE MEMORIA

1. **Problema de protección:** Un proceso no debe acceder a la memoria de otro. El SO genera un error (_segmentation fault_) si esto ocurre.
    
2. **Problema de reubicación (_relocation_):** El SO usa la **memoria virtual** para traducir direcciones virtuales a direcciones físicas reales, permitiendo que cada proceso crea tener toda la memoria libre.
    
3. **Problema de asignación y fragmentación:** La traducción de direcciones virtuales permite que un proceso ocupe **páginas físicas dispersas**, aprovechando mejor la memoria y evitando la **fragmentación externa** (huecos dispersos).
    

#### 7.2. PROBLEMA DE POCA MEMORIA: SWAPPING

Cuando se requiere más memoria de la que físicamente existe, se utiliza la técnica de **swapping** o **intercambio**.

- El sistema utiliza un dispositivo de almacenamiento secundario (disco duro o SSD) para guardar páginas de memoria menos usadas.
    
- Si un proceso necesita una página que está en disco, el sistema operativo intercambia una página de la RAM por la página requerida.
    

**Es importante destacar:**

- Un proceso solo puede ejecutarse si está en RAM.
    
- El disco duro es un respaldo temporal (memoria virtual), pero el acceso a él es mucho más lento que a la RAM.
    

### 8. GESTIÓN DE ENTRADA / SALIDA

#### 8.1. FORMAS DE GESTIONAR LA ENTRADA Y SALIDA

1. **Entrada/Salida Programada (_Programmed I/O_):** El proceso comprueba periódicamente si la operación ha finalizado, consumiendo tiempo de CPU. Ineficiente.
    
2. **Interrupciones (_Interrupts_):** El dispositivo de E/S interrumpe a la CPU cuando finaliza la operación. El proceso no consume CPU mientras espera (pasa a estado _Waiting_).
    
3. **Acceso Directo a Memoria (DMA):** Permite que ciertos dispositivos (discos, tarjetas de red) transfieran datos **directamente a la RAM** sin pasar por la CPU en cada operación. La CPU solo interviene al inicio y al final, reduciendo su carga.
    

#### 8.2. TÉCNICAS PARA INCREMENTAR EL RENDIMIENTO DE LA E/S

- **Uso de cachés:** El SO escribe datos en una _caché_ de memoria y considera la operación terminada. El _hardware_ se encarga de grabarla físicamente después.
    
- _Ejemplo:_ Este mecanismo explica la necesidad de "expulsar con seguridad" un dispositivo USB.
    

### 9. GESTIÓN DEL SISTEMA DE ARCHIVOS

El sistema de archivos organiza y gestiona la información en un dispositivo de almacenamiento.

#### 9.1. ESTRUCTURA DE UN SISTEMA DE ARCHIVOS

- Estructura de **árbol invertido**.
    
- **Objetos:** **Archivo** (almacena información) y **Directorio** (archivo especial que contiene referencias a otros archivos o directorios).
    
- El directorio principal es la **raíz** (_root_).
    

#### 9.2. ATRIBUTOS DE UN SISTEMA DE ARCHIVOS

- **Tamaño máximo de partición**.
    
- **Tamaño máximo de archivo**.
    
- **Tamaño de clúster:** Unidad mínima de almacenamiento. Un _clúster grande_ da mejor rendimiento pero mayor desperdicio de espacio.
    

#### 9.3. ORGANIZACIÓN INTERNA

- Utiliza una **tabla de asignación** (FAT, inodos) para localizar fragmentos de archivo.
    
- _Ejemplos:_ FAT16, NTFS, ext4, etc.
    
- **Partición:** División lógica de un disco duro.
    
- **Formato (_format_):** Reorganiza la tabla del sistema de archivos, preparando el disco para usarse.
    

#### 9.4. RUTAS ABSOLUTAS Y RELATIVAS

- **Ruta absoluta:** Ruta completa que parte siempre desde el directorio raíz.
    
    - _Unix/Linux:_ Comienza con `/` (ej. `/users/admin`).
        
    - _Windows:_ Comienza con la letra de la unidad (ej. `C:\Users\Admin\Documentos`).

![[Pasted image 20251216102750.png]]
- **Ruta relativa:** Se define en función del directorio actual.
    

**Símbolos especiales en rutas relativas:**

- **.** $\rightarrow$ directorio actual.
    
- **..** $\rightarrow$ directorio padre (un nivel superior).
    
- **~** $\rightarrow$ en Unix/Linux, directorio personal del usuario.
    

#### 9.5. CARACTERÍSTICAS DE LOS SISTEMAS DE FICHEROS MÁS POPULARES

||**FAT16**|**FAT32**|**NTFS**|**ext4**|
|---|---|---|---|---|
|**Sistema operativo**|MS-DOS 6.22, Windows 9X|Windows 9X, Windows Server, Windows XP/7/10/11|Windows Server, Windows XP/7/10/11|Linux|
|**Máximo tamaño de fichero**|2 GiB|4 GiB|Tamaño limitado por el tamaño del volumen|16 GiB to 16 EiB|
|**Máximo tamaño de partición**|2 GiB|2 TiB|Tamaño limitado por el tamaño del volumen|1 EiB|

### 10. MATERIAL ADICIONAL y 11. BIBLIOGRAFÍA
