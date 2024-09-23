package model;

/**
 * The User class represents a user with attributes such as DNI, username, password, and full name.
 * It provides methods to access and modify these attributes.
 * 
 * @author Alder and Borja
 */
public class User {

    // User attributes
    private String dni;
    private String username;
    private String password;
    private String fullName;

    /**
     * Constructs a User object with the specified attributes.
     * 
     * @param dni The user's DNI.
     * @param username The user's username.
     * @param password The user's password.
     * @param fullName The user's full name.
     */
    public User(String dni, String username, String password, String fullName) {
        this.dni = dni;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    // User attributes getters and setters

    /** 
     * Returns the user's DNI.
     * 
     * @return The user's DNI.
     */
    public String getDni() {
        return dni;
    }

    /** 
     * Sets the user's DNI.
     * 
     * @param dni The new DNI to set.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /** 
     * Returns the user's username.
     * 
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /** 
     * Sets the user's username.
     * 
     * @param username The new username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /** 
     * Returns the user's password.
     * 
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Sets the user's password.
     * 
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * Returns the user's full name.
     * 
     * @return The user's full name.
     */
    public String getFullName() {
        return fullName;
    }

    /** 
     * Sets the user's full name.
     * 
     * @param fullName The new full name to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
