/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Sofia
 */
public class Hashtable {
    private ListaDoble[] hastable; 
    
    public Hashtable() {
        this.hastable = new ListaDoble[1259];
        for (int i = 0; i < this.hastable.length; i++) {
            this.hastable[i] = new ListaDoble(); 
        }
 
    }
    public ListaDoble[] getHastable() {
        return hastable;
    }

    public void setHastable(ListaDoble[] hastable) {
        this.hastable = hastable;
    }
    public int getHashSize(){
        return this.hastable.length;
    }
    
    //Aplication of djb2 algotirthm for hash function 
    public int hashFunction (String str){
        long hash = 5381;
        int c; 
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i); 
            //Multiplying by 33 done by left bitshifting, to increase speed and add to hash ascii value of current char
            hash = ((hash << 5) + hash) + c ;
        }
        //Convert hash into index of array
        int index = (int) (hash % getHashSize());  
        return (index <0) ? index * -1: index; 
        
    }
    
    public void insert(String str, Object element) {
        int index = hashFunction(str);
        this.hastable[index].insertBegin(element);
    }
    
    public Object delete(String str, Object element){
        int index1 = hashFunction(str);
        if (this.hastable[index1].getHead() != null){
            int index2 = this.hastable[index1].searchIndex(element);
            Object deleted = this.hastable[index1]; 
            this.hastable[index1].deleteInIndex(index2); 
            return deleted; 
        }
        return null;  
    }
    
    public ListaDoble search(String str) {
        int index1 = hashFunction(str);
        return this.hastable[index1]; 
    }
    
    public void print (){
        for (int i = 0; i < this.hastable.length; i++) {
            System.out.println("["+ i + "]"+ this.hastable[i].printString());
        }
    }
   
}
