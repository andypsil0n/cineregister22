package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class MovieCollectionTest {
    private String fileName;
    private String movieName;

    @BeforeEach
    void setUp() {
        fileName = "test_movielist.txt";
        movieName = "Doctor Strange";
    }

    @Test
    void movieCollection_getMovie_returnsWantedMovie() {
        MovieCollection movies = new MovieCollection(fileName);
        Movie movie = movies.getMovie(movieName);

        assertThat(movie.getName()).isEqualTo(movieName);
    }

    @Test
    void movieCollection_getMovie_wrongMovieNameThrowsException() {
        MovieCollection movies = new MovieCollection(fileName);

        //when
        Throwable thrown = catchThrowable(() -> movies.getMovie("Star Wars"));

        //then
        assertThat(thrown).hasMessageContaining("Our cinema has no shows for this movie");

    }

    @Test
    void movieCollection_getMoviesAsString_returnsMoviesAsString() {
        MovieCollection movies = new MovieCollection(fileName);
        String moviesAsString = movies.getMoviesAsString();

        String wantedMoviesAsString = "Doctor Strange\n" +
                                      "Mo     Di     Mi     Do     Fr     Sa     So\n" +
                                      "17:00  17:00  16:00  16:00  17:00  17:00  15:00\n" +
                                      "20:00         19:00  19:00  20:00  20:00       \n" +
                                      "              22:00         23:00              \n" +
                                      "\n" +
                                      "Winnie Pooh\n" +
                                      "Mo     Di     Mi     Do     Fr     Sa     So\n" +
                                      "17:00  17:00  14:00  14:00  17:00  14:00  15:00\n" +
                                      "\n";

        assertThat(moviesAsString).isEqualTo(wantedMoviesAsString);
    }

}
