package helloworldtiers;

import dataAccess.DataAccessible;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import dataAccess.UserManagerFactory;
import java.util.logging.Logger;
import model.User;

/**
 * The UserDataWindowController class is the controller for a UI window that displays user data.
 * It fetches data from the data access layer and assigns it to the appropriate UI labels.
 * This class implements the {@link Initializable} interface to initialize UI components 
 * after they have been injected by the FXML loader.
 *
 * @author Alder and Borja
 */
public class UserDataWindowController implements Initializable {

    // View fields representing the UI labels
    @FXML
    private Label label_dni;
    @FXML
    private Label label_username;
    @FXML
    private Label label_password;
    @FXML
    private Label label_fullName;

    /**
     * Initializes the controller class. Loads user data and sets it to the labels.
     * If any error occurs during data retrieval, the labels are set to "Not available".
     * 
     * @param url The location used to resolve relative paths for the root object, 
     * or null if not known.
     * @param rb The resource bundle to localize the root object, or null if not available.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Fetch user data using the UserManagerFactory
            User user = UserManagerFactory.createFactory().fetchData();
            label_dni.setText("DNI: " + user.getDni());
            label_username.setText("Username: " + user.getUsername());
            label_password.setText("Password: " + user.getPassword());
            label_fullName.setText("Full name: " + user.getFullName());
        } catch (Exception e) {
            // Set labels to "Not available" if there is an error
            label_dni.setText("DNI: Not available");
            label_username.setText("Username: Not available");
            label_password.setText("Password: Not available");
            label_fullName.setText("Full name: Not available");
            Logger.getLogger("helloworldtiers").severe(e.getLocalizedMessage());
        }
    }
}
