package hwr.oop;

public class Receipt {
private String movieName;
private int row;
private int number;
private double price;
private int state;
private String clientName;
    public void addMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void addSeatInformation(int row, int number, double price, int state) {
        this.row = row;
        this.number = number;
        this.price = price;
        this.state = state;
    }

    public Seat getSeatInformation() {
        return new Seat(row,number,price,state);
    }

    public void addClientName(String clientName) {
        this.clientName= clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getReceiptAsString(String clientName) {
        return("Client Name: "+ clientName);
    }
}
