

public interface Piece
{
   
    boolean move(int toY,int toX);
    String[][] updateBoard();
    boolean attemptMove(int toY,int toX);
}
