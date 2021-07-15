package models;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 *
 * @author dante
 */
public class CirclePane extends Pane {
    
    private final double radio;
    private final double exteriorSize;
    private final double interiozSize;
    
    public CirclePane(double radio, double exteriorSize, double interiozSize){
        this.radio=radio;
        this.exteriorSize=exteriorSize;
        this.interiozSize=interiozSize;
        super.setMinSize(2*radio, 2d*radio);
        super.setPrefSize(2*radio, 2d*radio);
        super.setMaxSize(2*radio, 2d*radio);
    }

    /*
    * Todos los nodos o los hijos de la Clase CirclePane, tienen forma de un circulo.
    */
    @Override
    protected void layoutChildren() {
        final double cont = 360.00 / super.getChildren().size();
        double grados = 0;
        for (Node node : getChildren()) {
            //Coordenadas Rectangulares a Polares
            double x = radio * Math.cos(Math.toRadians(grados)) + getWidth() / 2;
            double y = radio * Math.sin(Math.toRadians(grados)) + getHeight() / 2;
            super.layoutInArea(node, x - node.getBoundsInLocal().getWidth() / 2, y - node.getBoundsInLocal().getHeight() / 2, super.getWidth(), super.getHeight(), 0.0, HPos.LEFT, VPos.TOP);
            grados += cont;
        }
    }
    
}
