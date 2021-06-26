/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.espol.ed.grupo_05_ed;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anthony Terreros
 */
public class VentanaPrincipalController implements Initializable {
    
    @FXML
    public BorderPane root;
    
    @FXML 
    public TextField txtApuestaInicial;
    
    @FXML 
    public TextField txtNumeroCirculos;
    
    @FXML 
    public Button btnJugar;
    
    @FXML
    public Button btnSalir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        btnJugar.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent t) {
//                System.out.println(txtNumeroCirculos.getText());
//            }
//        });
        
    }   
    
    @FXML
    void jugar(){
        try {
            App.setRoot("VentanaGame");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    void close(ActionEvent ae){
        Stage s = (Stage) root.getScene().getWindow();
        s.close();
    }
}
