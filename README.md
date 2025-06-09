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

## Requisitos

- **Java 8+**
- **MySQL**
- **Librerias:** Jasypt (para encriptación de contraseñas)

