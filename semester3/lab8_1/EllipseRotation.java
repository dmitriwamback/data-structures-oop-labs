package lab8_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class EllipseRotation extends Application {

    // fields
    private Label angleLabel;
    private TextField angleField;
    private int initialWidth, initialHeight;

    @Override
    public void start(Stage primaryStage) {

        // create pane
        Pane pane = new Pane();

        // set initial width and height for the pane
        initialWidth = 400;
        initialHeight = 200;
        
        // create ellipse
        Ellipse ellipse = new Ellipse(150, 100, 60, 40);
        angleField = new TextField("0");
        angleField.setMinWidth(40); 
        angleField.setMaxWidth(40);

        // create angle label
        angleLabel = new Label("Angle: ");
        angleLabel.setMinWidth(10);
        angleLabel.setAlignment(Pos.BASELINE_CENTER);

        // create rotate button
        Button button = new Button("Rotate");
        button.setLayoutX(130); 
        button.setLayoutY(10);

        // button functionality with lambda expression
        button.setOnAction(e -> {
            double angle = Double.parseDouble(angleField.getText());
            Rotate rotate = new Rotate(angle, ellipse.getCenterX(), ellipse.getCenterY());
            ellipse.getTransforms().add(rotate);
        });

        // hbox width and height
        int boxWidth = 200;
        int boxHeight = 20;

        // create hbox
        HBox box = new HBox();
        box.setSpacing(5);
        box.getChildren().addAll(angleLabel, angleField, button);
        box.setMaxWidth(boxWidth);
        box.setMinWidth(boxWidth);
        box.setMaxHeight(boxHeight);
        box.setMinHeight(boxHeight);

        // set x position
        box.setLayoutX((initialWidth - boxWidth) / 2.0);

        // add the ellipse and the hbox
        pane.getChildren().addAll(ellipse, box);

        // repositioning the hbox when the scene is rescaled
        pane.widthProperty().addListener((obs, previousValue, currentValue) -> {
            box.setLayoutX((currentValue.doubleValue() - boxWidth) / 2);
        });
        pane.heightProperty().addListener((obs, previousValue, currentValue) -> {
            box.setLayoutY((currentValue.doubleValue() - boxHeight) - 10);
        });

        primaryStage.setScene(new Scene(pane, initialWidth, initialHeight));
        primaryStage.setTitle("Ellipse Rotation");
        primaryStage.show();
    }

    public static void main(String[] args) { 
        launch(args); 
    }
}
