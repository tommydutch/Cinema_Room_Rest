// CinemaInfo.java
package cinema;

import java.util.List;

class CinemaInfo {
    private final int rows;
    private final int columns;
    private final List<Seat> seats;

    public CinemaInfo(int rows, int columns, List<Seat> seats) {
        this.rows = rows;
        this.columns = columns;
        this.seats = seats;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
