# 📚 Unidad 05 – Linux Parte 1

--- 
## 1. ¿Qué es Linux?

**Definición**  
Linux es un **sistema operativo de estilo Unix**.  
Un sistema operativo (SO) es el software que actúa como intermediario entre el hardware (CPU, memoria, disco, dispositivos) y el usuario, permitiendo ejecutar programas y gestionar recursos.

**Explicación**  
Decir que Linux es “de estilo Unix” significa que adopta las características y filosofía de Unix:

- **Portabilidad:** puede ejecutarse en diferentes tipos de ordenadores.
- **Multitarea:** permite ejecutar varios procesos simultáneamente.
- **Multiusuario:** varios usuarios pueden trabajar en el mismo sistema con seguridad y permisos diferenciados.
- **Modularidad y simplicidad:** se compone de programas pequeños que hacen una tarea concreta y se combinan para realizar funciones más complejas.

---

### Historia de Unix y Linux

**Definición**  
Unix fue creado en los años 70 en los Bell Labs y se convirtió en el primer gran sistema operativo moderno.

 **Explicación**

- Se expandió en múltiples versiones propietarias: Xenix (Microsoft), HP-UX (HP), IRIX (Silicon Graphics), SCO (Novell), AIX (IBM).
- Problema: eran de pago y con código cerrado → no se podían estudiar ni modificar.
- **Minix (Andrew Tanenbaum, finales de los 80):** sistema operativo libre y educativo, inspirado en Unix.
- **Linux (Linus Torvalds, 1991):** kernel libre para PC, inspirado en Minix. Objetivo: que cualquiera pudiera usarlo, estudiarlo y mejorarlo.

👉 Curiosidad: a los sistemas de la familia Unix se les suele llamar *IX (ej. AIX, Minix, Linux).

---

### 1.1 GNU/Linux

**Definición**  
Linux es solo el **kernel** (núcleo del sistema operativo).  
El kernel es el “corazón” que gestiona los recursos del ordenador: CPU, memoria, disco, dispositivos, procesos y seguridad.  
El sistema operativo completo se forma al combinar el kernel con las utilidades GNU → **GNU/Linux**.

 **Explicación**  
Componentes de GNU/Linux:

- **Shell o terminal:** interfaz de texto para ejecutar comandos (ej. Bash).
- **Servicios o demonios:** programas que se ejecutan en segundo plano (ej. cron, ssh).
- **Servidor gráfico:** sistema que dibuja ventanas y elementos en pantalla (ej. Xorg, Wayland).
- **Entorno de escritorio:** interfaz gráfica completa (ej. GNOME, KDE, LXDE, XFCE).

👉 Atención: el sistema operativo no se llama “Linux”, se llama **GNU/Linux**, porque el kernel se acompaña de utilidades GNU.

Analogía: Linux (kernel) es el motor de un coche. El coche completo (GNU/Linux) incluye motor + ruedas + volante + carrocería + accesorios.

---

### 1.2 ¿Qué es una distribución?

**Definición**  
Una **distribución (distro)** es un paquete que reúne:

- Kernel Linux.
- Utilidades GNU.
- Gestor de paquetes (para instalar software).
- Instalador y configuradores.
- Aplicaciones por defecto (navegador, editor, reproductor).
- Entorno de escritorio.

**Explicación**  
Cada distribución decide qué programas incluir, qué entorno gráfico usar y cómo organizar la instalación.

Ejemplos de distribuciones:

- Ubuntu (y variantes: Lubuntu, Xubuntu, Kubuntu, Ubuntu Server).
- Debian.
- Fedora.
- Red Hat.
- Arch Linux.
- openSUSE.
- Linux Mint.
- LliureX (Valenciana).

👉 En este curso se usa **Lubuntu**, ligera y fácil de virtualizar.

Analogía: todas las distribuciones usan el mismo motor (Linux), pero cambian el diseño y accesorios. Ubuntu sería un coche fácil de conducir, Lubuntu uno ligero que consume poco, Arch uno personalizable, Debian uno robusto y estable.

---

### 1.3 ¿Dónde encontramos Linux?

 **Definición**  
Linux no es solo para expertos o académicos. Está presente en muchos ámbitos de la informática moderna.

 **Explicación**  
Usos reales:

- Escritorio: Windows domina, pero Linux crece. macOS/iOS derivan de FreeBSD.
- Servidores: la mayoría de Internet funciona sobre Linux.
- Móviles: Android está basado en Linux.
- Supercomputadores: casi todos usan Linux.
- IoT y embebidos: routers, televisores, coches, cámaras.
- Educación y ciencia: bajo coste, libertad, estabilidad.

Ejemplo práctico:

- Tu móvil Android usa Linux.
- Muchas páginas web que visitas están en servidores Linux.
- Tu router probablemente corre Linux.
- Los coches modernos llevan sistemas embebidos basados en Linux.

---

Perfecto, José 🙌. Ese formato que me muestras es el más adecuado para **Obsidian**: títulos claros, bloques de **Definición** y **Explicación**, listas bien organizadas y ejemplos prácticos.

Ya tienes el **punto 1 completo (1.0, 1.1, 1.2, 1.3)** en ese estilo. Lo que vamos a hacer ahora es continuar con el **punto 2 – Licencias de software** exactamente con la misma estructura, para que toda la unidad quede uniforme y lista para tu examen.

---
## 2. Licencias de software

**Definición**  
Una **licencia de software** es un contrato legal que establece las normas de uso de un programa.  
Este contrato se firma entre el propietario del software y el usuario final, e incluye aspectos como:

- Duración de la cesión de derechos.
- Alcance geográfico de la licencia.
- Limitaciones de responsabilidad por fallos.
- Número de copias permitidas.
- Posibilidad (o no) de transferir el software a terceros.

**Explicación**  
En inglés, la palabra _free_ puede significar tanto “gratis” como “libre”. Esto genera confusión: la gratuidad del software no siempre está relacionada con el tipo de licencia.  
Existen varios tipos de licencias:

- **Licencia propietaria:**
    
    - El uso del software requiere un pago.
    - Suele estar limitado a una o varias máquinas.
    - Generalmente no incluye el código fuente, solo el ejecutable.
    - Ejemplo: Microsoft Windows.
- **Licencia shareware:**
    
    - El software puede probarse con funcionalidades limitadas durante un tiempo.
    - Se requiere un pago para desbloquear todas las opciones.
    - Ejemplo: WinRAR.
- **Licencia freeware:**
    
    - Permite un uso y copia ilimitados sin coste alguno.
    - No necesariamente incluye el código fuente.
    - Ejemplo: Skype.
- **Software libre:**
    
    - Permite usar, copiar, modificar y distribuir libremente el software.
    - Siempre con acceso al código fuente.
    - Dentro de esta categoría se distinguen dos tipos:
        - **Licencias permisivas:** otorgan total libertad al usuario; el código modificado puede incluso distribuirse como software propietario.
            - Ejemplo: licencia BSD.
        - **Licencias no permisivas (copyleft):** obligan a que las copias, modificaciones y redistribuciones se mantengan bajo las mismas condiciones que el original.
            - Ejemplo: licencia GPL, utilizada en los productos GNU.

👉 Diferencia clave: _free software_ significa software libre, no necesariamente gratuito.

---
## 3. Instalación

### 3.1 Descarga

**Definición**  
El primer paso para instalar Lubuntu es obtener la **imagen ISO** del sistema operativo.

**Explicación**

- La ISO es un archivo que contiene una copia exacta del sistema de instalación.
- Se descarga desde la página oficial: [https://lubuntu.me/](https://lubuntu.me/).
- Una vez descargada, se debe grabar en un medio de instalación:
    - **CD/DVD** → usando programas como Brasero, Nero, Toast, ISO Burner.
    - **USB de arranque** → usando herramientas como Rufus, UltraISO.

---

### 3.2 Instalación

**Definición**  
La instalación consiste en arrancar el ordenador desde el medio de instalación y seguir los pasos del instalador gráfico.

**Explicación**

1. Reinicia el ordenador con el medio conectado.
    - Si usas DVD, insértalo en el lector.
    - Si usas USB, conéctalo antes de arrancar.
2. El sistema mostrará un menú de arranque con opciones como:
    - _Try or Install Lubuntu_
    - _Lubuntu (safe graphics)_
    - _Test memory_
3. Selecciona **Try or Install Lubuntu**.
	1. ![[Pasted image 20251217013046.png]]
4. Una vez cargado el entorno Live, abre la herramienta **Install Lubuntu**.
5. El instalador pedirá parámetros básicos:
    - Idioma.
    - Región / zona horaria.
    - Distribución del teclado.
    - ![[Pasted image 20251217013117.png]]
    - ![[Pasted image 20251217013146.png]]
    - ![[Pasted image 20251217013156.png]]
6. Finalmente, se elige el tipo de instalación:
    - Automática (usar todo el disco).
    - Manual (particionado personalizado).
    - ![[Pasted image 20251217013218.png]]

👉 Atención: para arrancar desde DVD o USB es necesario configurar la BIOS/UEFI y, en ocasiones, modificar el orden de arranque.

---

### 3.3 El disco duro

**Definición**  
En Linux, los discos se representan como archivos dentro del directorio `/dev`.

**Explicación**

- Tipos de discos:
    - PATA (IDE) → `hd`
    - SATA / SCSI / NVMe → `sd`
- A cada disco se le asigna una letra según el orden de conexión: `sda`, `sdb`, `sdc`…
- Las particiones dentro de cada disco se numeran: `sda1`, `sda2`…

Ejemplo: `sdb1` → primera partición del segundo disco SATA.

**Particiones típicas en Linux:**

- `/` → sistema principal.
- `swap` → memoria de intercambio.
- `/home` → datos del usuario.

👉 Recomendación: el tamaño de la swap suele ser el doble de la memoria RAM. En discos grandes, se puede asignar hasta cuatro veces la RAM disponible.

![[Pasted image 20251217013248.png]]

**Carpetas importantes del sistema:**

- `/boot` → archivos de arranque.
- `/root` → directorio del superusuario.
- `/var` → archivos variables (logs, bases de datos).
- `/tmp` → archivos temporales.
- `/usr` → programas y datos compartidos.
- `/home` → carpetas personales de los usuarios.
- `/dev` → dispositivos físicos simulados.
- `/etc` → archivos de configuración del sistema.
- `/media` → punto de montaje para dispositivos externos (USB, SD).

---

### Estrategias de particionado

**Definición**  
El particionado consiste en dividir el disco en secciones (particiones) para organizar el sistema.

**Explicación**  
Opciones más comunes:

1. Partición única `/` → todo el sistema en una sola partición (opción por defecto).
2. Separar `/` y `/home` → recomendable, ya que los datos personales quedan independientes del sistema.
3. Separar `/`, `/home` y `/var` → útil si se manejan bases de datos o registros voluminosos.

En este curso se crean 3 particiones:

- `/` (sistema).
- `/home` (datos del usuario).
- `swap` (memoria virtual).

Para crear una partición, selecciona el espacio vacío del disco y pulsa el botón “+”. Asigna:

* Tamaño (MB).
 * Tipo de partición (primaria o lógica).
* Sistema de archivos (generalmente ext4).
* Punto de montaje (/, /home, etc.).

💬 Dato interesante: cuando conectas un USB, Linux lo monta automáticamente en /media.

**Tipos de particiones:**

- **Primarias:** máximo 4 por disco.
- **Extendidas:** permiten crear múltiples particiones lógicas dentro de ellas.

👉 Atención: al aceptar la tabla de particiones, todos los datos previos del disco se eliminan.

![[Pasted image 20251217013518.png]]

---

### 3.4 El sector de arranque

**Definición**  
El último paso de la instalación consiste en seleccionar en qué disco duro queremos instalar el **gestor de arranque (bootloader)**.

**Explicación**

- La BIOS/UEFI tiene configurado un orden de búsqueda en los diferentes dispositivos de almacenamiento para localizar un sector de arranque (**MBR, Master Boot Record**) que permita cargar un sistema operativo.
- El programa de la BIOS recorre esa lista hasta encontrar un dispositivo desde el cual arrancar.
- Cada sistema operativo debe instalar y configurar su propio sector de arranque, independientemente de su instalación en disco.
- Cuando solo tenemos un sistema operativo no hay complicación.
- Si instalamos varios, cada uno sobrescribirá el sector de arranque del anterior. Aunque tengamos varios sistemas instalados, solo podremos iniciar el último.
- Las distribuciones de Linux suelen ser cuidadosas: al instalar su gestor de arranque, normalmente detectan otros sistemas ya presentes y configuran un menú de inicio mediante **GRUB**, desde el que podremos elegir qué sistema operativo arrancar.

💬 **Curiosidad**  
Si el último sistema instalado es de la familia Microsoft Windows, este solo reconocerá sistemas de la misma familia. Por ello, si vas a tener arranque dual, instala primero Windows y después Linux.

💬 **Consejo**  
Si tienes problemas con el sector de arranque, recuerda que el sistema operativo sigue en el disco; el problema es solo que no puedes acceder a él.  
Existen utilidades para reparar el arranque, como **Rescatux**, un excelente Live DVD/USB que puedes descargar y usar para recuperar el acceso.

---

### 3.5 Creación de usuario administrador

**Definición**  
Antes de copiar los archivos al disco, se debe crear un usuario con perfil de administrador.


![[Pasted image 20251217013601.png]]


**Explicación**

- Se define:
    - Nombre de usuario.
    - Contraseña.
    - Nombre del equipo.
- Opciones adicionales:
    - Iniciar sesión automáticamente sin pedir contraseña.
    - Proteger la cuenta con contraseña obligatoria.

Una vez creado el usuario, el sistema copia los archivos y la instalación finaliza.

---

## 4. Aplicaciones

### 4.1 Aplicaciones básicas

**Definición**  
Cada distribución de Linux incluye diferentes programas según sus objetivos, pero existen tres aplicaciones fundamentales que siempre están presentes en cualquier sistema: explorador de ficheros, editor de texto y terminal.

**Explicación**

- **Explorador de ficheros:**
    
    - Equivalente al Explorador de Windows o Finder de macOS.
    - Permite navegar por carpetas, copiar, mover y eliminar archivos.
    - En Lubuntu se utiliza **PCManFM**.

![[Pasted image 20251217013805.png]]

- **Editor de texto:**
    
    - Equivalente al Bloc de notas de Windows.
    - Sirve para crear y editar archivos de texto plano.
    - En Lubuntu se incluye **FeatherPad**.
    - Para programación o edición avanzada se recomienda instalar **Visual Studio Code**.

![[Pasted image 20251217013822.png]]

- **Terminal:**
    
    - Permite interactuar con el sistema en modo texto mediante comandos.
    - Es una herramienta muy potente para administración y configuración.
    - En Lubuntu la terminal por defecto es **QTerminal**.

![[Pasted image 20251217013838.png]]

---
### 4.2 Cómo instalar programas en Linux

#### 4.2.1 Instalación usando paquetes

**Idea básica**  
En Linux, los programas se instalan mediante **paquetes**.  
Un paquete es como una “caja” que trae el programa y todo lo necesario para que funcione (instrucciones de instalación y dependencias).

👉 Piensa en ello como cuando instalas una app en tu móvil: descargas un archivo y el sistema sabe cómo colocarla en tu dispositivo.

**Formatos principales de paquetes:**

- `.deb` → usado en Ubuntu y Debian (como Lubuntu).
- `.rpm` → usado en Fedora o OpenSUSE.

💬 **Interesante:** No hay un único formato estándar, por eso los desarrolladores suelen publicar su programa en ambos formatos.

**Cómo se instalan:**

- Lo más sencillo: descargar el archivo y hacer doble clic → el instalador se abre y coloca el programa.
- Pero como Linux tiene muchas versiones y actualizaciones, se usan **gestores de aplicaciones** (programas que se encargan de instalar y actualizar software automáticamente).

**Gestores más comunes en Ubuntu/Debian:**

- `apt-get` / `apt` → se usan desde la **terminal** (modo texto).
- **Synaptic** → interfaz gráfica clásica.
- **Centro de Software** → tienda gráfica moderna.
- **Muon** → gestor gráfico en Lubuntu.

**Ejemplo práctico (terminal):**

```bash
sudo apt install vlc
```

- `sudo` → ejecutar como administrador.
- `apt` → gestor de paquetes.
- `install` → opción para instalar.
- `vlc` → nombre del programa.

⚠️ **Atención:** Linux distingue mayúsculas y minúsculas → `vlc` ≠ `Vlc`.

**Instalación gráfica (Muon):**

- Abres Muon desde el menú.
- Escribes el nombre del programa en el buscador.
- Lo seleccionas y das a instalar.
- Muon se encarga de descargarlo y resolver las dependencias.

![[Pasted image 20251217015046.png]]

👉 Además, Muon permite añadir **repositorios** (fuentes de software). Por defecto usa los oficiales de Ubuntu, pero puedes añadir otros (PPAs) para tener versiones más recientes.

---

#### 4.2.2 Instalación mediante paquetes completos

**Idea básica**  
Otra forma de instalar programas es usar **paquetes completos**.  
Estos incluyen el programa y todas sus dependencias en un solo archivo → así funcionan en casi cualquier distribución de Linux.

👉 Piensa en ello como una “app portátil” que trae todo lo que necesita dentro de la caja.

**Ejemplos de sistemas modernos:**

- **Snapcraft (snap).**
- **Flatpak.**

**Ventajas:**

- Muy fáciles de instalar.
- Funcionan en distintas distribuciones.

**Inconvenientes:**

- Ocupan más espacio en disco, porque cada paquete trae sus dependencias aunque ya existan en el sistema.

**Ejemplo práctico (Snap):**

1. Instalar el gestor Snap:
    
    ```bash
    sudo apt install snapd
    ```
    
2. Instalar Visual Studio Code:
    
    ```bash
    sudo snap install code --classic
    ```
    

---

Perfecto, José 🙌. Vamos a trabajar el **punto 1 – Usuarios en Linux** de la Unidad 05 Parte 2, completo y explicado de forma clara para principiantes, siguiendo el estilo que hemos usado en tus apuntes: definiciones, explicaciones, ejemplos y notas de atención/interesante.

---

# 📚 Unidad 05 – Linux Parte 2

---

## 1. Usuarios en Linux

**Definición**  
Linux es un sistema operativo **multiusuario**: permite que varias personas usen el mismo sistema, cada una con su propia cuenta, permisos y configuraciones.

**Explicación**

- Cada usuario tiene un **nombre** y un número interno llamado **UID (User Identifier)**.
- El UID identifica al usuario dentro del sistema.
- Si dos usuarios tienen distinto nombre pero el mismo UID → en realidad son el mismo usuario a nivel interno.

---

### Tipos de usuarios

- **Usuarios normales**
    
    - UID mayor que 0.
    - Operaciones limitadas.
    - Solo pueden acceder y modificar recursos para los que tengan permisos.
- **Usuario root (administrador)**
    
    - UID = 0.
    - Es el administrador principal del sistema.
    - Puede hacer cualquier tarea: instalar programas, cambiar configuraciones, borrar archivos, etc.
    - ⚠️ **Atención:** trabajar como root es peligroso → un error puede dañar el sistema de manera irreversible.

---

### 1.1 Ficheros `/etc/passwd` y `/etc/shadow`

**Definición**  
La información de los usuarios se guarda en dos archivos principales:

- `/etc/passwd`
    
    - Contiene la lista de usuarios y atributos como UID, directorio personal (home), estado del usuario.
    - Ejemplo:
        
        ```bash
        cat /etc/passwd
        ```
        
- `/etc/shadow`
    
    - Contiene las contraseñas cifradas de los usuarios.
    - Solo root puede leerlo o modificarlo.

---

### 1.2 El comando `sudo` y la lista sudoers

**Definición**  
En distribuciones modernas (Ubuntu, Mint…), la cuenta root está desactivada. Se usa la lista **sudoers** para dar permisos especiales a usuarios normales.

**Explicación**

- Permite ejecutar comandos como root usando `sudo`.
- Ejemplo:
    
    ```bash
    sudo cat fichero.txt
    ```
    
    → el comando se ejecuta con privilegios de root.

💬 **Curiosidad:** la primera vez que uses `sudo` en una sesión, el sistema pedirá tu propia contraseña para confirmar tu identidad.

---

### 1.3 El comando `su`

**Definición**  
`su` significa **Switch User** (cambiar de usuario).

**Explicación**

- Sin parámetros → intenta iniciar sesión como root.
- Con parámetros → cambia al usuario indicado.

Ejemplos:

```bash
su pepe      # cambiar al usuario pepe
sudo su      # acceder como root
```

---

### 1.4 Creación de usuarios en Linux

**Definición**  
Se pueden crear usuarios por consola o con interfaz gráfica.

**Explicación**

- **Consola:**
    
    ```bash
    sudo adduser nombre
    sudo useradd nombre
    ```
    
- **Gráfico:** depende de la distribución (ej. herramienta de administración de usuarios).
- Al crear un usuario, se genera automáticamente su carpeta personal copiando la plantilla de `/etc/skel`.
    - `/etc/skel` funciona como una **plantilla inicial**: contiene archivos de configuración que se copian al nuevo usuario.

---
## 2. Grupos en Linux

**Definición**  
Un **grupo** en Linux es un conjunto de usuarios. Sirve para asignar permisos o privilegios a varios usuarios a la vez, en lugar de hacerlo uno por uno.

**Explicación**

- Facilita la administración en sistemas con muchos usuarios.
- Ejemplo: si damos privilegios de `sudo` a un grupo, todos los usuarios dentro de ese grupo podrán ejecutar comandos como administradores.
- Un mismo usuario puede pertenecer a varios grupos al mismo tiempo → esto da flexibilidad en la gestión de permisos.
- Cada grupo tiene:
    - Un **nombre visible**.
    - Un número interno llamado **GID (Group ID)**.
- Si dos grupos comparten el mismo GID → en realidad son el mismo grupo para el sistema.

💬 **Dato interesante:** en distribuciones como Ubuntu, Lubuntu o Mint, pertenecer al grupo **sudo** significa automáticamente tener acceso a privilegios de administración.

---

### 2.1 Fichero `/etc/group`

**Definición**  
La información de los grupos se guarda en el archivo `/etc/group`.

**Explicación**  
Cada línea del archivo representa un grupo e incluye:

- Nombre del grupo.
- GID (identificador numérico).
- Lista de usuarios que pertenecen a ese grupo.

Ejemplo de consulta:

```bash
cat /etc/group
```

---

### 2.2 Crear grupos en Linux

**Definición**  
Los grupos se pueden crear y gestionar desde la consola o mediante herramientas gráficas.

**Explicación**

- **Consola:**
    - Crear un grupo:
        
        ```bash
        sudo groupadd profesores
        ```
        
    - Añadir un usuario a un grupo:
        
        ```bash
        sudo usermod -aG profesores ana
        ```
        
- **Gráfico:** depende de la distribución, algunas incluyen herramientas de administración de usuarios y grupos.

---
## 3. Ficheros y directorios en Linux

**Definición**  
En Linux, todo se organiza en forma de **archivos** y **directorios**. Incluso los dispositivos físicos (como discos o impresoras) se representan como archivos especiales dentro del sistema.

**Explicación**  
Existen distintos tipos de archivos:

- **Archivos regulares:**
    
    - Contienen información como texto, imágenes, programas, etc.
    - Son los más comunes.
- **Directorios:**
    
    - Son archivos especiales que contienen referencias a otros archivos o directorios.
    - Equivalen a las carpetas en Windows.
- **Enlaces:**
    
    - **Enlaces simbólicos (soft links):** apuntan a la ruta de otro archivo.  
        👉 Funcionan como los accesos directos de Windows.  
        ⚠️ Si se borra el archivo original, el enlace queda roto.
    - **Enlaces duros (hard links):** no son un archivo diferente, sino otro nombre para el mismo archivo.  
        👉 El archivo no desaparece hasta que se borran todas las referencias.
- **Archivos especiales:**
    
    - Representan dispositivos físicos (ejemplo: discos, impresoras).
    - Se encuentran en `/dev`.
- **Archivos ocultos:**
    
    - Su nombre comienza con un punto (`.`).
    - Ejemplo: `.bashrc`.
    - No aparecen al listar con `ls`, salvo que uses:
        
        ```bash
        ls -a
        ```
        

---
## 4. Permisos en Linux

**Definición**  
En Linux, cada archivo y directorio tiene **permisos** que determinan qué puede hacer cada usuario con ellos: leer, escribir o ejecutar.

**Explicación**

- Los permisos básicos son:
    
    - **Lectura (r):**
        - En un archivo → permite leer su contenido.
        - En un directorio → permite ver qué contiene (listar con `ls`).
    - **Escritura (w):**
        - En un archivo → permite modificarlo.
        - En un directorio → permite crear o borrar archivos dentro.
    - **Ejecución (x):**
        - En un archivo → permite ejecutarlo como programa.
        - En un directorio → permite acceder a él con `cd`.
- Los permisos se definen para tres categorías:
    
    1. **Propietario (owner).**
    2. **Grupo (group).**
    3. **Otros (others).**

Ejemplo con `ls -l`:

```
-rwxr-x---
```

- Propietario → rwx (leer, escribir, ejecutar).
- Grupo → r-x (leer, ejecutar).
- Otros → --- (sin permisos).

![[Pasted image 20251217020226.png]]

---

### 4.1 Algoritmo de concesión de permisos

Cuando un usuario intenta acceder a un recurso, el sistema sigue este orden:

1. Si el usuario es **root (UID=0)** → siempre tiene permiso.
2. Si es el **propietario** → se aplican los permisos de propietario.
3. Si pertenece al **grupo** → se aplican los permisos de grupo.
4. En cualquier otro caso → se aplican los permisos de otros.

👉 Es posible configurar permisos poco comunes, como que “otros” tengan más permisos que el propietario.

---

### 4.2 Usando el comando `chmod`

**Definición**  
El comando `chmod` permite cambiar los permisos de un archivo o directorio.

**Explicación**

- Solo el propietario o root pueden hacerlo.
- Dos formas de uso:

1. **Notación simbólica (alfabética):**
    
    ```bash
    chmod u=rwx,g=rx,o= myFile.txt
    ```
    
    - Propietario → todos los permisos.
    - Grupo → leer y ejecutar.
    - Otros → sin permisos.
2. **Notación octal (numérica):**
    
    - r=4, w=2, x=1.
    - Ejemplo:
        
        ```bash
        chmod 750 myFile.txt
        ```
        
        → Propietario = 7 (rwx), Grupo = 5 (r-x), Otros = 0 (---).

---

### 4.3 Permisos especiales

Además de los 9 bits básicos, existen 3 permisos avanzados:

![[Pasted image 20251217020244.png]]

- **setUID (s en propietario):**
    
    - En ejecutables → el programa se ejecuta con permisos del propietario.
    - En directorios → los nuevos archivos heredan el propietario del directorio.
- **setGID (s en grupo):**
    
    - Igual que setUID, pero aplicado al grupo.
    - En directorios → los nuevos archivos heredan el grupo del directorio.
- **Sticky bit (t):**
    
    - Usado en directorios compartidos (ejemplo: `/tmp`).
    - Permite que cualquiera cree archivos, pero solo el propietario (o root) puede borrarlos.

---

### 4.4 ACL (Access Control Lists)

**Definición**  
Las ACL permiten asignar permisos más detallados a usuarios o grupos específicos, además de los clásicos owner/group/others.

**Explicación**

- Ejemplo: un archivo pertenece al usuario **ana** y al grupo **profesores**.
- Con ACL, podemos dar permisos explícitos a un tercer usuario (ej. **maria**) sin cambiar propietario ni grupo.

**Comandos básicos de ACL:**

- Ver ACL de un archivo:
    
    ```bash
    getfacl mi_archivo.txt
    ```
    
- Asignar permisos a un usuario concreto:
    
    ```bash
    setfacl -m u:maria:rw mi_archivo.txt
    ```
    
- Eliminar una ACL:
    
    ```bash
    setfacl -x u:maria mi_archivo.txt
    ```
    

**Ventajas:**

- Mayor flexibilidad que el sistema tradicional.
- Útil en sistemas multiusuario y entornos corporativos.
- Permite herencia de permisos en directorios.

⚠️ **Consideración:** no todas las particiones tienen soporte ACL activado por defecto, aunque en distribuciones modernas suele estar habilitado.

---
## 5. Principales comandos de Linux

**Definición**  
Los comandos son instrucciones que se escriben en la **terminal** para interactuar con el sistema. Son la base del trabajo en Linux.

**Explicación**

- Se ejecutan escribiendo el nombre del comando y, opcionalmente, parámetros.
- Para obtener ayuda sobre cualquier comando se usa:
    
    ```bash
    man comando
    ```
    
- 💬 **Interesante:** `man` abre el manual del comando, como una guía rápida.
- ⚠️ **Atención:** algunos comandos requieren permisos de administrador → se ejecutan con `sudo`.

---

### 5.1 Comandos para gestionar la interfaz

|Comando|Qué hace|Ejemplo|
|---|---|---|
|`man`|Muestra la ayuda de un comando.|`man ls`|
|`clear`|Limpia la pantalla de la terminal.|`clear`|
|`echo`|Muestra texto literal en pantalla.|`echo "Hola Mundo"`|
|`exit`|Cierra la sesión en la consola.|`exit`|

---

### 5.2 Comandos para configurar el sistema

|Comando|Qué hace|Ejemplo|
|---|---|---|
|`date`|Muestra o cambia la fecha del sistema.|`date` / `sudo date -s "2025-09-18 14:00:00"`|
|`cal`|Muestra el calendario.|`cal`|
|`shutdown`|Apaga el sistema.|`sudo shutdown now`|
|`reboot`|Reinicia el sistema.|`sudo reboot`|

⚠️ **Atención:** en la mayoría de distribuciones modernas, `shutdown` y `reboot` requieren `sudo`.

---

### 5.3 Comandos para obtener información sobre discos

|Comando|Qué hace|Ejemplo|
|---|---|---|
|`du`|Muestra el uso de disco por archivo/directorio.|`du -h` / `du -sh *`|
|`df`|Muestra información de los sistemas de archivos montados.|`df -h`|

---

### 5.4 Comandos para gestionar archivos y directorios

|Comando|Qué hace|Ejemplo|
|---|---|---|
|`touch`|Crea un archivo vacío o actualiza su fecha.|`touch miArchivo.txt`|
|`nano` / `vi`|Editores de texto en terminal.|`nano miArchivo.txt`|
|`mkdir`|Crea un directorio.|`mkdir miDirectorio`|
|`cat`|Muestra el contenido de un archivo.|`cat miArchivo.txt`|
|`more`|Muestra contenido página a página.|`more miArchivo.txt`|
|`less`|Similar a more, pero más potente.|`less miArchivo.txt`|
|`grep`|Busca un patrón dentro de un archivo.|`grep root /etc/passwd`|
|`ls`|Lista el contenido de un directorio.|`ls` / `ls -la`|
|`cd`|Cambia de directorio.|`cd /home` / `cd ..`|
|`pwd`|Muestra la ruta actual.|`pwd`|
|`rm`|Borra archivos o directorios.|`rm miArchivo` / `rm -r miDirectorio`|
|`cp`|Copia archivos o directorios.|`cp miArchivo /home/admin/`|
|`mv`|Mueve o renombra archivos.|`mv antiguo.txt nuevo.txt`|
|`ln`|Crea enlaces.|`ln miArchivo hardLink.txt` / `ln -s miArchivo accesoDirecto.txt`|
|`mount`|Monta un dispositivo en una carpeta.|`sudo mount /dev/sda1 /media/miDisco`|

⚠️ **Atención:** `rm -r` es muy peligroso → borra todo sin pasar por la papelera. Siempre revisa con `ls` antes de usarlo.

---

### 5.5 Comandos relacionados con permisos

|Comando|Qué hace|Ejemplo|
|---|---|---|
|`chmod`|Cambia permisos de un archivo/directorio.|`chmod 750 miArchivo`|
|`chown`|Cambia propietario y/o grupo.|`sudo chown usuario:grupo miArchivo`|
|`chgrp`|Cambia solo el grupo.|`sudo chgrp profesores miArchivo`|

---

### 5.6 Comandos de red

|Comando|Qué hace|Ejemplo|
|---|---|---|
|`ping`|Comprueba conexión con otra máquina.|`ping google.com`|
|`ip a` / `ifconfig`|Muestra información de red.|`ip a`|
|`wget`|Descarga archivos de Internet.|`wget https://example.com/archivo.zip`|
|`curl`|Transferencia de datos desde/hacia servidor.|`curl https://example.com`|

---
