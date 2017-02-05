import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.effect.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;

public class FXSlider extends Application {
	final Slider opacityLevel = new Slider(0,1,1);
	final Slider sepiaTone = new Slider(0,1,1);
	final Slider scaling = new Slider(0.5,1,1);
	final Image image = new Image(getClass().getResourceAsStream("moon1.jpg"));
	final Label opacityCaption = new Label("Opacity Label:");
	final Label sepiaCaption = new Label("Sepia Tone:");
	final Label scalingCaption = new Label("Scaling Factor:");
	
	final Label opacityValue = new Label(Double.toString(opacityLevel.getValue()));
	final Label sepiaValue = new Label(Double.toString(sepiaTone.getValue()));
	final Label scalingValue = new Label(Double.toString(scaling.getValue()));
	
	final static Color textColor = Color.BLACK;
	final static SepiaTone sepiaEffect = new SepiaTone();
	
	public void start(Stage stage){
		stage.setTitle("FXSlider Demo");
		Group root = new Group();
		Scene scene = new Scene(root);
		scene.setFill(textColor);
		stage.setScene(scene);
		stage.sizeToScene();
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(70);
		
		final ImageView moon = new ImageView(image);
		moon.setEffect(sepiaEffect);
		GridPane.setConstraints(moon, 0, 0);
		GridPane.setColumnSpan(moon, 3);
		grid.getChildren().add(moon);
		scene.setRoot(grid);
		
		opacityCaption.setTextFill(textColor);
		GridPane.setConstraints(opacityCaption, 0,1);
		grid.getChildren().add(opacityCaption);
		
		opacityLevel.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> ov,
					Number old_value, Number new_value){
				moon.setOpacity(new_value.doubleValue());
				opacityValue.setText(String.format("%.2f", new_value));
					}
		});
		
		GridPane.setConstraints(opacityLevel, 1, 1);
		grid.getChildren().add(opacityLevel);
		opacityValue.setTextFill(textColor);
		GridPane.setConstraints(opacityValue,2,1);
		grid.getChildren().add(opacityValue);
		sepiaCaption.setTextFill(textColor);
		GridPane.setConstraints(sepiaCaption, 0,2);
		grid.getChildren().add(sepiaCaption);
		
		sepiaTone.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> ov,
					Number old_value, Number new_value){
				sepiaEffect.setLevel(new_value.doubleValue());
				sepiaValue.setText(String.format("%.2f", new_value));
					}
		});
		GridPane.setConstraints(sepiaTone, 1,2);
		grid.getChildren().add(sepiaTone);
		sepiaValue.setTextFill(textColor);
		GridPane.setConstraints(sepiaValue, 2,2);
		grid.getChildren().add(sepiaValue);
		
		scalingCaption.setTextFill(textColor);
		GridPane.setConstraints(scalingCaption, 0,3);
		grid.getChildren().add(scalingCaption);
		
		scaling.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> ob, 
					Number old_value, Number new_value){
				moon.setScaleX(new_value.doubleValue());
				moon.setScaleY(new_value.doubleValue());
				scalingValue.setText(String.format("%.2f", new_value));
					}
		});
		GridPane.setConstraints(scaling, 1,3);
		grid.getChildren().add(scaling);
		scalingValue.setTextFill(textColor);
		GridPane.setConstraints(scalingValue, 2, 3);
		grid.getChildren().add(scalingValue);
		stage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}