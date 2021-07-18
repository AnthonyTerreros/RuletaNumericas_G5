package com.espol.ed.grupo_05_ed;

import TDAs.CircularDoubleLinkedList;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import models.Action;
import models.CirclePane;
import models.Counter;
import models.Rotate;
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
        actualizarVentana();
        Game();
        
    }
    
    public void Game() {
        desactivarBotones(false);
        RuletaNumerica rn = RuletaNumerica.getRuletaNumerica();
        rn.cargarRuletas();
        try {
            actualizarVentana();
        } catch (Exception e) {
            dialogoAd.setText("No Hay Circulos.");
        }
        int apuesta = rn.apuestaInicial;
        int numProhibido = RuletaNumerica.generarNumAle(apuesta - 1);
        apuestaInicial.setText(String.valueOf(apuesta));
        numeroProhibido.setText(String.valueOf(numProhibido));
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
    
    public StackPane cargarContenidoVentana() {
        dialogoAd.setText("¡ Elige una Opcion !");
        StackPane container = new StackPane();
        try {
            RuletaNumerica rn = RuletaNumerica.getRuletaNumerica();
            int size = rn.ruletas.size(), cont = 0, distance = size * 100, e = size * 10, i = size * 5;
            int total = rn.sumTotal();
            int nCirculos = rn.ruletas.get(0).size() - 1;
            int apuesta = rn.apuestaInicial;
            int numProhibido = RuletaNumerica.generarNumAle(apuesta - 1);
            SpinnerValueFactory<Integer> numCirculos = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, nCirculos);
            SpinnerValueFactory<Integer> numCircuferencias = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, size - 1);
            for (CircularDoubleLinkedList<Integer> cdll : rn.ruletas) {
                CirclePane miniroot = new CirclePane(distance, e, i);
                Circle path = new Circle(distance, distance, distance);
                Iterator<Integer> it = cdll.iterator();
                while (it.hasNext()) {
                    Integer content = it.next();
                    StackPane sp = crearCirculo(String.valueOf(content), cont);
                    miniroot.getChildren().add(sp);
                    cont++;
                }
                StackPane sp = crearCirculo(String.valueOf(it.next()), cont);
                miniroot.getChildren().add(sp);
                distance -= 100;
                e -= 10;
                i -= 5;
                path.setStroke(Color.BLACK);
                path.setFill(null);
                container.getChildren().addAll(path, miniroot);
            }
            sumaRuleta.setText(String.valueOf(total));
            indexCircuferencia.setValueFactory(numCircuferencias);
            indexCirculo.setValueFactory(numCirculos);
            String s;
            if (total < 0 || total == numProhibido || rn.ruletas.isEmpty()) {
                if (total < 0) {
                    s = "Perdiste, el total de la ruleta numerica es menor que cero.";
                } else if (rn.ruletas.isEmpty() || rn.ruletas.get(0).isEmpty()) {
                    s = "Perdiste, te quedaste sin Circulos.";
                } else {
                    s = "Perdiste, te salio un numero prohibido.";
                }
                VentanaAdicional(Status.LOSE, s);
            }
            if (apuesta == total) {
                s = "Ganaste, tu apuesta cumple con la suma de la ruleta.";
                VentanaAdicional(Status.WIN, s);
            }
        } catch (NullPointerException e) {
            e.getMessage();
            VentanaAdicional(Status.LOSE, "Perdiste, te quedaste sin circulos");
        }
        return container;
    }
    
    public void VentanaAdicional(Status status, String reason) {
        desactivarBotones(true);
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

   @FXML
    public void eliminarCirculo(ActionEvent e) {
        System.out.println(Counter.countClickbtnELI);
        Counter.countClickbtnELI++;
        System.out.println(Counter.countClickbtnELI);
        RuletaNumerica rn = RuletaNumerica.getRuletaNumerica();
        int value = indexCirculo.getValue();
        for(CircularDoubleLinkedList<Integer> cdll: rn.ruletas){
            cdll.remove(value);
        }
        actualizarVentana();
        if(Counter.countClickbtnELI % 2 == 1){
            Counter.countClickbtnRIZQ = 1;
            Counter.countClickbtnRDER = 1;
            hacerOperacionApuesta(Action.DELETE); 
        }
        System.out.println("Eliminar: " + Counter.countClickbtnELI + " Derecha: " + Counter.countClickbtnRDER + " Izquierda:" + Counter.countClickbtnRIZQ);
    }
    
    @FXML
    public void rotarIzquierda(ActionEvent e){
        System.out.println(Counter.countClickbtnRIZQ);
        Counter.countClickbtnRIZQ++;
        System.out.println(Counter.countClickbtnRIZQ);
        RuletaNumerica rn = RuletaNumerica.getRuletaNumerica();
        int value = indexCircuferencia.getValue();
        rn.rotate(rn.ruletas.get(value), Rotate.LEFT);
        actualizarVentana();
        if(Counter.countClickbtnRIZQ % 2 == 1){
            Counter.countClickbtnELI++;
            hacerOperacionApuesta(Action.ROTATE);
        }
        System.out.println("Eliminar: " + Counter.countClickbtnELI + " Derecha: " + Counter.countClickbtnRDER + " Izquierda:" + Counter.countClickbtnRIZQ);
    }
    
    @FXML
    public void rotarDerecha(ActionEvent e){
        System.out.println(Counter.countClickbtnRDER);
        Counter.countClickbtnRDER++;
        System.out.println(Counter.countClickbtnRDER);
        RuletaNumerica rn = RuletaNumerica.getRuletaNumerica();
        int value = indexCircuferencia.getValue();
        rn.rotate(rn.ruletas.get(value), Rotate.RIGHT);
        actualizarVentana();
        hacerOperacionApuesta(Action.ROTATE);
        if(Counter.countClickbtnRDER % 2 == 1){
            Counter.countClickbtnELI++;
            hacerOperacionApuesta(Action.ROTATE);
        }
        System.out.println("Eliminar: " + Counter.countClickbtnELI + " Derecha: " + Counter.countClickbtnRDER + " Izquierda:" + Counter.countClickbtnRIZQ);
    }
    
    public void actualizarVentana(){
        desactivarBotones(false);
        Thread t = new Thread(() -> {
            Platform.runLater(() -> {
            _root.getChildren().clear();
            _root.getChildren().add(cargarContenidoVentana());
            });
        });
        t.start();
    }
    
    public void hacerOperacionApuesta(Action action){
        Task<Void> t1 = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                RuletaNumerica rn = RuletaNumerica.getRuletaNumerica();
                String g4;
                if (action == Action.ROTATE) {
                    g4 = "Hiciste una Rotacion, ";
                } else {
                    g4 = "Hiciste una Eliminacion, ";
                }
                for (int i = 5; i > 0; i--) {
                    String s = g4 + "Elige la operacion contrario " + i + " segundos.";
                    Platform.runLater(() -> dialogoAd.setText(s));
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                return null;
            }
        };
        t1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                if(action == Action.ROTATE){
                    desactivarContainerRotate(true);
                    dialogoAd.setText("Elige La Posicion Donde Deseas Eliminar.");
                }
                if(action == Action.DELETE){
                    desactivarContainerDelete(true);
                    dialogoAd.setText("Elige Hacia Donde Quieres Rotar.");
                }
            }
        });
        Thread t = new Thread(t1);
        t.start();
    }
    
    public void desactivarBotones(boolean b){
        btnEliminarCirculos.setDisable(b);
        btnRotarDerecha.setDisable(b);
        btnRotarIzquierda.setDisable(b);
        containerDelete.setDisable(b);
        containerRotate.setDisable(b);
    }
    
    public void desactivarContainerRotate(boolean b){
        btnRotarDerecha.setDisable(b);
        btnRotarIzquierda.setDisable(b);
        containerRotate.setDisable(b);
    }
    
    public void desactivarContainerDelete(boolean b){
        btnEliminarCirculos.setDisable(b);
        containerDelete.setDisable(b);
        
    }

}
