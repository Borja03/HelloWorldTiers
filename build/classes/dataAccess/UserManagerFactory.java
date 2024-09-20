package dataAccess;

import java.util.Locale;
import java.util.ResourceBundle;
import model.User;

/**
 *
 * @author 2dam
 */
public class UserManagerFactory {

    private String tipo;
    private User user;

    public UserManagerFactory() {
        try {
            tipo = ResourceBundle.getBundle("dataAccess.AccessorDataSelector", Locale.getDefault()).getString("dataAccessor");
        } catch (Exception e) {
            System.out.println("Error al cargar el ResourceBundle: " + e.getMessage());
            //tipo = "DB";
        }
    }

    public User createFactory() {
        if (tipo.equals("DB")) {
            DBUserDataAccessor dataAccess = new DBUserDataAccessor();
            user = dataAccess.fetchData();
        } else if (tipo.equals("Properties file")) {
            FileUserDataAccessor dataAccess = new FileUserDataAccessor();
            user = dataAccess.fetchData();
        } else {
            System.out.println("Error! Debes seleccionar DB/Properties file en el archivo AccessorDataSelector");
           user = null;
        }
        return user;
    }
}
