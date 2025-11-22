// Dmitri Wamback 2430480
package lab4_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleColor extends Application {

    @Override
    public void start(Stage primaryStage) {

        // create flow pane
        FlowPane pane = new FlowPane();
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);

        // create and add circle
        Circle circle = new Circle(100);
        circle.setFill(Color.RED);
        circle.setStrokeWidth(2);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        // set mouse pressed event
        pane.setOnMousePressed(e -> {
            circle.setFill(Color.GREEN);
        });

        // set mouse released event
        pane.setOnMouseReleased(e -> {
            circle.setFill(Color.RED);
        });

        // create and present scene
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Circle Color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
