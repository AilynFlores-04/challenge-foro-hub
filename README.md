ForoHub - API REST de un Foro

Descripción

ForoHub es una API REST que simula un foro donde los usuarios pueden crear tópicos con preguntas, dudas o sugerencias sobre cursos y proyectos.

El proyecto fue desarrollado con Spring Boot 3 y Java 17, usando una base de datos H2 en memoria, y permite realizar las operaciones básicas de CRUD (Crear, Leer, Actualizar, Eliminar).

Esta es la primera versión del challenge de Alura.
En una segunda fase se agregará autenticación con JWT para proteger ciertos endpoints.

Estructura del proyecto

forohub
│
├── ForohubApplication.java
├── controller
│ └── TopicoController.java
├── model
│ └── Topico.java
├── repository
│ └── TopicoRepository.java
├── security
│ └── SecurityConfig.java
└── src/main/resources
└── application.properties

Tecnologías utilizadas

Java 17
Spring Boot 3
Spring Web
Spring Data JPA
Lombok
H2 Database
Spring Boot DevTools
Validation

Endpoints disponibles

Método | Ruta | Descripción
GET | /topicos | Lista todos los tópicos
GET | /topicos/{id} | Muestra un tópico específico
POST | /topicos | Crea un nuevo tópico
PUT | /topicos/{id} | Actualiza un tópico existente
DELETE | /topicos/{id} | Elimina un tópico

Para los métodos POST, PUT y DELETE se requiere autenticación en la segunda fase (JWT). Por ahora todos los endpoints están abiertos para pruebas.

Base de datos

Usamos H2 en memoria, por lo que no necesitas instalar MySQL.

Para ver los datos en tiempo real:

Ejecuta el proyecto (ForohubApplication.java).

Abre el navegador en: http://localhost:8080/h2-console

Configura así:

JDBC URL: jdbc:h2:mem:forohub
User Name: sa
Password: (vacío)

Presiona Connect y podrás ver la tabla TOPICOS.

Cómo probar la API

Puedes usar herramientas como Hoppscotch, Insomnia o el navegador (para GET).

Listar todos los tópicos (GET)

URL: http://localhost:8080/topicos

Respuesta simulada:

[
{
"id": 1,
"titulo": "Pregunta sobre Spring",
"mensaje": "¿Cómo configuro Spring Boot correctamente?",
"fechaCreacion": "2026-03-10T10:20:30",
"status": "abierto",
"autor": "Ailyn",
"curso": "Spring Boot"
}
]

Crear un nuevo tópico (POST)

URL: http://localhost:8080/topicos

Body JSON:

{
"titulo": "Error en Spring Boot",
"mensaje": "No puedo iniciar mi proyecto",
"status": "abierto",
"autor": "Ailyn",
"curso": "Spring Boot"
}

Respuesta simulada:

{
"id": 2,
"titulo": "Error en Spring Boot",
"mensaje": "No puedo iniciar mi proyecto",
"fechaCreacion": "2026-03-10T11:15:40",
"status": "abierto",
"autor": "Ailyn",
"curso": "Spring Boot"
}

Obtener un tópico específico (GET /{id})

URL: http://localhost:8080/topicos/2

Respuesta simulada:

{
"id": 2,
"titulo": "Error en Spring Boot",
"mensaje": "No puedo iniciar mi proyecto",
"fechaCreacion": "2026-03-10T11:15:40",
"status": "abierto",
"autor": "Ailyn",
"curso": "Spring Boot"
}

Actualizar un tópico (PUT /{id})

URL: http://localhost:8080/topicos/2

Body JSON:

{
"titulo": "Error resuelto",
"mensaje": "Ya logré iniciar el proyecto",
"status": "cerrado",
"autor": "Ailyn",
"curso": "Spring Boot"
}

Eliminar un tópico (DELETE /{id})

URL: http://localhost:8080/topicos/2

Próximos pasos

Agregar seguridad JWT para proteger creación, actualización y eliminación.
Crear usuarios registrados para autenticar peticiones.
Mejorar el foro con respuestas y comentarios a cada tópico.
