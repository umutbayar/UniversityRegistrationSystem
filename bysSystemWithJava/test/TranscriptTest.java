import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class TranscriptTest {

    private Transcript transcript;
    private Course course1;
    private Course course2;
    private Grade grade1;
    private Grade grade2;

    @Before
    public void setUp() {
        transcript = new Transcript();

        course1 = new Course();
        course1.setCourseCode("CSE101");
        course1.setCourseName("Programming");
        course1.setCredits(2);

        course2 = new Course();
        course2.setCourseCode("CSE102");
        course2.setCourseName("Data Structures");
        course2.setCredits(2);

        grade1 = new Grade();
        grade1.setOutOfHundred(100);
        grade1.setGano(4);
        grade1.setLetterGrade("AA");
        course1.setGrade(grade1);

        grade2 = new Grade();
        grade2.setOutOfHundred(75);
        grade2.setGano(3);
        grade2.setLetterGrade("BB");
        course2.setGrade(grade2);
    }

    @Test
    public void testAddCourse() {

        transcript.addCourse(course1);
        transcript.addCourse(course2);

        ArrayList<Course> courses = transcript.getCourses();

        Course course3 = new Course();
        course3.setCourseCode("MATH100");
        course3.setCourseName("Calculus 1");

        assertEquals(2, courses.size());
        assertTrue(courses.contains(course1));
        assertTrue(courses.contains(course2));
        assertFalse(courses.contains(course3));
    }

    @Test
    public void testUpdateGPA() {

        course1.setGrade(grade1);
        course2.setGrade(grade2);

        transcript.addCourse(course1);
        transcript.addCourse(course2);

        assertEquals(3.5, transcript.getGPA(), 0.01);

        Course course3 = new Course();
        course3.setCourseCode("CSE300");
        course3.setCourseName("Assembly");
        course3.setCredits(2);
        Grade grade3 = new Grade();
        grade3.setOutOfHundred(50);
        grade3.setGano(2);
        course3.setGrade(grade3);

        transcript.addCourse(course3);

        assertEquals(3, transcript.getGPA(), 0.01);
    }

    @Test
    public void testToString() {

        transcript.addCourse(course1);
        transcript.addCourse(course2);

        String expectedString = "Transcript: \n" +
                "Course Code: CSE101, Course Name: Programming, Credit: 2, Letter Grade: AA\n" +
                "Course Code: CSE102, Course Name: Data Structures, Credit: 2, Letter Grade: BB\n" +
                "GPA: 3,5";

        assertEquals(expectedString, transcript.toString());
    }
}
