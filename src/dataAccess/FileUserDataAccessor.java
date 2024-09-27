package dataAccess;

import java.util.ResourceBundle;
import model.User;

/**
 * The FileUserDataAccessor class implements the DataAccessible interface to fetch user data from a properties file.
 * It reads user information from a specified resource bundle and creates a User object.
 * 
 * This implementation allows user data to be configured externally in a properties file,
 * providing flexibility and ease of modification without changing the codebase.
 * 
 * @author Alder and Borja
 */
public class FileUserDataAccessor implements DataAccessible {

    /**
     * Fetches the user data from the properties file.
     * 
     * This method accesses a resource bundle to retrieve user information such as DNI,
     * username, password, and full name. It assumes that the properties file is correctly
     * structured and accessible.
     * 
     * @return A User object containing the user's information (DNI, username, password, and full name).
     *         If any of the required properties are missing, the method may throw an exception.
     */
    @Override
    public User fetchData() {
        // Fetch user information from the resource bundle
        String dni = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.dni");
        String username = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.username");
        String password = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.password");
        String fullName = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.fullName");
        
        // Create and return a User object populated with the retrieved data
        User user = new User(dni, username, password, fullName);
        return user;
    }
}
