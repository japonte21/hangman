// program to run a simple game of Hangman with either 1 or 2 players
// (c) 2019

import java.util.Scanner;

public class Hangman {
    static Scanner s = new Scanner(System.in);
    
    /* HELPER FUNCTIONS TO MAKE SURE GAME RUNS SMOOTHLY */
    
    // periodically checks to see if user would like to quit the game
    public static void checkQuit(String input) {
        input = input.toLowerCase();
        if (input.equals("quit")) {
            System.exit(0);
        }
    }
    
    // prints the body based on number of incorrectGuesses
    public static void printBody(int incorrectGuessCount) {
        System.out.println("\n              *---*");
        System.out.println("Guesses left: | " + (6 - incorrectGuessCount) + " |");
        System.out.println("              *---*");
        
        // nothing hanging yet
        if (incorrectGuessCount == 0) {
            System.out.println("\n         ||####################");
            System.out.println("         ||                  ##");
            System.out.println("         ||                  \\/");
            for (int i = 0; i < 24; i++) {
                System.out.println("         ||");
            }
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#");
        }
        
        // head is now hanging
        if (incorrectGuessCount == 1) {
            System.out.println("\n         ||####################");
            System.out.println("         ||                  ##");
            System.out.println("         ||                  \\/");
            System.out.println("         ||                 .&&.");
            System.out.println("         ||              &&.    .&&");
            System.out.println("         ||             &/        \\&");
            System.out.println("         ||            &*          *&");
            System.out.println("         ||             &\\        /&");
            System.out.println("         ||              &&.    .&&");
            System.out.println("         ||                 .&&.");
            for (int i = 0; i < 17; i++) {
                System.out.println("         ||");
            }
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#");
        }
        
        // head and body
        if (incorrectGuessCount == 2) {
            System.out.println("\n         ||####################");
            System.out.println("         ||                  ##");
            System.out.println("         ||                  \\/");
            System.out.println("         ||                 .&&.");
            System.out.println("         ||              &&.    .&&");
            System.out.println("         ||             &/        \\&");
            System.out.println("         ||            &*          *&");
            System.out.println("         ||             &\\        /&");
            System.out.println("         ||              &&.    .&&");
            for (int i = 0; i < 12; i++) {
                System.out.println("         ||                 .&&.");
            }
            for (int i = 0; i < 6; i++) {
                System.out.println("         ||");
            }
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#");
        }
        
        // head, body and left leg
        if (incorrectGuessCount == 3) {
            System.out.println("\n         ||####################");
            System.out.println("         ||                  ##");
            System.out.println("         ||                  \\/");
            System.out.println("         ||                 .&&.");
            System.out.println("         ||              &&.    .&&");
            System.out.println("         ||             &/        \\&");
            System.out.println("         ||            &*          *&");
            System.out.println("         ||             &\\        /&");
            System.out.println("         ||              &&.    .&&");
            for (int i = 0; i < 12; i++) {
                System.out.println("         ||                 .&&.");
            }
            System.out.println("         ||                /.&&.");
            System.out.println("         ||              .&&");
            System.out.println("         ||             .&&");
            System.out.println("         ||            .&&");
            for (int i = 0; i < 3; i++) {
                System.out.println("         ||");
            }
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#");
        }
        
        // head, body and both legs
        if (incorrectGuessCount == 4) {
            System.out.println("\n         ||####################");
            System.out.println("         ||                  ##");
            System.out.println("         ||                  \\/");
            System.out.println("         ||                 .&&.");
            System.out.println("         ||              &&.    .&&");
            System.out.println("         ||             &/        \\&");
            System.out.println("         ||            &*          *&");
            System.out.println("         ||             &\\        /&");
            System.out.println("         ||              &&.    .&&");
            for (int i = 0; i < 3; i++) {
                System.out.println("         ||                 .&&.");
            }
            System.out.println("         ||                  &&");
            for (int i = 0; i < 8; i++) {
                System.out.println("         ||                 .&&.");
            }
            System.out.println("         ||                /.&&.\\");
            System.out.println("         ||              .&&    .&&");
            System.out.println("         ||             .&&      .&&");
            System.out.println("         ||            .&&        .&&");
            for (int i = 0; i < 3; i++) {
                System.out.println("         ||");
            }
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#");
        }
        
        // head, body, legs and left arm
        if (incorrectGuessCount == 5) {
            System.out.println("\n         ||####################");
            System.out.println("         ||                  ##");
            System.out.println("         ||                  \\/");
            System.out.println("         ||                 .&&.");
            System.out.println("         ||              &&.    .&&");
            System.out.println("         ||             &/        \\&");
            System.out.println("         ||            &*          *&");
            System.out.println("         ||             &\\        /&");
            System.out.println("         ||              &&.    .&&");
            for (int i = 0; i < 3; i++) {
                System.out.println("         ||                 .&&.");
            }
            System.out.println("         ||           *&&&&&&&&");
            for (int i = 0; i < 8; i++) {
                System.out.println("         ||                 .&&.");
            }
            System.out.println("         ||                /.&&.\\");
            System.out.println("         ||              .&&    .&&");
            System.out.println("         ||             .&&      .&&");
            System.out.println("         ||            .&&        .&&");
            for (int i = 0; i < 3; i++) {
                System.out.println("         ||");
            }
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#");
        }
                
        // full body hanging, game over
        if (incorrectGuessCount == 6) {
            System.out.println("\n         ||####################");
            System.out.println("         ||                  ##");
            System.out.println("         ||                  \\/");
            System.out.println("         ||                 .&&.");
            System.out.println("         ||              &&.    .&&");
            System.out.println("         ||             &/        \\&");
            System.out.println("         ||            &*          *&");
            System.out.println("         ||             &\\        /&");
            System.out.println("         ||              &&.    .&&");
            for (int i = 0; i < 3; i++) {
                System.out.println("         ||                 .&&.");
            }
            System.out.println("         ||           *&&&&&&&&&&&&&&*");
            for (int i = 0; i < 8; i++) {
                System.out.println("         ||                 .&&.");
            }
            System.out.println("         ||                /.&&.\\");
            System.out.println("         ||              .&&    .&&");
            System.out.println("         ||             .&&      .&&");
            System.out.println("         ||            .&&        .&&");
            for (int i = 0; i < 3; i++) {
                System.out.println("         ||");
            }
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#");
        }
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
    
    // playing the game on own, has to access dictionary of words
    public static void singlePlayer() {
        int incorrectGuessCount = 0;
        for (int i = 0; i < 7; i++) {
                       printBody(i);
        }
    }
    
    // playing the game with someone else, first user inputs and second user plays, then switches
    public static void twoPlayer() {
        int incorrectGuessCount = 0;
        printBody(incorrectGuessCount);
    }
    
    // main method - allows the user to play the game
    public static void main(String args[]) {
        gameIntro();
    }    
}