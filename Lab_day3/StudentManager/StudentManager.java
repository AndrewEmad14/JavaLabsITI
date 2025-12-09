package Lab_day3.StudentManager;

import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public Boolean addStudent(Student student) {
        if (students == null) {
            return false;
        }
        this.students.add(student);
        return true;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student getStudent(int index) {
        if (index < 0 || index >= students.size()) {
            return null;
        }
        return students.get(index);
    }

    public Boolean findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return true;
            }
        }
        return false;

    }

    public Boolean findCourse(Integer courseId) {
        for (Student student : students) {
            for (Student.CourseRegistration registration : student.getCourses()) {
                if (registration.getCourse().getCourseId() == courseId) {
                    return true;
                }
            }
        }
        return false;

    }

    public void displayStudents() {
        for (Student student : students) {
            student.printReport();
        }
    }

}
