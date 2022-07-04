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
}
