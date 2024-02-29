import java.util.ArrayList;

public class Course {
	private Student student = new Student();
	private Advisor advisor = new Advisor();
	private Lecturer courseLecturer = new Lecturer();
	private Grade grade = new Grade();
	private String courseName;
	private String courseCode;
	private String prequisite;
	private long credits;
	private long year = 0;
	private boolean isPrerequisitesCompleted;
	private boolean isCompleted;
	private boolean isApproved;

	public long getYear() {
		return this.year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getPrequisite() {
		return prequisite;
	}

	public void setPrequisite(String prequisite) {
		this.prequisite = prequisite;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Lecturer getCourseLecturer() {
		return courseLecturer;
	}

	public void setCourseLecturer(Lecturer courseLecturer) {
		this.courseLecturer = courseLecturer;
	}

	public long getCredits() {
		return credits;
	}

	public void setCredits(long credits) {
		this.credits = credits;
	}

	public boolean isPrerequisitesCompleted(String course) {

		if (course.equals("")) {
			this.isPrerequisitesCompleted = true;
			return isPrerequisitesCompleted;
		}

		ArrayList<Course> registeredCourses = getStudent().getRegisteredCourses();
		for (Course registeredCourse : registeredCourses) {

			if (course.equals(registeredCourse.getCourseCode())) {
				Grade grade1 = registeredCourse.getGrade();
				if (!grade1.getLetterGrade().equals("FF") && registeredCourse.isCompleted()) {
					isPrerequisitesCompleted = true;
					break;
				}
			}
		}
		return isPrerequisitesCompleted;
	}

	public void setPrerequisitesCompleted(boolean prequisiteCompleted) {
		this.isPrerequisitesCompleted = prequisiteCompleted;
	}

	public boolean getPrerequisitesCompleted() {
		return this.isPrerequisitesCompleted;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void approve() {
		isApproved = true;
	}

	public void setIsCompleted(boolean completed) {
		this.isCompleted = completed;
	}
}
