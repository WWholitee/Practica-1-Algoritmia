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
    //private ArrayList<String> ListaCodiAssignatura;
    
    private Llista_codi_assignatura la;

    // Constructor
    public Estudiantes(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        //ListaCodiAssignatura=new ArrayList<String>();
        la = new Llista_codi_assignatura();
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
        //ListaCodiAssignatura.add(codi);
        this.la.addElement(codi);
    }
    
    //ELIMINAMOS CODIGO AIGNATURA AL ALUMNO
    public void desmatricularAsignatura(String codi) {
        //ListaCodiAssignatura.removeIf(n ->(n==codi));
        la.EliminarCodi(codi);
    }

    // Método devuelve codi assignatura segons codi
    public String getAsignaturasMatriculadas(int i) {
        //return ListaCodiAssignatura.get(i);
        return la.getElement(i);
    }
    
    //DEVUELVE LISTA DEL CODIGO DE ASIGNATURAS
    public int getSize(){
        //return this.ListaCodiAssignatura;
        return la.longitud();
    }
    
    //Metodo que devuelve true si el alumno esta matriculado de esta asignatura
    public boolean EstaMatriculado(String codi){
        boolean matriculado=false;
        
        for(int i =1; i<=this.la.longitud();i++){
            if(this.la.getElement(i).equals(codi)){
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
