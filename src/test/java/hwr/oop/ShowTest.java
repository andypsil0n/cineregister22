package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShowTest {
    private String movieName;
    private String day;
    private String time;
    private String hallName;
    private double price;
    private Hall hall;

    @BeforeEach
    void setUp() {
        movieName = "Star Wars VI";
        day = "Mo";
        time = "20:00";
        hallName = "hall1";
        price = 7.00;
        hall = new Hall(hallName, price);

    }

    @Test
    void show_getHall_returnsHall() {
        Show show = new Show(day, time, hall);


    }

    @Test
    void show_returnReceiptInformation() {

    }
}
