package lab3_1;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;


public class FontDemoMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new StackPane();

        Circle circle = new Circle();
        circle.setRadius(150);
        circle.setStroke(Color.RED);
        circle.setFill(new Color(1.0, 0.9, 0.7, 1.0));

        pane.getChildren().add(circle);

        Label label = new Label("Dmitri Wamback");
        label.setFont(Font.font("Courier New", FontWeight.MEDIUM, FontPosture.REGULAR, 30));
        pane.getChildren().add(label);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Lab3.1 - Font Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}