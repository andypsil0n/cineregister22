package hwr.oop;

import java.util.*;

public class Main {
    private static Scanner inputScanner = new Scanner(System.in);
    private static MovieCollection movieCollection;

    static void main() {
        System.out.println("CineRegister22");
        System.out.println("-- starting --");
        movieCollection = new MovieCollection("movielist.txt");
        int run = 1;


        boolean moreMovies = true;
        while (moreMovies == true) {
            buyTickets(run);
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println("Möchten Sie weitere Tickets bei uns buchen? (y/n)");
            System.out.print("Antwort: ");
            String moreMoviesAnswer = inputScanner.nextLine();
            System.out.println();
            moreMovies = checkIfMoreMoviesWanted(moreMoviesAnswer);

            run++;
        }
        inputScanner.close();
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

    private static void buyTickets(int run) {
        //SetUp
        Receipt receipt = new Receipt(run);
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
        receipt.setMovieName(movie.getName());
        System.out.println();

        //Eingabe Vorstellungstag:
        System.out.println("Sie haben den Film \"" + movie.getName() + "\" ausgewählt.");
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

        //Auswahl der Anzahl der Sitzplätze:
        boolean correctNumberOfSeats = false;
        int numberOfSeats = 1;
        while (correctNumberOfSeats == false) {
            System.out.println("Wie viele Sitzplätze möchten Sie reservieren oder buchen?");
            System.out.println("(Verfügbar: " + freeSeats + ")");
            System.out.print("Anzahl Sitzplätze: ");
            numberOfSeats = inputScanner.nextInt();
            System.out.println();

            if (numberOfSeats > freeSeats) {
                System.out.println("!!! Sie können nicht mehr Sitze auswählen, als verfügbar sind.");
                System.out.println();
            } else if (numberOfSeats == 0) {
                System.out.println("!!! Sie müssen mindestens einen Sitzplatz auswählen");
                System.out.println();
            } else {
                correctNumberOfSeats = true;
            }
        }

        System.out.println("------------------------------------------------");
        printHall(hall);

        //Auswahl der Sitzplätze
        for (int seatCount = 0; seatCount < numberOfSeats; seatCount++) {

            boolean correctRows = false;
            int wantedRow = 0;
            while (!hall.checkIfCorrectRow(wantedRow)) {
                System.out.println("Bitte geben Sie Ihre gewünschte Reihe für den " + (seatCount + 1) + ". Sitzplatz ein.");
                System.out.println("(von oben nach unten, 1-6)");
                System.out.print("Gewünschte Reihe: ");

                wantedRow = inputScanner.nextInt();
                System.out.println();
            }

            int wantedNumber = 0;
            while (!hall.checkIfCorrectNumber(wantedNumber)) {
                System.out.println("Bitte geben Sie Ihre gewünschte Nummer für den " + (seatCount + 1) + ". Sitzplatz ein.");
                System.out.println("(von links nach rechts, 1-15)");
                System.out.print("Gewünschter Platz: ");
                wantedNumber = inputScanner.nextInt();
                System.out.println();
            }

            if (hall.getSeatAt(wantedRow, wantedNumber).checkIfSeatIsSelectable() == true) {
                Seat seat = hall.getSeatAt(wantedRow, wantedNumber);
                seats.add(seat);
                receipt.addSeat(seat);
                seat.setStateTo("o");
                System.out.println("------------------------------------------------");
                printHall(hall);
            }
            else {
                System.out.println("------------------------------------------------");
                printHall(hall);
                System.out.println("!!! Dieser Sitz kann nicht ausgewählt werden.\n" +
                        "Bitte wählen Sie einen anderen Sitzplatz.");
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
        //nur Dummy
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
                "Sie finden diese außerdem in ihrem Download-Ordner.\n" +
                "Wir wünschen Ihnen viel Spaß bei der Vorstellung von " + movie.getName() + ".");

        System.out.println();
        System.out.println();
        System.out.println(receipt.getReceiptAsString());
        System.out.println();
        System.out.println();
        System.out.println("Aktualisierter Saal: ");
        System.out.println("----LEINWAND----");
        System.out.println(hall.getHallAsString());
        receipt.saveReceipt();
    }

    private static void printHall(Hall hall) {
        System.out.println();
        System.out.println("----LEINWAND----");
        System.out.println(hall.getHallAsString());
        System.out.println();
    }

}
