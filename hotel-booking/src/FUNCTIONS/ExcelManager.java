package FUNCTIONS;

import EDD.Hastable;
import EDD.ListaDoble;
import EDD.SBT;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.String.valueOf;
import javax.swing.JOptionPane;

/**
 * Esta clase lee y controla los datos del excel. Incluye las funciones de: Leer_reservas, Leer_Habitaciones, Leer_Estado y Leer_Historial 
 *
 * @author Julene
 * @version 22/03/2024
 */

public class ExcelManager {

    /**
     * Metodo que lee el sheet de Reservas y maneja los datos. Se anaden dichos datos a las estructuras en la que corresponden
     * 
     *@IOException ex
     *@HeadlessException
     * 
     */
    
    public void Leer_reservas() {
            String line;
            String reservas_csv = "";
            String path = "test\\reservas.csv";
            File file = new File(path);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            reservas_csv += line + "\n";
                        }
                    }
                    if (!"".equals(reservas_csv)) {
                        String[] expresion_split = reservas_csv.split("\n");
                        for (int i = 0; i < expresion_split.length; i++) {

                            String[] datos = expresion_split[i].split(",");

                            int cedula_res = Integer.parseInt(datos[0].replaceAll("\\.", ""));
                            String nombre_res = datos[1];
                            String apellido_res = datos[2];
                            String email_res = datos[3];
                            String sexo_res = datos[4];
                            String telf_res = datos[6];
                            String tipo_hab_res = datos[5];
                            String fecha_llegada_res = datos[7];
                            String fecha_salida_res = datos[8];
                            
//                            System.out.println(cedula_res);
//                            System.out.println(nombre_res);
//                            System.out.println(apellido_res);
//                            System.out.println(email_res);
//                            System.out.println(sexo_res);
//                            System.out.println(telf_res);
//                            System.out.println(tipo_hab_res);
//                              System.out.println(fecha_llegada_res);
//                            System.out.println(fecha_salida_res);
//                            
                            //HotelCard card = new HotelCard(num_hab_res, fecha_llegada_res, fecha_salida_res, 0);
                            //Cliente cliente = new Cliente(cedulaa_res, nombre_res, apellido_res, email_res, sexo_res, cedula_res, card);

                        }
                    }
                    br.close();
                }
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer la expresion");
            }

        }
        
        /**
        * Metodo que lee el sheet de Habitaciones y maneja los datos. Se anaden dichos datos a las estructuras en la que corresponden
        * 
        *@IOException ex
        *@HeadlessException
        * 
        */
    // meter como parametro = SBT lista_habitacion, ListaDoble historial
        public void Leer_habitaciones() {
            String line;
            String expresion_txt = "";
            String path = "test\\habitaciones.csv";
            File file = new File(path);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            expresion_txt += line + "\n";
                        }
                    }
                    if (!"".equals(expresion_txt)) {
                        String[] expresion_split = expresion_txt.split("\n");
                        for (int i = 0; i < expresion_split.length; i++) {
                            String[] datos = expresion_split[i].split(",");

                            int num_hab = Integer.parseInt(datos[0]);
                            String tipo_hab = datos[1];
                            int piso_hab = Integer.parseInt(datos[2]);

                            //Room room = new Room(historial, false, num_hab, tipo_hab, piso_hab);
                            //insertaralarbol();
//                            System.out.println(num_hab);
//                            System.out.println(datos[1]);
//                            System.out.println(datos[2]);
                        }
                    }
                    br.close();
                }
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer la expresion");
            }
        }
        
        
        /**
        * Metodo que lee el sheet de Estados y maneja los datos. Se anaden dichos datos a las estructuras en la que corresponden
        * Chequea los espacios en blanco y les asigna el numero de habitacion de la persona que tienen arriba
        *@IOException ex
        *@HeadlessException
        * 
        */
        //pasar como parametro Hastable
        public void Leer_Estado() {
            String line;
            String expresion_txt = "";
            String path = "test\\estado.csv";
            File file = new File(path);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            expresion_txt += line + "\n";
                        }
                    }
                    if (!"".equals(expresion_txt)) {
                        String[] expresion_split = expresion_txt.split("\n");
                        int ultima_hab = 0;
                        for (int i = 0; i < expresion_split.length - 1; i++) {
                            String[] datos = expresion_split[i].split(",");

                            if (!datos[0].equalsIgnoreCase("")) {
                                int num_hab = Integer.parseInt(datos[0]);

                                String nombre_est = datos[1];
                                String apellido_est = datos[2];
                                String email_est = datos[3];
                                String sexo_est = datos[4];
                                String telf_est = datos[5];
                                String fecha_llegada = datos[6];
                                ultima_hab = num_hab;
                                
                                System.out.println(nombre_est);
//                                System.out.println(apellido_est);
//                                System.out.println(email_est);
//                                System.out.println(sexo_est);
//                                System.out.println(telf_est);
//                                System.out.println(fecha_llegada);
                                System.out.println(num_hab);
//                                
                                //HotelCard card = new HotelCard(num_hab_hist, fecha_llegada_hist, null, 1);
                                //Client cliente = new Cliente(cedula_est, nombre_est, apellido_est, email_est, sexo_est, 0, card);

                                //table.Agregar(cliente);
                                
                            } else {
                                if (i != 0) {

                                    String nombre_est = datos[1];
                                    String apellido_est = datos[2];
                                    String email_est = datos[3];
                                    String sexo_est = datos[4];
                                    String telf_est = datos[5];

                                    int hab = ultima_hab;
                                    //HotelCard card = new HotelCard(hab, fecha_llegada_hist, null, 1);
                                    //Client cliente = new Cliente(cedula_est, nombre_est, apellido_est, email_est, sexo_est, 0, card);

                                    //table.Agregar(cliente);S
//                                  

                                    System.out.println(nombre_est);
                                    System.out.println(hab);
//                                    System.out.println(apellido_est);
//                                    System.out.println(email_est);
//                                    System.out.println(sexo_est);
//                                    System.out.println(telf_est);
//                                    
                                    
                                    
                                }

                            }
                        }

                    }
                    br.close();
                }
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer la expresion");
            }
        }
        
        /**
        * Metodo que lee el sheet de Historial y maneja los datos. Se anaden dichos datos a las estructuras en la que corresponden
        * 
        *@IOException ex
        *@HeadlessException
        * 
        */
        // parametro ListaDoble lista_historial
        public void Leer_Historial(ListaDoble lista_historial) {
            String line;
            String expresion_txt = "";
            String path = "test\\Historico.csv";
            File file = new File(path);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                } else {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    while ((line = br.readLine()) != null) {
                        if (!line.isEmpty()) {
                            expresion_txt += line + "\n";
                        }
                    }
                    if (!"".equals(expresion_txt)) {
                        String[] expresion_split = expresion_txt.split("\n");
                        for (int i = 0; i < expresion_split.length; i++) {
                            String[] datos = expresion_split[i].split(",");
                            int cedula_hist = Integer.parseInt(datos[0].replaceAll("\\.", ""));
                            String nombre_hist = datos[1];
                            String apellido_hist = datos[2];
                            String email_hist = datos[3];
                            String sexo_hist = datos[4];
                            String fecha_llegada_hist = datos[5];
                            int num_hab_hist = Integer.parseInt(datos[6]);
                        
//                            System.out.println(cedula_hist);
//                            System.out.println(nombre_hist);
//                            System.out.println(apellido_hist);
//                            System.out.println(email_hist);
//                            System.out.println(sexo_hist);
//                            System.out.println(fecha_llegada_hist);
//                            System.out.println(num_hab_hist);
//                            
                        //HotelCard card = new HotelCard(num_hab_hist, fecha_llegada_hist, null, 0);
                        //Client cliente = new Cliente(cedula_hist, nombre_hist, apellido_hist, email_hist, sexo_hist, 0, card);
                        // lista_historial.insertarAlFinal(cliente);
                        }

                    }
                }
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer la expresion");
            }
        }
}
