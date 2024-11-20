package practica1;

import java.util.ArrayList;

/**
 *
 * @author ellen
 */
public class Assignatura implements InterficieElemento{

   private String nombre_a;
   private String codi_a;
   private ArrayList<String> ListaCodiEstudiant;
   
   //constructor
    public Assignatura(String nombre,String codi){
        this.nombre_a= nombre;
        this.codi_a=codi;
        ListaCodiEstudiant=new ArrayList<>();
        
    }
    @Override
    public String toString() {
        return "Assignatura: " + nombre_a + " con el codi " + codi_a;
    }
    public String toStringConDetalles() {
        String tipo = "Opcional";
        int credits = 0;
        String perfil = "T/P";

        // Si es asignatura obligatoria
        if (this instanceof AssignaturaOblig) {
            tipo = "Obligatoria";
            credits = ((AssignaturaOblig) this).getCreditos();
        } // Si es asignatura opcional
        else if (this instanceof AssignaturaOpt) {
            perfil = ((AssignaturaOpt) this).getPerfil();
        }

        return "Assignatura: " + nombre_a + " (Código: " + codi_a + ") - Tipo: " + tipo
                + ", Créditos: " + credits + ", Perfil: " + perfil;
    }

    
    public boolean compareNom(String nombrea){
        return this.nombre_a.equals(nombrea);
    }
    public boolean compareCodi(String codi){
        return this.codi_a.equals(codi);
    }
    
    public void AfegirEstudiant(String dni){
        this.ListaCodiEstudiant.add(dni);
    }
    
    public void desmatricularAsignatura(String dni) {
        this.ListaCodiEstudiant.removeIf(n ->(n==dni));
    }

    @Override
    public String getIdentificador() {
        return codi_a;
    }
    
   
    public String getCodiEstudiant(int i) {
        return this.ListaCodiEstudiant.get(i);
    }

    @Override
    public String getDescripcion() {
        return nombre_a;
    }
    public String getNombre_a() {
        return nombre_a;
    }

}
