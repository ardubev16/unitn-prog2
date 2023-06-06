package it.unitn.disi.prog2.Bevilacqua.esame200703;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class PiastrellaBicolore extends Piastrella {
    private int currentColor2 = 1;

    enum FormaInterna {
        QUADRATO(new Rectangle(65, 65)),
        CERCHIO(new Circle(32.5));

        private final Shape shape;
        FormaInterna(Shape shape) {
            this.shape = shape;
        }

        public Shape getShape() {
            return shape;
        }
    }

    public PiastrellaBicolore(String codice, int lato, int costo, String materiale, boolean interattiva, FormaInterna formaInterna) {
        super(codice, lato, costo, materiale, interattiva);
        Shape figura = formaInterna.getShape();
        figura.setFill(possibleColors[currentColor2]);
        figura.setStroke(Color.BLACK);
        if (this.interattiva) {
            figura.setOnMouseClicked(mouseEvent -> {
                currentColor2 = (currentColor2 + 1) % possibleColors.length;
                figura.setFill(possibleColors[currentColor2]);
            });
        }
        this.figure.getChildren().add(figura);
    }
}
