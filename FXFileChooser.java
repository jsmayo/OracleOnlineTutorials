/*import javafx.application.*;
import java.awt.Desktop.*;
import javafx.stage.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
*/
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class FXFileChooser extends Application {

    private Desktop desktop = Desktop.getDesktop();
	
	public void start(final Stage stage) {
		stage.setTitle("File Chooser Sample");
		final FileChooser fc = new FileChooser();
		Button openButton = new Button("Open a Picture");
		Button openMultiButton = new Button("Open Multi Pictures");
		
		openButton.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent ae) {
					File file = fc.showOpenDialog(stage);
					if(file !=null) {
						openFile(file);
					}
				}
		});
		
		openMultiButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(final ActionEvent ae){
					List<File> list = fc.showOpenMultipleDialog(stage);
					if(list!=null){
						for (File file: list){
							openFile(file);
						}
					}
				}
		});
		
		final GridPane inputGridPane = new GridPane();
		GridPane.setConstraints(openButton,0,0);
		GridPane.setConstraints(openMultiButton,1,0);
		inputGridPane.setHgap(6);
		inputGridPane.setVgap(6);
		inputGridPane.getChildren().addAll(openButton,openMultiButton);
		final Pane rootGroup = new VBox(12);
		rootGroup.getChildren().addAll(inputGridPane);
		rootGroup.setPadding(new Insets(12,12,12,12));
		
		stage.setScene(new Scene(rootGroup));
		stage.show();
	}
	
	public static void main(String[] av){
		Application.launch(av);
	}

	private void openFile(File file) {
		try{
			desktop.open(file);
		}catch(IOException ex){
		           System.out.println(ex.getMessage());
        }
	}
}