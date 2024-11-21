package practica1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author ellen
 */
public class LlistaAssignatura implements InterficieLista, Iterable<Assignatura> {
    private ArrayList<Assignatura> LlistaAssignatura;

    public LlistaAssignatura() {
        this.LlistaAssignatura = new ArrayList<>();
    }

    @Override
    public int longitud() {
        return LlistaAssignatura.size();
    }

    @Override
    public void Order() {
        this.LlistaAssignatura.sort(Comparator.comparing(Assignatura::getIdentificador));
    }

    @Override
    public ArrayList lista() {
        return this.LlistaAssignatura;
    }

    @Override
    public String getElement(int a) {
        String element = this.LlistaAssignatura.get(a).toString();
        return element;
    }

    @Override
    public Assignatura getObject(int i) {
        return this.LlistaAssignatura.get(i);
    }

    @Override
    public void addObject(Object a) {
        this.LlistaAssignatura.add((Assignatura) a);
    }

    public void EliminarElement(int a) {
        this.LlistaAssignatura.remove(a);
    }

    public void OrdenarLlista(Object a) {
        this.LlistaAssignatura.sort((Comparator<? super Assignatura>) a);
    }

    // Implementación de Iterable<Assignatura>
    @Override
    public Iterator<Assignatura> iterator() {
        return LlistaAssignatura.iterator(); // Usamos el iterador de ArrayList
    }
}
