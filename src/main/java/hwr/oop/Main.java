package hwr.oop;

import java.util.*;

public class Main {

    static void main() {
        System.out.println("CineRegister22");
        System.out.println("-- starting --");
        boolean moreMovies = true;
        while (moreMovies == true) {
            buyTickets();
            System.out.println();
            System.out.println();
            System.out.println();

            /*
            Scanner continueScanner = new Scanner(System.in);
            System.out.println("Möchten Sie Tickets für eine weitere Vorstellung kaufen? (y/n)");
            System.out.print("Antwort: ");
            String moreMoviesAnswer = continueScanner.next();
            System.out.println();

            moreMoviesAnswer = moreMoviesAnswer.toLowerCase();
            moreMovies = checkIfMoreMoviesWanted(moreMoviesAnswer);

            continueScanner.close();
            */

            moreMovies = false;
        }
    }

    public static boolean checkIfMoreMoviesWanted(String moreMoviesAnswer) {
        if (moreMoviesAnswer.equals("y")) {
            return true;
        } else if (moreMoviesAnswer.equals("n")) {
            return false;
        } else {
            throw new RuntimeException("Wrong input. Please only use 'y' or 'n'");
        }
    }

    private static void buyTickets() {
        //SetUp
        MovieCollection movieCollection = new MovieCollection("movielist.txt");
        Receipt receipt = new Receipt();
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<Seat> seats = new ArrayList<>();

        System.out.println();
        System.out.println();
        System.out.println();

        //Ausgabe Filme:
        System.out.println("Herzlich Wilkommen im Ticketsystem unseres Kinos");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("Im folgenden werden unsere Filme und Vorstellungen aufgelistet.");
        System.out.println("Bitte geben sie Ihren gewünschten Filmtitel korrekt ein.");
        System.out.println();

        System.out.println(movieCollection.getMoviesAsString());

        //Eingabe Filmname:
        System.out.print("Gewünschter Film: ");
        String wantedMovie = inputScanner.nextLine();
        Movie movie = movieCollection.getMovie(wantedMovie);
        receipt.setMovieName(wantedMovie);
        System.out.println();

        //Eingabe Vorstellungstag:
        System.out.println("Sie haben den Film \"" + wantedMovie + "\" ausgewählt.");
        System.out.println("Bitte geben sie Ihren gewünschten Tag (Abkürzung) ein.");
        System.out.print("Gewünschter Tag: ");
        String wantedDay = inputScanner.nextLine();
        System.out.println();

        //Eingabe Vorstellungszeit:
        System.out.println("Bitte geben sie nun Ihre gewünschte Uhrzeit ein.");
        System.out.print("Gewünschte Zeit: ");
        String wantedTime = inputScanner.nextLine();
        System.out.println();

        Show show = movie.getShowAt(wantedDay, wantedTime);
        receipt.setShowDates(show.getCompleteTime());
        String hallName = show.getHallName();
        receipt.setHall(hallName);

        System.out.println("Nachfolgend wird Ihnen der Kinosaal und die Sitzplätze ausgegeben.");
        System.out.println();
        Hall hall = show.getHall();

        System.out.println("----LEINWAND----");
        System.out.println(hall.getHallAsString());
        System.out.println();

        int freeSeats = hall.countFreeSeats();

        //Auswahl der Sitzplätze:
        System.out.println("Wie viele Sitzplätze möchten Sie reservieren oder buchen?");
        System.out.println("(Verfügbar: " + freeSeats +")");
        System.out.print("Anzahl Sitzplätze: ");
        int numberOfSeats = inputScanner.nextInt();
        System.out.println();

        if (numberOfSeats > freeSeats) {
            throw new RuntimeException("There are not enough free seats");
        }

        for (int seatCount = 0; seatCount < numberOfSeats; seatCount++) {
            System.out.println("Bitte geben Sie Ihre gewünschte Reihe für den " + (seatCount+1) + ". Sitzplatz ein.");
            System.out.println("(von oben nach unten, 0-5)");
            System.out.print("Gewünschte Reihe: ");
            int wantedRow = inputScanner.nextInt();
            System.out.println();

            System.out.println("Bitte geben Sie Ihre gewünschte Nummer für den " + (seatCount+1) + ". Sitzplatz ein.");
            System.out.println("(von links nach rechts, 0-14)");
            System.out.print("Gewünschter Platz: ");
            int wantedNumber = inputScanner.nextInt();
            System.out.println();
            if (hall.getSeatAt(wantedRow, wantedNumber).getStateAsChar() != ' ') {
                seats.add(hall.getSeatAt(wantedRow, wantedNumber));
                receipt.addSeat(hall.getSeatAt(wantedRow, wantedNumber));
            }
            else {
                System.out.println("Dieser Sitz kann nicht ausgewählt werden. Bitte wählen Sie einen anderen Sitz");
                seatCount--;
            }

        }

        //Auswahl ob Reservierung oder Buchung:
        System.out.println("Möchten Sie diese Sitzplätze reservieren oder buchen?");
        System.out.println("Reservierung 'r': Bezahlung im Kino");
        System.out.println("Buchung 'b': Bezahlung sofort");
        System.out.println("(Geben Sie bitte nur 'r' oder 'b' ein.)");
        System.out.print("Sitzplätze: ");

        String wantedState = "r";
        wantedState = inputScanner.next();
        System.out.println();
        for (int seatCount = 0; seatCount < seats.size(); seatCount++) {
            seats.get(seatCount).setStateTo(wantedState);
        }
        inputScanner.nextLine();

        System.out.println("Bitte geben Sie Ihren vollständigen Namen ein:");
        System.out.print("Name: ");
        String clientName = inputScanner.nextLine();
        receipt.addClientName(clientName);

        //Abfragen der Bankverbindung bei Buchung:
        if (wantedState.toLowerCase().equals("b")) {
            System.out.println();
            System.out.println("Bitte geben Sie Ihre IBAN ein.");
            System.out.print("IBAN: ");
            String iban = inputScanner.nextLine();

            System.out.println("Bitte geben Sie das Ablaufdatum ein. (mm/jj)");
            System.out.print("Ablaufdatum: ");
            String dateOfExpiry = inputScanner.nextLine();

            System.out.println("Bitte geben Sie den Sicherheitscode ein.");

            System.out.print("Sicherheitscode: ");
            String safetyCode = inputScanner.nextLine();
            System.out.println();
            System.out.println();
        }
        System.out.println("Mit Eingabe durch die Entertaste kaufen / reservieren Sie ihre Tickets verbindlich\n" +
                "und bestätigen, unsere AGB und Nutzungsbedingungen gelesen zu haben und zu akzeptieren.");
        String acceptance = inputScanner.nextLine();
        System.out.println();
        System.out.println();


        System.out.println("Vielen Dank für Ihren Einkauf.\n" +
                "Nachfolgend wird ihre Rechnung ausgegeben.\n" +
                "Wir wünschen Ihnen viel Spaß bei der Vorstellung von " + wantedMovie + ".");

        System.out.println();
        System.out.println();
        System.out.println(receipt.getReceiptAsString());
        System.out.println();
        System.out.println();
        System.out.println("Aktualisierter Saal: ");
        System.out.println("----LEINWAND----");
        System.out.println(hall.getHallAsString());
        inputScanner.close();
    }

}
