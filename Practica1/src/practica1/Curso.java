package practica1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase abstracta que representa un Curso.
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

    public LlistaAssignatura getLlistaAssignatura() {
        return llistaAssignatura;
    }

    // Métodos para añadir y ordenar asignaturas
    public void AddAssignatura(Assignatura a) {
        this.llistaAssignatura.addObject(a);
    }

    public void Order() {
        this.llistaAssignatura.Order();
    }

    // Devuelve las asignaturas como un String
    public String StringAssignaturas() {
        StringBuilder asignaturas = new StringBuilder();
        for (int i = 0; i < this.llistaAssignatura.longitud(); i++) {
            asignaturas.append(this.llistaAssignatura.getElement(i)).append("\n");
        }
        return asignaturas.toString();
    }

    // Métodos abstractos para obtener tipo y mostrar datos del curso
    public abstract String getTipo();

    public abstract void mostrarDatos();

    // Método que elimina una asignatura según su nombre
    public void eliminarAssignatura(String nombre, JFrame parentFrame) {
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

        // Mostrar mensaje en una ventana emergente
        String mensaje = encontrado 
            ? "Se ha eliminado la asignatura: " + nombre
            : "No se ha encontrado la asignatura: " + nombre;
        String tipoMensaje = encontrado ? "Éxito" : "Error";
        JOptionPane.showMessageDialog(parentFrame, mensaje, tipoMensaje, 
                encontrado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }

    // Método para añadir un alumno a una asignatura
    public void AfegirAlumneAAssignatura(String codi, String dni) {
        Assignatura assignatura;
        boolean encontrado = false;
        for (int i = 0; i < this.llistaAssignatura.longitud(); i++) {
            assignatura = this.llistaAssignatura.getObject(i);
            if (assignatura.compareCodi(codi)) {
                assignatura.AfegirEstudiant(dni);
                encontrado = true;
                break;
            }
        }
        System.out.println(encontrado ? "Se ha añadido el alumno" : "No se ha encontrado la asignatura");
    }

    // Método para buscar una asignatura por código
    public Assignatura getAsignaturaPorCodigo(String codigo) {
        for (int i = 0; i < this.llistaAssignatura.longitud(); i++) {
            Assignatura asignatura = this.llistaAssignatura.getObject(i);
            if (asignatura.getIdentificador().equals(codigo)) {
                return asignatura;
            }
        }
        return null; // Si no se encuentra la asignatura
    }

    // Método que devuelve true si la asignatura existe en el curso
    public boolean ExisteAssignatura(String nom) {
        for (int i = 0; i < this.llistaAssignatura.longitud(); i++) {
            if (this.llistaAssignatura.getObject(i).compareNom(nom)) {
                return true;
            }
        }
        return false;
    }

    // Devuelve detalles del curso
    public String toStringConDetalles() {
        String tipo = "Opcional";
        String especializacio_curso = "";

        // Si es asignatura obligatoria
        if (this instanceof FormacioProfessional) {
            tipo = "FormacioProfessional";
            especializacio_curso = "Especialitat: " + ((FormacioProfessional) this).getEspecialidad();
        } else if (this instanceof Batxiller) {
            tipo = "Batxiller";
            especializacio_curso = ((Batxiller) this).getCurso() + " Curso";
        }

        return "Curso: " + nombre_c + " (Código: " + codi_c + ") - Tipo: " + tipo + ", " + especializacio_curso;
    }

    // Método para obtener el código de una asignatura por nombre
    public String CodiAssignatura(String nom) {
        for (int i = 0; i < this.llistaAssignatura.longitud(); i++) {
            Assignatura assignatura = this.llistaAssignatura.getObject(i);
            if (assignatura.compareNom(nom)) {
                return assignatura.getIdentificador();
            }
        }
        return ""; // Retorna una cadena vacía si no se encuentra la asignatura
    }

    // Método toString
    @Override
    public String toString() {
        return "Curso: " + nombre_c + " con código: " + codi_c;
    }
}
