package lab8_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleTranslate extends Application {

    // fields
    private Label xLabel, yLabel;
    private TextField xField, yField;
    private int initialWidth, initialHeight;

    @Override
    public void start(Stage primaryStage) {

        // create pane
        Pane pane = new Pane();

        // set initial width and height for the pane
        initialWidth = 400;
        initialHeight = 200;
        
        // create rectangle
        Rectangle rect = new Rectangle(40, 40, 50, 40);

        // create translation parameters
        xField = new TextField("0");
        yField = new TextField("0");
        xField.setMinWidth(40); 
        xField.setMaxWidth(40);
        yField.setMinWidth(40); 
        yField.setMaxWidth(40);

        // create translation parameter labels
        xLabel = new Label("x:");
        yLabel = new Label("y: ");
        xLabel.setMinWidth(10);
        yLabel.setMinWidth(10);
        xLabel.setAlignment(Pos.BASELINE_CENTER);
        yLabel.setAlignment(Pos.BASELINE_CENTER);

        // create translate button
        Button button = new Button("Translate");
        button.setLayoutX(130); 
        button.setLayoutY(10);

        // button functionality with lambda functionality
        button.setOnAction(e -> {
            double xTranslate = Double.parseDouble(xField.getText());
            double yTranslate = Double.parseDouble(yField.getText());
            rect.setTranslateX(xTranslate);
            rect.setTranslateY(yTranslate);
        });

        // hbox width and height
        int boxWidth = 200;
        int boxHeight = 20;

        // create hbox for the parameters
        HBox box = new HBox();
        box.setSpacing(5);
        box.getChildren().addAll(xLabel, xField, yLabel, yField, button);
        box.setMaxWidth(boxWidth);
        box.setMinWidth(boxWidth);
        box.setMaxHeight(boxHeight);
        box.setMinHeight(boxHeight);

        // set the x position for the hbox
        box.setLayoutX((initialWidth - boxWidth) / 2.0);

        // add the rectangle and the hbox
        pane.getChildren().addAll(rect, box);

        // center the hbox to the bottom when the pane is resized
        pane.widthProperty().addListener((obs, previousValue, currentValue) -> {
            box.setLayoutX((currentValue.doubleValue() - boxWidth) / 2);
        });
        pane.heightProperty().addListener((obs, previousValue, currentValue) -> {
            box.setLayoutY((currentValue.doubleValue() - boxHeight) - 10);
        });

        primaryStage.setScene(new Scene(pane, initialWidth, initialHeight));
        primaryStage.show();
    }

    public static void main(String[] args) { 
        launch(args); 
    }
}
