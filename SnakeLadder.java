import java.util.*;

public class SnakeLadder {

    public static void main(String[] args) {
        final int winningPosition = 100;
        int[] board = new int[winningPosition + 1];
        int startPosition = 0;
        int nextPosition=0;
        int dice=0;

        while (startPosition < winningPosition) {
            dice = random.nextInt(6) + 1;
            nextPosition = startPosition + dice;

            // Ensure the position does not exceed the winning position
            if (nextPosition <= winningPosition) {
                startPosition = nextPosition;
                System.out.println("Dice Roll: " + dice + ", Position: " + startPosition);
            }

            // Check for winning condition
            if (startPosition == winningPosition) {
                System.out.println("Congratulations! You've won the game!");
                break;
            }
        }
    }
}
      
