/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author damar
 */
public class CircularDoubleLinkedList<E> implements List<E> {

    private int efectivo;
    private CircularDoubleNode<E> last;

    @Override
    public void clear() {
        last = null;
    }

    @Override
    public void add(int index, E element) {
        int c = 0;
        CircularDoubleNode<E> nodo = new CircularDoubleNode<>(element);
        if (element == null) {
            System.out.println("valor ingresado invalido");
        } else if (index == 0) {
            addFirst(element);
        } else if (index == efectivo) {
            addLast(element);

        } else if (index < 0 || index > efectivo) {
            System.out.println("Index invalido");

        } else {

            for (CircularDoubleNode<E> i = last.getNext(); i != last; i = i.getNext()) {
                if (c == index - 1) {
                    nodo.setNext(i.getNext());
                    i.setNext(nodo);
                    nodo.setPrevious(i);
                    nodo.getNext().setPrevious(nodo);
                    efectivo++;
                }
                c++;
            }
        }
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
            efectivo++;
        } else {
            (last.getPrevious()).setPrevious(nodo);
            nodo.setNext(last.getNext());
            nodo.setPrevious(last);
            last.setNext(nodo);
            efectivo++;
        }
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
            (last.getPrevious()).setPrevious(nodo);
            nodo.setNext(last.getNext());
            nodo.setPrevious(last);
            last.setNext(nodo);
            last = nodo;
            efectivo++;
        }

        return true;

    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        } else if (efectivo == 1) {
            last = null;
        } else {
            E d = (last.getNext()).getContent();
            ((last.getNext()).getNext()).setPrevious(last);
            last.setNext((last.getNext()).getNext());
            efectivo--;
            return d;
        }

        return null;
    }

    @Override
    public E removeLast() {
        if (last == null) {
            return last.getContent();
        }
        CircularDoubleNode<E> temp = last.getPrevious();
        temp.setNext(last.getNext());
        last.getNext().setPrevious(temp);
        last = temp;
        return last.getContent();
    }

    @Override
    public E get(int index) {
        int c = 0;
        if (index == efectivo - 1) {
            return last.getContent();

        }
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

    @Override//corregir
    public E remove(int index) {
        int c = 0;
        if (index < 0 || index >= efectivo) {
            return null;
        } else if (index == 0) {
            E tmp = (last.getNext()).getContent();
            removeFirst();
            return tmp;
        } else if (index == efectivo - 1) {
            E tmp = last.getContent();
            removeLast();
            
            return tmp;
        }
        for (CircularDoubleNode<E> i = last.getNext(); i != last; i = i.getNext()) {
            if (c == index) {
                E d = i.getContent();
                (i.getPrevious()).setNext(i.getNext());
                (i.getNext()).setPrevious(i.getPrevious());
                efectivo--;
                return d;
            }
            c++;
            
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > efectivo) {
            return null;
        } else if (element == null) {
            System.out.println("elemento invalido");
            return null;

        } else {
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
    }

    @Override
    public int size() {
        return efectivo;
    }

    public CircularDoubleNode<E> getLast() {
        return last;
    }

    public void setLast(CircularDoubleNode<E> last) {
        this.last = last;
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
