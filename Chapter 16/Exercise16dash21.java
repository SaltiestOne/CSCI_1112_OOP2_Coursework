import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.function.UnaryOperator;
import javafx.animation.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;


public class Exercise16dash21 extends Application {

	public void start(Stage timerStage) throws Exception {
		
		TextField startTime = new TextField();

		UnaryOperator<Change> integerFilter = change -> {
		    String newText = change.getControlNewText();
		    if (newText.matches("-?([1-9][0-9]*)?")) { 
		        return change;
		    }
		    return null;
		};

		startTime.setTextFormatter(
		    new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));
		//lines 30 through 39 were shamelessly stolen from someone on StackOverflow.
		//I asked Jason if I could do this, in case anyone asks.

		startTime.setMaxWidth(100);
		
		startTime.setFont(Font.font("Comic Sans",42));
		
		timerStage.setTitle("Timer");
		
		timerStage.setScene(new Scene(new StackPane(startTime), 400, 400));
		
		timerStage.show();
		
		startTime.setOnAction(e ->
			{int time = Integer.parseInt(startTime.getText());
				
			Timer timer = new Timer(time);
			
			timer.setFont(Font.font("Comic Sans",42));
	
			Timeline counter = new Timeline(new KeyFrame(Duration.seconds(1),
					(a -> {timer.decrement();})));
	
			counter.setCycleCount(time);
			
			timerStage.setScene(new Scene(new StackPane(timer),400,400));
			
			counter.setOnFinished(sports -> //it's in the game
			{MediaPlayer player = new MediaPlayer(new Media(
					"https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3"));
				player.setVolume(1);
				
				Text finish = new Text("Finished!");
				finish.setFont(Font.font("Comic Sans",42));
				
				timerStage.setScene(new Scene(new StackPane(finish),400,400));
				
				player.play();});
			
			counter.play();});

		timerStage.show();

	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}


class Timer extends Text {
	
	private int time;
	
	Timer(int time) {
		
		super(new Integer(time).toString());
		
		this.time = time;
	}
	
	void decrement() {
		
		this.time--;
		
		this.setText(new Integer(time).toString());
	}
	
}