import javafx.application.*;
import javafx.stage.*;
import javafx.beans.value.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;

public class FXTitledPane extends Application {
	final String[] imageNames = new String[] {"Moon1" , "Moon2", "LinenBkg"};
	final Image[] images = new Image[imageNames.length];
	final ImageView[] pics = new ImageView[imageNames.length];
	final TitledPane[] tps = new TitledPane[imageNames.length];
	final Label label = new Label("N/A");
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		stage.setTitle("TitledPane");
		Scene scene = new Scene(new Group(), 800,250);
		scene.setFill(Color.GHOSTWHITE);
		
		TitledPane gridTitlePane = new TitledPane();
		GridPane grid = new GridPane();
		grid.setVgap(4);
		grid.setPadding(new Insets(5,5,5,5));
		grid.add(new Label("To: "),0,0);
		grid.add(new TextField(), 1,0);
		grid.add(new Label("Cc: "),0,1);
		grid.add(new TextField(), 1,1);
		grid.add(new Label("Subject"),0,2);
		grid.add(new TextField(),1,2);
		grid.add(new Label("Attachment: "), 0, 3);
		grid.add(label,1,3);
		gridTitlePane.setText("Grid");
		gridTitlePane.setContent(grid);
		
		final Accordion accordion = new Accordion();
		for(int i =0; i < imageNames.length; i++) {
			images[i] = new Image(getClass().getResourceAsStream(imageNames[i]+ ".jpg"));
			pics[i] = new ImageView(images[i]);
			tps[i] = new TitledPane(imageNames[i], pics[i]);
		}
		
		accordion.getPanes().addAll(tps);
		accordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
				public void changed(ObservableValue<? extends TitledPane> ov, TitledPane oldp, TitledPane newp){
					if(newp != null) {
						label.setText(accordion.getExpandedPane().getText() + ".jpg");
					}
				}
		});
		
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(20,0,0,20));
		hbox.getChildren().setAll(gridTitlePane,accordion);
		Group root = (Group)scene.getRoot();
		root.getChildren().add(hbox);
		stage.setScene(scene);
		stage.show();
	}
}