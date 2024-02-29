import java.util.ArrayList;

/* This class is created to make an interconnection between the students and teachers. By using this class we can see which teacher gives which lecture and which students are attending */

public class CourseInstance {

    private final long maxNumberStudents = 50;

    private String courseCode = "";
    private String courseName = "";
    private String courseLecturerID = "";
    private ArrayList<Student> registeredStudents = new ArrayList<>();

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseLecturerID() {
        return courseLecturerID;
    }

    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseLecturerID(String courseLecturerID) {
        this.courseLecturerID = courseLecturerID;
    }

    public void setRegisteredStudents(ArrayList<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

}
