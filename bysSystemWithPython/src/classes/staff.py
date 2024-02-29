from abc import ABC, abstractmethod
from .user import User


class Staff(User, ABC):
    def __init__(
        self, user_id=None, name=None, password=None, email=None, department=None
    ):
        super().__init__(user_id, name, password, email)
        self.department = department

    def get_department(self):
        return self.department

    def get_info(self):
        return (
            f"user_id: {self.user_id}\n"
            f"name: {self.name}\n"
            f"password: {self.password}\n"
            f"email: {self.email}\n"
            f"department: {self.department}"
        )
