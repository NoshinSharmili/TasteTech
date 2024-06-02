import java.util.List;
import java.util.Scanner;

public class CustomerMenu implements Displayable {
    private Menu menu;
    private Order order;
    private List<Reservation> reservations;
    private List<Order> orders;

    public CustomerMenu(Menu menu, List<Reservation> reservations, List<Order> orders) {
        this.menu = menu;
        this.order = new Order();
        this.reservations = reservations;
        this.orders = orders;
    }

    @Override
    public void displayMenu() {
        menu.displayMenu();
    }

    public void customerMenu(Scanner scanner) {
        boolean customerRunning = true;

        while (customerRunning) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("\nCustomer Menu");
            System.out.println("1. View Menu");
            System.out.println("2. Add Item to Order");
            System.out.println("3. View Cart");
            System.out.println("4. Search Reservations");
            System.out.println("5. Submit Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    addItemToOrder(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    searchReservations(scanner);
                    break;
                case 5:
                    submitOrder();
                    customerRunning = false;
                    break;
                case 6:
                    customerRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addItemToOrder(Scanner scanner) {
        System.out.print("Enter the name of the item to order: ");
        String name = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (MenuItem item : menu.getItems()) {
            if (item.getName().equals(name)) {
                order.addItem(item, quantity);
                System.out.println("Item added to cart.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found in the menu.");
        }
    }

    private void viewCart() {
        order.displayOrder();
    }

    private void submitOrder() {
        System.out.println("Order submitted successfully.");
        orders.add(order);
        order = new Order();
    }

    private void searchReservations(Scanner scanner) {
        System.out.print("Enter your name or phone number to search for reservations: ");
        String searchQuery = scanner.nextLine();

        boolean found = false;
        for (Reservation reservation : reservations) {
            if (reservation.getCustomerName().equalsIgnoreCase(searchQuery) || reservation.getCustomerPhone().equals(searchQuery)) {
                System.out.println("Reservation found: Table " + reservation.getTable().getTableNumber() + " reserved by " + reservation.getCustomerName() + " (" + reservation.getCustomerPhone() + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No reservations found for the provided name or phone number.");
        }
    }
}

