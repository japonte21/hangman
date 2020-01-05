// program to run a simple game of Hangman with either 1 or 2 players
// (c) 2019 josiel m. aponte
// version: 1.1.0

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Hangman {
    static Scanner s = new Scanner(System.in);
    
    /* HELPER FUNCTIONS TO MAKE SURE GAME RUNS SMOOTHLY */
    
    // periodically checks to see if user would like to quit the game
    public static void checkQuit(String input) {
        if (input.equals("quit")) {
            System.out.println("\nGoodbye.");
            System.exit(0);
        }
    }
    
    // selects a random word from list of words for user to guess
    public static String selectWord() {
        // initialize objects
        List<String> words = new ArrayList<String>();
        Random rand = new Random();
	
        // initialize variables
        int rand_int;
        String line;
        
        // use a try catch to read in words from text file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("WordList.txt"));
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	
        // generate a random number based on size of the list to index into list and get a word
        rand_int = rand.nextInt(words.size());
        
        return words.get(rand_int);
    }
    
    // makes the initial guess array based on the length of word being guessed
    public static String[] makeGuessArray(String str) {
        String result[] = new String[str.length()];
	
        // fills array with blank values
        for (int i = 0; i < str.length(); i++) {
            // allows for multiple words to be used in answer
            if (str.charAt(i) == ' ') {
                result[i] = " ";
            }
            else {
                result[i] = "-";
            }
        }
        
        return result;
    }
    
    // visualization of an array to the user
    public static String toString(String array[]) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
	    s += array[i];
        }
        return "< " + s + " >";
    }
    
    public static void printLine() {
        System.out.println("\n--------------------------------------------------------------------------------\n");
    }
    
    public static boolean checkWin(String array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("-")) {
                return false;
            }
        }
        return true;
    }
    
    /* GAME FUNCTIONS */
    
    // starts game and asks if playing solo or with someone else
    public static void gameIntro() {
        System.out.println("Hello, and welcome to Hangman!");
        System.out.print("\nHow many people are playing? (1 player or 2 players): ");
        String input = s.next();
        checkQuit(input);
        input = input.toLowerCase(); // makes sure TWO == two
        
        // ensures the answer being given is one of the options available
        while ((!(input.equals("one") || input.equals("1"))) && (!(input.equals("two") || input.equals("2")))) {
            System.out.println("\nSorry but that is not an option, try again.");
            System.out.print("\nHow many people are playing? (1 player or 2 players): ");
            input = s.next();
            checkQuit(input);
            input = input.toLowerCase(); // makes sure TWO == two
        }
        
        // calls different function depending on who input of how many people are playing
        if (input.equals("one") || input.equals("1")) {
            singlePlayer();
        } else {
            twoPlayer();
        }
    }
    
    // playing the game on own, has to access list of words
    public static void singlePlayer() {
        String answer = selectWord().toLowerCase();
        
        // make an array based on the world selected from list
        String guess[] = makeGuessArray(answer);
	
        // guessing commeneces and each char input is checked to see if it is in the answer
        startGuessing(answer, guess, 1);
    }
    
    // playing the game with someone else, first user inputs and second user plays
    public static void twoPlayer() {
        Console console = System.console();
	
        // taking in the word from the non-guessing player
        printLine();
        // using readPassword to ensure other player can't see the input for word being guessed
        String answer = new String(console.readPassword("Non-guessing player, what word/phrase will you be selecting?: ")).toLowerCase();
        checkQuit(answer);
        
        // make an array based on the word selected from list
        String guess[] = makeGuessArray(answer);
	
        // guessing commeneces and each char input is checked to see if it is in the answer
        startGuessing(answer, guess, 2);
    }
    
    public static void startGuessing(String answer, String array[], int players) {
        boolean endGame = false;
        List<String> lettersGuessed = new ArrayList<String>();
        int incorrectGuessCount = 0;
        
        // while loop of continuous guessing until the word is solved or guess count is at 6
        while(!endGame) {
            // print the UI of hangman, guessed letters and their progress towards the answer
            Body.printBody(incorrectGuessCount);
            System.out.println("Progress towards answer: " + toString(array));
            System.out.println("Letters Guessed: " + lettersGuessed);
            
            // obtaining the guess from the user
            System.out.print("What letter will you be guessing?: ");
            String letter_guess = s.next().toLowerCase();
            checkQuit(letter_guess);
            if (letter_guess.length() > 1) {
                printLine();
                System.out.println("Please only guess a single letter at a time.");
                continue;
            }
            
            // checking if the letter has already been guessed
            if (lettersGuessed.contains(letter_guess)) {
                printLine();
                System.out.println("That letter has already been guessed. Please try again.");
                continue;
            }
            
            // adding the letter that was guessed into the total array to keep track of guesses
            lettersGuessed.add(letter_guess);
            printLine();
            
            // checking whether or not the letter is in the word
            if (answer.contains(letter_guess)) {
                System.out.println(letter_guess + " is in the word!");
		
                // change the answer array
                int index = answer.indexOf(letter_guess);
                array[index] = letter_guess;
                
                //checks if the letter appears again
                int index2 = answer.indexOf(letter_guess, index + 1);
                while (index2 != -1) {
                    array[index2] = letter_guess;
                    index2 = answer.indexOf(letter_guess, index2 + 1);
                }
            } else {
                System.out.println(letter_guess + " is not in the word...");
                incorrectGuessCount++;
            }
            
            // end of game, lost
            if (incorrectGuessCount == 6) {
                Body.printBody(incorrectGuessCount);
                System.out.println("Nice try, but the game is over! The word/phrase was '" + answer + "'. Better luck next time.");
                endGame = true;
            }
            
            // end of game, win
            if (checkWin(array)) {
                Body.printBody(incorrectGuessCount);
                System.out.println("Good job, you won! The word/phrase was '" + answer + "'. Feel free to play again!");
                endGame = true;
            }
        }
        
        // checking if the user wants to play again
        System.out.print("\nWould you like to play again? ([Y]es / [N]o) ");
        String input = s.next().toLowerCase();
        
        // checks mainly for a yes, anything else is essentially a no
        if (input.equals("yes") || input.equals("y")) {
            if (players == 1) {
                printLine();
                singlePlayer();
            }
            else {
                twoPlayer();
            }
        } else {
            System.out.println("\nGoodbye.");
        }
    }
    
    // main method - allows the user to play the game
    public static void main(String args[]) {
        gameIntro();
    }    
}
