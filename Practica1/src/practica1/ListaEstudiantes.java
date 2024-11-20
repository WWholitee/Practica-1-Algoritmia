package practica1;

import java.util.ArrayList;

/**
 *
 * @author ellen
 */
public class ListaEstudiantes implements InterficieLista{
    private ArrayList<Estudiantes> ListaEstudiantes;

    public ListaEstudiantes() {
        this.ListaEstudiantes = new ArrayList<>();
    }
    
    /*public void addEstudiante(Estudiantes alumnoNuevo) {
        for(Estudiantes e : ListaEstudiantes){
            if ((e.getNombre().equals(alumnoNuevo.getNombre())) && (e.getDNI().equals(alumnoNuevo.getDNI()))){
                this.ListaEstudiantes.add(alumnoNuevo);
                return;  // Si ya existe un estudiante con el mismo nombre y DNI, no lo añadimos
            }
        }
        // Si no existe, añadimos al nuevo estudiante
        this.ListaEstudiantes.add(alumnoNuevo);
    
    }*/
    
    //metodo para añadir Estudiante
    public void addEstudiante(Estudiantes alumnoNuevo){
        ListaEstudiantes.add(alumnoNuevo);
    }
    //metodo para comprobar si el estudiante ya estaba matriculado
    public boolean ExisteEstudiante(Estudiantes alumnoNuevo){
        boolean replica=false;
        for(Estudiantes e : ListaEstudiantes){
            if ((e.getNombre().equals(alumnoNuevo.getNombre())) && (e.getDNI().equals(alumnoNuevo.getDNI()))){
                replica=true;
            }
            
        }
        return replica;
    }
    
    public void AfegirAssignaturaAAlumne(String dni,String codi){
        for(Estudiantes e : ListaEstudiantes){
            if (e.getDNI().equals(dni)){
                e.matricularAsignatura(codi);
            }
        }
    }
    public boolean BuscarEstudianteNombre(String nombre){
        boolean encontrado=false;
        for(Estudiantes e : ListaEstudiantes){
            
        }
        return encontrado;
    }
    
    public void BuscarAlumnes(String codi){
        for(Estudiantes e : ListaEstudiantes){
            if(e.EstaMatriculado(codi)==true){
                System.out.println(e.toString());
            }
        }
    }
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

    // Método para desmatricular a todos los estudiantes de un curso
    /*public void desmatricularEstudiantesDeCurso(Curso curso) {
        for (Estudiantes estudiante : ListaEstudiantes) {
            estudiante.desmatricularDeCurso(curso);  // Desmatriculamos al estudiante de todas las asignaturas del curso
        }
    }*/
    
    @Override
    public int longitud() {
        return ListaEstudiantes.size();
    }

    @Override
    public void addObject(Object a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Order() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList lista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getElement(int a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
