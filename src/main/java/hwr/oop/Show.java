package hwr.oop;

import java.util.Locale;

public class Show {
    private String day;
    private String time;
    private String hallName;
    private Hall hall;

    public Show(String[] splittedShow) {
        this.day = splittedShow[0];
        this.time = splittedShow[1];
        this.hallName = splittedShow[2];
        double price = Double.parseDouble(splittedShow[3]);
        hall = new Hall(hallName, price);
    }

    public Hall getHall() {
        return hall;
    }

    public String getCompleteTime() {
        String dayAndTime = "";
        dayAndTime = day + "/" + time;
        return dayAndTime;
    }

    public String getDayTime() {
        return time;
    }

    public String getHallName() {
        return hallName;
    }
}
