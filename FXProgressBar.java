import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class FXProgressBar extends Application {
	final Float[] values = new Float[] {-1.0f, 0f,0.6f,1.0f};
	final Label[] labels = new Label[values.length];
	final ProgressBar[] pbs = new ProgressBar[values.length];
	final ProgressIndicator[] pi = new ProgressIndicator[values.length];
	final HBox hbs[] = new HBox[values.length];
	
	public void start(Stage stage){
		Group root = new Group();
		Scene scene = new Scene(root, 300,150);
		//scene.getStyleSheets().add("progresssample/Sample.css");
		stage.setScene(scene);
		stage.setTitle("Progress Controls");
		
		for(int i=0; i<values.length; i++){
			final Label label = labels[i]= new Label();
			label.setText("Progress:" + values[i]);
			
			final ProgressBar pb = pbs[i] = new ProgressBar();
			pb.setProgress(values[i]);
			
			final ProgressIndicator pin = pi[i] = new ProgressIndicator();
			pin.setProgress(values[i]);
			final HBox hb = hbs[i] = new HBox();
			hb.setSpacing(5);
			hb.setAlignment(Pos.CENTER);
			hb.getChildren().addAll(label, pb, pin);
		}
		
		final VBox vb = new VBox();
		vb.setSpacing(5);
		vb.getChildren().addAll(hbs);
		scene.setRoot(vb);
		stage.show();
	}
	
	public static void main(String[] av){
		launch(av);
	}
}