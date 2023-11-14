// PurchaseResponse.java
package cinema;

class PurchaseResponse {
    private final String token;
    private final Ticket ticket;

    public PurchaseResponse(String token, Ticket ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
