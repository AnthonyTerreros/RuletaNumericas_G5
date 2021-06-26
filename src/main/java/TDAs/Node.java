/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author Viviana
 */
public class Node<E> {
    private E elements;
    private Node<E> next;

    public Node(E nodo) {
        this.elements=nodo;
    }

    public E getElements() {
        return elements;
    }

    public void setElements(E elements) {
        this.elements = elements;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}
