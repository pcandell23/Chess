 
import java.awt.*;
import javax.swing.JApplet;
import java.util.Scanner;
import java.awt.event.*;
import java.applet.*; 
import java.lang.Math.*;
public class Chess extends JApplet implements MouseListener 
{
    private final int APPLET_WIDTH = 703;
    private final int APPLET_HEIGHT = 703;
    public static String[][] board = new String[9][9];
    public int[] rowNums = {0,50,123,197,272,345,420,495,567};
    public int[] rowNums2 = {0, 90, 163, 237, 310, 385, 460, 535, 605};
    private int x=0;
    private int y=0;
    private int mouseRow = -1;
    private int mouseCol = -1; 
    private int mousePickedRow = -1;
    private int mousePickedCol = -1;
    private boolean findW = true;
    private boolean findB = false;
    private boolean moveW = false;
    private boolean moveB = false;
    public String player;
    private Font stringFont = new Font("SansSerif", Font.PLAIN, 36);
    private int moves = -1;
    public String piece;
    private Image chessBoard, pawnW, kingW, queenW, knightW, bishopW, rookW, pawnB, kingB, queenB, knightB, bishopB, rookB;
    public void init() {
        chessBoard = getImage(getDocumentBase(), "chessboard.png");
        pawnW = getImage(getDocumentBase(), "pawnW.png");
        pawnB = getImage(getDocumentBase(), "pawnB.png");
        kingW = getImage(getDocumentBase(), "kingW.png");
        kingB = getImage(getDocumentBase(), "kingB.png");
        knightW = getImage(getDocumentBase(), "knightW.png");
        knightB = getImage(getDocumentBase(), "knightB.png");
        rookW = getImage(getDocumentBase(), "rookW.png");
        rookB = getImage(getDocumentBase(), "rookB.png");
        bishopW = getImage(getDocumentBase(), "bishopW.png");
        bishopB = getImage(getDocumentBase(), "bishopB.png");
        queenW = getImage(getDocumentBase(), "queenW.png");
        queenB = getImage(getDocumentBase(), "queenB.png");
        if(moves == -1){
            initBoard();
            initializeBoard();
            AI.resetPlaces();
            AI.resetTest();
            moves++;
        }
        addMouseListener(this);
    }
    public void drawPictures(int size, Graphics page) {
        page.drawImage(chessBoard, 0, 0, this);
        for (int row = 1; row < 9; row++){
            for (int col = 1; col < 9; col++){
                if(!Chess.board[row][col].equals("__")){
                    if(Chess.board[row][col].substring(0,1).equals("B")){
                        if(Chess.board[row][col].substring(1,2).equals("P")){
                            page.drawImage(pawnB,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("K")){
                            page.drawImage(kingB,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("k")){
                            page.drawImage(knightB,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("B")){
                            page.drawImage(bishopB,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("Q")){
                            page.drawImage(queenB,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("R")){
                            page.drawImage(rookB,rowNums[col],rowNums[row],80,70,this);
                        }
                    }
                    else if(Chess.board[row][col].substring(0,1).equals("W")){
                        if(Chess.board[row][col].substring(1,2).equals("P")){
                            page.drawImage(pawnW,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("K")){
                            page.drawImage(kingW,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("k")){
                            page.drawImage(knightW,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("B")){
                            page.drawImage(bishopW,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("Q")){
                            page.drawImage(queenW,rowNums[col],rowNums[row],80,70,this);
                        }
                        else if(Chess.board[row][col].substring(1,2).equals("R")){
                            page.drawImage(rookW,rowNums[col],rowNums[row],80,70,this);
                        }
                    }
                }
            }
        }
        page.setFont(stringFont);
        if(AI.checkCheckMate("W") == true){
             page.drawString("Black Wins!", 50,50);
             moveW = false;
             moveB = false;
             findB = false;
             findW = false;
        }
        else if(AI.checkCheckMate("B") == true){
             page.drawString("White Wins!", 50,50);
             moveW = false;
             moveB = false;
             findB = false;
             findW = false;
        }
        else if(findW){
            page.drawString("White, pick a piece to move",130,40);
        } 
        else if(moveW){
            page.drawString("White, where do you want to move your " + piece,30,40);
        } 
        else if(findB){
            page.drawString("Black, pick a piece to move",130,40);
        } 
        else if(moveB){
            page.drawString("Black, where do you want to move your " + piece,30,40);
        } else {
            page.drawString("GameOver",200,200);
        }
    }
    
    public void paint(Graphics page) {
        drawPictures(APPLET_WIDTH, page);
    }

    public static void initBoard(){
        for(int i = 0; i<9; i++){
            if(i!= 0){
                board[i][0] = ""+ (i) + "|   ";}
            else{
                board[i][0] = "|    ";
            }
            for(int j = 1; j<9; j++){
                board[i][j] = "__";
                if (i == 0){
                    if (j == 1){
                        board[i][j] = "A ";
                    }
                    else if (j == 2){
                        board[i][j] = "B ";
                    }
                    else if (j == 3){
                        board[i][j] = "C ";
                    }
                    else if (j == 4){
                        board[i][j] = "D ";
                    }
                    else if (j == 5){
                        board[i][j] = "E ";
                    }
                    else if (j == 6){
                        board[i][j] = "F ";
                    }
                    else if (j == 7){
                        board[i][j] = "G ";
                    }
                    else if (j == 8){
                        board[i][j] = "H ";
                    }
                }
            }
        }
    }
    public static void initializeBoard(){
        board[1][1] = "WR";
        board[1][2] = "Wk";
        board[1][3] = "WB";
        board[1][4] = "WQ";
        board[1][5] = "WK";
        board[1][6] = "WB";
        board[1][7] = "Wk";
        board[1][8] = "WR";
        board[2][1] = "WP";
        board[2][2] = "WP";
        board[2][3] = "WP";
        board[2][4] = "WP";
        board[2][5] = "WP";
        board[2][6] = "WP";
        board[2][7] = "WP";
        board[2][8] = "WP";
        board[7][1] = "BP";
        board[7][2] = "BP";
        board[7][3] = "BP";
        board[7][4] = "BP";
        board[7][5] = "BP";
        board[7][6] = "BP";
        board[7][7] = "BP";
        board[7][8] = "BP";
        board[8][1] = "BR";
        board[8][2] = "Bk";
        board[8][3] = "BB";
        board[8][4] = "BQ";
        board[8][5] = "BK";
        board[8][6] = "BB";
        board[8][7] = "Bk";
        board[8][8] = "BR";
    }
    public void printBoard(){
        repaint();
    }
    public void initAndPrint(){
        for(int i = 0; i<9; i++){
            if(i!= 8){
                board[i][0] = ""+ (i+1) + "|   ";}
            else{
                board[i][0] = "|    ";
            }
            System.out.print(board[i][0]);
            for(int j = 1; j<9; j++){
                board[i][j] = "__";
                if (i == 8){
                    if (j == 1){
                        board[i][j] = "A ";
                    }
                    else if (j == 2){
                        board[i][j] = "B ";
                    }
                    else if (j == 3){
                        board[i][j] = "C ";
                    }
                    else if (j == 4){
                        board[i][j] = "D ";
                    }
                    else if (j == 5){
                        board[i][j] = "E ";
                    }
                    else if (j == 6){
                        board[i][j] = "F ";
                    }
                    else if (j == 7){
                        board[i][j] = "G ";
                    }
                    else if (j == 8){
                        board[i][j] = "H ";
                    }
                }
                System.out.print("|" + board[i][j] );
            }
            System.out.println();
        }
    }
    public void mouseClicked (MouseEvent me) {
        x = me.getX();
        y = me.getY();
        repaint();
        for (int row = 1; row < 9; row++){
            for (int col = 1; col < 9; col++){
                if(Math.abs((x-rowNums2[col]))  < 30 && Math.abs(y-rowNums2[row]) < 30){
                    mouseCol = col;
                    mouseRow = row;
                }
            }
        }
         if(moveW == true){
            if(piece.equals("P")){
                Pawn pawn = new Pawn("W", board, mousePickedCol, mousePickedRow);
                if(pawn.attemptMove(mouseRow, mouseCol) == true){
                    pawn.move(mouseRow, mouseCol);
                    moveW = false;
                    findB = true;
                    board = pawn.updateBoard();
                    repaint();
                } else {
                    findW = true;
                    moveW = false;
                }
            }
            else if(piece.equals("K")){
                King king = new King("W", board, mousePickedCol, mousePickedRow);
                if(king.attemptMove(mouseRow, mouseCol) == true){
                    king.move(mouseRow, mouseCol);
                    moveW = false;
                    findB = true;
                    board = king.updateBoard();
                    repaint();
                } else {
                    findW = true;
                    moveW = false;
                }
            }
            else if(piece.equals("B")){
                Bishop bishop = new Bishop("W", board, mousePickedCol, mousePickedRow);
                if(bishop.attemptMove(mouseRow, mouseCol) == true){
                    bishop.move(mouseRow, mouseCol);
                    moveW = false;
                    findB = true;
                    board = bishop.updateBoard();
                    repaint();
                } else {
                    findW = true;
                    moveW = false;
                }
            }
            else if(piece.equals("k")){
                Knight knight = new Knight("W", board, mousePickedCol, mousePickedRow);
                if(knight.attemptMove(mouseRow, mouseCol) == true){
                    knight.move(mouseRow, mouseCol);
                    moveW = false;
                    findB = true;
                    board = knight.updateBoard();
                    repaint();
                } else {
                    findW = true;
                    moveW = false;
                }
            }
            else if(piece.equals("Q")){
                Queen queen = new Queen("W", board, mousePickedCol, mousePickedRow);
                if(queen.attemptMove(mouseRow, mouseCol) == true){
                    queen.move(mouseRow, mouseCol);
                    moveW = false;
                    findB = true;
                    board = queen.updateBoard();
                    repaint();
                } else {
                    findW = true;
                    moveW = false;
                }
            }
            else if(piece.equals("R")){
                Rook rook = new Rook("W", board, mousePickedCol, mousePickedRow);
                if(rook.attemptMove(mouseRow, mouseCol) == true){
                    rook.move(mouseRow, mouseCol);
                    moveW = false;
                    findB = true;
                    board = rook.updateBoard();
                    repaint();
                } else {
                    findW = true;
                    moveW = false;
                }
            }
        }
        else if(moveB == true){
            if(piece.equals("P")){
                Pawn pawn = new Pawn("B", board, mousePickedCol, mousePickedRow);
                if(pawn.attemptMove(mouseRow, mouseCol) == true){
                    pawn.move(mouseRow, mouseCol);
                    moveB = false;
                    findW = true;
                    board = pawn.updateBoard();
                    repaint();
                } else {
                    findB = true;
                    moveB = false;
                }
            }
            else if(piece.equals("K")){
                King king = new King("B", board, mousePickedCol, mousePickedRow);
                if(king.attemptMove(mouseRow, mouseCol) == true){
                    king.move(mouseRow, mouseCol);
                    moveB = false;
                    findW = true;
                    board = king.updateBoard();
                    repaint();
                } else {
                    findB = true;
                    moveB = false;
                }
            }
            else if(piece.equals("B")){
                Bishop bishop = new Bishop("B", board, mousePickedCol, mousePickedRow);
                if(bishop.attemptMove(mouseRow, mouseCol) == true){
                    bishop.move(mouseRow, mouseCol);
                    moveB = false;
                    findW = true;
                    board = bishop.updateBoard();
                    repaint();
                } else {
                    findB = true;
                    moveB = false;
                }
            }
            else if(piece.equals("k")){
                Knight knight = new Knight("B", board, mousePickedCol, mousePickedRow);
                if(knight.attemptMove(mouseRow, mouseCol) == true){
                    knight.move(mouseRow, mouseCol);
                    moveB = false;
                    findW = true;
                    board = knight.updateBoard();
                    repaint();
                } else {
                    findB = true;
                    moveB = false;
                }
            }
            else if(piece.equals("Q")){
                Queen queen = new Queen("B", board, mousePickedCol, mousePickedRow);
                if(queen.attemptMove(mouseRow, mouseCol) == true){
                    queen.move(mouseRow, mouseCol);
                    moveB = false;
                    findW = true;
                    board = queen.updateBoard();
                    repaint();
                } else {
                    findB = true;
                    moveB = false;
                }
            }
            else if(piece.equals("R")){
                Rook rook = new Rook("B", board, mousePickedCol, mousePickedRow);
                if(rook.attemptMove(mouseRow, mouseCol) == true){
                    rook.move(mouseRow, mouseCol);
                    moveB = false;
                    findW = true;
                    board = rook.updateBoard();
                    repaint();
                } else {
                    findB = true;
                    moveB = false;
                }
            }
        }
        else if(findW == true){
            if(board[mouseRow][mouseCol].substring(0,1).equals("W")){
                if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("P")){
                    piece = "P";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("K")){
                    piece = "K";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("k")){
                    piece = "k";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("B")){
                    piece = "B";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("Q")){
                    piece = "Q";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("R")){
                    piece = "R";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                moveW = true;
                findW = false;
                repaint();
            }
        }
        else if(findB == true){
            if(board[mouseRow][mouseCol].substring(0,1).equals("B")){
                if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("P")){
                    piece = "P";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("K")){
                    piece = "K";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("k")){
                    piece = "k";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("B")){
                    piece = "B";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("Q")){
                    piece = "Q";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                else if(Chess.board[mouseRow][mouseCol].substring(1,2).equals("R")){
                    piece = "R";
                    mousePickedRow = mouseRow;
                    mousePickedCol = mouseCol;
                }
                moveB = true;
                findB = false;
                repaint();
            }
        }
    }
    public void mouseEntered (MouseEvent me) {
        
    } 
    public void mousePressed (MouseEvent me) {
        
    }
    public void mouseReleased (MouseEvent me) {
        
    }  
    public void mouseExited (MouseEvent me) {
        
    }
}
