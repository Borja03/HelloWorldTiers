/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class FileUserDataAccessor {
    //Get user info from properties file
    //Getting dni
    String static final USER_DNI = ResourceBundle.getBundle("dataAccess.userInfo").getString("user.dni");
    //Getting username
    //Getting password
    //Getting fullName
}
