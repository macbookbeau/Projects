/**
 * Connect4
 * CPSC 220-03 Project 3
 *
 * This program is designed to allow users to play the classic game Connect4.
 * It uses user input to place tokens on a pre-generated board.
 * It will determine the winner based on how the user lays their tokens:
 * diagonally, horizontally, or vertically.
 */

import java.util.*;

public class ConnectFour {
    // The following declare final, uneditable variables that can be accessed throughout the entire program.
    private static final int theROWS = 10;
    private static final int theCOLUMNS = 10;
    private static final char emptySPACE = '-';
    private static final char playONE = 'R';
    private static final char playTWO = 'Y';


    //This method is what executes the game using the other methods defined below
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        char [][] dasGameBoard = new char[theROWS][theCOLUMNS];
        boardCreation(dasGameBoard);
        boolean endGame = false;

        char presentPlayer = playONE;

        //This loops until the game ends
        while(!endGame) {
            visualBoard(dasGameBoard);

            int tempColumn = moveValidity(scnr, presentPlayer, dasGameBoard);

            theMoves(dasGameBoard, tempColumn, presentPlayer);

            if(winValidity(dasGameBoard, presentPlayer)) {
                visualBoard(dasGameBoard);
                System.out.println("Player" + presentPlayer + " wins! Too bad, other dude. :(");
                endGame = true;
            }
            else if (isDraw(dasGameBoard)) {
                visualBoard(dasGameBoard);
                System.out.println("Nobody wins; the board is full.");
                endGame = true;
            }
            else {
                if(presentPlayer == playONE) {
                    presentPlayer = playTWO;
                }
                else {
                    presentPlayer = playONE;
                }
            }
        }
    }

    //This method initialises an empty board
    public static void boardCreation(char gameBoard[][]) {
        for (int r = 0; r < theROWS; r++) {
            for (int c = 0; c < theCOLUMNS; c++) {
                gameBoard[r][c] = emptySPACE;
            }
        }

    }

    //This method creates a game board visible to the players.
    public static void visualBoard(char gameBoard[][]) {
        for (int r = 0; r < theROWS; r++) {
            for (int c = 0; c < theCOLUMNS; c++) {
                System.out.print(gameBoard[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6 7 8 9");
        System.out.println();
    }

    //This method gets the players's moves and checks their validity against the existing board.
    public static int moveValidity(Scanner scnr, char generalPlayer, char gameBoard[][]) {
        int chosenColumn = -1;
        boolean moveValid = false;

        while (!moveValid) {
            System.out.println("Where do you want your chip to go? You can only use integer values.");
            chosenColumn = scnr.nextInt();

            if (chosenColumn < 0 || chosenColumn >= theCOLUMNS) {
                System.out.println(":( Invalid entry, friend. Try again.");
            }
            else if (gameBoard[0][chosenColumn] != emptySPACE) {
                System.out.println("Column unavailable. Try again.");
            }
            else {
                moveValid = true;
            }
        }
        return chosenColumn;
    }

    //This method places the users' chips onto the game board.
    public static void theMoves(char gameBoard[][], int column, char generalPlayer) {
        //This for loop acts as an iteration search algorithm
        for(int r = theROWS - 1; r >= 0; r--) {
            if(gameBoard[r][column] == emptySPACE) {
                gameBoard[r][column] = generalPlayer;
                break;
            }
        }
    }

    //This method checks whether either player has won
    public static boolean winValidity(char gameBoard[][], char generalPlayer) {
        //Conditions for Horizontal Win
        for(int r = 0; r < theROWS; r++) {
            for(int c = 0; c < theCOLUMNS - 3; c++) {
                if(gameBoard[r][c] == generalPlayer && gameBoard[r][c+1] == generalPlayer && gameBoard[r][c+2] == generalPlayer && gameBoard[r][c+3] == generalPlayer) {
                    return true;
                }
            }
        }

        //Conditions for Vertical Win
        for(int r = 0; r < theROWS - 3; r++) {
            for(int c = 0; c < theCOLUMNS; c++) {
                if(gameBoard[r][c] == generalPlayer && gameBoard[r+1][c] == generalPlayer && gameBoard[r+2][c] == generalPlayer && gameBoard[r+3][c] == generalPlayer) {
                    return true;
                }
            }
        }

        //Conditions for / Win
        for(int r = 3; r < theROWS; r++) {
            for(int c = 0; c < theCOLUMNS - 3; c++){
                if(gameBoard[r][c] == generalPlayer && gameBoard[r-1][c+1] == generalPlayer && gameBoard[r-2][c+2] == generalPlayer && gameBoard[r-3][c+3] == generalPlayer) {
                    return true;
                }
            }
        }

        //Conditions for \ Win
        for(int r = 0; r < theROWS - 3; r++) {
            for(int c = 0; c < theCOLUMNS -3; c++) {
                if(gameBoard[r][c] == generalPlayer && gameBoard[r+1][c+1] == generalPlayer && gameBoard[r+2][c+2] == generalPlayer && gameBoard[r+3][c+3] == generalPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    //This method checks whether the board is full, which would equal a Draw.
    public static boolean isDraw(char gameBoard[][]) {
        for(int c = 0; c < theCOLUMNS; c++) {
            if (gameBoard[0][c] == emptySPACE) {
                return false;
            }
        }
        return true;
    }
}