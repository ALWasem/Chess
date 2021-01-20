public class Rook extends Piece {

    public Rook(String s, String n, int m) {
        super(s, n, m);
    }

    public String toString(){
        if(side == "W")
            return "R";
        if(side == "B")
            return "r";
        else
            return "color error";
    }

    public boolean isValidMove(String newSquare){
        return true;
    }

}
