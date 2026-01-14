# 📚 Unidad 04 – Máquinas virtuales y contenedores (versión ampliada)

---

## 1️⃣ Virtualización

- **Definición ampliada:** técnica que permite ejecutar múltiples entornos aislados sobre un mismo hardware físico.
- **Tipos de virtualización:**
    - **Virtualización de hardware:** simula componentes físicos (CPU, RAM, disco).
    - **Virtualización de SO:** permite ejecutar varios sistemas operativos sobre un mismo host.
    - **Virtualización de aplicaciones:** ejecuta programas en entornos aislados.
- **Ejemplos adicionales:**
    - Emulación de consolas (ej. Dolphin, PCSX2).
    - Virtualización en la nube (AWS, Azure, Google Cloud).

---

## 2️⃣ Definición de máquina virtual

- Una VM es un **ordenador virtual dentro de otro ordenador**.
- **Componentes simulados:** CPU, memoria, disco duro, tarjeta de red, BIOS.
- **Casos de uso:**
    - Probar sistemas operativos sin afectar al host.
    - Crear entornos de laboratorio para formación.
    - Ejecutar software antiguo en hardware moderno.
    - Seguridad: aislar aplicaciones potencialmente peligrosas.

---

## 3️⃣ Tipos de máquinas virtuales

### 🔹 Máquinas virtuales de sistema (SVM)

- Replican un sistema completo.
- **Hipervisor tipo 1 (bare-metal):**
    - Ejemplos: VMware ESXi, Xen, Hyper-V Server.
    - Usados en **centros de datos** y **cloud computing**.
- **Hipervisor tipo 2 (hosted):**
    - Ejemplos: VirtualBox, VMware Workstation, QEMU.
    - Usados en **educación, pruebas y uso doméstico**.
- **Comparación:**
    - Tipo 1 → mejor rendimiento, más complejo de instalar.
    - Tipo 2 → más sencillo, pero con menor rendimiento.

### 🔹 Máquinas virtuales de proceso (PVM)

- Diseñadas para ejecutar un único proceso.
- **Ejemplos ampliados:**
    - JVM (Java Virtual Machine).
    - .NET CLR.
    - Python Virtual Machine (PyVM).
- **Ventaja clave:** independencia de plataforma → el mismo programa funciona en Windows, Linux o macOS.

---

## 4️⃣ Ventajas y desventajas de las máquinas virtuales

**Ventajas ampliadas:**

- Snapshot: guardar estado de la VM y restaurarlo.
- Clonado rápido de entornos.
- Aislamiento de fallos: si una VM se corrompe, no afecta al host.
- Uso en **DevOps** y **QA** para pruebas automatizadas.

**Desventajas ampliadas:**

- Consumo elevado de recursos (RAM, CPU).
- Necesidad de licencias adicionales si se instalan varios SO comerciales.
- Complejidad en la gestión de redes virtuales.

---

## 5️⃣ Configuración de una máquina virtual (VirtualBox)

- **Pasos básicos:**
    1. Descargar VirtualBox.
    2. Crear nueva VM.
    3. Asignar memoria y disco virtual.
    4. Montar ISO del sistema operativo.
    5. Instalar Guest Additions para mejorar integración.
- **Guest Additions ampliado:**
    - Drivers optimizados para gráficos y red.
    - Sincronización de hora entre host e invitado.
    - Carpetas compartidas automáticas.

---

## 6️⃣ Máquinas virtuales vs Contenedores

**Comparación ampliada:**

|Característica|Máquinas virtuales|Contenedores|
|---|---|---|
|SO|Cada VM tiene su propio SO|Comparten el SO del host|
|Rendimiento|Más lento (hipervisor)|Más rápido (sin hardware virtual)|
|Tamaño|GBs (imagen completa)|MBs (imagen ligera)|
|Portabilidad|Menos flexible|Muy portable|
|Uso típico|Ejecutar SO distintos|Microservicios, apps en la nube|

---

## 7️⃣ Contenedores: Docker

**Funcionamiento interno ampliado:**

- **cgroups:** controlan uso de CPU, RAM, disco.
- **namespaces:** aíslan procesos, redes, usuarios.
- **UnionFS:** sistema de archivos en capas → permite crear imágenes ligeras.

**Casos de uso:**

- Despliegue de aplicaciones web.
- Microservicios.
- Integración continua (CI/CD).
- Escalado automático en Kubernetes.

---

## 8️⃣ Comandos básicos de Docker (ampliados)

- `docker run -d imagen` → ejecutar en segundo plano.
- `docker exec -it contenedor bash` → abrir terminal dentro del contenedor.
- `docker stop contenedor` → detener contenedor.
- `docker rm contenedor` → eliminar contenedor.
- `docker rmi imagen` → eliminar imagen.
- `docker logs contenedor` → ver registros de ejecución.

---

## 8.2 Docker Compose (ampliado)

- **Archivo `docker-compose.yml`:** define servicios, redes y volúmenes.
- **Ejemplo sencillo:**

```yaml
version: '3'
services:
  web:
    image: nginx
    ports:
      - "8080:80"
  db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: ejemplo
```

- **Ventajas:**
    - Levantar varios servicios con un solo comando (`docker-compose up`).
    - Escalar servicios fácilmente.
    - Definir redes internas entre contenedores.

---
