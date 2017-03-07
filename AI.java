import java.util.Random;
/**
 * Write a description of class AI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AI 
{
    private String difficulty;
    public static String[][] places = new String[9][9];
    public static String[][] test = new String[9][9];
    private static int xPos = 0;
    private static int yPos = 0;
    /**
     * Constructor for objects of class Rook
     */
    public AI(){
 
    }
    public static void resetPlaces(){
        for (int row = 0; row < places.length; row++){
            for (int col = 0; col < places[0].length; col++){
                    places[row][col] = " ";
            }
        }
    }
    public static void checkPositions(Piece piece){
        for (int row = 1; row < places.length; row++){
            for (int col = 1; col < places[0].length; col++){
                if(piece.attemptMove(row,col) == true){
                    places[row][col] = "x";
                }
            }
        }
    }
    public static void checkPlayer(String player){
        if(player.equals("B")){
            player = "W";
        } else {
            player = "B";
        }
        resetPlaces();
        for (int row = 1; row < 9; row++){
            for (int col = 1; col < 9; col++){
                if(test[row][col].substring(0,1).equals(player)){
                    if(test[row][col].substring(1,2).equals("P")){
                        Pawn pawn = new Pawn(player, test, col, row);
                        checkPositions(pawn);
                    }
                    else if(test[row][col].substring(1,2).equals("R")){
                        Rook rook = new Rook(player, test, col, row);
                        checkPositions(rook);
                    }
                    else if(test[row][col].substring(1,2).equals("k")){
                        Knight knight = new Knight(player, test, col, row);
                        checkPositions(knight);
                    }
                    else if(test[row][col].substring(1,2).equals("B")){
                        Bishop bishop = new Bishop(player, test, col, row);
                        checkPositions(bishop);
                    }
                    else if(test[row][col].substring(1,2).equals("Q")){
                        Queen queen = new Queen(player, test, col, row);
                        checkPositions(queen);
                    }
                    else if(test[row][col].substring(1,2).equals("K")){
                        King king = new King(player, test, col, row);
                        checkPositions(king);
                    }
                }
            } 
        }
    }
    public static boolean checkCheckMate(String player){
        resetPlaces();
        resetTest();
        checkPlayer(player);
        xPos = 0; 
        yPos = 0;
         for(int row = 1; row < places.length; row++){
            for(int col = 1; col < places[0].length; col++){
                if(test[row][col].equals(player + "K")){
                    yPos = row;
                    xPos = col;
                }
            }
        }
        King king = new King(player, test, xPos, yPos);
         if(!places[yPos][xPos].equals("x")){
            return false;
        }
        for (int row = yPos-1; row < yPos+1; row++){
            for (int col = xPos -1; col < xPos+1; col++){
                if(king.attemptMove(row,col) == true){
                    return false;
                }
            }
        }
        for (int row = 1; row < places.length; row++){
            for (int col = 1; col < places[0].length; col++){
                if(test[row][col].substring(0,1).equals(player)){
                    if(test[row][col].substring(1,2).equals("Q")){
                        Queen queen = new Queen(player, test, col, row);
                        if(testMove(queen,player)== false){
                            return false;
                        }
                    }
                    if(test[row][col].substring(1,2).equals("B")){
                        Bishop bishop = new Bishop(player, test, col, row);
                        if(testMove(bishop,player)== false){
                            return false;
                        }
                    }
                    if(test[row][col].substring(1,2).equals("R")){
                        Rook rook = new Rook(player, test, col, row);
                        if(testMove(rook,player)== false){
                            return false;
                        }
                    }
                    if(test[row][col].substring(1,2).equals("k")){
                        Knight knight = new Knight(player, test, col, row);
                        if(testMove(knight,player)== false){
                            return false;
                        }
                    }
                    if(test[row][col].substring(1,2).equals("P")){
                        Pawn pawn = new Pawn(player, test, col, row);
                        if(testMove(pawn,player)== false){
                            return false;
                        }
                    }
                    if(test[row][col].substring(1,2).equals("K")){
                        if(testMove(king,player)== false){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static boolean testMove(Piece piece, String player){
        for (int row = 1; row < places.length; row++){
            for (int col = 1; col < places[0].length; col++){
                if(piece.attemptMove(row,col) == true){
                    piece.move(row,col);
                    checkPlayer(player);
                    if(!places[yPos][xPos].equals("x")){
                         return false;
                    }
                    resetTest();
                    }
            }
        }
        return true;
    }
    public static void resetTest(){
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                test[row][col] = Chess.board[row][col];
            }
        }
    }
}

