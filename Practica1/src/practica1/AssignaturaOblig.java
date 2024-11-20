/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author ellen
 */
public class AssignaturaOblig extends Assignatura{
       private int credits;

    public AssignaturaOblig(String nombre, String codi, int credits) {
        super(nombre, codi);
        this.credits = credits;
    }

    public int getCreditos() {
        return credits;
    }

    public void imprimirAsignatura() {
        System.out.println("    ASSIGNATURA: " + getNombre_a() + " OBLIGATORIA    CRÉDITOS: " + credits);
        
    }
}
