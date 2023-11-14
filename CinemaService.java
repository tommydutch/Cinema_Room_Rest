package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CinemaService {
    private List<List<Seat>> seats;
    private int totalRows;
    private int totalColumns;

    public CinemaService(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.seats = new ArrayList<>();

        initializeSeats();
    }

    private void initializeSeats() {
        for (int row = 1; row <= totalRows; row++) {
            List<Seat> rowSeats = new ArrayList<>();
            for (int col = 1; col <= totalColumns; col++) {
                rowSeats.add(new Seat(row, col));
            }
            seats.add(rowSeats);
        }
    }

    public CinemaResponse getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (List<Seat> rowSeats : seats) {
            for (Seat seat : rowSeats) {
                if (!seat.isBooked()) {
                    availableSeats.add(seat);
                }
            }
        }
        return new CinemaResponse(totalRows, totalColumns, availableSeats);
    }

    public CinemaResponse purchaseTicket(PurchaseRequest request) {
        int row = request.getRow();
        int col = request.getColumn();

        if (isOutOfBounds(row, col)) {
            return new CinemaResponse("The number of a row or a column is out of bounds!");
        }

        Seat seat = seats.get(row - 1).get(col - 1);

        if (seat.isBooked()) {
            return new CinemaResponse("The ticket has been already purchased!");
        }

        String token = UUID.randomUUID().toString();
        seat.book(token);

        return new CinemaResponse(token, seat);
    }

    // Other methods for refund, statistics, etc.

    private boolean isOutOfBounds(int row, int col) {
        return row < 1 || row > totalRows || col < 1 || col > totalColumns;
    }
}
