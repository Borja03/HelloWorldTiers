package helloworldtiers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is the main controller for the user application window. 
 * It extends the {@link javafx.application.Application} class to set up and display the main user interface.
 * The application loads the FXML file and creates the primary stage for the GUI.
 * 
 * @author Alder and Borja
 */
public class Application extends javafx.application.Application {

    /**
     * The main entry point for all JavaFX applications.
     * This method is called after the system is ready for the application to begin running.
     * 
     * @param stage The primary stage for this application, onto which 
     * the application scene can be set.
     * 
     * @throws Exception if there is an error loading the FXML resource.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file from the specified resource
        Parent root = FXMLLoader.load(getClass().getResource("UserDataView.fxml"));
        
        // Create a scene with the loaded FXML view
        Scene scene = new Scene(root);
        
        // Set the scene onto the stage
        stage.setScene(scene);
        
        // Show the stage to the user
        stage.show();
    }

    /**
     * The main method is the entry point of the application when launched from the command line.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
