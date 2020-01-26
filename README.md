# Hangman
Latest Version: `1.2.1`

This is a group of Java files that simulates a game of [Hangman](https://en.wikipedia.org/wiki/Hangman_(game)). The game 
could be played with either one or two players, with the program providing a word in a single player session and someone 
else providing a word in a two-player session.

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

Ensure that you have a version of Java compatible with your local machine. To check this, run the command `java -version` 
in terminal. If you don't have Java, download the latest version compatible with you machine on the
[Java SE Development Kit website](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

### Note
Part of the user-experience for the two-player mode is for one player to be able to input a word into the program without 
the other being able to see it. However, this program uses the Console class in Java, which returns `null` when used from 
an IDE, such as Eclipse or IDE. This is the same case for the hint portion of the program in the two-player mode. Thus, 
this program performs best when used directly from the command line. 

## Versions

### `1.2.1` – 2020-01-26
#### Changed
  - Made methods in the program private rather than public
  - Allowed the program to be ran using an instance of the class, rather than statically
  
#### Fixed
  - New hints for new games when continuing to play in one session now show up instead of the old hints provided from
  previous game play

### `1.2.0` – 2020-01-06
#### Added
  - New feature for the non-guessing user to provide 3 hints for their answer 

### `1.1.0` – 2020-01-05
#### Added
  - Allows for more than one word or a phrase to be guessed
  - Added phrases to `WordList.txt`

### `1.0.0` – 2019-12-26
First complete running version of the game. Comes with the following features:
  - Single Player version sourcing words from `WordList.txt` 
  - Two Player version allowing for one player to provide a word and another player to guess
  - Keeps track of letters guessed by the user and amount of guesses left
