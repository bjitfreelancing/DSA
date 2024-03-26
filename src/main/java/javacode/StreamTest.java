package javacode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
  public static void main(String[] args) {
    StreamTest test = new StreamTest();
    test.test();
  }
  private void test() {
    Employee[] employees = {
        new Employee(1, "Jeff Bezos", 100000.0),
        new Employee(2, "Bill Gates", 200000.0),
        new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    List<Employee> employeeList = Stream.of(employees).map(this::addIncentive).collect(Collectors.toList());
    employeeList.stream().forEach(employee -> System.out.println(employee.name + ":" + employee.salary));

  }

  private Employee addIncentive(Employee emp) {
    emp.salary = emp.salary + emp.salary * 0.2;
    return emp;
  }
  private class Employee {
    private int id;
    private String name;
    private double salary;
    private Employee(int id, String name, double salary) {
      this.id = id;
      this.name = name;
      this.salary = salary;
    }
  }
}
