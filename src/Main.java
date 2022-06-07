public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee(new Employee("Employee1", "1", 15000));
        employeeBook.addEmployee(new Employee("Employee2", "2", 16000));
        employeeBook.addEmployee(new Employee("Employee3", "2", 17000));
        employeeBook.addEmployee(new Employee("Employee4", "3", 18000));
        employeeBook.addEmployee(new Employee("Employee5", "4", 19000));
        employeeBook.addEmployee(new Employee("Employee6", "4", 20000));
        employeeBook.print();
        System.out.println();

        employeeBook.deleteEmployee(2);
        employeeBook.print();
        System.out.println();

        employeeBook.printDepartments();
        System.out.println();
    }
}
