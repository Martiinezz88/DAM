# 📚 Unidad 02: Representación de la Información

## 1. Introducción

### 1.1. Dato, pieza de información e información

- Los ordenadores (sistemas de información) son máquinas diseñadas para procesar información.
    
- **Dato o pieza de información:** Es una representación formal y objetiva de un concepto (ejemplo: el número "30").
    
- **Información:** Es el resultado de interpretar ese dato en un contexto (ejemplo: "Hace calor").
    
- **Operación:** Es la regla o criterio que transforma el dato en información (ejemplo: "Si la temperatura es superior a 23 ºC, entonces hace calor").
    
- **Conclusión:** El dato por sí solo carece de sentido; solo se convierte en información útil al aplicarle una regla.
    

### 1.2 Representación interna de los datos

- Para almacenar y manipular datos y las operaciones de interpretación, el ordenador utiliza el **código binario**.
    
- **¡Atención!** Todo tipo de datos (números, letras, imágenes, sonidos) se representan internamente con este sistema.
    
- El sistema binario se basa en el uso exclusivo de dos dígitos: **0 y 1**.
    
- Esto se debe a que el _hardware_ trabaja con señales eléctricas que solo pueden asumir dos estados:
    
    - **$0\rightarrow$** Tensión o potencial eléctrico próximo a 0 voltios.
        
    - **$1\rightarrow$** Tensión que supera un umbral (normalmente 3 o 5 voltios).
        
- _Interesante:_ El potencial se entiende como la fuerza con la que circula la corriente.
    

### 1.3. El verdadero "conocimiento" de un ordenador

- Todos los componentes usan el sistema binario para representar y procesar.
    
- En realidad, los ordenadores no "saben" nada, solo:
    
    - "Entienden" 0 y 1.
        
    - Saben aplicar operaciones básicas (sumar, restar, comparar...).
        
- La diferencia es que lo hacen a una velocidad extremadamente alta, lo que permite resolver problemas complejos.
    

## 2. Sistemas de numeración

- Un sistema de numeración es un conjunto ordenado de símbolos para representar cantidades.
    
- La **base del sistema** es el número de símbolos que lo forman.
    

### 2.1. Descomposición de números en un sistema de numeración

- Cualquier número puede reconstruirse a partir de sus dígitos, su posición y la base del sistema.
    
- _Ejemplo decimal:_ $34,76 = 3 \cdot 10^{1} + 4 \cdot 10^{0} + 7 \cdot 10^{-1} + 6 \cdot 10^{-2}$.
    

### 2.2. Generalización a cualquier sistema de base B

- Un número $N$ en base $B$ se escribe $N=a_{n-1}...a_{0},a_{-1}...a_{-p}$.
    
    - $a$: Cada dígito, que es un entero entre 0 y $(B-1)$.
        
    - La parte entera son los dígitos antes de la coma.
        
    - La parte fraccionaria son los dígitos después de la coma.
        

### 2.3. Código binario

- Sistema con **base 2** y símbolos: 0 y 1.
    
- **Importante:** Cada dígito binario es un **bit** (_binary digit_), la unidad mínima de información.
    
- Se usa un subíndice para evitar confusiones de base (ej: $101_{10}$ vs $101_{2}$).
    

#### 2.3.1. Conversión de decimal a otra base

- **1. Parte entera** (Método de divisiones sucesivas):
    
    - Dividir el número entre la base $B$.
        
    - Guardar el resto en cada paso.
        
    - Leer los restos en **orden inverso**.
        
- **2. Parte fraccionaria** (Método de multiplicaciones sucesivas):
    
    - Multiplicar la fracción por la base $B$.
        
    - Tomar la parte entera del resultado en cada paso.
        
    - Leer los dígitos en **orden directo**.
        
- _Ejemplo:_ $45_{10}=101101_{2}$; 
![[Pasted image 20251216093930.png]]
- $6,25_{10}=110,01_{2}$.

![[Pasted image 20251216094023.png]]

![[Pasted image 20251216094039.png]]

- **Importante:**
    
    - **MSB** (_Most Significant Bit_): Bit más a la izquierda (mayor peso).
        
    - **LSB** (_Least Significant Bit_): Bit más a la derecha (menor peso).
        

#### 2.3.2. Conversión de un número binario a decimal

- Se representa como una suma de potencias de la base 2.
    
- Fórmula general: $N = \sum a_{i}B^{i}$.
    ![[Pasted image 20251216094114.png]]

#### 2.3.3. Pasos para convertir binario a decimal

1. Escribir el número binario.
    
2. Multiplicar cada cifra por $2$ elevado al exponente correspondiente (el exponente empieza en 0 para el último dígito entero, aumentando a la izquierda y disminuyendo a la derecha).
    
3. Sumar todos los productos.
    

- _Ejemplo:_ $101001_{2} \rightarrow 1\cdot2^5 + ... + 1\cdot2^0 = 41_{10}$.
- ![[Pasted image 20251216094154.png]]
    

### 2.4. Máximo valor representable con n bits

- Con $n$ bits se pueden representar exactamente $2^n$ valores diferentes.
    
- El rango de valores es de $0$ a $2^n-1$.
    
- _Ejemplo:_ Con 4 bits, $2^4=16$ valores, en el rango de 0 a 15.
    

### 2.5. Operaciones con números binarios

#### 2.5.1. Suma

- $1+1=0$ (con acarreo 1).

![[Pasted image 20251216094514.png]]

- **¡Atención!** Si el resultado excede los bits disponibles (ej. un acarreo final), se produce un **overflow** (desbordamiento).
    

#### 2.5.2. Resta

- $0-1=1$ (con préstamo de 1 a la siguiente columna).

![[Pasted image 20251216094538.png]]

- **Atención:** El préstamo se añade al sustraendo, no al minuendo. (En la práctica, la resta se resuelve mediante suma con complemento a dos).
    

#### 2.5.3. Multiplicación

- Se resuelve igual que en decimal (desplazando y sumando).

![[Pasted image 20251216094614.png]]
![[Pasted image 20251216094626.png]]

- **¡Atención!** Si hay más de dos unos en una columna, se suman en grupos de dos generando acarreos.
    

#### 2.5.4. División

- $1 \div 0$ = no definido (error).
    
- $0 \div 0$ = indeterminado.

![[Pasted image 20251216094656.png]]

- **Atención:** Se compara divisor y dividendo con el mismo número de cifras y se desplaza hasta que el divisor "quepa".
    

### 2.6. Representación de números negativos en binario

Cuando necesitamos representar números negativos en binario, existen varias formas de hacerlo. Las más importantes son cuatro:

1. Signo y magnitud.
    
2. Complemento a uno.
    
3. Complemento a dos.
    
4. Exceso-K.
    

La elección del método es una convención entre quien genera el número y quien lo interpreta. Si no existe acuerdo, el valor real podría malinterpretarse.

### 2.6.1. Signo y magnitud

Es el método más sencillo de comprender.

- El bit más significativo (MSB) indica el signo:
    
    - $0 \rightarrow$ positivo
        
    - $1 \rightarrow$ negativo
        
- Los demás bits representan el valor absoluto del número.
    

**Ejemplo con 4 bits**:

|**Decimal**|**Binario puro**|**Positivo (signo-magnitud)**|**Negativo (signo-magnitud)**|
|---|---|---|---|
|+5|101|0101|1101 (–5)|

- Con 4 bits, el rango es de –7 a +7.
    
- **¡Atención!** Existen dos formas de representar el 0 $\rightarrow$ $0000$ (+0) y $1000$ (–0). Esto complica las operaciones aritméticas.
    

### 2.6.2. Complemento a uno

Este método también usa el primer bit como signo, pero los negativos se obtienen invirtiendo todos los bits del número positivo (cambiando $0 \rightarrow 1$ y $1 \rightarrow 0$).

**Ejemplo con 4 bits**:

|**Decimal**|**Binario puro**|**Positivo (comp. a 1)**|**Negativo (comp. a 1)**|
|---|---|---|---|
|+5|101|0101|1010 (–5)|

**Ejemplo con 8 bits**:

- +5 $\rightarrow$ 00000101.
    
- –5 $\rightarrow$ invertir bits $\rightarrow$ 11111010.
    
- **¡Atención!** También existen dos ceros posibles (ej. $0000$ y $1111$).
    

### 2.6.3. Complemento a dos

Es el sistema más utilizado en la práctica, porque simplifica al máximo las operaciones aritméticas.

El proceso es:

1. Tomar el número positivo en binario.
    
2. Aplicar el complemento a uno (invertir bits).
    
3. Sumar 1 al resultado.
    

**Ejemplo (–5 en 8 bits)**:

1. +5 $\rightarrow$ 00000101.
    
2. Complemento a 1 $\rightarrow$ 11111010.
    
3. $+1 \rightarrow$ 11111011.
    

- Por tanto: +5 = 00000101 y –5 = 11111011.
    

Ventaja clave:

En complemento a dos, la resta puede realizarse como una suma con el negativo.

Ejemplo de resta por suma:

Restar $45_{10} - 21_{10}$ es igual a sumar $45_{10}$ al número $-21_{10}$, dando $24_{10}$.

- En binario (6 bits), $45 = 101101_{2}$ y $-21 = 101011_{2}$.
    
- Suma: $101101_{2} + 101011_{2} = 011000_{2} = 24_{10}$.
    

### 2.6.4. Exceso-K

Este método reparte el rango entre negativos y positivos desplazando el cero al centro del rango.

- Se define un valor de exceso $K$: $K = 2^{n-1}$.
    
- El rango resultante será: $[-K, K-1]$.
    

**Ejemplo con 3 bits ($n=3$)**:

- $K = 2^2 = 4$.
    
- El rango será $[-4, 3]$.
    

|**Decimal**|**Binario**|
|---|---|
|–4|000|
|–3|001|
|–2|010|
|–1|011|
|0|100|
|1|101|
|2|110|
|3|111|

**Ejemplo de conversión con 8 bits**:

- $K = 128$.
    
- $11001100_{2} = 204_{10} \rightarrow 204 - 128 = 76$.
    
- $00111100_{2} = 60_{10} \rightarrow 60 - 128 = –68$.
    

#### 2.6.4. Resumen práctico

- **Signo-magnitud:** simple, pero con dos ceros y operaciones complicadas.
    
- **Complemento a uno:** mejora, pero sigue teniendo dos ceros.
    
- **Complemento a dos:** el estándar actual (unificación de suma y resta).
    
- **Exceso-K:** muy usado en _hardware_ (ej. representación de exponentes en punto flotante, como en IEEE 754).

---

### 2.7. Números reales en los ordenadores

Para representar números reales (aquellos que tienen parte fraccionaria, como $3,14159$ o $0,0000001$), se utilizan dos métodos principales: **Coma fijo** y **Coma flotante**.

### 2.7.1. Representación en coma fijo

- Se reserva un número fijo de bits para la parte entera y otro número fijo de bits para la parte fraccionaria.
    
- La posición de la coma binaria **no varía** (está fija) durante las operaciones.
    
- **Ventaja:** Las operaciones son sencillas y rápidas, similares a las de enteros.
    
- **Inconveniente:** El rango de valores que se pueden representar es muy limitado.
    
**📌 Ejemplo:  
En un ordenador de 8 bits, podemos usar:**

- 5 bits para la parte entera  
      
    
- 3 bits para la parte fraccionaria
    

Formato: b7 b6 b5 b4 b3 , b2 b1 b0

- Máximo representable: 01111,111₂ = 15,875₁₀
    
- Mínimo positivo: 00000,001₂ = 0,125₁₀
    

Si en lugar de fijar la coma, esta fuera “flotante”, podríamos representar:
### 2.7.2. Representación en coma flotante

- Se utiliza para representar números muy grandes o muy pequeños, típicos de aplicaciones científicas y de ingeniería.
    
- Se basa en la notación científica. Un número $N$ se representa como:
    
    $$N = M \cdot B^{E}$$
    
    Donde:
    
    - **$M$** es la **mantisa** (los dígitos significativos).
        
    - **$B$** es la **base** (generalmente $2$ en binario).
        
    - **$E$** es el **exponente**.
        
**Ejemplo en binario:**

**Por ejemplo en decimal (B=10)  259,75 = 0,25975*103 o (0,25975;10;3) o, en código binario**

**259,75 →100000011,11 → 0,10000001111 * 29 → 0,10000001111 *  21001 → (0,10000001111;1001)**
### 2.7.3. Normalización

- Para evitar ambigüedades en la representación de un número y maximizar la precisión, se usa una forma normalizada.
    
- En binario, esto significa ajustar el exponente $E$ hasta que el punto binario se coloque inmediatamente a la izquierda del primer dígito significativo (el primer '1').

![[Pasted image 20251216095800.png]]

### 2.7.4. Estándar IEEE 754

Es el formato más utilizado en la industria para representar números en coma flotante, resolviendo ambigüedades y estandarizando la precisión.

Este estándar define no solo la representación de números _normales_, sino también:

- Números **desnormalizados** (para valores muy pequeños cercanos a cero).
    
- Infinito positivo ($+\infty$) e infinito negativo ($-\infty$).
    
- NaN (_Not a Number_), para resultados de operaciones inválidas o indefinidas.
    

La estructura general de cualquier número IEEE 754 se divide en tres campos:

|**Parte**|**Bits**|**Función**|
|---|---|---|
|**Signo (S)**|1|0 para positivo, 1 para negativo.|
|**Exponente (E)**|$n$|Indica la potencia de la base 2. Se almacena en formato de **Exceso-K** o sesgo.|
|**Mantisa (M)**|$m$|Representa los dígitos significativos del número.|

**Formatos Principales y su Estructura de Bits:**

|**Formato**|**Total Bits**|**Bits de Exponente (n)**|**Bits de Mantisa (m)**|**Sesgo (K)**|
|---|---|---|---|---|
|**Media precisión (Half Precision)**|16 bits|5|10|$K = 15$|
|**Simple precisión (Single Precision)**|32 bits|8|23|$K = 127$|
|**Doble precisión (Double Precision)**|64 bits|11|52|$K = 1023$|

![[Pasted image 20251216100122.png]]
**Detalles Clave de la Representación:**

1. **Bit Oculto (_Hidden Bit_):**
    
    - En la forma normalizada, la mantisa siempre comienza con un '1' antes del punto binario (es decir, $1.xxxx...$).
        
    - Este '1' es **implícito** o **asumido** y **no se almacena** físicamente en la memoria.
        
    - Esto permite que el campo de mantisa de $m$ bits represente $m+1$ bits de precisión real, optimizando el uso de la memoria.
        
2. **Representación del Exponente (Exceso-K o Sesgo):**
    
    - El exponente se guarda en formato **Exceso-K** para poder representar tanto exponentes positivos como negativos sin necesidad de un bit de signo adicional.
        
    - El sesgo ($K$) se calcula como:
        
        $$K = 2^{n-1} - 1$$
        
        donde $n$ es el número de bits del exponente.
        
    - El valor que realmente se almacena ($E_{\text{almacenado}}$) es el valor real del exponente ($E_{\text{real}}$) sumado al sesgo ($K$):
        
        $$E_{\text{almacenado}} = E_{\text{real}} + K$$
        
    - De esta forma, al leer el exponente, se debe restar el sesgo para obtener el valor real del exponente para la potencia de 2.
        

_El valor final del número en notación IEEE 754 se calcula como: $(\pm 1) \cdot (1.\text{Mantisa}) \cdot 2^{(\text{Exponente}_{\text{almacenado}} - K)}$_

---
---

## 3. Álgebra booleana

El Álgebra de Boole, o Álgebra Booleana, es la base de la lógica digital y de cómo funcionan los circuitos electrónicos dentro de un ordenador. Se utiliza para realizar operaciones lógicas con los números binarios (bits).

- El **1** se interpreta como el valor lógico **"verdadero" (true)**.
    
- El **0** se interpreta como el valor lógico **"falso" (false)**.
    
- Las operaciones se realizan sobre uno o dos operandos binarios.
    

### 3.1. Operación NOT (negación)

- **Símbolos:** NOT, $\neg$, $\overline{A}$, $!$
    
- **Función:** Invierte el valor lógico del operando. Es una operación unaria (de un solo operando).
    
- Se implementa mediante una **Puerta NOT** o inversor.
    

**Tabla de verdad NOT:**

|**Entrada (A)**|**Salida (A o NOT A)**|
|---|---|
|0|1|
|1|0|

### 3.2. Operación AND (conjunción lógica)

- **Símbolos:** AND, Y, $\wedge$, $\cdot$ (a menudo se omite el punto, $AB$)
    
- **Función:** Devuelve **1 (verdadero)** solo si **todos** los operandos son 1. Si al menos uno es 0, la salida es 0.
    
- Se implementa mediante una **Puerta AND**.
    

**Tabla de verdad AND:**

|**A**|**B**|**Salida (A ⋅ B o A AND B)**|
|---|---|---|
|0|0|0|
|0|1|0|
|1|0|0|
|1|1|1|

### 3.3. Operación OR (disyunción lógica)

- **Símbolos:** OR, O, $\vee$, $+$
    
- **Función:** Devuelve **1 (verdadero)** si **al menos uno** de los operandos es 1.
    
- Se implementa mediante una **Puerta OR**.
    

**Tabla de verdad OR:**

|**A**|**B**|**Salida (A + B o A OR B)**|
|---|---|---|
|0|0|0|
|0|1|1|
|1|0|1|
|1|1|1|

### 3.4. Operación XOR (disyunción exclusiva)

- **Símbolos:** XOR, $\oplus$
    
- **Función:** Devuelve **1 (verdadero)** únicamente cuando los dos operandos son **distintos**. Devuelve 0 si son iguales.
    
- Se implementa mediante una **Puerta XOR**.
    

**Tabla de verdad XOR:**

|**A**|**B**|**Salida (A ⊕ B o A XOR B)**|
|---|---|---|
|0|0|0|
|0|1|1|
|1|0|1|
|1|1|0|

### 3.5. Propiedades del álgebra booleana

El álgebra de Boole obedece a leyes y propiedades que permiten simplificar expresiones lógicas y diseñar circuitos más eficientes:

|**Propiedad**|**Ley de la Suma (OR)**|**Ley del Producto (AND)**|
|---|---|---|
|**Conmutatividad**|$A + B = B + A$|$A \cdot B = B \cdot A$|
|**Asociatividad**|$(A + B) + C = A + (B + C)$|$(A \cdot B) \cdot C = A \cdot (B \cdot C)$|
|**Identidad**|$A + 0 = A$|$A \cdot 1 = A$|
|**Complemento**|$A + \overline{A} = 1$|$A \cdot \overline{A} = 0$|
|**Idempotencia**|$A + A = A$|$A \cdot A = A$|
|**Absorción**|$A + (A \cdot B) = A$|$A \cdot (A + B) = A$|
|**Distributividad**|$A + (B \cdot C) = (A + B) \cdot (A + C)$|$A \cdot (B + C) = (A \cdot B) + (A \cdot C)$|
|**Leyes de De Morgan**|$\overline{A + B} = \overline{A} \cdot \overline{B}$|$\overline{A \cdot B} = \overline{A} + \overline{B}$|

---
## 4. Sistemas octal y hexadecimal

Estos sistemas de numeración se utilizan con frecuencia en informática porque sus bases (8 y 16) son potencias exactas de 2. Esto facilita enormemente la conversión directa y rápida con el sistema binario, y sirve para hacer más compacta la representación de grandes secuencias de bits.

### 4.1. Sistema octal

- **Base 8**.
    
- **Símbolos:** Utiliza los dígitos del 0 al 7.
    
- **Relación con Binario:** Un solo dígito octal se puede representar con exactamente **3 bits** ($2^3 = 8$).
    

**Tabla de conversión Decimal, Binario y Octal (3 bits):**

|**Octal**|**Decimal**|**Binario (3 bits)**|
|---|---|---|
|0|0|000|
|1|1|001|
|2|2|010|
|3|3|011|
|4|4|100|
|5|5|101|
|6|6|110|
|7|7|111|

### 4.2. Conversión de binario a octal

- **Proceso:** Se agrupan los bits del número binario en bloques de **3 bits**, comenzando siempre de derecha a izquierda. Si el último grupo a la izquierda no tiene 3 bits, se rellena con ceros a la izquierda.
    
- Luego, cada grupo de 3 bits se sustituye por su valor equivalente en octal.
    
- _Ejemplo:_ $1101011_{2}$
    
    - Agrupando: $\mathbf{001} \ \mathbf{101} \ \mathbf{011}$
        
    - Convirtiendo: $1 \ 5 \ 3$
        
    - Resultado: $153_{8}$
        

### 4.3. Conversión de octal a binario

- **Proceso:** Es la operación inversa. Cada dígito octal se convierte en su equivalente binario de **3 bits**.
    
- _Ejemplo:_ $7402_{8}$
    
    - Convirtiendo cada dígito: $7 \rightarrow 111$ | $4 \rightarrow 100$ | $0 \rightarrow 000$ | $2 \rightarrow 010$
        
    - Resultado: $111100000010_{2}$
        

### 4.4. Sistema hexadecimal

- **Base 16**.
    
- **Símbolos:** Utiliza los dígitos del 0 al 9 y las letras A, B, C, D, E, F, donde $A=10$ y $F=15$.
    
- **Relación con Binario:** Un solo dígito hexadecimal se puede representar con exactamente **4 bits** ($2^4 = 16$).
    

**Tabla de conversión Decimal, Binario y Hexadecimal (4 bits):**

|**Hexadecimal**|**Decimal**|**Binario (4 bits)**|
|---|---|---|
|0|0|0000|
|1|1|0001|
|2|2|0010|
|3|3|0011|
|4|4|0100|
|5|5|0101|
|6|6|0110|
|7|7|0111|
|8|8|1000|
|9|9|1001|
|A|10|1010|
|B|11|1011|
|C|12|1100|
|D|13|1101|
|E|14|1110|
|F|15|1111|

### 4.5. Conversión de binario a hexadecimal

- **Proceso:** Se agrupan los bits del número binario en bloques de **4 bits**, comenzando de derecha a izquierda. Si el último grupo a la izquierda no tiene 4 bits, se rellena con ceros a la izquierda.
    
- Luego, cada grupo de 4 bits se sustituye por su valor equivalente en hexadecimal.
    

**Ejemplo de conversión Binario a Hexadecimal:**

|**Número Binario**|**Agrupación en 4 bits**|**Hexadecimal**|
|---|---|---|
|1101011|0110 1011|6B|
|101110010010|1011 1001 0010|B92|

### 4.6. Conversión de hexadecimal a binario

- **Proceso:** Cada dígito hexadecimal se convierte en su equivalente binario de **4 bits**.
    
- _Ejemplo:_ $D4_{16}$
    
    - Convirtiendo cada dígito: $D \rightarrow 1101$ | $4 \rightarrow 0100$
        
    - Resultado: $11010100_{2}$
        
- **Nota importante:** La conversión a/desde decimal se puede hacer multiplicando o dividiendo por potencias de 8 o 16. Sin embargo, la conversión a través del binario es la más común y directa en un contexto informático.
    

---
## 5. Representación alfanumérica

### 5.1. Datos numéricos y alfanuméricos

- **Dato numérico:** Se pueden realizar operaciones matemáticas con él (ejemplo: edad, 45).
    
- **Dato alfanumérico:** No se pueden realizar operaciones matemáticas con él (ejemplo: nombre, número de móvil). Se representan entre comillas.
    
- Los datos alfanuméricos se denominan **cadenas de caracteres** (_strings_).
    

### 5.2. Representación interna

- Los caracteres se representan mediante **tablas de codificación** (cada carácter es un número entero).
    
- **ASCII (_American Standard Code for Information Interchange_)**:
    
    - Utiliza **7 bits** (128 caracteres).
        
    - Incluye alfabeto inglés, números, puntuación y caracteres de control (espacio, tabulador).
        
- **ASCII extendido**:
    
    - Utiliza **8 bits** (256 caracteres) para incluir símbolos gráficos y variantes latinas (ñ, acentos).
        
- **Unicode/UTF-8:** Es el estándar actual (más extendido), necesario para soportar todos los alfabetos del mundo (millones de caracteres). UTF-8 es el sistema de codificación variable más común de Unicode.
    

## 6. Sistema de unidades

El sistema de unidades se utiliza para medir el tamaño de los datos y la capacidad de almacenamiento o la velocidad de transmisión en un sistema informático.

### 6.1. Unidades base

- **Bit (b):** Es la unidad de información más pequeña. Corresponde a un único dígito binario (0 o 1).
    
- **Byte (B):** Es la unidad fundamental de almacenamiento. Un byte equivale a **8 bits**. Históricamente, se eligió este tamaño porque 8 bits son suficientes para codificar un carácter alfanumérico (como en ASCII).
    

### 6.2. Múltiplos y la doble notación

Los sistemas informáticos utilizan múltiplos para medir grandes cantidades de bytes, como Kilobyte (KB), Megabyte (MB), Gigabyte (GB), Terabyte (TB), etc.

Históricamente, esta nomenclatura ha provocado una confusión debido a que se utilizaban los prefijos del Sistema Internacional (SI), basados en potencias de 10, para cantidades que en realidad se medían en potencias de 2 (que son las que usa el hardware).

#### A. Sistema Internacional (SI) - Prefijos Decimales

- Los múltiplos son potencias de $1000$ ($10^3$).
    
- **Uso común:** Velocidad de redes (bits/segundo) y en ocasiones, capacidad de almacenamiento por razones comerciales o de estandarización.
    
- **Símbolos:** Se usa la letra 'k' mayúscula o minúscula para Kilobyte (kB o KB).
    

|**Unidad**|**Abreviatura**|**Valor Exacto**|
|---|---|---|
|Kilobyte|kB|$10^3$ bytes ($1000$ bytes)|
|Megabyte|MB|$10^6$ bytes ($1.000.000$ bytes)|
|Gigabyte|GB|$10^9$ bytes ($1$ billón de bytes)|
|Terabyte|TB|$10^{12}$ bytes|

#### B. Sistema IEC (Binario) - Prefijos Binarios

- Los múltiplos son potencias de $1024$ ($2^{10}$). Esta es la medida **real** que el hardware utiliza.
    
- Para evitar la confusión con el SI, la Comisión Electrotécnica Internacional (IEC, 1998) creó nuevos prefijos para las potencias de 2.
    
- **Símbolos:** Se añade la sílaba "bi" (binary) en el nombre y la letra 'i' en la abreviatura.
    

|**Unidad**|**Abreviatura**|**Valor Exacto**|
|---|---|---|
|Kibibyte|KiB|$2^{10}$ bytes ($1024$ bytes)|
|Mebibyte|MiB|$2^{20}$ bytes ($1.048.576$ bytes)|
|Gibibyte|GiB|$2^{30}$ bytes|
|Tebibyte|TiB|$2^{40}$ bytes|

**Importante:** La práctica común en la industria sigue mezclando las unidades. Cuando se habla de capacidad de un disco duro, se usa el prefijo decimal (GB, TB). Cuando se habla de memoria RAM o sistemas operativos, se suele usar la medida binaria (Gibibytes).

### 6.3. Distinción de la notación

Es crucial evitar la confusión entre bits y bytes en el contexto de velocidad de transmisión de datos:

- **kB (Kilobyte):** Unidad de almacenamiento, potencia de $1000$ bytes.
    
- **kb (Kilobit):** Unidad de velocidad de transmisión de datos, potencia de $1000$ bits.
    

Por ejemplo, una conexión de $100 \text{ Mbps}$ (megabits por segundo) es distinta a una tasa de transferencia de archivos de $100 \text{ MB/s}$ (megabytes por segundo).
