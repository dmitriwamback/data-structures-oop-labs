// Dmitri Wamback 2430480
package lab4_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MouseInRectangle extends Application {
    @Override
    public void start(Stage primaryStage) {

        // create pane
        Pane pane = new Pane();

        // positions and scales
        double rectCenterX = 80;
        double rectCenterY = 50;
        double rectWidth = 100;
        double rectHeight = 30;

        // create rectangle
        Rectangle rectangle = new Rectangle(
                rectCenterX - rectWidth / 2,
                rectCenterY - rectHeight / 2,
                rectWidth, rectHeight
        );
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);

        // create empty label
        Label label = new Label("");
        label.setLayoutY(10);
        label.setLayoutX(10);

        // add everything to the pane
        pane.getChildren().addAll(rectangle, label);

        // add functionality
        pane.setOnMouseMoved(e -> {
            if (rectangle.getBoundsInParent().contains(e.getX(), e.getY())) {
                label.setText("Mouse point is inside the rectangle");
            } else {
                label.setText("Mouse point is outside the rectangle");
            }
        });

        // create and present scene
        Scene scene = new Scene(pane, 300, 150);
        primaryStage.setTitle("Mouse in rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
