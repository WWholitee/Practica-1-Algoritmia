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
    private LlistaAssignatura llistaAssignatura;
    // Lista de asignaturas asociadas al curso
   

    // Constructor
    public Curso(String nombre, String codigo) {
        this.codi_c = codigo;
        this.nombre_c = nombre;
        this.llistaAssignatura= new LlistaAssignatura();
    }

    // Métodos Getters
    public String getNombre() {
        return nombre_c;
    }

    public String getCodigo() {
        return codi_c;
    }
    public void AddAssignatura(Assignatura a ){
        this.llistaAssignatura.addObject(a);
    }
    public String StringAssignaturas(){
        String asignaturas = "";
        for (int i = 0; i < this.llistaAssignatura.longitud(); i++) {
            asignaturas += this.llistaAssignatura.getElement(i) + "\n";
        }
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