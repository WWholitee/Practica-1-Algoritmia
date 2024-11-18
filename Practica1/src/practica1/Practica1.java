/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author ellen
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.println("OPCION 1:Dar de Alta un Curso y sus Asignaturas");
            System.out.println("OPCION 2:Dar de Alta un alumno dada una asignatura a la que se quiere matricular");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    Curso curs;
                    System.out.println("Bachiller(1) o FP(2)");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        System.out.println("Escriba el nombre, el codigo y el curso del Bachiller que quiere añadir");
                        curs = new Batxiller(scanner.next(), scanner.next(), scanner.next());
                    } else {
                        System.out.println("Escriba el nombre, el codigo y el curso de la Formación Profesional que quiere añadir");
                        curs = new FormacioProfessional(scanner.next(), scanner.next(), scanner.next());
                    }

                    System.out.println("Afegir assignatures");
                    System.out.println("Dime cuantas asignaturas quieres meter");
                    int numa = scanner.nextInt();
                    for (int i = 0; i < numa; i++) {
                        Assignatura a;
                        System.out.println("Añade nombre, codigo y numero de credits");
                        a = new AssignaturaOblig(scanner.next(), scanner.next(), scanner.nextInt());
                        curs.AddAssignatura(a);
                    }
                    System.out.println("Lista assignaturas");
                    System.out.println(curs.StringAssignaturas());
                    break;
                case 2:
                    Assignatura assignatura;
                    Estudiantes estudiante;
                    ListaEstudiantes listaE = new ListaEstudiantes();
                    System.out.println("Es una asignatura obligatoria(1) o opcional(2)");
                    int aux = scanner.nextInt();
                    scanner.nextLine();
                    if (aux == 1) {
                        System.out.println("Cual es la asignatura obligatoria a la que te quieres matricular? (Escribe el nombre, el codigo y los créditos");
                        assignatura = new AssignaturaOblig(scanner.nextLine(), scanner.nextLine(), scanner.nextInt());
                        scanner.nextLine();
                    } else {
                        System.out.println("Cual es la asignatura opcional a la que te quieres matricular? (Escribe el nombre, el codigo y el perfil");
                        assignatura = new AssignaturaOpt(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                    }
                    System.out.println("Escribe el nombre y el DNI del estudiante");
                    estudiante = new Estudiantes(scanner.nextLine(), scanner.nextLine());
                    estudiante.matricularAsignatura(assignatura);
                    listaE.addEstudiante(estudiante);
                    System.out.println("Estudiante " + estudiante.getNombre() + " con DNI " + estudiante.getDNI() + " matriculado a la asignatura " + assignatura.toString());
                    break;
                default:
                    System.out.println("no es una opcio valida");
                    break;
            }
        } while (num != 0);
    }
    
}
