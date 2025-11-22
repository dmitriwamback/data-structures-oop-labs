package lab3_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DisplayClock extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a clock and a label
    ClockPane clock = new ClockPane();
    String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
    Label lblCurrentTime = new Label(timeString);

    // Place clock and label in border pane
    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(lblCurrentTime);
    BorderPane.setAlignment(lblCurrentTime, Pos.BOTTOM_CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 350, 350);
    primaryStage.setTitle("DisplayClock"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}