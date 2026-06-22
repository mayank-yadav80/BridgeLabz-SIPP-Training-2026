import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int id;
    private final String name;
    private final String department;
    private final double salary;
    private final int skillScore;

    public Employee(int id, String name, String department, double salary, int skillScore) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skillScore = skillScore;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getSkillScore() {
        return skillScore;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', department='%s', salary=%.2f, skillScore=%d}", id, name, department, salary, skillScore);
    }
}

public class EmployeeSkillAssignment {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Employee> employees = new ArrayList<>();
            System.out.print("Enter number of employees: ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < n; i++) {
                System.out.println("Enter details for employee " + (i + 1) + " (id,name,department,salary,skillScore):");
                String[] data = scanner.nextLine().split(",");
                if (data.length < 5) {
                    System.out.println("Invalid input format. Try again.");
                    i--;
                    continue;
                }
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String department = data[2].trim();
                double salary = Double.parseDouble(data[3].trim());
                int skillScore = Integer.parseInt(data[4].trim());
                employees.add(new Employee(id, name, department, salary, skillScore));
            }
            System.out.print("Enter target skill sum for a team: ");
            int target = Integer.parseInt(scanner.nextLine().trim());
            findTeams(employees, target);
            serializeEmployees(employees, "employees.ser");
            List<Employee> recoveredEmployees = deserializeEmployees("employees.ser");
            System.out.println("Recovered employee information:");
            for (Employee employee : recoveredEmployees) {
                System.out.println(employee);
            }
        } catch (IOException e) {
            System.out.println("An error occurred during employee serialization.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input.");
        }
    }

    private static void findTeams(List<Employee> employees, int target) {
        int n = employees.size();
        boolean found = false;
        System.out.println("Teams with total skill score " + target + ":");
        for (int mask = 1; mask < (1 << n); mask++) {
            int sum = 0;
            List<Employee> team = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += employees.get(i).getSkillScore();
                    team.add(employees.get(i));
                }
            }
            if (sum == target) {
                found = true;
                System.out.println(team);
            }
        }
        if (!found) {
            System.out.println("No matching team found.");
        }
    }

    private static void serializeEmployees(List<Employee> employees, String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(new ArrayList<>(employees));
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Employee> deserializeEmployees(String fileName) throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Employee>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Failed to deserialize employee data", e);
        }
    }
}
