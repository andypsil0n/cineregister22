package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class ReceiptTest {
    private String wantedReceiptAsString;
    private Seat seat1 = new Seat(5, 7, 7.00, '#');
    private Seat seat2 = new Seat(5, 8, 7.00, '#');
    private ArrayList<Seat> seats = new ArrayList();

    @BeforeEach
    void setUp() {
        wantedReceiptAsString = "Rechnung\n" +
                                "\n" +
                                "Film:    Doctor Strange\n" +
                                "Zeit:    Mo/17:00\n" +
                                "Saal:    hall1\n" +
                                "-------------------------------\n" +
                                "Sitz 1:  Reihe 5 Platz 7, 7,00€\n" +
                                "Sitz 2:  Reihe 5 Platz 8, 7,00€\n" +
                                "\n" +
                                "Gesamt:                  14,00€\n" +
                                "Status:  gebucht und bezahlt\n" +
                                "-------------------------------\n" +
                                "Käufer:  Bernd Baum\n";

        seats.add(seat1);
        seats.add(seat2);
    }

    @Test
    void receipt_getReceiptAsString_returnsReceiptAsStringWithBookedSeats() {
        Receipt receipt = new Receipt(1);

        receipt.setMovieName("Doctor Strange");
        receipt.setShowDates("Mo/17:00");
        receipt.setHall("hall1");

        receipt.addSeat(seat1);
        receipt.addSeat(seat2);

        receipt.addClientName("Bernd Baum");

        String receiptAsString = receipt.getReceiptAsString();
        assertThat(receiptAsString).isEqualTo(wantedReceiptAsString);

    }

    @Test
    void receipt_getReceiptAsString_returnsReceiptAsStringWithReservedSeats() {
        String wantedReceiptAsString = "Rechnung\n" +
                "\n" +
                "Film:    Doctor Strange\n" +
                "Zeit:    Mo/17:00\n" +
                "Saal:    hall1\n" +
                "-------------------------------\n" +
                "Sitz 1:  Reihe 5 Platz 7, 7,00€\n" +
                "Sitz 2:  Reihe 5 Platz 8, 7,00€\n" +
                "\n" +
                "Gesamt:                  14,00€\n" +
                "Status:  reserviert und unbezahlt\n" +
                "-------------------------------\n" +
                "Käufer:  Bernd Baum\n";;

        Receipt receipt = new Receipt(1);

        receipt.setMovieName("Doctor Strange");
        receipt.setShowDates("Mo/17:00");
        receipt.setHall("hall1");

        receipt.addSeat(new Seat(5, 7, 7.00, 'r'));
        receipt.addSeat(new Seat(5, 8, 7.00, 'r'));

        receipt.addClientName("Bernd Baum");

        String receiptAsString = receipt.getReceiptAsString();
        assertThat(receiptAsString).isEqualTo(wantedReceiptAsString); // ändern

    }

    @Test
    void receipt_getReceiptAsString_returnsReceiptAsStringWithStatusCantBeRead() {
        String wantedReceiptAsString = "Rechnung\n" +
                "\n" +
                "Film:    Doctor Strange\n" +
                "Zeit:    Mo/17:00\n" +
                "Saal:    hall1\n" +
                "-------------------------------\n" +
                "Sitz 1:  Reihe 5 Platz 7, 7,00€\n" +
                "Sitz 2:  Reihe 5 Platz 8, 7,00€\n" +
                "\n" +
                "Gesamt:                  14,00€\n" +
                "Status:  konnte nicht ermittelt werden\n" +
                "-------------------------------\n" +
                "Käufer:  Bernd Baum\n";;

        Receipt receipt = new Receipt(1);

        receipt.setMovieName("Doctor Strange");
        receipt.setShowDates("Mo/17:00");
        receipt.setHall("hall1");

        receipt.addSeat(new Seat(5, 7, 7.00, ' '));
        receipt.addSeat(new Seat(5, 8, 7.00, ' '));

        receipt.addClientName("Bernd Baum");

        String receiptAsString = receipt.getReceiptAsString();
        assertThat(receiptAsString).isEqualTo(wantedReceiptAsString); // ändern

    }

    @Test
    void receipt_saveReceipt_savesReceiptToDownloadFolder() throws FileNotFoundException {
        Receipt receipt = new Receipt(0);

        receipt.setMovieName("Doctor Strange");
        receipt.setShowDates("Mo/17:00");
        receipt.setHall("hall1");

        receipt.addSeat(seat1);
        receipt.addSeat(seat2);

        receipt.addClientName("Bernd Baum");

        receipt.saveReceipt();

        String home = System.getProperty("user.home");

        File receiptFile = new File(home + "\\Downloads\\" + "Rechnung0.txt");
        Scanner scanner = new Scanner(receiptFile);
        String firstLine = scanner.nextLine();

        assertThat(firstLine).isEqualTo("Rechnung");
    }
}
