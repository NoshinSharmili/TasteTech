import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public void displayMenu() {
        if (items.isEmpty()) {
            System.out.println("The menu is empty.");
        } else {
            for (MenuItem item : items) {
                System.out.println(item.getName() + " - " + item.getDescription() + " - $" + item.getPrice());
            }
        }
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public List<MenuItem> getItems() {
        return items;
    }
}
