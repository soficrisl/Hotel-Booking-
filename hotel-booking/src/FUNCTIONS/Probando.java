/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FUNCTIONS;

import EDD.Hashtable;
import EDD.ListaDoble;
import EDD.NodoDoble;
import EDD.SBT;
import OBJECTS.Client;

/**
 *
 * @author Sofia
 */
public class Probando {
    
   public static void main (String[] args){
        ExcelManager excel = new ExcelManager();
        ListaDoble historial = excel.Leer_Historial(); 
        SBT roomTree = excel.Leer_habitaciones(historial); 
        Hashtable table = excel.Leer_Estado();
        roomTree = excel.uptadeRooms(roomTree, table); 
        SBT reserveTree = excel.Leer_reservas();
        HotelManager manager = new HotelManager(table, roomTree, reserveTree); 
        
        printwData(table); 
        //Probando
        /*Funciona
        System.out.println("1");
        search1 ("Xenos", "Blague", manager);
        System.out.println("2");
        search1 ("Niels", "Lauthian", manager);
        System.out.println("3");
        search1 ("Trixy", "Dominik", manager);
        System.out.println("4");
        search1 ("Sofia", "Leon", manager);
        System.out.println("5");
        search1 ("Tamar", "Dwerryhouse", manager);
        */        

   }
   
   public static void search1(String f_name, String l_name, HotelManager manager){
        ListaDoble result = manager.searchClient(f_name, l_name); 
        NodoDoble pointer = result.getHead(); 
        while (pointer!= null){
            System.out.println(((Client)pointer.getElement()).data());
            pointer = pointer.getNext(); 
        }
   }
   
   public static void printwData(Hashtable table) {
      ListaDoble[] x = table.getHastable(); 
       for (int i = 0; i < x.length; i++) {
           NodoDoble pointer = x[i].getHead(); 
           while (pointer != null){
               System.out.println("["+ i + "]" + ((Client)pointer.getElement()).data());
               pointer = pointer.getNext();
           }
           
       }
   }
   
   /*
    public static void inOrderwData(NodoTree root) {
        if (root!= null){
           inOrderwData(root.getLeftSon()); 
           System.out.println(root.getKey() + " - " +((Reservation)root.getElement()).data());
           inOrderwData(root.getRightSon()); 
        }
    }
    
    public static void x(NodoTree root){
         if (root!= null){
           x(root.getLeftSon()); 
           System.out.println(root.getKey() + " - " +((Room)root.getElement()).data());
           x(root.getRightSon()); 
        }
    }
        */   
}
