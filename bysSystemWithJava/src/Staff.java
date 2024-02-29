/**
 * The Staff class represents a staff member with information such as a staff ID and department.
 * It extends the User class and includes methods to retrieve and set staff information.
 *
 * @author ??
 * @version 1.0
 * @since 2023-12-10
 */
public class Staff extends User {
    private String staffID;
    private String department;

    /**
     * Default constructor for Staff.
     * Creates an instance with default values.
     */
    public Staff() {
        // Default constructor
    }

    /**
     * Constructor for Staff with specified staff ID and department.
     *
     * @param staffID    The staff ID.
     * @param department The department where the staff member works.
     */
    public Staff(String staffID, String department) {
        this.staffID = staffID;
        this.department = department;
    }

    /**
     * Retrieves the staff ID.
     *
     * @return The staff ID.
     */
    public String getStaffID() {
        return staffID;
    }

    /**
     * Sets the staff ID.
     *
     * @param staffID The new staff ID to set.
     */
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    /**
     * Retrieves the department where the staff member works.
     *
     * @return The department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department where the staff member works.
     *
     * @param department The new department to set.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInfo() {
        return "Staff Info:" + "\nName: " + this.getName() + "\nLastname: " + this.getLastName() + "\nBirthdate: "
                + this.getBirthDate() + "\nAddress: " + this.getAddress() + "\nSSN: " + this.getSsn() + "\nEmail: "
                + this.getEmail();
    }
}
