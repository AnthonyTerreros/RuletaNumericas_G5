/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.Iterator;

/**
 *
 * @author damar
 */
public class CircularDoubleLinkedList<E> implements List<E> {

    private int efectivo;
    private CircularDoubleNode<E> last;

    public CircularDoubleLinkedList() {
        efectivo = 0;
        last = null;
    }

    @Override
    public void clear() {
        last = null;
    }

    @Override
    public void add(int index, E element) {
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
            int c = 0;
            for (CircularDoubleNode<E> current = last.getNext(); current != last; current = current.getNext()) {
                if (c == index - 1) {
                    current.getPrevious().setNext(nodo);
                    nodo.setPrevious(current.getPrevious());
                    nodo.setNext(current);
                    current.setPrevious(nodo);
                    efectivo++;
                }
                c++;
            }
        }
    }

    @Override
    public boolean addFirst(E element) {
        CircularDoubleNode<E> nodo = new CircularDoubleNode<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            last = nodo;
            last.setNext(nodo);
            last.setPrevious(nodo);
            efectivo++;
        } else {
            nodo.setNext(last.getNext());
            last.setNext(nodo);
            nodo.setPrevious(last);
            nodo.getNext().setPrevious(nodo);

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
            nodo.setPrevious(last);
            nodo.setNext(last.getNext());
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
            E d = last.getNext().getContent();
            last.getNext().getNext().setPrevious(last);
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
        E answer = last.getContent();
        temp.setNext(last.getNext());
        last.getNext().setPrevious(temp);
        last = temp;
        efectivo--;
        return answer;
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

    @Override
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
        for (CircularDoubleNode<E> nodo = last.getNext(); nodo != last; nodo = nodo.getNext()) {
            if (c == index) {
                E d = nodo.getContent();
                nodo.getPrevious().setNext(nodo.getNext());
                nodo.getNext().setPrevious(nodo.getPrevious());
                nodo.setContent(null);
                nodo.setPrevious(null);
                nodo.setNext(null);
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
            System.out.println("Elemento invalido.");
            return null;
        } else {
            int c = 0;
            for (CircularDoubleNode<E> nodo = last.getNext(); nodo != last; nodo = nodo.getNext()) {
                if (c == index) {
                    E d = nodo.getContent();
                    nodo.setContent(element);
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

    @Override
    public String toString() {
        if (last == null) {
            return "[]";
        } else {
            CircularDoubleNode<E> node = last.getNext();
            String s = "[";
            for (int cont = 0; cont < efectivo; cont++) {
                s += node.getContent().toString();
                if (cont != efectivo - 1) {
                    s += ", ";
                }
                node = node.getNext();
            }
            return s + "]";
        }
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private CircularDoubleNode<E> p = last.getNext();

            @Override
            public boolean hasNext() {
                return p != last;
            }

            @Override
            public E next() {
                E e = p.getContent();
                p = p.getNext();
                return e;
            }
        };
        return it;
    }
}
