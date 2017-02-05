import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.geometry.*;

public class FXPassword extends Application {
	final Label message = new Label("");
	public void start(Stage stage) {
		stage.setTitle("Password!");
		VBox vb = new VBox();
		Scene scene = new Scene(vb);
		vb.setPadding(new Insets(10,0,0,10));
		vb.setSpacing(10);
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER_LEFT);
		Label label = new Label("Passowrd");
		final PasswordField pb = new PasswordField();
		
		pb.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					if(!pb.getText().equals("bleh")) {
						message.setText("Your password is incorrect!");
						message.setTextFill(Color.rgb(210, 39, 30));
					} else {
						message.setText("Your password has been confirmed.");
						message.setTextFill(Color.rgb(21,117,84));
					}
					pb.clear();
				}
		});
		hb.getChildren().addAll(label, pb);
		vb.getChildren().addAll(hb,message);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
		