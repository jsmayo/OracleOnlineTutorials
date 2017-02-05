import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.collections.*;
import javafx.scene.control.cell.*;

public class FXListViewMod extends Application {
	public static final ObservableList names = 
		FXCollections.observableArrayList();
	public static final ObservableList data = FXCollections.observableArrayList();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("List View Sample");
		final ListView listView = new ListView(data);
		listView.setPrefSize(200,250);
		listView.setEditable(true);
		
		names.addAll(
             "Adam", "Alex", "Alfred", "Albert",
             "Brenda", "Connie", "Derek", "Donny", 
             "Lynne", "Myrtle", "Rose", "Rudolph", 
             "Tony", "Trudy", "Williams", "Zach"
             );
        
        for(int i =0; i < 18; i++){
        	data.add("anonym");
        }
        
        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(names));
        
        StackPane root = new StackPane();
        root.getChildren().add(listView);
        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();
    }
}