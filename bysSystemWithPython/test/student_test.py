import unittest
from unittest.mock import MagicMock
from src.classes.student import Student
from src.classes.draft import Draft

class TestStudentClass(unittest.TestCase):
    def setUp(self):
        self.mock_draft = MagicMock(spec=Draft)
        self.student = Student(
            user_id="123",
            name="John Doe",
            password="password",
            email="john.doe@example.com",
            transcript=None,
            year=2,
            advisor=None,
        )
        self.student.draft = self.mock_draft

    def test_get_student_info(self):
        expected_info = (
            "Name: John Doe\n"
            "User ID: 123\n"
            "Email: john.doe@example.com\n"
            "Year: 2\n"
        )
        self.assertEqual(self.student.get_student_info(), expected_info)

    def test_get_registered_courses(self):
        mock_course = MagicMock()
        mock_course.has_student.return_value = True

        registered_courses = self.student.get_registered_courses([mock_course])

        self.assertEqual(registered_courses, [mock_course])
        mock_course.has_student.assert_called_once_with(self.student.user_id)

    def test_get_draft(self):
        self.assertEqual(self.student.get_draft(), self.mock_draft)

    def test_set_advisor(self):
        mock_advisor = MagicMock()
        self.student.set_advisor(mock_advisor)
        self.assertEqual(self.student.advisor, mock_advisor)

    def test_get_advisor(self):
        mock_advisor = MagicMock()
        self.student.advisor = mock_advisor
        self.assertEqual(self.student.get_advisor(), mock_advisor)

    def test_get_name(self):
        self.assertEqual(self.student.get_name(), "John Doe")

if __name__ == '__main__':
    unittest.main()
