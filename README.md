# Java Chess

## Description
Java Chess is a command-line application that allows you to play chess in the terminal. It provides a basic implementation of the game with support for moving pieces, capturing opponent's pieces, and basic rules of chess. Please note that this project is currently a work in progress and certain features, such as checkmate detection, are yet to be implemented.

## Features
- Play chess against another player in the terminal.
- Move pieces according to the rules of chess.
- Capture opponent's pieces by moving onto their occupied squares.

## Installation
1. Ensure that you have Java Development Kit (JDK) installed on your system.
2. Clone this repository or download the source code as a ZIP file.
3. Extract the contents of the ZIP file (if applicable) to a directory of your choice.

## Usage
1. Open a terminal or command prompt and navigate to the directory where the source code is located.
2. Compile the Java files using the following command:
    ```bash
    javac Main.java
    ```
3. Run the program using the following command:
    ```bash
    java Main
    ```
4. Follow the on-screen prompts to enter your moves and play the game.
5. The game will display the chessboard and update it with each move.

## Rules
- Moves are entered in algebraic notation, such as "e2 e4" to move the pawn from e2 to e4.
- The game follows the standard rules of chess regarding piece movement and capturing.
- Checkmate detection is not implemented yet, so players should manually check for checkmate conditions.

## TODO
The project is still under development, and the following features are planned to be implemented:

- Checkmate detection: Automatically detect checkmate conditions and end the game.
- En passant: Implement the en passant rule for pawn captures.
- Castling: Allow players to perform the castling move.
- Promotion: Implement pawn promotion when a pawn reaches the opponent's back rank.
- Improved user interface: Enhance the terminal interface for better user experience.

## Contributing
Contributions to this project are welcome! If you have any ideas, suggestions, or would like to contribute to the development, please submit an issue or a pull request on the GitHub repository.
