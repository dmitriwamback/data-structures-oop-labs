package lab6_1;

import java.io.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SalarySaver extends Application {

    // fields
    private GridPane pane;
    private static File salaryDataFile;
    private TextField salaryTextField;
    private Text salariesAddedText, salaryListText, instructionText;
    private int currentNumberOfSalaries = 0;
    private Button writeSalaryButton, readSalaryButton;
    
    @Override
    public void start(Stage primaryStage) throws IOException {

        // create pane
        pane = new GridPane();

        // align the gridpane and set a vertical gap
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);

        // create salary text field to input the salaries
        salaryTextField = new TextField();

        // create a button that saves the salary to a .dat file
        writeSalaryButton = new Button("Add salary");

        // action using lambda expression
        writeSalaryButton.setOnAction(e -> {
            // try-catch to prevent the program from crashing from integer parsing
            try {
                // parse salary from the textfield
                int salary = Integer.parseInt(salaryTextField.getText());

                // input validation checks
                if (salary >= 0) writeSalaryToFile(salary);
                else System.out.println("Salary cannot be negative");
            }
            catch (Exception ex) {
                System.out.println("Salary is not a number");
            }
        });

        // create done button
        readSalaryButton = new Button("Done");

        // action using lambda expression
        readSalaryButton.setOnAction(e -> {
            try {
                // retireve all the salaries saved in the .dat file
                ArrayList<Integer> salaries = retrieveSalaries();

                // check if there are not any salaries
                if (salaries.isEmpty()) {
                    salaryListText.setText("No salaries have been added");
                    return; // return if there are no salaries
                }

                // create the string for the list of salaries (e.g. 400, 550, 203, etc.)
                String salaryListAsString = "";

                // set up necessary variables
                int averageSalary = 0, 
                    salarySum = 0;

                // iterate through all the salaries
                for (int i = 0; i < salaries.size(); i++) {
                    // get the salary
                    int salary = salaries.get(i);

                    // check if the index is at the end, and if so don't put a comma
                    salaryListAsString += i == salaries.size()-1 ? salary+"" : salary+", ";

                    // add to the sum
                    salarySum += salary;
                }

                // compute the average salary
                averageSalary = salarySum / salaries.size();

                // compile all the information into a single string then set the salaryListText this
                String finalResult = "Salaries " + salaryListAsString + "\nCount: " + salaries.size() + "\nTotal: " + salarySum + "\nAverage: " + averageSalary;
                salaryListText.setText(finalResult);
            } 
            catch (IOException ex) {

            }
        });
        // create text objects for information
        salariesAddedText = new Text("No salaries added");
        salaryListText = new Text("");
        instructionText = new Text("Enter Salary: ");

        // add each element to the gridpane
        pane.add(instructionText, 0, 0);
        pane.add(salaryTextField, 0, 1);
        pane.add(writeSalaryButton, 0, 2);
        pane.add(salariesAddedText, 0, 3);
        pane.add(readSalaryButton, 0, 4);
        pane.add(salaryListText, 0, 5);

        // create scene and present
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Salary Saver");
        primaryStage.show();

        // debug: wipe all the values from the file for next usage
        new FileOutputStream(salaryDataFile).close();
    }

    private void writeSalaryToFile(int salary) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(salaryDataFile, true)) {

            // bit shifting to keep the value at 4 bits and have values greater than 255
            fileOutputStream.write((salary >> 24) & 0xFF);
            fileOutputStream.write((salary >> 16) & 0xFF);
            fileOutputStream.write((salary >> 8) & 0xFF);
            fileOutputStream.write(salary & 0xFF);

            // close the file output stream
            fileOutputStream.close();
        }

        currentNumberOfSalaries++;
        String salaryText = currentNumberOfSalaries == 1 ? "Salary" : "Salaries";
        salariesAddedText.setText(currentNumberOfSalaries + " " + salaryText + " added");
    }

    private ArrayList<Integer> retrieveSalaries() throws IOException {
        ArrayList<Integer> salaries = new ArrayList<>();

        // open dataInputStream
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(salaryDataFile))) {

            // check if there's something to be read
            while (dataInputStream.available() > 0) {
                // append the data to the salaries array list
                salaries.add(dataInputStream.readInt());
            }

            // close the data input stream
            dataInputStream.close();
        }

        // return the salaries
        return salaries;
    }

    public static void main(String[] args) {
        // open the salaries binary file
        salaryDataFile = new File("salaries.dat");

        // if that file doesn't exist, then create it programmatically
        if (!salaryDataFile.exists()) {
            try {
                salaryDataFile.createNewFile();
            } 
            catch (Exception e) { e.printStackTrace(); }
        }

        // start
        launch();
    }
}
