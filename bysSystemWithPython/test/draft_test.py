import unittest
from src.classes.draft import Draft  
from src.classes.course import Course  
from src.classes.student import Student
class TestDraft(unittest.TestCase):
    def setUp(self):
        self.student = Student(
            user_id="123",
            name="John Doe",
            password="pass123",
            email="john@gmail.com",
            transcript=None,
            year=2,
            advisor=None,
        )
        self.draft = Draft(student=self.student)
        self.course = Course(
            course_code="CSE101",
            course_name="Introduction to Computer Science",
           
            prerequisites=None,
        )

    def test_add_to_draft(self):
        self.assertTrue(self.draft.add_to_draft(self.course))
        self.assertIn(self.course, self.draft.courses)
        self.assertFalse(self.draft.add_to_draft(self.course))
        self.assertEqual(len(self.draft.courses), 1)

    def test_remove_from_draft(self):
        self.draft.add_to_draft(self.course)
        self.assertTrue(self.draft.remove_from_draft(self.course))
        self.assertNotIn(self.course, self.draft.courses)
        self.assertFalse(self.draft.remove_from_draft(self.course))

    def test_clear_draft(self):
        self.draft.add_to_draft(self.course)
        self.draft.add_to_draft(Course(course_code="CSE102", course_name="Computer Science 2"))
        self.draft.clear_draft()
        self.assertEqual(len(self.draft.courses), 0)

    def test_get_courses(self):
        self.draft.add_to_draft(self.course)
        self.draft.add_to_draft(Course(course_code="CSE102", course_name="Computer Science 2"))
        courses = self.draft.get_courses()
        self.assertEqual(len(courses), 2)
        self.assertIn(self.course, courses)

    def test_get_student(self):

        student = Student(user_id="111", name="Jane Doe", password="pass456", email="jane@gmail.com", year=3)
        draft = Draft(student=student)
        result_student = draft.get_student()
        self.assertEqual(result_student, student)

    def test_get_list_info(self):
        course1 = Course(course_code="CSE101", course_name="Computer Science 1")
        course2 = Course(course_code="CSE102", course_name="Computer Science 2")
        course3 = Course(course_code="CSE103", course_name="Computer Science 3")

        courses_list = [course1, course2, course3]

        result_info = Draft.get_list_info(courses_list)

        expected_info = f"{course1.get_info()}{course2.get_info()}{course3.get_info()}"
        self.assertEqual(result_info, expected_info)

if __name__ == '__main__':
    unittest.main()
