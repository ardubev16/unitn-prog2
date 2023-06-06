package it.unitn.disi.prog2.Bevilacqua.esame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Comparator;

public class Stato extends HBox {
    public enum TipoBandiera {
        VERT_2,
        VERT_3,
        ORIZ_2,
        ORIZ_3,
        TRIANG
    }

    private final String nomeStato;
    private final String capitale;
    public String getCapitale() {
        return capitale;
    }
    public String getNomeStato() {
        return nomeStato;
    }

    public Stato(String nomeStato, String capitale, TipoBandiera tipoBandiera, Color[] colors) {
        this.nomeStato = nomeStato;
        this.capitale = capitale;
        Canvas bandiera = new Canvas(60, 42);
        GraphicsContext gc = bandiera.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        switch (tipoBandiera) {
            case VERT_2 -> mkBandieraV2(gc, colors);
            case VERT_3 -> mkBandieraV3(gc, colors);
            case ORIZ_2 -> {}
            case ORIZ_3 -> {}
            case TRIANG -> {}
        }
        this.getChildren().addAll(bandiera, new Text(nomeStato), new Text(capitale));
    }

    private void mkBandieraV2(GraphicsContext gc, Color[] colors) {
        gc.setFill(colors[0]);
        gc.fillRect(0, 0, 30, 42);
        gc.strokeRect(0, 0, 30, 42);
        gc.setFill(colors[1]);
        gc.fillRect(30, 0, 60, 42);
        gc.strokeRect(30, 0, 60, 42);
    }
    private void mkBandieraV3(GraphicsContext gc, Color[] colors) {
        gc.setFill(colors[0]);
        gc.fillRect(0, 0, 20, 42);
        gc.strokeRect(0, 0, 20, 42);
        gc.setFill(colors[1]);
        gc.fillRect(20, 0, 40, 42);
        gc.strokeRect(20, 0, 40, 42);
        gc.setFill(colors[2]);
        gc.fillRect(40, 0, 60, 42);
        gc.strokeRect(40, 0, 60, 42);
    }
}
class ComparaPerStato implements Comparator<Stato> {
    @Override
    public int compare(Stato s1, Stato s2) {
        return s1.getNomeStato().compareTo(s2.getNomeStato());
    }
}

class ComparaPerCapitale implements Comparator<Stato> {
    @Override
    public int compare(Stato s1, Stato s2) {
        return s1.getCapitale().compareTo(s2.getCapitale());
    }
}