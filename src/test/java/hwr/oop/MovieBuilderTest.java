package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class MovieBuilderTest {
ArrayList<Movie> movies = new ArrayList<Movie>();
    @BeforeEach
    void setUp() {

    }

    @Test
    void movieBuilder_buildMovies_returnsMoviesInsideAnArrayList() {
        MovieBuilder movieBuilder = new MovieBuilder("test_movielist.txt");
        movies.addAll(movieBuilder.buildMovies());

        Movie movie = movies.get(0);
        String movieName = movie.getName();

        assertThat(movieName).isEqualTo("Doctor Strange");

    }
}
