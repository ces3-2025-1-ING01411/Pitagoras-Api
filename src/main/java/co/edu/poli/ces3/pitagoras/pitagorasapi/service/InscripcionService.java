package co.edu.poli.ces3.pitagoras.pitagorasapi.service;

import co.edu.poli.ces3.pitagoras.pitagorasapi.dao.InscripcionDAO;
import co.edu.poli.ces3.pitagoras.pitagorasapi.utils.Utils;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class InscripcionService {

    public static final ArrayList<InscripcionDAO> inscripciones = new ArrayList<>();

    static {
        InscripcionDAO insc1 = new InscripcionDAO(
                1, "Juan Perez", "123456789", "Ingenieria de Sistemas",
                "Programación I", "2025-1", "2025-01-01",
                "Activa", 3, 4.5
        );
        inscripciones.add(insc1);
        insc1.setPrioridad(calcularPrioridad(insc1));


        InscripcionDAO insc2 = new InscripcionDAO(
                2, "Luis Vargas", "111", "Ingenieria Mecanica",
                "Matematicas I", "2024-2", "2024-06-01",
                "Inactiva", 4, 4.3
        );
        inscripciones.add(insc2);
        insc2.setPrioridad(calcularPrioridad(insc2));
    }

    private static int generarIdUnico() {
        int maxId = 0;
        for (InscripcionDAO insc : inscripciones) {
            if (insc.getId() > maxId) {
                maxId = insc.getId();
            }
        }
        return maxId + 1;  // Incrementa el ID para la siguiente inscripción
    }

    public static Map<String, String> crearInscripcion(InscripcionDAO nuevaInscripcion, HttpServletResponse resp) throws IOException {

        Map<String, String> responseMap = new HashMap<>();

        if (!nuevaInscripcion.getEstado().equalsIgnoreCase("Activa") &&
                !nuevaInscripcion.getEstado().equalsIgnoreCase("Cancelada")) {

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseMap.put("error", "El estado debe ser 'Activa' o 'Cancelada'.");
            return responseMap;
        }

        for (InscripcionDAO insc : inscripciones) {
            if (insc.getEstudiante().equalsIgnoreCase(nuevaInscripcion.getEstudiante()) && insc.getAsignatura().equalsIgnoreCase(nuevaInscripcion.getAsignatura())) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

                responseMap.put(
                        "error",
                        "Ya existe una inscripción para el estudiante " + nuevaInscripcion.getEstudiante() + "  en la asignatura " + nuevaInscripcion.getAsignatura()
                );

                return responseMap;
            }
        }

        int contadorEstudiantes = 0;
        for (InscripcionDAO insc : inscripciones) {
            if (insc.getEstudiante().equalsIgnoreCase(nuevaInscripcion.getEstudiante())) {
                contadorEstudiantes = contadorEstudiantes+1;
            }
        }
        System.out.println(contadorEstudiantes);

        if (contadorEstudiantes > 7) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseMap.put(
                    "error",
                    "El estudiante " + nuevaInscripcion.getEstudiante() + " ya tiene 7 inscripciones."
            );
            return responseMap;
        }

        inscripciones.add(nuevaInscripcion);
        nuevaInscripcion.setId(generarIdUnico());
        nuevaInscripcion.setPrioridad(calcularPrioridad(nuevaInscripcion));
        responseMap.put(
                "success",
                "Inscripción creada con éxito."
        );

        return responseMap;
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

    public static int calcularPrioridad(InscripcionDAO inscricion) {
        int prioridad = (int) Math.round(inscricion.getPromedioAcumulado() * 0.6 + (inscricion.getCreditos()/10) * 0.3 + (Utils.x(inscricion.getFechaInscripcion()) * 0.1));
        //System.out.println(prioridad);
        return prioridad;
    }

    public static ArrayList<InscripcionDAO> ordernarInscripciones() {

        ArrayList<InscripcionDAO> inscripcionesPriorizadas = new ArrayList<>(inscripciones);

        inscripcionesPriorizadas.sort(Comparator.comparingInt(InscripcionDAO::getPrioridad));

        return inscripcionesPriorizadas;
    }
}
