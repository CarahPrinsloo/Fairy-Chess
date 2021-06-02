
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ScannerInput {

	public static boolean isKingSideCastling = false;
    public static boolean isQueenSideCastling = false;
	public static List<Move> moves = new ArrayList<>();
	public static boolean hasSymbol = false;
	public static String PromoPiece;
	public static boolean moveCast = false;
	public static String[] CastlingType = new String[2];
	public static char[] charsUsed = new char[12];
	public static char[] numbersPieces = new char[12];
	public static int Errorlinecounter;
	public static PieceType promotionP;
	public static Piece [][] pieces;
	public static String[] statusItems;
	public static int MovesCounter = 0;
	public static int counterMove = 0;
	
public static ArrayList<String> moveFromFile(Scanner scanner){
	ArrayList<String> moves = new ArrayList<String>();
	while(scanner.hasNext()) {
	    String val = scanner.next();
		if(!val.startsWith("%")) {
			moves.add(val);
		}
	}	
	
	return moves;
}
	
public static void LinesSeperateFiles (Scanner scanner, ArrayList<String> moves) throws IOException {//save move lines in separate files 

//add lines to separate files
for (String line : moves) {

    	File fileLine = new File("C:\\Users\\cw\\Desktop\\ProjectGUI\\Movefiles\\Moves"+String.valueOf(MovesCounter)+".txt");
    	
    	if(!fileLine.exists()) {
    		fileLine.createNewFile();
    	}
    	
    	PrintWriter pw = new PrintWriter(fileLine);
        pw.print(line);
        pw.close();
        MovesCounter++;
       }	    
}
  

public static Move getMoveGUI() {
	ArrayList<String> GUImoves = new ArrayList<String>();
	while(true) {
		boolean isText = false;
		boolean Execute = false;
		
		while(StdDraw.isMousePressed()) {
	
			if(!Execute) {
				
				String pressedMove;
					
					if(GUItemp.inputMove().compareTo("undo")==0) {
						if( (FairyChess.movesFile.size()<2) || (counterMove==0) ) {
							pressedMove = null; //unable to undo
						}
						else {
							pressedMove = FairyChess.movesFile.get(ScannerInput.counterMove-1);
							ScannerInput.counterMove++;
						}
					}
					else if(GUItemp.inputMove().compareTo("redo")==0){//redo move
						if( (FairyChess.movesFile.size()==0) || (FairyChess.movesFile.size()<ScannerInput.counterMove) ) {
								pressedMove = null; //unable to undo
						}
						else if(ScannerInput.counterMove==0) {
							System.out.println("reach ");
							pressedMove = FairyChess.movesFile.get(ScannerInput.counterMove);
							ScannerInput.counterMove++;
						}
						else {
							pressedMove = FairyChess.movesFile.get(ScannerInput.counterMove+1);
							ScannerInput.counterMove++;
						}
					}
					else {//normal move
						pressedMove = GUItemp.inputMove();
					}
					
				
				
				if( (pressedMove.length()>2)&&(pressedMove.length()!=3) ) {//return whole moveline
					isText = true;
				}
						
	            GUImoves.add(pressedMove);
	            
			}
			int sizeList = GUImoves.size();
			if( (sizeList%2==0) && (sizeList>1) ) {
				String tempLine = GUImoves.get(GUImoves.size()-2) + "-" + GUImoves.get(GUImoves.size()-1);
				String symbol = GUItemp.moveSymbol(pieces,tempLine);
				String moveExecute = GUImoves.get(GUImoves.size()-2) + symbol + GUImoves.get(GUImoves.size()-1);
				Move moveObj = GUItemp.GUIMove(moveExecute);
				return moveObj;
				
			}else if(isText&&(sizeList>0)) {
				String moveExecute = GUImoves.get(GUImoves.size()-1);
				Move moveObj = GUItemp.GUIMove(moveExecute);
				return moveObj;
			}
			isText = false;	
			Execute = true;
		}
	}
	
}

public static List<Move> readMoves(Scanner scanner) {

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            if (line.startsWith("%")) {
            	Board.badmove++;
                continue;
            }


         if( line.equals("0-0") ){
        	 isKingSideCastling = true;
         }
         else if( line.equals("0-0-0") ){
        	 isQueenSideCastling = true;
         }

            String delimiter;
            if (line.lastIndexOf('x') > 0) {
                delimiter = "x";
            } else {
                delimiter = "-";
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
            positions = line.split(delimiter);


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
            if(line.lastIndexOf('=') > 0) {

                PieceType pt = null;
                switch (line.split("=")[1].toUpperCase()) {
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
            } else if (line.lastIndexOf('x') > 0) {
//            	System.out.print("Reach E");

                int checkIndex = line.lastIndexOf("+");

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
                        moves.add(new Move(new Position(fromColumn, fromRow), new Position(toColumn, toRow), false, true, true, false));
                    } else { // IS King side
                        moves.add(new Move(new Position(fromColumn, fromRow), new Position(toColumn, toRow), false, true, false, true));
                    }
                } else {
                        int checkIndex = line.lastIndexOf("+");
                        boolean isCheck = false;
                        boolean isCheckMate = false;

                        if (checkIndex == 5) {
//                        	System.out.print(" Reach A ");
                            isCheck = true;
                        } else if (checkIndex == 6) {
//                         	System.out.print(" Reach B ");
                            isCheck = true;
                            isCheckMate = true;
                        }
                        m = new Move(new Position(fromColumn, fromRow), new Position(toColumn, toRow), isCheck, isCheckMate);
                    }

                    if(!(isKingSideCastling || isQueenSideCastling)) {
                        moves.add(m);
                    }

                }
        
        //put moves in seperate text files
        

                return moves;
            }

    public static Board readBoard(Scanner scanner) {

        scanner.useDelimiter("-----");

        String pieceCount = scanner.next();
        String board = scanner.next();
        String status = scanner.next();

        Map<PieceType, Integer> pc = new HashMap<>();

        int indexD = 0;
        int indexA = 0;
        for(String row: pieceCount.trim().split("\n")){

        	char w = row.split(":")[1].charAt(0);
            char p = row.split(":")[0].charAt(0);

            //char val then number allocated for end board
            charsUsed[indexA]= p;

            //num values
            numbersPieces[indexD] = w;

            Integer n = Integer.parseInt(row.split(":")[1].trim());

            switch (p) {
                case 'k':
                    pc.put(PieceType.KING, n);
                    break;
                case 'q':
                    pc.put(PieceType.QUEEN, n);
                    break;
                case 'a':
                    pc.put(PieceType.AMAZON, n);
                    break;
                case 'p':
                    pc.put(PieceType.PAWN, n);
                    break;
                case 'b':
                    pc.put(PieceType.BISHOP, n);
                    break;
                case 'f':
                    pc.put(PieceType.DRAGON, n);
                    break;
                case 'r':
                    pc.put(PieceType.ROOK, n);
                    break;
                case 'n':
                    pc.put(PieceType.KNIGHT, n);
                    break;
                case 'e':
                    pc.put(PieceType.ELEPHANT, n);
                    break;
                case 'w':
                    pc.put(PieceType.PRINCESS, n);
                    break;
                case 'd':
                    pc.put(PieceType.DRUNKED_PAWN, n);
                    break;
            }
            indexA++;
            indexD++;
        }


        List<List<Piece>> boardAsPieces = new ArrayList<>();

        for(String piece : board.trim().split("\n")){

            List<Piece> row = new ArrayList<>();

            String[] chars = piece.split(" ");

            for(String c: chars) {

                switch(c.charAt(0)) {
                    case 'K' : row.add(new King(PlayerType.WHITE)); break;
                    case 'k' : row.add(new King(PlayerType.BLACK)); break;
                    case 'Q' : row.add(new Queen(PlayerType.WHITE)); break;
                    case 'q' : row.add(new Queen(PlayerType.BLACK)); break;
                    case 'A' : row.add(new Amazon(PlayerType.WHITE)); break;
                    case 'a' : row.add(new Amazon(PlayerType.BLACK)); break;
                    case 'F' : row.add(new Dragon(PlayerType.WHITE)); break;
                    case 'f' : row.add(new Dragon(PlayerType.BLACK)); break;
                    case 'D' : row.add(new DrunkenPawn(PlayerType.WHITE)); break;
                    case 'd' : row.add(new DrunkenPawn(PlayerType.BLACK)); break;
                    case 'B' : row.add(new Bishop(PlayerType.WHITE)); break;
                    case 'b' : row.add(new Bishop(PlayerType.BLACK)); break;
                    case 'E' : row.add(new Elephant(PlayerType.WHITE)); break;
                    case 'e' : row.add(new Elephant(PlayerType.BLACK)); break;
                    case 'N' : row.add(new Knight(PlayerType.WHITE)); break;
                    case 'n' : row.add(new Knight(PlayerType.BLACK)); break;
                    case 'P' : {
                        boolean isAtStartingPosition = boardAsPieces.size() == 8;
                        row.add(new Pawn(PlayerType.WHITE, isAtStartingPosition)); break;
                    }
                    case 'p' : {
                        boolean isAtStartingPosition = boardAsPieces.size() == 1;
                        row.add(new Pawn(PlayerType.BLACK, isAtStartingPosition)); break;
                    }
                    case 'W' : row.add(new Princess(PlayerType.WHITE)); break;
                    case 'w' : row.add(new Princess(PlayerType.BLACK)); break;
                    case 'R' : row.add(new Rook(PlayerType.WHITE)); break;
                    case 'r' : row.add(new Rook(PlayerType.BLACK)); break;
                    default : row.add(new Space()); break;
                }
            }

            boardAsPieces.add(row);
        }

        statusItems = status.trim().split(":");

        PlayerType pt;
        if(statusItems[0].equals("w")) {
           pt = PlayerType.WHITE;
        } else {
            pt = PlayerType.BLACK;
        }

        String costling = statusItems[1];
        CostlingStatus blackStatus = new CostlingStatus();

        if(costling.charAt(0) == '+') {
            blackStatus.setHasQueenCostling(true);
        } else {
            blackStatus.setHasQueenCostling(false);
        }

        if(costling.charAt(1) == '+') {
            blackStatus.setHasKingCostling(true);
        } else {
            blackStatus.setHasKingCostling(false);
        }

        CostlingStatus whiteStatus = new CostlingStatus();

        if(costling.charAt(2) == '+') {
            whiteStatus.setHasQueenCostling(true);
        } else {
            whiteStatus.setHasQueenCostling(false);
        }

        if(costling.charAt(3) == '+') {
            whiteStatus.setHasKingCostling(true);
        } else {
            whiteStatus.setHasKingCostling(false);
        }
        
        //GUI print startup board
        pieces = GUItemp.convertFilePieces(boardAsPieces);
        GUItemp.printPieces(pieces);
        //GUI print status line and 
        GUItemp.GUIStatusline(statusItems[0], blackStatus.hasQueenCostling, blackStatus.hasKingCostling, whiteStatus.hasQueenCostling, whiteStatus.hasKingCostling, Integer.parseInt(statusItems[2]), Integer.parseInt(statusItems[3]));
        //GUI print Piece Allocations
        GUItemp.GUIPieceAllocations(charsUsed, numbersPieces);

        return new Board(pt, boardAsPieces, pc, blackStatus, whiteStatus, Integer.parseInt(statusItems[2]), Integer.parseInt(statusItems[3]));

    }


}

