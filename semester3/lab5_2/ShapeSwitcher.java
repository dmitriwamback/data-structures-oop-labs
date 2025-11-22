package lab5_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class ShapeSwitcher extends Application {

    private Shape shape;
    private Color fill;
    
    @Override
    public void start(Stage primaryStage) {

        // stack pane
        StackPane pane = new StackPane();

        // default fill
        fill = Color.TRANSPARENT;

        // create circle shape
        shape = new Circle(150);
        shape.setFill(Color.TRANSPARENT);
        shape.setStroke(Color.BLACK);

        // create hbox and align it to the bottom center
        HBox bar = new HBox();
        bar.setAlignment(Pos.BOTTOM_CENTER);

        // create radio buttons
        RadioButton circleRadioButton = new RadioButton("Circle"),
                    squareRadioButton = new RadioButton("Square"),
                    ellipseRadioButton = new RadioButton("Ellipse"),
                    fillRadioButton = new RadioButton("Fill");

        // set up toggle group for all radio buttons but for the fill radio button
        ToggleGroup toggleGroup = new ToggleGroup();
        circleRadioButton.setToggleGroup(toggleGroup);
        squareRadioButton.setToggleGroup(toggleGroup);
        ellipseRadioButton.setToggleGroup(toggleGroup);

        // add functionality to each
        circleRadioButton.setOnAction(e -> {
            pane.getChildren().remove(1);
            shape = new Circle(150);
            setFill(shape);
            pane.getChildren().add(shape);
        });
        squareRadioButton.setOnAction(e -> {
            pane.getChildren().remove(1);
            shape = new Rectangle(200, 200);
            setFill(shape);
            pane.getChildren().add(shape);
        });
        ellipseRadioButton.setOnAction(e -> {
            pane.getChildren().remove(1);
            shape = new Ellipse(150, 100);
            setFill(shape);
            pane.getChildren().add(shape);
        });
        fillRadioButton.setOnAction(e -> {
            fill = fill == Color.TRANSPARENT ? Color.BLACK : Color.TRANSPARENT;
            shape.setFill(fill);
        });

        // add each radio button to the hbox
        bar.getChildren().addAll(circleRadioButton, squareRadioButton, ellipseRadioButton, fillRadioButton);

        // add the bar and the shape
        pane.getChildren().add(bar);
        pane.getChildren().add(shape);

        // create and present scene
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("hello");
        primaryStage.show();
    }

    private void setFill(Shape shape) {
        shape.setFill(fill);
        shape.setStroke(Color.BLACK);
    }

    public static void main(String[] args) {
        launch();
    }
}
