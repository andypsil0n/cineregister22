package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ShowBuilderTest {
    private ArrayList<String> times;
    private ArrayList<ArrayList<Show>> allMovieShows = new ArrayList<ArrayList<Show>>();

    @BeforeEach
    void setUp() {
        times = new ArrayList<>(Arrays.asList ( "Mo/17:00/hall1/7.00","Mo/20:00/hall1/7.00","Di/17:00/hall1/8.00",
                "Mi/14:00/hall1/7.50", "Do/14:00/hall1/7.00","Fr/17:00/hall1/7.00","Sa/14:00/hall1/7.00",
                "So/15:00/hall1/7.00"));
    }

    @Test
    void show_buildShows_buildsShowsIntoArrayList() {
        ShowBuilder showBuilder = new ShowBuilder(times);
        allMovieShows.addAll(showBuilder.buildShows());
        Show show = allMovieShows.get(1).get(0);
        assertThat(show.getCompleteTime()).isEqualTo("Di/17:00");

    }

}
