import java.util.ArrayList;

/**
 * The Lecturer class represents a staff member with additional information related to being a lecturer,
 * including the lecturer's profession and the list of course instances they are associated with.
 * It extends the Staff class, inheriting staff-related information.
 *
 * @author ??
 * @version 1.0
 * @since 2023-12-10
 */
public class Lecturer extends Staff {

    private String profession;
    private ArrayList<CourseInstance> courseInstances = new ArrayList<>();

    /**
     * Default constructor for Lecturer.
     * Creates an instance with default values.
     */
    public Lecturer() {
        // Default constructor
    }

    /**
     * Constructor for Lecturer with specified profession.
     *
     * @param profession The profession of the lecturer.
     */
    public Lecturer(String profession) {
        this.profession = profession;
    }

    /**
     * This method sets all the courses a lecturer actively has.
     *
     * @param courses The list of all courses.
     */
    public void findAllCourseInstances(ArrayList<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseLecturer().getStaffID().equals(getStaffID())) {
                CourseInstance courseInstance = new CourseInstance();
                courseInstance.setCourseCode(courses.get(i).getCourseCode());
                courseInstance.setCourseName(courses.get(i).getCourseName());
                courseInstance.setCourseLecturerID(getStaffID());
                courseInstances.add(courseInstance);
            }
        }
    }

    /**
     * Retrieves the list of course instances associated with the lecturer.
     *
     * @return The list of course instances.
     */
    public ArrayList<CourseInstance> getCourseInstances() {
        return courseInstances;
    }

    /**
     * Sets the list of course instances associated with the lecturer.
     *
     * @param courseInstances The new list of course instances to set.
     */
    public void setCourseInstances(ArrayList<CourseInstance> courseInstances) {
        this.courseInstances = courseInstances;
    }

    /**
     * Retrieves the profession of the lecturer.
     *
     * @return The profession of the lecturer.
     */
    public String getProfession() {
        return profession;
    }

    /**
     * Sets the profession of the lecturer.
     *
     * @param profession The new profession to set.
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getInfo() {
        return "Lecturer Info:" + "\nName: " + this.getName() + "\nLastname: " + this.getLastName() + "\nBirthdate: "
                + this.getBirthDate() + "\nAddress: " + this.getAddress() + "\nSSN: " + this.getSsn() + "\nEmail: "
                + this.getEmail();
    }
}
