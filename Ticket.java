// Ticket.java
package cinema;

import java.util.Objects;
import java.util.UUID;

class Ticket {
    private final int row;
    private final int column;
    private final int price;
    private final String token;

    public Ticket(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.token = UUID.randomUUID().toString();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ticket ticket = (Ticket) obj;
        return row == ticket.row && column == ticket.column && Objects.equals(token, ticket.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, token);
    }
}
