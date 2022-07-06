package hwr.oop;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Receipt {
    private final int receiptNumber;
    private String movieName;
    private ArrayList<Seat> seats = new ArrayList<>();
    private String clientName;
    private String showDates;
    private String hall;

    public Receipt(int run) {
        this.receiptNumber = run;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setShowDates(String showDates) {
        this.showDates = showDates;
    }


    public void setHall(String hall) {
        this.hall = hall;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    private double getTotalCosts() {
        double totalCosts = 0;

        for (int seatCount = 0; seatCount < seats.size(); seatCount++) {
            totalCosts = totalCosts + seats.get(seatCount).getPrice();
        }
        return totalCosts;
    }


    public void addClientName(String clientName) {
        this.clientName= clientName;
    }

    public String getReceiptAsString() {
        String titleLine = "Rechnung\n";
        String freeLine = "\n";
        
        String movieLine = "Film:    " + movieName + "\n";
        String showLine =  "Zeit:    " + showDates + "\n";
        String hallLine =  "Saal:    " + hall + "\n";
        
        String seperatorLine = "-------------------------------\n";
        
        String seatsAsString = "";
        seatsAsString = getSeatsAsString();
        
        String completePriceLine = "Gesamt:                  " + getPriceAString(getTotalCosts()) + "\n";
        
        String statusLine = "Status:  ";
        Seat seat = seats.get(0);
        if (seat.getStateAsChar() == 'r') {
            statusLine = statusLine + "reserviert und unbezahlt\n";
        } else if (seat.getStateAsChar() == '#') {
            statusLine = statusLine + "gebucht und bezahlt\n";
        } else {
            statusLine = statusLine + "konnte nicht ermittelt werden\n";
        }
            
        String nameLine = "Käufer:  " + clientName + "\n";
        
        String receiptAsString = "";
        
        receiptAsString = titleLine + freeLine + movieLine + showLine + hallLine + seperatorLine + seatsAsString +
                freeLine + completePriceLine + statusLine + seperatorLine + nameLine;
        
        return receiptAsString;
    }

    private String getSeatsAsString() {
        String seatsAsString = "";

        for (int seatCount = 0; seatCount < seats.size(); seatCount++) {
            Seat seat = seats.get(seatCount);

            String priceString = getPriceAString(seat.getPrice());

            String seatString = "Sitz " + (seatCount+1) + ":  " + "Reihe " + seat.getRow() +
                    " Platz " + seat.getNumber() + ", " + priceString + "\n";
            seatsAsString = seatsAsString + seatString;
        }

        return seatsAsString;
    }

    private String getPriceAString(double price) {
        String priceString = String.format("%.2f€", price);
        return priceString;
    }


    public void saveReceipt() {
        String home = System.getProperty("user.home");
        Path p = Path.of(home + "\\Downloads\\" + "Rechnung" + receiptNumber + ".txt");
        try {
            Path receiptPath = Files.writeString(p, getReceiptAsString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
