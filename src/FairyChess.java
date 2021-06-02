//package root;

//import root.pieces.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FairyChess {
	
public static void StartUpLayout() { //initial layout at start of game
StdDraw.setCanvasSize(1900, 950);
	StdDraw.picture(GUItemp.xMidCoord(0.0,1.0), GUItemp.yMidCoord(0.0,1.0), String.valueOf(Paths.get("Pictures/"+GUItemp.ChooseWallpaper(3)).toAbsolutePath()), 1.0, 1.0);
	StdDraw.picture(GUItemp.xMidCoord(0.4,0.6), GUItemp.yMidCoord(0.8,1.0), String.valueOf(Paths.get("Pictures/Title.png").toAbsolutePath()));
	StdDraw.picture(GUItemp.xMidCoord(0.8,0.99), GUItemp.yMidCoord(0.29,0.49), String.valueOf(Paths.get("Pictures/StatusPieceAlloc.png").toAbsolutePath()), 0.2, 0.75);
	StdDraw.picture(GUItemp.xMidCoord(0.8,0.99), GUItemp.yMidCoord(0.01,0.21), String.valueOf(Paths.get("Pictures/textmove.png").toAbsolutePath()), 0.15, 0.1);
}

public static List<Move> moves;
public static boolean GUI = true;
public static boolean Undo = false;
public static boolean Redo = false;
public static ArrayList<String> movesFile;
public static int countBoard;

public static void main(String[] args) throws IOException {

StartUpLayout();
	
//scan file
Scanner MainMoveScanner;
try {
	//scan file and add each move into a separate file mainmove movefiles
	MainMoveScanner = new Scanner(new File (args[1]));
	movesFile = ScannerInput.moveFromFile(MainMoveScanner);
	ScannerInput.LinesSeperateFiles(MainMoveScanner, movesFile);

} catch (FileNotFoundException e) {
	e.printStackTrace();
}
	
	while(true) {
		
		try {
			
			Scanner boardScanner;

			if(countBoard==0) {
				boardScanner = new Scanner(new File(args[0]));
				countBoard++;
			}else {
				boardScanner = new Scanner(new File(String.valueOf(Paths.get("Boardfiles/Board"+Board.countFile+".txt").toAbsolutePath())));
			}
			
	        Board board = ScannerInput.readBoard(boardScanner);
	        

	        	
		        try {
		        Move guiMove = ScannerInput.getMoveGUI();
		        board.move(guiMove, 1);
		        String indexline = Utils.MoveObjToindex(guiMove);
		        String moveline = GUItemp.IndexToMove(indexline, true)+"-"+GUItemp.IndexToMove(indexline, false);
		        GUItemp.MoveGUIPiece(indexline,ScannerInput.pieces,moveline);
		        }
		        catch(Exception e) {
		        	System.out.println("illegal move");
		        }   
 
	        
		}catch (Exception e) {
	        System.out.println(e);
	        e.printStackTrace();
	    }


	    Board.printBoard();
	}	
	}
}


