from abc import ABC, abstractmethod
import json


class User(ABC):
    def __init__(self, user_id=None, name=None, password=None, email=None):
        self.user_id = user_id
        self.name = name
        self.password = password
        self.email = email

    def get_user_id(self):
        return self.user_id

    def get_password(self):
        return self.password

    def get_name(self):
        return self.name

    def get_email(self):
        return self.email

    @abstractmethod
    def get_info(self):
        pass

    @abstractmethod
    def to_json_file(self):
        pass

    @abstractmethod
    def from_json_file(cls, user_id):
        pass
