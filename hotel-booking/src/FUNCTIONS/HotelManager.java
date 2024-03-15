/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FUNCTIONS;

import EDD.Hastable;
import EDD.ListaDoble;
import EDD.NodoDoble;
import EDD.NodoTree;
import OBJECTS.Client;
import OBJECTS.Reservation;
import OBJECTS.Room;

/**
 *
 * @author cristiandresgp
 */
public class HotelManager {
    

    public Object buscarcliente(String nombre, String apellido, Hastable hashtable) {
        // Calcula el índice utilizando la cadena proporcionada
        int index = hashtable.hashFunction(nombre);

        // Obtiene la lista doble correspondiente al índice calculado
        EDD.ListaDoble lista = hashtable.getHastable()[index];
        EDD.NodoDoble current = lista.getHead();

        // Recorre la lista para buscar el valor de la clave
        while (current != null) {
            Client currentClient = (Client) current.getElement();
            // Verifica si el elemento actual coincide con la clave proporcionada y con el apellido del cliente
            if (currentClient.getNombre().toLowerCase() == nombre.toLowerCase() && currentClient.getApellido().toLowerCase() == apellido.toLowerCase()) {
                // Si se encuentra la clave y el apellido coincide, devuelve el elemento asociado
                return current.getElement();
            }
            current = current.getNext();
        }

        // Si no se encuentra ningún elemento con la clave dada (o que el apellido no coincida), devuelve null
        Messages.error("No existe ningún cliente con estas carácteristicas");
        return null;
    }
    
    
    public Reservation buscarReservacion(int cedula, NodoTree root){

    
        // Comienza desde la raíz
        NodoTree current = root;

        // Realiza un bucle mientras no llegues al final del árbol
        while (current != null) {
            // Si la clave coincide con la clave del nodo actual, devuelve el nodo
            if (current.getKey() == cedula) {
                return (Reservation) current.getElement();
            }
            // Si la clave es menor que la clave del nodo actual, ve al hijo izquierdo
            else if (cedula < current.getKey()) {
                current = current.getLeftson();
            }
            // Si la clave es mayor que la clave del nodo actual, ve al hijo derecho
            else {
                current = current.getRightSon();
            }
        }

        // Si no se encuentra el nodo con la clave dada, devuelve null
        Messages.error("Esta cédula no está registrada");
        return null;
}
    
    
    public ListaDoble historialHabitacion(int num, NodoTree root){
        
        // Comienza desde la raíz
        NodoTree current = root;

        // Realiza un bucle mientras no llegues al final del árbol
        while (current != null) {
            // Si la clave coincide con la clave del nodo actual, devuelve el nodo
            if (current.getKey() == num) {
                Room room = (Room) current.getElement();
                ListaDoble historial = room.getHistorial();
                return historial;
            }
            // Si la clave es menor que la clave del nodo actual, ve al hijo izquierdo
            else if (num < current.getKey()) {
                current = current.getLeftson();
            }
            // Si la clave es mayor que la clave del nodo actual, ve al hijo derecho
            else {
                current = current.getRightSon();
            }
        }

        // Si no se encuentra el nodo con la clave dada, devuelve null
        Messages.error("Este número de habitación no es válido");
        return null;
        
    
    }
    
    public void checkIn(){
    
    }
    
    public void checkOut(){
    
    }
}
