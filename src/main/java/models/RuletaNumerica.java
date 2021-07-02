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
    
    public static ArrayList<CircularDoubleLinkedList<Integer>> ruletas;

    private RuletaNumerica() {
        ruletas = new ArrayList<>();
        while(ruletas.size() < 2){
            CircularDoubleLinkedList<Integer> cdll = new CircularDoubleLinkedList<>();
            for(int i = 0; i < numCirculos; i++){
                cdll.addLast(RuletaNumerica.generarNumAle());
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
    
    public static void addRuletas(CircularDoubleLinkedList<Integer> cdll){
        ruletas.addLast(cdll);
    }
    
    public static void rotateLeft(CircularDoubleLinkedList<Integer> l){
        if(l.isEmpty()) return;
        CircularDoubleNode<Integer> current = l.getLast().getNext();
        while(current != l.getLast()){
            current.setContent(current.getContent() - 1);
            current = current.getNext();
        }
        current.setContent(current.getContent() - 1);
        l.setLast(l.getLast().getNext());
        System.out.println(l);
    }

    public static void rotateRight(CircularDoubleLinkedList<Integer> l){
        if(l.isEmpty()) return;
        CircularDoubleNode<Integer> current = l.getLast().getNext();
        while(current != l.getLast()){
            current.setContent(current.getContent() + 1);
            current = current.getNext();
        }
        current.setContent(current.getContent() + 1);
        l.setLast(current.getPrevious().getPrevious().getNext());
        System.out.println(l);
    }
    
    private static int generarNumAle() {
        Random r = new Random();
        return r.nextInt(9);
    }
    
}
