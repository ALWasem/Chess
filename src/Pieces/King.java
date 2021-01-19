package Pieces;

public class King extends Piece{

    public King(String s, String n) {
        super(s, n);
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
