import java.util.Random;

class Board {
    private final int[] board;
    private final int winningPosition;

    public Board(int size, int winningPosition) {
        this.board = new int[size + 1];
        this.winningPosition = winningPosition;
        initializeBoard();
    }

    private void initializeBoard() {
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
    }

    public int getNextPosition(int currentPosition, int diceRoll) {
        int nextPosition = currentPosition + diceRoll;
        if (nextPosition > winningPosition) {
            return currentPosition; // Stay in the same position if exceeding winning position
        } else if (board[nextPosition] != 0) {
            return board[nextPosition]; // Move to the snake or ladder
        }
        return nextPosition;
    }

    public int getWinningPosition() {
        return winningPosition;
    }
}

class Player {
    private int position;
    private final String name;

    public Player(String name) {
        this.position = 0;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void move(int diceRoll, Board board) {
        int nextPosition = board.getNextPosition(position, diceRoll);
        position = nextPosition;
    }
}

class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private boolean isPlayer1Turn;
    private int diceRolls;

    public Game() {
        this.board = new Board(100, 100);
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.isPlayer1Turn = true;
        this.diceRolls = 0;
    }

    public void play() {
        Random random = new Random();
        boolean gameWon = false;

        while (!gameWon) {
            diceRolls++;
            int dice = random.nextInt(6) + 1;
            Player currentPlayer = isPlayer1Turn ? player1 : player2;
            currentPlayer.move(dice, board);

            System.out.println(currentPlayer.getName() + " rolls " + dice + " and moves to position " + currentPlayer.getPosition());

            if (currentPlayer.getPosition() == board.getWinningPosition()) {
                gameWon = true;
                System.out.println(currentPlayer.getName() + " wins the game!");
            }
                    
            isPlayer1Turn = !isPlayer1Turn;
        }  
        
        System.out.println("Total dice rolls: " + diceRolls);
    }
}

public class SnakeLadder2 {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
