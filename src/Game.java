import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private int attempts;
    private String word;
    private ArrayList<String> guesses;
    private boolean gameOver;
    private boolean win;

    public static final String BG_RESET = "\u001b[0m";
    public static final String BG_GREEN = "\u001b[42m";
    public static final String BG_YELLOW = "\u001b[43m";

    public Game() {
        word = "SNAIL";
        guesses = new ArrayList<String>();
        attempts = 0; 
        gameOver = false;
        win = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void makeGuess(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 5-letter word: ");
        String guess = input.nextLine().toUpperCase();

        while (guess.length() != 5) {
            System.out.print("Enter a 5-letter word: ");
            guess = input.nextLine().toUpperCase();
        }

        checkGuess(guess);
    }

    public void checkGuess(String guess) {
        String[] split = word.split("");
        ArrayList<String> characters = new ArrayList<String>(Arrays.asList(split)); 

        String coloredGuess = "";
        ArrayList<Integer> correct = new ArrayList<Integer>();
        String letter;
        
        //Checks for any correct spots first - this will prevent issues with yellow squres
        for (int i = 0; i < 5; i++) {
            letter = Character.toString(guess.charAt(i));
            
            if (guess.charAt(i) == word.charAt(i)) {
                correct.add(i);
                characters.remove(letter);
            }
        }

        for (int i = 0; i < 5; i++) {
            letter = Character.toString(guess.charAt(i));

            if (correct.contains(i)) {
                coloredGuess += BG_GREEN + guess.charAt(i) + BG_RESET + " "; 
            }
            else if (characters.contains(letter)) {
                coloredGuess += BG_YELLOW + guess.charAt(i) + BG_RESET + " ";
                characters.remove(letter); 
            }
            else {
                coloredGuess += guess.charAt(i) + " ";
            }
        }
        guesses.add(coloredGuess);
        attempts += 1;

        if (correct.size() == 5) {
            gameOver = true;
            win = true;
        }
        else if (attempts == 6) {
            gameOver = true;
            win = false; 
        }
    }

    public void printBoard() {
        System.out.println("");
        for (String guess : guesses) {
            System.out.println(guess);
        }

        for (int i = 6 - attempts; i > 0; i--) {
            System.out.println("_ _ _ _ _");
        }

    }

    public void isWinner() {
        if (gameOver && win) {
            System.out.println("\nWINNER!!");
            System.out.println("The word was: " + word);
        }
        else {
            System.out.println("\nLOSER :(");
            System.out.println("The word was: " + word);
        }
    }

}
