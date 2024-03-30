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


public class Datos {
    private static HotelManager manager;

    public static void cargarDatos() {
        ExcelManager excel = new ExcelManager();
        ListaDoble historial = excel.Leer_Historial(); 
        SBT roomTree = excel.Leer_habitaciones(historial); 
        Hashtable table = excel.Leer_Estado();
        roomTree = excel.uptadeRooms(roomTree, table); 
        SBT reserveTree = excel.Leer_reservas();
        manager = new HotelManager(table, roomTree, reserveTree);
        reserveTree.inOrder(reserveTree.getRoot());
        //reserveTree.delete(12922153);
 
    }

    public static HotelManager getManager() {
        return manager;
    }
}


