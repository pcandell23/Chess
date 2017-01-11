public class Rook
{
    // instance variables - replace the example below with your own
    private String player;
    public String[][] board;
    private int x = 0; 
    private int y= 0;
    /**
     * Constructor for objects of class Rook
     */
    public Rook(String player, String[][] board, int xposition,int yposition)
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
        // put your code here
        
        if(toY == y){
            boolean moveOK = true;
            if(toX < x){
                for(int i = toX; i < x; i++){
                     if(board[y][i] != "__" || board[toY][toX].substring(0,1).equals(player)){
                         moveOK = false; 
                        }
                    }
                if (moveOK == true){
                    board[y][x] = "__";
                    board[toY][toX] = player + "R";
                    return true;
                }else {
                    System.out.println("Invalid move try again");
                    return false;
                }
                } else{
                    for(int i = x; i < toX; i++){
                        if(board[y][i] != "__" || board[toY][toX].substring(0,1).equals(player)){
                            moveOK = false; 
                        }
                    }
                    if (moveOK == true){
                        board[y][x] = "__";
                        board[toY][toX] = player + "R";
                        return true;
                    }else {
                        System.out.println("Invalid move try again");
                        return false;
                    }
            }
        } 
        else if(toX == x){
             boolean moveOK = true;
            if(toY < y){
                for(int i = toY; i < y; i++){
                     if(board[i][x] != "__" || board[toY][toX].substring(0,1).equals(player)){
                         moveOK = false; 
                        }
                    }
                if (moveOK == true){
                     board[y][x] = "__";
                     board[toY][toX] = player + "R";
                     return true;
                }else {
                    System.out.println("Invalid move try again");
                    return false;
                }
            } 
            else{       
                for(int i = y; i < toY; i++){
                    if(board[i][x] != "__" || board[toY][toX].substring(0,1).equals(player)){
                        moveOK = false; 
                    }
                }
                if (moveOK == true){
                    board[y][x] = "__";
                    board[toY][toX] = player + "R";
                    return true;
                } else {
                    System.out.println("Invalid move try again");
                    return false;
                }
           }
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
