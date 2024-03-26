/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FUNCTIONS;

import javax.swing.JOptionPane;

/**
 *
 * @author cristiandresgp
 */
public class Messages {
    public static void information(String message){
        JOptionPane.showMessageDialog(null, message, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void error(String message){
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void warning(String message){
        JOptionPane.showMessageDialog(null, message, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
    } 
}

