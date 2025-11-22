package lab7_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Halloween extends Application {

    @Override
    public void start(Stage primaryStage) {

        // create pane root
        Pane root = new Pane();
        root.setStyle("-fx-background-color: #161b5aff;");

        // create moon circle
        Circle moon = new Circle(100, 100, 55);
        moon.getStyleClass().add("moon");

        // create pumpkin circle
        Circle pumpkin = new Circle(240, 270, 90);
        pumpkin.getStyleClass().add("pumpkin");

        // create left eye (triangle)
        Path leftEye = new Path(
            new MoveTo(200, 245),
            new LineTo(215, 220),
            new LineTo(230, 245),
            new ClosePath()
        );
        leftEye.getStyleClass().add("eye");

        // create right eye (triangle)
        Path rightEye = new Path(
            new MoveTo(250, 245),
            new LineTo(265, 220),
            new LineTo(280, 245),
            new ClosePath()
        );
        rightEye.getStyleClass().add("eye");

        // create mouth (arc)
        Arc mouth = new Arc(240, 300, 55, 25, 200, 140);
        mouth.setType(ArcType.CHORD);
        mouth.getStyleClass().add("mouth");

        // create truck (line)
        Line trunk = new Line(440, 110, 440, 300);
        trunk.getStyleClass().add("trunk");

        // create branch 1
        Path branch1 = new Path(
            new MoveTo(440, 130),
            new LineTo(390, 120)
        );
        branch1.getStyleClass().add("branch");

        // create branch 2
        Path branch2 = new Path(
            new MoveTo(440, 130),
            new LineTo(470, 100)
        );
        branch2.getStyleClass().add("branch");

        // add all elements to the pane
        root.getChildren().addAll(moon, pumpkin, leftEye, rightEye, mouth, trunk, branch1, branch2);

        // create and present scene
        Scene scene = new Scene(root, 550, 400);
        // add stylesheet to the pane
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Halloween");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}