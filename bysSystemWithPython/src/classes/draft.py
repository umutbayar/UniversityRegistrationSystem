class Draft:
    def __init__(self, student=None, courses=[]):
        self.student = student
        self.courses = courses

    def add_to_draft(self, course):
        if course not in self.courses:
            self.courses.append(course)
            return True
        return False

    def remove_from_draft(self, course):
        if course in self.courses:
            self.courses.remove(course)
            return True
        return False

    def clear_draft(self):
        self.courses.clear()

    def get_courses(self):
        return self.courses

    def get_student(self):
        return self.student
    
    def set_student(self, student):
        self.student = student
        
    def set_courses(self, courses):
        self.courses.clear()
        self.courses = courses

    @staticmethod
    def get_list_info(list):
        if len(list) == 0:
            return ""
        all_info = ""
        for item in list:
            all_info += item.get_info()
        return all_info

    def get_info(self):
        return f"\nstudent: {self.student}\ncourses: {self.courses}"
