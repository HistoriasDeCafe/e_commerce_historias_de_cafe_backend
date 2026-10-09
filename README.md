# Historia de Café - E-Commerce Backend

> **Backend** para el proyecto final de generación de *Historias de Café*, construido con **Java** y **Spring Boot**. Esta aplicación gestiona el catálogo de productos y la administración de usuarios mediante una arquitectura robusta y APIs RESTful.

## Sobre el Proyecto

Este repositorio contiene el **backend** de una aplicación **Full-Stack** dedicada al comercio electrónico. La arquitectura está diseñada para ser escalable y mantenible, implementando un ciclo de vida completo de gestión de datos (CRUD) para **Productos** y **Usuarios**.

El sistema se comunica con un frontend construido con **Bootstrap** a través de APIs REST, permitiendo operaciones fluidas en tiempo real.

## Características Principales

- **CRUD Completo**: Operaciones de Crear, Leer, Actualizar y Borrar para usuarios y productos.
- **Arquitectura en Capas**: Implementación limpia de la estructura `Controller → Service → Repository`.
- **APIs RESTful**: +5 endpoints optimizados para la interoperabilidad frontend-backend.
- **Persistencia de Datos**: Integración con **MySQL** mediante **Spring Data JPA**.
- **Control de Versiones**: Gestión eficiente de cambios utilizando la metodología *Git Flow*.

## Tecnologías Utilizadas

| Componente | Tecnología |
|------------|------------|
| **Lenguaje** | Java (100% del código) |
| **Framework** | Spring Boot |
| **Persistencia** | Spring Data JPA |
| **Base de Datos** | MySQL |
| **Frontend** | Bootstrap (integración) |
| **Build Tool** | Maven |
| **Control de Versiones** | Git Flow |

## Estructura del Proyecto

El proyecto sigue una estructura estándar de Spring Boot:

```text
src/
├── main/
│   ├── java/.../controller/   # Capa de exposición (APIs)
│   ├── java/.../service/      # Lógica de negocio
│   ├── java/.../repository/   # Acceso a datos (JPA)
│   └── resources/             # Configuración y datos

## Prerequisitos
JDK 11 o superior
Maven 3.6+
MySQL Server
