package hwr.oop;

public class Show {
    private String day;
    private String time;
    private Hall hall;

    public Show(String day, String time, String hallName, double price) {
        this.day = day;
        this.time = time;
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

    public String getTime() {
        String dayAndTime = "";
        dayAndTime = day + "/" + time;
        return time;
    }
}
