// program to run a simple game of Hangman with either 1 or 2 players
// (c) 2019

public class Body {

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
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#\n");
        }

        // head is now hanging
        else if (incorrectGuessCount == 1) {
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
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#\n");
        }

        // head and body
        else if (incorrectGuessCount == 2) {
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
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#\n");
        }

        // head, body and left leg
        else if (incorrectGuessCount == 3) {
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
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#\n");
        }

        // head, body and both legs
        else if (incorrectGuessCount == 4) {
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
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#\n");
        }

        // head, body, legs and left arm
        else if (incorrectGuessCount == 5) {
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
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#\n");
        }

        // full body hanging, game over
        else if (incorrectGuessCount == 6) {
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
            System.out.println("#|||||||||||||||||||||||||||||||||||||||||#\n");
        }

        // in the case anything other than 6 is ever passed as a parameter
        else {
            System.out.println("Invalid input");
        }
    }

}
