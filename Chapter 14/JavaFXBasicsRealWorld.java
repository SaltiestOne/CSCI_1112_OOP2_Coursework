import javafx.application.Application;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.scene.control.Label;



public class JavaFXBasicsRealWorld extends Application {
  @Override 
  public void start(Stage stopStage) {   

	FXOctogon actagan = new FXOctogon();
	
	Label stop = new Label("STOP");
	stop.setFont(new Font("Comic Sans", 88));
	stop.setTextFill(Color.WHITE);
	
	StackPane stacky = new StackPane(actagan, stop);
	
    Scene scene = new Scene(stacky, 400, 400);
   
    stopStage.setTitle("It's time to:");
    stopStage.setScene(scene);
    stopStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}

class FXOctogon extends Pane {
  private void paint() {
    // Create a polygon and place polygon to pane
    Polygon polygon = new Polygon();
    polygon.setFill(Color.RED);
    polygon.setStroke(Color.BLACK);
    ObservableList<Double> list = polygon.getPoints();
    
    double centerX = getWidth() / 2, centerY = getHeight() / 2;
    double radius = Math.min(getWidth(), getHeight()) * 0.4;

    // Add points to the polygon list
    for (int i = 0; i < 8; i++) {
      list.add(centerX + radius * Math.cos((Math.PI / 8) * ((2 * i) + 1))); 
      list.add(centerY - radius * Math.sin((Math.PI / 8) * ((2 * i) + 1)));
    }     
    
    getChildren().clear();
    getChildren().add(polygon); 
  }
  
  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    paint();
  }
  
  @Override
  public void setHeight(double height) {
    super.setHeight(height);
    paint();
  }
}
