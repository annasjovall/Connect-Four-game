package player;

import java.util.Optional;

public class Board {
	private int rowSize;
	private int colSize;
	private Player[][] board;
	
	public Board(int rowSize, int colSize){
		this.rowSize = rowSize;
		this.colSize = colSize;
		board = new Player[rowSize][colSize];
	} 
	
	public int getColSize(){
		return colSize;
	}
	
	public int getRowSize(){
		return rowSize;
	}
	public Optional<Player> get(int row, int col){
		return isWithinBounds(row, col) ? Optional.ofNullable(board[row][col]) : Optional.empty();
	}
	
	public boolean isWithinBounds(int row, int col){
		return (col >= 0 && row >= 0 && col < colSize && row < rowSize);
	}
	
	private boolean set(int row, int col, Player player){
		if(get(row, col).isPresent()){
			return false;
		}
		board[row][col] = player;
		return true;
	}
	
	public void dropDisc(int col, Player player){
		if(discCanDrop(col)){
			set(getRow(col), col, player);
		}
	}
	
	public boolean discCanDrop(int col){
		int row = getRow(col);
		return row >= 0;
	}
	
	public int getRow(int col){
		int row = rowSize - 1;
		while(row >= 0 && get(row ,col).isPresent()){
			row--;
		}
		return row;
	}
	
	/* För felsökning
	private void print(){
		for(int row = 0; row < rowSize; row++){
			for(int col = 0; col < colSize; col++){
				String name = get(row, col).isPresent() ? get(row, col).get().getName() : "null";
				System.out.print(name + " ");
			}
		System.out.print("\n");
		}
	}
	*/
	
}
