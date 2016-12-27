package player;

import java.util.Optional;

import logg.Writer;
/**
 * 
 * @author Anna Palmqvist Sjövall
 * 
 * A board filled with players representing a Connect four game.
 */
public class Board {
	private int rowSize; //Amount of rows for this board
	private int colSize; //Amount of cols for this board
	private Player[][] board; //A matrix of players
	
	/**
	 * Creates a board with given size.
	 * @param rowSize The amount of rows for the board
	 * @param colSize The amount of columns for the board
	 */
	public Board(int rowSize, int colSize){
		this.rowSize = rowSize;
		this.colSize = colSize;
		board = new Player[rowSize][colSize];
		Writer.start();
	} 
	
	/**
	 * Gets the amount of columns for the board.
	 * @return The amount of columns in the board
	 */
	public int getColSize(){
		return colSize;
	}
	
	/**
	 * Clears the board, the size remains.
	 */
	public void clear(){
		board = new Player[rowSize][colSize];
		Writer.stop();
	}
	
	/**
	 * Gets the amount of rows for the board.
	 * @return The amount of rows in the board
	 */
	public int getRowSize(){
		return rowSize;
	}
	
	/**
	 * Gets the player at a specific place. 
	 * @param row The row the player is placed at
	 * @param col The column the player is placed at
	 * @return An Optional that contains a player at the specific place if it exists
	 */
	public Optional<Player> get(int row, int col){
		return isWithinBounds(row, col) ? Optional.ofNullable(board[row][col]) : Optional.empty();
	}
	
	/**
	 * Finds out if the given parameters (row, col) is within the board.
	 * @param row The row
	 * @param col The column
	 * @return true if the (row, col) is within the board
	 */
	public boolean isWithinBounds(int row, int col){
		return (col >= 0 && row >= 0 && col < colSize && row < rowSize);
	}
	
	/**
	 * Sets the value at placement (row, col) to player.
	 * @param row The row to place the player
	 * @param col The column to place the player
	 * @param player The player to be placed
	 * @return true if the player was successfully inserted
	 */
	private boolean set(int row, int col, Player player){
		if(get(row, col).isPresent()){
			return false;
		}
		board[row][col] = player;
		return true;
	}
	
	/**
	 * Drops the disc in the specified column according to gravity, if allowed.
	 * @param col The column to place the disc
	 * @param player The player of which the disc belongs to
	 */
	public void dropDisc(int col, Player player){
		if(discCanDrop(col)){
			int row = getRow(col);
			set(row, col, player);
			Writer.append(player + " dropped disc at row: " + row + " and col: " + col);
		}
	}
	
	/**
	 * Checks if the disc is allowed to drop.
	 * @param col The column to se if the disc can drop in
	 * @return true if the disc can drop in the column
	 */
	public boolean discCanDrop(int col){
		int row = getRow(col);
		return row >= 0;
	}
	
	/**
	 * Gets the placement an eventual disc would get if dropped. 
	 * @param col The column the disc would be dropped in
	 * @return The row the disc would be placed in
	 */
	public int getRow(int col){
		int row = rowSize - 1;
		while(row >= 0 && get(row ,col).isPresent()){
			row--;
		}
		return row;
	}
	
}
