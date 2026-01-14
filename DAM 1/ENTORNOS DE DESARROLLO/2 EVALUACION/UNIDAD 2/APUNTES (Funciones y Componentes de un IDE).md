# **0. Contenidos de la Unidad**

- Componentes básicos de un IDE
    
    - Gestor de proyectos
    - Editor de código
    - Constructor de código ejecutable
    - Consola de salida
    - Depurador
- Herramientas y asistentes
    
    - Constructor gráfico de interfaz de usuario
    - Sistema de control de versiones (SVC)
    - Refactorización
    - Soporte UML
    - Ayuda en línea
    - Generador integrado de documentación
    - Asistentes (Wizards)
    - Configuración del IDE
    - Gestor de plugins
    - Mecanismos de actualización
    - Tutoriales y sistema de ayuda

---

# **1. Componentes básicos de un IDE**

El objetivo principal de un IDE es **manejar proyectos** y obtener **código ejecutable** a partir del código fuente.  
Por ello, debe incluir como mínimo los siguientes componentes:

- Gestor de proyectos
- Editor de código fuente
- Constructor de código ejecutable
- Depurador
- Consola o cliente de ejecución

---

## **1.1 Gestor de proyectos**

- Permite gestionar distintos proyectos dentro del IDE.
- Facilita la creación de proyectos de diferentes tipos (Java, Android, etc.).
- Permite abrir, cerrar, borrar, importar y exportar proyectos.
- Gestiona la ubicación de los ficheros del proyecto:
    - Archivos fuente
    - Archivos compilados
    - Recursos
- Proporciona un **explorador de proyectos** para visualizar el contenido, estructura y propiedades del proyecto.
- Organiza los ficheros en carpetas según su función (src, bin, resources, etc.).

---

## **1.2 Editor de código**

- Permite crear y modificar los archivos de texto que contienen el código fuente.
- Incluye funciones básicas: copiar, pegar, buscar, reemplazar.
- Resalta palabras reservadas mediante **coloración sintáctica**.
- Autocompleta código durante la edición (paréntesis, llaves, estructuras comunes).
- Proporciona plantillas para estructuras habituales.
- Introduce automáticamente tabulaciones y espaciado para mejorar la legibilidad.
- Permite plegar y desplegar secciones de código para facilitar la visión general.
- En algunos lenguajes permite trabajar con vista previa del resultado (**WYSIWYG**), como en interfaces Android basadas en XML.

---

## **1.3 Constructor de código ejecutable**

- Automatiza las llamadas al compilador, intérprete y montador.
- Permite construir proyectos complejos en un solo paso.
- Puede generar el **paquete ejecutable** de la aplicación, incluyendo:
    - Descripción del paquete
    - Versión
    - Dependencias
    - Información de la compañía
- Permite configurar qué componentes se generan, cuáles se excluyen y en qué plataforma se construyen.
- Facilita la creación de archivos ejecutables como JAR, APK, etc.
- Permite seleccionar configuraciones de compilación específicas.

---

## **1.4 Consola de salida**

- Permite ejecutar la aplicación dentro del propio IDE.
- Muestra la salida estándar del programa (mensajes, resultados, errores).
- Facilita probar el código de forma inmediata.
- Permite observar el comportamiento del programa sin salir del entorno de desarrollo.

---

## **1.5 Depurador**

- Herramienta utilizada para depurar programas.
- Permite ejecutar el programa paso a paso.
- Permite marcar **breakpoints** (puntos de parada) para detener la ejecución en líneas concretas.
- Permite inspeccionar valores de variables durante la ejecución.
- Facilita detectar errores lógicos y comprender el flujo del programa.
- Permite observar el estado interno del programa en tiempo real.

---

# **2. Herramientas y asistentes del IDE**

Los IDE modernos incluyen herramientas adicionales que facilitan el desarrollo y aumentan la productividad.

---

## **2.1 Constructor gráfico de interfaz de usuario**

- Permite crear y manipular componentes visuales mediante herramientas **drag-and-drop**.
- Suele incluir dos vistas:
    - Vista de diseño (gráfica)
    - Vista de código fuente
- Incluye paletas de componentes (botones, paneles, listas, etc.).
- Permite editar propiedades de los componentes desde un panel dedicado.
- Facilita la creación de interfaces sin necesidad de escribir todo el código manualmente.

---

## **2.2 Sistema de Control de Versiones (SVC)**

- Gestiona los cambios realizados en el proyecto.
- Permite almacenar distintas versiones de archivos (código, imágenes, documentación).
- Permite modificar, añadir, borrar, renombrar o mover elementos.
- Registra las acciones realizadas, permitiendo volver a estados anteriores.
- Facilita el trabajo colaborativo, permitiendo que varios usuarios trabajen simultáneamente.
- Puede integrarse con sistemas como Git, Mercurial o Subversion.

---

##v **2.3 Refactorización**

- Mejora la estructura interna del código sin alterar su comportamiento externo.
- No añade ni elimina funcionalidades.
- Limpia el código para mejorar su claridad y consistencia.
- Ejemplos:
    - Cambiar nombres de variables o métodos
    - Reorganizar código
    - Cambiar nombres de ficheros en cascada
- Facilita el mantenimiento y la legibilidad del código.

---

## **2.4 Soporte UML**

- Herramienta utilizada en las fases de análisis y diseño.
- Permite crear diagramas UML (clases, secuencia, casos de uso).
- Puede generar código a partir de diagramas o viceversa.
- Facilita visualizar la estructura del software y sus relaciones.

---

## **2.5 Ayuda en línea**

- Sistema integrado que permite consultar documentación en formato HTML.
- Puede mostrarse en un navegador interno del IDE.
- Permite acceder rápidamente a información sobre funciones, clases, métodos, etc.
- Facilita resolver dudas sin salir del entorno de desarrollo.

---

## **2.6 Generador integrado de documentación**

- Genera documentación automáticamente a partir de comentarios en el código.
- Útil para crear manuales de referencia de librerías o proyectos.
- Puede incluir:
    - Índices alfabéticos
    - Índices temáticos
    - Código fuente enlazado
- Ejemplo típico: **JavaDoc**.
- Permite documentar métodos, clases, parámetros y valores de retorno.

---

## **2.7 Asistentes (Wizards)**

- Ayudan a programar guiando procesos o generando código automáticamente.
- Facilitan tareas repetitivas o complejas.
- Ejemplos:
    - Creación de clases
    - Creación de proyectos
    - Generación de métodos o estructuras base
- Presentan pasos guiados para completar tareas.

---

## **2.8 Configuración del IDE**

- Permite personalizar el entorno según las preferencias del usuario.
- Ajustes posibles:
    - Menús
    - Barras de herramientas
    - Ventanas
    - Atajos de teclado
    - Temas de color
- Permite adaptar el IDE a distintos estilos de trabajo.
- Puede configurarse globalmente o por usuario.

---

## **2.9 Gestor de plugins**

- Permite instalar extensiones que añaden nuevas funcionalidades.
- Facilita ampliar el IDE con herramientas adicionales.
- Permite activar, desactivar o actualizar plugins.
- Mantiene el entorno adaptable a nuevas tecnologías.

---

## **2.10 Mecanismos de actualización**

- Permiten actualizar el IDE y sus componentes.
- Garantizan que el entorno esté al día con nuevas versiones, parches y mejoras.
- Pueden actualizar también plugins y herramientas integradas.

---

## **2.11 Tutoriales y sistema de ayuda**

- Muchos IDE incluyen tutoriales interactivos.
- Facilitan aprender a usar el entorno.
- Incluyen ejemplos, guías paso a paso y documentación integrada.
- Ayudan a nuevos usuarios a familiarizarse con el IDE.

---
