/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import EDD.Hashtable;
import EDD.ListaDoble;
import EDD.SBT;
import FUNCTIONS.ExcelManager;
import FUNCTIONS.HotelManager;
import OBJECTS.Client;
import OBJECTS.Reservation;
import OBJECTS.Room;


/**
 *
 * @author User
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ExcelManager excel = new ExcelManager();
        ListaDoble historial = excel.Leer_Historial(); 
        SBT roomTree = excel.Leer_habitaciones(historial); 
        Hashtable table = excel.Leer_Estado();
        roomTree = excel.uptadeRooms(roomTree, table); 
        SBT reserveTree = excel.Leer_reservas();
        HotelManager manager = new HotelManager(table, roomTree, reserveTree); 
    
        //GUI interfaz1 = new GUI();
        //interfaz1.setVisible(true);
    }
   
}

