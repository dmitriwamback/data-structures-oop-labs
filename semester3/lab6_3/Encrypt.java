package lab6_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Encrypt extends Application {
    
    TextField enterFilePromptTextField, encryptedFileTextField;
    Label promptLabel, encryptedOutputLabel;
    Button encryptButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // create gridpane
        GridPane pane = new GridPane();

        // set alignments
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);

        // create hboxes for the prompt and output
        HBox promptBox = new HBox(), outputBox = new HBox();
        promptBox.setSpacing(10);
        outputBox.setSpacing(10);

        // create the forum to enter the unencrypted file
        enterFilePromptTextField = new TextField("");
        promptLabel = new Label("Enter a file: ");
        promptLabel.setTextAlignment(TextAlignment.CENTER);
        promptLabel.setPrefWidth(150);
        promptLabel.setMinWidth(150);
        promptLabel.setMaxWidth(150);

        // create the forum to enter the encrypted file
        encryptedFileTextField = new TextField("");
        encryptedOutputLabel = new Label("Which file to encrypt to: ");
        encryptedOutputLabel.setPrefWidth(150);
        encryptedOutputLabel.setMinWidth(150);
        encryptedOutputLabel.setMaxWidth(150);

        // create encrypt button
        encryptButton = new Button("Encrypt");

        // set on action event using lambda expression
        encryptButton.setOnAction(e -> {
            encrypt();
        });

        // add the elements to their appropriate hbox
        promptBox.getChildren().add(promptLabel);
        promptBox.getChildren().add(enterFilePromptTextField);
        outputBox.getChildren().add(encryptedOutputLabel);
        outputBox.getChildren().add(encryptedFileTextField);

        // add the hboxes and button to the grid pane
        pane.add(promptBox, 0, 0);
        pane.add(outputBox, 0, 1);
        pane.add(encryptButton, 0, 2);

        // create scene and present
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Encryptor");
        primaryStage.show();
    }

    private void encrypt() {
        // get source and target files
        File fileToEncrypt = new File(enterFilePromptTextField.getText());
        File encryptedFileDst = new File(encryptedFileTextField.getText());

        // check if the source file doesn't exist
        if (!fileToEncrypt.exists()) { 
            System.out.println("source file does not exist"); 
            return; 
        }

        // read the data and write it with a 10 byte offset
        try (FileInputStream fileInputStream = new FileInputStream(fileToEncrypt); 
             FileOutputStream fileOutputStream = new FileOutputStream(encryptedFileDst)) {

            int data;

            while ((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data + 10); // add 10 bytes
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
