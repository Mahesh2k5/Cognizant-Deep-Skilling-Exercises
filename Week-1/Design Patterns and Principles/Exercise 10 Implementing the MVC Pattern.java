// Exercise 10: Implementing the MVC Pattern
public class Exercise10_MVCPattern {

    public static class Student {
        private String id;
        private String name;
        private String grade;

        public Student(String id, String name, String grade) {
            this.id = id; this.name = name; this.grade = grade;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public String getGrade() { return grade; }
        
        public void setName(String name) { this.name = name; }
        public void setGrade(String grade) { this.grade = grade; }
    }

    public static class StudentView {
        public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + studentName);
            System.out.println("ID: " + studentId);
            System.out.println("Grade: " + studentGrade);
        }
    }

    public static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) { model.setName(name); }
        public void setStudentGrade(String grade) { model.setGrade(grade); }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    public static void main(String[] args) {
        Student student = new Student("S101", "John Doe", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();
        System.out.println("\n-- Updating Grade --\n");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
