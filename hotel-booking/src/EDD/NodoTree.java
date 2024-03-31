/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *Clase que define el Nodo para un arbol binario 
 * @author Sofia
 */


public class NodoTree {
    //Atributos de la clase
    private Object element; 
    private int height; 
    private int key; 
    private NodoTree rightson, leftson; 
    //Constructor
    public NodoTree(Object element, int key) {
        this.element = element;
        this.height = 1; 
        this.key = key;
        this.rightson = this.leftson = null;
    }//Final del constructor
    
    /**
     * Serie de getters y setters de los atributos 
     */
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public NodoTree getRightSon() {
        return rightson;
    }

    public void setRightSon(NodoTree rightSon) {
        this.rightson = rightSon;
    }
    
    public NodoTree getLeftSon() {
        return leftson;
    }
    
    public void setLeftSon(NodoTree leftson) {
        this.leftson = leftson;
    }
    /**
     * Boolean method to know if a node is a leaf in the tree. 
     * @return true if leaf. 
     */
    public boolean isLeaf(){        
        return this.leftson == null && this.rightson == null; 
    }
    /**
     * Boolean methods to know if a node only has one son
     * @return true if only have left son
     */
    public boolean onlyLeftSon(){
        return this.rightson == null; 
    }
    /**
     * Boolean methods to know if a node only has one son
     * @return true if only have right son
     */
    
    public boolean onlyRightSon(){
        return this.leftson == null; 
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
     
}
