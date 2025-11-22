package lab5_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TrafficLight extends Application {

    @Override 
    public void start(Stage primaryStage) {

        // circles
        Circle redLight, yellowLight, greenLight;

        // initialize the circles
        redLight = new Circle();
        yellowLight = new Circle();
        greenLight = new Circle();

        // set default paramters for each light
        setLightSettings(redLight);
        setLightSettings(yellowLight);
        setLightSettings(greenLight);

        // create vbox and add all the lights
        VBox lights = new VBox(20, redLight, yellowLight, greenLight);
        lights.setAlignment(Pos.CENTER);

        // create radio buttons and toggle group
        RadioButton redRadioButton = new RadioButton("Red");
        RadioButton yellowRadioButton = new RadioButton("Yellow");
        RadioButton greenRadioButton = new RadioButton("Green");
        ToggleGroup group = new ToggleGroup();

        // set the toggle group
        redRadioButton.setToggleGroup(group);
        yellowRadioButton.setToggleGroup(group);
        greenRadioButton.setToggleGroup(group);

        // add actions to each radio button
        redRadioButton.setOnAction(e -> {
            redLight.setFill(Color.RED);
            yellowLight.setFill(Color.TRANSPARENT);
            greenLight.setFill(Color.TRANSPARENT);
        });
        yellowRadioButton.setOnAction(e -> {
            redLight.setFill(Color.TRANSPARENT);
            yellowLight.setFill(Color.YELLOW);
            greenLight.setFill(Color.TRANSPARENT);
        });
        greenRadioButton.setOnAction(e -> {
            redLight.setFill(Color.TRANSPARENT);
            yellowLight.setFill(Color.TRANSPARENT);
            greenLight.setFill(Color.GREEN);
        });

        // add all the radio buttons to an hbox
        HBox radioButtons = new HBox(10, redRadioButton, yellowRadioButton, greenRadioButton);
        radioButtons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20, lights, radioButtons);
        layout.setAlignment(Pos.CENTER);
        
        StackPane root = new StackPane(layout);
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Traffic Light");
        primaryStage.show();
    }

    private void setLightSettings(Circle light) {
        light.setRadius(30);
        light.setStroke(Color.BLACK);
        light.setStrokeWidth(2);
        light.setFill(Color.TRANSPARENT);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
