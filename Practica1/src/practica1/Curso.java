package practica1;

/**
 *
 * @author ellen
 */
public abstract class Curso {
    // Atributos
    private String nombre_c;
    private String codi_c;
    private LlistaAssignatura llistaAssignatura;

    // Constructor
    public Curso(String nombre, String codigo) {
        this.codi_c = codigo;
        this.nombre_c = nombre;
        this.llistaAssignatura = new LlistaAssignatura();
    }

    // Métodos Getters
    public String getNombre() {
        return nombre_c;
    }

    public String getCodigo() {
        return codi_c;
    }

    public LlistaAssignatura getLlistaAssignatura() {  // Añadimos el getter
        return llistaAssignatura;
    }

    public void AddAssignatura(Assignatura a) {
        this.llistaAssignatura.addObject(a);
    }

    public String StringAssignaturas() {
        String asignaturas = "";
        for (int i = 0; i < this.llistaAssignatura.longitud(); i++) {
            asignaturas += this.llistaAssignatura.getElement(i) + "\n";
        }
        return asignaturas;
    }

    public abstract String getTipo();

    public abstract void mostrarDatos();

    // Método para eliminar asignaturas de este curso
    public void eliminarAsignaturas() {
        this.llistaAssignatura = new LlistaAssignatura(); // Limpiar la lista de asignaturas
    }

    // Método toString
    @Override
    public String toString() {
        return "Curso: " + nombre_c + " con codigo: " + codi_c;
    }
}
