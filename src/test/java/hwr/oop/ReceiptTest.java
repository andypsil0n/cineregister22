package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReceiptTest {
    @Test
    void receipt_get_totalSeatCosts_returns_totalPrice() {
        Seat seat1 = new Seat(1, 1, 7.00, 2);
        Seat seat2 = new Seat(1, 1, 7.00, 2);
        assertThat(seat1.getPrice()+seat2.getPrice()).isEqualTo(14.00);
    }
    @Test // Eingaben die beim bezahlen gemacht werden auch überprüfen?
    void receipt_getCreditCardNumber_length_returns16digits() {
        String creditCard_Number ="4356353291238672";
        assertThat(creditCard_Number.length()).isEqualTo(16);
    }
    @Test
    void receipt_addMovieName_addsMovieNameToReceipt() {
        Receipt receipt = new Receipt();
        receipt.addMovieName("Dr. Strange");
        String name = receipt.getMovieName();
        assertThat(name).isEqualTo("Dr. Strange");
    }
    @Test
    void receipt_addShowDates_addsShowDatesToReceipt() {
        Receipt receipt = new Receipt();
    }
    @Test
    void receipt_addSeatInformation_addsSeatInformationToReceipt() {
        Receipt receipt = new Receipt();
        receipt.addSeatInformation(1,1,7.00,3);
        Seat seat = receipt.getSeatInformation();
        assertThat(seat).isEqualTo(new Seat(1,1,7.00,3));
        // vllt als String und nicht als seat?
    }
    @Test
    void receipt_addClientName_addsClientNameToReceipt() {
        Receipt receipt = new Receipt();
        receipt.addClientName("Pascal Stark");
        String clientName = receipt.getClientName();
        assertThat(clientName).isEqualTo("Pascal Stark");
    }
    @Test
    void receipt_getReceiptAsString_returnsReceiptAsString() {
        Receipt receipt = new Receipt();
        String receiptAsStringManuel = "Client Name: Pascal Stark";
        receipt.addClientName("Pascal Stark");
        String receiptAsString = receipt.getReceiptAsString(receipt.getClientName());
        assertThat(receiptAsStringManuel).isEqualTo(receiptAsString);
        // wie stellt man das am besten dar? momentan nur mit client name
    }
}
