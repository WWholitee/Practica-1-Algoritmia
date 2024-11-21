package practica1;

/**
 *
 * @author ellen
 */
public abstract class Curso {
    // Atributos
    private String nombre_c;
    private String codi_c;
    private LlistaAssignatura llistaAssignatura;

    // Constructor
    public Curso(String nombre, String codigo) {
        this.codi_c = codigo;
        this.nombre_c = nombre;
        this.llistaAssignatura = new LlistaAssignatura();
    }

    // Métodos Getters
    public String getNombre() {
        return nombre_c;
    }

    public String getCodigo() {
        return codi_c;
    }

    public LlistaAssignatura getLlistaAssignatura() {  // Añadimos el getter
        return llistaAssignatura;
    }

    public void AddAssignatura(Assignatura a) {
        this.llistaAssignatura.addObject(a);
    }
    public void Order(){
        this.llistaAssignatura.Order();
    }

    public String StringAssignaturas() {
        String asignaturas = "";
        for (int i = 0; i < this.llistaAssignatura.longitud(); i++) {
            asignaturas += this.llistaAssignatura.getElement(i) + "\n";
        }
        return asignaturas;
    }

    public abstract String getTipo();

    public abstract void mostrarDatos();
    //METODO QUE ELIMINA UNA ASIGNATURA SEGUN SU NOMBRE
    public void eliminarAssignatura(String nombre){
        Assignatura assignatura;
        boolean encontrado=false;
        for(int i = 0; i < this.llistaAssignatura.longitud(); i++){
            assignatura=this.llistaAssignatura.getObject(i);
            if(assignatura.compareNom(nombre)==true){
                this.llistaAssignatura.EliminarElement(i);
                encontrado=true;
            }
        }
        if(encontrado=true){
            System.out.println("Se ha eliminado");
        }else
            System.out.println("No se ha encontrado la assignatura");
    }
    //AÑADIMOS EL CODIGO DEL ALUMNO A UNA ASIGNATURA
    public void AfegirAlumneAAssignatura(String codi, String dni){
        Assignatura assignatura;
        boolean encontrado=false;
        for(int i = 0; i < this.llistaAssignatura.longitud(); i++){
            assignatura=this.llistaAssignatura.getObject(i);
            
            if(assignatura.compareCodi(codi)==true){
                this.llistaAssignatura.getObject(i).AfegirEstudiant(dni);
                encontrado=true;
                
            }
        }
        if(encontrado=true){
            System.out.println("Se ha eliminado");
        }else
            System.out.println("No se ha encontrado la assignatura");
    }
    //Metodo que devuelve true si la asignatura existe en el curso
    public boolean ExisteAssignatura(String nom){
        Assignatura assignatura;
        boolean encontrado=false;
        for(int i = 0; i < this.llistaAssignatura.longitud(); i++){
            assignatura=this.llistaAssignatura.getObject(i);
            if(assignatura.compareNom(nom)==true){
                encontrado=true;
            }
        }
        return encontrado;
    }
    
    //STRING CON DETALLES 
    public String toStringConDetalles(){
        String tipo = "Opcional";
        String especializacio_curso="";

        // Si es asignatura obligatoria
        if (this instanceof FormacioProfessional) {
            tipo = "FormacioProfessional";
            especializacio_curso= "Especialitat: ";
            especializacio_curso= especializacio_curso+ ((FormacioProfessional) this).getEspecialidad();
            
        } // Si es asignatura opcional
        else if (this instanceof Batxiller) {
            tipo= "Batxiller";
            especializacio_curso = ((Batxiller) this).getCurso();
            especializacio_curso=especializacio_curso+" Curso";
        }

        return "Curso: " + nombre_c + " (Código: " + codi_c + ") - Tipo: " + tipo
                + especializacio_curso;
    }
    //devuelve el codigo de una assignatura dado un nombre
    public String CodiAssignatura(String nom){
        String codiassignatura="";
         Assignatura assignatura;
       
        for(int i = 0; i < this.llistaAssignatura.longitud(); i++){
            assignatura=this.llistaAssignatura.getObject(i);
            if(assignatura.compareNom(nom)==true){
                codiassignatura=assignatura.getIdentificador();
            }
        }
        return codiassignatura;
    }

    // Método toString
    @Override
    public String toString() {
        return "Curso: " + nombre_c + " con codigo: " + codi_c;
    }
}
