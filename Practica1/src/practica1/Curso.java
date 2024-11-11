package practica1;

/**
 *
 * @author ellen
 */

import java.util.ArrayList;
import java.util.List;

public abstract class Curso {
    // Atributos
    private String nombre_c;
    private String codi_c;
    
    // Lista de asignaturas asociadas al curso
    private List<Assignatura> asignaturas = new ArrayList<>();

    // Constructor
    public Curso(String nombre, String codigo) {
        this.codi_c = codigo;
        this.nombre_c = nombre;
    }

    // Métodos Getters
    public String getNombre() {
        return nombre_c;
    }

    public String getCodigo() {
        return codi_c;
    }

    // Métodos para agregar y eliminar asignaturas
    public void agregarAsignatura(Assignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public void eliminarAsignatura(Assignatura asignatura) {
        asignaturas.remove(asignatura);
    }

    // Método para listar todas las asignaturas
    public List<Assignatura> listarAsignaturas() {
        return asignaturas;
    }

    public abstract String getTipo();

    public abstract void mostrarDatos();

    // Método toString
    @Override
    public String toString() {
        return "Curso: " + nombre_c + " con codigo: " + codi_c;
    }
}
