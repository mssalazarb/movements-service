# 🚀 movements-service (Proyecto Spring Boot con PostgreSQL)

¡Bienvenido/a! Este es un microservicio desarrollado con Spring Boot y PostgreSQL. Su responsabilidad es guardar los movimientos que se generan en las cuentas las cuentas de los usuarios, así como también las auditorías respectivas.

Aquí te dejo los pasos para que puedas levantar el proyecto de forma local y empezar a usarlo en poco tiempo. ¡Vamos a ello! 😎

## 🛠️ Requisitos previos
Antes de empezar, asegúrate de tener instalado lo siguiente en tu máquina:

* Java 22+ ☕
* Gradle 🛠️
* Docker 🐳
* Git 🐙

## ⚙️ Configuración del Proyecto

### 🐙 Clona este repositorio en tu máquina local:

```shell
git clone https://github.com/mssalazarb/movements-service.git
cd movements-service
```

### 🐳 Levantando PostgreSQL con Docker
Para tener tu base de datos PostgreSQL corriendo en Docker, sigue estos pasos:

```shell
docker run --name postgres -e POSTGRES_DB=movements_service -e POSTGRES_USER=movements_service -e POSTGRES_PASSWORD=movements_service -p 5432:5432 -d postgres:latest
```
Esto hará lo siguiente:

* Levanta un contenedor con el nombre postgres-db.
* Crea una base de datos llamada mi_base_de_datos.
* El usuario es postgres y la contraseña es password_secreta.
* Expone el puerto 5432 en tu máquina local.

> ¡Listo! 🎉 Ahora tienes PostgreSQL corriendo. Puedes conectarte con tu aplicación Spring Boot.


### 🏃‍♂️ Ejecutando la aplicación localmente
Para levantar el proyecto en tu máquina local, sigue estos pasos:

1. Instala las dependencias:

```shell
./gradlew build
```
2. Ejecuta el microservicio

```shell
./gradlew bootRun
```

3. Explora la API con Swagger:

> Dirígete a http://localhost:8086/api/v1/swagger-ui/index.html para ver y probar los endpoints documentados con Swagger 🧑‍💻.

### 📂 Migraciones de base de datos (Flyway)
Este microservicio utiliza Flyway para gestionar las migraciones de base de datos, estas correrán automáticamente cuando ejecutes la aplicación.


## 📦 Integración continua con GitHub Actions
Este proyecto incluye un pipeline de GitHub Actions para automatizar el proceso de construcción y pruebas. ¡No tienes que preocuparte por nada! 🤖

Cada vez que realices un push o abras un pull request, GitHub Actions correrá automáticamente el pipeline.
El archivo de configuración se encuentra en .github/workflows/cicd.yml, donde puedes personalizar el pipeline si lo necesitas.

## 💡 Consejos útiles

* Si quieres detener la base de datos de PostgreSQL:

```shell
docker stop postgres
```

* Para reiniciar el contenedor de PostgreSQL:

```shell
docker start postgres
```

## 🔥 Problemas comunes

* **Error al conectar con PostgreSQL:** Verifica que el contenedor esté corriendo y que la configuración en application.properties sea correcta.

* **Puerto 5432 en uso:** Si tienes otro servicio usando este puerto, cambia el mapeo en el comando Docker.

* **Puerto 8086 en uso:** Si tienes otro servicio usando este puerto, modifica el puerto por defecto de la aplicación en application.properties y vuelve a levantar la aplicación.

## 🤖 Contribuir

> ¿Tienes alguna idea o encontraste un bug? ¡Los PRs y sugerencias son bienvenidos! 🍀

## 📜 Licencia
Este proyecto está bajo la licencia MIT. ¡Usa el código como quieras! 😎