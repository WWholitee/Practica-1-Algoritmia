package practica1;

import java.util.ArrayList;

/**
 *
 * @author ellen
 */
public class Assignatura implements InterficieElemento{

   private String nombre_a;
   private String codi_a;
   private String tipo;
   //private ArrayList<String> ListaCodiEstudiant;
   private LLista_codi_estudiants le;
   
   
   //constructor
    public Assignatura(String nombre,String codi,String tipo){
        this.nombre_a= nombre;
        this.codi_a=codi;
        this.tipo = tipo;
        le=new LLista_codi_estudiants();
        //ListaCodiEstudiant=new ArrayList<>();
        
    }
    @Override
    public String toString() {
        return "Assignatura: " + nombre_a + " con el codi " + codi_a + " - Tipo: " + tipo;
    }
    public String toStringConDetalles() {
        String tipo = "Opcional";
//        String credits = "Teoric";
//        String perfil = "T/P";
//
//        // Si es asignatura obligatoria
//        if (this instanceof AssignaturaOblig) {
//            tipo = "Obligatoria";
//            credits = ((AssignaturaOblig) this).getCreditos();
//        } // Si es asignatura opcional
//        else if (this instanceof AssignaturaOpt) {
//            perfil = ((AssignaturaOpt) this).getPerfil();
//        }
//
//        return "Assignatura: " + nombre_a + " (Código: " + codi_a + ") - Tipo: " + tipo
//                + ", Créditos: " + credits + ", Perfil: " + perfil;

String tipoAsignatura = tipo.equals("T") ? "Teórica" : "Práctica";
        return "Assignatura: " + nombre_a + " (Código: " + codi_a + ") - Tipo: " + tipoAsignatura;
    }

    
    public boolean compareNom(String nombrea){
        return this.nombre_a.equals(nombrea);
    }
    public boolean compareCodi(String codi){
        return this.codi_a.equals(codi);
    }
    //AÑADIMOS EL CODIGO DEL ALUMNO EN LA LISTA DE LA ASIGNATURA
    public void AfegirEstudiant(String dni){
       // this.ListaCodiEstudiant.add(dni);
        this.le.addElement(dni);
    }
    //ELIMINAMOS CODIGO DEL ALUMNO EN LA ASIGNATURA
    public void desmatricularAsignatura(String dni) {
        //this.ListaCodiEstudiant.removeIf(n ->(n==dni));
        this.le.EliminarCodi(dni);
    }

    @Override
    public String getIdentificador() {
        return codi_a;
    }
    
   
//    public String getCodiEstudiant(int i) {
//        return this.ListaCodiEstudiant.get(i);
//    }

    @Override
    public String getDescripcion() {
        return nombre_a;
    }
    public String getNombre_a() {
        return nombre_a;
    }

}
