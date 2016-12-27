package player;

import logg.Writer;

/**
 * 
 * @author Anna Palmqvist Sjövall
 * 
 * A check for a board to see if current game should end.
 */
public class EndGame{
	private Board board; //The board to check wins
	
	/**
	 * Creates a check for the given board to see if the game should end.
	 * @param board The board to be checked
	 */
	public EndGame(Board board){
		this.board = board;
	}
	
	/**
	 * Checks if the disc at place (row, col) forms a four-in-a-row in that row.
	 * @param row The row of the disc to be checked
	 * @param col The column of the disc to be checked
	 * @return true if the disc forms a four-in-a-row
	 */
	private boolean checkRows(int row, int col){
		Player player = board.get(row, col).get();
		int count = 0;
		for(int cols = col - 3; cols <= col + 3; cols++){
			if(count == 4) return true;
			if(board.get(row, cols).isPresent() 
					&& board.get(row, cols).get().equals(player)) count++;
			else count = 0;
		}
		return count == 4;
	}
	
	/**
	 * Checks if the disc at place (row, col) forms a four-in-a-row in that column.
	 * @param row The row of the disc to be checked
	 * @param col The column of the disc to be checked
	 * @return true if the disc forms a four-in-a-row
	 */
	private boolean checkColumns(int row, int col){
		Player player = board.get(row, col).get();
		int count = 0;
		for(int rows = row - 3; rows <= row + 3; rows++){
			if(count == 4) return true;
			if(board.get(rows, col).isPresent() 
					&& board.get(rows, col).get().equals(player)) count++;
			else count = 0;
		}
		return count == 4;
	}
	
	
	//DIAGONALEN FUNKAR INTE RIKTIGT
	/**
	 * Checks if the disc at place (row, col) forms a four-in-a-row in a diagonal (right or left shifted).
	 * @param row The row of the disc to be checked
	 * @param col The column of the disc to be checked
	 * @return true if the disc forms a four-in-a-row
	 */
	private boolean checkDiagonals(int row, int col){
		Player player = board.get(row, col).get();
		int countleft = 0; //Counts the occurences of discs in the left diagonal "\"
		int countright = 0; //Counts the occurences of discs in the right diagonal "/"
		for(int i = -3; i <= 3; i++){
			if(countleft == 4 || countright == 4) return true;
			if(board.get(row + i, col + i).isPresent() && board.get(row + i, col + i).get().equals(player)) countleft++;
			if(board.get(row - i, col - i).isPresent() && board.get(row - i, col - i).get().equals(player)) countright++;
			else{
				countleft = 0; 
				countright = 0;
			}
		}
		return countleft == 4 || countright == 4;
	}
	
	/**
	 * Checks if the disc placed at (row, col) forms a four-in-a-row and "wins".
	 * @param row The row of the disc to be checked
	 * @param col The column of the disc to be checked
	 * @return true if the disc forms a four-in-a-row
	 */
	public boolean win(int row, int col){
		boolean win = checkColumns(row, col) || checkRows(row, col) || checkDiagonals(row, col);
		if(win) Writer.append("Spelaren " + board.get(row, col).get() + " har vunnit!");
		return win;
	}
	
	/**
	 * Checks if the board is full. No more discs can be placed.
	 * @return true if the board is full
	 */
	public boolean filledBoard(){
		for(int row = 0; row < board.getRowSize(); row++){
			for(int col = 0; col < board.getColSize(); col++){
				if(!board.get(row, col).isPresent()) return false;
			}
		}
		return true;
	}
}
