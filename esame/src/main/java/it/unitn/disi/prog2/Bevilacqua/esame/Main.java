package it.unitn.disi.prog2.Bevilacqua.esame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main extends Application {
    public static final List<Stato> stati = new LinkedList<>();
    public static final Random RNG = new Random();

    void initStates() {
        stati.add(new Stato("Algeria", "Algiers", Stato.TipoBandiera.VERT_2, new Color[]{Color.GREEN, Color.WHITE}));
        stati.add(new Stato("Armenia","Yerevan", Stato.TipoBandiera.ORIZ_3, new Color[]{Color.RED, Color.BLUE, Color.ORANGE}));
        stati.add(new Stato("Chad","N'Djamena", Stato.TipoBandiera.VERT_3, new Color[]{Color.BLUE, Color.YELLOW, Color.RED}));
        stati.add(new Stato("Czech Republic","Prague", Stato.TipoBandiera.TRIANG, new Color[]{Color.WHITE, Color.RED, Color.BLUE}));
        stati.add(new Stato("Djibouti","Djibouti", Stato.TipoBandiera.TRIANG, new Color[]{Color.CYAN, Color.GREEN, Color.WHITE}));
        stati.add(new Stato("Gabon","Libreville", Stato.TipoBandiera.VERT_3, new Color[]{Color.GREEN, Color.YELLOW, Color.BLUE}));
        stati.add(new Stato("Indonesia","Jakarta", Stato.TipoBandiera.ORIZ_2, new Color[]{Color.RED, Color.WHITE}));
        stati.add(new Stato("Lithuania","Vilnius", Stato.TipoBandiera.ORIZ_3, new Color[]{Color.YELLOW, Color.GREEN, Color.RED}));
        stati.add(new Stato("Malta","La Valletta", Stato.TipoBandiera.VERT_2, new Color[]{Color.WHITE, Color.RED}));
        stati.add(new Stato("Ukraine","Kiev", Stato.TipoBandiera.ORIZ_2, new Color[]{Color.BLUE, Color.YELLOW}));
    }

    private static class ListaDatiStage extends Stage {
        private final GridPane listaDatiGrid = new GridPane();
        ListaDatiStage(Stage primaryStage) {
            this.setTitle("Lista dei dati");
            this.setOnCloseRequest(windowEvent -> primaryStage.show());

            setGrid();

            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(listaDatiGrid);

            Button buttonOrdinaPerStato = new Button("Ordina per stato");
            buttonOrdinaPerStato.setOnAction(actionEvent -> {
                stati.sort(new ComparaPerStato());
                setGrid();
            });
            Button buttonOrdinaPerCapitale = new Button("Ordina per capitale");
            buttonOrdinaPerCapitale.setOnAction(actionEvent -> {
                stati.sort(new ComparaPerCapitale());
                setGrid();
            });

            HBox buttons = new HBox(buttonOrdinaPerStato, buttonOrdinaPerCapitale);
            buttons.setAlignment(Pos.CENTER);
            borderPane.setBottom(buttons);
            this.setScene(new Scene(borderPane));
        }

        void setGrid() {
            listaDatiGrid.getChildren().clear();
            for (int i = 0; i< Main.stati.size(); i++) {
                listaDatiGrid.add(Main.stati.get(i).getBandiera(), 0, i);
                listaDatiGrid.add(new Text(Main.stati.get(i).getNomeStato()), 1, i);
                listaDatiGrid.add(new Text(Main.stati.get(i).getCapitale()), 2, i);
            }
        }
    }

    private static class GiocaStage extends Stage {
        private final GridPane grid = new GridPane();
        private final List<Pair<Stato, TextField>> statiGioco = new LinkedList<>();

        GiocaStage(Stage primaryStage) {
            this.setTitle("Gioca!");
            this.setOnCloseRequest(windowEvent -> primaryStage.show());
            this.setScene(new Scene(grid));
        }

        public void initGioca() {
            int[] rns = RNG.ints(0, stati.size()).distinct().limit(3).toArray();
            statiGioco.clear();
            grid.getChildren().clear();
            for (int n : rns) {
                statiGioco.add(new Pair<>(stati.get(n), new TextField()));
            }
            for (int i=0; i<statiGioco.size(); i++) {
                grid.add(statiGioco.get(i).getKey().getBandiera(), 0, i);
                grid.add(statiGioco.get(i).getValue(), 1, i);
                grid.add(new Text(i+1 + ": " + statiGioco.get(i).getKey().getCapitale()), 0, i+3);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        initStates();
        ListaDatiStage listaDatiStage = new ListaDatiStage(primaryStage);
        GiocaStage giocaStage = new GiocaStage(primaryStage);

        Button buttonMostra = new Button("Mostra Tutto");
        buttonMostra.setOnAction(actionEvent -> {
            giocaStage.close();
            listaDatiStage.show();
            listaDatiStage.setGrid();
        });

        Button buttonGioca = new Button("Gioca!");
        buttonGioca.setOnAction(actionEvent -> {
            listaDatiStage.close();
            giocaStage.show();
            giocaStage.initGioca();
        });

        VBox primaryVBox = new VBox(buttonMostra, buttonGioca);
        primaryVBox.setAlignment(Pos.CENTER);

        primaryStage.setTitle("Lorenzo Bevilacqua");
        primaryStage.setScene(new Scene(primaryVBox));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}