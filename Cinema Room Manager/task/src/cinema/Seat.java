package cinema;

public class Seat {
    private final int row;
    private final int column;
    private boolean booked;
    private int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.booked = false;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }

    public String getStatusSymbol() {
        return booked ? "B" : "S";
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
