public class Knight extends Piece {

    public Knight(String s, String n, int m) {
        super(s, n, m);
    }

    public String toString(){
        if(side == "W")
            return "N";
        if(side == "B")
            return "n";
        else
            return "color error";
    }

    public boolean isValidMove(String newSquare){
        return true;
    }

}