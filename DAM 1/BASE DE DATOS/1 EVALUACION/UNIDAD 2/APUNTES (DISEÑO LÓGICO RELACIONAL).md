# 📚 TEMA 1 – Diseño lógico relacional: Modelo Entidad/Relación (E/R)

---

## 1. Diseño conceptual

1. Se realiza tras el **análisis de requisitos** (enunciado del problema).
2. En el análisis se identifican:
    - **Entidades**: objetos de interés (ej. Empleados, Departamentos).
    - **Relaciones**: vínculos entre entidades (ej. Empleado trabaja en Departamento).
    - **Información a guardar**: atributos relevantes (ej. NIF, nombre, director).
    - **Restricciones de integridad**: reglas del negocio (ej. cada departamento tiene un único director).
3. El **Modelo Entidad-Relación (ER)** es la herramienta para plasmar este diseño conceptual.

💡 _Ejemplo:_ En una empresa, se define la entidad **Empleado** con atributos NIF y nombre, la entidad **Departamento** con nombre y director, y la relación **dirige** entre ambas.

---

## 2. Modelo Entidad-Relación

1. Propuesto por **Peter Chen en 1976**.
2. Representa conceptualmente los datos y sus relaciones mediante **diagramas ER**.
3. Variantes: modelo ER extendido (ERE), que añade mejoras.
4. Es **conceptual y universal**, independiente del SGBD.

---

## 3. Características del modelo ER

- Simplicidad y legibilidad.
- Útil para reflejar requisitos del mundo real y comunicarlos con usuarios finales.
- Fácil de aprender y usar.
- Herramientas CASE (ej. MySQL Workbench, Dia) lo implementan.

---

## 4. Elementos del modelo ER

1. **Entidades**
2. **Relaciones**
3. **Atributos**
4. **Restricciones**

---

## 5. Entidades

1. **Definición:** objetos sobre los que se guarda información (personas, cosas, conceptos, sucesos).
2. **Representación:** rectángulos con el nombre dentro.
3. **Instancias:** ejemplares concretos de la entidad.
    - Entidad: Coche.
    - Instancia: Seat Ibiza matrícula 1442-FHD.

### Tipos de entidades

- **Fuertes:** existen por sí mismas (ej. Cliente, Pedido).
- **Débiles:** dependen de otra entidad fuerte; se representan con doble rectángulo (ej. Detalle de Pedido depende de Pedido).

![[Captura de pantalla 2025-12-15 201000.png]]

💡 _Ejemplo:_ Una **Factura** es débil respecto a **Cliente** (no existe sin cliente), pero fuerte respecto a **LíneaFactura**.

---

## 6. Atributos

1. **Definición:** características que describen una entidad o relación

![[Captura de pantalla 2025-12-15 201150.png]]


1. **Representación:** elipses conectadas a la entidad.
2. **Clave primaria:** atributo(s) que identifican unívocamente una instancia; se subraya.
    - Puede ser **atómica** (ej. DNI) o **compuesta** (ej. nombre+apellido).
    - Puede haber varias candidatas; se elige una como primaria.

       ![[Pasted image 20251215201357.png]]
### Tipos de atributos

- **Simples:** indivisibles (ej. DNI).
- **Compuestos:** formados por subatributos (ej. Dirección = calle + ciudad + CP).
- **Multivaluados:** pueden tener varios valores (ej. Teléfonos).
- **Opcionales:** pueden ser nulos (ej. segundo apellido).
- **Derivados:** calculados a partir de otros (ej. edad a partir de fecha de nacimiento).

![[Pasted image 20251215201542.png]]

💡 _Ejemplo:_ Entidad **Hotel** con atributos: código (clave primaria), nombre, dirección, ciudad, número de plazas.

---

## 7. Dominio y valor

1. **Valor:** contenido concreto de un atributo.
2. **Dominio:** conjunto de valores posibles.
    - Por intensión: definido por tipo de dato (ej. DNI = cadena de 10 caracteres).
    - ![[Pasted image 20251215201627.png]]
    - Por extensión: conjunto explícito de valores (ej. Ciudad = Zaragoza, Huesca, Teruel).

---

## 8. Relaciones

1. **Definición:** asociación entre entidades.
2. **Representación:** rombo con un verbo dentro (ej. “trabaja en”).

![[Pasted image 20251215201649.png]]

3. **Atributos de relación:** propios de la relación, no de las entidades (ej. fecha de inicio en “Empleado trabaja en Proyecto”).

![[Pasted image 20251215201738.png]]

---

## 9. Grado de la relación

- **Binarias:** entre dos entidades (ej. Jugador juega en Equipo).
- ![[Pasted image 20251215201807.png]]
- **Unarias/reflexivas:** una entidad consigo misma (ej. Empleado es jefe de Empleado).
- ![[Pasted image 20251215201823.png]]
- **Ternarias:** entre tres entidades (ej. Autor escribe Libro para Editorial).
- ![[Pasted image 20251215201838.png]]
- **N-arias:** raras; se recomienda descomponer en binarias.

---

## 10. Restricciones

1. **Participación:** mínimo y máximo de veces que una entidad participa en una relación.
    - Ej. (0,n): un empleado puede trabajar en ningún proyecto o en muchos.
    - Ej. (1,1): un departamento debe tener un director único.

![[Pasted image 20251215201952.png]]

1. **Cardinalidad:** número máximo de ocurrencias entre entidades.
    - 1:1 → un empleado dirige un único departamento.
    - 1:N → un representante representa a varios actores.
    - N:M → un empleado trabaja en varios proyectos y un proyecto tiene varios empleados.

![[Pasted image 20251215202013.png]]

2. **Dependencia:**
    - Por existencia: entidad débil no existe sin la fuerte.
    - Por identificación: necesita la clave de la fuerte para identificarse.

---

## 11. Ejemplos de cardinalidad

- **1:1:** Empleado dirige Departamento.

![[Pasted image 20251215202150.png]]

- **1:N:** Representante representa Actor.

![[Pasted image 20251215202207.png]]

- **N:M:** Empleado trabaja en Proyecto.

![[Pasted image 20251215202220.png]]

- **Ternaria:** Empresa auditada por Auditora con Expediente.

![[Pasted image 20251215202240.png]]

- **Reflexiva:** Empleado es jefe de Empleado.

![[Pasted image 20251215202309.png]]

---

## 12. Dependencia

- **Existencia:** la entidad débil no tiene sentido sin la fuerte (ej. Transacción depende de Cuenta Bancaria).

![[Pasted image 20251215202331.png]]

- **Identificación:** la entidad débil necesita la clave de la fuerte para identificarse (ej. LíneaPedido depende de Pedido).

![[Pasted image 20251215202343.png]]

---

## 13. Herramientas de modelado

1. **MySQL Workbench:** permite crear diagramas ER, definir entidades, relaciones y dependencias.

![[Pasted image 20251215202359.png]]

1. **Dia Diagram Editor:** programa libre para dibujar diagramas estructurados (entidades, relaciones, atributos).

![[Captura de pantalla 2025-12-15 202410.png]]

---

## 14. Conclusión del tema 

1. El **modelo ER** es la base del diseño conceptual de BD.
2. Permite representar entidades, atributos, relaciones y restricciones de forma clara y entendible.
3. Facilita la comunicación entre diseñadores y usuarios, asegurando que la BD refleje fielmente los requisitos del mundo real.
4. Es independiente del SGBD, pero sirve como paso previo al diseño lógico (tablas relacionales).

---
# 📚 TEMA 2 – Diseño lógico relacional: Modelo Entidad/Relación Ampliado (E/R)

---

## 1. Introducción

1. El modelo E/R inicial se ha ido desarrollando hasta alcanzar un nivel más completo.
2. El **Modelo Entidad-Relación Extendido o Ampliado (ERE)** incorpora:
    - Todos los elementos del modelo E/R clásico.
    - **Roles** en las relaciones.
    - **Interrelaciones jerárquicas** (superclase/subclase, generalización/especialización).
    - **Restricciones** adicionales en las interrelaciones.
    - **Agregaciones** (relaciones entre relaciones).

💡 _Ejemplo:_ En un sistema académico, además de entidades como **Estudiante** y **Carrera**, el modelo ampliado permite definir roles (“estudia”, “dirige”), jerarquías (Persona → Estudiante/Profesor) y restricciones (un estudiante debe estar matriculado para poder examinarse).

---

## 2. Roles

1. **Definición:** función que cumple una entidad dentro de una relación.
2. **Utilidad:** añade semántica y reduce ambigüedad en cardinalidades.
3. **Ejemplo:**
    - Relación **Empleado dirige Empleado** → roles: “dirige a” y “es dirigido por”.
    - Relación **Autor escribe Libro** → roles: “escribe” y “es escrito”.

![[Pasted image 20251215213437.png]]


![[Pasted image 20251215213501.png]]

---

## 3. Interrelaciones jerárquicas

1. Representan relaciones del tipo **“es un”**.
2. **Supertipo/Superclase:** entidad general.
3. **Subtipo/Subclase:** entidades específicas derivadas.
4. **Representación:** triángulo unido a la entidad general.
5. **Ejemplo:**
    - **Empleado** (superclase) → **Técnico**, **Directivo**, **Comercial** (subclases).
    - Todos heredan atributos comunes (DNI, nombre, dirección), pero cada subclase añade atributos propios (ej. comisión, nº proyectos).

![[Pasted image 20251215213542.png]]


---

## 4. Generalización y especialización

1. **Generalización:** se detecta que varias entidades comparten atributos → se crea una superclase.
2. **Especialización:** una entidad tiene atributos que solo aplican a algunos ejemplares → se crean subclases.
3. **Ejemplo:**
    - Generalización: **Empleado** agrupa atributos comunes de Técnico, Directivo y Comercial.
    - Especialización: **Empleado** se divide en subclases según puesto.

![[Pasted image 20251215213618.png]]

---

## 5. Tipos de especialización

1. **Exclusiva (sin solapamiento):** cada instancia pertenece a una sola subclase.
    - Ejemplo: un empleado es Directivo **o** Técnico **o** Comercial.
    - Representación: arco bajo el triángulo.

	![[Pasted image 20251215222512.png]]

1. **Inclusiva (con solapamiento):** una instancia puede pertenecer a varias subclases.
    - Ejemplo: un empleado puede ser Directivo y Técnico a la vez.
    - Representación: sin arco.

![[Pasted image 20251215224000.png]]

1. **Total:** toda instancia de la superclase debe pertenecer a alguna subclase.
    - Ejemplo: todo empleado debe ser Directivo, Técnico o Comercial.
    - Representación: círculo antes del triángulo.

![[Pasted image 20251215224024.png]]

1. **Parcial:** no todas las instancias de la superclase deben pertenecer a una subclase.
    - Ejemplo: algunos empleados no son Directivos ni Técnicos ni Comerciales.
    - Representación: sin círculo.

![[Pasted image 20251215224048.png]]


### Combinaciones de especialización en el modelo ER ampliado

#### Exclusiva–Total

- **Definición:** toda instancia del supertipo debe estar en una subclase, y solo en una.
- **Representación:** triángulo con arco (exclusiva) y círculo (total).
- **Ejemplo:**
    - **Animal → Vertebrado, Invertebrado.** Todo animal es exactamente uno de los dos.
- **Consecuencia de diseño:**
    - **Herencia completa:** la clave del supertipo identifica a la subclase.
    - **Validación obligatoria:** no pueden existir instancias del supertipo sin asignación a subclase.
- **Paso a relacional:**
    - **Opción A (tabla por subclase + tabla supertipo con PK/FK):**
        - Tabla Animal(id, …); Vertebrado(id PK/FK Animal, …); Invertebrado(id PK/FK Animal, …).
        - Constraint “exactamente una” se implementa con checks y/o vistas con reglas, o con disparadores.
    - **Opción B (tabla única con columnas de cada subclase + columna tipo):**
        - Animal(id, tipo CHECK IN('VER','INV'), …atributos específicos nullable…).
        - Más simple, pero puede introducir nulos para atributos que no aplican.

![[Pasted image 20251215224528.png]]

---

#### Exclusiva–Parcial

- **Definición:** una instancia puede pertenecer a cero o una subclase; si pertenece, solo a una.
- **Representación:** triángulo con arco (exclusiva), sin círculo (parcial).
- **Ejemplo:**
    - **Empleado → Directivo, Técnico, Comercial.** Puede haber Empleados sin perfil específico (Conserje, Administrativo…); si tienen perfil, solo uno.
- **Consecuencia de diseño:**
    - **Instancias en supertipo “sin especializar” permitidas.**
- **Paso a relacional:**
    - **Tabla supertipo + tablas subclase opcionales:**
        - Empleado(id, …); Directivo(id PK/FK Empleado, …); Técnico(id PK/FK Empleado, …); Comercial(id PK/FK Empleado, …).
        - Exclusividad: garantizar que un id aparezca en, como máximo, una tabla de subclase (triggers o constraint parcial mediante índices únicos con predicados, según SGBD).


![[Pasted image 20251215224409.png]]

---

#### Inclusiva–Total

- **Definición:** toda instancia del supertipo debe pertenecer al menos a una subclase; puede pertenecer a varias.
- **Representación:** triángulo sin arco (inclusiva), con círculo (total).
- **Ejemplo:**
    - **Empleado → Directivo, Técnico, Comercial.** Todo empleado debe ser, como mínimo, uno; puede ser varios a la vez.
- **Consecuencia de diseño:**
    - **Cobertura obligatoria** y **solapamiento permitido.**
- **Paso a relacional:**
    - **Supertipo + subclases múltiples:**
        - Empleado(id, …); Directivo(id PK/FK Empleado); Técnico(id PK/FK Empleado); Comercial(id PK/FK Empleado).
        - Totalidad: al insertar Empleado, asegurar presencia en al menos una subclase (trigger AFTER INSERT que compruebe/impida commit si no hay subclase).

![[Pasted image 20251215224437.png]]

---

#### Inclusiva–Parcial

- **Definición:** una instancia puede pertenecer a ninguna, una o varias subclases.
- **Representación:** triángulo sin arco (inclusiva), sin círculo (parcial).
- **Ejemplo:**
    - **Persona → Trabajador, Estudiante.** Puede ser Trabajador, Estudiante, ambos, o ninguno (p. ej., Jubilado).
- **Consecuencia de diseño:**
    - **Máxima flexibilidad:** no hay obligación de clasificar; se permite solapamiento.
- **Paso a relacional:**
    - **Supertipo + subclases opcionales y solapables:**
        - Persona(id, …); Trabajador(id PK/FK Persona); Estudiante(id PK/FK Persona).
        - No requiere constraints adicionales, salvo reglas de negocio específicas.


![[Pasted image 20251215224506.png]]

---
#### Ejemplos adicionales de cada combinación

- **Exclusiva–Total:**
    - Vehículo → Coche | Moto | Camión. Todo vehículo es exactamente uno.
- **Exclusiva–Parcial:**
    - Usuario → Alumno | Profesor. Puede haber usuarios “invitados” sin rol; si tienen rol, solo uno.
- **Inclusiva–Total:**
    - Documento → Etiqueta A | Etiqueta B | Etiqueta C. Todo documento requiere al menos una etiqueta; puede tener varias.
- **Inclusiva–Parcial:**
    - Recurso → Habilitado en Región EU | US. Puede estar en ninguna, una o ambas regiones.

---
## 6. Restricciones en interrelaciones

1. **Exclusividad:** una entidad no puede participar en dos relaciones a la vez.
    - Ejemplo: un artículo es suministrado por un proveedor **o** por un fabricante, pero no ambos.
    - ![[Pasted image 20251215224903.png]]
2. **Exclusión:** algunos ejemplares no pueden estar en ciertas relaciones simultáneamente.
    - Ejemplo: una persona no puede impartir y recibir el mismo curso.
    - ![[Pasted image 20251215224927.png]]
3. **Inclusividad:** si participa en una relación, debe participar en otra.
    - Ejemplo: un socio que pertenece a un club debe pagar cuotas.
    - ![[Pasted image 20251215224949.png]]
4. **Inclusión:** una relación implica otra.
    - Ejemplo: los cirujanos son un subconjunto de los médicos → si opera, necesariamente atiende.
    - ![[Pasted image 20251215225014.png]]

---

## 7. Agregaciones

1. **Definición:** relación especial donde una relación se trata como entidad para participar en otra.
2. **Tipos:**
    - **Compuesto/Componente:** un “todo” formado por partes distintas.
        - Ejemplo: **Coche** compuesto por **Motor**, **Chasis**, **Rueda**.
    - **Miembro/Colección:** un “todo” formado por miembros del mismo tipo.
        - Ejemplo: **Flota** formada por varios **Barcos**, ordenados por número.

![[Pasted image 20251215225137.png]]

---

## 8. Construcción de un diagrama E/R ampliado

1. Leer y comprender el problema.
2. Identificar entidades, relaciones y atributos.
3. Distinguir atributos clave y tipos de atributos.
4. Detectar generalizaciones/especializaciones.
5. Definir dominios de atributos.
6. Identificar relaciones y sus participaciones/cardinalidades.
7. Colocar todos los elementos en un esquema.
8. Refinar y replantear si es necesario.

---

## 9. Consideraciones finales

1. El diseño ER es **subjetivo**: puede haber varias formas de modelar.
2. Un mal diseño genera **redundancia** y anomalías en inserciones, borrados y actualizaciones.
    - Se soluciona con **normalización**.
3. Existen muchas notaciones distintas para diagramas ER.
4. El modelo ampliado añade potencia semántica y flexibilidad, pero requiere más cuidado en el diseño.

---

## 10. Conclusión de la unidad

1. El **Modelo ER Ampliado (ERE)** extiende el clásico con roles, jerarquías, restricciones y agregaciones.
2. Permite representar con mayor precisión la complejidad del mundo real.
3. Facilita un diseño conceptual más rico, que luego se traduce en un modelo lógico relacional más robusto.
4. Es clave para evitar ambigüedades y redundancias, asegurando que la BD refleje fielmente las reglas del negocio.

---

#  TEMA 2 – Apuntes complementarios: El modelo Entidad Relación (E/R)

---

## 1. Introducción (novedades)

- El modelo E/R es **conceptual y universal**, no depende de ningún sistema físico ni informático.
- Puede usarse para explicar procesos a personas sin conocimientos técnicos, gracias a su **simplicidad y legibilidad**.
- El diseño de BD comienza siempre con:
    1. Analizar el problema.
    2. Identificar la información que se necesita guardar.
    3. Pensar qué información se necesitará obtener.

💡 _Ejemplo:_ Antes de diseñar una BD de una biblioteca, se analiza qué datos se necesitan (libros, autores, préstamos) y qué consultas se harán (ej. libros prestados por usuario).

---

## 2. Relaciones – Grado y reducción de complejidad

### 2.1 Grados de relación

- **Unarias (reflexivas):** una entidad consigo misma (ej. Empleado es jefe de Empleado).
- **Binarias:** dos entidades (ej. Empleado trabaja en Sucursal).
- **Ternarias:** tres entidades (ej. Actor interpreta Personaje en Película).
- **N-arias:** más de tres entidades. Son poco frecuentes y se recomienda **reducirlas a relaciones binarias** para simplificar el modelo.

### 2.2 Reducción de relaciones N-arias

- Una relación de orden 4 (ej. Actor–Película–Estudio–Salario) puede transformarse en varias relaciones binarias mediante una **entidad intermedia**.
- Ejemplo: crear la entidad **Contrato** que conecta Actor, Película, Estudio y Salario.
- Esto mejora la claridad y facilita la transformación al modelo relacional.

💡 _Ejemplo práctico:_

```text
Entidad CONTRATO
- idContrato (PK)
- idActor (FK)
- idPelícula (FK)
- idEstudio (FK)
- salario
```

---

## 3. Restricciones derivadas del modelo ERE (ampliación)

Ya vimos exclusividad, exclusión, inclusividad e inclusión, pero aquí se añaden **ejemplos más ricos**:

- **Exclusividad:** un profesor puede impartir cursos o recibirlos, pero no ambas cosas.
- **Exclusión:** un profesor puede impartir y recibir cursos, pero nunca el mismo curso.
- **Inclusividad:** un profesor que imparte debe haber recibido previamente cursos (ej. al menos 3).
- **Inclusión:** un profesor que imparte un curso debe haber recibido **ese mismo curso** antes.

💡 _Ejemplo inclusividad vs inclusión:_

- Inclusividad: Profesor imparte curso A → debe haber recibido **algún curso** (no necesariamente A).
- Inclusión: Profesor imparte curso A → debe haber recibido **ese mismo curso A**.

---

## 4. Atributos – Novedades

1. **Clasificación adicional:**
    
    - **Obligatorios:** siempre deben estar definidos (ej. DNI en Empleado).
    - **Opcionales:** pueden quedar vacíos (ej. edad).
    - **Simples:** indivisibles (ej. DNI).
    - **Compuestos:** formados por varios componentes (ej. Dirección = calle + número + población).
    - **Monovalentes:** un único valor por instancia (ej. DNI).
    - **Polivalentes/multivaluados:** varios valores por instancia (ej. Teléfonos).
2. **Cardinalidad de atributos:**
    
    - **Mínima:** número mínimo de valores que debe tener (0 o 1, aunque puede ser >1 en casos especiales).
    - **Máxima:** número máximo de valores (1 o N).
    - Ejemplo: atributo Teléfono con cardinalidad (1,3) → al menos 1 número, máximo 3 (casa, móvil, oficina).
3. **Atributos derivados:** valores calculados a partir de otros (ej. edad derivada de fecha de nacimiento).
    
4. **Atributos en relaciones:** también pueden existir, típicos en relaciones históricas (ej. fecha de emisión de una factura).
    

💡 _Ejemplo práctico:_

```text
Entidad EMPLEADO
- DNI (obligatorio, simple, monovalente)
- Dirección (compuesto: calle, número, ciudad)
- Teléfono (multivaluado, cardinalidad (1,3))
- Edad (derivado de fechaNacimiento)
```

---

## 5. Calidad de un diagrama E/R

- El diseño de un diagrama ER es **subjetivo**: puede haber varias formas de modelar un mismo problema.
- No todas las representaciones son correctas: un mal diseño puede generar **redundancia** y **anomalías** en inserciones, borrados y actualizaciones.
- Se recomienda aplicar **normalización** para evitar redundancia.
- Existen muchas notaciones distintas para diagramas ER; lo importante es mantener la **coherencia interna**.

💡 _Ejemplo:_  
Un mal diseño que repite el atributo “dirección” en varias entidades genera redundancia. La solución es normalizar y crear una entidad **Dirección** relacionada con las demás.

---

## 📌 Síntesis de lo nuevo (para complementar tus apuntes anteriores)

1. El modelo ER es **conceptual y comunicativo**, útil incluso para usuarios no técnicos.
2. Las relaciones N-arias deben **reducirse a binarias** mediante entidades intermedias (ej. Contrato).
3. Las restricciones se detallan con ejemplos claros:
    - Exclusividad (una u otra).
    - Exclusión (no ambas en la misma instancia).
    - Inclusividad (si participa en una, debe participar en otra).
    - Inclusión (si participa en una, debe participar en la misma instancia de otra).
4. Los atributos se clasifican más exhaustivamente: obligatorios/opcionales, simples/compuestos, monovalentes/polivalentes, derivados, con cardinalidad mínima y máxima.
5. Los atributos también pueden pertenecer a **relaciones** (ej. fecha de emisión).
6. Criterios de calidad: evitar redundancia, aplicar normalización, mantener coherencia en notación.

---

Perfecto, José 🙌. Ahora te preparo los **apuntes completos y mejorados de la Unidad 2 – El modelo Entidad Relación (ud2_ElModeloER.pdf)**, aplicando todas las características que me pediste:

- **Formato Markdown para Obsidian** (títulos, listas, tablas, ejemplos en bloques de código).
- **Claridad y exhaustividad** (explicaciones completas, sin huecos).
- **Orientados a principiantes** (lenguaje sencillo, ejemplos prácticos).
- **Visualmente atractivos** (estructurados, fáciles de repasar).
- **Complementarios** (incluyendo lo nuevo que aporta este PDF).

---


# 📚 TEMA 3 – Modelo Relacional

---

## 1. Objetivo del modelo relacional

- Proteger al usuario de conocer las estructuras físicas de almacenamiento.
- El usuario ve la BD como una **colección de relaciones (tablas)**.
- Independiente de cómo se almacenen los datos.
- Se puede implementar en cualquier **SGBD relacional** y gestionar con aplicaciones gráficas.
- Tiene una fuerte base **matemática** (teoría de conjuntos y lógica).
- Es eficaz para operar con **conjuntos de datos**.

💡 _Ejemplo:_ En SQL Server o MySQL, el usuario consulta tablas con `SELECT`, sin preocuparse de cómo se guardan físicamente los registros en disco.

---

## 2. Las relaciones en el modelo relacional

### 2.1 Definición

- Una **relación** es un conjunto de atributos, cada uno con un dominio, y un nombre identificativo.
- Se representa como una **tabla** con columnas (atributos) y filas (tuplas).

### 2.2 Componentes

- **Nombre/Cabecera:** nombre de la relación.
- **Esquema:** definición de atributos y dominios.
- **Cuerpo/Estado:** conjunto de tuplas (filas).

💡 _Ejemplo:_ Relación **ImpuestoVehículos**

```text
Vehículo | Dueño     | TeléfonoDueño | Matrícula | Cuota
---------------------------------------------------------
Seat Ibiza | Francisco | 925884721     | 9918-FTV  | 92,24
VW Polo    | Pedro     | 918773621     | 4231-FHD  | 61,98
Renault    | María     | 929883762     | 7416-GSJ  | 145,32
Fiat Punto | Ernesto   | 646553421     | 9287-BHF  | 45,77
```

---

## 3. Conceptos clave en la transformación al modelo relacional

- **Atributo:** característica que describe una entidad o relación.
- **Dominio:** conjunto de valores permitidos para un atributo (ej. enteros, cadenas).
- **Restricción semántica:** condición que deben cumplir los datos para ser válidos.
- **Clave:** conjunto de atributos que identifican de forma única una ocurrencia.

---

## 4. Tipos de restricciones

1. **De clave**
2. **Valor único (UNIQUE)**
3. **Integridad referencial (REFERENCES)**
4. **De dominio**
5. **Verificación (CHECK)**
6. **Valor nulo (NULL / NOT NULL)**
7. **Disparadores (TRIGGERS)**
8. **Genéricas o aserciones (ASSERT)**

---

## 5. Restricción de clave

- Identifica de manera única una entidad.
- Tipos:
    - **Superclave:** cualquier conjunto de atributos que identifica de forma única.
        - Ej. DNI, NºSS, o combinación DNI+Apellidos.
    - **Clave candidata:** mínima superclave.
        - Ej. DNI o NºSS.
    - **Clave primaria:** candidata elegida como identificador principal.
        - Ej. DNI.
    - **Clave foránea:** atributo que es clave en otra entidad.
        - Ej. DNI en tabla Notas referencia a tabla Alumnos.

💡 _Ejemplo SQL:_

```sql
CREATE TABLE Empleado (
  DNI CHAR(9) PRIMARY KEY,
  Nombre VARCHAR(50),
  NSS CHAR(12) UNIQUE
);

CREATE TABLE Nota (
  idNota INT PRIMARY KEY,
  DNI CHAR(9),
  FOREIGN KEY (DNI) REFERENCES Empleado(DNI)
);
```

---

## 6. Restricción de valor único (UNIQUE)

- Impide que un atributo tenga valores repetidos.
- Todas las claves primarias cumplen esta restricción.
- También puede aplicarse a atributos no clave.
    - Ej. matrícula de coche (clave) y bastidor (no clave, pero único).

💡 _Ejemplo SQL:_

```sql
CREATE TABLE Vehiculo (
  Matricula CHAR(7) PRIMARY KEY,
  Bastidor CHAR(17) UNIQUE
);
```

---

## 7. Restricción de integridad referencial

- Una tabla que referencia otra debe contener valores existentes en la tabla referenciada.
- Se aplica en **claves foráneas**.
- Evita registros huérfanos.

💡 _Ejemplo:_ No puede haber notas de un alumno que no exista en la tabla Alumnos.

```sql
ALTER TABLE Nota
ADD CONSTRAINT fk_alumno
FOREIGN KEY (DNI) REFERENCES Alumno(DNI);
```

---

## 8. Restricción de dominio

- El valor de un atributo debe estar dentro de su dominio.
- Ejemplo: DNI debe tener 9 dígitos y una letra.

💡 _Ejemplo SQL:_

```sql
CHECK (DNI LIKE '[0-9]{8}[A-Z]')
```

---

## 9. Restricción de verificación (CHECK)

- Comprueba si un valor cumple una condición.
- Ejemplo: la letra del DNI se calcula con un algoritmo.

💡 _Ejemplo SQL:_

```sql
CHECK (Edad >= 18)
```

---

## 10. Restricción de valor obligatorio (NULL / NOT NULL)

- **NOT NULL:** atributo obligatorio.
- **NULL:** atributo opcional.

💡 _Ejemplo SQL:_

```sql
Nombre VARCHAR(50) NOT NULL,
Telefono VARCHAR(20) NULL
```

---

## 11. Disparadores (Triggers)

- Procedimientos que se ejecutan automáticamente al insertar, modificar o eliminar datos.
- Se usan para mantener integridad, auditoría o lógica de negocio.

💡 _Ejemplo SQL:_

```sql
CREATE TRIGGER trg_actualiza_saldo
AFTER INSERT ON Movimiento
FOR EACH ROW
UPDATE Cuenta SET saldo = saldo + NEW.importe
WHERE idCuenta = NEW.idCuenta;
```

---

## 12. Restricciones genéricas o aserciones (ASSERT)

- Validan condiciones complejas sobre una o varias tablas.
- Ejemplo: el salario medio de empleados no puede superar cierto límite.

💡 _Ejemplo SQL:_

```sql
CREATE ASSERTION salario_maximo
CHECK (NOT EXISTS (
  SELECT * FROM Empleado
  GROUP BY Departamento
  HAVING AVG(Salario) > 5000
));
```

---

## 📌 Síntesis final

1. El modelo relacional protege al usuario de detalles físicos y se basa en **tablas (relaciones)**.
2. Conceptos clave: atributos, dominios, claves, restricciones semánticas.
3. Tipos de restricciones: clave, UNIQUE, integridad referencial, dominio, CHECK, NULL/NOT NULL, triggers, aserciones.
4. Cada restricción asegura **integridad, consistencia y validez** de los datos.
5. SQL implementa estas restricciones mediante **PRIMARY KEY, FOREIGN KEY, UNIQUE, CHECK, NOT NULL, TRIGGERS y ASSERTIONS**.

---
# 📚 TEMA 4 – Transformación del modelo E/R al modelo Relacional

---

## 1. Objetivo

- Convertir el **modelo conceptual (Chen)** en el **modelo lógico relacional (Codd)**.
- Se aplican **reglas de transformación** para pasar de entidades, atributos y relaciones a tablas, claves y restricciones.

---

## 2. Transformación de entidades

### 2.1 Entidades fuertes

- Cada entidad fuerte → una tabla con sus atributos.
- La **clave primaria** de la tabla corresponde a la clave de la entidad.

💡 _Ejemplo:_  

![[Pasted image 20251215232254.png]]

Entidad **Categoría** → Tabla **CATEGORIAS(Codigo, Descripcion)**  
Entidad **Producto** → Tabla **PRODUCTOS(Id, Nombre, Precio, Descripcion, Codigo)**

- `Codigo` en PRODUCTOS es clave foránea que referencia a CATEGORIAS.

---

### 2.2 Entidades débiles

#### Dependencia de existencia

- Tabla de la entidad débil incluye sus atributos + clave de la entidad fuerte como **clave ajena**.
- La clave primaria es la propia de la entidad débil.

💡 _Ejemplo:_

![[Pasted image 20251215232308.png]]

```text
CUENTAS_BANCARIAS(NºCuenta, Saldo)
TRANSACCIONES(Codigo, Tipo, Cantidad, NºCuenta)
```

#### Dependencia de identificación

- La clave primaria de la entidad débil = clave propia + clave de la entidad fuerte.
- Ambas forman la clave compuesta.

💡 _Ejemplo:_

```text
TRANSACCIONES(Codigo, Tipo, Cantidad, NºCuenta)
```

==Clave primaria: (Codigo, NºCuenta).==

---

## 3. Transformación de relaciones

### Regla general

- Cada relación → tabla.
- La tabla incluye:
    - Claves de las entidades relacionadas (como claves ajenas).
    - Atributos propios de la relación.
- La clave primaria suele ser la combinación de las claves ajenas.

---

### 3.1 Relaciones N:M

- Se crea una tabla intermedia con las claves de ambas entidades + atributos de la relación.

💡 _Ejemplo:_

![[Pasted image 20251215232612.png]]

```text
CLIENTES(codCliente, nombre, apellidos)
PRODUCTOS(codProducto, nombre, precio)
COMPRAS(codCliente, codProducto, cantidad)
```

---

### 3.2 Relaciones 1:N

- La clave de la entidad del lado 1 se **propaga** a la entidad del lado N como clave ajena.
- Si la participación mínima es 0, la clave ajena admite NULL.
- Si la participación mínima es 1, la clave ajena es NOT NULL.

💡 _Ejemplo:_

![[Pasted image 20251215232644.png]]

```text
VENDEDORES(codVendedor, nombre, apellidos)
CLIENTES(codCliente, nombre, apellidos, codVendedor)
```

---

### 3.3 Relaciones 1:1

- Se puede:
    1. Generar una única tabla con todos los atributos de ambas entidades.
    2. O mantener dos tablas y propagar la clave de una como ajena en la otra.
- Si una de las cardinalidades mínimas es 0 → mejor mantener dos tablas para evitar muchos valores nulos.

💡 _Ejemplo:_

![[Pasted image 20251215232756.png]]

```text
ACTORES(codActor, nombre)
PERSONAJES(codPersonaje, nombre, codActor)
```

---

### 3.4 Relaciones reflexivas

- Se tratan igual que las demás, pero la misma clave aparece dos veces en la tabla (con distinto rol).
- Si la relación necesita atributos adicionales (ej. fecha), se crea una tabla específica para la relación.

💡 _Ejemplo:_

![[Pasted image 20251215232815.png]]

```text
EMPLEADOS(DNI, Nombre, DNISupervisor)
```

Relación reflexiva 1:N (Empleado es jefe de otro Empleado).

---

### 3.5 Relaciones de orden N (ternarias o superiores)

- Se crea una tabla con las claves de todas las entidades participantes + atributos de la relación.

💡 _Ejemplo ternaria:_

![[Pasted image 20251215232833.png]]

```text
ESTUDIANTES(est, ...)
ASIGNATURAS(asig, ...)
SEMESTRES(sem, ...)
TIENE_NOTAS(est, asig, sem, calificacion)
```

---

## 4. Participaciones

- **(0,n):** clave ajena opcional → atributo admite NULL.
- **(1,n):** clave ajena obligatoria → atributo con restricción NOT NULL.

---

## 5. Transformación de jerarquías (superclase/subclase)

Existen **4 opciones** según el tipo de especialización (exclusiva/inclusiva, total/parcial):

1. Transformación de jerarquías 1
    
    - Cada subclase hereda la clave de la superclase.
    - Útil cuando los subtipos tienen muchos atributos distintos.
    - Ejemplo:
        ![[Pasted image 20251215234040.png]]
        ```text
        EMPLEADOS(DNI, Nombre)
        DIRECTIVOS(DNI, Dpto)
        TECNICOS(DNI, Maquinas)
        COMERCIALES(DNI, Comision)
        ```
        
2. Transformación de jerarquías 2
    
    - Ejemplo:
        ![[Pasted image 20251215234107.png]]
        ```text
        DIRECTIVOS(DNI, Nombre, Dpto)
        TECNICOS(DNI, Nombre, Maquinas)
        COMERCIALES(DNI, Nombre, Comision)
        ```
        
3. Transformación de jerarquías 3
    
    - Adecuado para especializaciones **exclusivas**.
    - Ejemplo:
        ![[Pasted image 20251215234117.png]]
        ```text
        EMPLEADOS(DNI, Nombre, Dpto, Maquinas, Comision, Tipo)
        ```
        
4. Transformación de jerarquías 4
    
    - Adecuado para especializaciones **inclusivas**.
    - Ejemplo:
        ![[Pasted image 20251215234130.png]]
        ```text
        EMPLEADOS(DNI, Nombre, Dpto, Maquinas, Comision, EsDirectivo, EsTecnico, EsComercial)
        ```
        

---

## 6. Notación y restricciones adicionales

- **Integridad referencial:** flechas entre claves propagadas.
- **Restricciones de borrado/modificación:**
    - B:C → borrado en cascada.
    - B:R → borrado restringido.
    - B:N → borrado con puesta a NULL.
    - B:D → borrado con valor por defecto.
    - M:C → modificación en cascada.
    - M:R → modificación restringida.
    - M:N → modificación con puesta a NULL.
    - M:D → modificación con valor por defecto.
- **NOT NULL:** atributo obligatorio → marcado con NN.
- **CHECK:** restricciones de dominio reflejadas en tabla de especificaciones.

---

## 📌 Síntesis final

1. La transformación E/R → Relacional convierte entidades y relaciones en **tablas con claves y restricciones**.
2. **Entidades fuertes:** tabla propia con clave primaria.
3. **Entidades débiles:** tabla con clave propia + clave ajena de la fuerte; si hay identificación, clave compuesta.
4. **Relaciones:**
    - N:M → tabla intermedia.
    - 1:N → propagación de clave.
    - 1:1 → tabla única o dos tablas según cardinalidad mínima.
    - Reflexivas → clave repetida con roles.
    - N-arias → tabla con todas las claves.
5. **Jerarquías:** cuatro opciones según especialización (superclase + subclases, solo subclases, tabla única con tipo, tabla única con booleanos).
6. **Restricciones adicionales:** integridad referencial, borrado/modificación, NOT NULL, CHECK.

---
# 📚 TEMA 5 – Normalización de Bases de Datos

---

## 1. Calidad del diseño

- Aunque el paso del modelo E/R al relacional se haga siguiendo reglas, las tablas pueden presentar problemas:
    - **Restricciones mal representadas** entre atributos de distintas tablas.
    - **Redundancia** y **anomalías** en operaciones.
- La calidad de una BD se mide por su **grado de normalización**.
- Si no cumple criterios, se deben hacer **refinamientos sucesivos** hasta alcanzar el nivel deseado.

💡 _Idea clave:_ La normalización es un proceso de mejora continua del diseño.

---

## 2. Dependencias

- Cada forma normal impone restricciones sobre los atributos.
- Estas restricciones se llaman **dependencias**.
- Estudiarlas permite alcanzar un nivel aceptable de normalización.

---

## 3. Dependencia funcional

- **Definición:** Y depende funcionalmente de X (X → Y) si cada valor de X determina un único valor de Y.
- X = determinante, Y = implicado.
- Ejemplo:

```text
FechaNacimiento → Edad
```

---

## 4. Utilidad de las dependencias funcionales

- Son **restricciones de integridad** sobre los datos.
- Ayudan a:
    - Evitar redundancia.
    - Mejorar eficiencia y organización.
- Detectar dependencias puede indicar un **mal diseño**.

💡 _Ejemplo:_

```text
PELICULAS(título, fecha_rodaje, estudio, presidente, email_presidente)

Dependencias:
estudio, fecha_rodaje → presidente
presidente → email_presidente
```

👉 Mal diseño: deberían existir entidades separadas para PELICULAS, ESTUDIOS y PRESIDENTES.

---

## 5. Tipos de dependencias funcionales

- **Completa (X ⇒ Y):** Y depende de todo el conjunto X, no de un subconjunto.
    - Ejemplo: (CodProducto, CodProveedor) ⇒ FechaCompra.
- **Parcial:** Y depende solo de parte de la clave compuesta.
- **Transitiva:** X → Y y Y → Z ⇒ X → Z.
    - Ejemplo: FechaNacimiento → Edad, Edad → Conducir ⇒ FechaNacimiento → Conducir.
- **Elemental:** Y es un único atributo.
- **Trivial:** Y es subconjunto de X. Ejemplo: (DNI, Nombre) → DNI.

---

## 6. Normalización

- **Definición:** proceso de obligar a los atributos a cumplir ciertas formas normales.
- **Objetivos:**
    - Evitar redundancia.
    - Evitar anomalías en inserciones, modificaciones y borrados.
    - Mejorar independencia de los datos.
    - No imponer restricciones artificiales.

---

## 7. Proceso de normalización

- Se comprueba que cada tabla cumpla reglas basadas en clave primaria y dependencias funcionales.
- Si no cumple, se descompone en varias tablas.
- Existen **6 formas normales**:
    - 1FN, 2FN, 3FN, FNBC, 4FN, 5FN, 6FN.
- El modelo relacional exige **1FN obligatoria**.
- Se recomienda llegar al menos a **3FN**.

---

## 8. Primera Forma Normal (1FN)

- Requisitos:
    - Atributos atómicos (sin multivalores).
    - Clave primaria única y sin nulos.
    - Número fijo de columnas.
    - Independencia del orden de filas y columnas.
- Ejemplo de tabla que **no cumple 1FN**:

![[Pasted image 20251216000007.png]]

### Cómo conseguir 1FN

1. Repetir atributos multivaluados en varias filas.
2. Separar atributos multivaluados en otra tabla.

💡 _Ejemplo:_

![[Pasted image 20251216000053.png]]

```text
ALUMNOS(CodAlumno, Nombre, Apellido, Dirección)
TELEFONOS(CodAlumno, Tfno)
```

---

## 9. Segunda Forma Normal (2FN)

- Requisitos:
    - Cumplir 1FN.
    - Todos los atributos no clave dependen **completamente** de la clave primaria.
- Solo se aplica si la clave es compuesta.
- Problema: dependencias parciales → redundancias.

💡 _Ejemplo:_

```text
CALIFICACIONES(CodAlumno, Asignatura, Nota, NombreAlumno, Curso)
Dependencias parciales:
CodAlumno → NombreAlumno
Asignatura → Curso
```

👉 Solución: descomponer en ALUMNOS, ASIGNATURAS y CALIFICACIONES.

---

## 10. Tercera Forma Normal (3FN)

- Requisitos:
    - Cumplir 2FN.
    - No debe haber dependencias transitivas entre atributos no clave.
- Problema: atributos dependen de otros no clave.

💡 _Ejemplo:_

```text
LIBROS(CodLibro, Título, Editorial, País)
Dependencias:
CodLibro → Editorial
Editorial → País
⇒ CodLibro → País (transitiva)
```

👉 Solución: separar en LIBROS y EDITORIALES.

---

## 11. Otras formas normales

- **FNBC (Boyce-Codd):** más estricta que 3FN.
- **4FN y 5FN:** tratan dependencias multivaluadas.
- **FNDK:** restricciones de dominio y clave.
- **6FN:** bases de datos temporales.

---

## 12. Desnormalización

- Cada nivel superior implica más **joins** → puede ralentizar consultas.
- A veces se **desnormaliza** para mejorar rendimiento.
- Desnormalizar = bajar el nivel de normalización, aceptando más redundancia a cambio de velocidad.

---

## 13. Tabla comparativa de formas normales

| Forma Normal | Requisitos principales                                     | Ejemplo de problema que evita          |
| ------------ | ---------------------------------------------------------- | -------------------------------------- |
| **1FN**      | Atributos atómicos, clave primaria única, sin multivalores | Teléfonos en una sola celda            |
| **2FN**      | Cumplir 1FN + eliminar dependencias parciales              | NombreAlumno depende solo de CodAlumno |
| **3FN**      | Cumplir 2FN + eliminar dependencias transitivas            | País depende de Editorial              |
| **FNBC**     | Más estricta que 3FN, elimina anomalías restantes          | Casos especiales de claves             |
| **4FN**      | Elimina dependencias multivaluadas                         | Atributos con listas múltiples         |
| **5FN**      | Elimina redundancias en descomposición de relaciones       | Relaciones complejas N-arias           |
| **6FN**      | Bases de datos temporales                                  | Datos con validez temporal             |


---

## 📌 Síntesis final de la Unidad 2 – Normalización

1. La normalización es esencial para garantizar la **calidad del diseño** de una BD.
2. Se basa en **dependencias funcionales** (completas, parciales, transitivas, elementales, triviales).
3. **1FN:** atributos atómicos y clave primaria única.
4. **2FN:** eliminar dependencias parciales.
5. **3FN:** eliminar dependencias transitivas.
6. Formas superiores (FNBC, 4FN, 5FN, 6FN) tratan casos más complejos.
7. La **desnormalización** puede ser necesaria para mejorar rendimiento, aunque aumenta redundancia.

---
#  Apuntes complementarios – TEMA 5: Normalización (refuerzo y ejemplos)

---

## 1. Problemas del esquema relacional (ejemplos prácticos)

- **Redundancia excesiva:** datos repetidos en múltiples filas → síntoma claro de mal diseño.
- **Ambigüedad:** registros que no identifican claramente a qué ejemplar se refieren.
- **Pérdida de integridad:** dependencias funcionales mal representadas → errores en relaciones.
- **Anomalías en operaciones:**
    - Inserción: necesidad de duplicar tuplas.
    - Borrado: eliminar un elemento implica borrar varias filas relacionadas.
    - Actualización: inconsistencias al modificar datos repetidos.

💡 _Complemento:_ Aquí se insiste en que **cada fila debe representar inequívocamente un elemento reconocible**. Si no, el diseño es incorrecto.

---

## 2. Formas normales – visión ampliada

- Las formas normales fueron definidas por **Codd (1970)** y ampliadas por **Boyce y Fagin**.
- Cada forma normal es más restrictiva que la anterior:
    - Una tabla puede estar en 1FN pero no en 2FN.
    - Nunca al revés.
- Existe debate:
    - Muchos diseñadores consideran suficiente llegar a **Boyce-Codd (FNBC)**.
    - La 4FN y 5FN son más polémicas; algunos opinan que pueden complicar más de lo que ayudan.

💡 _Complemento:_ Este PDF aporta la **visión crítica** de que no siempre más normalización = mejor diseño.

---

## 3. Primera Forma Normal (1FN) – ejemplos adicionales

- Ejemplo de tabla **TRABAJADOR** con multivalores en “Departamento”.
- Solución: dividir en dos tablas:
    - **TRABAJADOR(DNI, Nombre)**
    - **DEPARTAMENTOS(DNI, Departamento)**

💡 _Complemento:_ Se explica el **proceso paso a paso** para pasar a 1FN:

1. Localizar atributos clave.
2. Descomponer en dos proyecciones:
    - Clave + atributos únicos.
    - Clave + atributos multivaluados.

---

## 4. Ejemplo extendido de 1FN

- Tabla con **TRABAJADOR** que incluye títulos múltiples (“Magisterio, ATS”).
- Solución: separar en dos tablas:
    - **TRABAJADOR(Numero, Nombre, Categoría, Salario)**
    - **MATERIALES(Num, Título)**
![[Pasted image 20251216000503.png]]

![[Pasted image 20251216000620.png]]

💡 _Complemento:_ Se muestra cómo **atributos multivaluados como “Medidas”** deben convertirse en filas independientes en una tabla aparte (**MAT-MED**).

---

## 5. Dependencias funcionales – ejemplos más ricos

- **Dependencia funcional completa:**
    - (DNI, Empresa) → Sueldo (depende de ambos).
    - (DNI, Empresa) → Nombre no es completa, porque Nombre depende solo de DNI.
- **Dependencia transitiva:**
    - Grupo → Tutor, Tutor → Departamento ⇒ Grupo → Departamento.

💡 _Complemento:_ Aquí se aportan ejemplos más **realistas y detallados** (profesor, grupo, departamento).

---

## 6. Segunda Forma Normal (2FN) – ejemplo ampliado

- Tabla **ALUMNOS(DNI, CodCurso, Nombre, Apellido, Nota)**.

![[Pasted image 20251216000649.png]]

- Problema:
    - Nombre y Apellido dependen solo de DNI.
    - Nota depende de (DNI, CodCurso).
- Solución:
    - **ASISTENCIA(DNI, CodCurso, Nota)**
    - **ALUMNOS(DNI, Nombre, Apellido)**

![[Pasted image 20251216000710.png]]

![[Pasted image 20251216000725.png]]

💡 _Complemento:_ Se explica el proceso paso a paso para separar atributos que no dependen de toda la clave compuesta.

---

## 7. Tercera Forma Normal (3FN) – ejemplo ampliado

- Tabla **ALUMNOS(DNI, Nombre, Apellido, CodProvincia, Provincia)**.

![[Pasted image 20251216000750.png]]

- Problema: Provincia depende de CodProvincia (dependencia transitiva).
- Solución:
    - **ALUMNOS(DNI, Nombre, Apellido, CodProvincia)**
    - **PROVINCIAS(CodProvincia, Provincia)**

![[Pasted image 20251216000804.png]]


💡 _Complemento:_ Ejemplo claro de cómo eliminar dependencias transitivas creando una tabla nueva.

---

## 📌 Síntesis de lo nuevo (para complementar tus apuntes anteriores)

1. Se detallan **problemas del esquema relacional** con ejemplos prácticos (redundancia, ambigüedad, anomalías).
2. Se aporta una **visión crítica**: no siempre más formas normales = mejor diseño; FNBC suele ser suficiente.
3. Ejemplos extendidos de **1FN**: cómo dividir tablas con atributos multivaluados (Departamentos, Títulos, Medidas).
4. Ejemplos más ricos de **dependencias funcionales completas y transitivas** (profesor-grupo-departamento).
5. Ejemplo detallado de **2FN**: separación de ALUMNOS y ASISTENCIA.
6. Ejemplo detallado de **3FN**: separación de ALUMNOS y PROVINCIAS.

---
