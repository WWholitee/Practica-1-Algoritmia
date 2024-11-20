package practica1;

/**
 *
 * @author ellen
 */
public class FormacioProfessional extends Curso {

    private String especialidad;

    public FormacioProfessional(String nombre, String codigo, String especialidad) {
        super(nombre, codigo);
        this.especialidad = especialidad;
    }

    @Override
    public String getTipo() {
        return "Formación Profesional (" + especialidad + ")";
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Curso FP: " + getNombre() + " - Código: " + getCodigo() + " - Especialidad: " + especialidad);
    }
    
    public String getEspecialidad(){
        return this.especialidad;
    }
}
