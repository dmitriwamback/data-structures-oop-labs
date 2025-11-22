package lab4_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Calculator extends Application {

    // fields
    private TextField nb1Input = new TextField();
    private TextField nb2Input = new TextField();
    private TextField resInput = new TextField();

    @Override
    public void start(Stage primaryStage) {

        // create flowpane
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setAlignment(Pos.CENTER);

        // create labels for each number
        Label label1 = new Label("Number 1: ");
        Label label2 = new Label("Number 2: ");
        Label labelRes = new Label("Result: ");

        // set inputs' appropriate properties
        nb1Input.setPrefColumnCount(5);
        nb2Input.setPrefColumnCount(5);
        resInput.setPrefColumnCount(10);
        resInput.setEditable(false); // so the user cannot type in the result text field
        
        // add the contents
        flowPane.getChildren().addAll(label1, nb1Input, label2, nb2Input, labelRes, resInput);

        // create hbox
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);

        // create all buttons for each operation
        Button addButton = new Button("Add");
        Button subButton = new Button("Subtract");
        Button mulButton = new Button("Multiply");
        Button divButton = new Button("Divide");
        Button powButton = new Button("Power");

        // add the buttons to the hbox
        hbox.getChildren().addAll(addButton, subButton, mulButton, divButton, powButton);

        // apply all the functions to each button
        addButton.setOnAction(new OperationHandler(nb1Input, nb2Input, resInput, "add"));
        subButton.setOnAction(new OperationHandler(nb1Input, nb2Input, resInput, "sub"));
        mulButton.setOnAction(new OperationHandler(nb1Input, nb2Input, resInput, "mul"));
        divButton.setOnAction(new OperationHandler(nb1Input, nb2Input, resInput, "div"));
        powButton.setOnAction(new OperationHandler(nb1Input, nb2Input, resInput, "pow"));

        // create root
        BorderPane root = new BorderPane();
        root.setCenter(flowPane);
        root.setBottom(hbox);

        // create and present scene
        Scene scene = new Scene(root, 500, 150);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // autonomous class
    static class OperationHandler implements EventHandler<ActionEvent> {
        private final TextField nb1Input;
        private final TextField nb2Input;
        private final TextField resInput;
        private final String operation;

        // default constructor
        public OperationHandler(TextField nb1Input, TextField nb2Input, TextField resInput, String operation) {
            this.nb1Input = nb1Input;
            this.nb2Input = nb2Input;
            this.resInput = resInput;
            this.operation = operation;
        }

        @Override
        public void handle(ActionEvent event) {
            try {
                // parse values
                double a = Double.parseDouble(nb1Input.getText());
                double b = Double.parseDouble(nb2Input.getText());
                double result = 0.0;

                // add operation
                if (operation.equals("add")) {
                    result = a + b;
                }
                // subtract operation
                else if (operation.equals("sub")) {
                    result = a - b;
                }
                // multiply operation
                else if (operation.equals("mul")) {
                    result = a * b;
                }
                // divide operation
                else if (operation.equals("div")) {
                    if (b == 0) { // divide by zero
                        resInput.setText("Cannot divide by zero");
                        return;
                    }
                    else {
                        result = a / b;
                    }
                }
                // exponential operation
                else if (operation.equals("pow")) {
                    result = Math.pow(a, b);
                }
                resInput.setText(String.valueOf(result));
            } 
            catch (Exception e) {
                resInput.setText("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
