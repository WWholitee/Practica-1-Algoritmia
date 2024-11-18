/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ListaEstudiantes {
    private ArrayList<Estudiantes> ListaEstudiantes;

    public ListaEstudiantes() {
        this.ListaEstudiantes = new ArrayList<>();
    }
    
    public void addEstudiante(Estudiantes alumnoNuevo) {
        for(Estudiantes e:ListaEstudiantes){
            if ((e.getNombre() == alumnoNuevo.getNombre()) && (e.getDNI()== alumnoNuevo.getDNI())){
                this.ListaEstudiantes.add(alumnoNuevo);
            }
        }
    }
    
    
}
