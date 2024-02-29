import os
from .staff import Staff
import json


class Lecturer(Staff):
    def __init__(
        self,
        user_id=None,
        name=None,
        password=None,
        email=None,
        department=None,
        field=None,
    ):
        super().__init__(user_id, name, password, email, department)
        self.field = field

    def get_field(self):
        return self.field

    def get_info(self):
        return (
            f"user_id: {self.user_id}\n"
            f"name: {self.name}\n"
            f"password: {self.password}\n"
            f"email: {self.email}\n"
            f"department: {self.department}\n"
            f"field: {self.field}"
        )

    def to_json_file(self):
        
        course_dict = {
            "lecturerId": self.user_id,
            "field": self.field,
            "Name": self.name,
            "password": self.password,
            "department": self.department,
            "email": self.email,
        }

        json_data = json.dumps(course_dict, indent=2)

        filename = f"database/lecturers/{self.user_id}.json"


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
