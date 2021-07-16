/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.Iterator;


/**
 *
 * @author Viviana Velasco
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
    private E[] elements;
    private int capacity=100;
    private int effectiveSize=0;
    
    
    public ArrayList() {
      elements = (E[])(new Object[capacity]); 
    }
    public ArrayList(int cap){
        this.capacity=cap;
        elements = (E[]) new Object[capacity];
    }
    
  @Override
    public boolean addFirst(E e) {
        if(e==null){
            return false;
        }
        else if(isEmpty()){
            elements[effectiveSize] = e;
            effectiveSize++;
            return true;
        }
        else if(isFull()){
            addCapacity();
            addFirst(e);
        }
        for(int i = effectiveSize -1; i >=0; i--){
            elements[i+1] = elements[i];
        }
        elements[0] = e;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if(e==null){
            return false;
        }
        else if(isFull()){
            addCapacity();
            addLast(e);
        }else 
        elements[effectiveSize++] = e;
        return true;
    }

    @Override
    public E removeFirst() {
        E temporal = elements[0];
        for(int i=0; i<effectiveSize; i++) {
            elements[i] = elements[i+1];
        }
        effectiveSize--;
        return temporal;
    }

    @Override
    public E removeLast() {
        E temporal2 = elements[effectiveSize-1];
        elements[effectiveSize] = null;
        effectiveSize--;
        return temporal2;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        if(effectiveSize == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void clear() {
        for( int i=0; i<effectiveSize; i++){
            elements[i] = null;
        }
        System.out.println("se limpio el arraylist.");
    }
    
    private boolean revisarindiceCorrecto(int effectiveSize, int index){
        if(index>0 && index<effectiveSize){
            return true;
        }
        else{
            return false;
        }
    }

    public void add(int index, E element) {
        if(isEmpty()){
            elements[effectiveSize]=element;
            effectiveSize++;
        }
        else if(isFull()){
            addCapacity();
            add(index,element);
        }
        if(revisarindiceCorrecto(effectiveSize,index)){
            for(int i=effectiveSize-1; i>=index; i--){
                elements[i+1]=elements[i];
            }
            elements[index] = element;
            effectiveSize++;
            System.out.println("se agrego correctamente");
        }else{
            System.out.println("no se pudo agregar");
        }
    }

    
    public E remove(int index) {
        if(revisarindiceCorrecto(effectiveSize,index)){
            E temporal3 = elements[index];
            for(int i=index; i<effectiveSize-1; i++) {
                elements[i] = elements[i+1];
            }
            elements[effectiveSize-1]=null;
            effectiveSize--;
            return temporal3;
        }else{
           return null; 
        }
        

    }

    
    public E get(int index) {
        if(index>=0 && index<capacity){
            return elements[index];
        }else{
           return null; 
        }
        
    }
    
 
    public E set(int index, E element) {
        if (revisarindiceCorrecto(effectiveSize,index)) {
            E temporal = elements[index];
            elements[index] = element;
            System.out.println("se cambio el contenido del index ingresado.");
            return temporal;
        } else {
            System.out.println("no se pudo cambiar!");
            return null;
        }

    }
    
    
    private boolean isFull(){
        if(effectiveSize==capacity){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    private void addCapacity(){
        E[] temporalArrayList = (E[]) new Object[capacity*2];
        for(int i=0; i<capacity; i++){
            temporalArrayList[i]=elements[i];
        }
        capacity *= 2;
        elements=temporalArrayList;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i=0; i<effectiveSize; i++){
            s += elements[i] + " ";
        }
        return "["+s+"]";
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>(){
            
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < effectiveSize;
            }

            @Override
            public E next() {
                E tmp = get(index);
                index++;
                return tmp;
            }
            
        };
        
        return it;
    }
}
