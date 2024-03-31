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
 * Class that manages all the operations needed in a hotel
 * @author cristiandresgp and soficrisl
 */
public class HotelManager {
    //Atributos
    private Hashtable clientsTable;
    private SBT roomTree; 
    private SBT reserveTree; 
    //Constructor
    public HotelManager(Hashtable clientsTable, SBT roomTree, SBT reserveTree) {
        this.clientsTable = clientsTable;
        this.roomTree = roomTree;
        this.reserveTree = reserveTree;
    } //End of constructor
    
    /**
     * Method to search for a client in the clients Hashtable
     * Complexity approximately O(1)
     * @param f_name
     * @param l_name
     * @return ListaDoble of clients with the same name. 
     */
    public ListaDoble searchClient (String f_name, String l_name) {
        String key = f_name +" "+ l_name;
        ListaDoble match = clientsTable.search(key); 
        NodoDoble pointer = match.getHead(); 
        int aux = 0; 
        ListaDoble clone  = new ListaDoble(); 
        while (pointer!= null){
            clone.insertFinal(pointer.getElement());
             pointer = pointer.getNext();
        }
        pointer = clone.getHead();
        while (pointer!= null){
            String nombre = ((Client)pointer.getElement()).getF_name(); 
            String apellido = ((Client)pointer.getElement()).getL_name(); 
            pointer = pointer.getNext();     
            if (!nombre.equalsIgnoreCase(f_name) || !apellido.equalsIgnoreCase(l_name)) {
                clone.deleteInIndex(aux); 
            } else {
                aux++; 
            } 
        }
      return clone;  
    }
    
    /**
     * Method to search for a reservation in the reservation tree, by the id of the reservation. 
     * Complexity approximately O(logn)
     * @param id
     * @return  reservation being looked for 
     */
    public Reservation searchReservation (int id) {
        Reservation found = (Reservation)reserveTree.search(id, reserveTree.getRoot()); 
        return found; 
    }
    
/**
 * Method to get the history of a specific room by the number of the room, by looking with O(logn) complexity in the room Tree.
 * @param roomNum
 * @return ListaDoble of clients that have stayed in the room
 */
    public ListaDoble roomHistory (int roomNum) {
        Room found = (Room)roomTree.search(roomNum, roomTree.getRoot());
        if (found == null){
            return null;}
        return found.getHistorial(); 
    }
 /**
  * Method to Check in a client by the id in their reservation
  * @param id
  * @return Status of Check in, 0 means reservation non existant, 1 means that there are no rooms avalaible, and 2 means check in completed successfully
  */   
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
    
    /**
     * Method to find an unnocupied room by its type
     * @param roomType
     * @param root
     * @return  room with the attribute occupied in false; 
     */
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
/**
 * Method to do check out of a client object
 * @param client
 * @return status of checkout, 1 means completed successfully
 */
    public int CheckOut (Client client){
        //Escogemos la fecha de hoy; 
        LocalDate currentDate = LocalDate.now(); 
        String currentDateString = currentDate.toString(); 
        String [] pre = currentDateString.split("-"); 
        String final_date = pre[2] + "/" + pre[1] + "/" + pre[0]; 
        
        
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
    /**
     * Method to search for an specific room in the roomTree by its room number
     * @param numHab
     * @return room
     */
    public Room searchRoom (int numHab) {
        return (Room)roomTree.search(numHab, roomTree.getRoot());
    }
}

    
