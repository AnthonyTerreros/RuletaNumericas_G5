/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.util.Comparator;

/**
 *
 * @author damar
 */
public interface List <E> extends Iterable<E> {
    
   boolean addFirst(E element);
   boolean addLast(E element);
   boolean removeFirst();
   boolean removeLast();
   E getFirst();
   E getLast();
   boolean insert(int index, E element);
   boolean contains(E element);
   E get(int index);
   int indexOf(E element);
   boolean isEmpty();
   E remove(int index);
   boolean remove(E element);
   E set(int index, E element);
   int size();
   
  /*
   public List<E> findAll (Comparator<E> cmp, E element); //comparadores por si los necesitamos
   public List<E> findLowerThan (Comparator<E> cmp, E element);
   public List<E> findGreaterThan (Comparator<E> cmp, E element);
   public List<E> findBetween (Comparator<E> cmp, E element, E element2);*/
   
   
   
}
