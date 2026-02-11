# Snap game

**This is a Snap card game implemented using Java, playable using the terminal and stores player records.**

## Table of Contents

- [Game Overview](#-game-overview)
- [How to Play](#-how-to-play)
- [Documentation](#-documentation)

## Game Overview

Snap is a card game in which players deal cards and react quickly to spot pairs of cards of the same rank. This implementation allows for two players taking alternating turns. The first person to spot the same rank cards has the opportunity to call snap, which gives the chance to win the game.

## How to Play

### Locally

clone the repository

```bash
    git clone https://github.com/Hongsworth/Space-invaders.git
```

The game be run by running the Main.java file and the inputs are registered in the terminal.

### Controls

**Terminal**

First enter the player name to load locally saved information or if it is a new player then it will create a new player in the files. 

Then press enter to deal the cards, the player's turn is indicated in the console.

When 2 consecutive cards of the same rank are detected then there is a 2 seconds window for the player to call snap.

Failure to call snap in time will result in a loss, success will result in a win.

The player records are then shown in the terminal after the game ends.

The players can choose to enter y to continue and play another game or any other inputs to quit the game.

## Documentation

The game logic is mainly contained within the `Snap.java` file where it inherits a set of methods and structures from the base `CardGame()` class.
The game is initialized with a set of cards in a deck shuffled and a scanner to read player inputs.

The player's data is stored in the `players.json` file, it contains the players' name and win/loss data. The `org.json` package is used to read and write and interpret json data.

The timer is implemented using a thread, this is because the `scanner.nextLine()` method will hold the terminal up until a next line is submitted. This means no other process can be completed during this time.
A thread can be created to solve this issue by running `scanner.readLine()` on a separate thread which can then be shutdown after a certain amount of time.

This is done in the `checkWin()` function where a new thread is created using `ExecutorService`.