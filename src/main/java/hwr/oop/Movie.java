package hwr.oop;

import java.util.*;

public class Movie {
    private final String name;
    private final ArrayList<String> times;
    private ArrayList<ArrayList<Show>> allMovieShows = new ArrayList<ArrayList<Show>>();

    public Movie(String name, ArrayList times) {
        this.name = name;
        this.times = times;
        //sortTimes(); -- raus
        buildShows();
    }

    private void buildShows() {
        ShowBuilder showBuilder = new ShowBuilder(times);
        allMovieShows.addAll(showBuilder.buildShows());
    }

    public String getName() {
        return name;
    }


    public String getTimesAsString() {
        String daysAsString = getDaysAsString();
        String dayTimesAsString = getDayTimesAsString();
        return daysAsString + dayTimesAsString;
    }

    private String getDaysAsString() {
        String daysAsString = "Mo     Di     Mi     Do     Fr     Sa     So\n";
        return daysAsString;
    }

    private String getDayTimesAsString() {
        String dayTimesAsString = "";
        String line = "";

        int maxShowsPerDay = getMaxShowsPerDay();
        for (int showLine = 0; showLine < maxShowsPerDay; showLine++) {
            for (int day = 0; day < 7; day++) {
                if ( showLine >= 0 && showLine <= (allMovieShows.get(day).size() - 1)) {
                    if (day == 6) {
                        Show show = allMovieShows.get(day).get(showLine);
                        line = line + show.getDayTime() + "\n";
                    } else {
                        Show show = allMovieShows.get(day).get(showLine);
                        line = line + show.getDayTime() + "  ";
                    }
                }
            }
            dayTimesAsString = dayTimesAsString + line;
            line = "";
        }

        return dayTimesAsString;
    }

    private int getMaxShowsPerDay() {
        int maxShowsPerDay = 0;
        for (int day = 0; day < 7; day++) {
            if (day == 0) {
                maxShowsPerDay = allMovieShows.get(day).size();
            } else {
                if (allMovieShows.get(day).size() > maxShowsPerDay) {
                    maxShowsPerDay = allMovieShows.get(day).size();
                }
            }
        }
        return maxShowsPerDay;
    }



    public Show getShowAt(String dayString, String timeString) {
        int day;
        int time;

        day = checkWhatDay(dayString);
        time = checkWhatTime(day, timeString);

        Show show = allMovieShows.get(day).get(time);
        return show;

    }

    private int checkWhatDay(String dayString) {
        int day = 0;
        if (dayString.equals("Mo")) {
            day = 0;
        } else if (dayString.equals("Di")) {
            day = 1;
        } else if (dayString.equals("Mi")) {
            day = 2;
        } else if (dayString.equals("Do")) {
            day = 3;
        } else if (dayString.equals("Fr")) {
            day = 4;
        } else if (dayString.equals("Sa")) {
            day = 5;
        } else if (dayString.equals("So")) {
            day = 6;
        }
        return day;
    }

    private int checkWhatTime(int day, String timeString) {
        boolean correctSelectedTime = false;
        int wantedTime = 0;
        int showNumber = 0;

        while (correctSelectedTime == false) {
            Show selectedShow = allMovieShows.get(day).get(showNumber);
            String selectedTimeAsString = selectedShow.getDayTime();
            if (selectedTimeAsString.equals(timeString)) {
                wantedTime = showNumber;
                correctSelectedTime = true;
            }
            showNumber++;
        }
        return wantedTime;
    }

}
