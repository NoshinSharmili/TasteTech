class Table {
    private int tableNumber;
    private boolean occupied;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.occupied = false;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
