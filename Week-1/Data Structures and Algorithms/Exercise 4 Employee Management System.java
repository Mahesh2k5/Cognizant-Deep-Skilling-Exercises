// Exercise 4: Employee Management System
public class Exercise4_EmployeeManagementSystem {

    public static class Employee {
        private String employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String getEmployeeId() { return employeeId; }

        @Override
        public String toString() {
            return "Employee{id='" + employeeId + "', name='" + name + "'}";
        }
    }

    public static class EmployeeManager {
        private Employee[] employees;
        private int count;

        public EmployeeManager(int capacity) {
            employees = new Employee[capacity];
            count = 0;
        }

        public void addEmployee(Employee emp) {
            if (count < employees.length) {
                employees[count++] = emp;
            } else {
                System.out.println("Array is full");
            }
        }

        public Employee searchEmployee(String id) {
            for (int i = 0; i < count; i++) {
                if (employees[i].getEmployeeId().equals(id)) {
                    return employees[i];
                }
            }
            return null;
        }

        public void traverse() {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }

        public void deleteEmployee(String id) {
            for (int i = 0; i < count; i++) {
                if (employees[i].getEmployeeId().equals(id)) {
                    // Shift elements
                    for (int j = i; j < count - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[count - 1] = null;
                    count--;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);
        manager.addEmployee(new Employee("E01", "Alice", "Developer", 80000));
        manager.addEmployee(new Employee("E02", "Bob", "Manager", 95000));
        manager.addEmployee(new Employee("E03", "Charlie", "Analyst", 70000));

        System.out.println("All Employees:");
        manager.traverse();

        System.out.println("\nSearch E02: " + manager.searchEmployee("E02"));

        System.out.println("\nDeleting E02");
        manager.deleteEmployee("E02");
        manager.traverse();
    }
}
