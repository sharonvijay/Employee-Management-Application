import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nEMPLOYEE MANAGEMENT APPLICATION");
                System.out.println("1 - CREATE, 2 - READ, 3 - UPDATE, 4 - DELETE");
                try {
                    int choice = sc.nextInt();
                    sc.nextLine(); // Consume the remaining newline character

                    if (choice < 1 || choice > 4) {
                        System.out.println("Invalid choice. Please enter a valid choice (1, 2, 3, or 4).");
                        continue; // Continue to the next iteration of the loop
                    }

                    switch (choice) {
                        case 1:
                            System.out.println("ID, NAME, EMAILID, SALARY");
                            int id = sc.nextInt();
                            sc.nextLine();
                            String name = sc.nextLine();
                            String emailid = sc.nextLine();
                            int salary = sc.nextInt();
                            sc.nextLine(); // Consume the remaining newline character
                            Employee emp = new Employee(id, name, emailid, salary);
                            EmployeeDao.createEmployee(emp);
                            break;

                        case 2:
                            ArrayList<Employee> list = EmployeeDao.readEmployees();
                            for (Employee employee : list) {
                                System.out.println(employee);
                            }
                            break;

                        case 3:
                            System.out.println("ENTER ID AND EMPLOYEE NAME TO UPDATE");
                            id = sc.nextInt();
                            sc.nextLine();
                            name = sc.nextLine();
                            EmployeeDao.updateEmployee(id, name);
                            break;

                        case 4:
                            System.out.println("ENTER ID TO DELETE THE EMPLOYEE DETAILS");
                            id = sc.nextInt();
                            sc.nextLine();
                            EmployeeDao.deleteEmployee(id);
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid choice (1, 2, 3, or 4).");
                    sc.nextLine(); // Clear the input buffer
                }
            }
        }
    }

}
