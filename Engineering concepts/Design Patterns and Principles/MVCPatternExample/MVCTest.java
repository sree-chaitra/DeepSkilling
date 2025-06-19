package MVCPatternExample;

class Student {
    private String id;
    private String name;
    private String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
}

class StudentView {
    public void displayStudentDetails(Student s) {
        System.out.println("Student ID: " + s.getId());
        System.out.println("Name: " + s.getName());
        System.out.println("Grade: " + s.getGrade());
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateName(String name) {
        model.setName(name);
    }

    public void updateGrade(String grade) {
        model.setGrade(grade);
    }

    public void showStudent() {
        view.displayStudentDetails(model);
    }
}

public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student("S101", "Ravi", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.showStudent();

        controller.updateName("Chaitra");
        controller.updateGrade("A+");

        controller.showStudent();
    }
}