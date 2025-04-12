# Pitagoras-Api

### Variante: Variante B: Gestión de Inscripciones

## Descripción
La variante B de la API de Pitagoras permite gestionar las inscripciones de los alumnos a los cursos.

## Endpoints

### 📌 Obtener todas las inscripciones
**Descripción:** Devuelve la lista completa de todas las inscripciones registradas.
#### GET /inscripciones
- **URL PETICIÓN:** `GET http://localhost:8000/inscripciones`
- **RESPUESTA:**
```json
[
  {
    "id": 1,
    "estudiante": "Juan Perez",
    "documento": "123456789",
    "carrera": "Ingenieria de Sistemas",
    "asignatura": "Programación I",
    "semestre": "2025-1",
    "fechaInscripcion": "2025-01-01",
    "estado": "Activa",
    "creditos": 3,
    "prioridad": 13,
    "promedioAcumulado": 4.5
  },
  {
    "id": 2,
    "estudiante": "Luis Vargas",
    "documento": "111",
    "carrera": "Ingenieria Mecanica",
    "asignatura": "Matematicas I",
    "semestre": "2024-2",
    "fechaInscripcion": "2024-06-01",
    "estado": "Inactiva",
    "creditos": 4,
    "prioridad": 34,
    "promedioAcumulado": 4.3
  }
]
```

### 📌 Obtener inscripciones por carrera
**Descripción:** Filtra y devuelve las inscripciones correspondientes a una carrera específica.
- **URL PETICIÓN:** 
```bash
curl -X GET "http://localhost:8000/inscripciones/carrera?nombre=Ingenieria%20de%20Sistemas"
```

- **RESPUESTA:**
```json
[
  {
    "id": 1,
    "estudiante": "Juan Perez",
    "documento": "123456789",
    "carrera": "Ingenieria de Sistemas",
    "asignatura": "Programación I",
    "semestre": "2025-1",
    "fechaInscripcion": "2025-01-01",
    "estado": "Activa",
    "creditos": 3,
    "prioridad": 13,
    "promedioAcumulado": 4.5
  }
]
```

#### GET /inscripciones/priorizadas
```bash
curl -X GET "http://localhost:8000/inscripciones/priorizadas"
```
```json
[
  {
    "id": 3,
    "estudiante": "Sofia",
    "documento": "123",
    "carrera": "Ingenieria Ambiental",
    "asignatura": "Biologia9",
    "semestre": "2025-1",
    "fechaInscripcion": "2025-02-01",
    "estado": "Activa",
    "creditos": 1,
    "prioridad": 10,
    "promedioAcumulado": 4.9
  },
  {
    "id": 1,
    "estudiante": "Juan Perez",
    "documento": "123456789",
    "carrera": "Ingenieria de Sistemas",
    "asignatura": "Programación I",
    "semestre": "2025-1",
    "fechaInscripcion": "2025-01-01",
    "estado": "Activa",
    "creditos": 3,
    "prioridad": 13,
    "promedioAcumulado": 4.5
  },
  {
    "id": 2,
    "estudiante": "Luis Vargas",
    "documento": "111",
    "carrera": "Ingenieria Mecanica",
    "asignatura": "Matematicas I",
    "semestre": "2024-2",
    "fechaInscripcion": "2024-06-01",
    "estado": "Inactiva",
    "creditos": 4,
    "prioridad": 34,
    "promedioAcumulado": 4.3
  }
]
```

#### POST /inscripciones
```bash
curl -X POST "http://localhost:8000/inscripciones" \
-H "Content-Type: application/json" \
-d '{
		"estudiante": "Sofia",
		"documento": "123",
		"carrera": "Ingenieria Ambiental",
		"asignatura": "Biologia9",
		"semestre": "2025-1",
		"fechaInscripcion": "2025-02-01",
		"estado": "Activa",
		"creditos": 1,
		"prioridad": 2,
		"promedioAcumulado": 4.9
	}'
```
```json
{
  "success": "Inscripción creada con éxito."
}
```

