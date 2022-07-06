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
    void show_getHallName_returnsHallName() {
        Show show = new Show(splittedShow);
        String hallName = show.getHallName();

        assertThat(hallName).isEqualTo("hall1");
    }
}
