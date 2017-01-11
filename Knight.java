public class Knight
{
    // instance variables - replace the example below with your own
    private String player;
    public String[][] board;
    private int x = 0; 
    private int y= 0;
    /**
     * Constructor for objects of class Pawn
     */
    public Knight(String player, String[][] board, int xposition,int yposition)
    {
        // initialise instance variables
        this.player = player;
        this.board = board;
        this.y = yposition;
        this.x = xposition;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean move(int toY, int toX)
    {
        // put your code here
        if(Math.abs(toY - y ) == 2 && Math.abs(toX - x) == 1){
            board[y][x] = "__";
            y = toY;
            x = toX;
            board[y][x] = player + "k";
            return true;
        } else if(Math.abs(toY - y) == 1 && Math.abs(toX - x) == 2){
            board[y][x] = "__";
            y = toY;
            x = toX;
            board[y][x] = player + "k";
            return true;
        }
        else {
            System.out.println("Invalid move try again");
            return false;
        }
    }
    public String[][] updateBoard(){
        return board;
    }
}
