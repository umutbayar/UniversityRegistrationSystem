class Transcript:
    def __init__(self, gano=0, grades=[]):
        self.gano = gano
        self.grades = grades

    def get_grades(self):
        return self.grades

    def add_grade(self, grade):
        self.grades.append(grade)
        self.calculate_gano()


    def calculate_gano(self):
        sum = 0
        for grade in self.grades:
            sum = sum + int(grade.number_grade)
        
        self.gano = (sum * 1/25) / len(self.grades) 


    def get_completed_courses(self):
        completed_courses = []
        for grade in self.grades:
            if grade.is_grade_passing():
                completed_courses.append(grade.get_course_code())
        return completed_courses

    def to_string(self):
        info_str = f"GANO: {self.gano}\n"

        completed_courses = self.get_completed_courses()
        if completed_courses:
            info_str += "Completed Courses:\n"
            for course_code in completed_courses:
                info_str += f"- {course_code}\n"
        else:
            info_str += "No completed courses.\n"

        return info_str

    def get_info(self):
        return f"gano: {self.gano}\ngrades: {self.grades}"
