package hwr.oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MovieBuilder {
    private File movielistSource;
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public MovieBuilder(String fileName) {
        movielistSource = new File("movielists\\" + fileName);
    }

    public ArrayList<Movie> buildMovies() {
        try {
            scanAndBuildMovies();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return movies;
    }

    private void scanAndBuildMovies() throws FileNotFoundException {
        int numberOfMovies = getNumberOfMovies();
        Scanner movieScanner = new Scanner(movielistSource);

        for (int movieNumber = 0; movieNumber < numberOfMovies; movieNumber++) {
            ArrayList<String> times = new ArrayList<String>();
            String name = movieScanner.nextLine();

            String allTimes = movieScanner.nextLine();
            times = new ArrayList<>(Arrays.asList(allTimes.split(",")));

            movies.add(new Movie(name, times));
        }
    }

    private int getNumberOfMovies() throws FileNotFoundException {
        Scanner movieScanner = new Scanner(movielistSource);
        int numberOfMovies = 0;
        while (movieScanner.hasNextLine()) {
            numberOfMovies++;
            movieScanner.nextLine();
        }
        movieScanner.close();
        return numberOfMovies / 2;
    }


}
