import java.util.HashMap;
import java.util.Map;

class TableManager {
    private Map<Integer, Table> tables;

    public TableManager() {
        this.tables = new HashMap<>();
    }

    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    public void removeTable(int tableNumber) {
        tables.remove(tableNumber);
    }

    public boolean isTableAvailable(int tableNumber) {
        Table table = tables.get(tableNumber);
        return table != null && !table.isOccupied();
    }

    // Other methods as needed
}