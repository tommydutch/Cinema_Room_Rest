// TicketInfo.java
package cinema;

class TicketInfo {
    private final int row;
    private final int column;
    private final int price;

    public TicketInfo(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
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
}
