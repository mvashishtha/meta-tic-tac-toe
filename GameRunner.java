import java.util.Scanner;

public class GameRunner {
	
	private BigBoard mainBoard;
	private Board metaBoard;
	private Character currChar;
	private int[] boardChoice;
	private Scanner input;
	
	public GameRunner() {
		mainBoard = new BigBoard();
		metaBoard = new Board();
		currChar = 'O';
		boardChoice = new int[0];
		input = new Scanner(System.in);
	}
	
	public void runGame() {
		
		while (metaBoard.determineWin().equals('0')) {
			System.out.println(mainBoard);
			System.out.println();
			System.out.println(metaBoard);
			
			System.out.println("Turn is for " + currChar);

			if (boardChoice.length == 0) {
				chooseSubBoard();
			}

			if (! mainBoard.board[boardChoice[0]][boardChoice[1]].determineWin().equals('0')) {
				System.out.println("The board at row " + boardChoice[0] + " and col " + boardChoice[1] + " has been won.");
				chooseSubBoard();
			}

			
			makeMove(boardChoice[0], boardChoice[1]);


			
			if (currChar.equals('O'))
				currChar = 'X';
			else
				currChar = 'O';
		}	

		if (currChar.equals('O'))
			currChar = 'X';
		else
			currChar = 'O';
		System.out.println("Player " + currChar + " has won the game.");
		
	}
	
	public void chooseSubBoard() {
		boardChoice = new int[2];
		System.out.println("Please choose a sub-board row: ");
		boardChoice[0] = input.nextInt();
		System.out.println("Please choose a column: ");
		boardChoice[1] = input.nextInt();
		if (! mainBoard.board[boardChoice[0]][boardChoice[1]].determineWin().equals('0')) {
			System.out.println("The board at row " + boardChoice[0] + " and col " + boardChoice[1] + " has been won.");
			chooseSubBoard();
		}
	} 
	
	public void makeMove(int row, int col) {
		boardChoice = mainBoard.makeMove(row, col, currChar);
		Character testChar = mainBoard.board[row][col].determineWin();
		if (! testChar.equals('0'))
		{
			System.out.println("Board at row " + row + " and col " + col + " is won. Meta-board updated.");
			metaBoard.makeMove(row, col, currChar);
		}
	}
	

}