package dataAccess;

import java.util.ResourceBundle;
import model.User;

/**
 *
 * @author 2dam
 */
public class FileUserDataAccessor implements DataAccessible {

    @Override
    public User fetchData() {
        String dni = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.dni");
        String username = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.username");
        String password = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.password");
        String fullName = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.fullName");
        
        User user = new User(dni,username,password,fullName);
        return user;
    }

}
