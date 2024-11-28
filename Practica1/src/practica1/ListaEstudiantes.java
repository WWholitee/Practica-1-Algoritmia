package practica1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

public class ListaEstudiantes implements InterficieLista, Iterable<Estudiantes> {

    private ArrayList<Estudiantes> listaEstudiantes;

    public ListaEstudiantes() {
        this.listaEstudiantes = new ArrayList<>();
    }

    @Override
    public int longitud() {
        return listaEstudiantes.size();
    }

    @Override
    public void Order() {
        this.listaEstudiantes.sort(Comparator.comparing(Estudiantes::getDescripcion));
    }

    @Override
    public ArrayList lista() {
        return this.listaEstudiantes;
    }

    @Override
    public String getElement(int a) {
        return this.listaEstudiantes.get(a).toString();
    }

    @Override
    public Object getObject(int i) {
        return this.listaEstudiantes.get(i);
    }

    @Override
    public void addObject(Object alumnoNuevo) {
        listaEstudiantes.add((Estudiantes) alumnoNuevo);
    }

    public boolean ExisteEstudiante(Estudiantes alumnoNuevo) {
        for (Estudiantes e : listaEstudiantes) {
            if (e.getDescripcion().equals(alumnoNuevo.getDescripcion()) && e.getIdentificador().equals(alumnoNuevo.getIdentificador())) {
                return true;
            }
        }
        return false;
    }

    public void AfegirAssignaturaAAlumne(String dni, String codi) {
        for (Estudiantes e : listaEstudiantes) {
            if (e.getIdentificador().equals(dni)) {
                e.matricularAsignatura(codi);
            }
        }
    }

    public ArrayList<String> BuscarAlumnes(String codigoAsignatura) {
        ArrayList<String> estudiantesMatriculados = new ArrayList<>();

        // Recorremos todos los estudiantes
        for (Estudiantes estudiante : listaEstudiantes) {
            if (estudiante.EstaMatriculado(codigoAsignatura)) {
                estudiantesMatriculados.add(estudiante.getDescripcion()); // Agrega el nombre del estudiante
            }
        }

        return estudiantesMatriculados; // Devuelve la lista de estudiantes
    }

    public void EliminarAsignatura(String codi) {
        for (Estudiantes e : listaEstudiantes) {
            if (e.EstaMatriculado(codi)) {
                e.desmatricularAsignatura(codi);
            }
        }
    }

    public Estudiantes getEstudiante(int i) {
        return listaEstudiantes.get(i);
    }

    @Override
    public Iterator<Estudiantes> iterator() {
        return listaEstudiantes.iterator();
    }
}
