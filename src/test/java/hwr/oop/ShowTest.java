package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShowTest {
    private String movieName;
    private String day;
    private String time;
    private String hallName;
    private String priceString;
    private double price;
    String[] splittedShow;
    private Hall hall;

    @BeforeEach
    void setUp() {
        movieName = "Star Wars VI";
        day = "Mo";
        time = "20:00";
        hallName = "hall1";
        price = 7.00;
        priceString = String.valueOf(price);
        splittedShow = new String[]{day, time, hallName, priceString};
    }

    @Test
    void show_getHall_returnsHall() {
        Show show = new Show(splittedShow);
        Hall newHall = show.getHall();
        Seat seat = newHall.getSeatAt(5, 5);

        assertThat(seat.getPrice()).isEqualTo(price);

    }

    @Test
    void show_getCompleteTime_returnsDayAndTimeAsString() {
        Show show = new Show(splittedShow);
        String completeTime = show.getCompleteTime();
        assertThat(completeTime).isEqualTo(day + "/" + time);
    }

    @Test
    void show_getDayTime_returnsDayTimeAsString() {
        Show show = new Show(splittedShow);
        String dayTime = show.getDayTime();
        assertThat(dayTime).isEqualTo(time);
    }
    
    @Test
    void show_bookSeats_booksAsManySeatsAsWanted() {
        Show show = new Show(splittedShow);
        int row = 4;
        int number = 5;
        double totalPrice = 0.00;

        for (int numberOfSeats = 0; numberOfSeats < 2; numberOfSeats++) {
            totalPrice += show.bookSeatAt(row, number);
            number++;
        }

        Hall showHall = show.getHall();
        Seat seat1 = showHall.getSeatAt(4, 5);
        Seat seat2 = showHall.getSeatAt(4, 6);

        String state1= seat1.getState();
        String state2 = seat2.getState();

        assertThat(state1).isEqualTo("booked");
        assertThat(state2).isEqualTo("booked");
        assertThat(totalPrice).isEqualTo(7.00*2);
    }

    @Test
    void seat_reserveSeat_reservesAsManySeatsAsWanted() {
        Show show = new Show(splittedShow);
        int row = 4;
        int number = 5;
        double totalPrice = 0.00;

        for (int numberOfSeats = 0; numberOfSeats < 2; numberOfSeats++) {
            totalPrice += show.reserveSeatAt(row, number);
            number++;
        }

        Hall showHall = show.getHall();
        Seat seat1 = showHall.getSeatAt(4, 5);
        Seat seat2 = showHall.getSeatAt(4, 6);

        String state1= seat1.getState();
        String state2 = seat2.getState();

        assertThat(state1).isEqualTo("reserved");
        assertThat(state2).isEqualTo("reserved");
        assertThat(totalPrice).isEqualTo(7.00*2);
    }
}
