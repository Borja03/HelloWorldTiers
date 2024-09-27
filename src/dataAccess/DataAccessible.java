package dataAccess;

import model.User;

/**
 * The DataAccessible interface defines a method for fetching user data.
 * Implementing classes should provide the actual data retrieval logic.
 * 
 * This interface serves as a contract for data access classes, ensuring they implement
 * the fetchData method for retrieving User information.
 * 
 * @author Alder and Borja
 */
public interface DataAccessible {
    
    /**
     * Fetches user data.
     * 
     * This method is intended to be implemented by DBUserDataAccessor and FileUserDataAccessor
     * 
     * 
     * @return A User object containing the user's information, including but not limited to
     *         fields such as DNI, username, password, and full name.
     * @throws Exception If an error occurs while fetching user data, such as issues
     *                   with database connectivity or data retrieval.
     */
    public User fetchData() throws Exception;
}
