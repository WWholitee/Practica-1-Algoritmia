package practica1;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author ellen
 */
public class ListaEstudiantes implements InterficieLista{
    private ArrayList<Estudiantes> ListaEstudiantes;
    
    public ListaEstudiantes() {
        this.ListaEstudiantes = new ArrayList<>();
    }
    
    @Override
    public int longitud() {
        return ListaEstudiantes.size();
    }
     @Override
    public void Order() {
         this.ListaEstudiantes.sort(Comparator.comparing(Estudiantes::getDescripcion));
    }
     @Override
    public ArrayList lista() {
        return this.ListaEstudiantes;
    }

    @Override
    public String getElement(int a) {
        return this.ListaEstudiantes.get(a).toString();
    }

    @Override
    public Object getObject(int i) {
        return this.ListaEstudiantes.get(i);
    }
    @Override
    public void addObject(Object alumnoNuevo){
       ListaEstudiantes.add((Estudiantes)alumnoNuevo);
    }
    
    //METODO DEVUELVE TRUE SI EL ALUMNO YA EXISTE EN LA LISTA
    public boolean ExisteEstudiante(Estudiantes alumnoNuevo){
        boolean replica=false;
        for(Estudiantes e : ListaEstudiantes){
            if ((e.getDescripcion().equals(alumnoNuevo.getDescripcion())) && (e.getIdentificador().equals(alumnoNuevo.getIdentificador()))){
                replica=true;
            }
            
        }
        return replica;
    }
    //METODO QUE DADO UN DNI DE UN ALUMNO AÑADE EN CODIGO DE LA ASIGNATURA AL ALUMNO
    public void AfegirAssignaturaAAlumne(String dni,String codi){
        for(Estudiantes e : ListaEstudiantes){
            if (e.getIdentificador().equals(dni)){
                e.matricularAsignatura(codi);
            }
        }
    }
    
    
//    public boolean BuscarEstudianteNombre(String nombre){
//        boolean encontrado=false;
//        for(Estudiantes e : ListaEstudiantes){
//            
//        }
//        return encontrado;
//    }
    //DEVUELVE STRING DE LOS ALUMNOS QUE TIENEN ESE CODIGO DE ASIGNATURA
    public String BuscarAlumnes(String codi){
        String frase="";
        for(Estudiantes e : ListaEstudiantes){
            if(e.EstaMatriculado(codi)==true){
                
                frase= frase+e.toString()+'\n';
            }
        }
        return frase;
    }
    //METODO QUE ELIMINA EL CODIGO DE LA ASIGNATURA DADA EN TODOS LOS ESTUDIANTES
    public void EliminarAsignatura(String codi){
        for(Estudiantes e : ListaEstudiantes){
            if(e.EstaMatriculado(codi)==true){
                e.desmatricularAsignatura(codi);
            }
        }
    }
       
    public Estudiantes getEstudiante(int i){
        return ListaEstudiantes.get(i);
    }

    
}
