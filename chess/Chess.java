//Timothy Walker tpw32

package chess;

import pieces.Piece;
import board.Board;
import java.util.Scanner;


/**
 * Chess class, responsible for handling the game and making sure it plays as expected
 * @author Timothy Walker
 *
 */
public class Chess {
	
	/**
	 * Boolean that dictates what team is up to make a move
	 */
	static Boolean whitemove = true;
	
	/**
	 * Scanner to read inputs from the user
	 */
	static Scanner scan = new Scanner(System.in);
	
	/**
	 * String to store scanned input
	 */
	static String input;
	
	/**
	 * Instance of Board class which will be used to play the game
	 */
	static Board gameBoard = new Board();	
	
	/**
	 * Main method, handles the flow of the entire game
	 * @param args typical main method parameter
	 */
	public static void main(String[] args) {
		gameBoard.displayBoard(gameBoard.board);
		
		//game loop
		while(true) {
			//Check who's move it is and take input, we can assume all inputs are valid
			Boolean validMove = false;
			
			if(whitemove) {
				System.out.print("White's move: ");
				input = scan.nextLine();
			}else {
				System.out.print("Black's move: ");
				input = scan.nextLine();
			}
			
			if(input.equals("resign")){
				if(whitemove) {	System.out.println("Black wins"); return;}
				System.out.println("White wins"); return;
			}
			
			String[] choice = input.split("\\s+");
			String from = choice[0];
			String to = choice[1];
			
			if (choice.length == 3) {
				//check for draw request
				if(choice[2].equals("draw?")) {
					if(whitemove) {System.out.print("Black's move: ");}
					else {System.out.print("White's move: ");}
					input = scan.nextLine();
					System.out.println("draw");
					return;
				}
			}
			
			int x = Piece.numToIndex(from.charAt(1));
			int y = Piece.letterToIndex(from.charAt(0));
			if(whitemove) {
				if (gameBoard.board[x][y]!=null) {
					if (gameBoard.board[x][y].getColor()=='b') {
						System.out.println("Illegal move, try again");
						continue;
					}
				}
			}else {
				if (gameBoard.board[x][y]!=null) {
					if (gameBoard.board[x][y].getColor()=='w') {
						System.out.println("Illegal move, try again");
						continue;
					}
				}
			}
			
			if(choice.length == 3) {validMove = gameBoard.move(from, to, choice[2], true);}
			else{validMove = gameBoard.move(from, to, "", true);}
		
			if (validMove == true) {
				char color = Piece.MoveIntoChar(whitemove);
				if(gameBoard.enemyInCheck(color)) {
					if(gameBoard.checkmate(color)) {return;}
					else {System.out.println("Check");}
				}
				
				whitemove=!whitemove;
			}
			
			else {System.out.println("Illegal move, try again");}


			
		}
		
	}	
	
}
