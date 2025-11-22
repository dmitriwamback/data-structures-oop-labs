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

public class Decrypt extends Application {
    
    TextField encryptedFileTextField, decryptedFileTextField;
    Label promptLabel, decryptedOutputLabel;
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

        // create the forum to enter the encrypted file
        encryptedFileTextField = new TextField("");
        promptLabel = new Label("Enter the encrypted file: ");
        promptLabel.setTextAlignment(TextAlignment.CENTER);
        promptLabel.setPrefWidth(150);
        promptLabel.setMinWidth(150);
        promptLabel.setMaxWidth(150);

        // create the forum to enter and create the decrypted file
        decryptedFileTextField = new TextField("");
        decryptedOutputLabel = new Label("Which file to decrypt to: ");
        decryptedOutputLabel.setPrefWidth(150);
        decryptedOutputLabel.setMinWidth(150);
        decryptedOutputLabel.setMaxWidth(150);

        // create encrypt button
        encryptButton = new Button("Decrypt");

        // set on action event using lambda expression
        encryptButton.setOnAction(e -> {
            decrypt();
        });

        // add the elements to their appropriate hbox
        promptBox.getChildren().add(promptLabel);
        promptBox.getChildren().add(encryptedFileTextField);
        outputBox.getChildren().add(decryptedOutputLabel);
        outputBox.getChildren().add(decryptedFileTextField);

        // add the hboxes and button to the grid pane
        pane.add(promptBox, 0, 0);
        pane.add(outputBox, 0, 1);
        pane.add(encryptButton, 0, 2);

        // create scene and present
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Decryptor");
        primaryStage.show();
    }

    private void decrypt() {
        // get source and target files
        File encryptedFileSrc = new File(encryptedFileTextField.getText());
        File decryptedFileDst = new File(decryptedFileTextField.getText());

        // check if the encrypted file doesn't exist
        if (!encryptedFileSrc.exists()) {
            System.out.println("encrypted file does not exist");
            return;
        }

        try (
            FileInputStream fileInputStream = new FileInputStream(encryptedFileSrc);
            FileOutputStream fileOutputStream = new FileOutputStream(decryptedFileDst)
        ) {
            int data;
            while ((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data - 10); // deduct 10 from each byte
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
