/**
 * The StudentAffairsStaff class represents staff members working in student affairs.
 * It extends the Staff class and includes additional information about the working field.
 *
 * @author ??
 * @version 1.0
 * @since 2023-12-10
 */
public class StudentAffairsStaff extends Staff {

    /**
     * The specific working field of the student affairs staff member.
     */
    private String workingField;

    /**
     * Default constructor for StudentAffairsStaff.
     * Creates an instance with default values.
     */
    public StudentAffairsStaff() {
        // Default constructor
    }

    /**
     * Constructor for StudentAffairsStaff with a specified working field.
     *
     * @param workingField The working field of the student affairs staff.
     */
    public StudentAffairsStaff(String workingField) {
        this.workingField = workingField;
    }

    public String getInfo() {
        return "Student Affairs Staff Info:" + "\nName: " + this.getName() + "\nLastname: " + this.getLastName() + "\nBirthdate: "
                + this.getBirthDate() + "\nAddress: " + this.getAddress() + "\nSSN: " + this.getSsn() + "\nEmail: "
                + this.getEmail();
    }

    public void studentUpdate(Student updatedStudent, String studentId){
        updatedStudent.setStudentId(studentId);
    }
    /**
     * Retrieves the working field of the student affairs staff.
     *
     * @return The working field.
     */
    public String getWorkingField() {
        return workingField;
    }

    /**
     * Retrieves the working field of the student affairs staff.
     *
     * @return The working field.
    /**
     * Sets the working field of the student affairs staff.
     *
     * @param workingField The new working field to set.
     */
    public void setWorkingField(String workingField) {
        this.workingField = workingField;
    }

}
