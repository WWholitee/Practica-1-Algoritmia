package practica1;

/**
 *
 * @author ellen
 */
public abstract class Curso {

    // Atributos
    String nombre_c;
    String codi_c;
    LlistaAssignatura llistaAssignatura;

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

    public LlistaAssignatura getLlistaAssignatura() {
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

    public abstract void imprimirCurso();

    // Método para eliminar asignaturas de este curso
    public void eliminarAsignaturas() {
        this.llistaAssignatura = new LlistaAssignatura(); // Limpiar la lista de asignaturas
    }

    public void eliminarAssignatura(String nombre) {
        Assignatura assignatura;
        boolean encontrado = false;
        for (int i = 0; i < this.llistaAssignatura.longitud(); i++) {
            assignatura = this.llistaAssignatura.getObject(i);
            if (assignatura.compareNom(nombre)) {
                this.llistaAssignatura.EliminarElement(i);
                encontrado = true;
                break; 
            }
        }
        if (encontrado) {
            System.out.println("Se ha eliminado");
        } else {
            System.out.println("No se ha encontrado la assignatura");
        }
    }

    // Método para imprimir detalles de cada asignatura y los estudiantes matriculados
    public void imprimirAsignaturasConDetalles() {
        System.out.println("Listado de Asignaturas del curso " + nombre_c + " (Código: " + codi_c + "):");
        for (int i = 0; i < llistaAssignatura.longitud(); i++) {
            Assignatura asignatura = llistaAssignatura.getObject(i);
            System.out.println(asignatura.toStringConDetalles());
            asignatura.imprimirMatriculados();
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Curso: " + nombre_c + " con codigo: " + codi_c;
    }
}
