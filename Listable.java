import java.util.Iterator;

public interface Listable<T>{

    /**
     * Método para agregar elemento a una lista
     * 
     * @param T elemento a agregar
     */
    public void agregar(T elem);

    /**
     * Metodo para obtener dato de un nodo si se da el indice del elemento
     *
     *@param int indice del elemento buscado
     *@return dato del indice del elemento buscado
     */
    public T obtenerDato(int i);

    /**
     * Método para obtener la longitud de la lista
     * 
     * @return int con la longitud de lista
     */
    public int longitudLista();

    /**
     * Método para buscar si un elemento se enceuntra en la lista
     * 
     * @param T elemento a buscar 
     * @return boolean true si lo encuentra.
     */
    public boolean contiene(T elem);

    /**
     * Metodo para verificar si una lista esta vacia
     * 
     * @return boolean, true esta vacia, false tiene un elemento
     */
    public boolean estaVacio();

    /**
     * Metodo para vaciar la lista
     */
    public void vacia();

    /**
     * Metodo para encontrar el primer elemento de una lista
     * 
     * @return T elemento en primera posición
     */
    public T primerElemento();

    /**
     * Metodo para encontrar el ultimo elemento de una lista
     * 
     * @return T elemento en ultima posición
     */
    public T ultimoElemento();

    /**
     * Metodo para eliminar un elemento de la lista
     * 
     * @param T elemento a eliminar
     */
    public void eliminar(T elem);

    /**
     * Metodo para regresar el indice del dato buscado
     *
     * @param T elemento a buscar
     * @return int con el numero de indice del dato buscado
     */
    public int regresarIndice(T elem);

    /**
     * Iterador para recorrer la lista
     * @return iterator
     */
    Iterator<T> iterador();
}
