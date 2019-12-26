# Hangman
```Version 1.0.0```

This is a group of Java files that simulates a game of Hangman. The game could be played with either one or two players, with the program providing a word in a single player session and someone else providing a word in a two-player session.

## Getting Started

In order to play:
- Clone this repository to your local machine using https://github.com/japonte21/hangman.git
- Run the program with these commands
```
-> javac Hangman.java 
-> java Hangman
```

This will allow you to have a copy of the project on your local machine available to play when desired.

### Prerequisites

Ensure that you have a version of Java compatiable with your local machine. To check this, run the command ```java -version``` in terminal. If you don't have Java, download the latest version compatiable with you machine on the [Java SE website](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html).

## Versions

Latest Version: ```1.0.0```

- ```1.0.0```: First complete running version of the game. Comes with the following features:
  - Single Player version sourcing words from ```WordList.txt``` 
  - Two Player version allowing for one player to provide a word and another player to guess
  - Keeps track of letters guessed by the user and amount of guesses left
