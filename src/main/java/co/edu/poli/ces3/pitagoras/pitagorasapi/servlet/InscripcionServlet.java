package co.edu.poli.ces3.pitagoras.pitagorasapi.servlet;

import co.edu.poli.ces3.pitagoras.pitagorasapi.dao.InscripcionDAO;
import co.edu.poli.ces3.pitagoras.pitagorasapi.service.InscripcionService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "inscripcionServlet", value = "/inscripciones/*")
public class InscripcionServlet extends HttpServlet {

    public void init() {
        System.out.println("Initializing InscripcionServlet");
    }
/*

    public void init() {
        System.out.println("Initializing InscripcionServlet");

        InscripcionDAO ins1 = new InscripcionDAO(
                1,
                "Juan Perez",
                "123456789",
                "Ingeniería de Sistemas",
                "Programación I",
                "2025-1",
                "2025-01-01",
                "Activa",
                3,
                1,
                4.5
        );
        inscripciones.add(ins1);

        InscripcionDAO ins2 = new InscripcionDAO(
                1,
                "Luis Vargas",
                "111",
                "Ingeniería Mecanica",
                "Matematicas I",
                "2024-2",
                "2024-06-01",
                "Inactiva",
                4,
                2,
                4.3
        );
        inscripciones.add(ins2);
    }

 */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //System.out.println(request.getPathInfo());

        if (request.getPathInfo() != null && request.getPathInfo().equalsIgnoreCase("/carrera")) {

            String carreraParam = request.getParameter("nombre");
            //System.out.println(carreraParam);

            if (carreraParam == null || carreraParam.trim().isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                PrintWriter out = response.getWriter();

                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "El parámetro 'nombre' es obligatorio.");

                Gson gson = new Gson();
                out.println(gson.toJson(errorResponse));
                out.flush();
                return;
            }

            ArrayList<InscripcionDAO> inscripcionesEncontradas = InscripcionService.buscarInsCarrera(carreraParam);

            if (inscripcionesEncontradas != null && !inscripcionesEncontradas.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_OK);
                PrintWriter out = response.getWriter();
                Gson gson = new Gson();
                String jsonResponse = gson.toJson(inscripcionesEncontradas);
                out.println(jsonResponse);
                out.flush();
                return;
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
            return;
        }

        if (request.getPathInfo() != null && request.getPathInfo().equalsIgnoreCase("/priorizadas")) {
            ArrayList<InscripcionDAO> inscripcionesPriorizadas = InscripcionService.ordernarInscripciones();

            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String jsonResponse = gson.toJson(inscripcionesPriorizadas);
            out.println(jsonResponse);
            out.flush();
            return;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        String jsonResponse = gson.toJson(InscripcionService.obtenerInscripciones());
        out.println(jsonResponse);
        out.flush();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        Gson gson = new Gson();
        InscripcionDAO inscripcion = gson.fromJson(request.getReader(), InscripcionDAO.class);
        System.out.println(inscripcion);
        InscripcionService.calcularPrioridad(inscripcion);
        //InscripcionService.crearInscripcion(inscripcion);

        String jsonResponse = gson.toJson(inscripcion);
        out.println(jsonResponse);
        out.flush();
    }
}
