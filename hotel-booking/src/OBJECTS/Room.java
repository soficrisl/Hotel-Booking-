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
public class Room {
    private ListaDoble historial;
    private boolean ocupado;
    private int numero;
    private String tipo;
    private int piso;

    public Room(int numero, String tipo, int piso) {
        this.historial = new ListaDoble();
        this.ocupado = false;
        this.numero = numero;
        this.tipo = tipo;
        this.piso = piso;
    }

    public ListaDoble getHistorial() {
        return historial;
    }

    public void setHistorial(ListaDoble historial) {
        this.historial = historial;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    
    
}
