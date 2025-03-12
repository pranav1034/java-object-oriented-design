import java.util.ArrayList;
// Course class (Students enroll in Courses - Association)
class Course {
    private String name;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Course: " + name + " has the following students:");
        for (Student student : students) {
            System.out.println("  Student: " + student.getName());
        }
    }
    public String getName() {
        return name;
    }
}

// Student class (Can enroll in multiple Courses - Association)
class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this); // Ensure two-way association
    }

    public void displayCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("  Course: " + course.getName());
        }
    }

    public String getName() {
        return name;
    }
}

// School class (Contains multiple Students - Aggregation)
class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name + " has the following students:");
        for (Student student : students) {
            System.out.println("  Student: " + student.getName());
        }
    }

    public static void main(String[] args) {
        // Creating a School
        School school = new School("DPS");

        // Creating Students
        Student student1 = new Student("Pranav");
        Student student2 = new Student("Abhay");

        // Adding Students to School (Aggregation)
        school.addStudent(student1);
        school.addStudent(student2);

        // Creating Courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");

        // Enrolling Students in Courses (Association)
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        // Displaying Information
        school.displayStudents();
        System.out.println();
        student1.displayCourses();
        student2.displayCourses();
        System.out.println();
        course1.displayStudents();
        course2.displayStudents();
    }
}
