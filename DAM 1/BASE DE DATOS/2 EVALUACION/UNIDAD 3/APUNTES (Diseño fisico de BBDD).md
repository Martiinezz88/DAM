# 📚 TEMA 0 : Introducción a SQL y Diseño Físico

## 1. El Lenguaje SQL: Conceptos Fundamentales

SQL (Structured Query Language o Lenguaje de Consulta Estructurado) es el lenguaje estándar utilizado para interactuar con los Sistemas Gestores de Bases de Datos Relacionales (SGBDR).

### 1.1. Características de SQL

A diferencia de lenguajes de programación como Java o C:

- **Declarativo:** Se especifica **qué** se quiere obtener y no **cómo** conseguirlo.
    
- **No Procedimental:** No se necesita especificar el procedimiento paso a paso para lograr el objetivo.
    
- **Estándar con Variaciones:** Es una norma ANSI/ISO, pero los fabricantes de SGBD (Oracle, MySQL, SQL Server) suelen añadir pequeñas variaciones propias (SQL "puro" vs. implementaciones específicas).
    

### 1.2. ¿Cómo se utiliza SQL? (El Entorno de Ejecución)

SQL interactúa con la base de datos a través de una serie de elementos definidos por la normativa ANSI/ISO:

|**Componente**|**Función**|
|---|---|
|**Agente SQL**|Cualquier elemento que inicia la ejecución de las instrucciones SQL.|
|**Cliente SQL**|Software que actúa como interfaz entre el Agente SQL y el Servidor SQL. Se conecta al servidor.|
|**Servidor SQL**|Software que maneja y ejecuta la instrucción SQL sobre los datos. Es quien realmente realiza la operación y devuelve los resultados al cliente.|

Existen dos modos principales de acceso a las bases de datos:

1. **Modo Interactivo:**
    
    - Destinado a usuarios finales (avanzados u ocasionales).
        
    - Las sentencias se introducen directamente a través de un cliente (ej. MySQL Command Line Client).
        
2. **Modo Embebido:**
    
    - Destinado a programadores.
        
    - Las sentencias SQL se incrustan dentro de un **lenguaje anfitrión** (como Java, PHP, C++, etc.). El lenguaje anfitrión aporta la lógica de programación que le falta a SQL.
        
    - Se usa un precompilador y un software adaptador (driver, ej. JDBC u ODBC) para conectar la aplicación con la base de datos.
        

### 1.3. Componentes y Tipos de Sentencias SQL

Las sentencias SQL se clasifican en cuatro grandes grupos de comandos:

|**Grupo**|**Nombre (Siglas)**|**Función Principal**|**Comandos Famosos**|
|---|---|---|---|
|**Definición de Datos**|**DDL** (Data Definition Language)|Crear, modificar y borrar **estructuras** (objetos) de la base de datos. (Metadatos)|`CREATE`, `DROP`, `ALTER`, `TRUNCATE`.|
|**Manipulación de Datos**|**DML** (Data Manipulation Language)|Operar con los **datos** almacenados en las estructuras (consultar, añadir, modificar, borrar).|`SELECT`, `INSERT`, `UPDATE`, `DELETE`.|
|**Control de Datos**|**DCL** (Data Control Language)|Gestionar usuarios, permisos y seguridad.|`GRANT`, `REVOKE`.|
|**Control de Transacciones**|**TCL** (Transaction Control Language)|Gestionar la finalización (confirmación o anulación) de grupos de sentencias DML.|`COMMIT`, `ROLLBACK`, `SAVEPOINT`.|

Una **Instrucción SQL** se construye combinando un **Comando** con **Cláusulas**, **Operadores** y **Funciones**.

- **Cláusulas:** Modifican el comportamiento de las sentencias (ej. `FROM`, `WHERE`, `ORDER BY`, `GROUP BY`, `HAVING`).
    
- **Funciones de Agregación:** Realizan operaciones sobre un grupo de filas (ej. `COUNT`, `SUM`, `AVG`, `MAX`, `MIN`).
    
- **Operadores:** Lógicos (`AND`, `OR`, `NOT`) y de comparación (`=`, `>`, `<`).
    

## 2. Lenguaje de Definición de Datos (DDL)

El DDL se utiliza para crear la estructura de la base de datos. Los objetos (tablas, índices, etc.) se almacenan en el **Diccionario de Datos** del sistema (que contiene metadatos).

### 2.1. Creación de Tablas (`CREATE TABLE`)

Permite crear una tabla dentro de un esquema.

**Reglas de Nomenclatura:**

- No puede haber dos tablas con el mismo nombre en el mismo esquema.
    
- El nombre no puede ser una palabra reservada SQL (ej. no se puede llamar `SELECT`).
    

**Sintaxis General:**

```SQL
CREATE TABLE [esquema.] nombreDeTabla
(
    nombreColumna1 tipoDeDatos [propiedades],
    nombreColumna2 tipoDeDatos [propiedades],
    ...
);
```

**Ejemplo:**

```SQL
CREATE TABLE proveedores (nombre VARCHAR(25));
```

### 2.2. Tipos de Datos (Muy Importante)

Al definir una columna, hay que asignarle un tipo de dato. Es importante recordar que los tipos de datos varían ligeramente entre diferentes SGBD (ANSI SQL es el estándar).

![[Pasted image 20251216004419.png]]

> **Analogy: VARCHAR vs. NVARCHAR**
> 
> - `VARCHAR`: Cadena de caracteres de longitud variable.
>     
> - `NVARCHAR`: `VARCHAR` que puede almacenar datos **UNICODE** (la 'N' es de uNicode). Esto permite guardar y recuperar caracteres de múltiples lenguajes, como la `ñ`, `á`, `é`, etc., que pueden ser "conflictivos" en `VARCHAR` tradicional.
>     

### 2.3. Claves Primarias (`PRIMARY KEY`)

La clave primaria (PK) es el conjunto de columnas que **identifica de forma única** a cada registro de la tabla.

- **Restricción Implícita:** Los campos que forman la PK son automáticamente **`NOT NULL`** (no pueden quedar vacíos) y **`UNIQUE`** (no se pueden repetir).
    
- Al crear una PK, se crea un **índice** para optimizar el acceso a la tabla.
    

Sintaxis (Clave simple):

Se define directamente junto a la columna.

```SQL
CREATE TABLE cliente(
    dni VARCHAR(9) PRIMARY KEY, -- Clave directa
    nombre VARCHAR(50)
);
```




Sintaxis (Clave compuesta o con nombre de restricción):
Se define al final de la lista de columnas, con un nombre de restricción explícito (buena práctica).

```SQL
CREATE TABLE alquiler(
    dni VARCHAR(9),
    cod_pelicula NUMBER(5),
    CONSTRAINT alquiler_pk PRIMARY KEY(dni, cod_pelicula) -- Clave compuesta
);
```

### 2.4. Claves Ajenas (`FOREIGN KEY`)

Una clave ajena o foránea (FK) es uno o más campos de una tabla que se relacionan con la clave principal (PK) de otra tabla.

- **Propósito:** Asegurar la **integridad referencial**.
    
- **Regla de Integridad:** Obliga a que cualquier valor insertado en la columna FK exista previamente como valor en la columna PK de la tabla referenciada. Si intentas insertar un valor que no existe, ocurre un error.
    

**Sintaxis (con nombre de restricción y referencia al final):**

```SQL
CREATE TABLE existencias(
    tipo CHAR(9),
    modelo NUMBER(3),
    CONSTRAINT exi_t_m_fk FOREIGN KEY(tipo, modelo) -- Se indica que campos son la FK
    REFERENCES piezas(tipo, modelo) -- Se indica la tabla y los campos de la PK a la que se enlaza
);
```


#### Reglas de Integridad Referencial (ON DELETE / ON UPDATE)

Cuando se borra o actualiza un registro en la tabla principal (la que contiene la PK), estas cláusulas definen el comportamiento en los registros de la tabla secundaria (la que contiene la FK):

| **Cláusula**              | **Efecto**                                                            | **Aplicación**                                                             |
| ------------------------- | --------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| **`ON DELETE SET NULL`**  | Pone a nulo (`NULL`) la FK en la tabla secundaria.                    | **Importante:** El campo de la FK no debe tener la restricción `NOT NULL`. |
| **`ON DELETE CASCADE`**   | Borra todos los registros relacionados en la tabla secundaria.        | Es la opción más drástica, borra en cascada.                               |
| **`ON DELETE NO ACTION`** | Impide la operación de borrado o actualización en la tabla principal. | Comportamiento por defecto en muchos SGBD.                                 |

> **⚠️ NOTA sobre Oracle:** Oracle no implementa directamente las opciones `ON UPDATE CASCADE|SET NULL|SET DEFAULT`.

### 2.5. Otras Restricciones de Integridad

Una restricción es una condición de obligado cumplimiento para una o más columnas. Es una buena práctica poner siempre un nombre a la restricción (ej. `alu_cod_pk`).

1. **Prohibir Nulos (`NOT NULL`)**
    
    - Obliga a que la columna tenga un valor.
        
    - **Sintaxis:** `CREATE TABLE cliente (dni VARCHAR(9) CONSTRAINT cli_dni_nn NOT NULL);`.
        
2. **Valores Únicos (`UNIQUE`)**
    
    - Obliga a que el contenido de una o más columnas no pueda repetir valores.
        
    - **Sintaxis (Restricción compuesta):** `CONSTRAINT alquiler_uk UNIQUE(dni, cod_pelicula)`.
        
3. **Restricciones de Validación (`CHECK`)**
    
    - Dictan una condición que debe cumplir el contenido de la columna (ej. un rango de valores).
        
    - No pueden incluir subconsultas ni hacer referencia a valores de otras filas.
        
    - **Ejemplo:** `CHECK (importe>0) CONSTRAINT importe_max CHECK (importe<8000)`.
        
4. **Valor por Defecto (`DEFAULT`)**
    
    - Asigna un valor a la columna si no se proporciona uno durante la inserción.
        
    - **Sintaxis:** `precio NUMBER(11,2) DEFAULT 3.5`.
        

###  2.6. Modificación y Eliminación de Tablas

#### 1. Cambiar de nombre a una tabla

De forma estándar (SQL estándar) se hace:

```SQL
ALTER TABLE nombreViejo RENAME TO nombreNuevo;
```



En Oracle y MySQL se realiza mediante la orden `RENAME` (que permite el cambio de nombre de cualquier objeto). Sintaxis:

```SQL
RENAME nombreViejo TO nombreNuevo;
```



#### 2. Borrar contenido de tablas

Oracle y MySQL disponen de una orden no estándar para eliminar definitivamente los datos de una tabla; es la orden `TRUNCATE TABLE` seguida del nombre de la tabla a borrar. Hace que se elimine el contenido de la tabla, pero no la estructura de la tabla en sí. Incluso borra del archivo de datos el espacio ocupado por la tabla.

#### 3. Añadir columnas

```SQL
ALTER TABLE nombreTabla ADD(nombreColumna TipoDatos [Propiedades] [,columnaSiguiente tipoDatos [propiedades]...)
```

Permite añadir nuevas columnas a la tabla. Se deben indicar su tipo de datos y sus propiedades si es necesario (al estilo de `CREATE TABLE`). Si la columna no está definida como `NOT NULL`, se puede añadir en cualquier momento.



Las nuevas columnas se añaden al final, no se puede indicar otra posición (hay que recordar que el orden de las columnas no importa). Ejemplo:

```SQL
ALTER TABLE facturas ADD (fecha DATE);
```

Muchas bases de datos (pero no Oracle) requieren escribir la palabra `COLUMN` tras la palabra `ADD`. Normalmente suele ser opcional.

#### 4. Borrar columnas

```SQL
ALTER TABLE nombreTabla DROP(columna [,columnaSiguiente,...]);
```

Elimina la columna indicada de manera irreversible e incluyendo los datos que contenía.



No se puede eliminar la única columna de una tabla que sólo tiene esa columna (habrá que usar `DROP TABLE`), ni se pueden eliminar las claves primarias referenciadas por claves ajenas.

```SQL
ALTER TABLE facturas DROP (fecha);
```

Al igual que en el caso anterior, en SQL estándar se puede escribir el texto `COLUMN` tras la palabra `DROP`.

#### 5. Modificar columnas

Permite cambiar el tipo de datos y propiedades de una determinada columna. Sintaxis:

```SQL
ALTER TABLE nombreTabla MODIFY (columna tipo [propiedades] [columnaSiguiente tipo [propiedades] ...]
```



Hay que tener en cuenta los datos ya insertados en las tablas a la hora de modificar las columnas, ya que no pueden entrar en contradicción con los datos ya insertados.

Ejemplo:

```SQL
ALTER TABLE facturas MODIFY(fecha DATE);
```



En el caso de SQL estándar en lugar de `MODIFY` se emplea `ALTER` (que además opcionalmente puede ir seguida de `COLUMN`). Por ejemplo:

```SQL
ALTER TABLE facturas ALTER COLUMN fecha DATE;
```

#### 6. Renombrar columnas

Esto permite cambiar el nombre de una columna. Sintaxis en Oracle:

```SQL
ALTER TABLE nombreTabla
RENAME COLUMN nombreAntiguo TO nombreNuevo;
```



Sintaxis en MySQL:

```SQL
ALTER TABLE nombreTabla
CHANGE nombreAntiguo nombreNuevo;
```

Ejemplo:

```SQL
ALTER TABLE facturas RENAME COLUMN fecha TO fechaYhora;
```****

## 3. Lenguaje de Manipulación de Datos (DML)

El DML se usa para operar con los datos dentro de las estructuras creadas por el DDL.

### 3.1. Inserción de Datos (`INSERT`)

Añade nuevos registros (filas) a una tabla.

**Sintaxis:**

SQL

```SQL
INSERT INTO tabla [(listaDeCampos)]
VALUES (valor1 [,valor2 ...]);
```

**Consideraciones:**

- Si no se especifica la `listaDeCampos`, la lista de `VALUES` debe seguir el orden de las columnas.
    
- Los campos no rellenados:
    
    - Se rellenan con su valor **`DEFAULT`** si se definió uno.
        
    - Se rellenan con **`NULL`** si no tienen valor por defecto.
        
- Si un campo tiene restricción **`NOT NULL`**, debe rellenarse obligatoriamente.
    

**Ejemplo (con campos implícitos):**

```SQL
INSERT INTO clientes VALUES( '11111111','Pedro','Gutiérrez', 'Crespo',DEFAULT,NULL);
```

**Ejemplo (con campos explícitos):**

```SQL
INSERT INTO clientes(dni,nombre,apellido1,apellido2) 
VALUES('11111111','Pedro','Gutiérrez', 'Crespo'); 
```

---- 
### 2.7 Añadir restricciones

Es posible querer añadir restricciones tras haber creado la tabla. En ese caso se utiliza la siguiente sintaxis:

```SQL
ALTER TABLE tabla
ADD [CONSTRAINT nombre] tipoDeRestricción(columnas);
```

_tipoRestricción_ es el texto `CHECK`, `PRIMARY KEY` o `FOREIGN KEY`. Las restricciones `NOT NULL` deben indicarse mediante `ALTER TABLE .. MODIFY` colocando `NOT NULL` en el campo que se modifica.

### 2.8 Eliminar restricciones

Sintaxis:


```SQL
ALTER TABLE tabla
DROP {PRIMARY KEY | UNIQUE(campos) | CONSTRAINT nombreRestricción [CASCADE]}
```

La opción `PRIMARY KEY` elimina una clave principal (también quitará el índice `UNIQUE` sobre los campos que formaban la clave). `UNIQUE` elimina índices únicos. La opción `CONSTRAINT` elimina la restricción indicada.

La opción `CASCADE` hace que se eliminen en cascada las restricciones de integridad que dependen de la restricción eliminada.


Por ejemplo en:

```SQL
CREATE TABLE curso(
cod_curso CHAR(7) PRIMARY KEY, fecha_inicio DATE,
fecha_fin DATE, titulo VARCHAR(60), cod_siguientecurso CHAR(7),
CONSTRAINT fecha_ck CHECK(fecha_fin>fecha_inicio),
CONSTRAINT cod_ste_fk FOREIGN KEY(cod_siguientecurso)
REFERENCES curso ON DELETE SET NULL);
```



Tras esa definición de tabla, esta instrucción:

```SQL
ALTER TABLE curso DROP PRIMARY KEY; 
```



Produce este error (en Oracle):

```SQL
ORA-02273: a esta clave única/primaria hacen referencia algunas claves ajenas
```



Para ello habría que utilizar esta instrucción:

```SQL
ALTER TABLE curso DROP PRIMARY KEY CASCADE;
```

Esa instrucción elimina la restricción de clave secundaria antes de eliminar la principal.



También produce error esta instrucción:

```SQL
ALTER TABLE curso DROP(fecha_inicio);
```

```SQL
ERROR en línea 1:
ORA-12991: se hace referencia a la columna en una restricción de multicolumna
```

El error se debe a que no es posible borrar una columna que forma parte de la definición de una restricción.



La solución es utilizar `CASCADE CONSTRAINTS` que elimina las restricciones en las que la columna a borrar estaba implicada:

```SQL
ALTER TABLE curso DROP(fecha_inicio) CASCADE CONSTRAINTS;
```

Esta instrucción elimina la restricción de tipo `CHECK` en la que aparecía la `fecha_inicio` y así se puede eliminar la columna. En SQL estándar sólo se pone `CASCADE` y no `CASCADE CONSTRAINTS`.

Por defecto las restricciones se activan al crearlas, se pueden desactivar de las siguiente forma:



Para desactivar una restricción sin borrarla se usa `DISABLE`:

```SQL
ALTER TABLE table
DISABLE CONSTRAINT nombre_constraint
```



Para activar una restricción de integridad actualmente desactivada se usa `ENABLE`:

```SQL
ALTER TABLE table
ENABLE CONSTRAINT nombreconstraint;
```
## 3. Lenguaje de Manipulación de Datos (DML)

El DML se usa para operar con los datos dentro de las estructuras creadas por el DDL.

### 3.1. Inserción de Datos (`INSERT`)

Añade nuevos registros (filas) a una tabla.

**Sintaxis:**

```SQL
INSERT INTO tabla [(listaDeCampos)]
VALUES (valor1 [,valor2 ...]);
```



**Consideraciones:**

- Si no se especifica la `listaDeCampos`, la lista de `VALUES` debe seguir el orden de las columnas.
    
- Los campos no rellenados:
    
    - Se rellenan con su valor **`DEFAULT`** si se definió uno.
        
    - Se rellenan con **`NULL`** si no tienen valor por defecto.
        
- Si un campo tiene restricción **`NOT NULL`**, debe rellenarse obligatoriamente.
    

**Ejemplo (con campos implícitos):**

```SQL
INSERT INTO clientes VALUES( '11111111','Pedro','Gutiérrez', 'Crespo',DEFAULT,NULL);
```

**Ejemplo (con campos explícitos):**

```SQL
INSERT INTO clientes(dni,nombre,apellido1,apellido2) 
VALUES('11111111','Pedro','Gutiérrez', 'Crespo'); 
```

### 3.2. Actualización de Registros (`UPDATE`)

La modificación de los datos de los registros lo implementa la instrucción `UPDATE`.

Sintaxis: 

```SQL
UPDATE tabla
SET columna1=valor1 [,columna2=valor2...] 
[WHERE condición]
```

Se modifican las columnas indicadas en el apartado `SET` con los valores indicados. La cláusula `WHERE` permite especificar qué registros serán modificados.

Ejemplos: 

```SQL
UPDATE clientes SET provincia='Ourense'
WHERE provincia='Orense';
UPDATE productos SET precio=precio*1.16;
```

El primer dato actualiza la provincia de los clientes de Orense para que aparezca como Ourense. El segundo `UPDATE` incrementa los precios en un 16%. La expresión para el valor puede ser todo lo compleja que se desee (en el ejemplo se utilizan funciones de fecha para conseguir que los partidos que se juagaban hoy, pasen a jugarse el martes):

```SQL
UPDATE partidos SET fecha= NEXT_DAY(SYSDATE,'Martes') 
WHERE fecha=SYSDATE;
```

En la condición se pueden utilizar cualquiera de los siguientes operadores de comparación: 

| **Operador** | **Significado**   |
| ------------ | ----------------- |
| >            | Mayor que         |
| <            | Menor que         |
| >=           | Mayor o igual que |
| <=           | Menor o igual que |
| =            | Igual             |
| <>           | Distinto          |
| !=           | Distinto          |

Además se puede utilizar:

| **Operador** | **Significado**                                                                                            |
| ------------ | ---------------------------------------------------------------------------------------------------------- |
| **AND**      | Devuelve verdadero si las expresiones a su izquierda y derecha son ambas verdaderas.                       |
| **OR**       | Devuelve verdadero si cualquiera de las dos expresiones a izquierda y derecha del OR son verdaderas.       |
| **NOT**      | Invierte la lógica de la expresión que está a su derecha. Si era verdadera, mediante NOT pasa a ser falsa. |

---

### 3.3. Borrado de Registros (`DELETE`)

Elimina registros (filas) de una tabla.

**Sintaxis:**

```SQL
DELETE FROM tabla
[WHERE condición]
```

- **`WHERE`:** Al igual que en `UPDATE`, la cláusula `WHERE` es la que especifica qué registros eliminar. Si se omite, **todos los registros de la tabla serán eliminados**.
    
- **Integridad:** La operación no puede provocar fallos de integridad. Si se definió `ON DELETE CASCADE` en una FK relacionada, se borrarán en cascada todos los registros relacionados.
    

## 4. Transacciones (TCL)

Una transacción es una serie de instrucciones DML que se ejecutan como una única unidad lógica. Se asegura que o se hacen todos los cambios, o no se hace ninguno.

### 4.1. Ciclo de una Transacción

- **Inicio:** Comienza con la primera instrucción DML que se ejecuta.
    
- **Fin:** Finaliza con alguna de estas circunstancias:
    
    - Una operación explícita: **`COMMIT`** o **`ROLLBACK`**.
        
    - Una instrucción DDL o DCL (produce un `COMMIT` implícito).
        
    - El usuario abandona la sesión o el sistema se cae.
        

### 4.2. Comandos de Transacción

|**Comando**|**Función**|**Riesgo / Advertencia**|
|---|---|---|
|**`COMMIT`**|Hace que los cambios realizados por la transacción sean **definitivos e irrevocables**.|Conviene asegurarse antes de ejecutarlo, ya que afecta a los datos de forma permanente.|
|**`ROLLBACK`**|Anula los cambios realizados, regresando los datos al estado del último `COMMIT`, DDL o DCL o al inicio de sesión.|Se utiliza para deshacer una operación antes de que se haga permanente.|

### 4.3. Estado de los Datos durante la Transacción (Aislamiento)

Mientras una transacción está en curso:

- **Usuario Transactor:** El usuario que inició la transacción ve los datos ya modificados por sus propias instrucciones DML.
    
- **Resto de Usuarios:** El resto de usuarios ven los datos tal como estaban **antes** de que la transacción comenzara (se aplica un aislamiento). Los registros afectados aparecen **bloqueados** y no pueden ser modificados por otros.
    
- **Post-Transacción:** Una vez finalizada la transacción (con `COMMIT` o `ROLLBACK`), todos los usuarios ven los datos en su estado final y los bloqueos se liberan.

# 📚 EXPLICACION DE LOS TERMINOS 

- **CREATE:** Crea objetos (tablas, vistas, usuarios).
    
    ```sql
    CREATE TABLE clientes (...);
    ```
    
- **ALTER:** Modifica objetos existentes (añadir/quitar columnas o restricciones).
    
    ```sql
    ALTER TABLE clientes ADD (email VARCHAR2(255));
    ```
    
- **DROP:** Elimina objetos (tabla, vista, usuario).
    
    ```sql
    DROP TABLE clientes;
    ```
    
- **TRUNCATE:** Vacía una tabla (borra todas las filas rápidamente, mantiene estructura).
    
    ```sql
    TRUNCATE TABLE clientes;
    ```
    
- **SELECT:** Consulta datos.
    
    ```sql
    SELECT nombre FROM clientes WHERE id = 1;
    ```
    
- **INSERT:** Inserta filas.
    
    ```sql
    INSERT INTO clientes (id,nombre) VALUES (1,'Ana');
    ```
    
- **UPDATE:** Actualiza filas.
    
    ```sql
    UPDATE clientes SET nombre='Ana María' WHERE id=1;
    ```
    
- **DELETE:** Borra filas.
    
    ```sql
    DELETE FROM clientes WHERE id=2;
    ```
    
- **FROM:** Indica la tabla o tablas de las que se obtienen datos.
    
    ```sql
    SELECT * FROM clientes;
    ```
    
- **WHERE:** Filtra filas según una condición.
    
    ```sql
    SELECT * FROM clientes WHERE activo=1;
    ```
    
- **GROUP BY:** Agrupa filas para aplicar funciones de agregación.
    
    ```sql
    SELECT provincia, COUNT(*) FROM clientes GROUP BY provincia;
    ```
    
- **HAVING:** Filtra grupos (después del GROUP BY).
    
    ```sql
    SELECT provincia, COUNT(*) 
    FROM clientes 
    GROUP BY provincia 
    HAVING COUNT(*) > 10;
    ```
    
- **ORDER BY:** Ordena resultados.
    
    ```sql
    SELECT nombre FROM clientes ORDER BY nombre ASC;
    ```
    
- **DISTINCT:** Elimina duplicados en resultados.
    
    ```sql
    SELECT DISTINCT provincia FROM clientes;
    ```
    
- **PRIMARY KEY:** Clave primaria; identifica filas de forma única, implica `NOT NULL` + `UNIQUE`.
    
    ```sql
    id NUMBER CONSTRAINT pk_clientes PRIMARY KEY
    ```
    
- **FOREIGN KEY / REFERENCES:** Clave ajena; vincula con PK de otra tabla, mantiene integridad referencial.
    
    ```sql
    CONSTRAINT fk_pedidos_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id)
    ```
    
- **UNIQUE:** Obliga a valores no repetidos.
    
    ```sql
    email VARCHAR2(255) CONSTRAINT uq_email UNIQUE
    ```
    
- **CHECK:** Condición que deben cumplir los valores.
    
    ```sql
    total NUMBER(10,2) CHECK (total >= 0)
    ```
    
- **DEFAULT:** Valor por defecto si no se especifica uno.
    
    ```sql
    fecha_alta DATE DEFAULT SYSDATE
    ```
    
- **NOT NULL:** Obliga a que la columna tenga siempre un valor.
    
    ```sql
    nombre VARCHAR2(100) NOT NULL
    ```
    
- **ENABLE / DISABLE CONSTRAINT:** Activa/desactiva una restricción sin borrarla.
    
    ```sql
    ALTER TABLE t DISABLE CONSTRAINT t_ck;
    ALTER TABLE t ENABLE  CONSTRAINT t_ck;
    ```
    
- **CASCADE:** Propaga una acción a objetos dependientes (ej. `DROP PRIMARY KEY CASCADE`; y, en FKs, `ON DELETE CASCADE`).
- **ON DELETE SET NULL:** Al borrar el padre, pone la FK hija a `NULL`.
    
    ```sql
    FOREIGN KEY (...) REFERENCES ... ON DELETE SET NULL
    ```
    
- **ON DELETE CASCADE:** Al borrar el padre, borra las filas hijas vinculadas.
    
    ```sql
    FOREIGN KEY (...) REFERENCES ... ON DELETE CASCADE
    ```
    
- **ON UPDATE (no en Oracle):** En otros SGBD puede actualizar FKs al cambiar PK; Oracle no lo soporta.
- **GRANT / REVOKE:** Otorga / revoca permisos.
    
    ```sql
    GRANT SELECT ON clientes TO alumno;
    REVOKE SELECT ON clientes FROM alumno;
    ```
    
- **COMMIT:** Confirma (hace permanentes) las operaciones de la transacción.
    
    ```sql
    COMMIT;
    ```
    
- **ROLLBACK:** Deshace las operaciones no confirmadas.
    
    ```sql
    ROLLBACK;
    ```
    
- **SAVEPOINT / ROLLBACK TO:** Marca un punto intermedio; revierte hasta él.
    
    ```sql
    SAVEPOINT p1; 
    ROLLBACK TO p1;
    ```
    
- **SYSDATE:** Fecha y hora del sistema en Oracle.
    
    ```sql
    SELECT SYSDATE FROM dual;
    ```
    
- **DUAL:** Tabla especial de Oracle para evaluar expresiones o seleccionar constantes/variables del sistema.
    
    ```sql
    SELECT 1+1 FROM dual;
    ```
    
- **USER:** Usuario actual de la sesión.
    
    ```sql
    SELECT USER FROM dual;
    ```
- **CONSTRAINT** :  sirve para **ponerle nombre a la regla**.

```sql 
CONSTRAINT pk_curso PRIMARY KEY (id)
```
---

# 📚 TEMA 1 : Diseño físico de bases de datos

## 1.  Conceptos generales para SGBD relacionales

- Una vez definido el **modelo lógico**, el siguiente paso es el **diseño físico**.
- Se debe elegir el **SGBD** (Sistema Gestor de Bases de Datos) que mejor se adapte al proyecto.
- Los SGBD relacionales ofrecen utilidades para crear y manejar bases de datos.

---

## 2.  Tipos de SGBD según licencia

- **Libres / gratuitos**
    - MySQL Community Server
    - SQLite
    - PostgreSQL
    - Apache Derby
- **Comerciales**
    - Oracle
    - MySQL Server
    - dBase
    - Microsoft SQL Server
    - Paradox
- **No libres pero gratuitos (versiones limitadas)**
    - Oracle Express Edition (solo en servidor, capacidad limitada).
    - Microsoft SQL Server Express Edition (gratis, ideal para desarrollo y pequeñas aplicaciones).

---

## 3.  Motores de almacenamiento

- Una base de datos relacional usa **tablas** para guardar datos.
- El **motor de almacenamiento** (_storage engine_) es el software que guarda físicamente los datos en disco.
- Cada motor tiene **limitaciones**: índices, tipos de atributos, particionado, funciones SQL soportadas.
- El motor elegido influye en la **rapidez y funcionalidades** del SGBD.

---

## 4.  Tipos de motores más comunes

- **BerkeleyDB (BDB)**
- **HEAP / MEMORY**
- **InnoDB**
- **MERGE / MRG_MyISAM**
- **MyISAM**

👉 Ejemplo:

- Solo **InnoDB** soporta claves ajenas (FOREIGN KEY).
- **InnoDB**: seguridad y transacciones seguras.
- **MyISAM**: velocidad en acceso a datos, útil en aplicaciones web.

---

## 5.  Comparativa: InnoDB vs MyISAM

|Característica|InnoDB|MyISAM|
|---|---|---|
|Tipo|Tablas transaccionales|Tablas no transaccionales|
|Uso|Grandes bases de datos, múltiples usuarios|Consultas rápidas, portabilidad|
|Ventaja|Recuperación de fallos, soporte FOREIGN KEY|Acceso rápido a datos|
|Desventaja|Más consumo de recursos|Inserciones más costosas|

---

## 6.  Tablas transaccionales

- Una **transacción** = conjunto de órdenes que forman una unidad indivisible (ejemplo: transferencia bancaria).
- Un SGBD transaccional asegura que los datos nunca queden en estado intermedio.
- Si ocurre un fallo, el sistema **revierte** la transacción al estado inicial (punto de integridad).
- SQL permite definir transacciones con comandos específicos.

---

## 7.  SQL (Structured Query Language)

- Lenguaje para crear, consultar y administrar bases de datos.
- Existen **dialectos** según el fabricante, pero todos siguen normas ISO.
- Normativas principales:
    - **SQL-86**: versión mínima.
    - **SQL-89**: integridad referencial (FOREIGN KEY).
    - **SQL-92**: muchas variaciones.
    - **SQL-1999**: extensiones orientadas a objetos.
    - **SQL-2003**: soporte SQL/XML.
    - **SQL-2016**: estándar actual.

---

## 8.  Clasificación de sentencias SQL

- **DDL (Data Definition Language)**
    
    - Define la estructura de la BD: tablas, índices, objetos.
    - Permite crear, modificar y eliminar estructuras.
    - Define estructuras físicas (tablespaces, datafiles).
    - Es la parte que más varía entre SGBD.
- **DML (Data Manipulation Language)** _(no detallado en tu fragmento, pero complementario)_
    
    - Consultar, insertar, actualizar y borrar datos.
- **DCL (Data Control Language)** _(también complementario)_
    
    - Control de permisos y seguridad.

---
## 9. El lenguaje de definición de datos
- **DDL** es un sublenguaje de SQL que permite la **definición de datos**.- **Funciones principales**:
    
    - Crear la estructura lógica (BD, tablas, índices, objetos).
    - Modificar la estructura (cambiar tablas, eliminarlas…).
    - Definir estructuras físicas donde se almacenarán los objetos (_tablespaces_, _datafiles_).
    
    - El DDL es la parte de SQL que más varía entre SGBD, porque cada sistema organiza internamente los datos de forma distinta.
    
    📖 Ejemplos básicos
    
    ```SQL
   Crear una tabla CREATE TABLE Clientes ( id_cliente NUMBER PRIMARY KEY, nombre VARCHAR2(100), email VARCHAR2(150) ); -- Modificar una tabla ALTER TABLE Clientes ADD fecha_registro DATE; -- Eliminar una tabla DROP TABLE Clientes;  
    ```
    


---
## 10. 💻 Intérpretes de comandos

- Todo SGBD tiene una aplicación cliente para enviar comandos y mostrar resultados.
![[Pasted image 20251216125110.png]]
---

## 11. 🖥️ Herramientas gráficas

- La mayoría de los SGBD incluyen interfaces gráficas que facilitan su uso.
![[Pasted image 20251216125119.png]]
---

## 🎯 Conclusión

El diseño físico de bases de datos implica **elegir el SGBD adecuado, seleccionar el motor de almacenamiento correcto y aplicar SQL según las normativas**. La decisión entre motores como **InnoDB** y **MyISAM** depende de si se prioriza la **seguridad transaccional** o la **velocidad de acceso**.

---
# 📚TEMA 2: Diseño físico de bases de datos

### 1. Oracle DataBase (SGBD)

Sistema gestor de bases de datos objeto-relacional desarrollado por Oracle Corporation.

Se considera a Oracle Database como uno de los sistemas de bases de datos más completos, destacando:

- soporte de transacciones
    
- estabilidad
    
- escalabilidad
    
- soporte multiplataforma.
    

---

### 2. Oracle Database XE (Express Edition)

- Esta versión gratuita está dirigida a estudiantes, pequeñas empresas y desarrolladores que quieran embeberla junto con sus aplicaciones.
    
- Es una versión limitada en características pero perfectamente operativa para pruebas.
    
- **Oracle Database gratuita para todos**123
    
- Tanto si es desarrollador, administrador de base de datos, científico de datos o educador, como si sencillamente tiene curiosidad por las bases de datos, Oracle Database 18c Express Edition (XE) es ideal para comenzar. Es la misma potente Or4acle Database en la que confían las empresas de todo el mundo, empaquetada para una descarga simple, fácil de usar y una experiencia con todas las 5funciones. Dispondrá de una Oracle Database para usar en cualquier entorno, además de la capacidad de incrustar y redistrib6uir, todo gratuitamente.
    

---

### 3. Instalación en Windows

- Tras la descarga, se descomprime el fichero bajado y se ejecuta el instalador.
    
- Nos pedirá la ruta de instalación y la contraseña.
    
- Esta contraseña será usada para las cuentas **SYS, SYSTEM y PDBADMIN**.
    
- Debes tener paciencia porque puede ser un proceso largo.
    
- Por defecto, el instalador de Oracle Express Edition crea y configura una base de datos.
    

---

### 4. Post-instalación

El programa de instalación de Oracle Database XE habrá creado los siguientes servicios:

- `OracleServiceXE`
    
- `OracleJobSchedulerXE`
    
- `OracleOraDB18Home MTSRecoveryService`
    
- `OracleOraDB18Home1 TNSListener`
    
- `OracleVss WriterXE`
    
- Puede ser recomendable fijar el inicio como manual para evitar colisiones con otros servicios que puedan utilizar el mismo puerto y/o para hacer más rápido el arranque del sistema.
    

---

### 5. Programas instalados

- Concluido el proceso de instalación, se obtiene el submenú de opciones asociados.
    
- La mayoría son usadas por los administradores del sistema gestor de la base de datos.
    
- Como usuarios y programadores nos interesa:
    
    - **SQL Command Line:** cliente de línea de comandos cuya misión es enviar comandos al SGBD y mostrar los resultados devueltos en pantalla
![[Pasted image 20251216130406.png]]
---

### 6. SQL*Plus: Conexión a la BD

Desde el intérprete de comandos (`cmd`) y situados en la ruta `RUTA_DE_INSTALACIÓN\dbhomeXE\bin`:

- Conexión de usuario:
    
    sqlplus usuario[/password>][@<identificador_conexión>]
    
- **Conexión sin usuario** (Útil para realizar algunas tareas de administración de bases de datos, escribir scripts para transportar,... Además luego puede conectarse con CONNECT).
    
    - Es como se conecta desde el menú de programas: `sqlplus/nolog`.
        
- Conexión con rol:
    
    sqlplus / [AS {SYSDBA | SYSOPER}]
    
    - Conexión como administrador de la BD (`SYSDBA`).
        
    - Conexión como operador de la BD (`SYSOPER`).
        
    - Tienen privilegios para conectarse a la BD cuando no está abierta, para realizar tareas de administración y mantenimiento.
        
- **Ejemplos**:
    
    - `#conexión a la base de datos con el usuario hr (password hr)` **`sqlplus hr/hr`**
        ![[Pasted image 20251216130445.png]]
    - `#arrancar sqlplus sin un usuario concreto` **`sqlplus/nolog`**
        
    - `#conexión con rol de administrador` **`sqlplus / as SYSDBA`**
        

---

### 7. Tabla dual

- Disponible para todos los usuarios, sirve para seleccionar variables del sistema o para evaluar expresiones.
    ![[Pasted image 20251216130500.png]]
- Las sentencias sql terminan en **`;`** y pueden ocupar varias líneas.
    
- Comentarios precedidos por **`--`**.
    
- No es sensible a mayúsculas y minúsculas.
    

---

### 8. SQL*Plus: Desconexión de la BD

- `SQL> exit`
    ![[Pasted image 20251216130519.png]]

---

### 9. Creación de BD: Oracle vs. MySQL

- La creación de la BD en Oracle es un proceso muy elaborado.
    
- En MySQL una sola instancia controla todas las BD, en Oracle cada BD está asociada a una instancia.
    
    - Una BD está compuesta por todos los ítems almacenados en disco y una instancia es un conjunto de procesos del servidor que tiene su propio área global de memoria y una BD asociada a ellos.
        
- Por ello, en la instalación del SGBD Oracle suele preguntar si se desea instalar una BD de ejemplo (¡la versión que nosotros utilizamos ni siquiera nos lo pregunta!).
    

---

### 10. Creación de la BD

- La documentación de Oracle refleja que hay tres formas de crear la BD:
    
    - Utilizando el Asistente de configuración de base de datos (DBCA).
        
    - Manualmente, utilizando la sentencia `CREATE DATABASE`.
        
    - Actualizando una base de datos existente.
        

---

### 11. Manualmente (Estructura Física)

Desde el punto de vista físico, una base de datos es, para Oracle, un conjunto de ficheros:

- `datafiles`, ficheros de datos.
    
- `log files`, ficheros de log.
    
- `init.ora`, fichero de texto que contiene los parámetros de configuración de la base de datos.
    
- `control files`, ficheros de control, definidos en el `init.ora`.
    
- `password files`, fichero con la password del BDA y los operadores (todos los demás usuarios están definidos en tablas).
    

---

### 12. Actualización de una existente

- En Oracle Database XE ya tenemos una BD instalada que actualizaremos añadiendo tablas, otros usuarios, etc....
    

---

### 13. MODIFICACIÓN DE BBDD

- `ALTER DATABASE`
    
- **Ejemplos**:
    
    - `#cambia el tamaño del fichero` **`SQL> ALTER DATABASE DATAFILE ‘/datos/jardineria/system01.dbf' SIZE 1G;`**
        
    - `#cambia el modo de acceso` **`SQL> ALTER DATABASE open read only;`**
        
    - `#desactiva la opción de recuperación rápida` **`SQL> ALTER DATABASE flashback off;`**
        

---

### 14. BORRADO DE BASE DE DATOS

- `DROP DATABASE`
    
- **Ejemplo**:
    
    - `>sqlplus / as sysdba`
        
    - `shutdown abort;` `--parada de la instancia`
        
    - `startup mount exclusive restrict;` `--reinicio en modo exclusivo`
        
    - `drop database;` `--borrado`
        
    - `exit` `--salir`
        

---

### 15. CREACIÓN DE USUARIO

- Para que un usuario pueda trabajar con tablas, debe existir y tener los permisos necesarios.
    
- Desde SQL*PLUS, conectado como administrador (`sqlplus / as sysdba`):
    
    SQL
    
    ```
    CREATE USER nombre_usuario 
    IDENTIFIED BY identificador_instancia 
    QUOTA UNLIMITED ON USERS;
    GRANT CREATE SESSION, CREATE TABLE TO nombre_usuario;
    ```
    
- O desde SQLDeveloper.
    ![[Pasted image 20251216130604.png]]

---

### 16. Problemas

- Si se cambia el nombre del equipo, la instalación dejará de ser válida, ya que hay numerosos ficheros que guardan dicho nombre.
    
- Por ejemplo: `tnsnames.ora`.
    ![[Pasted image 20251216130629.png]]
- Solución rápida: desinstalar y volver a instalar.
    

---
# 📚 TEMA 3: Diseño físico de bases de datos
### 1. Oracle SQL Developer

El objetivo fundamental de SQL Developer es proporcionar una interfaz más amigable para la consulta y programación de la base de datos Oracle.

Es la herramienta gráfica gratuita que proporciona Oracle para que no sea necesario utilizar herramientas de terceros para desarrollar y poder ejecutar consultas o scripts SQL, tanto DML como DDL. Además, en las últimas versiones ha incorporado mejoras como permitir conectar con bases de datos no Oracle, como SQLServer, MySQL o Access.

Version 24.3.0.284.2209 - October 17, 2024

Now Available

SQL Developer for VS Code

---

### 2. Instalación

Para instalar en Windows basta con descomprimir en la carpeta deseada (incluso permite importar configuraciones de instalaciones anteriores).

---

### 3. Entorno gráfico SQLDeveloper

- **Menú Principal:** Archivo, Editar, Ver, Navegar, Ejecutar, Equipg, Herramientas, Ventana, Ayuda.
    
- **Paneles:** Informes, Conexiones (como system), Conexiones de Nube.
    
- **Página Inicial (Contenido):** Introducción, Comunidad, Video de Visión General, Novedades, flotas Técnicas sobre la Versión, Documentación, Rutas de Acceso de Optimizador, Asesor de Ajustes SQL, Trabajo con Utilidades de Ajuste, Copia de Base de Datos, Funciones de Informes, Función de Oracle Data Pump, Mostrar al Iniciar.
![[Pasted image 20251216131951.png]]
---

### 4. Conexión a Oracle Database como usuario system

Obviamente el SGBD debe estar puesto en marcha.

- **Nueva Conexión:**
    
    - Se inicia desde el menú o botón **Nueva Conexión...** / **Nueva Conexión de Nube...**.
        ![[Pasted image 20251216132005.png]]
- **Definición de Conexión:**
    
    - **Nombre de Conexión:** como_system
        
    - **Usuario:** system
        
    - **Contraseña:** ......
        
    - **Tipo de Conexión:** Básico
        
    - **Rol:** valor por defecto
        
    - **Nombre del Host:** localhost
        
    - **Puerto:** 1521
        
    - **SID:** Xe
        
    - **Opciones:** Autenticación del Sistema Operativo, Autenticación Kerberos, Conexión de Proxy.
![[Pasted image 20251216132034.png]]



---

### 5. SQL Developer Data Modeler

Oracle proporciona otra herramienta gratuita, SQL Developer Data Modeler, que permite el modelado de BD.

- Puede **integrarse con SQL Developer**.
    
- Permite **ingeniería directa e inversa**.
    
- Muchas de sus características ya están integradas en Sqldeveloper.
    

---
### 6. Espacio de trabajo de SQL Data Modeler - Modelo relacional

![[Pasted image 20251216132158.png]]

---
# 📚 TEMA 4: Lenguaje SQL 

## 1. El lenguaje SQL

### 1.1 Contexto

- En los temas anteriores vimos cómo el **modelo Entidad-Relación (E/R)** permite representar situaciones del mundo real.
- Ese modelo se transforma en el **modelo relacional**, que organiza la información en tablas.
- Para **almacenar y manipular** esa información en un **Sistema Gestor de Bases de Datos Relacional (SGBDR)** se utiliza **SQL**.

---

### 1.2 Definición

- **SQL** significa _Structured Query Language_ (Lenguaje de Consulta Estructurado).
- Es el **lenguaje estándar** para interactuar con bases de datos relacionales.
- Permite especificar:
    - **Operaciones sobre los datos** (consultar, insertar, modificar, borrar).
    - **Operaciones sobre la estructura** (crear tablas, definir claves, restricciones).

---

### 1.3 Características principales

- **Lenguaje declarativo:**
    
    - Se indica _qué_ queremos obtener, no _cómo_.
    - Ejemplo:
        
        ```sql
        SELECT nombre FROM clientes;
        ```
        
        → El SGBD decide cómo buscar los datos internamente.
- **Lenguaje no procedimental:**
    
    - No requiere definir pasos o algoritmos.
    - Se centra en el resultado deseado.
- **No es un lenguaje de programación** como Java o C.
    
    - No tiene estructuras de control de flujo (if, for) en su forma básica.
    - Se usa para **consultar y manipular datos**, no para construir aplicaciones completas.

---

### 1.4 Importancia actual

- SQL es el **lenguaje de consulta y manipulación de datos más extendido** en el mundo.
- Todos los fabricantes de SGBDR lo utilizan (Oracle, MySQL, SQL Server, PostgreSQL, DB2, etc.).
- A lo largo de los años se han añadido nuevas características para adaptarse a la evolución tecnológica.

---

### 1.5 Estándar y variaciones

- SQL es una **norma ANSI/ISO**, no propiedad de ningún fabricante.
- En la práctica, cada sistema añade **variaciones**:
    - Oracle usa `VARCHAR2` en lugar de `VARCHAR`.
    - MySQL permite `AUTO_INCREMENT` para claves primarias.
    - SQL Server tiene tipos como `NTEXT` o `BIT`.
- Esto significa que **SQL puro** no existe en la realidad: cada implementación tiene pequeñas diferencias.

---

### 1.6 Conclusión del apartado

- SQL es el **lenguaje universal de las bases de datos relacionales**.
- Su fuerza está en ser **declarativo, sencillo y estandarizado**, aunque con variaciones según el fabricante.
- Es la herramienta que conecta el **modelo lógico relacional** con el **uso práctico en un SGBDR**.

---
## 2. ¿Cómo se usa SQL?

### 2.1 Elementos según la normativa ANSI/ISO

Cuando se ejecuta SQL, entran en juego varios componentes:

- **Agente SQL**
    
    - Es cualquier elemento que provoca la ejecución de instrucciones SQL.
    - Ejemplo: un servicio que lanza tareas administrativas programadas en el servidor.
    - Actúa como “disparador” de las órdenes.
- **Implementación SQL**
    
    - Es el procesador software que interpreta y ejecuta las instrucciones recibidas.
    - Está formada por:
        - **Cliente SQL:** interfaz que conecta al agente con el servidor. Permite enviar consultas y recibir resultados.
        - **Servidor SQL:** software que gestiona los datos. Es quien realmente ejecuta las instrucciones y devuelve los resultados al cliente.

💡 _Ejemplo práctico:_  
Cuando escribes en la consola de MySQL:

```sql
SELECT * FROM clientes;
```

- El **agente** es el usuario que lanza la consulta.
- El **cliente SQL** es la consola de MySQL.
- El **servidor SQL** es el motor de MySQL que busca los datos y los devuelve.

---

### 2.2 Modos de acceso a las bases de datos

Los SGBDR permiten dos formas principales de trabajar con SQL:

#### a) Modo interactivo

- Pensado para usuarios finales, avanzados u ocasionales.
- Las sentencias SQL se introducen directamente en un cliente conectado al servidor.
- El intérprete de órdenes traduce las instrucciones y muestra los resultados.

💡 _Ejemplo (MySQL Command Line Client):_

```sql
mysql> USE dvd_collection;
Database changed

mysql> SELECT * FROM movies;
```

Resultado: se muestran todas las filas de la tabla `movies`.

---

#### b) Modo embebido

- Pensado para programadores.
- Las sentencias SQL se incrustan dentro de un **lenguaje anfitrión** (Java, PHP, C++, .NET, etc.).
- El lenguaje anfitrión aporta la lógica de programación que SQL no tiene.
- Se utiliza un **driver** (ej. JDBC para Java, ODBC para C/C++).
- Al compilar el código, un **precompilador** traduce las sentencias SQL y conecta la aplicación con la base de datos.

💡 _Ejemplo (PHP con MySQL):_

```php
$conexion = mysql_connect("127.0.0.1", "root", "");
mysql_select_db("agenda", $conexion);

$sql = "INSERT INTO contactos (nombre, apellidos, telefono, direccion)
        VALUES ('$nombre', '$apellidos', '$telefono', '$direccion')";
mysql_query($sql, $conexion);

mysql_close($conexion);
```

- Aquí SQL está embebido dentro de PHP.
- El driver de MySQL conecta el programa con la base de datos.
- El resultado es una aplicación que inserta datos en la tabla `contactos`.

---

### 2.3 Conclusión del apartado

- SQL puede usarse de forma **directa** (modo interactivo) o **integrada en aplicaciones** (modo embebido).
- El **cliente SQL** es la herramienta visible para el usuario.
- El **servidor SQL** es quien realmente ejecuta las órdenes.
- Esta separación permite que SQL sea flexible: tanto para consultas rápidas como para aplicaciones completas.

---
## 3. Componentes del lenguaje SQL

### 3.1 Sentencias principales

El lenguaje SQL se compone de **sentencias** (comandos) que se clasifican en varios grupos:

#### a) DDL – _Data Definition Language_ (Lenguaje de Definición de Datos)

- Sirve para **crear, modificar y borrar** elementos estructurales de la base de datos.
- Objetos que se gestionan:
    - Bases de datos.
    - Tablas.
    - Índices.
    - Restricciones.
- Las definiciones quedan almacenadas en el **diccionario de datos** del sistema.
- **Comandos más usados:**
    - `CREATE` → crear objetos.
    - `DROP` → eliminar objetos.
    - `ALTER` → modificar objetos.

💡 _Ejemplo:_

```sql
CREATE TABLE clientes (
  dni VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(50)
);
```

---

#### b) DML – _Data Manipulation Language_ (Lenguaje de Manipulación de Datos)

- Permite **trabajar con los datos** almacenados en las estructuras creadas por DDL.
- Operaciones:
    - Consultar (`SELECT`).
    - Insertar (`INSERT`).
    - Modificar (`UPDATE`).
    - Borrar (`DELETE`).
- También ordenar, filtrar y agrupar resultados.

💡 _Ejemplo:_

```sql
SELECT nombre, edad
FROM clientes
WHERE edad > 30
ORDER BY nombre;
```

---

#### c) DCL – _Data Control Language_ (Lenguaje de Control)

- Gestiona aspectos de **usuarios, permisos y seguridad**.
- **Comandos principales:**
    - `GRANT` → otorgar permisos.
    - `REVOKE` → retirar permisos.

💡 _Ejemplo:_

```sql
GRANT SELECT, INSERT ON clientes TO usuario1;
REVOKE INSERT ON clientes FROM usuario1;
```

---

#### d) TCL – _Transaction Control Language_ (Lenguaje de Control de Transacciones)

- Gestiona **transacciones** y bloqueos.
- **Comandos principales:**
    - `COMMIT` → confirmar cambios.
    - `ROLLBACK` → deshacer cambios.
    - `SAVEPOINT` → marcar un punto intermedio en la transacción.

💡 _Ejemplo:_

```sql
BEGIN TRANSACTION;
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 1;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
```

---

### 3.2 Elementos adicionales de las sentencias

Además de los comandos principales, las sentencias SQL se construyen con:

- **Cláusulas:** modifican el comportamiento de las sentencias.
    
    - Ejemplos: `FROM`, `WHERE`, `GROUP BY`, `HAVING`, `ORDER BY`.
- **Operadores lógicos y de comparación:** permiten condiciones en consultas.
    
    - Ejemplos: `AND`, `OR`, `>`, `<`, `=`.
- **Funciones de agregación:** realizan cálculos sobre grupos de filas.
    
    - Ejemplos:
        - `COUNT(*)` → cuenta filas.
        - `SUM(columna)` → suma valores.
        - `MAX(columna)` → valor máximo.
        - `MIN(columna)` → valor mínimo.
        - `AVG(columna)` → media.
- **Funciones de transformación:** operaciones sobre datos (ej. concatenar cadenas, convertir tipos).
    
- **Expresiones:** combinaciones de operadores, funciones, literales y nombres de columna.
    
- **Metadatos:** información sobre la propia base de datos (ej. definición de tablas, usuarios, privilegios).
    

---

### 3.3 Ejemplo completo

```sql
SELECT departamento, COUNT(*)
FROM empleados
GROUP BY departamento
HAVING COUNT(*) > 5
ORDER BY departamento;
```

- **SELECT:** consulta datos.
- **COUNT(*):** función de agregación (cuenta empleados).
- **FROM empleados:** tabla origen.
- **GROUP BY departamento:** agrupa por departamento.
- **HAVING COUNT(*) > 5:** filtra grupos con más de 5 empleados.
- **ORDER BY departamento:** ordena resultados.

---

### 3.4 Conclusión del apartado

- SQL se organiza en **cuatro grandes grupos de sentencias** (DDL, DML, DCL, TCL).
- Cada sentencia puede incluir **cláusulas, operadores, funciones y expresiones** para ampliar su potencia.
- Gracias a esta estructura, SQL permite tanto **definir la base de datos** como **manipular datos y controlar transacciones**.

---
## 4. Formato de las instrucciones en los apuntes

---

### 4.1 Sintaxis vs. Ejemplo

En los apuntes se presentan dos formas de mostrar un comando SQL:

- **Sintaxis:**
    
    - Explica la forma general de escribir un comando.
    - Usa símbolos especiales para indicar opciones, partes obligatorias u opcionales.
    - Ejemplo de sintaxis:
        
        ```sql
        SELECT * | {[DISTINCT] columna | expresión [alias], ...}
        FROM tabla;
        ```
        
        → Aquí se indica que se puede seleccionar todas las columnas (`*`), o bien columnas específicas, con posibilidad de usar `DISTINCT` y alias.
- **Ejemplo concreto:**
    
    - Muestra un caso real de uso del comando.
    - Ejemplo:
        
        ```sql
        SELECT nombre FROM cliente;
        ```
        
        → Consulta el campo `nombre` de la tabla `cliente`.

---

### 4.2 Símbolos usados en la sintaxis

Para interpretar correctamente las definiciones de comandos SQL, se utilizan símbolos estándar:

- **PALABRA en negrita:**
    
    - Indica una palabra reservada que debe escribirse literalmente.
    - Ejemplo: `SELECT`, `FROM`.
- **Texto normal:**
    
    - Representa un elemento que debe sustituirse por un nombre real.
    - Ejemplo: `columna`, `tabla`.
    - En `SELECT columna FROM tabla;` → `columna` puede ser `nombre`, `edad`; `tabla` puede ser `clientes`.
- **Texto en negrita (no reservado):**
    
    - Símbolos o caracteres que deben escribirse tal cual.
    - Ejemplo: `*` (asterisco).
- **[ ] Corchetes:**
    
    - Indican que una parte es opcional.
    - Ejemplo: `[DISTINCT]` → se puede usar o no.
- **{ } Llaves:**
    
    - Indican opciones obligatorias pero excluyentes.
    - Ejemplo:
        
        ```sql
        SELECT { * | columna | expresión }
        FROM tabla;
        ```
        
        → Se debe elegir una de las tres opciones: `*`, una columna o una expresión.
- **| Barra vertical:**
    
    - Indica alternativas.
    - Ejemplo: `{ * | columna }` → elegir entre `*` o `columna`.
- **... Puntos suspensivos:**
    
    - Indican repetición.
    - Ejemplo: `columna1, columna2, ...` → se pueden añadir más columnas.

---

### 4.3 Ejemplo explicado paso a paso

```sql
SELECT * | {[DISTINCT] columna | expresión [alias], ...}
FROM tabla;
```

- `SELECT` → palabra reservada obligatoria.
- `*` → selecciona todas las columnas.
- `[DISTINCT]` → opcional, elimina duplicados.
- `columna | expresión` → se puede elegir una columna o una expresión.
- `[alias]` → opcional, permite renombrar el resultado.
- `...` → se pueden añadir más columnas o expresiones.
- `FROM tabla` → indica la tabla de origen.

💡 _Ejemplo real:_

```sql
SELECT DISTINCT nombre, edad AS años
FROM clientes;
```

- `DISTINCT` → evita duplicados en `nombre`.
- `edad AS años` → renombra la columna `edad` como `años`.
- `FROM clientes` → tabla origen.

---

### 4.4 Conclusión del apartado

- La **sintaxis** muestra la estructura general de un comando.
- Los **ejemplos** muestran casos concretos de uso.
- Los **símbolos** (corchetes, llaves, barra vertical, puntos suspensivos) son esenciales para interpretar correctamente la documentación.
- Entender la sintaxis permite **aplicar el comando en múltiples situaciones** y no limitarse a un único ejemplo.

---
## 5. Normas de escritura

---

### 5.1 Mayúsculas y minúsculas

- En SQL **no se distingue entre mayúsculas y minúsculas**.
- Es decir, estas tres sentencias son equivalentes:

```sql
SELECT nombre FROM clientes;
select nombre from clientes;
SeLeCt nombre FrOm clientes;
```

- Aunque el motor las interpreta igual, **por convención** se escriben las palabras reservadas (`SELECT`, `FROM`, `WHERE`) en mayúsculas para mejorar la legibilidad.

---

### 5.2 Finalización de instrucciones

- Todas las sentencias SQL deben terminar con **punto y coma (`;`)**.
- Esto indica al intérprete que la instrucción ha concluido.
- Ejemplo:

```sql
SELECT * FROM clientes;
```

---

### 5.3 Uso de espacios y saltos de línea

- Se pueden **partir las sentencias en varias líneas** o añadir espacios sin afectar al resultado.
- Esto permite escribir consultas largas de forma más clara.
- Ejemplo:

```sql
SELECT nombre, edad
FROM clientes
WHERE edad > 30
ORDER BY nombre;
```

- Aquí cada cláusula está en una línea distinta, lo que facilita la lectura.

---

### 5.4 Tabulación

- Se pueden usar **tabulaciones** para alinear columnas o cláusulas.
- Esto es útil en consultas con muchas columnas o condiciones.
- Ejemplo:

```sql
SELECT  nombre,
        edad,
        direccion
FROM    clientes
WHERE   edad > 30
AND     ciudad = 'Zaragoza';
```

---

### 5.5 Comentarios

- Los comentarios permiten documentar el código SQL.
- En la mayoría de SGBD se usan:
    - `/* ... */` → comentario de bloque.
    - `-- ...` → comentario de línea (en muchos sistemas, como Oracle y SQL Server).

💡 _Ejemplo:_

```sql
/* Seleccionamos clientes mayores de 30 años */
SELECT nombre, edad
FROM clientes
WHERE edad > 30; -- condición de edad
```

---

### 5.6 Estructura de una instrucción SQL

Una instrucción SQL se compone de varios elementos combinados:

- **Comando:** palabra reservada principal (`SELECT`, `INSERT`, `UPDATE`, etc.).
- **Cláusulas:** modifican el comportamiento (`WHERE`, `GROUP BY`, `ORDER BY`).
- **Operadores:** definen condiciones (`AND`, `OR`, `>`, `<`).
- **Funciones:** realizan cálculos (`COUNT`, `SUM`, `AVG`).

💡 _Ejemplo completo:_

```sql
SELECT departamento, COUNT(*)
FROM empleados
WHERE salario > 2000
GROUP BY departamento
HAVING COUNT(*) > 5
ORDER BY departamento;
```

---

### 5.7 Conclusión del apartado

- SQL es **flexible en su escritura**: no distingue mayúsculas/minúsculas y permite espacios o saltos de línea.
- El uso de **punto y coma** es obligatorio para finalizar sentencias.
- Los **comentarios** son esenciales para documentar y mantener el código.
- Una instrucción SQL combina **comando + cláusulas + operadores + funciones**, lo que permite construir consultas muy potentes.

---
## 6. Lenguaje de descripción de datos (DDL)

---

### 6.1 ¿Qué es DDL?

- **DDL (Data Definition Language)** es el conjunto de sentencias SQL que permiten **definir la estructura** de la base de datos.
- Con DDL podemos:
    - Crear tablas, índices y restricciones.
    - Modificar la estructura de las tablas existentes.
    - Eliminar tablas y otros objetos.
- Se centra en **qué queremos hacer** (crear, modificar, borrar), no en cómo se ejecuta internamente.
- Es considerado un **lenguaje de cuarta generación**, porque busca ser lo más cercano posible al lenguaje humano.

💡 _Ejemplo:_

```sql
CREATE TABLE clientes (
  dni VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(50),
  edad INT
);
```

---

### 6.2 Creación de tablas

#### Sintaxis general

```sql
CREATE TABLE [esquema.] nombreTabla (
  nombreColumna tipoDeDatos [propiedades] [, ...]
);
```

#### Reglas importantes

- No puede haber dos tablas con el mismo nombre en un esquema.
- No se puede usar una palabra reservada como nombre de tabla (ej. `SELECT`).
- Si la tabla pertenece a otro esquema, se antepone el nombre del esquema:

```sql
CREATE TABLE otroUsuario.proveedores (
  nombre VARCHAR(25)
);
```

#### Ejemplo básico

```sql
CREATE TABLE proveedores (
  nombre VARCHAR(25)
);
```

→ Crea una tabla con un solo campo de tipo texto variable.

---

### 6.3 Tipos de datos

Al crear tablas, cada columna debe tener un tipo de datos.

|Descripción|ANSI SQL|SQL Server|Oracle|MySQL|
|---|---|---|---|---|
|Texto fijo|CHAR(n)|CHAR(n)|CHAR(n)|CHAR(n)|
|Texto variable|VARCHAR(n)|VARCHAR(n)|VARCHAR2(n)|VARCHAR(n)|
|Texto nacional fijo|NCHAR(n)|NCHAR(n)|NCHAR(n)|—|
|Texto nacional variable|NVARCHAR(n)|NVARCHAR(n)|NVARCHAR2(n)|—|
|Enteros|INT, SMALLINT|INT, SMALLINT|NUMBER(38)|INT, SMALLINT, TINYINT|
|Decimales|NUMERIC(m,d), DECIMAL(m,d)|NUMERIC, DECIMAL|NUMBER(m,d)|DECIMAL(m,d)|
|Flotantes|FLOAT, REAL, DOUBLE|FLOAT|NUMBER|FLOAT(m,d), DOUBLE(m,d)|
|Fecha|DATE|DATE|DATE|DATE|
|Fecha/hora|TIMESTAMP|DATETIME, TIMESTAMP|TIMESTAMP|TIMESTAMP, DATETIME|
|Texto largo|CLOB|TEXT, NTEXT|CLOB|TEXT, MEDIUMTEXT, LONGTEXT|
|Binario largo|BLOB|IMAGE|RAW, BLOB|BLOB, MEDIUMBLOB, LONGBLOB|

💡 **Nota importante:**

- `VARCHAR` → texto de longitud variable.
- `NVARCHAR` → texto de longitud variable con soporte **Unicode** (permite caracteres internacionales como ñ, á, ü).

---

### 6.4 Claves primarias

- La **clave primaria** identifica de forma única cada registro de una tabla.
- Implica automáticamente:
    - `NOT NULL` → no puede estar vacío.
    - `UNIQUE` → no puede repetirse.
- Al crear una clave primaria, el SGBD genera un **índice** para acelerar búsquedas.

#### Ejemplo clave primaria simple

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(50)
);
```

#### Ejemplo con nombre de restricción

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) CONSTRAINT cliente_pk PRIMARY KEY,
  nombre VARCHAR(50)
);
```

#### Ejemplo clave primaria compuesta

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9),
  cod_pelicula NUMBER(5),
  CONSTRAINT alquiler_pk PRIMARY KEY(dni, cod_pelicula)
);
```

---

### 6.5 Claves ajenas (foráneas)

- Una **clave ajena** relaciona una tabla con otra.
- Garantiza la **integridad referencial**: no se pueden insertar valores que no existan en la tabla principal.

#### Ejemplo básico

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9) CONSTRAINT dni_fk REFERENCES clientes(dni),
  cod_pelicula NUMBER(5) CONSTRAINT pelicula_fk REFERENCES peliculas(cod),
  CONSTRAINT alquiler_pk PRIMARY KEY(dni, cod_pelicula)
);
```

#### Ejemplo con varias claves foráneas

```sql
CREATE TABLE existencias (
  tipo CHAR(9),
  modelo NUMBER(3),
  n_almacen NUMBER(1),
  cantidad NUMBER(7),
  CONSTRAINT exi_t_m_fk FOREIGN KEY(tipo, modelo) REFERENCES piezas,
  CONSTRAINT exi_nal_fk FOREIGN KEY(n_almacen) REFERENCES almacenes,
  CONSTRAINT exi_pk PRIMARY KEY(tipo, modelo, n_almacen)
);
```

#### Opciones ON DELETE / ON UPDATE

- **SET NULL:** pone nulos en las claves secundarias relacionadas.
- **CASCADE:** borra todos los registros relacionados.
- **SET DEFAULT:** coloca el valor por defecto.
- **NO ACTION:** impide la operación.

💡 _Ejemplo con opciones:_

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9),
  cod_pelicula NUMBER(5),
  CONSTRAINT alquiler_pk PRIMARY KEY(dni, cod_pelicula),
  CONSTRAINT dni_fk FOREIGN KEY (dni) REFERENCES clientes(dni) ON DELETE SET NULL,
  CONSTRAINT pelicula_fk FOREIGN KEY (cod_pelicula) REFERENCES peliculas(cod) ON DELETE CASCADE
);
```

---

### 6.6 Restricciones de integridad

- Son condiciones obligatorias sobre columnas.
- Se recomienda nombrarlas para identificarlas fácilmente.

#### Tipos de restricciones

- **NOT NULL:** prohíbe valores nulos.
- **UNIQUE:** obliga a que los valores sean únicos.
- **CHECK:** valida condiciones sobre los datos.
- **DEFAULT:** asigna un valor por defecto.

💡 _Ejemplo con CHECK:_

```sql
CREATE TABLE ingresos (
  cod NUMBER(5) PRIMARY KEY,
  concepto VARCHAR(40) NOT NULL,
  importe NUMBER(11,2) CONSTRAINT importe_min CHECK (importe > 0),
  CONSTRAINT importe_max CHECK (importe < 8000)
);
```

---

### 6.7 Conclusión del apartado

- El **DDL** define la estructura de la base de datos.
- Permite crear tablas, definir tipos de datos, claves primarias y foráneas, y restricciones.
- Es la base sobre la que se construyen todas las operaciones posteriores de manipulación de datos.

---

Perfecto, José 🙌. Vamos a continuar con el **séptimo apartado del tema: “Creación de tablas – ejemplos y reglas”**, redactado como apuntes completos para Obsidian, punto por punto, con toda la información del PDF y ejemplos prácticos.

---
## 7. Creación de tablas

---

### 7.1 Reglas básicas

- **Nombre único:** no puede haber dos tablas con el mismo nombre dentro de un mismo esquema.
- **Palabras reservadas:** no se pueden usar como nombre de tabla (ejemplo: no se puede llamar `SELECT` a una tabla).
- **Esquema:** si la tabla pertenece a otro esquema, se debe anteponer el nombre del esquema.
    - Ejemplo:
        
        ```sql
        CREATE TABLE otroUsuario.proveedores (
          nombre VARCHAR(25)
        );
        ```
        

---

### 7.2 Sintaxis general

```sql
CREATE TABLE [esquema.] nombreTabla (
  nombreColumna tipoDeDatos [propiedades] [, ...]
);
```

- `[esquema.]` → opcional, indica el esquema al que pertenece la tabla.
- `nombreTabla` → nombre de la tabla.
- `nombreColumna` → nombre de cada columna.
- `tipoDeDatos` → tipo de datos de la columna (ej. VARCHAR, INT, DATE).
- `[propiedades]` → restricciones opcionales (ej. NOT NULL, UNIQUE, DEFAULT).

---

### 7.3 Ejemplo básico

```sql
CREATE TABLE proveedores (
  nombre VARCHAR(25)
);
```

- Crea una tabla llamada `proveedores` con una columna `nombre` de tipo texto variable (máx. 25 caracteres).

---

### 7.4 Tipos de datos (resumen comparativo)

|Descripción|ANSI SQL|SQL Server|Oracle|MySQL|
|---|---|---|---|---|
|Texto fijo|CHAR(n)|CHAR(n)|CHAR(n)|CHAR(n)|
|Texto variable|VARCHAR(n)|VARCHAR(n)|VARCHAR2(n)|VARCHAR(n)|
|Texto nacional fijo|NCHAR(n)|NCHAR(n)|NCHAR(n)|—|
|Texto nacional variable|NVARCHAR(n)|NVARCHAR(n)|NVARCHAR2(n)|—|
|Enteros|INT, SMALLINT|INT, SMALLINT|NUMBER(38)|INT, SMALLINT, TINYINT|
|Decimales|NUMERIC(m,d), DECIMAL(m,d)|NUMERIC, DECIMAL|NUMBER(m,d)|DECIMAL(m,d)|
|Flotantes|FLOAT, REAL, DOUBLE|FLOAT|NUMBER|FLOAT(m,d), DOUBLE(m,d)|
|Fecha|DATE|DATE|DATE|DATE|
|Fecha/hora|TIMESTAMP|DATETIME, TIMESTAMP|TIMESTAMP|TIMESTAMP, DATETIME|
|Texto largo|CLOB|TEXT, NTEXT|CLOB|TEXT, MEDIUMTEXT, LONGTEXT|
|Binario largo|BLOB|IMAGE|RAW, BLOB|BLOB, MEDIUMBLOB, LONGBLOB|

💡 **Nota:**

- `VARCHAR` → texto de longitud variable.
- `NVARCHAR` → texto de longitud variable con soporte **Unicode** (permite caracteres internacionales como ñ, á, ü).

---

### 7.5 Claves primarias

- Identifican de forma única cada registro.
- Implican automáticamente:
    - `NOT NULL` → no puede estar vacío.
    - `UNIQUE` → no puede repetirse.
- Al crear una clave primaria, el SGBD genera un **índice** para acelerar búsquedas.

#### Ejemplo clave primaria simple

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(50)
);
```

#### Ejemplo con nombre de restricción

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) CONSTRAINT cliente_pk PRIMARY KEY,
  nombre VARCHAR(50)
);
```

#### Ejemplo clave primaria compuesta

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9),
  cod_pelicula NUMBER(5),
  CONSTRAINT alquiler_pk PRIMARY KEY(dni, cod_pelicula)
);
```

---

### 7.6 Claves ajenas (foráneas)

- Relacionan una tabla con otra.
- Garantizan la **integridad referencial**: no se pueden insertar valores que no existan en la tabla principal.

#### Ejemplo básico

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9) CONSTRAINT dni_fk REFERENCES clientes(dni),
  cod_pelicula NUMBER(5) CONSTRAINT pelicula_fk REFERENCES peliculas(cod),
  CONSTRAINT alquiler_pk PRIMARY KEY(dni, cod_pelicula)
);
```

#### Ejemplo con varias claves foráneas

```sql
CREATE TABLE existencias (
  tipo CHAR(9),
  modelo NUMBER(3),
  n_almacen NUMBER(1),
  cantidad NUMBER(7),
  CONSTRAINT exi_t_m_fk FOREIGN KEY(tipo, modelo) REFERENCES piezas,
  CONSTRAINT exi_nal_fk FOREIGN KEY(n_almacen) REFERENCES almacenes,
  CONSTRAINT exi_pk PRIMARY KEY(tipo, modelo, n_almacen)
);
```

#### Opciones ON DELETE / ON UPDATE

- **SET NULL:** pone nulos en las claves secundarias relacionadas.
- **CASCADE:** borra todos los registros relacionados.
- **SET DEFAULT:** coloca el valor por defecto.
- **NO ACTION:** impide la operación.

💡 _Ejemplo con opciones:_

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9),
  cod_pelicula NUMBER(5),
  CONSTRAINT alquiler_pk PRIMARY KEY(dni, cod_pelicula),
  CONSTRAINT dni_fk FOREIGN KEY (dni) REFERENCES clientes(dni) ON DELETE SET NULL,
  CONSTRAINT pelicula_fk FOREIGN KEY (cod_pelicula) REFERENCES peliculas(cod) ON DELETE CASCADE
);
```

---

### 7.7 Restricciones de integridad

- Son condiciones obligatorias sobre columnas.
- Se recomienda nombrarlas para identificarlas fácilmente.

#### Tipos de restricciones

- **NOT NULL:** prohíbe valores nulos.
- **UNIQUE:** obliga a que los valores sean únicos.
- **CHECK:** valida condiciones sobre los datos.
- **DEFAULT:** asigna un valor por defecto.

💡 _Ejemplo con CHECK:_

```sql
CREATE TABLE ingresos (
  cod NUMBER(5) PRIMARY KEY,
  concepto VARCHAR(40) NOT NULL,
  importe NUMBER(11,2) CONSTRAINT importe_min CHECK (importe > 0),
  CONSTRAINT importe_max CHECK (importe < 8000)
);
```

---

### 7.8 Conclusión del apartado

- La **creación de tablas** es el primer paso en el diseño físico de una base de datos.
- Se deben definir correctamente los **tipos de datos**, las **claves primarias y foráneas**, y las **restricciones de integridad**.
- Un buen diseño inicial evita problemas de redundancia, inconsistencia y pérdida de integridad en el futuro.

---
Perfecto, José 🙌. Vamos a continuar con el **octavo apartado del tema: “Tipos de datos – explicación detallada y diferencias entre sistemas”**, redactado como apuntes completos para Obsidian, punto por punto, con toda la información del PDF y ejemplos prácticos.

---
## 8. Tipos de datos

---

### 8.1 Importancia de los tipos de datos

- Al crear una tabla, cada columna debe tener un **tipo de datos** definido.
- El tipo de datos determina:
    - Qué valores se pueden almacenar (texto, números, fechas, binarios).
    - El rango y precisión de esos valores.
    - El espacio de almacenamiento que ocuparán.
- Elegir correctamente los tipos de datos es **fundamental** para:
    - Optimizar el rendimiento.
    - Evitar errores de integridad.
    - Asegurar compatibilidad entre distintos SGBD.

---

### 8.2 Tipos de datos según ANSI SQL y principales SGBD

|Descripción|ANSI SQL|SQL Server|Oracle|MySQL|
|---|---|---|---|---|
|Texto fijo|`CHAR(n)`|`CHAR(n)`|`CHAR(n)`|`CHAR(n)`|
|Texto variable|`VARCHAR(n)`|`VARCHAR(n)`|`VARCHAR2(n)`|`VARCHAR(n)`|
|Texto nacional fijo|`NCHAR(n)`|`NCHAR(n)`|`NCHAR(n)`|—|
|Texto nacional variable|`NVARCHAR(n)`|`NVARCHAR(n)`|`NVARCHAR2(n)`|—|
|Enteros|`INTEGER`, `SMALLINT`|`INT`, `SMALLINT`|`NUMBER(38)`|`INT`, `SMALLINT`, `TINYINT`|
|Decimales (coma fija)|`NUMERIC(m,d)`, `DECIMAL(m,d)`|`NUMERIC`, `DECIMAL`|`NUMBER(m,d)`|`DECIMAL(m,d)`|
|Flotantes (coma variable)|`FLOAT(b)`, `REAL`, `DOUBLE`|`FLOAT`|`NUMBER`|`FLOAT(m,d)`, `DOUBLE(m,d)`|
|Fecha|`DATE`|`DATE`|`DATE`|`DATE`|
|Fecha y hora|`TIMESTAMP`|`DATETIME`, `SMALLDATETIME`, `TIMESTAMP`|`TIMESTAMP`|`TIMESTAMP`, `DATETIME`, `TIME`|
|Intervalos|`INTERVAL`|—|`INTERVAL`|`YEAR`|
|Booleanos|`BIT`, `BOOL`|`BINARY`, `BIT`|—|`BIT`, `BOOL`|
|Texto largo|`CLOB`|`TEXT`, `NTEXT`|`CLOB`, `LONG` (en desuso)|`TEXT`, `MEDIUMTEXT`, `LONGTEXT`|
|Binario largo|`BLOB`|`IMAGE`|`RAW`, `LONG RAW`, `BLOB`|`BLOB`, `MEDIUMBLOB`, `LONGBLOB`|

---

### 8.3 Notas importantes

- **VARCHAR vs NVARCHAR**
    
    - `VARCHAR`: texto de longitud variable.
    - `NVARCHAR`: texto de longitud variable con soporte **Unicode**.
    - Unicode permite almacenar caracteres internacionales (ej. ñ, á, ü, 汉字).
    - Ejemplo:
        
        ```sql
        CREATE TABLE ejemplo (
          texto_normal VARCHAR(50),
          texto_unicode NVARCHAR(50)
        );
        ```
        
- **NUMERIC vs DECIMAL**
    
    - Ambos representan números con precisión fija.
    - Se diferencian en la implementación interna según el SGBD.
    - Ejemplo:
        
        ```sql
        CREATE TABLE precios (
          precio NUMERIC(10,2),
          descuento DECIMAL(5,2)
        );
        ```
        
- **FLOAT vs DOUBLE**
    
    - `FLOAT`: número en coma flotante con precisión variable.
    - `DOUBLE`: número en coma flotante con mayor precisión.
    - Ejemplo:
        
        ```sql
        CREATE TABLE medidas (
          valor_float FLOAT(7,3),
          valor_double DOUBLE(15,8)
        );
        ```
        
- **DATE vs TIMESTAMP**
    
    - `DATE`: almacena solo la fecha (día, mes, año).
    - `TIMESTAMP`: almacena fecha y hora completas.
    - Ejemplo:
        
        ```sql
        CREATE TABLE eventos (
          fecha DATE,
          fecha_hora TIMESTAMP
        );
        ```
        
- **CLOB vs BLOB**
    
    - `CLOB` (Character Large Object): texto de gran longitud.
    - `BLOB` (Binary Large Object): datos binarios (imágenes, vídeos, archivos).
    - Ejemplo:
        
        ```sql
        CREATE TABLE documentos (
          texto_largo CLOB,
          archivo BLOB
        );
        ```
        

---

### 8.4 Buenas prácticas al elegir tipos de datos

- Usar el tipo más **específico y ajustado** posible (ej. `CHAR(2)` para códigos de país).
- Evitar usar tipos demasiado grandes si no es necesario (ej. `VARCHAR(500)` para nombres).
- Usar `NVARCHAR` si se necesita soporte multilingüe.
- Definir precisión en números (`NUMERIC`, `DECIMAL`) para evitar errores en cálculos financieros.
- Usar `DATE` o `TIMESTAMP` en lugar de almacenar fechas como texto.
- Usar `CLOB` y `BLOB` solo cuando sea imprescindible (consumen más recursos).

---

### 8.5 Conclusión del apartado

- Los **tipos de datos** son la base de la definición de tablas en SQL.
- Cada SGBD tiene pequeñas diferencias, pero todos siguen el estándar ANSI/ISO.
- Elegir correctamente los tipos de datos garantiza **integridad, eficiencia y compatibilidad**.

---
## 9. Claves primarias

---

### 9.1 Definición

- La **clave primaria (PRIMARY KEY)** es el conjunto de una o más columnas que **identifican de forma única cada registro** de una tabla.
- Es el mecanismo fundamental para garantizar que no existan filas duplicadas ni registros sin identificación.

---

### 9.2 Propiedades de una clave primaria

- **Unicidad:** los valores de la clave primaria no pueden repetirse.
- **No nulos:** los campos que forman la clave primaria no pueden contener valores nulos (`NOT NULL`).
- **Índice automático:** al crear una clave primaria, el SGBD genera automáticamente un índice para acelerar búsquedas y accesos.
- **Integridad:** asegura que cada fila de la tabla sea única y reconocible.

---

### 9.3 Sintaxis general

```sql
CREATE TABLE nombreTabla (
  columna1 tipoDeDato [propiedades],
  columna2 tipoDeDato [propiedades],
  CONSTRAINT nombreRestriccion PRIMARY KEY (columna1 [, columna2 ...])
);
```

- `CONSTRAINT nombreRestriccion` → opcional, permite dar un nombre a la restricción.
- `(columna1, columna2, ...)` → lista de columnas que forman la clave primaria.

---

### 9.4 Ejemplos prácticos

#### a) Clave primaria simple

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(50)
);
```

- La columna `dni` identifica de forma única cada cliente.
- El sistema añade automáticamente `NOT NULL` y `UNIQUE` a `dni`.

---

#### b) Clave primaria con nombre de restricción

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) CONSTRAINT cliente_pk PRIMARY KEY,
  nombre VARCHAR(50)
);
```

- Se asigna el nombre `cliente_pk` a la restricción.
- Esto facilita localizarla en esquemas con muchas restricciones.

---

#### c) Clave primaria compuesta

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9),
  cod_pelicula NUMBER(5),
  CONSTRAINT alquiler_pk PRIMARY KEY (dni, cod_pelicula)
);
```

- La clave primaria está formada por dos columnas: `dni` y `cod_pelicula`.
- Esto significa que un mismo cliente (`dni`) puede alquilar varias películas, pero **no puede repetir el mismo código de película**.

---

### 9.5 Buenas prácticas

- **Nombrar las restricciones:** usar nombres descriptivos como `tabla_columna_pk`.
    - Ejemplo: `cliente_dni_pk`.
- **Evitar claves primarias demasiado largas:** usar claves simples o compuestas de pocas columnas.
- **Usar claves naturales o claves sustitutas:**
    - Claves naturales → atributos propios del objeto (ej. DNI).
    - Claves sustitutas → atributos artificiales creados para identificar (ej. `id_cliente` autoincremental).
- **Compatibilidad:** algunos SGBD permiten definir claves primarias con `AUTO_INCREMENT` (MySQL) o `IDENTITY` (SQL Server) para generar valores automáticamente.

---

### 9.6 Errores comunes

- Intentar definir una clave primaria en una columna que admite valores nulos.
- Definir una clave primaria en columnas que pueden repetirse.
- No nombrar las restricciones, lo que dificulta su gestión posterior.

---

### 9.7 Conclusión del apartado

- La **clave primaria** es esencial para garantizar la integridad de los datos.
- Define la identidad única de cada fila en una tabla.
- Puede estar formada por una sola columna o por varias (clave compuesta).
- Su correcta definición es la base para relaciones entre tablas y para evitar duplicados.

---
## 10. Claves ajenas (foráneas)

---

### 10.1 Definición

- Una **clave ajena (FOREIGN KEY)** es uno o más campos de una tabla que están relacionados con la **clave primaria de otra tabla**.
- Su función principal es garantizar la **integridad referencial**, es decir:
    - No se pueden insertar valores en la tabla secundaria que no existan en la tabla principal.
    - No se pueden borrar registros de la tabla principal si están siendo referenciados en la secundaria (salvo que se definan acciones específicas).

---

### 10.2 Sintaxis general

```sql
CREATE TABLE nombreTabla (
  columna1 tipoDeDato [propiedades],
  columna2 tipoDeDato [propiedades],
  CONSTRAINT nombreRestriccion FOREIGN KEY (columna1 [, columna2 ...])
    REFERENCES tablaPrincipal (columnaClavePrimaria)
    [ON DELETE | ON UPDATE {SET NULL | CASCADE | DEFAULT | NO ACTION}]
);
```

- `CONSTRAINT nombreRestriccion` → nombre opcional para la restricción.
- `FOREIGN KEY (columna1, ...)` → columnas de la tabla secundaria que forman la clave ajena.
- `REFERENCES tablaPrincipal (columnaClavePrimaria)` → tabla y columnas de la clave primaria referenciada.
- `[ON DELETE | ON UPDATE ...]` → acciones que se ejecutan al borrar o actualizar registros en la tabla principal.

---

### 10.3 Ejemplo básico

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9) CONSTRAINT dni_fk REFERENCES clientes(dni),
  cod_pelicula NUMBER(5) CONSTRAINT pelicula_fk REFERENCES peliculas(cod),
  CONSTRAINT alquiler_pk PRIMARY KEY (dni, cod_pelicula)
);
```

- `dni` en `alquiler` debe existir previamente en `clientes`.
- `cod_pelicula` en `alquiler` debe existir previamente en `peliculas`.
- La clave primaria de `alquiler` es compuesta: `(dni, cod_pelicula)`.

---

### 10.4 Ejemplo con varias claves foráneas

```sql
CREATE TABLE existencias (
  tipo CHAR(9),
  modelo NUMBER(3),
  n_almacen NUMBER(1),
  cantidad NUMBER(7),
  CONSTRAINT exi_t_m_fk FOREIGN KEY (tipo, modelo) REFERENCES piezas,
  CONSTRAINT exi_nal_fk FOREIGN KEY (n_almacen) REFERENCES almacenes,
  CONSTRAINT exi_pk PRIMARY KEY (tipo, modelo, n_almacen)
);
```

- `tipo` y `modelo` deben existir en la tabla `piezas`.
- `n_almacen` debe existir en la tabla `almacenes`.
- La clave primaria de `existencias` es compuesta por tres columnas.

---

### 10.5 Opciones de integridad referencial

Al definir una clave ajena, se pueden especificar acciones automáticas:

- **ON DELETE SET NULL**
    
    - Si se borra el registro en la tabla principal, las claves ajenas relacionadas se ponen a `NULL`.
- **ON DELETE CASCADE**
    
    - Si se borra el registro en la tabla principal, también se borran todos los registros relacionados en la secundaria.
- **ON DELETE SET DEFAULT**
    
    - Si se borra el registro en la tabla principal, las claves ajenas toman el valor por defecto definido en la columna.
- **ON DELETE NO ACTION**
    
    - Impide la operación de borrado si existen registros relacionados.

💡 Estas opciones también pueden aplicarse con **ON UPDATE**, para definir qué ocurre al modificar la clave primaria en la tabla principal.

>⚠️ **Nota importante (Oracle):**  
Oracle no implementa directamente las opciones `ON UPDATE CASCADE | SET NULL | SET DEFAULT`.  
Esto significa que no permite modificar el valor de una clave primaria si existen filas que la referencian.

---

### 10.6 Ejemplo con ON DELETE

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9),
  cod_pelicula NUMBER(5),
  CONSTRAINT alquiler_pk PRIMARY KEY (dni, cod_pelicula),
  CONSTRAINT dni_fk FOREIGN KEY (dni) REFERENCES clientes(dni) ON DELETE SET NULL,
  CONSTRAINT pelicula_fk FOREIGN KEY (cod_pelicula) REFERENCES peliculas(cod) ON DELETE CASCADE
);
```

- Si se borra un cliente en `clientes`, el campo `dni` en `alquiler` se pone a `NULL`.
- Si se borra una película en `peliculas`, se borran también los registros de `alquiler` que la referencian.

---

### 10.7 Buenas prácticas

- **Nombrar las restricciones:** usar nombres descriptivos como `tabla_columna_fk`.
    - Ejemplo: `alquiler_dni_fk`.
- **Definir acciones ON DELETE/ON UPDATE:** para evitar errores de integridad al borrar o modificar registros.
- **Evitar claves foráneas innecesarias:** solo cuando realmente exista una relación entre tablas.
- **Orden correcto de creación:** primero crear la tabla principal, luego la secundaria con la clave ajena.

---

### 10.8 Conclusión del apartado

- Las **claves ajenas** son esenciales para mantener la **integridad referencial** en bases de datos relacionales.
- Permiten relacionar tablas y asegurar que los datos estén siempre coherentes.
- Las opciones `ON DELETE` y `ON UPDATE` ofrecen flexibilidad para definir el comportamiento al modificar o eliminar registros.
- Una buena definición de claves foráneas evita inconsistencias y asegura relaciones sólidas entre tablas.

---
## 11. Restricciones de integridad

---

### 11.1 Definición

- Una **restricción** es una condición que debe cumplirse obligatoriamente en una o más columnas de una tabla.
- Sirven para **garantizar la calidad y coherencia de los datos**.
- Se pueden definir al crear la tabla (`CREATE TABLE`) o al modificarla (`ALTER TABLE`).
- Cada restricción puede tener un **nombre** para facilitar su identificación y gestión posterior.

💡 **Recomendación:** siempre nombrar las restricciones con un formato descriptivo:

- `tabla_columna_tipoRestriccion` → Ejemplo: `cliente_dni_nn` (restricción NOT NULL sobre la columna `dni` de la tabla `cliente`).

---

### 11.2 Sintaxis general

```sql
{CREATE TABLE nombreTabla |
 ALTER TABLE nombreTabla {ADD | MODIFY}}
(
  columna tipoDeDatos [propiedades]
  [CONSTRAINT nombreRestriccion] tipoRestriccion (columnas)
  [, siguienteColumna ...]
  [, CONSTRAINT nombreRestriccion tipoRestriccion (columnas) ...]
);
```

- `CONSTRAINT nombreRestriccion` → opcional, permite dar un nombre a la restricción.
- `tipoRestriccion` → puede ser `PRIMARY KEY`, `FOREIGN KEY`, `NOT NULL`, `UNIQUE`, `CHECK`, `DEFAULT`.

---

### 11.3 Tipos de restricciones

#### a) NOT NULL – Prohibir valores nulos

- Obliga a que una columna siempre tenga un valor.
- Se usa para campos que son obligatorios.

💡 _Ejemplo:_

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) NOT NULL
);
```

Con nombre de restricción:

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) CONSTRAINT cliente_dni_nn NOT NULL
);
```

---

#### b) UNIQUE – Valores únicos

- Obliga a que los valores de una columna (o conjunto de columnas) no se repitan.
- Se usa para claves candidatas.

💡 _Ejemplo simple:_

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) UNIQUE
);
```

Con nombre de restricción:

```sql
CREATE TABLE cliente (
  dni VARCHAR(9) CONSTRAINT dni_u UNIQUE
);
```

💡 _Ejemplo compuesto:_

```sql
CREATE TABLE alquiler (
  dni VARCHAR(9),
  cod_pelicula NUMBER(5),
  CONSTRAINT alquiler_uk UNIQUE (dni, cod_pelicula)
);
```

---

#### c) CHECK – Restricciones de validación

- Permite definir condiciones que deben cumplir los valores de una columna.
- No puede hacer referencia a otras filas ni incluir subconsultas.

💡 _Ejemplo simple:_

```sql
CREATE TABLE ingresos (
  cod NUMBER(5) PRIMARY KEY,
  concepto VARCHAR(40) NOT NULL,
  importe NUMBER(11,2) CONSTRAINT importe_min CHECK (importe > 0),
  CONSTRAINT importe_max CHECK (importe < 8000)
);
```

→ El campo `importe` debe estar entre 0 y 8000.

💡 _Ejemplo con referencia a otra columna:_

```sql
CREATE TABLE ingresos (
  cod NUMBER(5) PRIMARY KEY,
  concepto VARCHAR(40) NOT NULL,
  importe_max NUMBER(11,2),
  importe NUMBER(11,2),
  CONSTRAINT importe_maximo CHECK (importe < importe_max)
);
```

---

#### d) DEFAULT – Valor por defecto

- Permite asignar un valor automático a una columna si no se especifica ninguno al insertar un registro.

💡 _Ejemplo:_

```sql
CREATE TABLE articulo (
  cod NUMBER(7),
  nombre VARCHAR(25),
  precio NUMBER(11,2) DEFAULT 3.5
);
```

→ Si no se indica precio, se asigna automáticamente `3.5`.

---

### 11.4 Gestión de restricciones

#### Añadir restricciones

```sql
ALTER TABLE nombreTabla
ADD [CONSTRAINT nombre] tipoRestriccion (columnas);
```

💡 Ejemplo:

```sql
ALTER TABLE cliente
ADD CONSTRAINT cliente_email_u UNIQUE (email);
```

---

#### Eliminar restricciones

```sql
ALTER TABLE nombreTabla
DROP {PRIMARY KEY | UNIQUE (campos) | CONSTRAINT nombreRestriccion [CASCADE]};
```

- `PRIMARY KEY` → elimina la clave primaria.
- `UNIQUE` → elimina índices únicos.
- `CONSTRAINT nombreRestriccion` → elimina la restricción indicada.
- `CASCADE` → elimina también las restricciones dependientes.

💡 Ejemplo:

```sql
ALTER TABLE curso DROP PRIMARY KEY CASCADE;
```

---

#### Activar y desactivar restricciones

- **Desactivar:**

```sql
ALTER TABLE nombreTabla
DISABLE CONSTRAINT nombreRestriccion;
```

- **Activar:**

```sql
ALTER TABLE nombreTabla
ENABLE CONSTRAINT nombreRestriccion;
```

---

### 11.5 Errores comunes

- Intentar borrar una columna que forma parte de una restricción → error.
- Intentar eliminar una clave primaria sin usar `CASCADE` cuando existen claves foráneas que la referencian.
- Definir restricciones sin nombre → difícil de gestionar en esquemas grandes.

---

### 11.6 Conclusión del apartado

- Las **restricciones de integridad** son esenciales para asegurar que los datos sean correctos y coherentes.
- Tipos principales: `NOT NULL`, `UNIQUE`, `CHECK`, `DEFAULT`.
- Se pueden añadir, eliminar, activar o desactivar con `ALTER TABLE`.
- Una buena práctica es **nombrar todas las restricciones** para facilitar su gestión.

---
## 12. Modificación y eliminación de tablas

---

### 12.1 Eliminación de tablas

- Se utiliza la orden **`DROP TABLE`** seguida del nombre de la tabla.
- Al borrar una tabla:
    - **Desaparecen todos los datos** almacenados en ella.
    - Las **vistas y sinónimos** que dependan de la tabla seguirán existiendo, pero quedarán inservibles.
    - En bases de datos con transacciones, las transacciones pendientes se aceptan automáticamente (`COMMIT`).
    - Solo se pueden eliminar tablas sobre las que el usuario tenga **permisos de borrado**.
- ⚠️ El borrado es **irreversible** y no pide confirmación, por lo que debe usarse con cuidado.

💡 _Ejemplo:_

```sql
DROP TABLE clientes;
```

---

### 12.2 Modificación de tablas

Las tablas pueden modificarse con la orden **`ALTER TABLE`**.

#### a) Cambiar el nombre de una tabla

- **SQL estándar:**

```sql
ALTER TABLE nombreViejo RENAME TO nombreNuevo;
```

- **Oracle:**

```sql
RENAME nombreViejo TO nombreNuevo;
```

---

#### b) Borrar contenido de una tabla

- **Oracle** dispone de la orden no estándar **`TRUNCATE TABLE`**:

```sql
TRUNCATE TABLE clientes;
```

- Elimina todos los registros de la tabla, pero mantiene la estructura.
- Libera el espacio ocupado en el archivo de datos.

---

#### c) Añadir columnas

```sql
ALTER TABLE nombreTabla
ADD (nombreColumna tipoDeDatos [propiedades] [, ...]);
```

- Permite añadir nuevas columnas al final de la tabla.
- Ejemplo:

```sql
ALTER TABLE facturas ADD (fecha DATE);
```

- En algunos SGBD se requiere la palabra `COLUMN` tras `ADD`.

---

#### d) Borrar columnas

```sql
ALTER TABLE nombreTabla
DROP (columna [, columnaSiguiente ...]);
```

- Elimina columnas de forma irreversible, incluyendo sus datos.
- Restricciones:
    - No se puede eliminar la única columna de una tabla.
    - No se pueden eliminar claves primarias referenciadas por claves ajenas.
- Ejemplo:

```sql
ALTER TABLE facturas DROP (fecha);
```

---

#### e) Modificar columnas

```sql
ALTER TABLE nombreTabla
MODIFY (columna tipoDeDatos [propiedades] [, ...]);
```

- Permite cambiar el tipo de datos o propiedades de una columna.
- Hay que tener en cuenta los datos ya insertados para evitar contradicciones.
- Ejemplo:

```sql
ALTER TABLE facturas MODIFY (fecha DATE);
```

💡 En SQL estándar se usa `ALTER COLUMN` en lugar de `MODIFY`:

```sql
ALTER TABLE facturas ALTER COLUMN fecha DATE;
```

---

#### f) Renombrar columnas

- **Oracle:**

```sql
ALTER TABLE nombreTabla
RENAME COLUMN nombreAntiguo TO nombreNuevo;
```

- Ejemplo:

```sql
ALTER TABLE facturas RENAME COLUMN fecha TO fechaYhora;
```

---

#### g) Asignar valores por defecto

- Se usa la propiedad **`DEFAULT`** al crear o modificar columnas.
- Ejemplo:

```sql
CREATE TABLE articulo (
  cod NUMBER(7),
  nombre VARCHAR2(25),
  precio NUMBER(11,2) DEFAULT 3.5
);
```

→ Si no se indica precio, se asigna automáticamente `3.5`.

---

### 12.3 Añadir restricciones

```sql
ALTER TABLE nombreTabla
ADD [CONSTRAINT nombre] tipoRestriccion (columnas);
```

- `tipoRestriccion` puede ser `CHECK`, `PRIMARY KEY` o `FOREIGN KEY`.
- ⚠️ Las restricciones `NOT NULL` se añaden con `ALTER TABLE ... MODIFY`.

💡 Ejemplo:

```sql
ALTER TABLE cliente
ADD CONSTRAINT cliente_email_u UNIQUE (email);
```

---

### 12.4 Eliminar restricciones

```sql
ALTER TABLE nombreTabla
DROP {PRIMARY KEY | UNIQUE (campos) | CONSTRAINT nombreRestriccion [CASCADE]};
```

- `PRIMARY KEY` → elimina la clave principal (también el índice asociado).
- `UNIQUE` → elimina índices únicos.
- `CONSTRAINT nombreRestriccion` → elimina la restricción indicada.
- `CASCADE` → elimina también las restricciones dependientes.

💡 Ejemplo:

```sql
ALTER TABLE curso DROP PRIMARY KEY CASCADE;
```

---

### 12.5 Activar y desactivar restricciones

- **Desactivar:**

```sql
ALTER TABLE nombreTabla
DISABLE CONSTRAINT nombreRestriccion;
```

- **Activar:**

```sql
ALTER TABLE nombreTabla
ENABLE CONSTRAINT nombreRestriccion;
```

---

### 12.6 Errores comunes

- Intentar borrar una columna que forma parte de una restricción → error.
- Intentar eliminar una clave primaria sin `CASCADE` cuando existen claves foráneas que la referencian.
- No nombrar las restricciones → difícil de gestionar en esquemas grandes.

---

### 12.7 Conclusión del apartado

- **DROP TABLE** elimina tablas completas de forma irreversible.
- **ALTER TABLE** permite modificar la estructura: añadir, borrar, renombrar o cambiar columnas y restricciones.
- **TRUNCATE TABLE** borra datos sin eliminar la estructura.
- Una buena gestión de restricciones requiere nombrarlas y usar `CASCADE` cuando sea necesario.

---
Perfecto, José 🙌. Vamos con el **decimotercer apartado del tema: “Lenguaje de manipulación de datos – DML”**, redactado como apuntes completos para Obsidian, con toda la información importante, ejemplos y notas.

---
## 13. Lenguaje de manipulación de datos (DML)

---

### 13.1 Definición

- El **DML (Data Manipulation Language)** es el conjunto de sentencias SQL que permiten **trabajar directamente con los datos** almacenados en las tablas.
- Mientras que el DDL define la estructura, el DML se centra en **insertar, modificar, borrar y consultar registros**.
- Es el grupo de sentencias más utilizado en el día a día por usuarios y programadores.

---

### 13.2 Sentencias principales

#### a) INSERT – Inserción de datos

- Permite añadir nuevos registros a una tabla.
- Sintaxis general:

```sql
INSERT INTO nombreTabla (columna1, columna2, ...)
VALUES (valor1, valor2, ...);
```

💡 Ejemplo:

```sql
INSERT INTO cliente (dni, nombre, edad)
VALUES ('12345678A', 'José', 25);
```

- Si no se especifican columnas, se deben indicar valores para todas:

```sql
INSERT INTO cliente
VALUES ('12345678A', 'José', 25);
```

- Se pueden insertar múltiples filas en una sola sentencia (dependiendo del SGBD):

```sql
INSERT INTO cliente (dni, nombre, edad)
VALUES ('11111111B', 'Ana', 30),
       ('22222222C', 'Luis', 40);
```

---

#### b) UPDATE – Actualización de registros

- Permite modificar valores de columnas en registros existentes.
- Sintaxis general:

```sql
UPDATE nombreTabla
SET columna1 = valor1, columna2 = valor2, ...
WHERE condición;
```

💡 Ejemplo:

```sql
UPDATE cliente
SET nombre = 'Pepe', edad = 26
WHERE dni = '12345678A';
```

⚠️ **Importante:** siempre usar `WHERE` para evitar modificar todos los registros de la tabla.

```sql
UPDATE cliente SET edad = 30; -- ¡Modifica todas las filas!
```

---

#### c) DELETE – Borrado de registros

- Permite eliminar registros de una tabla.
- Sintaxis general:

```sql
DELETE FROM nombreTabla
WHERE condición;
```

💡 Ejemplo:

```sql
DELETE FROM cliente
WHERE dni = '12345678A';
```

⚠️ Si se omite `WHERE`, se borran **todos los registros** de la tabla:

```sql
DELETE FROM cliente; -- ¡Elimina toda la tabla!
```

---

#### d) SELECT – Consulta de datos

- Permite recuperar información de una o varias tablas.
- Sintaxis general:

```sql
SELECT columna1, columna2, ...
FROM nombreTabla
WHERE condición
ORDER BY columna;
```

💡 Ejemplo básico:

```sql
SELECT nombre, edad
FROM cliente
WHERE edad > 30
ORDER BY nombre;
```

💡 Ejemplo con alias y funciones:

```sql
SELECT nombre AS cliente, AVG(edad) AS edad_media
FROM cliente
GROUP BY nombre
HAVING AVG(edad) > 25;
```

---

### 13.3 Buenas prácticas

- **INSERT:** especificar siempre las columnas para mayor claridad.
- **UPDATE y DELETE:** usar siempre `WHERE` para evitar cambios masivos accidentales.
- **SELECT:** usar alias (`AS`) para mejorar la legibilidad de los resultados.
- **Transacciones:** combinar DML con TCL (`COMMIT`, `ROLLBACK`) para asegurar la consistencia de los cambios.

---

### 13.4 Errores comunes

- Insertar valores en columnas con restricciones (`NOT NULL`, `UNIQUE`, `CHECK`) que no se cumplen.
- Intentar actualizar o borrar registros sin `WHERE`, afectando toda la tabla.
- Usar tipos de datos incorrectos en `INSERT` (ej. texto en una columna numérica).
- No respetar claves foráneas: intentar insertar un valor que no existe en la tabla principal.

---

### 13.5 Conclusión del apartado

- El **DML** es el conjunto de sentencias que permiten manipular los datos de las tablas.
- Incluye las operaciones básicas: `INSERT`, `UPDATE`, `DELETE` y `SELECT`.
- Su uso correcto garantiza que los datos se mantengan coherentes y que las consultas sean claras y eficientes.
- Es el grupo de sentencias más utilizado en el trabajo diario con bases de datos.

---
## 14. Lenguaje de control de datos (DCL)

---

### 14.1 Definición

- El **DCL (Data Control Language)** es el conjunto de sentencias SQL destinadas a **gestionar la seguridad y los permisos de acceso** en la base de datos.
- Permite controlar:
    - Qué usuarios pueden acceder a la base de datos.
    - Qué operaciones pueden realizar sobre tablas, vistas u otros objetos.
- Es fundamental en entornos multiusuario, donde se necesita garantizar la **confidencialidad, integridad y disponibilidad** de los datos.

---

### 14.2 Sentencias principales

#### a) CREATE USER – Crear usuarios

- Permite dar de alta un nuevo usuario en el sistema.
- Sintaxis general (Oracle, SQL Server, MySQL varía):

```sql
CREATE USER nombreUsuario IDENTIFIED BY contraseña;
```

💡 Ejemplo (Oracle):

```sql
CREATE USER jose IDENTIFIED BY claveSegura;
```

💡 Ejemplo (MySQL):

```sql
CREATE USER 'jose'@'localhost' IDENTIFIED BY 'claveSegura';
```

---

#### b) GRANT – Otorgar permisos

- Permite conceder privilegios a un usuario o rol.
- Sintaxis general:

```sql
GRANT privilegio [, privilegio2 ...]
ON objeto
TO usuario;
```

💡 Ejemplo:

```sql
GRANT SELECT, INSERT
ON clientes
TO jose;
```

→ El usuario `jose` puede consultar (`SELECT`) e insertar (`INSERT`) en la tabla `clientes`.

---

#### c) REVOKE – Revocar permisos

- Permite retirar privilegios previamente concedidos.
- Sintaxis general:

```sql
REVOKE privilegio [, privilegio2 ...]
ON objeto
FROM usuario;
```

💡 Ejemplo:

```sql
REVOKE INSERT
ON clientes
FROM jose;
```

→ El usuario `jose` ya no podrá insertar registros en la tabla `clientes`.

---

### 14.3 Tipos de privilegios

- **De sistema:** afectan a la base de datos en general.
    - Ejemplo: `CREATE TABLE`, `CREATE USER`.
- **De objeto:** afectan a un objeto específico (tabla, vista, procedimiento).
    - Ejemplo: `SELECT`, `INSERT`, `UPDATE`, `DELETE` sobre una tabla concreta.

---

### 14.4 Roles

- Un **rol** es un conjunto de privilegios que se puede asignar a uno o varios usuarios.
- Facilita la administración de permisos en grupos de usuarios.
- Ejemplo:

```sql
CREATE ROLE analista;
GRANT SELECT ON clientes TO analista;
GRANT analista TO jose;
```

→ El rol `analista` tiene permiso de consulta sobre `clientes`.  
→ El usuario `jose` hereda ese permiso al recibir el rol.

---

### 14.5 Buenas prácticas

- **Principio de mínimo privilegio:** otorgar solo los permisos estrictamente necesarios.
- **Usar roles:** simplifica la gestión de permisos en grupos grandes.
- **Revocar permisos no usados:** mantener la seguridad evitando accesos innecesarios.
- **Nombrar usuarios y roles de forma clara:** facilita la administración.

---

### 14.6 Conclusión del apartado

- El **DCL** controla la seguridad y los permisos de acceso en la base de datos.
- Sentencias principales: `CREATE USER`, `GRANT`, `REVOKE`.
- Los privilegios pueden ser de sistema o de objeto.
- Los **roles** permiten agrupar permisos y simplificar la gestión.
- Una buena administración de DCL es clave para garantizar la seguridad en entornos multiusuario.

---

Perfecto, José 🙌. Vamos con el **decimoquinto apartado del tema: “Transacciones – COMMIT y ROLLBACK”**, redactado como apuntes completos para Obsidian, con lo más importante, ejemplos y notas.

---
## 15. Transacciones (COMMIT y ROLLBACK)

---

### 15.1 Definición

- Una **transacción** es un conjunto de operaciones SQL que se ejecutan como una unidad lógica de trabajo.
- El objetivo es garantizar que los datos permanezcan **consistentes** incluso si ocurre un error.
- Principio fundamental: **ACID**
    - **Atomicidad:** todas las operaciones se realizan o ninguna.
    - **Consistencia:** los datos pasan de un estado válido a otro.
    - **Aislamiento:** las transacciones no interfieren entre sí.
    - **Durabilidad:** una vez confirmadas, las operaciones permanecen guardadas.

---

### 15.2 Estados de los datos

- **Antes del COMMIT:**
    - Los cambios realizados por `INSERT`, `UPDATE` o `DELETE` son **temporales**.
    - Solo el usuario que ejecuta la transacción los ve.
- **Después del COMMIT:**
    - Los cambios se vuelven **permanentes** y visibles para todos los usuarios.
- **Después del ROLLBACK:**
    - Los cambios se **deshacen** y los datos vuelven al estado anterior.

---

### 15.3 Sentencias principales

#### a) COMMIT – Confirmar cambios

- Hace permanentes los cambios realizados en la transacción.
- Sintaxis:

```sql
COMMIT;
```

💡 Ejemplo:

```sql
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 1;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
```

→ Se confirma la transferencia de dinero entre cuentas.

---

#### b) ROLLBACK – Deshacer cambios

- Revierte los cambios realizados en la transacción desde el último `COMMIT`.
- Sintaxis:

```sql
ROLLBACK;
```

💡 Ejemplo:

```sql
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 1;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
ROLLBACK;
```

→ Se cancela la operación y los saldos vuelven al estado inicial.

---

#### c) SAVEPOINT – Punto de guardado

- Permite marcar un punto intermedio dentro de una transacción.
- Se puede hacer `ROLLBACK` hasta ese punto sin deshacer toda la transacción.
- Sintaxis:

```sql
SAVEPOINT nombrePunto;
ROLLBACK TO nombrePunto;
```

💡 Ejemplo:

```sql
SAVEPOINT inicio;
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 1;
ROLLBACK TO inicio;
```

→ Se deshace solo la última operación, manteniendo el resto de la transacción.

---

### 15.4 COMMIT implícito

- Algunas operaciones generan un **COMMIT automático**:
    - `DROP TABLE`
    - `ALTER TABLE`
    - `CREATE TABLE`
- Esto significa que no se pueden deshacer con `ROLLBACK`.

---

### 15.5 Buenas prácticas

- Usar transacciones para operaciones críticas (ej. transferencias bancarias).
- Confirmar (`COMMIT`) solo cuando se esté seguro de los cambios.
- Usar `SAVEPOINT` en transacciones largas para tener puntos de control.
- Evitar transacciones demasiado extensas que bloqueen recursos durante mucho tiempo.

---

### 15.6 Conclusión del apartado

- Las **transacciones** garantizan la coherencia y seguridad de los datos.
- `COMMIT` confirma cambios, `ROLLBACK` los deshace, y `SAVEPOINT` permite control intermedio.
- Son esenciales en sistemas multiusuario y en operaciones críticas.

---
#  ALTER USER – DESBLOQUEAR HR

---

### 🔑 Comando:

```sql
ALTER USER hr ACCOUNT UNLOCK IDENTIFIED BY hr;
```

---

### 1️⃣ ¿Qué hace este comando?

- **`ALTER USER hr`** → indica que se va a modificar el usuario llamado `hr`.
- **`ACCOUNT UNLOCK`** → desbloquea la cuenta del usuario (por ejemplo, si estaba bloqueada por intentos fallidos de login).
- **`IDENTIFIED BY hr`** → asigna la contraseña `hr` al usuario.

👉 En conjunto: desbloquea la cuenta del usuario `hr` y le establece la contraseña `hr`.

---

### 2️⃣ Contexto

- En Oracle, el usuario **HR** (Human Resources) es un **usuario de ejemplo** que viene con las bases de datos de práctica.
- Muchas veces está bloqueado por defecto, y para usarlo hay que desbloquearlo con este comando.
- Tras ejecutarlo, podrás iniciar sesión con:

```sql
CONNECT hr/hr;
```

---

### 3️⃣ Variantes útiles

- **Bloquear una cuenta:**

```sql
ALTER USER hr ACCOUNT LOCK;
```

- **Cambiar contraseña:**

```sql
ALTER USER hr IDENTIFIED BY nuevaClave;
```

- **Desbloquear y cambiar contraseña a la vez:**

```sql
ALTER USER hr ACCOUNT UNLOCK IDENTIFIED BY nuevaClave;
```

---

### 4️⃣ Buenas prácticas

- Nunca usar contraseñas triviales como `hr` en entornos reales.
- Desbloquear solo las cuentas necesarias para trabajar.
- Cambiar periódicamente las contraseñas de usuarios.
- Usar roles y privilegios para limitar lo que cada usuario puede hacer.

---

### ✅ Conclusión

El comando `ALTER USER hr ACCOUNT UNLOCK IDENTIFIED BY hr;` es una instrucción de **Oracle DCL** que desbloquea la cuenta del usuario `hr` y le asigna la contraseña `hr`. Es muy usado en entornos de práctica para acceder al esquema de ejemplo **HR**.

---
#  Ejemplo completo de creación de usuario y concesión de privilegios (Oracle)

---

### 🔑 Creación de usuario

```sql
CREATE USER usuario IDENTIFIED BY contrase_a
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;
```

- **`CREATE USER usuario IDENTIFIED BY contrase_a`** → crea un nuevo usuario llamado `usuario` con la contraseña `contrase_a`.
- **`DEFAULT TABLESPACE USERS`** → define el tablespace por defecto donde se almacenarán sus objetos (tablas, índices).
- **`TEMPORARY TABLESPACE TEMP`** → asigna el tablespace temporal que usará para operaciones intermedias (ej. ordenaciones grandes).

---

### 🛠 Concesión de privilegios básicos

```sql
GRANT CONNECT TO usuario;
GRANT RESOURCE TO usuario;
```

- **`CONNECT`** → permite al usuario iniciar sesión en la base de datos.
- **`RESOURCE`** → concede privilegios básicos de creación de objetos (tablas, procedimientos, etc.).

---

### 📊 Privilegios adicionales

```sql
GRANT CREATE MATERIALIZED VIEW TO usuario;
GRANT CREATE VIEW TO usuario;
```

- **`CREATE MATERIALIZED VIEW`** → permite crear vistas materializadas (consultas almacenadas físicamente).
- **`CREATE VIEW`** → permite crear vistas normales (consultas virtuales).

---

### 🔗 Privilegios de sinónimos y roles

```sql
GRANT CREATE PUBLIC SYNONYM TO usuario;
GRANT CREATE ROLE TO usuario;
```

- **`CREATE PUBLIC SYNONYM`** → permite crear sinónimos públicos (alias accesibles por todos los usuarios).
- **`CREATE ROLE`** → permite crear roles, que son conjuntos de privilegios agrupados.

---

### ✅ Conclusión

Este bloque de sentencias:

1. **Crea un usuario** con contraseña y tablespaces definidos.
2. **Le otorga permisos básicos** (`CONNECT`, `RESOURCE`).
3. **Le concede privilegios avanzados** para crear vistas, vistas materializadas, sinónimos públicos y roles.

👉 Es un ejemplo típico de cómo preparar un usuario en Oracle para que pueda trabajar con objetos de base de datos y gestionar sus propios roles.

---
