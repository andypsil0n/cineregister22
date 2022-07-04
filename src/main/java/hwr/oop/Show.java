package hwr.oop;

public class Show {
    private String day;
    private String time;
    private Hall hall;

    public Show(String[] splittedShow) {
        this.day = splittedShow[0];
        this.time = splittedShow[1];
        String hallName = splittedShow[2];
        double price = Double.parseDouble(splittedShow[3]);
        hall = new Hall(hallName, price);
    }

    public Hall getHall() {
        return hall;
    }

    public double bookSeatAt(int row, int number) {
        Seat seat = hall.getSeatAt(row,number);
        seat.setStateTo("booked");
        return seat.getPrice();
    }

    public double reserveSeatAt(int row, int number) {
        Seat seat = hall.getSeatAt(row, number);
        seat.setStateTo("reserved");
        return seat.getPrice();
    }

    public String getCompleteTime() {
        String dayAndTime = "";
        dayAndTime = day + "/" + time;
        return dayAndTime;
    }

    public String getDayTime() {
        return time;
    }
}
