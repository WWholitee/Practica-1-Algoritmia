/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author ellen
 */
public class AssignaturaOpt extends Assignatura {
     private String perfil;

    public AssignaturaOpt(String nombre, String codi, String perfil) {
        super(nombre, codi);
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void imprimirAsignatura() {
        System.out.println("    ASSIGNATURA: " + getNombre_a() + " OBLIGATORIA    PERFIL: " + perfil);
        

    }
}
