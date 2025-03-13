import java.util.ArrayList;

// Subject class
class Subject {
    private String subjectName;
    private Professor professor;
    private ArrayList<Learner> learners;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.learners = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addSubject(this); // Association with Professor
    }

    public void enrollLearner(Learner learner) {
        learners.add(learner);
        learner.addSubject(this); // Association with Learner
    }

    public void displaySubjectDetails() {
        System.out.println("Subject: " + subjectName);
        if (professor != null) {
            System.out.println("  Taught by: " + professor.getName());
        }
        System.out.println("  Enrolled Learners:");
        for (Learner learner : learners) {
            System.out.println("    - " + learner.getName());
        }
        System.out.println();
    }

    public String getSubjectName() {
        return subjectName;
    }
}

// Learner class (Can enroll in multiple subjects - Association)
class Learner {
    private String name;
    private ArrayList<Subject> subjects;

    public Learner(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void displaySubjects() {
        System.out.println("Learner: " + name + " is enrolled in:");
        for (Subject subject : subjects) {
            System.out.println("  - " + subject.getSubjectName());
        }
        System.out.println();
    }
}

// Professor class (Can teach multiple subjects - Association)
class Professor {
    private String name;
    private ArrayList<Subject> subjects;

    public Professor(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void displaySubjects() {
        System.out.println("Professor: " + name + " teaches:");
        for (Subject subject : subjects) {
            System.out.println("  - " + subject.getSubjectName());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating Subjects
        Subject subject1 = new Subject("Data Structures");
        Subject subject2 = new Subject("Core Java");

        // Creating Professors
        Professor professor1 = new Professor("Mr. A");
        Professor professor2 = new Professor("Ms. B");

        // Assigning Professors to Subjects (Association)
        subject1.assignProfessor(professor1);
        subject2.assignProfessor(professor2);

        // Creating Learners
        Learner learner1 = new Learner("Pranav");
        Learner learner2 = new Learner("Nikhil");

        // Enrolling Learners in Subjects (Association)
        subject1.enrollLearner(learner1);
        subject1.enrollLearner(learner2);
        subject2.enrollLearner(learner1);

        // Displaying Information
        subject1.displaySubjectDetails();
        subject2.displaySubjectDetails();

        professor1.displaySubjects();
        professor2.displaySubjects();

        learner1.displaySubjects();
        learner2.displaySubjects();
    }
}
