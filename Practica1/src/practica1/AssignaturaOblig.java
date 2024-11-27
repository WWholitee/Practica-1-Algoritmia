package practica1;

public class AssignaturaOblig extends Assignatura {

    private int credits;

    // Constructor
    public AssignaturaOblig(String nombre, String codi, int credits, String tipo) {
        super(nombre, codi, tipo);
        this.credits = credits;
    }

    // Método para obtener los créditos
    public int getCreditos() {
        return credits;
    }

    // Método para imprimir los detalles de la asignatura
    public void imprimirAsignatura() {
        String tipoAsignatura = getTipo().equals("T") ? "Teórica" : "Práctica";
        System.out.println("    ASSIGNATURA OBLIGATORIA: " + getNombre_a() + " CRÉDITOS: " + credits + " TIPO: " + tipoAsignatura);
    }

    @Override
    public String toString() {
        return super.toString() + " (Obligatoria) - Créditos: " + credits;
    }

    @Override
    public String toStringConDetalles() {
        String tipoAsignatura = getTipo().equals("T") ? "Teórica" : "Práctica";
        return super.toStringConDetalles() + " - Créditos: " + credits + " - Tipo: " + tipoAsignatura;
    }
}
