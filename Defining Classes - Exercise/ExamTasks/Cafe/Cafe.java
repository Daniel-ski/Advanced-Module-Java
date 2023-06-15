package Exercise.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().contains(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).get();


     /*   int greatestAge = 0;
        Employee greatestEmployee = null;

        for (Employee employee : employees) {
            if (employee.getAge() > greatestAge){
                greatestAge = employee.getAge();
                greatestEmployee = employee;
            }
        }
        return greatestEmployee;

      */
    }

    public Employee getEmployee(String name){
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe " + this.name + ":").append(System.lineSeparator());
       this.employees.forEach(employee -> sb.append(employee.toString()).append(System.lineSeparator()));

        return sb.toString();
    }
}
