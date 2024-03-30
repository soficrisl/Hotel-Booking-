/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FUNCTIONS;

import EDD.Hashtable;
import EDD.ListaDoble;
import EDD.NodoDoble;
import EDD.NodoTree;
import EDD.SBT;
import OBJECTS.Client;
import OBJECTS.Reservation;
import OBJECTS.Room;

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
        
        System.out.println("ESTA ES UNA PRUEBA");
        
        System.out.println("----------------------BUSQUEDA DE CLIENTE POR NOMBRE------------------------");
        System.out.println("Base de datos de clientes\n");
        printwData(table); 
        System.out.println("\n");
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
        /*
        System.out.println("\n\n----------------------BUSQUEDA DE RESERVAS POR ID------------------------");
        System.out.println("Base de datos de reservas\n");
        inOrderwData(reserveTree.getRoot()); 
        System.out.println("1");
        search2(15505394, manager);
        System.out.println("2");
        search2(2, manager);
        System.out.println("3");
        search2(13144904, manager);
        System.out.println("2");
        search2(18824967, manager);
        System.out.println("\n\n----------------------BUSQUEDA DE RESERVAS POR HABITACION------------------------");
        System.out.println("Base de datos de reservas\n");
        x(roomTree.getRoot()); 
        System.out.println("\n\n");
        System.out.println("1- Room 1");
        search3(1, manager); 
        System.out.println("2- Room 27");
        search3(27, manager); 
        System.out.println("3- Room 50");
        search3(50, manager); 
        
        
        System.out.println("\n\n----------------------CHECK-IN-----------------------");
        x(roomTree.getRoot()); 
        System.out.println("Base de datos de reservas\n");
        inOrderwData(reserveTree.getRoot()); 
        System.out.println("\n\n");
        System.out.println("Base de datos de clientes\n");
        printwData(table); 
        System.out.println("\n\n");
        System.out.println(manager.CheckIn(15505394));
        System.out.println("Base de datos de reservas\n");
        inOrderwData(reserveTree.getRoot()); 
        System.out.println("\n\n");
        System.out.println("Base de datos de clientes\n");
        printwData(table); 
        System.out.println("\n\n");
        x(roomTree.getRoot()); 
      */
        System.out.println("----------------------CHECK-OUT-----------------------");
        System.out.println("Base de datos de clientes\n");
        printwData(table); 
        System.out.println("\n\n");
        ListaDoble encontrado = manager.searchClient("Xenos", "Blague"); 
        Client found = (Client)encontrado.getHead().getElement(); 
        System.out.println("BUSQUEDA EN HABITACION CORRESPONDIENTE");
        search3(found.getRoomNum(), manager); 
        manager.CheckOut(found); 
        System.out.println("\n\n");
        System.out.println("Base de datos de clientes\n");
        printwData(table); 
        System.out.println("\n\n");
        System.out.println("BUSQUEDA EN HABITACION CORRESPONDIENTE");
        search3(found.getRoomNum(), manager);
        System.out.println("\n\nARBOL DE HABITACIONES");
        x(roomTree.getRoot()); 
        
       
   }
   public static void search1(String f_name, String l_name, HotelManager manager){
        ListaDoble result = manager.searchClient(f_name, l_name); 
        if (result != null) {
            NodoDoble pointer = result.getHead(); 
            while (pointer!= null){
                System.out.println(((Client)pointer.getElement()).data());
                pointer = pointer.getNext(); 
            }
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
   
   public static void search2(int id, HotelManager manager) {
       Reservation x = manager.searchReservation(id); 
       if (x != null) {
           System.out.println(x.data());
       } else {
           System.out.println("Not found");
       }

   }
   
   public static void search3(int num, HotelManager manager){
       ListaDoble x = manager.roomHistory(num); 
       NodoDoble pointer = x.getHead(); 
       while (pointer != null){
           System.out.println(((Client)pointer.getElement()).data()); 
           pointer = pointer.getNext(); 
       }
       
   }
 
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
         
}