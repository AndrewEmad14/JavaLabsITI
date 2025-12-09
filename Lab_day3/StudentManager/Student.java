package Lab_day3.StudentManager;

import java.util.ArrayList;

public class Student {
    private String name = "";
    private Integer age = 0;
    private String studentId = "";
    private ArrayList<CourseRegistration> courses = new ArrayList<>();

    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setCourses(ArrayList<CourseRegistration> courses) {
        this.courses = courses;
    }

    public ArrayList<CourseRegistration> getCourses() {
        return courses;
    }

    // Lets the student register for a course and optionally store a grade.
    // Uses autoboxing with Double.
    public void registerCourse(Course course, Double grade) {
        CourseRegistration registration = new CourseRegistration(course, grade);
        courses.add(registration);
    }

    // Prints all the courses and grades of the student.
    // This method should use a StringBuilder to build the formatted report.
    public void printReport() {
        StringBuilder report = new StringBuilder();

        // Add student info
        report.append("Student ID: ").append(studentId).append("\n");
        report.append("Name: ").append(name).append("\n");

        report.append("Courses:\n");

        for (CourseRegistration course : courses) {
            report.append("  Course: ").append(course.course.getCourseName());
            report.append(", Grade: ");
            if (course.grade != null) {
                report.append(course.grade);
            } else {
                report.append("N/A");
            }
            report.append("\n");
        }

        // Convert to String and print
        System.out.println(report.toString());
    }

    class CourseRegistration {
        private Course course;
        private Double grade; // Using Double to allow null (no grade yet)

        public Course getCourse() {
            return course;
        }

        public Double getGrade() {
            return grade;
        }

        public CourseRegistration(Course course, Double grade) {
            this.course = course;
            this.grade = grade;
        }

    }

}
