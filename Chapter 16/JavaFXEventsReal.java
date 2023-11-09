import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

public class JavaFXEventsReal extends Application {

	public void start(Stage buttonStage) throws Exception {
		
		Text fun = new Text("Programming is fun!");
		
		fun.setFont(Font.font("Times New Roman",FontPosture.ITALIC,25));
		
		fun.setLayoutX(140);
		fun.setLayoutY(101);
		
		Button left = new Button("<- Text Left");
		
		Button right = new Button("Text Right ->");
		
		right.setLayoutX((393));
		
		ToggleGroup colors = new ToggleGroup();
		
		RadioButton black = new RadioButton("Black");
		
		black.setToggleGroup(colors);
		
		black.setLayoutX(5);
		black.setLayoutY(175);
		
		black.setSelected(true);
		//not necessary since it's the default color already but hey
		RadioButton red = new RadioButton("Red");
		
		red.setToggleGroup(colors);
		
		red.setLayoutX(105);
		red.setLayoutY(175);
		
		RadioButton yellow = new RadioButton("Yellow");
		
		yellow.setToggleGroup(colors);
		
		yellow.setLayoutX(205);
		yellow.setLayoutY(175);
		
		RadioButton green = new RadioButton("Green");
		
		green.setToggleGroup(colors);
		
		green.setLayoutX(305);
		green.setLayoutY(175);
		
		RadioButton blue = new RadioButton("Blue");
		
		blue.setToggleGroup(colors);
		
		blue.setLayoutX(405);
		blue.setLayoutY(175);
		
		Scene scene = new Scene(new Pane(fun,left,right,black,red,yellow,green,blue),500,200);
		
		left.pressedProperty().addListener(e ->
		{if ((fun.getLayoutX() - 12) <= 0) {
			
			fun.setLayoutX(0);
		} else {
			
			fun.setLayoutX(fun.getLayoutX() - 12);
		}});
		
		right.pressedProperty().addListener(e ->
		{if (fun.getLayoutX() >= 284) {
			//i had to plug-and-chug this since there isn't a method to get a pixel length for texts
			fun.setLayoutX(284);
		} else {
			
			fun.setLayoutX(fun.getLayoutX() + 12);
		}});
		
		black.pressedProperty().addListener(e -> 
		{fun.setFill(Color.BLACK);});
		
		red.pressedProperty().addListener(e -> 
		{fun.setFill(Color.RED);});
		
		yellow.pressedProperty().addListener(e -> 
		{fun.setFill(Color.YELLOWGREEN);});
		//wow "that one crayon" came in handy
		green.pressedProperty().addListener(e -> 
		{fun.setFill(Color.GREEN);});
		
		blue.pressedProperty().addListener(e -> 
		{fun.setFill(Color.BLUE);});
		
		buttonStage.setScene(scene);
		
		buttonStage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
