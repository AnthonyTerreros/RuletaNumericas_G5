/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.Iterator;

/**
 *
 * @author jaque
 */
public class LinkedList<E> implements List<E> {
     private Node<E> first;
    private Node<E> last;
    

    @Override
    public boolean addFirst(E n) {
        Node<E> nodo= new Node<E>(n);
        if (n==null) {
            return false;
        } else if (first==null) {
            first=nodo;
            last=nodo;
            return true;
        } else {
            nodo.setNext(first);
            first=nodo;
            return true;
        } 
    }

    @Override
    public boolean addLast(E n) {
        Node<E> nodo = new Node<>(n);
        if (n==null) {
            return false;
        }
        else if (first==null) {
            first=nodo;
            last=nodo;
            return true;
        }
        else {
            last.setNext(nodo);
            last=nodo;
            return true;
        }
    }

    @Override
    public E removeFirst() {
         E temporal = first.getElements();
        if (first==null) {
            return null;
        }
        else if (first==last) {
            first=null;
            last=null;
            return temporal;
        } else {
            first=first.getNext();
            return temporal;
        } 

    }

    @Override
    public E removeLast() {
         if (first == null) {
            return null;
        } 
        else if (first == last) {
            return removeFirst();
        }
        else {
            Node<E> nodo = null;
            Node<E> anterior = null;
            for (nodo = first; nodo != last; nodo = nodo.getNext()) {
                anterior = nodo;
            }
            anterior.setNext(null);
            last = anterior;
            return nodo.getElements();
        }
        }

    @Override
    public int size() {
       int effectiveSize = 0;
        Node<E> nodo = null;
        for(nodo = first; nodo != null; nodo = nodo.getNext()){
            effectiveSize++;
        }
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return first==null && last==null;
    }

    @Override
    public void clear() {
        first= null;
        last=null;
        System.out.println("se borraron los datos de la LinkedList.");
    }
    
    
   
    public void add(int index, E element) {
        int es = size();
        if (index<0 || index>es) {
            System.out.println("Error: Fuera de Indice!!");
        } else if (isEmpty()) {
            addFirst(element);
        } else if (index==es) {
            addLast(element);
        } else {
            Node<E> nodo = new Node<>(element);
            Node<E> temporal2 = first;
            for (int i=0; i<index-1; i++) {
                temporal2 = temporal2.getNext();
            }
            nodo.setNext(temporal2.getNext());
            temporal2.setNext(nodo);
            System.out.println("nodo agredago.");
        }
    }

    public E remove(int index) {
        if (this.first == null) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else { 
            int c = 0;
            Node<E> nodo = first, anterior = null;
            for(int i=0; i<index; i++){
                anterior = nodo;
                nodo = nodo.getNext();
                c++;
            }
            
            anterior.setNext(nodo.getNext()); //del anterior sel salta el nodo actual al siguiente del nodo actual
            nodo.setNext(null);
            return nodo.getElements();
        }
    }

    public E get(int index) {
        if (index == 0) {
            return first.getElements();
        } 
        else if (index == size() - 1) {
            return last.getElements();
        } 
        else {
            int cont = 0;
            Node<E> nodo = first;
            while (nodo != null) {
                if (cont == index) {
                    return nodo.getElements();
                }
                nodo = nodo.getNext();
                cont++;
            }
            return null;
        }
    }

    public E set(int index, E element) {
        if (element == null) {
            return null;
        }
        else{
            int c = 0;
            Node<E> nodo = first;
            while (nodo != null) {
                if (c == index) {
                    nodo.setElements(element);
                    return nodo.getElements();
                }
                nodo = nodo.getNext();
                c++;
            }
            return null; 
        }
    }
    

    @Override
    public String toString() {
        String s = "";
        Node<E> nodoviajero = null;
        for(nodoviajero = first; nodoviajero != null; nodoviajero = nodoviajero.getNext()){
            s+=nodoviajero.getElements() + " - ";
        }
        return s;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>(){
            private Node<E> p = first;
            
            @Override
            public boolean hasNext() {
                return p!= null;
            }

            @Override
            public E next() {
                E tmp = p.getElements();
                p = p.getNext();
                return tmp;
            }
        };
        
        return it;
       }
    
}
