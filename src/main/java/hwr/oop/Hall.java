package hwr.oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hall {
    private final String hallName;
    private ArrayList<ArrayList<Seat>> hall = new ArrayList<ArrayList<Seat>>();
    private double price;

    private int maxRows = 6;
    private int maxNumbers = 15;

    public Hall(String hallName, double price) {
        this.hallName = hallName;
        this.price = price;
        try {
            buildHall();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void buildHall() throws FileNotFoundException {

        File hallFile = new File("halls\\"+hallName+".txt");
        Scanner hallFileScanner = new Scanner(hallFile);
        hallFileScanner.useDelimiter("");

        for (int row = 0; row < maxRows; row++) {
            hall.add(new ArrayList<Seat>());
            for (int number = 0; number < maxNumbers; number++) {
                char steatStateChar = hallFileScanner.next().charAt(0);
                //----
                hall.get(row).add(new Seat(row, number, price, steatStateChar));
            }
            if (row < maxRows-1) {
                hallFileScanner.nextLine();
            }
        }

    }

    public Seat getSeatAt(int row, int number) {
        return hall.get(row).get(number);
    }

    public String getHallAsString() {
        String hallAsString = "";

        for (int row = 0; row < maxRows; row++) {
            for (int number = 0; number < maxNumbers; number++) {
                Seat seat = hall.get(row).get(number);
                char state = seat.getStateAsChar();

                hallAsString = hallAsString + state;
            }
            hallAsString = hallAsString + "\n";
        }

        return hallAsString;
    }

    public int countFreeSeats() {
        int freeSeats = 0;

        for (int row = 0; row < maxRows; row++) {
            for (int number = 0; number < maxNumbers; number++) {
                Seat seat = hall.get(row).get(number);
                if (seat.getStateAsChar() == 'x') {
                    freeSeats += 1;
                }
            }
        }
        return freeSeats;
    }

    public boolean checkIfCorrectRow(int wantedRow) {
        if (wantedRow < 1 || wantedRow > maxRows) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkIfCorrectNumber(int wantedNumber) {
        if (wantedNumber < 1 || wantedNumber > maxNumbers) {
            return false;
        } else {
            return true;
        }
    }
}
