package project5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Project 5 solution attempt for CF7 (Five-Projects PDF Chapter.10 "Structured Programming")
 * Representing the seats of a theatre in a boolean array 30x12.
 * User can book a seat or cancel an already booked one.
 * The seats are being printed from printSeats function represented as '-' for the non-booked ones and '|' for the ones already booked.
 * Make sure you're scrolling up above the printed seats to view the feedback message after each action.
 * To exit program press 'E' after the 'select action' prompt.
 */
public class Project05 {

    static boolean[][] theatre = new boolean[30][12];

    public static void main(String[] args) {

        boolean showIsOn = true;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the theatre! \nSeats marked as '-' are empty and available for booking while seats marked as '|' are booked.");

        while (showIsOn) {
            try {
                System.out.println("Please select an action. Press 'B' to make a booking, 'C' to cancel a booked seat or 'E' to terminate.");
                String action = in.nextLine().toUpperCase();

                if (action.equals("E")) {
                    break;
                }
                else if (!(action.equals("B") || action.equals("C")))
                    throw new InputMismatchException("Action must be either 'B', 'C' or 'E'.");

                System.out.println("Please select seat for given action. ex. 'C2'");
                String seat = in.nextLine();

                char column = seat.charAt(0);
                int row = seat.length() == 2
                        ? Integer.parseInt(seat.substring(1)) - 1
                        : Integer.parseInt(seat.substring(1, 3)) - 1;

                int colToInt = ((int) Character.toUpperCase(column) - 65);

                if (row > 29 || row < 0) {
                    System.out.println("Row out of theatre's range. Theatre range 1-30");
                } else if (colToInt < 0 || colToInt > 12) {
                    System.out.println("Column out of theatre's range. Theatre columns A-L");
                }

                if (action.equals("B"))
                    book(colToInt, row);
                else
                    cancel(colToInt, row);

                printSeats(theatre);

            } catch(Exception e){
                System.out.println("Invalid action. Try again.");
            }
        }
    }

    // Helper functions below this point
    public static void book (int col, int row) {
        if (theatre[row][col]) {
                System.out.println("Seat already booked. Please select one of the seats below marked as '-'.");
        } else {
            theatre[row][col] = true;
            System.out.println("Seat booked successfully!");
        }
    }

    public static void cancel (int col, int row) {
        if (theatre[row][col]) {
            theatre[row][col] = false;
            System.out.println("Seat cancelled");
        }
        else {
            System.out.println("Seat not booked");
        }
    }

    public  static void printSeats (boolean[][] arr) {
        for (boolean[] row : arr) {
            for (boolean seat : row) {
                System.out.print( seat ? "| " : "- " );
            }
            System.out.println();
        }
    }
}
