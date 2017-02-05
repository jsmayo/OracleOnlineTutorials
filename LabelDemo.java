import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LabelDemo extends Application {
	
	public static void main(String[] args){
		launch(args);
		
	}
	
	public void init(){
		
	}
	
	public void start(Stage myStage){
		myStage.setTitle("JavaFX Login");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10); //spaces between rows
		grid.setVgap(10); //spaces between columns
		grid.setPadding(new Insets(25,25,25,25)); //edges around grid
		Scene myScene = new Scene(grid, 300, 275);
		myStage.setScene(myScene);
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
		grid.add(scenetitle, 0,0,2,1); //added at (0,0) but spans 2 row, 1 column (CENTER)
		Label userName = new Label("User Name:");
		grid.add(userName,0,1);
		TextField userTextField = new TextField();
		grid.add(userTextField, 1,1);
		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);
		PasswordField pwBox = new PasswordField();
		grid.add(pwBox,1,2);
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10); //new layout with spacing of 10 pxls
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1,4);
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		btn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae){
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Sign in button pressed.");
				}
		});
		
		 //rootNode is grid, like usual
		
		myStage.show();
	}
	
	public void stop(){
		
	}
}