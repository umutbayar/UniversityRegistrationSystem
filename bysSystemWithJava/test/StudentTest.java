import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class StudentTest {

    @Test
    public void testGetEligibleCourses() {
        Student student = new Student();
        student.setYear(2);

        Course course1 = new Course();
        course1.setCourseCode("CSE101");
        course1.setIsCompleted(true);
        course1.setPrequisite("");
        Course course2 = new Course();
        course2.setCourseCode("CSE102");
        course2.setIsCompleted(true);
        course2.setPrequisite("");
        Course course3 = new Course();
        course3.setCourseCode("CSE104");
        course3.setIsCompleted(true);
        course3.setPrequisite("CSE103");

        ArrayList<Course> allCourses = new ArrayList<>();

        student.addToRegisteredCourses(course1);

        allCourses.add(course1);
        allCourses.add(course2);
        allCourses.add(course3);

        ArrayList<Course> registeredCourses = new ArrayList<>();
        registeredCourses.add(course1);
        student.setRegisteredCourses(registeredCourses);

        ArrayList<Course> eligibleCourses = student.getEligableCourses(allCourses);

        assertEquals(1, eligibleCourses.size());
        assertTrue(eligibleCourses.contains(course2));
        assertFalse(eligibleCourses.contains(course3));
    }

    @Test
    public void testSendDraftToAdvisor() {
        Student student = new Student();
        Advisor advisor = new Advisor();
        student.setAdvisor(advisor);

        Draft draft = new Draft();
        Course course1 = new Course();
        course1.setCourseCode("CSE101");
        draft.addCourse(course1);
        student.setDraft(draft);

        student.sendDraftToAdvisor(student.getAdvisor());

        assertTrue(advisor.getDrafts().contains(draft));
    }
}