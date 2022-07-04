package hwr.oop;

import java.util.ArrayList;
import java.util.Collection;

public class ShowBuilder {
    private ArrayList<String> times = new ArrayList<String>();
    private ArrayList<ArrayList<Show>> allMovieShows = new ArrayList<ArrayList<Show>>();

    public ShowBuilder(ArrayList<String> times) {
        this.times.addAll(times);
    }


    public Collection<? extends ArrayList<Show>> buildShows() {

        String showAsString;
        String[] splittedShow;

        for (int day = 0; day < 7; day++) {
            allMovieShows.add(new ArrayList<Show>());
        }

        for (int showNumber = 0; showNumber < times.size(); showNumber++) {
            showAsString = times.get(showNumber);
            splittedShow = showAsString.split("/");

            Show show = new Show(splittedShow);
            if (showNumber == 0) {
                allMovieShows.get(0).add(show);

            } else if (splittedShow[0].equals("Mo")) {
                allMovieShows.get(0).add(show);
            } else if (splittedShow[0].equals("Di")) {
                allMovieShows.get(1).add(show);
            } else if (splittedShow[0].equals("Mi")) {
                allMovieShows.get(2).add(show);
            } else if (splittedShow[0].equals("Do")) {
                allMovieShows.get(3).add(show);
            } else if (splittedShow[0].equals("Fr")) {
                allMovieShows.get(4).add(show);
            } else if (splittedShow[0].equals("Sa")) {
                allMovieShows.get(5).add(show);
            } else if (splittedShow[0].equals("So")) {
                allMovieShows.get(6).add(show);
            }
        }
        return allMovieShows;
    }
}
