/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.ed.grupo_05_ed;

import TDAs.ArrayList;
import TDAs.CircularDoubleLinkedList;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import models.Status;


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
    @FXML
    public Spinner<Integer> indexCirculo;
    @FXML
    public Spinner<Integer> indexCircuferencia;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Game();
        
    }
    
    public static void Game() {
        System.out.println("Game");
        RuletaNumerica rn= RuletaNumerica.getRuletaNumerica();
        rn.cargarRuletas();
        System.out.println("Ruletas: " + rn.ruletas);
         _root.getChildren().add(cargarContenidoVentana());
        int apuesta = rn.apuestaInicial;
        int numProhibido = RuletaNumerica.generarNumAle(apuesta - 1);
        apuestaInicial.setText(String.valueOf(apuesta));
        numeroProhibido.setText(String.valueOf(numProhibido));
    }

    public void VentanaAdicional(Status status, String reason) {
        VBox root2 = new VBox();
        Label l = new Label();
        Label l1 = new Label();
        ImageView iv = new ImageView();
        Label l2 = new Label();
        Button btn = new Button("Volver al Inicio");
        Stage s = new Stage();
        btn.setStyle("-fx-background-color: #2673f7; -fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: white;");
        root2.setAlignment(Pos.CENTER);
        root2.setSpacing(10);
        l1.setText(reason);
        l1.setStyle("-fx-font-size: 14; -fx-font-weight: bold;");
        l2.setStyle("-fx-font-size: 14; -fx-font-weight: bold;");
        String fotoString = App.pathFiles;
        if (status == Status.WIN) {
            fotoString += "Ganaste.png";
            l.setText("WINNER");
            l.setStyle("-fx-text-fill: green; -fx-font-size: 26; -fx-font-weight: bold;");
        }
        else{
            fotoString += "Perdiste.png";
            l.setText("GAME OVER");
            l.setStyle("-fx-text-fill: red; -fx-font-size: 26; -fx-font-weight: bold;");

        }
       try (FileInputStream input = new FileInputStream(fotoString)) {
                Image i = new Image(input, 200, 200, true, false);
                iv.setImage(i);
            } catch (IOException ex) {
                ex.getMessage();
        }
        Thread t = new Thread(() -> {
            try {
                for (int k = 10; k > 0; k--) {
                    String sa = k + " segundos para volver al inicio.";
                    Platform.runLater(() -> l2.setText(sa));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.getMessage();
                    }
                }
                Platform.runLater(() -> s.close());
                App.setRoot("VentanaPrincipal");
            } catch (IOException ex) {
                ex.getMessage();
            }
        });
        btn.setOnAction((ActionEvent ta) -> {
            try {
                s.close();
                App.setRoot("VentanaPrincipal");

            } catch (IOException ex) {
                ex.getMessage();
            }
        });
        t.setDaemon(true);
        t.start();
        root2.getChildren().addAll(l, l1, l2, iv, btn);

        Scene sce = new Scene(root2, 450, 400);
        s.setScene(sce);
        s.show(); 
    }
    
   public StackPane crearCirculo(String content, int n) {
        StackPane contenedor = new StackPane();
        Circle c = new Circle(25, 25, 25);
        Text t = new Text(content);
        contenedor.setMaxSize(10.00, 10.00);
        c.setStroke(Color.BLACK);
        if(n % 2 == 0){
            c.setFill(Color.RED);
        }else{
            c.setFill(Color.YELLOW);
        }
        t.setFill(Color.BLACK);
        t.setFont(new Font("System", 22));
        t.setStyle("-fx-font-weight: bold");
        t.setBoundsType(TextBoundsType.VISUAL);
        contenedor.getChildren().addAll(c, t);
        return contenedor;
    }
    
    
    
}
