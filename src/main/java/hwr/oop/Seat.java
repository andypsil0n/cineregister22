package hwr.oop;

public class Seat {
    private int row;
    private int number;
    private double price;
    private int state;

    public Seat(int row, int number, double price, char stateChar) {
        this.row = row-1;
        this.number = number-1;
        this.price = price;
        convertStateToInt(stateChar);
    }

    private void convertStateToInt(char stateChar) {
        state = 0;
        if (stateChar == ' ') {
            state = 0;
        } else if (stateChar == 'x') {
            state = 1;
        } else if (stateChar == 'r') {
            state = 2;
        } else if (stateChar == '#') {
            state = 3;
        }
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
        newState = newState.toLowerCase();
        if(state == 0) {
            throw new RuntimeException("Cannot change the state of a placeholder seat");
        }
        if(newState.equals("r")) {
            state = 2;
        } else if(newState.equals("b")) {
            state = 3;
        } else if (newState.equals("o")) {
            state = 4;
        } else  {
            throw new RuntimeException("This is a wrong input for a state");
        }

    }

    public int getRow() {
        return row+1;
    }

    public int getNumber() {
        return number+1;
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
        } else if (state == 4) {
            stateChar = 'o';
        }

        return stateChar;
    }

    public boolean checkIfSeatIsSelectable() {
        if (state == 1) {
            return true;
        } else {
            return false;
        }
    }
}
