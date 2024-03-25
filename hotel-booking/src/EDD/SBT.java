/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Sofia
 */
public class SBT {
    private NodoTree root; 

    public SBT() {
        this.root = root;
    }

    public NodoTree getRoot() {
        return root;
    }

    public void setRoot(NodoTree root) {
        this.root = root;
    }
    
    public boolean isEmpty(){ 
        return root == null;  
        
    }
    
    public NodoTree getMin(NodoTree nodo){
        if (isEmpty()){
            return null; 
        } 
        while(nodo.getLeftSon() != null){
            nodo = nodo.getLeftSon(); 
        }
        return nodo; 
    }
    
     public NodoTree getMax(NodoTree nodo){
        if (isEmpty()){
            return null; 
        } 
        while(nodo.getRightSon()!= null){
            nodo = nodo.getRightSon(); 
        }
        return nodo; 
    }
     
    public NodoTree getMaxandDelete(NodoTree nodo){
        if (isEmpty()){
            return null; 
        } 
        while(nodo.getRightSon().getRightSon()!= null){
            nodo = nodo.getRightSon(); 
        }
        NodoTree temp = nodo.getRightSon(); 
        nodo.setRightSon(null);
        return temp; 
    }
    
    public void insert(Object element, int key){
        NodoTree nodo = new NodoTree(element, key);
        setRoot(insert(nodo, getRoot())); 
    }
    
    public NodoTree insert(NodoTree newnodo, NodoTree root) {
        if (root == null){
            return newnodo; 
        } else if (newnodo.getKey() > root.getKey()){
            root.setRightSon(insert(newnodo, root.getRightSon()));
        } else if (newnodo.getKey() < root.getKey()) {
            root.setLeftSon(insert(newnodo, root.getLeftSon()));
        }else {
            return newnodo; 
        }
        uptadeHeight(root); 
        return rotation(root); 
    }
    
    public void delete(int key) {
        setRoot(delete(key, getRoot()));
    }
    
    public NodoTree delete(int key, NodoTree nodo){
        if (nodo == null) {
            return null; 
        }else if (key > nodo.getKey()){
            nodo.setRightSon(delete (key, nodo.getRightSon())); 
        }else if (key < nodo.getKey()) {
            nodo.setLeftSon(delete (key, nodo.getLeftSon())); 
        } else {
            //Case 1, node is a leaf o has only one child 
            if (nodo.getLeftSon() == null) {
                return nodo.getRightSon(); 
            } else if (nodo.getRightSon() == null) {
                return nodo.getLeftSon(); 
            }
            //Case 2:node has two children 
            NodoTree replacement = getMaxandDelete(nodo.getLeftSon());
            replacement.setRightSon(nodo.getRightSon());
            replacement.setLeftSon(nodo.getLeftSon());
            if (getRoot().getKey() == key){
                setRoot(replacement); 
            }
            nodo = replacement; 
        }
        
        uptadeHeight(nodo); 
        return rotation(nodo); 
    }
    
    public int height(NodoTree nodo){
        return nodo!= null ? nodo.getHeight() :0; 
    }
    
    public void uptadeHeight (NodoTree nodo){
        int maxHeight = Math.max(height(nodo.getLeftSon()), height(nodo.getRightSon()));
        nodo.setHeight(maxHeight + 1);
    }
    
    public NodoTree rotation (NodoTree nodo) {
        int bf = balanceFactor(nodo); 
        //Case 1: left heavy
        if (bf > 1){
            if (balanceFactor(nodo.getLeftSon()) < 0){
                nodo.setLeftSon(rotateLeft(nodo.getLeftSon()));
            }
            return rotateRight(nodo); 
            
        }// Case 2: right heavy
        else if (bf < -1) {
            if (balanceFactor(nodo.getRightSon()) > 0){
                nodo.setRightSon(rotateRight(nodo.getRightSon()));
            }
            return rotateLeft(nodo); 
        }
        return nodo; 
    }
    
    public int balanceFactor (NodoTree nodo){
        return nodo != null ? height(nodo.getLeftSon()) - height(nodo.getRightSon()) : 0; 
        
    }
    
    public NodoTree rotateRight(NodoTree nodo){
        NodoTree left = nodo.getLeftSon(); 
        NodoTree leftright = left.getRightSon();
        left.setRightSon(nodo);
        nodo.setLeftSon(leftright);
        uptadeHeight(nodo); 
        uptadeHeight (left); 
        return left; 
    }
    
    public NodoTree rotateLeft (NodoTree nodo){
        NodoTree right = nodo.getRightSon(); 
        NodoTree rightleft = right.getLeftSon();
        right.setLeftSon(nodo);
        nodo.setRightSon(rightleft);
        uptadeHeight(nodo); 
        uptadeHeight (right); 
        return right; 
    }
        
    public Object search (int key, NodoTree root){
        if (root == null) {
            return null; 
        }
        if (key > root.getKey()){
            return search(key, root.getRightSon()); 
        }else if (key < root.getKey()) {
            return search(key, root.getLeftSon()); 
        }else {
            return root.getElement(); 
        }
    }
    
    
    
    public void preOrder(NodoTree root){
        if (root!= null){
            System.out.println(root.getElement());
            preOrder(root.getLeftSon()); 
            preOrder(root.getRightSon());
        }
    }
    
    public void postOrder(NodoTree root){
        if (root!= null){
            postOrder(root.getLeftSon()); 
            postOrder(root.getRightSon());
            System.out.println(root.getElement());
        }
    }
    
    public void inOrder(NodoTree root) {
        if (root!= null){
            inOrder(root.getLeftSon()); 
            System.out.println(root.getKey() + " - " + root.getElement());
            inOrder(root.getRightSon());
            
        }
    }
    
    
    public Object setNodoElement (int key, Object element){
        if (root == null) {
            return null; 
        }
        if (key > root.getKey()){
            return search(key, root.getRightSon()); 
        }else if (key < root.getKey()) {
            return search(key, root.getLeftSon()); 
        }else {
            root.setElement(element);
            return element;
        } 
    }
    
    
    

}

