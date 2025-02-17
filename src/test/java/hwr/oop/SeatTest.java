package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class SeatTest {
    private int row;
    private int number;
    private double price;
    private char state;

    @BeforeEach
    void setUp() {
        row = 4;
        number = 12;
        price = 13.5;
        state = 'x'; //state: "free"
    }

    @Test
    void seat_newFreeSeat_getSateReturnsFree() {
        Seat seat = new Seat(row, number, price, state);
        String seatState = seat.getState();
        assertThat(seatState).isEqualTo("free");

    }

    @Test
    void Seat_checkIfSeatIsSelectable_freeSeatReturnsTrue() throws Exception {
        Seat seat = new Seat(row, number, price, 'x');
        boolean isSeatSelectable = seat.checkIfSeatIsSelectable();
        assertThat(isSeatSelectable).isTrue();

    }

    @Test
    void Seat_checkIfSeatIsSelectable_reservedSeatReturnsFalse() throws Exception {
        Seat seat = new Seat(row, number, price, 'r');
        boolean isSeatSelectable = seat.checkIfSeatIsSelectable();
        assertThat(isSeatSelectable).isFalse();

    }

    @Test
    void freeSeat_setStateToReserved_getStateReturnsReserved() {
        Seat seat = new Seat(row, number, price, state);
        seat.setStateTo("R");
        String seatState = seat.getState();
        assertThat(seatState).isEqualTo("reserved");
    }


    @Test
    void freeSeat_setStateToBooked_getStateReturnsBooked() {
        Seat seat = new Seat(row, number, price, state);
        seat.setStateTo("b");
        String seatState = seat.getState();
        assertThat(seatState).isEqualTo("booked");
    }

    @Test
    void freeSeat_setStateToSelected_getStateAsCharReturnsO() {
        Seat seat = new Seat(row, number, price, state);
        seat.setStateTo("o");
        char seatState = seat.getStateAsChar();
        assertThat(seatState).isEqualTo('o');
    }

    @Test
    void placeholderSeat_setState_throwsException() throws Exception {
        Seat seat = new Seat(row, number, price, ' ');

        //when
        Throwable thrown = catchThrowable(() -> seat.setStateTo("r"));

        //then
        assertThat(thrown).hasMessageContaining("Cannot change the state of a placeholder seat");

    }

    @Test
    void Seat_setState_wrongStateThrowsException() throws Exception {
        Seat seat = new Seat(row, number, price, 'x');

        //when
        Throwable thrown = catchThrowable(() -> seat.setStateTo("l"));

        //then
        assertThat(thrown).hasMessageContaining("This is a wrong input for a state");

    }

    @Test
    void seat_getRow_returnsRow() {
        Seat seat = new Seat(row, number, price, ' ');
        int seatRow = seat.getRow();
        assertThat(seatRow).isEqualTo(row);
    }

    @Test
    void seat_getNumber_returnsNumber() {
        Seat seat = new Seat(row, number, price, ' ');
        int seatNumber = seat.getNumber();
        assertThat(seatNumber).isEqualTo(number);
    }

    @Test
    void seat_getPrice_returnsMoviePrice() {
        Seat seat = new Seat(row, number, price, ' ');
        double seatPrice = seat.getPrice();
        assertThat(seatPrice).isEqualTo(price);
    }

    @Test
    void seat_getStateAsChar_state1ReturnsX() {
        Seat seat = new Seat(row, number, price, 'x');
        char stateChar = seat.getStateAsChar();

        assertThat(stateChar).isEqualTo('x');
    }

    @Test
    void seat_getStateAsChar_state2ReturnsR() {
        Seat seat = new Seat(row, number, price, 'r');
        char stateChar = seat.getStateAsChar();

        assertThat(stateChar).isEqualTo('r');
    }

    @Test
    void seat_getStateAsChar_state3ReturnsHashtag() {
        Seat seat = new Seat(row, number, price, '#');
        char stateChar = seat.getStateAsChar();

        assertThat(stateChar).isEqualTo('#');
    }

    @Test
    void seat_getStateAsChar_state0ReturnsSpace() {
        Seat seat = new Seat(row, number, price, ' ');
        char stateChar = seat.getStateAsChar();

        assertThat(stateChar).isEqualTo(' ');
    }
}
