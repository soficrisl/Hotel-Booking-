/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

/**
 * clase que define la clase reservacion del hotel 
 * @author cristiandresgp
 */
public class Reservation {
   int clientID; 
   Client leadClient;
   String roomType;  

    public Reservation(int clientID, Client leadClient, String roomType) {
        this.clientID = clientID;
        this.leadClient = leadClient;
        this.roomType = roomType;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Client getLeadClient() {
        return leadClient;
    }

    public void setLeadClient(Client leadClient) {
        this.leadClient = leadClient;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
   
    public String data(){
        return clientID + " - " + leadClient.getF_name() + " " + leadClient.getL_name() + " - "+ roomType; 
    }
    
    public String show(){
        if (clientID != -1) {
            return " ID: " + clientID + ".\n Nombre y apellido: " + leadClient.getFull_name() +  ".\n Tipo de habitación: "+ roomType + ".\n Email: " + leadClient.getEmail() + ".\n Genero: " + leadClient.getGender() + ".\n Telefono:" + leadClient.getCellphone() + ".\n Llegada:" + leadClient.getArrival() + ".\n Salida: " + leadClient.getDeparture(); 
        }
        return " ID: No hay ID disponible" + ".\n Nombre y apellido: " + leadClient.getFull_name() +  ".\n Tipo de habitación: "+ roomType + ".\n Email: " + leadClient.getEmail() + ".\n Genero: " + leadClient.getGender() + ".\n Telefono:" + leadClient.getCellphone() + ".\n Llegada:" + leadClient.getArrival() + ".\n Salida: " + leadClient.getDeparture(); 

    }
}