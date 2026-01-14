# **01. INTRODUCCIÓN A CSS**

## **1.1. ¿Qué es CSS?**

CSS significa **Cascading Style Sheets** o **Hojas de Estilo en Cascada**.  
Es el lenguaje que permite **definir el aspecto visual** de documentos HTML o XHTML.

HTML = contenido  
CSS = apariencia  
JavaScript = comportamiento

CSS permite:

- Cambiar colores, tamaños, tipografías, márgenes, bordes…
- Separar el contenido (HTML) de la presentación (CSS).
- Aplicar estilos diferentes a un mismo documento sin modificar el HTML.

---

## **1.2. Evolución de CSS**

|Año|Versión|
|---|---|
|1996|CSS 1|
|1998|CSS 2|
|2011|CSS 2.1|
|2012|CSS 3|

CSS3 no es una versión única, sino un conjunto de **módulos** que se actualizan por separado (selectores, colores, fondos, animaciones, etc.).

---

# **02. ESTRUCTURA Y SINTAXIS DE CSS**

## **2.1. Cómo funciona CSS**

El navegador:

1. Lee el HTML (estructura y contenido).
2. Lee el CSS (reglas de estilo).
3. Aplica las reglas según prioridades y especificidad.

---

## **2.2. Partes de una regla CSS**

```css
selector {
    propiedad: valor;
}
```

### **Selector**

Indica **qué elemento(s)** del HTML se van a modificar.  
Ejemplos: `body`, `.clase`, `#id`, `p`, `h1`, `article p`, etc.

### **Declaraciones**

Cada declaración es un **par propiedad–valor**.  
Ejemplo:

```css
body {
    text-align: center;
    font-family: 'Roboto', sans-serif;
    background-color: black;
    color: white;
    /* Comentario */
}
```

---

# **03. APLICACIÓN DE CSS**

CSS puede aplicarse de **tres formas**:

## **3.1. CSS externo (recomendado)**

Archivo separado `.css`.

```html
<link rel="stylesheet" href="estilos.css">
```

Ventajas:

- Separación total entre contenido y estilo.
- Reutilizable.
- Más limpio.

---

## **3.2. CSS interno**

Dentro de `<style>` en el `<head>`.

```html
<style>
ul {
    list-style: none;
}
</style>
```

---

## **3.3. CSS inline**

Dentro del propio elemento HTML.

```html
<ul style="list-style: none;">
```

Desventajas:

- Muy difícil de mantener.
- Máxima prioridad → puede romper estilos.

---

# **04. PRIORIDADES Y ORDEN EN CSS**

Cuando varias reglas afectan al mismo elemento, el navegador debe decidir cuál aplicar.

## **4.1. Orden de prioridad por origen**

De menor a mayor prioridad:

1. Estilos del navegador (por defecto).
2. Estilos del usuario.
3. Estilos del autor (nosotros).
4. Dentro del autor:
    - **inline** (más fuerte)

# **06. SELECTORES EN CSS**

Los selectores son la base del CSS. Sirven para **indicar qué elementos HTML** deben recibir las reglas de estilo.

---

## **6.1. Selectores básicos**

### **Selector universal**

- Selecciona **todos los elementos** del documento.
- Sintaxis:
    
    ```css
    * { ... }
    ```
    

---

### **Selector de tipo**

- Selecciona todos los elementos de un tipo concreto.
- Ejemplos:
    
    ```css
    p { ... }
    h1 { ... }
    div { ... }
    ```
    

---

### **Selector de clase**

- Permite aplicar el mismo estilo a varios elementos.
- Se escribe con un **punto** delante del nombre.
- Un elemento puede tener **varias clases**.

Ejemplo CSS:

```css
.naranja {
    color: orange;
}
```

Ejemplo HTML:

```html
<h2 class="naranja">Soy una naranja</h2>
<p class="naranja">Soy una naranja</p>
<p>soy un párrafo sin color</p>
```

Ejemplo de varias clases:

```html
<div class="celda negro">Cuadrado</div>
```

---

### **Selector de identificador (ID)**

- Identifica un elemento **único**.
- No se puede repetir.
- Se escribe con **#**.

Ejemplo CSS:

```css
#verde {
    color: green;
}
```

Ejemplo HTML:

```html
<p id="verde">soy una manzana</p>
```

Reglas importantes:

- No pueden contener espacios.
- No pueden empezar por números.
- No llevan tildes.
- Se suelen escribir en **camelCase** o con **guiones**.

---

### **Selector de atributo**

Selecciona elementos que tienen un atributo concreto.

Ejemplo CSS:

```css
[disabled] {
    background-color: cyan;
}
```

Ejemplo HTML:

```html
<button disabled>Haz click!</button>
```

También permite expresiones como:

- `[type="text"]`
- `[href^="https"]` → empieza por
- `[href$=".pdf"]` → termina en
- `[class*="menu"]` → contiene

---

## **6.2. Agrupación de selectores**

Permite aplicar las mismas reglas a varios elementos.

```css
h1, h2, h3 {
    color: blue;
}
```

También se pueden mezclar tipos:

```css
button.rojo, #sub, [enabled] {
    color: red;
}
```

---

## **6.3. Combinadores**

Los combinadores permiten seleccionar elementos según su **relación jerárquica**.

### **1. Descendientes (espacio)**

Selecciona elementos dentro de otros, sin importar el nivel.

```css
body article p
```

---

### **2. Hijos directos (>)**

Solo selecciona hijos inmediatos.

```css
article > p
```

---

### **3. Hermanos adyacentes (+)**

Selecciona el elemento que está **justo después** del otro.

```css
p + img
```

---

### **4. Hermanos generales (~)**

Selecciona todos los hermanos posteriores, aunque no estén pegados.

```css
p ~ img
```

---

## **6.4. Pseudoclases**

Filtran elementos según su **estado**.

Sintaxis:

```css
selector:pseudoclase { ... }
```

Ejemplos comunes:

- `:active`
- `:checked`
- `:disabled`
- `:empty`
- `:first-child`
- `:hover`
- `:focus`
- `:visited`

Ejemplo:

```css
div p:first-child {
    color: red;
}
```

---

## **6.5. Pseudoclases de enlaces**

|Selector|Estado|
|---|---|
|`a:link`|Enlace no visitado|
|`a:visited`|Enlace visitado|
|`a:hover`|Ratón encima|
|`a:focus`|Tiene el foco|
|`a:active`|Se está pulsando|

---

## **6.6. Pseudoelementos**

Permiten seleccionar **partes internas** de un elemento.

Sintaxis:

```css
selector::pseudoelemento { ... }
```

Pseudoelementos más usados:

- `::before`
- `::after`
- `::first-letter`
- `::first-line`
- `::selection`

Ejemplo:

```css
#ElQuijote::after {
    content: "SEGUIR LEYENDO...";
}

#ElQuijote::first-letter {
    font-size: 3em;
}
```

---

# **07. PROPIEDADES CSS Y MODELO DE CAJAS**

## **7.1. ¿Qué es el modelo de cajas?**

Todo elemento HTML se representa como una **caja rectangular** formada por:

1. **Contenido**
2. **Padding** (relleno interior)
3. **Border** (borde)
4. **Margin** (margen exterior)

---

## **7.2. Propiedades básicas**

### **Padding**

Espacio entre el contenido y el borde.

```css
padding-top: 10px;
padding-right: 20px;
padding-bottom: 5px;
padding-left: 30px;
```

Atajo:

```css
padding: 10px 20px 5px 30px;
```

---

### **Border**

Tres propiedades principales:

- `border-width`
- `border-style`
- `border-color`

Ejemplo:

```css
div {
    border-top-width: 10px;
    border-right-width: 1em;
    border-bottom-width: thick;
    border-left-width: thin;
}
```

Estilos posibles:

- solid
- dotted
- dashed
- double
- groove
- ridge
- inset
- outset

---

### **Margin**

Espacio exterior que separa la caja de otras cajas.

---

## **7.3. Tipos de cajas**

### **Cajas de bloque**

- Ocupan todo el ancho disponible.
- Generan salto de línea.
- Aceptan width y height.

Ejemplos: `div`, `h1`, `p`, `section`.

---

### **Cajas en línea**

- No generan salto de línea.
- Solo ocupan el espacio de su contenido.
- **No** aceptan width ni height.
- El padding y margin vertical **no desplazan** a otros elementos.

Ejemplo: `span`.

---

## **7.4. Propiedad display**

Permite cambiar el comportamiento de una caja.

### **inline**

- Se comporta como texto.
- Ignora width y height.

### **block**

- Ocupa todo el ancho.
- Acepta width y height.

### **inline-block**

- Se coloca en línea.
- **Sí** acepta width y height.

### **flex**

Activa el modelo **flexbox**.

### **grid**

Activa el modelo **grid**.

---

## **7.5. Propiedad float**

Hace que un elemento “flote” a un lado.

Valores:

- `left`
- `right`
- `none`
- `inherit`

---

## **7.6. Propiedad position**

Controla cómo se posiciona un elemento.

|Valor|Descripción|
|---|---|
|static|Flujo normal|
|relative|Se mueve respecto a su posición original|
|absolute|Se posiciona respecto al ancestro posicionado|
|fixed|Fijo respecto a la ventana|
|sticky|Se pega al hacer scroll|

---

Si quieres, continúo con:

✔ **Actividades explicadas paso a paso**  
✔ **Ejemplos resueltos**  
✔ **Resumen final para estudiar**  
✔ **Guía práctica para usar selectores y modelo de cajas en ejercicios reales**

Solo di **“continúa”** y sigo.