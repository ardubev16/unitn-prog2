package it.unitn.disi.prog2.Bevilacqua.esame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class Main extends Application {
    public static final List<Stato> stati = new LinkedList<>();

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
        ListaDatiStage(Stage primaryStage) {
            this.setTitle("Lista dei dati");
            this.setOnCloseRequest(windowEvent -> primaryStage.show());

            VBox listaDatiVbox = new VBox();
            listaDatiVbox.getChildren().addAll(stati);

            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(listaDatiVbox);

            Button buttonOrdinaPerStato = new Button("Ordina per stato");
            buttonOrdinaPerStato.setOnAction(actionEvent -> {
                stati.sort(new ComparaPerStato());
                listaDatiVbox.getChildren().clear();
                listaDatiVbox.getChildren().addAll(stati);
            });
            Button buttonOrdinaPerCapitale = new Button("Ordina per capitale");
            buttonOrdinaPerCapitale.setOnAction(actionEvent -> {
                stati.sort(new ComparaPerCapitale());
                listaDatiVbox.getChildren().clear();
                listaDatiVbox.getChildren().addAll(stati);
            });

            HBox buttons = new HBox(buttonOrdinaPerStato, buttonOrdinaPerCapitale);
            borderPane.setBottom(buttons);
            this.setScene(new Scene(borderPane));
        }
    }

    private static class GiocaStage extends Stage {
        GiocaStage(Stage primaryStage, Parent parent) {
            this.setTitle("Gioca!");
            this.setOnCloseRequest(windowEvent -> primaryStage.show());
            this.setScene(new Scene(parent));
        }
    }

    @Override
    public void start(Stage primaryStage) {
        initStates();
        Stage listaDatiStage = new ListaDatiStage(primaryStage);
//        Stage giocaStage = new GiocaStage(primaryStage);

        Button buttonMostra = new Button("Mostra Tutto");
        buttonMostra.setOnAction(actionEvent -> listaDatiStage.show());

        Button buttonGioca = new Button("Gioca!");
//        buttonGioca.setOnAction(actionEvent -> giocaStage.show());

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