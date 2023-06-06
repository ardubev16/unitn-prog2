package it.unitn.disi.prog2.Bevilacqua.esame200703;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Piastrella {
    public final Color[] possibleColors = {Color.BROWN, Color.WHEAT, Color.TEAL, Color.DARKBLUE, Color.OLIVE, Color.GOLD};
    protected int currentColor1 = 0;
    protected final String codice;
    protected final double lato;
    protected final double costo;
    protected final String materiale;
    protected final boolean interattiva;
    protected final StackPane figure = new StackPane();

    public Piastrella(String codice, int lato, int costo, String materiale, boolean interattiva) {
        this.codice = codice;
        this.lato = lato;
        this.costo = costo;
        this.materiale = materiale;
        this.interattiva = interattiva;
        Shape figura = new Rectangle(130, 130);
        figura.setFill(possibleColors[currentColor1]);
        figura.setStroke(Color.BLACK);
        if (this.interattiva) {
            figura.setOnMouseClicked(mouseEvent -> {
                currentColor1 = (currentColor1 + 1) % possibleColors.length;
                figura.setFill(possibleColors[currentColor1]);
            });
        }
        this.figure.getChildren().add(figura);
    }

    @Override
    public String toString() {
        return String.format(
                "Codice: %s\n" +
                "materiale: %s\n" +
                "costo: %.2f EUR\n" +
                "dimensione: %.1f cm\n" +
                "shelta colore %s",
                codice, materiale, costo, lato, interattiva ? "SI" : "NO");
    }

    public StackPane getFigura() {
        return figure;
    }
}
