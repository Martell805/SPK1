public class EmployeeBook {
    private final Employee[] employees = {
            null, null, null, null, null, null, null, null, null, null
    };

    private int length = 0;

    public void print(){
        for(Employee employee: this.employees)
            if(employee != null)
                System.out.println(employee);
    }

    public int sumOfSalaries(){
        int result = 0;

        for(Employee employee: this.employees)
            if(employee != null)
                result += employee.getSalary();

        return result;
    }

    public int minSalary(){
        if(this.length == 0) throw new RuntimeException("EmployeeBook is empty");

        int result = -1;

        for(Employee employee: this.employees)
            if(employee != null)
                result = (result != -1) ? Math.min(result, employee.getSalary()) : employee.getSalary();

        return result;
    }

    public int maxSalary(){
        if(this.length == 0) throw new RuntimeException("EmployeeBook is empty");

        int result = -1;

        for(Employee employee: this.employees)
            if(employee != null)
                result = (result != -1) ? Math.max(result, employee.getSalary()) : employee.getSalary();

        return result;
    }

    public int averageSalary(){
        if(this.length == 0) throw new RuntimeException("EmployeeBook is empty");

        return sumOfSalaries() / this.length;
    }

    public void printNames(){
        for(Employee employee: this.employees)
            if(employee != null)
                System.out.println(employee.getName());
    }

    public void indexSalary(int percent){
        for(int q = 0; q < 10; q++)
            if(this.employees[q] != null)
                this.employees[q].setSalary((int)(this.employees[q].getSalary() * (1 + percent / 100.0)));
    }

    private boolean belongsTo(Employee employee, String department){
        return employee != null && employee.getDepartment().equals(department);
    }

    public int sumOfSalaries(String department){
        int result = 0;

        for(Employee employee: this.employees)
            if(belongsTo(employee, department))
                result += employee.getSalary();

        return result;
    }

    public int minSalary(String department){
        if(this.length == 0) throw new RuntimeException("EmployeeBook is empty");

        int result = -1;

        for(Employee employee: this.employees)
            if(belongsTo(employee, department))
                result = (result != -1) ? Math.min(result, employee.getSalary()) : employee.getSalary();

        return result;
    }

    public int maxSalary(String department){
        if(this.length == 0) throw new RuntimeException("EmployeeBook is empty");

        int result = -1;

        for(Employee employee: this.employees)
            if(belongsTo(employee, department))
                result = (result != -1) ? Math.max(result, employee.getSalary()) : employee.getSalary();

        return result;
    }

    public int averageSalary(String department){
        if(this.length == 0) throw new RuntimeException("EmployeeBook is empty");

        int sum = 0;
        int quantity = 0;

        for(Employee employee: this.employees)
            if(belongsTo(employee, department)){
                sum += employee.getSalary();
                quantity++;
            }

        if(quantity == 0) throw new RuntimeException("Chosen department is empty");

        return sum / quantity;
    }

    public void indexSalary(int percent, String department){
        for(int q = 0; q < 10; q++)
            if(belongsTo(this.employees[q], department))
                this.employees[q].setSalary((int)(this.employees[q].getSalary() * (1 + percent / 100.0)));
    }

    public void print(String department){
        for(Employee employee: this.employees)
            if(belongsTo(employee, department))
                System.out.println(
                        "Employee{" +
                        "id=" + employee.getId() +
                        ", name='" + employee.getName() + '\'' +
                        ", salary=" + employee.getSalary() +
                        '}'
                );
    }

    public void printEmployeesWithLessSalary(int salary){
        for(Employee employee: this.employees)
            if(employee != null && employee.getSalary() < salary)
                System.out.println(employee);
    }

    public void printEmployeesWithHighersSalary(int salary){
        for(Employee employee: this.employees)
            if(employee != null && employee.getSalary() >= salary)
                System.out.println(employee);
    }

    public void addEmployee(Employee new_employee){
        if(length == 10) throw new RuntimeException("EmployeeBook is already full");

        for(int q = 0; q < 10; q++)
            if(this.employees[q] == null){
                this.employees[q] = new_employee;
                length++;
                return;
            }
    }

    public void deleteEmployee(int id){
        if(length == 0) throw new RuntimeException("EmployeeBook is empty");

        for(int q = 0; q < 10; q++)
            if(this.employees[q] != null && this.employees[q].getId() == id){
                this.employees[q] = null;
                length--;
                return;
            }

        throw new RuntimeException("Employee didnt found");
    }

    public void deleteEmployee(String name){
        if(length == 0) throw new RuntimeException("EmployeeBook is empty");

        for(int q = 0; q < 10; q++)
            if(this.employees[q] != null && this.employees[q].getName().equals(name)){
                this.employees[q] = null;
                length--;
                return;
            }

        throw new RuntimeException("Employee didnt found");
    }

    public void deleteEmployee(int id, String name){
        if(length == 0) throw new RuntimeException("EmployeeBook is empty");

        for(int q = 0; q < 10; q++)
            if(this.employees[q] != null && this.employees[q].getId() == id && this.employees[q].getName().equals(name)){
                this.employees[q] = null;
                length--;
                return;
            }

        throw new RuntimeException("Employee didnt found");
    }

    public void setSalary(String name, int salary){
        if(length == 0) throw new RuntimeException("EmployeeBook is empty");

        for(int q = 0; q < 10; q++)
            if(this.employees[q] != null && this.employees[q].getName().equals(name)){
                this.employees[q].setSalary(salary);
                return;
            }

        throw new RuntimeException("Employee didnt found");
    }

    public void setDepartment(String name, String department){
        if(length == 0) throw new RuntimeException("EmployeeBook is empty");

        for(int q = 0; q < 10; q++)
            if(this.employees[q] != null && this.employees[q].getName().equals(name)){
                this.employees[q].setDepartment(department);
                return;
            }

        throw new RuntimeException("Employee didnt found");
    }

    public void printDepartments(){
        for(String department: new String[]{"1", "2", "3", "4", "5"}){
            System.out.println("Department " + department + ":");
            print(department);
        }
    }
}
