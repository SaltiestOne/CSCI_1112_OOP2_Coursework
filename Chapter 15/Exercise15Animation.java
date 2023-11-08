import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.control.Button;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class Exercise15Animation extends Application{

	public void start(Stage aniStage) throws Exception {

		Pane pane = new Pane();
		
		Scene scene = new Scene(pane, 400, 400);
		
		Polygon path = new Polygon();
	    
		path.setFill(Color.WHITE);
	    
	    path.setStroke(Color.WHITE);
	    
	    ObservableList<Double> list = path.getPoints();
	    
	    for (int i = 0; i < 5; i++) {
	    	
	      list.add((scene.getWidth() / 2) + (100 * Math.cos((Math.PI / 10) * ((4 * i) + 5)))); 
	      list.add((scene.getHeight() / 2) - (100 * Math.sin((Math.PI / 10) * ((4 * i) + 5))));
	    
	    }     
	    
	    Rectangle mover = new Rectangle(50, 20, Color.BLUEVIOLET);
	    
	    pane.getChildren().addAll(path, mover); 
	    
	    PathTransition pentaPath = new PathTransition(Duration.seconds(3), path, mover);
		
		pentaPath.setCycleCount(Timeline.INDEFINITE);
	
		pentaPath.setAutoReverse(false);
		
		pentaPath.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		
		pentaPath.play();
		
		mover.rotateProperty().addListener(ov ->
		{mover.setOpacity(new Random().nextDouble());
		});
		//pane.onMousePressedProperty().bind(pentaPath.statusProperty());
		pane.pressedProperty().addListener(ov ->
		{if (pentaPath.getStatus().equals(Animation.Status.RUNNING)) {
		
			pentaPath.pause();
		} else if (pentaPath.getStatus().equals(Animation.Status.PAUSED)) {
			pentaPath.play();
			} else {}});

		aniStage.setTitle("Choo choo");
		
		aniStage.setScene(scene);
		
		aniStage.show();

	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
