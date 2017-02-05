import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.geometry.*;




public class FXTextField extends Application {
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage myStage){
		myStage.setTitle("TextField Demo");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(5);
		grid.setHgap(5);
		TextField name = new TextField();
		name.setPromptText("Please enter your first name");
		name.setPrefColumnCount(10);
		name.getText();
		GridPane.setConstraints(name, 0, 0);
		grid.getChildren().add(name); // trying without .getchildren method
		TextField lastName = new TextField();
		lastName.setPromptText("Please Enter your last name.");
		GridPane.setConstraints(lastName, 0, 1);
		grid.getChildren().add(lastName);
		TextField comment = new TextField();
		comment.setPrefColumnCount(15);
		comment.setPromptText("Enter your comment.");
		GridPane.setConstraints(comment, 0, 2);
		grid.getChildren().add(comment);
		Button submit = new Button("Submit");
		GridPane.setConstraints(submit, 1, 0);
		grid.getChildren().add(submit);
		Button clear = new Button("Clear");
		GridPane.setConstraints(clear, 1, 1);
		grid.getChildren().add(clear);
		Scene myScene = new Scene(grid);
		myStage.setScene(myScene);
		myStage.sizeToScene();
		myStage.show();
	}
}