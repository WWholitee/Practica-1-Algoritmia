package practica1;

import java.util.ArrayList;

/**
 *
 * @author ellen
 */
public class LlistaCurs implements InterficieLista {

    private ArrayList<Curso> listacurso;  // Cambiar el tipo de Object a Curso

    public LlistaCurs() {
        listacurso = new ArrayList<>();
    }

    @Override
    public void addObject(Object o) {
        this.listacurso.add((Curso) o);
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
}

