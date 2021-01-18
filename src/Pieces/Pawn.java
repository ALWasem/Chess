package Pieces;

public class Pawn extends Piece{

    public Pawn(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side == "W")
            return "P";
        if(side == "B")
            return "p";
        else
            return "color error";
    }


}
