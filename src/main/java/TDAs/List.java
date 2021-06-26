/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Viviana Velasco
 */
public interface List <E> extends Iterable<E> {
    
   public boolean addFirst(E e); 

    public boolean addLast(E e); 

    public E removeFirst(); 

    public E removeLast(); 

    public int size();

    public boolean isEmpty();

    public void clear();
   
    public void add(int index, E element);

    public E remove(int index); 

    public E get(int index);

    public E set(int index, E element); 
   
    public String toString(); 
  /*
   public List<E> findAll (Comparator<E> cmp, E element); //comparadores por si los necesitamos
   public List<E> findLowerThan (Comparator<E> cmp, E element);
   public List<E> findGreaterThan (Comparator<E> cmp, E element);
   public List<E> findBetween (Comparator<E> cmp, E element, E element2);*/
   
   
   
}
