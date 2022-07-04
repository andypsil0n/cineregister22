package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

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
    void movie_getShowAt_moReturnsWantedShowOnMonday() {
        Movie movie = new Movie(name, times);
        Show show = movie.getShowAt("Mo", "20:00");
        String newTime = show.getCompleteTime();

        assertThat(newTime).isEqualTo("Mo/20:00");
    }
    @Test
    void movie_getShowAt_diReturnsWantedShowOnTuesday() {
        Movie movie = new Movie(name, times);
        Show show = movie.getShowAt("Di", "17:00");
        String newTime = show.getCompleteTime();

        assertThat(newTime).isEqualTo("Di/17:00");
    }

    @Test
    void movie_getShowAt_miReturnsWantedShowOnWednesday() {
        Movie movie = new Movie(name, times);
        Show show = movie.getShowAt("Mi", "14:00");
        String newTime = show.getCompleteTime();

        assertThat(newTime).isEqualTo("Mi/14:00");
    }

    @Test
    void movie_getShowAt_doReturnsWantedShowOnThursday() {
        Movie movie = new Movie(name, times);
        Show show = movie.getShowAt("Do", "14:00");
        String newTime = show.getCompleteTime();

        assertThat(newTime).isEqualTo("Do/14:00");
    }

    @Test
    void movie_getShowAt_frReturnsWantedShowOnFriday() {
        Movie movie = new Movie(name, times);
        Show show = movie.getShowAt("Fr", "17:00");
        String newTime = show.getCompleteTime();

        assertThat(newTime).isEqualTo("Fr/17:00");
    }

    @Test
    void movie_getShowAt_saReturnsWantedShowOnSaturday() {
        Movie movie = new Movie(name, times);
        Show show = movie.getShowAt("Sa", "14:00");
        String newTime = show.getCompleteTime();

        assertThat(newTime).isEqualTo("Sa/14:00");
    }

    @Test
    void movie_getShowAt_soReturnsWantedShowOnSunday() {
        Movie movie = new Movie(name, times);
        Show show = movie.getShowAt("So", "15:00");
        String newTime = show.getCompleteTime();

        assertThat(newTime).isEqualTo("So/15:00");
    }

    @Test
    void movie_getShowAt_wrongShowDayThrowsException() {
        Movie movie = new Movie(name, times);
        //when
        Throwable thrown = catchThrowable(() -> movie.getShowAt("De", "20:00"));

        //then
        assertThat(thrown).hasMessageContaining("The entered day does not exist");


    }

    @Test
    void movie_getShowAt_wrongShowTimeThrowsException() {
        Movie movie = new Movie(name, times);
        //when
        Throwable thrown = catchThrowable(() -> movie.getShowAt("Mo", "25:00"));

        //then
        assertThat(thrown).hasMessageContaining("No show exists at the entered time");


    }

}
