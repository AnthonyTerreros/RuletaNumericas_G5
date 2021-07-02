/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import TDAs.ArrayList;
import TDAs.CircularDoubleLinkedList;
import TDAs.CircularDoubleNode;
import java.util.Random;


/**
 *
 * @author AnthonyTerreros
 */
public class RuletaNumerica {
    public static int numRuletasNumerica = 2;
    public static int numCirculos;
    public static int apuestaInicial;
    public static RuletaNumerica ruletaNumerica;
    
    public ArrayList<CircularDoubleLinkedList<Integer>> ruletas;

    private RuletaNumerica() {
        ruletas = new ArrayList<>();
        while(ruletas.size() < 2){
            CircularDoubleLinkedList<Integer> cdll = new CircularDoubleLinkedList<>();
            for(int i = 0; i < numCirculos; i++){
                cdll.addLast(RuletaNumerica.generarNumAle(9));
            }
            ruletas.addLast(cdll);
        }
    }
    
    public static RuletaNumerica getRuletaNumerica(){
        if(ruletaNumerica == null){
            ruletaNumerica = new RuletaNumerica();
        }
        return ruletaNumerica;
    }
    
    public void addRuletas(CircularDoubleLinkedList<Integer> cdll){
        ruletas.addLast(cdll);
    }
    
    public static void rotate(CircularDoubleLinkedList<Integer> l, Rotate r) {
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
    
    public static int generarNumAle(int n) {
        Random r = new Random();
        return r.nextInt(n);
    }
    
}
