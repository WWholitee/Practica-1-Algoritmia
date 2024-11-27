package practica1;

public class AssignaturaOpt extends Assignatura {

    private String perfil;

    // Constructor
    public AssignaturaOpt(String nombre, String codi, String perfil, String tipo) {
        super(nombre, codi, tipo);
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    // Método para imprimir los detalles de la asignatura
    public void imprimirAsignatura() {
        String tipoAsignatura = getTipo().equals("T") ? "Teórica" : "Práctica";
        System.out.println("    ASSIGNATURA OPCIONAL: " + getNombre_a() + " PERFIL: " + perfil + " TIPO: " + tipoAsignatura);
    }

    @Override
    public String toString() {
        return super.toString() + " (Opcional) - Perfil: " + perfil;
    }

    @Override
    public String toStringConDetalles() {
        String tipoAsignatura = getTipo().equals("T") ? "Teórica" : "Práctica";
        return super.toStringConDetalles() + " - Perfil: " + perfil + " - Tipo: " + tipoAsignatura;
    }
}
