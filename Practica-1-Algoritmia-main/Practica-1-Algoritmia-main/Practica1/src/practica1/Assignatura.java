package practica1;

/**
 *
 * @author ellen
 */
public class Assignatura {

   private String nombre_a;
   private String codi_a;
   
   //constructor
    public Assignatura(String nombre,String codi){
        this.nombre_a= nombre;
        this.codi_a=codi;
        
    }
    @Override
    public String toString() {
        return "Assignatura: " + nombre_a + " con el codi " + codi_a;
    }
    
    public boolean compareNom(String nombrea){
        if(this.nombre_a== nombrea){
            return true;
        }
        return false;
    }

}
