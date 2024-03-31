/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *Class that defines a Binary Search Tree with AVL balancing
 * @author Sofia
 */
public class SBT {
    //Atributos
    private NodoTree root; 
    //Constructor
    public SBT() {
        this.root = root;
    } //Fin del constructor
    
    //Serie de getters y setters de los atributos
    public NodoTree getRoot() {
        return root;
    }

    public void setRoot(NodoTree root) {
        this.root = root;
    }
    
    /**
     * Method that returns if the tree is empty
     * @return true if empty
     */
    public boolean isEmpty(){ 
        return root == null;  
        
    }
    /**
     * Method to get the minimun element of the tree by its key
     * @param nodo
     * @return nodo 
     */  
    public NodoTree getMin(NodoTree nodo){
        if (isEmpty()){
            return null; 
        } 
        while(nodo.getLeftSon() != null){
            nodo = nodo.getLeftSon(); 
        }
        return nodo; 
    }
    /**
     * Method to get the maximum element of the tree by its key
     * @param nodo
     * @return nodo 
     */
     public NodoTree getMax(NodoTree nodo){
        if (isEmpty()){
            return null; 
        } 
        while(nodo.getRightSon()!= null){
            nodo = nodo.getRightSon(); 
        }
        return nodo; 
    }
     
    /**
     * Method to get the maximum element of the tree by its key, and delete it 
     * @param nodo
     * @return nodo deleted
     */  
    public NodoTree getMaxandDelete(NodoTree nodo){
        if (isEmpty()){
            return null; 
        } 
        if (nodo.getRightSon() != null) {
            while(nodo.getRightSon().getRightSon()!= null){
                nodo = nodo.getRightSon();
                }
            NodoTree temp = nodo.getRightSon(); 
            nodo.setRightSon(null);
            return temp;
        } else {
            return nodo; 
        }
    }
    
    /**
     * Inicial method to insert an element to the tree, it calls the recursive method to make things more organized for user
     * @param element
     * @param key 
     */ 
    public void insert(Object element, int key){
        NodoTree nodo = new NodoTree(element, key);
        setRoot(insert(nodo, getRoot())); 
    }
    
    /**
     * Recursive method to insert an element to the tree, and balance it 
     * @param newnodo
     * @param root
     * @return root of the tree
     */
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
    
    /**
     * Inicial method to delete an element to the tree, it calls the recursive method to make things more organized for user
     * @param element
     * @param key 
     */
    public void delete(int key) {
        setRoot(delete(key, getRoot()));
    }
    
    /**
     * Recursive method to delete an element to the tree, and balance it 
     * @param newnodo
     * @param root
     * @return root of the tree
     */
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
    
    /**
     * Method to get the height of a node, with validations.
     * @param nodo
     * @return int, height of the node in the tree
     */
    public int height(NodoTree nodo){
        return nodo!= null ? nodo.getHeight() :0; 
    }
    
    /**
     * Method to uptade the height of a node
     * @param nodo 
     */
    public void uptadeHeight (NodoTree nodo){
        int maxHeight = Math.max(height(nodo.getLeftSon()), height(nodo.getRightSon()));
        nodo.setHeight(maxHeight + 1);
    }
    
    /**
     * Inicial method of rotation, with all possible cases
     * @param nodo
     * @return root of the tree
     */
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
    
    /**
     * Method to calculate the balance factor of a node
     * @param nodo
     * @return int, balance factor
     */
    public int balanceFactor (NodoTree nodo){
        return nodo != null ? height(nodo.getLeftSon()) - height(nodo.getRightSon()) : 0; 
        
    }
  
    /**
     * Method to rotate a node right
     * @param nodo
     * @return root node after rotation; 
     */
    public NodoTree rotateRight(NodoTree nodo){
        NodoTree left = nodo.getLeftSon(); 
        NodoTree leftright = left.getRightSon();
        left.setRightSon(nodo);
        nodo.setLeftSon(leftright);
        uptadeHeight(nodo); 
        uptadeHeight (left); 
        return left; 
    }
    
    /**
     * Method to rotate a node left
     * @param nodo
     * @return root node after rotation; 
     */ 
    public NodoTree rotateLeft (NodoTree nodo){
        NodoTree right = nodo.getRightSon(); 
        NodoTree rightleft = right.getLeftSon();
        right.setLeftSon(nodo);
        nodo.setRightSon(rightleft);
        uptadeHeight(nodo); 
        uptadeHeight (right); 
        return right; 
    }
    
    /**
     * Binary Search of an object in the tree, by its key
     * @param key
     * @param root
     * @return object that is being looked for
     */
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
    
 /**
  * Trasversal, recursive methos to print the tree in preorder, postorder and inorder
  * @param root 
  */   
    
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
    
 /**
  * Method to set the node of a tree with a new element
  * @param key
  * @param element
  * @return object modified
  */   
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

