import unittest
from src.classes.grade import Grade

class TestGrade(unittest.TestCase):
    def setUp(self):
        self.grade = Grade(
            course_code="CSE101",
            number_grade=85,
            letter_grade="B",
            is_passed=True,
        )

    def test_get_course_code(self):
        self.assertEqual(self.grade.get_course_code(), "CSE101")

    def test_is_grade_passing(self):
        self.assertTrue(self.grade.is_grade_passing())

    def test_get_info(self):
        expected_info = (
            "course_code: CSE101\n"
            "number_grade: 85\n"
            "letter_grade: B\n"
            "is_passed: True"
        )
        self.assertEqual(self.grade.get_info(), expected_info)

if __name__ == '__main__':
    unittest.main()
