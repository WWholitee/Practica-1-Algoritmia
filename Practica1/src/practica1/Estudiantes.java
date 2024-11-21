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
    @Override
    public String getDescripcion() {
        return nombre;
    }
    @Override
    public String getIdentificador() {
        return dni;
    }
    
    //AÑADIR CODIGO ASIGNATURA AL ALUMNO
    public void matricularAsignatura(String codi) {
        ListaCodiAssignatura.add(codi);
    }
    
    //ELIMINAMOS CODIGO AIGNATURA AL ALUMNO
    public void desmatricularAsignatura(String codi) {
        ListaCodiAssignatura.removeIf(n ->(n==codi));
    }

    // Método devuelve codi assignatura segons codi
    public String getAsignaturasMatriculadas(int i) {
        return ListaCodiAssignatura.get(i);
    }
    
    //DEVUELVE LISTA DEL CODIGO DE ASIGNATURAS
    public ArrayList getList(){
        return this.ListaCodiAssignatura;
    }
    
    //Metodo que devuelve true si el alumno esta matriculado de esta asignatura
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
    public String toString() {
        return "Estudiant: " + nombre + " con el dni " + dni;
    }
}
