package it.unitn.prog.lab6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private final MyShape[][] shapes = new MyShape[8][8];
    private boolean xBool = false;
    private int x;

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                MyShape tmp = new MyShape(i, j);
                shapes[i][j] = tmp;
                root.add(tmp.getShape(), i, j);
            }
        }

        Scene scene = new Scene(root, 480, 480);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            switch (keyEvent.getCode()) {
                case C -> xBool = false;
                case R -> {
                    xBool = false;
                    for (MyShape[] myshapes : shapes) {
                        for (MyShape myshape : myshapes) {
                            myshape.resetColor();
                        }
                    }
                }
                default -> {
                    try {
                        int n = Integer.parseInt(keyEvent.getText());
                        if (n <= 7) {
                            if (xBool)
                                shapes[x][n].setColor();
                            else
                                x = n;
                            xBool = !xBool;
                        }
                    } catch (Exception ignored) {}
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("Esercitazione 6");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}