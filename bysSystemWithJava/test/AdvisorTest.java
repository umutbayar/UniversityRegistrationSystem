import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class AdvisorTest {

    private Advisor advisor;
    private Student student;
    private Draft draft;

    @Before
    public void setUp() {
        advisor = new Advisor();
        student = new Student();
        draft = new Draft();
    }

    @Test
    public void testAddDraft() {
        advisor.addDraft(draft);
        ArrayList<Draft> drafts = advisor.getDrafts();
        assertEquals(1, drafts.size());
        assertEquals(draft, drafts.get(0));
    }

    @Test
    public void testAddStudent() {
        advisor.addStudent(student);
        ArrayList<Student> students = advisor.getStudents();
        assertEquals(1, students.size());
        assertEquals(student, students.get(0));
    }

    @Test
    public void testProcessDrafts() {
        Course course = new Course();

        draft.setStudent(student);
    
        draft.getStudent().addToRegisteredCourses(course);
        
        advisor.addStudent(student);
        advisor.addDraft(draft);
    
        advisor.processDrafts();
    
        assertTrue(student.getRegisteredCourses().contains(course));
        assertTrue(advisor.getDrafts().isEmpty());        
    }
}
