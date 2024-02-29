class Grade:
    def __init__(
        self, course_code=None, number_grade=None, letter_grade=None, is_passed=None
    ):
        self.course_code = course_code
        self.number_grade = number_grade
        self.letter_grade = letter_grade
        self.is_passed = is_passed

    def get_course_code(self):
        return self.course_code

    def is_grade_passing(self):
        return self.is_passed

    def convert_hundred_to_gano(self, hundred_not):
       return int(hundred_not) * 1 / 25 

    def convert_hundred_to_letter_grade(self, hundred):
        gano = self.convert_hundred_to_gano(hundred)
        if 4.00 >= gano > 3.50:
            self.letter_grade = "AA"
        elif 3.50 >= gano > 3.00:
            self.letter_grade = "BA"
        elif 3.00 >= gano > 2.50:
            self.letter_grade = "BB"
        elif 2.50 >= gano > 2.00:
            self.letter_grade = "CB"
        elif 2.00 >= gano > 1.50:
            self.letter_grade = "CC"
        elif 1.50 >= gano > 1.00:
            self.letter_grade = "DC"
        elif 1.00 >= gano > 0.50:
            self.letter_grade = "DD"
        elif 0.50 >= gano > 0.00:
            self.letter_grade = "FD"
        else:
            self.letter_grade = "FF"

    def get_info(self):
        return (
            f"course_code: {self.course_code}\n"
            f"number_grade: {self.number_grade}\n"
            f"letter_grade: {self.letter_grade}\n"
            f"is_passed: {self.is_passed}"
        )
