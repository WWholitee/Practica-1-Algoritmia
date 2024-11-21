package practica1;

import java.util.Scanner;

/**
 *
 * @author ellen
 */
public class Practica1 {

    public static void main(String[] args) {
        
        //Declaraciones
        Scanner scanner = new Scanner(System.in);
        int num;
        LlistaCurs llistaCursos = new LlistaCurs();  // Lista de cursos
        ListaEstudiantes listaEstudiantes = new ListaEstudiantes();  // Lista de estudiantes

        do {
            System.out.println("OPCION 1: Dar de Alta un Curso y sus Asignaturas");
            System.out.println("OPCION 2: Dar de Alta un alumno dada una asignatura a la que se quiere matricular");
            System.out.println("OPCION 3: Dar de baja un curso");
            System.out.println("OPCION 4: Dar de baja una assignatura");
            System.out.println("OPCION 5: Ver un curso, sus asignaturas y sus estudiantes");
            System.out.println("OPCION 6: Dada una asignatura ver el curso y sus estudiantes ");
            System.out.println("OPCION 7: Dado un estudiante ver que asignaturas tiene y a que curso pertenecen ");
            num = scanner.nextInt();
            scanner.nextLine(); 

            switch (num) {
                case 1:// Dar de alta un curso y sus asignaturas

                    Curso curs;
                    System.out.println("Bachiller(1) o FP(2)");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        // Crear un curso de Bachillerato
                        System.out.println("Escriba el nombre, el código y el curso del Bachiller que quiere añadir");
                        curs = new Batxiller(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                    } else {
                        // Crear un curso de Formación Profesional
                        System.out.println("Escriba el nombre, el código y la especialidad de la Formación Profesional que quiere añadir");
                        curs = new FormacioProfessional(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                    }

                    System.out.println("Añadir asignaturas");
                    System.out.println("Dime cuántas asignaturas quieres añadir");
                    //pedimos numero de asignaturas
                    int numa = scanner.nextInt();
                    scanner.nextLine();
                    //creamos asignaturas para el curso
                    for (int i = 0; i < numa; i++) {
                        Assignatura a;
                        System.out.println("Añade nombre, código y número de créditos");
                        a = new AssignaturaOblig(scanner.nextLine(), scanner.nextLine(), scanner.nextInt());
                        scanner.nextLine();
                        curs.AddAssignatura(a);
                        curs.Order();
                        
                    }
                    System.out.println("Lista de asignaturas:");
                    System.out.println(curs.StringAssignaturas());
                    //MUY IMPORTANTE !!! METEMOS EL CURSO EN LA LISTA
                    llistaCursos.addObject(curs);
                    break;

                case 2:
                    String codi;
                    String nom;
                    String dni;
                    
                    
                    Estudiantes estudiante;
                    
                    System.out.println("nombre y dni del estudiante a matricular ");
                    nom=scanner.nextLine();
                    dni=scanner.nextLine();
                    //creamos el estudiante
                    estudiante = new Estudiantes(nom, dni);
                    System.out.println("Que codigo tiene la assignatura a la que queires matricular al alumno?");
                    codi=scanner.nextLine();
                    if(listaEstudiantes.ExisteEstudiante(estudiante)==false){
                        listaEstudiantes.addObject(estudiante);
                        listaEstudiantes.Order();
                    }
                    llistaCursos.BuscarCodiAssignatura(codi, dni);
                    listaEstudiantes.AfegirAssignaturaAAlumne(dni, codi);
                    break;

                case 3:
                    
                    // Dar de baja un curso y sus asignaturas
                    System.out.println("Introduce el nombre del curso a dar de baja:");
                    String cursoNombre = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < llistaCursos.longitud(); i++) {
                        Curso curso = (Curso) llistaCursos.lista().get(i);
                        if (curso.getNombre().equals(cursoNombre)) {
                            // El curso fue encontrado
                             for (int j = 0; j < curso.getLlistaAssignatura().longitud(); j++) {
                                  Assignatura asignatura = curso.getLlistaAssignatura().getObject(j);

                                //borrar codigo de asignatura en Estudiante
                                String codi_a=asignatura.getIdentificador();
                                listaEstudiantes.EliminarAsignatura(codi_a);
                             }
                            encontrado = true;
                            System.out.println("Curso '" + cursoNombre + "' dado de baja correctamente.");
                            llistaCursos.lista().remove(i);
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Curso no encontrado.");
                    }
                    break;
                case 4:
                    String error="no entra en el bucle";
                    //Pedimos datos NOMBRE CURSO
                    System.out.println("Introduce el nombre del curso donde se encuentra la asignatura a dar de baja");
                    cursoNombre = scanner.nextLine();
                    //Pedimos Dato NOMBRE ASIGNATURA
                    System.out.println("Introduce el nombre de la asignatura a borrar");
                    String assignaturaNombre= scanner.nextLine();
                    encontrado = false;
                    
                    for (int i = 0; i < llistaCursos.longitud(); i++) {
                        Curso curso = llistaCursos.getCurs(i);
                        //buscamos el curso en la lista
                        error="no encuentra un curso igual";
                        if (curso.getNombre().equals(cursoNombre)) {
                            //comprobamos que la asignatura existe en curso
                            error="no encuentra una assignatura igual";
                            if(curso.ExisteAssignatura(assignaturaNombre)==true){
                                encontrado =true;
                                String codi_a= curso.CodiAssignatura(assignaturaNombre);
                                listaEstudiantes.EliminarAsignatura(codi_a);
                                //curso.eliminarAssignatura(assignaturaNombre);
                                error="todo va bien";
                            }
                            
                        }
                    }
                    
                    //por si no se ha encontrado el curso
                    if (!encontrado) {
                        System.out.println(error);
                    }
                    
                    break;
                case 5:
                     String nom_aux,
                     codi_aux;
                    System.out.println("Introduce el nombre del curso del cual quieres ver los datos (escribe el nombre y el codigo).");
                    nom_aux = scanner.nextLine();
                    codi_aux = scanner.nextLine();

                    // Encontramos el curso en la lista
                    boolean cursoEncontrado = false;
                    for (int i = 0; i < llistaCursos.longitud(); i++) {
                        Curso curso = (Curso) llistaCursos.lista().get(i);

                        // Comprobamos si el nombre y código coinciden
                        if (curso.getNombre().equals(nom_aux) && curso.getCodigo().equals(codi_aux)) {
                            cursoEncontrado = true;
                            System.out.println("Curso: " + curso.getNombre() + " (" + curso.getCodigo() + ")");
                            System.out.println("Listado de Asignaturas del curso " + curso.getNombre() + " (" + curso.getCodigo() + "):");

                            for (int j = 0; j < curso.getLlistaAssignatura().longitud(); j++) {
                                Assignatura asignatura = curso.getLlistaAssignatura().getObject(j);

                                // Imprimimos los detalles de la asignatura
                                System.out.println(asignatura.toStringConDetalles());
                                String codi_a=asignatura.getIdentificador();
                                System.out.println(listaEstudiantes.BuscarAlumnes(codi_a));
                                
                                // Imprimimos los estudiantes matriculados en esta asignatura
                                
                            }
                   
                       
                            }
                        }
                     break;
                case 6: //DADA UNA ASIGNATURA dar los alumnos y el curso
                    System.out.println("El nombre de la asignatura es?");
                    String nombreassignatura= scanner.nextLine();
                    //buscamos en todos los cursos
                    for (int i = 0; i < llistaCursos.longitud(); i++) {
                         Curso curso = (Curso) llistaCursos.lista().get(i);
                         if(curso.ExisteAssignatura(nombreassignatura)==true){
                                encontrado =true;
                                String codi_a= curso.CodiAssignatura(nombreassignatura);
                                System.out.println(curso.toStringConDetalles());
                                System.out.println(listaEstudiantes.BuscarAlumnes(codi_a));
                            }
                    }
                    
                    break;
                case 7:
                    String error1="";
                    System.out.println("Dime el nombre del estudiante");
                    String nome=scanner.nextLine();
                    error1="El estudiante no existe";
                    //buscamos si el estudiante existe
                    for(int i = 0; i < listaEstudiantes.longitud(); i++){
                        error1="No hay alumno mismo nombre";
                        if(listaEstudiantes.getEstudiante(i).getDescripcion().equals(nome)){
                            //cogemos todos los codigos del estudiante
                            for(int j =0;j<listaEstudiantes.getEstudiante(i).getList().size();j++ ){
                                String codi_a=listaEstudiantes.getEstudiante(i).getAsignaturasMatriculadas(j);
                                //buscamos en cada curso
                                
                                for (int a = 0; a < llistaCursos.longitud(); a++) {
                                    //buscamos en las asignaturas
                                    for(int b =0; b < llistaCursos.getCurs(a).getLlistaAssignatura().longitud();b++){
                                        error1="No hay asignaturas mismo codigoi"; 
                                        if(llistaCursos.getCurs(a).getLlistaAssignatura().getObject(b).compareCodi(codi_a)==true){
                                            System.out.println(llistaCursos.getCurs(a).toStringConDetalles());
                                            System.out.println(llistaCursos.getCurs(a).getLlistaAssignatura().getObject(b).toStringConDetalles());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    System.out.println(error1);
                    break;

        
            }
            }while(num!=0);
        
        }
}
        

