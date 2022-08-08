//Timothy Walker tpw32

package board;

import java.util.ArrayList;
import pieces.Piece;
import pieces.Rook;
import pieces.Knight;
import pieces.Bishop;
import pieces.Queen;
import pieces.King;
import pieces.Pawn;


/**
 * Board class, does the majority of the work by managing all of the pieces. Also handles situational aspects of the game.
 * @author Timothy Walker
 *
 */
public class Board {

	/**
	 * 2D array of pieces to represent a chess board
	 */
	public static Piece[][] board = new Piece[8][8];
	
	/**
	 * Boolean that represents the status of castling
	 */
	public static Boolean castling = false;
	
	/**
	 * Boolean that dictates whether or not to reset En Passant
	 */
	public static Boolean dontResetEnPassant = false;

	/**
	 * Board constructor that will start by filling itself with Pieces
	 */
	public Board() {
    	fillBoard();
    }

	/**
	 * Method that displays the current state of the board and where it's Pieces are located
	 * @param board the board you wish to display
	 */
	public static void displayBoard(Piece[][] board) {
		System.out.println("");
		int row = 8;
		Boolean whitesquare = false;
		for(int i=0; i<8; i++) {
			for(int j=0; j<9; j++) {

				if(j!=8) {
					if(board[i][j]!=null) {
						System.out.print(board[i][j].getColor());
						System.out.print(board[i][j].getType());
					}
					else if(whitesquare) {
						System.out.print("##");
					}
					else {System.out.print("  ");}

					System.out.print(" ");
					whitesquare = !whitesquare;
				}

				else if(row!=0){
					System.out.print(row); row --;
				}
			}
			whitesquare = !whitesquare;
			System.out.println();
		}
		System.out.println(" a " + " b " + " c " + " d " + " e " + " f " + " g " + " h ");
		System.out.println("");
	}

	/**
	 * Method that fills the board with Pieces to indicate a new game
	 */
	public static void fillBoard() {
		//black team
		board[0][0] = new Rook('b');
		board[0][1] = new Knight('b');
		board[0][2] = new Bishop('b');
		board[0][3] = new Queen('b');
		board[0][4] = new King('b');
		board[0][5] = new Bishop('b');
		board[0][6] = new Knight('b');
		board[0][7] = new Rook('b');
		board[1][0] = new Pawn('b');
		board[1][1] = new Pawn('b');
		board[1][2] = new Pawn('b');
		board[1][3] = new Pawn('b');
		board[1][4] = new Pawn('b');
		board[1][5] = new Pawn('b');
		board[1][6] = new Pawn('b');
		board[1][7] = new Pawn('b');

		//white team
		board[7][0] = new Rook('w');
		board[7][1] = new Knight('w');
		board[7][2] = new Bishop('w');
		board[7][3] = new Queen('w');
		board[7][4] = new King('w');
		board[7][5] = new Bishop('w');
		board[7][6] = new Knight('w');
		board[7][7] = new Rook('w');
		board[6][0] = new Pawn('w');
		board[6][1] = new Pawn('w');
		board[6][2] = new Pawn('w');
		board[6][3] = new Pawn('w');
		board[6][4] = new Pawn('w');
		board[6][5] = new Pawn('w');
		board[6][6] = new Pawn('w');
		board[6][7] = new Pawn('w');
	}

	/**
	 * Method that returns the boolean status of castling
	 * @param from coordinates of Piece to move
	 * @param to coordinates of space to move to
	 * @param color color of team to execute castling
	 * @return was castling successful?
	 */
	public boolean castling(String from, String to, char color) {
		Piece[][] temp = duplicateBoard(board);
		int i;

		//use this.move() (boolean return) to utilize leaveKingInCheck()
		if(color=='w' && enemyInCheck(Piece.invertColor(color))==false ) { //if it's white and not in check
			i=7;
			//move rook and king
			if(to.equals("c1") && board[i][0].hasMoved==false && board[i][0].getType()=='R') { //left
				castling = true;
				if(!this.move(from, "d1", "", false)) {board=temp; return false;} //king
				if(!this.move("d1", to, "", false)) {board=temp; return false;} //king
				board[i][3] = board[i][0]; //rook
				board[i][0] = null; //delete previous rook
				return enemyANDleavekingChecks(temp,i,3,false);
			}

			else if (to.equals("g1") && board[7][7].hasMoved==false && board[7][7].getType()=='R') { //right
				castling = true;
				if(!this.move(from, "f1", "", false)) {board=temp; return false;} //king
				if(!this.move("f1", to, "", false)) {board=temp; return false;} //king
				board[i][5] = board[i][7]; //rook
				board[i][7] = null; //delete previous rook
				return enemyANDleavekingChecks(temp,i,5,false);
			}

		}else if(color=='b' && enemyInCheck(Piece.invertColor(color))==false ) {
			i=0;
			//move rook and king
			if(to.equals("c8") && board[i][0].hasMoved==false && board[i][0].getType()=='R') { //left
				castling = true;
				if(!this.move(from, "d8", "", false)) {board=temp; return false;} //king
				if(!this.move("d8", to, "", false)) {board=temp; return false;} //king
				board[i][3] = board[i][0]; //rook
				board[i][0] = null; //delete previous rook
				return enemyANDleavekingChecks(temp,i,3,false);
			}

			else if (to.equals("g8") && board[i][7].hasMoved==false && board[i][7].getType()=='R') { //right
				castling = true;
				if(!this.move(from, "f8", "", false)) {board=temp; return false;} //king
				if(!this.move("f8", to, "", false)) {board=temp; return false;} //king
				board[i][5] = board[i][7]; //rook
				board[i][7] = null; //delete previous rook
				return enemyANDleavekingChecks(temp,i,5,false);
			}

		}

		return false;
	}

	/**
	 * Method that promotes a Pawn to an instance of any Piece the user chooses
	 * @param i array index
	 * @param j array index
	 * @param choice Piece you want to change the Pawn into
	 * @return was promotion successful?
	 */
	public boolean promote(int i, int j, String choice) {
		//System.out.println("promoting...");
		if(choice.equals("")) {choice="Q";}

		char color = board[i][j].getColor();

		if(choice.equals("Q")) {
			board[i][j]=null; board[i][j] = new Queen(color);
			return true;
		}else if(choice.equals("R")) {
			board[i][j]=null; board[i][j] = new Rook(color);
			return true;
		}else if(choice.equals("B")) {
			board[i][j]=null; board[i][j] = new Bishop(color);
			return true;
		}else if(choice.equals("N")) {
			board[i][j]=null; board[i][j] = new Knight(color);
			return true;
		}


		return false;
	}

	/**
	 * Method that checks whether a move is valid and subsequently executes the move if allowed
	 * @param from coordinates of Piece to move
	 * @param to coordinates of space to move to
	 * @param promoteTo promotion request (if possible)
	 * @param shouldDisplay should the board display after the move?
	 * @return was the move executed?
	 */
	public boolean move(String from, String to, String promoteTo, Boolean shouldDisplay) {
		int fromI = Piece.numToIndex(from.charAt(1));
		int fromJ = Piece.letterToIndex(from.charAt(0));
		int toI = Piece.numToIndex(to.charAt(1));
		int toJ = Piece.letterToIndex(to.charAt(0));

		if(board[fromI][fromJ]==null) {return false;}

		//check if castling by checking if toJ-fromJ=2, if it's a king, and hasn't moved
		if(	board[fromI][fromJ].getType()=='K' && board[fromI][fromJ].hasMoved==false && (toJ-fromJ==2 || toJ-fromJ==-2)) {
			if(!this.castling(from, to, board[fromI][fromJ].getColor())) {
				castling=false;
				return false;
			}
			else {
				displayBoard(board);
				castling=false;
				return true;
			}
		}
		

		//fill movelist for piece you want to move
		board[fromI][fromJ].getMoves(board, from);
		
		//Check if the piece can move to desired spot
		if(board[fromI][fromJ].moves.contains(to)) {
			
			//Create temp board before move in case you leave the king in check
			Piece[][] temp = duplicateBoard(board);

			//move piece to desired spot
			board[toI][toJ] = board[fromI][fromJ];
			//delete piece from where it used to be
			board[fromI][fromJ] = null;
			

			//promotion and double-move (en passant)
			if(board[toI][toJ].getType()=='p') {
				if((toI==0 || toI==7)) {if(!this.promote(toI,toJ,promoteTo)) {board=temp; return false;}}
				else if(fromJ==toJ && (toI-fromI==2 || toI-fromI==-2)) {surroundingCanEnPass(toI, toJ);}
				else if(fromJ!=toJ && board[toI][toJ].addEnPassant) {enPassant(temp, toI, toJ);}
			}
			
			//if told to reset addEnPassant, reset, otherwise, do it next time
			if(!dontResetEnPassant) {resetEnPassant();} 
			//else {dontResetEnPassant=false;} in enemyANDleavekingChecks() now
			
			return enemyANDleavekingChecks(temp,toI,toJ,shouldDisplay);

		}else {//move is not in movelist
			return false;
		}
	}

	/**
	 * Method that takes a board and returns an exact copy
	 * @param toDupe board to duplicate
	 * @return duplicated board
	 */
	public Piece[][] duplicateBoard(Piece[][] toDupe){
		Piece[][] temp = new Piece[8][8];
		for(int i=0; i<=7; i++) {
			for(int j=0; j<=7; j++) {
				temp[i][j] = toDupe[i][j];
			}
		}
		return temp;
	}
	
	/**
	 * Method that determines En Passant status of surrounding Pieces
	 * @param i array index
	 * @param j array index
	 */
	public void surroundingCanEnPass(int i, int j) {
		dontResetEnPassant = true; 
		if(j-1>=0) {
			int toJ=j-1;
			if(board[i][toJ]!=null) {
				if( board[i][toJ].getType()=='p' && board[i][toJ].getColor()!=board[i][j].getColor() ) {
					board[i][toJ].addEnPassant=true;
				}
			}
		}
		if(j+1>=0) {
			int toJ=j+1;
			if(board[i][toJ]!=null) {
				if( board[i][toJ].getType()=='p' && board[i][toJ].getColor()!=board[i][j].getColor() ) {
					board[i][toJ].addEnPassant=true;
				}
			}
		}
		
		
		
	}
	
	/**
	 * Method that resets En Passant status
	 */
	public void resetEnPassant() {
		for(int i=0; i<=7; i++) {
			for(int j=0; j<=7; j++) {
				if(board[i][j]!=null) {board[i][j].addEnPassant=false;}
			}
		}
	}
		
	/**
	 * Method that carries out the En Passant process
	 * @param temp temporary Piece
	 * @param i array index
	 * @param j array index
	 */
	public void enPassant(Piece[][] temp, int i, int j) {

		if(board[i][j].getColor()=='w') {
			if(board[i+1][j]!=null && board[i+1][j].getType()=='p' && temp[i][j]==null) {
				board[i+1][j]=null;
				dontResetEnPassant=false;
			}
		}
		else if(board[i][j].getColor()=='b') {
			if(board[i-1][j]!=null && board[i-1][j].getType()=='p' && temp[i][j]==null) {
				board[i-1][j]=null;
				dontResetEnPassant=false;
			}
		}
    	
	}

	/**
	 * Method that incorporates leaveKingInCheck and enemyInCheck methods
	 * @param temp temporary Piece
	 * @param toI array index
	 * @param toJ array index
	 * @param shouldDisplay should the board display?
	 * @return was the method executed?
	 */
	public boolean enemyANDleavekingChecks(Piece[][] temp, int toI, int toJ, boolean shouldDisplay){
		if(leaveKingInCheck(board[toI][toJ].getColor())) { //revert changes
			board = temp;
			if(shouldDisplay) {displayBoard(board);}
			return false;
		}else { //doesn't leave in check
			
			//being moved normally
			if( !castling ) {
				board[toI][toJ].hasMoved=true;
			}
			
			dontResetEnPassant=false; //reset no matter the move
			if(shouldDisplay) {displayBoard(board);}
			return true;
		}
	}
	
	/**
	 * Method that dictates the checkmate status of the game
	 * @param color team in question
	 * @return was the checkmate successful?
	 */
	public Boolean checkmate(char color) {
		String kingsPos = null;
		color = Piece.invertColor(color);
		

		//get movelist for all pieces and get position of king in question
		for(int i=0; i<=7; i++) {
			for(int j=0; j<=7; j++) {
				String pos = Piece.indexToLetter(j) + Piece.indexToNum(i);
				if(board[i][j] != null) {
					board[i][j].getMoves(board, pos);
					if(board[i][j].getColor()==color && board[i][j].getType()=='K') {
						kingsPos = Piece.indexToLetter(j) + Piece.indexToNum(i);
					}
				}
			}
		}
		
		Piece[][] temp1 = duplicateBoard(board);
		
		for(int i=0; i<=7; i++) {
			for(int j=0; j<=7; j++) {
				String pos = Piece.indexToLetter(j) + Piece.indexToNum(i);
				if(board[i][j] != null) {
					if(board[i][j].getColor()==color) {
						if(board[i][j].moves.size()==0) {continue;}
						//System.out.println("piece: " + pos + " moves: " + board[i][j].moves);
						
						for(int moveCount=0; moveCount<board[i][j].moves.size(); moveCount++) {
							//System.out.println("piece: " + pos + " moving: " + board[i][j].moves.get(moveCount));
							move(pos, board[i][j].moves.get(moveCount), "", false);
							
							//if king isnt in check, no checkmate()
							if(!enemyInCheck(Piece.invertColor(color))) {
								board=temp1;
								temp1=duplicateBoard(board);
								return false;
							}
							
							//reset
							board=temp1;
							temp1=duplicateBoard(board);
							board[i][j].getMoves(board,pos);
							
							
						}
						
					}
				}
			}
		}
		
		System.out.println("Checkmate");
		System.out.println(Piece.charColorIntoWord(Piece.invertColor(color)) + " wins");
		return true;
		
	}

	/**
	 * Method that determines whether you will leave your King in check after a move
	 * @param colorOfMoved color of Piece that was moved
	 * @return is the King in check?
	 */
	public boolean leaveKingInCheck(char colorOfMoved) {
		String kingsPos = null;

		//get movelist for all pieces and get position of king in question
		for(int i=0; i<=7; i++) {
			for(int j=0; j<=7; j++) {
				String pos = Piece.indexToLetter(j) + Piece.indexToNum(i);
				if(board[i][j] != null) {
					board[i][j].getMoves(board, pos);
					if(board[i][j].getColor()==colorOfMoved && board[i][j].getType()=='K') {
						kingsPos = Piece.indexToLetter(j) + Piece.indexToNum(i);
					}
				}
			}
		}

		if(colorOfMoved == 'w') {
			for(int i=0; i<=7; i++) {
				for(int j=0; j<=7; j++) {
					String pos = Piece.indexToLetter(j) + Piece.indexToNum(i);
					if(board[i][j] != null) {
						if(board[i][j].getColor()=='b' && board[i][j].moves.contains(kingsPos)) {
							return true;
						}
					}
				}
			}
		}

		if(colorOfMoved == 'b') {
			for(int i=0; i<=7; i++) {
				for(int j=0; j<=7; j++) {
					String pos = Piece.indexToLetter(j) + Piece.indexToNum(i);
					if(board[i][j] != null) {
						if(board[i][j].getColor()=='w' && board[i][j].moves.contains(kingsPos)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	/**
	 * Method that determines whether you will leave the enemy in check after a move
	 * @param colorOfMoved color of Piece that was moved
	 * @return is the enemy King in check?
	 */
	public boolean enemyInCheck(char colorOfMoved) {
		String kingsPos = null;

		
		//get movelist for all pieces and get position of enemy King
		for(int i=0; i<=7; i++) {
			for(int j=0; j<=7; j++) {
				String pos = Piece.indexToLetter(j) + Piece.indexToNum(i);
				if(board[i][j] != null) {
					board[i][j].getMoves(board, pos);
					if(board[i][j].getColor()!=colorOfMoved && board[i][j].getType()=='K') {
						kingsPos = Piece.indexToLetter(j) + Piece.indexToNum(i);
					}
				}
			}
		}
		

		if(colorOfMoved == 'w') {
			for(int i=0; i<=7; i++) {
				for(int j=0; j<=7; j++) {
					String pos = Piece.indexToLetter(j) + Piece.indexToNum(i);
					if(board[i][j] != null) {
						if(board[i][j].getColor()=='w' && board[i][j].moves.contains(kingsPos)) {
							return true;
						}
					}
				}
			}
		}

		if(colorOfMoved == 'b') {
			for(int i=0; i<=7; i++) {
				for(int j=0; j<=7; j++) {
					String pos = Piece.indexToLetter(j) + Piece.indexToNum(i);
					if(board[i][j] != null) {
						if(board[i][j].getColor()=='b' && board[i][j].moves.contains(kingsPos)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}


}
