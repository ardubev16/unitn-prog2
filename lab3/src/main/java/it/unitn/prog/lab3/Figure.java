package it.unitn.prog.lab3;

import java.util.Objects;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class Figure {
    Shape shape;
    Color color;
    final Color[] colors = {Color.YELLOW, Color.RED, Color.BLUE};
    final Shape[] shapes = {new Rectangle(60, 60), new Circle(30)};
    private static final Random RNG = new Random();

    public Figure() {
        this.color = colors[RNG.nextInt(colors.length)];
        this.shape = shapes[RNG.nextInt(shapes.length)];
        shape.setFill(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
//        return color.equals(figure.color) && shape.getClass().equals(figure.shape.getClass());
        return color.equals(figure.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape.getClass(), color);
    }
}