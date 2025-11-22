package lab4_1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

// autonomous class for the AddTwoNumbers.java exercise
public class AddHandlerAutonomous implements EventHandler<ActionEvent> {

    // fields (as constants)
    private final TextField nb1Input;
    private final TextField nb2Input;
    private final TextField resInput;

    // default constructor
    public AddHandlerAutonomous(TextField nb1Input, TextField nb2Input, TextField resInput) {
        this.nb1Input = nb1Input;
        this.nb2Input = nb2Input;
        this.resInput = resInput;
    }

    // handle function overriding
    @Override
    public void handle(ActionEvent e) {
        resInput.setText(computeAdditionWithTextField());
    }

    // compute function
    private String computeAdditionWithTextField() {
        try {
            // parse values
            double a = Double.parseDouble(nb1Input.getText());
            double b = Double.parseDouble(nb2Input.getText());

            // compute addition
            return String.valueOf(a + b);
        } 
        catch (NumberFormatException ex) {
            return "Invalid input";
        }
    }
}
