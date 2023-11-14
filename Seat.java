package cinema;

public class Seat {
    private int row;
    private int column;
    private boolean booked;
    private String token;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.booked = false;
        this.token = null;
    }

    public Seat(int row, int column, int price) {
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book(String token) {
        this.booked = true;
        this.token = token;
    }

    public void unbook() {
        this.booked = false;
        this.token = null;
    }

    public String getToken() {
        return token;
    }
}
