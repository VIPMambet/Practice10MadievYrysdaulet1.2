import java.util.ArrayList;
import java.util.List;

abstract class OrganizationComponent {
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    public abstract void display();
    public abstract double getBudget();
}

class Employee extends OrganizationComponent {
    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void display() {
        System.out.println("Сотрудник: " + name + ", Должность: " + position + ", Зарплата: " + salary);
    }

    @Override
    public double getBudget() {
        return salary;
    }
}

class Department extends OrganizationComponent {
    private String name;
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Отдел: " + name);
        for (OrganizationComponent component : components) {
            component.display();
        }
    }

    @Override
    public double getBudget() {
        double budget = 0;
        for (OrganizationComponent component : components) {
            budget += component.getBudget();
        }
        return budget;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Иванов Иван", "Разработчик", 50000);
        Employee employee2 = new Employee("Петров Петр", "Тестировщик", 45000);

        Department department = new Department("IT Отдел");
        department.add(employee1);
        department.add(employee2);

        department.display();
        System.out.println("Бюджет отдела: " + department.getBudget());
    }
}
