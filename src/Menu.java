import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Menu {
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
        for (MenuItem item : items) {
            System.out.println(item.getName() + " - " + item.getDescription() + " - $" + item.getPrice());
        }
    }
}