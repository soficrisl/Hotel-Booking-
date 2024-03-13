/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

import EDD.ListaDoble;

/**
 *
 * @author cristiandresgp
 */
public class Client {
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String numero;
    private ListaDoble card;

    public Client(String nombre, String apellido, String email, String genero, String numero, ListaDoble card) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.numero = numero;
        this.card = new ListaDoble();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ListaDoble getCard() {
        return card;
    }

    public void setCard(ListaDoble card) {
        this.card = card;
    }
    
    
}
