Overview
The BYS system is designed to manage various user roles and their interactions with courses, grades, transcripts, and more. It is implemented in both Java and Python, providing flexibility and ensuring usability across different programming environments. The system allows students, staff, and faculty to perform various tasks, such as logging in, managing courses, handling student records, and more.

Project Structure
This project consists of multiple components, each representing a core part of the system. The main classes include:

1. Advisor
Represents an advisor who provides academic guidance to students.
Can access student records, grades, and transcripts.
2. Course
Represents a course that is offered in the university.
Includes details such as course name, course code, professor, and enrolled students.
3. Draft
Manages drafts for student work and submissions.
Allows students to save and submit drafts of their assignments.
4. Grade
Stores and manages student grades for different courses.
Facilitates the calculation of final grades for students.
5. Lecturer
Represents a lecturer who is responsible for teaching courses.
Can assign grades and manage the course materials.
6. Staff
Represents university staff who manage administrative tasks such as course registration and student records.
7. Student
Represents a student within the system.
Can log in, view their grades, register for courses, and access their transcripts.
8. StudentAffairsStaff
Represents staff members who handle student affairs such as records, transcripts, and other administrative duties.
9. Transcript
Stores the official records of a student's academic achievements, including courses, grades, and overall performance.
10. User
A base class for managing the general functionality of different users (student, staff, lecturer, etc.).
Handles user login and authentication.
