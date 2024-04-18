import java.util.ArrayList;
import java.util.List;
class Order {
    private int tableNumber;
    private List<MenuItem> items;

    public Order(int tableNumber) {
        this.tableNumber = tableNumber;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    // Other methods as needed
}