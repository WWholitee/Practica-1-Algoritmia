package practica1;

public class Assignatura {

    private String nombre_a;
    private String codi_a;
    private ListaEstudiantes estudiantesMatriculados; // Inicializar correctamente la lista

    // Constructor
    public Assignatura(String nombre, String codi) {
        this.nombre_a = nombre;
        this.codi_a = codi;
        this.estudiantesMatriculados = new ListaEstudiantes(); // Inicialización de la lista de estudiantes
    }

    @Override
    public String toString() {
        return "Assignatura: " + nombre_a + " (Código: " + codi_a + ")";
    }

    public String toStringConDetalles() {
        String tipo = "Opcional";
        int credits = 0;
        String perfil = "T/P";

        // Si es asignatura obligatoria
        if (this instanceof AssignaturaOblig) {
            tipo = "Obligatoria";
            credits = ((AssignaturaOblig) this).getCreditos();
        } // Si es asignatura opcional
        else if (this instanceof AssignaturaOpt) {
            perfil = ((AssignaturaOpt) this).getPerfil();
        }

        return "Assignatura: " + nombre_a + " (Código: " + codi_a + ") - Tipo: " + tipo
                + ", Créditos: " + credits + ", Perfil: " + perfil;
    }

    // Método para matricular estudiantes en la asignatura
    public void matricularEstudiante(Estudiantes e) {
        estudiantesMatriculados.addEstudiante(e);
    }

    // Método para imprimir los estudiantes matriculados
    public void imprimirMatriculados() {
        System.out.println("Estudiantes matriculados en " + nombre_a + ":");
        if (estudiantesMatriculados.longitud() == 0) {
            System.out.println("No hay estudiantes matriculados.");
        } else {
            estudiantesMatriculados.imprimirEstudiantes(); // Imprime todos los estudiantes
        }
    }

    public boolean compareNom(String nombrea) {
        return this.nombre_a.equals(nombrea);
    }

    public String getNombre_a() {
        return nombre_a;
    }

    public String getCodi_a() {
        return codi_a;
    }
}
