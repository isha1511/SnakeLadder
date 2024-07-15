import java.util.*;

public class SnakeLadder {

    public static void main(String[] args) {
        final int winningPosition = 100;
        int[] board = new int[winningPosition + 1];
        int position1 = 0, position2 = 0;
        int diceRolls = 0;
        boolean isPlayer1Turn = true;
        boolean gameWon = false;

        Random random = new Random();
        // Initialize ladders
        board[3] = 22;   // Ladder from 3 to 22
        board[5] = 8;    // Ladder from 5 to 8
        board[11] = 26;  // Ladder from 11 to 26
        board[20] = 29;  // Ladder from 20 to 29
        // Initialize snakes
        board[27] = 1;   // Snake from 27 to 1
        board[21] = 9;   // Snake from 21 to 9
        board[17] = 4;   // Snake from 17 to 4
        board[19] = 7;   // Snake from 19 to 7
        // Initialize no play squares
        board[6] = 6;
        board[14] = 14;
        board[35] = 35;
        board[56] = 56;

        while (!gameWon) {
            diceRolls++;
            int dice = random.nextInt(6) + 1;
            int currentPosition = isPlayer1Turn ? position1 : position2;
            int nextPosition = currentPosition + dice;

            if (nextPosition > winningPosition) {
                nextPosition = currentPosition; // Stay in the same position
            } else if (board[nextPosition] != 0) {
                nextPosition = board[nextPosition]; // Move to the snake or ladder
            }

            if (isPlayer1Turn) {
                position1 = nextPosition;
                System.out.println("Player 1 rolls " + dice + " and moves to position " + position1);
                if (position1 == winningPosition) {
                    gameWon = true;
                    System.out.println("Player 1 wins the game!");
                }
            } else {
                position2 = nextPosition;
                System.out.println("Player 2 rolls " + dice + " and moves to position " + position2);
                if (position2 == winningPosition) {
                    gameWon = true;
                    System.out.println("Player 2 wins the game!");
                }
            }
            if (board[nextPosition] > nextPosition) {
                System.out.println((isPlayer1Turn ? "Player 1" : "Player 2") + " gets an extra turn due to ladder!");
            } else {
                // Switch turns only if not a ladder
                isPlayer1Turn = !isPlayer1Turn;
            }
        }
          
        System.out.println("Total dice rolls: " + diceRolls);
    }
}
