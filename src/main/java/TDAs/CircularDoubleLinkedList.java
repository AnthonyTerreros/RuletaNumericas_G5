/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import TDAs.CircularDoubleNode;
import java.util.Iterator;

/**
 *
 * @author damar
 */
public class CircularDoubleLinkedList<E> implements List<E> {

    private int efectivo;
    private CircularDoubleNode<E> last;

    public CircularDoubleLinkedList() {
        efectivo = efectivo;
        last = null;

    }

    @Override
    public boolean addFirst(E element) {
        CircularDoubleNode<E> nodo = new CircularDoubleNode<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            last = nodo;
            nodo.setNext(nodo);
            nodo.setPrevious(nodo);

        } else {
            nodo.setNext(last.getNext());
            nodo.setPrevious(last);
            (last.getPrevious()).setNext(nodo);
        }
        efectivo++;
        return true;

    }

    @Override
    public boolean addLast(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public boolean isEmpty() {

        return (last == null);
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isEmpty()) {
            return "[]";
        }
        s.append("[");

        if (efectivo == 1) {
            CircularDoubleNode<E> i = last;
            s.append(i.getContent());
            s.append("]");
        } else {

            for (CircularDoubleNode<E> i = last.getNext(); i != last; i = i.getNext()) {

                if (i != last) {
                    s.append(i.getContent() + ",");
                }
            }
            s.append(last.getContent() + "]");
        }
        return s.toString();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
