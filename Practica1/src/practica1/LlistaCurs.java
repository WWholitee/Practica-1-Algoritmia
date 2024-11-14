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
public class LlistaCurs implements InterficieLista{
    
    private ArrayList<Curso> listacurso;
    
    public LlistaCurs() {
        listacurso= new ArrayList<>();
    }
    public void addObject(Object o) {
        this.listacurso.add((Curso) o);
    }
    public int longitud() {
        return listacurso.size();
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
