/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import TDAs.ArrayList;
import TDAs.CircularDoubleLinkedList;
import TDAs.CircularDoubleNode;
import TDAs.List;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author AnthonyTerreros
 */
public class RuletaNumerica {
    public int numRuletasNumerica = 2;
    public int numCirculos;
    public int apuestaInicial;
    public static RuletaNumerica ruletaNumerica;

    public List<CircularDoubleLinkedList<Integer>> ruletas;

    private RuletaNumerica() {
        
    }
    
    public static RuletaNumerica getRuletaNumerica(){
        if(ruletaNumerica == null){
            ruletaNumerica = new RuletaNumerica();
        }
        return ruletaNumerica;
    }
    
    public void cargarRuletas(){
        ruletas = new ArrayList<>();
        while(ruletas.size() < 2){
            CircularDoubleLinkedList<Integer> cdll = new CircularDoubleLinkedList<>();
            for(int i = 0; i < numCirculos; i++){
                int num = RuletaNumerica.generarNumAle(10);
                cdll.addLast(num);
            }
            ruletas.addLast(cdll);
        }
    }
    
    public void rotate(CircularDoubleLinkedList<Integer> l, Rotate r) {
        if (l.isEmpty()) {
            return;
        } else if (r == Rotate.LEFT) {
            CircularDoubleNode<Integer> current = l.getLast().getNext();
            while (current != l.getLast()) {
                current.setContent(current.getContent() - 1);
                current = current.getNext();
            }
            current.setContent(current.getContent() - 1);
            l.setLast(l.getLast().getNext());
            System.out.println(l);
        } else {
            CircularDoubleNode<Integer> current = l.getLast().getNext();
            while (current != l.getLast()) {
                current.setContent(current.getContent() + 1);
                current = current.getNext();
            }
            current.setContent(current.getContent() + 1);
            l.setLast(current.getPrevious().getPrevious().getNext());
            System.out.println(l);
        }
    }
    
    public int sumTotal(){
        int cont = 0;
        for(CircularDoubleLinkedList<Integer> cdll: ruletas){
            Iterator<Integer> it = cdll.iterator();
            while(it.hasNext()){
                cont += it.next();
            }
            cont += it.next();
        }
        return cont;
    }
    
    public static int generarNumAle(int n) {
        Random r = new Random();
        return r.nextInt(n);
    }
}