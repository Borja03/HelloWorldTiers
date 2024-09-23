package dataAccess;

import model.User;

/**
 * The DataAccessible interface defines a method for fetching user data.
 * Implementing classes should provide the actual data retrieval logic.
 * 
 * @author Alder and Borja
 */
public interface DataAccessible {
    
    /**
     * Fetches user data.
     * 
     * @return A User object containing the user's information.
     * @throws Exception If an error occurs while fetching user data.
     */
    public User fetchData() throws Exception;
}
