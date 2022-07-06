package hwr.oop;

import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public MovieCollection(String fileName) {
        getMovies(fileName);

    }

    private void getMovies(String fileName) {
        MovieBuilder movieBuilder = new MovieBuilder(fileName);
        movies.addAll(movieBuilder.buildMovies());
    }

    public Movie getMovie(String movieName) {
        boolean correctMovie = false;

        int wantedMovieNumber = 0;
        for (int movieNumber = 0; movieNumber < movies.size(); movieNumber++) {
            Movie movie = movies.get(movieNumber);
            if (movie.getName().equals(movieName)) {
                correctMovie = true;
                wantedMovieNumber = movieNumber;
            }
        }

        if (correctMovie == false) {
            throw new RuntimeException("Our cinema has no shows for this movie");
        }

        return movies.get(wantedMovieNumber);
    }

    public String getMoviesAsString() {
        String moviesAsString = "";

        for (int movieCount = 0; movieCount < movies.size(); movieCount++) {
            Movie movie = movies.get(movieCount);
            moviesAsString = moviesAsString + movie.getName() + "\n";
            moviesAsString = moviesAsString + movie.getTimesAsString() + "\n";
        }

        return moviesAsString;
    }
}
