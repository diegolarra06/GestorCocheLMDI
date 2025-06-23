# Gestión de Control de Gastos de Coches

Aplicación de consola en Java para el control de gastos de coches, con gestión de usuarios, coches y gastos asociados.

## Descripción

Este proyecto permite a los usuarios registrarse, iniciar sesión, añadir coches y gestionar los gastos asociados a cada vehículo.  
Toda la información se almacena en una base de datos MySQL, y la interacción se realiza desde la línea de comandos.

## Estructura del proyecto

El proyecto sigue una estructura MVC (Modelo-Vista-Controlador) simplificada:

- **Modelo:** Base de datos MySQL, gestionada por la clase `BaseDatos` y `GestorDatos`.
- **Vista:** Interfaz de consola implementada en `VistaConsola`.
- **Controladores:** Lógica de negocio en `ControladorUsuario`, `ControladorCoche` y `ControladorGasto`.

![EstructuraCarpetas2](https://github.com/user-attachments/assets/02d77104-a8c3-4584-b349-ce0a0e53eeef)


### Clases principales

- **BaseDatos:** Gestiona la conexión a la base de datos.
- **GestorDatos:** Encapsula todas las operaciones de base de datos (usuarios, coches, gastos).
- **VistaConsola:** Muestra menús y recoge la entrada del usuario.
- **ControladorUsuario:** Gestiona el registro, login y asociación de usuarios con coches.
- **ControladorCoche:** Permite añadir y ver coches.
- **ControladorGasto:** Permite añadir y listar gastos asociados a un coche.
- **PasswordEncryptor:** Encripta y verifica contraseñas usando Jasypt.

### Relación entre clases

- **Main** inicia la aplicación y coordina la interacción entre la vista y los controladores.
- **VistaConsola** muestra los menús y recoge la entrada del usuario, que se pasa a los controladores.
- **ControladorUsuario** y **ControladorCoche** usan **GestorDatos** para interactuar con la base de datos.
- **ControladorGasto** gestiona los gastos de los coches, también usando **GestorDatos**.
- **PasswordEncryptor** se usa para encriptar y verificar contraseñas antes de guardarlas en la base de datos.

## Funcionalidades principales

- **Registro y login de usuarios**
- **Añadir, ver y asociar coches a usuarios**
- **Añadir y ver gastos asociados a un coche**
- **Encriptación segura de contraseñas**

## Ejemplo de uso

1. **Registra un usuario:** Elige la opción de registro, introduce nombre y contraseña.
2. **Inicia sesión:** Usa el mismo nombre y contraseña para entrar al sistema.
3. **Añade un coche:** Introduce matrícula, marca, modelo y año.
4. **Añade gastos:** Elige el tipo de gasto (gasolina, revisión, ITV, cambio de aceite u otros), kilometraje, fecha, importe y descripción opcional.
5. **Consulta tus gastos:** Visualiza los gastos asociados a un coche.

## Configuración de la Base de Datos
Este proyecto utiliza una base de datos MySQL. Antes de ejecutar la aplicación, es necesario configurar los parámetros de conexión a la base de datos. Estos parámetros se colocan en un archivo de entorno (.env) ubicado en la raíz del proyecto.

Los valores que debes definir son los siguientes:

**DB_HOST**: Dirección del servidor de base de datos 

**DB_PORT**: Puerto de conexión 

**DB_NAME**: Nombre de la base de datos utilizada por la aplicación

**DB_USER**: Usuario con permisos de acceso a la base de datos

**DB_PASSWORD**: Contraseña correspondiente al usuario

DB_HOST=Localhost
DB_PORT=3306
DB_USERNAME=root
DB_PASSWORD=PracticaRoot
DB_DATABASE=ProjectLMDI

![BaseDatosDiegoL](https://github.com/user-attachments/assets/ea494770-d955-4fa6-8e77-b7b44be816a7)



## Pasos para la instalacion del proyecto
1. Clonar el proyecto desde GitHub
Abre Eclipse.
Ve al menú: File > Import...
Selecciona: Git > Projects from Git y haz clic en Next.
Elige la opción: Clone URI y haz clic en Next.
Pega la URL del repositorio GitHub:
https://github.com/tu-usuario/tu-proyecto.git
Haz clic en Next varias veces hasta llegar a la opción: Import existing Eclipse projects.

Selecciona esa opción y haz clic en Finish.
2. Verificar que el proyecto funcione en Eclipse
Asegúrate de que Eclipse reconozca el proyecto como Java.
Si tu proyecto usa librerías externas (por ejemplo, el conector de MySQL), asegúrate de agregarlas:
Click derecho en el proyecto > Build Path > Configure Build Path
En la pestaña Libraries, haz clic en Add External JARs...
Asegúrate de tener MySQL instalado y corriendo.

![Captura24](https://github.com/user-attachments/assets/b6a83b11-9580-44d8-9de8-0179e5010f2d)


3. Crea una base de datos vacía en tu sistema MySQL.
4. En tu código Java, asegúrate de tener la configuración de conexión correctamente escrita.
5. Ejecutar el proyecto
Ubicar la clase principal ( Main.java).
Haz clic derecho sobre ella > Run As > Java Application.
Si todo está configurado correctamente, el proyecto se ejecutará y se conectará a la base de datos.

## Requisitos

- **Java 8+**
- **MySQL**
- **Librerias:** Jasypt (para encriptación de contraseñas)

