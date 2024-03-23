/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import EDD.ListaDoble;
import EDD.SBT;
import FUNCTIONS.ExcelManager;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDoble lista_historial =  new ListaDoble();
        ExcelManager excel = new ExcelManager();
        excel.Leer_Historial(lista_historial);
        excel.Leer_habitaciones();
        excel.Leer_Estado();
        excel.Leer_reservas();
        
        
        GUI interfaz1 = new GUI();
        interfaz1.setVisible(true);
    }
}
