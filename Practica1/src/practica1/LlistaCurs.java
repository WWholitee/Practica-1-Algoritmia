package practica1;

import java.util.ArrayList;

public class LlistaCurs {

    private ArrayList<Curso> cursos;

    public LlistaCurs() {
        this.cursos = new ArrayList<>();
    }

    public void addObject(Curso curso) {
        cursos.add(curso);
    }

    public int longitud() {
        return cursos.size();
    }

    public ArrayList<Curso> lista() {
        return cursos;
    }

    // Método para imprimir las asignaturas y estudiantes de un curso específico
    public void imprimirDatosCurso(String nombreCurso, String codigoCurso) {
        boolean encontrado = false;
        for (Curso curso : cursos) {
            if (curso.getNombre().equals(nombreCurso) && curso.getCodigo().equals(codigoCurso)) {
                System.out.println("Curso: " + curso.getNombre() + " (" + curso.getCodigo() + ")");
                curso.imprimirAsignaturasConDetalles();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Curso no encontrado.");
        }
    }
}
