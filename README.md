# Autenticación de Login con JWT en Java

Este proyecto implementa un sistema de autenticación basado en JWT (JSON Web Token) utilizando Java y Spring Boot. JWT se utiliza para gestionar la autenticación sin almacenar sesiones en el servidor, asegurando así una mayor escalabilidad y seguridad.

## Objetivo del proyecto

El objetivo es crear un sistema de autenticación que permita a los usuarios registrarse e iniciar sesión, generando un token JWT para el acceso a rutas protegidas dentro de la aplicación. Los usuarios autenticados pueden acceder a recursos protegidos mediante el uso de este token en cada solicitud HTTP.

## Características principales

- **Registro de usuarios**: Los nuevos usuarios pueden registrarse en la aplicación proporcionando sus credenciales.
- **Inicio de sesión**: Los usuarios registrados pueden autenticarse, y se les proporcionará un JWT.
- **Protección de rutas**: Las rutas sensibles o privadas están protegidas y solo pueden ser accedidas con un JWT válido.
- **Validación de tokens**: Cada solicitud a rutas protegidas valida el token JWT para comprobar su autenticidad y su caducidad.

## Tecnologías utilizadas

- **Java 11+**
- **Spring Boot**: Marco de trabajo para construir la aplicación de backend.
- **Spring Security**: Para gestionar la seguridad y la autenticación.
- **JWT (JSON Web Token)**: Para la generación y validación de tokens.
- **MySQL**: Base de datos utilizada para almacenar los usuarios.
- **Maven o Gradle**: Herramientas de gestión de dependencias.

## Estructura del proyecto

1. **Controladores**: Manejan las solicitudes HTTP para el registro, login y rutas protegidas.
2. **Servicios**: Implementan la lógica de negocio, incluyendo la creación y validación de tokens JWT.
3. **Filtros de Seguridad**: Para interceptar solicitudes y validar JWT antes de procesarlas.
4. **Modelos**: Clases que representan a los usuarios y sus credenciales.
5. **Configuración de Spring Security**: Donde se define la seguridad de la aplicación, incluyendo las rutas públicas y protegidas.

## Flujo de Autenticación

1. **Registro**: El usuario envía sus credenciales y se almacena en la base de datos.
2. **Login**: El usuario proporciona su nombre de usuario y contraseña. Si son válidos, se genera un JWT que el usuario utilizará en futuras solicitudes.
3. **Acceso a rutas protegidas**: El usuario envía el JWT en el encabezado de cada solicitud a una ruta protegida. El sistema valida el token antes de permitir el acceso.

## Próximas mejoras

- Implementar la renovación automática de tokens cuando están a punto de expirar.
- Añadir la funcionalidad de "recordar sesión" usando refresh tokens.
