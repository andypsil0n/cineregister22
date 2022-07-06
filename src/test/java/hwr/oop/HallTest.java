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

    @Test
    void hall_checkIfCorrectRow_0ReturnsFalse() {
        Hall hall = new Hall(hallName, price);
        assertThat(hall.checkIfCorrectRow(0)).isFalse();
    }

    @Test
    void hall_checkIfCorrectRow_7ReturnsFalse() {
        Hall hall = new Hall(hallName, price);
        assertThat(hall.checkIfCorrectRow(7)).isFalse();
    }

    @Test
    void hall_checkIfCorrectRow_3ReturnsTrue() {
        Hall hall = new Hall(hallName, price);
        assertThat(hall.checkIfCorrectRow(3)).isTrue();
    }


    @Test
    void hall_checkIfCorrectNumber_0ReturnsFalse() {
        Hall hall = new Hall(hallName, price);
        assertThat(hall.checkIfCorrectNumber(0)).isFalse();
    }

    @Test
    void hall_checkIfCorrectNumber_16ReturnsFalse() {
        Hall hall = new Hall(hallName, price);
        assertThat(hall.checkIfCorrectNumber(16)).isFalse();
    }

    @Test
    void hall_checkIfCorrectNumber_3ReturnsTrue() {
        Hall hall = new Hall(hallName, price);
        assertThat(hall.checkIfCorrectNumber(3)).isTrue();
    }
}
