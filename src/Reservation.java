import java.io.Serializable;

public class Reservation implements Serializable {
    private Table table;
    private String customerName;
    private String customerPhone;

    public Reservation(Table table, String customerName, String customerPhone) {
        this.table = table;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    public Table getTable() {
        return table;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }
}