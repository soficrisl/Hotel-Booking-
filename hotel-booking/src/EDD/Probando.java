/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;


/**
 *
 * @author Sofia
 */
public class Probando {
    
    public static void main(String[] args){
        /*
        Hastable table = new Hastable(); 
        
        table.insert("Sofia", "Sofia"); 
        table.insert("Camila", "Camila");  
        table.insert("Ale", "Juan"); 
        table.insert("Pedro", "Ed"); 
        table.insert("Carlos", "Carlos"); 
        table.insert("Ana", "Ana");
        table.insert("Estefania", "Estefania");
        table.insert("Mama", "Mama"); 
        table.insert("Nana", "NAna");
        table.insert("Abuela", "Abuela");
        table.insert("Nonna", "Nonna"); 
        table.insert("Cama", "Cama");
        table.insert("Mia", "Mia");
        table.insert("Nathalie", "Nathalie"); 
        table.insert("Amanda", "Amanda");
        table.insert("Bilal", "Bilal");
        table.insert("Waleska", "Waleska");
        table.insert("Vicky", "Vicky"); 
        table.insert("Ivana", "Ivana");
        table.insert("Cristina", "Cristina");
        table.insert("perro", "perro");
;
        table.print();
        table.delete("Pedro", "Ed"); 
        System.out.println("\n");
        table.print(); 
        System.out.println("\n");
        table.search("perro").print();
        
        
    }
*/
        
    SBT tree = new SBT();
    
    tree.insert(50, null, 50);
    tree.insert(40, tree.getRoot(), 40);
    tree.insert(45, tree.getRoot(), 45);
    tree.insert(10, tree.getRoot(), 10);
    tree.insert(30, tree.getRoot(), 30);
    tree.insert(55, tree.getRoot(), 55);
    tree.insert(75, tree.getRoot(), 75);
    tree.insert(54, tree.getRoot(), 54);
    tree.insert(51, tree.getRoot(), 51);
    tree.insert(68, tree.getRoot(), 68);
    tree.insert(88, tree.getRoot(), 88);
    tree.insert(12, tree.getRoot(), 12);
    tree.insert(35, tree.getRoot(), 35);
    System.out.println("In Order");
    tree.inOrder(tree.getRoot());
    System.out.println("Pre Order");
    tree.preOrder(tree.getRoot());
    System.out.println("Post Order");
    tree.postOrder(tree.getRoot()); 
    tree.deleteNodo(40, tree.getRoot(), null);
    System.out.println("In Order");
    tree.inOrder(tree.getRoot());
    System.out.println("Pre Order");
    tree.preOrder(tree.getRoot());
    System.out.println("Post Order");
    tree.postOrder(tree.getRoot()); 
    }
    
}
