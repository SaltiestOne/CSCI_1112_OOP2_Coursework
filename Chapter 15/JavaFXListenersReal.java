import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.control.Button;



public class JavaFXListenersReal extends Application {

	public void start(Stage ballStage) throws Exception {

		ballStage.setTitle("The B A L L");
		
		Ball ball = new Ball(50);
		
		Pane pane = new Pane(ball);

		Button up = new Button("Up");

		Button right = new Button("Right");

		Button down = new Button("Down");

		Button left = new Button("Left");
		
		//Pane pane = new Pane();
		
		pane.getChildren().addAll(up, right, down, left);
		
		IncrementedScene scene = new IncrementedScene(pane, 450, 450);
		
		

		scene.widthProperty().addListener(ov -> 
			{right.setLayoutX(scene.getWidth() - right.getWidth());
			up.setLayoutX((scene.getWidth() / 2) - (up.getWidth() / 2));
			down.setLayoutX((scene.getWidth() / 2) - (down.getWidth() /2));
			
			if ((ball.getRight()) > scene.getWidth()) {
				
				ball.setCenterX(scene.getWidth() - ball.getRadius());
			} else {};
		});
		
		scene.heightProperty().addListener(ov -> 
			{down.setLayoutY(scene.getHeight() - down.getHeight());
			left.setLayoutY((scene.getHeight() / 2) - (left.getHeight() / 2));
			right.setLayoutY((scene.getHeight() / 2) - (right.getHeight() / 2));
			
			if ((ball.getBottom()) > scene.getHeight()) {
				
				ball.setCenterY(scene.getHeight() - ball.getRadius());
			} else {};
		});
		
		ballStage.setScene(scene);
		
		ball.setCenterX((scene.getWidth() / 2));
		ball.setCenterY((scene.getHeight() / 2));
		
		right.setLayoutX(scene.getWidth() - (right.getWidth() * 2));
		right.setLayoutY((scene.getHeight() / 2) - (right.getHeight() / 2));
		/*right.layoutXProperty().bind(scene.widthProperty().subtract(right.widthProperty()));
		right.layoutYProperty().bind(scene.heightProperty().subtract(right.getHeight()));*/
		
		
		left.setLayoutY((scene.getHeight() / 2) - (left.getHeight() / 2));
		//left.layoutYProperty().bind(scene.heightProperty().divide(2).subtract(left.getHeight() / 2));
		
		
		up.setLayoutX((scene.getWidth() / 2) - (up.getWidth() / 2));
		
		down.setLayoutX((scene.getWidth() / 2) - (down.getWidth() / 2));
		down.setLayoutY(scene.getHeight() - down.getHeight());
		
		up.pressedProperty().addListener(ov ->
		{if (ball.getTop() > 0) {
			
			if (ball.getTop() > scene.getYIncrement()) {
				ball.setCenterY(ball.getCenterY() - scene.getYIncrement());
			} else {
				ball.setCenterY(ball.getRadius());
			}
		} else {}; });
		
		right.pressedProperty().addListener(ov ->
		{if (ball.getRadius() < (scene.getWidth())) {
			
			if ((ball.getRight() + scene.getXIncrement()) < scene.getWidth()) {
				ball.setCenterX(ball.getCenterX() + scene.getXIncrement());
			} else {
				ball.setCenterX(scene.getWidth() - ball.getRadius());
			}
		} else {}; });
		
		down.pressedProperty().addListener(ov ->
		{if (ball.getBottom() < scene.getHeight()) {
			
			if ((ball.getBottom() + scene.getYIncrement()) < scene.getHeight()) {
				ball.setCenterY(ball.getCenterY() + scene.getYIncrement());
			} else {
				ball.setCenterY(scene.getHeight() - ball.getRadius());
			}
		} else {}; });
		
		left.pressedProperty().addListener(ov ->
		{if (ball.getLeft() > 0) {
			
			if ((ball.getLeft()) > (scene.getXIncrement())) {
				ball.setCenterX(ball.getCenterX() - scene.getXIncrement());
			} else {
				ball.setCenterX(ball.getRadius());
			}
		} else {}; });

		ballStage.show();
	}
	
	
	public static void main(String[] args) {
		
		launch(args);
	}
}

class IncrementedScene extends Scene {

	public IncrementedScene(Parent root, double width, double height) {
		super(root, width, height);
	}
	
	double getYIncrement() {
		
		return (this.getHeight() / 20);
	}
	
	double getXIncrement() {
		
		return (this.getWidth() / 20);
	}
}

class Ball extends Circle {
	
	Ball(double radius) {
		
		super(radius, Color.AQUAMARINE);
	}
	
	double getTop() {
		
		return (this.getCenterY() - this.getRadius());
	}
	
	double getRight() {
		
		return (this.getCenterX() + this.getRadius());
	}
	
	double getBottom() {
		
		return (this.getCenterY() + this.getRadius());
	}
	
	double getLeft() {
		
		return (this.getCenterX() - this.getRadius());
	}
}
