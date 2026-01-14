
## **Metodologías Ágiles (Scrum y Kanban) + Git/GitHub**
---

# 🟦 **1. Conceptos Fundamentales de las Metodologías Ágiles**

## 🧠 **¿Qué significa “Ágil”?**

Las metodologías ágiles nacen del **Manifiesto Ágil (2001)**, que propone una forma distinta de trabajar frente a los métodos tradicionales en cascada.

### **Valores del Manifiesto Ágil**

- **Individuos e interacciones** por encima de procesos y herramientas.
- **Software funcionando** por encima de documentación exhaustiva.
- **Colaboración con el cliente** por encima de negociación contractual.
- **Respuesta al cambio** por encima de seguir un plan rígido.

### **Objetivo general**

Entregar valor al cliente **de forma rápida, continua y flexible**, adaptándose a los cambios y evitando la rigidez de los modelos tradicionales.

### **Cómo funcionan las metodologías ágiles**

- Trabajo en **iteraciones cortas**.
- Revisión frecuente del progreso.
- Ajustes constantes (mejora continua).
- Comunicación fluida entre todos los participantes.

---

# 🟥 **2. SCRUM — Marco de Trabajo Ágil**

Scrum se inspira en el rugby: un equipo que avanza en fases cortas, se reorganiza y vuelve a avanzar.

## 🧩 **Definición**

Scrum es un **marco de trabajo iterativo e incremental** para gestionar proyectos complejos.  
El trabajo se organiza en **Sprints**, ciclos cortos y fijos (2–4 semanas).

---

## 🟦 **2.1 Roles de Scrum**

### 🧑‍💼 **Product Owner (PO)**

- Representa al cliente o negocio.
- Responsable de **maximizar el valor del producto**.
- Gestiona y prioriza el **Product Backlog**.
- Decide qué se desarrolla y en qué orden.

### 🧑‍🏫 **Scrum Master (SM)**

- No es un jefe de proyecto.
- Es un **facilitador** y **coach** del equipo.
- Asegura que Scrum se entienda y se aplique correctamente.
- Elimina impedimentos que bloquean al equipo.

### 👥 **Equipo de Desarrollo**

- Grupo multidisciplinar y autoorganizado.
- Realiza el trabajo técnico.
- Entrega un **incremento funcional** al final del Sprint.

---

## 🟩 **2.2 Artefactos de Scrum**

### 📌 **Product Backlog**

- Lista priorizada de TODO lo que necesita el producto.
- Es dinámica: cambia según necesidades del cliente.
- La gestiona el Product Owner.

### 📌 **Sprint Backlog**

- Conjunto de elementos del Product Backlog seleccionados para el Sprint.
- Es el **plan del equipo** para ese Sprint.

### 📌 **Incremento**

- Resultado tangible y “terminado” al final del Sprint.
- Suma de lo completado en este Sprint + lo anterior.

---

## 🟨 **2.3 Eventos de Scrum (Ceremonias)**

### 🏁 **Sprint**

- Periodo de tiempo fijo (2–4 semanas).
- Se crea un incremento utilizable del producto.
- No se permiten cambios que pongan en riesgo el objetivo del Sprint.

### 📝 **Sprint Planning**

- Se decide **qué** se hará y **cómo** se hará.
- Participan PO, SM y equipo.

### ⏱ **Daily Scrum (15 minutos)**

Cada miembro responde:

- ¿Qué hice ayer?
- ¿Qué haré hoy?
- ¿Hay impedimentos?

### 👀 **Sprint Review**

- Se muestra el incremento al cliente/PO.
- Se obtiene feedback real.

### 🔄 **Sprint Retrospective**

- Reunión interna del equipo.
- Reflexión sobre qué mejorar en el proceso.
- Base de la **mejora continua**.

---

## 🟫 **Resumen de Scrum**

- Marco **prescriptivo**: reglas claras.
- Iteraciones fijas (Sprints).
- Roles definidos.
- Ideal cuando el objetivo está claro, pero el camino puede cambiar.

---

# 🟩 **3. KANBAN — Gestión Visual del Flujo**

Kanban nace en Toyota en los años 40 para optimizar la producción.  
Hoy se usa en software, marketing, RRHH y cualquier tipo de proyecto.

## 🧩 **Definición**

Kanban es un método ágil basado en **visualizar el trabajo** y **gestionar el flujo** de forma continua.

---

## 🟦 **3.1 Principios Fundamentales de Kanban**

### 🔵 **Visualizar el flujo de trabajo**

- Se usa un tablero con columnas (Por hacer → En progreso → Hecho).
- Permite ver el estado de todas las tareas.

### 🔵 **Limitar el trabajo en progreso (WIP)**

- Es el concepto más importante.
- Evita la multitarea y la sobrecarga.
- Obliga a terminar antes de empezar algo nuevo.

### 🔵 **Gestionar el flujo**

- Identificar cuellos de botella.
- Mejorar la eficiencia del sistema.

### 🔵 **Hacer explícitas las reglas**

- Todos deben entender cómo se mueve una tarjeta.

### 🔵 **Mejora continua**

- Ajustar el proceso regularmente.

---

## 🟩 **3.2 Elementos del Tablero Kanban**

### 🧱 **El Tablero**

Representa el flujo de trabajo.  
Ejemplo básico:

- Por Hacer
- En Progreso
- En Revisión
- Hecho

### 🗂 **Las Tarjetas**

- Cada tarjeta = una tarea.
- Pueden ser post-its o tarjetas digitales.

### 📊 **Las Columnas**

- Representan estados del trabajo.
- El movimiento de izquierda a derecha = avance.

### 🚦 **Límites WIP**

- Número máximo de tareas permitidas en una columna.
- Evitan saturación y revelan problemas.

---

## 🟧 **3.3 Metáfora de la Fábrica de Cocinas**

- **Por Hacer** = pedidos de clientes.
- **En Progreso (WIP 2)** = solo caben 2 cocinas en la línea de montaje.
- **En Revisión (WIP 1)** = solo un inspector.
- **Hecho** = cocinas entregadas.

**Conclusión:**  
Los límites WIP evitan el caos y muestran dónde está el cuello de botella.

---

## 🟫 **Resumen de Kanban**

- Flujo continuo (no hay Sprints).
- No define roles.
- Muy flexible.
- Ideal para soporte, mantenimiento o trabajo impredecible.

---

# 🟥 **4. Git y GitHub — Control de Versiones**

## 🧠 **El problema que resuelve Git**

- Archivos duplicados: _Tesis_v1, Tesis_v2_final, Tesis_revJuan…_
- Trabajo en equipo donde alguien pisa el trabajo de otro.
- Necesidad de volver a una versión anterior.

## 🧩 **Git es la solución**

Git es un **sistema de control de versiones**:

- Guarda el historial completo de cambios.
- Permite recuperar versiones anteriores.
- Permite trabajar en equipo sin conflictos.

---

## 🟦 **4.1 Git vs GitHub**

|Git|GitHub|
|---|---|
|Programa instalado en tu PC|Plataforma web|
|Guarda historial local|Guarda repositorios en la nube|
|Control de versiones|Colaboración, copia de seguridad|
|Motor|Garaje donde guardas tu coche|

---

## 🟩 **4.2 Conceptos Clave**

### 📁 **Repositorio**

- Carpeta del proyecto controlada por Git.
- Contiene una carpeta oculta `.git` con todo el historial.

### 📸 **Commit**

- “Foto instantánea” del estado del proyecto.
- Debe tener un mensaje claro: qué cambiaste y por qué.

### 🔄 **Flujo visual**

```
[Tus Archivos] -- git add --> [Staging] -- git commit --> [Repositorio Local]
                                      |
                                      git push
                                      |
                                      v
                               [GitHub (Remoto)]
```

---

## 🟨 **4.3 Comandos esenciales**

### 🔧 Configuración inicial

```
git config --global user.name "Tu Nombre"
git config --global user.email "tu.email@ejemplo.com"
```

### 📁 Crear repositorio

```
git init
```

### 🔍 Ver estado

```
git status
```

### ➕ Añadir archivos

```
git add archivo.txt
git add .
```

### 💾 Guardar cambios

```
git commit -m "Mensaje descriptivo"
```

### ☁ Subir a GitHub

```
git remote add origin URL
git branch -M main
git push -u origin main
```

---

## 🟫 **4.4 Actividad práctica (según tus apuntes)**

### Proyecto: **“Libro de Recetas”**

1. Crear carpeta
2. `git init`
3. Crear README
4. `git add` → `git commit`
5. Crear receta
6. Subir a GitHub
7. Ver resultado en la web

---

# 🟪 **5. Conexión entre Scrum, Kanban y Git**

- Scrum organiza el trabajo en **Sprints**.
- Kanban organiza el trabajo en **flujo continuo**.
- Git registra **todos los cambios** del proyecto.
- GitHub permite **colaborar y compartir** el trabajo.

Juntos forman un sistema completo de **gestión ágil + control de versiones**.

---
