package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HallTest {
    String hallName;
    int seatRow;
    int seatNumber;
    double price;
    String hallAsString;

    @BeforeEach
    void setUp() {
        hallName = "hall1";
        seatRow = 3;
        seatNumber= 10;
        price = 7.00;

        hallAsString ="  xxxxxxxxxxx  \n" +
                      "xxxxxxxxxxxxxxx\n" +
                      "xxxxxxxxxxxxxxx\n" +
                      "xxxxxxxxxxxxxxx\n" +
                      "xxxxxxxxxxxxxxx\n" +
                      "xxxxxxxxxxxxxxx\n";
    }

    @Test
    void hall_getSeatAt_returnsWantedSeat() {
        Hall hall = new Hall(hallName, price);
        Seat seat = hall.getSeatAt(seatRow, seatNumber);

        int newRow = seat.getRow();
        int newNumber = seat.getNumber();

        boolean equalRows = seatRow == newRow;
        boolean equalNumbers = seatNumber == newNumber;

        assertThat(equalRows && equalNumbers).isTrue();
    }

    @Test
    void hall_getHallAsString_returnsHallAsFormattedString() {
        Hall hall = new Hall(hallName, price);
        String newHallAsString = hall.getHallAsString();

        assertThat(newHallAsString).isEqualTo(hallAsString);
    }

    @Test
    void hall_countFreeSeats_returnsNumberOfFreeSeats() {
        Hall hall = new Hall(hallName, price);
        int freeSeats = hall.countFreeSeats();

        assertThat(freeSeats).isEqualTo(86);
    }

}
