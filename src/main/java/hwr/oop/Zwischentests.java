package hwr.oop;
import java.io.*;
import java.util.Scanner;

public class Zwischentests {
    public static void main(String[] args) throws FileNotFoundException {

        File getMovies = new File("movielist.txt");
        Scanner sc = new Scanner(getMovies);
        sc.useDelimiter("#");
        while (sc.hasNext())
        {
            System.out.print(sc.next() + " | ");
        }
        sc.close();
    }    
}
