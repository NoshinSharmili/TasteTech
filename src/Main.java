import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ADMIN_PIN = "1234";
    public static final String FILE_PATH = "resources//menu.ser";
    private static Menu menu;
    private static List<Reservation> reservations;
    private static List<Order> orders;

    public static void main(String[] args) {
        menu = FileUtility.loadMenuFromFile(FILE_PATH);
        if (menu == null) {
            menu = new Menu();
        }

        reservations = new ArrayList<>();
        orders = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to TasteTech");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (authenticateAdmin(scanner)) {
                        AdminMenu adminMenu = new AdminMenu(menu, reservations, orders);
                        adminMenu.adminMenu(scanner);
                    } else {
                        System.out.println("Invalid PIN. Access denied.");
                    }
                    break;
                case 2:
                    CustomerMenu customerMenu = new CustomerMenu(menu, reservations, orders);
                    customerMenu.customerMenu(scanner);
                    break;
                case 3:
                    running = false;
                    FileUtility.saveMenuToFile(menu, FILE_PATH);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static boolean authenticateAdmin(Scanner scanner) {
        System.out.print("Enter admin PIN: ");
        String enteredPin = scanner.nextLine();
        return ADMIN_PIN.equals(enteredPin);
    }
}

