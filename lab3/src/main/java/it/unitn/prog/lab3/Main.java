package it.unitn.prog.lab3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane layout = new BorderPane();

        Button buttonGioca = new Button("Gioca");
        Button buttonCancella = new Button("Cancella");

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(buttonGioca, buttonCancella);

        Label label = new Label("Gioca!");
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);

        HBox figuresBox = new HBox();
        figuresBox.setAlignment(Pos.CENTER);
        Figure[] figures = new Figure[2];
        buttonGioca.setOnAction(actionEvent -> {
            Figure figure = new Figure();
            figures[figuresBox.getChildren().size()] = figure;
            figuresBox.getChildren().add(figure.shape);

            if (figuresBox.getChildren().size() >= 2) {
                if (figures[0].equals(figures[1]))
                    label.setText("Hai vinto!");
                else
                    label.setText("Hai perso!");
                buttonGioca.setDisable(true);
            }
        });
        buttonCancella.setOnAction(actionEvent -> {
            figuresBox.getChildren().clear();
            buttonGioca.setDisable(false);
            label.setText("Gioca!");
        });

        layout.setBottom(buttons);
        layout.setTop(label);
        layout.setCenter(figuresBox);

        primaryStage.setTitle("Gioco");
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}