package hwr.oop;

import java.util.*;

public class Movie {
    private final String name;
    private final ArrayList<String> times;
    private ArrayList<ArrayList<String>> sortedTimes = new ArrayList<ArrayList<String>>();

    public Movie(String name, ArrayList times) {
        this.name = name;
        this.times = times;
        sortTimes();
    }

    private void sortTimes() {
        String show;
        String[] s;

        for (int x = 0; x < times.size(); x++) {
            show = times.get(x);
            s = show.split("/");

            sortedTimes.add(x, new ArrayList<String>());
            for (int y = 0; y < 4; y++) {
                sortedTimes.get(x).add(s[y]);
            }

        }
    }

    public String getName() {
        return name;
    }


    private int getMaxYSize() {
        int maxYSize = 1;
        String currentMaxHolder = "";
        for (int x = 0; x < sortedTimes.size(); x++) {
            if (x != 0 && sortedTimes.get(x-1).get(0).equals(sortedTimes.get(x).get(0)) &!
                    sortedTimes.get(x).get(0).equals(currentMaxHolder)) {
                maxYSize += 1;
                currentMaxHolder = sortedTimes.get(x).get(0);
            } else if (currentMaxHolder.equals(sortedTimes.get(x).get(0))) {
                maxYSize += 1;
            }
        }

        return maxYSize;
    }

    private String getClockTimesAsString(int maxYSize, ArrayList<ArrayList<String>> tableRest) {
        String stringClockTimes = "";

        for (int i = 1; i <= maxYSize; i++) {
            String line = "";


            for (int x = 0; x < times.size(); x++) {
                if (x != 0 && tableRest.get(x - 1).get(0).equals(tableRest.get(x).get(0))) {
                    if (tableRest.get(x - 1).get(1).equals("")) {
                        if (x == tableRest.size() - 1) {
                            line = line + tableRest.get(x).get(1) + "\n";
                            tableRest.get(x).set(1, "     \n");
                        } else {
                            line = line + tableRest.get(x).get(1) + "  ";
                            tableRest.get(x).set(1, "     ");
                        }
                    }
                    tableRest.get(x - 1).set(1, "");
                } else {
                    if (x == tableRest.size() - 1) {
                        line = line + tableRest.get(x).get(1) + "\n";
                        tableRest.get(x).set(1, "     \n");
                    } else if (tableRest.get(x).get(1).equals("")) {
                        line = line;
                    } else {
                        line = line + tableRest.get(x).get(1) + "  ";
                        tableRest.get(x).set(1, "     ");
                    }
                }
            }
            stringClockTimes = stringClockTimes + line;

        }
        return stringClockTimes;
    }


    public String getTimes() {
        String stringDays = "";
        for (int x = 0; x < times.size(); x++) {
            if (x == 0) {
                stringDays = stringDays + sortedTimes.get(x).get(0) + "     ";
            } else if (sortedTimes.get(x-1).get(0).equals(sortedTimes.get(x).get(0))) {
                stringDays = stringDays;
            } else if (x == times.size()-1) {
                stringDays = stringDays + sortedTimes.get(x).get(0) + "\n";
            } else {
                stringDays = stringDays + sortedTimes.get(x).get(0) + "     ";
            }
        }

        int maxYSize = getMaxYSize();

        ArrayList<ArrayList<String>> tableRest = new ArrayList<ArrayList<String>>();
        for (int x = 0; x < times.size(); x++) {
            tableRest.add(new ArrayList<String>());
            for (int y = 0; y < 2; y++) {
                tableRest.get(x).add(this.sortedTimes.get(x).get(y));
            }
        }

        String stringTimes = stringDays + getClockTimesAsString(maxYSize, tableRest);

        return stringTimes;
    }


    public Hall getHallAt(String day, String time) {
        return null;
    }

    public Show getShowAt(String day, String time) {
        return null;
    }
}
