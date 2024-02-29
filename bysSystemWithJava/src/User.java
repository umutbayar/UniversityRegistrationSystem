/**
 * The abstract class representing a user with basic information.
 * This class provides getters and setters for user attributes.
 * Subclasses should extend this class to add specific functionality.
 *
 * @author yigit_tuncer
 * @version 1.0
 * @since 2023-12-10
 */
public abstract class User {

    /**
     * The first name of the user.
     */
    private String name;

    /**
     * The last name of the user.
     */
    private String lastName;

    /**
     * The birthdate of the user in the format yyyy-MM-dd.
     */
    private String birthDate;

    /**
     * The address of the user.
     */
    private String address;

    /**
     * The Social Security Number (SSN) of the user.
     */
    private String ssn;

    /**
     * The email address of the user.
     */
    private String email;

    /**
     * The password associated with the user's account.
     */
    private String password;

    /**
     * Implement an abstract method for Polymorphism.
     */
    public abstract String getInfo();

    /**
     * Retrieves the first name of the user.
     *
     * @return The user's first name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the last name of the user.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the birthdate of the user.
     *
     * @return The user's birthdate in the format yyyy-MM-dd.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Retrieves the address of the user.
     *
     * @return The user's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Retrieves the Social Security Number (SSN) of the user.
     *
     * @return The user's SSN.
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the password associated with the user's account.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the first name of the user.
     *
     * @param name The new first name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the birthdate of the user.
     *
     * @param birthDate The new birthdate in the format yyyy-MM-dd.
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Sets the address of the user.
     *
     * @param address The new address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the Social Security Number (SSN) of the user.
     *
     * @param ssn The new SSN.
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the password associated with the user's account.
     *
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
