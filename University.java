import java.util.ArrayList;

// Department class (Composition: Exists only within University)
class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

// Faculty class (Aggregation: Faculty can exist without a University)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// University class (Composition: Owns Departments, Aggregates Faculty)
class University {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void displayUniversityDetails() {
        System.out.println("University: " + name);

        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.println("  " + dept.getName());
        }

        System.out.println("Faculty Members:");
        for (Faculty faculty : faculties) {
            System.out.println("  " + faculty.getName());
        }
    }

    public static void main(String[] args) {
        // Creating a University
        University university = new University("Chitkara University");

        // Adding Departments (Composition)
        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        // Creating Faculty Members (Aggregation)
        Faculty faculty1 = new Faculty("Ms. Roshni");
        Faculty faculty2 = new Faculty("Mr. Chandrakant");

        // Adding Faculty to University
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        // Display University Details
        university.displayUniversityDetails();
    }
}
