package Pieces;

public class Rook extends Piece{

    public Rook(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side == "W")
            return "R";
        if(side == "B")
            return "r";
        else
            return "color error";
    }

}
