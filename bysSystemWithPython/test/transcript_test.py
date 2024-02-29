import unittest
from src.classes.transcript import Transcript
from src.classes.grade import Grade


class TestTranscript(unittest.TestCase):
    def setUp(self):
        self.transcript = Transcript(
            gano=3.2,
            grades=[
                Grade(course_code="CSE101", number_grade=85, is_passed=True),
                Grade(course_code="CSE201", number_grade=74, is_passed=True),
                Grade(course_code="CSE301", number_grade=20, is_passed=False),
            ],
        )

    def test_get_grades(self):
        self.assertEqual(self.transcript.get_grades(), self.transcript.grades)

    def test_add_grade(self):
        grade_count = len(self.transcript.grades)
        new_grade = Grade(course_code="CSE401", number_grade=68)
        self.transcript.add_grade(new_grade)
        new_grade_count = len(self.transcript.grades)
        self.assertEqual(new_grade_count, grade_count + 1)
        self.assertIn(new_grade, self.transcript.grades)

    def test_get_completed_courses(self):
        completed_courses = self.transcript.get_completed_courses()
        result = ["CSE101", "CSE201"]
        self.assertEqual(completed_courses, result)

    def test_get_info(self):
        result = f"gano: 3.2\ngrades: {str(self.transcript.grades)}"
        self.assertEqual(self.transcript.get_info(), result)


if __name__ == "__main__":
    unittest.main()
