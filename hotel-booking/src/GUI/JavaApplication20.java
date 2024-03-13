/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GUI;

import FUNCTIONS.ExcelManager;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class JavaApplication20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // GUI interfaz1 = new GUI();
        // interfaz1.setVisible(true);
        ExcelManager xlsx = new ExcelManager();
        xlsx.readExcel();
        
        //lee y separa datos de reservas
        List lista = xlsx.reservas;
        for (int i = 0; i < lista.size(); i++) {
            LinkedList datos = (LinkedList) lista.get(i);
            String cedula;
            String primer_nombre;
            String segundo_nombre;
            String email;
            String genero;
            String tipo_hab;
            String llegada;
            String salida;

            for (int j = 0; j < datos.size(); j++) {
                // Gestionar todas las variables por separado
                {
                    if (j == 0) {
                        String dato = (String) datos.get(j);
                        cedula = dato;
                    }
                    if (j == 1) {
                        String dato = (String) datos.get(j);
                        primer_nombre = dato;
                    }
                    if (j == 2) {
                        String dato = (String) datos.get(j);
                        segundo_nombre = dato;
                    }
                    if (j == 3) {
                        String dato = (String) datos.get(j);
                        email = dato;
                    }
                    if (j == 4) {
                        String dato = (String) datos.get(j);
                        genero = dato;
                    }
                    if (j == 5) {
                        String dato = (String) datos.get(j);
                        tipo_hab = dato;
                    }
                    if (j == 6) {
                        String dato = (String) datos.get(j);
                        llegada = dato;
                    }
                    if (j == 7) {
                        String dato = (String) datos.get(j);
                        salida = dato;
                    }
                }
                
                // añadirArbol(cedula, primer_nombre, segundo_nombre)
            }
        }
        
        //lee y separa datos de habitaciones
        
    }
}
