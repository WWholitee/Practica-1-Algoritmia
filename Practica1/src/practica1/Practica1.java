package practica1;

import java.util.Scanner;

/**
 *
 * @author ellen
 */
public class Practica1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        LlistaCurs llistaCursos = new LlistaCurs();  // Lista de cursos
        ListaEstudiantes listaEstudiantes = new ListaEstudiantes();  // Lista de estudiantes

        do {
            System.out.println("OPCION 1: Dar de Alta un Curso y sus Asignaturas");
            System.out.println("OPCION 2: Dar de Alta un alumno dada una asignatura a la que se quiere matricular");
            System.out.println("OPCION 3: Dar de baja un curso");
            System.out.println("OPCION 4: Dar de baja una assignatura");
            System.out.println("OPCION 5: Dado un curso imprimir todas sus asignaturas y los estudiantes que estan matriculados a cada una de ellas");
            num = scanner.nextInt();
            scanner.nextLine();

            switch (num) {
                case 1:
                    // Dar de alta un curso y sus asignaturas
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
                    int numa = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < numa; i++) {
                        Assignatura a;
                        System.out.println("Añade nombre, código y número de créditos");
                        a = new AssignaturaOblig(scanner.nextLine(), scanner.nextLine(), scanner.nextInt());
                        scanner.nextLine();
                        curs.AddAssignatura(a);
                    }
                    System.out.println("Lista de asignaturas:");
                    System.out.println(curs.StringAssignaturas());
                    llistaCursos.addObject(curs);
                    break;

                case 2:
                    // Dar de alta un estudiante y matricularlo en una asignatura
                    Assignatura assignatura;
                    Estudiantes estudiante;
                    System.out.println("Es una asignatura obligatoria(1) o opcional(2)");
                    int aux = scanner.nextInt();
                    scanner.nextLine();
                    if (aux == 1) {
                        System.out.println("¿Cuál es la asignatura obligatoria a la que te quieres matricular? (Escribe el nombre, el código y los créditos)");
                        assignatura = new AssignaturaOblig(scanner.nextLine(), scanner.nextLine(), scanner.nextInt());
                        scanner.nextLine();
                    } else {
                        System.out.println("¿Cuál es la asignatura opcional a la que te quieres matricular? (Escribe el nombre, el código y el perfil)");
                        assignatura = new AssignaturaOpt(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                    }
                    System.out.println("Escribe el nombre y el DNI del estudiante");
                    estudiante = new Estudiantes(scanner.nextLine(), scanner.nextLine());
                    estudiante.matricularAsignatura(assignatura); // Matriculamos el estudiante en la asignatura
                    listaEstudiantes.addEstudiante(estudiante);  // Añadimos el estudiante a la lista de estudiantes
                    System.out.println("Estudiante " + estudiante.getNombre() + " con DNI " + estudiante.getDNI() + " matriculado en la asignatura " + assignatura.toString());
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
                            llistaCursos.lista().remove(i);
                            encontrado = true;
                            System.out.println("Curso '" + cursoNombre + "' dado de baja correctamente.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Curso no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Introduce el nombre del curso donde se encuentra la asignatura a dar de baja");
                    cursoNombre = scanner.nextLine();
                    System.out.println("Introduce el nombre de la asignatura a borrar");
                    String assignaturaNombre = scanner.nextLine();
                    encontrado = false;
                    for (int i = 0; i < llistaCursos.longitud(); i++) {
                        Curso curso = (Curso) llistaCursos.lista().get(i);
                        if (curso.getNombre().equals(cursoNombre)) {
                            curso.eliminarAssignatura(assignaturaNombre);
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Curso no encontrado.");
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

                                // Imprimimos los estudiantes matriculados en esta asignatura
                                asignatura.imprimirMatriculados();
                            }
                            break;
                        }
                    }

                    if (!cursoEncontrado) {
                        System.out.println("No se encontró el curso con el nombre y código proporcionado.");
                    }
                    break;

            }
        } while (num != 0);

        scanner.close();  // Cerrar el scanner
    }
}
