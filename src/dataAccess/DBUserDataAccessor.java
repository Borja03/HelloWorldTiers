package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;
import model.User;

/**
 * The DBUserDataAccessor class implements the DataAccessible interface to fetch user data from a database.
 * It connects to a MySQL database, executes a query to retrieve user information, and returns a User object.
 * 
 * @author Alder and Borja
 */
public class DBUserDataAccessor implements DataAccessible {

    // Parameters to access the DB
    private String url = "jdbc:mysql://localhost:3306/DBUser?serverTimezone=Europe/Madrid";
    private String user = "root";
    private String passwd = "abcd*1234";

    /**
     * Fetches the user data from the database.
     * 
     * @return A User object containing the user's information (DNI, username, password, and full name),
     * or null if an error occurs during the database access.
     */
    @Override
    public User fetchData() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection(url, user, passwd);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user");

            if (resultSet.next()) { // Check if there is at least one result
                String dni = resultSet.getString("dni");
                String username = resultSet.getString("username");
                String password = resultSet.getString("passwd");
                String fullName = resultSet.getString("fullName");
                
                // Return the user object
                return new User(dni, username, password, fullName);
            } else {
                Logger.getLogger("dataAccess").warning("No user data found in the database.");
                return null; // Return null if no data is found
            }

        } catch (Exception e) {
            Logger.getLogger("dataAccess").severe("Error fetching user data: " + e.getLocalizedMessage());
        } finally {
            // Close the resources in the finally block
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                Logger.getLogger("dataAccess").severe("Error closing resources: " + e.getLocalizedMessage());
            }
        }

        // Return null if an error occurs during DB access
        return null;
    }
}
