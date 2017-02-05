import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.value.*;
import javafx.scene.image.*;


public class FXScrollPane extends Application {
	
	ScrollPane sp = new ScrollPane();
	Image[] images = new Image[2];
	ImageView[] pics = new ImageView[2];
	VBox vb = new VBox();
	Label fileName = new Label();
	String[] imageNames = new String[] {"moon1.jpg", "moon2.jpg"};
	
	public void start(Stage myStage) {
		VBox box = new VBox();
		Scene scene = new Scene(box, 180,180);
		myStage.setTitle("ScrollPane Demo");
		myStage.setScene(scene);
		box.getChildren().addAll(sp, fileName);
		VBox.setVgrow(sp, Priority.ALWAYS);
		
		fileName.setLayoutX(30);
		fileName.setLayoutY(160);
		
		for(int i =0; i < 2; i++){
			images[i] = new Image(getClass().getResourceAsStream(imageNames[i]));
			pics[i] = new ImageView(images[i]);
			pics[i].setFitWidth(100);
			pics[i].setPreserveRatio(true);
			vb.getChildren().add(pics[i]);
		}
		
		sp.setVmax(440);
		sp.setPrefSize(115,150);
		sp.setContent(vb);
		sp.vvalueProperty().addListener(new ChangeListener<Number> () {
				public void changed(ObservableValue<? extends Number> ov,
					Number old_val, Number new_val){
				//fileName.setText(imageNames[(new_val.intValue() -1)/100]);
					}
		});
		fileName.setText(sp.vvalueProperty(imageNames[1]));
		myStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
		