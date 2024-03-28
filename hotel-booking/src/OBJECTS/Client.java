/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBJECTS;

/**
 *
 * @author cristiandresgp
 */
public class Client {
    int id; 
    String f_name; 
    String l_name; 
    String email; 
    String gender; 
    int roomNum; 
    String cellphone; 
    String arrival; 
    String departure; 
    String full_name; 

    public Client(int id, String f_name, String l_name, String email, String gender, int roomNum, String cellphone, String arrival, String departure, String name) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.gender = gender;
        this.roomNum = roomNum;
        this.cellphone = cellphone;
        this.arrival = arrival;
        this.departure = departure;
        this.full_name = name; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
    
    public String data (){
        return id + " - " + f_name +  " - " + l_name +  " - " + email +  " - " + gender + " - " + roomNum + " - " + cellphone +  " - " + arrival +  " - " + departure; 
    }
    
    public String show(){
        return "ID: " + id + ". Nombre: y apellido: " + f_name +  " " + l_name +  ". Correo: " + email +  ". Género: " + gender + ". Nro de habitación: " + roomNum + ". Telf.: " + cellphone +  ". Llegada: " + arrival +  ". Salida: " + departure; 
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    
    
    
}

