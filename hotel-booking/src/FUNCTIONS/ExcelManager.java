package FUNCTIONS;

import EDD.Hashtable;
import EDD.ListaDoble;
import EDD.NodoDoble;
import EDD.SBT;
import OBJECTS.Client;
import OBJECTS.Reservation;
import OBJECTS.Room;
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
    
    public SBT Leer_reservas() {
        SBT tree1 = new SBT(); 
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
                        String nombre_res = datos[1].toLowerCase();
                        String apellido_res = datos[2].toLowerCase();
                        String email_res = datos[3];
                        String sexo_res = datos[4];
                        String telf_res = datos[6];
                        String tipo_hab_res = datos[5];
                        String fecha_llegada_res = datos[7];
                        String fecha_salida_res = datos[8];
 //    public Client(int id, String f_name, String l_name, String email, String gender, int roomNum, String cellphone, String arrival, String departure) {           
                        Client client = new Client (cedula_res, nombre_res, apellido_res, email_res, sexo_res,-1,telf_res, fecha_llegada_res, fecha_salida_res, datos[1] + " "+ datos[2]); 
                        Reservation reserve = new Reservation(cedula_res, client, tipo_hab_res); 
                        tree1.insert(reserve, cedula_res);

                    }
                }
                br.close();
                return tree1; 
            }
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer la expresion");
            }
          return tree1; 
        }
        
        /**
        * Metodo que lee el sheet de Habitaciones y maneja los datos. Se anaden dichos datos a las estructuras en la que corresponden
        * 
        *@IOException ex
        *@HeadlessException
        * 
        */
    // meter como parametro = SBT lista_habitacion, ListaDoble historial
        public SBT Leer_habitaciones(ListaDoble info) {
            SBT tree2 = new SBT(); 
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
                            ListaDoble historial = new ListaDoble(); 
                            String[] datos = expresion_split[i].split(",");
                            int num_hab = Integer.parseInt(datos[0]);
                            String tipo_hab = datos[1];
                            int piso_hab = Integer.parseInt(datos[2]);               
                            NodoDoble pointer = info.getHead(); 
                            while (pointer != null){
                                Client client = (Client)pointer.getElement(); 
                                if (client.getRoomNum() == num_hab){
                                    historial.insertBegin(client);
                                }
                                pointer = pointer.getNext(); 
                            }
                            Room room = new Room(num_hab,piso_hab, historial, tipo_hab);
                            tree2.insert(room, num_hab);
                            //insertaralarbol();
//                            System.out.println(num_hab);
//                            System.out.println(datos[1]);
//                            System.out.println(datos[2]);
                        }
                    }
                    br.close();
                    return tree2; 
                    
                }
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer la expresion");
            }
           return tree2; 
        }
        
        
        /**
        * Metodo que lee el sheet de Estados y maneja los datos. Se anaden dichos datos a las estructuras en la que corresponden
        * Chequea los espacios en blanco y les asigna el numero de habitacion de la persona que tienen arriba
        *@IOException ex
        *@HeadlessException
        * 
        */
        //pasar como parametro Hastable
        public Hashtable Leer_Estado() {
            Hashtable table = new Hashtable(); 
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
                                String nombre_est = datos[1].toLowerCase();
                                String apellido_est = datos[2].toLowerCase();
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
                                
                                ultima_hab = num_hab;                              
                                Client client = new Client (-1, nombre_est, apellido_est, email_est, sexo_est, num_hab, telf_est, fecha_llegada, "",datos[1] + " "+ datos[2] ); 
                                String key = nombre_est + " " + apellido_est; 
                                table.insert(key, client);
                                //System.out.println(ultima_hab);
                            } else {
                                if (i != 0) {
                                    String nombre_est = datos[1].toLowerCase();
                                    String apellido_est = datos[2].toLowerCase();
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

                                    String fecha_llegada = datos[6];
                                    int hab = ultima_hab;                               
                                    Client client = new Client (-1, nombre_est, apellido_est, email_est, sexo_est,hab, telf_est, fecha_llegada, "", datos[1] + " "+ datos[2]); 
                                    String key = nombre_est +" "+ apellido_est; 
                                    //System.out.println(key);
                                    table.insert(key, client);
                                    //System.out.println(hab);
                                   
                                }

                            }
                        }

                    }
                    br.close();
                    return table; 
                }
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer la expresion");
            }
            return table; 
        }
        
        /**
        * Metodo que lee el sheet de Historial y maneja los datos. Se anaden dichos datos a las estructuras en la que corresponden
        * 
        *@IOException ex
        *@HeadlessException
        * 
        */
        public ListaDoble Leer_Historial() {
            ListaDoble lista_historial =  new ListaDoble();
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
                            String nombre_hist = datos[1].toLowerCase();
                            String apellido_hist = datos[2].toLowerCase();
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
//    public Client(int id, String f_name, String l_name, String email, String gender, int roomNum, String cellphone, String arrival, String departure) {                           
                        Client cliente = new Client(cedula_hist, nombre_hist, apellido_hist, email_hist, sexo_hist, num_hab_hist, "No data", fecha_llegada_hist, "No data", datos[1] + " "+ datos[2]);
                        lista_historial.insertFinal(cliente);
                        }

                    }
                    br.close();
                    return lista_historial; 
                }
            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer la expresion");
            }
            
            return lista_historial; 
        }

        public SBT uptadeRooms(SBT roomTree, Hashtable table){
            ListaDoble[] hashtable = table.getHastable(); 
            for (ListaDoble clients: hashtable) {
                NodoDoble pointer = clients.getHead(); 
                while (pointer != null){
                    int num_hab = ((Client) pointer.getElement()).getRoomNum();
                    try {
                       Room room = (Room)roomTree.search(num_hab, roomTree.getRoot());
                       room.setOcupied(true);
                       roomTree.setNodoElement(num_hab, room); 
                    } catch (Exception E) {
                        }
                    pointer = pointer.getNext(); 
                }
            }
            return roomTree; 
        }
}
