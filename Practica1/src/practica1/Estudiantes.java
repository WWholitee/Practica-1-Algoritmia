package practica1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ellen
 */
public class Estudiantes implements InterficieElemento {

    private String nombre;
    private String dni;
    private List<Assignatura> asignaturasMatriculadas = new ArrayList<>();

    // Constructor
    public Estudiantes(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    // Métodos Getters
    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return dni;
    }

    // Métodos para matricular y desmatricular asignaturas
    public void matricularAsignatura(Assignatura asignatura) {
        asignaturasMatriculadas.add(asignatura);
    }

    public void desmatricularAsignatura(Assignatura asignatura) {
        asignaturasMatriculadas.remove(asignatura);
    }

    // Método para desmatricular a un estudiante de todas las asignaturas de un curso
    public void desmatricularDeCurso(Curso curso) {
        List<Assignatura> asignaturasDelCurso = curso.getLlistaAssignatura().lista(); // Usamos el getter
        for (Assignatura a : asignaturasDelCurso) {
            desmatricularAsignatura(a); // Desmatriculamos al estudiante de cada asignatura del curso
        }
    }

    // Método para listar Asignaturas matriculadas
    public List<Assignatura> getAsignaturasMatriculadas() {
        return asignaturasMatriculadas;
    }

    @Override
    public String getIdentificador() {
        return dni;
    }

    @Override
    public String getDescripcion() {
        return nombre;
    }
}
