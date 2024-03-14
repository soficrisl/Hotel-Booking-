
package EDD;
/**
 * Esta clase define a los nodos dobles, con un puntero hacia el siguiente y uno hacia el anterior, que conforman al nodo doble. 
 * @author Sofia
 */

public class NodoDoble {
    //Atributos de la clase 
    private Object element;
    private NodoDoble next;
    private NodoDoble previous;
    
    /**
     * Constructor de la claseNodo
     * @param element el cual sera el elemento correspondiente al nodo
     */
    public NodoDoble(Object element) {
        this.element = element;
        this.next = this.previous = null;
    }// cierre del constructor
    
    /**
     * Metodo para obtener el objeto correspondiente al elemento del nodo
     * @return element en tipo object
     */
    public Object getElement() {
        return element;
    }
    /**
     * Metodo para setear el elemento del nodo, a uno nuevo.
     * @param element 
     */
    public void setElement(Object element) {
        this.element = element;
    }
    /**
     * Metodo para obtener el siguiente nodo al Nodo correspondiente
     * @return NodoDoble al que este nodo apunta a siguiente
     */
    public NodoDoble getNext() {
        return next;
    }
    /**
     * Metodo para setear el apuntador  siguiente del nodo a otro nodo especifico
     * @param next NodoDoble al que se desea apuntar
     */
    public void setNext(NodoDoble next) {
        this.next = next;
    }

    /**
     * Metodo para obtener el nodo que es apuntado con el apuntador a previo
     * @return previo NodoDoble
     */
    public NodoDoble getPrevious() {
        return previous;
    }
    /**
     * Metodo para setear el previo nodo a uno especifico. 
     * @param previous 
     */
    public void setPrevious(NodoDoble previous) {
        this.previous = previous;
    }
    
    
}
