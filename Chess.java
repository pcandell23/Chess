import java.util.Scanner;
/**
 * Write a description of class Chess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chess
{
    public static String[][] board = new String[9][9];
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
    public static void printBoard(){
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                
                System.out.print("|" + board[i][j] );
            }
            System.out.println();
        }
    }
    public static void initAndPrint(){
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
    public static int convertLetter(String letter){
        if(letter.toUpperCase().equals("A")){
            return 1;
        }
        if(letter.toUpperCase().equals("B")){
            return 2;
        }
        if(letter.toUpperCase().equals("C")){
            return 3;
        }
        if(letter.toUpperCase().equals("D")){
            return 4;
        }
        if(letter.toUpperCase().equals("E")){
            return 5;
        }
        if(letter.toUpperCase().equals("F")){
            return 6;
        }
        if(letter.toUpperCase().equals("G")){
            return 7;
        }
        if(letter.toUpperCase().equals("H")){
            return 8;
        }
        else{
            System.out.println("Invalid input");
            return 0;
        }
    }
    public static void movePiece(String player){
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = convertLetter(scan.next());
        if(board[row][col].substring(0, 1).equals(player)){
            System.out.println("Where would you like to move that piece to?");
            int newRow = scan.nextInt();
            int newCol = convertLetter(scan.next());
            if(board[row][col].substring(1,2).equals("P")){
                Pawn pawn = new Pawn(player, board, col, row);
                if(pawn.move(newRow, newCol))
                    pawn.move(newRow, newCol) ;
                else{
                    movePiece(player);
                }
                board = pawn.updateBoard();
            }
            if(board[row][col].substring(1,2).equals("R")){
                Rook rook = new Rook(player, board, col, row);
                if(rook.move(newRow, newCol)) 
                    rook.move(newRow, newCol);
                else{
                    movePiece(player);
                }
                board = rook.updateBoard();
            }
            if(board[row][col].substring(1,2).equals("k")){
                Knight knight = new Knight(player, board, col, row);
                if(knight.move(newRow, newCol))
                    knight.move(newRow, newCol);
                else{
                    movePiece(player);
                }
                board = knight.updateBoard();
            }
            if(board[row][col].substring(1,2).equals("B")){
                Bishop bishop = new Bishop(player, board, col, row);
                if(bishop.move(newRow, newCol))
                    bishop.move(newRow, newCol);
                else{
                    movePiece(player);
                }
                board = bishop.updateBoard();
            }
            if(board[row][col].substring(1,2).equals("Q")){
                Queen queen = new Queen(player, board, col, row);
                if(queen.move(newRow, newCol))
                    queen.move(newRow, newCol);
                else{
                    movePiece(player);
                }
                board = queen.updateBoard();
            }
            if(board[row][col].substring(1,2).equals("K")){
                King king = new King(player, board, col, row);
                if(king.move(newRow, newCol))
                    king.move(newRow, newCol);
                else{
                    movePiece(player);
                }
                board = king.updateBoard();
            }
           }
        else{
            System.out.println("There's no piece that you can move there.  Try entering the coordinates again.");
            movePiece(player);
        }
    }
    public static void runGame(){
        boolean keepGoing = true;
        int row;
        int col;
        int newRow;
        int newCol;
        initBoard();
        initializeBoard();
        boolean whiteKing = true;
        boolean blackKing = true;
        while(keepGoing){
            printBoard();
            System.out.println("White side, your move.  Enter the location of the piece you would like to move (row, column).");
            movePiece("W");
            printBoard();
            System.out.println("Black side, your move.  Enter the location of the piece you would like to move (row, column).");
            movePiece("B");
            whiteKing = false;
            blackKing = false;
            for(int i = 0; i<9; i++){
                for(int j = 0; j<9; j++){
                    if(board[i][j].equals("WK")){
                        whiteKing = true;
                    }
                    if(board[i][j].equals("BK")){
                        blackKing = true;
                    }
                }
            }
            if(!whiteKing){
                System.out.println("Black wins.");
                keepGoing = false;
            }
            if(!blackKing){
                System.out.println("White wins.");
                keepGoing = false;
            }
        }
    }
}
