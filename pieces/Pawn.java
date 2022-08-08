//Timothy Walker tpw32

package pieces;

/**
 * Pawn class, extends Piece
 * @author Timothy Walker
 *
 */
public class Pawn extends Piece {
	
	/**
	 * Status of whether this Pawn has been moved or not
	 */
	Boolean firstMove = true;
	
	/**
	 * Pawn constructor with character parameter to indicate color
	 * @param c color character
	 */
	public Pawn(char c) {
		super(c);

	}

	/**
	 * Returns char 'p' to indicate this Piece is a Pawn
	 * @return char 'p'
	 */
	public char getType() {
    	return 'p';
    }
	
	/**
	 * Fills Pawn's move list with all potential coordinates
	 * @param board game board
	 * @param position coordinates of the Pawn you want to move
	 */
	public void getMoves(Piece[][] board, String position) {
    	moves.clear();
    	  	
    	int i = numToIndex(position.charAt(1));
    	int j = letterToIndex(position.charAt(0));
    	
    	//check if first move
    	if(board[i][j].getColor()=='w') {
    		if(position.charAt(1)!='2') {firstMove = false;}
    	}else {
    		if(position.charAt(1)!='7') {firstMove = false;}
    	}
    	
    	
    	//check if EnPassant
    	if(board[i][j].getColor()=='w' && board[i][j].addEnPassant) {
    		
    		if(i==3 ){
    			
    			if(j+1 <= 7) {
    				if(board[i][j+1]!=null) {
		            	if(board[i][j+1].getColor()!='w'){
		            		moves.add(indexToLetter(j+1)+indexToNum(i-1));
		            	}
    				}
    			}
    			if(j-1 >= 0) {
    				if(board[i][j-1]!=null) {
		            	if(board[i][j-1].getColor()!='w'){
		            		moves.add(indexToLetter(j-1)+indexToNum(i-1));
		            	}
    				}
    			}
    			
    		}
    	}
		else if(board[i][j].getColor()=='b' && board[i][j].addEnPassant) {
			if(i==4){
    			if(j+1 <= 7) {
    				if(board[i][j+1]!=null) {
		            	if(board[i][j+1].getColor()!='b'){
		            		moves.add(indexToLetter(j+1)+indexToNum(i+1));
		            	}
    				}
    			}
    			if(j-1 >= 0) {
    				if(board[i][j-1]!=null) {
		            	if(board[i][j-1].getColor()!='b'){
		            		moves.add(indexToLetter(j-1)+indexToNum(i+1));
		            	}
    				}
    			}
    			
    		}
		}
    	

    	
    	
    	//if Pawn's 1st move
    	if(firstMove) {
    		if (board[i][j].getColor()=='w') {
    			if (board[i-1][j]==null) {
    				moves.add(indexToLetter(j)+indexToNum(i-1));
    				if (board[i-2][j]==null) {
        				moves.add(indexToLetter(j)+indexToNum(i-2));
        			}
    			}
    			
    			//Can take diagonal Left?
    			if(j-1 >= 0){
    				if(board[i-1][j-1] != null) {
    					if(board[i-1][j-1].getColor()=='b') {moves.add(indexToLetter(j-1)+indexToNum(i-1));}
    				}
    			}
    			//Can take diagonal Right?
    			if(j+1 <= 7){
    				if(board[i-1][j+1] != null) {
    					if(board[i-1][j+1].getColor()=='b') {moves.add(indexToLetter(j+1)+indexToNum(i-1));}
    				}
    			}
    			
    		}else {
    			if (board[i+1][j]==null) {
    				moves.add(indexToLetter(j)+indexToNum(i+1));
    				if (board[i+2][j]==null) {
        				moves.add(indexToLetter(j)+indexToNum(i+2));
        			}
    			}
    			
    			//Can take diagonal Left?
				if(j-1 >= 0){
					if(board[i+1][j-1] != null) {
						if(board[i+1][j-1].getColor()=='w') {moves.add(indexToLetter(j-1)+indexToNum(i+1));}
					}
				}
				//Can take diagonal Right?
				if(j+1 <= 7){
					if(board[i+1][j+1] != null) {
						if(board[i+1][j+1].getColor()=='w') {moves.add(indexToLetter(j+1)+indexToNum(i+1));}
					}
				}
    					
    		} 		 		
    	}else {
    		//White Pawn
    		if(board[i][j].getColor()=='w') {
    			//Bounds check
    			if(i-1 >= 0) {
    				//Can move up 1?
    				if (board[i-1][j] == null) {moves.add(indexToLetter(j)+indexToNum(i-1));}
    				//Can take diagonal Left?
    				if(j-1 >= 0){
    					if(board[i-1][j-1] != null) {
    						if(board[i-1][j-1].getColor()=='b') {moves.add(indexToLetter(j-1)+indexToNum(i-1));}
    					}
    				}
    				//Can take diagonal Right?
    				if(j+1 <= 7){
    					if(board[i-1][j+1] != null) {
    						if(board[i-1][j+1].getColor()=='b') {moves.add(indexToLetter(j+1)+indexToNum(i-1));}
    					}
    				}   				
    			}
    		}else {//Black Pawn
    			//Bounds check
    			if(i+1 <= 7) {
    				//Can move up 1?
    				if (board[i+1][j] == null) {moves.add(indexToLetter(j)+indexToNum(i+1));}
    				//Can take diagonal Left?
    				if(j-1 >= 0){
    					if(board[i+1][j-1] != null) {
    						if(board[i+1][j-1].getColor()=='w') {moves.add(indexToLetter(j-1)+indexToNum(i+1));}
    					}
    				}
    				//Can take diagonal Right?
    				if(j+1 <= 7){
    					if(board[i+1][j+1] != null) {
    						if(board[i+1][j+1].getColor()=='w') {moves.add(indexToLetter(j+1)+indexToNum(i+1));}
    					}
    				}   				
    			}
    		}
    	}
    }
}
