import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.web.*;
import javafx.geometry.*;
import javafx.event.*;

public class FXHTMLEditShow extends Application {
    private final String INITIAL_TEXT = "Lorem ipsum dolor sit "
            + "amet, consectetur adipiscing elit. Nam tortor felis, pulvinar "
            + "in scelerisque cursus, pulvinar at ante. Nulla consequat"
            + "congue lectus in sodales. Nullam eu est a felis ornare "
            + "bibendum et nec tellus. Vivamus non metus tempus augue auctor "
            + "ornare. Duis pulvinar justo ac purus adipiscing pulvinar. "
            + "Integer congue faucibus dapibus. Integer id nisl ut elit "
            + "aliquam sagittis gravida eu dolor. Etiam sit amet ipsum "
            + "sem.";
            
            
            public void start(Stage stage) {
            	stage.setTitle("HTML Edit Copier");
            	stage.setWidth(500);
            	stage.setHeight(500);
            	Scene scene = new Scene(new Group());
            	VBox root = new VBox();
            	root.setPadding(new Insets(8,8,8,8));
            	root.setSpacing(5);
            	root.setAlignment(Pos.BOTTOM_LEFT);
            	
            	final HTMLEditor htmlEditor = new HTMLEditor();
            	htmlEditor.setPrefHeight(245);
            	htmlEditor.setHtmlText(INITIAL_TEXT);
            	
            	final TextArea htmlCode = new TextArea();
            	htmlCode.setWrapText(true);
            	
            	ScrollPane scrollPane = new ScrollPane();
            	scrollPane.getStyleClass().add("noborder-scroll-pane");
            	scrollPane.setContent(htmlCode);
            	scrollPane.setFitToWidth(true);
            	scrollPane.setPrefHeight(180);
            	
            	Button showHTMLButton = new Button("Produce HTML Code");
            	root.setAlignment(Pos.CENTER);
            	showHTMLButton.setOnAction(new EventHandler<ActionEvent>() {
            			public void handle(ActionEvent arg) {
            				htmlCode.setText(htmlEditor.getHtmlText());
            			}
            	});
            	
            	root.getChildren().addAll(htmlEditor, showHTMLButton, scrollPane);
            	scene.setRoot(root);
            	
            	stage.setScene(scene);
            	stage.show();
            }
            public static void main(String[] args){
            	launch(args);
            }
}