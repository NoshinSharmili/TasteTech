import java.io.Serializable;

public class Table implements Serializable {
    private int tableNumber;
    private int numberOfSeats;
    private boolean reserved;

    public Table(int tableNumber, int numberOfSeats) {
        this.tableNumber = tableNumber;
        this.numberOfSeats = numberOfSeats;
        this.reserved = false;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        this.reserved = true;
    }

    public void unreserve() {
        this.reserved = false;
    }
}
