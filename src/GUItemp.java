import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GUItemp {

public static void MoveGUIPiece (String indexline, Piece[][] pieces, String moveline) {
	String indexVal;
	Piece fromCharacter;
	
	indexVal = convertMoveToIndex(moveline);
	fromCharacter = Utils.getPieceGUI(Integer.parseInt(String.valueOf(indexVal.charAt(0))), Integer.parseInt(String.valueOf(indexVal.charAt(1))), pieces);
	GUItemp.MoveGUI(pieces,indexVal,fromCharacter,moveline);
	List<List<Piece>> update = Utils.convertArraytoList(pieces);
	Utils.copy(pieces, GUItemp.convertFilePieces(update));
}
	
public static String inputMove() { //converts mouse input into move
	String row = "20"; //default
	String column = "20"; //default
	double addValue = 0.077;

//column:
		if( (StdDraw.mouseX() > 0.01) && (StdDraw.mouseX() < 0.087) ) {
			column = "a";
		}
		else if((StdDraw.mouseX() > (0.01+addValue)) && (StdDraw.mouseX() < (0.087+addValue))) {
			column = "b";
		}
		else if((StdDraw.mouseX() > (0.01+(2*addValue))) && (StdDraw.mouseX() < (0.087+(2*addValue)))) {
			column = "c";
		}
		else if((StdDraw.mouseX() > (0.01+(3*addValue))) && (StdDraw.mouseX() < (0.087+(3*addValue)))) {
			column = "d";
		}
		else if((StdDraw.mouseX() > (0.01+(4*addValue))) && (StdDraw.mouseX() < (0.087+(4*addValue)))) {
			column = "e";
		}
		else if((StdDraw.mouseX() > (0.01+(5*addValue))) && (StdDraw.mouseX() < (0.087+(5*addValue)))) {
			column = "f";
		}
		else if((StdDraw.mouseX() > (0.01+(6*addValue))) && (StdDraw.mouseX() < (0.087+(6*addValue)))) {
			column = "g";
		}
		else if((StdDraw.mouseX() > (0.01+(7*addValue))) && (StdDraw.mouseX() < (0.087+(7*addValue)))) {
			column = "h";
		}
		else if((StdDraw.mouseX() > (0.01+(8*addValue))) && (StdDraw.mouseX() < (0.087+(8*addValue)))) {
			column = "i";
		}
		else if((StdDraw.mouseX() > (0.01+(9*addValue))) && (StdDraw.mouseX() < (0.087+(9*addValue)))) {
			column = "j";
		}
		
//row:
		if( (StdDraw.mouseY() > 0.01) && (StdDraw.mouseY() < 0.087) ) {
			row = "1";
		}
		else if((StdDraw.mouseY() > (0.01+addValue)) && (StdDraw.mouseY() < (0.087+addValue))) {
			row = "2";
		}
		else if((StdDraw.mouseY() > (0.01+(2*addValue))) && (StdDraw.mouseY() < (0.087+(2*addValue)))) {
			row = "3";
		}
		else if((StdDraw.mouseY() > (0.01+(3*addValue))) && (StdDraw.mouseY() < (0.087+(3*addValue)))) {
			row = "4";
		}
		else if((StdDraw.mouseY() > (0.01+(4*addValue))) && (StdDraw.mouseY() < (0.087+(4*addValue)))) {
			row = "5";
		}
		else if((StdDraw.mouseY() > (0.01+(5*addValue))) && (StdDraw.mouseY() < (0.087+(5*addValue)))) {
			row = "6";
		}
		else if((StdDraw.mouseY() > (0.01+(6*addValue))) && (StdDraw.mouseY() < (0.087+(6*addValue)))) {
			row = "7";
		}
		else if((StdDraw.mouseY() > (0.01+(7*addValue))) && (StdDraw.mouseY() < (0.087+(7*addValue)))) {
			row = "8";
		}
		else if((StdDraw.mouseY() > (0.01+(8*addValue))) && (StdDraw.mouseY() < (0.087+(8*addValue)))) {
			row = "9";
		}
		else if((StdDraw.mouseY() > (0.01+(9*addValue))) && (StdDraw.mouseY() < (0.087+(9*addValue)))) {
			row = "10";
		}
		
	if( (StdDraw.mouseY()>(0.01)&&(StdDraw.mouseY()<(0.21))) && (StdDraw.mouseX()>(0.8)&&(StdDraw.mouseX()<(0.99))) ) {// promotion/check/castling move
			
		String typeMove = GUItemp.DialogBox("Enter move type" +"\n promotion: type 'p' " + "\n castling: type 'c' " + "\n check: type 'ch' " +"\n undo: type 'u' "+"\n redo: type 'r' " ,"Move type chosen: ", false);
			
			if(typeMove.compareTo("p")==0) {//promotion
				String movePromotion = GUItemp.DialogBox("Enter your promotion move " + "\n e.g. e9-e8=d", "Your move is: ", false);
				return movePromotion;
			}
			else if(typeMove.compareTo("c")==0) {//castling
				String moveCastling = GUItemp.DialogBox("Enter your castling move " + "\n queenside: type '0-0-0'" + "\n kingside: type '0-0'", "Your move is: ", false);
				return moveCastling;
			}
			else if(typeMove.compareTo("ch")==0) {//check
				String moveCheck = GUItemp.DialogBox("Enter your check move " + "\n e.g. a8-a7+", "Your move is: ", false);
				return moveCheck;
			}
			else if(typeMove.compareTo("u")==0) {//undo
				if(ScannerInput.counterMove==0) {
					return null; //no moves in file
				}else {
					try {
						return FairyChess.movesFile.get(ScannerInput.counterMove-1); //move present
					}
					catch(Exception e){
						return null;
					}	
				}
			}
			else if(typeMove.compareTo("r")==0) {//redo
				if(ScannerInput.counterMove==0) {
					return null; //no moves in file
				}else {
					try {
						return FairyChess.movesFile.get(ScannerInput.counterMove+1); //move present
					}
					catch(Exception e){
						return null;
					}	
				}
			}
			else {
				String invalidInput = GUItemp.DialogBox("Invalid move" + "\n To continue type: 'ok' ", "You typed: ", false);
				
				while(invalidInput.compareTo("ok")!=0) {
					String tryAgain = GUItemp.DialogBox("To continue type: 'ok' ", "You typed: ", false);
					invalidInput = tryAgain;
				}
				
			}
	}
			
	 if( (row.compareTo("20")==0)||(column.compareTo("20")==0) ) { // text move
		 String input = GUItemp.DialogBox("Enter the move: (e.g. a9-a8)","Your move is ", true);
		 return input;
	 }

	String move = column+row;
	return move;
}

public static String convertMoveToIndex(String moveline) { // returns index in form String = (fromRow)+(fromCol)+(toRow)+(toCol)
String fromrowMove;
String fromcolMove;
String torowMove;
String tocolMove;
String indexMove;

//'to' position
	if(isFromRow10(moveline)) {
		torowMove = moveline.substring(5,moveline.length());
		tocolMove = String.valueOf(moveline.charAt(4));
	}
	else {
		torowMove = moveline.substring(4,moveline.length());
		tocolMove = String.valueOf(moveline.charAt(3));
	}
	
//'from' position 	
	if(isFromRow10(moveline)) {
		fromrowMove = moveline.substring(1,3);
		fromcolMove = String.valueOf(moveline.charAt(0));
	}
	else {
		fromrowMove = String.valueOf(moveline.charAt(1));
		fromcolMove = String.valueOf(moveline.charAt(0));
	}

	
String alphabet = "a,b,c,d,e,f,g,h,i,j";
String numbers = "1,2,3,4,5,6,7,8,9,10";
String[] lettersArray = alphabet.split(",");
String[] numbersArray = numbers.split(",");

String indexfromRow = null;
String indexfromCol = null;
String indextoRow = null;
String indextoCol = null;

//find FROM
//column
for(int f = 0; f < 10; f++) {
	if(fromcolMove.compareTo(lettersArray[f])==0) {
		int value = Integer.parseInt(numbersArray[f])-1;
		indexfromCol = String.valueOf(value);
	}
}
//row
for(int g = 0; g < numbersArray.length; g++) {
	
	if(fromrowMove.compareTo(numbersArray[g])==0) {
		int value = Integer.parseInt(numbersArray[numbersArray.length-1])-(g+1);
		indexfromRow = String.valueOf(value);
	}
}

//find TO
//column
for(int f = 0; f < 10; f++) {
	if(tocolMove.compareTo(lettersArray[f])==0) {
		int value = Integer.parseInt(numbersArray[f])-1;
		indextoCol = String.valueOf(value);
	}
}
//row
for(int g = 0; g < 10; g++) {
	if(torowMove.compareTo(numbersArray[g])==0) {
		int value = Integer.parseInt(numbersArray[numbersArray.length-1])-(g+1);
		indextoRow = String.valueOf(value);
	}
}

indexMove = indexfromRow + indexfromCol + indextoRow + indextoCol;
return indexMove;
	
	
}

public static Move GUIMove(String moveline) { 

boolean isKingSideCastling = false;
boolean isQueenSideCastling = false;
boolean isPromotionGUImove = false;
String PromoteToPlayer = "z"; //default

        String delimiter;
        if (moveline.lastIndexOf('x') > 0) {
            delimiter = "x";
        } else {
            delimiter = "-";
        }
        
        //Promotion move
        if(moveline.lastIndexOf('=')>0) {
        	isPromotionGUImove = true;
        	PromoteToPlayer = String.valueOf(moveline.charAt(moveline.lastIndexOf('=')+1));
        }
        
        //Castling move
        if(moveline.equals("0-0") ){
          	 isKingSideCastling = true;
           }
           else if(moveline.equals("0-0-0") ){
          	 isQueenSideCastling = true;
           }

        //String [] of positions (start) then (destination)
        String[] positions;


        int fromRow;
        int toRow;
        int fromColumn;
        int toColumn;
        char fromAlphaCharacter;
        char toAlphaCharacter;
        int fromRowRook = 10; // no row 10; if not pick-up is Queen/King Castling
        int toRowRook = 10; // no row 10; if not pick-up is Queen/King Castling
        int fromColRook = 11; // no column 11; if not pick-up is Queen/King Castling
        int toColRook = 11; // no column 11; if not pick-up is Queen/King Castling

        //String [] of positions (start) then (destination)
        positions = moveline.split(delimiter);


        if( (isKingSideCastling == true) && (Board.currentPlayer == PlayerType.BLACK)){
        	fromRow = 0;
            toRow = 0;

            fromRowRook = 0;
            toRowRook = 0;

            fromColRook = Utils.columnPosition('j');
            toColRook = Utils.columnPosition('h');

            fromAlphaCharacter = 'f';
            toAlphaCharacter = 'i';

            fromColumn = Utils.columnPosition(fromAlphaCharacter);
            toColumn = Utils.columnPosition(toAlphaCharacter);

        } else if((isKingSideCastling == true) && (Board.currentPlayer == PlayerType.WHITE)){
        	fromRow = 9;
            toRow = 9;

            fromRowRook = 9;
            toRowRook = 9;

            fromColRook = Utils.columnPosition('j');
            toColRook = Utils.columnPosition('h');

            fromAlphaCharacter = 'f';
            toAlphaCharacter = 'i';

            fromColumn = Utils.columnPosition(fromAlphaCharacter);
            toColumn = Utils.columnPosition(toAlphaCharacter);

        } else if( ((isQueenSideCastling) && (Board.currentPlayer == PlayerType.BLACK)) ){
        	fromRow = 0;
            toRow = 0;

            fromRowRook = 0;
            toRowRook = 0;

            fromColRook = Utils.columnPosition('a');
            toColRook = Utils.columnPosition('d');

            fromAlphaCharacter = 'f';
            toAlphaCharacter = 'c';

            fromColumn = Utils.columnPosition(fromAlphaCharacter);
            toColumn = Utils.columnPosition(toAlphaCharacter);

        } else if(((isQueenSideCastling) && (Board.currentPlayer == PlayerType.WHITE)) ){

        	fromRow = 9;
            toRow = 9;

            fromRowRook = 9;
            toRowRook = 9;

            fromColRook = Utils.columnPosition('a');
            toColRook = Utils.columnPosition('d');

            fromAlphaCharacter = 'f';
            toAlphaCharacter = 'c';

            fromColumn = Utils.columnPosition(fromAlphaCharacter);
            toColumn = Utils.columnPosition(toAlphaCharacter);

        } else { // normal move

            try {
                fromRow = Utils.reverseConV(Integer.parseInt(positions[0].substring(1)) );
            } catch (Exception e) {
                int equalsPosition = positions[0].indexOf('=');
                int checkPosition = positions[0].indexOf('+');
                int capturePosition = positions[0].indexOf('x');

                if(equalsPosition > 0) {
                    fromRow = Utils.reverseConV(Integer.parseInt(positions[0].substring(1, equalsPosition)));
                } else if(checkPosition > 0){
                    fromRow = Utils.reverseConV(Integer.parseInt(positions[0].substring(1, checkPosition)));
                } else {
                    fromRow = Utils.reverseConV(Integer.parseInt(positions[0].substring(1, capturePosition)));
                }
            }

            try {
                toRow = Utils.reverseConV(Integer.parseInt(positions[1].substring(1)) );
            } catch (Exception e) {
                int equalsPosition = positions[1].indexOf('=');
                int checkPosition = positions[1].indexOf('+');
                int capturePosition = positions[1].indexOf('x');

                if(equalsPosition > 0) {
                    toRow = Utils.reverseConV(Integer.parseInt(positions[1].substring(1, equalsPosition)));
                } else if(checkPosition > 0){
                    toRow = Utils.reverseConV(Integer.parseInt(positions[1].substring(1, checkPosition)));
                } else {
                    toRow = Utils.reverseConV(Integer.parseInt(positions[1].substring(1, capturePosition)));
                }

            }

             //first move's start column (alphabet)
             fromAlphaCharacter = positions[0].charAt(0);
             //first move's destination column (alphabet)
             toAlphaCharacter = positions[1].charAt(0);


             //convert to integer
             fromColumn = Utils.columnPosition(fromAlphaCharacter);
             toColumn = Utils.columnPosition(toAlphaCharacter);
        }


        Move m = null;

        // IF Move is a Promotion/Capture/Normal Move
        if(moveline.lastIndexOf('=') > 0) {

            PieceType pt = null;
            switch (moveline.split("=")[1].toUpperCase()) {
                case "K": pt = PieceType.KING;
                case "Q": pt = PieceType.QUEEN;
                case "A": pt = PieceType.AMAZON;
                case "P": pt = PieceType.PAWN;
                case "B": pt = PieceType.BISHOP;
                case "F": pt = PieceType.DRAGON;
                case "R": pt = PieceType.ROOK;
                case "N": pt = PieceType.KNIGHT;
                case "E": pt = PieceType.ELEPHANT;
                case "W": pt = PieceType.PRINCESS;
                case "D": pt = PieceType.DRUNKED_PAWN;
                case ".": pt = PieceType.SPACE;

            }
            m = new Move(new Position(fromColumn, fromRow), new Position(toColumn, toRow), pt, true);
        } else if (moveline.lastIndexOf('x') > 0) {
//        	System.out.print("Reach E");

            int checkIndex = moveline.lastIndexOf("+");

            boolean isCheck = false;
            boolean isCheckMate = false;

            if (checkIndex == 5) {

                isCheck = true;
            } else if (checkIndex == 6) {

                isCheck = true;
                isCheckMate = true;
            }
            m = new Move(new Position(fromColumn, fromRow), new Position(toColumn, toRow), true, isCheck, isCheckMate);
        } else if(isKingSideCastling || isQueenSideCastling) {

                if(isQueenSideCastling){ // IS Queen side
                    m = new Move(new Position(fromColumn, fromRow), new Position(toColumn, toRow), false, true, true, false);
                } else { // IS King side
                    m = new Move(new Position(fromColumn, fromRow), new Position(toColumn, toRow), false, true, false, true);
                }
            } else {
                    int checkIndex = moveline.lastIndexOf("+");
                    boolean isCheck = false;
                    boolean isCheckMate = false;

                    if (checkIndex == 5) {
//                    	System.out.print(" Reach A ");
                        isCheck = true;
                    } else if (checkIndex == 6) {
//                     	System.out.print(" Reach B ");
                        isCheck = true;
                        isCheckMate = true;
                    }
                    m = new Move(new Position(fromColumn, fromRow), new Position(toColumn, toRow), isCheck, isCheckMate);
                }

                if(!(isKingSideCastling || isQueenSideCastling)) {
                    return m;
                }

        return m;
}	

public static String DialogBox(String title, String yourmove, boolean useSecond) {//text move
	String str = new String();
	str = JOptionPane.showInputDialog(null,title);
	
	if(useSecond) {
		JOptionPane.showMessageDialog(null, yourmove + str);
	}
	
	return str;
}


public static String moveSymbol(Piece [][] pieces, String move) {
	String indexline = MoveToIndex(move);
	String symbol;
	System.out.println("indexline is "+indexline);
	int toRow = Integer.parseInt(String.valueOf(indexline.charAt(2)));
	int toCol = Integer.parseInt(String.valueOf(indexline.charAt(3)));
	
	if(pieces[toRow][toCol].getType() != PieceType.SPACE) {
		symbol = "x";
	}
	else {
		symbol = "-";
	}

	System.out.println(symbol);
	return symbol;
}
	
public static String MouseGUIMove() { //converts mouse input into move
	String row;
	String column;
	String indexline;
	String symbol;
	double addValue = 0.077;

	//column:
			if( (StdDraw.mouseX() > 0.01) && (StdDraw.mouseX() < 0.087) ) {
				column = "a";
			}
			else if((StdDraw.mouseX() > (0.01+addValue)) && (StdDraw.mouseX() < (0.087+addValue))) {
				column = "b";
			}
			else if((StdDraw.mouseX() > (0.01+(2*addValue))) && (StdDraw.mouseX() < (0.087+(2*addValue)))) {
				column = "c";
			}
			else if((StdDraw.mouseX() > (0.01+(3*addValue))) && (StdDraw.mouseX() < (0.087+(3*addValue)))) {
				column = "d";
			}
			else if((StdDraw.mouseX() > (0.01+(4*addValue))) && (StdDraw.mouseX() < (0.087+(4*addValue)))) {
				column = "e";
			}
			else if((StdDraw.mouseX() > (0.01+(5*addValue))) && (StdDraw.mouseX() < (0.087+(5*addValue)))) {
				column = "f";
			}
			else if((StdDraw.mouseX() > (0.01+(6*addValue))) && (StdDraw.mouseX() < (0.087+(6*addValue)))) {
				column = "g";
			}
			else if((StdDraw.mouseX() > (0.01+(7*addValue))) && (StdDraw.mouseX() < (0.087+(7*addValue)))) {
				column = "h";
			}
			else if((StdDraw.mouseX() > (0.01+(8*addValue))) && (StdDraw.mouseX() < (0.087+(8*addValue)))) {
				column = "i";
			}
			else if((StdDraw.mouseX() > (0.01+(9*addValue))) && (StdDraw.mouseX() < (0.087+(9*addValue)))) {
				column = "j";
			}
			else {
				column = "z";
		}
			
	//row:
			if( (StdDraw.mouseY() > 0.01) && (StdDraw.mouseY() < 0.087) ) {
				row = "1";
			}
			else if((StdDraw.mouseY() > (0.01+addValue)) && (StdDraw.mouseY() < (0.087+addValue))) {
				row = "2";
			}
			else if((StdDraw.mouseY() > (0.01+(2*addValue))) && (StdDraw.mouseY() < (0.087+(2*addValue)))) {
				row = "3";
			}
			else if((StdDraw.mouseY() > (0.01+(3*addValue))) && (StdDraw.mouseY() < (0.087+(3*addValue)))) {
				row = "4";
			}
			else if((StdDraw.mouseY() > (0.01+(4*addValue))) && (StdDraw.mouseY() < (0.087+(4*addValue)))) {
				row = "5";
			}
			else if((StdDraw.mouseY() > (0.01+(5*addValue))) && (StdDraw.mouseY() < (0.087+(5*addValue)))) {
				row = "6";
			}
			else if((StdDraw.mouseY() > (0.01+(6*addValue))) && (StdDraw.mouseY() < (0.087+(6*addValue)))) {
				row = "7";
			}
			else if((StdDraw.mouseY() > (0.01+(7*addValue))) && (StdDraw.mouseY() < (0.087+(7*addValue)))) {
				row = "8";
			}
			else if((StdDraw.mouseY() > (0.01+(8*addValue))) && (StdDraw.mouseY() < (0.087+(8*addValue)))) {
				row = "9";
			}
			else if((StdDraw.mouseY() > (0.01+(9*addValue))) && (StdDraw.mouseY() < (0.087+(9*addValue)))) {
				row = "10";
			}
			else {
				row = "11";
		}
		return column+row;
	}

	
public static String colourReplace(String moveline, boolean isFrom) { //use??
	boolean colUneven;
	boolean rowUneven;
	String colour;
	
	if(isFrom) {
	//is col even or uneven
		System.out.println(moveline.charAt(0));
	if((moveline.charAt(0) == 'a') || (moveline.charAt(0) == 'c') || (moveline.charAt(0) == 'e') || (moveline.charAt(0) == 'g') || (moveline.charAt(0) == 'i') ) {
		colUneven = true;
	}
	else {
		colUneven = false;
	}
	//is row even or uneven
	System.out.println(Integer.parseInt(String.valueOf(moveline.charAt(1)))%2);
	if(Integer.parseInt(String.valueOf(moveline.charAt(1)))%2==0) {
		rowUneven = false;
	}
	else {
		rowUneven = true;
	}
	} 
	
	else { //'to' position
	//is fromRow 10	
	int rowindex;
	char colindex;
		if(isFromRow10(moveline)) {
			rowindex = Integer.parseInt(moveline.substring(5,moveline.length()));
			colindex = moveline.charAt(4);
		}
		else {
			rowindex = Integer.parseInt(moveline.substring(4,moveline.length()));
			colindex = moveline.charAt(3);
		}
		
	//is col even or uneven	
		if((colindex == 'a') || (colindex == 'c') || (colindex == 'e') || (colindex == 'g') || (colindex == 'i') ) {
			colUneven = true;
		}
		else {
			colUneven = false;
		}
		//is row even or uneven
		if(rowindex%2==0) {
			rowUneven = false;
		}
		else {
			rowUneven = true;
		}	
	}
	
	//set color
	if( (colUneven&&rowUneven) || (rowUneven&&colUneven)) {
		colour = "WHITE";
	}
	else {
		colour = "BOOK_BLUE";
	}
	
	return colour;
}


public static List<List<Piece>> updateGUIMatrix(List<List<Piece>> pieces, String indexline) { //returns updated List matrix after move
int fromRow = Integer.parseInt(String.valueOf(indexline.charAt(0)));
int fromCol = Integer.parseInt(String.valueOf(indexline.charAt(1)));
int toRow = Integer.parseInt(String.valueOf(indexline.charAt(2)));
int toCol = Integer.parseInt(String.valueOf(indexline.charAt(3)));

Piece value = pieces.get(fromRow).get(fromCol);
pieces.get(fromRow).set(fromCol, pieces.get(toRow).get(toCol));

return pieces;		
}


public static String PieceToFilename(Piece piece) {
	String file;
	
	if(piece.owner.equals(PlayerType.BLACK)) {//bird
		file = "birds/";
		if(piece.type.equals(PieceType.AMAZON)) {	
			file = file + "birdamazon.png";
		}
		else if(piece.type.equals(PieceType.BISHOP)) {
			file = file + "birdbishop.png";
		}
		else if(piece.type.equals(PieceType.DRAGON)) {
			file = file + "birddragon.png";
		}
		else if(piece.type.equals(PieceType.DRUNKED_PAWN)) {
			file = file + "birddrunken.png";
		}
		else if(piece.type.equals(PieceType.ELEPHANT)) {
			//TODO: make elephant
			file = file + "birdelephant.jpg";
		}
		else if(piece.type.equals(PieceType.KING)) {
			file = file + "birdking.png";
		}
		else if(piece.type.equals(PieceType.KNIGHT)) {
			file = file + "birdknight.png";
		}
		else if(piece.type.equals(PieceType.PAWN)) {
			file = file +"birdpawn.png";
		}
		else if(piece.type.equals(PieceType.PRINCESS)) {
			file = file + "birdprincess.png";
		}
		else if(piece.type.equals(PieceType.QUEEN)) {
			file = file + "birdqueen.png";
		}
		else if(piece.type.equals(PieceType.ROOK)) {
			file = file + "birdrook.png";
		}
		
	}
	else {
		file = "pigs/";
		if(piece.type.equals(PieceType.AMAZON)) {
			//TODO: make amazon 
			file = file + "pigamazon.png";
		}
		else if(piece.type.equals(PieceType.BISHOP)) {
			file = file + "pigbishop.png";
		}
		else if(piece.type.equals(PieceType.DRAGON)) {
			//TODO: make dragon
			file = file + "pigdragon.png";
		}
		else if(piece.type.equals(PieceType.DRUNKED_PAWN)) {
			file = file + "pigdrunken.png";
		}
		else if(piece.type.equals(PieceType.ELEPHANT)) {
			//TODO: make elephant
			file = file + "pigelephant.png";
		}
		else if(piece.type.equals(PieceType.KING)) {
			file = file + "pigking.png";
		}
		else if(piece.type.equals(PieceType.KNIGHT)) {
			file = file + "pigknight.png";
		}
		else if(piece.type.equals(PieceType.PAWN)) {
			file = file + "pigpawn.png";
		}
		else if(piece.type.equals(PieceType.PRINCESS)) {
			file = file +"pigprincess.png";
		}
		else if(piece.type.equals(PieceType.QUEEN)) {
			file = file + "pigqueen.png";
		}
		else if(piece.type.equals(PieceType.ROOK)) {
			file = file + "pigrook.png";
		}
	}
	return file;
}


public static Piece [][] updatedGUIMatrix(Piece[][] pieces, String indexlineUpdate){//returns updated GUI matrix in 2D array form
	Piece [][] Replace = new Piece[10][10];
	
	int fromRow = Integer.parseInt(String.valueOf(indexlineUpdate.charAt(0)));
	int fromCol = Integer.parseInt(String.valueOf(indexlineUpdate.charAt(1)));
	int toRow = Integer.parseInt(String.valueOf(indexlineUpdate.charAt(2)));
	int toCol = Integer.parseInt(String.valueOf(indexlineUpdate.charAt(3)));
	Piece Character = pieces[fromRow][fromCol];
	
	for(int f = 0; f < pieces.length; f++) {
		for(int g = 0; g < pieces.length; g++) {
			
			if((fromRow==f)&&(fromCol==g)) {
				Replace[f][g].type = PieceType.SPACE;
				Replace[f][g].owner = PlayerType.NOT_SET;	
			}
			else if((toRow==f)&&(toCol==g)) {
				Replace[f][g].type = Character.type;
				Replace[f][g].owner = Character.owner;
			}
			else {
				Replace[f][g] = pieces[f][g];
			}
		}
		
	}

	return Replace;
}


public static void MoveGUI(Piece[][] arrayBoard, String indexMove, Piece Character, String move) {
		
	for(int c = 0; c < arrayBoard.length; c++) {
		for(int d = 0; d < arrayBoard.length; d++) {
			if(arrayBoard[c][d].getType().equals(Character.type)) {
					
				String indexString = String.valueOf(c)+String.valueOf(d);
				if(indexMove.substring(0,2).compareTo(indexString) == 0) {
						
				//is 'to' position occupied 
				boolean isCaptureGUI = false;
				if(arrayBoard[Integer.parseInt(String.valueOf(indexMove.charAt(2)))][Integer.parseInt(String.valueOf(indexMove.charAt(3)))].getType() != PieceType.SPACE) {
				isCaptureGUI = true;
				}
				
				//DO MOVE in GUI
				String toCol = String.valueOf(move.charAt(3));
				String fromCol = String.valueOf(move.charAt(0));
				String toRow = String.valueOf(move.charAt(4));
				String fromRow = String.valueOf(move.charAt(1));
						
				//draw 'from' square
				if(colourReplace(move, true)=="BOOK_BLUE") {
				StdDraw.setPenColor(StdDraw.BOOK_BLUE);	
				}
				else {
				StdDraw.setPenColor(StdDraw.WHITE);
				}
						
				StdDraw.filledSquare(toGuiMove_Column(fromCol),toGuiMove_Row(fromRow), 0.0385);
						
				//draw 'to' square if capture move
				if(isCaptureGUI) {
				//draw 'from' square
				StdDraw.filledSquare(toGuiMove_Row(toRow), toGuiMove_Column(toCol), 0.0385);
				//draw 'to' square
				if(colourReplace(move, false)=="BOOK_BLUE") {
				StdDraw.setPenColor(StdDraw.BOOK_BLUE);	
				}else {
				StdDraw.setPenColor(StdDraw.WHITE);
				}
				StdDraw.filledSquare( toGuiMove_Column(toCol),toGuiMove_Row(toRow), 0.0385);
				}
						
				//add piece on 'to' position
				StdDraw.picture(toGuiMove_Column(toCol),toGuiMove_Row(toRow), String.valueOf(Paths.get("Pictures/Pieces/"+ PieceToFilename(Character)).toAbsolutePath()), 0.07, 0.07);
				}
			}
		}
			
	}	
}

	
public static void GUIStatusline(String type, boolean blackQueen, boolean blackKing, boolean whiteQueen, boolean whiteKing, int halfmove, int movecount){
StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
StdDraw.filledRectangle(xMidCoord(0.75,1.04), yMidCoord(0.1,0.3), 0.08622, 0.014);//cover previous player allocation

//PLAYER TYPE
if(type.compareTo("w")==0) {//player white
	StdDraw.picture(xMidCoord(0.73,0.92), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/pig.png").toAbsolutePath()), 0.03, 0.03);
}
else if(type.compareTo("b")==0){//black
	StdDraw.picture(xMidCoord(0.73,0.92), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/bird.png").toAbsolutePath()), 0.03, 0.03);
}

//SEPERATER 
StdDraw.picture(xMidCoord(0.747,0.937), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/doubledot.png").toAbsolutePath()), 0.01, 0.02);


//CASTLING STATUS
//blackQueen
if(blackQueen) {
	StdDraw.picture(xMidCoord(0.76,0.95), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/plus.png").toAbsolutePath()), 0.02, 0.02);
}
else {
	StdDraw.picture(xMidCoord(0.76,0.95), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/minus.png").toAbsolutePath()), 0.02, 0.02);
}
//blackKing
if(blackKing) {
	StdDraw.picture(xMidCoord(0.775,0.965), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/plus.png").toAbsolutePath()), 0.02, 0.02);
}
else {
	StdDraw.picture(xMidCoord(0.775,0.965), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/minus.png").toAbsolutePath()), 0.02, 0.02);
}
//whiteQueen
if(whiteQueen) {
	StdDraw.picture(xMidCoord(0.79,0.98), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/plus.png").toAbsolutePath()), 0.02, 0.02);
}
else {
	StdDraw.picture(xMidCoord(0.79,0.98), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/minus.png").toAbsolutePath()), 0.02, 0.02);
}
//whiteKing
if(whiteKing) {
	StdDraw.picture(xMidCoord(0.805,0.995), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/plus.png").toAbsolutePath()), 0.02, 0.02);
}
else {
	StdDraw.picture(xMidCoord(0.805,0.995), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/minus.png").toAbsolutePath()), 0.02, 0.02);
}

//SEPERATER
StdDraw.picture(xMidCoord(0.8156,1.0056), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/doubledot.png").toAbsolutePath()), 0.01, 0.02);

//HALFMOVE COUNT
String number = "0,1,2,3,4,5,6,7,8,9,10";
String[] num = number.split(",");
String word = "zero,one,two,three,four,five,six,seven,eight,nine,ten";
String[] wordform = word.split(",");

//check if it is a double value

	for(int n = 0; n < num.length; n++) {
		if(String.valueOf(halfmove).compareTo(num[n])==0) {
			if(num[n].compareTo("10")==0) {
				StdDraw.picture(xMidCoord(0.826,1.016), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/one.png").toAbsolutePath()), 0.02, 0.02);
				StdDraw.picture(xMidCoord(0.847,1.017), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/zero.png").toAbsolutePath()), 0.02, 0.02);
			}
			else {
				StdDraw.picture(xMidCoord(0.826,1.016), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/"+wordform[n]+".png").toAbsolutePath()), 0.02, 0.02);
			}
		}
	}

//SEPERATER
StdDraw.picture(xMidCoord(0.8594,1.0294), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/doubledot.png").toAbsolutePath()), 0.01, 0.02);

//MOVE COUNT
	for(int n = 0; n < num.length; n++) {
		if(String.valueOf(movecount).compareTo(num[n])==0) {
			if(num[n].compareTo("10")==0) {
				StdDraw.picture(xMidCoord(0.869,1.039), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/one.png").toAbsolutePath()), 0.02, 0.02);
				StdDraw.picture(xMidCoord(0.89,1.04), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/zero.png").toAbsolutePath()), 0.02, 0.02);
			}
			else {
				StdDraw.picture(xMidCoord(0.869,1.039), yMidCoord(0.1,0.3), String.valueOf(Paths.get("Pictures/Statusline/"+wordform[n]+".png").toAbsolutePath()), 0.02, 0.02);
			}
		}
	}


}	

public static void GUIPieceAllocations(char[] pieces, char[] allocations) {
String pieceAlphabet = "k,r,q,n,b,p,d,f,e,a,w";	
String pieceValue = "King,Rook,Queen,Knight,Bishop,Pawn,Drunken,Dragon,Elephant,Amazon,Princess";
String pieceNumber = "0,1,2,3,4,5,6,7,8,9";
String Number = "zero,one,two,three,four,five,six,seven,eight,nine";
String [] pieceNum = pieceNumber.split(",");
String [] numValue = Number.split(",");
String[] alphabet = pieceAlphabet.split(",");
String[] value = pieceValue.split(",");

double position = 0.0;
for(int q = 0; q < alphabet.length; q++) {
	for(int r = 0; r < alphabet.length; r++) {
		
		if((String.valueOf(pieces[q]).compareTo(alphabet[r])==0)) {
			StdDraw.picture(xMidCoord(0.756,0.946), yMidCoord(0.54+position,0.74+position), String.valueOf(Paths.get("Pictures/Statusline/"+value[r]+".png").toAbsolutePath()), 0.075, 0.04);
			StdDraw.picture(xMidCoord(0.813,1.013), yMidCoord(0.54+position,0.74+position), String.valueOf(Paths.get("Pictures/Statusline/multiply.png").toAbsolutePath()), 0.02, 0.03);
			position -= 0.045;
		}
		
	}
}

position = 0.0;
for(int q = 0; q < pieceNum.length; q++) {
	for(int r = 0; r < pieceNum.length; r++) {

		if((String.valueOf(allocations[q]).compareTo(pieceNum[r])==0)) {
		StdDraw.picture(xMidCoord(0.844,1.054), yMidCoord(0.54+position,0.74+position), String.valueOf(Paths.get("Pictures/Statusline/"+numValue[r]+".png").toAbsolutePath()), 0.02, 0.03);
		position -= 0.045;
		}
		
	}
}


}


public static String ChooseWallpaper(int number) {//use??
		//TODO: add function where can choose wallpaper 
		String get;
		if(number == 1) {
			get = "Wallpaper1.jpg";
		}
		else if(number == 2) {
			get = "Wallpaper2.jpg";	
		}
		else {
			get = "Wallpaper3.jpg";
		}
		
		return get;
	}	

public static Piece[][] convertFilePieces(List<List<Piece>> boardasPieces){ //converts Piece 2D List to Piece 2D array
	Piece [][] boardGUI = new Piece[10][10];
	
	for(int h = 0; h < boardasPieces.size(); h++) {
		List<Piece> row = boardasPieces.get(h);
		
		Piece[] type = new Piece[row.size()];
		for(int i = 0; i < row.size(); i++) {
			type[i] = row.get(i);
		}
		boardGUI[h] = type;
	}
	
	return boardGUI;
	
}


public static double xMidCoord(double firstxCord, double secondxCord) { //gets middle value of two double values
	double xMid = firstxCord + (secondxCord-firstxCord)/2;
	return xMid;
}


public static double yMidCoord(double firstyCord, double secondyCord) { //gets middle value of two double values
	double yMid = firstyCord + (secondyCord - firstyCord)/2;
	return yMid;
}


//if return -1: value entered incorrectly
public static double toGuiMove_Column(String moveVal) {
		double value;
		double a = 0.077;
		
		String sequence = "a,b,c,d,e,f,g,h,i,j";
		String[] val = sequence.split(",");
		
		if((moveVal).compareTo(val[0])==0) {
			value = xMidCoord(0.01,0.087);
		}
		else if((moveVal).compareTo(val[1])==0) {
			value = xMidCoord(0.01+a,0.087+a);
		}
		else if((moveVal).compareTo(val[2])==0) {
			value = xMidCoord(0.01+(2*a),0.087+(2*a));
		}
		else if((moveVal).compareTo(val[3])==0) {
			value = xMidCoord(0.01+(3*a),0.087+(3*a));
		}
		else if((moveVal).compareTo(val[4])==0) {
			value = xMidCoord(0.01+(4*a),0.087+(4*a));
		}
		else if((moveVal).compareTo(val[5])==0) {
			value = xMidCoord(0.01+(5*a),0.087+(5*a));
		}
		else if((moveVal).compareTo(val[6])==0) {
			value = xMidCoord(0.01+(6*a),0.087+(6*a));
		}
		else if((moveVal).compareTo(val[7])==0) {
			value = xMidCoord(0.01+(7*a),0.087+(7*a));
		}
		else if((moveVal).compareTo(val[8])==0) {
			value = xMidCoord(0.01+(8*a),0.087+(8*a));
		}
		else if((moveVal).compareTo(val[9])==0) {
			value = xMidCoord(0.01+(9*a),0.087+(9*a));
		}
		else {
			value = -1;
		}
		return value;
}


//if return -1: value entered incorrectly
public static double toGuiMove_Row(String moveVal) {
	double value;
	double b = 0.077;
	String sequence = "10,9,8,7,6,5,4,3,2,1";
	String[] val = sequence.split(",");
	
	if((moveVal).compareTo(val[0])==0) {
		value = yMidCoord(0.703,0.78);
	}
	else if((moveVal).compareTo(val[1])==0) {
		value = yMidCoord(0.703-b,0.78-b);
	}
	else if((moveVal).compareTo(val[2])==0) {
		value = yMidCoord(0.703-(2*b),0.78-(2*b));
	}
	else if((moveVal).compareTo(val[3])==0) {
		value = yMidCoord(0.703-(3*b),0.78-(3*b));
	}
	else if((moveVal).compareTo(val[4])==0) {
		value = yMidCoord(0.703-(4*b),0.78-(4*b));
	}
	else if((moveVal).compareTo(val[5])==0) {
		value = yMidCoord(0.703-(5*b),0.78-(5*b));
	}
	else if((moveVal).compareTo(val[6])==0) {
		value = yMidCoord(0.703-(6*b),0.78-(6*b));
	}
	else if((moveVal).compareTo(val[7])==0) {
		value = yMidCoord(0.703-(7*b),0.78-(7*b));
	}
	else if((moveVal).compareTo(val[8])==0) {
		value = yMidCoord(0.703-(8*b),0.78-(8*b));
	}
	else if((moveVal).compareTo(val[9])==0) {
		value = yMidCoord(0.703-(9*b),0.78-(9*b));
	}
	else {
		value = -1;
	}
	return value;
}


public static boolean isFromRow10(String moveline) { //use??
	boolean isTen = false;
	
	try {
		int row = Integer.parseInt(moveline.substring(1,3));
		isTen = true;
	} catch(Exception e) {
		return isTen;
	}
	
	return isTen;
}


public static String MoveToIndex(String moveline) { //convert move line to index line (rowfrom+colFrom+rowto+colto)
	String fromrowMove;
	String fromcolMove;
	String torowMove;
	String tocolMove;
	String indexMove;
	
	//row 10 present
	int indexSymbol;

	indexSymbol = moveline.lastIndexOf("-");
		if(indexSymbol == -1) {
			indexSymbol = moveline.lastIndexOf("x");
		}
	
	//'to' position
		if(indexSymbol > 2) {
			torowMove = moveline.substring(indexSymbol+2,moveline.length());
			tocolMove = String.valueOf(moveline.charAt(4));
		}
		else {
			torowMove = moveline.substring(4,moveline.length());
			tocolMove = String.valueOf(moveline.charAt(3));
		}
		
	//'from' position 
		System.out.println("ten move is "+moveline);
		
		if(indexSymbol>2) {
			fromrowMove = moveline.substring(1,indexSymbol);
			fromcolMove = String.valueOf(moveline.charAt(0));
		}
		else {
			fromrowMove = String.valueOf(moveline.charAt(1));
			fromcolMove = String.valueOf(moveline.charAt(0));
		}

		
	String alphabet = "a,b,c,d,e,f,g,h,i,j";
	String numbers = "1,2,3,4,5,6,7,8,9,10";
	String[] lettersArray = alphabet.split(",");
	String[] numbersArray = numbers.split(",");
	
	String indexfromRow = null;
	String indexfromCol = null;
	String indextoRow = null;
	String indextoCol = null;
	
	//find FROM
	//column
	for(int f = 0; f < 10; f++) {
		if(fromcolMove.compareTo(lettersArray[f])==0) {
			int value = Integer.parseInt(numbersArray[f])-1;
			indexfromCol = String.valueOf(value);
		}
	}
	//row
	for(int g = 0; g < numbersArray.length; g++) {
		
		if(fromrowMove.compareTo(numbersArray[g])==0) {
			int value = Integer.parseInt(numbersArray[numbersArray.length-1])-(g+1);
			indexfromRow = String.valueOf(value);
		}
	}
	
	//find TO
	//column
	for(int f = 0; f < 10; f++) {
		if(tocolMove.compareTo(lettersArray[f])==0) {
			int value = Integer.parseInt(numbersArray[f])-1;
			indextoCol = String.valueOf(value);
		}
	}
	//row
	for(int g = 0; g < 10; g++) {
		if(torowMove.compareTo(numbersArray[g])==0) {
			int value = Integer.parseInt(numbersArray[numbersArray.length-1])-(g+1);
			indextoRow = String.valueOf(value);
		}
	}
	
	indexMove = indexfromRow + indexfromCol + indextoRow + indextoCol;
	return indexMove;
	
}


public static String IndexToMove(String indexline, boolean isFrom) { //converts 'from/to' index line into 'from/to' move line
	String row;
	String column;

if(isFrom) {
//from column:
		if(indexline.charAt(1)=='0') {
			column = "a";
		}
		else if(indexline.charAt(1)=='1') {
			column = "b";
		}
		else if(indexline.charAt(1)=='2') {
			column = "c";
		}
		else if(indexline.charAt(1)=='3') {
			column = "d";
		}
		else if(indexline.charAt(1)=='4') {
			column = "e";
		}
		else if(indexline.charAt(1)=='5') {
			column = "f";
		}
		else if(indexline.charAt(1)=='6') {
			column = "g";
		}
		else if(indexline.charAt(1)=='7') {
			column = "h";
		}
		else if(indexline.charAt(1)=='8') {
			column = "i";
		}
		else if(indexline.charAt(1)=='9') {
			column = "j";
		}
		else {
			column = "z";
	}
		
//from row:
		if(indexline.charAt(0)=='9') {
			row = "1";
		}
		else if(indexline.charAt(0)=='8') {
			row = "2";
		}
		else if(indexline.charAt(0)=='7') {
			row = "3";
		}
		else if(indexline.charAt(0)=='6') {
			row = "4";
		}
		else if(indexline.charAt(0)=='5') {
			row = "5";
		}
		else if(indexline.charAt(0)=='4') {
			row = "6";
		}
		else if(indexline.charAt(0)=='3') {
			row = "7";
		}
		else if(indexline.charAt(0)=='2') {
			row = "8";
		}
		else if(indexline.charAt(0)=='1') {
			row = "9";
		}
		else if(indexline.charAt(0)=='0') {
			row = "10";
		}
		else {
			row = "11";
	}
} else {
	
//to column:
		if(indexline.charAt(3)=='0') {
			column = "a";
		}
		else if(indexline.charAt(3)=='1') {
			column = "b";
		}
		else if(indexline.charAt(3)=='2') {
			column = "c";
		}
		else if(indexline.charAt(3)=='3') {
			column = "d";
		}
		else if(indexline.charAt(3)=='4') {
			column = "e";
		}
		else if(indexline.charAt(3)=='5') {
			column = "f";
		}
		else if(indexline.charAt(3)=='6') {
			column = "g";
		}
		else if(indexline.charAt(3)=='7') {
			column = "h";
		}
		else if(indexline.charAt(3)=='8') {
			column = "i";
		}
		else if(indexline.charAt(3)=='9') {
			column = "j";
		}
		else {
			column = "z";
		}

//to row:
		if(indexline.charAt(2)=='9') {
			row = "1";
		}
		else if(indexline.charAt(2)=='8') {
			row = "2";
		}
		else if(indexline.charAt(2)=='7') {
			row = "3";
		}
		else if(indexline.charAt(2)=='6') {
			row = "4";
		}
		else if(indexline.charAt(2)=='5') {
			row = "5";
		}
		else if(indexline.charAt(2)=='4') {
			row = "6";
		}
		else if(indexline.charAt(2)=='3') {
			row = "7";
		}
		else if(indexline.charAt(2)=='2') {
			row = "8";
		}
		else if(indexline.charAt(2)=='1') {
			row = "9";
		}
		else if(indexline.charAt(2)=='0') {
			row = "10";
		}
		else {
			row = "11";
		}
}
	
	String moveline = column+row;
	return moveline;
}


public static void printPieces(Piece[][] boardGUI) {//reprint after every move

	StdDraw.picture(xMidCoord(0.15, 0.65), yMidCoord(0.15, 0.65), String.valueOf(Paths.get("Pictures/startupBoard.png").toAbsolutePath()), 0.78, 0.8);
	StdDraw.picture(xMidCoord(0.8,0.99), yMidCoord(0.01,0.21), String.valueOf(Paths.get("Pictures/textmove.png").toAbsolutePath()), 0.15, 0.1);

	
	for(int d = 0; d < boardGUI.length; d++) {
		for(int e = 0; e < boardGUI.length; e++) {
			
			String moveline = IndexToMove(String.valueOf(d)+String.valueOf(e),true);
			String fromRow;
			
			try {
				int Ten = Integer.parseInt(moveline.substring(1,moveline.length()));
				fromRow = String.valueOf(Ten);
			}
			catch(Exception e1){
				fromRow = String.valueOf(moveline.charAt(1));
			}
			
			if(boardGUI[d][e].getType().equals(PieceType.KING)) {
				
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigking.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birdking.png").toAbsolutePath()), 0.07, 0.07);
				}	
			}
			else if(boardGUI[d][e].getType().equals(PieceType.AMAZON)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigamazon.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birdamazon.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			else if(boardGUI[d][e].getType().equals(PieceType.BISHOP)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigbishop.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birdbishop.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			else if(boardGUI[d][e].getType().equals(PieceType.DRAGON)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigdragon.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birddragon.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			else if(boardGUI[d][e].getType().equals(PieceType.DRUNKED_PAWN)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigdrunken.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birddrunken.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			else if(boardGUI[d][e].getType().equals(PieceType.ELEPHANT)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigelephant.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birdelephant.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			else if(boardGUI[d][e].getType().equals(PieceType.KNIGHT)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigknight.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birdknight.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			else if(boardGUI[d][e].getType().equals(PieceType.PAWN)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigpawn.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birdpawn.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			else if(boardGUI[d][e].getType().equals(PieceType.PRINCESS)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigprincess.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birdprincess.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			else if(boardGUI[d][e].getType().equals(PieceType.QUEEN)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigqueen.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birdqueen.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			else if(boardGUI[d][e].getType().equals(PieceType.ROOK)) {
				if(boardGUI[d][e].owner.equals(PlayerType.WHITE)) {
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/pigs/pigrook.png").toAbsolutePath()), 0.07, 0.07);
				}
				else {//PlayerType is Black
					StdDraw.picture(toGuiMove_Column(String.valueOf(moveline.charAt(0))),toGuiMove_Row(fromRow), String.valueOf(Paths.get("Pictures/Pieces/birds/birdrook.png").toAbsolutePath()), 0.07, 0.07);
				}
			}
			
		}
	}
}


}
