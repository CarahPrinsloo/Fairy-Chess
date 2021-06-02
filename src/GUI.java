//import java.util.ArrayList;
//
//public class GUI {
//
//
//public static String ChooseWallpaper(int number) {
//	//TODO: add function where can choose wallpaper 
//	String get;
//	if(number == 1) {
//		get = "Wallpaper1.jpg";
//	}
//	else if(number == 2) {
//		get = "Wallpaper2.jpg";	
//	}
//	else {
//		get = "Wallpaper3.jpg";
//	}
//	
//	return get;
//}
//
//public static void StartUpLayout() { //initial layout at start of game
//	StdDraw.setCanvasSize(1900, 950);
//	StdDraw.picture(xMidCoord(0.0,1.0), yMidCoord(0.0,1.0), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\"+ChooseWallpaper(3), 1.0, 1.0);
//	StdDraw.picture(xMidCoord(0.4,0.6), yMidCoord(0.8,1.0), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Title.png");
//	StdDraw.picture(xMidCoord(0.8,0.99), yMidCoord(0.29,0.49), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\StatusPieceAlloc.png", 0.2, 0.75);
//	
//	StdDraw.picture(xMidCoord(0.15, 0.65), yMidCoord(0.15, 0.65), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\startupBoard.png");
//
//////row1
////	StdDraw.picture(toGuiMove_Column("a"), toGuiMove_Row("1"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigrook.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("b"), toGuiMove_Row("1"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigknight.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("c"), toGuiMove_Row("1"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigknight.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("d"), toGuiMove_Row("1"),"C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigbishop.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("e"), toGuiMove_Row("1"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigqueen.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("f"), toGuiMove_Row("1"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigking.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("g"), toGuiMove_Row("1"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigbishop.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("h"), toGuiMove_Row("1"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigknight.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("i"), toGuiMove_Row("1"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigknight.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("j"), toGuiMove_Row("1"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigrook.png", 0.07, 0.07);
////	
//////row 2
////		StdDraw.picture(toGuiMove_Column("a"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigpawn.png", 0.07, 0.07);
////		StdDraw.picture(toGuiMove_Column("b"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigpawn.png", 0.07, 0.07);
////		StdDraw.picture(toGuiMove_Column("c"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigdrunken.png", 0.07, 0.07);
////		StdDraw.picture(toGuiMove_Column("d"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigpawn.png", 0.07, 0.07);
////		StdDraw.picture(toGuiMove_Column("e"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigpawn.png", 0.07, 0.07);
////		StdDraw.picture(toGuiMove_Column("f"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigpawn.png", 0.07, 0.07);
////		StdDraw.picture(toGuiMove_Column("g"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigpawn.png", 0.07, 0.07);
////		StdDraw.picture(toGuiMove_Column("h"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigdrunken.png", 0.07, 0.07);
////		StdDraw.picture(toGuiMove_Column("i"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigpawn.png", 0.07, 0.07);
////		StdDraw.picture(toGuiMove_Column("j"), toGuiMove_Row("2"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\pigs\\pigpawn.png", 0.07, 0.07);
////
//////row9
////				StdDraw.picture(toGuiMove_Column("a"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdpawn.png", 0.07, 0.07);
////				StdDraw.picture(toGuiMove_Column("b"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdpawn.png", 0.07, 0.07);
////				StdDraw.picture(toGuiMove_Column("c"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birddrunken.png", 0.07, 0.07);
////				StdDraw.picture(toGuiMove_Column("d"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdpawn.png", 0.07, 0.07);
////				StdDraw.picture(toGuiMove_Column("e"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdpawn.png", 0.07, 0.07);
////				StdDraw.picture(toGuiMove_Column("f"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdpawn.png", 0.07, 0.07);
////				StdDraw.picture(toGuiMove_Column("g"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdpawn.png", 0.07, 0.07);
////				StdDraw.picture(toGuiMove_Column("h"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birddrunken.png", 0.07, 0.07);
////				StdDraw.picture(toGuiMove_Column("i"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdpawn.png", 0.07, 0.07);
////				StdDraw.picture(toGuiMove_Column("j"), toGuiMove_Row("9"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdpawn.png", 0.07, 0.07);	
////	
//////row10	
////	StdDraw.picture(toGuiMove_Column("a"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdrook.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("b"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdknight.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("c"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdknight.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("d"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdbishop.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("e"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdqueen.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("f"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdking.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("g"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdbishop.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("h"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdknight.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("i"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdknight.png", 0.07, 0.07);
////	StdDraw.picture(toGuiMove_Column("j"), toGuiMove_Row("10"), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\birds\\birdrook.png", 0.07, 0.07);
//	
//
//}
//
//public static String inputMove() { //converts mouse input into move
//	String row = "20"; //default
//	String column = "20"; //default
//	double addValue = 0.077;
//
////column:
//		if( (StdDraw.mouseX() > 0.01) && (StdDraw.mouseX() < 0.087) ) {
//			column = "a";
//		}
//		else if((StdDraw.mouseX() > (0.01+addValue)) && (StdDraw.mouseX() < (0.087+addValue))) {
//			column = "b";
//		}
//		else if((StdDraw.mouseX() > (0.01+(2*addValue))) && (StdDraw.mouseX() < (0.087+(2*addValue)))) {
//			column = "c";
//		}
//		else if((StdDraw.mouseX() > (0.01+(3*addValue))) && (StdDraw.mouseX() < (0.087+(3*addValue)))) {
//			column = "d";
//		}
//		else if((StdDraw.mouseX() > (0.01+(4*addValue))) && (StdDraw.mouseX() < (0.087+(4*addValue)))) {
//			column = "e";
//		}
//		else if((StdDraw.mouseX() > (0.01+(5*addValue))) && (StdDraw.mouseX() < (0.087+(5*addValue)))) {
//			column = "f";
//		}
//		else if((StdDraw.mouseX() > (0.01+(6*addValue))) && (StdDraw.mouseX() < (0.087+(6*addValue)))) {
//			column = "g";
//		}
//		else if((StdDraw.mouseX() > (0.01+(7*addValue))) && (StdDraw.mouseX() < (0.087+(7*addValue)))) {
//			column = "h";
//		}
//		else if((StdDraw.mouseX() > (0.01+(8*addValue))) && (StdDraw.mouseX() < (0.087+(8*addValue)))) {
//			column = "i";
//		}
//		else if((StdDraw.mouseX() > (0.01+(9*addValue))) && (StdDraw.mouseX() < (0.087+(9*addValue)))) {
//			column = "j";
//		}
//		
////row:
//		if( (StdDraw.mouseY() > 0.01) && (StdDraw.mouseY() < 0.087) ) {
//			row = "1";
//		}
//		else if((StdDraw.mouseY() > (0.01+addValue)) && (StdDraw.mouseY() < (0.087+addValue))) {
//			row = "2";
//		}
//		else if((StdDraw.mouseY() > (0.01+(2*addValue))) && (StdDraw.mouseY() < (0.087+(2*addValue)))) {
//			row = "3";
//		}
//		else if((StdDraw.mouseY() > (0.01+(3*addValue))) && (StdDraw.mouseY() < (0.087+(3*addValue)))) {
//			row = "4";
//		}
//		else if((StdDraw.mouseY() > (0.01+(4*addValue))) && (StdDraw.mouseY() < (0.087+(4*addValue)))) {
//			row = "5";
//		}
//		else if((StdDraw.mouseY() > (0.01+(5*addValue))) && (StdDraw.mouseY() < (0.087+(5*addValue)))) {
//			row = "6";
//		}
//		else if((StdDraw.mouseY() > (0.01+(6*addValue))) && (StdDraw.mouseY() < (0.087+(6*addValue)))) {
//			row = "7";
//		}
//		else if((StdDraw.mouseY() > (0.01+(7*addValue))) && (StdDraw.mouseY() < (0.087+(7*addValue)))) {
//			row = "8";
//		}
//		else if((StdDraw.mouseY() > (0.01+(8*addValue))) && (StdDraw.mouseY() < (0.087+(8*addValue)))) {
//			row = "9";
//		}
//		else if((StdDraw.mouseY() > (0.01+(9*addValue))) && (StdDraw.mouseY() < (0.087+(9*addValue)))) {
//			row = "10";
//		}
//		
//	if( (StdDraw.mouseY()>(0.01)&&(StdDraw.mouseY()<(0.21))) && (StdDraw.mouseX()>(0.8)&&(StdDraw.mouseX()<(0.99))) ) {// promotion/check/castling move
//			
//		String typeMove = GUItemp.DialogBox("Enter move type" +"\n promotion: type 'p' " + "\n castling: type 'c' " + "\n check: type 'ch' " +"\n undo: type 'u' "+"\n redo: type 'r' " ,"Move type chosen: ", false);
//			
//			if(typeMove.compareTo("p")==0) {//promotion
//				String movePromotion = GUItemp.DialogBox("Enter your promotion move " + "\n e.g. e9-e8=d", "Your move is: ", false);
//				return movePromotion;
//			}
//			else if(typeMove.compareTo("c")==0) {//castling
//				String moveCastling = GUItemp.DialogBox("Enter your castling move " + "\n queenside: type '0-0-0'" + "\n kingside: type '0-0'", "Your move is: ", false);
//				return moveCastling;
//			}
//			else if(typeMove.compareTo("ch")==0) {//check
//				String moveCheck = GUItemp.DialogBox("Enter your check move " + "\n e.g. a8-a7+", "Your move is: ", false);
//				return moveCheck;
//			}
//			else if(typeMove.compareTo("u")==0) {//undo
//				if(ScannerInput.counterMove==0) {
//					return null; //no moves in file
//				}else {
//					try {
//						return FairyChess.movesFile.get(ScannerInput.counterMove-1); //move present
//					}
//					catch(Exception e){
//						return null;
//					}	
//				}
//			}
//			else if(typeMove.compareTo("r")==0) {//redo
//				if(ScannerInput.counterMove==0) {
//					return null; //no moves in file
//				}else {
//					try {
//						return FairyChess.movesFile.get(ScannerInput.counterMove+1); //move present
//					}
//					catch(Exception e){
//						return null;
//					}	
//				}
//			}
//			else {
//				String invalidInput = GUItemp.DialogBox("Invalid move" + "\n To continue type: 'ok' ", "You typed: ", false);
//				
//				while(invalidInput.compareTo("ok")!=0) {
//					String tryAgain = GUItemp.DialogBox("To continue type: 'ok' ", "You typed: ", false);
//					invalidInput = tryAgain;
//				}
//				
//			}
//	}
//			
//	 if( (row.compareTo("20")==0)||(column.compareTo("20")==0) ) { // text move
//		 String input = GUItemp.DialogBox("Enter the move: (e.g. a9-a8)","Your move is ", true);
//		 return input;
//	 }
//
//	String move = column+row;
//	return move;
//}
//
//public static boolean isFromRow10(String moveline) { 
//	boolean isTen = false;
//	
//	try {
//		int row = Integer.parseInt(moveline.substring(1,3));
//		isTen = true;
//	} catch(Exception e) {
//		return isTen;
//	}
//	
//	return isTen;
//}
//
//public static String colourReplace(String moveline, boolean isFrom) { //get colour of block: if from row value is 10 isFrom = true
//	boolean colUneven;
//	boolean rowUneven;
//	String colour;
//	
//	if(isFrom) {
//	//is col even or uneven
//	if((moveline.charAt(0) == 'a') || (moveline.charAt(0) == 'c') || (moveline.charAt(0) == 'e') || (moveline.charAt(0) == 'g') || (moveline.charAt(0) == 'i') ) {
//		colUneven = true;
//	}
//	else {
//		colUneven = false;
//	}
//	//is row even or uneven
//	if(Integer.parseInt(String.valueOf(moveline.charAt(1)))%2==0) {
//		rowUneven = false;
//	}
//	else {
//		rowUneven = true;
//	}
//	} 
//	
//	else { //'to' position
//	//is fromRow 10	
//	int rowindex;
//	char colindex;
//		if(isFromRow10(moveline)) {
//			rowindex = Integer.parseInt(moveline.substring(5,moveline.length()));
//			colindex = moveline.charAt(4);
//		}
//		else {
//			rowindex = Integer.parseInt(moveline.substring(4,moveline.length()));
//			colindex = moveline.charAt(3);
//		}
//		
//	//is col even or uneven	
//		if((colindex == 'a') || (colindex == 'c') || (colindex == 'e') || (colindex == 'g') || (colindex == 'i') ) {
//			colUneven = true;
//		}
//		else {
//			colUneven = false;
//		}
//		//is row even or uneven
//		if(rowindex%2==0) {
//			rowUneven = false;
//		}
//		else {
//			rowUneven = true;
//		}	
//	}
//	
//	System.out.println(colUneven);
//	//set colour
//	if( (colUneven&&rowUneven) || (rowUneven&&!colUneven)) {
//		colour = "WHITE";
//	}
//	else {
//		colour = "BOOK_BLUE";
//	}
//	
//	return colour;
//}
//
//public static String[][] updateGUIMatrix(String indexMove, String[][] boardMatrix, String Character) { //returns updated matrix after move
//	int fromRow = Integer.parseInt(String.valueOf(indexMove.charAt(0)));
//	int toRow = Integer.parseInt(String.valueOf(indexMove.charAt(2)));
//	int fromCol = Integer.parseInt(String.valueOf(indexMove.charAt(1)));
//	int toCol = Integer.parseInt(String.valueOf(indexMove.charAt(3)));
//	
//	boardMatrix[fromRow][fromCol] = "empty";
//	boardMatrix[toRow][toCol] = Character;
//	
//	return boardMatrix;
//	
//}
//
//public static String convertMoveToIndex(String moveline) { // returns index in form String = (fromRow)+(fromCol)+(toRow)+(toCol)
//		String fromrowMove;
//		String fromcolMove;
//		String torowMove;
//		String tocolMove;
//		String indexMove;
//		
//		//'to' position
//			if(isFromRow10(moveline)) {
//				torowMove = moveline.substring(5,moveline.length());
//				tocolMove = String.valueOf(moveline.charAt(4));
//			}
//			else {
//				torowMove = moveline.substring(4,moveline.length());
//				tocolMove = String.valueOf(moveline.charAt(3));
//			}
//			
//		//'from' position 	
//			if(isFromRow10(moveline)) {
//				fromrowMove = moveline.substring(1,3);
//				fromcolMove = String.valueOf(moveline.charAt(0));
//			}
//			else {
//				fromrowMove = String.valueOf(moveline.charAt(1));
//				fromcolMove = String.valueOf(moveline.charAt(0));
//			}
//
//			
//		String alphabet = "a,b,c,d,e,f,g,h,i,j";
//		String numbers = "1,2,3,4,5,6,7,8,9,10";
//		String[] lettersArray = alphabet.split(",");
//		String[] numbersArray = numbers.split(",");
//		
//		String indexfromRow = null;
//		String indexfromCol = null;
//		String indextoRow = null;
//		String indextoCol = null;
//		
//		//find FROM
//		//column
//		for(int f = 0; f < 10; f++) {
//			if(fromcolMove.compareTo(lettersArray[f])==0) {
//				int value = Integer.parseInt(numbersArray[f])-1;
//				indexfromCol = String.valueOf(value);
//			}
//		}
//		//row
//		for(int g = 0; g < numbersArray.length; g++) {
//			
//			if(fromrowMove.compareTo(numbersArray[g])==0) {
//				int value = Integer.parseInt(numbersArray[numbersArray.length-1])-(g+1);
//				indexfromRow = String.valueOf(value);
//			}
//		}
//		
//		//find TO
//		//column
//		for(int f = 0; f < 10; f++) {
//			if(tocolMove.compareTo(lettersArray[f])==0) {
//				int value = Integer.parseInt(numbersArray[f])-1;
//				indextoCol = String.valueOf(value);
//			}
//		}
//		//row
//		for(int g = 0; g < 10; g++) {
//			if(torowMove.compareTo(numbersArray[g])==0) {
//				int value = Integer.parseInt(numbersArray[numbersArray.length-1])-(g+1);
//				indextoRow = String.valueOf(value);
//			}
//		}
//		
//		indexMove = indexfromRow + indexfromCol + indextoRow + indextoCol;
//		return indexMove;
//			
//			
//}
//
//public static void MoveGUI(String[][] arrayBoard, String indexMove, String Character, String move) {
//	
//	for(int c = 0; c < arrayBoard.length; c++) {
//		for(int d = 0; d < arrayBoard.length; d++) {
//			if(arrayBoard[c][d].compareTo(Character) == 0) {
//				
//				String indexString = String.valueOf(c)+String.valueOf(d);
//				if(indexMove.substring(0,2).compareTo(indexString) == 0) {
//					
//					//is 'to' position occupied 
//					boolean isCaptureGUI = false;
//					if(arrayBoard[Integer.parseInt(String.valueOf(indexMove.charAt(2)))][Integer.parseInt(String.valueOf(indexMove.charAt(3)))].compareTo("empty") != 0) {
//						isCaptureGUI = true;
//					}
//					
//					//update boardArray
//					arrayBoard[c][d] = "empty";
//					arrayBoard[Integer.parseInt(String.valueOf(indexMove.charAt(2)))][Integer.parseInt(String.valueOf(indexMove.charAt(3)))] = Character;
//					
//					//DO MOVE in GUI
//					String toCol = String.valueOf(move.charAt(3));
//					String fromCol = String.valueOf(move.charAt(0));
//					String toRow = String.valueOf(move.charAt(4));
//					String fromRow = String.valueOf(move.charAt(1));
//					
//					//draw 'from' square
//					if(colourReplace(move, true)=="BOOK_BLUE") {
//						StdDraw.setPenColor(StdDraw.BOOK_BLUE);	
//					}
//					else {
//						StdDraw.setPenColor(StdDraw.WHITE);
//					}
//					
//					StdDraw.filledSquare(toGuiMove_Column(fromCol),toGuiMove_Row(fromRow), 0.0385);
//					
//					//draw 'to' square if capture move
//					if(isCaptureGUI) {
//						//draw 'from' square
//						StdDraw.filledSquare(toGuiMove_Row(toRow), toGuiMove_Column(toCol), 0.0385);
//						//draw 'to' square
//						if(colourReplace(move, false)=="BOOK_BLUE") {
//							StdDraw.setPenColor(StdDraw.BOOK_BLUE);	
//						}else {
//							StdDraw.setPenColor(StdDraw.WHITE);
//						}
//						StdDraw.filledSquare( toGuiMove_Column(toCol),toGuiMove_Row(toRow), 0.0385);
//					}
//					
//					//add piece on 'to' position
//					StdDraw.picture(toGuiMove_Column(toCol),toGuiMove_Row(toRow), "C:\\Users\\cw\\Desktop\\ProjectGUI\\Pictures\\Pieces\\"+ Character + ".png", 0.07, 0.07);
//					
//				}
//			}
//		}
//		
//	}
//	
//}
//
//public static String IndextoColumn(int d) { //converts index value to col row value
//	String Column;
//	if(d==0) {
//		Column = "a";
//	}
//	else if(d==1) {
//		Column = "b";
//	}
//	else if(d==2) {
//		Column = "c";
//	}
//	else if(d==3) {
//		Column = "d";
//	}
//	else if(d==4) {
//		Column = "e";
//	}
//	else if(d==5) {
//		Column = "f";
//	}
//	else if(d==6) {
//		Column = "g";
//	}
//	else if(d==7) {
//		Column = "h";
//	}
//	else if(d==8) {
//		Column = "i";
//	}
//	else {
//		Column = "j";
//	}
//	
//	return Column;
//}
//
//public static String IndextoRow(int c) { // converts index value to move row value
//	String Row;
//	
//	if(c==0) {
//		Row = "10";
//	}
//	else if(c==1) {
//		Row = "9";
//	}
//	else if(c==2) {
//		Row = "8";
//	}
//	else if(c==3) {
//		Row = "7";
//	}
//	else if(c==4) {
//		Row = "6";
//	}
//	else if(c==5) {
//		Row = "5";
//	}
//	else if(c==6) {
//		Row = "4";
//	}
//	else if(c==7) {
//		Row = "3";
//	}
//	else if(c==8) {
//		Row = "2";
//	}
//	else {
//		Row = "1";
//	}
//	
//	return Row;
//}
//
//public static String[][] firstBoardMatrixGUI() { //startup boardmatrix
//	String[][] Board = new String[10][10];
//	
//	Board[0][0] = "birds\\birdrook";
//	Board[0][1]= "birds\\birdknight";
//	Board[0][2] = "birds\\birdknight";
//	Board[0][3] = "birds\\birdbishop";
//	Board[0][4]= "birds\\birdqueen";
//	Board[0][5] = "birds\\birdking";
//	Board[0][6]= "birds\\birdbishop";
//	Board[0][7] = "birds\\birdknight";
//	Board[0][8] = "birds\\birdknight";
//	Board[0][9]= "birds\\birdrook";
//	
//	Board[1][0] = "birds\\birdpawn";
//	Board[1][1]= "birds\\birdpawn";
//	Board[1][2] = "birds\\birddrunken";
//	Board[1][3] = "birds\\birdpawn";
//	Board[1][4]= "birds\\birdpawn";
//	Board[1][5] = "birds\\birdpawn";
//	Board[1][6]= "birds\\birdpawn";
//	Board[1][7] = "birds\\birddrunken";
//	Board[1][8] = "birds\\birdpawn";
//	Board[1][9]= "birds\\birdpawn";
//	
//	Board[2][0] = "empty";
//	Board[2][1]= "empty";
//	Board[2][2] = "empty";
//	Board[2][3] = "empty";
//	Board[2][4]= "empty";
//	Board[2][5] = "empty";
//	Board[2][6]= "empty";
//	Board[2][7] = "empty";
//	Board[2][8] = "empty";
//	Board[2][9]= "empty";
//	
//	Board[3][0] = "empty";
//	Board[3][1]= "empty";
//	Board[3][2] = "empty";
//	Board[3][3] = "empty";
//	Board[3][4]= "empty";
//	Board[3][5] = "empty";
//	Board[3][6]= "empty";
//	Board[3][7] = "empty";
//	Board[3][8] = "empty";
//	Board[3][9]= "empty";
//	
//	Board[4][0] = "empty";
//	Board[4][1]= "empty";
//	Board[4][2] = "empty";
//	Board[4][3] = "empty";
//	Board[4][4]= "empty";
//	Board[4][5] = "empty";
//	Board[4][6]= "empty";
//	Board[4][7] = "empty";
//	Board[4][8] = "empty";
//	Board[4][9]= "empty";
//	
//	Board[5][0] = "empty";
//	Board[5][1]= "empty";
//	Board[5][2] = "empty";
//	Board[5][3] = "empty";
//	Board[5][4]= "empty";
//	Board[5][5] = "empty";
//	Board[5][6]= "empty";
//	Board[5][7] = "empty";
//	Board[5][8] = "empty";
//	Board[5][9]= "empty";
//	
//	Board[6][0] = "empty";
//	Board[6][1]= "empty";
//	Board[6][2] = "empty";
//	Board[6][3] = "empty";
//	Board[6][4]= "empty";
//	Board[6][5] = "empty";
//	Board[6][6]= "empty";
//	Board[6][7] = "empty";
//	Board[6][8] = "empty";
//	Board[6][9]= "empty";
//	
//	Board[7][0] = "empty";
//	Board[7][1]= "empty";
//	Board[7][2] = "empty";
//	Board[7][3] = "empty";
//	Board[7][4]= "empty";
//	Board[7][5] = "empty";
//	Board[7][6]= "empty";
//	Board[7][7] = "empty";
//	Board[7][8] = "empty";
//	Board[7][9]= "empty";
//	
//	Board[8][0] = "pigs\\pigpawn";
//	Board[8][1]= "pigs\\pigpawn";
//	Board[8][2] = "pigs\\pigdrunken";
//	Board[8][3] = "pigs\\pigpawn";
//	Board[8][4]= "pigs\\pigpawn";
//	Board[8][5] = "pigs\\pigpawn";
//	Board[8][6]= "pigs\\pigpawn";
//	Board[8][7] = "pigs\\pigdrunken";
//	Board[8][8] = "pigs\\pigpawn";
//	Board[8][9]= "pigs\\pigpawn";
//	
//	Board[9][0] = "pigs\\pigrook";
//	Board[9][1]= "pigs\\pigknight";
//	Board[9][2] = "pigs\\pigknight";
//	Board[9][3] = "pigs\\pigbishop";
//	Board[9][4]= "pigs\\pigqueen";
//	Board[9][5] = "pigs\\pigking";
//	Board[9][6]= "pigs\\pigbishop";
//	Board[9][7] = "pigs\\pigknight";
//	Board[9][8] = "pigs\\pigknight";
//	Board[9][9]= "pigs\\pigrook";
//	
//	
//	return Board;
//}
//
//public static String getIndexGUI (char column, int row) { //OLD?
//	String ArrayIndex;
//	
//	if(row==1) {
//		ArrayIndex = "9";
//	}
//	else if(row==2) {
//		ArrayIndex = "8";
//	}
//	else if(row==3) {
//		ArrayIndex = "7";
//	}
//	else if(row==4) {
//		ArrayIndex = "6";
//	}
//	else if(row==5) {
//		ArrayIndex = "5";
//	}
//	else if(row==6) {
//		ArrayIndex = "4";
//	}
//	else if(row==7) {
//		ArrayIndex = "3";
//	}
//	else if(row==8) {
//		ArrayIndex = "2";
//	}
//	else if(row==9) {
//		ArrayIndex = "1";
//	}
//	else if(row==10) {
//		ArrayIndex = "0";
//	}
//	else {
//		ArrayIndex ="-1"; //if not right value
//	}
//		
//		String StringvalOfColumn = String.valueOf(column);
//		String alphabet = "a,b,c,d,e,f,g,h,i,j";
//		String[] alphabetArray = alphabet.split(",");
//		
//		if( (StringvalOfColumn).compareTo(alphabetArray[0]) == 0 ) {
//			ArrayIndex = "0" + ArrayIndex ;
//		}
//		else if( (StringvalOfColumn).compareTo(alphabetArray[1]) == 0 ) {
//			ArrayIndex = "1" + ArrayIndex ;
//		}
//		else if( (StringvalOfColumn).compareTo(alphabetArray[2]) == 0 ) {
//			ArrayIndex = "2" + ArrayIndex ;
//		}
//		else if( (StringvalOfColumn).compareTo(alphabetArray[3]) == 0 ) {
//			ArrayIndex = "3" + ArrayIndex ;
//		}
//		else if( (StringvalOfColumn).compareTo(alphabetArray[4]) == 0 ) {
//			ArrayIndex = "4" + ArrayIndex ;
//		}
//		else if( (StringvalOfColumn).compareTo(alphabetArray[5]) == 0 ) {
//			ArrayIndex = "5" + ArrayIndex ;
//		}
//		else if( (StringvalOfColumn).compareTo(alphabetArray[6]) == 0 ) {
//			ArrayIndex = "6" + ArrayIndex ;
//		}
//		else if( (StringvalOfColumn).compareTo(alphabetArray[7]) == 0 ) {
//			ArrayIndex = "7" + ArrayIndex ;
//		}
//		else if( (StringvalOfColumn).compareTo(alphabetArray[8]) == 0 ) {
//			ArrayIndex = "8" + ArrayIndex ;
//		}
//		else if( (StringvalOfColumn).compareTo(alphabetArray[9]) == 0 ) {
//			ArrayIndex = "9" + ArrayIndex ;
//		}
//		System.out.println(ArrayIndex);
//		return ArrayIndex;
//		
//	} 
//
//public static String getCharacter(String indexline, boolean isFrom, String[][] BoardMatrix) {
//	int row;
//	int col;
//	String Character = "invalid"; //default value
//	
//	if(isFrom) {
//		row = Integer.parseInt(String.valueOf(indexline.charAt(0)));
//		col = Integer.parseInt(String.valueOf(indexline.charAt(1)));
//	}
//	else {
//		row = Integer.parseInt(String.valueOf(indexline.charAt(2)));
//		col = Integer.parseInt(String.valueOf(indexline.charAt(3)));
//	}
//	
//	for(int h = 0; h < BoardMatrix.length; h++) {
//		for(int i = 0; i < BoardMatrix.length; i++) {
//			if( (row==h)&&(col==i) ) {
//				Character = BoardMatrix[h][i];
//			}
//		}
//	}
//	
//	return Character;
//	
//}
//	
////public static void main(String[] args) {
//
////StartUpLayout();
////
////ArrayList<String> GUImoves = new ArrayList<String>();
////int counter = 0;
////String[][] updatedBoard = new String[10][10];
////
////while(true) {
////	boolean Execute = false;
////	
////	while(StdDraw.mousePressed()) {
////
////		if(!Execute) {
////			
////			String pressedMove = inputMove();
////            GUImoves.add(pressedMove);
////
////		}
////		Execute = true;
////	}
////	int sizeList = GUImoves.size();
////	if( (sizeList%2==0) && (sizeList>1) ) {
////		
////		String moveExecute = GUImoves.get(0) + "-" + GUImoves.get(1);
////		System.out.println(moveExecute);
////		GUImoves.clear();
////		counter++;
////		
////		//move piece and update boardmatrix
////		String indexVal;
////		String fromCharacter;
////		if(counter == 1) { //first move
////			indexVal = convertMoveToIndex(moveExecute);
////			fromCharacter = getCharacter(indexVal,true,firstBoardMatrixGUI());
////			MoveGUI(firstBoardMatrixGUI(),indexVal,fromCharacter,moveExecute);
////			updatedBoard = updateGUIMatrix(indexVal,firstBoardMatrixGUI(),fromCharacter);
////		} 
////		else {
////			indexVal = convertMoveToIndex(moveExecute);
////			fromCharacter = getCharacter(indexVal,true,updatedBoard);
////			MoveGUI(updatedBoard,indexVal,fromCharacter,moveExecute);
////			updatedBoard = updateGUIMatrix(indexVal,updatedBoard,fromCharacter);
////		}
////	}	
////}
////
////}
//}
