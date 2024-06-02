import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu implements Displayable {
    private Menu menu;
    private List<Table> tables;
    private List<Reservation> reservations;
    private List<Order> orders;

    public AdminMenu(Menu menu, List<Reservation> reservations, List<Order> orders) {
        this.menu = menu;
        this.tables = new ArrayList<>();
        this.reservations = reservations;
        this.orders = orders;
    }

    @Override
    public void displayMenu() {
        menu.displayMenu();
    }

    public void adminMenu(Scanner scanner) {
        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("\nAdmin Menu Management");
            System.out.println("1. View Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Remove Menu Item");
            System.out.println("4. View Tables");
            System.out.println("5. Add Table");
            System.out.println("6. Reserve Table");
            System.out.println("7. View Reservations");
            System.out.println("8. View Orders");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    addMenuItem(scanner);
                    break;
                case 3:
                    removeMenuItem(scanner);
                    break;
                case 4:
                    displayTables();
                    break;
                case 5:
                    addTable(scanner);
                    break;
                case 6:
                    reserveTable(scanner);
                    break;
                case 7:
                    displayReservations();
                    break;
                case 8:
                    displayOrders();
                    break;
                case 9:
                    adminRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMenuItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item description: ");
        String description = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        MenuItem newItem = new MenuItem(name, description, price);
        menu.addItem(newItem);
        System.out.println("Item added successfully.");
    }

    private void removeMenuItem(Scanner scanner) {
        System.out.print("Enter the name of the item to remove: ");
        String name = scanner.nextLine();

        boolean removed = false;
        for (MenuItem item : menu.getItems()) {
            if (item.getName().equals(name)) {
                menu.removeItem(item);
                System.out.println("Item removed successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Item not found.");
        }
    }

    private void addTable(Scanner scanner) {
        System.out.print("Enter table number: ");
        int tableNumber = scanner.nextInt();
        System.out.print("Enter number of seats: ");
        int numberOfSeats = scanner.nextInt();
        scanner.nextLine();

        Table table = new Table(tableNumber, numberOfSeats);
        tables.add(table);
        System.out.println("Table added successfully.");
    }

    private void reserveTable(Scanner scanner) {
        System.out.print("Enter table number to reserve: ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine();

        boolean reserved = false;
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber && !table.isReserved()) {
                System.out.print("Enter customer name: ");
                String customerName = scanner.nextLine();
                System.out.print("Enter customer phone number: ");
                String customerPhone = scanner.nextLine();

                table.reserve();
                reservations.add(new Reservation(table, customerName, customerPhone));
                System.out.println("Table reserved successfully.");
                reserved = true;
                break;
            }
        }

        if (!reserved) {
            System.out.println("Table not found or already reserved.");
        }
    }

    private void displayTables() {
        if (tables.isEmpty()) {
            System.out.println("No tables available.");
        } else {
            for (Table table : tables) {
                System.out.println("Table " + table.getTableNumber() + " - " + table.getNumberOfSeats() + " seats - " + (table.isReserved() ? "Reserved" : "Available"));
            }
        }
    }

    private void displayReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations available.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println("Reservation: Table " + reservation.getTable().getTableNumber() + " reserved by " + reservation.getCustomerName() + " (" + reservation.getCustomerPhone() + ")");
            }
        }
    }

    private void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            for (Order order : orders) {
                order.displayOrder();
            }
        }
    }
}
