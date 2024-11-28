/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

import java.util.ArrayList;

/**
 *
 * @author ellen
 */
public class Llista_codi_assignatura implements InterficieLista{
    
    private LlistaNode ln;
    
    public Llista_codi_assignatura(){
         ln = new LlistaNode();
    }

    @Override
    public int longitud() {
        return ln.LongitudLlista();
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
         return ln.ObtenirStringPosicio(a);
    }

    @Override
    public Object getObject(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addObject(Object a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
      public void addElement(String i){
        this.ln.Nodenou(i);
    }
    
    public void EliminarCodi(String i){
        this.ln.EliminarNode(i);
    }
    
}
