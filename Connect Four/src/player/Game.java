package player;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Board board = new Board(7, 6);
		EndGame end = new EndGame(board);
		Players list = new Players();
		Scanner scan = new Scanner(System.in);
//		scannerPlay(list, board, end, scan);
//		shouldGiveTrue(list, board, end);
		testDropDisc(list, board, end);
	}
	
	private static void testDropDisc(Players list, Board board, EndGame end){
		list.add(new Player("Anna", -1));
		list.add(new Player("John", 1));

		board.dropDisc(0, list.getActivePlayer());
		System.out.println(end.checkIfWon(6, 0));
		
		board.dropDisc(1, list.getActivePlayer());
		System.out.println(end.checkIfWon(6, 1));
		
		board.dropDisc(2, list.getActivePlayer());
		System.out.println(end.checkIfWon(6, 2));
		
		board.dropDisc(3, list.getActivePlayer());
		System.out.println(end.checkIfWon(6, 3));
		
		
		board.print();
		
		
		board.dropDisc(0, list.getActivePlayer());
		System.out.println(end.checkIfWon(5, 0));
		
		board.dropDisc(1, list.getActivePlayer());
		System.out.println(end.checkIfWon(5, 1));
		
		board.dropDisc(2, list.getActivePlayer());
		System.out.println(end.checkIfWon(5, 2));
		
		
		board.print();
		
		
		board.dropDisc(1, list.getActivePlayer());
		System.out.println(end.checkIfWon(5, 2));
		
		board.dropDisc(2, list.getActivePlayer());
		System.out.println(end.checkIfWon(5, 3));
		
		
		board.print();
		
		board.dropDisc(2, list.getActivePlayer());
		System.out.println(end.checkIfWon(4, 3));
		
	}
	
	private static void scannerPlay(Players list, Board board, EndGame end, Scanner scan){
		System.out.println("Skriv in namn på spelare 1");
		list.add(new Player(scan.nextLine(), -1));
		System.out.println("Skriv in namn på spelare 2");
		list.add(new Player(scan.nextLine(), 1));	
		
		while(!end.endGame()){
			board.print();
			Player active = list.getActivePlayer();
			System.out.println("Gör ditt drag spelare " + active.getName() + ". Ange plats");
			int row = scan.nextInt();
			int col = scan.nextInt();
			board.set(row, col, active);
			if(end.checkIfWon(row, col)) {
				System.out.println("Du har vunnit!");
				System.exit(0);
			}
			list.nextPlayer();
		}
		System.out.println("Oavgjort, inga drag kvar.");
		System.exit(0);
		scan.close();
	}
	private static void shouldGiveTrue(Players list, Board board, EndGame end){
		list.add(new Player("Anna", -1));
		list.add(new Player("John", 1));
		board.print();
		board.set(0, 2, list.getActivePlayer());
		board.print();
		System.out.println("anna" + end.checkIfWon(0, 2));
//		board.set(0, 1, list.getActivePlayer());
//		board.print();
//		System.out.println("anna" + end.checkIfWon(0, 1));
		board.set(0, 3, list.getActivePlayer());
		board.print();
		System.out.println("anna" + end.checkIfWon(0, 3));
		board.set(0, 4, list.getActivePlayer());
		board.print();
		System.out.println("anna" + end.checkIfWon(0, 4));
		board.set(0, 5, list.getActivePlayer());
		board.print();
		System.out.println("anna" + end.checkIfWon(0, 5));
	}

}
