package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatTest {
    private int row;
    private int number;
    private double price;
    private String state;

    @BeforeEach
    void setUp() {
        row = 4;
        number = 12;
        price = 13.5;
        state = "free";
    }

    @Test
    void seat_newFreeSeat_getSateReturnsFree() {
        Seat seat = new Seat(row, number, price, state);
        String seatState = seat.getState();
        assertThat(seatState).isEqualTo("free");

    }

    @Test
    void freeSeat_setStateToReserved_getStateReturnsReserved() {

    }


    @Test
    void freeSeat_setStateToBooked_getStateReturnsBooked() {

    }



    @Test
    void freeSeat_setToSelected_getStateReturnsFreeAndSelected() {

    }

    @Test
    void bookedSeat_setToSelected_getStateReturnsBookedAndSelected() {

    }

    @Test
    void reservedSeat_setToSelected_getStateReturnsReservedAndSelected() {

    }



    @Test
    void placeholderSeat_SetState_throwsException() {

    }

    @Test
    void seat_getRow_returnsRow() {

    }

    @Test
    void seat_getNumber_returnsNumber() {

    }

    @Test
    void seat_getPrice_returnsMoviePrice() {

    }
}
