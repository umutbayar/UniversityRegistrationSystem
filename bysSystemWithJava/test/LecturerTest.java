import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class LecturerTest {

    private Lecturer lecturer;
    private ArrayList<Course> courses;

    @Before
    public void setUp() {

        lecturer = new Lecturer("Data Science");
        lecturer.setStaffID("160555");
        lecturer.setName("Ayşe");
        lecturer.setLastName("Deniz");
        lecturer.setBirthDate("13:03:96.454+0530");
        lecturer.setAddress("Ankara, Turkey");
        lecturer.setSsn("33333333333");
        lecturer.setEmail("aysedeniz@gmail.com");

        courses = new ArrayList<>();

        Course course1 = new Course();
        
        course1.setCredits(4);
        course1.setYear(2);
        course1.setCourseName("Anthropology");
        course1.setCourseCode("ANTH202");
        course1.setPrequisite("");

        
        course1.setCourseLecturer(lecturer);
        
         Course course2 = new Course();
        
        course2.setCredits(3);
        course2.setYear(1);
        course2.setCourseName("Introduction to Computer Programming");
        course2.setCourseCode("CSE101");
        course2.setPrequisite("CSE100");

        course2.setCourseLecturer(lecturer);
        courses.add(course1);
        courses.add(course2);
    }

    @Test
    public void testFindAllCourseInstances() {
        lecturer.findAllCourseInstances(courses);

        ArrayList<CourseInstance> courseInstances = lecturer.getCourseInstances();
        assertEquals(2, courseInstances.size()); 
        assertEquals("ANTH202", courseInstances.get(0).getCourseCode());
        assertEquals("CSE101", courseInstances.get(1).getCourseCode());
        assertEquals("Anthropology", courseInstances.get(0).getCourseName());
        assertEquals("Introduction to Computer Programming", courseInstances.get(1).getCourseName());
        assertEquals("160555", courseInstances.get(0).getCourseLecturerID());
    }

    @Test
    public void testGetProfession() {
        assertEquals("Data Science", lecturer.getProfession());
    }

    @Test
    public void testSetProfession() {
        lecturer.setProfession("Data Science");
        assertEquals("Data Science", lecturer.getProfession());
    }

    @Test
    public void testGetInfo() {
        String expectedInfo = "Lecturer Info:\nName: Ayşe\nLastname: Deniz\nBirthdate: 13:03:96.454+0530\nAddress: Ankara, Turkey\nSSN: 33333333333\nEmail: aysedeniz@gmail.com";
        assertEquals(expectedInfo, lecturer.getInfo());
    }
}
