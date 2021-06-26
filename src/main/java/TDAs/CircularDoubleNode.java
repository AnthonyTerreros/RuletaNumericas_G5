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
    private CircularDoubleNode<E> last;

    public CircularDoubleNode(E data) {
        this.content = data;
        this.last = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public void setLast(CircularDoubleNode<E> last) {
        this.last = last;
    }

    public CircularDoubleNode<E> getLast() {
        return last;
    }

}
