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
    
    private final double radius;
    private final double ext_gap;
    private final double int_gap;
    
    public CirclePane(double radius, double ext_gap, double int_gap){
        this.radius=radius;
        this.ext_gap=ext_gap;
        this.int_gap=int_gap;
        setMinSize(2*radius, 2d*radius);
        setPrefSize(2*radius, 2d*radius);
        setMaxSize(2*radius, 2d*radius);
    }
    
    @Override
    protected void layoutChildren() {
//        final int radius = 200;
        final double increment = 360 / getChildren().size();
        double degreese = 0;
        for (Node node : getChildren()) {
            double x = radius * Math.cos(Math.toRadians(degreese)) + getWidth() / 2;
            double y = radius * Math.sin(Math.toRadians(degreese)) + getHeight() / 2;
            layoutInArea(node, x - node.getBoundsInLocal().getWidth() / 2, y - node.getBoundsInLocal().getHeight() / 2, getWidth(), getHeight(), 0.0, HPos.LEFT, VPos.TOP);
            degreese += increment;
        }
    }
    
}
