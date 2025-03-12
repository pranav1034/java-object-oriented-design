import java.util.ArrayList;

// Department class (Composition: Exists only within a Company)
class Department {
    private String name;
    private ArrayList<String> employees; // Storing employee names directly

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        employees.add(employeeName);
    }

    public void displayEmployees() {
        System.out.println("Department: " + name);
        for (String employee : employees) {
            System.out.println("  Employee: " + employee);
        }
    }

    public String getName() {
        return name;
    }
}

// Company class (Composition: Owns Departments and Employees)
class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Department " + departmentName + " not found!");
    }

    public void displayCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayEmployees();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating a Company
        Company company = new Company("Capgemini");

        // Adding Departments
        company.addDepartment("Engineering");
        company.addDepartment("Finance");

        // Adding Employees to Departments
        company.addEmployeeToDepartment("Engineering", "Pranav");
        company.addEmployeeToDepartment("Engineering", "Nikhil");
        company.addEmployeeToDepartment("Finance", "Abhay");

        // Display Company Structure
        company.displayCompanyStructure();
    }
}
