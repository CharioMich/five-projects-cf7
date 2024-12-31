package project4;

import java.util.Scanner;

/**
 * Project 4 solution attempt for CF7 (Five-Projects PDF Chapter.10 "Structured Programming")
 * Tic-tac-toe game for two players.
 */
public class Project04 {

    public static void main(String[] args) {
        char[][] gameSet = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Scanner in = new Scanner(System.in);
        String input;
        boolean gameIsOn = true;
        // playerSwitch variable defines the player where true -> Player A and false -> Player B.
        boolean playerSwitch = true;
        boolean setCoords = true;
        int x = 0;
        int y = 0;

        // Greet user and give game instructions
        System.out.println("~~ Welcome to the game!! ~~ \nGame Instructions: \nThere are two players. A and B. Player A makes the first move.\n" +
                "Each move is made in the following form: 'rowPosition , columnPosition'\n" +
                "For example '2,2' refers to the central box and '1,1' to the top left corner. " +
                "Player A has the 'X' symbol by default and Player B the 'O'.");
        twoDPrinter(gameSet);
        // Main loop of the game
        while (gameIsOn) {
            // Get the x and y coordinates from the user
            while (setCoords) {
                try {
                    System.out.println("Player " + (playerSwitch ? "A" : "B") + " make a move.");
                    input = in.nextLine();
                    String[] move = input.split(",");
                    x = Integer.parseInt(move[0]);
                    y = Integer.parseInt(move[1]);
                    if (isNotValid(x) || isNotValid(y) || gameSet[x - 1][y - 1] != ' ') {
                        System.out.println("Please choose an empty position within the table's range.");
                    } else {
                        setCoords = false;
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Please insert a valid position of two integers in the following form: x,y");
                }
            }

            // Insert the value into the 2D array's given coordinates and print the board
            gameSet[x - 1][y - 1] = playerSwitch ? 'X' : 'O';
            twoDPrinter(gameSet);

            // Check game state. If not winning or tie, change player and set setCoords boolean variable to true
            // so that we can do the state testing on the next round
            if (thereIsAWinner(gameSet)) {
                System.out.println("Player " + (playerSwitch ? "A" : "B") + " won this game!");
                gameIsOn = false;
            } else if (isTie(gameSet)) {
                System.out.println("It's a tie!");
                gameIsOn = false;
            } else {
                playerSwitch = !playerSwitch;
                setCoords = true;
            }
        }
        // Last message for the user after exiting the main "while" loop
        System.out.println("Thanks for playing!");
    }

    public static void twoDPrinter(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length - 1; j++) {
                System.out.printf("%c | ", table[i][j]);
            }
            System.out.printf("%c \n", table[i][table.length - 1]);
            if (i != table.length - 1) {
                System.out.println("---------");
            }
        }
    }

    public static boolean isTie(char[][] table) {
        for (char[] row : table) {
            for (char i : row) {
                if (i == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNotValid(int index) {
        return index < 1 || index > 3;
    }

    public static boolean thereIsAWinner(char[][] table) {
        boolean winner = false;
        // Check horizontally
        for (char[] move : table) {
            if (move[0] != ' ' && move[0] == move[1] && move[1] == move[2]) {
                winner = true;
                break;
            }
        }
        // Check vertically
        for (int i = 0; i < table[0].length; i++) {
            if (table[0][i] != ' ' && table[0][i] == table[1][i] && table[1][i] == table[2][i]) {
                winner = true;
                break;
            }
        }
        // Check diagonally
        char center = table[1][1];
        if (center != ' ') {
            if ((center == table[0][0] && center == table[2][2]) || (center == table[0][2] && center == table[2][0])) {
                winner = true;
            }
        }
        return winner;
    }
}
