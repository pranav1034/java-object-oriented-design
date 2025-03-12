import java.util.ArrayList;

// Patient class (Can consult multiple doctors - Association)
class Patient {
    private String name;
    private ArrayList<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }
    public void consultDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.addPatient(this); // Ensure two-way association
    }
    public void displayDoctors() {
        System.out.println("Patient: " + name + " has consulted the following doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  Doctor: " + doctor.getName());
        }
    }
    public String getName() {
        return name;
    }
}

// Doctor class (Can see multiple patients - Association)
class Doctor {
    private String name;
    private ArrayList<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void consult(Patient patient) {
        System.out.println("Doctor " + name + " is treating Patient " + patient.getName());
        patient.consultDoctor(this); // Ensure two-way association
    }

    public void displayPatients() {
        System.out.println("Doctor: " + name + " has treated the following patients:");
        for (Patient patient : patients) {
            System.out.println("  Patient: " + patient.getName());
        }
    }

    public String getName() {
        return name;
    }
}

// Hospital class (Contains multiple doctors - Aggregation)
class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void displayDoctors() {
        System.out.println("Hospital: " + name + " has the following doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  Doctor: " + doctor.getName());
        }
    }

    public static void main(String[] args) {
        // Creating a Hospital
        Hospital hospital = new Hospital("Max Hospital");

        // Creating Doctors
        Doctor doctor1 = new Doctor("Dr. A");
        Doctor doctor2 = new Doctor("Dr. B");

        // Adding Doctors to Hospital (Aggregation)
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        // Creating Patients
        Patient patient1 = new Patient("Pranav");
        Patient patient2 = new Patient("Nikhil");

        // Doctor-Patient Consultations (Association)
        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

        // Displaying Information
        System.out.println();
        hospital.displayDoctors();
        System.out.println();
        doctor1.displayPatients();
        doctor2.displayPatients();
        System.out.println();
        patient1.displayDoctors();
        patient2.displayDoctors();
    }
}
