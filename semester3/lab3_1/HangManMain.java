package lab3_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HangManMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // building the base (semi circle)
        Arc base = new Arc();
        base.setCenterX(100); // 100 units right
        base.setCenterY(250); // 250 units down
        base.setRadiusX(50); // 50 units radius along the horizontal
        base.setRadiusY(20); // 20 units radius along the vertical
        base.setStartAngle(0); // initial angle = 0
        base.setLength(180); // fixed size
        base.setType(ArcType.OPEN); // no closure
        base.setStroke(Color.BLACK); // color
        base.setStrokeWidth(2); // 2 units wide
        base.setFill(Color.TRANSPARENT); // no internal color

        // main pole (100 units right, 50 units down (point A), 100 units right, 230 units down (point B))
        Line pole = new Line(100, 50, 100, 230);
        pole.setStrokeWidth(2);

        // horizontal bar (100 units right, 50 units down (point A), 200 units right, 50 units down (point B))
        Line topBar = new Line(100, 50, 200, 50);
        topBar.setStrokeWidth(2);

        // rope 
        Line rope = new Line(200, 50, 200, 80);
        rope.setStrokeWidth(2);

        // head using circle
        Circle head = new Circle(200, 100, 20);
        head.setStroke(Color.BLACK);
        head.setFill(Color.TRANSPARENT);
        head.setStrokeWidth(2);

        // body
        Line body = new Line(200, 120, 200, 180);
        body.setStrokeWidth(2);

        // arms
        Line leftArm = new Line(200, 140, 170, 110);
        leftArm.setStrokeWidth(2);
        Line rightArm = new Line(200, 140, 230, 110);
        rightArm.setStrokeWidth(2);

        // legs
        Line leftLeg = new Line(200, 180, 170, 220);
        leftLeg.setStrokeWidth(2);
        Line rightLeg = new Line(200, 180, 230, 220);
        rightLeg.setStrokeWidth(2);

        // append
        root.getChildren().addAll(base, pole, topBar, rope, head, body, leftArm, rightArm, leftLeg, rightLeg);

        // display
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Hang man");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

