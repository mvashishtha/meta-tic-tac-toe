import java.util.Scanner;

public class BigBoard {
	public Board[][] board;
	private Scanner input;
	
	public static int ROWS = 3;
	public static int COLUMNS = 3;
	
	
	public BigBoard() {
		input = new Scanner(System.in);
		board = new Board[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++)
			for (int j = 0; j < COLUMNS; j++)
				board[i][j] = new Board();
	}
	
	public int[] makeMove(int row, int col, Character myChar) {
		int subRow = -1; 
		int subCol = -1;
		while ( (subRow == -1 && subCol == -1) || (board[row][col].board[subRow][subCol] != '_')) {
		    System.out.println("You move in the sub-board at row " + row + " and col " + col + ". Choose a row, then a column.");
		    subRow = input.nextInt();
		    subCol = input.nextInt();
		}
		board[row][col].makeMove(subRow, subCol, myChar);
		int[] newArray = new int[2];
		newArray[0] = subRow;
		newArray[1] = subCol;		
		return newArray;
	}
	
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				toReturn += board[i][j].toString();
				toReturn += "\n";
			}
			toReturn += "\n";
			toReturn += "\n";
		}
		return toReturn;
	}
}