package lab4_1;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddTwoNumbers extends Application {

    // fields for the inner class 
    TextField nb1Input;
    TextField nb2Input;
    TextField resInput;

    // the start method
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        GridPane pane = new GridPane();

        pane.setHgap(10);
        pane.setVgap(10);

        // center the grid
        pane.setAlignment(Pos.CENTER);

        // create labels for the numbers
        Label nb1 = new Label("Number 1");
        Label nb2 = new Label("Number 2");
        Label res = new Label("Result");

        // initialize each text field
        nb1Input = new TextField("");
        nb2Input = new TextField("");
        resInput = new TextField("");
        resInput.setEditable(false); // so the user cannot type in the result text field

        // create add button
        Button calculateButton = new Button("Add");

        // inner class
        calculateButton.setOnAction(new AddHandler());
        

        // autonomous class
        //calculateButton.setOnAction(new AddHandlerAutonomous(nb1Input, nb2Input, resInput));


        // lambda
        /*
        calculateButton.setOnAction(e -> {
            resInput.setText(computeAdditionWithTextField());
        });
        */
        
        // set appropriate input size (as a single function to not clutter the code)
        setTextFieldSize(nb1Input);
        setTextFieldSize(nb2Input);
        setTextFieldSize(resInput);

        // add the labels
        pane.add(nb1, 0, 0);
        pane.add(nb2, 0, 1);
        pane.add(res, 0, 2);

        // add the inputs
        pane.add(nb1Input, 1, 0);
        pane.add(nb2Input, 1, 1);
        pane.add(resInput, 1, 2);

        // add the calculate button
        pane.add(calculateButton, 1, 3);

        // create scene and present
        Scene scene = new Scene(pane, 350, 350);
        primaryStage.setTitle("Add Two Numbers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // independent function that sets the appropriate property values to a text field
    private void setTextFieldSize(TextField textField) {
        textField.setPrefColumnCount(2);
        textField.setPrefWidth(100);
        textField.setMinWidth(60);
        textField.setMaxWidth(100);
    }

    // function to compute the addition 
    private String computeAdditionWithTextField() {

        // get input
        String nb1InputText = nb1Input.getText();
        String nb2InputText = nb2Input.getText();

        // use try-catch to avoid casting errors
        try {
            // cast the string to a double
            double num1 = Double.parseDouble(nb1InputText),
                   num2 = Double.parseDouble(nb2InputText);

            // compute addition as a string
            return String.valueOf(num1 + num2);
        } 
        catch (Exception exc) {
            // yield error message if any input is wrong
            return "Invalid input";
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }


    // inner class
    private class AddHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            resInput.setText(computeAdditionWithTextField());
        }
    }
}
