En esta unidad vamos a ver como utilizar el lenguaje como HTML el cual sirve para dar cuerpo y forma a una pagina web.

---

# 📑 1. Estructura y Sintaxis de HTML 

Define los elementos fundamentales de un documento HTML

## 1. `<!DOCTYPE html>` 

**Función:** Define el tipo de documento. Es una declaración obligatoria para que el navegador interprete correctamente el contenido.


* **Ejemplo:**

```html
<!DOCTYPE html>

```

---

## 2. `<html>` 

**Función:** Es el elemento principal y raíz de todo el documento HTML. Todos los demás elementos descienden de él.


* **Ejemplo:**

```html
<html lang="es">
  </html>

```

El atributo `lang="es"` dentro de la etiqueta `<html>` sirve para **indicar el idioma principal del contenido de la página web**.

Este atributo es fundamental por varias razones:

### 1. Accesibilidad

- **Lectores de pantalla:** Ayuda a los lectores de pantalla (utilizados por personas con discapacidad visual) a pronunciar correctamente el texto, ya que saben qué reglas fonéticas aplicar (las del español en este caso).
    

### 2. Motores de Búsqueda (SEO)

- **Indexación:** Ayuda a los motores de búsqueda (como Google) a clasificar el contenido por idioma. Esto asegura que la página aparezca en los resultados de búsqueda cuando un usuario busca contenido en español.
    

### 3. Experiencia del Usuario

- **Traducción:** Indica a los navegadores web (como Chrome) el idioma del documento. Si un usuario tiene configurado un idioma diferente, el navegador sabrá que debe ofrecer la opción de traducir la página **del español** a su idioma.
    
- **Fuentes y Tipografía:** Permite que los navegadores apliquen las reglas tipográficas o de espaciado específicas del idioma si fuera necesario.
    
## Estructura de un documento HTML

```HTML
<!DOCTYPE html>
<html>

	<head>

	</head>

	<body>
	
	</body>

</html>
```

 
---

## 3. `<head>`

**Función:** Contiene datos no visibles que afectan la interpretación del documento (metadatos, título, estilos, codificación).


* **Ejemplo:**

```html
<head>

</head>
```

![[Pasted image 20260112211450.png]]

---

## 4. `<title>`

**Función:** Define el título que se muestra en la pestaña del navegador web.


* **Ejemplo:**

```html
<title>Mi primera página</title>

```

---

## 5. `<meta>`

**Función:** Especifica metadatos descriptivos (datos sobre los datos), como la codificación del juego de caracteres (`charset`). El valor estándar en HTML5 es `utf-8`.


* **Ejemplo:**

```html
<head>
  <meta charset="UTF-8">
</head>

```

---

## 6. `<body>`

**Función:** Contiene todo el contenido visible para el usuario (texto, imágenes, elementos multimedia).


* **Ejemplo:**

```html
<body>
  <h1>¡HOLA!</h1>
</body>

```


---

# 📑 2. Elementos de Bloque 

Se utilizan para crear la estructura de la página. Ocupan todo el ancho y provocan un salto de línea.

## 1. `<h1>` a `<h6>`

**Función:** Definen distintos niveles de encabezado. `<h1>` es el más importante, usado típicamente para el título principal de una noticia o documento.


* **Ejemplo:**

```html
<article>
  <h1>Título de la noticia principal</h1>
  <h2>Título de la primera noticia secundaria</h2>
</article>

```

![[Pasted image 20260112215147.png]]

---

## 2. `<p>`

**Función:** Define un párrafo de texto.


* **Ejemplo:**

```html
<p>
  Esto es un párrafo de ejemplo que contiene la información de la noticia.
</p>

```

---

## 3. `<div>`

**Función:** Es un agrupador genérico de contenidos (se usa principalmente para aplicar estilos o para la manipulación con JavaScript).


* **Ejemplo:**

```html
<div class="noticias-principales">
  <article>...</article>
  <article>...</article>
</div>

```

---

## 4. `<article>`

**Función:** Representa una unidad independiente de información, como una noticia, un artículo de blog o un comentario.


* **Ejemplo:**

```html
<article>
  <h1>Mi Blog</h1>
  <p>Contenido de la entrada del blog.</p>
</article>

```

---

## 5. `<address>`

**Función:** Contiene información de contacto para su autor o para el propietario del documento.


* **Ejemplo:**

```html
<address>
  Puede contactar con la editorial a través del sitio web
  <a href="https://www.paraninfo.es/">www.paraninfo.es</a>
</address>

```

---

## 6. `<footer>`

**Función:** Agrupa el contenido correspondiente al pie de página (ej. información de copyright, enlaces de contacto).


* **Ejemplo:**

```html
<footer>
  Esta web ha sido diseñada por DAM1 ® al precio de 0 €.
</footer>

```

---

## 7. Listas (`<ol>`, `<ul>`, `<li>`)

**Función:**

- `<ol>`: Lista ordenada (numerada).

- `<ul>`: Lista no ordenada (con viñetas).

- `<li>`: Elemento de la lista

* **Ejemplo:**

```html
<ol>
  <li>Paso 1: Pelar las patatas.</li>
  <li>Paso 2: Freír las patatas.</li>
</ol>

```

## 8. Comentario ( `<!-- contenido -->`)

```html
<!-- esto es una lista para montrar los pasos para hacer patatas fritas -->

<ol>
  <li>Paso 1: Pelar las patatas.</li>
  <li>Paso 2: Freír las patatas.</li>
</ol>
```

## 9. `aside`

Función:  
Representa contenido **relacionado**, pero **no esencial** con respecto al contenido principal.  
Suele usarse para:

- Barras laterales
- Notas adicionales
- Información complementaria
- Enlaces relacionados
- Publicidad contextual

El contenido del `<aside>` debe poder eliminarse sin afectar al significado principal del documento.

• Ejemplo:

```html
<article>
  <h2>Historia del lenguaje HTML</h2>
  <p>
    HTML fue creado por Tim Berners-Lee en 1991 como un lenguaje para
    estructurar documentos en la web.
  </p>

  <aside>
    <h3>Dato curioso</h3>
    <p>
      El primer navegador web también fue creado por Berners-Lee y se llamaba
      WorldWideWeb.
    </p>
  </aside>
</article>
```

---

## 10.  **`<blockquote>`**

Función:  
Se utiliza para **citas textuales largas** que provienen de otra fuente.  
El navegador suele mostrarlo con sangría para indicar que es una cita independiente del texto principal.

• Ejemplo:

```html
<blockquote>
  La educación es el arma más poderosa que puedes usar para cambiar el mundo.
</blockquote>
```

---

##  11.**`<details>`**

Función:  
Crea un bloque de contenido **plegable**, que el usuario puede abrir o cerrar.  
Es útil para mostrar información adicional, ejemplos, notas o explicaciones sin saturar la página.

Normalmente se usa junto con `<summary>`, que actúa como el título del bloque.

• Ejemplo:

```html
<details>
  <summary>Ver más información</summary>
  <p>
    Este texto aparece cuando el usuario despliega el bloque.
  </p>
</details>
```

## 12. **`<dialog>`**

Función:  
Representa un **cuadro de diálogo**, ventana modal o contenido emergente dentro de la página.  
Puede abrirse o cerrarse mediante el atributo `open` o con JavaScript.

• Ejemplo:

```html
<dialog open>
  <p>Este es un cuadro de diálogo.</p>
  <button>Cerrar</button>
</dialog>
```

![[Pasted image 20260112215118.png]]

---

## 13.  **`<dl>`**

Función:  
Define una **lista de definiciones** o lista de pares término–descripción.  
Se usa junto con `<dt>` y `<dd>`.

• Ejemplo:

```html
<dl>
  <dt>HTML</dt>
  <dd>Lenguaje de marcado para estructurar páginas web.</dd>
</dl>
```

---

## 14.  **`<dt>`**

Función:  
Representa el **término** dentro de una lista de definiciones (`<dl>`).

• Ejemplo:

```html
<dl>
  <dt>Navegador</dt>
  <dd>Programa que permite visualizar páginas web.</dd>
</dl>
```

---

## 15. **`<dd>`**

Función:  
Representa la **descripción** o definición del término `<dt>` dentro de un `<dl>`.

• Ejemplo:

```html
<dl>
  <dt>CSS</dt>
  <dd>Lenguaje para dar estilo a documentos HTML.</dd>
</dl>
```

---

##  16. **`<figure>`**

Función:  
Agrupa contenido independiente del flujo principal, como imágenes, gráficos, fragmentos de código o ilustraciones.  
Suele acompañarse de `<figcaption>`.

• Ejemplo:

```html
<figure>
  <img src="foto.jpg" alt="Paisaje">
  <figcaption>Paisaje al atardecer.</figcaption>
</figure>
```

---

## 17. **`<figcaption>`**

Función:  
Proporciona un **pie de figura** o descripción para el contenido dentro de `<figure>`.

• Ejemplo:

```html
<figure>
  <pre><code>console.log("Hola mundo");</code></pre>
  <figcaption>Ejemplo de código JavaScript.</figcaption>
</figure>
```

---

Si quieres, puedo continuar con más elementos semánticos (`<section>`, `<article>`, `<nav>`, `<header>`, `<footer>`, `<main>`, etc.) con este mismo formato.

---

## **18. `<header>`**

**Función:**  
Representa la **cabecera** de una sección o de toda la página.  
Suele contener: logotipo, menú, título, buscador, etc.

• **Ejemplo:**

```html
<header>
  <h1>Mi Blog Personal</h1>
  <p>Bienvenido a mi sitio web</p>
</header>
```

---

## **19. `<hr>`**

**Función:**  
Representa un **cambio de tema** o una **separación temática** dentro del contenido.  
Visualmente se muestra como una línea horizontal.

• **Ejemplo:**

```html
<p>Introducción al tema.</p>
<hr>
<p>Contenido principal.</p>
```

![[Pasted image 20260112215216.png]]

---

## **20. `<nav>`**

**Función:**  
Define una sección de **navegación**, normalmente un menú con enlaces a otras partes del sitio.

• **Ejemplo:**

```html
<nav>
  <ul>
    <li><a href="#inicio">Inicio</a></li>
    <li><a href="#servicios">Servicios</a></li>
    <li><a href="#contacto">Contacto</a></li>
  </ul>
</nav>
```

---

## **21. `<pre>`**

**Función:**  
Muestra el texto **respetando espacios, saltos de línea y formato original**.  
Se usa para código, poesía o texto donde el formato es importante.

• **Ejemplo:**

```html
<pre>
Línea 1
    Línea 2 (con espacios)
Línea 3
</pre>
```

![[Pasted image 20260113085010.png]]

---

# 📑 3. Elementos de Línea

Se utilizan para formatear o añadir semántica a pequeñas porciones de texto. Ocupan solo el espacio de su contenido y no generan salto de línea.

## 1. `<a>`

**Función:**  
Crea un **enlace** a otra página, sección, archivo o recurso.  
Es uno de los elementos más importantes de HTML.

### Atributos SIGNIFICATIVOS DE `<a>` 
#### **Atributo `href`**

Función:  
Define la **dirección** a la que apunta el enlace.

• Ejemplo:

```html
<a href="https://www.google.com">Ir a Google</a>
```

---

#### **Atributo `target`**

Función:  
Indica **cómo** se abre el enlace.

- `_blank` → nueva pestaña
- `_self` → misma pestaña (por defecto)

• Ejemplo:

```html
<a href="https://www.wikipedia.org" target="_blank">
  Abrir Wikipedia en otra pestaña
</a>
```

---

#### **Atributo `rel`**

Función:  
Define la **relación** con el recurso enlazado.  
Importante para seguridad cuando se usa `target="_blank"`.

• Ejemplo:

```html
<a href="https://ejemplo.com" target="_blank" rel="noopener noreferrer">
  Enlace seguro
</a>
```

---

#### **Atributo `download`**

Función:  
Hace que el navegador **descargue** el archivo en lugar de abrirlo.

• Ejemplo:

```html
<a href="documento.pdf" download>
  Descargar PDF
</a>
```

---

#### **Atributo `hreflang`**

Función:  
Indica el **idioma** del recurso enlazado.

• Ejemplo:

```html
<a href="https://es.wikipedia.org" hreflang="es">
  Wikipedia en español
</a>
```

---

#### **Atributo `type`**

Función:  
Indica el **tipo MIME** del recurso enlazado.

• Ejemplo:

```html
<a href="manual.pdf" type="application/pdf">
  Manual en PDF
</a>
```

---

#### **Atributo `ping`**

Función:  
Envía una **notificación POST** a las URLs indicadas cuando el usuario hace clic.  
Se usa para analítica o tracking.

• Ejemplo:

```html
<a
  href="https://www.ejemplo.com/articulo"
  ping="https://analytics.ejemplo.com/click"
>
  Leer artículo
</a>
```

---




---

## **2. `<abbr>`**

**Función:**  
Representa una abreviatura. El atributo `title` muestra el significado completo al pasar el ratón.

• Ejemplo:

```html
<p>
  De todos los videojuegos, el que más me gusta es el
  <abbr title="Call Of Duty">COD</abbr>.
</p>
```
![[Pasted image 20260113085033.png]]
---

## **3. `<b>`**

**Función:**  
Muestra el texto en **negrita**, sin añadir importancia semántica.

• Ejemplo:

```html
<p>
  Este texto está en <b>negrita</b>.
</p>
```

---

## **4. `<bdi>` / `<bdo>`**

**Función:**

- `<bdi>`: Aísla texto con dirección desconocida.
- `<bdo>`: Fuerza la dirección del texto mediante el atributo `dir`.

• Ejemplo:

```html
<p>Usuario: <bdi>اسم_المستخدم</bdi></p>

<p>
  <bdo dir="rtl">Texto mostrado de derecha a izquierda.</bdo>
</p>
```

---

## **5. `<br>`**

**Función:**  
Provoca un salto de línea.

• Ejemplo:

```html
Línea 1<br>Línea 2<br>Línea 3
```

---

## **6. `<cite>`**

**Función:**  
Representa el **título de una obra** (libro, película, artículo…).

• Ejemplo:

```html
<p>
  Mi libro favorito es <cite>El Hobbit</cite>.
</p>
```
![[Pasted image 20260113085047.png]]
---

## **7. `<code>`**

**Función:**  
Indica que el contenido es **código fuente**.

• Ejemplo:

```html
<p>
  La función principal es <code>main()</code>.
</p>
```

---

## **8. `<data>`**

**Función:**  
Asocia un valor legible con un valor de datos para máquinas.

• Ejemplo:

```html
<p>
  Precio: <data value="19.99">19,99 €</data>
</p>
```

---

## **9. `<del>`**

**Función:**  
Indica contenido **eliminado** (tachado).

• Ejemplo:

```html
<p>
  La versión actual es <del>4.0</del> 5.0.
</p>
```
![[Pasted image 20260113085102.png]]
---

## **10. `<dfn>`**

**Función:**  
Marca la **definición** de un término.

• Ejemplo:

```html
<p>
  <dfn>HTML</dfn> es el lenguaje para estructurar páginas web.
</p>
```

---

## **11. `<em>`**

**Función:**  
Indica **énfasis** (normalmente cursiva).

• Ejemplo:

```html
<p>
  Esto es <em>muy importante</em>.
</p>
```
![[Pasted image 20260113085114.png]]
---

## **12. `<i>`**

**Función:**  
Texto en **cursiva**, sin énfasis semántico.

• Ejemplo:

```html
<p>
  La palabra <i>lorem</i> se usa como texto de prueba.
</p>
```

---

## **13. `<ins>`**

**Función:**  
Indica contenido **insertado** (normalmente subrayado).

• Ejemplo:

```html
<p>
  La versión actual es <del>4.0</del> <ins>5.0</ins>.
</p>
```

---

## **14. `<kbd>`**

**Función:**  
Representa una **entrada del usuario**, como una tecla.

• Ejemplo:

```html
<p>
  Para enviar el mensaje, pulsa <kbd>F2</kbd>.
</p>
```

---

## **15. `<mark>`**

**Función:**  
Resalta texto como si estuviera marcado con rotulador.

• Ejemplo:

```html
<p>
  Mis módulos favoritos son <mark>Programación</mark> y <mark>ED</mark>.
</p>
```
![[Pasted image 20260113085126.png]]
---

## **16. `<noscript>`**

**Función:**  
Contenido alternativo cuando JavaScript está desactivado.

• Ejemplo:

```html
<noscript>
  <p>JavaScript está desactivado. Algunas funciones no estarán disponibles.</p>
</noscript>
```

---

## **17. `<q>`**

**Función:**  
Cita corta dentro de una frase. El navegador añade comillas.

• Ejemplo:

```html
<p>
  El profesor dijo: <q>Estudiad para el examen</q>.
</p>
```

---

## **18. `<s>`**

**Función:**  
Texto tachado que ya no es relevante (no indica edición).

• Ejemplo:

```html
<p>
  Precio original: <s>50 €</s> 30 €.
</p>
```
![[Pasted image 20260113085141.png]]
---

## **19. `<samp>`**

**Función:**  
Representa un **mensaje de salida** del sistema.

• Ejemplo:

```html
<p>
  El sistema responde: <samp>Mensaje enviado correctamente</samp>.
</p>
```

---

## **20. `<script>`**

**Función:**  
Contiene código ejecutable (normalmente JavaScript).

• Ejemplo:

```html
<script>
  console.log("Hola desde JavaScript");
</script>
```

---

## **21. `<slot>`**

**Función:**  
Define zonas de contenido en **Web Components**.

• Ejemplo:

```html
<template id="componente">
  <p><slot>Contenido por defecto</slot></p>
</template>
```

---

## **22. `<small>`**

**Función:**  
Texto más pequeño, usado para notas o aclaraciones.

• Ejemplo:

```html
<p>
  Oferta válida hasta mañana.
  <small>*Consulta condiciones.</small>
</p>
```

---

## **23. `<span>`**

**Función:**  
Contenedor en línea genérico para aplicar estilos o clases.

• Ejemplo:

```html
<p>
  Este texto tiene una palabra <span class="resaltado">resaltada</span>.
</p>
```

---

## **24. `<strong>`**

**Función:**  
Indica **importancia**. Se muestra en negrita.

• Ejemplo:

```html
<p>
  <strong>Atención:</strong> La entrega es mañana.
</p>
```

---

## **25. `<sub>` / `<sup>`**

**Función:**

- `<sub>`: Subíndice
- `<sup>`: Superíndice

• Ejemplo:

```html
<p>
  E = mc<sup>2</sup><br>
  H<sub>2</sub>O
</p>
```

---

## **26. `<template>`**

**Función:**  
Almacena contenido que no se muestra hasta que se activa con JavaScript.

• Ejemplo:

```html
<template id="fila">
  <p>Elemento oculto</p>
</template>
```

---

## **27. `<time>`**

**Función:**  
Representa una fecha u hora, legible por humanos y máquinas.

• Ejemplo:

```html
<p>
  La reunión será el <time datetime="2026-01-15">15 de enero</time>.
</p>
```

---

## **28. `<var>`**

**Función:**  
Representa una **variable** en programación o matemáticas.

• Ejemplo:

```html
<p>
  Cambia el valor de <var>offset</var> para mover la imagen.
</p>
```
![[Pasted image 20260113085156.png]]
---

## **29. `<wbr>`**

**Función:**  
Indica un punto donde se **puede cortar** una palabra larga.

• Ejemplo:

```html
<p>
  EstaPalabraMuyLarga<wbr>PodríaRomperElDiseño
</p>
```

---
# 📑 4. Contenido IncrustadoPermite añadir recursos externos dentro del documento HTML.
## **1. `<embed>`**

**Función:**  
Permite **incrustar contenido externo** mediante un plug‑in o componente adicional.  
Se usa para PDF, animaciones, reproductores antiguos, etc.

• Ejemplo:

```html
<embed src="documento.pdf" type="application/pdf" width="600" height="400">
```

---

## **2. `<iframe>`**

**Función:**  
Representa una **ventana incrustada** que muestra contenido HTML almacenado en otra ubicación.  
Se usa para vídeos, mapas, páginas externas, etc.

• Ejemplo:

```html
<iframe
  src="https://www.youtube.com/embed/VIDEO_ID"
  width="560"
  height="315"
  frameborder="0"
  allowfullscreen
></iframe>
```

---
![[Pasted image 20260113085237.png]]
## **3. `<object>`**

**Función:**  
Permite incrustar contenido como imágenes, HTML o recursos manejados por plug‑ins.  
Es una alternativa a `<img>`, `<iframe>` y `<embed>`.

• Ejemplo:

```html
<object data="documento.pdf" type="application/pdf" width="600" height="400">
  Documento PDF no soportado.
</object>
```

---

## **4. `<param>`**

**Función:**  
Define **parámetros de configuración** para un elemento `<object>`.

• Ejemplo:

```html
<object data="video.mp4" type="video/mp4" width="500">
  <param name="autoplay" value="true">
</object>
```

---

## **5. `<picture>`**

**Función:**  
Permite proporcionar **imágenes alternativas** según el tamaño de pantalla o formato soportado.  
Se usa para imágenes responsivas.

• Ejemplo:

```html
<picture>
  <source srcset="imagen.webp" type="image/webp">
  <source srcset="imagen.jpg" type="image/jpeg">
  <img src="imagen.jpg" alt="Paisaje">
</picture>
```

---

## **6. `<source>`**

**Función:**  
Proporciona **múltiples alternativas** para `<picture>`, `<audio>` o `<video>`.  
El navegador elige la más adecuada.

• Ejemplo (en vídeo):

```html
<video controls>
  <source src="video.mp4" type="video/mp4">
  <source src="video.webm" type="video/webm">
  Tu navegador no soporta el elemento video.
</video>
```

---

# 📑 5. Tablas en HTML

Permiten presentar datos organizados en filas y columnas.

## 1. `<table>` 

**Función:** Elemento contenedor que delimita el inicio y el fin de una tabla.

* **Ejemplo:**

```html
<table border="1">
  </table>

```

---

## 2. `<caption>`

**Función:** Título descriptivo o pie de la tabla.

* **Ejemplo:**

```html
<table>
  <caption>Tabla simple</caption>
  </table>

```

---

## 3. `<thead>`

**Función:** Agrupa el conjunto de filas que formarán el **encabezado** de la tabla.


* **Ejemplo:**

```html
<thead>
  <tr>
    <th>Encabezado 1</th>
    <th>Encabezado 2</th>
  </tr>
</thead>

```

---

## 4. `<tbody>`

**Función:** Delimita el **cuerpo** de la tabla, conteniendo las filas con los datos principales.


* **Ejemplo:**

```html
<tbody>
  <tr>
    <td>Dato1</td>
    <td>Dato2</td>
  </tr>
</tbody>

```

---

## 5. `<tfoot>`

**Función:** Agrupa el conjunto de filas que formarán el **pie** de la tabla, a menudo usado para totales o resúmenes.


* **Ejemplo:**

```html
<tfoot>
  <tr>
    <td><b>Pie de tabla 1</b></td>
    <td><b>Pie de tabla 2</b></td>
  </tr>
</tfoot>

```

---

## 6. `<tr>`

**Función:** Define una **fila** dentro de la tabla. Contiene elementos `<th>` o `<td>`.

* **Ejemplo:**

```html
<tr>
  <td>Dato de la fila 1</td>
  <td>Otro dato de la fila 1</td>
</tr>

```

---

## 7. `<th>`

**Función:** Define una **celda de encabezado** dentro de una fila (se muestra en negrita por defecto).


* **Ejemplo:**

```html
<tr>
  <th>Trimestre 1</th>
  <th>Trimestre 2</th>
</tr>

```

---

## 8. `<td>`

**Función:** Define una **celda de datos** (contenido normal) dentro del cuerpo de la tabla.


* **Ejemplo:**

```html
<tr>
  <td>1500</td>
  <td>3000</td>
</tr>

```

---

# 📑 6. Símbolos 

## **1. Usando entidades HTML 

Las entidades empiezan con `&` y terminan con `;`.

Las más usadas:

| Símbolo | Código HTML     |
| ------- | --------------- |
| `<`     | `&lt;`          |
| `>`     | `&gt;`          |
| `&`     | `&amp;`         |
| `"`     | `&quot;`        |
| `'`     | `&apos;`        |
| `©`     | `&copy;`        |
| `®`     | `&reg;`         |
| `€`     | `&euro;`        |
| `→`     | `&rarr;`        |
| `←`     | `&larr;`        |
| `↑`     | `&uarr;`        |
| `↓`     | `&darr;`        |
| `✓`     | `&check;`       |
| `✗`     | `&cross;`       |
| `$`     | ``&dollar``<br> |
| `∞`     | ``&infin``      |
| `£`     | ``&pound``      |
# 7. Atributos globales en HTML
## 1. `class`

Función:  
Agrupa elementos. Se usa para aplicar estilos CSS o acceder a ellos desde JavaScript.

• Ejemplo:

```html
<div class="alerta">Este bloque tiene estilo de alerta.</div>
```

---

## 2. `id`

Función:  
Identifica de forma única un elemento. Útil para aplicar estilos específicos o manipularlo con JS.

• Ejemplo:

```html
<p id="mensaje">Este párrafo tiene un ID único.</p>
```

---

## 3.  `contenteditable`

Función:  
Permite que el contenido del elemento sea editable directamente en el navegador.

• Ejemplo:

```html
<div contenteditable="true">Puedes editar este texto.</div>
```

---

## 3. `hidden`

Función:  
Oculta el elemento. No se muestra en la página aunque esté en el DOM.

• Ejemplo:

```html
<span hidden>Este texto está oculto.</span>
```

---

## 4. `lang`

Función:  
Define el idioma del contenido. Mejora accesibilidad y ayuda a los navegadores y buscadores.

• Ejemplo:

```html
<p lang="es">Hola mundo</p>
<p lang="en">Hello world</p>
```

---

## 5. `spellcheck`

Función:  
Activa o desactiva la revisión ortográfica y gramatical del navegador.

• Ejemplo:

```html
<textarea spellcheck="true">Texto editable con corrección.</textarea>
```

---

## 6. `style`

Función:  
Permite aplicar estilos CSS directamente al elemento, sin usar hojas externas.

• Ejemplo:

```html
<h1 style="color: blue;">Título azul</h1>
```

---

## 7.`tabindex`

Función:  
Define el orden de navegación con la tecla Tab.

• Ejemplo:

```html
<input tabindex="1">
<input tabindex="2">
```

---

## 8. `title`

Función:  
Muestra información adicional al pasar el cursor por encima del elemento.

• Ejemplo:

```html
<abbr title="HyperText Markup Language">HTML</abbr>
```

---

## 9. `translate`

Función:  
Indica si el contenido debe ser traducido automáticamente por el navegador.

• Ejemplo:

```html
<p translate="no">BrandName</p>
```

---
