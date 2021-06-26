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
public class CircularDoubleNode<E> {

    private E content;
    private CircularDoubleNode<E> previous, next;

    public CircularDoubleNode(E data) {
        this.content = data;
        this.next = null;
        this.previous = null;
    }

    public E getContent() {
        return content;
    }

    public CircularDoubleNode<E> getPrevious() {
        return previous;
    }

    public CircularDoubleNode<E> getNext() {
        return next;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public void setPrevious(CircularDoubleNode<E> previous) {
        this.previous = previous;
    }

    public void setNext(CircularDoubleNode<E> next) {
        this.next = next;
    }

}
