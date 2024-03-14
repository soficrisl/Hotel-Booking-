/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Sofia
 */


public class NodoTree {
    private Object element; 
    private float key; 
    private NodoTree rightson, leftson; 

    public NodoTree(Object element, float key) {
        this.element = element;
        this.key = key;
        this.rightson = this.leftson = null;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public float getKey() {
        return key;
    }

    public void setKey(float key) {
        this.key = key;
    }

    public NodoTree getRightSon() {
        return rightson;
    }

    public void setRightSon(NodoTree rightSon) {
        this.rightson = rightSon;
    }

    public NodoTree getLeftson() {
        return leftson;
    }

    public void setLeftson(NodoTree leftson) {
        this.leftson = leftson;
    }
    
    public boolean isLeaf(){        
        return this.leftson == null && this.rightson == null; 
    }
    
    public boolean onlyLeftSon(){
        return this.rightson == null; 
    }
    
     public boolean onlyRightSon(){
        return this.leftson == null; 
    }
    
    
}
