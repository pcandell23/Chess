public class Pawn implements Piece
{
    // instance variables - replace the example below with your own
    private String player;
    public String[][] board;
    private int x = 0; 
    private int y= 0;
    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(String player, String[][] board, int xposition,int yposition)
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
        if(player == "B" && toX == x && y == 7 && (toY == y -2 || toY == y-1) && board[toY][x] == "__"  && !(board[toY][toX].substring(0,1).equals(player))){
            board[y][x] = "__";
            y = toY;
            board[y][x] = "BP";
            return true;
        }
        else if (player == "W" && y == 2 && (toY == y +2 || toY == y+1) && board[toY][x] == "__"&& toX == x &&!(board[toY][toX].substring(0,1).equals(player))){
            board[y][x] = "__";
            y = toY;
            board[y][x] = "WP";
            return true;
        }
        else if(player == "B" && toY == y-1 && board[toY][x] == "__"&& toX == x && !(board[toY][toX].substring(0,1).equals(player))){
            board[y][x] = "__";
            y = toY;
            board[y][x] = "BP";
            return true;
        }
        else if(player == "W" && toY == y+1 && board[toY][x] == "__"&& toX == x && !(board[toY][toX].substring(0,1).equals(player))){
            board[y][x] = "__";
            y = toY;
            board[y][x] = "WP";
            return true;
        } 
        else if(player == "W" && (toY == y+1 && (x+1 == toX || x-1 == toX) )&& board[toY][toX] != "__" && !(board[toY][toX].substring(0,1).equals(player))){
            board[y][x] = "__";
            y = toY;
            x = toX;
            board[y][x] = "WP";
            return true;
        } 
        else if(player == "B" && (toY == y-1 && (x+1 == toX || x-1 == toX) )&& board[toY][toX] != "__" && !(board[toY][toX].substring(0,1).equals(player))){
            board[y][x] = "__";
            y = toY;
            x = toX;
            board[y][x] = "BP";
            return true;
        } 
        else {
            
            return false;
        }
    }
    public boolean attemptMove(int toY, int toX)
    {
        if(toY >= 1 && toX >= 1){
                if(player == "B" && toX == x && y == 7 && (toY == y -2 || toY == y-1) && board[toY][x] == "__"  && !(board[toY][toX].substring(0,1).equals(player))){
                return true;
            }
            else if (player == "W" && y == 2 && (toY == y +2 || toY == y+1) && board[toY][x] == "__"&& toX == x &&!(board[toY][toX].substring(0,1).equals(player))){
                return true;
            }
            else if(player == "B" && toY == y-1 && board[toY][x] == "__"&& toX == x && !(board[toY][toX].substring(0,1).equals(player))){
                return true;
            }
            else if(player == "W" && toY == y+1 && board[toY][x] == "__"&& toX == x && !(board[toY][toX].substring(0,1).equals(player))){
                return true;
            } 
            else if(player == "W" && (toY == y+1 && (x+1 == toX || x-1 == toX) )&& board[toY][toX] != "__" && !(board[toY][toX].substring(0,1).equals(player))){
                return true;
            } 
            else if(player == "B" && (toY == y-1 && (x+1 == toX || x-1 == toX) )&& board[toY][toX] != "__" && !(board[toY][toX].substring(0,1).equals(player))){
                return true;
            } 
            else {
                return false;
            }
        } else {
            return false;
        }
    }
    public String[][] updateBoard(){
        return board;
    }
}
