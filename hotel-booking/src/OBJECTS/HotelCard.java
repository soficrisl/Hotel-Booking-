/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

/**
 *
 * @author cristiandresgp
 */
public class HotelCard {
    private int numHabitacion;
    private Boolean entrada;
    private Boolean salida;
    private int estado;

    public HotelCard(int numHabitacion, int estado) {
        this.numHabitacion = numHabitacion;
        this.entrada = false;
        this.salida = false;
        this.estado = estado;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public Boolean getEntrada() {
        return entrada;
    }

    public void setEntrada(Boolean entrada) {
        this.entrada = entrada;
    }

    public Boolean getSalida() {
        return salida;
    }

    public void setSalida(Boolean salida) {
        this.salida = salida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
}
