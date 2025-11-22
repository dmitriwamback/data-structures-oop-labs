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
import javafx.stage.Stage;

public class EllipseScale extends Application {

    // fields
    private Label xLabel, yLabel;
    private TextField xField, yField;
    private int initialWidth, initialHeight;

    @Override
    public void start(Stage primaryStage) {

        // create pane
        Pane pane = new Pane();

        // initial width and height for the pane
        initialWidth = 400;
        initialHeight = 200;
        
        // create ellipse and the fields for the scale x and y
        Ellipse ellipse = new Ellipse(150, 100, 60, 40);
        xField = new TextField("0");
        yField = new TextField("0");
        xField.setMinWidth(40); 
        xField.setMaxWidth(40);
        yField.setMinWidth(40); 
        yField.setMaxWidth(40);

        // the labels for both the x and y scales
        xLabel = new Label("x:");
        yLabel = new Label("y: ");
        xLabel.setMinWidth(10);
        yLabel.setMinWidth(10);
        xLabel.setAlignment(Pos.BASELINE_CENTER);
        yLabel.setAlignment(Pos.BASELINE_CENTER);

        // create scale button
        Button button = new Button("Scale");
        button.setLayoutX(130); 
        button.setLayoutY(10);

        // button functionality with lambda expression
        button.setOnAction(e -> {
            double xScale = Double.parseDouble(xField.getText());
            double yScale = Double.parseDouble(yField.getText());
            ellipse.setScaleX(xScale);
            ellipse.setScaleY(yScale);
        });

        // hbox width and heigth
        int boxWidth = 200;
        int boxHeight = 20;

        // create hbox for the scaling parameters
        HBox box = new HBox();
        box.setSpacing(5);
        box.getChildren().addAll(xLabel, xField, yLabel, yField, button);
        box.setMaxWidth(boxWidth);
        box.setMinWidth(boxWidth);
        box.setMaxHeight(boxHeight);
        box.setMinHeight(boxHeight);

        // set x position
        box.setLayoutX((initialWidth - boxWidth) / 2.0);

        // add the ellipse and the hbox
        pane.getChildren().addAll(ellipse, box);

        // position the hbox with the screen size
        pane.widthProperty().addListener((obs, previousValue, currentValue) -> {
            box.setLayoutX((currentValue.doubleValue() - boxWidth) / 2);
        });
        pane.heightProperty().addListener((obs, previousValue, currentValue) -> {
            box.setLayoutY((currentValue.doubleValue() - boxHeight) - 10);
        });

        // create and present scene
        primaryStage.setScene(new Scene(pane, initialWidth, initialHeight));
        primaryStage.setTitle("Ellipse Scale");
        primaryStage.show();
    }

    public static void main(String[] args) { 
        launch(args); 
    }
}
