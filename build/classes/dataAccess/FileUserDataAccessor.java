package dataAccess;

import java.util.ResourceBundle;
import model.User;

/**
 * The FileUserDataAccessor class implements the DataAccessible interface to fetch user data from a properties file.
 * It reads user information from a specified resource bundle and creates a User object.
 * 
 * @author Alder and Borja
 */
public class FileUserDataAccessor implements DataAccessible {

    /**
     * Fetches the user data from the properties file.
     * 
     * @return A User object containing the user's information (DNI, username, password, and full name).
     */
    @Override
    public User fetchData() {
        String dni = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.dni");
        String username = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.username");
        String password = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.password");
        String fullName = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.fullName");
        
        // Return the user object
        User user = new User(dni, username, password, fullName);
        return user;
    }
}
