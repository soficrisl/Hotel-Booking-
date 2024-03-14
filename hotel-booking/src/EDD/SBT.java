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
    
    public void insert(Object element, NodoTree root, float key) {
        NodoTree nodo = new NodoTree(element, key); 
        if (root == null) {
            setRoot(nodo);
        }else {
            if (key > root.getKey()) {
                if (root.getRightSon() == null) {
                    root.setRightSon(nodo);
                }else {
                    insert (element, root.getRightSon(), key); 
                }
            } else if (key < root.getKey()) {
                if (root.getLeftson() == null) {
                    root.setLeftson(nodo);
                }else {
                    insert (element, root.getLeftson(), key); 
                }
            } else System.out.println("No se pueden agregar dos elementos con el mismo Key");
        }
    }
    
    public void preOrder(NodoTree root){
        if (root!= null){
            System.out.println(root.getElement());
            preOrder(root.getLeftson()); 
            preOrder(root.getRightSon());
        }
    }
    
    public void postOrder(NodoTree root){
        if (root!= null){
            postOrder(root.getLeftson()); 
            postOrder(root.getRightSon());
            System.out.println(root.getElement());
        }
    }
    
    public void inOrder(NodoTree root) {
        if (root!= null){
            inOrder(root.getLeftson()); 
            System.out.println(root.getElement());
            inOrder(root.getRightSon());
            
        }
    }
    
    
    
    
    public void deleteNodo(int key, NodoTree pointer, NodoTree pointerPrevious) {
        if (isEmpty()){
            System.out.println("Arbol vacio");
        } else {
            if (key < pointer.getKey()) {
                deleteNodo(key, pointer.getLeftson(), pointer); 
            } else if (key > pointer.getKey()) {
                deleteNodo(key, pointer.getRightSon(), pointer); 
            } else {
                if (pointer.isLeaf()) {
                    if (pointerPrevious == null) {
                        setRoot(null);
                    }else if (key < pointerPrevious.getKey()) {
                        pointerPrevious.setLeftson(null);
                    } else {
                        pointerPrevious.setRightSon(null);
                    }
                } else if (pointer.onlyRightSon()) {
                    if (pointerPrevious == null) {
                        setRoot(pointer.getRightSon());
                    }else if (key < pointerPrevious.getKey()) {
                        pointerPrevious.setLeftson(pointer.getRightSon());
                    } else {
                        pointerPrevious.setRightSon(pointer.getRightSon());
                    }
                } else if (pointer.onlyLeftSon()) {
                    if (pointerPrevious == null) {
                        setRoot(pointer.getLeftson());
                    }else if (key < pointerPrevious.getKey()) {
                        pointerPrevious.setLeftson(pointer.getLeftson());
                    } else {
                        pointerPrevious.setRightSon(pointer.getLeftson());
                    }
                } else {
                    NodoTree replacement = biggestOfSmallest(pointer); 
                    if (pointerPrevious == null) {
                        setRoot(replacement); 
                    }else if (key < pointerPrevious.getKey()) {
                        pointerPrevious.setLeftson(replacement); 
                        
                    } else {
                        pointerPrevious.setRightSon(replacement);
                    }
                    replacement.setLeftson(pointer.getLeftson());
                    replacement.setRightSon(pointer.getRightSon());
                }
                
            }
        }
    }
    
    
    
    public NodoTree biggestOfSmallest(NodoTree nodo) {
        NodoTree pointerPrevious = nodo;  
        NodoTree pointer = nodo.getLeftson();    
        if (!pointer.onlyLeftSon()){
            while (pointer.getRightSon() != null) {
                pointerPrevious = pointer; 
                pointer = pointer.getRightSon(); 
            }
        }
        pointerPrevious.setRightSon(null);
        if (pointer.onlyLeftSon()) {
            pointerPrevious.setRightSon(pointer.getLeftson());
            pointer.setLeftson(null);
        }
        return pointer; 
    }

}

