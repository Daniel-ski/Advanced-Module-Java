package DefiningClasses_Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
   private List<Employee> employeeList;
   private String name;

   public Department(String name) {
      this.name = name;
      employeeList = new ArrayList<>();
   }
   public double calculateAverageSalary(){
      return this.employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0);
   }

   public String getName() {
      return name;
   }

   public List<Employee> getEmployeeList() {
      return employeeList;
   }

}
