package lab3_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;

public class TicTacToeMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Random rand = new Random();

        // Load images
        Image xImage = new Image(getClass().getResource("res/X.png").toExternalForm());
        Image oImage = new Image(getClass().getResource("res/O.png").toExternalForm());

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                int choice = rand.nextInt(3);

                ImageView cell = null;

                if (choice == 0) {
                    cell = new ImageView(xImage);
                } 
                else if (choice == 1) {
                    cell = new ImageView(oImage);
                }
                if (cell != null) {
                    cell.setFitWidth(60);
                    cell.setFitHeight(60);
                    grid.add(cell, col, row);
                }
            }
        }

        Scene scene = new Scene(grid, 200, 200);
        primaryStage.setTitle("Exercise14_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
