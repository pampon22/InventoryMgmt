package com.skillstorm.models;


/**
 * User model for creating an object to access User login info from the database
 * will get back to see if I need setters her for security purposes
 * @author phil
 *
 */
public class User {

    private int id;
    private String fullname;
    private String email;
    private String password;
	
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This function returns the id of the object.
	 * 
	 * @return The id of the object.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This function sets the id of the object to the value of the parameter id.
	 * 
	 * @param id The id of the user.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This function returns the fullname of the user
	 * 
	 * @return The fullname of the person.
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * > This function sets the fullname of the user
	 * 
	 * @param fullname The full name of the user.
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	/**
	 * > This function returns the email of the user
	 * 
	 * @return The email address of the user.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * > This function sets the email of the user
	 * 
	 * @param email The email address of the user.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This function returns the password.
	 * 
	 * @return The password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * This function sets the password of the user.
	 * 
	 * @param password The password to use when connecting to the database.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * The toString() method returns a string representation of the object
	 * 
	 * @return The toString() method is being returned.
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password + "]";
	} 
}
