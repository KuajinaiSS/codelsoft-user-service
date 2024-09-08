# Codelsoft User Service

## Overview

Codelsoft User Service es una aplicación Spring Boot que proporciona endpoints para gestionar Profesores y Estudiantes. Esta guía te llevará a través de los pasos necesarios para configurar y ejecutar el proyecto en tu máquina local.

## Requisitos Previos

Before you begin, ensure you have the following software installed:

1. **Java JDK 17** o superior
2. **Docker** y **Docker Compose**
3. **Git**

## Instalacion

Seguir los siguientes pasos para la Instalacion:

### 1. Clonar el repositorio

Abrir la terminal y ejecutar el comando:

```sh
git clone https://github.com/KuajinaiSS/codelsoft-user-service.git
cd codelsoft-user-service
```

2. Instalar Java JDK
Asegúrate de tener Java JDK 17 o superior instalado en tu sistema. Puedes verificar la versión de Java con:

```sh
java -version
```
Si necesitas instalar o actualizar Java JDK, sigue la guía de instalación para tu sistema operativo:

[Install Java JDK](https://www.oracle.com/cl/java/technologies/downloads/#java21)

3. Instalar Docker y Docker Compose
Asegúrate de que Docker y Docker Compose estén instalados en tu sistema. Puedes verificar la instalación con:

```sh
docker --version
docker-compose --version
```

Si Docker y Docker Compose no están instalados, sigue la guía de instalación:

[Install Docker](https://docs.docker.com/desktop/install/windows-install/)


4. Configurar el archivo application.properties colocando tu usuario y contraseña de la base de datos

5. Construir y Ejecutar la Aplicación
Construye y ejecuta los contenedores Docker usando Docker Compose:

```sh
docker-compose up --build
```

6. Acceder a la Aplicación
Una vez que los contenedores estén en funcionamiento, puedes acceder a la aplicación en:

[Spring Boot Application: http://localhost:8080](http://localhost:8080/api/)

[SwaggerUI](http://localhost:8080/swagger-ui/index.html#/)

8. Endpoints de la API
Los siguientes endpoints están disponibles:

* Crear Profesor: POST /teachers
* Editar Profesor: PUT /teachers/{id}
* Obtener Profesor por ID: GET /teachers/{id}
* Obtener Todos los Profesores: GET /teachers
* Crear Estudiante: POST /students
* Editar Estudiante: PUT /students/{id}
* Obtener Estudiante por ID: GET /students/{id}
* Obtener Todos los Estudiantes: GET /students
