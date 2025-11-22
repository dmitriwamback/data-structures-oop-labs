package lab3_2;

import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;
  
  /** Construct a default clock with the current time*/
  public ClockPane() {
    setCurrentTime();
  }

  /** Construct a clock with specified hour, minute, and second */
  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  /** Return hour */
  public int getHour() {
    return hour;
  }

  /** Set a new hour */
  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }

  /** Return minute */
  public int getMinute() {
    return minute;
  }

  /** Set a new minute */
  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }

  /** Return second */
  public int getSecond() {
    return second;
  }

  /** Set a new second */
  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }
  
  /* Set the current time for the clock */
  public void setCurrentTime() {
    // Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();

    // Set current hour, minute and second
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
    
    paintClock(); // Repaint the clock
  }
  
  /** Paint the clock */
  private void paintClock() {
    // Initialize clock parameters
    double clockRadius = Math.min(this.getWidth(), this.getHeight()) * 0.8 * 0.5;
    double centerX = getWidth() / 2;
    double centerY = getHeight() / 2;

    // Draw circle
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    circle.setStrokeWidth(3);

    
    // Draw second hand
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.RED);

    // Draw minute hand
    //The x-coordinate is: x = r * sin(θ)
    //The y-coordinate is: y = r * cos(θ)
    //2 * Math.PI / 60 → converts 1 minute into radians (since a full circle = 2π radians).
    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    mLine.setStroke(Color.BLUE);
    
    // Draw hour hand
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);
    
    getChildren().clear(); // Clear the pane

    double maxAngle = 2 * Math.PI;
    int minutes = 60, hours = 12;

    getChildren().addAll(circle, sLine, mLine, hLine);

    // minute ticks
    for (int i = 0; i < minutes; i++) {
        // map [0, 60] to [0, 2pi] to get the angle
        double angle = (maxAngle/minutes) * (double)i;

        double cosA = Math.cos(angle), sinA = Math.sin(angle);

        // points on the radius of the clock
        double xToRadius = cosA * clockRadius,
               yToRadius = sinA * clockRadius,
               
               // how far in wards to extend the minute ticks
               xToCenter = cosA * (clockRadius - 4.0),
               yToCenter = sinA * (clockRadius - 4.0);

        Line l = new Line(centerX + xToRadius, centerY + yToRadius, centerX + xToCenter, centerY + yToCenter);
        getChildren().add(l);
    }

    // hour ticks
    for (int i = 0; i < hours; i++) {
        
        // map [0, 12] to [0, 2pi] to get the angle
        double angle = (maxAngle/hours) * (double)i;

        double cosA = Math.cos(angle), sinA = Math.sin(angle);

        // points on the radius of the clock
        double xToRadius = cosA * clockRadius,
               yToRadius = sinA * clockRadius,
               
               // how far to extend the hour ticks
               xToCenter = cosA * (clockRadius - 12.0),
               yToCenter = sinA * (clockRadius - 12.0),
               
               // where to place the hour label (1-12)
               hourLabelX = cosA * (clockRadius - 25.0),
               hourLabelY = sinA * (clockRadius - 25.0);

        // create line
        Line l = new Line(centerX + xToRadius, centerY + yToRadius, centerX + xToCenter, centerY + yToCenter);
        l.setStrokeWidth(2);

        // offset by 2, then mod 12 to get to [0, 11] then add one to get to [1, 12]
        int currentHour = (i+2) % 12 + 1;

        // create text for the hour at the desired spot
        Text t = new Text(centerX + hourLabelX, centerY + hourLabelY, Integer.toString(currentHour));

        Bounds bounds = t.getLayoutBounds();
        double textWidth = bounds.getWidth();
        double textHeight = bounds.getHeight();

        // center the text label afterwards
        double cx = centerX + hourLabelX;
        double cy = centerY + hourLabelY;

        t.setX(cx - textWidth / 2);
        t.setY(cy + textHeight / 4);

        getChildren().add(l);
        getChildren().add(t);
    }
  }
  
  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paintClock();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paintClock();
  }
}