import os
from .user import User
from .draft import Draft
import json
import logging

# LOGGING CONFIG
logger = logging.getLogger()
logger.setLevel(logging.DEBUG)
file_handler = logging.FileHandler("logfile.log")
formatter = logging.Formatter("%(asctime)s - %(levelname)s - %(message)s")
file_handler.setFormatter(formatter)
logger.addHandler(file_handler)


class Student(User):
    def __init__(
        self,
        user_id=None,
        name=None,
        password=None,
        email=None,
        transcript=None,
        year=0,
        advisor=None,
    ):
        super().__init__(user_id, name, password, email)
        self.transcript = transcript
        self.year = year
        self.advisor = advisor
        self.draft = None

    def add_grade_to_transcript(self, grade):
        self.transcript.add_grade(grade)
        
    def get_student_info(self):  
        return (
            f"Name: {self.name}\n"
            f"User ID: {self.user_id}\n"
            f"Email: {self.email}\n"
            f"Year: {self.year}\n"
        )
    
    def get_registered_courses(self, courses):
        enrolled_courses = []
        for course in courses:
            if course.has_student(self.user_id):
                enrolled_courses.append(course)
        return enrolled_courses
      
    def get_draft(self):
        return self.draft
    
    def set_draft(self, draft):
        self.draft = draft

    def set_advisor(self, advisor):
        self.advisor = advisor

    def get_advisor(self):
        return self.advisor

    def get_name(self):
        return self.name

    def get_transcript(self):
        return self.transcript

    def is_course_eligible(self, course):
        logger.info(f"is course eligable called for course {course.get_course_code()}")

        # check if already in draf
        if course in self.draft.get_courses():
            return False

        # check year prerequisite
        if course.get_course_year() > self.year:
            logger.info(
                f"course is found to NOT be eligable for {course.get_course_code()} by year"
            )
            return False

        # check if course is already taken
        if course.get_course_code() in self.transcript.get_completed_courses():
            logger.info(
                f"course is found to NOT be eligable for {course.get_course_code()} by already taken"
            )
            return False

        # check if prerequisites are completed
        if course.get_prerequisites() is not None:
            for prerequisite in course.get_prerequisites():
                if prerequisite not in self.transcript.get_completed_courses():
                    logger.info(
                        f"course is found to NOT be eligable for {course.get_course_code()} by prerequisite"
                    )
                    return False

        logger.info(f"course is found to be eligable for {course.get_course_code()}")
        return True

    def get_eligible_courses(self, all_courses):
        eligible_courses = []
        for course in all_courses:
            if self.is_course_eligible(course):
                eligible_courses.append(course)
        return eligible_courses

    def get_info(self):
        return (
            f"user_id: {self.user_id}\n"
            f"name: {self.name}\n"
            f"password: {self.password}\n"
            f"email: {self.email}\n"
            f"transcript: {self.transcript}\n"
            f"year: {self.year}\n"
            f"advisor: {self.advisor}"
        )

    def to_json_file(self):
        grades_array = []

        for grade in self.transcript.grades:
            grade_node = {
                "courseCode": grade.course_code ,
                "numberGrade": grade.number_grade,
                "letterGrade": grade.letter_grade,
                "isPassed": grade.is_passed
            }
            grades_array.append(grade_node)
            
        course_dict = {
            "studentId": self.user_id,
            "advisorId": self.advisor.user_id,
            "Name": self.name,
            "password": self.password,
            "year": self.year,
            "gano": self.transcript.gano,

            "email": self.email,
            "grades": grades_array,

        }

        json_data = json.dumps(course_dict, indent=2)

        filename = f"database/students/{self.user_id}.json"


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
