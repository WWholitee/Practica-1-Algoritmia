package practica1;

import java.util.ArrayList;

/**
 *
 * @author ellen
 */
public class ListaEstudiantes {
    private ArrayList<Estudiantes> ListaEstudiantes;

    public ListaEstudiantes() {
        this.ListaEstudiantes = new ArrayList<>();
    }
    
    public void addEstudiante(Estudiantes alumnoNuevo) {
        for(Estudiantes e : ListaEstudiantes){
            if ((e.getNombre().equals(alumnoNuevo.getNombre())) && (e.getDNI().equals(alumnoNuevo.getDNI()))){
                this.ListaEstudiantes.add(alumnoNuevo);
                return;  // Si ya existe un estudiante con el mismo nombre y DNI, no lo añadimos
            }
        }
        // Si no existe, añadimos al nuevo estudiante
        this.ListaEstudiantes.add(alumnoNuevo);
    }

    // Método para desmatricular a todos los estudiantes de un curso
    public void desmatricularEstudiantesDeCurso(Curso curso) {
        for (Estudiantes estudiante : ListaEstudiantes) {
            estudiante.desmatricularDeCurso(curso);  // Desmatriculamos al estudiante de todas las asignaturas del curso
        }
    }
}
