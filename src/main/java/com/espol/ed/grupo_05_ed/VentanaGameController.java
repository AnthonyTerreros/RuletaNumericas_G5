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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import models.CirclePane;
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
    
    @FXML
    public HBox containerRotate;
    
    @FXML
    public HBox containerDelete;
    
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
        sumaRuleta.setText(String.valueOf(RuletaNumerica.sumTotal()));
        sumaRuleta.setStyle("-fx-text-fill: green");
        CirclePane miniroot = new CirclePane(200,10,20);
        for(int i = 0; i < 8; i++){
            Circle c = new Circle(25, 25, 25);
            c.setStroke(Color.BLACK);
            c.setFill(Color.RED);
            miniroot.getChildren().add(c);
        }
        Circle path = new Circle(200, 200, 200);
        path.setStroke(Color.BLACK);
        path.setFill(null);
        StackPane contenedor = new StackPane(path, miniroot);
        _root.getChildren().add(contenedor);
        
//        Circle c = new Circle(200,200,200);
//        Circle c2 = new Circle(75, 75, 75);
//        c.setFill(null);
//        c2.setFill(null);
//        c.setStroke(Color.BLACK);
//        c2.setStroke(Color.BLACK);
//        StackPane cir = crearCirculo();
//        cir.setOnMouseClicked(new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent t) {
//                Text txt = (Text) cir.getChildren().get(1);
//                System.out.println(Integer.valueOf(txt.getText()));
//            }  
//        });
//        StackPane container = new StackPane(c,c2,cir);
//        _root.getChildren().addAll(container);
//        containerRotate.setOnMouseMoved(new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent t) {
//                dialogoAd.setText("Seleccione el circulo");
//            }
//        });
        
        Game();
        
    }
    
    public static void Game() {
        System.out.println("Game");
    }

    public static void VentanaAdicional() {
        VBox root2 = new VBox();
        Label l1 = new Label("Ganaste!");
        root2.getChildren().addAll(l1);
        Stage s = new Stage();
        Scene sce = new Scene(root2,200,200);
        s.setScene(sce);
        s.show();
    }
    
    public static StackPane crearCirculo() {
        Circle c = new Circle(25, 25, 25);
        c.setStroke(Color.BLACK);
        c.setFill(Color.RED);
        Text t = new Text("5");
        t.setStyle("-fx-font-weight: bold; -fx-font-size: 14; -fx-text-fill: white");
        t.setFill(Color.WHITE);
        t.setFont(Font.font("System",18));
        t.setBoundsType(TextBoundsType.VISUAL);
        StackPane contenedor = new StackPane();
        contenedor.getChildren().addAll(c, t);
        
        return contenedor;
    }
    
    
    
    
}
