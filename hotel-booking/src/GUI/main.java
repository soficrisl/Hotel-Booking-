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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExcelManager xlsx = new ExcelManager();
        xlsx.readExcel();
        
        //Leer reservas y recorrer para obtener valores
        List listareservas = xlsx.reservas;
        for (int i = 0; i < listareservas.size(); i++) {
            LinkedList datos = (LinkedList) listareservas.get(i);
            String cedulares;
            String primer_nombreres;
            String segundo_nombreres;
            String emailres;
            String generores;
            String tipo_habres;
            String llegadares;
            String salidares;

            for (int j = 0; j < datos.size(); j++) {
                // Gestionar todas las variables por separado
                {
                    if (j == 0) {
                        String dato = (String) datos.get(j);
                        cedulares = dato;
                    }
                    if (j == 1) {
                        String dato = (String) datos.get(j);
                        primer_nombreres = dato;
                    }
                    if (j == 2) {
                        String dato = (String) datos.get(j);
                        segundo_nombreres = dato;
                    }
                    if (j == 3) {
                        String dato = (String) datos.get(j);
                        emailres = dato;
                    }
                    if (j == 4) {
                        String dato = (String) datos.get(j);
                        generores = dato;
                    }
                    if (j == 5) {
                        String dato = (String) datos.get(j);
                        tipo_habres = dato;
                    }
                    if (j == 6) {
                        String dato = (String) datos.get(j);
                        llegadares = dato;
                    }
                    if (j == 7) {
                        String dato = (String) datos.get(j);
                        salidares = dato;
                    }
                }
                
                // añadirArbol(cedula, primer_nombre, segundo_nombre)
            }
        }
        
        //Leer habitaciones y recorrer para obtener valores
        List listahabitaciones = xlsx.habitaciones;
        for (int i = 0; i < listahabitaciones.size(); i++) {
            LinkedList datos = (LinkedList) listahabitaciones.get(i);
            String num_habitaciones;
            String tipo_habitaciones;
            String pisohab;

            for (int j = 0; j < datos.size(); j++) {
                // Gestionar todas las variables por separado
                {
                    if (j == 0) {
                        String dato = (String) datos.get(j);
                        num_habitaciones = dato;
                    }
                    if (j == 1) {
                        String dato = (String) datos.get(j);
                        tipo_habitaciones = dato;
                    }
                    if (j == 2) {
                        String dato = (String) datos.get(j);
                        pisohab = dato;
                    }
                    
                }// añadirhabitaciones(num_habitaciones, tipo_habitaciones, pisohab)
            }
        }
        
        //Leer habitaciones y recorrer para obtener valores
        List listaestados = xlsx.estados;
        for (int i = 0; i < listaestados.size(); i++) {
            LinkedList datos = (LinkedList) listaestados.get(i);
            String num_habest;
            String primer_nombreest;
            String apellidoest;
            String emailest;
            String generoest;
            String celularest;
            String llegadaest;

            for (int j = 0; j < datos.size(); j++) {
                // Gestionar todas las variables por separado
                {
                    if (j == 0) {
                        String dato = (String) datos.get(j);
                        num_habest = dato;
                    }
                    if (j == 1) {
                        String dato = (String) datos.get(j);
                        primer_nombreest = dato;
                    }
                    if (j == 2) {
                        String dato = (String) datos.get(j);
                        apellidoest = dato;
                    }
                    if (j == 3) {
                        String dato = (String) datos.get(j);
                        emailest = dato;
                    }
                    if (j == 4) {
                        String dato = (String) datos.get(j);
                        generoest = dato;
                    }
                    if (j == 5) {
                        String dato = (String) datos.get(j);
                        celularest = dato;
                    }
                    if (j == 6) {
                        String dato = (String) datos.get(j);
                        llegadaest = dato;
                    }
                }
                // añadirestado(num_habest, primer_nombre, apellidoest)
            }
        }
        
        //Leer historicos y recorrer para obtener valores
        List listahistoricos = xlsx.historicos;
        for (int i = 0; i < listahistoricos.size(); i++) {
            LinkedList datos = (LinkedList) listahistoricos.get(i);
            String cedulahist;
            String primer_nombrehist;
            String segundo_nombrehist;
            String emailhist;
            String generohist;
            String llegadahist;
            String num_habhist;

            for (int j = 0; j < datos.size(); j++) {
                // Gestionar todas las variables por separado
                {
                    if (j == 0) {
                        String dato = (String) datos.get(j);
                        cedulahist = dato;
                    }
                    if (j == 1) {
                        String dato = (String) datos.get(j);
                        primer_nombrehist = dato;
                        
                    }
                    if (j == 2) {
                        String dato = (String) datos.get(j);
                        segundo_nombrehist = dato;
                    }
                    if (j == 3) {
                        String dato = (String) datos.get(j);
                        emailhist = dato;
                    }
                    if (j == 4) {
                        String dato = (String) datos.get(j);
                        generohist = dato;
                    }
                    if (j == 5) {
                        String dato = (String) datos.get(j);
                        llegadahist = dato;
                    }
                    if (j == 6) {
                        String dato = (String) datos.get(j);
                        num_habhist = dato;
                       
                    }
                }
                // añadirHistorico(cedula, primer_nombre, segundo_nombre)
            }
        }
        
        //Inicializa interfaz
        GUI interfaz1 = new GUI();
        interfaz1.setVisible(true);
    }
}
