import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The Transcript class represents a student's academic transcript,
 * including a list of courses and the calculated GPA.
 * It provides methods to add courses, retrieve the course list,
 * and get the GPA.
 *
 * @author mehmet_sina
 * @version 1.0
 * @since 2023-12-10
 */
public class Transcript {
    private ArrayList<Course> courses;
    private double GPA;

    /**
     * Constructs a new Transcript object with an empty list of courses
     * and initializes the GPA to 0.0.
     */
    public Transcript() {
        this.courses = new ArrayList<>();
        this.GPA = 0.0;
    }

    /**
     * Adds a course to the transcript and updates the GPA.
     *
     * @param course The course to be added.
     */
    public void addCourse(Course course) {
        courses.add(course);
        updateGPA();
    }

    /**
     * Retrieves the list of courses in the transcript.
     *
     * @return The list of courses.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses in the transcript and updates the GPA.
     *
     * @param courses The new list of courses.
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
        updateGPA();
    }

    /**
     * Retrieves the GPA of the student.
     *
     * @return The GPA.
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * Updates the GPA based on the grades and credits of the courses.
     * The GPA is calculated using a weighted sum of grades and credits.
     */
    private void updateGPA() {
        double totalCredits = 0.0;
        double weightedSum = 0.0;

        for (Course course : courses) {
            totalCredits += course.getCredits();
            weightedSum += course.getCredits() * course.getGrade().getOutOfHundred();
        }

        if (totalCredits > 0) {
            GPA = (weightedSum / totalCredits) / 25;
        } else {
            GPA = 0.0;
        }
    }

    /**
     * Generates a string representation of the transcript,
     * including course details and GPA.
     *
     * @return The string representation of the transcript.
     */
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedGPA = decimalFormat.format(GPA);
        StringBuilder result = new StringBuilder("Transcript: \n");

        for (Course course : courses) {
            result.append("Course Code: ").append(course.getCourseCode())
                    .append(", Course Name: ").append(course.getCourseName())
                    .append(", Credit: ").append(course.getCredits())
                    .append(", Letter Grade: ").append(course.getGrade().getLetterGrade())
                    .append("\n");
        }

        result.append("GPA: ").append(formattedGPA);
        return result.toString();
    }
}
