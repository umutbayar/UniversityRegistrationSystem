import java.util.ArrayList;

/**
 * The Draft class represents a draft of courses selected by a student. It
 * contains methods
 * for managing the draft, such as checking if a course is in the draft,
 * retrieving the list
 * of courses, and manipulating the contents of the draft.
 *
 * @author yigit_tuncer
 * @version 13.0
 * @since 2023-12-10
 */
public class Draft {

    private ArrayList<Course> courses = new ArrayList<>();
    private Student student;

    /**
     * Checks if a given course is present in the draft.
     *
     * @param course The course to check for.
     * @return true if the course is in the draft, false otherwise.
     */
    public boolean hasCourse(Course course) {
        for (Course draftCourse : courses) {
            if (draftCourse.getCourseCode().equals(course.getCourseCode())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCourse(String courseCode) {
        for (Course draftCourse : courses) {
            if (draftCourse.getCourseCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the list of courses in the draft.
     *
     * @return The list of courses in the draft.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses in the draft.
     *
     * @param courses The new list of courses to set.
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public boolean removeCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                courses.remove(course);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the draft is empty.
     *
     * @return true if the draft is empty, false otherwise.
     */
    public boolean isEmpty() {
        return courses.isEmpty();
    }

    /**
     * Retrieves the number of courses in the draft.
     *
     * @return The number of courses in the draft.
     */
    public int getNumberOfClasses() {
        return courses.size();
    }

    /**
     * Clears the contents of the draft, removing all courses.
     */
    public void clearDraft() {
        courses.clear();
    }

    /**
     * Adds a course to the draft.
     *
     * @param course The course to add to the draft.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Retrieves the student associated with the draft.
     *
     * @return The student associated with the draft.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the student associated with the draft.
     *
     * @param student The new student to associate with the draft.
     */
    public void setStudent(Student student) {
        this.student = student;
    }
}
