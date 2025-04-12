package co.edu.poli.ces3.pitagoras.pitagorasapi.service;

import co.edu.poli.ces3.pitagoras.pitagorasapi.dao.InscripcionDAO;
import co.edu.poli.ces3.pitagoras.pitagorasapi.utils.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InscripcionService {

    public static final ArrayList<InscripcionDAO> inscripciones = new ArrayList<>();

    static {
        InscripcionDAO insc1 = new InscripcionDAO(
                1, "Juan Perez", "123456789", "Ingeniería de Sistemas",
                "Programación I", "2025-1", "2025-01-01",
                "Activa", 3, 4.5
        );
        inscripciones.add(insc1);
        insc1.setPrioridad(calcularPrioridad(insc1));


        InscripcionDAO insc2 = new InscripcionDAO(
                2, "Luis Vargas", "111", "Ingeniería Mecanica",
                "Matematicas I", "2024-2", "2024-06-01",
                "Inactiva", 4, 4.3
        );
        inscripciones.add(insc2);
        insc2.setPrioridad(calcularPrioridad(insc2));
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

    public static int calcularPrioridad(InscripcionDAO inscricion) {
        int prioridad = (int) Math.round(inscricion.getPromedioAcumulado() * 0.6 + (inscricion.getCreditos()/10) * 0.3 + (Utils.x(inscricion.getFechaInscripcion()) * 0.1));
        //System.out.println(prioridad);
        return prioridad;
    }

    public static ArrayList<InscripcionDAO> ordernarInscripciones() {
        //inscripciones.sort(Comparator.comparingInt(InscripcionDAO::getPrioridad));

        ArrayList<InscripcionDAO> inscripcionesPriorizadas = new ArrayList<>();

        for (InscripcionDAO inscripcion : inscripciones) {
            if (inscripcion.getPrioridad() == 1) {
                inscripcionesPriorizadas.add(inscripcion);
            }
        }
        return inscripcionesPriorizadas;
    }
}
