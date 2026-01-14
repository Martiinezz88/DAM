
# 📚 Ejercicios de DDL – Mini Campus

---

## 1️⃣ Registro mínimo de empleados de conserjería

**Enunciado:** Crear tabla `EMP_CONSERJE` con `ID (NUMBER)` y `NOMBRE (VARCHAR2(50))`.

```sql
CREATE TABLE emp_conserje (
  id NUMBER,
  nombre VARCHAR2(50)
);
```

**Explicación:**  
Tabla básica sin restricciones, útil para practicar la sintaxis mínima de `CREATE TABLE`.

---

## 2️⃣ Departamentos con clave primaria

**Enunciado:** Crear `DEPARTAMENTO` con `DEP_ID (NUMBER, PK)` y `NOMBRE (VARCHAR2(40))`.

```SQL
CREATE TABLE departamento (
  dep_id NUMBER PRIMARY KEY,
  nombre VARCHAR2(40)
);
```

**Explicación:**  
La PK se define inline sobre la columna, garantizando unicidad y `NOT NULL`.

---

## 3️⃣ Catálogo de cursos con PK nombrada

**Enunciado:** Crear `CURSO` con `ID (NUMBER)`, `TITULO (VARCHAR2(100) NOT NULL)` y PK `PK_CURSO`.

```sql
CREATE TABLE curso (
  id NUMBER,
  titulo VARCHAR2(100) NOT NULL,
  CONSTRAINT pk_curso PRIMARY KEY (id)
);
```

**Explicación:**  
La PK se define como constraint de tabla con nombre explícito, lo que facilita su gestión.

---

## 4️⃣ Alumnado con estado activo por defecto

**Enunciado:** Crear `ALUMNO` con `ID (NUMBER PK)`, `NOMBRE (VARCHAR2(60))`, `ACTIVO (CHAR(1) DEFAULT 'S')`.

```sql
CREATE TABLE alumno (
  id NUMBER CONSTRAINT pk_alumno PRIMARY KEY,
  nombre VARCHAR2(60),
  activo CHAR(1) DEFAULT 'S'
);
```

**Explicación:**  
El valor por defecto `'S'` se aplica automáticamente si no se indica al insertar.

---

## 5️⃣ Notas con rango válido

**Enunciado:** Crear `NOTA` con `ID (NUMBER PK)` y `VALOR (NUMBER(3,1))` entre 0 y 10.

```sql
CREATE TABLE nota (
  id NUMBER CONSTRAINT pk_nota PRIMARY KEY,
  valor NUMBER(3,1),
  CONSTRAINT chk_nota_valor CHECK (valor BETWEEN 0 AND 10)
);
```

**Explicación:**  
La `CHECK` asegura integridad de dominio, rechazando valores fuera del rango.

---

## 🔗 Relaciones y ajustes al modelo

---

## 6️⃣ Matriculaciones entre alumnado y cursos

**Enunciado:** Crear `MATRICULA` con PK `ID`, y FKs a `ALUMNO(ID)` y `CURSO(ID)`.

```sql
CREATE TABLE matricula (
  id NUMBER CONSTRAINT pk_matricula PRIMARY KEY,
  alumno_id NUMBER,
  curso_id NUMBER,
  CONSTRAINT fk_matr_alumno FOREIGN KEY (alumno_id) REFERENCES alumno(id),
  CONSTRAINT fk_matr_curso FOREIGN KEY (curso_id) REFERENCES curso(id)
);
```

**Explicación:**  
Las FKs aseguran integridad referencial: no existen matrículas huérfanas.

---

## 7️⃣ Fecha de alta de alumnos

```sql
ALTER TABLE alumno 
ADD fecha_alta DATE;
```

**Explicación:**  
Las filas existentes tendrán la nueva columna como `NULL` hasta actualizarse.

---

## 8️⃣ Nombres de alumnos más largos

```sql
ALTER TABLE alumno 
MODIFY nombre VARCHAR2(100);
```

**Explicación:**  
Se aumenta la longitud de la columna, operación compatible y típica.

---

## 9️⃣ Retirar la marca de activo/inactivo

```sql
ALTER TABLE alumno 
DROP COLUMN activo;
```

**Explicación:**  
Se elimina un atributo obsoleto tras cambios en la lógica de negocio.

---

## 🔟 Nombres de departamento únicos

```sql
ALTER TABLE departamento
ADD CONSTRAINT uk_dep_nombre UNIQUE (nombre);
```

**Explicación:**  
La `UNIQUE` impide duplicados y crea un índice único interno.

---

## ⚡ Rendimiento y mantenimiento

---

## 1️⃣1️⃣ Índice en matrículas por alumno

```sql
CREATE INDEX idx_matr_alumno 
ON matricula (alumno_id);
```

**Explicación:**  
El índice acelera consultas frecuentes por `alumno_id`.

---

## 1️⃣2️⃣ Retirar índice redundante

```sql
DROP INDEX idx_matr_alumno;
```

**Explicación:**  
Se eliminan estructuras innecesarias para ahorrar espacio y mantenimiento.

---

## 1️⃣3️⃣ Vaciar matrículas al final del curso

```sql
TRUNCATE TABLE matricula;
```

**Explicación:**  
Elimina todas las filas rápidamente, manteniendo la estructura.

---

## 1️⃣4️⃣ Renombrar tabla de empleados antiguos

```sql
RENAME emp_conserje TO emp_conserje_hist;
```

**Explicación:**  
Solo cambia el nombre lógico, sin afectar datos ni estructura.

---

## 1️⃣5️⃣ Eliminar tabla histórica

```sql
DROP TABLE emp_conserje_hist;
```

**Explicación:**  
Elimina datos y metadatos asociados de forma definitiva.

---
## 1️⃣6️⃣ Formalizar la PK de departamento a posteriori

**Enunciado:** Añadir una PK llamada `PK_DEP` sobre `DEP_ID` en `DEPARTAMENTO`.

```sql
ALTER TABLE departamento
ADD CONSTRAINT pk_dep PRIMARY KEY (dep_id);
```

**Explicación:**  
Se convierte `DEP_ID` en identificador oficial. Oracle comprobará que no haya nulos ni duplicados antes de crear la restricción.

---

## 1️⃣7️⃣ Retirar la unicidad de nombre de departamento

**Enunciado:** Eliminar la constraint `UK_DEP_NOMBRE` de `DEPARTAMENTO`.

```sql
ALTER TABLE departamento
DROP CONSTRAINT uk_dep_nombre;
```

**Explicación:**  
Se elimina la regla de unicidad, permitiendo nombres duplicados. Es la forma recomendada para modificar reglas de integridad.

---

## 1️⃣8️⃣ Crear una copia de trabajo de alumnos

**Enunciado:** Crear `ALUMNO_TEST` copiando estructura y datos desde `ALUMNO`.

```sql
CREATE TABLE alumno_test AS
SELECT * FROM alumno;
```

**Explicación:**  
`CREATE TABLE ... AS SELECT` (CTAS) genera una nueva tabla con columnas y datos del `SELECT`, pero sin copiar restricciones ni índices.

---

## 1️⃣9️⃣ Profesores con fecha de alta automática

**Enunciado:** Crear `PROFESOR` con `ID (NUMBER PK)`, `NOMBRE (VARCHAR2(80) NOT NULL)` y `FECHA_ALTA (DATE DEFAULT SYSDATE)`.

```sql
CREATE TABLE profesor (
  id NUMBER CONSTRAINT pk_profesor PRIMARY KEY,
  nombre VARCHAR2(80) NOT NULL,
  fecha_alta DATE DEFAULT SYSDATE
);
```

**Explicación:**  
`DEFAULT SYSDATE` captura la fecha y hora del servidor en el momento de la inserción, automatizando la trazabilidad.

---

## 2️⃣0️⃣ Asignar profesor responsable a cada curso

**Enunciado:** Añadir a `CURSO` la columna `PROF_ID` y una FK `FK_CURSO_PROF` que referencia `PROFESOR(ID)`.

```sql
ALTER TABLE curso
ADD prof_id NUMBER;

ALTER TABLE curso
ADD CONSTRAINT fk_curso_prof
FOREIGN KEY (prof_id) REFERENCES profesor(id);
```

**Explicación:**  
Primero se incorpora la columna y luego se define la FK, asegurando que solo se asignen cursos a profesores existentes.

## 2️⃣1️⃣ Borrar la tabla completa 

```sql
DROP TABLE matricula;
```

**Explicación:**
Borra la tabla completa, su información columnas y también sus componentes 

---


# 📚 Ejercicios de DDL – Problemas con integridad referencial

---

## 1️⃣ Instituto: departamentos, profesores y grupos

**Enunciado** 
Un instituto quiere que, si un departamento se elimina (por una reestructuración), se
borren automáticamente todos los profesores asociados, y al borrar un profesor se borren
a su vez todos los grupos de los que era tutor. Se necesita:

- DEPARTAMENTO: departamentos del centro

- PROFESOR: profesorado, asignado a un departamento.

- GRUPO: grupos de alumnos; opcionalmente, cada grupo tiene un profesor tutor.

**Tablas necesarias:**

- `DEPARTAMENTO`:
    - `PK DEP_ID`
    - `NOMBRE` único

- `PROFESOR`:
    - `PK PROF_ID`
    - `FK DEP_ID` → `DEPARTAMENTO(DEP_ID)` con `ON DELETE CASCADE`

- `GRUPO`:
    - `PK GRUPO_ID`
    - `CODIGO` único
    - `FK TUTOR_ID` → `PROFESOR(PROF_ID)` con `ON DELETE CASCADE`

```sql
CREATE TABLE departamento (
  dep_id NUMBER CONSTRAINT pk_departamento PRIMARY KEY,
  nombre VARCHAR2(100) NOT NULL,
  CONSTRAINT uk_departamento_nombre UNIQUE (nombre)
);

CREATE TABLE profesor (
  prof_id NUMBER CONSTRAINT pk_profesor PRIMARY KEY,
  nombre VARCHAR2(100) NOT NULL,
  dep_id NUMBER NOT NULL,
  CONSTRAINT fk_prof_dep FOREIGN KEY (dep_id)
    REFERENCES departamento(dep_id)
    ON DELETE CASCADE
);

CREATE TABLE grupo (
  grupo_id NUMBER CONSTRAINT pk_grupo PRIMARY KEY,
  codigo VARCHAR2(20) NOT NULL,
  tutor_id NUMBER,
  CONSTRAINT uk_grupo_codigo UNIQUE (codigo),
  CONSTRAINT fk_grupo_tutor FOREIGN KEY (tutor_id)
    REFERENCES profesor(prof_id)
    ON DELETE CASCADE
);
```

**Explicación:**  
Se construye una cadena de borrados en cascada: eliminar un departamento borra sus profesores, y al eliminar un profesor se borran los grupos de los que era tutor.

---

## 2️⃣ Biblioteca: libros, ejemplares y préstamos


**Enunciado**
La biblioteca del centro quiere un modelo donde:

- Si se elimina un libro del catálogo, se eliminen automáticamente todos sus
ejemplares físicos.

- Si se elimina un ejemplar concreto (porque se pierde o se da de baja), se eliminen
también todos los préstamos asociados a ese ejemplar.

**Tablas necesarias:**

- `LIBRO`:
    - `PK LIBRO_ID`
    - `CHECK` año de publicación válido (1900–2100)

- `EJEMPLAR`:
    - `PK EJEMPLAR_ID`
    - `FK LIBRO_ID` → `LIBRO(LIBRO_ID)` con `ON DELETE CASCADE`
    - `CODIGO_BARRA` único

- `PRESTAMO`:
    - `PK PRESTAMO_ID`
    - `FK EJEMPLAR_ID` → `EJEMPLAR(EJEMPLAR_ID)` con `ON DELETE CASCADE`

```sql
CREATE TABLE libro (
  libro_id NUMBER CONSTRAINT pk_libro PRIMARY KEY,
  titulo VARCHAR2(200) NOT NULL,
  anio_publicacion NUMBER(4),
  CONSTRAINT chk_libro_anio CHECK (anio_publicacion BETWEEN 1900 AND 2100)
);

CREATE TABLE ejemplar (
  ejemplar_id NUMBER CONSTRAINT pk_ejemplar PRIMARY KEY,
  libro_id NUMBER NOT NULL,
  codigo_barra VARCHAR2(50) NOT NULL,
  estado VARCHAR2(20) NOT NULL,
  CONSTRAINT uk_ejemplar_cod UNIQUE (codigo_barra),
  CONSTRAINT fk_ejemplar_libro FOREIGN KEY (libro_id)
    REFERENCES libro(libro_id)
    ON DELETE CASCADE
);

CREATE TABLE prestamo (
  prestamo_id NUMBER CONSTRAINT pk_prestamo PRIMARY KEY,
  ejemplar_id NUMBER NOT NULL,
  alumno_id NUMBER NOT NULL,
  fecha_inicio DATE NOT NULL,
  fecha_fin DATE,
  CONSTRAINT fk_prestamo_ejemplar FOREIGN KEY (ejemplar_id)
    REFERENCES ejemplar(ejemplar_id)
    ON DELETE CASCADE
);
```

**Explicación:**  
Modelo jerárquico con cascada en cada nivel: `LIBRO → EJEMPLAR → PRESTAMO`. Se evita tener registros huérfanos.

---

## 3️⃣ Plataforma de cursos online: cursos, ediciones y matrículas

**Enunciado**
Una plataforma de formación online para el profesorado del centro quiere que:

-  Cada curso tiene múltiples ediciones (por ejemplo, “Gestión de aula digital” edición
enero, marzo…). 

- Cada edición tiene muchas matrículas de usuarios.
- 
- Si se elimina un curso, deben eliminarse todas sus ediciones y, con ellas, todas las
matrículas asociadas.

- Si se elimina una edición concreta (por decisión pedagógica), deben borrarse
también todas las matrículas de esa edición.

**Tablas necesarias:**

- `CURSO_FORM`:
    - `PK CURSO_ID`
    - `CHECK` horas > 0

- `EDICION_CURSO`:
    - `PK EDICION_ID`
    - `FK CURSO_ID` → `CURSO_FORM(CURSO_ID)` con `ON DELETE CASCADE`
    - `CHECK` fechas válidas (`fecha_fin >= fecha_ini`)

- `USUARIO_FORM`:
    - `PK USR_ID`
    - `EMAIL` único

- `MATRICULA_FORM`:
    - `PK MATR_ID`
    - `FK EDICION_ID` → `EDICION_CURSO(EDICION_ID)` con `ON DELETE CASCADE`
    - `FK USR_ID` → `USUARIO_FORM(USR_ID)` (sin cascada)

```sql
CREATE TABLE curso_form (
  curso_id NUMBER CONSTRAINT pk_curso_form PRIMARY KEY,
  nombre VARCHAR2(150) NOT NULL,
  descripcion VARCHAR2(500),
  horas NUMBER(4,1),
  CONSTRAINT chk_curso_form_horas CHECK (horas > 0)
);

CREATE TABLE edicion_curso (
  edicion_id NUMBER CONSTRAINT pk_edicion_curso PRIMARY KEY,
  curso_id NUMBER NOT NULL,
  fecha_ini DATE NOT NULL,
  fecha_fin DATE,
  CONSTRAINT fk_edicion_curso_curso FOREIGN KEY (curso_id)
    REFERENCES curso_form(curso_id)
    ON DELETE CASCADE,
  CONSTRAINT chk_edicion_fechas CHECK (fecha_fin IS NULL OR fecha_fin >= fecha_ini)
);

CREATE TABLE usuario_form (
  usr_id NUMBER CONSTRAINT pk_usuario_form PRIMARY KEY,
  nombre VARCHAR2(100) NOT NULL,
  email VARCHAR2(200) NOT NULL,
  CONSTRAINT uk_usuario_form_email UNIQUE (email)
);

CREATE TABLE matricula_form (
  matr_id NUMBER CONSTRAINT pk_matricula_form PRIMARY KEY,
  edicion_id NUMBER NOT NULL,
  usr_id NUMBER NOT NULL,
  fecha_mat DATE DEFAULT SYSDATE,
  CONSTRAINT fk_matr_form_edicion FOREIGN KEY (edicion_id)
    REFERENCES edicion_curso(edicion_id)
    ON DELETE CASCADE,
  CONSTRAINT fk_matr_form_usr FOREIGN KEY (usr_id)
    REFERENCES usuario_form(usr_id)
);
```

**Explicación:**  
Se aplica cascada en el eje `CURSO → EDICION → MATRICULA`. La FK hacia `USUARIO_FORM` no lleva cascada para que la política de borrado de usuarios se gestione aparte.

---
