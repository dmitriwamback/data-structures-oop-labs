package lab6_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CopyAsGUI extends Application {

    TextField fileTextField, noFilesTextField;
    Label enterFilesText, noFilesText;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create gridpane
        GridPane pane = new GridPane();

        // set alignements and v/hgaps
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);

        // hboxes for the 'enter file' and 'how many files you want to split into'
        HBox fileForum = new HBox(), noFilesForum = new HBox();
        fileForum.setSpacing(10);
        noFilesForum.setSpacing(10);

        // create the file input forum
        fileTextField = new TextField("");
        enterFilesText = new Label("Enter a file: ");
        enterFilesText.setTextAlignment(TextAlignment.CENTER);
        enterFilesText.setPrefWidth(200);
        enterFilesText.setMinWidth(200);
        enterFilesText.setMaxWidth(200);

        // create the split amount forum
        noFilesTextField = new TextField("");
        noFilesText = new Label("Specify the number of smaller files: ");
        noFilesText.setPrefWidth(200);
        noFilesText.setMinWidth(200);
        noFilesText.setMaxWidth(200);

        // create start button
        button = new Button("Start");

        // set the click event using lambda expression
        button.setOnAction(e -> {
            splitFile();
        });

        // add the elements to each individual forum
        fileForum.getChildren().add(enterFilesText);
        fileForum.getChildren().add(fileTextField);
        fileForum.setStyle(
            "-fx-alignment: center-left;"
        );
        noFilesForum.getChildren().add(noFilesText);
        noFilesForum.getChildren().add(noFilesTextField);
        noFilesForum.setStyle(
            "-fx-alignment: center-left;"
        );

        // add the forums and button to the grid pane
        pane.add(fileForum, 0, 0);
        pane.add(noFilesForum, 0, 1);
        pane.add(button, 0, 2);

        // create scene and present
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("File Splitter");
        primaryStage.show();
    }

    private void splitFile() {
        String sourceFileName = fileTextField.getText().trim();
        String numFilesStr = noFilesTextField.getText().trim();

        // check if the input is empty
        if (sourceFileName.isEmpty()) {
            System.out.println("enter a valid filename");
            return;
        }

        int numFiles;
        // input validation
        try {
            numFiles = Integer.parseInt(numFilesStr);
            if (numFiles <= 0) {
                System.out.println("number of files must be positive");
                return;
            }
        } 
        catch (NumberFormatException e) {
            System.out.println("invalid input");
            return;
        }

        // Check if source file exists
        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            System.out.println(sourceFileName + " does not exist");
            return;
        }

        try {
            // calculate the number of bytes per file
            long fileSize = sourceFile.length();
            long bytesPerFile = (long)Math.ceil((double) fileSize / numFiles);

            // create input stream
            try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile))) {
                
                // split the file into multiple parts
                for (int i = 0; i < numFiles; i++) {
                    // create the output name for each file
                    String outputFileName = sourceFileName + "." + (i+1);
                    File outputFile = new File(outputFileName);

                    // create buffered output stream to write the bytes
                    try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile))) {
                        
                        long bytesWritten = 0;
                        int byteRead;
                        
                        while (bytesWritten < bytesPerFile && (byteRead = input.read()) != -1) {
                            output.write((byte)byteRead);
                            bytesWritten++;
                        }
                    }
                }
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
