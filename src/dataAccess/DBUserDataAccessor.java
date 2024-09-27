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
    private String url = "jdbc:mysql://localhost:3306/DBUser?serverTimezone=Europe/Madrid&useSSL=false";
    private String user = "root";
    private String passwd = "abcd*1234";

    /**
     * Fetches the user data from the database.
     * 
     * @return A User object containing the user's information (DNI, username, password, and full name),
     *         or null if an error occurs during the database access.
     */
    @Override
    public User fetchData() {
        Connection connection = null; // Connection object for database connection
        Statement statement = null;   // Statement object to execute SQL queries
        ResultSet resultSet = null;   // ResultSet object to hold the results of the query

        try {
            // Connect to the database using the specified URL, user, and password
            connection = DriverManager.getConnection(url, user, passwd);
            // Create a statement to execute the query
            statement = connection.createStatement();
            // Execute the query to fetch user data from the "user" table
            resultSet = statement.executeQuery("SELECT * FROM user");

            // Check if there is at least one result in the result set
            if (resultSet.next()) { 
                // Retrieve user information from the result set
                String dni = resultSet.getString("dni");          // Get user's DNI
                String username = resultSet.getString("username"); // Get user's username
                String password = resultSet.getString("passwd");   // Get user's password
                String fullName = resultSet.getString("fullName"); // Get user's full name
                
                // Create and return a new User object populated with the retrieved data
                return new User(dni, username, password, fullName);
            } else {
                // Log a warning if no user data was found
                Logger.getLogger("dataAccess").warning("No user data found in the database.");
                return null; // Return null if no data is found
            }

        } catch (Exception e) {
            // Log the exception if an error occurs during database access
            Logger.getLogger("dataAccess").severe("Error fetching user data: " + e.getLocalizedMessage());
        } finally {
            // Close the resources in the finally block to ensure they are released
            try {
                if (resultSet != null) resultSet.close();   // Close the ResultSet if it's not null
                if (statement != null) statement.close();   // Close the Statement if it's not null
                if (connection != null) connection.close(); // Close the Connection if it's not null
            } catch (Exception e) {
                // Log any exceptions that occur during resource closure
                Logger.getLogger("dataAccess").severe("Error closing resources: " + e.getLocalizedMessage());
            }
        }

        // Return null if an error occurs during DB access
        return null;
    }
}
