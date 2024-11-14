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
        do{
            System.out.println("OPCION 1:Dar de Alta un Curso y sus Asignaturas");
            num = scanner.nextInt();
            
            switch(num){
                case 1:
                    Curso curs;
                    System.out.println("Bachiller(1) o FP(2)");
                    int tipo=scanner.nextInt();
                    if(tipo ==1){
                        curs= new Batxiller(scanner.next(),scanner.next(),scanner.next());
                    }else
                        curs = new FormacioProfessional(scanner.next(),scanner.next(),scanner.next());
                    System.out.println("Afegir assignatures");
                    System.out.println("Dime cuantas asignaturas quieres meter");
                    int numa=scanner.nextInt();
                    for(int i=0; i< numa;i++){
                        Assignatura a; 
                        System.out.println("Añade nombre, codigo y numero de credits");
                        a= new AssignaturaOblig(scanner.next(),scanner.next(),scanner.nextInt());
                        curs.AddAssignatura(a);
                    }
                    System.out.println("Lista assignaturas");
                    System.out.println(curs.StringAssignaturas());
                    break;
             default:
                    System.out.println("no es una opcio valida");
                    break;       
            }
        }while (num !=0 );
    }
    
}
