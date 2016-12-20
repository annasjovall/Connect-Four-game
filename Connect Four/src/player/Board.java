package player;

public class Board {
	private int rowSize;
	private int colSize;
	private int[][] board;
	
	public Board(int rowSize, int colSize){
		this.rowSize = rowSize;
		this.colSize = colSize;
		board = new int[rowSize][colSize];
	} 
	
	public int getColSize(){
		return colSize;
	}
	
	public int getRowSize(){
		return rowSize;
	}
	public int get(int row, int col){
		return isWithinBounds(row, col) ? board[row][col] : 0;
	}
	
	public boolean isWithinBounds(int row, int col){
		return (col >= 0 && row >= 0 && col < colSize && row < rowSize);
	}
	
	//måste också set så att den inte var upptagen innan, returnerar player, ta bort isWithinbounds?
	public int set(int row, int col, Player player){
		if(isWithinBounds(row, col) && board[row][col] == 0){
			board[row][col] = player.getID();
			return board[row][col];
		}
		return 0;
	}
	
	public boolean dropDisc(int col, Player player){
		int row = rowSize - 1;
		while(row >= 0 && board[row][col] != 0){
			row--;
		}
		if(row < 0) return false;
		set(row, col, player);
		return true;
	}
	
	public void print(){
		for(int row = 0; row < rowSize; row++){
			for(int col = 0; col < colSize; col++){
				System.out.print(board[row][col] + " ");
			}
		System.out.print("\n");
		}
	}
	
	
//	public static void main(String[] args) {
//		Board b = new Board(7, 6);
//		Player anna = new Player("anna", -1);
//		Player john = new Player("john", 1);
//		b.print();
//		b.set(0, 0, anna);
//		b.set(1, 0, anna);
//		b.set(2, 0, anna);
//		b.set(0, 2, john);
//		b.print();
//	}
	
}
