public class Bishop
{
    // instance variables - replace the example below with your own
    private String player;
    public String[][] board;
    private int x = 0; 
    private int y= 0;
    /**
     * Constructor for objects of class Rook
     */
    public Bishop(String player, String[][] board, int xposition,int yposition)
    {
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
        if(Math.abs(toY-y) == Math.abs(toX-x)){
            boolean moveOK = true;
            if(x < toX && y < toY){
                 for(int i = 1; i < Math.abs(x -toX); i++){
                     if(board[y+i][x+i] != "__"){
                         toY = y+i;
                         toX = x+i;
                         moveOK = false;
                        }
                    }
                }
            else if (x< toX && y > toY){
                 for(int i = 1; i < Math.abs(x -toX); i++){
                     if(board[y - i][x+i] != "__"){
                         toY = y-i;
                         toX = x+i;
                         moveOK = false; 
                        }
                    }
                } 
            else if (x > toX && y < toY){
                 for(int i = 1; i < Math.abs(x - toX); i++){
                     if(board[y + i][x-i] != "__"){
                         toY = y+i;
                         toX = x-i;
                         moveOK = false; 
                        }
                    }
                } 
            else if (x > toX && y > toY){
                 for(int i = 1; i < Math.abs(x - toX); i++){
                     if(board[y - i][x-i] != "__"){
                         toY = y-i;
                         toX = x-i;
                         moveOK = false; 
                        }
                    }
                }
            if (moveOK == true && !(board[toY][toX].substring(0,1).equals(player))){
                board[y][x] = "__";
                board[toY][toX] = player + "B";
                return true;
            }
            else {
                    System.out.println("Invalid move try again");
                    return false;
                }
        } else {
            System.out.println("Invalid move try again");
            return false;
        }
    }
     public String[][] updateBoard(){
        return board;
    }
}

