public class King extends Piece {

    public King(String s, String n, int m) {
        super(s, n, m);
    }

    public String toString(){
        if(side == "W")
            return "K";
        if(side == "B")
            return "k";
        else
            return "color error";
    }

    public boolean isValidMove(String newSquare){
        return true;
    }

}