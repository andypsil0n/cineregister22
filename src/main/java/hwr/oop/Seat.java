package hwr.oop;

public class Seat {
    //private int selectionState;
    private int row;
    private int number;
    private double price;
    private int state;

    public Seat(int row, int number, double price, char stateChar) {
        this.row = row;
        this.number = number;
        this.price = price;
        this.state = convertStateToInt(stateChar);
        //this.selectionState = 0;
    }

    private int convertStateToInt(char stateChar) {
        int state = 0;
        if (stateChar == ' ') {
            state = 0;
        } else if (stateChar == 'x') {
            state = 1;
        } else if (stateChar == 'r') {
            state = 2;
        } else if (stateChar == '#') {
            state = 3;
        }
        return state;
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

    /*
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
     */

    //unselect hinzufügen?

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public char getStateAsChar() {
        char stateChar;
        stateChar = ' ';

        if (state == 0) {
            stateChar = ' ';
        } else if (state == 1) {
            stateChar = 'x';
        } else if (state == 2) {
            stateChar = 'r';
        } else if (state == 3) {
            stateChar = '#';
        }

        return stateChar;
    }
}
