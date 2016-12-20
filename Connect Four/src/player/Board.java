package player;

public class Board {
	private int rowSize;
	private int colSize;
	private String[][] board;
	
	public Board(int rowSize, int colSize){
		this.rowSize = rowSize;
		this.colSize = colSize;
		board = new String[rowSize][colSize];
	}
	
	public String get(int row, int col){
		return isWithinBounds(row, col) ? "" : board[row][col];
	}
	
	private boolean isWithinBounds(int row, int col){
		return (col >= 0 || row >= 0 || col < colSize || row < rowSize);
	}
	
	//måste också set så att den inte var upptagen innan
	public void set(int row, int col, Player player){
		if(isWithinBounds(row, col)) board[row][col] = player.getID();
	}
	
	public void print(){
		for(int row = 0; row < rowSize; row++){
			for(int col = 0; col < colSize; col++){
				System.out.print(board[row][col] + " ");
			}
		System.out.print("\n");
		}
	}
	
	
	public static void main(String[] args) {
		Board b = new Board(3, 3);
		Player anna = new Player("X");
		Player john = new Player("0");
		b.print();
		b.set(0, 0, anna);
		b.set(1, 0, anna);
		b.set(2, 0, anna);
		b.set(0, 2, john);
		b.print();
	}
	
}
