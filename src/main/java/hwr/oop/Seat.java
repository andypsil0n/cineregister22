package hwr.oop;

public class Seat {
    private int selectionState;
    private int row;
    private int number;
    private double price;
    private int state;

    public Seat(int row, int number, double price, int state) {
        this.row = row;
        this.number = number;
        this.price = price;
        this.state = state;
        this.selectionState = 0;
    }

    public String getState() {
        if(state == 2) {
            return "reserved";
        }
        else if(state == 3){
            return "booked";
        }
        return "free";
    }

    public void setStateTo(String newState) {
        if(state == 0) {
            throw new RuntimeException("Cannot change the state of a placeholder seat");
        }
        if(newState == "reserved") {
            state = 2;
        } else if(newState == "booked") {
            state = 3;
        }

    }

    public void setStateToBooked() {
        state = 3;
    }

    public String getSelectionState() {
        if(selectionState == 1){
            return "selected";
        }
        return "unselected";
    }

    public void setToSelected() {
        if(state == 0) {
            throw new RuntimeException("Cannot change the selection-state of a placeholder seat");
        }
        selectionState = 1;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }
}
