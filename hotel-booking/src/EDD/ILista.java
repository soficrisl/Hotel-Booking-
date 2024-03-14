
package EDD;

/**
 * @author Sofia
 * @version 02/02/2024
 * Esta es una interfaz, con metodos abstractos implementada en la clase ListaDoble
 */

public interface ILista {
    //Los siguientes son todos los metodos que deberia tener una lista doblemente enlazada
    public void insertBegin(Object element);
    public void insertFinal(Object element);
    public void insertInIndex(Object element, int index);
    public Object deleteBegin();
    public Object deleteFinal();
    public Object deleteInIndex(int index);
    public boolean isEmpty();
    public void print();
}