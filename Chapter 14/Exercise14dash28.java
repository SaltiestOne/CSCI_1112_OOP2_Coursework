import javafx.application.*;

import java.util.Calendar; 
import java.util.GregorianCalendar;
import java.util.Random;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Exercise14dash28 extends Application {
	
	public void start(Stage clockStage) {
		
		ClockPane cronie = new ClockPane((new Random().nextInt(12)), ((new Random().nextInt(2)) * 30), 0);
		
		cronie.setSecondHandVisible(false);
		
		Scene scene = new Scene(cronie, 250, 200);
		
		clockStage.setTitle("Time");
		
		clockStage.setScene(scene);
		
		clockStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;
  private boolean hourHandVisible;
  private boolean minuteHandVisible;
  private boolean secondHandVisible;
  
  /** Construct a default clock with the current time*/
  public ClockPane() {
    setCurrentTime();
    this.hourHandVisible = true;
    this.minuteHandVisible = true;
    this.secondHandVisible = true;
  }

  /** Construct a clock with specified hour, minute, and second */
  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
    this.hourHandVisible = true;
    this.minuteHandVisible = true;
    this.secondHandVisible = true;
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
  
  public boolean getHourHandVisible() {
	  
	  return this.hourHandVisible;
  }
  
  public void setHourHandVisible(boolean visibility) {
	  
	  this.hourHandVisible = visibility;
	  
	  paintClock();
  }
  
public boolean getMinuteHandVisible() {
	  
	  return this.minuteHandVisible;
  }
  
  public void setMinuteHandVisible(boolean visibility) {
	  
	  this.minuteHandVisible = visibility;
	  
	  paintClock();
  }
  
public boolean getSecondHandVisible() {
	  
	  return this.secondHandVisible;
  }
  
  public void setSecondHandVisible(boolean visibility) {
	  
	  this.secondHandVisible = visibility;
	  
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
    double clockRadius = 
      Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
    double centerX = getWidth() / 2;
    double centerY = getHeight() / 2;

    // Draw circle
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.PURPLE);
    Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
    Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
    Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
    Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
    
    // Draw second hand
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * 
      Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength * 
      Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.BLUE);


    // Draw minute hand
	double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * 
      Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength * 
      Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    mLine.setStroke(Color.BLUE);

    
    // Draw hour hand
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength * 
      Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *
      Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.BLUE);
    
    getChildren().clear();  
    getChildren().addAll(circle, t1, t2, t3, t4);
    
    if (secondHandVisible) {
    	
    	getChildren().add(sLine);
    } else {}
    
    if (minuteHandVisible) {
    	
    	getChildren().add(mLine);
    } else {}
    
    if (hourHandVisible) {
    	
    	getChildren().add(hLine);
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