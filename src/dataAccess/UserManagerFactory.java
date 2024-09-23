package dataAccess;

import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * The UserManagerFactory class is responsible for creating an instance of the
 * DataAccessible interface according to the access type configured in a
 * properties file.
 *
 * @author Alder and Borja
 */
public class UserManagerFactory {

    private static String tipo = "";
    /**
     * Static method to create an instance of DataAccessible based on the
     * configured type.
     *
     * @return An instance of a class that implements the DataAccessible
     * interface. It can be an instance of DBUserDataAccessor or
     * FileUserDataAccessor, depending on the configured type.
     * @throws IllegalArgumentException If the access type is not supported.
     */
    public static DataAccessible createFactory() throws Exception{
            tipo = ResourceBundle.getBundle("dataAccess.AccessorDataSelector").getString("dataAccessor");
            
        switch (tipo) {
            case "DB":
                return new DBUserDataAccessor();       
            case "Properties file":
                return new FileUserDataAccessor();
            default:
                Logger.getLogger("dataAccess").severe("Error creating data access instance");
        }
        return null;
    }
}
