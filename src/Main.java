import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String filepath = "words.txt";
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                String line;
                while((line = reader.readLine()) != null ) {
                        words.add(line.trim());
                }

        }
        catch (FileNotFoundException e) {
            System.out.println("could not locate the file");
        }
        catch (IOException e){
            System.out.println("SOmething went wrong");
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        char guess ;
        int wrongGuess = 0;

        Scanner scanner = new Scanner(System.in);

        ArrayList<Character> wordState = new ArrayList<>();

        for (int i=0 ; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("*****************************");
        System.out.println("Welcome to Java Hangman Game");
        System.out.println("*****************************");
        System.out.println();

       while (wrongGuess < 6) {
           System.out.println(getHandmanArt(wrongGuess));

           System.out.print("Word : ");

           for (char c : wordState) {
               System.out.print(c + " ");
           }
           System.out.println();

           System.out.print("Enter a Guess: ");
           guess = scanner.next().toLowerCase().charAt(0);

           if (word.indexOf(guess) >= 0) {
               System.out.println("Correct Guess");

               for (int i = 0 ; i < word.length() ; i++){
                   if (word.charAt(i) == guess){
                       wordState.set(i,guess);
                   }
               }

               if (!wordState.contains('_')) {
                   System.out.println(getHandmanArt(wrongGuess));
                   System.out.println("You Won");
                   System.out.println("Correct word is: " + word);
                   System.out.println("Game is Over");
                   break;
               }
           }
           else {
               System.out.println("Wrong guess !!!");
               wrongGuess++;

               if (wrongGuess >= 6){
                   System.out.println(getHandmanArt(wrongGuess));
                   System.out.println("Game is Over");
                   System.out.println("Correct word is: " + word);
               }
           }

       }

        scanner.close();



    }

    static String getHandmanArt(int wrongGuess) {
        return switch (wrongGuess) {
            case 0 -> """
                    
                    
                    
                    """;

            case 1 -> """
                        o
                    
                    
                    """;

            case 2 -> """
                        o
                        |
                    
                    """;

            case 3 -> """
                        0
                       /|
                    
                    """;

            case 4 -> """
                        o
                       /|\\
                    
                    """;

            case 5 -> """
                        o
                       /|\\
                       /
                    """;

            case 6 -> """
                        o
                       /|\\
                       / \\
                    """;

            default -> "";
        };
    }
}