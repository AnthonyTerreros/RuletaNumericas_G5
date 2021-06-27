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

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

        CircularDoubleNode<E> nodo = new CircularDoubleNode<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            addFirst(element);

        } else {
            nodo.setPrevious(last);
            nodo.setNext(last.getNext());
            last.setNext(nodo);
            last = nodo;
        }
        efectivo--;
        return true;

    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        int c = 0;
        for (CircularDoubleNode<E> i = last.getNext(); i != last; i = i.getNext()) {
            if (c == index) {
                return i.getContent();
            }
            c++;
        }
        return null;

    }

    @Override
    public boolean isEmpty() {

        return (last == null);
    }

    @Override
    public E remove(int index) {
        int c = 0;
        E u = last.getContent();
        for (CircularDoubleNode<E> i = last.getNext(); i != last; i = i.getNext()) {
            if (c == index) {
                E d = i.getContent();
                (i.getPrevious()).setNext(i.getNext());
                (i.getNext()).setPrevious(i.getPrevious());
                System.out.println(c + " " + index);
                return d;
            }
            c++;
        }
        return u;
    }

    @Override
    public E set(int index, E element) {
        int c = 0;
        for (CircularDoubleNode<E> i = last.getNext(); i != last; i = i.getNext()) {
            if (c == index) {
                E d = i.getContent();
                i.setContent(element);
                return d;
            }
            c++;
        }
        return null;
    }

    @Override
    public int size() {
        return efectivo;
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

}
