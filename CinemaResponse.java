package cinema;

import java.util.List;

public class CinemaResponse {
    private String token;
    private List<Seat> seats;
    private String error;

    public CinemaResponse() {
    }

    public CinemaResponse(int rows, int columns, List<Seat> seats) {
        this.seats = seats;
    }

    public CinemaResponse(Seat seat) {
        this.token = seat.getToken();
        this.seats = List.of(seat);
    }

    public CinemaResponse(String error) {
        this.error = error;
    }

    public CinemaResponse(String string, Seat seat) {
    }

    // Getters and setters
}
