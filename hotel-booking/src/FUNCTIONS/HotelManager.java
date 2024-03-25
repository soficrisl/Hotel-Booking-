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
import OBJECTS.Reservation;
import OBJECTS.Room;

/**
 *
 * @author cristiandresgp
 */
public class HotelManager {
    private Hashtable clientsTable;
    private SBT roomTree; 
    private SBT reserveTree; 

    public HotelManager(Hashtable clientsTable, SBT roomTree, SBT reserveTree) {
        this.clientsTable = clientsTable;
        this.roomTree = roomTree;
        this.reserveTree = reserveTree;
    }

    public ListaDoble searchClient (String f_name, String l_name) {
        String key = f_name +" "+ l_name;
        ListaDoble match = clientsTable.search(key); 
        NodoDoble pointer = match.getHead(); 
        int aux = 0; 
        while (pointer!= null){
            String nombre = ((Client)pointer.getElement()).getF_name(); 
            String apellido = ((Client)pointer.getElement()).getL_name(); 
            String key2 = nombre + " " + apellido; 
            if (!nombre.equalsIgnoreCase(f_name) || !apellido.equalsIgnoreCase(l_name)) {
                match.deleteInIndex(aux); 
            }
            aux++; 
            pointer = pointer.getNext();      
        }
        return match; 
    }
    
    

}
