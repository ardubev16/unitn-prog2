package it.unitn.prog.lab6;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Random;

public class MyShape {
    private final static Random RNG = new Random();
    
    private Shape shape;
    private final int x;
    private final int y;
    
    public MyShape(int x, int y) {
        switch (RNG.nextInt(3)) {
            case 0 -> shape = new Circle(30);
            case 1 -> shape = new Rectangle(60, 60);
            case 2 -> shape = new Polygon(0, 0, 60, 0, 30, 60);
        }
        shape.setFill(Color.WHITE);
        shape.setStroke(Color.BLACK);
        shape.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            setColor();
            mouseEvent.consume();
        });
        this.x = x;
        this.y = y;
    }

    public void setColor() {
        if (shape.getFill().equals(Color.WHITE)) {
            Color color = (x + y) % 2 == 0 ? Color.RED : Color.GREEN;
            shape.setFill(color);
        } else
            resetColor();
    }

    public void resetColor() {
        shape.setFill(Color.WHITE);
    }

    public Shape getShape() {
        return shape;
    }
}