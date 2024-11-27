package practica1;

import java.util.ArrayList;

public class Estudiantes implements InterficieElemento {

    private String nombre;
    private String dni;
    private String codigoCurso; // Ahora cada estudiante tiene un código de curso
    private ArrayList<String> ListaCodiAssignatura; // Lista de códigos de asignaturas matriculadas

    // Constructor
    public Estudiantes(String nombre, String dni, String codigoCurso) {
        this.nombre = nombre;
        this.dni = dni;
        this.codigoCurso = codigoCurso;
        this.ListaCodiAssignatura = new ArrayList<String>();
    }

    // Constructor
    public Estudiantes(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.codigoCurso = "Curso_Default"; // Código de curso por defecto
        this.ListaCodiAssignatura = new ArrayList<String>();
    }

    // Métodos Getters
    @Override
    public String getDescripcion() {
        return nombre;
    }

    @Override
    public String getIdentificador() {
        return dni;
    }

    // Devuelve el código del curso al que pertenece el estudiante
    public String getCodigoCurso() {
        return codigoCurso;
    }

    // AÑADIR CÓDIGO DE ASIGNATURA AL ALUMNO (Matricular)
    public void matricularAsignatura(String codi) {
        if (!ListaCodiAssignatura.contains(codi)) {
            ListaCodiAssignatura.add(codi);
        }
    }

    // ELIMINAR CÓDIGO DE ASIGNATURA AL ALUMNO (Desmatricular)
    public void desmatricularAsignatura(String codi) {
        ListaCodiAssignatura.removeIf(n -> n.equals(codi)); // Usar .equals() para comparación de cadenas
    }

    // Método devuelve código de asignatura
    public String getAsignaturasMatriculadas(int i) {
        if (i >= 0 && i < ListaCodiAssignatura.size()) {
            return ListaCodiAssignatura.get(i);
        }
        return null;
    }

    // DEVUELVE LISTA DE LOS CÓDIGOS DE LAS ASIGNATURAS
    public ArrayList<String> getList() {
        return this.ListaCodiAssignatura;
    }

    public boolean EstaMatriculado(String codi) {
        return ListaCodiAssignatura.contains(codi);
    }

    @Override
    public String toString() {
        return "Estudiant: " + nombre + " con el dni " + dni + " (Curso: " + codigoCurso + ")";
    }
}
