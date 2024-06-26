/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

import EDD.ListaDoble;
import EDD.NodoDoble;

/**
 * clase que define la clase habitacion del hotel 
 * @author cristiandresgp
 */
public class Room {
    int NumHab; 
    int floor; 
    ListaDoble historial; 
    String roomType; 
    boolean ocupied; 

    public Room(int NumHab, int floor, ListaDoble historial, String roomType) {
        this.NumHab = NumHab;
        this.floor = floor;
        this.historial = historial;
        this.roomType = roomType;
        this.ocupied = false;
    }

    public int getNumHab() {
        return NumHab;
    }

    public void setNumHab(int NumHab) {
        this.NumHab = NumHab;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ListaDoble getHistorial() {
        return historial;
    }

    public void setHistorial(ListaDoble historial) {
        this.historial = historial;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isOcupied() {
        return ocupied;
    }

    public void setOcupied(boolean ocupied) {
        this.ocupied = ocupied;
    }
    
    public String data(){
        String x  = ""; 
        NodoDoble pointer = historial.getHead(); 
        int aux = 0; 
        while (pointer != null) {
            x += "Client " + aux + " " + ((Client)pointer.getElement()).getId() + " - / "; 
            pointer = pointer.getNext(); 
            aux++; 
        }
        
        return NumHab + " - " + roomType + " - " + ocupied +" - " + x; 
    }
    
    public void insertInHistory(Client client) {
        historial.insertFinal(client);
    }
    
    
}
