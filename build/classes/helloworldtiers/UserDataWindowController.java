package helloworldtiers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import dataAccess.UserManagerFactory;
import model.User;

/**
 *
 * @author 2dam
 */
public class UserDataWindowController implements Initializable {

    UserManagerFactory factory = new UserManagerFactory();
    User user = null;

    public void createFactory() {
        user = factory.createFactory();
    }

    @FXML
    private Label label_dni;
    @FXML
    private Label label_username;
    @FXML
    private Label label_password;
    @FXML
    private Label label_fullName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Cargar los datos del usuario y asignarlos a los labels
        this.createFactory();
        if (user != null) {
            label_dni.setText("DNI: " + user.getDni());
            label_username.setText("Username: " + user.getUsername());
            label_password.setText("Password: " + user.getPassword());
            label_fullName.setText("Full name: " + user.getFullName());
        } else {
            label_dni.setText("DNI: Not available");
            label_username.setText("Username: Not available");
            label_password.setText("Password: Not available");
            label_fullName.setText("Full name: Not available");
        }
    }
}
