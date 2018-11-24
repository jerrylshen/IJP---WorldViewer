/**
 * @author Jerry Shen
 *
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainProgram extends Application {
	
	public void start(Stage stage) {
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader();
			String viewerFxml = "WorldViewer.fxml";
			AnchorPane page = (AnchorPane)fxmlLoader.load(this.getClass().getResource(viewerFxml).openStream());
			Scene scene = new Scene(page);
			stage.setScene(scene);
			
			Controller viewer = (Controller)fxmlLoader.getController();
			//FXMLLoader newfxml = FXMLLoader(getClass().getClassLoader().getResource(WorldViewer)).setController(viewer); //added
			viewer.Initialise();
			
			stage.show();
		}
		catch (IOException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
			System.exit(1);
		}
	}
	
	public static void main(String args[]) {
		launch(args);
	}
}