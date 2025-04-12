package co.edu.poli.ces3.pitagoras.pitagorasapi.service;

import co.edu.poli.ces3.pitagoras.pitagorasapi.dao.InscripcionDAO;

import java.util.ArrayList;

public class InscripcionService {

    public static final ArrayList<InscripcionDAO> inscripciones = new ArrayList<>();

    static {
        inscripciones.add(new InscripcionDAO(
                1, "Juan Perez", "123456789", "Ingeniería de Sistemas",
                "Programación I", "2025-1", "2025-01-01",
                "Activa", 3, 1, 4.5
        ));

        inscripciones.add(new InscripcionDAO(
                2, "Luis Vargas", "111", "Ingeniería Mecánica",
                "Matemáticas I", "2024-2", "2024-06-01",
                "Inactiva", 4, 2, 4.3
        ));
    }

    public static void crearInscripcion(InscripcionDAO inscripcion) {
        inscripciones.add(inscripcion);
    }

    public static ArrayList<InscripcionDAO> obtenerInscripciones() {
        return inscripciones;
    }

    public static ArrayList<InscripcionDAO> buscarInsCarrera(String carrera) {

        ArrayList<InscripcionDAO> inscripcionesCarrera = new ArrayList<>();

        for (InscripcionDAO inscripcion : inscripciones) {
            if (inscripcion.getCarrera().equalsIgnoreCase(carrera)) {
                inscripcionesCarrera.add(inscripcion);
            }
        }
        return inscripcionesCarrera;
    }
}
