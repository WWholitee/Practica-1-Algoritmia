/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package practica1;

/**
 *
 * @author ellen
 */
public class Batxiller extends Curso {

   private String curss;
   public Batxiller(String nombre, String codi, String curss){
       super(nombre,codi);
       this.curss=curss;
   }

   
    public void imprimirCurso(){
        System.out.println("Batxiller: " + getNombre());
        llistaAssignatura.imprimirAssignatura();
    }
    @Override
    public String getTipo() {
        return "Curso de Batxiller(" + curss + ")";
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Curso Batxiller: " + getNombre() + " - Código: " + getCodigo() + " - Curso: " + curss);
    }
}