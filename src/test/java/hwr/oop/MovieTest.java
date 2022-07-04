package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieTest {
    String name;
    ArrayList<String> times;
    String movieTimesAsString;

    @BeforeEach
    void setUp() {
        name = "Star Wars VI";
        times = new ArrayList<>(Arrays.asList ( "Mo/17:00/hall1/7.00","Mo/20:00/hall1/7.00","Di/17:00/hall1/8.00",
                "Mi/14:00/hall1/7.50", "Do/14:00/hall1/7.00","Fr/17:00/hall1/7.00","Sa/14:00/hall1/7.00",
                "So/15:00/hall1/7.00"));

        movieTimesAsString ="Mo     Di     Mi     Do     Fr     Sa     So\n" +
                            "17:00  17:00  14:00  14:00  17:00  14:00  15:00\n" +
                            "20:00  ";
    }

    @Test
    void movie_getName_returnsName() {
        Movie movie = new Movie(name, times);
        String movieName = movie.getName();
        assertThat(movieName).isEqualTo(name);

    }

    @Test
    void movie_getTimes_returnsTimesAsString() {
        Movie movie = new Movie(name, times);
        String movieTimes = movie.getTimesAsString();
        assertThat(movieTimes).isEqualTo(movieTimesAsString);
    }

    @Test
    void movie_getShowAt_returnsWantedShow() {
        Movie movie = new Movie(name, times);
        Show show = movie.getShowAt("Mo", "20:00");
        String newTime = show.getCompleteTime();

        assertThat(newTime).isEqualTo("Mo/20:00");
    }

}
