package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class SeatTest {
    private int row;
    private int number;
    private double price;
    private int state;

    @BeforeEach
    void setUp() {
        row = 4;
        number = 12;
        price = 13.5;
        state = 1;
    }

    @Test
    void seat_newFreeSeat_getSateReturnsFree() {
        Seat seat = new Seat(row, number, price, state);
        String seatState = seat.getState();
        assertThat(seatState).isEqualTo("free");

    }

    @Test
    void freeSeat_setStateToReserved_getStateReturnsReserved() {
        Seat seat = new Seat(row, number, price, state);
        seat.setStateTo("reserved");
        String seatState = seat.getState();
        assertThat(seatState).isEqualTo("reserved");
    }


    @Test
    void freeSeat_setStateToBooked_getStateReturnsBooked() {
        Seat seat = new Seat(row, number, price, state);
        seat.setStateTo("booked");
        String seatState = seat.getState();
        assertThat(seatState).isEqualTo("booked");
    }

    @Test
    void freeSeat_newFreeSeat_getSelectionStateReturnUnselected() {
        Seat seat = new Seat(row, number, price, state);
        String seatSelectionState = seat.getSelectionState();
        assertThat(seatSelectionState).isEqualTo("unselected");
    }

    @Test
    void freeSeat_setToSelected_getSelectionStateReturnSelected() {
        Seat seat = new Seat(row, number, price, state);
        seat.setToSelected();
        String seatSelectionState = seat.getSelectionState();
        assertThat(seatSelectionState).isEqualTo("selected");
    }

    @Test
    void placeholderSeat_setState_throwsException() throws Exception {
        Seat seat = new Seat(row, number, price, 0);

        //when
        Throwable thrown = catchThrowable(() -> seat.setStateTo("reserved"));

        //then
        assertThat(thrown).hasMessageContaining("Cannot change the state of a placeholder seat");

    }

    @Test
    void placeholderSeat_setToSelected_throwsException() {
        Seat seat = new Seat(row, number, price, 0);

        //when
        Throwable thrown = catchThrowable(() -> seat.setToSelected());

        //then
        assertThat(thrown).hasMessageContaining("Cannot change the selection-state of a placeholder seat");
    }

    @Test
    void seat_getRow_returnsRow() {
        Seat seat = new Seat(row, number, price, 0);
        int seatRow = seat.getRow();
        assertThat(seatRow).isEqualTo(row);
    }

    @Test
    void seat_getNumber_returnsNumber() {
        Seat seat = new Seat(row, number, price, 0);
        int seatNumber = seat.getNumber();
        assertThat(seatNumber).isEqualTo(number);
    }

    @Test
    void seat_getPrice_returnsMoviePrice() {
        Seat seat = new Seat(row, number, price, 0);
        double seatPrice = seat.getPrice();
        assertThat(seatPrice).isEqualTo(price);
    }

    @Test
    void seat_getStateAsChar_state1ReturnsX() {
        Seat seat = new Seat(row, number, price, 1);
        char stateChar = seat.getStateAsChar();

        assertThat(stateChar).isEqualTo('x');
    }

    @Test
    void seat_getStateAsChar_state2ReturnsR() {
        Seat seat = new Seat(row, number, price, 2);
        char stateChar = seat.getStateAsChar();

        assertThat(stateChar).isEqualTo('r');
    }

    @Test
    void seat_getStateAsChar_state3ReturnsHashtag() {
        Seat seat = new Seat(row, number, price, 3);
        char stateChar = seat.getStateAsChar();

        assertThat(stateChar).isEqualTo('#');
    }

    @Test
    void seat_getStateAsChar_state0ReturnsSpace() {
        Seat seat = new Seat(row, number, price, 0);
        char stateChar = seat.getStateAsChar();

        assertThat(stateChar).isEqualTo(' ');
    }
}
