import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.value.*;

public class FXProgressIndicator extends Application {
	
	public void start(Stage stage){
		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Progress Controls");
		
		final Slider slider = new Slider();
		slider.setMin(0);
		slider.setMax(50);
		
		final ProgressBar pb = new ProgressBar(0);
		final ProgressIndicator pi = new ProgressIndicator(0);
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> ov, 
					Number oldv , Number newv){
				pb.setProgress(newv.doubleValue()/50);
				pi.setProgress(newv.doubleValue()/50);
					}
		});
		
		final HBox hb = new HBox();
		hb.setSpacing(5);
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(slider, pb, pi);
		scene.setRoot(hb);
		stage.show();
	}
	
	public static void main(String[] av){
		launch(av);
	}
}