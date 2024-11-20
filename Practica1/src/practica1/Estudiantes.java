package practica1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ellen
 */
public class Estudiantes implements InterficieElemento {

    private String nombre;
    private String dni;
    private ArrayList<String> ListaCodiAssignatura;

    // Constructor
    public Estudiantes(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        ListaCodiAssignatura=new ArrayList<String>();
    }

    // Métodos Getters
    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return dni;
    }

    // Métodos para matricular y desmatricular asignaturas
    public void matricularAsignatura(String codi) {
        ListaCodiAssignatura.add(codi);
    }

    public void desmatricularAsignatura(String codi) {
        ListaCodiAssignatura.removeIf(n ->(n==codi));
    }

    // Método para desmatricular a un estudiante de todas las asignaturas de un curso
    /*public void desmatricularDeCurso(Curso curso) {
        List<Assignatura> asignaturasDelCurso = curso.getLlistaAssignatura().lista(); // Usamos el getter
        for (Assignatura a : asignaturasDelCurso) {
            desmatricularAsignatura(a); // Desmatriculamos al estudiante de cada asignatura del curso
        }
    }*/

    // Método devuelve codi assignatura segons codi
    public String getAsignaturasMatriculadas(int i) {
        return ListaCodiAssignatura.get(i);
    }
    public ArrayList getList(){
        return this.ListaCodiAssignatura;
    }
    
    public boolean EstaMatriculado(String codi){
        boolean matriculado=false;
        for(int i =0; i<this.ListaCodiAssignatura.size();i++){
            if(this.ListaCodiAssignatura.get(i).equals(codi)){
                matriculado=true;
            }
        }
        return matriculado;
    }
    
    @Override
    public String getIdentificador() {
        return dni;
    }

    @Override
    public String getDescripcion() {
        return nombre;
    }
    @Override
    public String toString() {
        return "Estudiant: " + nombre + " con el dni " + dni;
    }
}
