import java.util.ArrayList;

public class Advisor extends Lecturer {

    private ArrayList<Draft> drafts = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    public String getInfo() {
        return "Advisor Info:" + "\nName: " + this.getName() + "\nLastname: " + this.getLastName() + "\nBirthdate: "
                + this.getBirthDate() + "\nAddress: " + this.getAddress() + "\nSSN: " + this.getSsn() + "\nEmail: "
                + this.getEmail();
    }

    public void addDraft(Draft draft) {
        this.drafts.add(draft);
    }

    public ArrayList<Draft> getDrafts() {
        return drafts;
    }

    public void setDrafts(ArrayList<Draft> drafts) {
        this.drafts = drafts;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void processDrafts() {
        for (Draft draft : drafts) {
            for (Course course : draft.getCourses()) {
                if (course.isApproved()) {
                    draft.getStudent().addToRegisteredCourses(course);
                }
            }
        }
        drafts.clear();
    }
}
