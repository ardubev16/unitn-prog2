package it.unitn.prog.lab5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.Random;

public class Main extends Application {
    private static final Random RNG = new Random();
    private int punti = 5;
    private final Text cCorrenteText = new Text("[]");
    private final Text cPescataText = new Text("[]");
    private final Button gioca = new Button("gioca");

    private Carta cCorrente;
    private VBox risultato;
    private boolean vinto = false;
    private final Text vintoText = new Text("Gioca!");
    private final Text puntiText = new Text(String.format("Punti: %d", punti));
    private final Comparator<Carta>[] comparators = new Comparator[]{new Carta.ComparatorBySeme(), new Carta.ComparatorByValore()};
    private final Text criterioText = new Text("Criterio: nessun criterio");

    @Override
    public void start(Stage primaryStage) {
        VBox cCorrenteBox = new VBox(new Text("Carta Corrente"), cCorrenteText);
        cCorrenteBox.setAlignment(Pos.CENTER);
        cCorrenteBox.setPadding(new Insets(25));

        VBox cPescataBox = new VBox(new Text("Carta Pescata"), cPescataText);
        cPescataBox.setAlignment(Pos.CENTER);
        cPescataBox.setPadding(new Insets(25));

        HBox carteBox = new HBox(cCorrenteBox, cPescataBox);
        carteBox.setAlignment(Pos.CENTER);

        risultato = new VBox(vintoText, puntiText, criterioText);
        risultato.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(gioca, Pos.CENTER);

        game();

        BorderPane root = new BorderPane();
        root.setTop(carteBox);
        root.setCenter(risultato);
        root.setBottom(gioca);

        primaryStage.setTitle("Pesca la carta!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void game() {
        Mazzo mazzo = new Mazzo();

        cCorrente = mazzo.pop();


        gioca.setOnAction(actionEvent -> {
            if (mazzo.size() > 0) {
                cCorrenteText.setText(cCorrente.toString());
                Carta cPescata = mazzo.pop();
                Comparator<Carta> criterio = comparators[RNG.nextInt(comparators.length)];
                criterioText.setText(String.format("Criterio: %s", criterio));
                cPescataText.setText(cPescata.toString());

                vinto = criterio.compare(cPescata, cCorrente) >= 0;
                vintoText.setText(vinto ? "Mano vinta" : "Mano persa");

                punti += vinto ? 1 : -1;
                puntiText.setText(String.format("Punti: %d", punti));

                cCorrente = cPescata;
            } else {
                risultato.getChildren().clear();
                risultato.getChildren().addAll(new Text("Mazzo finito!"), puntiText);
                gioca.setDisable(true);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}