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
        System.out.println();
        apuestaInicial.setText(String.valueOf(RuletaNumerica.apuestaInicial));
        apuestaInicial.setStyle("-fx-text-fill: green");
        numeroProhibido.setText(String.valueOf(RuletaNumerica.generarNumAle(100)));
        numeroProhibido.setStyle("-fx-text-fill: red");
        sumaRuleta.setText(String.valueOf(sumTotal(ng.ruletas)));
        sumaRuleta.setStyle("-fx-text-fill: green");
        Circle c = new Circle(200,200,200);
        Circle c2 = new Circle(75, 75, 75);
        c.setFill(null);
        c2.setFill(null);
        c.setStroke(Color.BLACK);
        c2.setStroke(Color.BLACK);
        StackPane cir = crearCirculo();
        StackPane container = new StackPane(c,c2,cir);
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
    
    public static void Game() {
        System.out.println("Game");
    }

    public static void VentanaGanaste() {

    }

    public static void VentanaPerdiste() {

    }
    
    public static StackPane crearCirculo() {
        Circle c = new Circle(25, 25, 25);
        c.setStroke(Color.BLACK);
        c.setFill(Color.RED);
        Text t = new Text("5");
        t.setStyle("-fx-font-weight: bold; -fx-font-size: 14; -fx-text-fill: white");
        t.setFill(Color.WHITE);
        t.setFont(Font.font("System",18));
//        t.setBoundsType(TextBoundsType.VISUAL);
        StackPane contenedor = new StackPane();
        contenedor.getChildren().addAll(c, t);
        return contenedor;
    }
    
}
