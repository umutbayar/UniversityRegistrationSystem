import org.junit.Test;
import static org.junit.Assert.*;

public class StaffTest {

    @Test
    public void testDefaultConstructor() {
        Staff staff = new Staff();
        assertNull(staff.getStaffID());
        assertNull(staff.getDepartment());
    }

    @Test
    public void testParameterizedConstructor() {
        String staffID = "S123";
        String department = "IT";
        Staff staff = new Staff(staffID, department);
        assertEquals(staffID, staff.getStaffID());
        assertEquals(department, staff.getDepartment());
    }

    @Test
    public void testSetStaffID() {
        Staff staff = new Staff();
        String staffID = "S456";
        staff.setStaffID(staffID);
        assertEquals(staffID, staff.getStaffID());
    }

    @Test
    public void testSetDepartment() {
        Staff staff = new Staff();
        String department = "BIOLOGY";
        staff.setDepartment(department);
        assertEquals(department, staff.getDepartment());
    }
}
