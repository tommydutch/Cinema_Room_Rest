// ReturnResponse.java
package cinema;

class ReturnResponse {
    private final Ticket ticket;

    public ReturnResponse(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
