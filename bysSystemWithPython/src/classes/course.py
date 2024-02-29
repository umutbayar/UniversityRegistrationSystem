import json
import os


class Course:
    def __init__(
        self,
        course_code=None,
        course_name=None,
        lecturer=None,
        students=[],
        prerequisites=[],
        credits=None,
        year=0,
    ):
        self.course_code = course_code
        self.course_name = course_name
        self.lecturer = lecturer
        self.students = students
        self.prerequisites = prerequisites
        self.credits = credits
        self.year = year


    def set_students(self, new_students):
        self.students = new_students
    
    def set_lecturer(self, new_lecturer):
        self.lecturer = new_lecturer
    
    def enroll_student(self, student):
        if student not in self.students:
            self.students.append(student)
            
    def remove_student(self, student):
        if student in self.students:
            self.students.remove(student)
            
    def has_student(self, user_id):
        for student in self.students:
            if student.get_user_id() == user_id:
                return True
        return False

    def get_course_code(self):
        return self.course_code

    def get_course_year(self):
        return self.year

    def get_prerequisites(self):
        return self.prerequisites

    def get_course_name(self):
        return self.course_name

    def get_lecturer(self):
        return self.lecturer

    def get_students(self):
        return self.students

    @staticmethod
    def get_list_info(list):
        if len(list) == 0:
            return ""
        all_info = ""
        for item in list:
            all_info += item.get_info()
        return all_info

    def get_info(self):
        return f"course_code: {self.course_code}\course_name: {self.course_name}\nlecturer: {self.lecturer}\nstudents: {self.students}\nprerequisites: {self.prerequisites}\ncredits: {self.credits}\nyear: {self.year}"

    def get_course_information(self):  # Used for printing the course information
        # Basic inforamtion
        temp = f"course_code: {self.course_code}\ncourse_name: {self.course_name}\ncredits: {self.credits}\nyear: {self.year}\nprerequisites:"
        # Checking for prerequisites
        if self.prerequisites.__len__() == 0:
            temp += "\n              -> no prerequisite!"
        for item in self.prerequisites:
            temp += (
                "\n              -> course_code: "
                + item
            )
        # Basic lecturer information
        temp += (
            "\nlecturer: \n         -> name: "
            + self.lecturer.get_name()
            + "\n            email: "
            + self.lecturer.get_email()
            + "\n            department: "
            + self.lecturer.get_department()
            + "\n            field: "
            + self.lecturer.get_field()
            + "\nstudents: "
        )
        # Checking for students
        if self.students.__len__() == 0:
            temp += "\n         -> no students!"
        for item in self.students:
            temp += (
                "\n         -> name: "
                + item.get_name()
                + " studentID: "
                + item.get_user_id()
                + " email: "
                + item.get_email()
            )
        return temp

    def to_json_file(self):
        student_arr = [student.user_id for student in self.students]
        prerequisite_arr = [prerequisite for prerequisite in self.prerequisites]
        course_dict = {
            "courseCode": self.course_code,
            "courseName": self.course_name,
            "courseLecturer": self.lecturer.user_id,
            "students": student_arr,
            "prerequisite": prerequisite_arr,
            "credits": self.credits,
            "year": self.year,
        }

        json_data = json.dumps(course_dict, indent=2)

        filename = f"database/courses/{self.course_code}.json"


        with open(filename, 'w') as json_file:
            json_file.write(json_data)

    @classmethod
    def from_json_file(cls, user_id):
        filename = f"{user_id}.json"
        if os.path.exists(filename):
            with open(filename, "r") as json_file:
                student_data = json.load(json_file)
                return cls(**student_data)
        else:
            raise FileNotFoundError(f"File {filename} does not exist.")
