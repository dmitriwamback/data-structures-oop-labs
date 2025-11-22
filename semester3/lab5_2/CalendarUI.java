package lab5_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.DayOfWeek;

public class CalendarUI extends Application {
    private YearMonth currentYearMonth;
    private GridPane pane;
    private Label monthYearLabel;

    public void start(Stage primaryStage) {

        // create gridpane
        pane = new GridPane();
        pane.setHgap(40);
        pane.setVgap(20);

        // get the current year and the month
        currentYearMonth = YearMonth.now();
        monthYearLabel = new Label(); // create its label

        // create root
        BorderPane root = new BorderPane();
        root.setTop(monthYearLabel);
        BorderPane.setAlignment(monthYearLabel, Pos.CENTER);

        // create prior and next button
        Button priorButton = new Button("Prior");
        Button nextButton = new Button("Next");
        
        // set actions using lambda
        priorButton.setOnAction(e -> {
            currentYearMonth = currentYearMonth.minusMonths(1);
            updateCalendar();
        });
        nextButton.setOnAction(e -> {
            currentYearMonth = currentYearMonth.plusMonths(1);
            updateCalendar();
        });

        // create borderpane for the prior and next button
        BorderPane buttonPane = new BorderPane();
        buttonPane.setLeft(priorButton);
        buttonPane.setRight(nextButton);
        root.setBottom(buttonPane);

        root.setCenter(pane);
        updateCalendar();

        Scene scene = new Scene(root, 400, 300);

        // resize hgap
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            double gap = newVal.doubleValue() / 10.0;
            pane.setHgap(gap);
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calendar UI");
        primaryStage.show();
    }

    private void updateCalendar() {

        // clear the grid pane
        pane.getChildren().clear();

        // set the name of the month and the year
        monthYearLabel.setText(currentYearMonth.getMonth() + " " + currentYearMonth.getYear());

        // get days of the week
        DayOfWeek[] daysOfWeek = DayOfWeek.values();

        // iterate 7 times and add a day as a label
        for (int i = 0; i < 7; i++) {
            Label dayLabel = new Label(daysOfWeek[i].toString().substring(0, 3));
            dayLabel.setFont(new Font(14));
            pane.add(dayLabel, i, 0);
        }

        // get the current month and its start date and the number of days in the month
        LocalDate firstOfMonth = currentYearMonth.atDay(1);
        int startDay = firstOfMonth.getDayOfWeek().getValue() % 7; // start day = index of current month's first day
        int daysInMonth = currentYearMonth.lengthOfMonth();

        // get the previous month's days and number of days
        YearMonth prevMonth = currentYearMonth.minusMonths(1);
        int daysInPrevMonth = prevMonth.lengthOfMonth();

        // color the previous month's day in gray
        int dayCounter = 1;
        for (int i = 0; i < startDay; i++) {
            Label dayLabel = new Label(Integer.toString(daysInPrevMonth - startDay + i + 1));
            dayLabel.setTextFill(Color.LIGHTGRAY);
            pane.add(dayLabel, i, 1);
        }

        // color the current month's day in black
        int col = startDay;
        int row = 1;
        for (int day = 1; day <= daysInMonth; day++) {
            Label dayLabel = new Label(Integer.toString(day));
            dayLabel.setTextFill(Color.BLACK);
            pane.add(dayLabel, col, row);

            col++;
            if (col > 6) {
                col = 0;
                row++;
            }
        }

        // color the next month's days in gray
        dayCounter = 1;
        while (col <= 6) {
            Label dayLabel = new Label(Integer.toString(dayCounter++));
            dayLabel.setTextFill(Color.LIGHTGRAY);
            pane.add(dayLabel, col, row);
            col++;
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
