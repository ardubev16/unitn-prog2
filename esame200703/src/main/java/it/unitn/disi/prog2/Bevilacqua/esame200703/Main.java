package it.unitn.disi.prog2.Bevilacqua.esame200703;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class Main extends Application {
    private final List<Piastrella> piastrelle = new LinkedList<>();
    private int piastrelleIndex = 0;
    private final HBox root = new HBox();
    private final VBox righthandBox = new VBox();
    private final Button prev = new Button("<prev");
    private final Button next = new Button("next>");
    private void initPiastrelle() {
        piastrelle.add(new Piastrella("P1", 50, 50, "ceramica", false));
        piastrelle.add(new Piastrella("P2", 80, 20, "laminato", true));
        piastrelle.add(new Piastrella("P3", 40, 50, "terracotta", true));
        piastrelle.add(new PiastrellaBicolore("B1", 40, 100, "laminato", false, PiastrellaBicolore.FormaInterna.QUADRATO));
        piastrelle.add(new PiastrellaBicolore("B2", 90, 120, "ceramica", true, PiastrellaBicolore.FormaInterna.CERCHIO));
        piastrelle.add(new PiastrellaBicolore("B3", 50, 140, "terracotta", true, PiastrellaBicolore.FormaInterna.QUADRATO));

        righthandBox.getChildren().add(new Text(piastrelle.get(0).toString()));
        root.getChildren().add(righthandBox);
        root.getChildren().add(piastrelle.get(0).getFigura());
    }

    private void showPiastrella() {
        righthandBox.getChildren().set(0, new Text(piastrelle.get(piastrelleIndex).toString()));
        root.getChildren().set(0, righthandBox);
        root.getChildren().set(1, piastrelle.get(piastrelleIndex).getFigura());

        prev.setDisable(piastrelleIndex <= 0);
        next.setDisable(piastrelleIndex >= piastrelle.size()-1);
    }

    @Override
    public void start(Stage primaryStage) {
        initPiastrelle();
        showPiastrella();

        prev.setOnAction(actionEvent -> {
            piastrelleIndex--;
            showPiastrella();
        });

        next.setOnAction(actionEvent -> {
            piastrelleIndex++;
            showPiastrella();
        });

        HBox buttons = new HBox(prev, next);
        buttons.setPadding(new Insets(10));

        righthandBox.getChildren().add(buttons);
        righthandBox.setAlignment(Pos.CENTER);
        righthandBox.setPadding(new Insets(20));

        root.setAlignment(Pos.CENTER);

        primaryStage.setTitle("Catalogo Piastrelle");
        primaryStage.setScene(new Scene(root, 300, 180));
        primaryStage.show();
}

    public static void main(String[] args) {
        launch(args);
    }
}