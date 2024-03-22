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
    
    tree.insert(13, 13);
    tree.insert(84, 84);
    tree.insert(89, 89);
    tree.insert(43, 43);
    tree.insert(8, 8);
    tree.insert(53,53); 
    tree.insert(59,59); 
    tree.insert(16,16); 
    tree.insert(15,15); 
    tree.insert(7,7); 
    tree.insert(9,9); 
    tree.insert(72,72); 
    System.out.println("Post Order");
    tree.postOrder(tree.getRoot()); 
    
        
    /*
    System.out.println("In Order");
    tree.inOrder(tree.getRoot());
    System.out.println("Pre Order");
    tree.preOrder(tree.getRoot());
    System.out.println("Post Order");
    tree.postOrder(tree.getRoot()); 
    System.out.println("\n\n");
    /*
    System.out.println("In Order");
    tree.inOrder(tree.getRoot());
    System.out.println("Pre Order");
    tree.preOrder(tree.getRoot());
    System.out.println("Post Order");
    tree.postOrder(tree.getRoot()); 
    tree.insert(40, 40);
    tree.insert(60, 60);
    tree.insert(45, 45);
    tree.insert(10, 10);
    tree.insert(62, 62);
    tree.insert(62, 62);
    tree.delete(50);
*/
    }
    
}
