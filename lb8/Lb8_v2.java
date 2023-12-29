package lb8;

import java.util.*;

public class Lb8_v2 {

    public static class Main {
        public static void main(String[] args) {
            // Створення працівників
            Employee director = new Employee("John", "Doe", 100000.0);
            Employee head1 = new Employee("Alice", "Smith", 80000.0);
            Employee head2 = new Employee("Bob", "Johnson", 75000.0);
            Employee employee1 = new Employee("Eva", "Davis", 90000.0);
            Employee employee2 = new Employee("Chris", "Williams", 70000.0);
            Employee employee3 = new Employee("Grace", "Brown", 65000.0);

            // Створення відділів
            Department department1 = new Department("HR", head1);
            department1.addEmployee(employee1);

            Department department2 = new Department("IT", head2);
            department2.addEmployee(employee2);
            department2.addEmployee(employee3);

            // Створення фірми
            Company company = new Company("XYZ lb8.Lb8_v2.Company", director);
            company.addDepartment(department1);
            company.addDepartment(department2);

            // Завдання 1: Знайти значення максимальної заробітної платні
            double maxSalary = company.getMaxSalary();
            System.out.println("Максимальна заробітна платня: " + maxSalary);

            // Завдання 2: Визначити, відділ, в якому хоча б один з співробітників отримує більше за свого начальника
            Set<Department> departmentsWithHigherSalary = company.findDepartmentsWithHigherSalary();
            System.out.println("Відділи з працівниками, які отримують більше за свого начальника: " + departmentsWithHigherSalary);

            // Завдання 3: Скласти список усіх співробітників фірми, включаючи начальників та директора
            Set<Employee> allEmployees = company.getAllEmployees();
            System.out.println("Усі співробітники фірми:");
            for (Employee employee : allEmployees) {
                System.out.println(employee.firstName + " " + employee.lastName + " - " + employee.salary);
            }
        }
    }

    public static class Employee {
        String firstName;
        String lastName;
        double salary;

        public Employee(String firstName, String lastName, double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }
    }

    public static class Department {
        String name;
        Employee head;
        Set<Employee> employees;

        public Department(String name, Employee head) {
            this.name = name;
            this.head = head;
            this.employees = new HashSet<>();
        }

        public void addEmployee(Employee employee) {
            employees.add(employee);
        }
    }

    public static class Company {
        String name;
        Employee director;
        Set<Department> departments;
        Map<Employee, Department> employeeDepartmentMap;

        public Company(String name, Employee director) {
            this.name = name;
            this.director = director;
            this.departments = new HashSet<>();
            this.employeeDepartmentMap = new HashMap<>();
        }

        public void addDepartment(Department department) {
            departments.add(department);

            for (Employee employee : department.employees) {
                employeeDepartmentMap.put(employee, department);
            }
        }

        // Завдання 1: Знайти значення максимальної заробітної платні
        public double getMaxSalary() {
            double maxSalary = director.salary;

            for (Department department : departments) {
                maxSalary = Math.max(maxSalary, department.head.salary);

                Iterator<Employee> employeeIterator = department.employees.iterator();
                while (employeeIterator.hasNext()) {
                    Employee employee = employeeIterator.next();
                    maxSalary = Math.max(maxSalary, employee.salary);
                }
            }

            return maxSalary;
        }

        // Завдання 2: Визначити, відділ, в якому хоча б один з співробітників отримує заробітну
        // платню вищу за платню свого начальника
        public Set<Department> findDepartmentsWithHigherSalary() {
            Set<Department> departmentsWithHigherSalary = new HashSet<>();

            Iterator departmentIterator = departments.iterator();
            while (departmentIterator.hasNext()) {
                Department department = (Department) departmentIterator.next();
                Iterator employeeIterator = department.employees.iterator();
                while (employeeIterator.hasNext()) {
                    Employee employee = (Employee) employeeIterator.next();
                    if (employee.salary > department.head.salary) {
                        departmentsWithHigherSalary.add(department);
                        break;
                    }
                }
            }

            return departmentsWithHigherSalary;
        }

        // Завдання 3: Скласти список усіх співробітників фірми, включаючи начальників та директора
        public Set<Employee> getAllEmployees() {
            Set<Employee> allEmployees = new HashSet<>();

            allEmployees.add(director);

            for (Department department : departments) {
                allEmployees.add(department.head);

                for (Employee employee : department.employees) {
                    allEmployees.add(employee);
                }
            }

            return allEmployees;
        }
    }
}