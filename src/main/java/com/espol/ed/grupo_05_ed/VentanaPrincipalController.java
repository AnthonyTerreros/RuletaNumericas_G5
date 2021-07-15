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
import models.RuletaNumerica;

/**
 * FXML Controller class
 *
 * @author Anthony Terreros
 */
public class VentanaPrincipalController implements Initializable {
    
    @FXML
    public BorderPane root; 
    public TextField txtApuestaInicial;
    public TextField txtNumeroCirculos;
    public Button btnJugar;
    public Button btnSalir;
    public Label lblMessage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    @FXML
    void jugar() { 
        try {
            if (!txtApuestaInicial.getText().equals("")) {
                System.out.println(txtApuestaInicial.getText() + " " + txtNumeroCirculos.getText());
                RuletaNumerica ng = RuletaNumerica.getRuletaNumerica();
                ng.numCirculos = Integer.parseInt(txtNumeroCirculos.getText());
                ng.apuestaInicial = Integer.parseInt(txtApuestaInicial.getText());
            }if(txtNumeroCirculos.getText().equals("") || txtApuestaInicial.getText().equals("")){
                lblMessage.setText("Debes Ingresar Los Datos Para Poder Jugar!");
            }
            App.setRoot("VentanaGame");
        }   
        catch (IOException ex) {
            ex.getMessage();
        }
    }
    
    @FXML
    void close(ActionEvent ae){
        Stage s = (Stage) root.getScene().getWindow();
        s.close();
    }
}
