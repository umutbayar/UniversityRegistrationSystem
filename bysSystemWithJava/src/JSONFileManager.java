import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import json.JSONArray;
import json.JSONObject;
import json.parser.JSONParser;
import json.parser.ParseException;

public class JSONFileManager {
    private ArrayList<Advisor> advisors = new ArrayList<>();
    private ArrayList<Lecturer> lecturers = new ArrayList<>();
    private ArrayList<StudentAffairsStaff> studentAffairsStaffs = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public JSONFileManager() {
        getAllCoursesData();
        getAllStudentsData();
        getAllAdvisorsData();
        getAllLecturersData();
        getAllStudentAffairsStaffsData();
    }

    public void writeAllDataToJSON() {
        writeAllStudentsData();
        writeAllAdvisorsData();
        writeAllLecturersData();
        writeAllStudentAffairsStaffsData();
        writeAllCoursesData();

    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<StudentAffairsStaff> getStudentAffairsStaffs() {
        return studentAffairsStaffs;
    }

    public void setStudentAffairsStaffs(ArrayList<StudentAffairsStaff> studentAffairsStaffs) {
        this.studentAffairsStaffs = studentAffairsStaffs;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public ArrayList<Advisor> getAdvisors() {
        return advisors;
    }

    public void setAdvisors(ArrayList<Advisor> advisors) {
        this.advisors = advisors;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    private void writeAllCoursesData() {

        try {

            for (Course course : courses) {
                JSONObject courseJSON = new JSONObject();

                courseJSON.put("courseName", course.getCourseName());
                courseJSON.put("credits", course.getCredits());
                courseJSON.put("courseCode", course.getCourseCode());
                courseJSON.put("prerequisite", course.getPrequisite());
                courseJSON.put("courseLecturer", course.getCourseLecturer().getStaffID());
                courseJSON.put("year", course.getYear());

                try (FileWriter fileWriter = new FileWriter("database/courses/" + course.getCourseCode() + ".json")) {
                    fileWriter.write(courseJSON.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllCoursesData() {

        try {
            String folderPath = "database/courses";

            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".json")) {
                        try {
                            FileReader fileReader = new FileReader(file);
                            JSONParser jsonParser = new JSONParser();
                            Object obj = jsonParser.parse(fileReader);
                            JSONObject jsonObject = (JSONObject) obj;

                            Course course = new Course();
                            course.setCourseName((String) jsonObject.get("courseName"));
                            course.setCourseCode((String) jsonObject.get("courseCode"));
                            course.setPrequisite((String) jsonObject.get("prerequisite"));

                            course.setCredits((long) jsonObject.get("credits"));
                            course.setYear((long) jsonObject.get("year"));

                            Lecturer lecturer = new Lecturer();
                            lecturer.setStaffID((String) jsonObject.get("courseLecturer"));

                            course.setCourseLecturer(lecturer);

                            courses.add(course);

                            fileReader.close();
                        } catch (IOException | ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } else {
                System.out.println("No file in database.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeAllStudentsData() {

        try {
            for (Student student : students) {
                JSONObject studentJson = new JSONObject();

                studentJson.put("firstName", student.getName());
                studentJson.put("lastName", student.getLastName());
                studentJson.put("birthDate", student.getBirthDate());
                studentJson.put("address", student.getAddress());
                studentJson.put("ssn", student.getSsn());
                studentJson.put("email", student.getEmail());
                studentJson.put("password", student.getPassword());
                studentJson.put("studentId", student.getStudentId());
                studentJson.put("year", student.getYear());

                JSONArray registeredCoursesArray = new JSONArray();
                for (Course course : student.getRegisteredCourses()) {
                    JSONObject courseJson = new JSONObject();

                    courseJson.put("courseName", course.getCourseName());
                    courseJson.put("courseCode", course.getCourseCode());
                    courseJson.put("courseCode", course.getCourseCode());
                    courseJson.put("courseLecturer", course.getCourseLecturer().getStaffID());
                    courseJson.put("credits", course.getCredits());
                    courseJson.put("grade", course.getGrade().getOutOfHundred());
                    courseJson.put("isCompleted", course.isCompleted());

                    registeredCoursesArray.add(courseJson);
                }

                studentJson.put("registeredCourses", registeredCoursesArray);

                // JSONArray coursesWaitingForApprovalArray = new JSONArray();
                /*
                 * for (Course course : student.getDraftForCourses()) {
                 * JSONObject draftJSON = new JSONObject();
                 * 
                 * draftJSON.put("courseName", course.getCourseName());
                 * draftJSON.put("courseCode", course.getCourseCode());
                 * draftJSON.put("courseCode", course.getCourseCode());
                 * draftJSON.put("courseLecturer", course.getCourseLecturer().getStaffID());
                 * draftJSON.put("credits", course.getCredits());
                 * draftJSON.put("advisor", student.getAdvisor().getStaffID());
                 * 
                 * coursesWaitingForApprovalArray.add(draftJSON);
                 * }
                 * 
                 * studentJson.put("coursesWaitingForApproval", coursesWaitingForApprovalArray);
                 */

                studentJson.put("advisorId", student.getAdvisor().getStaffID());

                try (FileWriter fileWriter = new FileWriter("database/students/" + student.getStudentId() + ".json")) {
                    fileWriter.write(studentJson.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeAllAdvisorsData() {
        try {
            for (Advisor advisor : advisors) {
                JSONObject advisorJson = new JSONObject();
                advisorJson.put("firstName", advisor.getName());
                advisorJson.put("lastName", advisor.getLastName());
                advisorJson.put("birthDate", advisor.getBirthDate());
                advisorJson.put("address", advisor.getAddress());
                advisorJson.put("ssn", advisor.getSsn());
                advisorJson.put("email", advisor.getEmail());
                advisorJson.put("password", advisor.getPassword());
                advisorJson.put("advisorId", advisor.getStaffID());
                advisorJson.put("profession", advisor.getProfession());

                JSONArray draftsArray = new JSONArray();
                for (Draft draft : advisor.getDrafts()) {
                    JSONObject draftObject = new JSONObject();
                    draftObject.put("studentId", draft.getStudent().getStudentId());

                    JSONArray coursesArray = new JSONArray();
                    for (Course course : draft.getCourses()) {
                        JSONObject courseObject = new JSONObject();
                        courseObject.put("courseName", course.getCourseName());
                        courseObject.put("credits", course.getCredits());
                        courseObject.put("courseCode", course.getCourseCode());
                        courseObject.put("prerequisite", course.getPrequisite());
                        courseObject.put("courseLecturer", course.getCourseLecturer().getStaffID());

                        coursesArray.add(courseObject);
                    }
                    draftObject.put("courses", coursesArray);

                    draftsArray.add(draftObject);
                }
                advisorJson.put("drafts", draftsArray);

                try (FileWriter fileWriter = new FileWriter("database/advisors/" + advisor.getStaffID() + ".json")) {
                    fileWriter.write(advisorJson.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getAllAdvisorsData() {
        try {

            String folderPath = "database/advisors";

            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".json")) {
                        try {
                            FileReader fileReader = new FileReader(file);
                            JSONParser jsonParser = new JSONParser();
                            Object obj = jsonParser.parse(fileReader);
                            JSONObject jsonObject = (JSONObject) obj;

                            Advisor advisor = new Advisor();
                            advisor.setName((String) jsonObject.get("firstName"));
                            advisor.setLastName((String) jsonObject.get("lastName"));
                            advisor.setBirthDate((String) jsonObject.get("birthDate"));
                            advisor.setAddress((String) jsonObject.get("address"));
                            advisor.setSsn((String) jsonObject.get("ssn"));
                            advisor.setEmail((String) jsonObject.get("email"));
                            advisor.setPassword((String) jsonObject.get("password"));
                            advisor.setStaffID((String) jsonObject.get("advisorId"));
                            advisor.setProfession((String) jsonObject.get("profession"));
                            advisor.setDepartment((String) jsonObject.get("department"));

                            ArrayList<Draft> draftsList = new ArrayList<>();

                            JSONArray drafts = (JSONArray) jsonObject.get("drafts");

                            for (Object draftObj : drafts) {

                                Draft draftObject = new Draft();

                                ArrayList<Course> coursesObject = new ArrayList<>();

                                JSONObject draft = (JSONObject) draftObj;

                                Student student = new Student();

                                student.setStudentId((String) draft.get("studentId"));

                                draftObject.setStudent(student);

                                JSONArray courses = (JSONArray) draft.get("courses");

                                for (Object courseObj : courses) {

                                    Course courseObject = new Course();

                                    JSONObject course = (JSONObject) courseObj;

                                    courseObject.setCourseName((String) course.get("courseName"));
                                    courseObject.setCredits((long) course.get("credits"));
                                    courseObject.setCourseCode((String) course.get("courseCode"));
                                    courseObject.setPrequisite((String) course.get("prerequisite"));

                                    Lecturer lecturer = new Lecturer();

                                    lecturer.setStaffID((String) course.get("courseLecturer"));

                                    courseObject.setCourseLecturer(lecturer);

                                    coursesObject.add(courseObject);

                                }
                                draftObject.setCourses(coursesObject);

                                draftsList.add(draftObject);
                            }

                            advisor.setDrafts(draftsList);

                            advisors.add(advisor);

                            fileReader.close();
                        } catch (IOException | ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } else {
                System.out.println("No file in database.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getAllStudentsData() {
        try {
            String folderPath = "database/students";

            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".json")) {
                        try {
                            FileReader fileReader = new FileReader(file);
                            JSONParser jsonParser = new JSONParser();
                            Object obj = jsonParser.parse(fileReader);
                            JSONObject jsonObject = (JSONObject) obj;

                            Student student = new Student();
                            student.setName((String) jsonObject.get("firstName"));
                            student.setLastName((String) jsonObject.get("lastName"));
                            student.setBirthDate((String) jsonObject.get("birthDate"));
                            student.setAddress((String) jsonObject.get("address"));
                            student.setSsn((String) jsonObject.get("ssn"));
                            student.setEmail((String) jsonObject.get("email"));
                            student.setPassword((String) jsonObject.get("password"));
                            student.setStudentId((String) jsonObject.get("studentId"));
                            student.setYear((long) jsonObject.get("year"));

                            ArrayList<Course> registeredCoursesList = new ArrayList<>();

                            JSONArray registeredCoursesJSON = (JSONArray) jsonObject.get("registeredCourses");

                            for (Object courseObj : registeredCoursesJSON) {

                                JSONObject courseJSON = (JSONObject) courseObj;

                                Course registeredCourse = new Course();

                                registeredCourse.setCourseName((String) courseJSON.get("courseName"));
                                registeredCourse.setCourseCode((String) courseJSON.get("courseCode"));
                                registeredCourse.setIsCompleted((boolean) courseJSON.get("isCompleted"));

                                Lecturer lecturer = new Lecturer();
                                lecturer.setStaffID((String) courseJSON.get("courseLecturer"));
                                registeredCourse.setCourseLecturer(lecturer);

                                registeredCourse.setCredits((long) courseJSON.get("credits"));

                                // ADD GRADE
                                Grade grade = new Grade();
                                try {
                                    Double gradeValue = ((Number) courseJSON.get("grade")).doubleValue();
                                    grade.setOutOfHundred(gradeValue);
                                    grade.convertHundredToGano(gradeValue);
                                    grade.convertHundredToLetterGrade(gradeValue);
                                    registeredCourse.setGrade(grade);

                                } catch (Exception e) {
                                }

                                // ADD prerequisite

                                registeredCourse.setPrerequisitesCompleted(true);
                                registeredCoursesList.add(registeredCourse);

                            }

                            Transcript transcript = new Transcript();

                            transcript.setCourses(registeredCoursesList);

                            student.setTranscript(transcript);

                            student.setRegisteredCourses(registeredCoursesList);

                            Advisor advisor = new Advisor();

                            advisor.setStaffID((String) jsonObject.get("advisorId"));

                            student.setAdvisor(advisor);

                            students.add(student);

                            fileReader.close();
                        } catch (IOException | ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } else {
                System.out.println("No file in database.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getAllLecturersData() {

        try {
            String folderPath = "database/lecturers";

            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".json")) {
                        try {
                            FileReader fileReader = new FileReader(file);
                            JSONParser jsonParser = new JSONParser();
                            Object obj = jsonParser.parse(fileReader);
                            JSONObject jsonObject = (JSONObject) obj;

                            Lecturer lecturer = new Lecturer();
                            lecturer.setName((String) jsonObject.get("firstName"));
                            lecturer.setLastName((String) jsonObject.get("lastName"));
                            lecturer.setBirthDate((String) jsonObject.get("birthDate"));
                            lecturer.setAddress((String) jsonObject.get("address"));
                            lecturer.setSsn((String) jsonObject.get("ssn"));
                            lecturer.setEmail((String) jsonObject.get("email"));
                            lecturer.setPassword((String) jsonObject.get("password"));
                            lecturer.setStaffID((String) jsonObject.get("lecturerId"));
                            lecturer.setDepartment((String) jsonObject.get("department"));
                            lecturer.setProfession((String) jsonObject.get("profession"));

                            lecturer.findAllCourseInstances(courses); // This is used to make an interconnection between
                                                                      // the
                                                                      // courses and the teacher.

                            lecturers.add(lecturer);

                            fileReader.close();
                        } catch (IOException | ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } else {
                System.out.println("No file in database.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeAllLecturersData() {

        try {

            for (Lecturer lecturer : lecturers) {
                JSONObject lecturerJSON = new JSONObject();

                lecturerJSON.put("firstName", lecturer.getName());
                lecturerJSON.put("lastName", lecturer.getLastName());
                lecturerJSON.put("birthDate", lecturer.getBirthDate());
                lecturerJSON.put("address", lecturer.getAddress());
                lecturerJSON.put("ssn", lecturer.getSsn());
                lecturerJSON.put("email", lecturer.getEmail());
                lecturerJSON.put("password", lecturer.getPassword());
                lecturerJSON.put("lecturerId", lecturer.getStaffID());
                lecturerJSON.put("department", lecturer.getDepartment());
                lecturerJSON.put("profession", lecturer.getProfession());

                try (FileWriter fileWriter = new FileWriter("database/lecturers/" + lecturer.getStaffID() + ".json")) {
                    fileWriter.write(lecturerJSON.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writeAllStudentAffairsStaffsData() {
        try {

            for (StudentAffairsStaff studentAffairsStaff : studentAffairsStaffs) {
                JSONObject studentAffairsStaffJSON = new JSONObject();

                studentAffairsStaffJSON.put("firstName", studentAffairsStaff.getName());
                studentAffairsStaffJSON.put("lastName", studentAffairsStaff.getLastName());
                studentAffairsStaffJSON.put("birthDate", studentAffairsStaff.getBirthDate());
                studentAffairsStaffJSON.put("address", studentAffairsStaff.getAddress());
                studentAffairsStaffJSON.put("ssn", studentAffairsStaff.getSsn());
                studentAffairsStaffJSON.put("email", studentAffairsStaff.getEmail());
                studentAffairsStaffJSON.put("password", studentAffairsStaff.getPassword());
                studentAffairsStaffJSON.put("lecturerId", studentAffairsStaff.getStaffID());
                studentAffairsStaffJSON.put("department", studentAffairsStaff.getDepartment());

                try (FileWriter fileWriter = new FileWriter(
                        "database/studentAffairsStaffs/" + studentAffairsStaff.getStaffID() + ".json")) {
                    fileWriter.write(studentAffairsStaffJSON.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getAllStudentAffairsStaffsData() {
        try {
            String folderPath = "database/studentAffairsStaffs";

            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".json")) {
                        try {
                            FileReader fileReader = new FileReader(file);
                            JSONParser jsonParser = new JSONParser();
                            Object obj = jsonParser.parse(fileReader);
                            JSONObject jsonObject = (JSONObject) obj;

                            StudentAffairsStaff studentAffairsStaff = new StudentAffairsStaff();
                            studentAffairsStaff.setName((String) jsonObject.get("firstName"));
                            studentAffairsStaff.setLastName((String) jsonObject.get("lastName"));
                            studentAffairsStaff.setBirthDate((String) jsonObject.get("birthDate"));
                            studentAffairsStaff.setAddress((String) jsonObject.get("address"));
                            studentAffairsStaff.setSsn((String) jsonObject.get("ssn"));
                            studentAffairsStaff.setEmail((String) jsonObject.get("email"));
                            studentAffairsStaff.setPassword((String) jsonObject.get("password"));
                            studentAffairsStaff.setStaffID((String) jsonObject.get("lecturerId"));
                            studentAffairsStaff.setDepartment((String) jsonObject.get("department"));
                            studentAffairsStaff.setWorkingField((String) jsonObject.get("workingField"));

                            studentAffairsStaffs.add(studentAffairsStaff);

                            fileReader.close();
                        } catch (IOException | ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }

            } else {
                System.out.println("No file in database.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
