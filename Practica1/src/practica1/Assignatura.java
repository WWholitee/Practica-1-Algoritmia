package practica1;

import java.util.ArrayList;

public class Assignatura implements InterficieElemento {

    private String nombre_a; // Nombre de la asignatura
    private String codi_a; // Código de la asignatura
    private String tipo; // Tipo de asignatura ("T" o "P")
    private ArrayList<String> listaCodiEstudiant; // Lista de códigos de estudiantes matriculados

    // Constructor
    public Assignatura(String nombre, String codi, String tipo) {
        this.nombre_a = nombre;
        this.codi_a = codi;
        this.tipo = tipo; // Asignamos el tipo de la asignatura
        this.listaCodiEstudiant = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Assignatura: " + nombre_a + " con el código " + codi_a + " - Tipo: " + tipo;
    }

    //Imprime una descripción de la asignatura
    public String toStringConDetalles() {
        String tipoAsignatura = tipo.equals("T") ? "Teórica" : "Práctica";
        return "Assignatura: " + nombre_a + " (Código: " + codi_a + ") - Tipo: " + tipoAsignatura;
    }

    //Compara si el nombre coincide
    public boolean compareNom(String nombrea) {
        return this.nombre_a.equals(nombrea);
    }

    //Compara si el código coincide
    public boolean compareCodi(String codi) {
        return this.codi_a.equals(codi);
    }

    //Añade un estudiante a la lista
    public void AfegirEstudiant(String dni) {
        this.listaCodiEstudiant.add(dni);
    }

    //Elimina a un estudiante de la lista
    public void desmatricularAsignatura(String dni) {
        this.listaCodiEstudiant.removeIf(n -> n.equals(dni));
    }

    @Override
    public String getIdentificador() {
        return codi_a;
    }

    //Devuelve el código de un estudiante matriculado
    public String getCodiEstudiant(int i) {
        if (i >= 0 && i < this.listaCodiEstudiant.size()) {
            return this.listaCodiEstudiant.get(i);
        }
        return null;
    }

    @Override
    public String getDescripcion() {
        return nombre_a;
    }

    public String getNombre_a() {
        return nombre_a;
    }

    public String getTipo() {
        return tipo;
    }
}
