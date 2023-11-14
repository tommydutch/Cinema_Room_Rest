// CinemaController.java
package cinema;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CinemaController {

    private final int totalRows = 9;
    private final int totalColumns = 9;
    private final List<Ticket> bookedTickets = new ArrayList<>();

    @GetMapping("/seats")
    public CinemaInfo getAvailableSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= totalRows; row++) {
            for (int column = 1; column <= totalColumns; column++) {
                int price = (row <= 4) ? 10 : 8;
                seats.add(new Seat(row, column, price));
            }
        }
        return new CinemaInfo(totalRows, totalColumns, seats);
    }

    @PostMapping("/purchase")
    public Object purchaseTicket() {
        int randomRow = new Random().nextInt(totalRows) + 1;
        int randomColumn = new Random().nextInt(totalColumns) + 1;

        int price = (randomRow <= 4) ? 10 : 8;
        Ticket newTicket = new Ticket(randomRow, randomColumn, price);
        String token = UUID.randomUUID().toString();

        bookedTickets.add(newTicket);
        return new PurchaseResponse(token, newTicket);
    }

    @PostMapping("/return")
    public Object returnTicket(@RequestBody TokenRequest tokenRequest) {
        String token = tokenRequest.getToken();
        Optional<Ticket> ticketToReturn = bookedTickets.stream()
                .filter(ticket -> token.equals(ticket.getToken()))
                .findFirst();

        if (ticketToReturn.isPresent()) {
            Ticket returnedTicket = ticketToReturn.get();
            bookedTickets.remove(returnedTicket);
            return new ReturnResponse(returnedTicket);
        } else {
            return new ErrorResponse("Wrong token!");
        }
    }
}
