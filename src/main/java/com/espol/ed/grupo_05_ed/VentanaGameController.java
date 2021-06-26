/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.ed.grupo_05_ed;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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

/**
 * FXML Controller class
 *
 * @author dante
 */
public class VentanaGameController implements Initializable {
    
    @FXML
    public MenuButton btnRotar;
    
    @FXML
    public MenuButton btnGirar;
    
    @FXML
    public HBox _root;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MenuItem girarDerecha = new MenuItem("Derecha");
        MenuItem girarIzquierda = new MenuItem("Izquierda");
        StackPane root = new StackPane();
        Circle circuloExterior = new Circle(200,200,200);
        Circle circuloInterior = new Circle(100,100,100);
        Circle prueba = new Circle(25,25,25);
        prueba.setFill(Color.YELLOW);
        Text t = new Text("5");
        t.setBoundsType(TextBoundsType.VISUAL);
        StackPane ej = new StackPane();
        ej.getChildren().addAll(prueba,t);
        root.getChildren().add(ej);
        circuloExterior.setFill(null);
        circuloInterior.setFill(null);
        circuloExterior.setStroke(Color.BLACK);
        circuloInterior.setStroke(Color.BLACK);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(circuloExterior,circuloInterior);
        btnRotar.getItems().clear();
        btnRotar.getItems().add(girarDerecha);
        btnRotar.getItems().add(girarIzquierda);
        Label l = new Label();
        _root.getChildren().addAll(l,root);
        EventHandler<ActionEvent> evn = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                l.setText(((MenuItem)e.getSource()).getText() + " Selecionado!");
                
            }
        };
        girarDerecha.setOnAction(evn);
        girarIzquierda.setOnAction(evn);
        
    }
    
    
    
}
