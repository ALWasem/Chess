package Pieces;

public class Queen extends Piece{

    public Queen(String s, String n) {
        super(s, n);
    }

    public String toString(){
        if(side == "W")
            return "Q";
        if(side == "B")
            return "q";
        else
            return "color error";
    }
}
