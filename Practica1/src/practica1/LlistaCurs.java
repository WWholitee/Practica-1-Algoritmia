package practica1;

import java.util.ArrayList;

/**
 *
 * @author ellen
 */
public class LlistaCurs implements InterficieLista {

    private ArrayList<Curso> listacurso;

    public LlistaCurs() {
        listacurso = new ArrayList<>();
    }
    
    @Override
    public int longitud() {
        return listacurso.size();
    }
    
    @Override
    public void Order() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public ArrayList lista() {
        return this.listacurso;
    }
    @Override
    public String getElement(int a) {
        return listacurso.get(a).toString();  // Usamos el método toString del curso
    }
    @Override
    public Object getObject(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addObject(Object o) {
        this.listacurso.add((Curso) o);
    }
    //BUSCAMOS EN TODOS LOS CURSOS LA ASIGNATURA CON EL CODIGO Y LE AÑADIMOS EL DNI DEL ALUMNO
    public void BuscarCodiAssignatura(String codi, String dni) {
        for (Curso c : listacurso) {
            c.AfegirAlumneAAssignatura(codi, dni);
        }

    }

    public Curso getCurs(int a) {
        return listacurso.get(a);
    }

    
}
