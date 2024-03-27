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
import java.time.LocalDate;
import java.util.Date;

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
        if (match.getHead() != null) {
           return match;
        } else {
            return null; 
        } 
    }
    
    public Reservation searchReservation (int id) {
        Reservation found = (Reservation)reserveTree.search(id, reserveTree.getRoot()); 
        return found; 
    }
    
    public ListaDoble roomHistory (int roomNum) {
        Room found = (Room)roomTree.search(roomNum, roomTree.getRoot());
        if (found == null){
            return null;}
        return found.getHistorial(); 
    }
    
    public int CheckIn (int id) {
        Reservation newClient = searchReservation(id); 
        if (newClient == null) {
            return 0; 
        } else {
            String roomType = newClient.getRoomType(); 
            Room newRoom = findRoom (roomType, roomTree.getRoot()); 
            if (newRoom == null) {
                return 1; 
            } else {
                int numHab = newRoom.getNumHab(); 
                reserveTree.delete(newClient.getClientID());
                Client client = newClient.getLeadClient(); 
                client.setRoomNum(numHab);
                newRoom.setOcupied(true);
                roomTree.setNodoElement(numHab, newRoom); 
                String key = client.getF_name() + " " + client.getL_name(); 
                clientsTable.insert(key, client);
                return 2; 
            } 
        }  
    }
    
    public Room findRoom (String roomType, NodoTree root) {
        if (root == null) {
            return null; 
        } 
        Room room = (Room)root.getElement(); 
        if (!room.isOcupied() && room.getRoomType().equalsIgnoreCase(roomType)) {
            return room; 
        } else  {
            if (root.getLeftSon() != null) {
               room = findRoom (roomType, root.getLeftSon()); 
               if (room != null) return room;  
              
            }
            if (root.getRightSon() != null) {
                room = findRoom (roomType, root.getRightSon()); 
                if (room != null) return room;  
            } if (root.isLeaf()) {
                return null; 
                }
            }
        return null; 
        }

    public int CheckOut (Client client){
        //Escogemos la fecha de hoy; 
        LocalDate currentDate = LocalDate.now(); 
        String currentDateString = currentDate.toString(); 
        String final_date = currentDateString.replace("-", "/"); 
        
        
        int numRoom = client.getRoomNum(); 
        ListaDoble clients = new ListaDoble(); 
        ListaDoble[] table = clientsTable.getHastable(); 
        for (ListaDoble lista : table) {
            NodoDoble pointer = lista.getHead(); 
            while (pointer != null){
                Client possibleClient = (Client)pointer.getElement(); 
                if (possibleClient.getRoomNum() == numRoom){ 
                    clients.insertBegin(possibleClient);
                }
                pointer = pointer.getNext(); 
            }
        }
        Room room = (Room)roomTree.search(numRoom, roomTree.getRoot()); 
        NodoDoble pointer = clients.getHead(); 
        while (pointer != null) {
            Client currentClient = (Client)pointer.getElement(); 
            String Key = currentClient.getF_name() + " " + currentClient.getL_name(); 
            clientsTable.delete(Key, currentClient);
            currentClient.setDeparture(final_date);
            room.insertInHistory(currentClient);
            pointer = pointer.getNext(); 
        }
        room.setOcupied(false);
        roomTree.setNodoElement(numRoom, room); 
        return 1; 
    }
}

    
