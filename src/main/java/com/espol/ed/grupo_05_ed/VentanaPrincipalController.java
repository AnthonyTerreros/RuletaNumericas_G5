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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Anthony Terreros
 */
public class VentanaPrincipalController implements Initializable {
    @FXML 
    public TextField txtApuestaInicial;
    
    @FXML 
    public TextField txtNumeroCirculos;
    
    @FXML 
    public Button btnJugar;
    //fx:controller="com.espol.ed.grupo_05_ed.VentanaPrincipalController"
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnJugar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.out.println(txtNumeroCirculos.getText());
            }
        });
    }    
    
}
