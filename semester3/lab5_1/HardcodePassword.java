package lab5_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HardcodePassword extends Application {

    private final String[] usernames = {"JohnDoe", "JohnSmith"};
    private final String[] passwords = {"HelloWorld1", "Montreal$2023"};

    @Override
    public void start(Stage primaryStage) {

        // create gridpane
        GridPane root = new GridPane();

        // set h and vgaps and alignment
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);

        // create username and password labels
        Label usernameLabel = new Label("Input username: ");
        Label passwordLabel = new Label("Input password: ");

        // create username and password textfields
        TextField usernameTextField = new TextField();
        TextField passwordTextField = new TextField();

        // set max size
        usernameTextField.setMaxWidth(150);
        passwordTextField.setMaxWidth(150);

        // create login button
        Button loginButton = new Button("Login");

        // create extra labels (notice = general instructions, formInput = display username/password, confirmation = success/failure)
        Label notice = new Label("Enter your username and password");
        Label formInput = new Label();
        Label confirmation = new Label();

        // set max size and wraptext for formInput and confirmation
        formInput.setMaxWidth(250);
        formInput.setWrapText(true);
        confirmation.setMaxWidth(250);    

        // create stackpane for each label
        StackPane noticeStack = new StackPane(notice);
        StackPane confirmationStack = new StackPane(confirmation);
        StackPane formInputStack = new StackPane(formInput);
        
        // add stack panes
        root.add(noticeStack, 0, 0);
        GridPane.setColumnSpan(noticeStack, 3);
        noticeStack.setAlignment(Pos.CENTER);

        root.add(formInputStack, 0, 4);
        GridPane.setColumnSpan(formInputStack, 3);
        formInputStack.setAlignment(Pos.CENTER);

        root.add(confirmationStack, 0, 5);
        GridPane.setColumnSpan(confirmationStack, 3);
        confirmationStack.setAlignment(Pos.CENTER);

        // add username/password forms
        root.add(usernameLabel, 1, 1);
        root.add(passwordLabel, 1, 2);

        root.add(usernameTextField, 2, 1);
        root.add(passwordTextField, 2, 2);

        // add login button
        root.add(loginButton, 2, 3);

        // use lambda expression to add button press action
        loginButton.setOnAction(e -> {

            // get username/password
            String userName = usernameTextField.getText();
            String passWord = passwordTextField.getText();

            // for loop to check if a username and password exists and are at the same index
            boolean verified = false;
            for (int i = 0; i < usernames.length; i++) {
                if (usernames[i].equals(userName) && passwords[i].equals(passWord)) {
                    verified = true;
                    break;
                }
            }

            // verification string if the user has successfully authenticated
            String verification = verified ? "Successfully logged in" : "Failed to login";

            // set text
            formInput.setText("Username = " + usernameTextField.getText() + ", Password = " + passwordTextField.getText());
            confirmation.setText(verification);
        });

        // create scene and present
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Hard Code");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
