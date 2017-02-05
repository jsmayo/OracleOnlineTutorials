import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.*;

public class FXHTMLEditLoad extends Application {
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
            	stage.setTitle("Load HTML");
            	stage.setWidth(500);
            	stage.setHeight(500);
            	Scene scene = new Scene(new Group());
            	
            	VBox root = new VBox();
            	root.setPadding(new Insets(8,8,8,8));
            	root.setSpacing(5);
            	root.setAlignment(Pos.BOTTOM_LEFT);
            	
            	HTMLEditor htmlEditor = new HTMLEditor();
            	htmlEditor.setPrefHeight(245);
            	htmlEditor.setHtmlText(INITIAL_TEXT);
            	
            	final WebView browser = new WebView();
            	final WebEngine webEngine = browser.getEngine();
            	
            	ScrollPane scrollPane = new ScrollPane();
            	scrollPane.getStyleClass().add("noborder-scroll-pane");
            	scrollPane.setStyle("-fx-background-color: white");
            	scrollPane.setContent(browser);
            	scrollPane.setFitToWidth(true);
            	scrollPane.setPrefHeight(180);
            	
            	Button showHTMLButton = new Button("Load Content");
            	root.setAlignment(Pos.CENTER);
            	showHTMLButton.setOnAction(new EventHandler<ActionEvent> () {
            			public void handle(ActionEvent args) {
            				webEngine.loadContent(htmlEditor.getHtmlText());
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