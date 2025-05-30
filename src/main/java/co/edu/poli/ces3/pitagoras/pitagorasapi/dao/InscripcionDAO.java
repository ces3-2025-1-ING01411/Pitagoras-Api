package co.edu.poli.ces3.pitagoras.pitagorasapi.dao;

public class InscripcionDAO {

    private int id;
    private String estudiante;
    private String documento;
    private String carrera;
    private String asignatura;
    private String semestre;
    private String fechaInscripcion;
    private String estado; //"Activa", "Cancelada"
    private int creditos;
    private int prioridad;
    private double promedioAcumulado;

    public InscripcionDAO() {
    }

    public InscripcionDAO(String estudiante, String documento, String carrera, String asignatura, String semestre, String fechaInscripcion, String estado, int creditos, double promedioAcumulado) {
        this.estudiante = estudiante;
        this.documento = documento;
        this.carrera = carrera;
        this.asignatura = asignatura;
        this.semestre = semestre;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.creditos = creditos;
        this.promedioAcumulado = promedioAcumulado;
    }

    public InscripcionDAO(int id, String estudiante, String documento, String carrera, String asignatura, String semestre, String fechaInscripcion, String estado, int creditos, double promedioAcumulado) {
        this.id = id;
        this.estudiante = estudiante;
        this.documento = documento;
        this.carrera = carrera;
        this.asignatura = asignatura;
        this.semestre = semestre;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.creditos = creditos;
        this.promedioAcumulado = promedioAcumulado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public double getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }
}
