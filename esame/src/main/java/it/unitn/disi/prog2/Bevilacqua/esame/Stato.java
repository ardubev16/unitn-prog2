package it.unitn.disi.prog2.Bevilacqua.esame;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Comparator;

public class Stato {
    public enum TipoBandiera {
        VERT_2,
        VERT_3,
        ORIZ_2,
        ORIZ_3,
        TRIANG
    }

    private final String nomeStato;
    private final String capitale;
    private final Canvas bandiera;
    public String getCapitale() {
        return capitale;
    }
    public String getNomeStato() {
        return nomeStato;
    }

    public Canvas getBandiera() {
//        Canvas bandiera = new Canvas(60, 42);
//        bandiera.getGraphicsContext2D().drawImage(this.bandiera.snapshot(new SnapshotParameters(), null), 0, 0);
        return bandiera;
    }

    public Stato(String nomeStato, String capitale, TipoBandiera tipoBandiera, Color[] colors) {
        this.nomeStato = nomeStato;
        this.capitale = capitale;
        bandiera = new Canvas(60, 42);
        GraphicsContext gc = bandiera.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        switch (tipoBandiera) {
            case VERT_2:
                mkBandieraV2(gc, colors);
                break;
            case VERT_3:
                mkBandieraV3(gc, colors);
                break;
            case ORIZ_2:
                mkBandieraH2(gc, colors);
                break;
            case ORIZ_3:
                mkBandieraH3(gc, colors);
                break;
            case TRIANG:
                mkBandieraT(gc, colors);
                break;
        }
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
    private void mkBandieraH2(GraphicsContext gc, Color[] colors) {
        gc.setFill(colors[0]);
        gc.fillRect(0, 0, 60, 21);
        gc.strokeRect(0, 0, 60, 21);
        gc.setFill(colors[1]);
        gc.fillRect(0, 21, 60, 42);
        gc.strokeRect(0, 21, 60, 42);
    }
    private void mkBandieraH3(GraphicsContext gc, Color[] colors) {
        gc.setFill(colors[0]);
        gc.fillRect(0, 0, 60, 14);
        gc.strokeRect(0, 0, 60, 14);
        gc.setFill(colors[1]);
        gc.fillRect(0, 14, 60, 28);
        gc.strokeRect(0, 14, 60, 28);
        gc.setFill(colors[2]);
        gc.fillRect(0, 28, 60, 42);
        gc.strokeRect(0, 28, 60, 42);
    }
    private void mkBandieraT(GraphicsContext gc, Color[] colors) {
        gc.setFill(colors[0]);
        gc.fillPolygon(new double[]{0, 60, 60, 20}, new double[]{0, 0, 21, 21}, 4);
        gc.strokePolygon(new double[]{0, 60, 60, 20}, new double[]{0, 0, 21, 21}, 4);
        gc.setFill(colors[1]);
        gc.fillPolygon(new double[]{20, 60, 60, 0}, new double[]{21, 21, 42, 42}, 4);
        gc.strokePolygon(new double[]{20, 60, 60, 0}, new double[]{21, 21, 42, 42}, 4);
        gc.setFill(colors[2]);
        gc.fillPolygon(new double[]{0, 20, 0}, new double[]{0, 21, 42}, 3);
        gc.strokePolygon(new double[]{0, 20, 0}, new double[]{0, 21, 42}, 3);
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