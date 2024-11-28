/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

/**
 *
 * @author ellen
 */
public class LlistaNode {

   private Node inici; 
   
   public LlistaNode(){
       this.inici=null;
   }
   
   public void Nodenou(String a ){
       Node Nounode= new Node(a);
       
       if(inici==null){
           inici=Nounode;
       }else{ //caso de que no sea el primer nodo 
           Node act= inici;
           while(act.seg!= null){//recoremos la lista hasata encontrar el ultimo elemento de la lista
               act=act.seg;
           }
           act.seg=Nounode;
       }
   }
   
   public void MostrarLLista(){
       if(inici==null){
           System.out.println("La llista esta buida");
           return;
       }
       Node act=inici;
       while(act != null){
           System.out.println(act.info+" ");
           act=act.seg;
       }
   }
   
//   public void InsercioNodeOrdenat(String a){
//       Node node=new Node(a);
//       //si el es el primero o es mayor el inicio
//       if(inici ==null|| inici.info>= a){
//           node.seg=inici;
//           inici=node;
//           
//       }else{
//           Node act=inici;
//           while(act.seg!=null && act.seg.info< a ){
//               act=act.seg;
//           }
//           node.seg =act.seg;
//           act.seg=node;
//       }
//   }
   
   //metodo para borrar un elemento segun su valor
   public Node BorrarNode(String a){
       //caso lista vacia
       if(inici==null){
           System.out.println("la lista esta vacia");
          return null;
       }
       
       Node act=inici;
       Node ant=null;
       Node borrar=null;
       Node borrarant=null;
       //busacamos si hay coincidencias en la lista y los ponemos en borrar
       while(act !=null){
           if(act.info.equals(a)){
               borrar=act;
               borrarant=ant;
           }
           ant=act;
           act=act.seg;
       }
       if(borrar==null){
           System.out.println("no hay conicidencias");
           return null;
       }
       if (borrar==inici){
           inici=borrar.seg;
           //si no es el primer el punter del nombre anterior al borrat te que apuntar on apuntaba en borrar.seg
       }else{
           borrarant.seg=borrar.seg;
       }
       borrar.seg=null;
       return borrar;
   }
   
    public void EliminarNode(String a){
       //caso lista vacia
       if(inici==null){
           System.out.println("la lista esta vacia");
       }
       
       Node act=inici;
       Node ant=null;
       Node borrar=null;
       Node borrarant=null;
       //busacamos si hay coincidencias en la lista y los ponemos en borrar
       while(act !=null){
           if(act.info.equals(a)){
               borrar=act;
               borrarant=ant;
           }
           ant=act;
           act=act.seg;
       }
       if(borrar==null){
           System.out.println("no hay conicidencias");
       }
       if (borrar==inici){
           inici=borrar.seg;
           //si no es el primer el punter del nombre anterior al borrat te que apuntar on apuntaba en borrar.seg
       }else{
           borrarant.seg=borrar.seg;
       }
       borrar.seg=null;
   }
   public void Eliminarkessim(int posicio){
      if (inici == null) {
            System.out.println("La llista està buida.");
            return;
        }
      if(posicio<=0){
          System.out.println("valor no valid");
          return;
          
      }
      if(posicio==1){
          inici = inici.seg;
            System.out.println("Eliminat");
            return;
      }
      Node act=inici;
      Node ant=null;
      int compt=1;
      while(act!=null&&compt<posicio){
          ant=act;
          act=act.seg;
          compt++;
      }
      if(act==null){
          System.out.println("La llista te menys elements.");
      }else{
          ant.seg=act.seg;
          System.out.println("Se ha eliminat el element");
      }
   }
      
     // Método para obtener el String de una posición específica
public String ObtenirStringPosicio(int posicio) {
    if (inici == null) {
        System.out.println("La llista està buida.");
        return null;
    }
    if (posicio <= 0) {
        System.out.println("Posició no vàlida.");
        return null;
    }
    Node act = inici;
    int compt = 1; // Contador de posición
    while (act != null && compt < posicio) {
        act = act.seg;
        compt++;
    }
    if (act == null) {
        System.out.println("La posició no existeix a la llista.");
        return null;
    }
    return act.info; // Retorna el valor de la posició trobada
}

// Método para calcular la longitud de la lista
public int LongitudLlista() {
    int compt = 0;
    Node act = inici;
    while (act != null) {
        compt++;
        act = act.seg;
    }
    return compt; // Retorna la quantitat d'elements
}
}

