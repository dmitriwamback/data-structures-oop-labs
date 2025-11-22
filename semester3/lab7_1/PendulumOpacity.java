package lab7_1;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PendulumOpacity extends Application {
    private Timeline pendulumTimeline;

    private double horizonalRadius = 120;
    private double verticalRadius = 90;
    private double arcExtent = 140.0;

    private double maxAngle = 0.0;
    private double timeElapsed = 0.0;
    private double verticalOffset = 50.0;

    private Circle ball;
    private Pane pane;

    @Override
    public void start(Stage primaryStage) {
        pane = new Pane();

        int initialWidth = 400, initialHeight = 400;

        // set max angle
        maxAngle = Math.toRadians(arcExtent/2);

        // create arc
        Arc arc = new Arc(initialWidth, initialHeight, horizonalRadius, verticalRadius, 200, arcExtent);
        arc.centerXProperty().bind(pane.widthProperty().divide(2));
        arc.centerYProperty().bind(pane.heightProperty().divide(2).subtract(verticalOffset));
        arc.setStroke(Color.BLACK);
        arc.setFill(null);
        arc.setStrokeWidth(2);

        pane.getChildren().add(arc);

        // Pendulum ball
        ball = new Circle(0, initialHeight + verticalRadius, 10, Color.BLUE);
        pane.getChildren().add(ball);

        // create a timeline
        pendulumTimeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            updatePendulum();
        }));
        pendulumTimeline.setCycleCount(Animation.INDEFINITE);
        pendulumTimeline.play();

        // pause and resume events using lambda expression
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            pendulumTimeline.pause();
        });
        pane.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            pendulumTimeline.play();
        });

        // create and present scene
        Scene scene = new Scene(pane, initialWidth, initialHeight);
        primaryStage.setTitle("Pendulum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updatePendulum() {
        // animating the pendulum
        double angle = Math.sin(timeElapsed) * maxAngle; // make the angle swing between -maxAngle and maxAngle
        ball.setCenterX(pane.getWidth()/2 + horizonalRadius * Math.sin(angle)); // swing on the x axis
        ball.setCenterY(pane.getHeight()/2 - verticalOffset + verticalRadius * Math.cos(angle)); // swing onm the y axis

        double opacity = (Math.sin(timeElapsed * 3.0) + 1.0)/2.0;
        ball.setOpacity(opacity);

        timeElapsed += 0.025;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
