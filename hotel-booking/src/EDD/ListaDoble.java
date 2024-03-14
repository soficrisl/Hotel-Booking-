
package EDD;
/**
 * @author Sofia
 * Esta clase define a una listadoblemente enlazada
 */


public class ListaDoble implements ILista{
    //Atributos de la clase
    private int size; 
    private NodoDoble head, tail;
    /**
     * Constructo para la clase ListaDoble
     */
    public ListaDoble() {
        this.size = 0;
        this.head = this.tail = null;
    }
    //cierre del constructor
    
    /**
     * Metodo para retornar el tamaño de la lista en un int 
     * @return int size
     */
   
    public int getSize() {
        return size;
    }
    
    /**
     * Metodo para retornar el el primer nodo de la lista
     * @return  head
     */
    public NodoDoble getHead() {
        return head;
    }
    
    /**
     * Metodo para setear la cabeza de lista a un nuevo nododoble
     * @param head 
     */

    public void setHead(NodoDoble head) {
        this.head = head;
    }
    
    /**
     * Mtodo para obtener el ultimo nodo de la lista 
     * @return el ultimo Nododoble de la lista 
     */
    public NodoDoble getTail() {
        return tail;
    }
    
    /**
     * Metodo para setear la cola de la lista a un nuevo NodoDoble
     * @param tail 
     */
    public void setTail(NodoDoble tail) {
        this.tail = tail;
    }
    
    /**
     * Metodo pata insertar un elemento al comienzo de la lista, como la cabeza de esta
     * @param element cualquier tipo de objeto. 
     */
    @Override
    public void insertBegin(Object element) {
        NodoDoble newNodo = new NodoDoble(element);
        if (isEmpty()) {
            setHead(newNodo); 
            setTail(newNodo); 
        }else {
            newNodo.setNext(getHead());
            getHead().setPrevious(newNodo);
            setHead(newNodo); 
        }
        size++;
    }

    /**
     * Metodo para insertar un elemento al final de la lista, como a cola de esta
     * @param element que puede ser cualquier tipo de objeto
     */
    @Override
    public void insertFinal(Object element) {
        NodoDoble newNodo = new NodoDoble(element);
        if (isEmpty()) {
            setHead(newNodo); 
            setTail(newNodo); 
        }else {
            newNodo.setPrevious(getTail());
            getTail().setNext(newNodo);
            setTail(newNodo);
        }
        size++;
    }

    /**
     * Metodo para insertar un objeto cualquiera en una posicion (index) especifico de la lista
     * @param element
     * @param index 
     */
    @Override
    public void insertInIndex(Object element, int index) {
        NodoDoble newNodo = new NodoDoble(element);
        if (isEmpty()) {
            setHead(newNodo); 
            setTail(newNodo); 
        }else if (index == size) {
            insertFinal(element); 
        }else if (index == 0) {
            insertBegin(element); 
        }else if (index > size) {
            System.out.println("Index Error");
        }else if (index < 0)
            System.out.println("Index Error");
        else {
            if (index > (int) getSize()/2) {
                NodoDoble pointer = getTail(); 
                for (int end = size-index; end >1 ; end--) {
                    pointer = pointer.getPrevious(); 
                    
                }
                NodoDoble previous = pointer.getPrevious();
                newNodo.setNext(pointer);
                newNodo.setPrevious(previous);
                previous.setNext(newNodo);
                pointer.setPrevious(newNodo); 
            }
            else {
                NodoDoble pointer = getHead();
                for (int i = 1; i < index; i++) {
                    pointer = pointer.getNext(); 
                    
                }
                
                NodoDoble nodoNext = pointer.getNext(); 
                newNodo.setNext(nodoNext);
                newNodo.setPrevious(pointer);
                pointer.setNext(newNodo);
                nodoNext.setPrevious(newNodo); 
            }
         size++; 
        }
    }

    /**
 * Metodo para eliminar un nodo al final de la lista
 * @return el objeto  correspondiente al nodo que ha sido eliminado
 */
    @Override
    public Object deleteFinal() {
        if (isEmpty()) {
            System.out.println("Delete Error, empty list.");; 
        }else {
            NodoDoble newTail = getTail().getPrevious();
            if (newTail == null){
                setHead(null);
                setTail(null); 
                size--;
            }else {
                NodoDoble eliminated = getTail(); 
                newTail.setNext(null);
                getTail().setPrevious(null);
                setTail(newTail);
                size--; 
                return eliminated.getElement(); 
            }
        }
        return null;
        
    }
    
/**
 * Metodo para eliminar un nodo al inicio de la lista
 * @return el objeto  correspondiente al nodo que ha sido eliminado
 */
    @Override
    public Object deleteBegin() {
        if (isEmpty()) {
            System.out.println("Delete Error, empty list.");; 
        }else {
            NodoDoble newHead = getHead().getNext();
            NodoDoble eliminated = getHead(); 
            newHead.setPrevious(null);
            getHead().setNext(null);
            setHead(newHead); 
            size--;
            return eliminated.getElement(); 
        }
        
        return null;
        
    }
    
/**
 * Metodo para eliminar un nodo en una posicion especifica (index) de la lista
 * @return el objeto  correspondiente al nodo que ha sido eliminado
 * @param index
 */
    @Override
    public Object deleteInIndex(int index) {
        if (isEmpty()) {
            System.out.println("Delete Error, list empty.");
        }else if (index >= size) {
             System.out.println("Index Error");
        }else if (index == 0) {
            deleteBegin(); 
        }else if  (index == size-1) {
            deleteFinal(); 
        }else if (index < 0)
            System.out.println("Index Error");
        else {
            
            if (index > (int) getSize()/2) {
                NodoDoble pointer = getTail(); 
                for (int end = size-index; end >1 ; end--) {
                    pointer = pointer.getPrevious();   
                }
                
                pointer.getNext().setPrevious(pointer.getPrevious());
                pointer.getPrevious().setNext(pointer.getNext());
                pointer.setNext(null);
                pointer.setPrevious(null);
                size--;
                
                return pointer.getElement(); 
               
                
                
            }
            else {
                NodoDoble pointer = getHead();
                for (int i = 1; i < index; i++) {
                    pointer = pointer.getNext(); 
                    
                }
                
                NodoDoble deleted = pointer.getNext(); 
                pointer.setNext(deleted.getNext());
                deleted.getNext().setPrevious(pointer);
                deleted.setNext(null);
                deleted.setPrevious(null);
                size--;
                return deleted.getElement();

            } 
        }
        return null;
        
    }
    
/**
 * Metodo para saber si la lista no contiene ningun elemento, es decir, esta vacia
 * @return booleano, true si esta vacia, false si no lo esta
 */
    @Override
    public boolean isEmpty() {
        return (getHead() == null  && getTail() == null); 
    }
    
/**
 * Metodo para imprimir la lista por consola
 */
    @Override
    public void print() {
        NodoDoble pointer = getHead();
        int aux = 0;
        while(pointer != null){
            System.out.println(aux + "._ [" + pointer.getElement() + "]");
            aux ++;
            pointer = pointer.getNext();
        }
        if (getHead() == null){
            System.out.println("Empty List");
        }
    }
    
/**
 * Metodo para obtener un string con los elementos de la lista
 * @return String con los elementos de la lista
 */    
    public String printString() {
        NodoDoble pointer = getHead();
        String list = ""; 
        while (pointer != null) {
            if (pointer.getNext() != null) {
                list = list + pointer.getElement() + " -> "; 
            } else {
                list = list + pointer.getElement(); 
            } 
            pointer = pointer.getNext(); 
            
       }    
       return list;
    }

    /**
 * Metodo para saber si un elemento esta dentro de la lista
 * @param element
 * @return booleano, true si elemento fue encontrado en la lista, false si no lo fue
 */      
    public boolean isIn(Object element) {
        NodoDoble pointer = getHead(); 
        while (pointer != null){
            if (pointer.getElement().equals(element)) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false; 
    }
    
    /**
     * Metodo para vaciar la lista, exceptuando la cabeza
     */
    public void emptyButHead() {
        if (!isEmpty()){
            while(getHead().getNext() != null){
                deleteFinal(); 
            }
        }
    }
    
    public int searchIndex(Object element) {
        if (isEmpty()) return -1; 
        int aux = 0; 
        NodoDoble pointer = getHead(); 
        while (pointer!= null) {
            if (pointer.getElement() == element)return aux;
            aux++; 
            pointer = pointer.getNext();
        }
        return -1; 
    }
}