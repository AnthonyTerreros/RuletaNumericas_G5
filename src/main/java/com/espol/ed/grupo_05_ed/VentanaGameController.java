/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.ed.grupo_05_ed;

import TDAs.ArrayList;
import TDAs.CircularDoubleLinkedList;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import models.RuletaNumerica;


/**
 * FXML Controller class
 *
 * @author dante
 */
public class VentanaGameController implements Initializable {
    
    @FXML
    public Button btnRotarDerecha;
    
    @FXML
    public Button btnRotarIzquierda;
    
    @FXML
    public Button btnEliminarCirculos;
    
    @FXML
    public Label apuestaInicial;
    
    @FXML
    public Label numeroProhibido;
    
    @FXML
    public Label dialogoAd;
    
    @FXML
    public Label sumaRuleta;
    
    @FXML
    public HBox _root;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RuletaNumerica ng = RuletaNumerica.getRuletaNumerica();
        System.out.println("Ruletas: " + ng.ruletas);
        System.out.println(sumTotal(ng.ruletas));
        apuestaInicial.setText("Apuesta Inicial: " + String.valueOf(RuletaNumerica.apuestaInicial));
        numeroProhibido.setText("Numero Prohibido: " + String.valueOf(RuletaNumerica.generarNumAle(100)));
        Circle c = new Circle(150,150,150);
        Circle c2 = new Circle(75, 75, 75);
        c.setFill(null);
        c2.setFill(null);
        c.setStroke(Color.BLACK);
        c2.setStroke(Color.BLACK);
        StackPane container = new StackPane(c,c2);
        _root.getChildren().addAll(container);
        Game();
        
    }
    
    public static int sumTotal(ArrayList<CircularDoubleLinkedList<Integer>> ruletas){
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
    
    public static void Game(){
        System.out.println("Game");
    }
    
    public static void VentanaGanaste(){
        
    }
    
    public static void VentanaPerdiste(){
        
    }
    
}
