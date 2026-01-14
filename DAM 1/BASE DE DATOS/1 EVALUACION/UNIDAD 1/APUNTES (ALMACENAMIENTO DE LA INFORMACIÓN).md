# 📚 TEMA 0 : Introducción a las Bases de Datos

## 1. Conceptos Fundamentales

En esta sección definimos los términos clave que dan sentido a los Sistemas de Información.

| **Concepto**                    | **Definición**                                                                                                          | **Ejemplo**                                        |
| ------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------- |
| **DATO**                        | Palabras, números, ==valores que por sí solos **no tienen sentido**.== Es la información, los atributos de cada entidad | `Pérez`, `30`, `1.70`                              |
| **INFORMACIÓN**                 | Datos estructurados y contextualizados que sí **tienen sentido**.                                                       | `Pérez tiene 30 años y mide 1.70 m.`               |
| **INFORMÁTICA**                 | ==Ciencia que estudia el tratamiento **automático y racional** de la información== mediante ordenadores.                |                                                    |
| **SISTEMA DE INFORMACIÓN (SI)** | Conjunto de **datos, equipos, procedimientos y personas** que actúan sobre esos datos para obtener información.         | El SI de una empresa gestiona sus ventas y stocks. |

## 2. Un poco de historia

Antes de existir las bases de datos se trabajaba con sistemas
de ficheros.

Los sistemas de ficheros fueron la solución al informatizar el
manejo de los archivadores manuales.

## 3. Sistemas de Archivos

Este es el método tradicional y básico de administrar datos, antes de la adopción masiva de las Bases de Datos.

- **Definición:** Método en el que los datos se almacenan en **ficheros** y se accede a ellos mediante programas de aplicación desarrollados para tareas específicas.
    

| **Tipo de Fichero**                  | **Definición y Organización**                                                                                                                                                                             | **Acceso**                                                                                                                                  |
| ------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- |
| **1. Secuenciales**                  | Se leen uno a continuación del otro. No hay un orden lógico, sino temporal (el orden en que se grabaron).                                                                                                 | El acceso a un registro específico requiere leer todos los registros anteriores. ==Es la forma de acceso más lenta.==                       |
| **2. De Acceso Directo o Aleatorio** | El orden de los registros en el fichero no sigue un patrón secuencial. Su organización permite calcular la posición física o lógica de cualquier registro.                                                | ==Se puede acceder a cualquier registro de forma **directa** e inmediata== (aleatoria), sin tener que leer los datos previos.               |
| **3. Secuenciales Indexados**        | Es un tipo de organización híbrida. ==Los datos se almacenan de forma secuencial, pero se crea y mantiene un **índice**== separado que asocia el valor de una clave con la ubicación física del registro. | ==Permite tanto el acceso **directo** (a través del índice)== como el acceso **secuencial** (una vez localizado el registro por el índice). |
| **4. Indexado**                      | Término amplio que agrupa cualquier organización que utiliza índices para la localización de datos. A menudo se refiere al modelo **Secuencial Indexado** (ISAM).                                         | Permite búsquedas rápidas utilizando estructuras de índice, siendo un requisito clave para las bases de datos modernas.                     |

## 4. Sistemas de Archivos vs. Sistemas de Bases de Datos
### 1. Evolución histórica de los sistemas de información

### 🔹 Sin informatizar (años 60 – papel y bolígrafo)

- La información se guardaba en fichas físicas, como hojas dentro de carpetas también llamados ficheros. 

- Ejemplo: fichas de alumnos con nombre, dirección y notas escritas a mano

- **Problemas**:
    - Acceso lento y manual.
    - Dificultad para realizar cálculos (ej. medias).
    - Datos duplicados y riesgo de inconsistencias.
    - Muy poca seguridad y concurrencia imposible.

---

### 🔹 Primeros sistemas informatizados (años 70–80 – ficheros)

- Se usan **ficheros de texto** (`alumnos.txt`, `asignaturas.txt`).

- Cada fichero guarda información relacionada.
- Ejemplo:
    - `alumnos.txt` → DNI, nombre, dirección, fecha nacimiento.
    - `asignaturas.txt` → DNI, asignatura, nota.

- **Problemas**:
    - Redundancia (datos repetidos en varios ficheros).
    - Inconsistencias (ej. mismo alumno con datos distintos en dos ficheros).
    - Consultas complejas requieren programas específicos.
    - Cambios en la estructura implican modificar todos los ficheros.
    - Seguridad limitada al sistema operativo.

---

### 🔹 Sistemas de Bases de Datos (años 90 en adelante)

- Se introduce el **SGBD (Sistema Gestor de Bases de Datos)**.

- La información se organiza en **tablas relacionadas**.
- Ejemplo:
    - **Alumnos(DNI, Nombre, Dirección, FechaNacimiento)**
    - **Asignaturas(Código, Nombre)**
    - **Notas(DNI, CódigoAsignatura, Nota)**

- **Ventajas**:
    - Consultas rápidas con SQL.
    - Integridad y consistencia garantizadas.
    - Menor redundancia.
    - Seguridad avanzada (roles, privilegios).
    - Concurrencia mediante transacciones.
    - Flexibilidad para cambios en la estructura.

---

### 2. Comparación de modelos

| Aspecto                            | ==Sin informatizar (papel)== | ==Con ficheros==               | ==Con bases de datos==             |
| ---------------------------------- | :--------------------------- | ------------------------------ | ---------------------------------- |
| **Acceso a la información**        | Manual y lento               | Programas específicos          | Consultas SQL rápidas              |
| **Flexibilidad ante cambios**      | Reescribir fichas            | Modificar todos los ficheros   | Añadir atributos/tablas fácilmente |
| **Redundancia**                    | Muy alta                     | Alta                           | Baja                               |
| **Consistencia**                   | Difícil de mantener          | Riesgo de inconsistencias      | Garantizada por el SGBD            |
| **Integridad de datos**            | Manual                       | Depende del programador        | Automática                         |
| **Concurrencia (varios usuarios)** | No posible                   | Riesgo de lecturas incorrectas | Transacciones seguras              |
| **Seguridad**                      | Muy baja                     | Limitada                       | Control de accesos y privilegios   |

---

### 3. Aspectos clave

### 🔄 Redundancia y consistencia

- **Redundancia**: datos repetidos en varios lugares.
- **Consistencia**: cuando los datos redundantes no coinciden.

Esto es algo que las Bases de datos  logran centralizar, son aspectos lo cuales permiten lograr un mejor manejo de la información.

---

###  Integridad de datos

Ejemplos de cambios:

- Cambio de dirección de un alumno.
- Corrección de un nombre mal escrito.
- Modificación del nombre de una asignatura.
- Eliminación de una asignatura.

👉 En BD, los cambios se realizan una sola vez y se reflejan en todas las relaciones.

---

###  Concurrencia

- **Ficheros**: riesgo de que varios usuarios lean/escriban datos distintos.
- **BD**: uso de **transacciones** → asegura consistencia aunque trabajen varios usuarios a la vez.

---

### 🔒 Seguridad

- **Papel**: cualquiera con acceso físico puede ver la información.
- **Ficheros**: seguridad limitada al sistema operativo.
- **BD**: control de accesos, privilegios, roles → protección frente a accesos no autorizados.

---

### 4. Ejemplo práctico: Consulta de información

**Objetivo:** alumnos mayores de 25 años con nota media > 7 en la asignatura _Bases de Datos I_.

- **Sin informatizar**: revisar ficha por ficha y calcular manualmente.
- **Con ficheros**: programar un script que lea los ficheros y calcule.
- **Con BD**: basta una consulta SQL:

```sql
SELECT a.Nombre, AVG(n.Nota) AS Media
FROM Alumnos a
JOIN Notas n ON a.DNI = n.DNI
JOIN Asignaturas s ON n.Codigo = s.Codigo
WHERE TIMESTAMPDIFF(YEAR, a.FechaNacimiento, CURDATE()) > 25
  AND s.Nombre = 'Bases de Datos I'
GROUP BY a.Nombre
HAVING Media > 7;
```

---

###  Conclusión

- La evolución **papel → ficheros → bases de datos** responde a la necesidad de:
    - Reducir redundancia.
    - Asegurar integridad y consistencia.
    - Permitir concurrencia y seguridad.
    - Facilitar consultas complejas.
- Los **SGBD** son la solución moderna y eficiente para gestionar información en entornos multiusuario.

---

## 5. Sistemas de Bases de Datos

Un sistema de BD no es solo la colección de datos, sino toda la infraestructura que permite su gestión.

- **Definición:** Colección de datos interrelacionados y un conjunto de programas para **acceder a esos datos**.
    
- **Objetivo:** Administrar los datos eficientemente y eliminar los inconvenientes de los sistemas de archivos.
    

## 6. SGBD (Sistema Gestor de Bases de Datos)

El SGBD es el software esencial que actúa como intermediario entre el usuario/programa y los datos.

### 6.1. Definición

- **SGBD:** Es una colección de **programas** que permite a los usuarios acceder a una base de datos, manipular los datos, representarla y controlarla.
    
- **Funciones principales:**
    
    - Definición de la BD.
        
    - Construcción de la BD.
        
    - Manipulación de la BD.
        
    - Compartición de la BD.
        

### 6.2. Clasificación de los SGBD

Los gestores de bases de datos se pueden clasificar según varios criterios:

#### A. Según el Modelo de Datos (Estructura lógica)

| **Modelo**              | **Descripción**                                                                                                                        |
| ----------------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| **Jerárquico**          | Estructura de árbol (padres e hijos).                                                                                                  |
| **Red**                 | Más compleja que la jerárquica; un nodo puede tener varios padres.                                                                     |
| **Relacional**          | Basado en **tablas** (relaciones). Es el modelo dominante hasta la actualidad. Utiliza el lenguaje **SQL**.                            |
| **Orientado a Objetos** | Basado en la programación orientada a objetos (POO); los más modernos se basan en este concepto.                                       |
| **NoSQL**               | No usa el lenguaje SQL. Rompe con el modelo relacional. Diseñadas para grabar datos de manera **veloz** y atender miles de peticiones. |

> [!tip] Bases de Datos **NoSQL**
> 
> - **Uso:** Grandes servicios de Internet (Twitter, Facebook, Amazon).
>     
> - **Idea central:** Priorizar la **velocidad** y la **disponibilidad** de la base de datos.
>     
> - **Validación:** Los datos apenas necesitan validarse o relacionarse.
>     

#### B. Según el Número de Usuarios

- **Sistemas Monousuario:** Solo atienden a **un usuario** a la vez.
    
- **Sistemas Multiusuario:** Atienden a **varios usuarios** al mismo tiempo.
    

#### C. Según el Número de Sitios (Localización)

- **SGBD Centralizados:** Los datos se almacenan en **un solo ordenador**. El SGBD y la base de datos residen por completo en una sola máquina.
    
- **SGBD Distribuidos:** La base de datos y el software del gestor se encuentran **repartidos** en varios ordenadores.
    



---


# 📚 TEMA 01 : Sistemas de Información

## 1. Concepto de Información

- En cualquier actividad es necesario **tomar decisiones**.
- Para que las decisiones sean acertadas se necesita **información de calidad**.
- La buena información se obtiene mediante la **organización y tratamiento de los datos**.
- Para ello se utilizan los **Sistemas de Información (S.I.)**.

---

## 2. Definición de Sistema de Información

> Conjunto de elementos que interactúan entre sí para procesar información y distribuirla de manera adecuada en función de los objetivos de una entidad.

### 🔹 Elementos de un S.I.

- **Información**
- **Actividades** (procesos, técnicas de trabajo)
- **Objetivos de la entidad**
- **Personas**
- **Recursos** (materiales, tecnológicos, financieros)

---

## 3. Tareas básicas de un Sistema de Información

Un S.I. realiza cuatro actividades fundamentales:

1. **Entrada de información**
    
    - Obtención de datos necesarios para procesar información.
    - Tipos:
        - **Manual** → introducidos directamente por el usuario.
        - **Automática** → provienen de otros sistemas o módulos.
2. **Almacenamiento**
    
    - Capacidad de **recordar la información**.
    - Actualmente se almacena digitalmente en **archivos o ficheros**.
3. **Proceso de información**
    
    - Capacidad de realizar cálculos y operaciones preestablecidas.
    - Se puede procesar tanto datos recién introducidos como datos almacenados.
4. **Salida de información**
    
    - Generación de información procesada hacia el exterior.
    - La salida de un sistema puede ser la **entrada de otro sistema** o módulo.

---

## 4. Información digital

- La mayoría de la información hoy se trata en **formato digital**.
- Requiere **soportes de almacenamiento de gran capacidad**.
- Necesita **gestión, control, organización y administración**.
- Se utilizan los **Sistemas de Información Informáticos**.

---

## 5. Sistemas de Información Informáticos

- Son un **subconjunto** de los sistemas de información en general.
- Definición:
    
    > Sistema de equipos de telecomunicaciones interconectados que se utilizan para obtener, almacenar, manipular, administrar, mover, controlar, desplegar, intercambiar, transmitir o recibir información.  
    > Incluye tanto **programas** como **equipos físicos**.
    

### 🔹 Tipos de S.I. (visión empresarial)

- **Sistemas Transaccionales**
    
    - Automatizan procesos dentro de la organización.
    - Ejemplo: pagos, cobros, entradas, salidas.
- **Sistemas de Soporte a la Toma de Decisiones**
    
    - Ayudan en decisiones estratégicas o financieras.
    - Ejemplo: compra de materiales, proyectos financieros.
- **Sistemas Estratégicos**
    
    - Buscan ventajas competitivas mediante el uso de la tecnología.
    - Ejemplo: sistemas que diferencian a la empresa frente a la competencia.

---

## 6. Elementos de un Sistema de Información Informático

En la práctica, puede incluir:

- Bases de datos de la compañía.
- Software de gestión integral (ERP).
- Software de gestión de clientes (CRM).
- Software de gestión de la cadena de suministro (SCM).
- Infraestructura de red.
- Servidores de datos y almacenamiento.
- Servidores de aplicaciones.
- Dispositivos de seguridad.

---

## 7. Información útil

La información almacenada se considera útil cuando:

- Está agrupada en un depósito común de rápido acceso.
- Está actualizada.
- Es exacta y precisa.
- Es global y coherente.
- Está asegurada en lectura, escritura y borrado mediante mecanismos de seguridad.

👉 Para conseguirlo se necesitan **dispositivos de almacenamiento**.

---

## 8. Dispositivos de almacenamiento

- Se utilizan para guardar información de forma **permanente**.
- Se denominan **memoria secundaria** (no desaparece al apagar el ordenador).
- La información se organiza en **ficheros**.

### 🔹 Tipos según acceso

- **Secuenciales**
    
    - Información en posiciones consecutivas.
    - Para acceder a un dato hay que recorrer los anteriores.
    - Ejemplo: cinta magnética.
- **Direccionables (acceso directo)**
    
    - Espacio dividido en segmentos direccionables individualmente.
    - Ejemplo: disco duro.

---

## 9. Evolución histórica del almacenamiento digital

- **Ficheros** → primera forma de almacenamiento digital.
- **Bases de datos** → organización estructurada y relacional.
- **Otros sistemas** → XML, servicios de directorios, etc.

---

## 10. Conclusión

- Los **Sistemas de Información** son esenciales para transformar datos en información útil para la toma de decisiones.
- Los **S.I. informáticos** han revolucionado la gestión empresarial al integrar bases de datos, software y redes.
- La **información útil** debe ser precisa, coherente, segura y accesible.
- La evolución del almacenamiento muestra el paso de **ficheros → bases de datos → sistemas avanzados**, reflejando la necesidad de mayor capacidad y organización.

---

# 📚 TEMA 02 – Sistemas de Almacenamiento de Información: Ficheros

## 1. Historia

1. Las primeras aplicaciones informáticas se orientaban a tareas de oficina: gestión de pedidos, nóminas, facturación.
2. El lenguaje **COBOL** fue el más usado en banca y empresas, por su fiabilidad para trabajar con ficheros.
3. Aunque hoy los sistemas de ficheros están superados por las bases de datos, conocerlos ayuda a entender sus limitaciones y el origen de los SGBD.

💡 _Ejemplo:_ Un banco en los 70 guardaba cuentas en varios ficheros COBOL. Si un cliente cambiaba de dirección, había que modificar todos los ficheros manualmente.

---

## 2. Definición de fichero

1. Un fichero es una estructura creada por el sistema operativo para almacenar datos en forma de bits.
2. Se identifica por:
    - Nombre
    - Carpeta/directorio
    - Extensión (ej. `.txt`, `.jpg`, `.zip`)
3. Es la unidad básica de persistencia en sistemas de ficheros.

💡 _Ejemplo:_

- `clientes.txt` → texto plano con registros.
- `facturas.pdf` → documento en formato PDF.

---

## 3. Formato de los ficheros

1. Los bits deben interpretarse según un **formato** para tener sentido.
2. Un mismo conjunto de bits no tiene significado si se interpreta con otro formato.
3. Tipos habituales:
    - Texto (ASCII/Unicode).
    - Binarios (estructuras complejas con cabeceras y metadatos).

💡 _Ejemplo:_

- `.gif` → imagen animada.
- `.zip` → archivo comprimido.
- `.sql` → texto con sentencias SQL.

---

## 4. Terminología en ficheros de BD

1. **Dato:** unidad básica sin contexto. Ej: “Luis”, “942665544”.
2. **Campo:** categoría de información. Ej: Teléfono, Dirección.
3. **Registro:** conjunto de campos que describen una entidad. Ej: cliente con nombre, apellidos, dirección y teléfono.
4. **Fichero:** colección de registros relacionados. Ej: fichero de clientes.

💡 _Ejemplo práctico:_

```TEXT
Registro 1: Javier Barquín, C/ Alta 234, 918342156
Registro 2: Carmen Rodríguez, Paseo Pereda 123, 942665544
```

---

## 5. Tipos de acceso a registros

1. **Secuencial:** se leen los registros uno tras otro.
    - Ejemplo: recorrer todas las nóminas hasta encontrar la de “María”.
2. **Directo:** se accede mediante clave, sin leer los anteriores.
    - Ejemplo: buscar el precio de una pieza por su código.
3. **Indexado:** se usa una tabla de índices para localizar más rápido.
    - Ejemplo: localizar un cliente en un fichero grande gracias a un índice de DNIs.

---

## 6. Clasificación de ficheros

La clasificación de los ficheros se puede realizar desde **tres perspectivas principales**: por contenido, por utilidad y por organización. Cada una responde a una necesidad distinta y tiene ventajas y limitaciones.

### 6.1 Por contenido

1. **Ficheros de texto (ASCII/planos):**

- Guardan caracteres alfabéticos y números codificados (ej. ASCII o Unicode).
- Se pueden abrir y editar con programas sencillos como editores de texto.
- No requieren un formato complejo, aunque suelen tener extensiones que indican su uso (.ini, .conf, .sql, .c, .html).
- **Ventajas:** legibles, portables, fáciles de modificar.
- **Desventajas:** poco eficientes para datos complejos, ocupan más espacio.
- 💡 _Ejemplo:_ `clientes.sql` con sentencias SQL para crear tablas.

2. **Ficheros binarios:**

- Almacenan estructuras de datos más complejas (cabeceras, vectores, tablas).
- Necesitan un formato específico para ser interpretados correctamente.
- Extensiones típicas: `.bmp`, `.avi`, `.doc`, `.zip`.
- **Ventajas:** compactos, eficientes, permiten guardar información multimedia.
- **Desventajas:** no legibles directamente, dependen de programas específicos.
- 💡 _Ejemplo:_ `imagen.bmp` con datos de píxeles y paleta de colores.

### 6.2 Por utilidad

1. **Ficheros maestro:**

- Contienen los datos fundamentales y relativamente estables.
- Son la base sobre la que se aplican cambios o consultas.
- 💡 _Ejemplo:_ `clientes.dat` con todos los clientes activos de una empresa.

2. **Ficheros de movimientos:**

- Guardan las variaciones que afectan al maestro (altas, bajas, modificaciones).
- Se usan para actualizar el fichero maestro.
- 💡 _Ejemplo:_ `ventas.dat` con las compras realizadas en un día.

3. **Ficheros históricos:**

- Conservan datos antiguos que ya no son necesarios para el proceso diario, pero sí para auditorías o análisis.
- 💡 _Ejemplo:_ `facturas_2020.dat` con facturas de ejercicios anteriores.

### 6.3 Por organización

1. **Secuencial:**

- Los registros se graban en posiciones contiguas en el orden de entrada.
- Ideal para procesos que leen todos los registros.
- 💡 _Ejemplo:_ nóminas mensuales.

2. **Secuencial encadenada:**

- Los registros se enlazan mediante punteros que indican el siguiente o anterior registro en la secuencia lógica.
- Permite mantener un orden lógico distinto al físico.
- 💡 _Ejemplo:_ lista de clientes ordenada por apellido aunque físicamente estén grabados en otro orden.

3. **Secuencial indexada:**

- Los registros se graban secuencialmente, pero se pueden recuperar con acceso directo gracias a un fichero adicional de índices.
- 💡 _Ejemplo:_ índice de DNIs que apunta a bloques de registros en clientes.dat.

4. **Secuencial indexada-encadenada:**

- Combina punteros e índices, ofreciendo flexibilidad en búsquedas y mantenimiento.
- 💡 _Ejemplo:_ fichero de productos con índices por código y punteros para mantener orden lógico por categoría.

5. **Relativa directa:**

- La clave numérica del registro se relaciona directamente con su posición en memoria.
- 💡 _Ejemplo:_ clave 100 → posición 100 en el fichero.

6. **Relativa aleatoria (hashing):**

- La clave se transforma en un número entero mediante una función hash, que determina la posición en memoria.
- Problema: colisiones (dos claves con mismo hash) → se gestionan con zonas de overflow o listas de sinónimos.
- 💡 _Ejemplo:_ claves alfanuméricas de clientes transformadas en números para acceso rápido.

## 7. Elección del tipo de fichero

La **elección del tipo de fichero** depende de varios factores:

- El **tipo de proceso** que se va a realizar.
- La **frecuencia de acceso** a los datos.
- El **volumen de información** y su estabilidad.
- El **tipo de dispositivo de almacenamiento** (secuencial como cintas, direccionable como discos).
- La **necesidad de consultas puntuales o masivas**.
- El **coste de mantenimiento** (inserciones, borrados, actualizaciones).

---

### 7.1 Procesos típicos y tipos recomendados

1. **Procesos batch o masivos (ej. nóminas, facturación mensual):**
    
    - Se leen todos los registros cada vez.
    - **Tipo recomendado:** acceso secuencial.
    - 💡 _Ejemplo:_ calcular las nóminas de todos los empleados → se recorren todos los registros uno tras otro.
2. **Consultas puntuales (ej. stock, precios, clientes):**
    
    - Se necesita acceder rápidamente a un registro concreto.
    - **Tipo recomendado:** acceso directo o indexado.
    - 💡 _Ejemplo:_ consultar el precio de una pieza en almacén por su código → acceso directo mediante clave.
3. **Procesos mixtos (ej. informes + consultas rápidas):**
    
    - Se requieren lecturas masivas y también búsquedas puntuales.
    - **Tipo recomendado:** secuencial indexada-encadenada.
    - 💡 _Ejemplo:_ generar un informe de ventas completo y, además, consultar rápidamente las ventas de un cliente específico.

---

### 7.2 Criterios prácticos de elección

1. **Frecuencia de acceso:**
    
    - Si se accede a todos los registros → secuencial.
    - Si se accede a pocos registros concretos → directo o indexado.
2. **Tipo de dispositivo:**
    
    - Cintas magnéticas → solo permiten acceso secuencial.
    - Discos duros → permiten acceso directo e indexado.
3. **Volumen y estabilidad de datos:**
    
    - Datos estables y poco cambiantes → maestro secuencial.
    - Datos con muchas modificaciones → indexado o relativo aleatorio.
4. **Coste de mantenimiento:**
    
    - Ficheros secuenciales → fáciles de leer pero costosos de actualizar.
    - Ficheros indexados → más flexibles pero requieren mantener índices.
    - Ficheros relativos aleatorios → rápidos pero necesitan gestionar colisiones y overflow.

---

### 7.3 Ejemplos prácticos

- **Nóminas de trabajadores:**  
    Cada mes se procesan todas → acceso secuencial.
    
- **Inventario de almacén:**  
    Se consulta el stock de una pieza concreta → acceso directo.
    
- **Clientes de un banco:**  
    Se generan informes completos y también consultas rápidas por DNI → acceso indexado.
    
- **Sistema de reservas de vuelos:**  
    Se necesita acceso inmediato por número de vuelo o pasajero → acceso relativo aleatorio con función hash.
    

---

### 7.4 Conclusión del apartado

La elección del tipo de fichero no es trivial: debe balancear **eficiencia en lectura**, **facilidad de mantenimiento**, **tipo de dispositivo** y **patrón de uso de los datos**.  
Un mal diseño puede provocar accesos lentos, redundancia o dificultad para actualizar la información. Por eso, este apartado es clave para entender por qué los sistemas de ficheros fueron reemplazados por las bases de datos, que permiten consultas flexibles sin tener que decidir una organización rígida desde el inicio.

---

José, ahora el **apartado 7** está mucho más completo: incluye criterios, procesos típicos, ejemplos prácticos y una conclusión clara.

¿Quieres que haga lo mismo con los apartados 8, 9 y 10 (inconvenientes y problemas) para que también queden más desarrollados y uniformes?

## 8. Inconvenientes de los sistemas de ficheros

1. Orientados a procesos, no a datos.
2. Aplicaciones independientes → duplicación de información.
3. Nuevas necesidades → nuevos programas y ficheros.
4. Problemas respecto a ficheros y respecto a datos.

---

## 9. Problemas respecto a los ficheros

Los sistemas de almacenamiento basados en ficheros presentan una serie de **limitaciones técnicas y organizativas** que afectan directamente a la calidad y seguridad de la información. Estos problemas se centran en tres aspectos principales: **integridad semántica**, **control de autorizaciones** y **control de concurrencia**.

### 9.1 Integridad semántica

1. **Definición:**

- La integridad semántica se refiere al conjunto de reglas de validación que garantizan que los datos almacenados sean coherentes y válidos.
- Cada fichero puede tener sus propias reglas, diseñadas por los programadores de la aplicación que lo utiliza.

2. **Problema:**

- Al existir múltiples ficheros independientes, cada uno con sus propias validaciones, es difícil coordinar todas las reglas de forma uniforme.
- Esto provoca que se almacenen datos inconsistentes o contradictorios.

3. **Ejemplo:**

- En un fichero de cuentas corrientes se establece que el saldo nunca puede ser inferior a 50 €.
- Sin embargo, otro fichero que registra pagos no aplica esa regla, permitiendo operaciones que dejan el saldo en 30 €.
- Resultado: el sistema contiene información incoherente.

### 9.2 Control de autorizaciones

1. **Definición:**

- Es el mecanismo que evita accesos indebidos a los datos, asignando permisos según el rol del usuario.
- En sistemas modernos, esto se gestiona con privilegios y roles centralizados.

2. **Problema:**

- En sistemas de ficheros, los datos están dispersos en múltiples archivos sin un control centralizado.
- Es difícil establecer políticas de seguridad uniformes y garantizar que cada usuario acceda solo a lo que necesita.

3. **Ejemplo:**

- El departamento de nóminas debería acceder únicamente a datos de empleados.
- Sin embargo, si los ficheros están en la misma carpeta, podrían acceder también a datos de clientes, exponiendo información sensible.

### 9.3 Control de concurrencia

1. **Definición:**

- Se refiere a la capacidad de permitir que varios usuarios accedan a los mismos datos de forma simultánea sin comprometer la coherencia.
- En bases de datos modernas esto se gestiona con **transacciones** y mecanismos de bloqueo.

2. **Problema:**

- En sistemas de ficheros, si varios usuarios acceden al mismo archivo para modificarlo, no existe un control automático que garantice el orden de las operaciones.
- Esto puede provocar pérdida de datos o resultados incorrectos.

3. **Ejemplo:**

- Dos clientes intentan retirar dinero de la misma cuenta al mismo tiempo.
- Si ambos programas leen el saldo inicial (100 €) y realizan la operación sin coordinación, los dos retiros pueden ejecutarse como si hubiera saldo suficiente.
- Resultado: el saldo final puede quedar en negativo o reflejar solo una de las operaciones.

---

## 10. Problemas respecto a los datos

1. **Redundancia:** repetición innecesaria.
    - Ejemplo: teléfono de cliente en varios ficheros.
2. **Inconsistencia:** datos redundantes no coinciden.
    - Ejemplo: dirección distinta en dos ficheros.
3. **Aislamiento/fragmentación:** datos de un objeto repartidos en varios ficheros.
    - Ejemplo: datos personales en clientes.dat, cuentas en cuentas.dat.
4. **Dificultad de acceso:** obtener nueva información requiere programar.
    - Ejemplo: buscar clientes por código postal → hay que crear un programa nuevo.

---

## 11. Conclusión

1. Los sistemas de ficheros fueron la base del almacenamiento digital.
2. Presentan problemas graves: redundancia, inconsistencia, aislamiento y falta de seguridad.
3. Estos problemas explican la aparición de los **Sistemas de Bases de Datos**, que ofrecen integridad, seguridad, concurrencia y flexibilidad.

---
# 📚 TEMA 03 – Sistemas de almacenamiento de información: Bases de datos

## 1. Sistemas de bases de datos

1. **Qué es un sistema de bases de datos (visión general):**
    
    - Es el conjunto coordinado de personas, hardware, software y procedimientos que permiten almacenar, gestionar y usar datos de forma compartida y segura.
    - Su propósito es que diferentes usuarios y aplicaciones accedan a la misma información con reglas comunes (seguridad, integridad, rendimiento), evitando duplicidades y errores.
2. **Componentes principales:**
    
    - **Personas:**
        - DBA (administradores/diseñadores), programadores y usuarios finales (expertos/ocasionales).
    - **Hardware:**
        - Equipos de computación y dispositivos de almacenamiento (servidores, cabinas, discos).
    - **Software:**
        - SGBD/DBMS (motor que gestiona datos, transacciones, seguridad), utilidades del SGBD (backup, import/export, monitoreo) y programas de aplicación (ERP, CRM, apps propias).
    - **Procedimientos y estándares:**
        - Políticas de seguridad, copias de seguridad, normas de modelado, naming, planes de recuperación, reglas de acceso y mantenimiento.
3. **Qué hace el SGBD (rol central):**
    
    - Define y aplica reglas sobre los datos: esquemas, restricciones, permisos y transacciones.
    - Ofrece servicios a las aplicaciones: lenguaje de consultas (SQL), ejecución eficiente, control de concurrencia, integridad.
    - Proporciona herramientas de administración (creación de índices, estadísticas, backup/restore, replicación).
4. **Por qué es necesario (ventajas frente a ficheros):**
    
    - **Consistencia e integridad:** reglas comunes evitan datos contradictorios.
    - **Seguridad y control de acceso:** permisos por rol/usuario; auditoría.
    - **Concurrencia:** varios usuarios pueden trabajar a la vez sin corromper datos.
    - **Escalabilidad y rendimiento:** índices, planes de ejecución, cachés, replicación.
    - **Compartición:** una única “fuente de verdad” para todas las aplicaciones.
5. **Ejemplo completo (tienda online):**
    
    - Componentes:
        - Personas: DBA (define tablas e índices), programadores (API de pedidos), usuarios finales (administrativos y clientes).
        - Hardware: servidor de BD (PostgreSQL), servidor de aplicaciones, almacenamiento SSD.
        - Software: SGBD, utilidades de backup, ERP de inventario, web de ventas.
        - Procedimientos: backups nocturnos, roles (admin, ventas, soporte), normas de nombres para tablas/campos.
    - Funcionamiento:
        - El cliente hace un pedido (aplicación cliente → servidor de aplicaciones → SGBD).
        - El SGBD valida reglas (stock ≥ cantidad, cliente existe, total ≥ 0) y registra la transacción.
        - Los administrativos generan reportes; el DBA monitorea rendimiento y programa índices sobre “fecha_pedido” y “cliente_id”.
    - Beneficio: todos ven datos consistentes; las reglas se aplican en un único lugar (SGBD), se evitan duplicidades y se soportan miles de operaciones concurrentes.

---
## 2. Usuarios (perfiles implicados)

Un sistema de bases de datos involucra distintos tipos de usuarios, cada uno con responsabilidades y necesidades diferentes. Entender estos perfiles es clave para comprender cómo se organiza el trabajo y cómo se garantiza la seguridad y eficiencia del sistema.

---

### 2.1 Administradores/Diseñadores de la BD (DBA)

1. **Rol principal:**
    - Diseñan la estructura de la base de datos (modelo conceptual, lógico y físico).
    - Administran el sistema una vez implementado, asegurando seguridad, integridad y rendimiento.
2. **Responsabilidades:**
    - Definir esquemas y relaciones entre tablas.
    - Controlar accesos y permisos de usuarios.
    - Gestionar la concurrencia (varios usuarios trabajando a la vez).
    - Realizar copias de seguridad y planes de recuperación.
    - Optimizar consultas y almacenamiento.
3. **Ejemplo:**
    - En un hospital, el DBA diseña la BD de pacientes, médicos y tratamientos. Configura permisos para que los médicos solo accedan a sus pacientes y asegura que las consultas sean rápidas incluso con miles de registros.

---

### 2.2 Programadores de aplicaciones

1. **Rol principal:**
    - Crean los programas que permiten a los usuarios interactuar con la base de datos.
    - Implementan operaciones de consulta, inserción, actualización y eliminación.
2. **Lenguajes utilizados:**
    - Tercera generación: Java, PHP, Python, C#.
    - Cuarta generación: PL/SQL, T-SQL, herramientas RAD.
3. **Ejemplo:**
    - En una tienda online, el programador desarrolla el módulo de “carrito de compras” que inserta pedidos en la BD, actualiza el stock y genera facturas automáticamente.

---

### 2.3 Usuarios finales

1. **Rol principal:**
    - Son quienes utilizan la base de datos en su día a día, a través de aplicaciones o herramientas.
2. **Tipos de usuarios finales:**
    - **Expertos:** usan directamente las utilidades del SGBD (ej. ejecutar consultas SQL, generar informes personalizados).
    - **Ocasionales:** acceden mediante aplicaciones diseñadas por programadores (formularios, paneles, reportes).
3. **Ejemplo:**
    - En una universidad:
        - Un profesor (usuario ocasional) introduce las notas de sus alumnos en una aplicación.
        - Un analista académico (usuario experto) lanza consultas SQL para obtener estadísticas de rendimiento por asignatura.

---

### 2.4 Conclusión del apartado

Los sistemas de bases de datos no son solo tecnología: también son personas con roles definidos.

- El **DBA** asegura que el sistema sea seguro y eficiente.
- Los **programadores** crean las aplicaciones que conectan a los usuarios con los datos.
- Los **usuarios finales** consumen la información y realizan operaciones según sus necesidades.

👉 La interacción entre estos perfiles garantiza que la base de datos cumpla su propósito: ser una fuente confiable y compartida de información.

---
## 3. Diseñadores y Administradores (DBA)

### 3.1 Rol de los diseñadores

1. **Planificación y diseño de la BD:**
    - Los diseñadores son responsables de **modelar la información** antes de que exista físicamente en el sistema.
    - Definen el **esquema conceptual** (modelo entidad-relación), el **esquema lógico** (tablas, claves, relaciones) y el **esquema físico** (cómo se almacenan los datos en disco).
2. **Optimización del almacenamiento:**
    - Deciden cómo organizar los datos para que las consultas sean rápidas y eficientes.
    - Incluye la creación de índices, normalización de tablas y definición de claves primarias y foráneas.
3. **Documentación:**
    - Elaboran manuales y diagramas que sirven de guía para programadores y administradores.
    - Esta documentación asegura que todos los implicados comprendan la estructura de la BD.

💡 _Ejemplo:_  
En una universidad, el diseñador crea un modelo entidad-relación con entidades como **Alumno**, **Asignatura** y **Profesor**, definiendo relaciones como “Alumno se matricula en Asignatura” y “Profesor imparte Asignatura”. Luego transforma ese modelo en tablas relacionales con claves primarias y foráneas.

---

### 3.2 Rol de los administradores

1. **Seguridad:**
    - Controlan qué usuarios pueden acceder a qué datos.
    - Definen roles y privilegios (ej. un profesor puede ver notas de sus alumnos, pero no las de otros).
2. **Concurrencia:**
    - Garantizan que varios usuarios puedan trabajar simultáneamente sin que se produzcan inconsistencias.
    - Usan mecanismos de **transacciones** y **bloqueos** para asegurar que los cambios se registren correctamente.
3. **Disponibilidad y rendimiento:**
    - Mantienen el sistema operativo y optimizan el rendimiento de consultas.
    - Supervisan el uso de recursos (CPU, memoria, disco) y ajustan parámetros del SGBD.
4. **Copias de seguridad y recuperación:**
    - Programan backups periódicos y planes de recuperación ante fallos o desastres.
    - Esto asegura que la información nunca se pierda.
5. **Conocimiento técnico:**
    - Deben dominar el SGBD en uso (Oracle, MySQL, SQL Server, PostgreSQL, etc.) y el hardware sobre el que funciona.

💡 _Ejemplo:_  
En un hospital, el DBA configura permisos para que los médicos solo accedan a los historiales de sus pacientes. Además, programa copias de seguridad diarias y establece un sistema de replicación para que, si el servidor principal falla, otro servidor pueda asumir la carga sin pérdida de datos.

---

### 3.3 Conclusión del apartado

Los **diseñadores** construyen la base conceptual y lógica de la BD, mientras que los **administradores** garantizan que funcione de manera segura, eficiente y disponible en el día a día.  
👉 Sin estos roles, una base de datos sería caótica: mal diseñada, insegura y vulnerable a fallos.

---
## 4. Programadores

### 4.1 Rol principal

1. Los programadores son los encargados de **crear los programas de aplicación** que permiten a los usuarios finales interactuar con la base de datos.
2. Estos programas actúan como intermediarios entre el **usuario** y el **SGBD**, facilitando operaciones como:
    - Consultar datos (ej. buscar clientes).
    - Insertar nuevos registros (ej. añadir un pedido).
    - Actualizar información existente (ej. cambiar dirección de un cliente).
    - Eliminar registros (ej. borrar un producto descatalogado).

---

### 4.2 Lenguajes utilizados

1. **Lenguajes de tercera generación (3GL):**
    
    - Son lenguajes de propósito general, como **Java, PHP, Python, C#**, que permiten construir aplicaciones completas.
    - Se usan para desarrollar interfaces gráficas, servicios web y lógica de negocio que interactúa con la BD.
2. **Lenguajes de cuarta generación (4GL):**
    
    - Son lenguajes más especializados y cercanos al dominio de las bases de datos.
    - Ejemplos: **PL/SQL (Oracle)**, **T-SQL (SQL Server)**.
    - Permiten escribir procedimientos almacenados, triggers y consultas complejas directamente en el SGBD.

---

### 4.3 Responsabilidades

1. **Diseñar la lógica de negocio:** traducir las reglas de la organización en código que interactúe con la BD.
2. **Garantizar integridad:** asegurarse de que las operaciones respeten las restricciones definidas por los administradores/diseñadores.
3. **Optimizar consultas:** escribir código eficiente que aproveche índices y evite sobrecargar el sistema.
4. **Crear interfaces amigables:** facilitar que los usuarios finales trabajen con la BD sin necesidad de conocer SQL.

---

### 4.4 Ejemplo práctico

💡 _Ejemplo: Tienda online_

- El programador desarrolla un módulo de **carrito de compras**:
    1. Cuando el cliente añade un producto, el programa inserta un registro en la tabla `Pedidos`.
    2. Al confirmar la compra, se actualiza la tabla `Stock` restando las unidades vendidas.
    3. Se genera automáticamente una factura en la tabla `Facturas`.
- Lenguajes usados:
    - Backend en **Java/PHP** para la lógica de negocio.
    - Procedimientos almacenados en **PL/SQL** para validar stock y calcular totales.

---

### 4.5 Conclusión del apartado

Los **programadores** son el puente entre la base de datos y los usuarios finales.  
👉 Sin ellos, los usuarios tendrían que interactuar directamente con el SGBD, lo cual sería complejo y poco práctico. Gracias a los programas de aplicación, la información se gestiona de forma **segura, eficiente y accesible**.

---
## 5. Usuarios finales

### 5.1 Rol principal

1. Los usuarios finales son las personas que **utilizan la base de datos en su trabajo cotidiano**, pero no participan en su diseño ni en su administración técnica.
2. Acceden a la información a través de **programas de aplicación** o mediante **herramientas del SGBD**, dependiendo de su nivel de conocimiento.
3. Sus actividades más comunes son:
    - Consultar datos (ej. buscar información de clientes).
    - Actualizar registros (ej. cambiar dirección o teléfono).
    - Insertar nuevos datos (ej. añadir un pedido).
    - Generar informes (ej. reportes de ventas mensuales).

---

### 5.2 Tipos de usuarios finales

1. **Usuarios expertos:**
    
    - Manejan directamente las utilidades del SGBD.
    - Pueden escribir consultas SQL, crear informes personalizados y realizar análisis complejos.
    - Suelen ser analistas de datos, investigadores o personal técnico con formación en bases de datos.
    - 💡 _Ejemplo:_ Un analista financiero que lanza consultas SQL para calcular el promedio de ventas por región y genera gráficos con herramientas del SGBD.
2. **Usuarios ocasionales:**
    
    - Utilizan aplicaciones diseñadas por los programadores.
    - No necesitan conocer SQL ni la estructura interna de la BD.
    - Interactúan mediante formularios, menús y reportes predefinidos.
    - 💡 _Ejemplo:_ Un administrativo que introduce pedidos de clientes en un formulario de la aplicación de ventas, sin saber cómo se almacenan los datos en la BD.

---

### 5.3 Importancia de los usuarios finales

1. Son la **razón de ser** de la base de datos: todo el sistema se construye para que ellos puedan trabajar de manera más eficiente.
2. Sus necesidades determinan:
    - Qué datos se almacenan.
    - Qué consultas e informes se deben generar.
    - Qué interfaces se deben diseñar.
3. Sin usuarios finales, la base de datos sería un sistema sin propósito práctico.

---

### 5.4 Ejemplo completo

💡 _Ejemplo: Universidad_

- **Usuarios ocasionales:**
    - Profesores que introducen las notas de sus alumnos en una aplicación web.
    - Estudiantes que consultan sus calificaciones en un portal online.
- **Usuarios expertos:**
    - Analistas académicos que ejecutan consultas SQL para obtener estadísticas de rendimiento por asignatura y por curso.
    - Personal de administración que genera informes globales de matrícula y rendimiento.

---

### 5.5 Conclusión del apartado

Los **usuarios finales** son quienes dan sentido práctico a la base de datos.

- Los **expertos** aprovechan directamente las herramientas del SGBD para análisis avanzados.
- Los **ocasionales** trabajan con aplicaciones que simplifican el acceso a los datos.  
    👉 En conjunto, garantizan que la información almacenada se convierta en conocimiento útil para la organización.

---
## 6. Base de datos (BD)

### 6.1 Definición conceptual

1. Una **base de datos** es un conjunto de datos pertenecientes a un mismo contexto (ej. clientes, pedidos, inventario) que se almacenan con la **menor redundancia posible**, de forma **organizada y relacionada entre sí**.
2. El objetivo es que esos datos puedan ser reutilizados y consultados por diferentes usuarios y aplicaciones, garantizando coherencia y consistencia.
3. La idea clave es que la BD no es solo un “almacén de información”, sino un sistema que permite **relacionar datos** y **extraer conocimiento útil**.

---

### 6.2 Definición física

1. Desde el punto de vista físico, una BD es un sistema formado por un conjunto de datos almacenados en **ficheros en discos** que permiten acceso directo.
2. Estos ficheros son gestionados por el **SGBD**, que organiza cómo se guardan, cómo se indexan y cómo se accede a ellos.
3. Así, aunque físicamente los datos estén en múltiples ficheros, para el usuario se presentan como un sistema unificado.

---

### 6.3 Naturaleza compartida

1. Una característica fundamental de las BD es que **diferentes programas y usuarios pueden acceder a los mismos datos**.
2. Esto implica que el concepto de BD está íntimamente ligado al de **red y compartición de información**.
3. De ahí el término “base”: un repositorio común sobre el que se apoyan múltiples aplicaciones.

---

### 6.4 Origen del término

1. El término “base de datos” se escuchó por primera vez en **1963**, en un simposio celebrado en California, USA.
2. Desde entonces, el concepto ha evolucionado hasta convertirse en el núcleo de casi todas las aplicaciones modernas.

---

### 6.5 Uso de las bases de datos

1. Una BD proporciona a los usuarios acceso a datos con operaciones básicas:
    - **Visualizar** (consultar información).
    - **Insertar** (añadir nuevos registros).
    - **Actualizar** (modificar datos existentes).
    - **Eliminar** (borrar registros).
2. El acceso está regulado por **derechos y permisos** definidos por el administrador.
3. Ámbitos de uso:
    - Administrativos: clientes, pedidos, facturación.
    - Contables: pagos, balances, nóminas.
    - Motores de búsqueda web.
    - Científicos: experimentos, bibliotecas, censos.
    - Seguridad: antivirus, registros de acceso.
4. Cuanto mayor es la cantidad de datos almacenados, más útil se vuelve la BD, porque permite análisis más completos y precisos.

---

### 6.6 Ejemplo práctico

💡 _Ejemplo: Comercio electrónico_

- La BD contiene tablas como:
    - **Clientes** (id_cliente, nombre, dirección, email).
    - **Pedidos** (id_pedido, fecha, id_cliente, total).
    - **Productos** (id_producto, nombre, precio, stock).
- Funcionamiento:
    - Un cliente realiza un pedido → se inserta en la tabla `Pedidos`.
    - El stock se actualiza en la tabla `Productos`.
    - El administrador genera un informe mensual de ventas.
- Beneficio: todos los usuarios (clientes, administrativos, gerentes) trabajan sobre la misma información, evitando duplicidades y errores.

---

### 6.7 Conclusión del apartado

La **base de datos** es el corazón de los sistemas de información modernos:

- Conceptualmente, organiza datos relacionados con mínima redundancia.
- Físicamente, se implementa como ficheros gestionados por un SGBD.
- Su carácter compartido permite que múltiples usuarios y aplicaciones trabajen sobre la misma fuente de verdad.  
    👉 Sin bases de datos, las organizaciones tendrían que depender de ficheros aislados y duplicados, con todos los problemas que ya vimos en la unidad anterior.

---
## 7. Arquitectura cliente/servidor

### 7.1 Definición general

1. La arquitectura cliente/servidor es el modelo más común en sistemas de bases de datos modernos.
2. Se basa en la división de funciones entre dos partes:
    - **Servidor:** gestiona los datos, ejecuta el SGBD y asegura integridad, seguridad y concurrencia.
    - **Clientes:** consumen los recursos del servidor, enviando solicitudes (consultas, inserciones, actualizaciones) y recibiendo resultados.
3. Objetivo: facilitar el desarrollo y ejecución de aplicaciones que acceden a datos de forma eficiente y compartida.

---

### 7.2 Funciones del servidor

1. Aloja el **SGBD** y los ficheros físicos de la base de datos.
2. Procesa las consultas enviadas por los clientes.
3. Aplica reglas de seguridad, integridad y concurrencia.
4. Gestiona recursos de hardware (CPU, memoria, disco) para optimizar rendimiento.

💡 _Ejemplo:_ Un servidor con Oracle Database recibe cientos de consultas SQL de diferentes aplicaciones y usuarios, las procesa y devuelve resultados consistentes.

---

### 7.3 Funciones del cliente

1. Puede ser una aplicación de usuario, un programa servidor intermedio o cualquier software que acceda al servidor de BD.
2. Se encarga de la **interacción con el usuario**: formularios, interfaces gráficas, reportes.
3. Envía solicitudes al servidor y muestra los resultados.
4. Puede incluir herramientas de desarrollo para crear nuevas aplicaciones.

💡 _Ejemplo:_ Una aplicación web de ventas permite al usuario buscar productos; el cliente envía la consulta al servidor de BD y muestra los resultados en pantalla.

---

### 7.4 Tipos de software en la arquitectura

1. **Software de gestión de datos (SGBD):** reside en el servidor, administra almacenamiento, consultas y transacciones.
2. **Software de interacción/presentación:** reside en el cliente, implementa la interfaz gráfica de usuario.
3. **Software de desarrollo:** reside en el cliente, usado por programadores para crear aplicaciones.
4. **Software de conexión:** tanto en cliente como servidor, incluye sistemas operativos de red, drivers de conexión (ODBC/JDBC), librerías de comunicación.

---

### 7.5 Ejemplo completo

💡 _Ejemplo: Banco online_

- **Servidor:** aloja la BD con tablas de clientes, cuentas y transacciones; el SGBD gestiona consultas y asegura integridad.
- **Clientes:**
    - Aplicación web para clientes (consultar saldo, transferencias).
    - Aplicación interna para empleados (gestión de cuentas, informes).
- **Funcionamiento:**
    - El cliente solicita “saldo de la cuenta 123”.
    - El servidor procesa la consulta, valida permisos y devuelve el resultado.
    - El cliente muestra el saldo en la interfaz gráfica.

---

### 7.6 Conclusión del apartado

La arquitectura cliente/servidor permite separar responsabilidades:

- El **servidor** se centra en la gestión de datos.
- Los **clientes** se centran en la interacción con el usuario.  
    👉 Esta división facilita escalabilidad, seguridad y eficiencia, y es la base de la mayoría de sistemas de información actuales.

---
## 8. Tipos de sistemas de bases de datos

Los sistemas de bases de datos pueden clasificarse según distintos criterios: **ubicación**, **configuración cliente/servidor**, **variabilidad de los datos almacenados** y **modelo de administración de datos**. Cada clasificación refleja una forma distinta de organizar y gestionar la información.

---

### 8.1 Por ubicación

1. **Centralizados:**
    
    - La BD y el SGBD están en un único sitio (una sola máquina).
    - Variantes:
        - Basados en anfitrión: el cliente está en la misma máquina.
        - Cliente/servidor: el cliente se conecta por red al servidor central.
    - **Ventajas:** simplicidad de administración, control centralizado.
    - **Desventajas:** punto único de fallo, difícil escalado.
    - 💡 _Ejemplo:_ Una pequeña empresa con un servidor único que almacena la BD de clientes y facturas.
2. **Distribuidos:**
    
    - La BD y el SGBD están repartidos en múltiples sitios conectados por red.
    - Tipos:
        - Homogéneos: todos los sitios usan el mismo SGBD.
        - Heterogéneos: cada sitio puede usar un SGBD distinto.
    - **Ventajas:** escalabilidad, resiliencia, cercanía a los usuarios.
    - **Desventajas:** complejidad de sincronización y consistencia.
    - 💡 _Ejemplo:_ Un banco multinacional con sucursales que tienen réplicas locales de la BD para consultas rápidas, sincronizadas con un nodo central.

---

### 8.2 Por configuración de la arquitectura cliente/servidor

1. **Arquitectura de 2 capas:**
    
    - Cliente (presentación + parte de lógica) ↔ Servidor (SGBD).
    - **Ventajas:** simplicidad.
    - **Desventajas:** lógica de negocio dispersa en los clientes, difícil de mantener.
    - 💡 _Ejemplo:_ Una aplicación de escritorio que se conecta directamente a la BD central.
2. **Arquitectura de 3 capas:**
    
    - Cliente (presentación) ↔ Servidor de aplicaciones (lógica) ↔ Servidor de BD (datos).
    - **Ventajas:** mejor seguridad, escalabilidad y mantenibilidad.
    - **Desventajas:** mayor complejidad inicial.
    - 💡 _Ejemplo:_ Una aplicación web: navegador (cliente) ↔ servidor web/API (lógica) ↔ servidor de BD (datos).

---

### 8.3 Por variabilidad de los datos almacenados

1. **Bases de datos dinámicas:**
    
    - Contienen datos que cambian frecuentemente (operacionales).
    - Ejemplos: clientes, pedidos, pagos.
    - Necesitan transacciones, índices y control de concurrencia.
    - 💡 _Ejemplo:_ BD de un supermercado que registra ventas en tiempo real.
2. **Bases de datos estáticas (almacén de datos):**
    
    - Contienen datos consolidados para análisis, con pocas actualizaciones.
    - Usadas en BI (Business Intelligence) y OLAP (procesamiento analítico en línea).
    - 💡 _Ejemplo:_ Data Warehouse con datos históricos de ventas para generar informes trimestrales.

---

### 8.4 Por modelo de administración de datos (evolución histórica)

1. **Jerárquico (~1960):** datos organizados en árbol invertido.
2. **De red (finales de los 60):** estructura en grafo, más flexible que el jerárquico.
3. **Relacional (1970):** tablas con filas y columnas; modelo más usado actualmente.
4. **Orientado a objetos (1989):** datos representados como objetos con atributos y métodos.
5. **Documentales (2000, NoSQL; 2010, XML):** registros como documentos completos (JSON, XML).
6. **DBaaS (tendencias actuales):** bases de datos ofrecidas como servicio en la nube.

💡 _Ejemplo:_

- Jerárquico: ficha de cliente → facturas → líneas de detalle.
- Relacional: tablas Clientes, Pedidos, Productos relacionadas por claves.
- Documental: documento JSON con toda la información de un pedido (cliente, productos, total).

---

### 8.5 Conclusión del apartado

La clasificación de los sistemas de bases de datos muestra cómo han evolucionado y se han adaptado a distintas necesidades:

- **Centralizados** para simplicidad.
- **Distribuidos** para escalabilidad.
- **2/3 capas** para organización cliente/servidor.
- **Dinámicos/estáticos** según la variabilidad de los datos.
- **Modelos históricos** que reflejan la evolución tecnológica.

👉 Esta diversidad explica por qué hoy existen múltiples tipos de BD (SQL, NoSQL, en la nube), cada una pensada para resolver problemas específicos.

---
## 9. Modelos de bases de datos

Los modelos de bases de datos representan distintas formas de organizar y relacionar la información. Cada modelo surgió en un momento histórico para resolver limitaciones del anterior y adaptarse a nuevas necesidades.

---

### 9.1 BD jerárquica

1. **Definición:**
    - Los datos se organizan en forma de **árbol invertido** (estructura jerárquica).
    - Cada nodo padre puede tener varios hijos, pero cada hijo solo tiene un padre.
    - La navegación se realiza mediante punteros.
2. **Ventajas:**
    - Eficiente para datos con relaciones estrictamente jerárquicas.
    - Fácil de entender cuando las relaciones son simples.
3. **Limitaciones:**
    - Difícil representar relaciones muchos-a-muchos.
    - Redundancia de datos si un mismo elemento pertenece a varias jerarquías.
4. **Ejemplo:**
    - En una empresa: **Departamento → Empleados → Proyectos**.
    - Cada departamento tiene empleados, y cada empleado tiene proyectos asignados.

---

### 9.2 BD de red

1. **Definición:**
    - Similar al jerárquico, pero permite estructuras en **grafo** (no solo árbol).
    - Los registros pueden tener múltiples relaciones con otros registros.
2. **Ventajas:**
    - Soluciona mejor la redundancia de datos.
    - Permite relaciones complejas entre entidades.
3. **Limitaciones:**
    - Administración y consultas más complicadas.
    - Requiere conocimientos técnicos avanzados.
4. **Ejemplo:**
    - En un banco: **Cliente ↔ Cuenta ↔ Préstamo ↔ Seguro**.
    - Un cliente puede tener varias cuentas y préstamos, y cada cuenta puede estar vinculada a diferentes seguros.

---

### 9.3 BD relacional

1. **Definición:**
    - Modelo más usado actualmente.
    - Propuesto por **Edgar F. Codd en 1970** (IBM).
    - Los datos se organizan en **tablas (relaciones)** con filas (tuplas) y columnas (atributos).
2. **Ventajas:**
    - Lenguaje estándar (SQL).
    - Integridad referencial y normalización para reducir redundancia.
    - Flexibilidad para consultas complejas.
3. **Limitaciones:**
    - Puede ser menos eficiente en datos muy grandes y no estructurados.
4. **Ejemplo:**
    - Tablas:
        - **Clientes(id, nombre, dirección)**
        - **Pedidos(id, fecha, id_cliente)**
        - **Productos(id, nombre, precio)**
    - Relación: un cliente puede tener varios pedidos, y cada pedido incluye varios productos.

---

### 9.4 BD orientada a objetos

1. **Definición:**
    - Representa la información como **objetos**, igual que en la programación orientada a objetos.
    - Cada objeto tiene atributos (estado) y métodos (comportamiento).
2. **Ventajas:**
    - Ideal para aplicaciones que ya usan programación orientada a objetos.
    - Permite modelar datos complejos (multimedia, CAD, simulaciones).
3. **Limitaciones:**
    - Menos extendido que el relacional; mayor complejidad de implementación.
4. **Ejemplo:**
    - Clase **Persona** con atributos (nombre, teléfono) y métodos (cambiarTeléfono).
    - Subclases **Cliente** y **Proveedor** heredan de Persona y añaden comportamientos específicos.

---

### 9.5 BD documental

1. **Definición:**
    - Cada registro corresponde a un **documento completo** (texto, imagen, audio, vídeo, XML, JSON).
    - Se usan mucho en sistemas **NoSQL** modernos.
2. **Tipos:**
    - Texto completo: contienen el documento íntegro.
    - De imágenes: enlazan a la imagen original.
    - Referenciales: almacenan metadatos para localizar documentos.
3. **Ventajas:**
    - Flexibles para datos semiestructurados o no estructurados.
    - Ideales para aplicaciones web, bibliotecas digitales, big data.
4. **Limitaciones:**
    - Menos adecuadas para datos muy estructurados con relaciones complejas.
5. **Ejemplo:**
    - Una biblioteca digital almacena cada libro como un documento JSON con título, autor, año y contenido completo.
    - Otro sistema guarda solo metadatos (autor, título, ubicación física) para localizar documentos impresos.

---

### 9.6 Conclusión del apartado

Cada modelo refleja una etapa en la evolución de las bases de datos:

- **Jerárquico y de red:** pioneros, útiles pero rígidos.
- **Relacional:** estándar actual, flexible y potente.
- **Orientado a objetos:** adapta el paradigma OO al almacenamiento.
- **Documental:** responde a la era del big data y la información no estructurada.

👉 La elección del modelo depende del tipo de datos, las relaciones necesarias y el uso que se le dará a la información.

---
## 10. Bases de datos en la nube y DBaaS

### 10.1 Bases de datos en la nube (Cloud Storage)

1. **Definición:**
    
    - Son servicios que permiten a los usuarios acceder a recursos informáticos (hardware y software) **on-demand**, es decir, bajo demanda, a través de Internet o redes locales.
    - Incluyen almacenamiento, procesamiento y gestión de bases de datos sin necesidad de que la organización disponga de su propio hardware dedicado.
2. **Características principales:**
    
    - Escalabilidad: se pueden aumentar o reducir recursos según necesidad.
    - Flexibilidad: acceso desde cualquier lugar con conexión a Internet.
    - Delegación: el proveedor gestiona parte o todo el sistema.
3. **Modelos de implementación:**
    
    - El proveedor ofrece una **máquina virtual** con un SGBD instalado, que el cliente administra.
    - El proveedor gestiona directamente la BD como un servicio (el cliente solo la usa).
    - El proveedor almacena la BD en su infraestructura, liberando al cliente de la gestión física.

💡 _Ejemplo:_  
Una empresa contrata un servidor virtual en Amazon Web Services con MySQL instalado. El DBA de la empresa administra la BD, pero no necesita preocuparse por el hardware físico.

---

### 10.2 DBaaS (Database as a Service)

1. **Definición:**
    
    - Es un modelo en el que la base de datos se ofrece como un **servicio en la nube**.
    - El proveedor se encarga de la instalación, mantenimiento, escalado y seguridad del sistema.
    - El cliente solo se preocupa de usar la BD para sus aplicaciones.
2. **Ejemplos de servicios DBaaS:**
    
    - **Google Cloud SQL**
    - **Oracle Cloud Database**
    - **Amazon RDS**
    - **Azure SQL Database**
3. **Ventajas:**
    
    - Escalado sencillo y rápido.
    - Acceso desde cualquier lugar.
    - Ahorro de costes en hardware y mantenimiento.
    - Alta disponibilidad y replicación automática.
4. **Inconvenientes:**
    
    - Dependencia de la conexión a Internet.
    - Riesgos de seguridad si no se usan sistemas de cifrado adecuados.
    - Posibilidad de pérdida de privacidad y control de los datos.
    - Riesgo de dependencia del proveedor (vendor lock-in).
    - Problemas si el proveedor quiebra o falla el servicio.

💡 _Ejemplo:_  
Una startup decide usar **Google Cloud SQL** para su aplicación móvil. Así, no necesita instalar ni mantener servidores propios. El sistema escala automáticamente cuando aumenta el número de usuarios, pero si falla la conexión a Internet, los clientes no pueden acceder a la aplicación.

---

### 10.3 Conclusión del apartado

Las **bases de datos en la nube** y el modelo **DBaaS** representan la evolución natural de los sistemas de información hacia la flexibilidad y la escalabilidad.

- Permiten a las empresas centrarse en el uso de los datos sin preocuparse por la infraestructura.
- Ofrecen ventajas claras en costes, disponibilidad y facilidad de gestión.
- Sin embargo, plantean retos en seguridad, privacidad y dependencia del proveedor.

👉 Hoy en día, muchas organizaciones combinan BD locales con servicios en la nube para aprovechar lo mejor de ambos mundos.

---
# 📚 TEMA 04 – Sistemas de almacenamiento de información: SGBD Componentes

---

## 1. Definición de SGBD

1. **Concepto general:**  
    Un Sistema de Gestión de Bases de Datos (SGBD, DBMS en inglés) es el conjunto coordinado de programas, procedimientos y lenguajes que permiten definir, crear, mantener y acceder a una base de datos con control de seguridad, integridad y concurrencia.
2. **Propósito:**  
    Centralizar datos y reglas, facilitar su uso por múltiples usuarios y aplicaciones, y garantizar que las operaciones sean coherentes, seguras y eficientes.
3. **Relación con usuarios:**  
    Sirve de “capa intermedia” entre los datos y las personas/programas que los usan; traduce solicitudes (consultas, inserciones) en operaciones sobre los ficheros físicos de datos.
4. **Ejemplos de SGBD:**  
    Oracle Database, SQL Server, PostgreSQL, MySQL, IBM Db2, SQLite.

---

## 2. Funciones principales del SGBD

1. **Definición (descripción):**  
    Crear y modificar esquemas (tablas, tipos, índices, usuarios, roles, restricciones).
2. **Manipulación:**  
    Insertar, eliminar, actualizar y consultar datos de forma eficiente.
3. **Control:**  
    Seguridad (permisos), integridad (reglas), concurrencia (bloqueos/aislamiento), transacciones (ACID), recuperación (backups, logs).

---

## 3. Otras facilidades del SGBD

1. **Procedimientos para el administrador:** gestión de usuarios y roles, auditoría, parametrización del servidor.
2. **Reorganizaciones:** compactación de tablas, reconstrucción y reindexación para mejorar rendimiento.
3. **Copias de seguridad y restauración:** backups completos y diferenciales, puntos de recuperación.
4. **Carga/descarga de ficheros:** importación/exportación (CSV, JSON, XML), utilidades ETL.
5. **Estadísticas:** recopilación de estadísticas de columnas e índices para el optimizador.
6. **Generadores de listados/informes:** herramientas de reporting o integración con suites BI.
7. **Interfaces con monitores de transacciones:** integración con middleware, colas de mensajes, y monitores (TP Monitors).
8. **Replicación y alta disponibilidad:** replicación síncrona/asíncrona, clústeres, failover.
9. **Cifrado y cumplimiento:** cifrado en reposo y en tránsito, mascarado de datos, cumplimiento normativo (RGPD).

💡 Ejemplo: Un DBA programa backups incrementales diarios y un backup completo semanal, analiza estadísticas de consultas para reindexar tablas con alta fragmentación y activa la replicación para alta disponibilidad.

---

## 4. Arquitectura y componentes principales

1. **Lenguajes del SGBD:** DDL, DML, DCL, DSDL.
2. **Estructuras de datos:** ficheros de datos, diccionario de datos (catálogo), índices.
3. **Gestor de ficheros (File Manager):** asigna espacio y organiza bloques físicos.
4. **Gestor de datos (Data Manager):** aplica reglas de integridad, seguridad y coordina concurrencia y transacciones.
5. **Procesador de consultas (Query Processor):** analiza, optimiza y planifica ejecución.
6. **Compilador de DDL:** registra definiciones en el catálogo.
7. **Precompilador de DML:** traduce SQL embebido a llamadas del lenguaje huésped.
8. **Módulos transversales (ampliación):**
    - Buffer/Cache Manager
    - Transaction Manager (ACID)
    - Concurrency Control (bloqueos, aislamiento)
    - Recovery Manager (log de transacciones, checkpoints)
    - Security Manager (permisos, roles, políticas)
    - Storage Manager (tablas, particiones, tablespaces)
    - Statistics & Metadata Manager (catálogo y estadísticas)
    - Replication/HA Manager

---

## 5. Lenguajes del SGBD

### 5.1 DDL – Data Definition Language

1. **Qué hace:**  
    Define estructura: tablas, vistas, índices, restricciones, usuarios/roles y otras entidades del esquema.
2. **Dónde se guarda:**  
    En el diccionario de datos (catálogo del sistema).
3. **Ejemplos SQL:**
    
    ```sql
    CREATE TABLE Clientes (
      id        INT PRIMARY KEY,
      nombre    VARCHAR(100) NOT NULL,
      telefono  VARCHAR(20),
      email     VARCHAR(120) UNIQUE,
      creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
    
    CREATE INDEX idx_clientes_email ON Clientes(email);
    
    DROP TABLE Clientes_archivo;
    ```
    

### 5.2 DSDL – Data Storage Definition Language

1. **Qué hace:**  
    Especifica características físicas: volúmenes, archivos, tablespaces, particiones.
2. **Ejemplo (orientativo):**
    
    ```sql
    -- Crear un tablespace (dialecto Oracle/PostgreSQL)
    CREATE TABLESPACE ts_clientes LOCATION '/datos/ts_clientes';
    -- Crear tabla en dicho tablespace
    CREATE TABLE Clientes (...) TABLESPACE ts_clientes;
    ```
    

### 5.3 DCL – Data Control Language

1. **Qué hace:**  
    Controla permisos, concurrencia y transacciones (en SQL estándar, permisos y roles).
2. **Ejemplos SQL:**
    
    ```sql
    CREATE ROLE lector_clientes;
    GRANT SELECT ON Clientes TO lector_clientes;
    
    GRANT INSERT, UPDATE ON Clientes TO app_ventas;
    REVOKE UPDATE ON Clientes FROM app_ventas;
    ```
    

### 5.4 DML – Data Manipulation Language

1. **Qué hace:**  
    Consulta y manipula datos: SELECT, INSERT, UPDATE, DELETE.
2. **Ejemplos SQL:**
    
    ```sql
    INSERT INTO Clientes(id, nombre, telefono, email)
    VALUES (101, 'María Pérez', '600123456', 'maria@example.com');
    
    UPDATE Clientes SET telefono = '600999888' WHERE id = 101;
    
    DELETE FROM Clientes WHERE id = 101;
    
    SELECT id, nombre FROM Clientes WHERE email LIKE '%@example.com';
    ```
    

💡 Nota: Muchos SGBD incluyen procedimientos almacenados, triggers y funciones (PL/SQL, T-SQL), que extienden DDL/DML para lógica en el servidor.

---

## 6. Estructuras de datos internas

1. **Ficheros de datos:**  
    Archivos físicos que contienen páginas/bloques con registros de tablas e índices.
2. **Diccionario de datos (catálogo):**  
    Metadatos del sistema: tablas, columnas, tipos, índices, restricciones, vistas, permisos, procedimientos, triggers, estadísticas.
3. **Índices:**  
    Estructuras (B-Tree, Hash, GiST, etc.) para acceso rápido por claves.
4. **Particiones y tablespaces:**  
    División de tablas por rango/hash; agrupación de objetos de BD en áreas físicas.

💡 Ejemplo: El catálogo sabe que “Clientes.email” es UNIQUE; el optimizador usa el índice “idx_clientes_email” para consultas por email.

---

## 7. Gestor de ficheros (File Manager)

1. **Funciones:**  
    Asignar espacio, gestionar páginas/bloques, leer/escribir desde/ hacia disco.
2. **Interacción:**  
    Atiende peticiones del buffer manager y del gestor de datos para localizar bloques.
3. **Implementación:**  
    Puede apoyarse en el sistema operativo o incluir rutinas propias para rendimiento.

💡 Ejemplo: Al insertar 10.000 filas, reserva nuevas extensiones (chunks) en el fichero y mantiene la estructura de páginas libres usadas/ocupadas.

---

## 8. Gestor de datos (Data Manager)

1. **Funciones:**  
    Aplica integridad referencial y restricciones, coordina seguridad y concurrencia, valida operaciones de los usuarios.
2. **Transacciones:**  
    Encapsula operaciones bajo ACID (Atomicidad, Consistencia, Aislamiento, Durabilidad).
3. **Respaldo y recuperación:**  
    Coopera con el Recovery Manager y el log para garantizar persistencia.

💡 Ejemplo: Si una inserción viola la restricción UNIQUE en “email”, el gestor de datos rechaza la operación y devuelve un error coherente.

---

## 9. Procesador de consultas (Query Processor)

1. **Análisis (parsing):**  
    Convierte la consulta SQL en un árbol lógico.
2. **Reescritura:**  
    Simplifica/reescribe la consulta (por ejemplo, empuja predicados).
3. **Optimización:**  
    Selecciona el plan más eficiente según estadísticas (índices, cardinalidades).
4. **Ejecución:**  
    Entrega el plan al ejecutor (motor), que realiza scans, joins, filtros, proyecciones.

💡 Ejemplo:  
Una consulta “SELECT * FROM Ventas WHERE fecha > '2025-01-01'” escoge un índice por “fecha” y evita leer toda la tabla.

---

## 10. Compilador de DDL

1. **Función:**  
    Interpreta definiciones (CREATE/DROP/ALTER) y actualiza el catálogo.
2. **Resultado:**  
    Crea estructuras internas (descriptores) para que el SGBD conozca la forma y reglas de los datos.

💡 Ejemplo: “CREATE TABLE Pedidos(...)” registra columnas, tipos, claves e índices en el catálogo y reserva estructuras iniciales.

---

## 11. Precompilador de DML

1. **Función:**  
    Traduce SQL embebido en un lenguaje huésped (Java, C#, COBOL) a llamadas a la API (por ejemplo, JDBC/ODBC).
2. **Interacción:**  
    Coopera con el procesador de consultas para integrar sentencias y parámetros.

💡 Ejemplo:  
Un programa Java con “SELECT ... WHERE id = ?” se traduce a PreparedStatement con parámetros tipados, mejorando seguridad (evita SQL injection) y rendimiento.

---

## 12. Módulos transversales clave (ampliación)

### 12.1 Buffer/Cache Manager

1. **Qué hace:**  
    Mantiene en memoria páginas/bloques de datos recientemente usados para acelerar lecturas/escrituras.
2. **Políticas:**  
    LRU/MRU, tamaño de caché, write-back/write-through.
3. **Ejemplo:**  
    Lecturas repetidas de la misma tabla no acceden al disco cada vez; se sirven desde caché.

### 12.2 Transaction Manager (ACID)

1. **Atomicidad:**  
    Todas las operaciones de una transacción ocurren o ninguna.
2. **Consistencia:**  
    Las reglas del esquema se mantienen antes y después.
3. **Aislamiento:**  
    Niveles de aislamiento (READ COMMITTED, REPEATABLE READ, SERIALIZABLE).
4. **Durabilidad:**  
    Una vez commit, los cambios persisten aunque haya fallos.

```sql
BEGIN TRANSACTION;
UPDATE Cuentas SET saldo = saldo - 100 WHERE id = 1;
UPDATE Cuentas SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
```

### 12.3 Concurrency Control

1. **Bloqueos:**  
    Compartido (lectura) y exclusivo (escritura); bloqueo a nivel de fila/página/tabla.
2. **Fenómenos:**  
    Lecturas sucias, lecturas no repetibles, fantasmas → mitigados con aislamiento y MVCC.
3. **Ejemplo:**  
    Dos usuarios actualizan la misma fila: el segundo espera a que el primero libere el bloqueo.

### 12.4 Recovery Manager

1. **Log (registro de transacciones):**  
    Registra operaciones para rehacer/deshacer cambios (REDO/UNDO).
2. **Checkpoints:**  
    Puntos de control para acelerar recuperación tras fallos.
3. **Recuperación:**  
    Estrategias tipo ARIES (concepto general): análisis, redo, undo.
4. **Ejemplo:**  
    Ante un corte de luz, el SGBD reabre y ejecuta REDO de transacciones confirmadas, y UNDO de las incompletas.

### 12.5 Security Manager

1. **Permisos y roles:**  
    GRANT/REVOKE, políticas de acceso por esquema/tabla/columna.
2. **Cifrado:**  
    TLS para conexiones; cifrado en reposo (TDE).
3. **Auditoría:**  
    Registro de actividad (quién accede a qué).

### 12.6 Storage Manager

1. **Organización física:**  
    Files, tablespaces, particiones, compresión, fillfactor.
2. **Ejemplo:**  
    Partición mensual de “Ventas” para acelerar consultas por rango de fechas.

### 12.7 Statistics & Metadata Manager

1. **Estadísticas:**  
    Cardinalidad, histograms, selectividad → el optimizador decide planes.
2. **Recomendación:**  
    Actualizar estadísticas tras cargas masivas para evitar planes subóptimos.

### 12.8 Replication/High Availability

1. **Replicación:**  
    Síncrona (consistencia fuerte) vs. asíncrona (latencia menor).
2. **Failover y clúster:**  
    Nodo secundario asume si el primario cae.
3. **Ejemplo:**  
    PostgreSQL streaming replication para lectura escalable y continuidad.

---

## 13. Flujo de una operación típica en el SGBD

1. **Cliente envía SQL:**  
    “SELECT * FROM Clientes WHERE email = 'ana@example.com'”
2. **Procesador de consultas:**  
    Parseo → reescritura → optimización → plan de ejecución (usar índice por email).
3. **Gestor de datos + Concurrencia:**  
    Aplica permisos, asegura aislamiento adecuado.
4. **Buffer Manager:**  
    Carga páginas necesarias; si están en caché, evita acceso a disco.
5. **Gestor de ficheros:**  
    Lee bloques desde disco si falta en caché.
6. **Resultado:**  
    Devuelve filas al cliente; opcionalmente cachea resultados parciales.

---

## 14. Ejemplos integrados

### 14.1 Integridad y restricción

```sql
CREATE TABLE Pedidos (
  id          INT PRIMARY KEY,
  cliente_id  INT NOT NULL,
  total       DECIMAL(10,2) CHECK (total >= 0),
  FOREIGN KEY (cliente_id) REFERENCES Clientes(id)
);
```

- Si se intenta insertar un pedido con total negativo o con cliente inexistente, el gestor de datos rechaza la operación.

### 14.2 Transacción de transferencia bancaria

```sql
BEGIN TRANSACTION;
UPDATE Cuentas SET saldo = saldo - 200 WHERE id = 10;  -- Debe no quedar negativo
UPDATE Cuentas SET saldo = saldo + 200 WHERE id = 20;
-- Validar regla de negocio (ej.: saldo >= 0)
-- Si todo correcto:
COMMIT;
-- Si algo falla: ROLLBACK;
```

- Atomicidad: o se aplican ambas actualizaciones, o ninguna.

### 14.3 Permisos y auditoría

```sql
CREATE ROLE backoffice_lectura;
GRANT SELECT ON Ventas TO backoffice_lectura;
REVOKE DELETE ON Ventas FROM backoffice_lectura;
```

- El Security Manager registra que el rol solo puede leer y no borrar.

---

## 15. Buenas prácticas del DBA y del desarrollador

1. **Índices bien elegidos:** crear índices en columnas de búsqueda frecuente y claves foráneas; evitar índices redundantes.
2. **Estadísticas actualizadas:** tras cargas masivas o cambios de distribución, actualizar estadísticas.
3. **Normalización + desnormalización controlada:** evitar redundancia, desnormalizar solo cuando el rendimiento lo exige.
4. **Transacciones cortas:** reducir tiempo de bloqueo; usar el menor aislamiento que garantice coherencia.
5. **Backups y pruebas de recuperación:** validar regularmente que se puede restaurar.
6. **Seguridad por defecto:** mínimo privilegio, cifrado de conexiones, secretos fuera del código.
7. **Monitorización:** métricas de CPU, I/O, cache hit ratio, tiempos de consulta, deadlocks.
8. **Particiones y mantenimiento:** particionar tablas grandes por fecha; reindexar y vacuum/compactar cuando sea necesario.

---

## 16. Relación componentes–usuarios (visión conjunta)

1. **Usuarios ingenuos:** usan aplicaciones (formularios, reportes) sin saber SQL ni estructura interna.
2. **Programadores de aplicaciones:** escriben lógica de negocio; usan DML y APIs de conexión (JDBC/ODBC).
3. **Usuarios sofisticados:** ejecutan consultas complejas, análisis y reporting avanzado.
4. **DBA:** define esquemas (DDL), gestiona seguridad (DCL), almacenamiento (DSDL), y rendimiento (estadísticas/índices).

---
# 📚 Apuntes Complementarios – Unidad 01: Almacenamiento de la Información, Ficheros, Bases de Datos y SGBD

---

## 1. Concepto de información y estructuras de datos

1. **Datos simples:** indivisibles (ej. año = 1999).
2. **Datos compuestos:** agregados de simples (ej. fecha = 7/Oct/2010).
3. **Registro lógico:** unidad homogénea de información (ej. ficha de cliente).
4. **Registro físico:** unidad de transmisión/almacenamiento; puede contener varios registros lógicos.
5. **Almacenamiento:**
    - Primario: RAM (rápido, volátil).
    - Secundario: discos duros, SSD (bloques/sectores).
    - Intermedio: buffer en memoria principal para agilizar E/S.

💡 _Ejemplo:_ Una BD de nóminas guarda registros lógicos de empleados; físicamente se almacenan en bloques de disco gestionados por el SO.

---

## 2. Ficheros

1. **Definición:** estructuras creadas por el SO para almacenar datos binarios (0/1) interpretados según formato.
2. **Clasificación por contenido:**
    - Binarios: imágenes (.jpg), vídeos (.avi), comprimidos (.zip), ejecutables (.exe), documentos (.docx).
    - Texto: planos/ASCII (.ini, .java, .sql, .html).
3. **Clasificación por organización:**
    - Secuencial: registros contiguos.
    - Secuencial encadenada: punteros al siguiente registro.
    - Secuencial indexada: índice + archivo principal + desbordamiento.
    - Directa (hash): clave transformada en posición física.
4. **Clasificación por uso:**
    - Permanentes: maestros, constantes, históricos.
    - Temporales: corta duración.

💡 _Ejemplo:_ Access guarda BD en ficheros binarios .mdb/.accdb; Oracle usa múltiples ficheros (datafiles, logfiles).

---

## 3. Métodos de acceso a ficheros

1. **Secuencial:** recorrer registros uno a uno.
2. **Directo:** acceso inmediato por clave/posición.
3. **Indexado:** usar índices para localizar registros rápidamente.
    - Índice denso: referencia a todos los registros.
    - Índice no denso: referencia a subconjunto.
    - Índice primario: campo clave único.
    - Índice de agrupamiento: campo de ordenación con valores repetidos.
    - Índice secundario: campo distinto al de ordenación.

💡 _Ejemplo:_ En un fichero de clientes, un índice primario por DNI permite acceso directo; un índice secundario por ciudad facilita consultas geográficas.

---

## 4. Inconvenientes de los sistemas de ficheros

1. Separación y aislamiento de datos.
2. Redundancia y duplicación → inconsistencias.
3. Dependencia de programas → definición de datos codificada en aplicaciones.
4. Formatos incompatibles.
5. Falta de control de concurrencia y autorizaciones.

💡 _Ejemplo:_ Teléfono de cliente repetido en varios ficheros (cuentas, préstamos, hipotecas) → inconsistencias si se actualiza solo en uno.

---

## 5. Evolución hacia bases de datos

1. **Problemas de ficheros:** redundancia, inconsistencias, ocupación excesiva, tiempos de proceso altos.
2. **Solución:** sistemas orientados a datos → almacenar una sola vez, independiente de aplicaciones.
3. **Modelos iniciales:** jerárquico y de red (años 60).
4. **Modelo relacional (Codd, 1970):** basado en lógica de predicados y teoría de conjuntos.
5. **Evolución posterior:** BD distribuidas, multidimensionales, orientadas a objetos, documentales, en la nube.

---

## 6. Concepto de base de datos

1. **Definición:** colección de información organizada con redundancia controlada, compartida por múltiples usuarios y aplicaciones.
2. **Independencia:** separación entre programas y datos.
3. **Operaciones básicas:** consultar, insertar, modificar, eliminar.
4. **Tipos de datos almacenados:**
    - Datos del usuario (contenido).
    - Datos del sistema (estructura, metadatos, control).
5. **Componentes:**
    - Dato, tipo de dato, campo, registro, campo clave, tabla.
    - Consulta, índice, vista, informe, script, procedimiento.
    - Esquema (metainformación).

💡 _Ejemplo:_ En una BD relacional, la tabla `Clientes` almacena registros con campos `id`, `nombre`, `teléfono`; el índice sobre `id` acelera búsquedas.

---

## 7. Tipos de bases de datos

1. **Jerárquicas:** árbol invertido; relaciones 1:N; difícil representar N:M.
2. **De red:** grafo; más flexibles; complejas de implementar.
3. **Relacionales:** tablas con filas y columnas; SQL como estándar; integridad referencial.
4. **Orientadas a objetos:** encapsulan datos y métodos; útiles para multimedia, CAD, GIS.
5. **Documentales:** cada registro es un documento (texto, imagen, audiovisual, XML/JSON).
6. **Distribuidas:** BD repartidas en múltiples nodos; homogéneas o heterogéneas.
7. **En la nube / DBaaS:** bases de datos ofrecidas como servicio; escalables, accesibles, pero con riesgos de dependencia y seguridad.

---

## 8. Usos de las bases de datos

1. Administrativas (clientes, pedidos).
2. Contables (pagos, balances).
3. Motores de búsqueda web.
4. Científicas (experimentos, bibliotecas).
5. Configuraciones y censos.
6. Antivirus y seguridad.
7. Militares, videojuegos, deportes.

💡 _Ejemplo:_ Google usa BD distribuidas para su motor de búsqueda; hospitales usan BD relacionales para historiales médicos.

---

## 9. Sistemas Gestores de Bases de Datos (SGBD)

1. **Definición:** conjunto de herramientas que facilitan consulta, uso y actualización de una BD.
2. **Funciones:**
    - Almacenar, acceder y actualizar datos.
    - Garantizar integridad.
    - Seguridad y control de accesos.
    - Diccionario de metadatos.
    - Transacciones (ACID).
    - Estadísticas y monitorización.
    - Concurrencia.
    - Independencia de datos.
    - Conectividad externa (ODBC).
    - Copias de seguridad y recuperación.
3. **Ejemplos:**
    - Libres: MySQL, PostgreSQL, SQLite, Firebird.
    - Propietarios: Oracle, SQL Server, IBM DB2, Informix, dBase, FileMaker.

---

## 10. Lenguaje SQL

1. **Definición:** lenguaje estándar de comunicación con BD, estandarizado por ISO.
2. **Sub-lenguajes:**
    - **DDL:** definición de datos (`CREATE`, `DROP`).
    - **DML:** manipulación de datos (`SELECT`, `INSERT`, `UPDATE`, `DELETE`).
    - **DCL:** control de datos (`GRANT`, `REVOKE`).
    - **TCL:** control de transacciones (`COMMIT`, `ROLLBACK`).
3. **Niveles de definición con DDL:**
    - Interno: espacio físico, métodos de acceso.
    - Conceptual: entidades, atributos, relaciones, permisos.
    - Externo: vistas y permisos específicos para usuarios.

💡 _Ejemplo:_

```sql
CREATE TABLE Clientes (
  id INT PRIMARY KEY,
  nombre VARCHAR(100),
  telefono VARCHAR(20)
);

INSERT INTO Clientes VALUES (1, 'Ana López', '600123456');
SELECT * FROM Clientes WHERE id = 1;
```

---

## 11. Diferencias entre ficheros y bases de datos

1. **Ficheros:**
    - Orientados a procesos.
    - Datos aislados y duplicados.
    - Definición codificada en programas.
    - Difícil control de concurrencia y seguridad.
2. **Bases de datos:**
    - Orientadas a datos.
    - Datos centralizados y compartidos.
    - Independencia entre datos y programas.
    - Control de integridad, seguridad y concurrencia.

---


# tema  4
## ejercicios 

```html
fugyuygu
```

### `<a>`
sirve para enlaces 