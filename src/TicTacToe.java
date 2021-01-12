/*
 * Lab 8
 * Description: create a 3x3 TicTacToe board game
 * Name: Mohammad Abdelrahman
 * ID: 920158652
 * Class: CSC 211-02
 * Semester: fall 2020
 */
import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        String winner = null; // variable winner to hold the winner value
        Scanner input = new Scanner(System.in); // scanner object to use to get the input from user
        char[][] board = new char[3][3]; // a fixed 2d array 3x3 of characters
        char currPlayer = ' '; // char variable to hold the current player's turn
        int round = 1; // variable round to keep track of rounds and switch between players
        while(winner == null) { // loop to keep the game on as long as there is no winner or a draw
            currPlayer = 'X'; // start the game with X as the first player
            if (round % 2 == 0) { // condition to switch between X and O players
                currPlayer = 'O';
            }
            printBoard(board); // call function printBoard to print the board
            System.out.println(currPlayer + "'s turn. Pick a square 1-9 to put your mark in. Enter 0 if you want to see the mappings.");
            int opt = input.nextInt(); // store the input from user in opt which represents the option chosen
            do {
                if(opt == 0){ // check to see if the user want to draw the mapping for the game
                        boardMap();
                        opt = input.nextInt();
                }
                else if(opt < 1 || opt > 9){
                    System.out.println("Invalid input, please try again");
                    opt = input.nextInt();
                }
                switch (opt) { // insert the current player X or O at the place that the player wants
                    case 1:
                        board[0][0] = currPlayer; // number 1 on mapping
                        break;
                    case 2:
                        board[0][1] = currPlayer; // number 2 on mapping
                        break;
                    case 3:
                        board[0][2] = currPlayer; // number 3 on mapping
                        break;
                    case 4:
                        board[1][0] = currPlayer; // number 4 on mapping
                        break;
                    case 5:
                        board[1][1] = currPlayer; // number 5 on mapping
                        break;
                    case 6:
                        board[1][2] = currPlayer; // number 6 on mapping
                        break;
                    case 7:
                        board[2][0] = currPlayer; // number 7 on mapping
                        break;
                    case 8:
                        board[2][1] = currPlayer; // number 8 on mapping
                        break;
                    case 9:
                        board[2][2] = currPlayer; // number 9 on mapping
                        break;
                }
            }while(opt != 0 && opt > 9 || opt < 1); // keep looping till the user input a valid input

            round++; // increase round +1 to go to the next round and next player

            if(checkWinner(board).equals("X")){ // method to chek if player X is a winner at each round
                winner = "X";
                System.out.println("Game over X wins!");
            }
            else if(checkWinner(board).equals("O")) { // method to chek if player O is a winner at each round
                winner = "O";
                System.out.println("Game over O wins!");
            }
                else if (isFull(board)){ // method to chek if the board is full of X's and O's, and if so it's a draw
                winner = "Draw";
                System.out.println("Game over it's a Draw!");
                }
            }
    }

    static String checkWinner(char[][] board) { // a method to check if there are any winners
            String line = null; // string to collect the data in the array aka board
            for(int i = 0; i < 8; i++){ // loop to go though all the 8 different cases to win
            switch (i) {
                case 0: // all at the first row
                    line = "" +board[0][0] + board[0][1] + board[0][2];
                    break;
                case 1: // all at the second row
                    line = "" + board[1][0] + board[1][1] + board[1][2];
                    break;
                case 2: // all at the third row
                    line = "" + board[2][0] + board[2][1] + board[2][2];
                    break;
                case 3: // all at the first column
                    line = "" + board[0][0] + board[1][0] + board[2][0];
                    break;
                case 4: // all at the second column
                    line = "" + board[0][1] + board[1][1] + board[2][1];
                    break;
                case 5: // all at the third column
                    line = "" + board[0][2] + board[1][2] + board[2][2];
                    break;
                case 6: // all at a diagonal line from left to right
                    line = "" + board[0][0] + board[1][1] + board[2][2];
                    break;
                case 7: // all at a diagonal line from right to left
                    line = "" + board[0][2] + board[1][1] + board[2][0];
                    break;
            }
            if (line.equals("XXX")) { // if one od the lines above is "XXX" or "OOO" returns O or X respectively
                line = "X";
                return line;
            } else if (line.equals("OOO")) {
                line = "O";
                return line;
            }
        }
            return line;
    }

    public static void boardMap(){ // this method prints out the mapping for the board from 1-9
        int[][] board = new int[3][3]; // initialize a 2D array 3x3
        int cell = 1; // variable to number the cells of array
        for(int i  = 0; i < board.length; i++){ // loop trough the array aka board
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = cell++; // assign cell variable to array and then +1 the cell value
                System.out.print("["+board[i][j]+"] "); // print it out between brackets
            }
            System.out.println();
        }
    }


    public static void printBoard(char[][] board){ // method to print the passed array
        for(int i  = 0; i < board.length; i++){ // loop trough the array aka board
            for(int j = 0; j < board[i].length; j++){
                System.out.print("["+board[i][j]+"] ");// print it out between brackets
            }
            System.out.println();
        }

    }
    public static boolean isFull(char[][] board) { // method check if array is full of X's and O's
        boolean isFull = true; // initialize variable isFull
        for (int i = 0; i < board.length; i++) {// loop trough the array aka board
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') { // check if all cells are full of X's and O's
                    isFull = false;
                }
            }
        }
        return isFull;
    }
}