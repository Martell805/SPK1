import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private final Map<String, Employee> employees = new HashMap<>();
    
    public void print(){
        for(String fullName: this.employees.keySet())
            System.out.println(this.employees.get(fullName));
    }

    public int sumOfSalaries(){
        int result = 0;

        for(String fullName: this.employees.keySet())
            result += this.employees.get(fullName).getSalary();

        return result;
    }

    public int minSalary(){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        int result = -1;

        for(String fullName: this.employees.keySet())
            result = (result != -1) ? 
                    Math.min(result, this.employees.get(fullName).getSalary()) :
                    this.employees.get(fullName).getSalary();

        return result;
    }

    public int maxSalary(){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        int result = -1;

        for(String fullName: this.employees.keySet())
            result = (result != -1) ? 
                    Math.max(result, this.employees.get(fullName).getSalary()) :
                    this.employees.get(fullName).getSalary();

        return result;
    }

    public int averageSalary(){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        return sumOfSalaries() / this.employees.size();
    }

    public void printNames(){
        for(String fullName: this.employees.keySet())
            System.out.println(fullName);
    }

    public void indexSalary(int percent){
        for(String fullName: this.employees.keySet())
            this.employees.get(fullName).setSalary(
                    (int)(this.employees.get(fullName).getSalary() * (1 + percent / 100.0))
            );
    }

    private boolean belongsTo(Employee employee, String department){
        return employee != null && employee.getDepartment().equals(department);
    }

    public int sumOfSalaries(String department){
        int result = 0;

        for(String fullName: this.employees.keySet())
            if(belongsTo(this.employees.get(fullName), department))
                result += this.employees.get(fullName).getSalary();

        return result;
    }

    public int minSalary(String department){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        int result = -1;

        for(String fullName: this.employees.keySet())
            if(belongsTo(this.employees.get(fullName), department))
                result = (result != -1) ? 
                        Math.min(result, this.employees.get(fullName).getSalary()) : 
                        this.employees.get(fullName).getSalary();

        return result;
    }

    public int maxSalary(String department){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        int result = -1;

        for(String fullName: this.employees.keySet())
            if(belongsTo(this.employees.get(fullName), department))
                result = (result != -1) ? 
                        Math.max(result, this.employees.get(fullName).getSalary()) : 
                        this.employees.get(fullName).getSalary();

        return result;
    }

    public int averageSalary(String department){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        int sum = 0;
        int quantity = 0;

        for(String fullName: this.employees.keySet())
            if(belongsTo(this.employees.get(fullName), department)){
                sum += this.employees.get(fullName).getSalary();
                quantity++;
            }

        if(quantity == 0) throw new RuntimeException("Chosen department is empty");

        return sum / quantity;
    }

    public void indexSalary(int percent, String department){
        for(String fullName: this.employees.keySet())
            if(belongsTo(this.employees.get(fullName), department))
                this.employees.get(fullName).setSalary(
                        (int)(this.employees.get(fullName).getSalary() * (1 + percent / 100.0))
                );
    }

    public void print(String department){
        for(String fullName: this.employees.keySet())
            if(belongsTo(this.employees.get(fullName), department))
                System.out.println(this.employees.get(fullName));
    }

    public void printEmployeesWithLessSalary(int salary){
        for(String fullName: this.employees.keySet())
            if(this.employees.get(fullName) != null && this.employees.get(fullName).getSalary() < salary)
                System.out.println(this.employees.get(fullName));
    }

    public void printEmployeesWithHighersSalary(int salary){
        for(String fullName: this.employees.keySet())
            if(this.employees.get(fullName) != null && this.employees.get(fullName).getSalary() >= salary)
                System.out.println(this.employees.get(fullName));
    }

    public void addEmployee(Employee new_employee){
        if(this.employees.size() == 10) throw new RuntimeException("EmployeeBook is already full");

        employees.put(new_employee.getName(), new_employee);
    }

    public void deleteEmployee(int id){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        for(String fullName: this.employees.keySet())
            if(this.employees.get(fullName).getId() == id){
                this.employees.remove(fullName);
                return;
            }

        throw new RuntimeException("Employee not found");
    }

    public void deleteEmployee(String name){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        if(!this.employees.containsKey(name))
            throw new RuntimeException("Employee not found");

        this.employees.remove(name);
    }

    public void deleteEmployee(int id, String name){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        if(!this.employees.containsKey(name))
            throw new RuntimeException("Employee not found");

        if(this.employees.get(name).getId() != id)
            throw new RuntimeException("Employee not found");

        this.employees.remove(name);
    }

    public void setSalary(String name, int salary){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        if(!this.employees.containsKey(name))
            throw new RuntimeException("Employee not found");

        this.employees.get(name).setSalary(salary);
    }

    public void setDepartment(String name, String department){
        if(this.employees.size() == 0) throw new RuntimeException("EmployeeBook is empty");

        if(!this.employees.containsKey(name))
            throw new RuntimeException("Employee not found");

        this.employees.get(name).setDepartment(department);
    }

    public void printDepartments(){
        for(String department: new String[]{"1", "2", "3", "4", "5"}){
            System.out.println("Department " + department + ":");
            print(department);
        }
    }
}
