package it.unitn.prog.lab4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.Map;
import java.util.Random;

public class Main extends Application {
    private static final Random RNG = new Random();
    private final Shape[] shapes = new Shape[3];
    private Button bChangeColor;
    private Button bDirection;
    private int currentShape = 1;
    private int direction = 1;
    private static final Map<Integer, String> bSymbols = Map.of(1, "=>", -1, "<=");

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        setup();

        HBox figures = new HBox(shapes);
        figures.setAlignment(Pos.CENTER);
        root.setCenter(figures);

        HBox buttons = new HBox(bChangeColor, bDirection);
        buttons.setAlignment(Pos.CENTER);
        root.setBottom(buttons);

        bChangeColor.setOnAction(actionEvent -> {
            shapes[currentShape].setFill(Color.rgb(RNG.nextInt(256), RNG.nextInt(256), RNG.nextInt(256)));
            currentShape = (currentShape + (3 + direction)) % 3;
        });
        bDirection.setOnAction(actionEvent -> {
            direction = - direction;
            bDirection.setText(bSymbols.get(direction));
        });
        primaryStage.setTitle("Gioco");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Initializes the shapes array and the two buttons
     */
    private void setup() {
        shapes[0] = new Rectangle(60, 60);
        shapes[1] = new Circle(30);
        shapes[2] = new Polygon(0.0, 0.0, 60.0, 0.0, 30.0, 50.0);
        for (Shape shape : shapes) {
            shape.setFill(Color.WHITE);
            shape.setStroke(Color.BLACK);
        }

        bChangeColor = new Button("Cambia colore");
        bDirection = new Button(bSymbols.get(direction));
    }

    public static void main(String[] args) {
        launch(args);
    }
}