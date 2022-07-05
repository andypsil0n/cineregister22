package hwr.oop;

import javax.xml.transform.Result;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    String selectedMovie;

    public String selectMovie() {
        System.out.println();// Filmauswahl
        System.out.println("Für welchen Film wollen Sie Tickets kaufen?");
        selectedMovie = scan.next();
        return  selectedMovie;
    }
}