package cinema;

import java.util.UUID;

public class Booking {
    private Seat seat;
    private String token;

    public Booking(Seat seat) {
        this.seat = seat;
        this.token = UUID.randomUUID().toString();
    }

    public Seat getSeat() {
        return seat;
    }

    public String getToken() {
        return token;
    }
}
