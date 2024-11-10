/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package practica1;

/**
 *
 * @author ellen
 */
public class Curso {

   private String nombre_c;
   private String codi_c;
   
   public Curso(String nombre, String codigo){
       this.codi_c=codigo;
       this.nombre_c=nombre;
         
       }
   
   public String toString(){
       return "Curso: "+ nombre_c+"Con codigo:"+ codi_c;
   }
   }

