# Sistema de Gestión Hospitalaria - Clínica Iberoamericana 🏥

Este repositorio contiene el Trabajo Final desarrollado para el curso de **Java Fundamentals (Oracle)**. 

## 📝 Descripción del Proyecto
Es un sistema interactivo por consola diseñado para optimizar el registro de pacientes y la gestión de historias clínicas. Al no utilizar un motor de base de datos externo, la persistencia de los datos se simula en la memoria principal del sistema mediante el uso de colecciones dinámicas (`ArrayList`).

## ⚙️ Características Principales
* **Control de Acceso (Login):** Sistema de autenticación con validación de credenciales de usuario y límite de intentos de seguridad.
* **Gestión de Pacientes (POO):** Registro de nuevos pacientes validando la no duplicidad de DNI en el sistema.
* **Historias Clínicas:** Asignación de atenciones, motivos de consulta, diagnósticos y tratamientos vinculados al historial específico de cada paciente.
* **Manejo de Excepciones:** Uso de bloques `try-catch` para depurar entradas de teclado incorrectas y garantizar la estabilidad del programa en todo momento.

## 🛠️ Tecnologías y Herramientas
* **Lenguaje:** Java 
* **Paradigma:** Programación Orientada a Objetos (POO)
* **IDE:** Eclipse IDE
* **Lógica Interna:** Arreglos (`ArrayList`), Estructuras de Control (`do-while`, `switch`), encapsulamiento.
