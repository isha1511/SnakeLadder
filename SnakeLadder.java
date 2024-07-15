import java.util.*;

public class SnakeLadder {

    public static void main(String[] args) {
        final int winningPosition = 100;
        int[] board = new int[winningPosition + 1];
        int startPosition = 0;
        int nextPosition=0;
        int dice=0;

        Random random=new Random();
        board[3] = 22;   // Ladder from 3 to 22
        board[5] = 8;    // Ladder from 5 to 8
        board[11] = 26;  // Ladder from 11 to 26
        board[20] = 29;  // Ladder from 20 to 29
        board[27] = 1;   // Snake from 27 to 1
        board[21] = 9;   // Snake from 21 to 9
        board[17] = 4;   // Snake from 17 to 4
        board[19] = 7;   // Snake from 19 to 7
        board[6]=6;      //No play
        board[14]=14;    //No play
        board[35]=35;    //No play
        board[56]=56;    //No play

    while (startPosition < winningPosition) {
        dice = random.nextInt(7);
        nextPosition = startPosition + dice;

    if (nextPosition > winningPosition) {
        // If the next position is beyond 100, stay in the same position
        nextPosition = startPosition;
    } else if (board[nextPosition] != 0) {
        // Check if there's a snake or ladder
        nextPosition = board[nextPosition];
    }

    startPosition = nextPosition;
    System.out.println("Dice Roll: " + dice + ", Position: " + startPosition);
    }
    
    }
}
      
