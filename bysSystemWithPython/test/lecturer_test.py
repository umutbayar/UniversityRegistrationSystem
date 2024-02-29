import unittest
from src.classes.lecturer import Lecturer

class TestLecturer(unittest.TestCase):
    def setUp(self):
        self.lecturer = Lecturer(
            user_id="271828",
            name="Leonhard Euler",
            password="ln(e)",
            email="l.euler@gmail.com",
            department="Science",
            field="Mathematics"
        )

    def test_get_field(self):
        self.assertEqual(self.lecturer.get_field(), "Mathematics")

    def test_get_info(self):
        expected_info = (
            "user_id: 271828\n"
            "name: Leonhard Euler\n"
            "password: ln(e)\n"
            "email: l.euler@gmail.com\n"
            "department: Science\n"
            "field: Mathematics"
        )
        self.assertEqual(self.lecturer.get_info(), expected_info)

if __name__ == '__main__':
    unittest.main()