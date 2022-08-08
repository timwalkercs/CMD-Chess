//Timothy Walker tpw32

package pieces;

import java.util.ArrayList;


/**
 * Abstract Piece class, gives the framework for all of the pieces in the game.
 * @author Timothy Walker
 *
 */
public abstract class Piece {
	
	/**
	 * char representing Piece's color
	 */
    char color;
    
    /**
     * Status whether Piece has been moved
     */
    public boolean hasMoved = false;
    
    /**
     * Status of En Passant
     */
    public Boolean addEnPassant = false;
    
    /**
     * ArrayList containing coordinates of all moves a Piece can make
     */
    public ArrayList<String> moves = new ArrayList<String>();
    
    /**
     * Piece constructor with character parameter to indicate color
     * @param c color character
     */
    public Piece(char c) { 
    	color = c;
    	
    }

    /**
     * Obtains the color of the Piece.
     * @return char representing Piece's color
     */
    public char getColor() {
    	return color;
    }
    
    /**
     * Converts an index into the letter portion of a chess coordinate
     * @param j index int
     * @return String letter
     */
    public static String indexToLetter(int j) {
    	if(j==0) {return "a";}
    	else if(j==1) {return "b";}
    	else if(j==2) {return "c";}
    	else if(j==3) {return "d";}
    	else if(j==4) {return "e";}
    	else if(j==5) {return "f";}
    	else if(j==6) {return "g";}
    	else if(j==7) {return "h";}
    	else{return "ERROR";}
    }
    
    /**
     * Converts an index into the number portion of a chess coordinate
     * @param i index int
     * @return String of the number
     */
    public static String indexToNum(int i) {
    	if(i==0) {return "8";}
    	else if(i==1) {return "7";}
    	else if(i==2) {return "6";}
    	else if(i==3) {return "5";}
    	else if(i==4) {return "4";}
    	else if(i==5) {return "3";}
    	else if(i==6) {return "2";}
    	else if(i==7) {return "1";}
    	else{return "ERROR";}
    }

    /**
     * Converts the letter portion of a chess coordinate into an index of the 2D Board array
     * @param letter char of the letter to convert
     * @return int index
     */
    public static int letterToIndex(char letter) {
		if(letter=='a') {return 0;}
		else if(letter=='b') {return 1;}
		else if(letter=='c') {return 2;}
		else if(letter=='d') {return 3;}
		else if(letter=='e') {return 4;}
		else if(letter=='f') {return 5;}
		else if(letter=='g') {return 6;}
		else if(letter=='h') {return 7;}
		else return 0;
	}
	
    /**
     * Converts the number portion of a chess coordinate into an index of the 2D Board array
     * @param number char of the number to convert
     * @return int index
     */
	public static int numToIndex(char number) {
		if(number=='8') {return 0;}
		else if(number=='7') {return 1;}
		else if(number=='6') {return 2;}
		else if(number=='5') {return 3;}
		else if(number=='4') {return 4;}
		else if(number=='3') {return 5;}
		else if(number=='2') {return 6;}
		else if(number=='1') {return 7;}
		else return 0;
	}
	
	/**
	 * Take a Piece color and return the opposite
	 * @param color color character
	 * @return char of color
	 */
	public static char invertColor(char color) {
		if(color=='w') {return 'b';}
		else if(color=='b') {return 'w';}
		else return 0;
	}
	
	/**
	 * See who's turn it is and return the team color as a char
	 * @param whitemove boolean that dictates if it is white/black move
	 * @return char of color
	 */
	public static char MoveIntoChar(Boolean whitemove) {
		if(whitemove) {return 'w';}
		return 'b';
	}
	
	/**
	 * Convert color character into full string of the word
	 * @param color color character
	 * @return String of color in word form
	 */
	public static String charColorIntoWord(char color) {
		if(color=='w') {return "White";}
		return "Black";
	}
	
    /**
     * Abstract method to obtain the type of Piece
     * @return char of Piece type
     */
    public abstract char getType();
    
    /**
     * Given a board and coordinates of a Piece, fill moves list with all valid coordinates
     * @param board game board
     * @param position coordinates of the Piece you want to move
     */
    public abstract void getMoves(Piece[][] board, String position);   
    //getMoves will get all potential moves that a piece can make
    //it does however, contain moves which may leave the king in check, which you can't do

}
