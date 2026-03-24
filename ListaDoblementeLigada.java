import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListaDoblementeLigada<T> implements Listable<T> {
    /**
     * Clase auxiliar Nodo
     */
    private class Nodo{
        T dato;
        Nodo siguiente;
        Nodo anterior;

        Nodo(T dato){
            this.dato = dato;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    //Atributos
    private Nodo cabeza;
    private Nodo cola;
    private int tamaño;


    /**
     * Método constructor
     */
    public ListaDoblementeLigada(){
        cabeza = null;
        cola = null;
        tamaño = 0;
    }


    @Override
    public void agregar(T elem){
        Nodo nuevo = new Nodo(elem);

        if(estaVacio()){
            cabeza = cola = nuevo;
        } else{
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }

        tamaño++;
    }
    
    public void agregar(int indice, T elem) {
	if (indice < 0 || indice > tamaño) {
	    throw new IndexOutOfBoundsException();
	}
	
	if (indice == tamaño) {
	    agregar(elem);
        return;
	}
	
	Nodo nuevo = new Nodo(elem);
	
	if (indice == 0) {
        if (estaVacio()) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
	} else {
	    Nodo actual;
	    if (indice < tamaño / 2) {
		actual = cabeza;
		for (int i = 0; i < indice; i++) {
		    actual = actual.siguiente;
            }
	    } else {
		actual = cola;
		for (int i = tamaño - 1; i > indice; i--) {
		    actual = actual.anterior;
            }
	    }
	    nuevo.anterior = actual.anterior;
	    nuevo.siguiente = actual;
	    actual.anterior.siguiente = nuevo;
	    actual.anterior = nuevo;
	}
	tamaño++; 
    }

    @Override
    public T obtenerDato(int i) {
	if (i < 0 || i > tamaño) {
	    throw new IndexOutOfBoundsException();
	}
	
	Nodo actual = cabeza;
	int j = 0;

        while(actual != null){
            if(j == i) {
                return actual.dato;
            }
            actual = actual.siguiente;
	    j++;
        }
	return null;
    }
    
    @Override
    public int longitudLista() {
	Nodo actual = cabeza;
	int longitud = 0;

        while(actual != null){
            longitud++;
            actual = actual.siguiente;
        }
	this.tamaño = longitud;
	return longitud; 
    }

    @Override
    public boolean contiene(T elem){
        Nodo actual = cabeza;

        while(actual != null){
            if(actual.dato.equals(elem)){
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    @Override
    public boolean estaVacio(){
        return tamaño == 0;
    }

    @Override
    public void vacia(){
        cabeza = cola = null;
        tamaño = 0;
    }

    @Override
    public T primerElemento(){
        if(estaVacio()){
            throw new NoSuchElementException();
        }

        return cabeza.dato;
    }

    @Override
    public T ultimoElemento(){
	if(estaVacio()){
            throw new NoSuchElementException();
        }

        return cola.dato;
    }
	
    @Override
    public void eliminar(T elem){
        Nodo actual = cabeza;

        while(actual != null){
            if(actual.dato.equals(elem)){
                eliminarNodo(actual);
                return;
            }
            actual = actual.siguiente;
        }
    }

    private void eliminarNodo(Nodo nodo){
        if(nodo == cabeza){
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }else if( nodo == cola){
            cola = cola.anterior;
            cola.siguiente = null;
        }else{
            nodo.anterior.siguiente = nodo.siguiente;
            nodo.siguiente.anterior = nodo.anterior;
        }
    }

    @Override
    public int regresarIndice(T elem) {
	Nodo actual = cabeza;
	int i = 0;

        while(actual != null){
            if(actual.dato.equals(elem)){
                return i;
            }
            actual = actual.siguiente;
	    i ++;
        }

        return -1;
    }
	
    @Override
    public Iterator<T> iterador() {
        return new Iterator<T>() {

            private Nodo actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
    }    


}
