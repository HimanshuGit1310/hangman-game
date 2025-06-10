import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String word = "pizza";
        char guess ;

        Scanner scanner = new Scanner(System.in);

        ArrayList<Character> wordState = new ArrayList<>();

        for (int i=0 ; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("*****************************");
        System.out.println("Welcome to Java Hangman Game");
        System.out.println("*****************************");
        System.out.println();

        System.out.print("Word : ");

        for (char c : wordState) {
            System.out.print(c + " ");
        }



        scanner.close();

    }
}