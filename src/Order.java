import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private List<OrderItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem menuItem, int quantity) {
        items.add(new OrderItem(menuItem, quantity));
    }

    public void displayOrder() {
        double total = 0;
        System.out.println("Order Summary:");
        for (OrderItem orderItem : items) {
            MenuItem item = orderItem.getMenuItem();
            int quantity = orderItem.getQuantity();
            double price = item.getPrice() * quantity;
            total += price;
            System.out.println(item.getName() + " - " + quantity + " x $" + item.getPrice() + " = $" + price);
        }
        System.out.println("Total: $" + total);
        System.out.println();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void clearOrder() {
        items.clear();
    }
}

