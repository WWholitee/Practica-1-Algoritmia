package practica1;

import java.util.ArrayList;

/**
 *
 * @author ellen
 */
public class LlistaAssignatura implements InterficieLista {
    private ArrayList<Assignatura> LlistaAssignatura;
    public LlistaAssignatura(){
        this.LlistaAssignatura= new ArrayList<>();
    }
    @Override
    public int longitud() {
        return LlistaAssignatura.size();
    }

    @Override
    public void addObject(Object a) {
        this.LlistaAssignatura.add((Assignatura) a);
    }

    @Override
    public void Order() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList lista() {
        return this.LlistaAssignatura;
    }
    //devuelve elemento de una posicion
    @Override
    public String getElement(int a) {
        String element =this.LlistaAssignatura.get(a).toString();
        return element;
    }
    
}
