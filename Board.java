// Board has a two-dimensional array of Chars
public class Board {
	public Character[][] board;
	
	public static int ROWS = 3;
	public static int COLUMNS = 3;
	
	
	public Board() {
		board = new Character[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++)
			for (int j = 0; j < COLUMNS; j++)
				board[i][j] = '_';
	}
	
	public void makeMove(int row, int col, Character myChar) {
		board[row][col] = myChar;
	}
	
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++)
				toReturn += board[i][j] + " ";
			toReturn += "\n";
		}
		return toReturn;
	}
	
	public Character determineWin() {
		boolean row_victory = false;
		boolean col_victory = false;
		boolean diag_victory = false;
		Character testChar = null;
		// CHECK FOR ROW-VICTORY
		for (int i = 0; i < ROWS; i++) {
			testChar = board[i][0];
			if ( (! testChar.equals('_')) && testChar.equals(board[i][1]) && testChar.equals(board[i][2]) )
				row_victory = true;
		}
		
		if (! row_victory) {
			// CHECK FOR COL-VICTORY
			for (int i = 0; i < COLUMNS; i++) {
				testChar = board[0][i];
				if ( (! testChar.equals('_')) && testChar.equals(board[1][i]) && testChar.equals(board[2][i]))
					col_victory = true;
			}
		}
			if (! col_victory) {
				// CHECK FOR DIAG-VICTORY
				testChar = board[0][0];
				if ( (! testChar.equals('_')) && testChar.equals(board[1][1]) && testChar.equals(board[2][2]))
					diag_victory = true;
				else {
					testChar = board[0][2];
					if ( (! testChar.equals('_')) && testChar.equals(board[1][1]) && testChar.equals(board[2][0]))
						diag_victory = true;
				}
			}
		

		if (row_victory || diag_victory || col_victory)
			return testChar;
		return '0';
	}
}