import os
from .lecturer import Lecturer
import json


class Advisor(Lecturer):
    def __init__(
        self,
        user_id=None,
        name=None,
        password=None,
        email=None,
        department=None,
        field=None,
        students=[],
        drafts=[],
    ):
        super().__init__(user_id, name, password, email, department, field)
        self.students = students
        self.drafts = drafts
    
    def get_drafts(self):
        return self.drafts
    
    def remove_draft(self, draft_to_remove):
        self.drafts.remove(draft_to_remove)
    
    def get_students(self):
        return self.students

    def set_students(self, students):
        self.students.clear()
        self.students = students

    # returns true if draft was appended
    def add_draft(self, draft_sent):
            
        found_draft = False
        for draft in self.drafts:
            if draft_sent.get_student() == draft.get_student():
                draft = draft_sent
                found_draft = True
                
        if not found_draft:
            self.drafts.append(draft_sent)
            
    @staticmethod
    def get_list_info(list):
        if len(list) == 0:
            return ""
        all_info = ""
        for item in list:
            all_info += item.get_info()
        return all_info

    def get_info(self):
        return (
            f"user_id: {self.user_id}\n"
            f"name: {self.name}\n"
            f"password: {self.password}\n"
            f"email: {self.email}\n"
            f"department: {self.department}\n"
            f"field: {self.field}\n"
            f"students: {self.students}\n"
            f"drafts: {self.drafts}"
        )

    def to_json_file(self):
        student_arr = [student.user_id for student in self.students]
        drafts_array = []

        for draft in self.drafts:
            draft_courses = [course for course in draft.courses]

            draft_node = {
                "studentId": draft.student,
                "courseCode": draft_courses,
            }
            drafts_array.append(draft_node)
            
        course_dict = {
            "lecturerId": self.user_id,
            "field": self.field,
            "Name": self.name,
            "password": self.password,
            "department": self.department,
            "email": self.email,
            "students": student_arr,
            "drafts": drafts_array,

        }

        json_data = json.dumps(course_dict, indent=2)

        filename = f"database/advisors/{self.user_id}.json"


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
