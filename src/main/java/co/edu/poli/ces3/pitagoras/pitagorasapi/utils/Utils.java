package co.edu.poli.ces3.pitagoras.pitagorasapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static long x(String fechaInscripcion) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaIns = sdf.parse(fechaInscripcion);
            Date fechaActual = new Date();

            long diffMilisegundos = fechaActual.getTime() - fechaIns.getTime();

            return diffMilisegundos / (24 * 60 * 60 * 1000); // Convertir a días

        } catch (ParseException e) {
            return 0;
        }
    }
}
