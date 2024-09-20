package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import model.User;

public class DBUserDataAccessor implements DataAccessible {
    
    private String url = "jdbc:mysql://localhost:3306/DBUser?serverTimezone=Europe/Madrid";
    private String user = "root";
    private String passwd = "abcd*1234";
    
    @Override
    public User fetchData() {
        try {
            // Conectar a la base de datos
            Connection connection = DriverManager.getConnection(url, user, passwd);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            
            String dni = "";
            String username = "";
            String password = "";
            String fullName = "";
            // Leer los datos
            while (resultSet.next()) {
                dni = resultSet.getString("dni");
                username = resultSet.getString("username");
                password = resultSet.getString("passwd");
                fullName = resultSet.getString("fullName");
                
            }
            User user = new User(dni, username, password, fullName);

            // Cerrar conexión
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                System.out.print("fallo");
            }
            
            return user;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
